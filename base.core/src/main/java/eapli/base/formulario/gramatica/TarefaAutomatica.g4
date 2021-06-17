grammar TarefaAutomatica;



enviar_email : ENVIAR_EMAIL COLABORADOR_REQUERENTE corpo_email
 ;

corpo_email:  |corpo_email NAME
               | corpo_email calcula
;

calcula:  left=calcula op=('*'|'/') right=calcula # opExprMulDiv
              | left=calcula op=('+'|'-') right=calcula # opExprSumDif
              | atom=NUMERO #atomExpr
              ;


ENVIAR_EMAIL: 'ENVIAR EMAIL';

COLABORADOR_REQUERENTE: 'COLABORADOR REQUERENTE';

NUMERO: [0-9][0-9]*;

NAME
 : [a-zA-Z]+
 ;
