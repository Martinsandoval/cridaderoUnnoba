/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Sandoval
 */
@Entity
@Table(name = "galpon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galpon.findAll", query = "SELECT g FROM Galpon g"),
    @NamedQuery(name = "Galpon.findByIdgalpon", query = "SELECT g FROM Galpon g WHERE g.idgalpon = :idgalpon"),
    @NamedQuery(name = "Galpon.findByNumero", query = "SELECT g FROM Galpon g WHERE g.numero = :numero"),
    @NamedQuery(name = "Galpon.findByNombre", query = "SELECT g FROM Galpon g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Galpon.findByCapacidad", query = "SELECT g FROM Galpon g WHERE g.capacidad = :capacidad"),
    @NamedQuery(name = "Galpon.findByTemperatura", query = "SELECT g FROM Galpon g WHERE g.temperatura = :temperatura"),    
    @NamedQuery(name = "Galpon.idGalpon", query = "SELECT g FROM Galpon g WHERE g.nombre = :nombre") //Para que ingrese el nombre del galpon en vez del id
})
public class Galpon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgalpon")
    private Integer idgalpon;
    @Column(name = "numero")
    private Integer numero;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "capacidad")
    private Integer capacidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperatura")
    private Float temperatura;
    @OneToMany(mappedBy = "idgalpon")
    private Collection<GalponCerdo> galponCerdoCollection;

    public Galpon() {
    }

    public Galpon(Integer idgalpon) {
        this.idgalpon = idgalpon;
    }

    public Integer getIdgalpon() {
        return idgalpon;
    }

    public void setIdgalpon(Integer idgalpon) {
        this.idgalpon = idgalpon;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    @XmlTransient
    public Collection<GalponCerdo> getGalponCerdoCollection() {
        return galponCerdoCollection;
    }

    public void setGalponCerdoCollection(Collection<GalponCerdo> galponCerdoCollection) {
        this.galponCerdoCollection = galponCerdoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgalpon != null ? idgalpon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galpon)) {
            return false;
        }
        Galpon other = (Galpon) object;
        if ((this.idgalpon == null && other.idgalpon != null) || (this.idgalpon != null && !this.idgalpon.equals(other.idgalpon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Galpon[ idgalpon=" + idgalpon + " ]";
    }
    
}
