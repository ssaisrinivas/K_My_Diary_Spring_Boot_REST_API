package com.sai.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.springboot.entity.Entries;
import com.sai.springboot.repository.EntriesRepository;

@Service
public class EntriesServiceImpl implements EntriesService {

	@Autowired
	private EntriesRepository entriesRepository;

	public EntriesRepository getentriesRepository() {
		return entriesRepository;
	}

	public void setentriesRepository(EntriesRepository entriesRepository) {
		this.entriesRepository = entriesRepository;
	}

	@Override
	public Entries save(Entries entries) {
		return entriesRepository.save(entries);
	}

	@Override
	public Entries update(Entries entries) {
		return entriesRepository.save(entries);
	}

	@Override
	public void delete(Entries entries) {
		entriesRepository.delete(entries);
	}

	@Override
	public Entries findById(int id) {
		return entriesRepository.findById(id).get();
	}

	@Override
	public List<Entries> findAll() {
		return entriesRepository.findAll();
	}

	
	@Override
	public List<Entries> findByUserId(int id) {

		return entriesRepository.findByUserId(id);
	}

	

}
