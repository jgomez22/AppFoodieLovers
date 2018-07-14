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
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import modelo.Publicacion_Plato;

@ManagedBean
@RequestScoped
public class PublicacionBean {

    private String Empresa;
    private String Direccion;
    private String Delivery;
    private String Reserva;

    private Publicacion publicacion = new Publicacion();
    private List<Publicacion> lstPublicacion;
    private List<PublicacionxProducto> lstPublicacionxProducto;
    
    List<Publicacion_Plato> list = new ArrayList<Publicacion_Plato>();

    public List<Publicacion_Plato> getList() {
        return list;
    }

    public void setList(List<Publicacion_Plato> list) {
        this.list = list;
    }
    
   
    
    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDelivery() {
        return Delivery;
    }

    public void setDelivery(String Delivery) {
        this.Delivery = Delivery;
    }

    public String getReserva() {
        return Reserva;
    }

    public void setReserva(String Reserva) {
        this.Reserva = Reserva;
    }

    public void guardarDatos(String Empresa, String Direccion, String Delivery, String Reserva) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", Empresa);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("direccion", Direccion);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("delivery", Delivery);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reserva", Reserva);
        this.Empresa = Empresa;
        this.Direccion = Direccion;
        this.Delivery = Delivery;
        this.Reserva = Reserva;
    }

    
    
    
    public String op_emp() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empresa");
        if (emp != null) {
            return emp;
        } else {
            return "";
        }
    }
    
    public String op_Dir() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("direccion");
        if (emp != null) {
            return emp;
        } else {
            return "";
        }
    }
    
    public boolean op_Del() {
        String del = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("delivery");
        if (del != null) {
            if(del.equals("0")){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean op_Res() {
        String del = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("reserva");
        if (del != null) {
            if(del.equals("0")){
                return true;
            }else{
                return false;
            }
        } else {
            return false;
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
