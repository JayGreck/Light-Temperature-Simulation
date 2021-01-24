package cmet.ac.client;
import cmet.ac.frames.FanMain;

/**
 * 
 */

/**
 * @author Jay
 *
 */
public class TemperatureClient extends Client {
	
	private double fanSpeed;
	
	private double currentRoomTemp;
	
	private int clientTypeID;
	
	//CSVFileReader CSV_instance = new CSVFileReader();
	
	
	//Temp Client Constructor
	public TemperatureClient(int clientID) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				FanMain.getFanUIInstance();
//			}
//		});
		
		//System.out.println("[Temp Client] " + clientID);
		//FanMain fanSetID = new FanMain(clientID); // Sending ID to FanMain
		FanMain fan = new FanMain(clientID);
		//fan.setClientID(clientID);
		//fanSetID.setClientID(clientID);
		
		//FanMain fan = new FanMain(); // Calling FanMain instance
		
		//fan.setClientID(clientID);
		//CSV_instance.ReadFile(clientID, 1);
	}
	
//	TemperatureClient(int clientID) {
//		setClientID(clientID);
//		getClientID();
//	}
	
	// CSV file reader instance
	
	
	//Call Fan instance
	
	
	public void changeFanSpeed() {
		
	}
	

}
