/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.gui;

import br.com.note.DAO.CadNoteDAO;
import br.com.note.entidade.Note;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author f82cpd01
 */
public class CadNota extends javax.swing.JDialog {
    int inserir_alterar = 0;
    Note nota;
    /**
     * Creates new form CadNota
     */
    public CadNota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    
        //atualiza();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tf_nota = new javax.swing.JTextArea();
        bt_salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tf_nota.setColumns(20);
        tf_nota.setRows(5);
        jScrollPane1.setViewportView(tf_nota);

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/note/imagens/App-floppy-icon.png"))); // NOI18N
        bt_salvar.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salvar e Sair", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_salvar.setIconTextGap(2);
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(416, 273));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed

        String descNota = tf_nota.getText();
        if (inserir_alterar == 0) {
            CadNoteDAO dao = new CadNoteDAO();
            Note note = new Note(descNota,false);
            dao.inserir(note);
       
            dao.closeDB();
        } else if (inserir_alterar == 1) {
            if (tf_nota.getText().equals("")) {
           
            } else {
                CadNoteDAO dao = new CadNoteDAO();
                Note funmc = dao.buscar(nota);
                funmc.setDescricao(descNota);
                dao.alterar(funmc);
                dao.closeDB();
            }
        }
        dispose();
        inserir_alterar = 0;
          
    }//GEN-LAST:event_bt_salvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException classNotFoundException) {
            //java.util.logging.Logger.getLogger(CadNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                CadNota dialog = new CadNota(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_salvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tf_nota;
    // End of variables declaration//GEN-END:variables
 
   public void inseAlt(int valor){
    inserir_alterar = valor;
   }

public void recebeNota(Note note){
    if (note != null) {
     nota = note;
    }
}
public void mostraNota(){
    
     tf_nota.setText(nota.getDescricao());
}

  
}
