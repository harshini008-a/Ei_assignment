/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;


/**
 *
 * @author A .Harshini
 */

public class InvalidInputException extends AppException {
    public InvalidInputException(String msg) {
        super("Invalid Input: " + msg);
    }
}
