package bean;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Producto;
import dao.ProductoDAO;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProductoBean {

    private Producto producto = new Producto();
    private List<Producto> lstProducto;
    
    private List<Producto> checkboxLstProducto;

    private Producto[] selectedPublicacionxProducto;

    
    
    public Producto[] getSelectedPublicacionxProducto() {
        return selectedPublicacionxProducto;
    }

    public void setSelectedPublicacionxProducto(Producto[] selectedPublicacionxProducto) {
        this.selectedPublicacionxProducto = selectedPublicacionxProducto;
    }
    
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

    /*public void lista() throws SQLException {
        ProductoDAO dao = new ProductoDAO();
        try {
            lstProducto = dao.listar();
        } catch (SQLException e) {
            throw e;
        }
    }*/
    public List<Producto> listar(int idusu) throws SQLException {
        ProductoDAO dao = new ProductoDAO();
        try {
            lstProducto = dao.listar(idusu);
            return lstProducto;
        } catch (SQLException e) {
            throw e;
        }
    }

    public String obtenerNombre(int id) {
        String nombre = null;
        ProductoDAO dao = new ProductoDAO();
        try {
            nombre = dao.obtenerNombre(id);
        } catch (Exception e) {
            throw e;
        }
        return nombre;
    }

    public String registrarProducto(int idemp) throws Exception {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.registrarProducto(producto,idemp);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro producto", ""));
        } catch (Exception e) {
            throw e;
        }
        return "producto_nuevo.xhtml";
    }
}
