package com.produban.jmx;


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
public class MensajeJMXTest {

    final Logger logger = LoggerFactory.getLogger(MensajeJMXTest.class);

    @Autowired
    private MensajeJMX mensajeJMX = null;


    @Test
    public void testMensaje() throws InterruptedException {   
        assertNotNull("No funciona autowired", mensajeJMX);
        
        String mensaje = mensajeJMX.getMensaje();
        
        assertNotNull("Mensaje es null.", mensaje);
        
        int i = 0;
        while (i<100) {
        	Thread.sleep(1000);
        	mensajeJMX.setCuenta(mensajeJMX.getCuenta() + 1);
        }        
        
        String espected = "datos";
        
        assertEquals("El mensaje debe ser '" + espected + "'.", espected, mensaje);

        logger.info("mensaje='{}'", mensaje);
    } 
}
