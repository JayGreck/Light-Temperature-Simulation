/**
 * 
 */
package cmet.ac.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit; 

/**
 * @author Jay
 *
 */
public class CSVFileReader {
	
	
	private String line= "";
	CSVFileReaderMain csvObject = new CSVFileReaderMain();
	
	
	
	public CSVFileReader() {
		
	}
	
	public void ReadFile(String file) {
		SensorData dataObject = new SensorData();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(csvObject.getFile()));
			//parsing a CSV file into BufferedReader class constructor  
			 
			while ((line = br.readLine()) != null)   //returns a Boolean value  
			{  
				String[] sensorData = line.split(csvObject.getSplitBy());  // use comma as separator  
				//String data = sensorData[dataObject.getTempData()];
			
			System.out.println("Light:" + sensorData[dataObject.getLightData()] + ", Temp:" + sensorData[dataObject.getTempData()]);  
			TimeUnit.SECONDS.sleep(1);
			}  
			
			}   
		
			catch (IOException | InterruptedException e1)   
			{  
				e1.printStackTrace();  
			}  
			}   

}