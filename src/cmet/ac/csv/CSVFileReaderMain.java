/**
 * 
 */
package cmet.ac.csv;

import java.io.File;
import java.util.Scanner;



/**
 * @author Jay
 *
 */
public class CSVFileReaderMain {
	//static private String file = "C:\\Users\\Jay\\Downloads\\sensor_data.csv";
	private File file = new File("sensor_data.csv");
	private String absolute_file = file.getAbsolutePath();
	
	
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


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Scanner fileInput = new Scanner(System.in);
		//System.out.print("Enter File URL: ");
		
		//file = fileInput.nextLine();
		
		//CSVFileReader reader = new CSVFileReader();
		//reader.ReadFile(file);
		
	}
	}