package com.ahmete.repository;

import com.ahmete.entity.Oyuncu;
import com.ahmete.entity.Takim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OyuncuRepository implements ICRUD<Oyuncu> {
	private final DatabaseHelper databaseHelper;
	private String sql;
	
	public OyuncuRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Oyuncu oyuncu) {
		sql =
				("INSERT INTO Oyuncular(takim_id, ad,soyad,dtarih) VALUES(%d,'%s','%s','%s')").formatted(oyuncu.getTakim_id(), oyuncu.getAd(), oyuncu.getSoyad(), oyuncu.getDtarih());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void deleteById(int silinecekOyuncuId) {
		sql = "DELETE FROM Oyuncular WHERE id =" + silinecekOyuncuId;
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(Oyuncu oyuncu) {
		sql =
				"UPDATE Oyuncular SET takim_id =%d, ad = '%s',soyad ='%s',dtarih ='%s' WHERE id = %d"
						.formatted(oyuncu.getTakim_id(), oyuncu.getAd(), oyuncu.getSoyad(), oyuncu.getDtarih(),oyuncu.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Oyuncu> findAll() {
		sql = "SELECT * FROM Oyuncular ORDER BY id";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Oyuncu> oyuncuList = new ArrayList<>();
		
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				while (rs.next()) {
					oyuncuList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Oyuncuları getirirken bir sorun oluştu..." + e.getMessage());
		}
		return oyuncuList;
	}
	
	@Override
	public Optional<Oyuncu> findById(int bulunacakTakimId) {
		sql="SELECT * FROM Oyuncular WHERE id ="+bulunacakTakimId;
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
			System.out.println("Oyuncu bulmada sorun yaşandı..." + e.getMessage());
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	private Oyuncu getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		Integer takim_id = rs.getInt("takim_id");
		String ad = rs.getString("ad");
		String soyad = rs.getString("soyad");
		String dtarih = rs.getString("dtarih");
		Integer state = rs.getInt("state");
		Long createat = rs.getLong("createat");
		Long updateat = rs.getLong("updateat");
		
		return new Oyuncu(id, takim_id, ad, soyad, LocalDate.parse(dtarih), state, createat, updateat);
	}
}