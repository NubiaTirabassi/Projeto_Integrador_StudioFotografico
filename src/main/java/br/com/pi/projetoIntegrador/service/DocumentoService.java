package br.com.pi.projetoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.projetoIntegrador.model.Documentos;
import br.com.pi.projetoIntegrador.repository.DocumentosRepository;

@Service
public class DocumentoService {

	@Autowired
	private DocumentosRepository documentosRepository;

	public List<Documentos> listarDocumento() {
		return documentosRepository.findAll();
	}

	public Documentos consultarDocumentoId(Integer id) {
		Optional<Documentos> documentos = documentosRepository.findById(id);
		return documentos.orElse(null);
	}

	public Documentos criarDocumento(Documentos documentos) {
		return documentosRepository.save(documentos);
	}

	public Documentos atualizarDocumento(Integer id, Documentos documentos) {
		if (documentosRepository.existsById(id)) {
			documentos.setId(id);
			return documentosRepository.save(documentos);

		}
		return null;
	}

	public void excluirDocumento(Integer id) {
		documentosRepository.deleteById(id);
	}

}
