package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class EligibilityDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer plan_id;
	@Column
	private long case_num;
	@Column
	private String plan_name;
	@Column
	private String plan_status;
	@Column
	private String holder_name;
	@Column
	private Long holder_ssn;
	@Column
	private String benefit_amt;
	@Column
	private LocalDate start_date;
	@Column
	private LocalDate end_date;
	@Column
	private String denial_reason;

	
}
