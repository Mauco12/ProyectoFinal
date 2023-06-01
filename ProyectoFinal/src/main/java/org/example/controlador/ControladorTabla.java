package org.example.controlador;

import org.example.modelo.ModeloTablaAnimales;
import org.example.vista.VistadeTabla;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ControladorTabla extends MouseAdapter {
    private VistadeTabla view;
    private ModeloTablaAnimales modelo;

    public ControladorTabla(VistadeTabla view) {
        this.view = view;
        this.view.getBtnBaseDatos().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnBaseDatos()){
            modelo=new ModeloTablaAnimales();
            modelo.cargarDatos();
            this.view.getTblAnimales().setModel(modelo);
            this.view.getTblAnimales().updateUI();

        }
    }
}
