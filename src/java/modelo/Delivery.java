package modelo;

public class Delivery {
    private int iddelivery;
    private int cantidad;
    private Double importe_total;
    private String direccion;
    private String detalles;
    private int idusuario;
    private int idproducto;
    private int idestado;

    public int getIddelivery() {
        return iddelivery;
    }

    public void setIddelivery(int iddelivery) {
        this.iddelivery = iddelivery;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }
}
