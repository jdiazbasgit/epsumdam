package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Comision;
import com.example.demo.entidades.TiposIva;

public interface TiposIvaCrudRepository extends CrudRepository<Comision, Integer> {

}
