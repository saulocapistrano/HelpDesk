package com.sjnc.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjnc.HelpDesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
