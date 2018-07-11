package bean;

import dao.EmpresaDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Empresa;

@ManagedBean
@RequestScoped
public class EmpresaBean {

    private Empresa empresa = new Empresa();

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String obtenerNombre(int id) {
        String nombre = null;
        EmpresaDAO dao = new EmpresaDAO();
        try {
            nombre = dao.obtenerNombre(id);
        } catch (Exception e) {
            throw e;
        }
        return nombre;
    }

    public void registrarEmpresa(int idu) throws Exception {

        EmpresaDAO dao = new EmpresaDAO();
        try {
            dao.registrarEmpresa(empresa, idu);

        } catch (SQLException ex) {
            Logger.getLogger(EmpresaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
