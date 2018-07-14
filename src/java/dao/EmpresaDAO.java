package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empresa;

public class EmpresaDAO extends dao {

    public String obtenerNombre(int id) {
        String nombre = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT em.nombre nombre FROM empresa em, producto p WHERE em.idempresa=p.idempresa AND p.idproducto=?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                nombre = rs.getString("nombre");
                //nombre = rs.getString("nombre");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    public void registrarEmpresa(Empresa emp, int idusu) throws SQLException {
        try {
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement("INSERT INTO empresa (nombre, direccion, descripcion, telefono, delivery, reservar, idusuario) VALUES (?, ?, ?, ?, ?, ?, ?);");
            pst.setString(1, emp.getNombre());
            pst.setString(2, emp.getDireccion());
            pst.setString(3, emp.getDescripcion());
            pst.setInt(4, emp.getTelefono());
            pst.setInt(5, emp.getDelivery());
            pst.setInt(6, emp.getReserva());
            pst.setInt(7, idusu);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
    }
}
