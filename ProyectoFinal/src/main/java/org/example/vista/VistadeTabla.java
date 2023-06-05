package org.example.vista;

import org.example.modelo.ModeloTablaAnimales;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class VistadeTabla extends JFrame {
    //Atributos panel1
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblPeso;
    private JLabel lblLargo;
    private JLabel lblLongevidad;
    private JLabel lblImagen;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPeso;
    private JTextField txtLargo;
    private JTextField txtLongevidad;
    private JTextField txtImagen;
    private JButton btnAgregar;
    private JLabel lblAgregar;
    private JPanel panel1; //Formulario para dar de alta
    //Atributos panel2
    private JPanel panel2; //Tabla que muestra la base de datos
    private JButton btnBaseDatos;
    private JTable tblAnimales;
    private JScrollPane scrollPane;
    //Atributos panel3
    private JPanel panel3; // Muestra la imagen
    private ModeloTablaAnimales modelo;
    private JLabel lblFoto;

    //Atributos panel4
    private JPanel panel4; //eliminar datos
    private GridLayout layout;
    private JLabel lblIdPanel4;
    private JLabel lblNombrePanel4;
    private JLabel lblPesoPanel4;
    private JLabel lblLargoPanel4;
    private JLabel lblLongevidadPanel4;
    private JLabel lblImagenPanel4;
    private JTextField txtIdPanel4;
    private JTextField txtNombrePanel4;
    private JTextField txtPesoPanel4;
    private JTextField txtLargoPanel4;
    private JTextField txtLongevidadPanel4;
    private JTextField txtImagenPanel4;
    private JButton btnUpdate;
    private JLabel IndiceEliminar;
    private JLabel lblEliminar;
    private JTextField txtEliminar;
    private JButton btnEliminar;

        //Configuracion de JFrame
    public VistadeTabla(String title) throws HeadlessException {
        super(title);
        this.setSize(900,900);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //Configuración de que va a aparece en cada panel

        //PANEL1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(19, 147, 132, 210));

        lblId = new JLabel("Id: ");
        lblNombre = new JLabel("Nombre: ");
        lblPeso = new JLabel("Peso: ");
        lblLargo = new JLabel("Largo: ");
        lblLongevidad = new JLabel("Longevidad: ");
        lblImagen = new JLabel("URL : ");

        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtNombre = new JTextField(25);
        txtPeso = new JTextField(10);
        txtLargo = new JTextField(10);
        txtLongevidad = new JTextField(10);
        txtImagen = new JTextField(40);

        btnAgregar = new JButton("Agregar");

        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblPeso);
        panel1.add(txtPeso);
        panel1.add(lblLargo);
        panel1.add(txtLargo);
        panel1.add(lblLongevidad);
        panel1.add(txtLongevidad);
        panel1.add(lblImagen);
        panel1.add(txtImagen);
        panel1.add(btnAgregar);





        //PANEL2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(19, 102, 147, 210));
        btnBaseDatos = new JButton("Cargar");
        panel2.add(btnBaseDatos);
        tblAnimales = new JTable();
        scrollPane = new JScrollPane(tblAnimales);
        panel2.add(scrollPane);


        //PANEL3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(13, 101, 69, 210));
        lblFoto = new JLabel("Foto");
        this.panel3.add(lblFoto);



        //PANEL4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(19, 147, 132, 210));
        lblIdPanel4 = new JLabel("Id");
        lblNombrePanel4 = new JLabel("Nombre: ");
        lblPesoPanel4 = new JLabel("Peso: ");
        lblLargoPanel4 = new JLabel("Largo: ");
        lblLongevidadPanel4 = new JLabel("Longevidad: ");
        lblImagenPanel4 = new JLabel("Imagen: ");
        txtIdPanel4 = new JTextField(3);
        txtNombrePanel4 = new JTextField(25);
        txtPesoPanel4 = new JTextField(10);
        txtLargoPanel4 = new JTextField(10);
        txtLongevidadPanel4 = new JTextField(10);
        txtImagenPanel4 = new JTextField(75);
        btnUpdate = new JButton("Actualizar");
        panel4.add(lblIdPanel4);
        panel4.add(txtIdPanel4);
        panel4.add(lblNombrePanel4);
        panel4.add(txtNombrePanel4);
        panel4.add(lblPesoPanel4);
        panel4.add(txtPesoPanel4);
        panel4.add(lblLargoPanel4);
        panel4.add(txtLargoPanel4);
        panel4.add(lblLongevidadPanel4);
        panel4.add(txtLongevidadPanel4);
        panel4.add(lblImagenPanel4);
        panel4.add(txtImagenPanel4);
        panel4.add(btnUpdate);


        IndiceEliminar = new JLabel("------------------------------------------------------------------------------");

        lblEliminar = new JLabel("Eliminar id: ");
        txtEliminar = new JTextField(3);
        btnEliminar = new JButton("Eliminar datos");
        panel4.add(IndiceEliminar);
        panel4.add(lblEliminar);
        panel4.add(txtEliminar);
        panel4.add(btnEliminar);



        //Agregar los paneles al frame
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JLabel getLblPeso() {
        return lblPeso;
    }

    public void setLblPeso(JLabel lblPeso) {
        this.lblPeso = lblPeso;
    }

    public JLabel getLblLargo() {
        return lblLargo;
    }

    public void setLblLargo(JLabel lblLargo) {
        this.lblLargo = lblLargo;
    }

    public JLabel getLblLongevidad() {
        return lblLongevidad;
    }

    public void setLblLongevidad(JLabel lblLongevidad) {
        this.lblLongevidad = lblLongevidad;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtPeso() {
        return txtPeso;
    }

    public void setTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
    }

    public JTextField getTxtLargo() {
        return txtLargo;
    }

    public void setTxtLargo(JTextField txtLargo) {
        this.txtLargo = txtLargo;
    }

    public JTextField getTxtLongevidad() {
        return txtLongevidad;
    }

    public void setTxtLongevidad(JTextField txtLongevidad) {
        this.txtLongevidad = txtLongevidad;
    }

    public JTextField getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(JTextField txtImagen) {
        this.txtImagen = txtImagen;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTblAnimales() {
        return tblAnimales;
    }

    public void setTblAnimales(JTable tblAnimales) {
        this.tblAnimales = tblAnimales;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }



    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnBaseDatos() {
        return btnBaseDatos;
    }

    public void setBtnBaseDatos(JButton btnBaseDatos) {
        this.btnBaseDatos = btnBaseDatos;
    }

    public JTextField getTxtId() {
        return txtId;
    }


    ///////////////////////////////////////


    public JLabel getLblIdPanel4() {
        return lblIdPanel4;
    }

    public void setLblIdPanel4(JLabel lblIdPanel4) {
        this.lblIdPanel4 = lblIdPanel4;
    }

    public JLabel getLblNombrePanel4() {
        return lblNombrePanel4;
    }

    public void setLblNombrePanel4(JLabel lblNombrePanel4) {
        this.lblNombrePanel4 = lblNombrePanel4;
    }

    public JLabel getLblPesoPanel4() {
        return lblPesoPanel4;
    }

    public void setLblPesoPanel4(JLabel lblPesoPanel4) {
        this.lblPesoPanel4 = lblPesoPanel4;
    }

    public JLabel getLblLargoPanel4() {
        return lblLargoPanel4;
    }

    public void setLblLargoPanel4(JLabel lblLargoPanel4) {
        this.lblLargoPanel4 = lblLargoPanel4;
    }

    public JLabel getLblLongevidadPanel4() {
        return lblLongevidadPanel4;
    }

    public void setLblLongevidadPanel4(JLabel lblLongevidadPanel4) {
        this.lblLongevidadPanel4 = lblLongevidadPanel4;
    }

    public JLabel getLblImagenPanel4() {
        return lblImagenPanel4;
    }

    public void setLblImagenPanel4(JLabel lblImagenPanel4) {
        this.lblImagenPanel4 = lblImagenPanel4;
    }

    public JTextField getTxtIdPanel4() {
        return txtIdPanel4;
    }

    public void setTxtIdPanel4(JTextField txtIdPanel4) {
        this.txtIdPanel4 = txtIdPanel4;
    }

    public JTextField getTxtNombrePanel4() {
        return txtNombrePanel4;
    }

    public void setTxtNombrePanel4(JTextField txtNombrePanel4) {
        this.txtNombrePanel4 = txtNombrePanel4;
    }

    public JTextField getTxtPesoPanel4() {
        return txtPesoPanel4;
    }

    public void setTxtPesoPanel4(JTextField txtPesoPanel4) {
        this.txtPesoPanel4 = txtPesoPanel4;
    }

    public JTextField getTxtLargoPanel4() {
        return txtLargoPanel4;
    }

    public void setTxtLargoPanel4(JTextField txtLargoPanel4) {
        this.txtLargoPanel4 = txtLargoPanel4;
    }

    public JTextField getTxtLongevidadPanel4() {
        return txtLongevidadPanel4;
    }

    public void setTxtLongevidadPanel4(JTextField txtLongevidadPanel4) {
        this.txtLongevidadPanel4 = txtLongevidadPanel4;
    }

    public JTextField getTxtImagenPanel4() {
        return txtImagenPanel4;
    }

    public void setTxtImagenPanel4(JTextField txtImagenPanel4) {
        this.txtImagenPanel4 = txtImagenPanel4;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JLabel getIndiceEliminar() {
        return IndiceEliminar;
    }

    public void setIndiceEliminar(JLabel indiceEliminar) {
        IndiceEliminar = indiceEliminar;
    }

    public JLabel getLblEliminar() {
        return lblEliminar;
    }

    public void setLblEliminar(JLabel lblEliminar) {
        this.lblEliminar = lblEliminar;
    }

    public JTextField getTxtEliminar() {
        return txtEliminar;
    }

    public void setTxtEliminar(JTextField txtEliminar) {
        this.txtEliminar = txtEliminar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public ModeloTablaAnimales getModelo() {
        return modelo;
    }

    public void setModelo(ModeloTablaAnimales modelo) {
        this.modelo = modelo;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JLabel getLblAgregar() {
        return lblAgregar;
    }

    public void setLblAgregar(JLabel lblAgregar) {
        this.lblAgregar = lblAgregar;
    }

    public void limpiar(){
    txtNombre.setText("");
    txtPeso.setText("");
    txtLargo.setText("");
    txtLongevidad.setText("");
    txtImagen.setText("");
    }
    public void LimpiarPanel4(){
        txtIdPanel4.setText("");
        txtNombrePanel4.setText("");
        txtPesoPanel4.setText("");
        txtLargoPanel4.setText("");
        txtLongevidadPanel4.setText("");
        txtImagenPanel4.setText("");
    }

}
