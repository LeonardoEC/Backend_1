
package com.BackNew.BackNew.controlador;

import com.BackNew.BackNew.excepciones.ResourceNotFoundException;
import com.BackNew.BackNew.modelo.SobreMi;
import com.BackNew.BackNew.repositorio.SobreMiRepositorio;
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
public class SobreMiControlador {
    
    @Autowired
    private SobreMiRepositorio repositorio;
    
    @GetMapping("/sobremi")
    public List<SobreMi> listaSobreMi(){
        return repositorio.findAll();
    }
    
    @PostMapping("/sobremi")
    public SobreMi guardarSobreMi(@RequestBody SobreMi sobreMi){
        return repositorio.save(sobreMi);
    }
    
    @PutMapping("/sobremi/{id}")
    public ResponseEntity<SobreMi> actualizarSobreMi(@PathVariable Long id, @RequestBody SobreMi detalleSobreMi){
        SobreMi sobreMi = repositorio.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No existe sobreMi con el ID: " + id));
        
        sobreMi.setTitulo(detalleSobreMi.getTitulo());
        sobreMi.setDescripcion(detalleSobreMi.getDescripcion());
        
        SobreMi sobreMiActualizado = repositorio.save(sobreMi);
        return ResponseEntity.ok(sobreMiActualizado);
    }
    
    @DeleteMapping("/sobremi/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarSobreMi(@PathVariable Long id){
        SobreMi sobreMi = repositorio.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No existe sobreMi con el ID: " + id));
        
        repositorio.delete(sobreMi);
        Map<String,Boolean>repuesta = new HashMap<>();
        return ResponseEntity.ok(repuesta);
    }
    
}
