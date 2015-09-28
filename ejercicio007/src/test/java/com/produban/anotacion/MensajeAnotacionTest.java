package com.produban.anotacion;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.produban.anotacion.MensajeAnotacion;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MensajeAnotacionTest {

    final Logger logger = LoggerFactory.getLogger(MensajeAnotacionTest.class);

    @Autowired
    private MensajeAnotacion mensajeAnotacion = null;


    @Test
    public void testMensaje() {   
        assertNotNull("No funciona autowired", mensajeAnotacion);
        
        String mensaje = mensajeAnotacion.getMensaje();
        
        assertNotNull("Mensaje es null.", mensaje);
        
        String espected = "datos";
        
        assertEquals("El mensaje debe ser '" + espected + "'.", espected, mensaje);

        logger.info("mensaje='{}'", mensaje);
    } 
}
