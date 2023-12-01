package br.com.pi.projetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pi.projetoIntegrador.model.Usuario;


@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {
	
	Usuario findByLogin(String login);
	Usuario findByEmail(String email);
	Usuario findByLoginAndSenha(String login, String senha);
	boolean existsByLoginOrEmail(String login, String email);

}
