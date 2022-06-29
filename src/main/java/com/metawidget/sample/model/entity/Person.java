package com.metawidget.sample.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.metawidget.inspector.annotation.UiComesAfter;
import org.metawidget.inspector.annotation.UiHidden;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Person{
	
	@UiHidden
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	@UiComesAfter("id")
	private String title;
	 
	@UiComesAfter("title")
	@Column(name="name")
	private String name;
	 
	@Column(name="email")
	@UiComesAfter("name")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="person_id")  
	@UiComesAfter("email")
	private List<Child> childs;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)  
	@UiComesAfter("childs")
	private Address address;
	
}
