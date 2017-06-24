package driver;

import interfaceAndGradeBook.*;
import model.Student;
import util.Util;

public class Driver {

	public static void main(String[] args) {
		beginAnalyze(15);	// 1, 15, 40, 60	//number of student
	}
	
	public static void beginAnalyze(int numberOfStudent){
		String fileName = "/Users/tonyman/git/StudentGradeBookApp/StudentGradeBookApp/src/util/studentScores" + numberOfStudent + ".txt";

		Student studentList [] = new Student[numberOfStudent];
		Util fileIO = new Util();
		//Populate the student array
		studentList = fileIO.readFile(fileName, studentList);	
		// studentList[numberOfStudent] pass to readFile and return a Student [] with content
		
		testInstructorFunctions(studentList);
		
		//Generate class statistic
		//testObject(studentList);
		
		//testSerialization(studentList, numberOfStudent);
	}
	
	public static void testInstructorFunctions(Student [] studentList) {
		InstructorFunctions instFun_Chem = new ChemistryGradeBook(studentList, "Prof.X", "MW:1-3pm", "S33");
		//instFun_Chem.printAllRecordAndSubjectInfo();
		instFun_Chem.computeGrade();
		instFun_Chem.printAllWithGrades();
		
		InstructorFunctions instFun_CS = new CSGradeBook(studentList, "Prof.Y", "TTH: 5-7pm", "ATC201");
		//instFun_CS.printAllRecordAndSubjectInfo();
		instFun_CS.computeGrade();
		instFun_CS.printAllWithGrades();
		
	}
	
	public static void testObject(Student [] studentList){
		SGRAPI test1 = new TestSGRAPI(studentList, "Chem", "Prof.X", "MW:1-3pm", "ATC201");
		test1.printAllRecord();
		test1.printStatistics();
		System.out.println("");
		test1.printAStudentScores(1234);
		test1.printAStudentScores(0000);
		test1.printAStudentScores(6999);		
	}
	
	public static void testSerialization(Student [] studentList, int numberOfStudent){
		SGRAPI test2 = new TestSGRAPI(studentList, "Chem", "Prof.X", "MW:1-3pm", "ATC201");

		// Object Output
		test2.objectSerialization(studentList);
		
		// Object Input
		Student studentList2 [] = new Student[numberOfStudent];
		studentList2 = test2.objectDeserialization();
		
		// test the input object
		testObject(studentList2);
	}

	

}
