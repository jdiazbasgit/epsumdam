package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Empleado;

//@Repository
public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

}
