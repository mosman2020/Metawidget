package com.metawidget.sample.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metawidget.sample.model.entity.Child;


public interface ChildRepository extends JpaRepository<Child, Long>{

}
