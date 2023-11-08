package br.com.udemy.cursoudemy.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {

    private static final long serialVersion = 1L;


    private Long id;
    private String primeiroNome;
    private String UltimoNome;
    private String endereco;
    private String genero;

    public PersonVO() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonVO person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(getPrimeiroNome(), person.getPrimeiroNome()) && Objects.equals(getUltimoNome(), person.getUltimoNome()) && Objects.equals(getEndereco(), person.getEndereco()) && Objects.equals(getGenero(), person.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getPrimeiroNome(), getUltimoNome(), getEndereco(), getGenero());
    }
}
