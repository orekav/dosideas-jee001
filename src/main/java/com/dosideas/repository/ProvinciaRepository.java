package com.dosideas.repository;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository <Provincia, Long> {
    List<Provincia> findByNombre(String unNombre);
    List<Provincia> findByNombreContainingIgnoreCase(String unNombre);
    List<Provincia> findByPais(Pais unPais);
    Long deleteByNombreContainingIgnoreCase(String unNombre);
    Long deleteByNombre(String unNombre);
}
