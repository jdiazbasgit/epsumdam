package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.DatoPersonal;

@Repository
public interface DatosPersonalesCrudRepository extends CrudRepository<DatoPersonal, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
}
