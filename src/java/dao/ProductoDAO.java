package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

public class ProductoDAO extends dao {

    public String obtenerNombre(int id) {
        String nombre = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT nombre FROM producto WHERE idproducto=? LIMIT 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                nombre = rs.getString("nombre");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    public List<Producto> listar() throws SQLException {
        List<Producto> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT idproducto, nombre, precio, delivery, reserva, imagen,idempresa FROM producto");
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Producto pro = new Producto();
                pro.setIdproducto(rs.getInt("idproducto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                pro.setDelivery(rs.getInt("delivery"));
                pro.setReserva(rs.getInt("reserva"));
                pro.setImagen(rs.getString("imagen"));
                pro.setIdempresa(rs.getInt("idempresa"));
                lista.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

}
