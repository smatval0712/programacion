package com.juego.clases;
import com.juego.modelo.Estadisticas;
//creamos la interfaz clase de la mimsma manera que la de raza, para que todas las clases sigan
// el mismo patron que la interfaz. Añadimos la funcion bonificadorEstadisticas
//para añadir las ventajas de cada clase a las estadisticas
public interface Clase {
    //funcion base para añadir bonificaciones segun la clase
    void bonificadorEstadisticas (Estadisticas estadisticas);

}


