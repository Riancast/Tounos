package com.tounos.juego.tounos;

/**
 * Created by juanfrancisco on 17/05/2016.
 */
public class Comunicador {
    private static Object objeto = null;

    public static void setObjeto(Object newObjeto) {
        objeto = newObjeto;
    }

    public static Object getObjeto() {
        return objeto;
    }
}
