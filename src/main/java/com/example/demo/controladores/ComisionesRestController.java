package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Comision;
import com.example.demo.repositorios.ComisionesCrudRepository;

import lombok.Data;

@RestController
public class ComisionesRestController {
	
	@Autowired
	private ComisionesCrudRepository comisionesCrudRepository;

	public ComisionesCrudRepository getComisionesCrudRepository() {
		return comisionesCrudRepository;
	}

	public void setComisionesCrudRepository(ComisionesCrudRepository comisionesCrudRepository) {
		this.comisionesCrudRepository = comisionesCrudRepository;
	}
	@CrossOrigin(origins="*")
	@GetMapping("comisiones")
	public List<Comision> getComisiones(){
		return (List<Comision>) getComisionesCrudRepository().findAll();
	}

	
	
}
