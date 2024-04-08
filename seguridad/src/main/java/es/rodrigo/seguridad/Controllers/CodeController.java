package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.Models.Code;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/code")
@Tag(name =  "Codigo", description = "Se puede obtener un CRUD de Codigos")
public class CodeController {



	@Operation(summary ="Lista Codigos", description = "Se podrá obtener una lista de codigos.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "codigo no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		return ResponseEntity.status(200).body("Recurso encontrado: "); // Estado 200 OK
	}

	@Operation(summary ="Obtiene un blog", description = "Se podrá obtener un codigo segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "codigo no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el recurso: "+id); // Estado 200 OK
	}


	@Operation(summary = "Actualiza una blog", description = "Se podrá actualizar un codigo segun la id y la información que se introduzca.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "codigo no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarCode(@PathVariable int id,@RequestBody Code CodigoEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+CodigoEditado); // Estado 200 OK
	}


	@Operation(summary = "Elimina un blog", description = "Se podrá eliminar el codigo segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "codigo no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
