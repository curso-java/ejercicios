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

import com.produban.configuracion.MensajeSetter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MensajeSetterTest {

    final Logger logger = LoggerFactory.getLogger(MensajeSetterTest.class);

    @Autowired
    private MensajeSetter mensajeSetter = null;


    @Test
    public void testMensaje() {   
        assertNotNull("No funciona autowired", mensajeSetter);
        
        String mensaje = mensajeSetter.getMensaje();
        
        assertNotNull("Mensaje es null.", mensaje);
        
        String espected = "datos";
        
        assertEquals("El mensaje debe ser '" + espected + "'.", espected, mensaje);

        logger.info("mensaje='{}'", mensaje);
    }    
}
