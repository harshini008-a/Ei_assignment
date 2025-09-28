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

class OldStudent {
    String studentFullName;
    OldStudent(String name) { studentFullName = name; }
    String getOldName() { return studentFullName; }
}

interface NewStudent {
    String getName();
}

class OldToNewStudentAdapter implements NewStudent {
    OldStudent old;
    OldToNewStudentAdapter(OldStudent s) { old = s; }
    public String getName() { return old.getOldName(); }
}

public class adapterpattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter old student full name: ");
        String name = sc.nextLine();
        OldStudent old = new OldStudent(name);
        NewStudent adapted = new OldToNewStudentAdapter(old);
        System.out.println("Adapted name: " + adapted.getName());
    }
}

