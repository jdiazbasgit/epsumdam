package epsum.curso.conexiondatos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import epsum.curso.conexiondatos.entidades.Cargo;
import epsum.curso.conexiondatos.entidades.DatoLaboral;

@Repository
public interface DatoLaboralCrudRepository extends CrudRepository<DatoLaboral, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
}
