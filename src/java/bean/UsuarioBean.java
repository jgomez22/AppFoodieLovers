package bean;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;

@ManagedBean
@RequestScoped

public class UsuarioBean {

    private Usuario usuario = new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void registrar() {
        UsuarioDAO dao = new UsuarioDAO();

        try {
            dao.registrar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado correctamente", ""));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String obtenerNombre(int id) throws Exception {
        String nombre = "";
        UsuarioDAO dao = new UsuarioDAO();
        try {
            nombre = dao.obtenerNombre(id);
        } catch (Exception e) {
            throw e;
        }
        return nombre;
    }

    public String iniciaSe() {
        String redireccion2 = "";
        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario validar;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "rrrrr", usuario.getCorreo() + " " + usuario.getContrasena()));

            validar = dao.iniciarSession(usuario.getCorreo(), usuario.getContrasena());
            if (validar != null) {
                this.usuario = validar;
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", validar);
                redireccion2 = "principal.xhtml?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Datos incorretos"));
                redireccion2 = "login.xhtml";
            }

        } catch (Exception ex) {
            redireccion2 = "login.xhtml";
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return redireccion2;
    }

    public Boolean verificarSession() {
        Boolean estado;
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (us == null) {
                estado = true;
            } else {
                estado = false;
            }
        } catch (Exception e) {
            estado = true;
        }
        return estado;
    }

    public void cerrarSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public String mostrarUsu() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (us == null) {
            return "Falta logearse";
        } else {
            return us.getNombre();
        }

    }

    public int mostrarId() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        return us.getIdusuario();
    }

    public int obtenerIdEmpresa(int idusu) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        int idemp;
        try {
            idemp = dao.obtenerIdEmpresa(idusu);
        } catch (Exception e) {
            throw e;
        }
        return idemp;
    }

    public String validarCuentaRestaurant() throws Exception {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        UsuarioDAO dao = new UsuarioDAO();
        String red;
        try {
            if (dao.validarCuentaRestaurant(us.getIdusuario()) != 0) {
                red = "home.xhtml";
            } else {
                red = "empresa_registrar.xhtml";
            }
        } catch (Exception e) {
            throw e;
        }
        return red;
    }

    public String validarHome() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        String link = "";
        try {
            if (us == null) {
                link = "index.xhtml";
            } else {
                link = "principal.xhtml";
            }
        } catch (Exception e) {
            throw e;
        }
        return link;
    }

    public String validarAdmin() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        String link = "";
        try {
            if (us == null) {
                link = "index.xhtml";
            } else {
                link = "usuario_index.xhtml";
            }
        } catch (Exception e) {
            throw e;
        }
        return link;
    }

    public String btnValue() {
        String nombre = "";
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            if (us == null) {
                nombre = "Login";
            } else {
                nombre = "Salir";
            }
        } catch (Exception e) {
            throw e;
        }
        return nombre;
    }

    public void btnActList() throws Exception {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        try {
            if (us == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            } else {
                cerrarSession();
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        } catch (Exception e) {
            throw e;
        }
    }


}
