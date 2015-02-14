package tc.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileRead
{
	public String filePath;
	public FileReader fileRead;
	public BufferedReader fileReader;
	public int lineCount;
	
	public FileRead(String path)
	{
		filePath = path;
		try{fileRead = new FileReader(path);}
		catch (FileNotFoundException e){e.printStackTrace();}
		fileReader = new BufferedReader(fileRead);
		try{lineCount = getLineCount();}
		catch (IOException e){e.printStackTrace();}
	}
	
	int getLineCount() throws IOException
	{
		String line;
		int count = 0;
		while((line = fileReader.readLine()) != null)
		{
			count+=1;
		}
		fileReader.close();
		return count;
	}
	
	public String[] read() throws IOException
	{
		String[] textData = new String[lineCount];
		int i;
		for(i=0;i<lineCount;i+=1)
		{
			if(fileReader.readLine()=="# END"){i=lineCount+1;}
			textData[i] = fileReader.readLine();
		}
		fileReader.close();
		return textData;
	}
}