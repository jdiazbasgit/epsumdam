package epsum.curso.conexiondatos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import epsum.curso.conexiondatos.entidades.Empresa;
import epsum.curso.conexiondatos.servicios.EmpresaService;
import lombok.Data;

@SpringBootTest
@Data
public class TestEmpresas {
	@Autowired
	private EmpresaService empresaService;
	
	//@Test
	public void alta() {
		System.setProperty("java.awt.headless", "false");
		Empresa empresa = new Empresa();
		empresa.setNombre("prueba test");
		empresa.setCif("B12312312");
		getEmpresaService().save(empresa);
		int id= empresa.getId();
		getEmpresaService().deleteById(empresa.getId());
		assertFalse(getEmpresaService().existById(id));
	}
	
	//@Test
	public void count() {
		assertNotEquals(getEmpresaService().count(), 0);
	}
		
	//@Test
	public void grabar() {
		System.setProperty("java.awt.headless", "false");
		Empresa empresa = new Empresa();
		empresa.setNombre("prueba test");
		empresa.setCif("B12312312");
		getEmpresaService().save(empresa);
		empresa.setNombre("prueba test modificado");
		getEmpresaService().save(empresa);
		getEmpresaService().deleteById(empresa.getId());
	}
}
