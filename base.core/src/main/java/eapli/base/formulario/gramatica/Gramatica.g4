grammar Gramatica;

parseEspecificao
 : instructionEspecificacao* EOF
 ;

parseValidacao
 : instructionValidacao* EOF
;

instructionEspecificacao
 : enviar_email
 | servico1dataInicioFimEspecificacao
 | servico1Justificacao
 ;

instructionValidacao
 : servico1dataInicioFimValidacao
 ;

servico1dataInicioFimEspecificacao: dataInicio MENORIGUAL dataFim
;

servico1dataInicioFimValidacao: dataInicio dataFim
;

servico1Justificacao: SE tipoAusencia=NAME 'JUSTIFICADA' ENTAO justificacao NAOVAZIO
;

dataInicio: NAME;

dataFim: NAME;

justificacao: NAME
;

enviar_email : ENVIAR_EMAIL COLABORADOR_REQUERENTE corpo_email
 ;

 corpo_email:  |corpo_email NAME
               | corpo_email calcula
;

calcula:  left=calcula op=('*'|'/') right=calcula # opExprMulDiv
              | left=calcula op=('+'|'-') right=calcula # opExprSumDif
              | atom=INT #atomExpr
              ;

date
    : INT SEPARATOR month SEPARATOR INT
    | INT SEPARATOR month SEPARATOR INT4
    | INT SEPARATOR INT SEPARATOR INT4;

month : JAN | FEB | MAR | APR | MAY | JUN | JUL | AUG | SEP | OCT | NOV | DEC ;


COMMENT
 : '#' ~[\r\n]* -> skip
 ;


TIPOAUSENCIA: ('FERIAS'|'JUSTIFICADA'|'NAO JUSTIFICADA');

DEFINE: 'DEFINE';

SE : 'SE';

MENOR: 'MENOR';

MENORIGUAL: 'MENORIGUAL';

ENTAO : 'ENTAO';

NAOVAZIO: 'NAOVAZIO';

VAZIO : 'VAZIO';

ENVIAR_EMAIL: 'ENVIAR EMAIL';

COLABORADOR_REQUERENTE: 'COLABORADOR REQUERENTE';

JAN : [Jj][Aa][Nn] ;
FEB : [Ff][Ee][Bb] ;
MAR : [Mm][Aa][Rr] ;
APR : [Aa][Pp][Rr] ;
MAY : [Mm][Aa][Yy] ;
JUN : [Jj][Uu][Nn] ;
JUL : [Jj][Uu][Ll] ;
AUG : [Aa][Uu][Gg] ;
SEP : [Ss][Ee][Pp] ;
OCT : [Oo][Cc][Tt] ;
NOV : [Nn][Oo][Vv] ;
DEC : [Dd][Ee][Cc] ;

INT4 : DIGIT DIGIT DIGIT DIGIT;

DIGIT : [0-9];

NUMERO: [0-9][0-9]*;

INT
 : [0-9]+
 ;
NAME
 : [a-zA-Z]+
 ;

SPACES
 : [ \t\r\n] -> skip
 ;

SEPARATOR : [/\\\-] ;
