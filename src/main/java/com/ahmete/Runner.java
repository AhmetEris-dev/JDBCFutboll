package com.ahmete;

import com.ahmete.entity.Takim;
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
	
		takimRepository.findAll().forEach(System.out::println);
		takimRepository.findById(1).ifPresent(System.out::println);
	}

	
}