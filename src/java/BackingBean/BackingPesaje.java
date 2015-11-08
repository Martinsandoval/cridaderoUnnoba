/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.PesajeDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.Pesaje;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Islas, Juan Pablo
 */
@ManagedBean
@ApplicationScoped
public class BackingPesaje {

    @EJB
    private PesajeDAO pesajeDAO;
    @EJB
    private CerdoDAO cerdoDAO;
    private int idcerdo;
    private Cerdo cerdo;
    private String fecha;
    /*  Atributos para crear nuevo pesaje         */
    private Cerdo idCerdo;
    private float valor;
    private Pesaje pesaje;
    private Date date3;
 
    
    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public BackingPesaje() {
       

    }

    public Pesaje getPesaje() {
        return pesaje;
    }

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public void setPesaje(Pesaje pesaje) {
        this.pesaje = pesaje;
    }

    public int getIdcerdo() {
        return idcerdo;
    }

    public void setIdcerdo(int idcerdo) {
        this.idcerdo = idcerdo;
    }

    public PesajeDAO getPesajeDAO() {
        return pesajeDAO;
    }

    public void setPesajeDAO(PesajeDAO pesajeDAO) {
        this.pesajeDAO = pesajeDAO;
    }

    public Cerdo getIdCerdo() {
        return idCerdo;
    }

    public void setIdCerdo(Cerdo idCerdo) {
        this.idCerdo = idCerdo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Pesaje> getPesajes() {
        return pesajeDAO.getAll();
    }

    public List<Pesaje> historialPesaje() {
        return pesajeDAO.historial(cerdo);
    }

  
    public String cargar() throws ParseException {
         pesaje = new Pesaje();
        pesaje.setFecha(date3);
        pesaje.setValor(valor);
        pesaje.setIdcerdo(cerdoDAO.buscar(cerdo.getIdcerdo()));
        return "";
    }

    public String crearPesaje() {
        try {

            /*   Almacenamiento en Base de Datos   */

            this.cargar();
            pesajeDAO.create(pesaje);
            cerdo.getPesajeCollection().add(pesaje);

            /*   Mensaje de exito   */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El pesaje fue almacenado."));
            return "/admin/Pesaje/pesajeCerdo.xhtml";
        } catch (Exception e) {
            /*   Mensaje de error   */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al registrar el pesaje."));
            return "/admin/Pesaje/newPesaje.xhtml";
        }
    }

    public String eliminarPesaje(int idPesaje) {
        try {
            Pesaje p = pesajeDAO.buscar(idPesaje);
            cerdo.getPesajeCollection().remove(p);
            pesajeDAO.remove(p);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El pesaje fue eliminado exitosamente"));
            return "";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el pesaje"));
            return "";
        }
    }
    
     public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public float maxPeso(){
        float max = 0;
        for(Pesaje p: this.cerdo.getPesajeCollection()){
            if(p.getValor() > max)
                max = p.getValor();
        }
        
        return max;
    }
    
       public float minPeso(){
        float min = 0;
        for(Pesaje p: this.cerdo.getPesajeCollection()){
            if(p.getValor() < min)
                min = p.getValor();
        }
        
        return min;
    }
       
     public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha elegida", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    } 
    
  
}
