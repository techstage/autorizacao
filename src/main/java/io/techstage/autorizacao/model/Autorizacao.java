package io.techstage.autorizacao.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
public class Autorizacao {
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  Long id;
  String statux;  
  Long transacao;
  Long pagamento;
  Double valor;
	Long cliente;
	String nome;

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getStatux() {
      return statux;
    }

    public void setStatux(String statux) {
      this.statux = statux;
    }

    public Long getTransacao() {
      return transacao;
    }

    public void setTransacao(Long transacao) {
      this.transacao = transacao;
    }

    public Long getPagamento() {
      return pagamento;
    }

    public void setPagamento(Long pagamento) {
      this.pagamento = pagamento;
    }

    public Double getValor() {
      return valor;
    }

    public void setValor(Double valor) {
      this.valor = valor;
    }

    public Long getCliente() {
      return cliente;
    }

    public void setCliente(Long cliente) {
      this.cliente = cliente;
    }

    public String getNome() {
      return nome;
    }

    public void setNome(String nome) {
      this.nome = nome;
    }
  
}