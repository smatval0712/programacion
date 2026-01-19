package com.juego.habilidades;

public interface Habilidades {
    public void usarHabilidad();
    public String getNombre();
    public int getDaño();
    public int getUsos();
    public void setNombre(String nombre);
    public void setDaño(int daño);
    public void setUsos(int usos);
}
