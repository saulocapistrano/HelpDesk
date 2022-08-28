package com.sjnc.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjnc.HelpDesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
