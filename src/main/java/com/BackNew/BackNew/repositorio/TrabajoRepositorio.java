
package com.BackNew.BackNew.repositorio;

import com.BackNew.BackNew.modelo.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepositorio extends JpaRepository<Trabajo, Long>{
    
}
