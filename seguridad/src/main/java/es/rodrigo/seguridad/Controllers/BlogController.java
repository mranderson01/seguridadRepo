package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.Models.Blog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/blog")
@Tag(name = "Blog", description = "Se puede obtener un CRUD de Blogs")
public class BlogController {

	@Operation(summary = "Obtener Blogs", description = "Se podrá obtener un listado de blogs.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "Blogs no encontrado")
	@GetMapping("/") 
	public ResponseEntity<String> index(){
		System.out.println("hola");		
		return ResponseEntity.status(200).body("Recurso encontrado: "); // Estado 200 OK
	}

	@Operation(summary = "Obtiene un blog", description = "se podrá obtener un blog con dicha id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "Blogs no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el Blog: "+id); // Estado 200 OK
	}

	@Operation(summary = "Actualiza un blog", description ="se podria actualizar un blog segun la id y información que se introdujo.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "Blogs no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarBlog(@PathVariable int id,@RequestBody Blog BlogEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+BlogEditado); // Estado 200 OK
	}


	@Operation(summary ="Elimina un blog", description = "Se podrá eliminar en blog ")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "Blogs no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
