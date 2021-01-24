/**
 * 
 */
package cmet.ac.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
	
	CSVFileReaderMain csvObject = new CSVFileReaderMain();
	
	int i = 0;
	
	SpeedPanel sendTemptoFan = new SpeedPanel();
	
	
	
	
//	public void readTempData() {
//		String tempData = sensorData[dataObject.getTempData()];
//		//currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
//		//System.out.println("Temp:" + sensorData[dataObject.getTempData()]);
//		currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
//		//System.out.println("[CSV File Reader] Temp: " + currentTemp);
//		sendTemptoFan.setTemp(currentTemp);
//		sendTemptoFan.setButtonActions(getFanInstance());
//	}
//	
//	public void readLightData(JPanel panel) {
//		
//		//System.out.println("Light:" + sensorData[dataObject.getLightData()]);
//		String lightData = sensorData[dataObject.getLightData()];
//		currentLight = Double.parseDouble(sensorData[dataObject.getLightData()]);
//		lightClient.setLight(currentLight);
//		lightClient.changeBrightness(panel);
//	}
	
	public void ReadFile(int clientType, int n_delay) {
		
		try {
			
			
			LightClient lightClient = new LightClient();
			//System.out.println(csvObject.getFile());
			BufferedReader br = new BufferedReader(new FileReader(csvObject.getFile()));
			
			//parsing a CSV file into BufferedReader class constructor  
			//System.out.println("In READ FILE");
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				

				SensorData dataObject = new SensorData();
				
				
				String[] sensorData = line.split(csvObject.getSplitBy());  // use comma as separator  
				
				
				
				
				if (clientType == 1 && i != 0) {
					String tempData = sensorData[dataObject.getTempData()];
					//currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
					System.out.println("Temp:" + sensorData[dataObject.getTempData()]);
					currentTemp = Double.parseDouble(sensorData[dataObject.getTempData()]);
					//System.out.println("[CSV File Reader] Temp: " + currentTemp);
					sendTemptoFan.setTemp(currentTemp);
					sendTemptoFan.setButtonActions(getFanInstance());
				}
				else if(getClientID() == 2 && i != 0) {
					
					//System.out.println("In READ FILE IN LIGHT DATA");
					String lightData = sensorData[dataObject.getLightData()];
					//System.out.println("Light Data: " + sensorData[dataObject.getLightData()]);
					currentLight = Double.parseDouble(sensorData[dataObject.getLightData()]);
					lightClient.setLight(currentLight);
					lightClient.changeBrightness(getJPanel()); 
					
				}
				
				
				i++;
				
			
				//System.out.println("Light:" + sensorData[dataObject.getLightData()] + ", Temp:" + sensorData[dataObject.getTempData()]);  
				//TimeUnit.SECONDS.sleep(n_delay);
				//System.out.println("Delay = " + n_delay);
				Thread.sleep(n_delay);
			}  
			
			}   
		
			catch (IOException | InterruptedException e1)   
			{  
				e1.printStackTrace();  
			}  
			}   
	
	@Override
	public void run() {
		ReadFile(getClientID(), 500);
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
	
	public void setJPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getJPanel() {
		return panel;
	}
	
	public void setNDelay(int n_delay) {
		this.n_delay = n_delay;
	}
	
	public int getNDelay() {
		return n_delay;
	}
}