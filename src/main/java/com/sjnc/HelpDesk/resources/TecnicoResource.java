package com.sjnc.HelpDesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos") // o erro pode ser esse 31.08.2022
public class TecnicoResource {
	// localhost:8080/tecnicos/1
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
		Tecnico obj =  service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	}


