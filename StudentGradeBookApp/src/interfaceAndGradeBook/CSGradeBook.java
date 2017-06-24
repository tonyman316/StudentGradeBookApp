package interfaceAndGradeBook;

import model.Statistics;
import model.Student;
import model.StudentGradeRecord;

public class CSGradeBook extends StudentGradeRecord{
	private static String subject = "Computer Science";
	private Student [] csStudentListBeforeCurve;	// use serialization clone/output object
	private Student [] csStudentListAfterCurve;
	private String instructor;
	private String schedule;
	private String location;
	private int numberOfQuiz;
	private int numberOfStudent;
	int [] totalScoresOfAStudent;	// Lab7: 40
	private String [] letterGrades;

	public CSGradeBook(Student[] studentList, String instructor, String schedule, String location) {
		super(studentList, subject, instructor, schedule, location);
		this.csStudentListAfterCurve = studentList;
		this.csStudentListBeforeCurve = studentList;
		this.instructor = instructor;
		this.schedule = schedule;
		this.location = location;
		this.numberOfQuiz = studentList[0].getNumberOfQuiz();
		this.numberOfStudent = studentList.length;
		this.totalScoresOfAStudent = new int [this.numberOfStudent];
		letterGrades = new String [this.numberOfStudent];
		
		curveTheLowestAvgQuiz(); 
		computeTotalScoresOfAStuent();
	}
	
	public void computeTotalScoresOfAStuent(){	

		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];
		for(int i=0; i<this.numberOfStudent; i++){
			allScoresOfAStudentTemp = this.csStudentListAfterCurve[i].getScores();
			
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
	
	// As a whole class, not individual
	public int findTheLowestAvgQuiz(){
		Statistics stat_CS = super.getStat();
		double [] avgScores_CS = new double[this.numberOfQuiz];
		avgScores_CS = stat_CS.getAvgScores();
		double lowestAvgQuiz = avgScores_CS[0];
		int index = 0;
		
		for(int i=1; i<this.numberOfQuiz; i++){
			if(lowestAvgQuiz > avgScores_CS[i]){
				lowestAvgQuiz = avgScores_CS[i];
				index = i;
			}
		}
		return index;
	}
	
	public void curveTheLowestAvgQuiz(){
		int lowestQuizIndex = findTheLowestAvgQuiz();
		this.csStudentListBeforeCurve = this.csStudentListAfterCurve;

		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];	
		for(int i=0; i<this.csStudentListAfterCurve.length; i++){
			allScoresOfAStudentTemp = this.csStudentListAfterCurve[i].getScores();
			
			for(int j=0; j<numberOfQuiz; j++){
				if(j==lowestQuizIndex){
					allScoresOfAStudentTemp[j] += 30;	// The lowestAvgQuiz add x points
				}
				this.csStudentListAfterCurve[i].setScores(allScoresOfAStudentTemp);
				//System.out.printf("%d\t", allScoresOfAStudentTemp[j]);
			}
			//System.out.println("");
		}
		
	}
	
	public void computeGrade(){	
		for (int i=0; i<this.numberOfStudent; i++){
			if(this.totalScoresOfAStudent[i] >= 400){
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
		System.out.println("Grading Policy, A: >=400, B: >=300, C: >=250, D: >=200, F: <200 \n");
//		System.out.println("Before Curve:");
//		printAllWithGradesBeforeCurve();
//		
		System.out.println("\nAfter Curve:");
		System.out.println("Stud	Q1	Q2	Q3	Q4	Q5	Total	Grade");
		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];	
		for(int i=0; i<this.csStudentListAfterCurve.length; i++){
			System.out.printf("%d\t", this.csStudentListAfterCurve[i].getSID());
			allScoresOfAStudentTemp = this.csStudentListAfterCurve[i].getScores();
			
			for(int j=0; j<numberOfQuiz; j++){
				System.out.printf("%d\t", allScoresOfAStudentTemp[j]);
			}
			
			System.out.printf("%d\t", this.totalScoresOfAStudent[i]);
			System.out.printf("%s\n", this.letterGrades[i]);	
		}
	}
	
	public void printAllWithGradesBeforeCurve(){
		System.out.println("Stud	Q1	Q2	Q3	Q4	Q5	Total	Grade");
		
		int [] allScoresOfAStudentTemp = new int[this.numberOfQuiz];	
		for(int i=0; i<csStudentListBeforeCurve.length; i++){
			System.out.printf("%d\t", csStudentListBeforeCurve[i].getSID());
			allScoresOfAStudentTemp = csStudentListBeforeCurve[i].getScores();
			
			for(int j=0; j<numberOfQuiz; j++){
				System.out.printf("%d\t", allScoresOfAStudentTemp[j]);
			}
			
			System.out.printf("%d\t", this.totalScoresOfAStudent[i]);
			System.out.printf("%s\n", this.letterGrades[i]);	
		}
	}
}

