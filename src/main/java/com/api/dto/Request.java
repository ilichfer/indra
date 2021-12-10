package com.api.dto;

import java.util.List;

public class Request {

	private List<Integer> barrio;

	 private Integer dias;

	public List<Integer> getBarrio() {
		return barrio;
	}

	public void setBarrio(List<Integer> barrio) {
		this.barrio = barrio;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}
	 

}
