package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program started........" );
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
        
//        Student student = new Student();
//        student.setStudentId(2);
//        student.setStudentName("Sarvesh");
//        student.setStudentCity("Uttar Pradesh");
//        int result = studentDao.insert(student);
//        System.out.println("Inserted data is..."+result);
        Scanner sc = new Scanner(System.in);
        boolean go = true;
        while(go) {
        	System.out.println("PRESS 1 to add new data");
        	System.out.println("PRESS 2 to show all data");
        	System.out.println("PRESS 3 to show single data");
        	System.out.println("PRESS 4 to delete data");
        	System.out.println("PRESS 5 to updata data");
        	System.out.println("PRESS 6 to exit");
        	
        	try {
        		int input = sc.nextInt();
        		
        		switch (input) {
				case 1:
					System.out.println("Enter user id :");
					int uid = sc.nextInt();
					System.out.println("Enter username  :");
					String uname = sc.next();
					System.out.println("Enter City :");
					String city = sc.next();
					Student student = new Student(uid,uname,city);//using paramatrized constructor,can also be done using setter
					int result = studentDao.insert(student);
					System.out.println("Data added..."+result);
					System.out.println("*******************************************************************************");
					System.out.println();
					break;

				case 2:
					System.out.println("-------------------------------------------------------------------------------");
					List<Student>students = studentDao.getAllStudent();
					for(Student s:students) {
						System.out.println("ID "+s.getStudentId());
						System.out.println("Name "+s.getStudentName());
						System.out.println("City "+s.getStudentCity());
						
						System.out.println("-----------------------------------------------------------------------------");
					}
					break;
					
				case 3:
					System.out.println("Enter user id :");
					int id = sc.nextInt();
					System.out.println("-----------------------------------------------------------------------------");
					Student stud = studentDao.getStudent(id);
					System.out.println("ID "+stud.getStudentId());
					System.out.println("Name "+stud.getStudentName());
					System.out.println("City "+stud.getStudentCity());
					System.out.println("-----------------------------------------------------------------------------");
					
					break;
					
				case 4:
					System.out.println("Enter user id :");
					int usrid = sc.nextInt();
					studentDao.deleteStudent(usrid);
					System.out.println("Student seleted successfully..");
					break;
					
				case 5:
					System.out.println("Enter old user id :");
					int ouid = sc.nextInt();
					System.out.println("Enter new username  :");
					String usrname = sc.next();
					System.out.println("Enter new City :");
					String ncity = sc.next();
					Student stu = new Student(ouid,usrname,ncity);
					studentDao.updateStudent(stu);
					System.out.println("Student data updated successfully....");
					
					break;
					
				case 6:
					
					go = false;
					break;
					
					
				}
        		
        	}catch(Exception e) {
        		System.out.println("Invalid input try with other option");
        	}
        }
        System.out.println("Thank you for using");
    }
}
