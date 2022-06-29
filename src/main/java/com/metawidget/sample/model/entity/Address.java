package com.metawidget.sample.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.metawidget.inspector.annotation.UiComesAfter;
import org.metawidget.inspector.annotation.UiHidden;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="address")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 3177437573689292329L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@UiHidden
	private long id;
	
	@Column(name="line1")
	@UiComesAfter("id")
	private String line1;
	
	@Column(name="line2")
	@UiComesAfter("line1")
	private String line2;
	
	@Column(name="postalcode")
	@UiComesAfter("line2")
	private String postalcode;
	
	@OneToOne(targetEntity=City.class,cascade=CascadeType.DETACH)  
	@UiComesAfter("postalcode")
	private City city;
	
	@Column(name="cuntry")
	@UiComesAfter("city")
	private String cuntry;
	
}
