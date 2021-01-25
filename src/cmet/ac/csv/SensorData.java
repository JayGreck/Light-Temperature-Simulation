/**
 * 
 */
package cmet.ac.csv;

/**
 * @author Jay
 *
 */
public class SensorData {
	private int lightData = 7; // indicating light column in table
	private int tempData = 9; // indicating temp column in table

	
	
	
	public int getLightData() {
		return lightData;
	}
	
	public void setLightData(int lightData) {
		this.lightData = lightData;
	}
	
	public int getTempData() {
		return tempData;
	}
	
	public void setTempData(int tempData) {
		this.tempData = tempData;
	}
	
}
