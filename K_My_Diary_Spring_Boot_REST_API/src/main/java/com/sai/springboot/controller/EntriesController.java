package com.sai.springboot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.springboot.entity.Entries;
import com.sai.springboot.service.EntriesService;

@RestController
@RequestMapping("/entries")
public class EntriesController {

	@Autowired
	private EntriesService entriesService;

	@GetMapping("/")
	public List<Entries> findAllEntries() {

		return entriesService.findAll();
	}

	@PostMapping("/")
	public Entries saveEntries(@RequestBody Entries entries) {

		return entriesService.save(entries);
	}

	@PutMapping("/{id}")
	public Entries updateEntries(@PathVariable("id") int id ,@RequestBody Entries entries) {


		Entries dbEntry = entriesService.findById(id);
		
		dbEntry.setDescription(entries.getDescription());
		dbEntry.setEntrydate(entries.getEntrydate());
		dbEntry.setUserid(entries.getUserid());
		
		Entries updatedEntry = entriesService.update(dbEntry);

		return updatedEntry;
	}

	@GetMapping("/{id}")
	public Entries getEntriesById(@PathVariable("id") int id) {
		return entriesService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteEntries(@PathVariable("id") int id) {
		Entries entry = entriesService.findById(id);
		entriesService.delete(entry);
	}
	
	@PatchMapping("/{id}")
	public Entries partialupdateEntries(@PathVariable("id") int id ,@RequestBody Entries entries) {
		
		String desc =entries.getDescription();
		Date date =entries.getEntrydate();
		int userid =entries.getUserid();
		
		Entries dbEntry = entriesService.findById(id);
		
		if(desc !=null && desc.length()>0)
		dbEntry.setDescription(entries.getDescription());
		
		if(date !=null)
		dbEntry.setEntrydate(entries.getEntrydate());
		
		if(userid>0)
		dbEntry.setUserid(entries.getUserid());
		
		Entries updatedEntry = entriesService.update(dbEntry);

		return updatedEntry;
	}

}
