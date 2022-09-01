package com.sjnc.HelpDesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Pessoa;
import com.sjnc.HelpDesk.domain.Cliente;
import com.sjnc.HelpDesk.domain.dtos.ClienteDTO;
import com.sjnc.HelpDesk.repositories.PessoaRepository;
import com.sjnc.HelpDesk.repositories.ClienteRepository;
import com.sjnc.HelpDesk.services.exceptions.ObjectnotFoundException;


@Service
public class ClienteService {

		@Autowired
		private ClienteRepository repository;
		@Autowired
		private PessoaRepository pessoaRepository;
		
		public Cliente findById(Integer id ) {
		
			Optional<Cliente> obj = repository.findById(id);
			return obj.orElseThrow(() -> new ObjectnotFoundException( "Objeto náo encontrado! O referido id: " +id+  " é inexistente na base de dados "));
		}

		public List<Cliente> findAll() {
			return repository.findAll();
		}

		public Cliente create(ClienteDTO objDTO) {
			objDTO.setId(null);
			validaPorCpfEEmail(objDTO);
			Cliente newObj = new Cliente(objDTO);
			return repository.save(newObj);
		}
		
		public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
			objDTO.setId(id);
			Cliente oldObj = findById(id);
			validaPorCpfEEmail(objDTO);
			oldObj = new Cliente(objDTO);
			return repository.save(oldObj);
		}
		
		public void delete(Integer id) {
			Cliente obj = findById(id);
			if(obj.getChamados().size()>0) {
				throw new DataIntegrityViolationException("Cliente possui oredens de serviço, não pode ser excluído");
			}else {
				repository.deleteById(id);
			}
		}
		

		private void validaPorCpfEEmail(ClienteDTO objDTO) {
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
