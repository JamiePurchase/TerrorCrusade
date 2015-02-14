package tc.scenario;

public class Scenario
{
	// Node Details
	public int nodeCount;
	public ScenarioNode[] nodeObject = new ScenarioNode[33];
	
	// 
	
	// Treasure Details
	public String[] treasureStatus = new String[10];
	
	public Scenario()
	{
		init();
	}
	
	public void init()
	{
		initNodes();
		initBases();
		initTreasure();
	}
	
	public void initBases()
	{
		
	}
	
	public void initNodes()
	{
		
	}
	
	public void initTreasure()
	{
		treasureStatus[0] = "Unknown";
	}
	
	public void save()
	{
		
	}
}