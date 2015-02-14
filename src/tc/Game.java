package tc;
import tc.campaign.Campaign;
import tc.graphics.Fonts;
import tc.input.Mouse;
import tc.state.State;
import tc.state.StateTitle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable
{
	// Campaign
	public static Campaign campaign;

	// Graphics
	private BufferStrategy bs;
	private Graphics g;
	public Canvas canvas;
	
	// Mouse
	public static Mouse mouse;
	
	// Threads
	private Thread thread;
	private boolean running = false;
 
	// States
	public State gameState;
	public static State gameStateNew;
	public static boolean gameStateChange = false;
	
	// Development Mode
	public static boolean development;

	public Game(boolean devMode)
	{
		development = devMode;
	}
	
	public static void campaignNew()
	{
		campaign = new Campaign();
	}
	
	public void init()
	{
		initGame();
		initStates();
		Fonts.init();
	}
	
	public void initGame()
	{
		mouse = new Mouse();
		addMouseListener (mouse);
		setTitle("Terror Crusade");
		setSize(1366, 768);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(1366, 768));
		canvas.setMaximumSize(new Dimension(1366, 768));
		canvas.setMinimumSize(new Dimension(1366, 768));
		canvas.addMouseListener (mouse);
		canvas.addMouseMotionListener (mouse);
		
		// Add the canvas to the frame
		add(canvas);
		//pack();
	}
	
	public void initStates()
	{
		State.setState(new StateTitle());
	}
	
	public void render()
	{
		// Buffer strategy
		bs = canvas.getBufferStrategy();
		if(bs == null)
		{
			canvas.createBufferStrategy(3);
			return;
		}
		
		// Graphics start
		g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1366, 768);
		
		// Graphics draw
		if(State.getState() != null)
		{
			State.getState().render(g);
		}

		// Graphics done
		bs.show();
		g.dispose();
	}
	
	public void run()
	{
		// Render speed
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		// Create window
		init();
		
		// Main game loop
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000)
			{
				ticks = 0;
				timer = 0;
			}
		}
		
		// End game
		stop();
	}
	
	public static void setStateChange(State newState)
	{
		Game.gameStateChange = true;
		Game.gameStateNew = newState;
	}
	
	public synchronized void start()
	{
		if(running==false)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running==true)
		{
			try
			{
				thread.join();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void tick()
	{
		if(gameStateChange==true){tickStateChange();}
		State.getState().tick();
	}

	public void tickStateChange()
	{
		State.setState(gameStateNew);
		gameStateChange = false;
	}
	
}