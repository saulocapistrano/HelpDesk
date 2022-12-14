package com.sjnc.HelpDesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Pessoa;
import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.domain.dtos.TecnicoDTO;
import com.sjnc.HelpDesk.repositories.PessoaRepository;
import com.sjnc.HelpDesk.repositories.TecnicoRepository;
import com.sjnc.HelpDesk.services.exceptions.ObjectnotFoundException;


@Service
public class TecnicoService {

		@Autowired
		private TecnicoRepository repository;
		@Autowired
		private PessoaRepository pessoaRepository;
		@Autowired
		private BCryptPasswordEncoder encoder;	
		
		public Tecnico findById(Integer id ) {
		
			Optional<Tecnico> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ObjectnotFoundException( "Objeto náo encontrado! O referido id: " +id+  " é inexistente na base de dados "));
		}

		public List<Tecnico> findAll() {
			return repository.findAll();
		}

		public Tecnico create(TecnicoDTO objDTO) {
			objDTO.setId(null);
			objDTO.setSenha(encoder.encode(objDTO.getSenha()));
			validaPorCpfEEmail(objDTO);
			Tecnico newObj = new Tecnico(objDTO);
			return repository.save(newObj);
		}
		
		public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
			objDTO.setId(id);
			Tecnico oldObj = findById(id);
			validaPorCpfEEmail(objDTO);
			oldObj = new Tecnico(objDTO);
			return repository.save(oldObj);
		}
		
		public void delete(Integer id) {
			Tecnico obj = findById(id);
			if(obj.getChamados().size()>0) {
				throw new DataIntegrityViolationException("Técnico possui oredens de serviço, não pode ser excluído");
			}else {
				repository.deleteById(id);
			}
		}
		

		private void validaPorCpfEEmail(TecnicoDTO objDTO) {
			Optional <Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
			if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("Cpf já cadastrado no sistema");
			}
			obj = pessoaRepository.findByEmail(objDTO.getEmail());
			if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
				throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
		
		}

				
}
