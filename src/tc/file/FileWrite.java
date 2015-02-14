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
	
	public FileWrite(String path, boolean append)
	{
		filePath = path;
		fileAppend = append;
		try{fileWriter = new FileWriter(filePath, fileAppend);}
		catch (IOException e){e.printStackTrace();}
		filePrinter = new PrintWriter(fileWriter);
	}
	
	public void write(String text) throws IOException
	{
		filePrinter.printf("%s" + "%n", text);
		filePrinter.close();
	}
}