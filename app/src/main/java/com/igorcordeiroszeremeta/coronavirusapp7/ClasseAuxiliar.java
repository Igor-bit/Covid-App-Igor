package com.igorcordeiroszeremeta.coronavirusapp7;

import java.util.Date;

public class ClasseAuxiliar {
    String nome, cidade, resultadoResumido, genero, etnia;
    int cpf;
    Date dataDeNascimento;

    public ClasseAuxiliar(String nome, Date dataDeNascimento, String cidade, String genero, String etnia, int cpf, String resultadoResumido) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cidade = cidade;
        this.genero = genero;
        this.etnia = etnia;
        this.cpf = cpf;
        this.resultadoResumido = resultadoResumido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataDeNascimento(Date dataDeNascimento) { this.dataDeNascimento = dataDeNascimento; }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setGenero(String genero) { this.genero = genero; }

    public void setEtnia(String etnia) { this.etnia = etnia; }

    public void setCpf(int cpf) { this.cpf = cpf; }

    public void setResultadoResumido(String resultadoResumido) { this.resultadoResumido = resultadoResumido; }
}