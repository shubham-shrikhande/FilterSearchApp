package com.nt.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FilterModel {

	private String plan_name;

	private String plan_status;

	private LocalDate start_date;

	private LocalDate end_date;

}
