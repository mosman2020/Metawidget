package com.metawidget.sample.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metawidget.sample.model.entity.Child;
import com.metawidget.sample.model.exception.RecordNotFoundException;
import com.metawidget.sample.model.repository.ChildRepository;


@Service
public class ChildService {
	@Autowired
    ChildRepository repository;
	
	
	     
	    public Child getChildById(Long id) throws RecordNotFoundException
	    {
	        Optional<Child> child = repository.findById(id);
	         
	        if(child.isPresent()) {
	            return child.get();
	        } else {
	            throw new RecordNotFoundException("No child record exist for given id");
	        }
	    }
	     
	    public Child createOrUpdateChild(Child entity) throws RecordNotFoundException
	    {
	        Optional<Child> child = repository.findById(entity.getId());
	         
	        if(child.isPresent())
	        {
	        	Child newEntity = child.get();
	        	newEntity.setName(entity.getName());
	            newEntity.setAge(entity.getAge());
	            newEntity.setGender(entity.getGender());
	            newEntity = repository.save(newEntity);
	             
	            return newEntity;
	        } else {
	            entity = repository.save(entity);
	             
	            return entity;
	        }
	    }
	     
	    public void deleteChildById(Long id) throws RecordNotFoundException
	    {
	        Optional<Child> child = repository.findById(id);
	         
	        if(child.isPresent())
	        {
	            repository.deleteById(id);
	        } else {
	            throw new RecordNotFoundException("No child record exist for given id");
	        }
	    }
}
