/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.*;
import observer.Observer;

/**
 *
 * @author A .Harshini
 */


public class Classroom {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addObserver(Observer o) { observers.add(o); }

    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Student " + s.getId() + " enrolled in " + name);
    }

    public void scheduleAssignment(Assignment a) {
        assignments.add(a);
        System.out.println("Assignment \"" + a.getDetails() + "\" scheduled in " + name);
    }

    public void submitAssignment(String sid, String details) {
        int attempts = 0;
        boolean success = false;

        while (!success && attempts < 3) {
            attempts++;
            try {
                Optional<Assignment> found = assignments.stream()
                        .filter(a -> a.getDetails().equalsIgnoreCase(details))
                        .findFirst();

                if (found.isPresent()) {
                    found.get().markSubmitted();
                    System.out.println("Student " + sid + " submitted " + details + " in " + name);
                    notifyObservers("Student " + sid + " submitted " + details + " in " + name);
                    success = true;
                } else {
                    throw new RuntimeException("Assignment not found");
                }
            } catch (Exception e) {
                System.out.println("Error submitting (attempt " + attempts + "): " + e.getMessage());
                if (attempts == 3) System.out.println("Failed after 3 retries.");
            }
        }
    }

    private void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }

    public void listStudents() {
        if (students.isEmpty()) System.out.println("No students in " + name);
        else students.forEach(s -> System.out.println("- " + s.getId()));
    }

    public void listAssignments() {
        if (assignments.isEmpty()) System.out.println("No assignments in " + name);
        else assignments.forEach(a -> System.out.println("- " + a.getDetails() + (a.isSubmitted() ? " (done)" : " (pending)")));
    }
}
