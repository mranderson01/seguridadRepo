package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.Models.Article;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
@Tag(name = "Articulos", description = "Se puede obtener un CRUD de Articulos")
public class ArticleController {

	@Operation(summary = "Articulos", description = "Este metodo devuelve uns listado de articulos.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "articulo no encontrado")
	@GetMapping("/")  
	public ResponseEntity<String> index(){
		return ResponseEntity.status(200).body("articulos encontrado: Listado de articulos"); // Estado 200 OK
	}

	@Operation(summary =  "Obtiene un Articulo", description = "Con este metodo se podrá obtener un articulo segun una id que sera de un digito.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "articulo no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se esta buscando el recurso: "+id); // Estado 200 OK
	}


	@Operation(summary =  "Actualiza un articulo", description = "Se podrá actualizar un articulo segun la id y los datos introducidos por el usuario.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "articulo no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarArticulo(@PathVariable int id,@RequestBody Article ArticleEditado){ 
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+ArticleEditado); // Estado 200 OK
	}

	@Operation(summary = "Elimina articulo", description = "Se podrá eliminar un producto segun la id del articulo, tiene que ser un solo digito.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "articulo no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId(@PathVariable int id){ 
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
