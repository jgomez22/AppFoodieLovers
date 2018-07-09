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
    
    public void listarEmpresa (int id, int idest) throws Exception{
        DeliveryDAO dao = new DeliveryDAO();
        try{
            lstDelivery = dao.listarEmpresa(id, idest);
        } catch(Exception e){
            throw e;
        }
    }
    
    public void actualizaraProceso(int iddel) throws Exception{
        DeliveryDAO dao = new DeliveryDAO();
        try{
            dao.actualizaraPro(iddel);
        } catch(Exception e){
            throw e;
        }
    }
    
    public void actualizaraFinalizado(){
        
        
    }
}
