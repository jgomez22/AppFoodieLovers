package bean;

import dao.PublicacionxProductoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Publicacion_Plato;
import modelo.PublicacionxProducto;

@ManagedBean
@RequestScoped
public class PublicacionxProductoBean {

    private Publicacion_Plato publicacion_Plato = new Publicacion_Plato();

    public Publicacion_Plato getPublicacion_Plato() {
        return publicacion_Plato;
    }

    public void setPublicacion_Plato(Publicacion_Plato publicacion_Plato) {
        this.publicacion_Plato = publicacion_Plato;
    }

    PublicacionxProductoDAO query = new PublicacionxProductoDAO();
    List<Publicacion_Plato> list = new ArrayList<Publicacion_Plato>();

    public List<Publicacion_Plato> getList() throws SQLException {
        publicacion_Plato.setPlato("");

        list = query.ListaPublicacion(publicacion_Plato.getPlato());
        return list;
    }

    public PublicacionxProductoDAO getQuery() {
        return query;
    }

    public void setQuery(PublicacionxProductoDAO query) {
        this.query = query;
    }

    public void setList(List<Publicacion_Plato> list) {
        this.list = list;
    }

}
