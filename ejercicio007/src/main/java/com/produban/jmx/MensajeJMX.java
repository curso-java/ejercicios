package com.produban.jmx;

import org.springframework.stereotype.Service;

@Service
public class MensajeJMX {
    private String mensaje = "datos";
    private int cuenta = 0;
    
    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


	public int getCuenta() {
		return cuenta;
	}


	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
}
