package com.cognizant.ormlearnh2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearnh2.model.Department;
import com.cognizant.ormlearnh2.model.Employee;
import com.cognizant.ormlearnh2.model.Skill;
import com.cognizant.ormlearnh2.service.DepartmentService;
import com.cognizant.ormlearnh2.service.EmployeeService;
import com.cognizant.ormlearnh2.service.SkillService;



@SpringBootApplication
public class OrmLearnh2Application {

		//SpringApplication.run(OrmLearnh2Application.class, args);
		private static EmployeeService employeeService;
		private static DepartmentService departmentService;
		private static SkillService skillService;
		private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnh2Application.class);
		public static void main(String[] args) {
			//SpringApplication.run(OrmLearn1Application.class, args);
			ApplicationContext context = SpringApplication.run(OrmLearnh2Application.class, args);

			employeeService = context.getBean(EmployeeService.class);
			departmentService = context.getBean(DepartmentService.class);
			skillService = context.getBean(SkillService.class);
			LOGGER.info("Inside main");
			
			try {
				testGetEmployee();
				//testAddEmployee();
				//testUpdateEmployee();
				//testGetDepartment();
				//testGetAllPermanentEmployees();
				//testAddSkillToEmployee();
				//testAverageEmployee();
			} catch (Exception e){
				LOGGER.error(e.getMessage());
			}
			
			
		}
		
		
		
		private static void testAverageEmployee() {
			LOGGER.info("Average Salary is:");
			LOGGER.info("Average:{}",employeeService.getAverageSalaryService());
			
			
		}
		
		
		private static void testGetEmployee()throws ParseException {

			LOGGER.info("Start");

			Employee employee = employeeService.get(16);
			LOGGER.info("end get part");

			LOGGER.debug("Employee:{}", employee);

			LOGGER.debug("Department:{}", employee.getDepartment());
			
			
			Set<Skill> skills = employee.getSkillList();
			String skillNames = "";
			for(Skill skill : skills) {
				skillNames+=skill.getName()+" | ";
			}
			
			LOGGER.debug("Skills : "+skillNames);

			LOGGER.info("End");

			}
		
		private static void testAddEmployee() throws ParseException {
			Employee employee=new Employee();
			//employee.setId();
			employee.setName("Sunil");
			employee.setSalary(1000);
			employee.setPermanent(false);
			employee.setDateOfBirth(new SimpleDateFormat("YYYY-MM-DD").parse("1999-04-28"));
			Department dept=departmentService.get(123);
		    employee.setDepartment(dept);
			employeeService.save(employee);
			
			LOGGER.info("End");
			
		}
		private static void testUpdateEmployee() {
			Employee employee=employeeService.get(12);
			Department dept=departmentService.get(234);
			employee.setDepartment(dept);
			employeeService.save(employee);
			LOGGER.info("stttttaaarrrttt");
			LOGGER.debug("Employee:{}", employee);
			LOGGER.debug("Department:{}", employee.getDepartment());
			
		}
		
		private static void testAddSkillToEmployee() {
			
			LOGGER.info("-----Adding Skill to Employee----");
			Employee employee=employeeService.get(16);
			Skill skill=skillService.get(24);
			
			employee.getSkillList().add(skill);
			employee.getSkillList().add(skillService.get(26));
			employeeService.save(employee);
			LOGGER.debug("Employee:{}", employee);
		
			LOGGER.info("----Skill Added to Employee-----");
			
		}
		
		private static void testGetDepartment() {
			Department dept=departmentService.get(123);
			LOGGER.debug("Departure:{}",dept.getEmployeeList());
		}
	
		public static void testGetAllPermanentEmployees() {
			LOGGER.info("Start");
			List<Employee> employees = employeeService.getAllPermanentEmployees();
			LOGGER.debug("Permanent Employees:{}", employees);
			employees.forEach(e -> {LOGGER.info(e.getId()+"-"+ e.getName()+"-"+ e.getSalary());
					         LOGGER.info("Department="+e.getDepartment().getName());
					         LOGGER.info(e.getSkillList().toString());}			);
			
			LOGGER.info("End of Get All PermanentEmployees");

			}
		

}
