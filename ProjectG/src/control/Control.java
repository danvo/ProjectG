package control;

import java.util.List;

public interface Control
{
	/**
	 * Gets the accountname of the user
	 * @return a string
	 */
	public String getAccountname(String name);
	
	/**
	 * gets the names, of which the user wants to get information about and saving them in one list
	 * 
	 * @return a list of strings
	 */
	public List<String> getNameFromUI(String name);
}