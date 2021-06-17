grammar TarefaAutomatica;

prog: executa
;

executa: pesquisa_xml | enviar_email;

enviar_email :
            | ENVIAR_EMAIL COLABORADOR_REQUERENTE corpo_email
 ;

corpo_email:  |corpo_email NAME
              | corpo_email calcula
;

pesquisa_xml:  nome_ficheiro id_a_pesquisar = atributo desconto+ enviar_email
;

desconto: 'SE' atributo compara limite = numero 'ENTAO' desconto_aplica
        | 'SENAO' desconto

;

desconto_aplica: NUMERO
;

compara:  MENOR
        | MENORIGUAL
        | MAIOR
        | MAIORIGUAL
        | IGUAL
;

numero: NUMERO;

nome_ficheiro: FICHEIRO;

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