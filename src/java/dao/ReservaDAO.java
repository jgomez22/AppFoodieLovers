package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Reserva;

public class ReservaDAO extends dao {

    public void registrar(int cantidad, double total, String hora, String det, int id_us, int id_pro) throws SQLException{
        try {
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement("INSERT INTO reserva (cantidad,hora_llegada,importe_total,detalles,idproducto,idusuario,idestado) "
                    + "VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1,cantidad);
            pst.setString(2,hora);
            pst.setDouble(3,total);
            pst.setString(4, det);
            pst.setInt(5,id_pro);
            pst.setInt(6,id_us);
            pst.setInt(7,1);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
    }
    
    public void actualizaraPro(int idres, int nest) throws SQLException {
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("UPDATE reserva SET idestado=? WHERE idreserva=?");
            pst.setInt(1, nest);
            pst.setInt(2, idres);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
    }

    public List<Reserva> listarEmpresa(int id, int idest) throws SQLException {
        List<Reserva> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement(
                    "SELECT r.idreserva idreserva, r.cantidad cantidad, r.hora_llegada hora_llegada, r.importe_total importe_total, r.detalles detalles, r.idusuario idusuario, r.idproducto idproducto, r.idestado idestado "
                    + "FROM reserva r, producto p, empresa em, usuario u "
                    + "WHERE r.idproducto=p.idproducto AND p.idempresa=em.idempresa AND em.idusuario=u.idusuario AND u.idusuario=? AND r.idestado=?");
            pst.setInt(1, id);
            pst.setInt(2, idest);
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Reserva res = new Reserva();
                res.setIdreserva(rs.getInt("idreserva"));
                res.setCantidad(rs.getInt("cantidad"));
                res.setHora_llegada(rs.getString("hora_llegada"));
                res.setImporte_total(rs.getDouble("importe_total"));
                res.setDetalles(rs.getString("detalles"));
                res.setIdusuario(rs.getInt("idusuario"));
                res.setIdproducto(rs.getInt("idproducto"));
                res.setIdestado(rs.getInt("idestado"));
                lista.add(res);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Reserva> listar(int id) throws SQLException {
        List<Reserva> lista = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT "
                    + "idreserva, cantidad, importe_total, direccion, detalles, idusuario, idproducto, idestado "
                    + "FROM reserva "
                    + "WHERE idusuario=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Reserva res = new Reserva();
                res.setIdreserva(rs.getInt("idreserva"));
                res.setCantidad(rs.getInt("cantidad"));
                res.setHora_llegada(rs.getString("hora_llegada"));
                res.setImporte_total(rs.getDouble("importe_total"));
                res.setDetalles(rs.getString("detalles"));
                res.setIdusuario(rs.getInt("idusuario"));
                res.setIdproducto(rs.getInt("idproducto"));
                res.setIdestado(rs.getInt("idestado"));
                lista.add(res);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return lista;
    }
}
