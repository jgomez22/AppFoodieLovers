package bean;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Publicacion;
import modelo.PublicacionxProducto;
import dao.PublicacionDAO;

@ManagedBean
@RequestScoped
public class PublicacionBean {

    private Publicacion publicacion = new Publicacion();
    private List<Publicacion> lstPublicacion;
    private List<PublicacionxProducto> lstPublicacionxProducto;


    public List<Publicacion> listar() throws SQLException {
        PublicacionDAO dao = new PublicacionDAO();
        try {
            lstPublicacion = dao.listar();
            return lstPublicacion;
        } catch (SQLException e) {
            throw e;
        }
    }

    public void registrar() {
        PublicacionDAO dao = new PublicacionDAO();
        try {

            dao.registrar(publicacion, lstPublicacionxProducto);
            
        } catch (SQLException ex) {
            Logger.getLogger(PublicacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public List<Publicacion> getLstPublicacion() {
        return lstPublicacion;
    }

    public void setLstPublicacion(List<Publicacion> lstPublicacion) {
        this.lstPublicacion = lstPublicacion;
    }

}
