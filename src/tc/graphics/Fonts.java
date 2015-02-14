package tc.graphics;

import java.awt.Font;

public class Fonts
{
	public static Font fontCinematic;
	public static Font fontStandard, fontStandardBold;
	
	public static void init()
	{
		fontCinematic = new Font("Andalus", Font.BOLD, 32);
		fontStandard = new Font("MV Boli", Font.PLAIN, 26);
		fontStandardBold = new Font("MV Boli", Font.BOLD, 26);
	}

}