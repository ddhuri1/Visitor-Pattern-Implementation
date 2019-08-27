package troubleShootSearch.util;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Devina Dhuri
 */
 //Source: https://www.geeksforgeeks.org/singleton-class-java/

public class Store
{
	private static Store single_instance = null;
	private String stringLine = "";
	FileProcessor fp;
	String sysc = "";
	String line = "";
	public ArrayList<String> a = new ArrayList<String>();
	public ArrayList<String> b = new ArrayList<String>();

	private Store()	
	{
		MyLogger.writeMessage("Store constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}

	/**
	* This is used to access the singleton object outside the class
	* @param None
	* @return single_instance Object reference of singleton
	*/
	
	public static Store getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new Store(); 
  
        return single_instance; 
    } 
	
	/**
	* This is used to split synonym file
	* @param sys Synonsm file name
	* @return None
	*/
	public void split(String sys)
	{
		this.sysc = sys;
		try
		{
			fp = new FileProcessor(sys);
			line = fp.readLine();
			while(line != null)
			{
				String temp[] = line.split(":");
				a.add(temp[0]);
				b.add(temp[1]);
			
				line = fp.readLine();
			}
			
		}
		catch (IOException e) 
		{
			System.err.println("Exit from Store : Exiting Program");
			System.err.println("Error Reading the Product Files");
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	* This is used to store user input
	* @param line User input read from file
	* @return None
	*/
	public void store(String line)
	{
		this.stringLine = line;
	}
	
	/**
	* This is used to get stored user input
	* @param None
	* @return String
	*/
	public String getString()
	{
		return stringLine;
	}
	
	/**
	* This is used to set stored user input
	* @param line String
	* @return None
	*/
	public void setString(String line)
	{
		stringLine = line;
	}

	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Synonym Filename: " + sysc + "-------Synonym File:\n" + a.toString() + " : " + b.toString() + "\n" ;
	}
	
	
}