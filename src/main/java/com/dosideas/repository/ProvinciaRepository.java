/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.repository;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author escuelita
 */
public interface ProvinciaRepository extends JpaRepository <Provincia, Long> {
    List<Provincia> findByNombre(String unNombre);
    List<Provincia> findByNombreContainingIgnoreCase(String unNombre);
    List<Provincia> findByPais(Pais unPais);
}
