
package edu.ru.Main;

import java.io.* ;
import java.util.List;
import java.util.* ;

class Teacher{                   //Teacher class contains the info of teacher
    String name;                 //Teacher's name
    String subject;             //Subject that teacher is teaching
    Teacher(String name,String subject){        //Constructor
        this.name = name;
        this.subject = subject;
    }
}
class Test{
    int testNo ;            //Test no. of specific subject
    Teacher tchr ;          //Teacher that is taking that test
    Test(int testNo,Teacher tchr){  //Constructor of Test class
        this.testNo = testNo ;
        this.tchr = tchr ;
    }
}
class Student{          //Student class contains the student info
    String name;            //Student's name
    double grade ;          //Student's rade that he achieves in specific test
    Test tst ;              //Specific test that student gives
    Student(String name,double grade,Test tst){         //Constructor of student class
        this.name = name ;
        this.grade = grade ;
        this.tst = tst ;
    }
}

class AvgStudent{       //Avg Student class contains the info of every student's average marks
    String stdName ;        //Student's name
    double avgGrades ;      //Average grades of specific student
    AvgStudent(String sname,double avg){    //Constructor of AvgStudent class
        this.stdName = sname ;
        this.avgGrades = avg ;
    }
}

class AvgTest{      //Contains the info of each test's average grade
    int testNo ;       //Test no. of a subject
    String subject;     //specific subject
    double avgGrades ;      //Average grdes in specific test in specific subject
    AvgTest(int testNo,String subject,double avgGrades){        //Constructor of avgTest
        this.testNo = testNo ;
        this.subject = subject;
        this.avgGrades = avgGrades ;
    }
}

