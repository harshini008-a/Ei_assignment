/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;

/**
 *
 * @author A .Harshini
 */


public class ClassroomNotFoundException extends AppException {
    public ClassroomNotFoundException(String name) {
        super("Classroom not found: " + name);
    }
}
