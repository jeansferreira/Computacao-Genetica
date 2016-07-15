package br.univali.grafos.genetica.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;


/** 
 * Classe baseada no padrão JavaBean e que representa cada 
 * indivíduo (cromossomo) na população. Todo cromossomo deve
 * ser constituído de, no mínimo, 2 nós.
 * 
 * @author David Victor & Jean Ferreira
 * 
 * @since 27 de Maio de 2006
 * */
public class Cromossomo {

	private Double custo;
	private ArrayList rotas;
	
	public Cromossomo(ArrayList nos){
		this.rotas = nos;
	}
	
	public ArrayList getRotas() {
		return rotas;
	}
	
	public void setRotas(ArrayList rota) {
		this.rotas = rota;
	}
	
	public Double getCusto() {
		return custo;
	}
	
	public void setCusto(ArrayList nos){
		
		double valor = 0.0;
		double resultado = 0.0;
		
		int x = 0;
		int y = 0;
				
		Point origem = null;
		Point destino = null;
				
		Integer index = null;
		
		Iterator iterator = rotas.iterator();
		index = (Integer)iterator.next();
		
		origem = (Point)nos.get(index.intValue());
		
		while(iterator.hasNext()){
			
			index = (Integer)iterator.next();
			
			destino = (Point)nos.get(index.intValue());
			
			x = origem.x - destino.x;
			y = origem.y - destino.y;
			
			valor = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
			resultado = resultado + valor; 
				
			origem = destino;
		}
		custo = Double.valueOf(resultado);
	}
	
}
	

