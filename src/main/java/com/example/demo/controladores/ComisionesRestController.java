package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entidades.Comision;
import com.example.demo.repositorios.ComisionesCrudRepository;

import lombok.Data;


public class ComisionesRestController {
	
	@Autowired
	private ComisionesCrudRepository comisionesCrudRepository;

	public ComisionesCrudRepository getComisionesCrudRepository() {
		return comisionesCrudRepository;
	}

	public void setComisionesCrudRepository(ComisionesCrudRepository comisionesCrudRepository) {
		this.comisionesCrudRepository = comisionesCrudRepository;
	}

	@CrossOrigin(origins ="*" )
	public List<Comision> getComisiones(){
		return (List<Comision>) getComisionesCrudRepository().findAll();
	}

	
	
}
