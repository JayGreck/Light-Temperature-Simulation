package cmet.ac.client;
import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cmet.ac.csv.CSVFileReader;





/**
 * 
 */

/**
 * @author Jay
 *
 */
public class LightClient extends JComponent {
	
	private double currentLightLevel;
	
	public void createLightGUI(int clientID) {
		
		final CSVFileReader CSV_instance = new CSVFileReader(); // Creating CSV file instance to call the start() method on
		
		// Setting up Light GUI
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setSize(250,250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		CSV_instance.setJPanel(panel); // Sending JPanel to CSVFileReader, so CSVFileReader can send it to the changeBrightness() method
		System.out.println("Starting Light Client thread");
		CSV_instance.setClientID(clientID); // Sendning clientID to CSVFileReader
		CSV_instance.start(); // Creating a new thread for CSVFileReader
		
	}
	
	// Changes background colour of the Light GUI 
	public void changeBrightness(JPanel panel) {
		System.out.println("Brightness = " + getLight());
		if (getLight() <= 20) {
			panel.setBackground(Color.decode("#FBFE00"));
		}
		
		else if(getLight() <= 30 && getLight() > 20) {
			panel.setBackground(Color.decode("#FCFE2E"));
		}
		
		else if(getLight() > 30 && getLight() >= 40) {
			 //System.out.println(">= 40");
			panel.setBackground(Color.decode("#FBFD54"));
		}
		else if(getLight() > 40 && getLight() <= 50) {
			//System.out.println("< 40");
			panel.setBackground(Color.decode("#FBFC74"));
		}
		
		else if(getLight() > 50 && getLight() <= 60) {
			panel.setBackground(Color.decode("#FEFFA4"));
		}
		
		else if(getLight() > 60 && getLight() <= 70) {
			panel.setBackground(Color.decode("#FEFFBC"));
		}
		
		else if(getLight() > 70 && getLight() <= 80) {
			panel.setBackground(Color.decode("#FEFFCA"));
		}
		
		else if(getLight() > 80 && getLight() <= 90) {
			panel.setBackground(Color.decode("#FFFED8"));
		}
		
		else if(getLight() > 90) {
			panel.setBackground(Color.decode("#FFFFEE"));
		}
		repaint();
	}
	
	
	public void setLight(double lightLevel) {
		this.currentLightLevel = lightLevel;
	}
	
	public double getLight() {
		return currentLightLevel;
	}
}
