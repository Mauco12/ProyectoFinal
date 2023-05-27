package org.example;

import org.example.modelo.ListaAnimales;
import org.example.persistencia.ListaAnimalesDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListaAnimalesDAO lis = new ListaAnimalesDAO();
        try {
            ListaAnimales resul = (ListaAnimales) lis.buscarPorId("1");
            System.out.println(resul);
            System.out.println("----------------");
            for (Object listaTotal: lis.obtenerTodo()) {
                System.out.println((ListaAnimales)listaTotal);
                
            }
            

        }catch (SQLException sqle){
            System.out.println();
            sqle.printStackTrace();
        }



    }
}