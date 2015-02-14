package tc.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileRead
{
	private String filePath;
	private FileReader fileRead;
	private BufferedReader fileReader;
	private int lineCount;
	
	public FileRead(String file)
	{
		filePath = "C:/Eclipse/Workspace/TerrorCrusade/data/" + file + ".txt";
		try{lineCount = getLineCount();}
		catch (IOException e){e.printStackTrace();}
	}
	
	int getLineCount() throws IOException
	{
		try{fileRead = new FileReader(filePath);}
		catch (FileNotFoundException e){e.printStackTrace();}
		fileReader = new BufferedReader(fileRead);
		String line;
		int count = 0;
		while((line = fileReader.readLine()) != null){count+=1;}
		fileReader.close();
		return count;
	}
	
	public String[] read() throws IOException
	{
		try{fileRead = new FileReader(filePath);}
		catch (FileNotFoundException e){e.printStackTrace();}
		fileReader = new BufferedReader(fileRead);
		String[] textData = new String[lineCount];
		for(int x=0;x<lineCount;x+=1)
		{
			textData[x] = fileReader.readLine();
		}
		fileReader.close();
		return textData;
	}
}