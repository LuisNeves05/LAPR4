package eapli.base.tarefaManualAprovacao.domain;

public enum EstadoAprovacao {
    POR_APROVAR("Por Aprovar"), APROVADO("Aprovado"), REJEITADO("Rejeitado");

    private String estadoAprov;

    EstadoAprovacao(String s) {
        this.estadoAprov = s;
    }

    @Override
    public String toString() {
        return this.estadoAprov;
}}
