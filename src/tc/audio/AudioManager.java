package tc.audio;

import tc.audio.AudioPlayer;

public class AudioManager
{
	private static boolean musicActive = false;
	private static String musicFile;
	private static boolean soundActive = false;
	private static String soundFile;
	private static int soundTick;

	public AudioManager()
	{
		AudioPlayer.init();
		initDialogue();
		initMusic();
		initSounds();
	}
	
	public boolean getMusicActive()
	{
		return musicActive;
	}
	
	public boolean getSoundActive()
	{
		return soundActive;
	}
	
	public void initDialogue()
	{
		//AudioPlayer.load("/audio/dialogue/test1.wav", "tlkTest1");
	}
	
	public void initMusic()
	{
		//AudioPlayer.load("/audio/music/bgm1.wav", "music1");
		//AudioPlayer.load("/audio/music/BombingMission.wav", "bgmBombingMission");
	}
	
	public void initSounds()
	{
		//AudioPlayer.load("/audio/sounds/Something.wav", "sfxSomething");
	}
	
	public void playMusic(String music)
	{
		AudioPlayer.play(music);
		musicActive = true;
		musicFile = music;
	}
	
	public void playSound(String sound)
	{
		AudioPlayer.play(sound);
		soundActive = true;
		soundFile = sound;
		soundTick = 0;
	}
	
	public void stopMusic()
	{
		AudioPlayer.stop(musicFile);
		musicActive = false;
		musicFile = "";
	}
	
	public void stopSound()
	{
		//AudioPlayer.stop(soundFile);
		soundActive = false;
		soundFile = "";
	}
	
	public void tick()
	{
		if(getSoundActive())
		{
			soundTick += 1;
			//if(soundTick>1){stopSound();}
		}
	}
}