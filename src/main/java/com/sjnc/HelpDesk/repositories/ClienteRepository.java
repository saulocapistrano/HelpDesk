package com.sjnc.HelpDesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjnc.HelpDesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
