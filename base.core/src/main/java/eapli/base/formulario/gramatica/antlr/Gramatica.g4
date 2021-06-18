grammar Gramatica;

prog : valida
 ;


valida:
        atributo NAOVAZIO                                           #defineNaoVazio
        | left = atributo compara right = atributo decisao          #comparaAtributos
        | atributo nomes                                            #limitaNomeAtributo
        | atributo EXPREGULAR                                       #atributoExpRegular
;

compara: NAOVAZIO
        | VAZIO
        | NAME
        | MENOR
        | MENORIGUAL
        | MAIOR
        | MAIORIGUAL
        | IGUAL
;

decisao:
        | NAOVAZIO
        | VAZIO
        ;

atributo: ATRIBUTO NUMERO;

nomes: nomes NAME | NAME ;



COMMENT
 : '#' ~[\r\n]* -> skip
 ;

ATRIBUTO: 'ATRIBUTO';

DEFINE: 'DEFINE';

SE : 'SE';

MENOR: 'MENOR';

IGUAL: 'IGUAL';

MAIOR: 'MAIOR';

MENORIGUAL: 'MENORIGUAL';

MAIORIGUAL: 'MAIORIGUAL';

ENTAO : 'ENTAO';

NAOVAZIO: 'NAOVAZIO';

VAZIO : 'VAZIO';



NUMERO: [0-9][0-9]*;

NAME
 : [a-zA-Z]+
 ;

NEWLINE: [\r\n];

SPACES
 : [ \t] -> skip
 ;

SEPARATOR : [/\\\-] ;

EXPREGULAR: '@'.+?'@';
