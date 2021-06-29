package com.rk.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	@NotEmpty(message = "Name Most be Required")
	private String contactName;
	
	@Column(name="CONTACT_NUMBER")
	@NotNull(message = "Number is mandetory to field")
	private Long contactNumber;
	
	@Column(name="CONTACT_EMAIL")
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Enter valid Email id ...")
	private String contactEmail;
	
	@Column(name="ACTIVE_SWITCH")
	private String activeSwitch;
	
//-----------------------------------------------------------------------------------------

	@CreationTimestamp
	@Column(name="CREATE_DATE",updatable = false)
	private LocalDate createDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE",insertable = false)
	private LocalDate updateDate;
	
}
