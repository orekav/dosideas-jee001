package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Pais;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
@Transactional
public class PaisServiceComponenteTest {

    /** La instancia bajo test.
     *  La anotación @Autowired hará que Spring la inyecte automáticamente
     */
    @Autowired
    private PaisService instance;

    /**
     * Test de buscarPorId method con un id existente.
     * El metodo debe encontrar un Pais con el id buscado.
     */
    @Test
    public void buscarPorId_ConIdExistente_retornaProvinciaConEseId() {
        Long id = 1L;
        Pais pais = instance.buscarPorId(id);
        assertNotNull(pais);
        assertEquals(id, pais.getId());
        assertEquals("Argentina", pais.getNombre());
    }

    /**
     * Test de buscarPorId method con un id inexistente.
     * El metodo debe devolver null al buscar un id que no existe.
     */
    @Test
    public void buscarPorId_ConIdInexistente_retornaNull() {
        Long id = 21L;
        Pais pais = instance.buscarPorId(id);
        assertNull(pais);
    }

    /**
     * Test de buscarPorId method con un id null.
     * El metodo debe tirar una IllegalArgumentException al intengar invocar
     * al metodo con un null.
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void buscarPorId_ConIdNull_lanzaExcepcion() {
        instance.buscarPorId(null);
        fail("Debería haberse lanzado una excepción.");
    }
}
