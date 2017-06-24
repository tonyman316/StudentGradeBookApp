package model;

import java.io.*;
import interfaceAndGradeBook.GlobalConstant;
import interfaceAndGradeBook.SGRAPI;
import interfaceAndGradeBook.InstructorFunctions;

public abstract class StudentGradeRecord implements Serializable, GlobalConstant, SGRAPI, InstructorFunctions{

	private Student [] studentListTemp;
	private QuizData qData;
	private Statistics stat;
	private String subject;
	private String instructor;
	private String schedule;
	private String location;
	
	public StudentGradeRecord(Student studentList[], String subject, String instructor, String schedule, String location) { 
		this.studentListTemp = studentList;
		this.qData = new QuizData(studentList);
		this.stat = new Statistics(qData);
		this.subject = subject;
		this.instructor = instructor;
		this.schedule = schedule;
		this.location = location;
	}
	
	public Student[] getStudentListTemp() {
		return studentListTemp;
	}
	
	public Statistics getStat() {
		return stat;
	}

	public QuizData getqData() {
		return qData;
	}

	public void printAllRecord(){
		System.out.println("Stud	Q1	Q2	Q3	Q4	Q5");
		for(int i=0; i<studentListTemp.length; i++){
			studentListTemp[i].print();
		}
	}
	
	public void printAllRecordAndSubjectInfo(){
		System.out.printf("\nSubject: %s\t", this.subject);
		System.out.printf("Instructor: %s\n", this.instructor);
		System.out.printf("Schedule: %s\t", this.schedule);
		System.out.printf("Location: %s\n\n", this.location);
		printAllRecord();
	}
	
	public void printStatistics(){
		if(DEBUG){ qData.printAllRecordWithoutStudentId();}
		
		stat.findAllHighestAndPrint(qData);
		stat.findAllLowestAndPrint(qData);
		stat.findAllAvgAndPrint(qData);		
	}
	
	public void printAStudentScores(int id){
		boolean found = false;
		for(int i=0; i<this.studentListTemp.length; i++){
			if(id == studentListTemp[i].getSID()){
				System.out.println("\nStud	Q1	Q2	Q3	Q4	Q5");
				studentListTemp[i].print();
				found = true;
				break;
			}else{
				found = false;
			}
		}
		if(!found){ 
			System.out.println("\nStudent Not Found!");
		}

	}
	
	//method to achive StudentGradeRecord
	public void objectSerialization(Student[] studentList) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.dat"));
			out.writeObject(studentList);
			out.flush();
			out.close();
			System.out.println("\nObject Serialization success!");  

		} catch (Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
	
	//method to read StudentGradeRecord 
	public Student[] objectDeserialization() {
		Student[] studentList = null;
		try {

			ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.dat"));
			studentList = (Student[]) in.readObject(); // cast it as Student object array
			in.close();
			System.out.println("Object Deserialization success!\n");

		} catch (Exception e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}

		return studentList;
	}
	

}

