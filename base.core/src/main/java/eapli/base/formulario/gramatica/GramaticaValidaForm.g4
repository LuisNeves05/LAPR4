grammar GramaticaValidaForm;

prog: stat* ;

stat: stat DEFINE expr EXPREGULAR                    #defineExpRegular
      | SE expr VAZIO ENTAO expr NAOVAZIO       #validaEntreCampos
      | SE expr NAOVAZIO ENTAO expr VAZIO       #validaEntreCampos
      | SE expr MAIOR INT ENTAO expr VAZIO      #validaEntreCampos
      | DEFINE expr NAOVAZIO                    #defineCampoNaoVazio
      | DEFINE expr VAZIO                       #defineCampoPodeSerVazio
;

expr:    INT             # int
        | NOMEATRIBUTO   #nomeAtributo
        | MAIOR          #maior
        | MENOR          #menor
        | IGUAL          #igual
;

DEFINE: 'DEFINE';
NEWLINE : [\r\n]+ ;
SE : 'SE';
ENTAO : 'ENTAO';
INT:[0-9]+;
NAOVAZIO: 'NAOVAZIO';
VAZIO : 'VAZIO';
IGUAL : '=';
MAIOR : '>';
MENOR : '<';
NOMEATRIBUTO : [A-Za-z]+;
ESPACO : [ ] -> skip;
EXPREGULAR : '@' .+? '@';