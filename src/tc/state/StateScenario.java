package tc.state;
import tc.Game;
import tc.graphics.Drawing;
import tc.graphics.Fonts;

import java.awt.Color;
import java.awt.Graphics;

public class StateScenario extends State
{
	
	public StateScenario()
	{
		//initNexus();
	}
	
	public void initNexus()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("ButtonLaunch", 800, 420, 190, 40);
		Game.mouse.nexusAdd("ButtonSave", 800, 480, 175, 40);
		Game.mouse.nexusAdd("ButtonQuit", 800, 540, 150, 40);
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderDetails(g);
		//renderOptions(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Drawing.getImage("backgrounds/1.png"),  0, 20, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(Fonts.fontStandard);
		g.drawString("Scenario Menu", 50, 50);
		if(Game.development==true)
		{
			String devOffset = "Offset";
			g.drawString(devOffset, 50, 90);
		}
	}
	
	public void renderOptions(Graphics g)
	{
		g.setColor(Color.RED);
		
		// Launch Mission
		if(Game.mouse.nexusCheckRef()=="ButtonLaunch"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("Launch Mission", 805, 450);
		
		// Save Progress
		if(Game.mouse.nexusCheckRef()=="ButtonSave"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("Save Progress", 805, 510);
		
		// Quit
		if(Game.mouse.nexusCheckRef()=="ButtonQuit"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("Quit Game", 810, 570);
		
		// Show Nexus (dev mode)
		if(Game.development==true){Game.mouse.nexusDraw(g);}
	}
	
	public void tick()
	{
		//tickClick();
	}
	
	public void tickClick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			String ref = Game.mouse.nexusCheckRef();
			if(ref=="ButtonLaunch")
			{
				Game.mouse.mouseActionDone();
				//Game.setStateChange(new StateBattle());
			}
			if(ref=="ButtonSave")
			{
				Game.mouse.mouseActionDone();
				// Note: Create a file save feature
			}
			if(ref=="ButtonQuit")
			{
				Game.mouse.mouseActionDone();
				System.exit(0);
			}
		}
	}
}