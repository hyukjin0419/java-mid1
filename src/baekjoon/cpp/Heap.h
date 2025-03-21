#ifndef HEAP_H
#define HEAP_H

#include <iostream>
#include <vector>
#include <string>
#include <numeric>
#include "Student.h"

using namespace std;

class Heap {
public:
  Heap(int cap);
  ~Heap();

  void maxHeapInsertion();
  Student* maxHeapExtractMax();
  Student* maxHeapMaximum();
  void printHeap();
  void executeN();
  static int getValidScore();


private:
  vector<Student*> students;
  int size;
  int capacity;

  void heapIncreaseKey(int i, int score);
  void maxHeapify(int i);

};

#endif
