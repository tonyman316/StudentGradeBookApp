package util;
import java.io.*;
import java.util.StringTokenizer;

import model.Student;

public class Util {

	public Util() { }
	
	public Student [] readFile(String filename, Student [] studentList) {
		int counter = 0;
		int numberOfQuiz = 0;
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				counter++;
				if (line == null)
					eof = true;
				else {
						//System.out.println("Reading line " + counter + ": " + line);
					if (counter == 1) {
						// use tokenizer to count number of scores per student
						numberOfQuiz = countNumberOfQuiz(line);
						//System.out.println("\nnumberOfQuiz: " + numberOfQuiz);
					}
		
					if (counter >= 2) {
						studentList[counter-2] = buildStudentArray(numberOfQuiz, line);
					}
				}
			}
			buff.close();
		} catch (Exception error) {
			System.out.println("Error -- " + error.toString());
		}
		return studentList;
	}
	
	public Student buildStudentArray(int numberOfQuiz, String line) {	
		Student studentTemp = new Student(numberOfQuiz);
		String dummyString  =  "";
    	int[] score = new int[numberOfQuiz];

		StringTokenizer tokenizer = new StringTokenizer(line);
		dummyString = tokenizer.nextToken();
		//System.out.println("\ndummyString: " + dummyString);
    	studentTemp.setSID(Integer.parseInt(dummyString));
		//System.out.println("\nstudentTemp.getID: " + studentTemp.getSID());
		
		while (tokenizer.hasMoreTokens()) {
			for (int i = 0; i < numberOfQuiz; i++) {
				dummyString = tokenizer.nextToken();
				score[i] = Integer.parseInt(dummyString);
				//System.out.println("\nscore" + i + ": " + score[i]);
			}
		}
		studentTemp.setScores(score);

	    return studentTemp;
	}
	
	// use tokenizer to count number of scores per student
	public int countNumberOfQuiz(String line){
		int numberOfQuiz = 0;
		StringTokenizer tokenizer = new StringTokenizer(line);

		while (tokenizer.hasMoreTokens()) {
			tokenizer.nextToken();
			numberOfQuiz++;
		}
		return numberOfQuiz-1;
	}

}

