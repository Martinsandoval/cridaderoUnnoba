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
@Table(name = "tiene_partos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TienePartos.findAll", query = "SELECT t FROM TienePartos t"),
    @NamedQuery(name = "TienePartos.findByIdTienePartos", query = "SELECT t FROM TienePartos t WHERE t.idTienePartos = :idTienePartos"),
    @NamedQuery(name = "TienePartos.findByFecha", query = "SELECT t FROM TienePartos t WHERE t.fecha = :fecha")})
public class TienePartos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tiene_partos")
    private Integer idTienePartos;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "cria", referencedColumnName = "idparto")
    @ManyToOne(optional = false)
    private Parto cria;
    @JoinColumn(name = "progenitor", referencedColumnName = "idcerdo")
    @ManyToOne(optional = false)
    private Cerdo progenitor;

    public TienePartos() {
    }

    public TienePartos(Integer idTienePartos) {
        this.idTienePartos = idTienePartos;
    }

    public Integer getIdTienePartos() {
        return idTienePartos;
    }

    public void setIdTienePartos(Integer idTienePartos) {
        this.idTienePartos = idTienePartos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Parto getCria() {
        return cria;
    }

    public void setCria(Parto cria) {
        this.cria = cria;
    }

    public Cerdo getProgenitor() {
        return progenitor;
    }

    public void setProgenitor(Cerdo progenitor) {
        this.progenitor = progenitor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTienePartos != null ? idTienePartos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TienePartos)) {
            return false;
        }
        TienePartos other = (TienePartos) object;
        if ((this.idTienePartos == null && other.idTienePartos != null) || (this.idTienePartos != null && !this.idTienePartos.equals(other.idTienePartos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.TienePartos[ idTienePartos=" + idTienePartos + " ]";
    }
    
}
