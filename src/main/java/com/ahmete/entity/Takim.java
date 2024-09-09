package com.ahmete.entity;

import java.time.LocalDate;

public class Takim extends BaseEntity {
	private Integer id;
	private String takim_ad;
	private LocalDate kurulus_tarihi;
	
	
	public Takim() {
	}
	
	public Takim(String takim_ad, LocalDate kurulus_tarihi) {
	
		this.takim_ad = takim_ad;
		this.kurulus_tarihi = kurulus_tarihi;
	}
	
	public Takim(Integer state, Long createat, Long updateat, Integer id, String takim_ad,
	             LocalDate kurulus_tarihi) {
		super(state, createat, updateat);
		this.id = id;
		this.takim_ad = takim_ad;
		this.kurulus_tarihi = kurulus_tarihi;
		
	}
	
	public Takim(Integer id, String takim_ad, LocalDate kurulus_tarihi, Integer state, Long createat,
	             Long updateat) {
		super(state, createat, updateat);
		this.id = id;
		this.takim_ad = takim_ad;
		this.kurulus_tarihi = kurulus_tarihi;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTakim_ad() {
		return takim_ad;
	}
	
	public void setTakim_ad(String takim_ad) {
		this.takim_ad = takim_ad;
	}
	
	public LocalDate getKurulus_tarihi() {
		return kurulus_tarihi;
	}
	
	public void setKurulus_tarihi(LocalDate kurulus_tarihi) {
		this.kurulus_tarihi = kurulus_tarihi;
	}
	
	@Override
	public String toString() {
		return "Takimlar{" + "id=" + getId() + ", takim_ad='" + getTakim_ad() + '\'' + ", kurulus_tarihi=" + getKurulus_tarihi() + ", state=" + getState() + ", createat=" + getCreateat() + ", updateat=" + getUpdateat() + '}';
	}
}