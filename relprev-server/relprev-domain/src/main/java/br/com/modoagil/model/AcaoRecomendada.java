package br.com.modoagil.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.modoagil.model.support.AbstractEntity;
import br.com.modoagil.model.support.ModelConstants;
import br.com.modoagil.model.support.annotation.Hiddenable;
import br.com.modoagil.model.support.annotation.Updatable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Entidade para persistência e representação JSON sobre as ações recomendadas pelo OSV sobre a situação de Risco
 * 
 * @since 07/12/2014
 * @author Bruno César Ribeiro e Silva - <a href="mailto:bruno@brunocesar.com">bruno@brunocesar.com</a>
 */
@Entity
@Hiddenable
@JsonRootName(value = "acao")
@JsonInclude(Include.NON_EMPTY)
@Table(name = "acoes_recomendadas")
@Updatable(newinsert = true, updatable = false)
public class AcaoRecomendada extends AbstractEntity<AcaoRecomendada> {

    private static final long serialVersionUID = 485557117602416591L;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "relprev_id")
    private RelatorioPrevencao relPrev;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_60, nullable = false)
    @NotNull(message = "validation.AcaoRecomendada.remetente.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.AcaoRecomendada.remetente.Size.message")
    private String remetente;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_60, nullable = false)
    @NotNull(message = "validation.AcaoRecomendada.destinatario.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_60,
        message = "validation.AcaoRecomendada.destinatario.Size.message")
    private String destinatario;

    @JsonProperty
    @Column(length = ModelConstants.COLUMN_SIZE_600, nullable = false)
    @NotNull(message = "validation.AcaoRecomendada.descricao.NotNull.message")
    @Size(min = ModelConstants.FIELD_SIZE_1,
        max = ModelConstants.FIELD_SIZE_600,
        message = "validation.AcaoRecomendada.descricao.Size.message")
    private String descricao;

    @JsonProperty
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "validation.AcaoRecomendada.data.NotNull.message")
    private Date data;

    public RelatorioPrevencao getRelPrev() {
        return this.relPrev;
    }

    public void setRelPrev(final RelatorioPrevencao relPrev) {
        this.relPrev = relPrev;
    }

    public String getRemetente() {
        return this.remetente;
    }

    public void setRemetente(final String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(final String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(final Date data) {
        this.data = data;
    }

}