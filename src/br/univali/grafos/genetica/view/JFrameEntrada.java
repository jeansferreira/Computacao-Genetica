/*
 * JFrameEntrada.java
 *
 * Created on 16 de Junho de 2006, 15:06
 */

package br.univali.grafos.genetica.view;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Classe que implementa a interface gráfica responsável 
 * por requisitar ao usuário os dados de entrada. 
 * 
 *@author David Victor & Jean Ferreira
 *
 *@since 16 de Maio de 2006
 */
public class JFrameEntrada extends javax.swing.JFrame {
    
	private javax.swing.JButton jButtonGerar;
    private javax.swing.JLabel jLabelIteracoes;
    private javax.swing.JLabel jLabelNos;
    private javax.swing.JLabel jLabelPopulacao;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JTextField jTextFieldIteracoes;
    private javax.swing.JTextField jTextFieldNos;
    private javax.swing.JTextField jTextFieldPopulacao;
	
	
	public JFrameEntrada() {
        initComponents();
    }
    
    private void initComponents() {
        jButtonGerar = new javax.swing.JButton();
        jPanelInput = new javax.swing.JPanel();
        jLabelNos = new javax.swing.JLabel();
        jTextFieldNos = new javax.swing.JTextField();
        jLabelPopulacao = new javax.swing.JLabel();
        jLabelIteracoes = new javax.swing.JLabel();
        jTextFieldPopulacao = new javax.swing.JTextField();
        jTextFieldIteracoes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computa\u00e7\u00e3o Gen\u00e9tica");
        setResizable(false);
        jButtonGerar.setText("Gerar");
        
        jPanelInput.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de Entrada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 102)));
        jLabelNos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelNos.setText("N\u00f3s:");

        jLabelPopulacao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelPopulacao.setText("Popula\u00e7\u00e3o:");

        jLabelIteracoes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelIteracoes.setText("Itera\u00e7ões:");
        
        org.jdesktop.layout.GroupLayout jPanelInputLayout = new org.jdesktop.layout.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jLabelPopulacao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelNos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabelIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jTextFieldIteracoes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .add(jTextFieldNos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextFieldPopulacao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
                .add(31, 31, 31))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelNos)
                    .add(jTextFieldNos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(15, 15, 15)
                .add(jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelPopulacao)
                    .add(jTextFieldPopulacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(21, 21, 21)
                .add(jPanelInputLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextFieldIteracoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelIteracoes))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanelInput, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButtonGerar))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanelInput, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(jButtonGerar)
                .addContainerGap())
        );
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-900)/2, (screenSize.height-650)/2, 210, 245);
    }
  
    public boolean validarEntrada(){
    	
    	String qtdNos = jTextFieldNos.getText().trim();
    	String tamanhoPop = jTextFieldPopulacao.getText().trim();
    	String nroIteracoes = jTextFieldIteracoes.getText().trim();

    	if(qtdNos.matches("[0-9]+")&& tamanhoPop.matches("[0-9]+") && nroIteracoes.matches("[0-9]+")){
    			if(Integer.parseInt(tamanhoPop) % 2 != 0){
    				JOptionPane.showMessageDialog(null,"O tamanho da população deve ser par!", "Computação Genética (ERRO)", JOptionPane.WARNING_MESSAGE);
    				return false;
    			}else
    				return true;
    	}else{
    		JOptionPane.showMessageDialog(null,"Os campos de entrada devem conter apenas números!", "Computação Genética (ERRO)", JOptionPane.WARNING_MESSAGE);
        	return false;
    	}
    }
    
    public JButton getButton(){
    	return this.jButtonGerar;
    }
    
    public String getNos(){
    	return jTextFieldNos.getText();
    }
    
    public String getPopulacao(){
    	return jTextFieldPopulacao.getText();
    }
    
    public String getIteracoes(){
    	return jTextFieldIteracoes.getText();
    }
    

}
