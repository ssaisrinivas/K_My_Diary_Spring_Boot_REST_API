package com.sai.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sai.springboot.entity.Entries;

@Repository
public interface EntriesRepository extends JpaRepository<Entries, Integer> {

	@Query(value = "SELECT * FROM entries where userid = :id", nativeQuery = true)
	public List<Entries> findByUserId(Integer id);

}
