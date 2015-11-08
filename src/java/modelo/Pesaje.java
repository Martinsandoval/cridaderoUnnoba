/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sandoval
 */
@Entity
@Table(name = "pesaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pesaje.findAll", query = "SELECT p FROM Pesaje p"),
    @NamedQuery(name = "Pesaje.findByIdpesaje", query = "SELECT p FROM Pesaje p WHERE p.idpesaje = :idpesaje"),
    @NamedQuery(name = "Pesaje.findByValor", query = "SELECT p FROM Pesaje p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pesaje.findByFecha", query = "SELECT p FROM Pesaje p WHERE p.fecha = :fecha")})
    @NamedQuery(name = "Pesaje.findByIdCerdo", query = "SELECT p FROM Pesaje p LEFT JOIN Cerdo c on p.idcerdo = idcerdo")
public class Pesaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpesaje")
    private Integer idpesaje;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idcerdo", referencedColumnName = "idcerdo")
    @ManyToOne(optional = false)
    private Cerdo idcerdo;

    public Pesaje() {
    }

    public Pesaje(Integer idpesaje) {
        this.idpesaje = idpesaje;
    }

    public Integer getIdpesaje() {
        return idpesaje;
    }

    public void setIdpesaje(Integer idpesaje) {
        this.idpesaje = idpesaje;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cerdo getIdcerdo() {
        return idcerdo;
    }

    public void setIdcerdo(Cerdo idcerdo) {
        this.idcerdo = idcerdo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpesaje != null ? idpesaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pesaje)) {
            return false;
        }
        Pesaje other = (Pesaje) object;
        if ((this.idpesaje == null && other.idpesaje != null) || (this.idpesaje != null && !this.idpesaje.equals(other.idpesaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pesaje[ idpesaje=" + idpesaje + " ]";
    }
    
}
