package modelo;

public class Publicacion {
    
    private int idpublicacion;
    private String nombre;
    private String horapublicacion;
    private String horacierre;
    private int idempresa;

    public int getIdpublicacion() {
        return idpublicacion;
    }

    public void setIdpublicacion(int idpublicacion) {
        this.idpublicacion = idpublicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorapublicacion() {
        return horapublicacion;
    }

    public void setHorapublicacion(String horapublicacion) {
        this.horapublicacion = horapublicacion;
    }

    public String getHoracierre() {
        return horacierre;
    }

    public void setHoracierre(String horacierre) {
        this.horacierre = horacierre;
    }

    public int getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(int idempresa) {
        this.idempresa = idempresa;
    }
}
