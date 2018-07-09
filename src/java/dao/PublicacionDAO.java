/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Publicacion;

public class PublicacionDAO extends dao {
    
    
    
     public List<Publicacion> listar() throws SQLException {
        List<Publicacion> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT idpublicacion, nombre, horapublicacion, horacierre FROM publicacion");
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
    
}
