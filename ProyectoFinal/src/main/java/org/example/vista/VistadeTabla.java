package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VistadeTabla extends JFrame {
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
    private JButton btnBaseDatos;
    private JTable tblAnimales;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JPanel panel1; //Formulario para dar de alta
    private JPanel panel2; //Tabla que muestra la base de datos
    private JPanel panel3; // Muestra la imagen
    private JPanel panel4; //eliminar datos


    public VistadeTabla(String title) throws HeadlessException {
        super(title);
        this.setSize(900,900);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

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
        txtImagen = new JTextField(75);
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


        //PANEL4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(20, 62, 126, 150));


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

    public JTextField getTxtId() {
        return txtId;
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
}
