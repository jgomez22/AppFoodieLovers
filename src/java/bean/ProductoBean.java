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
public class ProductoBean extends BaseBean {
    private Producto usuario = new Producto();
    private List<Producto> lsProducto;
    
    
    
    public  void listar(){
        try {
            ProductoDAO dao=new ProductoDAO();
            lsProducto = dao.listar(1);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Producto getUsuario() {
        return usuario;
    }

    public void setUsuario(Producto usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getLsProducto() {
        return lsProducto;
    }

    public void setLsProducto(List<Producto> lsProducto) {
        this.lsProducto = lsProducto;
    }
    
    
    
}
