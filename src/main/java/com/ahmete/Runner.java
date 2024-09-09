package com.ahmete;

import com.ahmete.entity.Oyuncu;
import com.ahmete.entity.Takim;
import com.ahmete.repository.OyuncuRepository;
import com.ahmete.repository.TakimRepository;

import java.time.LocalDate;
import java.util.Optional;

public class Runner {
	public static void main(String[] args) {
		Takim takim1=new Takim("Galatasaray", LocalDate.of(1905, 10, 1));
		Takim takim2=new Takim("Fenerbahçe", LocalDate.of(1907, 5, 3));
		Takim takim3=new Takim("Trabzonspor", LocalDate.of(1967, 8, 2));
		
		TakimRepository takimRepository=new TakimRepository();
		
//		takimRepository.save(takim3);
//		takimRepository.deleteById(3);
		
//		Optional<Takim> guncellenecekTakim=takimRepository.findById(2);
//		if(guncellenecekTakim.isPresent()){
//			guncellenecekTakim.get().setTakim_ad("Real-Madrid");
//		}
//		takimRepository.update(guncellenecekTakim.get());
	
//		takimRepository.findAll().forEach(System.out::println);
//		takimRepository.findById(1).ifPresent(System.out::println);
		
		OyuncuRepository oyuncuRepository=new OyuncuRepository();
		Oyuncu oyuncu1=new Oyuncu(1,"Ahmet","Eris",LocalDate.of(1997,1,9));
		Oyuncu oyuncu2=new Oyuncu(1,"Emine","karabolat",LocalDate.of(1997,5,15));
		Oyuncu oyuncu3=new Oyuncu(1,"Berkay","Başrol",LocalDate.of(1997,3,16));
		Oyuncu oyuncu4=new Oyuncu(2,"Alper","Güler",LocalDate.of(1997,3,16));
//		oyuncuRepository.save(oyuncu4);
//		oyuncuRepository.deleteById(2);
		
		
//		Optional<Oyuncu> guncellenecekOyuncu=oyuncuRepository.findById(1);
//		if(guncellenecekOyuncu.isPresent()){
//			guncellenecekOyuncu.get().setSoyad("Özer");
//		}
//		oyuncuRepository.update(guncellenecekOyuncu.get());
		
//		oyuncuRepository.findAll().forEach(System.out::println);
		
//		oyuncuRepository.findById(3).ifPresentOrElse(System.out::println,()-> System.out.println("aradıgınız idli musteri " +
//				                                                                             "bulunamadı"));
//
		
		
		
	}
	
}