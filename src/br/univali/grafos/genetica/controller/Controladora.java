package br.univali.grafos.genetica.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import br.univali.grafos.genetica.model.ControlePopulacional;
import br.univali.grafos.genetica.model.Factory;
import br.univali.grafos.genetica.model.Populacao;
import br.univali.grafos.genetica.view.JFrameEntrada;
import br.univali.grafos.genetica.view.JFrameRotas;


/**
 * Classe responsável por 'ouvir' os eventos (solicitações do usuário)
 * gerados pela interface gráfica e delegar/controlar as classes de modelo.
 *                            
 * @author  David Victor & Jean Ferreira
 * 
 * @since 28 de Maio de 2006
 */
public class Controladora implements ActionListener{

	JFrameEntrada entrada;
	JFrameRotas rotas;
	JButton button;
	ControlePopulacional populacional;
	
	public Controladora(JFrameEntrada entrada, ControlePopulacional populacional){
		
		this.entrada = entrada;
		this.populacional = populacional;
		
		button = entrada.getButton();
		button.addActionListener(this);
	}
	
   /** 
	* Método 'listener'(ouvinte) dos eventos disparados pelas interfaces gráficas
	* 
	* @since 28 de Maio de 2006
	*/
	public void actionPerformed(ActionEvent evt){
		
		Object source = evt.getSource();
		
		if(source == entrada.getButton() && entrada.validarEntrada()){
			
			String nodes = entrada.getNos();
			String tamanho = entrada.getPopulacao();
			String iteracoes = entrada.getIteracoes();
			
			String log = "";
			
			Populacao populacao = null;
			Populacao novaGeracao = null;

			ArrayList evolucao = new ArrayList();
			
			ArrayList coordenadas = Factory.geraNos(nodes);
			
			for (int i=0; i<Integer.parseInt(iteracoes); i++){
				
				populacao = populacional.iniciaPopulacao(coordenadas, tamanho);
				novaGeracao = populacional.processaEvolucao(coordenadas, populacao);

				evolucao.add(novaGeracao);
			}

			log = populacional.relatorio(evolucao);
			
			JFrameRotas rotas = new JFrameRotas(coordenadas,evolucao,log);
		}
	}
	
}
