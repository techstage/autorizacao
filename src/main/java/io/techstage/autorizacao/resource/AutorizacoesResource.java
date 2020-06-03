package io.techstage.autorizacao.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.techstage.autorizacao.model.Autorizacao;
import io.techstage.autorizacao.repository.Autorizacoes;

@CrossOrigin
@RestController	
@RequestMapping("/autorizacao")
public class AutorizacoesResource {
  

	@Autowired
	private Autorizacoes autorizacoes;
	
	@CrossOrigin
	@PostMapping
	public Autorizacao adicionar(@Valid @RequestBody Autorizacao autorizacao) {
		return autorizacoes.save(autorizacao);
	}
	
	@CrossOrigin
	@GetMapping
	public List<Autorizacao> listar() {
		return autorizacoes.findAll();
	}
  
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Autorizacao> buscar(@PathVariable Long id) {
    Autorizacao autorizacao = autorizacoes.findById(id).get();
    
		if (autorizacao == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(autorizacao);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Autorizacao> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Autorizacao autorizacao) {
				Autorizacao existente = autorizacoes.findById(id).get();
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(autorizacao, existente, "id");
		
		existente = autorizacoes.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Autorizacao autorizacao = autorizacoes.findById(id).get();
		
		if (autorizacao == null) {
			return ResponseEntity.notFound().build();
		}
		
		autorizacoes.delete(autorizacao);
		
		return ResponseEntity.noContent().build();
  }
  
}