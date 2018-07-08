package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Delivery;

public class DeliveryDAO extends dao{
    
    public List<Delivery> listar() throws SQLException{
        List<Delivery> lista = null;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT iddelivery, cantidad, importe_total, direccion, detalles, idusuario, idproducto, idestado FROM delivery");
            rs = pst.executeQuery();
            lista = new ArrayList();
            
            while(rs.next()){
                Delivery del = new Delivery();
                del.setIddelivery(rs.getInt("iddelivery"));
                del.setCantidad(rs.getInt("cantidad"));
                del.setImporte_total(rs.getDouble("importe_total"));
                del.setDireccion(rs.getString("direccion"));
                del.setDetalles(rs.getString("detalles"));
                del.setIdusuario(rs.getInt("idusuario"));
                del.setIdproducto(rs.getInt("idproducto"));
                del.setIdestado(rs.getInt("idestado"));
                lista.add(del);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
              
        return lista;
    }
}
