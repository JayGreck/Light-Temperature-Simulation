/**
 * 
 */
package cmet.ac.components;

/**
 * @author Jay
 *
 */
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpeedPanel extends JPanel{
	
	
	private double currentTemp;
	
	private Fan			fan_instance;
			
	public SpeedPanel(Fan fanObj) {
		this.fan_instance = fanObj;
	}
	
	public SpeedPanel() {
		
	}
	
	public void setFanInstance(Fan fanInstance) {
		this.fan_instance = fanInstance;
	}
	
	
	public void setTimerValue(Fan fan_instance) {
		
		// Low Setting
		if (getTemp() <= 20) {
			int timervalue = 17;
			fan_instance.setFanSpeed(timervalue);
		}
		
		// Medium Setting
		else if (getTemp() > 20  && getTemp() < 25) {
			int timervalue = 10;
			fan_instance.setFanSpeed(timervalue);
		}
		
		// High Setting
		else if (getTemp() >= 25) {
			int timervalue = 1;
			fan_instance.setFanSpeed(timervalue);
		}
	}
	
	// Sets current temperature from sensor_data.csv
	public void setTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}
	
	// Gets current temperature from sensor_data.csv
	public double getTemp() {
		return currentTemp;
	}
}
