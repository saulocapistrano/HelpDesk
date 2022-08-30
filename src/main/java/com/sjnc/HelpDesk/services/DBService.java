package com.sjnc.HelpDesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Chamado;
import com.sjnc.HelpDesk.domain.Cliente;
import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.domain.enums.Perfil;
import com.sjnc.HelpDesk.domain.enums.Prioridade;
import com.sjnc.HelpDesk.domain.enums.Status;
import com.sjnc.HelpDesk.repositories.ChamadoRepository;
import com.sjnc.HelpDesk.repositories.ClienteRepository;
import com.sjnc.HelpDesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Saulo Capistrano", "84669322249", "saulo@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "11052350763", "torvaslds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01","Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
