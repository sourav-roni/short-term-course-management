The Project named Short_Term_Course_Management contains the required java file
for the Project. I have implemented the project with the help of three classes 
namely Faculty, Participant and Courses apart from a main class named 
Coursemanagement.The faculty class has the fields such as affiliatedDepartment,
facultyName, facultyAddress, mobile, email which are all Strings.The Participant
class has fields participantName, participantAddress, participantMobile,
participantOrganisation, participantEmail which are all Strings. The Course class
has the fields of courseName, courseFee, startDate, courseDuration which are Strings.
The Course class also has an integer field named instructorCount. It also has an 
object of the class Faculty which acts as the Course co-ordinator. Apart from these 
there are two array lists one foe storing instances of Faculty named facultylist 
and the other named participantlist for storing instances of the participant class.
Apart from all these fields all the above mentioned classes have Scanners which 
have been marked as transient so that the class is serilalizable. The main class
also declares a scanner and an array list for storing the instances of the course
class.For every class where there is need to enter mobile number it is checked using
Regular Expressions.

Apart from the above mentioned fields all the class have some or the other method
implemented. Both faculty and participants have methods defined facultyCreator and
participantCreator to initialise instances with user input. There are no restrictions
in the input entered as all the data types used are strings. So the user must be 
careful while entering the inputs as invalid entries would not be checked. The 
course class also has a courseCreator method for creating instances of Courses.
The course class also has a method named dateCompare which is used to ensure that 
for a particular year no ,more than 10 courses are created. The dateCompare function 
is called from the courseConstructor once the user enters a valid date. Thereafter
decisions are taken based on the boolean value returned by the method.

The main method makes use of Switch cases to execute user choices. There are even 
instances  of nested switches. The options are displayed everytime the loop executes
for the convenience of the user. The number beside the option corresponds to the 
correct choice number. Several checks are made to ensure that a course can have 
atmost 5 faculty as instructors and atmost 5 participants.As far the main class is
concerned only one main method has been implemented. As the program execution starts 
the stored arraylist of courses is copied from the existing file. After the user
creates a course or after he creates a faculty, participant  etc the data is written
on to the file. Even after deleting the objects appropriate update steps have been 
taken. Not only that in the option for save and exit we save the data into a file
named "shorttermcoursemanagement" and finally the control goes out of the main program.  
