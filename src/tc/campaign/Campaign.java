package tc.campaign;
import tc.file.FileWrite;
import tc.scenario.Scenario;

import java.io.IOException;

public class Campaign
{
	// Campaign Details
	public String campaignFile;
	public String campaignPlayer;
	
	// Scenario Details
	public Scenario scenario = new Scenario();
	public int scenarioCurrent;
	public String[] scenarioName = new String[10];
	public String[] scenarioStatus = new String[10];
	
	public Campaign()
	{
		init();
	}
	
	public void init()
	{
		initScenarios();
	}
	
	public void initScenarios()
	{
		// Scenario 0
		scenarioName[0] = "Mission1";
		scenarioStatus[0] = "Ready";
		
		// Scenario 1
		scenarioName[1] = "Mission2";
		scenarioStatus[1] = "Hidden";
		
		// Next Scenario
		scenarioCurrent = 0;
	}
	
	public void scenarioLoad()
	{
		scenario = new Scenario();
	}
	
	public void save() throws IOException
	{
		String file_name = "C:/Users/Jamie/Documents/My Workshop/Autumn Park/Datafiles/Data.txt";
		FileWrite writer = new FileWrite(file_name, false);
		writer.write("Hello world");
	}
}