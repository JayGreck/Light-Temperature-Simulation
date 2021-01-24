/**
 * 
 */
package cmet.ac.frames;

/**
 * @author Jay
 *
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;

import cmet.ac.components.Fan;
import cmet.ac.components.FanPanel;
import cmet.ac.components.SpeedPanel;
import cmet.ac.csv.CSVFileReader;


public class FanMain extends JFrame {
	
	// static instance to support singleton
	private static FanMain	fanui_instance;
	
	private FanPanel 		fan_panel;
	
	private SpeedPanel		speed_panel;
	
	private Fan				fan_instance;
	
	private int clientID;
	
	private CSVFileReader CSV_instance = new CSVFileReader();
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {			
				FanMain.getFanUIInstance();				
			}
		} );
	}
	
	/**
	 * Public getinstance method to create an instance of the AppFrame class. 
	 *  
	 * @return an instance of AppFrame class. 
	 */
	public static FanMain getFanUIInstance() {
		if(fanui_instance == null) {
			//fanui_instance = new FanMain();
		}
		
		return fanui_instance;
	}
	
//	public FanMain(int clientID) {
//		setClientID(clientID);
//		FanMain fan = new FanMain();
//		
//	}
	
	/**
	 * Constructor
	 */
	public FanMain(int clientID) {
		super();
		
		fan_instance = new Fan(150, 150);
		
		
		
		fan_panel = new FanPanel(300, 300, fan_instance);
		speed_panel = new SpeedPanel(fan_instance);
				
		//add(speed_panel, BorderLayout.NORTH);
		add(fan_panel, BorderLayout.CENTER);
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		if(clientID == 1) {
			CSV_instance.setFanInstance(fan_instance);
			CSV_instance.setClientID(clientID);
			//System.out.println("[Fan Main] Client ID = " + clientID);
			CSV_instance.start();
		}
		
	}
	
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	public int getClientID() {
		return clientID;
	}
}