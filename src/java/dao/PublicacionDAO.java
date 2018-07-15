/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Publicacion;
import modelo.PublicacionxProducto;

public class PublicacionDAO extends dao {

    public List<Publicacion> listar(int idemp) throws SQLException {
        List<Publicacion> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT idpublicacion, nombre, horapublicacion, horacierre FROM publicacion WHERE idempresa=?");
            pst.setInt(1, idemp);
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Publicacion pro = new Publicacion();
                pro.setIdpublicacion(rs.getInt("idpublicacion"));
                pro.setNombre(rs.getString("nombre"));
                pro.setHorapublicacion(rs.getString("horapublicacion"));
                pro.setHoracierre(rs.getString("horacierre"));
                lista.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public int registrar(Publicacion publicacion, int idempresa) throws SQLException {
        int lastid = 1;

        try {
            this.Conectar();
            PreparedStatement pst;
            System.out.println("mirate esta" + publicacion.getNombre());
            pst = this.getCn().prepareStatement("insert into publicacion (nombre,horapublicacion, horacierre, idempresa) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, publicacion.getNombre());
            pst.setString(2, publicacion.getHorapublicacion());
            pst.setString(3, publicacion.getHoracierre());
            pst.setInt(4, idempresa);

            pst.executeUpdate();

            try (ResultSet rs = pst.getGeneratedKeys()) {
                if (rs.next()) {
                    lastid = rs.getInt(1);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return lastid;
    }

}
