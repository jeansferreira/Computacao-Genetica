package br.univali.grafos.genetica.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import br.univali.grafos.genetica.model.Cromossomo;
import br.univali.grafos.genetica.model.Populacao;

/**
 * Classe que implementa o container que conterá os resultados 
 * gráficos (rotas) do sistema.
 * 
 * @author David Victor & Jean Ferreira
 * 
 * @since 28 de Maio de 2006
 **/
public class JPanelRotas extends JPanel implements Runnable{

	
	private Graphics2D grafico;
	private Line2D rota;
	private Ellipse2D node;
	
	private ArrayList nos;
	private ArrayList evolucao;
	
	private Populacao populacao;
	private Cromossomo cromossomo;
	
	public JPanelRotas(ArrayList coordenadas, ArrayList evolution) {

		nos = coordenadas;
		evolucao = evolution;
		populacao = (Populacao)evolucao.get(0);
	}

	
	/** 
	 * Método responsável por plotar no gráfico as coordenadas que respresentam os 'nós'
	 * 
	 * @since 28 de Maio de 2006
	 */
	public void paintComponent(Graphics componente) {
		
		super.paintComponent(componente);
		
		
		Point coordenada = null;
		
		grafico = (Graphics2D)componente;
		
		if(nos != null){

			Iterator iterator = nos.iterator();
			
			while(iterator.hasNext()){
			
				coordenada = (Point)iterator.next();
				
				node = new Ellipse2D.Double(coordenada.x, coordenada.y, 8.0, 8.0); 
				grafico.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				grafico.setPaint(Color.white);
				grafico.fill(node);
				grafico.setPaint(Color.red);  
				grafico.draw(node);
			}
		}
		drawRotas(grafico);
		grafico.dispose();
	}

	
	/** 
	 * Método responsável por plotar no gráfico as 'rotas' entre os 'nós'
	 * 
	 * @since 28 de Maio de 2006
	 */
	public void drawRotas(Graphics2D grafico) {

		//Guarda informações do primeiro cromossomo para que seja possível fechar o ciclo do grafo
		Cromossomo inicial = (Cromossomo)populacao.getCromossomo(0);
		Integer first = (Integer)inicial.getRotas().get(0);
		
		Iterator pop = populacao.getCromossomos().iterator();
		
		Point origem  = null;
        Point destino = null;
		
		int index = 0;
		
		while(pop.hasNext()){
			
			this.cromossomo = (Cromossomo)pop.next();
			
			Iterator i = cromossomo.getRotas().iterator();
        	
			index = ((Integer)i.next()).intValue();
           	origem = (Point)nos.get(index);
			
           	while(i.hasNext()){
				
				index = ((Integer)i.next()).intValue();
				destino = (Point)nos.get(index);
				
				rota = new Line2D.Double(origem.x, origem.y, destino.x, destino.y);
        		grafico.setColor(Color.blue);
              	grafico.draw(rota);
              
              	origem = destino;
			}
			//Fecha o ciclo do grafo (o último cromossomo liga-se ao primeiro)
			destino = (Point)nos.get(first.intValue());
			
			rota = new Line2D.Double(origem.x, origem.y, destino.x, destino.y);
			grafico.setColor(Color.blue);
	      	grafico.draw(rota);
		}
	}

	
	/** 
	 * Método utilizado pela thread para executar paralelamente
	 * os recursos gráficos. 
	 * 
	 * @since 28 de Maio de 2006
	 */
	public synchronized void run() {
		
 		 int delay = 500;
		 
		 Iterator popula = evolucao.iterator();
		
		 while(popula.hasNext()){
		
			 populacao = (Populacao)popula.next();
			
			 try {
				Thread.sleep(delay);
			 }catch (InterruptedException e) {
				e.printStackTrace();
			 }
			repaint();
		 }
	}

}		
	

