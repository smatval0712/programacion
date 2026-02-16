public class Artista {
    private String nombre;
    public Artista(String nombre){
        this.nombre=nombre;
    }
    public Cancion crearCanciones(String nombreCancion){
        Cancion can=new Cancion(nombreCancion);
        return can;
    }
}
