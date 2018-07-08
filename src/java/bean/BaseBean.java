/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author jared
 */
public class BaseBean {
    
    private int userId;
    private int empresaId;

    public BaseBean() {
    }
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }
    
    
    
}
