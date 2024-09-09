package com.ahmete.repository;

import static com.ahmete.utility.Constants.*;

import java.sql.*;
import java.util.Optional;

public class DatabaseHelper {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	private boolean openConnection(){
		try {
			connection=
					DriverManager.getConnection("jdbc:postgresql://"+ DB_HOSTNAME+":"+DB_PORT+"/"+DB_NAME, DB_USERNAME, DB_PASSWORD);
			return true;
		}
		catch (SQLException e) {
			System.out.println("Bağlantı Hatası.... "+e.getMessage());
			return false;
		}
	}
	private void closeConnection(){
		try {
			if (!connection.isClosed()) {
				connection.close();}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean executeUpdate(String sql){
		try {
			if (openConnection()){
				connection.prepareStatement(sql).executeUpdate();
				closeConnection();
				System.out.println("İşleminiz başarılıyla gercekleştirildi");
				return true;
			}else {
				System.out.println("Bağlantı acmada hata meydana geldi");
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("Sorgu calıştırmada hata! SQL kodunuzda bir hata olabiir... "+e.getMessage());
			return false;
		}
	}
	
	public Optional<ResultSet> executeQuery(String sql){
		try {
			if (openConnection()){
				ResultSet rs = connection.prepareStatement(sql).executeQuery();
				closeConnection();
				System.out.println("İşleminiz başarıyla gercekleştirildi");
				return Optional.ofNullable(rs);
			}else {
				System.out.println("Bağşantı acmada hata meydana geldi");
				return Optional.empty();
			}
		}
		catch (SQLException e) {
			System.out.println("Sorgu calıştırmada hata! SQL kodunuzda bir hata olabiir... "+e.getMessage());
			return Optional.empty();
		}
	}
}