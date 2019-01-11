package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private int robots;
	private String color;
	private int sides;
	
	public CodingExamA() {
		frame.add(panel);
	}
	
	public void runProgram() {
		robots = Integer.valueOf(JOptionPane.showInputDialog("How many robots?"));
		color = JOptionPane.showInputDialog("What color? (red, green, blue)");
		sides = Integer.valueOf(JOptionPane.showInputDialog("How many sides? must be >0"));
	}
	
	public int getRobots() {
		return robots;
	}
	public Color getColor() {
		if (color.equals("red")) {
			return Color.red;
		}
		else if (color.equals("green")) {
			return Color.green;
		}
		else if (color.equals("blue")) {
			return Color.blue;
		}
		return Color.black;
	}
	public int getSides() {
		return sides;
	}
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		CodingExamA test = new CodingExamA();
		
		test.runProgram();
		for (int i=0; i<test.getRobots(); i++) {
			Robot rob = new Robot(400*i,400);
			rob.setSpeed(10);
			rob.setPenWidth(5);
			//rob.moveTo(400*i,  400);
			//rob.setAngle(0);
			Thread r1 = new Thread( () ->{
					rob.penDown();
					rob.setPenColor(test.getColor());
					int angle = 360/test.getSides();
					for (int j=0; j<=360; j+= angle) {
						rob.move(100);
						rob.turn(angle);
					}});
					
			r1.start();
		}
		
		
	}
}
