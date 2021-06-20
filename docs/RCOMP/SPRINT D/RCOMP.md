RCOMP 2020-2021 Project - Sprint 4 review
=========================================

### Sprint master: 1191421 ###

# 1. Sprint's backlog #

* US 3101 - Como Gestor de Projeto, eu pretendo que as comunicações realizadas através do protocolo SDP2021 estejam
  protegidas.

* US 4003 - Como Gestor de Projeto, eu pretendo que a equipa conclua o desenvolvimento do motor de fluxos de atividades
  tornando-o bastante robusto.

* US 4051 - Como Gestor de Projeto, eu pretendo que as comunicações realizadas como aplicação servidora através do
  protocolo SDP2021 estejam protegidas.

* US 4052 - Como Gestor de Projeto, eu pretendo que as comunicações realizadas como aplicação cliente através do
  protocolo SDP2021 estejam protegidas.

* US 5002 - Como Gestor de Projeto, eu pretendo que as comunicações realizadas através do protocolo SDP2021 estejam
  protegidas.

* US 5003 - Como Gestor de Projeto, eu pretendo que a equipa conclua o desenvolvimento do Executor de Tarefas
  Automáticas tornando-o bastante robusto.

* US 2102 - Como Gestor de Projeto, eu pretendo que as comunicações realizadas através do protocolo SDP2021 estejam
  protegidas.

# Implementação #

* Lista de ips utilizados

    * Instancia 1 do Executor de Tarefas Automáticas
  > 10.8.0.81   
  Porta 6665

    * Instancia 2 do Executor de Tarefas Automáticas
  > 10.8.0.83   
  Porta 6665

    * Servidor Motor de fluxos
  > 10.8.0.83   
  Porta 9992

#### Idealmente teriamos utilizado 3 servidores diferentes, mas devido à falta de cota de compilação da framework de EAPLI, não foi possível instalar o projeto em mais servidores

### Divisão de bytes

Conforme o protocolo e requisitado pelo cliente, implementamos métodos de divisão de bytes.

```
public static List<String> divideProtocol(byte[] allPacket, int protocolo) {
        String string = new String(allPacket, StandardCharsets.UTF_8);
        List<String> stringApart = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i % protocolo == 0 && s.length() != 0) {
                stringApart.add(String.valueOf(s));
                s = new StringBuilder();
            }
        s.append(string.charAt(i));
        }
        stringApart.add(String.valueOf(s));
        return stringApart;
}
```


### SSL

Para criar os devidos certificados SSL, procedemos à criação de um ficheiro .sh para efetuar a criação dos mesmos.
Assim, as ligações inter aplicações ficam seguras.

O script de criação de certificados SSL pode ser encontrado no modulo Workflow, na package MakeSSLScripts.
> base.workflow/src/main/java/SSLWorkflow/MakeSSLScripts/make_certs.sh

Em todos os casos em que ligações são efetuadas, é então um requisito em ambos os lados, que estes partilhem os seus certificados de modo a que as ligações sejam encriptadas

### Protocolo SDP2021

 * Código 4 - Pede tarefas pendentes
 * Código 5 - Pede fluxos ativos
 * Código 6 - Atribuição automática mediante algoritmo
 * Código 7 - Pede tarefas automáticas
 * Default - Protocolo não definido

## Comments ##

* Em geral, a componente de RCOMP ficou bastante bem conseguida, a gestão de threads e sockets foi bem mantida para que a performance do programa seja boa e constante.

* Um ponto a melhorar seria a robustez da capacidade de ligação à base de dados em conjunto com as diversas aplicações em funcionamento.
