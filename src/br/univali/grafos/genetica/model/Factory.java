package br.univali.grafos.genetica.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;


/** 
 * Classe utilit�ria respons�vel por 'fabricar' os n�s (coordenadas) e os
 * respectivos cromossomos (rotas)
 * 
 * @author David Victor & Jean Ferreira
 * 
 * @since 27 de Maio de 2006
 * */
public class Factory {
	
	/** 
	 * M�todo respons�vel por gerar aleatoriamente as coordenadas
	 * no gr�fico que representar�o os n�s. O n�mero de coordenadas
	 * a serem geradas � dada pelo argumento 'nos'.
	 *
	 * @param nos correspondendo ao n�mero m�ximo de coordenadas(n�s) 
	 * 		  que formar�o a estrutura de cada cromossomo.
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
	 * M�todo respons�vel por gerar um �nico cromossomo que representar� 
	 * um �nico indiv�duo na popula��o.
	 * 
	 * @param nos contendo as coordenadas(n�s) sobre as quais ser�o
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
