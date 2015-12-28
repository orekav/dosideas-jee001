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

/**
 * Esta clase representa un test de componente. Los tests de componentes
 * se encargan de testear una clase en particular, y todas las dependencias
 * que la misma tiene.
 *
 * Este test comprueba el funcionamiento de la clase PaisRepository. Esta clase
 * utiliza Spring Data para acceder a la base de datos. Es necesario tener
 * entonces la base de datos iniciada, con el modelo de datos del workshop
 * cargado (ver archivo "Instrucciones para crear la BD").
 *
 * Para iniciar la base de datos:
 *   Ir al menu Window > Services > Databases > Java DB > Click derecho > Start server
 *
 * Para ejecutar este test en NetBeans:
 *    click derecho > "Test File" (CTRL + F6)
 *
 * @author ldeseta
 */
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
