/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;
import entities.Classroom;
import factory.EntityFactory;
import utils.AppLogger;
import exceptions.*;

/**
 *
 * @author A .Harshini
 */




import java.util.*;
import java.util.logging.Logger;

public class ClassroomManager {
    private static ClassroomManager instance;
    private Map<String, Classroom> classrooms = new HashMap<>();
    private final Logger log = AppLogger.getLogger();

    private ClassroomManager() {}

    public static ClassroomManager getInstance() {
        if (instance == null) instance = new ClassroomManager();
        return instance;
    }

    public void addClassroom(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty())
            throw new InvalidInputException("Classroom name cannot be empty");

        if (classrooms.containsKey(name)) {
            log.warning("Duplicate classroom attempt: " + name);
            System.out.println("Classroom already exists: " + name);
        } else {
            classrooms.put(name, EntityFactory.createClassroom(name));
            log.info("Classroom created: " + name);
            System.out.println("Classroom " + name + " created.");
        }
    }

    public Classroom getClassroom(String name) throws ClassroomNotFoundException {
        Classroom c = classrooms.get(name);
        if (c == null) throw new ClassroomNotFoundException(name);
        return c;
    }

    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            log.info("No classrooms available");
            System.out.println("No classrooms available.");
        } else {
            classrooms.keySet().forEach(c -> System.out.println("- " + c));
        }
    }

    public void removeClassroom(String name) {
        if (classrooms.remove(name) != null) {
            log.info("Classroom removed: " + name);
            System.out.println("Classroom " + name + " removed.");
        } else {
            log.warning("Failed removal: " + name);
            System.out.println("Classroom not found: " + name);
        }
    }
}

