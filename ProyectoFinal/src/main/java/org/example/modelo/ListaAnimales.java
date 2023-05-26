package org.example.modelo;

public class ListaAnimales {
    private int id;
    private String nombre;
    private double peso;
    private int largo;
    private int ancho;
    private String imagen;

    public ListaAnimales() {
    }

    public ListaAnimales(int id, String nombre, double peso, int largo, int ancho, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "ListaAnimales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", largo=" + largo +
                ", ancho=" + ancho +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
