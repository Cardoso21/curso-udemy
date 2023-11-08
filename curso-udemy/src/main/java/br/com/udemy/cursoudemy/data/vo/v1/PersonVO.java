package br.com.udemy.cursoudemy.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id","primeiroNome","UltimoNome", "endereco", "genero"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersion = 1L;


    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String primeiroNome;
    private String UltimoNome;
    private String endereco;
    private String genero;

    public PersonVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return UltimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        UltimoNome = ultimoNome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO personVO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getKey(), personVO.getKey()) && Objects.equals(getPrimeiroNome(), personVO.getPrimeiroNome()) && Objects.equals(getUltimoNome(), personVO.getUltimoNome()) && Objects.equals(getEndereco(), personVO.getEndereco()) && Objects.equals(getGenero(), personVO.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getKey(), getPrimeiroNome(), getUltimoNome(), getEndereco(), getGenero());
    }
}
