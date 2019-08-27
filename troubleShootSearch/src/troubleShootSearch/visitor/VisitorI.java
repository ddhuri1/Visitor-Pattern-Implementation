package troubleShootSearch.visitor;

import troubleShootSearch.visitor.DSeaGate;

/**
 * @author Devina Dhuri
 */
 
public interface VisitorI    
{
	/**
	* Interface method
	* @param product DSeaGate Product
	* @return None
	*/
    public void visit(DSeaGate product);
}
