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
 
public class SemanticMatch implements VisitorI 
{
	Results res = Results.getInstance();
	Store st = Store.getInstance();
	ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();

	public SemanticMatch()
	{
		MyLogger.writeMessage("Semantic constructor called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	* Function to check if semantic match
	* @param product DSeaGate Object
	* @return None 
	*/
	public void visit(DSeaGate product)
	{
		temp = product.getList();
		String s = st.getString();
		String tempo[] = s.split(" ");
		String word = tempo[tempo.length - 1];
		String syn = "";
		
		for(int i =0; i< st.a.size(); i++)
		{
			if(st.a.get(i).equals(word))
			{
				syn = st.b.get(i);
				s = s.replace(word, syn);
				
				String patternString = "\\b(" + s + ")\\b.?";
				Pattern pattern = Pattern.compile(patternString);
				
				for(ArrayList<String> innerList : temp) 
				{
					for(int j = 0; j < innerList.size(); j++) 
					{	
						Matcher matcher = pattern.matcher(innerList.get(j));
						if(matcher.find())
						{
							MyLogger.writeMessage(innerList.get(j).toString(), MyLogger.DebugLevel.SEARCH);
							MyLogger.writeMessage("TERM " + word + " Replaced by " + syn, MyLogger.DebugLevel.TERM);
							// if(!MyLogger.getDebugValue().toString().equals("RELEASE"))
							// {
							res.writeToFile(innerList.get(j).toString());
							// }
							
						}
					}
				}
			}
			else if(st.b.get(i).equals(word))
			{
				syn = st.a.get(i);
				s = s.replace(word, syn);
				
				String patternString = "\\b(" + s + ")\\b.?";
				Pattern pattern = Pattern.compile(patternString);
				
				for(ArrayList<String> innerList : temp) 
				{
					for(int j = 0; j < innerList.size(); j++) 
					{	
						Matcher matcher = pattern.matcher(innerList.get(j));
						if(matcher.find())
						{
							MyLogger.writeMessage(innerList.get(j).toString(), MyLogger.DebugLevel.SEARCH);
							MyLogger.writeMessage("TERM " + word + " Replaced by " + syn, MyLogger.DebugLevel.TERM);
							// if(!MyLogger.getDebugValue().toString().equals("RELEASE"))
							// {
								res.writeToFile(innerList.get(j).toString());
							// }
							
						}
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