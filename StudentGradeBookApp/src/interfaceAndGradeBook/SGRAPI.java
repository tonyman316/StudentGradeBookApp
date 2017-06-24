package interfaceAndGradeBook;

import model.Student;

public interface SGRAPI {
	public void printAllRecord();
	public void printStatistics();
	public void printAStudentScores(int id);
	public void objectSerialization(Student[] studentList);
	public Student[] objectDeserialization();
	
}
