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
 
public class NaiveStemmingMatch implements VisitorI 
{
	Results res = Results.getInstance();
	Store st = Store.getInstance();
	ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();

	public NaiveStemmingMatch()
	{
		MyLogger.writeMessage("NaiveStemmingMatch constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* Function to check if Stemming match
	* @param product DSeaGate Object
	* @return None 
	*/
	public void visit(DSeaGate product)
	{
		temp = product.getList();
		String s = st.getString();
		String tempo[] = s.split(" ");
		if(tempo.length > 1)
		{
			for(ArrayList<String> innerList : temp) 
			{
				for(int i = 0; i < innerList.size();i++) 
				{				
					if(innerList.get(i).contains(tempo[0]))
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
	}
	
	/**
	* @param None
	* @return String 
	*/
	public String toString()
	{
		return "--------------------------" + "\n" + getClass().getName()+"@"+Integer.toHexString(hashCode()) + "\n"  ;
	}
}