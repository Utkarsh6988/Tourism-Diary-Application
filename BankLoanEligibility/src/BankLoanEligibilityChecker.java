// Above 18 then Eligible for (House Loan, Car Loan and Education Loan) else not eligible 
// House Loan details ask: Name, age, address, Adhaar Card Number, Martial Status, Loan amount
// Car Loan Details ask:  Name, age, address, Adhaar Card Number, Martial Status, Driving License number, Loan amount
// Education Loan Details ask:  Name, age, address, Adhaar Card Number, Martial Status, Previous Education, Course name for loan, Name of the university, Loan amount

import java.util.*;

public class BankLoanEligibilityChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Bank Loan Eligibility Checker");
		System.out.println("Enter your age");
		int age = sc.nextInt();

		if (age < 18) {
			System.out.println("Sorry, you are not eligible for loans. ");
		}

		System.out.println("\nYou are eligible for House Loan, Car Loan, Education Loan");
		System.out.println("1. House Loan");
		System.out.println("2. Car Loan");
		System.out.println("3. Education Loan");
		System.out.println("Choose Loan type (1-3): ");
		int loanType = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter your name: ");
		String name = sc.nextLine();

		System.out.println("Enter your address: ");
		String address = sc.nextLine();

		System.out.println("Enter your Adhaar Card Number: ");
		String adhaar = sc.nextLine();

		System.out.println("Enter your Martial Status: ");
		String martialStatus = sc.nextLine();

		switch (loanType) {

		case 1:
			System.out.println("Enter loan amount: ");
			double houseLoanAmount = sc.nextDouble();
			System.out.println("\nHouse Loan Application Summary: ");
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Address: " + address);
			System.out.println("Adhaar Card Number: " + adhaar);
			System.out.println("Martial Status: " + martialStatus);
			System.out.println("Loan Amount: " + houseLoanAmount);
			break;

		case 2:
			System.out.println("Enter Driving License Number:");
			String license = sc.nextLine();
			System.out.println("Enter loan amount: ");
			double carLoanAmount = sc.nextDouble();
			System.out.println("\nCar Loan Application Summary: ");
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Address: " + address);
			System.out.println("Adhaar Card Number: " + adhaar);
			System.out.println("Driving License: " + license);
			System.out.println("Martial Status: " + martialStatus);
			System.out.println("Loan Amount: " + carLoanAmount);
			break;

		case 3:
			System.out.print("Enter previous education: ");
			String prevEducation = sc.nextLine();
			System.out.println("Enter Course name for Loan");
			String course = sc.nextLine();
			System.out.println("Enter name of university");
			String university = sc.nextLine();
			System.out.println("Enter loan amount: ");
			double EducationLoanAmount = sc.nextDouble();
			System.out.println("\nEducation Loan Application Summary: ");
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
			System.out.println("Address: " + address);
			System.out.println("Adhaar Card Number: " + adhaar);
			System.out.println("Martial Status: " + martialStatus);
			System.out.println("Previous Education" + prevEducation);
			System.out.println("Course: " + course);
			System.out.println("Name of University" + university);
			System.out.println("Loan Amount: " + EducationLoanAmount);
			break;

		default:
			System.out.println("Invalid loan type selected");
		}
		sc.close();
	}

}
