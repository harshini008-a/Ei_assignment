/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainApp;

/**
 *
 * @author A .Harshini
 */
import entities.*;
import factory.EntityFactory;
import manager.ClassroomManager;
import observer.Teacher;
import exceptions.*;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClassroomManager manager = ClassroomManager.getInstance();
        System.out.print("Enter teacher name: ");
        String teacherName = sc.nextLine();
        Teacher teacher = new Teacher("Mentor");

        System.out.println("=== Virtual Classroom Manager ===");
        System.out.println("Commands: add_class, add_student, add_work, submit_work, list_class, list_stud, list_work, del_class, exit");

        boolean running = true;
        while (running) {
            System.out.print("\n> ");
            String input = sc.nextLine();
            String[] p = input.trim().split("\\s+");


            try {
                switch (p[0]) {
                    case "add_class":
                        manager.addClassroom(p[1]);
                        manager.getClassroom(p[1]).addObserver(teacher);
                        break;

                    case "add_student":
                        Student s = EntityFactory.createStudent(p[1]);
                        manager.getClassroom(p[2]).addStudent(s);
                        break;

                    case "add_work":
                        manager.getClassroom(p[1])
                               .scheduleAssignment(EntityFactory.createAssignment(p[2]));
                        break;

                   case "submit_work":
    if (p.length < 4) {
        System.out.println("Usage: submit_work <studentId> <className> <assignment>");
    } else {
        String sid = p[1];         // student ID
        String className = p[2];   // class name
        // if assignment name has spaces, join the rest
        String assignment = String.join(" ", Arrays.copyOfRange(p, 3, p.length));
        manager.getClassroom(className).submitAssignment(sid, assignment);
    }
    break;





                    case "list_class":
                        manager.listClassrooms();
                        break;

                    case "list_stud":
                        manager.getClassroom(p[1]).listStudents();
                        break;

                    case "list_work":
                        manager.getClassroom(p[1]).listAssignments();
                        break;

                    case "del_class":
                        manager.removeClassroom(p[1]);
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid command.");
                }
            } catch (AppException e) {
                System.out.println("Handled: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}

