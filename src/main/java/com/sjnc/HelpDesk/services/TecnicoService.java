package com.sjnc.HelpDesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.repositories.TecnicoRepository;
import com.sjnc.HelpDesk.services.exceptions.ObjectnotFoundException;
import java.util.List;


@Service
public class TecnicoService {

		@Autowired
		private TecnicoRepository repository;
		
		public Tecnico findById(Integer id ) {
		
			Optional<Tecnico> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ObjectnotFoundException( "Objeto náo encontrado - id" +id));
		}

		public List<Tecnico> findAll() {
			return repository.findAll();
		}
}
