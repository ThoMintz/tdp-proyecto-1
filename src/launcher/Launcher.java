package launcher;

import javax.swing.JFrame;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student stu = new Student(134041, "Mintzer", "Thomas", "thomasmintzer1@gmail.com", "https://github.com/ThoMintz", "/images/foto.jpg");
            	JFrame ventana = new SimplePresentationScreen(stu);
            }
        });
    }
}