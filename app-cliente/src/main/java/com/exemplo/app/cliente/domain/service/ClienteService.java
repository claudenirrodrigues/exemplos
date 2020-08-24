package com.exemplo.app.cliente.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.app.cliente.domain.exception.DomainException;
import com.exemplo.app.cliente.domain.model.Cliente;
import com.exemplo.app.cliente.domain.repository.ClienteRepository;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new DomainException("Já existe um cliente cadastrado com este CPF.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
