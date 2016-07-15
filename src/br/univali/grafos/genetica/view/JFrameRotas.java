/*
 * JFrameRotas.java
 *
 * Created on 27 de Maio de 2006, 17:01
 */

package br.univali.grafos.genetica.view;

import java.util.ArrayList;

/**
 * Classe responsável por apresentar graficamente os resultados 
 * 
 * @author David Victor & Jean Ferreira
 *
 * @since 27 de Maio de 2006	
 */
public class JFrameRotas extends javax.swing.JFrame{

	private javax.swing.JButton jButtonSair;
    private javax.swing.JPanel jPanelCustos;
    private JPanelRotas jPanelRotas;
    private javax.swing.JScrollPane jScrollPaneCustos;
    private javax.swing.JTextArea jTextAreaCustos;
    
     
    public JFrameRotas(ArrayList coordenadas, ArrayList evolucao, String log) {
		
    	jPanelRotas = new JPanelRotas(coordenadas,evolucao);
    	initComponents();
    	Thread thread = new Thread(jPanelRotas);
    	thread.start();
    	jTextAreaCustos.setText(log);
    }

	private void initComponents() {
        
        jPanelCustos = new javax.swing.JPanel();
        jScrollPaneCustos = new javax.swing.JScrollPane();
        jTextAreaCustos = new javax.swing.JTextArea();
        jButtonSair = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computa\u00e7\u00e3o Gen\u00e9tica");
        setResizable(false);
        jPanelRotas.setLayout(null);

        jPanelRotas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelRotas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanelRotas);
        jPanelRotas.setBounds(10, 10, 880, 450);

        jPanelCustos.setLayout(null);

        jPanelCustos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultados (custos)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 102)));
        jTextAreaCustos.setColumns(20);
        jTextAreaCustos.setRows(5);
        jScrollPaneCustos.setViewportView(jTextAreaCustos);

        jPanelCustos.add(jScrollPaneCustos);
        jScrollPaneCustos.setBounds(15, 20, 850, 95);

        getContentPane().add(jPanelCustos);
        jPanelCustos.setBounds(10, 470, 880, 130);

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair(evt);
            }
        });

        getContentPane().add(jButtonSair);
        jButtonSair.setBounds(810, 615, 80, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-907)/2, (screenSize.height-685)/2, 907, 685);
    
        setVisible(true);
  
    }

    private void sair(java.awt.event.ActionEvent evt) {
    	this.dispose();
    }
    
    public void setLog(String log){
    	this.jTextAreaCustos.append(log);
    }

    
}   