grammar GramaticaValidaForm;

prog: validaExp* ;

validaExp: validaExp DEFINE exprExp EXPREGULAR     #defineExpRegular
      | SE exprExp VAZIO ENTAO exprExp NAOVAZIO       #validaEntreCampos
      | SE exprExp NAOVAZIO ENTAO exprExp VAZIO       #validaEntreCampos
      | SE exprExp MAIOR exprExp ENTAO exprExp VAZIO      #validaEntreCampos
      | SE exprExp MAIOR exprExp ENTAO exprExp NAOVAZIO   #validaEntreCampos
      | SE exprExp MENOR exprExp ENTAO exprExp NAOVAZIO   #validaEntreCampos
      | SE exprExp IGUAL exprExp ENTAO exprExp NAOVAZIO   #validaEntreCampos
      | DEFINE exprExp NAOVAZIO                    #defineCampoNaoVazio
      | DEFINE exprExp VAZIO                       #defineCampoPodeSerVazio
;

exprExp:    INT             #int
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
OU : ('||' | 'OU');
MENOR : '<';
NOMEATRIBUTO : [A-Za-z]+;
ESPACO : [ ] -> skip;
EXPREGULAR : '@' .+? '@';