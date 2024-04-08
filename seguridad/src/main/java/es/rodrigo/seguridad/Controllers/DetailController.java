package es.rodrigo.seguridad.Controllers;

import es.rodrigo.seguridad.Models.Detail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/detail")
@Tag(name =  "Detalles", description = "Se puede obtener un CRUD de Detalles de un projecto")
public class DetailController {



	@Operation(summary = "Obtiene una lista de Detalles de Projectos", description = "Se podrá obtener una lista de los detalles de los projectos.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "detalles no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		return ResponseEntity.status(200).body("Recurso encontrado: "); // Estado 200 OK
	}


	@Operation(summary = "Obtiene detalles", description ="Se obtiene detalles de un projectos en concreto segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "detalles no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el recurso: "+id); // Estado 200 OK
	}


	@Operation(summary = "Actualiza un Detalle de un Projecto", description = "Se podrá actualizar un detalles de un projecto segun la id y la información que sse introduzca.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "detalles no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarDetallesProjecto(@PathVariable int id,@RequestBody Detail DetallesEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+DetallesEditado); // Estado 200 OK
	}


	@Operation(summary =  "Elimina un Detalle de un Projecto", description = "Se podrá eliminar los detalles de un projecto segun la id")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "detalles no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
