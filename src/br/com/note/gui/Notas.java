/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.gui;

import br.com.note.DAO.CadNoteDAO;
import br.com.note.entidade.Note;
import br.com.note.metodos.NoteTableModel;
import br.com.note.metodos.TaskBar;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author f82cpd01
 */
public class Notas extends javax.swing.JFrame {
    List<Notas> funcionarios;
    private NoteTableModel model;
    private NoteTableModel model2;
    TaskBar task = new TaskBar("phone",this,"note"); //this referencia o proprio jframe
    /**
     * Creates new form CadNotas
     */
    public Notas() {
        initComponents();
        model = new NoteTableModel();
        model2 = new NoteTableModel();
        jTable1.setModel(model);
        jTable2.setModel(model2);
        buscatodos();
        addpopup();
        task.instanceTask(); 
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        arquivar = new javax.swing.JPopupMenu();
        jM_arquivar = new javax.swing.JMenuItem();
        retorna = new javax.swing.JPopupMenu();
        jM_retornar = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jB_excluir = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        jP_tela_prin = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jM_arquivar.setText("Arquivar");
        jM_arquivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_arquivarActionPerformed(evt);
            }
        });
        arquivar.add(jM_arquivar);

        jM_retornar.setText("Mover para aba principal");
        jM_retornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jM_retornarActionPerformed(evt);
            }
        });
        retorna.add(jM_retornar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setText("Nova");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jB_excluir.setText("Excluir");
        jB_excluir.setFocusable(false);
        jB_excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jB_excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jB_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_excluirActionPerformed(evt);
            }
        });
        jToolBar1.add(jB_excluir);

        bt_editar.setText("Edita");
        bt_editar.setFocusable(false);
        bt_editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bt_editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });
        jToolBar1.add(bt_editar);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jP_tela_prin.addTab("Principal", jScrollPane1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jP_tela_prin.addTab("Arquivados", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
            .addComponent(jP_tela_prin)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_tela_prin, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(553, 459));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadNota not = new CadNota(null, true);
        not.inseAlt(0);
        not.setVisible(true);
        buscatodos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jB_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_excluirActionPerformed
       excluir();
    }//GEN-LAST:event_jB_excluirActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        editar();
    }//GEN-LAST:event_bt_editarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (jTable1.isEnabled() && jTable2.isEnabled() && jTable2.isEnabled() ) {

            if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 1) {
                

            } else if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
               editar();

            }
        }
     
    }//GEN-LAST:event_jTable1MouseClicked

    private void jM_arquivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_arquivarActionPerformed
                int sele = jTable1.getSelectedRow();
                Note not = model.getItem(sele);
                CadNoteDAO dao = new CadNoteDAO();
                Note n =  dao.buscar(not);
                n.setArquivado(true);
                dao.alterar(n);
                buscatodos();
                dao.closeDB();
    }//GEN-LAST:event_jM_arquivarActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
          if (jTable2.isEnabled()) {

            if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 1) {
                

            } else if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
               editar();

            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
            if (jTable1.getSelectedRow()>=0) {
           if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
               excluir();
        }}
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
      if (jTable2.getSelectedRow()>=0) {
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
               excluir();
        }}
    }//GEN-LAST:event_jTable2KeyPressed

    private void jM_retornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jM_retornarActionPerformed
      
                int sele = jTable2.getSelectedRow();
                Note not = model2.getItem(sele);
                CadNoteDAO dao = new CadNoteDAO();
                Note n =  dao.buscar(not);
                n.setArquivado(false);
                dao.alterar(n);
                buscatodos();
                dao.closeDB();
    }//GEN-LAST:event_jM_retornarActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /*
