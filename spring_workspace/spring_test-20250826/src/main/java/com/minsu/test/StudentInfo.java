package com.minsu.test;

public class StudentInfo {
	private StudentDto studentDto; //의존 관계

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentInfo(StudentDto studentDto) {
		super();
		this.studentDto = studentDto;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
	
	public void printStudentIfno() {
		System.out.println("이름 : " + studentDto.getName());
		System.out.println("나이 : " + studentDto.getAge());
		System.out.println("학년 : " + studentDto.getGradeNum());
		System.out.println("반 : " + studentDto.getClassNum());
	}
}
