Especificar Serviço
=======================================


# 1. Requisitos

**Especificar Serviço** Como Gestor de Serviços de Help Desk (GSH), eu pretendo proceder à especificação de um novo serviço.

- Especificar Serviço 1.1. Como Gestor de Serviços de Help Desk (GSH), pretendo ter a possibilidade de retomar a um serviço que esteja incompleto. 

A interpretação feita deste requisito foi no sentido de viabilizar a especificação de serviços com vista a resolver o problema especificado pelo Gestor de Serviços do Help Desk (GSH).

# 2. Análise

- A especificação do serviço requer não só a informação base nele contida, tal como outros dados/informação a recolher relativamente ao formulário. Cada formulário será associado a um serviço.
- A atividade de aprovação do serviço especificado, podendo ser requerida ou não. 
- A atividade de realização também é referente ao serviço, podendo esta ser manual ou automática. 
- Uma atividade manual terá um formulário associado, enquanto que uma tarefa automática tem associado um script.
- Tendo em conta a extensão e complexidade na especificação de um serviço, esta pode ser feita em diferentes momentos espaçados no tempo, de modo a permitir que este fique incompleto para ser, posteriormente, continuada/completada.

# 3. Design

## 3.1. Realização da Funcionalidade

## Diagrama de Sequência ##

Temos, como diagrama de sequência para a especificação do serviço, onde o ator, como Gestor de Serviços de Help Desk (GSH), dá início a uma especificação de serviço, o sistema solicita os dados necessários sobre o serviço(título, descBreve, descCompleta, icone, conjKWs, feedback), tal como a sua atividade de aprovação e atividade de realização, o sistema apresenta todos os catálogos e o GSH introduz os dados solicitados escolhe um Catálogo. Por fim, de forma opcional, dados sobre o formulário (nome) com a respetiva lista de atributos a solicitar(nomeVar, label, descAjuda, tipoDBas, expRegular). O GSH introduz os dados solicitados, o sistema valida os dados e informa do sucesso da operação.


### Especificar Serviço ###
![SD_EspecificarServico.png](SD_EspecificarServico.png)

### Especificar Formulário ###
![SD_EspecificarFormulario.png](SD_EspecificarFormulario.png)

Na especificação de um novo serviço, o sistema pede os dados necessários e apresenta todos os Catálogos onde o Serviço se pode inserir. Após o GSH introduzir todos os dados e selecionar o Catálogo, o sistema pede os dados do Formulário, onde o GSH pode:

- Especificar um formulário (nome) e um conjunto de atributos associados(nomeVar, label, descAjuda, tipoDBas, expRegular), promovendo o Serviço a um estado "completo".
- Pode não querer criar um formulário, resultando na especificação de um Serviço no estado "incompleto".

## 3.2. Diagrama de Classes

![CD_Generico.png](CD_Generico.png)
//TODO
*Nesta secção deve apresentar e descrever as principais classes envolvidas na realização da funcionalidade.*

## 3.3. Padrões Aplicados

*Nesta secção deve apresentar e explicar quais e como foram os padrões de design aplicados e as melhores práticas.*

## 3.4. Testes 
*Nesta secção deve sistematizar como os testes foram concebidos para permitir uma correta aferição da satisfação dos requisitos.*

**Teste 1:** Verificar que não é possível criar uma instância da classe Exemplo com valores nulos.

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

# 4. Implementação

*Nesta secção a equipa deve providenciar, se necessário, algumas evidências de que a implementação está em conformidade com o design efetuado. Para além disso, deve mencionar/descrever a existência de outros ficheiros (e.g. de configuração) relevantes e destacar commits relevantes;*

*Recomenda-se que organize este conteúdo por subsecções.*

# 5. Integração/Demonstração

*Nesta secção a equipa deve descrever os esforços realizados no sentido de integrar a funcionalidade desenvolvida com as restantes funcionalidades do sistema.*

# 6. Observações

*Nesta secção sugere-se que a equipa apresente uma perspetiva critica sobre o trabalho desenvolvido apontando, por exemplo, outras alternativas e ou trabalhos futuros relacionados.*



