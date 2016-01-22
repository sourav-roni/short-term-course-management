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
	public static Scanner in1;
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
			System.out.println("6-Display all Courses Created in the past one year");
			System.out.println("7-Display all Courses Created so far");
			System.out.println("8-Save and exit\n");
			choice = Integer.parseInt(in.nextLine());
			switch(choice){
				case 1: if(courseArray.size()!=10){
							Course c = new Course();
							c.courseCreator();
							courseArray.add(c);
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
				case 3: System.out.print("\nEnter the name of the Course which you want to alter : ");
						in.reset();
						in1.reset();
						String courseChoose = in1.nextLine();
						i=0;
						while(i<courseArray.size()){
							if(courseArray.get(i).courseName.equals(courseChoose)==true){
								break;
							}
							i++;
						}
						if(i!=courseArray.size()){
							System.out.print("Do you want to Delete the Course? [Y/N] : ");
							in1.reset();
							String deleteChoice = in1.nextLine();
							if(deleteChoice.equals("Y")==true||deleteChoice.equals("y")==true){
								courseArray.remove(i);
								System.out.println("The Course "+courseChoose+" has been successfully deleted");
							}
							else{
								System.out.println("Entering into Course Alter Mode...");
								boolean select = true;
								while(select){
									System.out.println("Please Enter your choices for editing the selected Course : ");
									System.out.println("1-Edit Course Name");
									System.out.println("2-Edit Course Fees");
									System.out.println("3-Edit Course Start Date");
									System.out.println("4-Edit Course Duration");
									System.out.println("5-Save and Exit Edit Mode");
									int editChoice = Integer.parseInt(in1.nextLine());
									switch(editChoice){
										case 1: System.out.print("Enter the new Course Name for "+courseArray.get(i).courseName+" : ");
												in.reset();
												//String newCourseName = in.nextLine();
												//System.out.println(" "+newCourseName+" ");
												//System.out.println(""+);
												courseArray.get(i).courseName = in.nextLine();
												break;
										case 2: System.out.print("Enter the revised Course Fees for "+courseArray.get(i).courseName+" : ");
												in.reset();
												//String newCourseFees = in.nextLine();
												courseArray.get(i).courseFee = in.nextLine();
												break;
										case 3: System.out.print("Enter the new Start Date for "+courseArray.get(i).courseName+" : ");
												in.reset();
												//String newStartDate = in.nextLine();
												courseArray.get(i).startDate = in.nextLine();
												break;
										case 4: System.out.print("Enter the revised Course Duration for "+courseArray.get(i).courseName+" : ");
												in.reset();
												//String newCourseDuration = in.nextLine();
												courseArray.get(i).courseDuration = in.nextLine();
												break;
										case 5: System.out.println("All Changes successfully Saved!!");
												System.out.println("Exiting Edit Mode...\n");
												select = false;
												break;
										default: System.out.println("Invalid Choice.Please Try Again");
												 break;
									}
								}
							}
						}
						break;
				case 4: break;
				case 5: break;
				case 6: break;
				case 7: System.out.println("The following courses have been created so far:");
						int k = 0;
						while(k<courseArray.size()){
							System.out.println("Serial Number :"+(k+1));
							System.out.println("	Course Name : "+courseArray.get(k).courseName);
							System.out.println("	Course Fee : "+courseArray.get(k).courseFee);
							System.out.println("	Course Start Date : "+courseArray.get(k).startDate);
							System.out.println("	Course Duration : "+courseArray.get(k).courseDuration);
							System.out.println("\n	Course Co-ordinator : "+courseArray.get(k).courseCoordinator.facultyName);
							System.out.println("		Department : "+courseArray.get(k).courseCoordinator.affiliatedDepartment);
							System.out.println("		Address : "+courseArray.get(k).courseCoordinator.facultyAddress);
							System.out.println("		Mobile Number : "+courseArray.get(k).courseCoordinator.mobile);
							System.out.println("		E-mail : "+courseArray.get(k).courseCoordinator.email);
							System.out.println("	The Course, "+courseArray.get(k).courseName+" has the following Faculty Members as Instructors");
							int j = 0;
							while(j< courseArray.get(k).facultylist.size()){
								System.out.println("	Faculty Name : "+courseArray.get(k).facultylist.get(j).facultyName);
								System.out.println("		Department : "+courseArray.get(k).facultylist.get(j).affiliatedDepartment);
								System.out.println("		Address : "+courseArray.get(k).facultylist.get(j).facultyAddress);
								System.out.println("		Mobile Number : "+courseArray.get(k).facultylist.get(j).mobile);
								System.out.println("		E-mail Address : "+courseArray.get(k).facultylist.get(j).email);
								j++;
							}
							System.out.println("	The Course, "+courseArray.get(k).courseName+" has the following Participants enrolled.");
							j=0;
							while(j< courseArray.get(k).participantlist.size()){
								System.out.println("	Participant Name : "+courseArray.get(k).participantlist.get(j).participantName);
								System.out.println("		Organisation : "+courseArray.get(k).participantlist.get(j).participantOrganisation);
								System.out.println("		Address : "+courseArray.get(k).participantlist.get(j).participantAddress);
								System.out.println("		Mobile Number : "+courseArray.get(k).participantlist.get(j).participantMobile);
								System.out.println("		E-mail Address : "+courseArray.get(k).participantlist.get(j).participantEmail);
								j++;
							}
							k++;
							System.out.println(" ");
						}
						break;
				case 8: value = false;
						in.close();
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					         System.out.println("Serialized data is saved in shorttermcoursemanagement.ser");
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
