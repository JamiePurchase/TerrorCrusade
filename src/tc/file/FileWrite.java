package tc.file;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileWrite
{
	private boolean fileAppend = false;
	private String filePath;
	private PrintWriter filePrinter;
	private FileWriter fileWriter;
	private String lineBreak;
	
	public FileWrite(String file, boolean append)
	{
		filePath = "C:/Eclipse/Workspace/TerrorCrusade/data/" + file + ".txt";
		fileAppend = append;
		try{fileWriter = new FileWriter(filePath, fileAppend);}
		catch (IOException e){e.printStackTrace();}
		filePrinter = new PrintWriter(fileWriter);
		lineBreak = System.getProperty("line.separator");
	}
	
	public void write(String text) throws IOException
	{
		filePrinter.printf("%s" + "%n", text);
		filePrinter.close();
	}
	
	public void write(String[] text) throws IOException
	{
		String textAll = "";
		for(int x=0;x<text.length;x+=1)
		{
			textAll += text[x];
			if(x<text.length-1){textAll += lineBreak;}
		}
		filePrinter.printf("%s" + "%n", textAll);
		filePrinter.close();
	}
}