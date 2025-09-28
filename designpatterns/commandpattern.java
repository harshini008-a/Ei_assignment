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

interface Command {
    void execute();
}

class RegisterCommand implements Command {
    List<String> list;
    String student;
    RegisterCommand(List<String> l, String s) { list = l; student = s; }
    public void execute() {
        list.add(student);
        System.out.println("Registered: " + student);
    }
}

class RemoveCommand implements Command {
    List<String> list;
    String student;
    RemoveCommand(List<String> l, String s) { list = l; student = s; }
    public void execute() {
        if (list.remove(student))
            System.out.println("Removed: " + student);
        else
            System.out.println("Student not found: " + student);
    }
}

class Controller {
    Command cmd;
    void setCommand(Command c) { cmd = c; }
    void executeCommand() { cmd.execute(); }
}

public class commandpattern {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Controller controller = new Controller();

        System.out.print("Enter 1 to register, 2 to remove: ");
        int choice = sc.nextInt(); sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        if (choice == 1)
            controller.setCommand(new RegisterCommand(students, name));
        else
            controller.setCommand(new RemoveCommand(students, name));
        controller.executeCommand();
    }
}
