/*
Answer for #7.
제 생각에는 공백이 허용되면 안된다고 생각합니다.
명렁어 자체가 single character로 이루어졌기 때문에,
오타가 난다 하더라도 정확히 오타가 무엇을 의미하는지 정확히 특정하는 건 어려운 일이라고 생각합니다. 그렇기 때문에 그런 예외적인 상황을 발생시키지 않고 좀 더 안정적인 프로그램을 만들기 위해서 공백이 허용하면 안된다고 생각합니다.

-- 개인 노트 --
1. 수업 자료와 교과서를 사용해서 직접 작성한 노트 (공유 x, 개인 노트입니다.)
https://redtruth.notion.site/Heap-HeapSort-Priority-Queue-1adb10853ebd80299b10f62102bdb1bf?pvs=4 


-- 참고 블로그 --
2. 자바로 먼저 작성한 코드 (자바로 작성 후 cpp로 옮겼습니다. 백엔드 및 spring 공부 중에 있어서 자바로 객체지향형 코드를 짜고 싶었습니다.)
https://github.com/hyukjin0419/java-mid1/tree/master/src/baekjoon/algorithm/ds/priorityQueue

3. cpp 헤더 파일과 cpp 파일 소스 코드 분리 방법
https://twinparadox.tistory.com/205

4. c++ 에서 getter과 setter 문법 참고
https://dnf-lover.tistory.com/entry/C%EB%AC%B8%EB%B2%95-%EC%83%9D%EC%84%B1%EC%9E%90%EC%99%80-%EC%86%8C%EB%A9%B8%EC%9E%90-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%A0%91%EA%B7%BC%EC%9E%90%EC%99%80-getter-setter-%EC%86%8C%EB%A9%B8%EC%9E%90-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%A0%91%EA%B7%BC%EC%9E%90%EC%99%80-getter-setter-%ED%95%A8%EC%88%98

5. c++생성자 문법 참고
https://boycoding.tistory.com/244

6. c++ 입력 예외 처리 참고
https://blog.naver.com/tipsware/221115532845

7. c++ 에서 string -> int 형변환
https://www.freecodecamp.org/korean/news/c-eseo-stringeul-integerro-byeonhwanhaneun-bangbeob-yesi-2/

*/

#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Student{
private:
  string name;
  int score;
  string course;

public:
  Student(string name, int score, string course){
    this->name = name;
    this->score = score;
    this->course = course;
  }

  string getName(){
    return this->name; 
  }

  void setName(string name){
    this->name = name;
  }

  int getScore(){
    return this->score; 
  }

  void setScore(int score){
    this->score = score;
  }

  string getCourse(){
    return this->course; 
  }

  void setCourse(string course){
    this->course = course;
  }

  string toString() const {
    return "[" + name + ", " + to_string(score) + ", " + course + "]";
  }
};


class Heap{
private:
  vector<Student*> students;
  int size;
  int capacity;

  void heapIncreaseKey(int i, int score){
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

  void maxHeapify(int i){
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

public:
  Heap(int cap){
    this->capacity = cap;
    students.resize(cap + 1,nullptr);
    this->size = 0;
  }

  void maxHeapInsertion(){
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

  Student* maxHeapExtractMax(){
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

  Student* maxHeapMaximum(){
    if(size < 1){
      cout << "Queue is Empty." << endl;
      return nullptr;
    }
    return students[1];
  }

  void printHeap(){
    cout << "Current queue elements:" << endl;
    for (int i=1;i<=size;i++){
      cout << i << ". [" << students[i]->getName() << ", " << students[i]->getScore() << ", " << students[i]->getCourse() << "]" << endl;
    }
  }

  void executeN(){
    int index;

    if(size < 1){
      cout << "Queue is Empty." << endl;
      return;
    }
  
    while(true){
      cout << "Enter the index of the element: ";
      cin >> index;

      if(cin.fail()){
        cin.clear();
        cin.ignore(1000,'\n');
        cout << "Wrong input. Please check the type of input" << endl;
        continue;
      }

      if(index <= size && index > 0){
        break;
      }
      
      cout << "Enter the available index, please." << endl;;
    }

    if(students[index]->getScore() >= 100){
      cout << "Cannot update it, since it has the biggets score" << endl;
      return;
    }
    int newScore;
    cin.ignore();
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

  int getValidScore(){
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
  };
};

int main(){
  Heap heap(30);
  string menu;

  while(true){
    cout << endl;
    cout << "**************** Menu ****************" << endl;
    cout << "I: Insert a new element into the queue." << endl;
    cout << "D: Delete the element with the largest key from the queue." << endl;
    cout << "R: Retrieve the element with the largest key." << endl;
    cout << "N: Increase the key of an element in the queue." << endl;
    cout << "P: Print all elements in the queue." << endl;
    cout << "Q: Quit." << endl << endl;
    
    cout << "Choose menu: ";
    // cin >> menu;
    // cin.ignore();
    getline(cin,menu);

    for(int i=0;i<menu.size();i++){
      if('A' <= menu[i] && menu[i] <= 'Z'){
        menu[i] += 32;
      }
    }
    
    if (menu == "i") {
      heap.maxHeapInsertion();
    } else if (menu == "d") {
      Student* temp = heap.maxHeapExtractMax();
      if(temp == nullptr){
        continue;
      }
      cout << "Deleted element: [" << temp->getName() << ", " << temp->getScore() << ", " << temp->getCourse() << "]" << endl;
    } else if (menu == "r") {
      Student* temp = heap.maxHeapMaximum();
      if(temp == nullptr){
        continue;
      }
      cout << "Element with the largest key: [" << temp->getName() << ", " << temp->getScore() << ", " << temp->getCourse() << "]" << endl;
    } else if (menu == "n") {
      heap.executeN();
    } else if (menu == "p") {
      heap.printHeap();
    } else if (menu == "q") {
      cout << "Program terminated." << endl;
      break;
    } else {
      cout << "Invalid Input. Please choose a valid command." << endl;
    }
  }
};
