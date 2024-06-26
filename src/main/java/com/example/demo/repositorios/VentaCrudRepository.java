package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Venta;

public interface VentaCrudRepository extends CrudRepository<Venta, Integer> {

}
