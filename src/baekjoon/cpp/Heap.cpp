#include "Heap.h"

Heap::Heap(int cap){
  capacity = cap;
  students.resize(cap + 1,nullptr);
  size = 0;
}

Heap::~Heap(){
  for(int i=1;i<=size;i++){
    delete students[i];
  }
}

void Heap::maxHeapInsertion(){
  if(size >= capacity){
    cout << "Heap is full" << endl;
    return;
  }
  size ++;

  cout << "Enter the name of the student: ";
  string name;
  getline(cin,name);

  cout << "Enter the score of the element: ";
  int score = getValidScore();

  cout << "Enter the class name: ";
  string className;
  getline(cin,className);

  students[size] = new Student(name,0,className);
  heapIncreaseKey(size, score);
  cout << "New element [" << name << ", " << score << ", " << className << "] has been inserted." << endl;
}

Student* Heap::maxHeapExtractMax(){
  if (size < 1){
    cout << "Cannot delete from an empty queue" << endl;
    return nullptr;
  }

  Student* maxStudent = students[1];
  students[1] = students[size];
  students[size] = nullptr;
  size--;
  maxHeapify(1);
  return maxStudent;
}

Student* Heap::maxHeapMaximum(){
  if(size < 1){
    cout << "Queue is Empty." << endl;
    return nullptr;
  }
  return students[1];
}

void Heap::maxHeapify(int i){
  int l = 2 * i;
  int r = 2 * i + 1;

  int largest = i;

  if(l <= size && students[l]->getScore() > students[i]->getScore()){
    largest = l;
  }
  if (r <= size && students[r]->getScore() > students[largest]->getScore()) {
    largest = r;
  }
  if(largest != i){
    swap(students[i], students[largest]);
    maxHeapify(largest);
  }
}

void Heap::printHeap(){
  cout << "Current queue elements:" << endl;
  for (int i=1;i<=size;i++){
    cout << i << ". [" << students[i]->getName() << ", " << students[i]->getScore() << ", " << students[i]->getCourse() << "]" << endl;
  }
}

void Heap::executeN(){
  cout << "Enter the index of the element: ";
  int index;
  cin >> index;

  if(students[index]->getScore() >= 100){
    cout << "Cannot update it, since it has the biggets score" << endl;
    return;
  }
  int newScore;
  cout << "Enter the new score: ";
  newScore = getValidScore();

  while (newScore <= students[index]->getScore()) {
    cout << "New score should be larger than current score. please enter again." << endl;
    cout << "Enter the new score: ";
    newScore = getValidScore();
  }

  cout << "Key updated. [" << students[index]->getName() << ", " << newScore << ", " << students[index]->getCourse() << "] has been repositioned in the queue." << endl;
  heapIncreaseKey(index, newScore);
  
}


void Heap::heapIncreaseKey(int i, int score){
  if(score < students[i]->getScore()){
    cout << "New score should be larger than current score. Please enter again." << endl;
    return;
  }

  students[i]->setScore(score);
    while (i > 1 && students[i / 2]->getScore() < students[i]->getScore()) {
      swap(students[i/2],students[i]);
      i = i/2;
    }
}

int Heap::getValidScore(){
  int score;
  string input;

  while(true){
    getline(cin,input);
    bool isValid = true;

    for(int i=0;i<input.size();i++){
      char c = input[i];
      if (!isdigit(c)){
        isValid = false;
        break;
      }
    }

    if(!isValid) {
      cout << "Invalid score. Please enter a valid integer between 0~100: ";
      continue;
    }

    score = stoi(input);
    
    if(score <= 100 && score >= 0){
      return score;
    } else{
      cout << "Invalid score. Please enter a valid integer between 0~100: ";
    }
  }
}
