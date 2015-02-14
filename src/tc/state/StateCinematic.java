package tc.state;
import tc.Game;
import tc.graphics.Drawing;
import tc.graphics.Fonts;

import java.awt.Color;
import java.awt.Graphics;

public class StateCinematic extends State
{
	// Temporary
	private int tempFrame;
	private int tempFrameMax;
	private int tempTick;
	private int tempTickMax;
	
	public StateCinematic()
	{
		// Temp
		tempFrame = 1;
		tempFrameMax = 10;
		tempTick = 0;
		tempTickMax = 60;
	}
	
	public void render(Graphics g)
	{
		// Temp
		renderBackground(g);
		renderDetails(g);
		renderTemp(g);
	}
	
	public void renderBackground(Graphics g)
	{
		g.drawImage(Drawing.getImage("backgrounds/1.png"),  0, 20, null);
	}
	
	public void renderDetails(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.setFont(Fonts.fontStandard);
		g.drawString("Cinematic", 50, 50);
	}
	
	public void renderTemp(Graphics g)
	{
		if(tempFrame>=1 && tempFrame<3)
		{
			g.setColor(Color.BLACK);
			g.setFont(Fonts.fontCinematic);
			g.drawString("This is the opening cinematic for the campaign...", 200, 375);
		}
		if(tempFrame>=3 && tempFrame<5)
		{
			g.setColor(Color.BLACK);
			g.setFont(Fonts.fontCinematic);
			g.drawString("This is the opening cinematic for the campaign...", 200, 375);
			g.drawString("...need to create an animated map to illustrate the plot.", 200, 450);
		}
		if(tempFrame>=5 && tempFrame<10)
		{
			g.setColor(Color.BLACK);
			g.setFont(Fonts.fontCinematic);
			g.drawString("The village of ankharmal is being sacked by the mislums.", 200, 375);
			g.drawString("You must deploy forces to the area immediately.", 200, 450);
		}
	}
	
	public void tick()
	{
		tickAdvance();
		tickClick();
	}
	
	public void tickAdvance()
	{
		// Debug
		String debug1 = "Tick " + tempTick + " - Frame " + tempFrame;
		System.out.println(debug1);
		
		tempTick += 1;
		if(tempTick>=tempTickMax)
		{
			tempTick = 0;
			tempFrame += 1;
			if(tempFrame>=tempFrameMax)
			{
				// Temp
				Game.campaignNew();
				Game.setStateChange(new StateCampaign());
			}
		}
	}
	
	public void tickClick()
	{
		if(Game.mouse.mouseActionPressedL==true)
		{
			Game.mouse.mouseActionDone();
			Game.campaignNew();
			Game.setStateChange(new StateCampaign());
		}
	}
}