//         * Set the Nimbus look and feel
//         */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /*
//         * If Nimbus (introduced in Java SE 6) is not available, stay with the
//         * default look and feel. For details see
//         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /*
//         * Create and display the form
//         */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() { RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();  
//        final int runtimePid = Integer.parseInt(rt.getName().substring(0,rt.getName().indexOf("@")));
//            java.awt.EventQueue.invokeLater(new Runnable() {  
//            @Override
//            public void run() {
//                try {
//                    // se existe outra instância, mostra a mensagem e finaliza a instância atual.
//                    // Caso contrário inicia a aplicação.
//                    if (getMonitoredVMs(runtimePid))
//                    {
//                      
//                        new Notas().setVisible(true);
//                    } else  
//                        JOptionPane.showMessageDialog(null,"Note Control já está aberto");
//                        
//                } catch (MonitorException ex) {
//                    Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//           }
//        });
//        
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu arquivar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton jB_excluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jM_arquivar;
    private javax.swing.JMenuItem jM_retornar;
    private javax.swing.JTabbedPane jP_tela_prin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPopupMenu retorna;
    // End of variables declaration//GEN-END:variables
  private void buscatodos(){
         CadNoteDAO dao = new CadNoteDAO();
         ArrayList<Note> not1 = new ArrayList<Note>(); 
         ArrayList<Note> not2 = new ArrayList<Note>(); 
         
         List<Note> notas = dao.BuscaTodos();
         if(notas != null){
         for (Note note : notas) {
          if(note.isArquivado()){
              not2.add(note);
          }else{
              not1.add(note);
          }
      }
            
         mostraDados(not1);
         mostraDados2(not2);
         }else{
             model.limpar();
             model2.limpar();
         }
           dao.closeDB();
    }
  
  public void mostraDados(List<Note> notas){
      if(notas != null){
         ArrayList<Note> d = new ArrayList();
         for (Iterator<Note> it = notas.iterator(); it.hasNext();) {
            Note funcionario = it.next();
            d.add(funcionario);
        }
            model.listar(d);
      }else{
          model.limpar();
      }
    }
  public void mostraDados2(List<Note> notas){
      if(notas != null){
            model2.listar(notas);
      }else{
          model2.limpar();
      }
    }
  
  public void editar(){
      CadNota not = new CadNota(null, true);
      if (jP_tela_prin.getModel().getSelectedIndex()== 0) {
        
        System.out.println(jTable1.getSelectedRow());
          if (jTable1.getSelectedRow()<0) {
              JOptionPane.showMessageDialog(null, "Selecione uma nota!");
              return;
          }
        not.inseAlt(1);
        int sele = jTable1.getSelectedRow();
        not.recebeNota(model.getItem(sele));
        not.mostraNota();
        not.setVisible(true);
        buscatodos();
      }else{
          if (jTable2.getSelectedRow()<0) {
              JOptionPane.showMessageDialog(null, "Selecione uma nota!");
              return;
            }
        System.out.println(jP_tela_prin.getModel().getSelectedIndex());
        not.inseAlt(1);
        int sele = jTable2.getSelectedRow();
        not.recebeNota(model2.getItem(sele));
        not.mostraNota();
        not.setVisible(true);
        buscatodos();
      }
       
  }
  
   private void addpopup() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Verificando se o botão direito foi pressionado  
                if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                    arquivar.show(jTable1, e.getX(), e.getY());
                    
                }
            }
        });
        
        jTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Verificando se o botão direito foi pressionado  
                if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
                    retorna.show(jTable2, e.getX(), e.getY());
                }
            }
        });
    }
   
   public void excluir(){
         int sele = jTable1.getSelectedRow();
         int sele2 = jTable2.getSelectedRow();
         
         if(sele >=0 || sele2>=0){
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, "Excluir Nota selecionada?", "Exclusão ", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            Note n = null;
            CadNoteDAO dao = new CadNoteDAO();
            if(jP_tela_prin.getModel().getSelectedIndex() == 0){
            Note note = model.getItem(jTable1.getSelectedRow());
            if(note != null){
             n =  dao.buscar(note); 
             }
            }else if(jP_tela_prin.getModel().getSelectedIndex() == 1){
             Note note = model2.getItem(jTable2.getSelectedRow());
             if(note != null){
             n =  dao.buscar(note);  
             }
            }
             if(n != null) {     
			if (dao.delete(n)) {
				
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao excluir cadstro");
			}				
		} else {
			
		}
                    dao.closeDB();
                    buscatodos();
                   
        }}else if(sele < 0 || sele2< 0){
                JOptionPane.showMessageDialog(null, "Selecione um nota!");
            }
}
   
   
   
}
