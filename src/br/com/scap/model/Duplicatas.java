/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "duplicatas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duplicatas.findAll", query = "SELECT d FROM Duplicatas d"),
    @NamedQuery(name = "Duplicatas.findByIDuplicatas", query = "SELECT d FROM Duplicatas d WHERE d.iDuplicatas = :iDuplicatas"),
    @NamedQuery(name = "Duplicatas.findByIdentificacao", query = "SELECT d FROM Duplicatas d WHERE d.identificacao = :identificacao"),
    @NamedQuery(name = "Duplicatas.findByValor", query = "SELECT d FROM Duplicatas d WHERE d.valor = :valor"),
    @NamedQuery(name = "Duplicatas.findByValorPago", query = "SELECT d FROM Duplicatas d WHERE d.valorPago = :valorPago"),
    @NamedQuery(name = "Duplicatas.findByDataVencimento", query = "SELECT d FROM Duplicatas d WHERE d.dataVencimento = :dataVencimento"),
    @NamedQuery(name = "Duplicatas.findByDataEmissao", query = "SELECT d FROM Duplicatas d WHERE d.dataEmissao = :dataEmissao")})
public class Duplicatas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_duplicatas")
    private Integer iDuplicatas;
    @Basic(optional = false)
    @Column(name = "identificacao")
    private String identificacao;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "valor_pago")
    private double valorPago;
    @Basic(optional = false)
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDuplicatas")
    private Collection<Pagamentos> pagamentosCollection;
    @JoinColumn(name = "i_notas", referencedColumnName = "i_notas")
    @ManyToOne(optional = false)
    private NotasFiscais iNotas;

    public Duplicatas() {
    }

    public Duplicatas(Integer iDuplicatas) {
        this.iDuplicatas = iDuplicatas;
    }

    public Duplicatas(Integer iDuplicatas, String identificacao, double valor, double valorPago, Date dataVencimento, Date dataEmissao) {
        this.iDuplicatas = iDuplicatas;
        this.identificacao = identificacao;
        this.valor = valor;
        this.valorPago = valorPago;
        this.dataVencimento = dataVencimento;
        this.dataEmissao = dataEmissao;
    }

    public Integer getIDuplicatas() {
        return iDuplicatas;
    }

    public void setIDuplicatas(Integer iDuplicatas) {
        this.iDuplicatas = iDuplicatas;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @XmlTransient
    public Collection<Pagamentos> getPagamentosCollection() {
        return pagamentosCollection;
    }

    public void setPagamentosCollection(Collection<Pagamentos> pagamentosCollection) {
        this.pagamentosCollection = pagamentosCollection;
    }

    public NotasFiscais getINotas() {
        return iNotas;
    }

    public void setINotas(NotasFiscais iNotas) {
        this.iNotas = iNotas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDuplicatas != null ? iDuplicatas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duplicatas)) {
            return false;
        }
        Duplicatas other = (Duplicatas) object;
        if ((this.iDuplicatas == null && other.iDuplicatas != null) || (this.iDuplicatas != null && !this.iDuplicatas.equals(other.iDuplicatas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Duplicatas[ iDuplicatas=" + iDuplicatas + " ]";
    }
    
}
