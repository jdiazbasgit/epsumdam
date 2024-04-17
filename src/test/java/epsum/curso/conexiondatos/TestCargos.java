//package epsum.curso.conexiondatos;
//
////Importaciones necesarias para las pruebas unitarias y la configuración de Spring Boot
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
////Importaciones de las clases que se van a probar
//import epsum.curso.conexiondatos.entidades.Cargo;
//import epsum.curso.conexiondatos.servicios.CargoService;
//
////Importación de la anotación Lombok para la generación automática de métodos getter y setter
//import lombok.Data;
//
////Anotación que indica que esta clase es una prueba de integración de Spring Boot
//@SpringBootTest
//@Data // Anotación de Lombok para la generación automática de getters y setters
//public class TestCargos {
// // Inyección del servicio CargoService para poder utilizarlo en las pruebas
// @Autowired
// private CargoService cargoService;
// 
// // Método de prueba para probar el alta de un nuevo cargo
// @Test
// public void alta() {
//     // Establece que la propiedad "java.awt.headless" sea "false" para permitir la creación de ventanas
//     System.setProperty("java.awt.headless", "false");
//     
//     // Creación de un nuevo objeto Cargo para la prueba
//     Cargo cargo = new Cargo();
//     cargo.setDescripcion("prueba alta"); // Establece una descripción para el cargo
//     
//     // Guarda el cargo en la base de datos utilizando el servicio CargoService
//     getCargoService().save(cargo);
//     
//     // Elimina el cargo recién creado de la base de datos utilizando el servicio CargoService
////     getCargoService().deleteById(cargo.getId());
// }
// @Test
// public void testModificacion() {
//     // Obtener un cargo existente de la base de datos (puedes modificar este paso según tus necesidades)
//     Cargo cargoExistente = obtenerCargoExistente();
//
//     // Guardar el valor original de la descripción del cargo
//     descripcionOriginal = cargoExistente.getDescripcion();
//
//     // Modificar la descripción del cargo
//     String nuevaDescripcion = "Nueva descripción";
//     cargoExistente.setDescripcion(nuevaDescripcion);
//
//     // Guardar el cargo modificado en la base de datos utilizando el servicio CargoService
//     Cargo cargoModificado = cargoService.modificar(cargoExistente);
//
//     // Verificar que la descripción del cargo modificado sea la nueva descripción
//     assertEquals(nuevaDescripcion, cargoModificado.getDescripcion());
//
//     // Si la descripción cambió, revertir al valor original
//     if (!descripcionOriginal.equals(nuevaDescripcion)) {
//         cargoExistente.setDescripcion(descripcionOriginal);
//         cargoService.modificar(cargoExistente);
//     }
//
//}

