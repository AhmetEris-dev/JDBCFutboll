package com.ahmete.repository;

import com.ahmete.entity.Takim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements ICRUD<Takim> {
	private final DatabaseHelper databaseHelper;
	private  String sql;
	
	public TakimRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Takim takimlar) {
		sql = "INSERT INTO Takimlar(takim_ad, kurulus_tarihi) VALUES('%s','%s')"
				.formatted(takimlar.getTakim_ad(), takimlar.getKurulus_tarihi());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void deleteById(int silinecekTakimId) {
		sql = "DELETE FROM Takimlar WHERE id ="+silinecekTakimId;
		databaseHelper.executeUpdate(sql);
	
	}
	
	@Override
	public void update(Takim takimlar) {
	sql="UPDATE Takimlar SET takim_ad ='%s', kurulus_tarihi = '%s' WHERE id = %d"
			.formatted(takimlar.getTakim_ad(), takimlar.getKurulus_tarihi(), takimlar.getId());
	databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Takim> findAll() {
		sql = "SELECT * FROM Takimlar ORDER BY id";
		Optional<ResultSet> resultSet=databaseHelper.executeQuery(sql);
		List<Takim> takimlarList = new ArrayList<>();
		
		try {
			if (resultSet.isPresent()){
				ResultSet rs = resultSet.get();
				while(rs.next()){
					takimlarList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Takimlari getirirken bir sorun oluştu..."+e.getMessage());
		}
		return takimlarList;
	}
	
	@Override
	public Optional<Takim> findById(int bulunacakTakimId) {
		sql="SELECT * FROM Takimlar WHERE id ="+bulunacakTakimId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try {
			if (resultSet.isPresent()) {
				ResultSet rs =resultSet.get();
				if (rs.next()){
				
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Takim bulmada sorun yaşandı..." + e.getMessage());
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	private Takim getValueFromResultSet(ResultSet rs) throws SQLException {
		int id=rs.getInt("id");
		String takim_ad=rs.getString("takim_ad");
		String kurulus_tarihi=rs.getString("kurulus_tarihi");
		Integer state=rs.getInt("state");
		Long createat=rs.getLong("createat");
		Long updateat=rs.getLong("updateat");
		
		return new Takim(id, takim_ad, LocalDate.parse(kurulus_tarihi), state, createat, updateat);
	}
	
}