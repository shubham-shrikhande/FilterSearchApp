package com.nt.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FilterModel {

	private String planName;

	private String planStatus;

	private LocalDate startDate;

	private LocalDate endDate;

}
