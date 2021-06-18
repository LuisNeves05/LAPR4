grammar TarefaAutomatica;

prog: executa
;

executa: pesquisa_xml;

pesquisa_xml:  nome_ficheiro = atributo id_a_pesquisar = atributo desconto enviar_email
            | enviar_email
;

enviar_email :
            | ENVIAR_EMAIL COLABORADOR_REQUERENTE corpo_email
;

corpo_email:  |corpo_email NAME
              | corpo_email calcula
;

desconto: 'SE' atribquanti = atributo compara limite = numero 'ENTAO' desconto_aplica se_categoria
;

desconto_aplica: NUMERO
;

se_categoria: 'SE' NAME 'ENTAO' desconto_aplica;

compara:  MENOR
        | MENORIGUAL
        | MAIOR
        | MAIORIGUAL
        | IGUAL
;

numero: NUMERO;

calcula:  left=calcula op=('*'|'/') right=calcula # opExprMulDiv
              | left=calcula op=('+'|'-') right=calcula # opExprSumDif
              | atom=NUMERO #atomExpr
              ;

atributo: ATRIBUTO NUMERO;

MENOR: 'MENOR';

IGUAL: 'IGUAL';

MAIOR: 'MAIOR';

MENORIGUAL: 'MENORIGUAL';

MAIORIGUAL: 'MAIORIGUAL';

ATRIBUTO: 'ATRIBUTO';

ENVIAR_EMAIL: 'ENVIAR EMAIL';

COLABORADOR_REQUERENTE: 'COLABORADOR REQUERENTE';

NUMERO: [0-9][0-9]*;

FICHEIRO: (.*?).XML
;

XML: ('xml'|'csv');

NAME
 : [a-zA-Z]+
 ;

 COMMENT
  : '#' ~[ \r\n]* -> skip
  ;

SPACES
 : [ \t] -> skip
 ;