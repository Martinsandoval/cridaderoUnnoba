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
@Table(name = "cerdo_enfermedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CerdoEnfermedad.findAll", query = "SELECT c FROM CerdoEnfermedad c"),
    @NamedQuery(name = "CerdoEnfermedad.findByIdcerdoEnfermedad", query = "SELECT c FROM CerdoEnfermedad c WHERE c.idcerdoEnfermedad = :idcerdoEnfermedad"),
    @NamedQuery(name = "CerdoEnfermedad.findByFIni", query = "SELECT c FROM CerdoEnfermedad c WHERE c.fIni = :fIni"),
    @NamedQuery(name = "CerdoEnfermedad.findByFFin", query = "SELECT c FROM CerdoEnfermedad c WHERE c.fFin = :fFin")})
public class CerdoEnfermedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcerdo_enfermedad")
    private Integer idcerdoEnfermedad;
    @Column(name = "f_ini")
    @Temporal(TemporalType.DATE)
    private Date fIni;
    @Column(name = "f_fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;
    @JoinColumn(name = "idenfermedad", referencedColumnName = "idenfermedad")
    @ManyToOne
    private Enfermedad idenfermedad;
    @JoinColumn(name = "idcerdo", referencedColumnName = "idcerdo")
    @ManyToOne
    private Cerdo idcerdo;

    public CerdoEnfermedad() {
    }

    public CerdoEnfermedad(Integer idcerdoEnfermedad) {
        this.idcerdoEnfermedad = idcerdoEnfermedad;
    }

    public Integer getIdcerdoEnfermedad() {
        return idcerdoEnfermedad;
    }

    public void setIdcerdoEnfermedad(Integer idcerdoEnfermedad) {
        this.idcerdoEnfermedad = idcerdoEnfermedad;
    }

    public Date getFIni() {
        return fIni;
    }

    public void setFIni(Date fIni) {
        this.fIni = fIni;
    }

    public Date getFFin() {
        return fFin;
    }

    public void setFFin(Date fFin) {
        this.fFin = fFin;
    }

    public Enfermedad getIdenfermedad() {
        return idenfermedad;
    }

    public void setIdenfermedad(Enfermedad idenfermedad) {
        this.idenfermedad = idenfermedad;
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
        hash += (idcerdoEnfermedad != null ? idcerdoEnfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CerdoEnfermedad)) {
            return false;
        }
        CerdoEnfermedad other = (CerdoEnfermedad) object;
        if ((this.idcerdoEnfermedad == null && other.idcerdoEnfermedad != null) || (this.idcerdoEnfermedad != null && !this.idcerdoEnfermedad.equals(other.idcerdoEnfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CerdoEnfermedad[ idcerdoEnfermedad=" + idcerdoEnfermedad + " ]";
    }
    
}
