package com.produban.anotacion;

import org.springframework.stereotype.Service;

@Service
public class MensajeAnotacion {
    private String mensaje = "datos";

    
    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
