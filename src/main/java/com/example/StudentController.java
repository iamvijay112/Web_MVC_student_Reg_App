package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.binding.Student;
import com.example.entity.StudentEntity;
import com.example.repo.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo;

@GetMapping("/")
public String loadForm(Model model)
{
	loadFormData(model);
	
	return "index";
}

@PostMapping("/save")
public String handleSubmit(Student s, Model model)
{
	System.out.println(s);
	//logic to save the data 
	StudentEntity entity=new StudentEntity();
	
	//copy data from binding object to entity object
	BeanUtils.copyProperties(s, entity);
	
	entity.setTimings(Arrays.toString(s.getTimings()));
	repo.save(entity);
	model.addAttribute("msg", "Student saved..");
	
	loadFormData(model);
	return "index";
}
	//method to display data
	@GetMapping("/viewStudents")
	public String getStudentsData(Model model)
	{
		List<StudentEntity> studentsList=repo.findAll();
		model.addAttribute("students", studentsList);
		return "data";
	}

private void loadFormData(Model model) {
	List<String> courseslist =new ArrayList<>();
	courseslist.add("java");
	courseslist.add("DeVops");
	courseslist.add("AWS");
	courseslist.add("python");
	
	List<String> timingsList=new ArrayList<>();
	timingsList.add("Morning");
	timingsList.add("Afternoon");
	timingsList.add("Evening");
	
	model.addAttribute("courses",  courseslist);
	model.addAttribute("timings", timingsList);
	
	Student student=new Student();
	model.addAttribute("courses",courseslist);
	model.addAttribute("timings", timingsList);
	model.addAttribute("student", student);
}
		

}