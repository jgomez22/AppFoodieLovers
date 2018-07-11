package bean;

import dao.DeliveryDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    
    public void actualizaraProceso(int iddel) throws Exception {
        DeliveryDAO dao = new DeliveryDAO();
        try {
            dao.actualizaraPro(iddel, 2);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void actualizaraFinalizado(int iddel) throws Exception {
        DeliveryDAO dao = new DeliveryDAO();
        try {
            dao.actualizaraPro(iddel, 3);
        } catch (Exception e) {
            throw e;
        }
    }
}
