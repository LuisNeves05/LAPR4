RCOMP 2020-2021 Project - Sprint C review
=========================================
### Sprint master: 1191421 ###

# 1. Sprint's backlog #

* User Story 4001 -> Como Gestor de Projeto, eu pretendo que seja desenvolvido no Motor de Fluxo de Atividade o mecanismo de gestão/controlo/avanço do fluxo de atividades de um dado pedido.

* User Story 4002 -> Como Gestor de Projeto, eu pretendo que o Motor de Fluxo de Atividades disponibilize, a pedido, os dados necessários às aplicações "Serviços e RH" e "Portal dos Utilizadores".

* User Story 5001 -> Como Gestor de Projeto, eu pretendo que seja desenvolvido o Executor de Tarefas Automáticas.


## Comments ##

* A lógica de implementação foi eximiamente bem compreendida pelo grupo, de forma a que este teve grande parte da sua dificuldade na implementação do mesmo.
 Todos os testes de ligação, threads e parcelamento de bytes foram feitos em projetos à parte, o problema ocorreu na implementação no projeto principal, em que, em parte devido à
  complexidade da framework sobre a qual trabalhamos, não foi executado a 100%. Sendo assim, existe comunicação entre as diversas aplicações, mas a refresh rate e por vezes entra em deadlock.
  Tencionamos ter tudo isto implementado até ao fim da primeira semana do SPRINT D.
