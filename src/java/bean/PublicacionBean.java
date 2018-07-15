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

import modelo.Producto;

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
    private Producto producto = new Producto();
    private List<Publicacion> lstPublicacion;
    private List<Producto> lstProducto;

    private List<PublicacionxProducto> lstPublicacionxProducto;
    
    List<Publicacion_Plato> list = new ArrayList<Publicacion_Plato>();
   
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
    
    public void guardarDatos(String Empresa, String Direccion, String Delivery, String Reserva,int id_emp,int ip_pro,String plato,double  precio,int id_publicacion) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empresa", Empresa);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("direccion", Direccion);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("delivery", Delivery);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("reserva", Reserva);
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id_emp", id_emp);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id_pro", ip_pro);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("plato", plato);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("precio", precio);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id_pub", id_publicacion);
        this.Empresa = Empresa;
        this.Direccion = Direccion;
        this.Delivery = Delivery;
        this.Reserva = Reserva;
    }
    
    public String op_idpub() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_pub");
        if (emp != null) {
            return emp;
        } else {
            return "0";
        }
    }
    
    public double op_precio() {
        double emp = (double) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("precio");
        if (emp != 0) {
            return emp;
        } else {
            return 0;
        }
    }
    
    public String op_plato() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("plato");
        if (emp != null) {
            return emp;
        } else {
            return "";
        }
    }
    
    public String op_idpro() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_pro");
        if (emp != null) {
            return emp;
        } else {
            return "0";
        }
    }
    
    public String op_idemp() {
        String emp = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_emp");
        if (emp != null) {
            return emp;
        } else {
            return "0";
        }
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
    public List<Publicacion> listar( int idemp) throws SQLException {
        PublicacionDAO dao = new PublicacionDAO();
        try {
            lstPublicacion = dao.listar(idemp);
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
    
    

}
