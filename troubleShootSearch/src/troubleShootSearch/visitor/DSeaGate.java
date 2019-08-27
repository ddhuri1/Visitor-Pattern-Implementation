package troubleShootSearch.visitor;

import troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import java.io.IOException;

/**
 * @author Devina Dhuri
 */
 
public class DSeaGate
{
	
	ArrayList<String> p1 = new ArrayList<String>();
	ArrayList<String> p2 = new ArrayList<String>();
	ArrayList<String> p3 = new ArrayList<String>();
	ArrayList<String> p4 = new ArrayList<String>();
	ArrayList<ArrayList<String>> aList = new ArrayList<ArrayList<String>>(); 
	FileProcessor fp;
	String line;
	
	public DSeaGate()
	{
		MyLogger.writeMessage("DSeagate constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* store 4 product sentences in arrayList
	* @param product1 product1 file
	* @param product2 product2 file
	* @param product3 product3 file
	* @param product4 product4 file
	* @return None 
	*/
	public void store(String product1, String product2, String product3, String product4)
	{
		try
		{
			fp = new FileProcessor(product1);
			line = fp.readLine();
			while(line != null)
			{
				p1.add(line);
				line = fp.readLine();
			}
			aList.add(p1);
			
			fp = new FileProcessor(product2);
			line = fp.readLine();
			while(line != null)
			{
				p2.add(line);
				line = fp.readLine();
			}
			aList.add(p2);
			
			fp = new FileProcessor(product3);
			line = fp.readLine();
			while(line != null)
			{
				p3.add(line);
				line = fp.readLine();
			}
			aList.add(p3);
			
			fp = new FileProcessor(product4);
			line = fp.readLine();
			while(line != null)
			{
				p4.add(line);
				line = fp.readLine();
			}
			aList.add(p4);
			
		}
		catch (IOException e) 
		{
			System.err.println("Exit from FdSeaGate : Exiting Program");
			System.err.println("Error Reading the Product Files");
			e.printStackTrace();
			System.exit(1);
		}	
	}
	
	/**
	* used to call the visit method for each visitor according to object
	* @param VisitorInterface object
	* @return None 
	*/
	public void accept(VisitorI v)
	{
		v.visit(this);
	}
	
	/**
	* Getter method to get list of technical products 
	* @param None
	* @return ArrayList<ArrayList<String>> 
	*/
	public ArrayList<ArrayList<String>> getList()
	{
		return aList;
	}
	
	/**
	* Getter method to set list of technical products 
	* @param ArrayList<ArrayList<String>> line
	* @return None 
	*/
	public void setList(ArrayList<ArrayList<String>> line)
	{
		aList = line;
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" + "Product1 Content:" + p1.toString() + "--------------------" + "\n" + "Product2 Content:" + p2.toString() + "--------------------" + "\n" + "Product3 Content:" + p3.toString() + "--------------------" + "\n" + "Product4 Content:" + p4.toString() + "--------------------" + "\n" ;
	}
}