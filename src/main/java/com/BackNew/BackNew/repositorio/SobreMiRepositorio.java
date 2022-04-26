
package com.BackNew.BackNew.repositorio;

import com.BackNew.BackNew.modelo.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobreMiRepositorio extends JpaRepository<SobreMi, Long> {
    
}
