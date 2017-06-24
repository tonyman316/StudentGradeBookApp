package interfaceAndGradeBook;

import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudentGradeRecord;

public class ChemistryGradeBook extends StudentGradeRecord{
	private static String subject = "Chemistry";
	private String instructor;
	private String schedule;
	private String location;
	private Student [] chemStudentList;
	private int numberOfQuiz;
	private int numberOfStudent;
	private int [] totalScoresOfAStudent;	// Lab7: 40
	private String [] letterGrades;
	
	public ChemistryGradeBook(Student[] studentList, String instructor, String schedule, String location) {
		super(studentList, subject, instructor, schedule, location);
		this.chemStudentList = studentList;
		this.instructor = instructor;
		this.schedule = schedule;
		this.location = location;
		this.numberOfQuiz = studentList[0].getNumberOfQuiz();
		this.numberOfStudent = studentList.length;
		this.totalScoresOfAStudent = new int [this.numberOfStudent];
		letterGrades = new String [this.numberOfStudent];

		computeTotalScoresOfAStuent();
	}
	
	public void computeTotalScoresOfAStuent(){	// put inside studentGradeRecord
		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];	// Lab7: 5
		for(int i=0; i<this.numberOfStudent; i++){
			allScoresOfAStudentTemp = this.chemStudentList[i].getScores();
			
			for(int j=0; j<numberOfQuiz; j++){
				this.totalScoresOfAStudent[i] += allScoresOfAStudentTemp[j];
			}	
		}
		if(DEBUG){
			for(int k=0; k<this.numberOfStudent; k++){ 
				System.out.println("Total score of student " + (k+1) + ": " + this.totalScoresOfAStudent[k]);
			}
		}
	}
	
	// Custom grading policy for chemistry subject
	public void computeGrade(){	
		for (int i=0; i<this.numberOfStudent; i++){
			if(this.totalScoresOfAStudent[i] >= 350){
				this.letterGrades[i] = "A";
			}else if(this.totalScoresOfAStudent[i] >= 300){
				this.letterGrades[i] = "B";
			}else if(this.totalScoresOfAStudent[i] >= 250){
				this.letterGrades[i] = "C";
			}else if(this.totalScoresOfAStudent[i] >= 200){
				this.letterGrades[i] = "D";
			}else{
				this.letterGrades[i] = "F";
			}
		}
		
		// print grades for all students
		if (DEBUG) {
			for (int j = 0; j < this.numberOfStudent; j++) {
				System.out.println("Final grade of student " + (j + 1) + ": " + this.letterGrades[j]);
			}
		}
	}
	
	public void printAllWithGrades(){
		System.out.printf("\nSubject: %s\t", subject);
		System.out.printf("Instructor: %s\n", this.instructor);
		System.out.printf("Schedule: %s\t", this.schedule);
		System.out.printf("Location: %s\n", this.location);
		System.out.println("Grading Policy, A: >=350, B: >=300, C: >=250, D: >=200, F: <200 \n");
		System.out.println("Stud	Q1	Q2	Q3	Q4	Q5	Total	Grade");
		
		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];	
		for(int i=0; i<this.chemStudentList.length; i++){
			System.out.printf("%d\t", chemStudentList[i].getSID());
			allScoresOfAStudentTemp = this.chemStudentList[i].getScores();
			
			for(int j=0; j<numberOfQuiz; j++){
				System.out.printf("%d\t", allScoresOfAStudentTemp[j]);
			}
			
			System.out.printf("%d\t", this.totalScoresOfAStudent[i]);
			System.out.printf("%s\n", this.letterGrades[i]);	
		}
	}
	
	
}