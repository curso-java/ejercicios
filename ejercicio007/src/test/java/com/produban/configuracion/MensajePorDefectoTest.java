package com.produban.configuracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.produban.configuracion.MensajePorDefecto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MensajePorDefectoTest {

    final Logger logger = LoggerFactory.getLogger(MensajePorDefectoTest.class);

    @Autowired
    private MensajePorDefecto mensajePorDefecto = null;


    @Test
    public void testMensaje() {   
        assertNotNull("El mensaje por defecto es null.", mensajePorDefecto);
        
        String mensaje = mensajePorDefecto.getMensaje();
        
        assertNotNull("Mensaje es null.", mensaje);
        
        String expected = "datos";
        
        assertEquals("El mensaje debe ser '" + expected + "'.", expected, mensaje);

        logger.info("mensaje='{}'", mensaje);
    }
    
}
