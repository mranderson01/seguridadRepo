package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.Models.Project;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@Tag(name =  "Projectos", description = "Se puede obtener un CRUD de Projecto")
public class ProjectController {


	@Operation(summary ="Lista de projectos", description ="Se podrá obtener un listado de projectos")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "projectos no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		System.out.println("hola");		
		return ResponseEntity.status(200).body("Recurso encontrado: lista de proyectos "); // Estado 200 OK
	}


	@Operation(summary = "Obtiene un projecto", description ="Se podria obtener un projecto por su id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "projectos no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){
		return ResponseEntity.status(200).body("Se esta buscando el recurso: "+id); // Estado 200 OK
	}


	@Operation(summary ="Actualiza un projecto", description = "Se podrá actualizar un projecto segun la id y la información que se introduzca."  )
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "projectos no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarProjecto(@PathVariable int id,@RequestBody Project ProjectoEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+ProjectoEditado); // Estado 200 OK
	}


	@Operation(summary ="Elimina un projecto", description = "Se podrá eliminar un projecto segun la id que se introduzca."  )
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "projectos no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}