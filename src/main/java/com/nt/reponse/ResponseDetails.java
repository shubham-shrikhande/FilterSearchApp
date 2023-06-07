package com.nt.reponse;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResponseDetails {
	
	private Integer plan_id;
	private long case_num;
	private String plan_name;
	private String plan_status;

	private String holder_name;

	private Long holder_ssn;

	private String benefit_amt;

	private LocalDate start_date;

	private LocalDate end_date;

	private String denial_reason;
}
