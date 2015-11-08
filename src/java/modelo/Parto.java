/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sandoval
 */
@Entity
@Table(name = "parto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parto.findAll", query = "SELECT p FROM Parto p"),
    @NamedQuery(name = "Parto.findByIdparto", query = "SELECT p FROM Parto p WHERE p.idparto = :idparto"),
    @NamedQuery(name = "Parto.findByNumParto", query = "SELECT p FROM Parto p WHERE p.numParto = :numParto"),
    @NamedQuery(name = "Parto.findByCantChancho", query = "SELECT p FROM Parto p WHERE p.cantChancho = :cantChancho"),
    @NamedQuery(name = "Parto.findByCantMuertos", query = "SELECT p FROM Parto p WHERE p.cantMuertos = :cantMuertos"),
    @NamedQuery(name = "Parto.findByFecha", query = "SELECT p FROM Parto p WHERE p.fecha = :fecha")})
public class Parto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idparto")
    private Integer idparto;
    @Column(name = "num_parto")
    private Integer numParto;
    @Column(name = "cant_chancho")
    private Integer cantChancho;
    @Column(name = "cant_muertos")
    private Integer cantMuertos;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idcerdo", referencedColumnName = "idcerdo")
    @ManyToOne
    private Cerdo idcerdo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cria")
    private Collection<TienePartos> tienePartosCollection;
    @Column(name = "nro_caravana")
    private Integer nrocaravana;

    public Parto() {
    }

    public Parto(Integer idparto) {
        this.idparto = idparto;
    }

    public Integer getIdparto() {
        return idparto;
    }

    public void setIdparto(Integer idparto) {
        this.idparto = idparto;
    }

    public Integer getNumParto() {
        return numParto;
    }

    public void setNumParto(Integer numParto) {
        this.numParto = numParto;
    }

    public Integer getNrocaravana() {
        return nrocaravana;
    }

    public void setNrocaravana(Integer nrocaravana) {
        this.nrocaravana = nrocaravana;
    }

    
    public Integer getCantChancho() {
        return cantChancho;
    }

    public void setCantChancho(Integer cantChancho) {
        this.cantChancho = cantChancho;
    }

    public Integer getCantMuertos() {
        return cantMuertos;
    }

    public void setCantMuertos(Integer cantMuertos) {
        this.cantMuertos = cantMuertos;
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

    @XmlTransient
    public Collection<TienePartos> getTienePartosCollection() {
        return tienePartosCollection;
    }

    public void setTienePartosCollection(Collection<TienePartos> tienePartosCollection) {
        this.tienePartosCollection = tienePartosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idparto != null ? idparto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parto)) {
            return false;
        }
        Parto other = (Parto) object;
        if ((this.idparto == null && other.idparto != null) || (this.idparto != null && !this.idparto.equals(other.idparto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Parto[ idparto=" + idparto + " ]";
    }
    
}
