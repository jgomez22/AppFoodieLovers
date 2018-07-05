package bean;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Delivery;

@ManagedBean
@RequestScoped
public class DeliveryBean {
    
    private Delivery delivery = new Delivery();

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
      
}
