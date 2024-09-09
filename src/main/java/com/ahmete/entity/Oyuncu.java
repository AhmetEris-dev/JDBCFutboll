package com.ahmete.entity;

import java.time.LocalDate;

public class Oyuncu extends BaseEntity{
	private Integer id;
	private Integer takim_id;
	private String ad;
	private String soyad;
	private LocalDate dtarih;
	
	public Oyuncu() {
	}
	
	public Oyuncu(Integer takim_id, String ad, String soyad, LocalDate dtarih) {
		this.takim_id = takim_id;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
	}
	
	public Oyuncu(Integer id, Integer takim_id, String ad, String soyad, LocalDate dtarih) {
		this.id = id;
		this.takim_id = takim_id;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
	}
	
	public Oyuncu(Integer id, Integer takim_id, String ad, String soyad, LocalDate dtarih, Integer state,
	              Long createat, Long updateat) {
		super(state, createat, updateat);
		this.id = id;
		this.takim_id = takim_id;
		this.ad = ad;
		this.soyad = soyad;
		this.dtarih = dtarih;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getTakim_id() {
		return takim_id;
	}
	
	public void setTakim_id(Integer takim_id) {
		this.takim_id = takim_id;
	}
	
	public String getAd() {
		return ad;
	}
	
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public String getSoyad() {
		return soyad;
	}
	
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	public LocalDate getDtarih() {
		return dtarih;
	}
	
	public void setDtarih(LocalDate dtarih) {
		this.dtarih = dtarih;
	}
	
	@Override
	public String toString() {
		return "Oyuncular{" + "id=" + getId() + ", takim_id=" + getTakim_id() + ", ad='" + getAd() + '\'' + ", soyad='" + getSoyad() + '\'' + ", dtarih=" + getDtarih() + ", state=" + getState() + ", createat=" + getCreateat() + ", updateat=" + getUpdateat() + '}';
	}
}