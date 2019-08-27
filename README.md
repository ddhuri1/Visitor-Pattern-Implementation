
## Name: Devina Sachin Dhuri

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in troubleShootSearch/src folder.
To clean, compile and run, be sure to be in the troubleShootSearch folder.

-----------------------------------------------------------------------
## Instruction to clean:

### Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

### Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

### Command:  ant -buildfile src/build.xml run -Darg0=userInput.txt -Darg1=synonym.txt -Darg2=output.txt -Darg3=<0-4>
Argument Darg3 is the debug value 
	/**
	 * DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
     * DEBUG_VALUE=3 [Print to stdout everytime the node is added to a tree]
	 * DEBUG_VALUE=2 [Print to stdout everytime Results is written to File]
     * DEBUG_VALUE=1 [Print to stdout everytime a node is deleted ]
     * DEBUG_VALUE=0 [No output is printed from the application to stdout. It writes to the output file though" ]
     */

-----------------------------------------------------------------------
## Instruction to generate tarball:

### Command: ant -buildfile src/build.xml tarball

Description: Generates a .tar.gz inside the base folder. Calls clean to clean the project
and then calls compress on it to generate tarball.

-----------------------------------------------------------------------
## Description: 
In this, Visitor Pattern has been implemented. 
It needs 4 product files to be included in lines with the userInput.txt else will throw an exception.
There are three visitors, ExactMatch, Stemming Match and Semantic Match that run 
across the user inputs to see which visitor is applicable. 
p1, p2, p3, p4 are the 4 product files hardcoded in the code.  

###Logger Debug Values:
	DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
    DEBUG_VALUE=3 [Print to stdout everytime a term is replaced]
	DEBUG_VALUE=2 [Print to stdout everytime Results is written to File]
    DEBUG_VALUE=1 [ Only the search results should be printed ]
    DEBUG_VALUE=0 [No output is printed from the application to stdout. It only shows error messages" ]
	 
Data Structures:
For storing the synonyms and the sentences for the 4 products, ArrayList is used.
##### Time Complexity:
add(): O(1), thus adding n elements is O(n) 
get(): O(1)
remove(): O(n)   
contains(): O(n)  

-----------------------------------------------------------------------


### References and Citations:
1. Singleton:
https://www.geeksforgeeks.org/singleton-class-java/
