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

@ManagedBean
@RequestScoped
public class ProductoBean {

    private Producto producto = new Producto();
    private List<Producto> lstProducto;

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

    public void lista() throws SQLException {
        ProductoDAO dao = new ProductoDAO();
        try {
            lstProducto = dao.listar();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<Producto> listar() throws SQLException {
        ProductoDAO dao = new ProductoDAO();
        try {
            lstProducto = dao.listar();
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
}
