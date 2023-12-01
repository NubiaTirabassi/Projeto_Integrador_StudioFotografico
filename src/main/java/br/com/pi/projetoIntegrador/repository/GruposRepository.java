package br.com.pi.projetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pi.projetoIntegrador.model.Grupos;

@Repository
public interface GruposRepository extends JpaRepository<Grupos, Integer> {

}

