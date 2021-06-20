RCOMP 2020-2021 Project - Sprint C planning
===========================================
### Sprint master: 1191421 ###

# 1. Sprint's backlog #

* User Story 4001 -> Como Gestor de Projeto, eu pretendo que seja desenvolvido no Motor de Fluxo de Atividade o mecanismo de gestão/controlo/avanço do fluxo de atividades de um dado pedido.


* User Story 4002 -> Como Gestor de Projeto, eu pretendo que o Motor de Fluxo de Atividades disponibilize, a pedido, os dados necessários às aplicações "Serviços e RH" e "Portal dos Utilizadores".


* User Story 5001 -> Como Gestor de Projeto, eu pretendo que seja desenvolvido o Executor de Tarefas Automáticas.

# 2. Technical decisions and coordination #

###Protocolo ###

* Foi desenvolvido um protocolo de comunicação para que todas as comunicações servidor-cliente sigam o mesmo padrão. 

* Seguindo o protocolo SDP2021, foram criados 4 sinais extra.
  
  |Designação  | Posição  | Explicação  | Tamanho  | 
  |------------|----------|-------------|----------|
  | Pede Tarefas Pendentes  |   4  |  Envia codigo, servidor pede identificador do colaborador |    250 bytes      |   
  | Envia Tarefas Pendentes  | 5  | Servidor envia tarefas pendentes do colaborador  |  400 bytes |   
  | Pede Fluxo Atividades  | 6  | Envia codigo  |  12 bytes |   
  | Envia Fluxo Atividades |  7 |  Recebe codigo e envia todos os fluxos de atividade ativos |  400 bytes |   
    
* Foi também tido em conta tudo o que era pedido no SDP2021 no sentido da limitação do numero de bytes que poderiam ser transferidos em cada transação.
* Para tal foi desenvolvido um algoritmo que parcela as Strings geradas e as envia conforme o pedido.

# 3. Subtasks assignment #

* Todos os membros devem contribuir de forma igual e continua para o desenvolvimento da componente de RCOMP do projeto.


