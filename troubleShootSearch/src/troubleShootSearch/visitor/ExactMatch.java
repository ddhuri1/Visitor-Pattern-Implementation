package troubleShootSearch.visitor;

import troubleShootSearch.visitor.DSeaGate;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.Store;
import java.util.ArrayList;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @author Devina Dhuri
 */
 
public class ExactMatch implements VisitorI 
{
	Results res = Results.getInstance();
	Store st = Store.getInstance();
	ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
	
	public ExactMatch()
	{
		MyLogger.writeMessage("ExactMatch constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* Function to check if exact match
	* @param product DSeaGate Object
	* @return None 
	*/
	 @Override
	public void visit(DSeaGate product)
	{
		temp = product.getList();
		String s = st.getString();
		String patternString = "\\b(" + s + ")\\b.?";
		Pattern pattern = Pattern.compile(patternString);
		
		for(ArrayList<String> innerList : temp) 
		{
			for(int i = 0; i < innerList.size();i++) 
			{				
				 Matcher matcher = pattern.matcher(innerList.get(i));
				 if(matcher.find())
				 {
					MyLogger.writeMessage(innerList.get(i).toString(), MyLogger.DebugLevel.SEARCH);
					// if(!MyLogger.getDebugValue().toString().equals("RELEASE"))
					// {
					res.writeToFile(innerList.get(i).toString());
					// }
				 }
				
			}
		}
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n" ;
	}
}