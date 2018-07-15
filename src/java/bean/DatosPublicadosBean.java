/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Publicacion_Plato;

@ManagedBean
@ViewScoped

public class DatosPublicadosBean {
    
    
    
    private PublicacionBean publicacionBean ;
    private List<PublicacionxProducto> lstPublicacionxProducto2;
    private String Empresa;
    private String Direccion;
    private String Delivery;
    private String Reserva;

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
    
    
    @PostConstruct
    public void init(){
        this.Empresa = publicacionBean.getEmpresa();
        this.Direccion = publicacionBean.getDireccion();
        this.Delivery = publicacionBean.getDelivery();
        this.Reserva = publicacionBean.getReserva();
    }
}
