package com.sjnc.HelpDesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.domain.dtos.TecnicoDTO;
import com.sjnc.HelpDesk.repositories.TecnicoRepository;
import com.sjnc.HelpDesk.services.exceptions.ObjectnotFoundException;
import java.util.List;


@Service
public class TecnicoService {

		@Autowired
		private TecnicoRepository repository;
		
		public Tecnico findById(Integer id ) {
		
			Optional<Tecnico> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ObjectnotFoundException( "Objeto náo encontrado! O referido id: " +id+  " é inexistente na base de dados "));
		}

		public List<Tecnico> findAll() {
			return repository.findAll();
		}

		public Tecnico create(TecnicoDTO objDTO) {
			objDTO.setId(null);
			Tecnico newObj = new Tecnico(objDTO);
			return repository.save(newObj);
			
			
		}
}
