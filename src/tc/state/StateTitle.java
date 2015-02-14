package tc.state;
import tc.Game;
import tc.file.FileRead;
import tc.graphics.Drawing;
import tc.graphics.Fonts;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

public class StateTitle extends State
{
	// Saved campaign data
	private boolean dataExists;
	private int dataCount;
	private String[] dataFile;
	
	public StateTitle()
	{
		initFiles();
		initNexus();
	}
	
	public void initFiles()
	{
		// Load the main data file
		String[] data = null;
		FileRead reader = new FileRead("main");
		try{data = reader.read();}
		catch (IOException e){e.printStackTrace();}

		// Check to see if there are any saved campaigns
		if(Integer.parseInt(data[0])==0){dataExists = false;}
		else if(Integer.parseInt(data[0])>0)
		{
			dataExists = true;
		}
		else{System.out.println(data[0]);}
	}
	
	public void initNexus()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("ButtonNew", 800, 420, 150, 40);
		Game.mouse.nexusAdd("ButtonLoad", 800, 480, 135, 40);
		Game.mouse.nexusAdd("ButtonQuit", 800, 540, 150, 40);
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
		g.drawImage(Drawing.getImage("title/logo.png"),  399, 20, null);
		g.drawImage(Drawing.getImage("title/guardian2.png"),  400, 300, null);
	}
	
	public void renderOptions(Graphics g)
	{
		// New Game
		g.setColor(Color.RED);
		if(Game.mouse.nexusCheckRef()=="ButtonNew"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("New Story", 805, 450);
		
		// Continue
		g.setColor(Color.RED);
		if(dataExists==true)
		{
			if(Game.mouse.nexusCheckRef()=="ButtonLoad"){g.setFont(Fonts.fontStandardBold);}
			else{g.setFont(Fonts.fontStandard);}
		}
		else
		{
			g.setFont(Fonts.fontStandard);
			g.setColor(Color.GRAY);
		}
		g.drawString("Continue", 805, 510);
		
		// Quit
		g.setColor(Color.RED);
		if(Game.mouse.nexusCheckRef()=="ButtonQuit"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("Quit Game", 810, 570);
		
		// Show Nexus (dev mode)
		if(Game.development==true){Game.mouse.nexusDraw(g);}
	}
	
	public void tick()
	{
		tickClick();
	}
	
	public void tickClick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			String ref = Game.mouse.nexusCheckRef();
			if(ref=="ButtonNew")
			{
				Game.mouse.mouseActionDone();
				Game.campaignNew();
				Game.setStateChange(new StateCampaign());
			}
			if(ref=="ButtonLoad")
			{
				Game.mouse.mouseActionDone();
				if(dataExists==true)
				{
					// Note: Create a file load screen
				}
				else
				{
					// Note: Create an alert for no campaign data
				}
			}
			if(ref=="ButtonQuit")
			{
				Game.mouse.mouseActionDone();
				System.exit(0);
			}
		}
	}
}