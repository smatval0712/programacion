package com.juego.razas;
import com.juego.modelo.Estadisticas;

import java.util.ArrayList;

//creamos la interfaz razas para luego implementarla en cada raza que creemos y nos aseguramos de que
//cada raza se utilice de la misma forma sin importar cual sea.
//cada raza será una raza distinta pero, en definitiva, sera una raza.
public interface Raza {

    //lo que habra dentro de razas y que todas las razas que creemos deben tener sera el metodo
    //para rellenar el constructor de estadisticas, que ahora mismo esta a 0

    public void rellenarEstadisticas(Estadisticas estadisticas);
    public String getNombre();

}
