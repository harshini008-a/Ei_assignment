/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author A .Harshini
 */


public class Teacher implements Observer {
    private String name;

    public Teacher(String name) { this.name = name; }

    @Override
    public void update(String message) {
        System.out.println("Teacher " + name + " notified: " + message);
    }
}

