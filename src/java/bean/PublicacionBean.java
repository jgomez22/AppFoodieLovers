package bean;

import dao.ProductoDAO;
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
import dao.PublicacionxProductoDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import modelo.Producto;

@ManagedBean
@RequestScoped
public class PublicacionBean {

    private Publicacion publicacion = new Publicacion();
    private Producto producto = new Producto();
    private List<Publicacion> lstPublicacion;
    private List<Producto> lstProducto;

    private List<PublicacionxProducto> lstPublicacionxProducto;

    private List<Producto> checkboxLstProducto;
    private List<String> selectedPublicacionxProducto;
    
    private String message;

    

    public void show() {
        System.out.println(selectedPublicacionxProducto);
    }
    
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }

    public List<Producto> listarProductos(int idusu) throws SQLException {
        ProductoDAO dao = new ProductoDAO();
        try {
            lstProducto = dao.listar(idusu);
            return lstProducto;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Publicacion> listar() throws SQLException {
        PublicacionDAO dao = new PublicacionDAO();
        try {
            lstPublicacion = dao.listar();
            return lstPublicacion;
        } catch (SQLException e) {
            throw e;
        }
    }

    public String registrar(int idempresa) {
        
        String redireccion = "publicacion_lista.xhtml";
        PublicacionDAO dao = new PublicacionDAO();
        PublicacionxProductoDAO daoPublicacionxProducto = new PublicacionxProductoDAO();

        try {

            int lastid = dao.registrar(publicacion, idempresa);
            daoPublicacionxProducto.registrarPublicacionxProducto(selectedPublicacionxProducto, lastid);
        } catch (SQLException ex) {
            Logger.getLogger(PublicacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        this.message = "Creado correctamente";
        return redireccion;

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

    public List<String> getSelectedPublicacionxProducto() {
        return selectedPublicacionxProducto;
    }

    public void setSelectedPublicacionxProducto(List<String> selectedPublicacionxProducto) {
        this.selectedPublicacionxProducto = selectedPublicacionxProducto;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
