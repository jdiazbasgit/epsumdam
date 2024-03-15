package epsum.curso.conexiondatos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import epsum.curso.conexiondatos.entidades.Cargo;

//@Repository
public interface CargoCrudRepository extends CrudRepository<Cargo, Integer> {

}
