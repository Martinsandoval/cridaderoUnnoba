/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "galpon_cerdo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GalponCerdo.findAll", query = "SELECT g FROM GalponCerdo g"),
    @NamedQuery(name = "GalponCerdo.findByIdgalponCerdo", query = "SELECT g FROM GalponCerdo g WHERE g.idgalponCerdo = :idgalponCerdo"),
    @NamedQuery(name = "GalponCerdo.findByFIni", query = "SELECT g FROM GalponCerdo g WHERE g.fIni = :fIni"),
    @NamedQuery(name = "GalponCerdo.findByFFin", query = "SELECT g FROM GalponCerdo g WHERE g.fFin = :fFin"),
    @NamedQuery(name = "GalponCerdo.findByCerdo", query = "SELECT g FROM GalponCerdo g WHERE g.idcerdo = :cerdo")
})
public class GalponCerdo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgalpon_cerdo")
    private Integer idgalponCerdo;
    @Column(name = "f_ini")
    @Temporal(TemporalType.DATE)
    private Date fIni;
    @Column(name = "f_fin")
    @Temporal(TemporalType.DATE)
    private Date fFin;
    @JoinColumn(name = "idgalpon", referencedColumnName = "idgalpon")
    @ManyToOne
    private Galpon idgalpon;
    @JoinColumn(name = "idcerdo", referencedColumnName = "idcerdo")
    @ManyToOne
    private Cerdo idcerdo;

    public GalponCerdo() {
    }

    public GalponCerdo(Integer idgalponCerdo) {
        this.idgalponCerdo = idgalponCerdo;
    }

    public Integer getIdgalponCerdo() {
        return idgalponCerdo;
    }

    public void setIdgalponCerdo(Integer idgalponCerdo) {
        this.idgalponCerdo = idgalponCerdo;
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

    public Galpon getIdgalpon() {
        return idgalpon;
    }

    public void setIdgalpon(Galpon idgalpon) {
        this.idgalpon = idgalpon;
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
        hash += (idgalponCerdo != null ? idgalponCerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GalponCerdo)) {
            return false;
        }
        GalponCerdo other = (GalponCerdo) object;
        if ((this.idgalponCerdo == null && other.idgalponCerdo != null) || (this.idgalponCerdo != null && !this.idgalponCerdo.equals(other.idgalponCerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.GalponCerdo[ idgalponCerdo=" + idgalponCerdo + " ]";
    }

    public List getCerdo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
