package com.sjnc.HelpDesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Chamado;
import com.sjnc.HelpDesk.repositories.ChamadoRepository;
import com.sjnc.HelpDesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository repository;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto não encontrado Id: "+id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}
}
