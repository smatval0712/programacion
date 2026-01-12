package com.juego.modelo;

//creamos estadisticas dentro de modelo para saber cómo va el combate.
public class Estadisticas {

    //atributos de Estadisticas
    private int fuerza;
    private int inteligencia;
    private int destreza;
    private int vida;
    private int vidaMaxima;


    //constructor vacio, ya que no podemos asignarles los valores de estadisticas porque no los sabemos,
    //sino que dependiendo de la raza y clase que elijamos rellenaremos los datos de estadisticas
    public Estadisticas(){
        this.fuerza=0;
        this.inteligencia=0;
        this.destreza=0;
        this.vida=0;
        this.vidaMaxima=0;
    }

    //metodos get
    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() { return vidaMaxima; }

    //metodos set
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

}
