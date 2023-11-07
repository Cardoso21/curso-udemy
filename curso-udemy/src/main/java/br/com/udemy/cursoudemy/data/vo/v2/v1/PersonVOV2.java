package br.com.udemy.cursoudemy.data.vo.v2.v1;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonVOV2 implements Serializable {

    private static final long serialVersion = 1L;


    private Long id;
    private String primeiroNome;
    private String UltimoNome;
    private String endereco;
    private String genero;
    private Date dataNascimento;

    public PersonVOV2() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVOV2 that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getPrimeiroNome(), that.getPrimeiroNome()) && Objects.equals(getUltimoNome(), that.getUltimoNome()) && Objects.equals(getEndereco(), that.getEndereco()) && Objects.equals(getGenero(), that.getGenero()) && Objects.equals(getDataNascimento(), that.getDataNascimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrimeiroNome(), getUltimoNome(), getEndereco(), getGenero(), getDataNascimento());
    }
}
