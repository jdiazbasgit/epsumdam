package epsum.curso.conexiondatos.repositorios;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import epsum.curso.conexiondatos.entidades.EstadoCivil;

@Repository
public interface EstadoCivilCrudRepository extends CrudRepository<EstadoCivil, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
}
