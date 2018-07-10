package bean;

import dao.PublicacionxProductoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Publicacion_Plato;
import modelo.PublicacionxProducto;

@ManagedBean
@RequestScoped
public class PublicacionxProductoBean  {
    PublicacionxProductoDAO query = new PublicacionxProductoDAO();
    List<Publicacion_Plato> list = new ArrayList<Publicacion_Plato>();

    public List<Publicacion_Plato> getList() throws SQLException {
        list = query.ListaPublicacion();
        return list;
    }

    public void setList(List<Publicacion_Plato> list) {
        this.list = list;
    }
    
    
}
