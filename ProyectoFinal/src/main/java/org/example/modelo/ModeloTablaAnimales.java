package org.example.modelo;
import org.example.persistencia.ListaAnimalesDAO;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaAnimales implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<ListaAnimales> datos;
    private ListaAnimalesDAO lisdao;


    public ModeloTablaAnimales() {
        lisdao = new ListaAnimalesDAO();
        datos = new ArrayList<>();
    }


    public ModeloTablaAnimales(ArrayList<ListaAnimales>datos){
        this.datos = datos;
        lisdao=new ListaAnimalesDAO();
    }


    @Override
    public int getRowCount() {
        return datos.size();
    }


    @Override
    public int getColumnCount() {
        return COLUMNS;
    }


    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Peso";
            case 3:
                return "Largo";
            case 4:
                return "Longevidad";
            case 5:
                return "Imagen";
        }
        return null;
    }


    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            case 5:
                return String.class;
        }
        return null;
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ListaAnimales tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getPeso();
            case 3:
                return tmp.getLargo();
            case 4:
                return tmp.getLongevidad();
            case 5:
                return tmp.getImagen();
        }
        return null;
    }


    @Override
    public void setValueAt(Object a, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) a);
                break;
            case 2:
                datos.get(rowIndex).setPeso((Double) a);
                break;
            case 3:
                datos.get(rowIndex).setLargo((Integer) a);
                break;
            case 4:
                datos.get(rowIndex).setLongevidad((Integer) a);
                break;
            case 5:
                datos.get(rowIndex).setImagen((String) a);
                break;
            default:
                System.out.println("No se modifica nada");
        }
    }


    @Override
    public void addTableModelListener(TableModelListener l) {
    }


    @Override
    public void removeTableModelListener(TableModelListener l) {

    }


    public void cargarDatos(){
        try {
            datos = lisdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }


    public boolean agregarAnimal(ListaAnimales lista){
        boolean resultado = false;
        try{
            if (lisdao.insertar(lista)){
                datos.add(lista );
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public boolean delete(ListaAnimales lista){
        boolean resultado = false;
        try {
            if (lisdao.delete(String.valueOf(lista))){
                datos.add(lista);
                resultado=true;
            }else {
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public boolean updateAnimal(ListaAnimales lista){
        boolean resultado = false;
        try {
            if (lisdao.update(lista)){
                datos.add(lista);
                resultado=true;
            }else {
                resultado=false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }


    public ListaAnimales obtenerLista(int rowIndex){
        return datos.get(rowIndex);
    }
}
