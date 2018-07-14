package bean;

import dao.DeliveryDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Delivery;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class DeliveryBean {

    private int cant_cli;
    private String dir_cli;
    private String det_cli;

    public int getCant_cli() {
        return cant_cli;
    }

    public void setCant_cli(int cant_cli) {
        this.cant_cli = cant_cli;
    }

    public String getDir_cli() {
        return dir_cli;
    }

    public void setDir_cli(String dir_cli) {
        this.dir_cli = dir_cli;
    }

    public String getDet_cli() {
        return det_cli;
    }

    public void setDet_cli(String det_cli) {
        this.det_cli = det_cli;
    }
    
        
    
    
    private Delivery delivery = new Delivery();
    private List<Delivery> lstDelivery;

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Delivery> getLstDelivery() {
        return lstDelivery;
    }

    public void setLstDelivery(List<Delivery> lstDelivery) {
        this.lstDelivery = lstDelivery;
    }

    public List<Delivery> listar(int id) throws SQLException {
        DeliveryDAO dao = new DeliveryDAO();
        try {
            lstDelivery = dao.listar(id);
        } catch (SQLException e) {
            throw e;
        }
        return lstDelivery;
    }
    
    public List<Delivery> listarEmpresa(int id, int idest) throws Exception {
        DeliveryDAO dao = new DeliveryDAO();
        try {
            lstDelivery = dao.listarEmpresa(id, idest);
        } catch (Exception e) {
            throw e;
        }
        return lstDelivery;
    }
    
    public String actualizaraProceso(int iddel) throws Exception {
        DeliveryDAO dao = new DeliveryDAO();
        String red;
        try {
            dao.actualizaraPro(iddel, 2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se actualizo el estado", ""));
        } catch (Exception e) {
            throw e;
        }
        return "empresa_servicios_inicio.xhtml";
    }
    
    public String actualizaraFinalizado(int iddel) throws Exception {
        DeliveryDAO dao = new DeliveryDAO();
        String red;
        try {
            dao.actualizaraPro(iddel, 3);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se actualizo el estado", ""));
        } catch (Exception e) {
            throw e;
        }
        return "empresa_servicio_proceso.xhtml";
    }
    
    public void registrar() {
        double total,precio;
        int id_us,id_pro;
        DeliveryDAO dao = new DeliveryDAO();
        precio = (double) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("precio");
        id_us = mostrarId();
        id_pro = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_pro");
        total=cant_cli*precio;
        try {
            dao.registrar(cant_cli,total,dir_cli,det_cli,id_us,id_pro);
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    public int mostrarId() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getIdusuario();
    }
}
