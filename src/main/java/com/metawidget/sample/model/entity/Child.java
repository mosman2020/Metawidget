package com.metawidget.sample.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.metawidget.inspector.annotation.UiComesAfter;
import org.metawidget.inspector.annotation.UiHidden;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Child implements Serializable{
	
	private static final long serialVersionUID = -8794340066486711042L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@UiHidden
	private long id;
	
	@UiComesAfter("id")
	private String name;
	
	@UiComesAfter("name")
	private String gender;
	
	@UiComesAfter("gender")
	private int age;
	
	private boolean deleted;
}
