package br.com.myapp.managedbean.integrante;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.myapp.exception.BusinessException;
import br.com.myapp.model.Integrante;
import br.com.myapp.model.Sexo;
import br.com.myapp.service.IntegranteService;

@ManagedBean
@ViewScoped
public class IntegranteMB {

	private String nome;

	private String cpf;

	private String email;

	private Sexo sexo;

	private Date dataNascimento;

	private String logradouro;

	private String numero;

	private String uf;

	private String cidade;

	private String cep;

	@EJB
	private IntegranteService integranteService;

	@PostConstruct
	public void init() {

	}

	public void salvar() {

		try {

			final Integrante integrante = new Integrante();
			integrante.setCep("9999-999");
			integrante.setCidade("Recife");
			integrante.setCpf("999.999.999-99");
			integrante.setDataNascimento(Calendar.getInstance().getTime());
			integrante.setEmail("abc@abc.com");
			integrante.setLogradouro("rua");
			integrante.setNome("teste");
			integrante.setNumero("s/n");
			integrante.setSexo(Sexo.M);
			integrante.setUf("pe");

			this.integranteService.criar(integrante);
		} catch (final BusinessException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso!", "erro"));
		}
	}

	public String getNome() {

		return this.nome;
	}

	public void setNome(final String nome) {

		this.nome = nome;
	}

	public String getCpf() {

		return this.cpf;
	}

	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(final String email) {

		this.email = email;
	}

	public Sexo getSexo() {

		return this.sexo;
	}

	public void setSexo(final Sexo sexo) {

		this.sexo = sexo;
	}

	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	public String getLogradouro() {

		return this.logradouro;
	}

	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	public String getNumero() {

		return this.numero;
	}

	public void setNumero(final String numero) {

		this.numero = numero;
	}

	public String getUf() {

		return this.uf;
	}

	public void setUf(final String uf) {

		this.uf = uf;
	}

	public String getCidade() {

		return this.cidade;
	}

	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	public String getCep() {

		return this.cep;
	}

	public void setCep(final String cep) {

		this.cep = cep;
	}

}
