package com.exemplo.spring.apicliente.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.spring.apicliente.domain.repository.ClienteRepository;

@RestController
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public String listar() {
		return "teste";
	}

}
