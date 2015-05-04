
package control;

import java.util.List;

public class DataInputControl implements Control
{
	List<String> namelist;
	
	@Override
	public String getAccountname(String name)
	{
		return name; // auch hier muss noch geändert werden, nachdem die GUI fertig ist.
	}
	
	@Override
	public List<String> getNameFromUI(String name)
	{
		namelist.add(name); //bsiher nur ein Name, muss noch erweitert werden, wenn klar ist, wie man Namen von der UI bekommt.
		return namelist;
	}
}