package bean;

import dao.ReservaDAO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Reserva;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class ReservaBean {
    
    private int cant_cli;
    private String hor_cli;
    private String det_cli;

    public int getCant_cli() {
        return cant_cli;
    }

    public void setCant_cli(int cant_cli) {
        this.cant_cli = cant_cli;
    }

    public String getHor_cli() {
        return hor_cli;
    }

    public void setHor_cli(String hor_cli) {
        this.hor_cli = hor_cli;
    }

    public String getDet_cli() {
        return det_cli;
    }

    public void setDet_cli(String det_cli) {
        this.det_cli = det_cli;
    }
    
    public void registrar() throws Exception{
        double total,precio;
        int id_us,id_pro;
        ReservaDAO dao = new ReservaDAO();
        precio = (Double) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("precio");
        id_us = mostrarId();
        id_pro = (int) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id_pro");
        total=cant_cli*precio;
        try{
            dao.registrar(cant_cli,total,hor_cli,det_cli,id_us,id_pro);
        } catch(Exception e ){
            throw e;
        }
    }
    
    public int mostrarId(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getIdusuario();
    }

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

    public List<Reserva> listar(int id) throws Exception {
        ReservaDAO dao = new ReservaDAO();
        try {
            lstReserva = dao.listar(id);
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
