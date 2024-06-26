package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Articulo;

public interface ArticuloCrudRepository extends CrudRepository<Articulo, Integer> {

}
