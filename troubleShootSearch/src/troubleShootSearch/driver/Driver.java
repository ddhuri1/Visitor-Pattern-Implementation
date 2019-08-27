package troubleShootSearch.driver;

import troubleShootSearch.util.Results;
import troubleShootSearch.util.Store;
import troubleShootSearch.visitor.DSeaGate;
import troubleShootSearch.visitor.VisitorI;
import troubleShootSearch.visitor.ExactMatch;
import troubleShootSearch.visitor.NaiveStemmingMatch;
import troubleShootSearch.visitor.SemanticMatch;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.MyLogger.DebugLevel;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;
import java.util.ArrayList;

/**
* @author Devina Dhuri
*/

public class Driver 
{
	public static void main(String[] args) 
	{
		String inFile = "";
		String p1File = "p1.txt";
		String p3File = "p2.txt";
		String p4File = "p3.txt";
		String p2File = "p4.txt";
		String OutFile = "";
		String synFile = "";
		String debug = "";
		boolean exists = false;
		String line;
		File file;
		int debugValue = -1;
		// Results res ;
		try 
		{
			//validation check for arguments.
			if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}"))
			{
				throw new IllegalArgumentException("Error Illegal Number of Arguments");
			}	
			else if(args.length == 4)
			{
				if(args[0] != null && !args[0].equals("${arg0}")) 
				{
					inFile = args[0];
					file = new File(inFile);
					exists = file.exists();
					if(exists == false)
					{
						throw new FileNotFoundException("Error Input File Not Found");
					}
					if(file.length() == 0)
					{
						throw new Exception("Error Empty Input File");
					}
				}
				else 
				{
					throw new IllegalArgumentException("Invalid input file");
				}
				if(args[1] != null && !args[1].equals("${arg1}")) 
				{
					synFile = args[1];
					file = new File(synFile);
					exists = file.exists();
					if(exists == false)
					{
						throw new FileNotFoundException("Error Synonym File Not Found");
					}
					if(file.length() == 0)
					{
						throw new Exception("Error Empty Synonym File");
					}
				}
				else 
				{
					throw new IllegalArgumentException("Invalid Synonym file");
				}
				if(args[2] != null && !args[2].equals("${arg2}")) 
				{
					OutFile = args[2];
				}
				else 
				{
					throw new IllegalArgumentException("Invalid Output file");
				}
				if(args[3] != null && !args[3].equals("${arg3}")) 
				{
					try 
					{
            			debugValue = Integer.parseInt(args[3]);
						if(!(debugValue >= 0 && debugValue <= 4)) 
						{
							throw new NumberFormatException("Debug value must be integers between 0 and 4 inclusive");
						}
						MyLogger.setDebugValue(debugValue);
            		}
            		catch(NumberFormatException e) 
					{
            			System.err.println("Exit from Driver : Exiting Program");
						System.err.println(e.getMessage());
						e.printStackTrace();
						System.exit(1);
            		}
				}
				else 
				{
					throw new IllegalArgumentException("Please enter debug value");
				}
				
				file = new File(p1File);
				exists = file.exists();
				if(exists == false)
				{
					throw new FileNotFoundException("Error Product1 File Not Found");
				}
				if(file.length() == 0)
				{
					throw new Exception("Error Empty Product1 File");
				}
			
				file = new File(p2File);
				exists = file.exists();
				if(exists == false)
				{
					throw new FileNotFoundException("Error product2 File Not Found");
				}
				if(file.length() == 0)
				{
					throw new Exception("Error Empty product2 File");
				}
			
				file = new File(p3File);
				exists = file.exists();
				if(exists == false)
				{
					throw new FileNotFoundException("Error product3 File Not Found");
				}
				if(file.length() == 0)
				{
					throw new Exception("Error Empty product3 File");
				}
			
				file = new File(p4File);
				exists = file.exists();
				if(exists == false)
				{
					throw new FileNotFoundException("Error product4 File Not Found");
				}
				if(file.length() == 0)
				{
					throw new Exception("Error Empty product4 File");
				}
			
				DSeaGate product = new DSeaGate();
				product.store(p1File,p2File,p3File,p4File);
				
				Results res = Results.getInstance();
				res.setFile(OutFile);
				
				FileProcessor fp = new FileProcessor(inFile);
				line = fp.readLine();
				Store st = Store.getInstance();
				st.split(synFile);
				// System.out.println(st.getSys().toString());
				VisitorI exact = new ExactMatch();
				VisitorI stemming = new NaiveStemmingMatch();
				VisitorI semantic = new SemanticMatch();
				
				while(line != null)
				{
					st.store(line);
					// System.out.println(st.getString());
					product.accept(exact);
					product.accept(stemming);
					product.accept(semantic);
					line = fp.readLine();
				}
				// System.out.println(st.toString());
				// System.out.println(res.toString());
				// System.out.println(fp.toString());
				// System.out.println(exact.toString());
				// System.out.println(stemming.toString());
				// System.out.println(semantic.toString());
				// System.out.println(product.toString());
				
				res.closeF();
			}
		}
		catch(NumberFormatException e) 
		{
			System.err.println("Exit from Driver : Exiting Program");
			e.printStackTrace();
			System.exit(1);
		}
		
		catch(IllegalArgumentException e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			e.printStackTrace();
			System.exit(1);
		}
		catch(FileNotFoundException e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e) 
		{ 
			System.err.println("Exit from Driver : Exiting Program");
			e.printStackTrace();
			System.exit(1);
		}
	}
}