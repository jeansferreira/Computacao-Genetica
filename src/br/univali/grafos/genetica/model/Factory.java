package br.univali.grafos.genetica.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/** 
 * Classe utilitária responsável por 'fabricar' os nós (coordenadas) e os
 * respectivos cromossomos (rotas)
 * 
 * @author David Victor & Jean Ferreira
 * 
 * @since 27 de Maio de 2006
 * */
public class Factory {
	
	/** 
	 * Método responsável por gerar aleatoriamente as coordenadas
	 * no gráfico que representarão os nós. O número de coordenadas
	 * a serem geradas é dada pelo argumento 'nos'.
	 *
	 * @param nos correspondendo ao número máximo de coordenadas(nós) 
	 * 		  que formarão a estrutura de cada cromossomo.
	 * 
	 * @return ArrayList contendo todas as coordenadas geradas aleatoriamente
	 */
	public static ArrayList geraNos(String nos){
		
		int qtd = Integer.parseInt(nos);
		
		ArrayList coordenadas = new ArrayList();
		
		Point nodes = null; 
		
		Random aleatorio = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < qtd; i++){

			nodes = new Point();
			nodes.x = aleatorio.nextInt(870) + 1;
			nodes.y = aleatorio.nextInt(430) + 1;
			
			coordenadas.add(nodes);
		}

		return coordenadas;
	}
	
	/** 
	 * Método responsável por gerar um único cromossomo que representará 
	 * um único indivíduo na população.
	 * 
	 * @param nos contendo as coordenadas(nós) sobre as quais serão
	 * 		  geradas as rotas
	 */
	public static Cromossomo geraCromossomo(ArrayList nos){
		
		Cromossomo cromossomo = null;
		
		ArrayList rotas = new ArrayList();
		Integer pontos = null; 

		Double seed = Double.valueOf(Math.random()) * 1000;
		Random aleatorio = new Random(seed.longValue());
	
		while(rotas.size() < nos.size()){
			
			pontos = Integer.valueOf(aleatorio.nextInt(nos.size()));
			
			while(rotas.contains(pontos)){
				pontos = Integer.valueOf(aleatorio.nextInt(nos.size()));
			}
			rotas.add(pontos);	
		}
		
		cromossomo = new Cromossomo(rotas);
		cromossomo.setCusto(nos);
				
		return cromossomo;
	}
	
}
