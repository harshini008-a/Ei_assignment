/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package designpatterns;

/**
 *
 * @author A .Harshini
 */
import java.util.*;

interface Observer {
    void update(String studentName);
}

class Teacher implements Observer {
    String teacherName;
    Teacher(String name) { teacherName = name; }
    public void update(String studentName) {
        System.out.println(teacherName + " notified: New student registered - " + studentName);
    }
}

class StudentRegister {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer obs) { observers.add(obs); }
    public void registerStudent(String name) {
        System.out.println("Student " + name + " registered.");
        for (Observer obs : observers) obs.update(name);
    }
}

public class observerpattern{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRegister reg = new StudentRegister();
        reg.addObserver(new Teacher("Ms. Susan"));
        reg.addObserver(new Teacher("Mr. John"));
        System.out.print("Enter student name to register: ");
        String name = sc.nextLine();
        reg.registerStudent(name);
    }
}

