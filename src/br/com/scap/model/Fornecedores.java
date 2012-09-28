/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByIFornecedores", query = "SELECT f FROM Fornecedores f WHERE f.iFornecedores = :iFornecedores"),
    @NamedQuery(name = "Fornecedores.findByNome", query = "SELECT f FROM Fornecedores f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedores.findByTelefone", query = "SELECT f FROM Fornecedores f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedores.findByEmail", query = "SELECT f FROM Fornecedores f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedores.findByTipoPessoa", query = "SELECT f FROM Fornecedores f WHERE f.tipoPessoa = :tipoPessoa")})
public class Fornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_fornecedores")
    private Integer iFornecedores;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "tipo_pessoa")
    private String tipoPessoa;
    @JoinColumn(name = "i_municipio", referencedColumnName = "i_municipios")
    @ManyToOne
    private Municipios iMunicipio;
    @JoinColumn(name = "i_pais", referencedColumnName = "i_pais")
    @ManyToOne
    private Pais iPais;
    @JoinColumn(name = "i_estado", referencedColumnName = "i_estado")
    @ManyToOne
    private Estado iEstado;

    public Fornecedores() {
    }

    public Fornecedores(Integer iFornecedores) {
        this.iFornecedores = iFornecedores;
    }

    public Fornecedores(Integer iFornecedores, String nome) {
        this.iFornecedores = iFornecedores;
        this.nome = nome;
    }

    public Integer getIFornecedores() {
        return iFornecedores;
    }

    public void setIFornecedores(Integer iFornecedores) {
        this.iFornecedores = iFornecedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Municipios getIMunicipio() {
        return iMunicipio;
    }

    public void setIMunicipio(Municipios iMunicipio) {
        this.iMunicipio = iMunicipio;
    }

    public Pais getIPais() {
        return iPais;
    }

    public void setIPais(Pais iPais) {
        this.iPais = iPais;
    }

    public Estado getIEstado() {
        return iEstado;
    }

    public void setIEstado(Estado iEstado) {
        this.iEstado = iEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iFornecedores != null ? iFornecedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.iFornecedores == null && other.iFornecedores != null) || (this.iFornecedores != null && !this.iFornecedores.equals(other.iFornecedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Fornecedores[ iFornecedores=" + iFornecedores + " ]";
    }
    
}
