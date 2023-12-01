package br.com.pi.projetoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.projetoIntegrador.model.Usuario;
import br.com.pi.projetoIntegrador.service.UsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
		
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		List<Usuario> usuarios = usuarioService.listarUsuarios();
		return ResponseEntity.ok(usuarios);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> consultarUsuarioId (@PathVariable Integer id){
		Usuario usuario = usuarioService.consultarUsuarioId(id);
		return ResponseEntity.ok(usuario);
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
		Usuario novoUsuario = usuarioService.criarUsuario(usuario);
		return ResponseEntity.ok(novoUsuario);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuario);
		return ResponseEntity.ok(usuarioAtualizado);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id){
		usuarioService.excluirUsuario(id);
		return ResponseEntity.noContent().build();
	}
	
}
