package es.rodrigo.seguridad.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> index(){
        return ResponseEntity.status(200).body("Se ha entrado en el index de home");
    }
}
