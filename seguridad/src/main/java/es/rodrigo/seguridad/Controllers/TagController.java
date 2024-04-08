package es.rodrigo.seguridad.Controllers;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import  io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tag")
@Tag(name ="Projectos", description = "Se puede obtener un CRUD de Projecto")
public class TagController {



	@Operation(summary = "Obtiene una lista de etiquetas", description ="Se podrá obtener una lista de las etiquetas."  )
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "tag no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		System.out.println("hola");		
		return ResponseEntity.status(200).body("tag encontrado: "); // Estado 200 OK
	}


	@Operation(summary = "Obtiene una etiqueta", description ="Se podrá obtener una etiqueta segun la id."  )
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "tag no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el tag: "+id); // Estado 200 OK
	}


	@Operation(summary = "Actualiza una etiqueta", description = "Se podrá actualizar una etiqueta segun el id y la información de la etiqueta"  )
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "tag no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarProjecto(@PathVariable int id,@RequestBody Tag TagEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el tag con id: "+id + "Estos son los datos introducidos: "+TagEditado); // Estado 200 OK
	}


	@Operation(summary ="Elimina una etiqueta", description = "Se podrá  eliminar una etiqueta segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "tag no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este tag con id: "+id); // Estado 200 OK
	}
}
