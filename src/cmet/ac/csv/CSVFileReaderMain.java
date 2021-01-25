/**
 * 
 */
package cmet.ac.csv;

import java.io.File;




/**
 * @author Jay
 *
 */
public class CSVFileReaderMain {
	private File file = new File("sensor_data.csv");
	private String absolute_file = file.getAbsolutePath(); // Getting absolute file path of sensor_data.csv
	
	
	private String splitBy= ",";
	
	public String getFile() {
		return absolute_file;
	}
	
	public void setFile(String file) {
		this.absolute_file = file;
	}
	
	
	public String getSplitBy() {
		return splitBy;
	}
	
	public void setSplitBy(String splitBy) {
		this.splitBy = splitBy;
	}


	}