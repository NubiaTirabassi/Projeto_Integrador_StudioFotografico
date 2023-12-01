package br.com.pi.projetoIntegrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.projetoIntegrador.model.Grupos;
import br.com.pi.projetoIntegrador.repository.GruposRepository;

@Service
public class GrupoService {

	@Autowired
	private GruposRepository gruposRepository;

	public List<Grupos> listarGrupos() {
		return gruposRepository.findAll();
	}

	public Grupos consultarGrupoId(Integer id) {
		Optional<Grupos> grupos = gruposRepository.findById(id);
		return grupos.orElse(null);
	}

	public Grupos criarGrupo(Grupos grupos) {
		return gruposRepository.save(grupos);
	}

	public Grupos atualizarGrupo(Integer id, Grupos grupos) {
		if (gruposRepository.existsById(id)) {
			grupos.setId(id);
			return gruposRepository.save(grupos);
		}
		return null;
	}

	public void excluirGrupo(Integer id) {
		gruposRepository.deleteById(id);

	}

}
