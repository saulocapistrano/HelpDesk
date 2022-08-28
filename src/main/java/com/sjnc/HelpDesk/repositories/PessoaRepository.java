package com.sjnc.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjnc.HelpDesk.domain.Pessoa;

 interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
