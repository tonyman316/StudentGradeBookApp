package model;
import java.util.*;


public class Statistics {
	private int lowScores[];
	private int highScores[];
	private double avgScores[]; 
	private int numOfQuiz;
	
	public Statistics(){ }
	public Statistics(QuizData qData) {
		this.numOfQuiz = qData.getNumberOfQuiz();
		this.lowScores = new int[numOfQuiz];
		this.highScores = new int[numOfQuiz];
		this.avgScores = new double[numOfQuiz];
	}
	
	public double[] getAvgScores() {
		return avgScores;
	}

	public int findLowForAQuiz(QuizData qData, int quizNumber){
		int lowest = 0;
		List <Integer> quizListTemp = new ArrayList <Integer>();
		quizListTemp = qData.getListOfScoreForAQuiz(quizNumber);
		lowest = Collections.min(quizListTemp);
		//System.out.println("lowest of quiz" + quizNumber + ": " + lowest );
		return lowest;
	}
	
	public int findHighForAQuiz(QuizData qData, int quizNumber){
		int highest = 0;
		List <Integer> quizListTemp = new ArrayList <Integer>();
		quizListTemp = qData.getListOfScoreForAQuiz(quizNumber);
		highest = Collections.max(quizListTemp);
		//System.out.println("lowest of quiz" + quizNumber + ": " + lowest );
		return highest;
		
	}
	
	public double findAvgForAQuiz(QuizData qData, int quizNumber){
		double sum = 0.0;
		List <Integer> quizListTemp = new ArrayList <Integer>();
		quizListTemp = qData.getListOfScoreForAQuiz(quizNumber);
		for(int i=0; i<quizListTemp.size(); i++){
			sum += quizListTemp.get(i);
		}
		//System.out.println("sum of quiz" + quizNumber + ": " + sum);
		return sum/quizListTemp.size();
	}
	
	public void findAllLowestAndPrint(QuizData qData){
		System.out.println("");
		System.out.print("Low scores: 	");
		for(int i=0; i<numOfQuiz; i++){
			this.lowScores[i] = findLowForAQuiz(qData, i);
			//System.out.println("lowScores of quiz" + i + ": " + lowScores[i] + "\n");
			System.out.printf("%d\t", lowScores[i]);
		}
	}
	
	public void findAllHighestAndPrint(QuizData qData){
		System.out.println("");
		System.out.print("High scores:	");
		for(int i=0; i<numOfQuiz; i++){
			this.highScores[i] = findHighForAQuiz(qData, i);
			//System.out.println("highScores of quiz" + i + ": " + highScores[i] + "\n");
			System.out.printf("%d\t", highScores[i]);
		}
	}
	
	public void findAllAvgAndPrint(QuizData qData){
		System.out.println("");
		System.out.print("Average:	");
		for(int i=0; i<numOfQuiz; i++){
			this.avgScores[i] = findAvgForAQuiz(qData, i);
			System.out.printf("%.2f\t", avgScores[i]);
		}
	}
	
}
