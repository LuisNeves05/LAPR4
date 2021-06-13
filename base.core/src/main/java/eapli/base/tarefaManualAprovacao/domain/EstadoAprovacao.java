package eapli.base.tarefaManualAprovacao.domain;

public enum EstadoAprovacao {
    POR_APROVAR("Por Aprovrar"), APROVADO("Aprovado"), REJEITADO("Rejeitado");

    private String estadoAprov;

    EstadoAprovacao(String s) {
        this.estadoAprov = s;
    }

    @Override
    public String toString() {
        return this.estadoAprov;
}}
