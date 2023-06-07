package org.example.modelo;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

//LA CLASE EN LA CUAL VA A CONTENER TODOS LOS ATRIBUTOS DE LA TABLA
public class ListaAnimales {
    private int id;
    private String nombre;
    private double peso;
    private int largo;
    private int longevidad;
    private String imagen;

    public ListaAnimales() {
    }


    public ListaAnimales(int id, String nombre, double peso, int largo, int longevidad, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.largo = largo;
        this.longevidad = longevidad;
        this.imagen = imagen;
    }


    @Override
    public String toString() {
        return "ListaAnimales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", peso=" + peso +
                ", largo=" + largo +
                ", longevidad=" + longevidad +
                ", imagen='" + imagen + '\'' +
                '}';
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


    public int getLongevidad() {
        return longevidad;
    }


    public void setLongevidad(int longevidad) {
        this.longevidad = longevidad;
    }


    public String getImagen() {
        return imagen;
    }


    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    ///Crear icono
    public ImageIcon createIcon(){
        ImageIcon resultado = null;
        try{
            URL UrlAnimal = new URL(this.imagen);
            resultado = new ImageIcon(UrlAnimal);
        }catch (MalformedURLException malformedURLException){
            System.out.println(malformedURLException.toString());
        }
        return resultado;
    }

}



