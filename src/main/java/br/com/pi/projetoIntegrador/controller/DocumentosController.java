package br.com.pi.projetoIntegrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import br.com.pi.projetoIntegrador.service.DocumentoService;

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
	
	@GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadDocumento(@PathVariable Integer id) {
        Documentos documento = documentoService.consultarDocumentoId(id);
        if (documento == null || documento.getConteudoArquivo() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ByteArrayResource resource = new ByteArrayResource(documento.getConteudoArquivo());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + documento.getNomeArmazenamento())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(documento.getConteudoArquivo().length)
                .body(resource);
    }
	
}


