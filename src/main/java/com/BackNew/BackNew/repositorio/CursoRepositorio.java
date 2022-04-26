
package com.BackNew.BackNew.repositorio;

import com.BackNew.BackNew.modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso,Long> {
    
}
