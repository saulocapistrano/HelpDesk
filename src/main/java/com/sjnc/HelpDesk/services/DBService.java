package com.sjnc.HelpDesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sjnc.HelpDesk.domain.Chamado;
import com.sjnc.HelpDesk.domain.Cliente;
import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.domain.enums.Perfil;
import com.sjnc.HelpDesk.domain.enums.Prioridade;
import com.sjnc.HelpDesk.domain.enums.Status;
import com.sjnc.HelpDesk.repositories.ChamadoRepository;
import com.sjnc.HelpDesk.repositories.ClienteRepository;
import com.sjnc.HelpDesk.repositories.PessoaRepository;
import com.sjnc.HelpDesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Saulo Capistrano", "63367417700", "saulo@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Capistrano jose", "77671251658", "capist@gmail.com", encoder.encode("345"));
		Tecnico tec3 = new Tecnico(null, "Karla Capistrano", "75635248357", "karla@gmail.com", encoder.encode("567"));
		Tecnico tec4 = new Tecnico(null, "Joao Pereira", "21775815404", "pereira@gmail.com", encoder.encode("789"));
		Tecnico tec5 = new Tecnico(null, "Francisco Jose", "95275727119", "francisco@gmail.com", encoder.encode("901"));
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "12794514245", "torvaslds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Bezerra Menezes", "05449255306", "bezerra@mail.com", "556");
		Cliente cli3 = new Cliente(null, "Klark Kent", "46582327151", "super@mail.com", "665");
		Cliente cli4 = new Cliente(null, "Bruce Wane", "68461705459", "bat@mail.com", "996");
		Cliente cli5 = new Cliente(null, "Mark Hunter", "81264645007", "hunter@mail.com", "996");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01","Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02","Segundo chamado", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 03","Terceiro chamado", tec3, cli3);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2,tec3,tec4,tec5));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3));
	}
}
