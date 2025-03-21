#include <iostream>
#include "Heap.h"

using namespace std;

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
    cin >> menu;
    cin.ignore();

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
}