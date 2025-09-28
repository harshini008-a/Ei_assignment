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

interface StudentDetails {
    void showDetails();
}

class RealStudent implements StudentDetails {
    String name;
    RealStudent(String name) { this.name = name; }
    public void showDetails() {
        System.out.println("Student Name: " + name);
    }
}
class StudentProxy implements StudentDetails {
    RealStudent realStudent;
    String password;
    StudentProxy(String name, String pwd) {
        realStudent = new RealStudent(name);
        password = pwd;
    }
    public void showDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password to see details: ");
        String input = sc.nextLine();
        if (input.equals(password))
            realStudent.showDetails();
        else
            System.out.println("Access denied!");
    }
}

public class proxypattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Set student name: ");
        String name = sc.nextLine();
        System.out.print("Set password: ");
        String pwd = sc.nextLine();
        StudentDetails proxy = new StudentProxy(name, pwd);
        proxy.showDetails();
    }
}

