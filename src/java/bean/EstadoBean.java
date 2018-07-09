package bean;

import dao.EstadoDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Estado;

@ManagedBean
@RequestScoped
public class EstadoBean {

    private Estado estado = new Estado();

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String obtenerNombre(int id) {
        String nombre = null;
        EstadoDAO dao = new EstadoDAO();
        try {
            nombre = dao.obtenerNombre(id);
        } catch (Exception e) {
            throw e;
        }
        return nombre;
    }
}
