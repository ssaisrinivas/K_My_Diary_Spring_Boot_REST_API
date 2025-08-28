package com.sai.springboot.service;

import java.util.List;

import com.sai.springboot.entity.Entries;


public interface EntriesService {
	
	public Entries save(Entries entries) ;

	public Entries update(Entries entries);

	public void delete(Entries entries);
	
	public Entries findById(int id);

	public List<Entries> findAll() ;
	
    public List<Entries> findByUserId(int id); 

}
