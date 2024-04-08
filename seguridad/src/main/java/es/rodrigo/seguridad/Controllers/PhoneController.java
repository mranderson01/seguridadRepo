package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.Models.Phone;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/phone")
@Tag(name = "Telefono", description = "Se puede obtener un CRUD de telefonos de usuarios")
public class PhoneController {


	@Operation(summary ="Obtiene Telefonos", description = "Se podrá obtener una lista de todos los telefonos de los usuarios.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "telefono no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		System.out.println("hola");		
		return ResponseEntity.status(200).body("Recurso encontrado: "); // Estado 200 OK
	}


	@Operation(summary = "Obtiene un Telefono", description = "Se podrá obtener un numero de telefono segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "telefono no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el recurso: "+id); // Estado 200 OK
	}


	@Operation(summary = "Edita un Telefono", description = "Se podria actualizar un telefono segun la id del telefono y la nueva información que se inserte.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "telefono no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarTelefono(@PathVariable int id,@RequestBody Phone TelefonoEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+TelefonoEditado); // Estado 200 OK
	}


	@Operation(summary ="Elimina un Telefono", description = "Se podrá eliminar un telefono segun la id de un telefono.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "telefono no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
