package ec.com.registro.social.controller;

import ec.com.registro.social.model.Provincia;
import ec.com.registro.social.model.Canton;
import ec.com.registro.social.service.ProvinciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ubicacion")
public class UbicacionController {

    private final ProvinciaService provinciaService;

    public UbicacionController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    // Endpoint para obtener todas las provincias
    @GetMapping("/provincias")
    public ResponseEntity<Map<String, Provincia>> getProvincias() {
        Map<String, Provincia> provincias = provinciaService.getProvincias();
        return ResponseEntity.ok(provincias);
    }

    // Endpoint para obtener cantones por provinciaId
    @GetMapping("/cantones/{provinciaId}")
    public ResponseEntity<Map<String, Canton>> getCantones(@PathVariable String provinciaId) {
        Map<String, Canton> cantones = provinciaService.getProvincias()
                .get(provinciaId)
                .getCantones();
        return ResponseEntity.ok(cantones);
    }

    // Endpoint para obtener parroquias por provinciaId y cantonId
    @GetMapping("/parroquias/{provinciaId}/{cantonId}")
    public ResponseEntity<Map<String, String>> getParroquias(
            @PathVariable String provinciaId,
            @PathVariable String cantonId) {
        Map<String, String> parroquias = provinciaService.getProvincias()
                .get(provinciaId)
                .getCantones()
                .get(cantonId)
                .getParroquias();
        return ResponseEntity.ok(parroquias);
    }

    @GetMapping("/")
public String index() {
    return "index"; // Renderiza index.html
}

}