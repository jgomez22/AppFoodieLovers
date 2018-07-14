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
import modelo.Publicacion_Plato;
import modelo.PublicacionxProducto;

public class PublicacionxProductoDAO extends dao {
    
    public List<Publicacion_Plato> ListaPublicacion(String plato) throws SQLException{
        Publicacion_Plato publicacion_Plato=null;
        ResultSet rs;
        List<Publicacion_Plato> publicacion_Platos = new ArrayList<Publicacion_Plato>();
        this.Conectar();
            PreparedStatement pst= this.getCn().prepareStatement("select e.idempresa,e.nombre,pu.nombre as publica,p.idproducto,p.nombre as plato,pu.idpublicacion,e.direccion,p.delivery,p.reserva,p.precio from publicacionxproducto pp inner join publicacion pu on pp.idpublicacion=pu.idpublicacion inner join empresa e on pu.idempresa=e.idempresa inner join producto p on pp.idproducto=p.idproducto where p.nombre like '%" + plato + "%'");
            //pst.setString(1, plato);
            rs=pst.executeQuery();
            
            while(rs.next()){
                publicacion_Plato = new Publicacion_Plato();
                publicacion_Plato.setId_empresa(rs.getInt("idempresa"));
                publicacion_Plato.setEmpresa(rs.getString("nombre"));
                publicacion_Plato.setComentario(rs.getString("publica"));
                publicacion_Plato.setId_plato(rs.getInt("idproducto"));
                publicacion_Plato.setId_puplicado(rs.getInt("idpublicacion"));
                publicacion_Plato.setPlato(rs.getString("plato"));
                publicacion_Plato.setDireccion(rs.getString("direccion"));
                publicacion_Plato.setEst_delivery(rs.getString("delivery"));
                publicacion_Plato.setEst_reserva(rs.getString("reserva"));
                publicacion_Plato.setPrecio(rs.getDouble("precio"));
                publicacion_Platos.add(publicacion_Plato);
            }
        try{
            return publicacion_Platos;
        }catch(Exception e){
            return null;
        }finally {
            this.Cerrar();
        }
    }
}
