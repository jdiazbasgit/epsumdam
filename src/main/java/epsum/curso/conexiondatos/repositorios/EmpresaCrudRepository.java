package epsum.curso.conexiondatos.repositorios;

import org.springframework.data.repository.CrudRepository;

import epsum.curso.conexiondatos.entidades.Empresa;

public interface EmpresaCrudRepository extends CrudRepository<Empresa, Integer> {

	//@Query(value="SELECT id,descripcion FROM empresas.cargos where descripcion like 'M%'",nativeQuery = true)
	//@Query("from Cargo as cargo where cargo.descripcion like :dato")
	//public List<Cargo> getCargosQueEmpiezanPor(String dato);
}