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
@Table(name = "vacuna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacuna.findAll", query = "SELECT v FROM Vacuna v"),
    @NamedQuery(name = "Vacuna.findByIdvacuna", query = "SELECT v FROM Vacuna v WHERE v.idvacuna = :idvacuna"),
    @NamedQuery(name = "Vacuna.findByNombre", query = "SELECT v FROM Vacuna v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vacuna.findByTipo", query = "SELECT v FROM Vacuna v WHERE v.tipo = :tipo")})
public class Vacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idvacuna")
    private Integer idvacuna;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "idvacuna")
    private Collection<CerdoVacuna> cerdoVacunaCollection;

    public Vacuna() {
    }

    public Vacuna(Integer idvacuna) {
        this.idvacuna = idvacuna;
    }

    public Integer getIdvacuna() {
        return idvacuna;
    }

    public void setIdvacuna(Integer idvacuna) {
        this.idvacuna = idvacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<CerdoVacuna> getCerdoVacunaCollection() {
        return cerdoVacunaCollection;
    }

    public void setCerdoVacunaCollection(Collection<CerdoVacuna> cerdoVacunaCollection) {
        this.cerdoVacunaCollection = cerdoVacunaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvacuna != null ? idvacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacuna)) {
            return false;
        }
        Vacuna other = (Vacuna) object;
        if ((this.idvacuna == null && other.idvacuna != null) || (this.idvacuna != null && !this.idvacuna.equals(other.idvacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Vacuna[ idvacuna=" + idvacuna + " ]";
    }
    
}
