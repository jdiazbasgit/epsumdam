package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Empresa;

public interface EmpresaCrudRepository extends CrudRepository<Empresa, Integer> {

	
}