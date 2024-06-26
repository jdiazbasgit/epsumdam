package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entidades.Empleado;

//@Repository
public interface EmpleadoCrudRepository extends CrudRepository<Empleado, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
	
	public List<Empleado> findByNombreEquals(String nombre);
}
