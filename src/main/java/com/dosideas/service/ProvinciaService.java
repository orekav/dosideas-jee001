/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

/**
 *
 * @author escuelita
 */
public interface ProvinciaService {
    public Provincia buscarPorId(Long aID);
    public List<Provincia> buscarPorNombreExacto(String unNombre);
    public List<Provincia> buscarPorNombreGeneral(String unNombre);
    public List<Provincia> buscarPorNombreDePais(String unNombre);
    public void grabarProvincia(Provincia unaProvincia);
}
