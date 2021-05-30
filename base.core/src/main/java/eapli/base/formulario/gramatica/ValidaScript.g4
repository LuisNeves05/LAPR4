grammar ValidaScript;

prog: stat*  | validaExp*;
stat: operacoesAritmeticas NEWLINE # printExpr
| ID '=' operacoesAritmeticas NEWLINE # assign
| NEWLINE # blank

;
operacoesAritmeticas: operacoesAritmeticas op=('*'|'/') operacoesAritmeticas # MulDiv
| operacoesAritmeticas op=('+'|'-') operacoesAritmeticas# AddSub
| INT # inte
| ID # id
| '(' operacoesAritmeticas ')' # parens
;

validaExp: validaExp DEFINE variavel EXPREGULAR     #defineExpRegular
      | SE variavel VAZIO ENTAO variavel NAOVAZIO       #validaEntreCampos
      | SE variavel NAOVAZIO ENTAO variavel VAZIO       #validaEntreCampos
      | SE variavel MAIOR variavel ENTAO variavel VAZIO      #validaEntreCampos
      | SE variavel MAIOR variavel ENTAO variavel NAOVAZIO   #validaEntreCampos
      | SE variavel MENOR variavel ENTAO variavel NAOVAZIO   #validaEntreCampos
      | SE variavel ATR variavel ENTAO variavel NAOVAZIO   #validaEntreCampos
      | DEFINE variavel NAOVAZIO                    #defineCampoNaoVazio
      | DEFINE variavel VAZIO                       #defineCampoPodeSerVazio
;

variavel:    INT          #int
        | NOMEATRIBUTO   #nomeAtributo
        | MAIOR          #maior
        | MENOR          #menor
        | ATR          #igual
;

NEWLINE : [\r\n]+ ;
INT:[0-9]+;
ID:[a-z]+;
MUL : '*' ; // assigns token name to '*' used above in grammar
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
ATR : '=' ;
LPR : '(' ;
RPR : ')' ;
DEFINE: 'DEFINE';
SE : 'SE';
ENTAO : 'ENTAO';
NAOVAZIO: 'NAOVAZIO';
VAZIO : 'VAZIO';
MAIOR : '>';
MENOR : '<';
NOMEATRIBUTO : [A-Za-z]+;
ESPACO : [ ] -> skip;
EXPREGULAR : '@' .+? '@';


