/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m"),
    @NamedQuery(name = "Municipios.findByIMunicipios", query = "SELECT m FROM Municipios m WHERE m.iMunicipios = :iMunicipios"),
    @NamedQuery(name = "Municipios.findByNome", query = "SELECT m FROM Municipios m WHERE m.nome = :nome")})
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_municipios")
    private Integer iMunicipios;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "iMunicipio")
    private Collection<Fornecedores> fornecedoresCollection;

    public Municipios() {
    }

    public Municipios(Integer iMunicipios) {
        this.iMunicipios = iMunicipios;
    }

    public Municipios(Integer iMunicipios, String nome) {
        this.iMunicipios = iMunicipios;
        this.nome = nome;
    }

    public Integer getIMunicipios() {
        return iMunicipios;
    }

    public void setIMunicipios(Integer iMunicipios) {
        this.iMunicipios = iMunicipios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Fornecedores> getFornecedoresCollection() {
        return fornecedoresCollection;
    }

    public void setFornecedoresCollection(Collection<Fornecedores> fornecedoresCollection) {
        this.fornecedoresCollection = fornecedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iMunicipios != null ? iMunicipios.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.iMunicipios == null && other.iMunicipios != null) || (this.iMunicipios != null && !this.iMunicipios.equals(other.iMunicipios))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Municipios[ iMunicipios=" + iMunicipios + " ]";
    }
    
}
