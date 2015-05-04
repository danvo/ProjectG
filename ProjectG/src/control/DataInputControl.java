
package control;

import java.util.List;

public class DataInputControl implements Control
{
	private List<String> _namelist;
	
	@Override
	public String getAccountname()
	{
		return "name"; // auch hier muss noch geändert werden, nachdem die GUI fertig ist.
	}
	
	@Override
	public List<String> getNameFromUI(String name)
	{
		_namelist.add(name); //bsiher nur ein Name, muss noch erweitert werden, wenn klar ist, wie man Namen von der UI bekommt.
		return _namelist;
	}
}