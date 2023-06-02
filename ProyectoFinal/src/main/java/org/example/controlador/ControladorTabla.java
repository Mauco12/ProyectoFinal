package org.example.controlador;

import org.example.modelo.ListaAnimales;
import org.example.modelo.ModeloTablaAnimales;
import org.example.vista.VistadeTabla;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ControladorTabla extends MouseAdapter {
    private VistadeTabla view;
    private ModeloTablaAnimales modelo;

    public ControladorTabla(VistadeTabla view) {
        this.view = view;
        modelo=new ModeloTablaAnimales();
        this.view.getTblAnimales().setModel(modelo);
        this.view.getBtnBaseDatos().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnBaseDatos()){

            modelo.cargarDatos();
            this.view.getTblAnimales().setModel(modelo);
            this.view.getTblAnimales().updateUI();

        }

        if (e.getSource() == this.view.getBtnAgregar()){
            ListaAnimales lista= new ListaAnimales();
            lista.setId(0);
            lista.setNombre(this.view.getTxtNombre().getText());
            lista.setPeso(Double.parseDouble(this.view.getTxtPeso().getText()));
            lista.setLargo(Integer.parseInt(this.view.getTxtLargo().getText()));
            lista.setLongevidad(Integer.parseInt(this.view.getTxtLongevidad().getText()));
            lista.setImagen(this.view.getTxtImagen().getText());
            if(modelo.agregarAnimal(lista)){
                JOptionPane.showMessageDialog(view,"Se agrego correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblAnimales().updateUI();
            }else {
                JOptionPane.showMessageDialog(view,"No se pudo agregar a la base de datos","Error al insertar",JOptionPane.ERROR_MESSAGE);

            }
            this.view.limpiar();

        }

    }
}
