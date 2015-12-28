package com.dosideas.service.impl;

import com.dosideas.domain.Pais;
import com.dosideas.repository.PaisRepository;
import com.dosideas.service.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Pais buscarPorId(Long id) {
        return paisRepository.findOne(id);
    }

    @Override
    public List<Pais> buscarTodos() {
        return paisRepository.findAll();
    }

}
