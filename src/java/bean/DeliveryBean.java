package bean;

import dao.DeliveryDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Delivery;

@ManagedBean
@RequestScoped
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

    public void listar(int id) throws SQLException {
        DeliveryDAO dao = new DeliveryDAO();
        try {
            lstDelivery = dao.listar(id);
        } catch (SQLException e) {
            throw e;
        }
    }
}
