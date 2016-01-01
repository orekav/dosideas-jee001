package com.dosideas.service;

import com.dosideas.ApplicationConfig;
import com.dosideas.domain.Provincia;
import com.dosideas.exception.NombreInvalidoException;
import com.dosideas.exception.ProvinciaInvalidaException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
@Transactional
public class ProvinciaServiceTest {
    
    @Autowired
    private ProvinciaService provinciaService;

    @Test
    public void buscarPorId_IdExiste_retornaProvinciaConEseId(){
        Long id = new Long(1);
        Provincia provincia  = provinciaService.buscarPorId(id);        
        assertEquals(id.longValue(), provincia.getId().longValue());
    }
    
    @Test
    public void buscarPorId_IdNoExiste_retornaNull(){
        Long id = new Long(300);        
        assertNull(provinciaService.buscarPorId(id));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void buscarPorId_IdEsNull_tiraExcepcion(){
        Long id = null;
        provinciaService.buscarPorId(id);
    }
    
    @Test
    public void buscarPorNombreExacto_NombreExiste_retornaProvinciaConEseNombre(){
        Provincia provincia  = (provinciaService.buscarPorNombreExacto("Cordoba")).get(0);        
        assertEquals("Cordoba", provincia.getNombre());
    }
    
    @Test
    public void buscarPorNombreExacto_NombreNoExiste_retornaListaVacia(){
        List<Provincia> provincias  = provinciaService.buscarPorNombreExacto("Montevideo");        
        assertTrue(provincias.isEmpty());
    }
    
    @Test(expected=NombreInvalidoException.class)
    public void buscarPorNombreExacto_NombreNull_tiraExcepcion(){
        provinciaService.buscarPorNombreExacto(null);        
    }
    
    @Test(expected=NombreInvalidoException.class)
    public void buscarPorNombreExacto_NombreCorto_tiraExcepcion(){
        provinciaService.buscarPorNombreExacto("Ab");        
    }    

    @Test
    public void buscarPorNombreGeneral_NombreExiste_retornaListaConTresProvincias(){
        List<Provincia> provincias = provinciaService.buscarPorNombreGeneral("san");
        assertEquals(3, provincias.size());
    }    
    
    @Test
    public void buscarPorNombreGeneral_NombreDePaisArgentina_retornaListaDeProvinciasConPaisArgentina(){
        List<Provincia> provincias = provinciaService.buscarPorNombreDePais("Argentina");
        assertEquals(20, provincias.size());
    }    
    
    @Test
    public void buscarPorNombreGeneral_NombreDePaisBrasil_retornaListaVacia(){
        List<Provincia> provincias = provinciaService.buscarPorNombreDePais("Brasil");
        assertEquals(0, provincias.size());
    }    
    
    @Test
    public void grabarProvincia_ProvinciaValida_seCompruebaElCorrectoGuardado(){
        Provincia provincia  = new Provincia();
        provincia.setId(25L);
        provincia.setNombre("Nuevalandia");
        provinciaService.grabarProvincia(provincia);
        
        Provincia provinciaB = (provinciaService.buscarPorNombreExacto("Nuevalandia")).get(0);
        assertEquals("Nuevalandia", provinciaB.getNombre());
    }
    
    @Test(expected=ProvinciaInvalidaException.class)
    public void grabarProvincia_ProvinciaEsNull_tiraExcepcion(){
        provinciaService.grabarProvincia(null);
    }
    
    @Test(expected=ProvinciaInvalidaException.class)
    public void grabarProvincia_ProvinciaConIdNull_tiraExcepcion(){
        Provincia provincia  = new Provincia();
        provincia.setNombre("Nuevalandia");
        provinciaService.grabarProvincia(provincia);
    }
    
    @Test(expected=ProvinciaInvalidaException.class)
    public void grabarProvincia_ProvinciaConNombreNull_tiraExcepcion(){
        Provincia provincia  = new Provincia();
        provincia.setId(25L);
        provinciaService.grabarProvincia(provincia);
    }
    
    @Test(expected=ProvinciaInvalidaException.class)
    public void grabarOActualizarProvincia_ProvinciaConNombreCorto_tiraExcepcion(){
        Provincia provincia  = new Provincia();
        provincia.setId(25L);
        provincia.setNombre("AB");
        provinciaService.grabarProvincia(provincia);
    }
    
    @Test
    public void borrarPorNombreGeneral_NombreCoincide_BorraTresProvincias(){
        Long cantidadBorradas = provinciaService.borrarPorNombreGeneral("san");
        assertEquals(3, cantidadBorradas.longValue());
    }
    
    @Test(expected=NombreInvalidoException.class)
    public void borrarPorNombreExacto_NombreCorto_tiraExcepcion(){
        provinciaService.borrarPorNombreExacto("Ab");        
    }
    
    @Test(expected=NombreInvalidoException.class)
    public void borrarPorNombreExacto_NombreNull_tiraExcepcion(){
        provinciaService.borrarPorNombreExacto(null);        
    }
    
    @Test
    public void borrarPorNombreExacto_NombreExiste_BorraUnaProvincia(){
        Long cantidadBorradas = provinciaService.borrarPorNombreExacto("Cordoba");
        assertEquals(1, cantidadBorradas.longValue());
    }
    
    @Test
    public void borrarPorNombreExacto_NombreNoExiste_NoBorra(){
        Long cantidadBorradas  = provinciaService.borrarPorNombreExacto("Montevideo");        
        assertEquals(0, cantidadBorradas.longValue());
    }
}
