package troubleShootSearch.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;

/**
* @author Devina Dhuri
*/

public class Results implements FileDisplayInterface, StdoutDisplayInterface 
{
	private String outFile;
	private PrintWriter writer;
	private BufferedWriter bw;
    private String strResult;
	public ArrayList<Integer> myList = new ArrayList<Integer>();
	private static Results single_instance = null;
	
	private Results() 
	{
		MyLogger.writeMessage("Results constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* This is used to access the singleton object outside the class
	* @param None
	* @return single_instance Object reference of singleton
	*/
	//Source: https://www.geeksforgeeks.org/singleton-class-java/
	public static Results getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Results(); 
  
        return single_instance; 
    } 
	
	/**
     * This function sets file name
	 * @param outFile File where result is to be written
	 * @return None
     */
	public void setFile(String outFile)
	{
		this.outFile = outFile;
		try 
		{
			bw = new BufferedWriter(new FileWriter(outFile));
		}
		catch(IOException e) {
			System.err.println("Exception: opening output.txt");
			System.err.println("Exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
     * This function write the result to a file
     * @param s String to be written
	 * @return None
     */
	 public void writeToFile(String s) 
	 {
		try 
		{
			bw.write(s);
			bw.write("\n");
			MyLogger.writeMessage("Results written to file", MyLogger.DebugLevel.RESULTS);
		}
		catch(IOException e) {
			System.err.println("Exception: writing to output.txt");
			System.err.println("Exiting");
			e.printStackTrace();
			System.exit(1);
		}
		
	 }
	
	/**
     * This function closes the file
     * @param None
	 * @return None
     */
	public void closeF() 
	{
       try 
		{
			bw.close();
		}
		catch(IOException e) {
			System.err.println("Exception: closing output.txt");
			System.err.println("Exiting");
			e.printStackTrace();
			System.exit(1);
		}
    }
	
	/**
     * Getter method for private data members
     * @param None
	 * @return String
     */
	public String getResult() 
	{
		return strResult;
	}

	/**
     * Setter method for private data members
     * @param strResult
	 * @return None
     */
	public void setResult(String strResult) 
	{
		this.strResult = strResult;
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Output FileName:" + outFile + "--------------------" + "\n" ;
	}
}
