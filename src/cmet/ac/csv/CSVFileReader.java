/**
 * 
 */
package cmet.ac.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cmet.ac.components.Fan;
import cmet.ac.components.SpeedPanel; 



/**
 * @author Jay
 *
 */
public class CSVFileReader {
	
	
	private String line= "";
	
	Fan fan_instance;
	private int clientID; 
	
	private double currentTemp;
	
	CSVFileReaderMain csvObject = new CSVFileReaderMain();
	
	
	
	public CSVFileReader() {
		
	}
	
	public void ReadFile(int clientType, int n_delay) {
		
		int i = 0;
		
		SpeedPanel sendTemptoFan = new SpeedPanel();
		
		SensorData dataObject = new SensorData();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvObject.getFile()));
			//parsing a CSV file into BufferedReader class constructor  
			 
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] sensorData = line.split(csvObject.getSplitBy());  // use comma as separator  
				String data = sensorData[dataObject.getTempData()];
			if (clientType == 1 && i != 0) {
				currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
				//System.out.println("Temp:" + sensorData[dataObject.getTempData()]);
				currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
				sendTemptoFan.setTemp(currentTemp);
				sendTemptoFan.setButtonActions(getFanInstance());
			}
			else if(clientType == 2) {
				System.out.println("Light:" + sensorData[dataObject.getLightData()]);
			}
			
			
			i++;
			
			//System.out.println("Light:" + sensorData[dataObject.getLightData()] + ", Temp:" + sensorData[dataObject.getTempData()]);  
			TimeUnit.SECONDS.sleep(n_delay);
			}  
			
			}   
		
			catch (IOException | InterruptedException e1)   
			{  
				e1.printStackTrace();  
			}  
			}   
	
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
}