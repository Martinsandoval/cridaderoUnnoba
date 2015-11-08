/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sandoval
 */
@Entity
@Table(name = "cerdo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cerdo.findAll", query = "SELECT c FROM Cerdo c"),
    @NamedQuery(name = "Cerdo.findByIdcerdo", query = "SELECT c FROM Cerdo c WHERE c.idcerdo = :idcerdo"),
    @NamedQuery(name = "Cerdo.findBySexo", query = "SELECT c FROM Cerdo c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cerdo.findByGalpon", query = "SELECT c FROM Cerdo c WHERE c.galpon = :galpon"),
    @NamedQuery(name = "Cerdo.findByEstadoCorporal", query = "SELECT c FROM Cerdo c WHERE c.estadoCorporal = :estadoCorporal"),
    @NamedQuery(name = "Cerdo.findByNCaravana", query = "SELECT c FROM Cerdo c WHERE c.nCaravana = :nCaravana")})
public class Cerdo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "idcerdo", strategy = GenerationType.IDENTITY)
    
    private Integer idcerdo;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "galpon")
    private Integer galpon;
    @Size(max = 2147483647)
    @Column(name = "estado_corporal")
    private String estadoCorporal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_caravana")
    private int nCaravana;
    @OneToMany(mappedBy = "idcerdo")
    private Collection<CerdoEnfermedad> cerdoEnfermedadCollection;
    @OneToMany(mappedBy = "idcerdo")
    private Collection<CerdoVacuna> cerdoVacunaCollection;
    @OneToMany(mappedBy = "idcerdo")
    private Collection<Parto> partoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "progenitor")
    private Collection<TienePartos> tienePartosCollection;
    @OneToMany(mappedBy = "idcerdo")
    private Collection<GalponCerdo> galponCerdoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcerdo")
    private Collection<Pesaje> pesajeCollection;

    public Cerdo() {
    }

    public Cerdo(Integer idcerdo) {
        this.idcerdo = idcerdo;
    }

    public Cerdo(Integer idcerdo, int nCaravana) {
        this.idcerdo = idcerdo;
        this.nCaravana = nCaravana;
    }

    public Integer getIdcerdo() {
        return idcerdo;
    }

    public void setIdcerdo(Integer idcerdo) {
        this.idcerdo = idcerdo;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getGalpon() {
        return galpon;
    }

    public void setGalpon(Integer galpon) {
        this.galpon = galpon;
    }

    public String getEstadoCorporal() {
        return estadoCorporal;
    }

    public void setEstadoCorporal(String estadoCorporal) {
        this.estadoCorporal = estadoCorporal;
    }

    public int getNCaravana() {
        return nCaravana;
    }

    public void setNCaravana(int nCaravana) {
        this.nCaravana = nCaravana;
    }

    @XmlTransient
    public Collection<CerdoEnfermedad> getCerdoEnfermedadCollection() {
        return cerdoEnfermedadCollection;
    }

    public void setCerdoEnfermedadCollection(Collection<CerdoEnfermedad> cerdoEnfermedadCollection) {
        this.cerdoEnfermedadCollection = cerdoEnfermedadCollection;
    }

    @XmlTransient
    public Collection<CerdoVacuna> getCerdoVacunaCollection() {
        return cerdoVacunaCollection;
    }

    public void setCerdoVacunaCollection(Collection<CerdoVacuna> cerdoVacunaCollection) {
        this.cerdoVacunaCollection = cerdoVacunaCollection;
    }

    @XmlTransient
    public Collection<Parto> getPartoCollection() {
        return partoCollection;
    }

    public void setPartoCollection(Collection<Parto> partoCollection) {
        this.partoCollection = partoCollection;
    }

    @XmlTransient
    public Collection<TienePartos> getTienePartosCollection() {
        return tienePartosCollection;
    }

    public void setTienePartosCollection(Collection<TienePartos> tienePartosCollection) {
        this.tienePartosCollection = tienePartosCollection;
    }

    @XmlTransient
    public Collection<GalponCerdo> getGalponCerdoCollection() {
        return galponCerdoCollection;
    }

    public void setGalponCerdoCollection(Collection<GalponCerdo> galponCerdoCollection) {
        this.galponCerdoCollection = galponCerdoCollection;
    }

    @XmlTransient
    public Collection<Pesaje> getPesajeCollection() {
        return pesajeCollection;
    }

    public void setPesajeCollection(Collection<Pesaje> pesajeCollection) {
        this.pesajeCollection = pesajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcerdo != null ? idcerdo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cerdo)) {
            return false;
        }
        Cerdo other = (Cerdo) object;
        if ((this.idcerdo == null && other.idcerdo != null) || (this.idcerdo != null && !this.idcerdo.equals(other.idcerdo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cerdo[ idcerdo=" + idcerdo + " ]";
    }
}
