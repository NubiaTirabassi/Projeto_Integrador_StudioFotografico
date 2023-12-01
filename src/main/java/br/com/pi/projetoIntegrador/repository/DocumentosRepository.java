package br.com.pi.projetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pi.projetoIntegrador.model.Documentos;

@Repository
public interface DocumentosRepository extends JpaRepository<Documentos, Integer> {

}
