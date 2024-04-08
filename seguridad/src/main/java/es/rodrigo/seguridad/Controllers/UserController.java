package es.rodrigo.seguridad.Controllers;


import es.rodrigo.seguridad.security.User.User;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Controlador de usuarios", description = "Se puede obtener un CRUD de Usuarios")
public class UserController {


	@Operation(summary = "Obtiene una lista de usuarios", description = "Este metodo devuelve un listado de usuarios.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "usuario no encontrado")
	@GetMapping("/")
	public ResponseEntity<String> index(){
		System.out.println("hola");		
		return ResponseEntity.status(200).body("Recurso encontrado: "); // Estado 200 OK
	}


	@Operation(summary = "Obtiene un usuario por id", description = "Este metodo devuelve un usuarios por id, el id tiene que se un integer")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "usuario no encontrado")
	@GetMapping("/{id}") 
	public ResponseEntity<String> obtenerPorId(@Parameter(description = "id usuario",required = true,example = "1")
												   @PathVariable int id){
		return ResponseEntity.status(200).body("Se esta buscando el usuario: "+id); // Estado 200 OK
	}


	@Operation(summary = "Actualizar", description = "Este metodo actualiza un user, segun la id y la información enviada")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "usuario no encontrado")
	@PutMapping("/{id}") 
	public ResponseEntity<String> actualizarUser(@Parameter(description = "id usuario",required = true,example = "1")
													 @PathVariable int id,@RequestBody User ProjectoEditado){
		return ResponseEntity.status(200).body("Se ha editado el projecto con id: "+id + "Estos son los datos introducidos: "+ProjectoEditado); // Estado 200 OK
	}


	@Operation(summary = "Eliminar", description = "Este metodo elimina un user, segun la id.")
	@ApiResponse(responseCode = "200", description = "Operación exitosa")
	@ApiResponse(responseCode = "404", description = "usuario no encontrado")
	@DeleteMapping("/{id}") 
	public ResponseEntity<String> eliminarPorId( @Parameter(description = "id usuario",required = true,example = "1")
													 @PathVariable int id){
		return ResponseEntity.status(200).body("Se borrar este recurso con id: "+id); // Estado 200 OK
	}
}
