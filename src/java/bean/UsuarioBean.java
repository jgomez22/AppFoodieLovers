package bean;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Usuario;

@ManagedBean
@RequestScoped

public class UsuarioBean {
    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void registrar(){
        UsuarioDAO dao = new UsuarioDAO();
        
        try {        
            dao.registrar(usuario);
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
    
    public String obtenerNombre(int id){
        String nombre="";
        UsuarioDAO dao = new UsuarioDAO();
        try{
            nombre=dao.obtenerNombre(id);
        } catch (Exception e){
            throw e;
        }
        return nombre;
    }
}
