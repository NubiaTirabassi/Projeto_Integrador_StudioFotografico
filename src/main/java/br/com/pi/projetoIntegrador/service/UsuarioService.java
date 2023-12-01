package br.com.pi.projetoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.projetoIntegrador.model.Usuario;
import br.com.pi.projetoIntegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;


	// lista usuarios
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

//consulta usuário pelo ID
	public Usuario consultarUsuarioId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElse(null);
	}

//cria usuário
	public Usuario criarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

//atualiza usuário
	public Usuario atualizarUsuario(Integer id, Usuario usuario) {
		if (usuarioRepository.existsById(id)) {
			usuario.setId(id);
			return usuarioRepository.save(usuario);

		}
		return null;

	}

//exclui usuário
	public void excluirUsuario(Integer id) {
		usuarioRepository.deleteById(id);
	}

}
