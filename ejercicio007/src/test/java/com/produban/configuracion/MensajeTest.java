package com.produban.configuracion;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MensajeTest {

    final static Logger logger = LoggerFactory.getLogger(MensajeTest.class);
    
    @Test
    public void testApplicationContext() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        
        logger.info("Tengo el contexto");

        Mensaje mensaje = (Mensaje) applicationContext.getBean("mensaje");

        assertEquals("El valor no es correcto", "datos", mensaje.getMensaje());
        logger.debug("mensaje='" + mensaje.getMensaje() + "'");
    }

}
