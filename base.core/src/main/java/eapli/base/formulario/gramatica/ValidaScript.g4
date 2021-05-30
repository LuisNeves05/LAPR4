grammar ValidaScript;

prog: validaExp* | stat ;

stat: expr NEWLINE # printExpr
| ID '=' expr NEWLINE # assign
| NEWLINE # blank

;


validaExp: DEFINE exprExp EXPREGULAR              #defineExpRegular
      | SE exprExp ' ' VAZIO ENTAO exprExp NAOVAZIO             #validaEntreCampos
      | SE exprExp NAOVAZIO ENTAO exprExp VAZIO             #validaEntreCampos
      | SE exprExp MAIOR exprExp ENTAO exprExp VAZIO        #validaEntreCampos
      | SE exprExp MAIOR exprExp ENTAO exprExp NAOVAZIO     #validaEntreCampos
      | SE exprExp MENOR exprExp ENTAO exprExp NAOVAZIO     #validaEntreCampos
      | SE exprExp ATR exprExp ENTAO exprExp NAOVAZIO       #validaEntreCampos
      | DEFINE exprExp NAOVAZIO                             #defineCampoNaoVazio
      | DEFINE exprExp VAZIO                                #defineCampoPodeSerVazio
;

expr: expr op=('*'|'/') expr # MulDiv
| expr op=('+'|'-') expr# AddSub
| INT # inte
| ID # id
| '(' expr ')' # parens
;

exprExp:    INT          #int
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