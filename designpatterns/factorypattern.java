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

abstract class Student {
    String name;
    Student(String name) { this.name = name; }
    abstract String info();
}
class RegularStudent extends Student {
    RegularStudent(String name) { super(name); }
    String info() { return "Regular Student: " + name; }
}
class SportsStudent extends Student {
    SportsStudent(String name) { super(name); }
    String info() { return "Sports Student: " + name; }
}
class StudentFactory {
    static Student getStudent(String type, String name) {
        if (type.equalsIgnoreCase("regular"))
            return new RegularStudent(name);
        else
            return new SportsStudent(name);
    }
}
public class factorypattern{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type (regular/sports): ");
        String type = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        Student s = StudentFactory.getStudent(type, name);
        System.out.println(s.info());
    }
}