public class Main{          //Main class contains MainMethod
    static char findGrade(double grades){           //Method to find grade leter from percentage
            if(grades>=90){              //Above 90% gets A grade
                return 'A' ;
            }else if(grades>=80){        //Above 80% and below 90% gets B grade
                return 'B' ;
            }else if(grades>=70){        //Above 70 and below 80% gets C Grade
                return 'C' ;
            }else if(grades>=60){        //Above 60 and below 70% gets D Grade
                return 'D' ;    
            }else{                      //All others gets F grade
                return 'F' ;
            }
    }
    static List<Student> readFile(){            //Method to read files and store in Student List
           List<Student> std = new ArrayList<Student>();    //Students list
           FileReader fr = null ;       //File reader to read file
           BufferedReader br = null ;   //Buffer for dile reader
           String inputLine = "" ;      //Variable to store one line of file
           try {
               File tmp = new File("Test.txt") ;        //Creating object of file
               if(!tmp.exists()){                   //Check if file doesn't exists
                    tmp.createNewFile();            //Creating file
               }
               fr = new FileReader("Test.txt");     //File info
               br = new BufferedReader(fr);         //Opening file
               inputLine = br.readLine();           //Read one line and store in var
               while (inputLine!=null){             //Loop will iterate until it gets null value
                   String[] ss = inputLine.split(",");  //Breaks the line in values of object
                   Teacher tchr = new Teacher(ss[3],ss[2]) ;       //Creating object of teacher
                   Test tst = new Test(Integer.parseInt(ss[1]),tchr);   //Creating object of test
                   Student stud = new Student(ss[0],Double.parseDouble(ss[4]),tst) ;    //Object of student class
                   std.add(stud) ;      //Adding student object to the list of students
                   inputLine = br.readLine();   //Again reads next line
               }
               fr.close();      //Closing the reading end
               br.close();      //Closing the buffer
           }
           catch(IOException ie){
               System.out.print(ie.getMessage()) ;
           }
           return std ;   //Returns the student's list
       }
    static void writeFile(List<Student> std){  //Method to write to a file
           FileWriter fw = null ;           // File writer
           PrintWriter pw = null ;          //Printer to write into the file
           try
           {
               fw = new FileWriter("Test.txt") ;   //File info to open a file
               pw = new PrintWriter(fw) ;
               for(Student stdnt: std ){        //Loop will iterate to write all info of students in file one by one
                   pw.println(stdnt.name +","+ stdnt.tst.testNo +","+  stdnt.tst.tchr.subject +","+  stdnt.tst.tchr.name +","+  stdnt.grade );
               }
               pw.flush() ;
               pw.close() ;     //closing the printer
               fw.close() ;     //Closing the writing end
           }
           catch(IOException ie) {
               System.out.print(ie.getMessage());
           }
       }
    static void calcAvgClass(List<Student> std){
            Boolean found = false ;     //Boolean to check whether repetition exists in a list or not
            List<AvgStudent> average = new ArrayList<AvgStudent>() ;        //List of averages of students
            int count = 0 ;             //Count the repetitions of one student
            double avg = 0 ;            //Stores the sum of grades of one student
            for(Student sstd : std){       //Outer loop to iterate through all values of list of students
                count = 0 ;
                avg = 0 ;
                found = false ;
                for(Student sstd1 : std){       //inner loop to iterate through all values of list of students
                    if(sstd.name.equals(sstd1.name)){       //Checks if both names are same
                        count++ ;           //Count increase by one
                        avg += sstd1.grade;     //Sum increase by grade that student gets in current test
                    }
                }
                for(AvgStudent aveg: average){      //This loop is to check for duplicates
                    if(aveg.stdName.equals(sstd.name)){
                        found = true ;
                    }
                }
                if(!found){         //Avoid from duplicates
                    average.add(new AvgStudent(sstd.name,(avg/count)));  //Adding to average list of unique students
                }
            }
            count = 0 ;
            avg = 0 ;
            for(AvgStudent aa:average){         //This loop is to take average of all students
                count++ ;
                avg+=aa.avgGrades ;
            }
            System.out.println("Average Class Grade: " + findGrade(avg/count) );        //printing the averaga
        }
    static void calcAvgTest(List<Student> std){
            Boolean found = false ;         //Boolean to check for repititions
            List<AvgTest> average = new ArrayList<AvgTest>() ;      //To store averages of Test list
            int count = 0 ;     //Count for tests repitions
            double avg = 0 ;    //Variable to store grades of test
            for(Student sstd : std){        //outer loop to iterate through student list
                count = 0 ;
                avg = 0 ;
                found = false ;
                for(Student sstd1 : std){       //inner loop to iterate through student list
                    if((sstd.tst.testNo==sstd1.tst.testNo)&&(sstd1.tst.tchr.subject.equals(sstd.tst.tchr.subject))){ //checks if both objects have same subject and test no.
                        count++ ;   //The increase count
                        avg += sstd1.grade; //Increase the average value
                    }
                }
                for(AvgTest aveg: average){     //loop to check for duplicates
                    if((sstd.tst.testNo==aveg.testNo)&&(sstd.tst.tchr.subject.equals(aveg.subject))){
                        found = true ;
                    }
                }
                if(!found){         //Condition to avoid from adding duplicates
                    average.add(new AvgTest(sstd.tst.testNo,sstd.tst.tchr.subject,(avg/count))); //Adding to list
                }
            }
            for(AvgTest aa:average){ //loop to print averages
                System.out.println("Test No.: "+aa.testNo +" Subject: "+ aa.subject +"  Average Grade: " + findGrade(aa.avgGrades));
            }
        }
    static void calcAvgStd(List<Student> std){
        Boolean found = false ;     //Boolean to check whether repetition exists in a list or not
        List<AvgStudent> average = new ArrayList<AvgStudent>() ;        //List of averages of students
        int count = 0 ;             //Count the repetitions of one student
        double avg = 0 ;            //Stores the sum of grades of one student
        for(Student sstd : std){       //Outer loop to iterate through all values of list of students
            count = 0 ;
            avg = 0 ;
            found = false ;
            for(Student sstd1 : std){       //inner loop to iterate through all values of list of students
                if(sstd.name.equals(sstd1.name)){       //Checks if both names are same
                    count++ ;           //Count increase by one
                    avg += sstd1.grade;     //Sum increase by grade that student gets in current test
                }
            }
            for(AvgStudent aveg: average){      //This loop is to check for duplicates
                if(aveg.stdName.equals(sstd.name)){
                    found = true ;
                }
            }
            if(!found){         //Avoid from duplicates
                average.add(new AvgStudent(sstd.name,(avg/count)));  //Adding to average list of unique students
            }
        }

        for(AvgStudent aa:average){ //This loop is to print the averages of each unique students
               System.out.println("Student Name: "+aa.stdName + "  Average Grade: " + findGrade(aa.avgGrades));
        }
    }
    public static void main(String[] args) {
           List<Student> student = new ArrayList<Student>();   //Store the students
           student = readFile();        //read file and stores in the list of students
           Scanner input = new Scanner(System.in) ; //Scanner initializing
           a : while(true){         //Loop to iterate till user entering the students grade
               System.out.print("\n1. Add Student \n2. Done \nYour Selection : "); //Printing manual
               String option = input.nextLine() ;   //Getting user's choice
               switch (option){         //Switch
                   case "1":            //If user press one
                       System.out.print("Enter Student Name: ");
                       String stdName = input.nextLine() ;          //Get student name
                       System.out.print("Enter Test No.: ");
                       int testNo = Integer.parseInt(input.nextLine()) ;    //Get Test no.
                       System.out.print("Enter Teacher Name: ");
                       String tchrName = input.nextLine() ;         //Get teacher name
                       System.out.print("Enter Subject Name: ");
                       String subj = input.nextLine() ;         //Get subject name
                       System.out.print("Enter Student Test Grade Percentage: ");
                       double grade = Double.parseDouble(input.nextLine()) ;        //Get grades of student

                       Teacher tchr = new Teacher(tchrName,subj) ;
                       Test tst = new Test(testNo,tchr);
                       Student std = new Student(stdName,grade,tst);
                       student.add(std) ;           //Adding to student list
                       break;
                   case "2":
                       writeFile(student);          //Writing all student's list to the file
                       break a;
                   default:
                       System.out.println("Your input is invalid.");
               }
           }
           System.out.println("\nStudent's average grades");
           calcAvgStd(student);             //Calculate and print each unique student's grade
           System.out.println("\nTest's average grades");
           calcAvgTest(student);        // Calculate and prints each unique test's grade
           System.out.println("\nClass's average grades");
           calcAvgClass(student);       //Calculate and print class's average grade
       }
}
