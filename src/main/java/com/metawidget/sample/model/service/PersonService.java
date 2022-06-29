package com.metawidget.sample.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metawidget.sample.model.entity.Person;
import com.metawidget.sample.model.exception.RecordNotFoundException;
import com.metawidget.sample.model.repository.PersonRepository;


@Service
public class PersonService {
	
	@Autowired
    PersonRepository repository;
	
	
	 public List<Person> getAllPersons()
	    {
		 
		 System.out.println("from get all persons service ");
	        List<Person> persons = repository.findAll();
	         
	        if(persons.size() > 0) {
	            return persons;
	        } else {
	            return new ArrayList<Person>();
	        }
	    }
	     
	    public Person getPersonById(Long id) throws RecordNotFoundException
	    {
	        Optional<Person> person = repository.findById(id);
	         
	        if(person.isPresent()) {
	            return person.get();
	        } else {
	            throw new RecordNotFoundException("No person record exist for given id");
	        }
	    }
	     
	    public Person createOrUpdatePerson(Person entity) throws RecordNotFoundException
	    {
	        Optional<Person> person = repository.findById(entity.getId());
	         
	        if(person.isPresent())
	        {
	        	Person newEntity = person.get();
	        	newEntity.setName(entity.getName());
	            newEntity.setEmail(entity.getEmail());
	            newEntity.setTitle(entity.getTitle());
	            newEntity.setAddress(entity.getAddress());
	            newEntity.setChilds(entity.getChilds());

	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    }
	     
	    public void deletePersonById(Long id) throws RecordNotFoundException
	    {
	        Optional<Person> person = repository.findById(id);
	         
	        if(person.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No person record exist for given id");
	        }
	    }
}
