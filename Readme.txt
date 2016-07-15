Universidade do Vale do Itaja�
Ci�ncia da Computa��o
Disciplina de Grafos

Computa��o Gen�tica

�ndice:

        1) Contextualiza��o;
	2) Requisitos;
	3) Execu��o;
	4) Recomenda��es & restri��es;
	6) Contato


1) Contextualiza��o

O sistema denominado 'Computa��o Gen�tica' permite visualizar a evolu��o
de entidades (indiv�duos/cromossomos) dentro de um ambiente que envolva
a utiliza��o de grafos. Basicamente, o sistema consiste em iniciar uma 
determinada popula��o e processar sua respectiva evolu��o at� que seja
atingida uma condi��o (maiores detalhes com rela��o ao sistema podem
ser obtidas atrav�s da documenta��o dentro da pasta 'javadoc').



2) Requisitos

Para executar o sistema 'Computa��o Gen�tica' � necess�rio possuir 
o ambiente de execu��o Java, conhecido como JRE. � altamente recomend�vel
que a vers�o a ser utilizada seja a '5.0' . A JRE pode ser obtida atrav�s do 
site 'http://java.sun.com'. 

Para verificar a exist�ncia ou n�o da JRE na m�quina acesse o prompt de comando
do DOS (considerando aqui a plataforma Windows) e digite 'java -version'. 
Caso a JRE esteja instalada ser� mostrada a vers�o instalada; caso contr�rio,
o sistema informar� que o comando digitado n�o � reconhecido. Assim, deve-se
seguir as orienta��es contidas no site especificado anteriormente. 



3) Execu��o

O sistema 'Computa��o Gen�tica' cont�m a seguinte estrutura de diret�rios:

	src    : cont�m o c�digo fonte do sistema
	
	javadoc: cont�m a documenta��o do sistema 

	dist   : cont�m o arquivo execut�vel em si. 

  ATEN��O: OS ARQUIVOS E SUBDIRET�RIOS CONTIDOS DENTRO DO DIRET�RIO 'dist' N�O
	   DEVEM SER ALTERADOS!

Para executar o programa, basta acessar o diret�rio 'dist' e clicar com o mouse
sobre o arquivo 'Genetica.jar'.



5) Recomenda��es & restri��es

O sistema 'Computa��o Gen�tica' efetua muitos c�lculos internamente al�m de utilizar
recursos gr�ficos e processamento em paralelo. Assim, o consumo de processamento �
relevante. Portanto, duas observa��es devem ser consideradas:

        1) a configura��o da m�quina na qual executar� o sistema (capacidade de
	   processamento, mem�ria RAM instalada, etc);

        2) os dados de entrada impactam diretamente no comportamento do sistema. Assim,
           quanto maior for a cardinalidade dos dados maior ser� o processamento exigido
	   da m�quina;

	ATEN��O: DEPENDENDO DOS DADOS DE ENTRADA, O SISTEMA PODE COMPORTAR-SE COMO SE 
		 ESTIVESSE 'TRAVADO'. O SISTEMA FOI TESTADO EXAUSTIVAMENTE E EM NENHUM
		 MOMENTO HOUVE PARADA NO PROCESSAMENTO. CASO OCORRA O CITADO COMPORTAMENTO
	  	 � RECOMEND�VEL DIMINUIR A CARDINALIDADE DOS DADOS DE ENTRADA (EX: SE O 
   		 SISTEMA N�O APRESENTOU NENHUMA SA�DA AP�S A REQUISI��O DO USU�RIO COM 
		 N�MERO DE ITERA��ES IGUAL A 160, DEVE-SE DIMUNUIR GRADUALMENTE O VALOR
		 AT� QUE SE CONSIGA A SA�DA DESEJADA. ISSO TAMB�M � V�LIDO PARA OS VALORES   
		 DE POPULA��O E N�S).


� importante ressaltar tamb�m que, de acordo com os fundamentos matem�ticos em que se baseia 
o sistema, para uma melhor visualiza��o e a consecutiva avalia��o do sistema � recomend�vel 
que o n�mero de n�s seja sempre menor (ou no m�ximo igual) ao n�mero total da popula��o.  

 	

4) Contato

Para qualquer d�vida e/ou informa��o, segue abaixo os endere�os de e-mail para contato dos
respons�veis do sistema:
 

David Graminho Victor (david.victor@univali.br)
Jean Carlos da Silva Ferreira (jeansferreira@gmail.com)




12/06/2006



