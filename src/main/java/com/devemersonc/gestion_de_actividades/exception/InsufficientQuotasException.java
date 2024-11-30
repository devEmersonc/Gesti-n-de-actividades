package com.devemersonc.gestion_de_actividades.exception;

public class InsufficientQuotasException extends RuntimeException{

    public InsufficientQuotasException() {
        super("Lo sentimos. No quedan cupos para esta actividad.");
    }
}
