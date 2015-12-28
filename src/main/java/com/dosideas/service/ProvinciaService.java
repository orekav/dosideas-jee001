package com.dosideas.service;

import com.dosideas.domain.Provincia;
import java.util.List;

public interface ProvinciaService {
    public Provincia buscarPorId(Long aID);
    public List<Provincia> buscarPorNombreExacto(String unNombre);
    public List<Provincia> buscarPorNombreGeneral(String unNombre);
    public List<Provincia> buscarPorNombreDePais(String unNombre);
    public void grabarProvincia(Provincia unaProvincia);
}
