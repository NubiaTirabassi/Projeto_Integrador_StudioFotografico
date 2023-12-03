package br.com.pi.projetoIntegrador.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Lob;

@Entity
@Table(name = "Documentos")
public class Documentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", nullable=false, length=100)
    private String nome;

    @Column(name = "nomeArmazenamento", nullable=false, length=100)
    private String nomeArmazenamento;

    @ManyToOne
    @JoinColumn(name = "idGrupo", nullable=false, referencedColumnName = "id")
    private Grupos grupos;
    
    @Lob
    @Column(name = "conteudoArquivo", nullable=false)
    private byte[] conteudoArquivo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeArmazenamento() {
		return nomeArmazenamento;
	}

	public void setNomeArmazenamento(String nomeArmazenamento) {
		this.nomeArmazenamento = nomeArmazenamento;
	}

	public Grupos getGrupos() {
		return grupos;
	}

	public void setGrupos(Grupos grupos) {
		this.grupos = grupos;
	}

	public byte[] getConteudoArquivo() {
		return conteudoArquivo;
	}

	public void setConteudoArquivo(byte[] conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}


    
}
