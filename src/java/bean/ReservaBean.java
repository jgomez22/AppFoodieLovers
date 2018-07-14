package bean;

import dao.ReservaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Reserva;

@ManagedBean
@ViewScoped
public class ReservaBean {

    private Reserva reserva = new Reserva();
    private List<Reserva> lstReserva;

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getLstReserva() {
        return lstReserva;
    }

    public void setLstReserva(List<Reserva> lstReserva) {
        this.lstReserva = lstReserva;
    }

    public List<Reserva> listar(int id) {
        ReservaDAO dao = new ReservaDAO();
        try {
            //lstReserva = dao.listar(id);
        } catch (Exception e) {
            throw e;
        }
        return lstReserva;
    }

    public List<Reserva> listarEmpresa(int id, int idest) throws Exception {
        ReservaDAO dao = new ReservaDAO();
        try {
            lstReserva = dao.listarEmpresa(id, idest);
        } catch (Exception e) {
            throw e;
        }
        return lstReserva;
    }

    public String actualizaraProceso(int idres) throws Exception {
        ReservaDAO dao = new ReservaDAO();
        String red;
        try {
            dao.actualizaraPro(idres, 2);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se actualizo el estado", ""));
        } catch (Exception e) {
            throw e;
        }
        return "empresa_servicios_inicio.xhtml";
    }

    public String actualizaraFinalizado(int idres) throws Exception {
        ReservaDAO dao = new ReservaDAO();
        String red;
        try {
            dao.actualizaraPro(idres, 3);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se actualizo el estado", ""));
        } catch (Exception e) {
            throw e;
        }
        return "empresa_servicio_proceso.xhtml";
    }
}
