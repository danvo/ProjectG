package control;

import java.util.List;

public interface Control
{
	/**
	 * Gets the accountname of the user
	 * @return a string
	 */
	public String getAccountname();
	
	/**
	 * gets the list of the name, of which the user wants to get information about
	 * 
	 * @return a list of strings
	 */
	public List<String> getNamelist();
}