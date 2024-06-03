package epsum.curso.conexiondatos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;

import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.repositorios.EmpresaCrudRepository;
import lombok.Data;

@Service
@Data
public class EmpresaService {

	@Autowired
	private EmpresaCrudRepository empresaCrudRepository;
	
	public Iterable<Empresa> findAll(){
		return getEmpresaCrudRepository().findAll();
	}
	
	public Empresa save(Empresa empresa) {
		return getEmpresaCrudRepository().save(empresa);
	}
	
	public long count() {
		return getEmpresaCrudRepository().count();
	}
	public void deleteById(int id) {
		getEmpresaCrudRepository().deleteById(id);
	}
	
	public boolean existById(int id) {
		return getEmpresaCrudRepository().existsById(id);
	}
}
