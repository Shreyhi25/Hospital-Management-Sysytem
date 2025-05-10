package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
	private Connection connection;
	
	
	public Doctor(Connection connection) {
		this.connection=connection;
	}
	
	public void viewDoctors() {
		
		String query = "SELECT*FROM doctors";
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("DOCTORS : ");
			System.out.println("+------------+-----------------+--------------------+");
			System.out.println("| DOCTOR_ID | NAME            | SPECIALIZATION      |");
			System.out.println("+------------+-----------------+--------------------+");
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String specialization = resultSet.getString("specialization");
				System.out.printf("|%-11s|%-17s|%-21s|\n", id,name,specialization);
				System.out.println("+------------+-----------------+--------------------+");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public boolean checkDoctorById(int id) {
		
		String query = "SELECT*FROM DOCTORS WHERE ID=?";
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
