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
import modelo.Producto;

public class ProductoDAO extends dao {
    
     public List<Producto> listar(int idempresa) throws SQLException{
          List<Producto> lista=null;
            ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst=this.getCn().prepareStatement("SELECT * FROM producto");
            
            rs=pst.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
            Producto producto = new Producto();
            producto.setIdproducto(rs.getInt("idproducto"));
            producto.setDelivery(rs.getInt("delivery"));
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setReserva(rs.getInt("reserva"));
            
            
            lista.add(producto);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        this.Cerrar();
        }
        return lista;
    }

    
}
