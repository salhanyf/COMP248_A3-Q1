// -------------------------------------------------------
// Assignment (3-Q1)
// For COMP 248 Section (S) – Winter 2019
// --------------------------------------------------------
// This is a program that calculates the GPA for an undergraduate student
// by calculating what grade he will get and how that grade will affect his current GPA

import java.util.Arrays;
import java.util.Scanner;
public class GPA_Calculator {

	public static void main(String[] args) {
		//Declares the scanner object.
		Scanner Scan = new Scanner(System.in);
		//Declares variables 
		double currentGPA=0.0;
		int nbCredits, nbCourses=0;

		//Three arrays to store info about the added courses.
		String[] name = null;
		double[] credits = null;
		String[] letter = null;
		
		//Declares an array so we can store the weight of the grade
		double[] weight = null;
		
		//Welcome message and instructions of the program.
		System.out.println("*************************************************************");
		System.out.println("*****\tWelcome to the bested GPA calculator ever...\t*****"
				+ "\n***   The program will ask you first to enter the number  ***\n"
				+ "*****\t   of credits you have accumulated so far. \t*****\n");
		System.out.println("***\tIf this is your first semester, please enter 0.\t  ***");
		System.out.println("*************************************************************");    
	
		System.out.print("Please enter how many credits you have accumulated so\n"
				+ "far not including your current semester: ");
		nbCredits = Scan.nextInt();
		
		//Shows error message if number of credits accumulated so far is a negative number.
		while (nbCredits <0) {
			System.out.println("\nERROR: number of past credits has to be a positive number.");
			System.out.print("\nPlease enter how many credits you have accumulated so\n"
					+ "far not including your current semester: ");
			nbCredits = Scan.nextInt();
		}
		//while not first semester we need to ask the user for his/her current GPA.
		if (nbCredits != 0 ) {
			System.out.print("Please enter your current GPA: ");
			currentGPA = Scan.nextDouble();
			
			//Shows error if current GPA is not between 0 and 4.3 inclusive.
			while ((currentGPA<0)||(currentGPA>=4.3)) {
				System.out.println("\nERROR: a valid GPA is between 0 to 4.3 inclusive.");
				System.out.print("\nPlease enter your current GPA: ");
				currentGPA = Scan.nextDouble();
			}
			System.out.print("Please enter how many courses do you want to add to the GPA calculator: ");
			nbCourses = Scan.nextInt();
			
			//Shows error if number of courses to add is less than 0
			while ((nbCourses<=0)||(nbCourses>=5)) {
				System.out.println("\nERROR: number of courses has to be a positive number and less that 5 inclusive.");
				System.out.print("\nPlease enter how many courses do you want to add to the GPA calculator: ");
				nbCourses = Scan.nextInt();
			}
			//Stores user input in 3 different arrays to display after.
			name = new String[nbCourses];
			credits = new double[nbCourses];
			letter = new String[nbCourses];
			//another array to store the grade points of a student 
			weight = new double[nbCourses];
			System.out.println();
		}//end of if statement if it's not first semester.
		
		//in case of first semester.
		else if (nbCredits == 0 ) {
			System.out.print("Please enter how many courses do you want to add to the GPA calculator: ");
			nbCourses = Scan.nextInt();
			
			while ((nbCourses<=0)||(nbCourses>=5)) {
				System.out.println("\nERROR: number of courses has to be a positive number and less that 5 inclusive.");
				System.out.print("\nPlease enter how many courses do you want to add to the GPA calculator: ");
				nbCourses = Scan.nextInt();
			}
			name = new String[nbCourses];
			credits = new double[nbCourses];
			letter = new String[nbCourses];
			weight = new double[nbCourses];
			System.out.println();
		}//end of if statement if it's first semester.
		
		//declares option menu variables.
		String course, courseGrade;
		double courseCredit;
		double gradePts= 0.00;
	
		//asks the user for which courses he wants to add.
		for (int i=1 ; i<=nbCourses ; i++) {
			
			System.out.print("Please enter the name of course number "+i+": ");
			course = Scan.next();
			course = course.toUpperCase();
				
			System.out.print("Please enter the number of credits of course number "+i+": ");
			courseCredit = Scan.nextDouble();
			
			//shows error if number of credits of a course added is a negative number
			while (courseCredit <=0) {
				System.out.println("\nERROR: couse credit has to be a positive number.");
				System.out.print("\nPlease enter the number of credits of course number "+i+": ");
				courseCredit = Scan.nextInt();
			}
			System.out.print("Please enter the letter grade of cousre number "+i+": ");
			courseGrade = Scan.next();
			
			//shows error if letter grade is not a valid one.
			boolean validLetter = false;
			while(!validLetter) {
			if ((courseGrade.equals("A+"))||
					(courseGrade.equals("A"))||
					(courseGrade.equals("A-"))||
					(courseGrade.equals("B+"))||
					(courseGrade.equals("B"))||
					(courseGrade.equals("B-"))||
					(courseGrade.equals("C+"))||
					(courseGrade.equals("C"))||
					(courseGrade.equals("C-"))||
					(courseGrade.equals("D+"))||
					(courseGrade.equals("D"))||
					(courseGrade.equals("D-"))||
					(courseGrade.equals("FNS"))) {
				break;
			}
			System.out.println("\nERROR: couse grade has to be one of the following...");
			System.out.println("A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, FNS");
			System.out.print("\nPlease enter the letter grade of course number "+i+": ");
			courseGrade = Scan.next();
			}
			//weighting the grade to its points.
			if (courseGrade.equals("A+")) {
				gradePts=4.30;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("A")) {
				gradePts=4.00;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("A-")) {
				gradePts=3.70;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("B+")) {
				gradePts=3.30;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("B")) {
				gradePts=3.00;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("B-")) {
				gradePts=2.70;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("C+")) {
				gradePts=2.30;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("C")) {
				gradePts=2.00;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("C-")) {
				gradePts=1.70;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("D+")) {
				gradePts=1.30;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("D")) {
				gradePts=1.00;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("D-")) {
				gradePts=0.70;
				weight[i-1] = gradePts;
			}
			else if (courseGrade.equals("FNS")) {
				gradePts=0.00;
				weight[i-1] = gradePts;
			}           
			//stores user input in the arrays 
			name[i-1] = course;
			credits[i-1] = courseCredit;	
			letter[i-1] = courseGrade;
			
			System.out.println();
		}//end of for loop (questions)
		
		//options menu keeps displaying after executing each option until option 5 is chosen to exit the program.
		int option=0;
		do {
			System.out.println("Please choose one of the following options");
			System.out.println("Press 1: to display the courses in the system");
			System.out.println("Press 2: to display the new GPA");
			System.out.println("Press 3: to delete a course");
			System.out.println("Press 4: to add a course");
			System.out.println("Press 5: to exit program");
			option = Scan.nextInt();
			
			//using switch statement to handle the menu options.
			switch (option) {
			
			//displays the current information that the user has entered
			case 1:
				System.out.println("Your current GPA is: "+currentGPA);
				System.out.println("Your accumulated credits so far: "+nbCredits);
				System.out.println("Course Number\t\tCourse Name\tCourse Credit\tCourse Grade");
				for (int counter=0; counter<name.length; counter++) {
					System.out.println((counter+1)+"\t\t\t"+name[counter]+"\t\t"+credits[counter]+""
							+ "\t\t"+letter[counter]);
				}
				break;	
			//displays the new GPA
			case 2:
				double sigma=0, sigmaCredits=0;
				double x, y;
				//adding the credits of the courses the user wants to add using enhanced for loop.
				for (double s: credits) {
					sigmaCredits += s;
				}
				//handling the sigma(weight of course * course credit)
				for (int w=0; w<weight.length; w++) {
						sigma += (weight[w]*credits[w]);
				}
				
				x=(currentGPA*nbCredits)+sigma;
				y= nbCredits+sigmaCredits;
				double GPA=x/y;
				System.out.println("Your new GPA is: "+GPA);
				break;
		
			//deletes a course
			case 3:
				System.out.println("Cours e Number\t\tCourse Name\tCourse Credit\tCourse Grade");
				for (int counter=0; counter<name.length; counter++) {
					System.out.println((counter+1)+"\t\t\t"+name[counter]+"\t\t"+credits[counter]+""
							+ "\t\t"+letter[counter]);
				}
				System.out.print("Please enter the course number you want to delete: ");
				int delete = Scan.nextInt();
				//moves the elements of the arrays after deleting a course  
				for (int i=delete-1; i<name.length-1; i++) {
					name[i] = name[i+1];
					credits[i] = credits[i+1];
					letter[i] = letter[i+1];
					weight[i] = weight[i-1];
				}
				//resizes the three arrays (array[original number of elements - 1])
				name = Arrays.copyOf(name, nbCourses-1);
				credits = Arrays.copyOf(credits, nbCourses-1);
				letter = Arrays.copyOf(letter, nbCourses-1);
				weight = Arrays.copyOf(weight, nbCourses-1);
				break;
				
			//adds a new course	
			case 4:
				//asks the user for the details of the new course he wants to add 
				System.out.print("Please enter the name of course number "+(name.length+1)+": ");
				course = Scan.next();
				course = course.toUpperCase();
				
				System.out.print("Please enter the number of credits of course number "+(credits.length+1)+": ");
				courseCredit = Scan.nextDouble();
				
				while (courseCredit <=0) {
					System.out.println("\nERROR: couse credit has to be a positive number.");
					System.out.print("\nPlease enter the number of credits of course number "+(credits.length+1)+": ");
					courseCredit = Scan.nextInt();
				}
				System.out.print("Please enter the letter grade of cousre number "+(letter.length+1)+": ");
				courseGrade = Scan.next();
				
				//resizes the three arrays (array[original number of elements + 1])
				name = Arrays.copyOf(name, name.length+1);
				credits = Arrays.copyOf(credits, credits.length+1);
				letter = Arrays.copyOf(letter, letter.length+1);
				weight = Arrays.copyOf(weight, weight.length+1);
				
				//shows error if letter grade is not a valid one.
				boolean validLetter = false;
				while(!validLetter) {
				if ((courseGrade.equals("A+"))||
						(courseGrade.equals("A"))||
						(courseGrade.equals("A-"))||
						(courseGrade.equals("B+"))||
						(courseGrade.equals("B"))||
						(courseGrade.equals("B-"))||
						(courseGrade.equals("C+"))||
						(courseGrade.equals("C"))||
						(courseGrade.equals("C-"))||
						(courseGrade.equals("D+"))||
						(courseGrade.equals("D"))||
						(courseGrade.equals("D-"))||
						(courseGrade.equals("FNS"))) {
					break;
				}
				System.out.println("\nERROR: couse grade has to be one of the following...");
				System.out.println("A+, A, A-, B+, B, B-, C+, C, C-, D+, D, D-, FNS");
				System.out.print("\nPlease enter the letter grade of course number "+(letter.length+1)+": ");
				courseGrade = Scan.next();
				}
				//weighting the grade to its points.
				if (courseGrade.equals("A+")) {
					gradePts=4.30;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("A")) {
					gradePts=4.00;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("A-")) {
					gradePts=3.70;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("B+")) {
					gradePts=3.30;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("B")) {
					gradePts=3.00;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("B-")) {
					gradePts=2.70;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("C+")) {
					gradePts=2.30;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("C")) {
					gradePts=2.00;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("C-")) {
					gradePts=1.70;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("D+")) {
					gradePts=1.30;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("D")) {
					gradePts=1.00;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("D-")) {
					gradePts=0.70;
					weight[weight.length-1] = gradePts;
				}
				else if (courseGrade.equals("FNS")) {
					gradePts=0.00;
					weight[weight.length-1] = gradePts;
				}           
				//stores the new values to the arrays
				name[name.length-1] = course;
				credits[credits.length-1] = courseCredit;	
				letter[letter.length-1] = courseGrade;
				break;
		
			//exits the program	
			case 5:
				System.exit(0);
				break;
				
			//displays an error message if input is not between 1 and 5	
			default :	
				System.out.println("\nMenu option has to be between 1 and 5 inclusive.");
			
			}//end of switch statement for options
		} while (option !=5);  //end of do
	
	//closes the scanner object.
	Scan.close();
		
	}//end of main()
}//end of class
