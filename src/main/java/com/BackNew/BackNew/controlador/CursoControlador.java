
package com.BackNew.BackNew.controlador;

import com.BackNew.BackNew.excepciones.ResourceNotFoundException;
import com.BackNew.BackNew.modelo.Curso;
import com.BackNew.BackNew.repositorio.CursoRepositorio;
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
public class CursoControlador {
    
    @Autowired
    private CursoRepositorio repositorio;
    
    @GetMapping("/cursos")
    public List<Curso> listarTodosLosCursos(){
        return repositorio.findAll();
    }
    
    @PostMapping("/cursos")
    public Curso guardarCurso(@RequestBody Curso curso){
        return repositorio.save(curso);
    }
    
    @GetMapping("/cursos/{id}")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No existe el cuso con el ID: " + id));
        return ResponseEntity.ok(curso);
    }
    
    @PutMapping("/cursos/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso detallesCurso){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No Existe el curso con ese ID :" + id));
        
        curso.setNombre(detallesCurso.getNombre());
        curso.setInstitucion(detallesCurso.getInstitucion());
        curso.setDescripcion(detallesCurso.getDescripcion());
        curso.setLink(detallesCurso.getLink());
        
        Curso cursoActualizado = repositorio.save(curso);
        return ResponseEntity.ok(cursoActualizado);
    }
    
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarCurso(@PathVariable Long id){
        Curso curso = repositorio.findById(id) .orElseThrow(()-> new ResourceNotFoundException("No Existe el curso con ese ID :" + id));
        
        repositorio.delete(curso);
        Map<String,Boolean> respuesta = new HashMap<>();
        return ResponseEntity.ok(respuesta);
    }
}
