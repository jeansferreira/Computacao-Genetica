package br.univali.grafos.genetica.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeMap;

public class Evolutiva {
	
	private static final double PROBABILIDADE_CRUZAMENTO = 0.6;
	private static final double PROBABILIDADE_MUTACAO = 0.2;
 
	private ArrayList selecionados;
	private ArrayList excluidos;
	private ArrayList novaGeracao;
	private ArrayList nos;
	private TreeMap ordenados;
	
	private Populacao populacao;
	
	public Evolutiva(ArrayList nodes, Populacao cromossomos){
		
		populacao = cromossomos;
		nos = nodes;
	}
	
	/** 
	 * Método responsável por efetuar de forma 'elitista' a seleção
	 * dos cromossomos que compõe a população
	 * 
	 * @param populacao contendo todos os cromossomos do sistema
	 * 
	 * @since 27 de Maio de 2006
	 */ 
	public void selecao(Populacao populacao){
		
		int numeroSelecionados = populacao.getTamanho() / 2;
		int tamanho = populacao.getTamanho();

		selecionados = new ArrayList();
		excluidos = new ArrayList();
			
		for(int i=0; i<numeroSelecionados; i++){
			selecionados.add(populacao.getCromossomo(i));
		}
			
		for(int j=numeroSelecionados; j<tamanho; j++){
			excluidos.add(populacao.getCromossomo(j));
		}
	}
	
	/** 
	 * Método reponsável por efetuar o cruzamento entre dois 
	 * cromossomos utilizando o seguinte critério:
	 * 
	 * 		(1) recupera-se de forma 'sequencial' um cromossomo 
	 * 			que faça parte do grupo	de cromossomos considerados
	 * 			mais aptos (aqui denominado 'forte');
	 * 
	 *      (2) recupera-se de forma 'aleatoria' um cromossomo
	 *      	que faça parte do grupo de cromossomos considerados
	 *      	mesnos aptos (aqui denominado 'fraco');
	 *      
	 *      (3) efetua-se a o cruzamento de acordo com o seguinte 
	 *      	algoritmo: 
	 *      
	 *       	3.a) recupera-se de forma 'aleatoria' uma determinada
	 *       		 coordenada (x1,y1) do cromossomo 'forte';
	 *       
	 *          3.b) de posse desta coordenada, procura-se no cromossomo
	 *              'fraco' a coordenada correspondente (x2,y2) e recupera-se
	 *               o índice (posição) dessa coordenada;
	 *               
	 *          3.c) insere em cromossomo 'forte' a coordenada (x1,y1) baseando-se
	 *          	 no índice (posição) recuperada da coordenada (x2,y2);
	 *          
	 *          3.d) o processo ocorre inversamente ao cromossomo 'fraco';
	 *           
	 *          3.e) o processo termina quando 50% do cromossomo 'forte' tenha 
	 *          	 sido percorrido;		
	 *          	 	 
	 *      
	 * A probabilidade de ocorrer ou não o cruzamento entre os 
	 * cromossomos selecionados é determinado pela constante 
	 * 'PROBABILIDADE_MUTACAO'
	 * 
	 * @since 29 de Maio de 2006
	 */
	public void cruzamento(){
		
		Cromossomo forte = null;
		Cromossomo fraco = null;
		
		ArrayList rotaForte = null;
		ArrayList rotaFraco = null;
		ArrayList temp = null;
		
		ordenados = new TreeMap();
		novaGeracao = new ArrayList();
		
		Integer elementoForte = null;
		Integer elementoFraco = null;
		
		int index = 0;
		int indice = 0;
		
		Double seed = Double.valueOf(Math.random()) * 1000;
		Random aleatorio = new Random(seed.longValue());

		Iterator iterator = selecionados.iterator();
		
		while(iterator.hasNext()){
			
			forte = (Cromossomo)iterator.next();
			
			indice = aleatorio.nextInt(excluidos.size());
			fraco  = (Cromossomo)excluidos.remove(indice);
			
			try{
				if(Math.random() <= Evolutiva.PROBABILIDADE_CRUZAMENTO){
					
					rotaForte = forte.getRotas();
					temp = new ArrayList();
					
					while(!rotaForte.isEmpty()){
						
						index = aleatorio.nextInt(rotaForte.size());
						elementoForte = (Integer)rotaForte.remove(index);
						
						temp.add(elementoForte);
					}
					
					forte.setRotas(temp);
					forte.setCusto(nos);
					
					rotaFraco = fraco.getRotas();	
					temp = new ArrayList();
					
					while(!rotaFraco.isEmpty()){
						
						index = aleatorio.nextInt(rotaFraco.size());
						elementoFraco = (Integer)rotaFraco.remove(index);
						
						temp.add(elementoFraco);
					}
					
					fraco.setRotas(temp);
					fraco.setCusto(nos);
				}	
			}
			catch (Exception e){
				System.out.println("ERRO: Evolutiva.cruzamento: " + e.getMessage());
			}
			finally{
				
				ordenados.put(forte.getCusto(), forte);
				ordenados.put(fraco.getCusto(), fraco);
			}
		}
		selecionados = null;
		excluidos    = null;
	
		Collection colecao = ordenados.values();
		iterator = colecao.iterator();
		
		while(iterator.hasNext()){
			novaGeracao.add((Cromossomo)iterator.next());
		}
		
	}

	
	/** 
	 * Método responsável por efetuar mutação de um subgrupo de 
	 * cromossomos que compõe a população. A probabilidade de 
	 * ocorrer ou não a mutação no cromossomo selecionado é
	 * determinado pela constante 'PROBABILIDADE_MUTACAO' 
	 * 
	 * @since 30 de Maio de 2006
	 */
	public void mutacao(){
		
		int numeroMutantes = Math.abs(novaGeracao.size() / 2);
		int index = 0;
		
		Integer elemento = null;
		
		Cromossomo cromossomo = null;
		ArrayList rota = null;
		
		TreeMap ordena = new TreeMap();
		ArrayList mutantes = new ArrayList(numeroMutantes);
		
		Double seed = Double.valueOf(Math.random()) * 1000;
		Random aleatorio = new Random(seed.longValue());
		
		for (int i=numeroMutantes ; i < novaGeracao.size(); i++){
			mutantes.add(novaGeracao.remove(i));
		}
		
		Iterator iterator = mutantes.iterator();
		
		while(iterator.hasNext()){
			
			cromossomo = (Cromossomo)iterator.next();
			
			if(Math.random() <= Evolutiva.PROBABILIDADE_MUTACAO){

				rota = cromossomo.getRotas();
				
				while(index <= 0)
					index = aleatorio.nextInt(rota.size());
				
				elemento = (Integer)rota.remove(index);
				
				index = aleatorio.nextInt(rota.size());

				rota.add(index,elemento);
		
				cromossomo.setRotas(rota);
				cromossomo.setCusto(nos);
				
			}
			ordena.put(cromossomo.getCusto(),cromossomo);
		}
		
		int cont = 0; 
		
		while(!novaGeracao.isEmpty()){
			
			cromossomo = (Cromossomo)novaGeracao.remove(cont);
			ordena.put(cromossomo.getCusto(),cromossomo);
		}
	
		Collection colecao = ordena.values();
		iterator = colecao.iterator();
			
		while(iterator.hasNext()){
			novaGeracao.add(iterator.next());
		}
	}

	/** 
	 * Método de acesso à nova geração da população
	 * 
	 * @since 30 de Maio de 2006 
	 */
	public ArrayList getNovaGeracao(){
		return novaGeracao;
	}
	
}
