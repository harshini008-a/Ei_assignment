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

class StudentRegistry {
    private static StudentRegistry instance;
    List<String> students = new ArrayList<>();
    private StudentRegistry() {}
    public static StudentRegistry getInstance() {
        if (instance == null)
            instance = new StudentRegistry();
        return instance;
    }
    public void addStudent(String name) {
        students.add(name);
        System.out.println("Added: " + name);
    }
    public void printStudents() {
        System.out.println("Student list: " + students);
    }
}

public class singletonpattern{
    public static void main(String[] args) {
        StudentRegistry reg1 = StudentRegistry.getInstance();
        StudentRegistry reg2 = StudentRegistry.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        reg1.addStudent(name);
        System.out.println("All students (from reg2):");
        reg2.printStudents();
    }
}

