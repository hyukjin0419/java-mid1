#include "Student.h"

Student::Student(string name, int score, string course){
  this->name = name;
  this->score = score;
  this->course = course;
};

string Student::getName(){
  return this->name; 
}

void Student::setName(string name){
  this->name = name;
}

int Student::getScore(){
  return this->score; 
}

void Student::setScore(int score){
  this->score = score;
}

string Student::getCourse(){
  return this->course; 
}

void Student::setCourse(string course){
  this->course = course;
}

string Student::toString() const {
  return "[" + name + ", " + to_string(score) + ", " + course + "]";
}

