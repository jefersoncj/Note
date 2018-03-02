/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.gui;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.jvmstat.monitor.HostIdentifier;
import sun.jvmstat.monitor.MonitorException;
import sun.jvmstat.monitor.MonitoredHost;
import sun.jvmstat.monitor.MonitoredVm;
import sun.jvmstat.monitor.MonitoredVmUtil;
import sun.jvmstat.monitor.VmIdentifier;

/**
 *
 * @author Jeferson1
 */
public class Main {
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();  
        final int runtimePid = Integer.parseInt(rt.getName().substring(0,rt.getName().indexOf("@")));
            java.awt.EventQueue.invokeLater(new Runnable() {  
            @Override
            public void run() {
                try {
                    // se existe outra instância, mostra a mensagem e finaliza a instância atual.
                    // Caso contrário inicia a aplicação.
                    if (getMonitoredVMs(runtimePid))
                    {
                      
                        new Notas().setVisible(true);
                    } else  
                        JOptionPane.showMessageDialog(null,"Note Control já está aberto");
                        
                } catch (MonitorException ex) {
                    Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        private  boolean getMonitoredVMs(int processPid) throws MonitorException, URISyntaxException {  
        MonitoredHost host;  
        Set vms;  
        try {  
            host = MonitoredHost.getMonitoredHost(new HostIdentifier((String)null));  
            vms = host.activeVms();  
        } catch (java.net.URISyntaxException sx) {  
            throw new InternalError(sx.getMessage());  
        } catch (MonitorException mx) {  
            throw new InternalError(mx.getMessage());  
        }  
        MonitoredVm mvm;  
        String processName = null;  
        try{  
            mvm = host.getMonitoredVm(new VmIdentifier(String.valueOf(processPid)));  
            processName = MonitoredVmUtil.commandLine(mvm);  
            processName = processName.substring(processName.lastIndexOf("\\") + 1,processName.length());  
            mvm.detach();  
        } catch (MonitorException exception) {  
              
        }  
       // Essa linha é somente para verificar o nome do processo aberto. Pode ser retirada  
        //JOptionPane.showMessageDialog(null,processName);  
        for (Object vmid: vms) {  
            if (vmid instanceof Integer) {  
                int pid = ((Integer) vmid);  
                String name = vmid.toString(); // default to pid if name not available  
                try {  
                     mvm = host.getMonitoredVm(new VmIdentifier(name));  
                     // use the command line as the display name  
                     name =  MonitoredVmUtil.commandLine(mvm);  
                     name = name.substring(name.lastIndexOf("\\")+1,name.length());  
                     mvm.detach();  
                     if ((name.equalsIgnoreCase(processName)) && (processPid != pid))  
                         return false;  
                } catch (MonitorException exception) {  
                     // ignore  
                }  
            }  
        }  
          
        return true;  
}  
        });
           }
        });
        
    }}
