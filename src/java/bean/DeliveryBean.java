package bean;

import dao.DeliveryDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Delivery;

@ManagedBean
@ViewScoped
public class DeliveryBean {

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
}
