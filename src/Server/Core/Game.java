package Server.Core;

import Server.Core.FileRead;

import java.util.ArrayList;
import java.util.Random;

public class Game {

	private FileRead file;
	private ArrayList<String> answerList;
	private String answer;

	public void start() {
		readFile();
		saveAnswer();
	}

	private void readFile() {
		file = new FileRead();
		file.read();
	}

	private void saveAnswer() {
		answerList = file.getAnswer();
	}

	public void print() {
		for (int i = 0; i < answerList.size(); i++) {
			System.out.println(answerList.get(i));
		}
	}

	public boolean hasMoreAnswer() {
		if (answerList.size() != 0) {
			int index = (int) (Math.random() * answerList.size());
			answer = answerList.get(index);
			answerList.remove(index);
			return true;
		}
		else return false;
	}
	
	public String getAnswer() {
		return this.answer;
	}
}
