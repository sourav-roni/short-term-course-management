import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.lang.NullPointerException;

//Here is the beginning of the main class
@SuppressWarnings("unused")
public class Coursemanagement{
	public static Scanner in1;
	public static ArrayList<Course> courseArray = new ArrayList<Course>(10);
	@SuppressWarnings("unchecked")
	//beginning of main method
	public static void main(String []args) throws IOException,NullPointerException{
		System.out.println("Hello!");
		System.out.println("Welcome to IIT Kharagpur : Short Term Course Management");
		in1 = new Scanner(System.in);
		int choice = 0;
		boolean value = true;
		//ArrayList<Course> courseArray = new ArrayList<Course>(10);
		//a try and catch for reading from the file in which the earlier data was saved
		try
	      {
	         FileInputStream fileIn = new FileInputStream("shorttermcoursemanagement");
	         ObjectInputStream input = new ObjectInputStream(fileIn);
	         courseArray = (ArrayList<Course>) input.readObject();
	         try {
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
	         try {
				fileIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
	      }catch(FileNotFoundException a)
	      {
	         //System.out.println("OOPs!! File Not Found");
	      }catch(ClassNotFoundException c)
	      {
	         //System.out.println("ArrayList<Course> class not found");
	         //c.printStackTrace();
	         return;
	      }
		//defining a scanner for taking input from the user
		Scanner in = new Scanner(System.in);
		while(value){
			//to display the user the various options available to him
			System.out.println("Enter your choice:");
			System.out.println("1-Create a new Course and display all Courses");
			System.out.println("2-Create a new Faculty for a Course and display all its Instructors");
			System.out.println("3-Create a new Participant for a Course and display all its Registered Participants");
			System.out.println("4-Alter details of Courses");
			System.out.println("5-Alter details of Course Co-ordinator");
			System.out.println("6-Alter details of Faculty");
			System.out.println("7-Alter details of Participants");
			System.out.println("8-Display all Courses Created in the past one year");
			System.out.println("9-Display all Courses Created so far");
			System.out.println("10-Save and exit\n");
			try {
				choice = Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			//beginning of switch cases to implement user choice
			switch(choice){
				case 1: if(courseArray.size()>=0){
							Course c = new Course();
							boolean created = true;
							created = c.courseCreator();
							//checking whether the course can be added or not depending on the one year constraint 
							if(created==true){
								courseArray.add(c);
							}
							try
						      {
						         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
						         ObjectOutputStream out = new ObjectOutputStream(fileOut);
						         out.writeObject(courseArray);
						         out.flush();
						         out.close();
						         fileOut.close();
						      }catch(IOException exe)
						      {
						          //exe.printStackTrace();
						      }
							System.out.println("The following courses have been created so far:");
							int i = 0;
							while(i<courseArray.size()){
								System.out.println("Serial Number :"+(i+1));
								System.out.println("	Course Name : "+courseArray.get(i).courseName);
								System.out.println("	Course Fee : "+courseArray.get(i).courseFee);
								System.out.println("	Course Start Date : "+courseArray.get(i).startDate);
								System.out.println("	Course Duration : "+courseArray.get(i).courseDuration);
								System.out.println("\n	Course Co-ordinator : "+courseArray.get(i).courseCoordinator.facultyName);
								System.out.println("		Department : "+courseArray.get(i).courseCoordinator.affiliatedDepartment);
								System.out.println("		Address : "+courseArray.get(i).courseCoordinator.facultyAddress);
								System.out.println("		Mobile Number : "+courseArray.get(i).courseCoordinator.mobile);
								System.out.println("		E-mail : "+courseArray.get(i).courseCoordinator.email);
								int j = 0;
								if(courseArray.get(i).facultylist.size()>0){
									System.out.println("	The course, "+courseArray.get(i).courseName+" has the following Faculty Members as Instructors");
								}
								while(j< courseArray.get(i).facultylist.size()){
									System.out.println("	Faculty Name : "+courseArray.get(i).facultylist.get(j).facultyName);
									System.out.println("		Department : "+courseArray.get(i).facultylist.get(j).affiliatedDepartment);
									System.out.println("		Address : "+courseArray.get(i).facultylist.get(j).facultyAddress);
									System.out.println("		Mobile Number : "+courseArray.get(i).facultylist.get(j).mobile);
									System.out.println("		E-mail Address : "+courseArray.get(i).facultylist.get(j).email);
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
								System.out.println("	Course Name : "+courseArray.get(i).courseName);
								System.out.println("	Course Fee : "+courseArray.get(i).courseFee);
								System.out.println("	Course Start Date : "+courseArray.get(i).startDate);
								System.out.println("	Course Duration : "+courseArray.get(i).courseDuration);
								System.out.println("\n	Course Co-ordinator : "+courseArray.get(i).courseCoordinator.facultyName);
								System.out.println("		Department : "+courseArray.get(i).courseCoordinator.affiliatedDepartment);
								System.out.println("		Address : "+courseArray.get(i).courseCoordinator.facultyAddress);
								System.out.println("		Mobile Number : "+courseArray.get(i).courseCoordinator.mobile);
								System.out.println("		E-mail : "+courseArray.get(i).courseCoordinator.email);
								int j = 0;
								if(courseArray.get(i).facultylist.size()>0){
									System.out.println("	The course, "+courseArray.get(i).courseName+" has the following Faculty Members as Instructors");
								}
								while(j< courseArray.get(i).facultylist.size()){
									System.out.println("	Faculty Name : "+courseArray.get(i).facultylist.get(j).facultyName);
									System.out.println("		Department : "+courseArray.get(i).facultylist.get(j).affiliatedDepartment);
									System.out.println("		Address : "+courseArray.get(i).facultylist.get(j).facultyAddress);
									System.out.println("		Mobile Number : "+courseArray.get(i).facultylist.get(j).mobile);
									System.out.println("		E-mail Address : "+courseArray.get(i).facultylist.get(j).email);
									j++;
								}
								i++;
								System.out.println(" ");
							}
							System.out.println("Sorry. No more Courses can be created\n");
						}
						break;
				case 2: System.out.print("Enter the Course for which you want to add Faculty Members : ");
						String facAdd = in.nextLine();
						int var =0;
						while(var<courseArray.size()){
							if(courseArray.get(var).courseName.equals(facAdd)==true){
								break;
							}
							var++;
						}
						if(var<courseArray.size()){
							//checking whether new faculty can be added or not into the desired course
							if(courseArray.get(var).facultylist.size()<5){
								Faculty newFaculty = new Faculty();
								newFaculty.facultyCreator();
								courseArray.get(var).facultylist.add(newFaculty);
								try
							      {
							         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
							         ObjectOutputStream out = new ObjectOutputStream(fileOut);
							         out.writeObject(courseArray);
							         out.flush();
							         out.close();
							         fileOut.close();
							      }catch(IOException exe)
							      {
							          //exe.printStackTrace();
							      }
								int p=0;
								System.out.println("\nThe Course, "+facAdd+" has successfully added another Faculty");
								System.out.println("The following Faculty are now Instructors for the Course "+facAdd);
								while(p!=courseArray.get(var).facultylist.size()){
									System.out.println("Faculty Name : "+courseArray.get(var).facultylist.get(p).facultyName);
									System.out.println("	Department : "+courseArray.get(var).facultylist.get(p).affiliatedDepartment);
									System.out.println("	Address : "+courseArray.get(var).facultylist.get(p).facultyAddress);
									System.out.println("	Mobile Number : "+courseArray.get(var).facultylist.get(p).mobile);
									System.out.println("	E-mail Address : "+courseArray.get(var).facultylist.get(p).email);
									p++;
								}
								System.out.println(" ");
							}
							else{
								System.out.println("Sorry. The Course already has 5 Instructors. Cannot add more.\n");
							}
						}
						else{
							System.out.println("Sorry. Invalid Choice. \n");
						}
						break;
				case 3: System.out.print("Please enter the Course for which you want to create new Participants : ");
						String courseChoice = in1.nextLine();
						int i = 0;
						for(i=0;i<courseArray.size();i++){
							if(courseArray.get(i).courseName.equals(courseChoice) == true){
								//System.out.println("Oh Yes!");
								break;
							}
						}
						if(i<courseArray.size()){
							//checking whether new participant can be added or not into the desired course
							if(courseArray.get(i).participantlist.size()<5){
								Participant part = new Participant();
								part.participantCreator();
								courseArray.get(i).participantlist.add(part);
								try
							      {
							         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
							         ObjectOutputStream out = new ObjectOutputStream(fileOut);
							         out.writeObject(courseArray);
							         out.flush();
							         out.close();
							         fileOut.close();
							      }catch(IOException exe)
							      {
							          //exe.printStackTrace();
							      }
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
						}
						else{
							System.out.println("Sorry. Invalid Choice.\n ");
						}
						break;
				case 4: System.out.print("\nEnter the name of the Course which you want to alter : ");
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
						if(i<courseArray.size()){
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
									int editChoice = 0;
									try {
										editChoice = Integer.parseInt(in1.nextLine());
									} catch (NumberFormatException e) {
										// TODO Auto-generated catch block
										//e.printStackTrace();
									}
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
						else{
							System.out.println("Sorry. Invalid Choice. \n");
						}
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					      }catch(IOException exe)
					      {
					          //exe.printStackTrace();
					      }
						break;
				case 5: System.out.print("Enter the name of the Course whose Course Co-ordinator's details you want to alter : ");
						String courseCoEdit = in.nextLine();
						int d = 0;
						while(d<courseArray.size()){
							if(courseCoEdit.equals(courseArray.get(d).courseName)){
								break;
							}
							d++;
						}
						if(d<courseArray.size()){
							System.out.println("Entering Edit Mode...");
							boolean coordinatorEdit = true;
							while(coordinatorEdit){
								System.out.println("Please Enter your Choice");
								System.out.println("1-Change Name of "+courseArray.get(d).courseCoordinator.facultyName);
								System.out.println("2-Change Department for "+courseArray.get(d).courseCoordinator.facultyName);
								System.out.println("3-Change Address for "+courseArray.get(d).courseCoordinator.facultyName);
								System.out.println("4-Change Mobile Number for "+courseArray.get(d).courseCoordinator.facultyName);
								System.out.println("5-Change E-mail ID for "+courseArray.get(d).courseCoordinator.facultyName);
								System.out.println("6-Save and Exit");
								int userChoice = 0;
								try {
									userChoice = Integer.parseInt(in.nextLine());
								} catch (NumberFormatException e) {
									// TODO Auto-generated catch block
									//e.printStackTrace();
								}
								switch(userChoice){
									case 1:	System.out.print("Enter new Name for "+courseArray.get(d).courseCoordinator.facultyName+" : ");
											courseArray.get(d).courseCoordinator.facultyName = in.nextLine();
											break;
									case 2:	System.out.print("Enter new Department for "+courseArray.get(d).courseCoordinator.facultyName+" : ");
											courseArray.get(d).courseCoordinator.affiliatedDepartment = in.nextLine();
											break;
									case 3:	System.out.print("Enter new Address for "+courseArray.get(d).courseCoordinator.facultyName+" : ");
											courseArray.get(d).courseCoordinator.facultyAddress = in.nextLine();
											break;
									case 4:	System.out.print("Enter new Mobile Number for "+courseArray.get(d).courseCoordinator.facultyName+" : ");
											courseArray.get(d).courseCoordinator.mobile = in.nextLine();
											break;
									case 5:	System.out.print("Enter new E-mail Address for "+courseArray.get(d).courseCoordinator.facultyName+" : ");
											courseArray.get(d).courseCoordinator.email = in.nextLine();
											break;
									case 6:	System.out.println("All changes successfully Saved");
											System.out.println("Exiting Editing Mode...");
											coordinatorEdit = false;
											break;
									default: System.out.println("Invalid Choice. Please Try Again. ");
											 break;
								}
							}
						}
						else{
							System.out.println("Sorry. Invalid Choice. \n");
						}
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					      }catch(IOException exe)
					      {
					          //exe.printStackTrace();
					      }
						break;
				case 6: System.out.print("Enter the Name of the Course for which you want to Change the details of the Faculty : ");
						String courseFacEdit = in.nextLine();
						int fac = 0;
						while(fac<courseArray.size()){
							if(courseFacEdit.equals(courseArray.get(fac).courseName)){
								break;
							}
							fac++;
						}
						if(fac<courseArray.size()){
							if(courseArray.get(fac).facultylist.size()>0){
								int var1;
								System.out.println("The Course "+courseFacEdit+" has the following Faculty Members as Instructors:");
								for(var1=0;var1<courseArray.get(fac).facultylist.size();var1++){
									System.out.println(courseArray.get(fac).facultylist.get(var1).facultyName);
								}
								System.out.print("Enter the name of the Faculty member whose Details are to be Edited : ");
								String facChoice = in.nextLine();
								var1=0;
								while(var1<courseArray.get(fac).facultylist.size()){
									if(courseArray.get(fac).facultylist.get(var1).facultyName.equals(facChoice)){
										break;
									}
									var1++;
								}
								if(var1<courseArray.get(fac).facultylist.size()){
									System.out.println("Entering Edit Mode...");
									boolean facAlter = true ;
									while(facAlter){
										System.out.println("Please Enter your Choice:");
										System.out.println("1-Change Name of "+courseArray.get(fac).facultylist.get(var1).facultyName);
										System.out.println("2-Change Department for "+courseArray.get(fac).facultylist.get(var1).facultyName);
										System.out.println("3-Change Address of "+courseArray.get(fac).facultylist.get(var1).facultyName);
										System.out.println("4-Change Mobile Number for "+courseArray.get(fac).facultylist.get(var1).facultyName);
										System.out.println("5-Change E-mail Address for "+courseArray.get(fac).facultylist.get(var1).facultyName);
										System.out.println("6-Save and Exit");
										int facultyChoice = 0;
										try {
											facultyChoice = Integer.parseInt(in.nextLine());
										} catch (NumberFormatException e) {
											// TODO Auto-generated catch block
											//e.printStackTrace();
										}
										switch(facultyChoice){
											case 1: System.out.print("Enter new Name for "+courseArray.get(fac).facultylist.get(var1).facultyName+" : ");
													courseArray.get(fac).facultylist.get(var1).facultyName = in.nextLine();
													break;
											case 2: System.out.print("Enter new Department for "+courseArray.get(fac).facultylist.get(var1).facultyName+" : ");
													courseArray.get(fac).facultylist.get(var1).affiliatedDepartment = in.nextLine();
													break;
											case 3: System.out.print("Enter new Address for "+courseArray.get(fac).facultylist.get(var1).facultyName+" : ");
													courseArray.get(fac).facultylist.get(var1).facultyAddress = in.nextLine();
													break;
											case 4: System.out.print("Enter new Mobile Number for "+courseArray.get(fac).facultylist.get(var1).facultyName+" : ");
													courseArray.get(fac).facultylist.get(var1).mobile = in.nextLine();
													break;
											case 5: System.out.print("Enter new E-mail Address for "+courseArray.get(fac).facultylist.get(var1).facultyName+" : ");
													courseArray.get(fac).facultylist.get(var1).email = in.nextLine();
													break;
											case 6: System.out.println("All Changes Successfully Saved");
													System.out.println("Exiting Edit Mode ");
													facAlter = false;
													break;
											default: System.out.println("Sorry. Invalid Choice. Try Again. ");
													break;
										}
									}
								}
								else{
									System.out.println("Sorry. Invalid Entry. \n");
								}
							}
							else{
								System.out.println("Sorry. The Course "+courseFacEdit+" has no Instructors yet. Please create Instructors first.\n");
							}
						}
						else{
							System.out.println("Sorry. Invalid Choice. \n");
						}
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					      }catch(IOException exe)
					      {
					          //exe.printStackTrace();
					      }
						break;
				case 7: System.out.print("Enter the Name of the Course for which you want to Change the details of the Participants : ");
						String partEdit = in.nextLine();
						int part = 0;
						while(part<courseArray.size()){
							if(partEdit.equals(courseArray.get(part).courseName)){
								break;
							}
							part++;
						}
						if(part<courseArray.size()){
							if(courseArray.get(part).participantlist.size()>0){
								int var1;
								System.out.println("The Course "+partEdit+" has the following Participants enrolled :");
								for(var1=0;var1<courseArray.get(part).participantlist.size();var1++){
									System.out.println(courseArray.get(part).participantlist.get(var1).participantName);
								}
								System.out.print("Enter the name of the Participant whose Details are to be Edited : ");
								String partChoice = in.nextLine();
								var1=0;
								while(var1<courseArray.get(part).participantlist.size()){
									if(courseArray.get(part).participantlist.get(var1).participantName.equals(partChoice)){
										break;
									}
									var1++;
								}
								if(var1<courseArray.get(part).participantlist.size()){
									System.out.println("Entering Edit Mode...");
									boolean partAlter = true ;
									while(partAlter){
										System.out.println("Please Enter your Choice:");
										System.out.println("1-Change Name of "+courseArray.get(part).participantlist.get(var1).participantName);
										System.out.println("2-Change Organisation for "+courseArray.get(part).participantlist.get(var1).participantName);
										System.out.println("3-Change Address of "+courseArray.get(part).participantlist.get(var1).participantName);
										System.out.println("4-Change Mobile Number for "+courseArray.get(part).participantlist.get(var1).participantName);
										System.out.println("5-Change E-mail Address for "+courseArray.get(part).participantlist.get(var1).participantName);
										System.out.println("6-Save and Exit");
										int participantChoice = 0;
										try {
											participantChoice = Integer.parseInt(in.nextLine());
										} catch (NumberFormatException e) {
											// TODO Auto-generated catch block
											//e.printStackTrace();
										}
										switch(participantChoice){
											case 1: System.out.print("Enter new Name for "+courseArray.get(part).participantlist.get(var1).participantName+" : ");
													courseArray.get(part).participantlist.get(var1).participantName = in.nextLine();
													break;
											case 2: System.out.print("Enter new Organisation for "+courseArray.get(part).participantlist.get(var1).participantName+" : ");
													courseArray.get(part).participantlist.get(var1).participantOrganisation = in.nextLine();
													break;
											case 3: System.out.print("Enter new Address for "+courseArray.get(part).participantlist.get(var1).participantName+" : ");
													courseArray.get(part).participantlist.get(var1).participantAddress = in.nextLine();
													break;
											case 4: System.out.print("Enter new Mobile Number for "+courseArray.get(part).participantlist.get(var1).participantName+" : ");
													courseArray.get(part).participantlist.get(var1).participantMobile = in.nextLine();
													break;
											case 5: System.out.print("Enter new E-mail Address for "+courseArray.get(part).participantlist.get(var1).participantName+" : ");
													courseArray.get(part).participantlist.get(var1).participantEmail = in.nextLine();
													break;
											case 6: System.out.println("All Changes Successfully Saved");
													System.out.println("Exiting Edit Mode ");
													partAlter = false;
													break;
											default: System.out.println("Sorry. Invalid Choice. Try Again. ");
													break;
										}
									}
								}
								else{
									System.out.println("Sorry. Invalid Entry.\n");
								}
							}
							else{
								System.out.println("Sorry. The Course "+partEdit+" has no Participants yet. Please create Participants first.\n");
							}
						}
						else{
							System.out.println("Sorry. Invalid Choice.\n ");
						}
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					      }catch(IOException exe)
					      {
					          //exe.printStackTrace();
					      }
						break;
				case 8: boolean dateSelect = true;
						SimpleDateFormat fdate = new SimpleDateFormat("dd/MM/yyyy");
						Calendar calendar = Calendar.getInstance();
						while(dateSelect){
							System.out.print("Please Enter The Date(in DD/MM/YYYY Format) : ");
							String dateChoice = in.nextLine();
							try {
								calendar.setTime(fdate.parse(dateChoice));
								dateSelect = false;
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								System.out.println("Sorry. Incorrect Date Format. Please Enter Again.");
								//e.printStackTrace();
							}
						}
						Calendar calendarPast = (Calendar) calendar.clone();
						calendarPast.add(Calendar.YEAR, -1);
						//System.out.println("Year = " + calendar.get(Calendar.YEAR));
			            //System.out.println("Month = " + calendar.get(Calendar.MONTH));
			            //System.out.println("Day = " + calendar.get(Calendar.DAY_OF_MONTH));
			            //System.out.println("Year = " + calendarPast.get(Calendar.YEAR));
			            //System.out.println("Month = " + calendarPast.get(Calendar.MONTH));
			            //System.out.println("Day = " + calendarPast.get(Calendar.DAY_OF_MONTH));
						int m=0,b=0;
						while(m<courseArray.size()){
							//System.out.println(" "+m+" ");
							//System.out.println();
							//System.out.println();
							if(courseArray.get(m).courseStartDate.getTime().after(calendarPast.getTime())&&courseArray.get(m).courseStartDate.getTime().before(calendar.getTime())){
								if(b==0){
									System.out.println("The following Courses were created during the past one year :\n");
									b=1;
								}
								System.out.println("Course Name: "+courseArray.get(m).courseName);
								System.out.println("	Course Fees: "+courseArray.get(m).courseFee);
								System.out.println("	Course Start Date: "+courseArray.get(m).startDate);
								System.out.println("	Course Duration: "+courseArray.get(m).courseDuration);
								System.out.println("	Course Co-ordinator : "+courseArray.get(m).courseCoordinator.facultyName);
								System.out.println("		Department : "+courseArray.get(m).courseCoordinator.affiliatedDepartment);
								System.out.println("		Address : "+courseArray.get(m).courseCoordinator.facultyAddress);
								System.out.println("		Mobile Number : "+courseArray.get(m).courseCoordinator.mobile);
								System.out.println("		E-mail : "+courseArray.get(m).courseCoordinator.email);
								int j = 0;
								if(courseArray.get(m).facultylist.size()>0){
									System.out.println("	The course, "+courseArray.get(m).courseName+" has the following Faculty Members as Instructors");
								}
								while(j< courseArray.get(m).facultylist.size()){
									System.out.println("	Faculty Name : "+courseArray.get(m).facultylist.get(j).facultyName);
									System.out.println("		Department : "+courseArray.get(m).facultylist.get(j).affiliatedDepartment);
									System.out.println("		Address : "+courseArray.get(m).facultylist.get(j).facultyAddress);
									System.out.println("		Mobile Number : "+courseArray.get(m).facultylist.get(j).mobile);
									System.out.println("		E-mail Address : "+courseArray.get(m).facultylist.get(j).email);
									j++;
								}
								j=0;
								if(courseArray.get(m).participantlist.size()>0){
									System.out.println("	The course, "+courseArray.get(m).courseName+" has the following Participants enrolled.");
								}
								while(j< courseArray.get(m).participantlist.size()){
									System.out.println("	Participant Name : "+courseArray.get(m).participantlist.get(j).participantName);
									System.out.println("		Organisation : "+courseArray.get(m).participantlist.get(j).participantOrganisation);
									System.out.println("		Address : "+courseArray.get(m).participantlist.get(j).participantAddress);
									System.out.println("		Mobile Number : "+courseArray.get(m).participantlist.get(j).participantMobile);
									System.out.println("		E-mail Address : "+courseArray.get(m).participantlist.get(j).participantEmail);
									j++;
								}

								//System.out.println("OK");
							}
							m++;
						}
						if(b==0){
							System.out.println("Sorry. No Courses were created during the past one year.\n");
						}
						break;
				case 9: System.out.println("The following courses have been created so far:");
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
							int j = 0;
							if(courseArray.get(k).facultylist.size()>0){
								System.out.println("	The course, "+courseArray.get(k).courseName+" has the following Faculty Members as Instructors");
							}
							while(j< courseArray.get(k).facultylist.size()){
								System.out.println("	Faculty Name : "+courseArray.get(k).facultylist.get(j).facultyName);
								System.out.println("		Department : "+courseArray.get(k).facultylist.get(j).affiliatedDepartment);
								System.out.println("		Address : "+courseArray.get(k).facultylist.get(j).facultyAddress);
								System.out.println("		Mobile Number : "+courseArray.get(k).facultylist.get(j).mobile);
								System.out.println("		E-mail Address : "+courseArray.get(k).facultylist.get(j).email);
								j++;
							}
							j=0;
							if(courseArray.get(k).participantlist.size()>0){
								System.out.println("	The course, "+courseArray.get(k).courseName+" has the following Participants enrolled.");
							}
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
				case 10:value = false;
						in.close();
						try
					      {
					         FileOutputStream fileOut = new FileOutputStream("shorttermcoursemanagement");
					         ObjectOutputStream out = new ObjectOutputStream(fileOut);
					         out.writeObject(courseArray);
					         out.flush();
					         out.close();
					         fileOut.close();
					         System.out.println("\nAll Changes have been Saved Succcessfully!!");
					         System.out.println("Thank You");
					      }catch(IOException exe)
					      {
					          //exe.printStackTrace();
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
	//function to create an instance of the class faculty
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
	//function to create an instance of the class participant
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
	transient SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
	Calendar courseStartDate = Calendar.getInstance();
	String courseDuration;
	Faculty courseCoordinator = new Faculty();
	int instructorCount;
	//int participantCount;
	//Faculty []facultyList;
	//Participant []participantList;
	ArrayList<Faculty> facultylist = new ArrayList<Faculty>(5);
	ArrayList<Participant> participantlist = new ArrayList<Participant>(5);
	transient private Scanner in;
	//this function has been created to check the one year constraint 
	public boolean dateCompare(int userDate){
		boolean decision = true;
		int var1 = 0;
		int count = 0;
		while(var1<Coursemanagement.courseArray.size()){
			//System.out.println(var1);
			//System.out.println(	Coursemanagement.courseArray.get(var1).courseStartDate.get(Calendar.YEAR));
			//System.out.println(userDate);
			if(Coursemanagement.courseArray.get(var1).courseStartDate.get(Calendar.YEAR)==userDate){
				count++;
				//System.out.println(" " +count);
				if(count==10){
					return false;
				}
			}
			var1++;
		}
		return decision;
	}
	//function to create an instance of the class course
	public boolean courseCreator() {
		in = new Scanner(System.in);
		System.out.print("Enter the Name of the Course : ");
		this.courseName = in.nextLine();
		System.out.print("Enter the Couse Fee(in Rupees) : ");
		this.courseFee = in.nextLine();
		boolean date = true;
		while(date){
			System.out.print("Enter the Start Date(in DD/MM/YYYY Format) : ");
			this.startDate= in.nextLine();
			try {
				this.courseStartDate.setTime(datef.parse(this.startDate));
				//System.out.println("OhYes");
				boolean decided = dateCompare(this.courseStartDate.get(Calendar.YEAR));
				if(decided==true){
					date = false;
				}
				else{
					System.out.println("Already 10 Courses have been created for the same Year");
					System.out.print("Would you like to create the course for another Year? [Y/N] : ");
					String createChoice = in.nextLine();
					if(createChoice.equalsIgnoreCase("Y")){
						date = true;
					}
					else{
						return false;
					}
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Sorry. Incorrect Date Format. Please Enter Again.");
				//e.printStackTrace();
			}
		}
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
		System.out.print("\nEnter the number of Faculty Members as Instructors for the Course : ");
		try {
			this.instructorCount = Integer.parseInt(in.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid Choice.");
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		int count = this.instructorCount;
		while(count!=0){
			Faculty fac = new Faculty();
			fac.facultyCreator();
			this.facultylist.add(fac);
			count--;
			System.out.println(" ");
		}
		return true;
		//in.close();
	}
}
