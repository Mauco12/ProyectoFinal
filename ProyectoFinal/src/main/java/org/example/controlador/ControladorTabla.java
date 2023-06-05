package org.example.controlador;
import org.example.modelo.ListaAnimales;
import org.example.modelo.ModeloTablaAnimales;
import org.example.persistencia.ConexionSingleton;
import org.example.vista.VistadeTabla;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControladorTabla extends MouseAdapter {
    private VistadeTabla view;
    private ModeloTablaAnimales modelo;

    public ControladorTabla(VistadeTabla view) {
        this.view = view;
        modelo = new ModeloTablaAnimales();
        this.view.getTblAnimales().setModel(modelo);
        this.view.getBtnBaseDatos().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnUpdate().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Configuracion del boton para mostrar los datos de la tabla
        if (e.getSource() == this.view.getBtnBaseDatos()) {
            modelo.cargarDatos();
            this.view.getTblAnimales().setModel(modelo);
            this.view.getTblAnimales().updateUI();
        }

        //Configuracion del boton para agregar informacion a la base de datos
        if (e.getSource() == this.view.getBtnAgregar()) {
            ListaAnimales lista = new ListaAnimales();
            lista.setId(0);
            lista.setNombre(this.view.getTxtNombre().getText());
            lista.setPeso(Double.parseDouble(this.view.getTxtPeso().getText()));
            lista.setLargo(Integer.parseInt(this.view.getTxtLargo().getText()));
            lista.setLongevidad(Integer.parseInt(this.view.getTxtLongevidad().getText()));
            lista.setImagen(this.view.getTxtImagen().getText());
            if (modelo.agregarAnimal(lista)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblAnimales().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos", "Error al insertar", JOptionPane.ERROR_MESSAGE);

            }
            this.view.limpiar();
        }

        //Eliminar
        if (e.getSource() == this.view.getBtnEliminar()){
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Deseas eliminar este elemento?","Eliminar",JOptionPane.YES_NO_OPTION);
            if (respuesta == 0){
                String sqlDelete = "DELETE FROM animales WHERE id=?;";
                PreparedStatement pstm = null;
                try {
                    pstm= ConexionSingleton.get_instance("FaunaMarina.db").getConnection().prepareStatement(sqlDelete);
                }catch (SQLException sqle){
                    System.out.println(sqle.getMessage());
                }
                try {
                    pstm.setInt(1,Integer.parseInt(this.view.getTxtEliminar().getText()));
                    this.view.getTblAnimales().updateUI();
                    JOptionPane.showMessageDialog(view,"Se elimino correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                }catch (NumberFormatException a){
                    System.out.println(a.getMessage());
                }catch (SQLException sqle ){
                    System.out.println(sqle.getMessage());
                }
                try{
                    pstm.executeUpdate();
                }catch (SQLException sqle){
                    System.out.println(sqle.getMessage());
                    throw new RuntimeException();
                }finally {
                    this.view.LimpiarPanel4();
                }
            }
        }

        if (e.getSource()==this.view.getBtnUpdate()){
            int respuesta = JOptionPane.showConfirmDialog(view,"¿Quieres actualizar el dato?","Actualizar datos",JOptionPane.YES_NO_OPTION);
            if (respuesta==0){
                ListaAnimales lista = new ListaAnimales();
                lista.setId(Integer.parseInt((String)this.view.getTxtIdPanel4().getText()));
                lista.setNombre(this.view.getTxtNombrePanel4().getText());
                lista.setPeso(Double.parseDouble((String)this.view.getTxtPesoPanel4().getText()));
                lista.setLargo(Integer.parseInt((String)this.view.getTxtLargoPanel4().getText()));
                lista.setLongevidad(Integer.parseInt((String)this.view.getTxtLongevidadPanel4().getText()));
                lista.setImagen(this.view.getTxtImagenPanel4().getText());
                this.view.getTblAnimales().updateUI();
                if (modelo.updateAnimal(lista)){
                    JOptionPane.showMessageDialog(view,"Se actualizo correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblAnimales().updateUI();
                }else {
                    JOptionPane.showMessageDialog(view,"Error al actualizar","aviso",JOptionPane.ERROR_MESSAGE);
                }
                this.view.LimpiarPanel4();
            }else {
                this.view.LimpiarPanel4();
            }
        }


    }
}
