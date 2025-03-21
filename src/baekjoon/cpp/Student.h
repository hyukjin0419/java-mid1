#ifndef STUDENT_H
#define STUDENT_H

#include <iostream>
#include <string>

using namespace std;

class Student{
private:
  string name;
  int score;
  string course;

public:
  Student(string name, int score, string course);
  
  string getName();
  void setName(string name);

  int getScore();
  void setScore(int score);

  string getCourse();
  void setCourse(string course);

  string toString() const;
};

#endif