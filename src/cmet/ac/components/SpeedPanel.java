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
	
	JLabel 				lbl_speed_value;
	JTextField			txt_speed_value;
	JButton				btn_setSpeed;
	
	private double currentTemp;
	
	private Fan			fan_instance;
			
	public SpeedPanel(Fan fanObj) {
//		this.lbl_speed_value 	= new JLabel("Fan speed (Delay in ms) :");
//		this.txt_speed_value 	= new JTextField("10", 5);
//		this.btn_setSpeed 		= new JButton("Set Speed");
//		
//		this.setLayout(new FlowLayout());
//		this.add(lbl_speed_value);
//		this.add(txt_speed_value);
//		this.add(btn_setSpeed);
//		
		this.fan_instance = fanObj;
//		
//		setButtonActions();
	}
	
	public SpeedPanel() {
		
	}
	
	public void setFanInstance(Fan fanInstance) {
		this.fan_instance = fanInstance;
	}
	
	
	public String getFanSpeedValue() {
		return txt_speed_value.getText();
	}
	
	public void setButtonActions(Fan fan_instance) {
		
		//System.out.println("Inside Speed panel");
		//System.out.println("Temp Value: " + getTemp());
		
		// Low Setting
		if (getTemp() <= 20) {
			//System.out.println("below 24.1");
			int timervalue = 17;
			//System.out.println("Timervalue = " + timervalue);
			fan_instance.setFanSpeed(timervalue);
		}
		
		// Medium Setting
		else if (getTemp() > 20  && getTemp() < 25) {
			//System.out.println("above 24.1");
			int timervalue = 10;
			fan_instance.setFanSpeed(timervalue);
		}
		
		// High Setting
		else if (getTemp() >= 25) {
			//System.out.println("above 24.1");
			int timervalue = 1;
			fan_instance.setFanSpeed(timervalue);
		}
		
		
	}
	
	public void setTemp(double currentTemp) {
		this.currentTemp = currentTemp;
	}
	
	public double getTemp() {
		return currentTemp;
	}
}
