package br.com.udemy.cursoudemy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="person")
public class Person implements Serializable {

    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Column(name = "ultimo_nome")
    private String UltimoNome;
    @Column
    private String endereco;
    @Column
    private String genero;

    public Person() {
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
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(getPrimeiroNome(), person.getPrimeiroNome()) && Objects.equals(getUltimoNome(), person.getUltimoNome()) && Objects.equals(getEndereco(), person.getEndereco()) && Objects.equals(getGenero(), person.getGenero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getPrimeiroNome(), getUltimoNome(), getEndereco(), getGenero());
    }
}
