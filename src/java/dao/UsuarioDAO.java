package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class UsuarioDAO extends dao {

    public String obtenerNombre(int id) {
        String nombre = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT nombre from usuario WHERE idusuario=? LIMIT 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            while (rs.next()) {
                nombre = rs.getString("nombre");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nombre;
    }

    public void registrar(Usuario u) throws SQLException {
        try {
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement("INSERT INTO usuario (nombre,apellidos,telefono,correo,contrasena) "
                    + "VALUES(?,?,?,?,?)");
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellidos());
            pst.setInt(3, u.getTelefono());
            pst.setString(4, u.getCorreo());
            pst.setString(5, u.getContrasena());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
    }

    public Usuario iniciarSession(String usu, String cla) throws SQLException {
        Usuario usuario = null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("select* from usuario where correo=? and contrasena=? ");
            pst.setString(1, usu);
            pst.setString(2, cla);
            rs = pst.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return usuario;
    }

    public int validarCuentaRestaurant(int idu) throws SQLException {
        int idem = 0;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("select idempresa from empresa where idusuario=?");
            pst.setInt(1, idu);
            rs = pst.executeQuery();

            while (rs.next()) {
                idem = rs.getInt("idempresa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.Cerrar();
        }
        return idem;

    }
}
