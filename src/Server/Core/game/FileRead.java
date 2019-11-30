package Server.core.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class FileRead {
	
	private File file;
	private final String dir="src"+File.separator+"Server"+File.separator+"Core"+File.separator+"Game"+File.separator+"answer.txt";
	private ArrayList<String> list;
	
	public void read() {
		makeList();
		readstart();
	}
	
	private void makeList() {
		list = new ArrayList<String>();
	}
	
	private void readstart() {
		try {
			file = new File(dir);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				list.add(line);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<String> getAnswer() {
		return this.list;
	}
}
