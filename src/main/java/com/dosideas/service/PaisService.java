package com.dosideas.service;

import com.dosideas.domain.Pais;
import java.util.List;

/**
 *
 * @author ldeseta
 */
public interface PaisService {
    Pais buscarPorId(Long id);
    List<Pais> buscarTodos();
}
