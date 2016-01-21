import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Coursemanagement{
	private static Scanner in1;
	public static void main(String []args) throws IOException{
		System.out.println("Hello!");
		System.out.println("Welcome to IIT Kharagpur : Short Term Course Management");
		in1 = new Scanner(System.in);
		int choice;
		boolean value = true;
		//ArrayList<Course> courseArray = new ArrayList<Course>(10);
		ArrayList<Course> courseArray = new ArrayList<Course>(10);
		try
	      {
	         FileInputStream fileIn = new FileInputStream("shorttermcoursemanagement");
	         ObjectInputStream input = new ObjectInputStream(fileIn);
	         courseArray = (ArrayList<Course>) input.readObject();
	         try {
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         try {
				fileIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }catch(FileNotFoundException a)
	      {
	         System.out.println("OOPs!! File Not Found");
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("ArrayList<Course> class not found");
	         c.printStackTrace();
	         return;
	      }
		Scanner in = new Scanner(System.in);
		while(value){
			System.out.println("Enter your choice:");
			System.out.println("1-Create a new course and display all courses");
			System.out.println("2-Create a new participant for a course and display all its registered participants");
			System.out.println("3-Alter details of courses");
			System.out.println("4-Alter details of participants");
			System.out.println("5-Alter details of faculty");
			System.out.println("6-Save and exit\n");
			choice = in.nextInt();
			switch(choice){
				case 1: if(courseArray.size()!=10){
							Course c = new Course();
							c.courseCreator();
							courseArray.add(c);
						//System.out.println("The course created is :"+c.courseName+" "+c.courseFee+" "+c.startDate+" "+c.courseDuration+" "+c.courseCoordinator);
						//System.out.println("The following are the faculty members :");
						//int i=0;
						//while(i!=c.facultylist.size()){
						//	System.out.println("Faculty Name :"+c.facultylist.get(i).facultyName);
						//	i++;
						//}
						//System.out.println("Current Size : "+courseArray.size());
							System.out.println("The following courses have been created so far:");
							int i = 0;
							while(i<courseArray.size()){
								System.out.println("Serial Number :"+(i+1));
								System.out.println("Course Name : "+courseArray.get(i).courseName);
								System.out.println("Course Fee : "+courseArray.get(i).courseFee);
								System.out.println("Course Start Date : "+courseArray.get(i).startDate);
								System.out.println("Course Duration : "+courseArray.get(i).courseDuration);
								System.out.println("\nCourse Co-ordinator : "+courseArray.get(i).courseCoordinator.facultyName);
								System.out.println("	Department : "+courseArray.get(i).courseCoordinator.affiliatedDepartment);
								System.out.println("	Address : "+courseArray.get(i).courseCoordinator.facultyAddress);
								System.out.println("	Mobile Number : "+courseArray.get(i).courseCoordinator.mobile);
								System.out.println("	E-mail : "+courseArray.get(i).courseCoordinator.email);
								System.out.println("The course, "+courseArray.get(i).courseName+" has the following Faculty Members as Instructors");
								int j = 0;
								while(j< courseArray.get(i).facultylist.size()){
									System.out.println("Faculty Name : "+courseArray.get(i).facultylist.get(j).facultyName);
									System.out.println("	Department : "+courseArray.get(i).facultylist.get(j).affiliatedDepartment);
									System.out.println("	Address : "+courseArray.get(i).facultylist.get(j).facultyAddress);
									System.out.println("	Mobile Number : "+courseArray.get(i).facultylist.get(j).mobile);
									System.out.println("	E-mail Address : "+courseArray.get(i).facultylist.get(j).email);
									j++;
								}
								i++;
								System.out.println(" ");
							}
						}
						else{
							System.out.println("Sorry. No more Courses can be created");
						}
						break;
				case 2: System.out.println("Please enter the Course for which you want to create new Participants");
						String courseChoice = in1.nextLine();
						int i = 0;
						for(i=0;i<courseArray.size();i++){
							if(courseArray.get(i).courseName.equals(courseChoice) == true){
								//System.out.println("Oh Yes!");
								break;
							}
						}
						if(courseArray.get(i).participantlist.size()<5){
							Participant part = new Participant();
							part.participantCreator();
							courseArray.get(i).participantlist.add(part);
							int j=0;
							System.out.println("\nThe Course, "+courseChoice+" has successfully added another Participant");
							System.out.println("The following Participants are now enrolled in the Course "+courseChoice);
							while(j!=courseArray.get(i).participantlist.size()){
								System.out.println("Partcipant Name : "+courseArray.get(i).participantlist.get(j).participantName);
								System.out.println("	Address : "+courseArray.get(i).participantlist.get(j).participantAddress);
								System.out.println("	Organisation : "+courseArray.get(i).participantlist.get(j).participantOrganisation);
								System.out.println("	Mobile Number : "+courseArray.get(i).participantlist.get(j).participantMobile);
								System.out.println("	E-mail Address : "+courseArray.get(i).participantlist.get(j).participantEmail);
								j++;
							}
							System.out.println(" ");
						}
						else{
							System.out.println("Sorry the Course is full, no more Participants can be created\n");
						}
						break;
				case 3: break;
				case 4: break;
				case 5: break;
				case 6: value = false;
						in.close();
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					         System.out.printf("Serialized data is saved in /tmp/employee.ser");
					      }catch(IOException exe)
					      {
					          exe.printStackTrace();
					      }
						 break;
				default: System.out.println("Invalid choice");
						 break;
			}
		}
	}
}

class Faculty implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3872877282136394079L;
	String affiliatedDepartment;
	String facultyName;
	String facultyAddress;
	String mobile;
	String email;
	transient private Scanner input;
	
	public void facultyCreator(){
		input = new Scanner(System.in);
		System.out.print("Enter the Name of the Faculty : ");
		this.facultyName = input.nextLine();
		System.out.print("Enter the affiliated Department : ");
		this.affiliatedDepartment = input.nextLine();
		System.out.print("Enter the address of the Faculty : ");
		this.facultyAddress = input.nextLine();
		System.out.print("Enter the mobile number of the Faculty : ");
		this.mobile = input.nextLine();
		System.out.print("Enter the e-mail address of the Faculty : ");
		this.email = input.nextLine();
	}
}

