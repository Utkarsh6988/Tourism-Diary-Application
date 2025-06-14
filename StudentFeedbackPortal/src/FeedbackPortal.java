//Student Feedback Portal
//:Rating system, unique response, feedback export , make this in simple core java application

import java.util.*;
import java.io.*;

public class FeedbackPortal {
	private static final String FILENAME = "feedback.csv";
	private static Set<String> submittedStudents = new HashSet<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		loadExistingData();

		while (true) {
			System.out.println("\nStudent Feedback portal");
			System.out.println("1. Submit Feedback");
			System.out.println("2. View All Feedback");
			System.out.println("3. Export Feedback");
			System.out.println("4. Exit");
			System.out.println("Choose Option: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				submitFeedback();
				break;
			case 2:
				viewFeedback();
				break;
			case 3:
				exportFeedback();
				break;
			case 4:
				System.out.println("Exiting.....");
				break;
			default:
				System.out.println("Invalid Choice!");
			}
		}
	}

	private static void submitFeedback() {
		System.out.print("Enter student ID:");
		String studentId = sc.nextLine();

		if (submittedStudents.contains(studentId)) {
			System.out.println("Feedback already submitted for this student!");
			return;
		}

		System.out.print("Enter Course name: ");
		String course = sc.nextLine();

		int rating;
		do {
			System.out.print("Rate (1-5 Stars): ");
			rating = sc.nextInt();
			sc.nextLine();
		} while (rating < 1 || rating > 5);

		System.out.print("Enter Comments: ");
		String comments = sc.nextLine();

		try (FileWriter fw = new FileWriter(FILENAME, true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw)) {
			out.println(String.join(",", studentId, course, String.valueOf(rating),
					"\"" + comments.replace("\"", "\"\"") + "\""));
			submittedStudents.add(studentId);
			System.out.println("Thank you for your feedback! ");
		} catch (IOException e) {
//    		 e.printStackTrace();
			System.out.println("Error saving feedback: " + e.getMessage());
		}
	}

	private static void viewFeedback() {
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String line;
			System.out.println("\nStudent ID , Course, Rating, Comments ");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void exportFeedback() {
		System.out.println("Feeback is automatically saved to :" + FILENAME);
		System.out.println("File Location:" + new File(FILENAME).getAbsolutePath());
	}

	private static void loadExistingData() {
		if (!new File(FILENAME).exists())
			return;

		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",", 4);
				if (parts.length > 0) {
					submittedStudents.add(parts[0]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
