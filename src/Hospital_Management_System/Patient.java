package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Patient {
	private Connection connection;
	private Scanner scanner;
	
	public Patient(Connection connection, Scanner scanner) {
		this.connection=connection;
		this.scanner=scanner;
	}
	
//	public void addPatient() {
//		System.out.println("----Enter Patient Name----");
//		String 	name = scanner.next();
//		System.out.println("----Enter Patient Age----");
//		int age = scanner.nextInt();
//		System.out.println("----Enter Gender----");
//		String gender = scanner.next();
//		
//		try {
//			String query = "INSERT INTO patients(name,age,gender) VALUES (?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1,name);
//			preparedStatement.setInt(2,age);
//			preparedStatement.setString(3,gender);
//			
//			int affectedRows = preparedStatement.executeUpdate();
//			if(affectedRows>0)
//			{
//				System.out.println("----PATIENT ADDED SUCCESSFULLY !!----");
//			}
//			else {
//				System.out.println("----FAILED TO ADD PATIENT !!----");
//			}			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void addPatient() {
	    scanner.nextLine(); // Clear any leftover input
	    
	    // Name validation (only letters and spaces)
	    String name;
	    while (true) {
	        System.out.println("----Enter Patient Name (letters only)----");
	        name = scanner.nextLine().trim();
	        if (name.matches("[a-zA-Z ]+") && !name.isEmpty()) {
	            break;
	        }
	        System.out.println("Invalid name! Please use only letters and spaces.");
	    }

	    // Age validation (only numbers)
	    int age;
	    while (true) {
	        System.out.println("----Enter Patient Age (numbers only)----");
	        try {
	            age = Integer.parseInt(scanner.nextLine());
	            if (age > 0 && age < 120) { // Reasonable age range validation
	                break;
	            }
	            System.out.println("Invalid age! Please enter a number between 1-119.");
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid input! Please enter numbers only.");
	        }
	    }

	    // Gender validation (only male or female)
	    String gender;
	    while (true) {
	        System.out.println("----Enter Gender (male/female)----");
	        gender = scanner.nextLine().trim().toLowerCase();
	        if (gender.equals("male") || gender.equals("female")) {
	            break;
	        }
	        System.out.println("Invalid gender! Please enter either 'male' or 'female'.");
	    }

	    try {
	        String query = "INSERT INTO patients(name,age,gender) VALUES (?,?,?)";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, name);
	        preparedStatement.setInt(2, age);
	        preparedStatement.setString(3, gender);
	        
	        int affectedRows = preparedStatement.executeUpdate();
	        if (affectedRows > 0) {
	            System.out.println("----PATIENT ADDED SUCCESSFULLY !!----");
	        } else {
	            System.out.println("----FAILED TO ADD PATIENT !!----");
	        }
	    } catch (SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    }
	}
	
	public void viewPatients() {
		
		String query = "SELECT*FROM patients";
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Patient : ");
			System.out.println("+------------+-----------------+--------+-----------+");
			System.out.println("| PATIENT_ID | NAME            | AGE    | GENDER    |");
			System.out.println("+------------+-----------------+--------+-----------+");
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				System.out.printf("|%-12s|%-17s|%-8s|%-11s|\n", id, name, age, gender);
				System.out.println("+------------+-----------------+--------+-----------+");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean checkPatientById(int id) {
		
		String query = "SELECT*FROM patients WHERE id=?";
		try {
			
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			return true;
		}
		else {
			return false;
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
