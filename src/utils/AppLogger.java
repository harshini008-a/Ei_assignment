/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.logging.*;

public class AppLogger {
    private static final Logger logger = Logger.getLogger("VirtualClassLogger");

    static {
        try {
            LogManager.getLogManager().reset();
            ConsoleHandler ch = new ConsoleHandler();
            ch.setLevel(Level.ALL);
            logger.addHandler(ch);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            System.out.println("Logger init failed: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}
