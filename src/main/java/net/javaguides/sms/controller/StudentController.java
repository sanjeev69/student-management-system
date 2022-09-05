package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Student;
import net.javaguides.sms.sevice.StudentSevice;

@Controller
public class StudentController {

	private StudentSevice studentSevice;

	public StudentController(StudentSevice studentSevice) {
		super();
		this.studentSevice = studentSevice;
	}
	
	//handeler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		 model.addAttribute("students", studentSevice.getAllStudents());
		 return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create student object to hold student data
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudents(@ModelAttribute("student") Student student) {
		studentSevice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student", studentSevice.getStudentById(id));
		return "edit_student";
	}
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model) {
		
		//get student from database by id 
		Student existingStudent=studentSevice.getStudentById(id);
		
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student
		studentSevice.updateStudent(existingStudent);
		return "redirect:/students";
		
	}
	
	//handeler to delete student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentSevice.DeleteStudentById(id);
		return "redirect:/students";
	}
	
	
	
	
	
}
