package baekjoon.algorithm.ds.priorityQueue;

public class Student {
    private String name; //c++로 옮겨야 하기 때문에
    private int score;
    private String course;

    public Student(String name, int score, String course) {
        this.name = name;
        this.score = score;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return ("[" + name + ". " + score + ". " + course + "]");
    }
}
