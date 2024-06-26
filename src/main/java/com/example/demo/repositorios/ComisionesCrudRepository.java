package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Articulo;
import com.example.demo.entidades.Comision;

public interface ComisionesCrudRepository extends CrudRepository<Comision, Integer> {

}
