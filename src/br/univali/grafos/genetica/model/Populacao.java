package br.univali.grafos.genetica.model;

import java.util.ArrayList;
import java.util.Iterator;


/** 
* Classe baseada no padrão JavaBean e que representa o conjunto 
* de indivíduos(cromossomos) do sistema. O sistema exige que o
* tamanho da populção seja um valor par.
* 
* @author David Victor & Jean Ferreira
* 
* @since 27 de Maio de 2006
* */
public class Populacao {

	private Double custo;
	private ArrayList cromossomos;
	
	
	public Populacao(ArrayList cromossomos){
		this.cromossomos = cromossomos;
		this.calculaCusto();
	}
	
	public ArrayList getCromossomos() {
		return cromossomos;
	}
	
	public void setCromossomos(ArrayList cromossomos){
		this.cromossomos = cromossomos;
	}
	
	public int getTamanho() {
		return cromossomos.size();
	}
	
	public void setTamanho(int tamanho) {
	}

	public Cromossomo getCromossomo(int posicao){
		return (Cromossomo)cromossomos.get(posicao);
	}
	
	public void setCromossomo(Cromossomo cromossomo){
		cromossomos.add(cromossomo);
	}
	
	public Double getCusto(){
		return custo;
	}
	
	private void calculaCusto(){
		
		double custoCromossomo = 0;
		
		Cromossomo cromossomo = null;
		
		Iterator iterator = cromossomos.iterator();
		
		while(iterator.hasNext()){
			
			cromossomo = (Cromossomo)iterator.next();
			custoCromossomo = custoCromossomo + cromossomo.getCusto().doubleValue();
		}
		custo = Double.valueOf(custoCromossomo);
	}
	
}
