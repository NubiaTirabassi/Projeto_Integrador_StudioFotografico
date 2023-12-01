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

import br.com.pi.projetoIntegrador.model.Documentos;
import br.com.pi.projetoIntegrador.model.Usuario;
import br.com.pi.projetoIntegrador.service.DocumentoService;
import br.com.pi.projetoIntegrador.service.UsuarioService;

@RestController
@RequestMapping("/documentos")
public class DocumentosController {
	
	private final DocumentoService documentoService;
	
	@Autowired
	public DocumentosController(DocumentoService documentoService) {
		this.documentoService = documentoService;
		
	}

	@GetMapping
	public ResponseEntity<List<Documentos>> listarDocumentos() {
		List<Documentos> documentos = documentoService.listarDocumento();
		return ResponseEntity.ok(documentos);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Documentos> consultarDocumentoId (@PathVariable Integer id){
		Documentos documentos = documentoService.consultarDocumentoId(id);
		return ResponseEntity.ok(documentos);
		
	}
	
	@PostMapping
	public ResponseEntity<Documentos> criarDocumento(@RequestBody Documentos documentos){
		Documentos novoDocumento = documentoService.criarDocumento(documentos);
		return ResponseEntity.ok(novoDocumento);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Documentos> atualizarDocumento(@PathVariable Integer id, @RequestBody Documentos documentos) {
		Documentos documentoAtualizado = documentoService.atualizarDocumento(id, documentos);
		return ResponseEntity.ok(documentoAtualizado);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirDocumento(@PathVariable Integer id){
		documentoService.excluirDocumento(id);
		return ResponseEntity.noContent().build();
	}
	
}


