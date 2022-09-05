package net.javaguides.sms.sevice;

import java.util.List;

import net.javaguides.sms.entity.Student;

public interface StudentSevice {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void DeleteStudentById(Long id);
}
