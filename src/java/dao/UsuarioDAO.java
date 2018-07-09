package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class UsuarioDAO extends dao{
    
    public void registrar(Usuario u) throws SQLException{
        try{
            this.Conectar();
            PreparedStatement pst;
            pst = this.getCn().prepareStatement
                ("INSERT INTO usuario (nombre,apellidos,telefono,correo,contrasena) "
                        + "VALUES(?,?,?,?,?)");
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellidos());
            pst.setInt(3, u.getTelefono());
            pst.setString(4, u.getCorreo());
            pst.setString(5, u.getContrasena());
            pst.executeUpdate();            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            this.Cerrar();
        }
    }
    
    public String obtenerNombre(int id){
        String nombre=null;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement pst = this.getCn().prepareStatement("SELECT nombre from usuario WHERE idusuario=? LIMIT 1");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                nombre=rs.getString("nombre");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nombre;
    }
    
}
