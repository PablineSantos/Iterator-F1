package com.senai.pabline.f1.entity;

import java.util.Objects;

public class Piloto implements Comparable<Piloto>{
    private Integer id;
    private String nome;
    private String nacionalidade;
    private Integer idade;
    private String equipe;
    private String motor;
    private Integer pontos;

    public Piloto(String string) {
        String[] vetor = string.split(",");
        this.id = Integer.parseInt(vetor[0].trim());
        this.nome = vetor[1].trim();
        this.nacionalidade = vetor[2].trim();
        this.idade = Integer.parseInt(vetor[3].trim());
        this.equipe = vetor[4].trim();
        this.motor = vetor[5].trim();
        this.pontos = Integer.parseInt(vetor[6].trim());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getEquipe() {
        return equipe;
    }

    public String getMotor() {
        return motor;
    }

    public Integer getPontos() {
        return pontos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Piloto piloto = (Piloto) o;
        return Objects.equals(nome, piloto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nome='" + nome + '\'' +
                '}';
    }
    @Override
    public int compareTo(Piloto outroPiloto) {
        return this.getNome().compareToIgnoreCase(outroPiloto.getNome());
    }
}
