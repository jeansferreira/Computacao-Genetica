Universidade do Vale do Itajaí
Ciência da Computação
Disciplina de Grafos

Computação Genética

Índice:

        1) Contextualização;
	2) Requisitos;
	3) Execução;
	4) Recomendações & restrições;
	6) Contato


1) Contextualização

O sistema denominado 'Computação Genética' permite visualizar a evolução
de entidades (indivíduos/cromossomos) dentro de um ambiente que envolva
a utilização de grafos. Basicamente, o sistema consiste em iniciar uma 
determinada população e processar sua respectiva evolução até que seja
atingida uma condição (maiores detalhes com relação ao sistema podem
ser obtidas através da documentação dentro da pasta 'javadoc').



2) Requisitos

Para executar o sistema 'Computação Genética' é necessário possuir 
o ambiente de execução Java, conhecido como JRE. É altamente recomendável
que a versão a ser utilizada seja a '5.0' . A JRE pode ser obtida através do 
site 'http://java.sun.com'. 

Para verificar a existência ou não da JRE na máquina acesse o prompt de comando
do DOS (considerando aqui a plataforma Windows) e digite 'java -version'. 
Caso a JRE esteja instalada será mostrada a versão instalada; caso contrário,
o sistema informará que o comando digitado não é reconhecido. Assim, deve-se
seguir as orientações contidas no site especificado anteriormente. 



3) Execução

O sistema 'Computação Genética' contém a seguinte estrutura de diretórios:

	src    : contém o código fonte do sistema
	
	javadoc: contém a documentação do sistema 

	dist   : contém o arquivo executável em si. 

  ATENÇÃO: OS ARQUIVOS E SUBDIRETÓRIOS CONTIDOS DENTRO DO DIRETÓRIO 'dist' NÃO
	   DEVEM SER ALTERADOS!

Para executar o programa, basta acessar o diretório 'dist' e clicar com o mouse
sobre o arquivo 'Genetica.jar'.



5) Recomendações & restrições

O sistema 'Computação Genética' efetua muitos cálculos internamente além de utilizar
recursos gráficos e processamento em paralelo. Assim, o consumo de processamento é
relevante. Portanto, duas observações devem ser consideradas:

        1) a configuração da máquina na qual executará o sistema (capacidade de
	   processamento, memória RAM instalada, etc);

        2) os dados de entrada impactam diretamente no comportamento do sistema. Assim,
           quanto maior for a cardinalidade dos dados maior será o processamento exigido
	   da máquina;

	ATENÇÃO: DEPENDENDO DOS DADOS DE ENTRADA, O SISTEMA PODE COMPORTAR-SE COMO SE 
		 ESTIVESSE 'TRAVADO'. O SISTEMA FOI TESTADO EXAUSTIVAMENTE E EM NENHUM
		 MOMENTO HOUVE PARADA NO PROCESSAMENTO. CASO OCORRA O CITADO COMPORTAMENTO
	  	 É RECOMENDÁVEL DIMINUIR A CARDINALIDADE DOS DADOS DE ENTRADA (EX: SE O 
   		 SISTEMA NÃO APRESENTOU NENHUMA SAÍDA APÓS A REQUISIÇÃO DO USUÁRIO COM 
		 NÚMERO DE ITERAÇÕES IGUAL A 160, DEVE-SE DIMUNUIR GRADUALMENTE O VALOR
		 ATÉ QUE SE CONSIGA A SAÍDA DESEJADA. ISSO TAMBÉM É VÁLIDO PARA OS VALORES   
		 DE POPULAÇÃO E NÓS).


É importante ressaltar também que, de acordo com os fundamentos matemáticos em que se baseia 
o sistema, para uma melhor visualização e a consecutiva avaliação do sistema é recomendável 
que o número de nós seja sempre menor (ou no máximo igual) ao número total da população.  

 	

4) Contato

Para qualquer dúvida e/ou informação, segue abaixo os endereços de e-mail para contato dos
responsáveis do sistema:
 

David Graminho Victor (david.victor@univali.br)
Jean Carlos da Silva Ferreira (jeansferreira@gmail.com)




12/06/2006



