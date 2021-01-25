/**
 * 
 */
package cmet.ac.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

import cmet.ac.client.LightClient;
import cmet.ac.components.Fan;
import cmet.ac.components.SpeedPanel; 



/**
 * @author Jay
 *
 */
public class CSVFileReader extends Thread {
	
	
	
	private String line= "";
	
	private int n_delay;
	
	private Fan fan_instance;
	private int clientID; 
	
	private JPanel panel;
	
	private double currentTemp;
	
	private double currentLight;
	
	private CSVFileReaderMain csvObject = new CSVFileReaderMain();
	
	int i = 0;
	
	private SpeedPanel sendTemptoFan = new SpeedPanel();
	
	
	
	public void ReadFile(int clientType, int n_delay) {
		
		try {
			
			
			LightClient lightClient = new LightClient();
			BufferedReader br = new BufferedReader(new FileReader(csvObject.getFile()));
			
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				

				SensorData dataObject = new SensorData(); // Creating a Sensor data instance for getters and setters
				
				
				String[] sensorData = line.split(csvObject.getSplitBy());  // use comma as separator  
				
				
				
				
				if (clientType % 2 != 0 && i != 0) {
					System.out.println("Temp:" + sensorData[dataObject.getTempData()]); // Prints temp data
					
					currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]); // Stores temp data as a double
					sendTemptoFan.setTemp(currentTemp); // Setting temperature 
					sendTemptoFan.setTimerValue(getFanInstance()); // setting timer value delay 
				}
				
				else if(getClientID() % 2 == 0 && i != 0) {
					
					System.out.println("Light Data: " + sensorData[dataObject.getLightData()]); // Prints light data
					currentLight = Double.parseDouble(sensorData[dataObject.getLightData()]); // Stores light data as a double
					lightClient.setLight(currentLight); // Setting light 
					lightClient.changeBrightness(getJPanel()); // setting brightness
					
				}
				i++;
				// Setting delay in milliseconds for thread to wait
				Thread.sleep(n_delay);
			}  
			ReadFile(getClientID(), 500); // Recursively calls itself to simulate continuous supply of data
			
			}   
		
			catch (IOException | InterruptedException e1)   
			{  
				e1.printStackTrace();  
			}  
			catch (NumberFormatException e2) {
				
			}
			}   
	
	@Override
	public void run() {
		ReadFile(getClientID(), 500);
	}
	
	
	// Getters and Setters
	public void setFanInstance(Fan fanInstance) {
		this.fan_instance = fanInstance;
	}
	
	public Fan getFanInstance() {
		return fan_instance;
	}
	
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public int getClientID() {
		return clientID;
	}
	
	public void setJPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getJPanel() {
		return panel;
	}
}