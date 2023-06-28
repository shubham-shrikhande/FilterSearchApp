package com.nt.reponse;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ResponseDetails {
	
	private Integer planId;
	private long caseNumber;
	private String planName;
	private String planStatus;

	private String holderName;

	private Long holderSsn;

	private String benefitAmt;

	private LocalDate startDate;

	private LocalDate endDate;

	private String denialReason;
}
