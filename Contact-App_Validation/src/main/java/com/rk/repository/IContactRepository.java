package com.rk.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.entity.Contact;

public interface IContactRepository extends JpaRepository<Contact,Serializable>  {
	
}
