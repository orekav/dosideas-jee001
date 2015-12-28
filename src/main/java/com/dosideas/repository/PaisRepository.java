package com.dosideas.repository;

import com.dosideas.domain.Pais;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    List<Pais> findByNombre(String unNombre);
}
