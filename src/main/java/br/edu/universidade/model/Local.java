package br.edu.universidade.model;

public enum Local {

    BIBLIOTECA("Biblioteca"),
    SECRETARIA("Secretaria"),
    LABORATORIO("Laboratório"),
    LAB_QUIMICA("Laboratório de Química"),
    LAB_INFORMATICA("Laboratório de Informática"),
    CANTINA("Cantina"),
    AUDITORIO("Auditório"),
    SALA_DE_AULA("Sala de aula"),
    BANHEIRO("Banheiro");

    private final String nome;

    Local(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}