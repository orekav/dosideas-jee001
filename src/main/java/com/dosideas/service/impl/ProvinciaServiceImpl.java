package com.dosideas.service.impl;

import com.dosideas.domain.Pais;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
import com.dosideas.repository.PaisRepository;
import com.dosideas.repository.ProvinciaRepository;
import com.dosideas.service.ProvinciaService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {
    
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Provincia buscarPorId(Long aID) {
        if (aID == null)
            throw new IllegalArgumentException("No me mandes NULO");
        return provinciaRepository.findOne(aID);
    }
    
    @Override
    public List<Provincia> buscarPorNombreExacto(String unNombre) {
        if(unNombre == null || unNombre.length() < 3)
            throw new NombreInvalidoException("No me mandes NULO");        
        return provinciaRepository.findByNombre(unNombre);
    }
    
    @Override
    public List<Provincia> buscarPorNombreGeneral(String unNombre){
        return provinciaRepository.findByNombreContainingIgnoreCase(unNombre);
    }
    
    @Override
    public List<Provincia> buscarPorNombreDePais(String unNombre){
        Pais unPais = paisRepository.findByNombre(unNombre).get(0);
        return provinciaRepository.findByPais(unPais);
    }
    
    @Override
    public void grabarProvincia(Provincia unaProvincia){
        if(unaProvincia == null || 
        unaProvincia.getId() == null || 
        unaProvincia.getNombre() == null || 
        unaProvincia.getNombre().length() < 3
        )    
            throw new ProvinciaInvalidaException("");
        
        provinciaRepository.save(unaProvincia);
    }
    
    @Override
    public Long borrarPorNombreGeneral(String unNombre){
        return provinciaRepository.deleteByNombreContainingIgnoreCase(unNombre);        
    }
    
    @Override
    public Long borrarPorNombreExacto(String unNombre){
        if(unNombre == null || unNombre.length() < 3)
            throw new NombreInvalidoException("No me mandes NULO");
        return provinciaRepository.deleteByNombre(unNombre);
    }
}
