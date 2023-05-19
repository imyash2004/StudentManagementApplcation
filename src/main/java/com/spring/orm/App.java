package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student=new Student(4,"sarika agarwal","up");
//        
//        
//        int r=studentDao.insert(student);
//        System.out.println(r);
		boolean flag = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (flag) {

			System.out.println("Press 1 to insert the details of new student");
			System.out.println("Press 2 to get the details of student");

			System.out.println("Press 3 to get the details of all  students");

			System.out.println("Press 4 to delete the details of student");

			System.out.println("Press 5 to update the details of  student");
			System.out.println("Press 6 to exit");

			try {

				int input = Integer.parseInt(br.readLine());
				switch (input) {
				case 1:
					// insert
					System.out.println("Enter the Student id:");
					int sid = Integer.parseInt(br.readLine());
					System.out.println("Enter the Student name:");
					String sname = br.readLine();
					System.out.println("Enter the Student city:");
					String scity = br.readLine();

					Student student = new Student();
					student.setStudentCity(scity);
					student.setStudentId(sid);
					student.setStudentName(sname);
					int r = studentDao.insert(student);
					System.out.println(r + "hn ho gyi insert details student ki......");
					System.out.println("----------------------------------------------------------------------");
					System.out.println();
					break;
				case 2:
					// get the student
					System.out.println("```````````````````````````````````````````````````````````");
					System.out.println("Enter the Student id:");
					int s_id = Integer.parseInt(br.readLine());
					Student student1 = studentDao.getStudent(s_id);

					System.out.println("Id:" + student1.getStudentId());
					System.out.println("Name:" + student1.getStudentName());
					System.out.println("City:" + student1.getStudentCity());

					System.out.println("```````````````````````````````````````````````````````````");

					break;
				case 3:
					System.out.println(
							"..........................................................................................");
					List<Student> all = studentDao.getallStudents();
					for (Student a : all) {
						System.out.println("Id:" + a.getStudentId());
						System.out.println("Name:" + a.getStudentName());
						System.out.println("City:" + a.getStudentCity());
						System.out.println("===============================");

					}
					System.out.println(
							"..........................................................................................");

					// get all the students
					break;
				case 4:
					// delete the student
					System.out.println("```````````````````````````````````````````````````````````");
					System.out.println("Enter the Student id:");
					int id = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(id);
					System.out.println("nikal diya school sai bhaii................................");
					System.out.println("```````````````````````````````````````````````````````````");

					
					break;
				case 5:
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
					// update the student
					System.out.println("enter the student id :");
					int a1=Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(a1);
					System.out.println("press1 to update the name of student:");
					System.out.println("press 2 to change the city of student:");
					System.out.println("press 3 for both change the name and city");
					int aa=Integer.parseInt(br.readLine());
					if(aa==1) {
						System.out.println("enter update name:");
						
						String n=br.readLine();
						student2.setStudentName(n);
						studentDao.updateStudent(student2);
							
					}
					else if(aa==2) {
						System.out.println("enter update city:");
						
						String n=br.readLine();
						student2.setStudentCity(n);
						studentDao.updateStudent(student2);
							
					}
					else if(aa==3) {
						System.out.println("enter update city:");
						
						String n=br.readLine();
						System.out.println("enter update name:");
						String n1=br.readLine();
						student2.setStudentName(n1);

						student2.setStudentCity(n);
						studentDao.updateStudent(student2);
					}
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");

					break;
				case 6:
					// exit
					flag = false;
					break;
				default:
					break;
				}

			} catch (Exception e) {
				System.out.println("samjh nhi ata jo menu mai likha hai bs vo hi type krna hai ....");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("DHANYAWAD HMARA APPLICATION USE KRNE KA LIYE..........");
		System.out.println("UMEED HAI APKO MZA AYA HOGA USE KRKE................... ");

	}
}
