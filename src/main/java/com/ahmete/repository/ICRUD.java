package com.ahmete.repository;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
	void save(T t);
	void deleteById(int id);
	void update(T t);
	List<T> findAll();
	Optional<T> findById(int id);
}