package com.sjnc.HelpDesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sjnc.HelpDesk.domain.Tecnico;
import com.sjnc.HelpDesk.domain.enums.Perfil;

public class TecnicoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "O campo nome é requerido" )
	protected String  nome;
	@NotNull(message = "O campo cpf é requerido" )
	protected String  cpf;
	@NotNull(message = "O campo e-mail é requerido" )
	protected String  email;
	@NotNull(message = "Você precisa criar uma senha de acesso ao sistema" )
	protected String  senha;
	protected Set<Integer> perfils = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	public TecnicoDTO() {
		super();
	 addPerfil(Perfil.CLIENTE); 
	}
	
	
	private void addPerfil(Perfil cliente) {
		
		
	}


	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		addPerfil(Perfil.CLIENTE);	
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Set<Perfil> getPerfils() {
		return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	public void addPerfils(Perfil perfil) {
		this.perfils.add(perfil.getCodigo());
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
