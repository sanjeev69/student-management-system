package net.javaguides.sms.sevice.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.StudentRepository;
import net.javaguides.sms.sevice.StudentSevice;

@Service
public class StudentSeviceImpl implements StudentSevice {
	private StudentRepository studentRepository;
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	public StudentSeviceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}
	@Override
	public Student getStudentById(Long id) {
		return  studentRepository.findById(id).get();
	}
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public void DeleteStudentById(Long id) {
		 studentRepository.deleteById(id);		
	}
	
}
