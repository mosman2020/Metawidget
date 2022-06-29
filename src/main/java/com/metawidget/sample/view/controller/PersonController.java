package com.metawidget.sample.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metawidget.sample.model.entity.Address;
import com.metawidget.sample.model.entity.Person;
import com.metawidget.sample.model.exception.RecordNotFoundException;
import com.metawidget.sample.model.service.ChildService;
import com.metawidget.sample.model.service.PersonService;

@Controller
//@SessionAttributes("person")
public class PersonController {
	@Autowired
	PersonService personService;
	
	@Autowired
	ChildService childService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String viewPersons(Model model) {
		List<Person> persons = personService.getAllPersons();
		System.out.println("persons =" + persons);
		model.addAttribute("persons", personService.getAllPersons());
		return "persons";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST, params="add" )
	public String addPerson(@ModelAttribute("person") Person person,Model model) throws RecordNotFoundException{
		System.out.println("from add person");
		person = new Person();
		person.setAddress(new Address());
		model.addAttribute("person", person);
		model.addAttribute("editable",true);
		return "person";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST, params="edit" )
	public String editPerson(@RequestParam(name = "personId") String personId,Model model) throws RecordNotFoundException{
		System.out.println("from edit person");
		long pId = Long.valueOf(personId);
		Person person = personService.getPersonById(pId);
		model.addAttribute("person", person);
		model.addAttribute("editable",true);
		return "person";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST, params="view" )
	public String viewPerson(@RequestParam(name = "personId") String personId,Model model) throws RecordNotFoundException{
		System.out.println("from view person");
		long pId = Long.valueOf(personId);
		model.addAttribute("person", personService.getPersonById(pId));
		model.addAttribute("editable",false);
		return "person";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST, params="delete" )
	public String deletePerson(@RequestParam(name = "personId") String personId,Model model) throws RecordNotFoundException{
		System.out.println("from delete person");
		personService.deletePersonById( Long.valueOf(personId));
		model.addAttribute("persons", personService.getAllPersons());
		return "persons";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST, params="cancel" )
	public String cancel(Model model){
		model.addAttribute("persons", personService.getAllPersons());
		return "persons";
	}
	
	@RequestMapping(value = "/person", method = RequestMethod.POST, params="save" )
	public String save(@ModelAttribute("person") Person person, Model model) throws RecordNotFoundException{
		System.out.println("from save person");
		 personService.createOrUpdatePerson(person);
		 model.addAttribute("person",person);
		 model.addAttribute("editable",false);
		return "person";
	}

	@RequestMapping(value = "/person", method = RequestMethod.POST, params="deletechild" )
	public String deleteChild(@RequestParam(name = "childId") String childId,@RequestParam(name = "personId") String personId, Model model) throws RecordNotFoundException{
		System.out.println("from delete child");
		Long cid = Long.valueOf(childId);
		Long pid = Long.valueOf(personId);
		childService.deleteChildById(cid);
		Person person = personService.getPersonById(pid);
		model.addAttribute("person", person);
		return "person";
	}
/*
	@RequestMapping(value = "/person", method = RequestMethod.POST, params="addchild" )
	public String addChild(@RequestParam(name = "id") String personId,Model model)throws RecordNotFoundException{
		Child child = (Child) model.getAttribute("childx");
		long pId = Long.valueOf(personId);
		Person person = personService.getPersonById(pId);
		List<Child> list = person.getChilds();
		list.add(child);
		personService.createOrUpdatePerson(person);
		return viewPerson(personId,true,model);
	}
*/
	
}
