package tc.state;
import tc.Game;
import tc.graphics.Drawing;
import tc.graphics.Fonts;

import java.awt.Color;
import java.awt.Graphics;

public class StateScenario extends State
{
	// Message (consider using a class - can be used all over the game)
	private boolean messageActive;
	private String messageString;
	private int messageTick;
	
	public StateScenario()
	{
		//initNexus();
	}
	
	public void initNexus()
	{
		Game.mouse.nexusClear();
		Game.mouse.nexusAdd("ButtonTest", 800, 120, 190, 40);
	}
	
	public void render(Graphics g)
	{
		renderBackground(g);
		renderDetails(g);
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
		
		// Test Speech
		if(Game.mouse.nexusCheckRef()=="ButtonTest"){g.setFont(Fonts.fontStandardBold);}
		else{g.setFont(Fonts.fontStandard);}
		g.drawString("Test Speech", 1005, 150);
		
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
			if(ref=="ButtonTest")
			{
				Game.mouse.mouseActionDone();
				
				// Temp
				messageActive = true;
				messageString = "Hello";
				//Game.audio.playSound("tlkTest1");
				Game.audio.playMusic("bgm1");
			}
		}
	}
}