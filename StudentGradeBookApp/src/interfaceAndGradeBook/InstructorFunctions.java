package interfaceAndGradeBook;

import model.Student;

public interface InstructorFunctions {
	
	public void printAllRecordAndSubjectInfo();	// without total scores and final grades
	public void printAllWithGrades();	//printAll()
	public void computeGrade();		//computeGrade()
	public void objectSerialization(Student[] studentList);	// saveData()
	public Student[] objectDeserialization();	//loadData()
	public void printStatistics();	
	public void printAStudentScores(int id);
}
