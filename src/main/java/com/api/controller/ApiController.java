package com.api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.dto.Request;
import com.api.serviceImpl.DiasService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private DiasService diasService;

	protected static Logger logger = LogManager.getLogger(ApiController.class);


	@PostMapping("/dias")
	public ResponseEntity<Object> naveEspacial(@Validated @RequestBody Request request) throws Exception {

		if (logger.isDebugEnabled())
			logger.debug("Entra a calcular segun los dias");

		try {
			return ResponseEntity.status(HttpStatus.OK).body(diasService.calcular(request.getDias(),request.getBarrio()));
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		} 
		
	}

}
