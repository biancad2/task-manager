package br.com.fatec.gerenciadortarefas.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tar_tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tar_id")
	private Long id;

	@Column(name = "tar_titulo", length = 50, nullable = false)
	@NotNull(message = "O titulo e obrigatorio")
	@Length(max = 50, min = 3, message = "O titulo deve contar entre 3 e 50 caracteres.")
	private String titulo;

	@Length(max = 50, message = "A descricao deve conter ate 100 caracteres.")
	@Column(name = "tar_descricao", length = 100, nullable = true)
	private String descricao;

	@Column(name = "tar_data_expiracao", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataExpiracao;

	@Column(name = "tar_concluida", nullable = false)
	private Boolean concluida = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usr_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
