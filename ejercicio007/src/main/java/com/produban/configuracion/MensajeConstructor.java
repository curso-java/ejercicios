package com.produban.configuracion;


public class MensajeConstructor {

    private String mensaje = null;

    public MensajeConstructor(String mensaje) {
        this.mensaje = mensaje;
    }


    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
