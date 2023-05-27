package org.example.persistencia;

import org.example.modelo.ListaAnimales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListaAnimalesDAO implements Interfaz{
    public ListaAnimalesDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert ="INSERT INTO animales(nombre, peso, largo, ancho, imagen) VALUES (?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FaunaMarina.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1,((ListaAnimales)obj).getNombre());
        pstm.setDouble(2,((ListaAnimales)obj).getPeso());
        pstm.setInt(3,((ListaAnimales)obj).getLargo());
        pstm.setInt(4,((ListaAnimales)obj).getAncho());
        pstm.setString(5,((ListaAnimales)obj).getImagen());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate ="UPDATE animales SET nombre = ?, peso = ?, largo = ?, ancho = ?, imagen = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FaunaMarina.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((ListaAnimales)obj).getNombre());
        pstm.setDouble(2,((ListaAnimales)obj).getPeso());
        pstm.setInt(3,((ListaAnimales)obj).getLargo());
        pstm.setInt(4,((ListaAnimales)obj).getAncho());
        pstm.setString(5,((ListaAnimales)obj).getImagen());
        pstm.setInt(6,((ListaAnimales)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM animales WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FaunaMarina.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM animales";
        ArrayList<ListaAnimales> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.get_instance("FaunaMarina.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new ListaAnimales(rst.getInt(1), rst.getString(2),rst.getDouble(3),rst.getInt(4),rst.getInt(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM animales WHERE id = ? ;";
        ListaAnimales Lista = null;

        PreparedStatement pstm = ConexionSingleton.get_instance("FaunaMarina.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next()){
            Lista = new ListaAnimales(rst.getInt(1), rst.getString(2),rst.getDouble(3),rst.getInt(4),rst.getInt(5),rst.getString(6));
            return Lista;
        }
        return null;
    }
}
