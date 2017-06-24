package model;

import java.util.ArrayList;
import java.util.List;

public class QuizData {
	private int allQuizScores [][];
	private int numberOfStudent;
	private int numberOfQuiz;
	private Student [] studentListTemp;
	
	public QuizData() { }
	public QuizData(Student studentList[]) {
		this.studentListTemp = studentList;
		this.numberOfStudent = studentList.length;
		this.numberOfQuiz = studentList[0].getNumberOfQuiz();
		this.allQuizScores = new int [this.numberOfStudent][this.numberOfQuiz];
		buildAllRecord();
	}

	public int[][] getAllQuizScores() {
		return allQuizScores;
	}

	public void setAllQuizScores(int[][] allQuizScores) {
		this.allQuizScores = allQuizScores;
	}

	public int getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(int numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}

	public int getNumberOfQuiz() {
		return numberOfQuiz;
	}

	public void setNumberOfQuiz(int numberOfQuiz) {
		this.numberOfQuiz = numberOfQuiz;
	}
	
	// Use a list of student to build a record of a class
	public void buildAllRecord(){
		int [] scoresArrayTemp = new int [this.numberOfQuiz];
		
		for(int i=0; i<numberOfStudent; i++){
			scoresArrayTemp = studentListTemp[i].getScores();
	
			for(int j=0; j<numberOfQuiz; j++){
				//System.out.printf("%d	", scoresArrayTemp[j]);				
				this.allQuizScores[i][j] = scoresArrayTemp[j];
			}
		}
	}
	
	// Build a list of score for a quiz
		public List<Integer> getListOfScoreForAQuiz(int quizNumber){
			List <Integer> scoreList = new ArrayList<Integer>();
			for(int i=0; i<numberOfStudent; i++){
				scoreList.add(this.allQuizScores[i][quizNumber]);
			}
			//System.out.println("quizNumber" + quizNumber + ": " + scoreList);
			return scoreList;
		}
		
	// print helper
	public void printAllRecordWithoutStudentId(){
		System.out.println("\nQuizData:");
		System.out.println("\nQ1	Q2	Q3	Q4	Q5");

		for(int i=0; i<numberOfStudent; i++){			
			for(int j=0; j<numberOfQuiz; j++){
				System.out.printf("%d	", this.allQuizScores[i][j]);
			}
			System.out.println("");
		}
	}
	
}
