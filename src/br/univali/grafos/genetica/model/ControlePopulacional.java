package br.univali.grafos.genetica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;


/**          
 * Classe respons�vel por disparar a l�gica de neg�cio do sistema. 
 * Inicia a popula��o e controla o processo evolutivo da popula��o. 
 *                  
 *@author  David Victor & Jean Ferreira
 *
 *@since 28 de Maio de 2006
 */
public class ControlePopulacional {
	
	
	/**
	 * M�todo respons�vel por estruturar a popula��o inicial
	 * 
	 * @param nodes contendo os n�s 
	 * 	 
	 * @param size contendo o tamanho da popula��o
	 * 
	 * @return Popula��o representando a popula��o
	 * 
	 * @since 28 de Maio de 2006
	 */
	public Populacao iniciaPopulacao(ArrayList nodes, String size){
		
		int tamanho = Integer.parseInt(size);
		
		ArrayList cromossomos = new ArrayList(); 
		TreeMap ordenados = new TreeMap();
		
		Cromossomo cromossomo = null;
		
		for(int i=0; i<tamanho ; i++){
			
			cromossomo = Factory.geraCromossomo(nodes);
			
			while(ordenados.containsKey(cromossomo.getCusto()))
				cromossomo = Factory.geraCromossomo(nodes);
			
			ordenados.put(cromossomo.getCusto(),cromossomo);
		}
		
		Collection colecao = ordenados.values();
		Iterator it = colecao.iterator();
		
		while(it.hasNext()){
			cromossomos.add(it.next());
		}

		Populacao populacao = new Populacao(cromossomos);
	
		return populacao;
	}

	/** 
	 * M�todo respons�vel por disparar todo processo evolutivo de uma determinada
	 * popula��o. O n�mero de vezes que esse processo ocorrer� depender� de um
	 * coeficiente 'evolutivo', onde ser� verificada a similaridade da nova 
	 * popula��o com a popula��o imediatamente anterior (obs: o n�mero desej�vel 
	 * no qual o coeficiente deve atingir � de 95% de similaridade).
	 *
	 * @return ArrayList contendo todas as gera��es
	 * 
	 * @since 28 de Maio de 2006  	
	 **/
	public Populacao processaEvolucao(ArrayList nodes, Populacao populacao){
		
		Evolutiva evolutiva  = new Evolutiva(nodes, populacao);
		
		evolutiva.selecao(populacao);
		evolutiva.cruzamento();
		evolutiva.mutacao();
		
		Populacao novaPopulacao = new Populacao(evolutiva.getNovaGeracao());
		
		return novaPopulacao;
	}
	
	/**
	 * M�todo respons�vel por editar os resultados obtidos no processamento
	 * 
	 * @since 28 de Maio de 2006
	 */
	public String relatorio(ArrayList evolucao){
		
		Populacao populacao = null;
		Cromossomo cromossomo = null;
		
		ArrayList cromossomos = null;
		ArrayList rotas = null;
		
		String idCromossomo  = "";
		String nodes = "";
		String custo = "";
		String log = "";
		String relatorio = "";
		
		String eliteCromossomo = "";
		String eliteCusto = "";
		
		double cont = 10e100;
		
		Iterator iterator = evolucao.iterator();
		Iterator i = null;
		
		while(iterator.hasNext()){
			
			populacao = (Populacao)iterator.next();
			
			cromossomos = populacao.getCromossomos();
			i = cromossomos.iterator();
			
			while(i.hasNext()){
				
				cromossomo = (Cromossomo)i.next();
				rotas = cromossomo.getRotas();
				
				idCromossomo = cromossomo.toString();
				
				nodes = "";
				
				for(int j=0; j<rotas.size(); j++ ){
					nodes = nodes + "( " + ((Integer)rotas.get(j)).intValue() + " ) "; 
				}
				
				custo = String.valueOf(cromossomo.getCusto().intValue());

				if(cromossomo.getCusto().doubleValue() < cont) {
					
					cont = cromossomo.getCusto().doubleValue();
					
					eliteCromossomo = cromossomo.toString();
					eliteCusto = String.valueOf(cromossomo.getCusto().intValue());
				}
				
				log = log + "Cromossomo\t: " + idCromossomo + "\nRotas\t: " + nodes + "\nCusto\t: " + custo + "\n\n"; 
			}
			String elite = "====\nCromossomo mais apto \n\nCromossomo\t: " + eliteCromossomo + "\nCusto\t: " + eliteCusto + "\n";
			
			relatorio = log + elite; 
		}
		return relatorio;
	}
	
}
