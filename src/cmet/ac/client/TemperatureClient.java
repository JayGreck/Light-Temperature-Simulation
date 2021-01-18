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
	
	
	//Temp Client Constructor
	public TemperatureClient() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				FanMain.getFanUIInstance();
			}
		});
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
