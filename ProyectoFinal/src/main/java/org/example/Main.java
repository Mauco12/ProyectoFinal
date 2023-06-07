package org.example;
import org.example.controlador.ControladorTabla;
import org.example.modelo.ListaAnimales;
import org.example.persistencia.ListaAnimalesDAO;
import org.example.vista.VistadeTabla;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VistadeTabla view = new VistadeTabla("ANIMALES MARINOS");
        ControladorTabla controlador = new ControladorTabla(view);
    }
}
