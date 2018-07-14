/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author david
 */
public class Publicacion_Plato {
    private String plato;
    private int id_plato;
    private String comentario;
    private int id_empresa;
    private String empresa;
    private int id_puplicado;
    private String direccion;
    private String est_delivery;
    private String est_reserva;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEst_delivery() {
        return est_delivery;
    }

    public void setEst_delivery(String est_delivery) {
        this.est_delivery = est_delivery;
    }

    public String getEst_reserva() {
        return est_reserva;
    }

    public void setEst_reserva(String est_reserva) {
        this.est_reserva = est_reserva;
    }
    public Publicacion_Plato() {
    }

    
    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public int getId_plato() {
        return id_plato;
    }

    public void setId_plato(int id_plato) {
        this.id_plato = id_plato;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId_puplicado() {
        return id_puplicado;
    }

    public void setId_puplicado(int id_puplicado) {
        this.id_puplicado = id_puplicado;
    }
    
}
