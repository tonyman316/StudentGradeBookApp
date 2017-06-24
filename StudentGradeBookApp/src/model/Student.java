package model;
import java.io.*;

public class Student implements Serializable{
	private int numberOfQuiz;
	private int SID;
	private int scores[];
	
	public Student(int numberOfQuiz){ 
		this.numberOfQuiz = numberOfQuiz;
	}
	public int getNumberOfQuiz() {
		return numberOfQuiz;
	}

	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public int[] getScores() {
		return scores;
	}
	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	public void print(){
		System.out.printf("%d	", this.SID);
		for(int i=0; i<numberOfQuiz; i++){
			System.out.printf("%d	", this.scores[i]);
		}
		System.out.println("");
	}	
	
}

