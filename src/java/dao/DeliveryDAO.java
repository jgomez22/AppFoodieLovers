package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Delivery;

public class DeliveryDAO extends dao {
    
    public void actualizaraPro(int iddel, int nest) throws SQLException{
        
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("UPDATE delivery SET idestado=? WHERE iddelivery=?");
            pst.setInt(1, nest);
            pst.setInt(2, iddel);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeliveryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
    }

    public List<Delivery> listarEmpresa(int id,int idest) throws SQLException {
        List<Delivery> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement(
                    "SELECT d.iddelivery iddelivery, d.cantidad cantidad, d.importe_total importe_total, d.direccion direccion, d.detalles detalles, d.idusuario idusuario, d.idproducto idproducto, d.idestado idestado "
                    + "FROM delivery d, producto p, empresa em, usuario u "
                    + "WHERE d.idproducto=p.idproducto AND p.idempresa=em.idempresa AND em.idusuario=u.idusuario AND u.idusuario=? AND d.idestado=?");
            pst.setInt(1, id);
            pst.setInt(2, idest);
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
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

    public List<Delivery> listar(int id) throws SQLException {
        List<Delivery> lista = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT "
                    + "iddelivery, cantidad, importe_total, direccion, detalles, idusuario, idproducto, idestado "
                    + "FROM delivery "
                    + "WHERE idusuario=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
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
            Logger.getLogger(DeliveryDAO.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }

        return lista;
    }
}
