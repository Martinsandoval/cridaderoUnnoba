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
@Table(name = "cerdo_vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CerdoVacuna.findAll", query = "SELECT c FROM CerdoVacuna c"),
    @NamedQuery(name = "CerdoVacuna.findByIdcerdoVacuna", query = "SELECT c FROM CerdoVacuna c WHERE c.idcerdoVacuna = :idcerdoVacuna"),
    @NamedQuery(name = "CerdoVacuna.findByFecha", query = "SELECT c FROM CerdoVacuna c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CerdoVacuna.findByCerdo", query = "SELECT c FROM CerdoVacuna c WHERE c.idcerdo = :idcerdo"),
    @NamedQuery(name = "CerdoVacuna.findByDosis", query = "SELECT c FROM CerdoVacuna c WHERE c.dosis = :dosis")})
public class CerdoVacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcerdo_vacuna")
    private Integer idcerdoVacuna;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dosis")
    private Float dosis;
    @JoinColumn(name = "idvacuna", referencedColumnName = "idvacuna")
    @ManyToOne
    private Vacuna idvacuna;
    @JoinColumn(name = "idcerdo", referencedColumnName = "idcerdo")
    @ManyToOne
    private Cerdo idcerdo;

    public CerdoVacuna() {
    }

    public CerdoVacuna(Integer idcerdoVacuna) {
        this.idcerdoVacuna = idcerdoVacuna;
    }

    public Integer getIdcerdoVacuna() {
        return idcerdoVacuna;
    }

    public void setIdcerdoVacuna(Integer idcerdoVacuna) {
        this.idcerdoVacuna = idcerdoVacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getDosis() {
        return dosis;
    }

    public void setDosis(Float dosis) {
        this.dosis = dosis;
    }

    public Vacuna getIdvacuna() {
        return idvacuna;
    }

    public void setIdvacuna(Vacuna idvacuna) {
        this.idvacuna = idvacuna;
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
        hash += (idcerdoVacuna != null ? idcerdoVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CerdoVacuna)) {
            return false;
        }
        CerdoVacuna other = (CerdoVacuna) object;
        if ((this.idcerdoVacuna == null && other.idcerdoVacuna != null) || (this.idcerdoVacuna != null && !this.idcerdoVacuna.equals(other.idcerdoVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.CerdoVacuna[ idcerdoVacuna=" + idcerdoVacuna + " ]";
    }
    
}
