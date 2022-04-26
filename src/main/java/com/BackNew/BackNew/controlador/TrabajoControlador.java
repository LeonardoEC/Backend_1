
package com.BackNew.BackNew.controlador;

import com.BackNew.BackNew.excepciones.ResourceNotFoundException;
import com.BackNew.BackNew.modelo.Trabajo;
import com.BackNew.BackNew.repositorio.TrabajoRepositorio;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TrabajoControlador {
    
    @Autowired
    private TrabajoRepositorio repositorio;
    
    @GetMapping("/trabajos")
    public List<Trabajo> listarTodosLosTrabajos(){
        return repositorio.findAll();
    }
    
    @PostMapping("/trabajos")
    public Trabajo guardarTrabajo(@RequestBody Trabajo trabajo){
        return repositorio.save(trabajo);
    }
    
    @GetMapping("/trabajos/{id}")
    public ResponseEntity<Trabajo> obtenerTrabajo(@PathVariable Long id){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No existe el trabajo con el ID: " + id));
        return ResponseEntity.ok(trabajo);
    }
    
    @PutMapping("/trabajo/{id}")
    public ResponseEntity<Trabajo> actulizarTrabajo(@PathVariable Long id, @RequestBody Trabajo detallesTrabajo){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No existe el trabajo con el ID: " + id));
        
        trabajo.setNombre(detallesTrabajo.getNombre());
        trabajo.setPuesto(detallesTrabajo.getPuesto());
        trabajo.setReferencia(detallesTrabajo.getReferencia());
        trabajo.setDescripcion(detallesTrabajo.getDescripcion());
        
        Trabajo trabajoActualizado = repositorio.save(trabajo);
        return ResponseEntity.ok(trabajoActualizado);
    }
    
    @DeleteMapping("/trabajo/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarTrabajo(@PathVariable Long id){
        Trabajo trabajo = repositorio.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No existe el trabajo con el ID: " + id));
        
        repositorio.delete(trabajo);
        Map<String,Boolean> repuesta = new HashMap<>();
        return ResponseEntity.ok(repuesta);
    }
}
