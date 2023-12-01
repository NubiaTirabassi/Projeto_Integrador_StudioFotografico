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

import br.com.pi.projetoIntegrador.model.Grupos;
import br.com.pi.projetoIntegrador.service.GrupoService;

@RestController
@RequestMapping("/grupos")
public class GruposController {
	
	private final GrupoService grupoService;
	
	@Autowired
	public GruposController(GrupoService grupoService) {
		this.grupoService = grupoService;
		
	}

	@GetMapping
	public ResponseEntity<List<Grupos>> listarGrupos() {
		List<Grupos> grupos = grupoService.listarGrupos();
		return ResponseEntity.ok(grupos);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grupos> consultarGrupoId (@PathVariable Integer id){
		Grupos grupos = grupoService.consultarGrupoId(id);
		return ResponseEntity.ok(grupos);
		
	}
	
	@PostMapping
	public ResponseEntity<Grupos> criarGrupo(@RequestBody Grupos grupos){
		Grupos novoGrupo = grupoService.criarGrupo(grupos);
		return ResponseEntity.ok(novoGrupo);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Grupos> atualizarGrupo(@PathVariable Integer id, @RequestBody Grupos grupos) {
		Grupos grupoAtualizado = grupoService.atualizarGrupo(id, grupos);
		return ResponseEntity.ok(grupoAtualizado);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirGrupo(@PathVariable Integer id){
		grupoService.excluirGrupo(id);
		return ResponseEntity.noContent().build();
	}
	
}