class Participant implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7626518509370001646L;
	String participantName;
	String participantAddress;
	String participantMobile;
	String participantOrganisation;
	String participantEmail;
	transient private Scanner input;
	public void participantCreator(){
		input = new Scanner(System.in);
		System.out.print("Enter the Name of the Participant : ");
		this.participantName = input.nextLine();
		System.out.print("Enter the Address of the Participant : ");
		this.participantAddress = input.nextLine();
		System.out.print("Enter the Organisation name of which the Participant is affiliated to : ");
		this.participantOrganisation = input.nextLine();
		System.out.print("Enter the Mobile Number of the Participant : ");
		this.participantMobile = input.nextLine();
		System.out.print("Enter the E-mail address of the Participant : ");
		this.participantEmail = input.nextLine();
	}
}

class Course implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4017029059730236798L;
	String courseName;
	String courseFee;
	String startDate;
	String endDate;
	String courseDuration;
	Faculty courseCoordinator = new Faculty();
	int instructorCount;
	//int participantCount;
	//Faculty []facultyList;
	//Participant []participantList;
	ArrayList<Faculty> facultylist = new ArrayList<Faculty>(5);
	ArrayList<Participant> participantlist = new ArrayList<Participant>(5);
	transient private Scanner in;
	public void courseCreator() {
		in = new Scanner(System.in);
		System.out.print("Enter the Name of the Course : ");
		this.courseName = in.nextLine();
		System.out.print("Enter the Couse Fee(in Rupees) : ");
		this.courseFee = in.nextLine();
		System.out.print("Enter the Start Date : ");
		this.startDate= in.nextLine();
		System.out.print("Enter the Course Duration(upto 2 weeks) : ");
		this.courseDuration = in.nextLine();
		System.out.print("Enter the name of the Course Co-ordinator : ");
		this.courseCoordinator.facultyName = in.nextLine();
		System.out.print("Enter the affiliated Department :");
		this.courseCoordinator.affiliatedDepartment = in.nextLine();
		System.out.print("Enter the address of the Faculty : ");
		this.courseCoordinator.facultyAddress = in.nextLine();
		System.out.print("Enter the mobile number of the Faculty : ");
		this.courseCoordinator.mobile = in.nextLine();
		System.out.print("Enter the e-mail address of the Faculty : ");
		this.courseCoordinator.email = in.nextLine();
		System.out.print("Course "+this.courseName+ " successfully created!!\n");
		System.out.print("\nEnter the number of Faculty Members as Instructors for the Course\n");
		this.instructorCount = in.nextInt();
		int count = this.instructorCount;
		while(count!=0){
			Faculty fac = new Faculty();
			fac.facultyCreator();
			this.facultylist.add(fac);
			count--;
			System.out.println(" ");
		}
		//in.close();
	}
}
