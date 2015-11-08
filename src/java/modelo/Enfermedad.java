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
@Table(name = "enfermedad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfermedad.findAll", query = "SELECT e FROM Enfermedad e"),
    @NamedQuery(name = "Enfermedad.findByIdenfermedad", query = "SELECT e FROM Enfermedad e WHERE e.idenfermedad = :idenfermedad"),
    @NamedQuery(name = "Enfermedad.findByNombreCientifico", query = "SELECT e FROM Enfermedad e WHERE e.nombreCientifico = :nombreCientifico"),
    @NamedQuery(name = "Enfermedad.findByNombrePopular", query = "SELECT e FROM Enfermedad e WHERE e.nombrePopular = :nombrePopular")})
public class Enfermedad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "idenfermedad", strategy = GenerationType.IDENTITY)
    @Column(name = "idenfermedad")
    private Integer idenfermedad;
    @Size(max = 2147483647)
    @Column(name = "nombre_cientifico")
    private String nombreCientifico;
    @Size(max = 2147483647)
    @Column(name = "nombre_popular")
    private String nombrePopular;
    @OneToMany(mappedBy = "idenfermedad")
    private Collection<CerdoEnfermedad> cerdoEnfermedadCollection;

    public Enfermedad() {
        
    }

    public Enfermedad(Integer idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    public Integer getIdenfermedad() {
        return idenfermedad;
    }

    public void setIdenfermedad(Integer idenfermedad) {
        this.idenfermedad = idenfermedad;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getNombrePopular() {
        return nombrePopular;
    }

    public void setNombrePopular(String nombrePopular) {
        this.nombrePopular = nombrePopular;
    }

    @XmlTransient
    public Collection<CerdoEnfermedad> getCerdoEnfermedadCollection() {
        return cerdoEnfermedadCollection;
    }

    public void setCerdoEnfermedadCollection(Collection<CerdoEnfermedad> cerdoEnfermedadCollection) {
        this.cerdoEnfermedadCollection = cerdoEnfermedadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenfermedad != null ? idenfermedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfermedad)) {
            return false;
        }
        Enfermedad other = (Enfermedad) object;
        if ((this.idenfermedad == null && other.idenfermedad != null) || (this.idenfermedad != null && !this.idenfermedad.equals(other.idenfermedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Enfermedad[ idenfermedad=" + idenfermedad + " ]";
    }
    
}
