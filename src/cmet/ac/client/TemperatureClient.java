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
	
	// Temp Client Constructor
	public TemperatureClient(int clientID) {

		FanMain fan = new FanMain(clientID);
	
	}
}
