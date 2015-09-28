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

import com.produban.configuracion.MensajeConstructor;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MensajeConstructorTest {

    final Logger logger = LoggerFactory.getLogger(MensajeConstructorTest.class);

    @Autowired
    private MensajeConstructor mensajeConstructor = null;


    @Test
    public void testMensaje() {   
        assertNotNull("El objeto obtenido es null.", mensajeConstructor);
        
        String mensaje = mensajeConstructor.getMensaje();
        
        assertNotNull("El mensaje es null.", mensaje);
        
        String expected = "datos";
        
        assertEquals("El mensaje debe ser '" + expected + "'.", expected, mensaje);

        logger.info("mensaje='{}'", mensaje);
    }
    
}
