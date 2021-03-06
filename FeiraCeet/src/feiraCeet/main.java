package feiraCeet;

import arquivo.ManipularArquivo;
import bancoDeDados.ConectarBanco;
import interfaces.CaminhoServidor;
import interfaces.inicial;

/**
 *
 * @author jonathan
 */
public class main {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        ConectarBanco conexaoBanco = new ConectarBanco();
        ManipularArquivo arquivo = new ManipularArquivo();
        arquivo.moverAquivo();
        String caminho = "";
        
        
        

        if (arquivo.TestarArquivo("CaminhoServidor.txt")) 
        {
            caminho = arquivo.lerArquivo();
               
            conexaoBanco.criarBase(caminho);
            conexaoBanco.criarTabelas(caminho);
            }else
        {
            
            CaminhoServidor tela = new CaminhoServidor(null, true);
            tela.setVisible(true);
            caminho = tela.CaminhoServidor();
            arquivo.gravarArquivoServidor(caminho);
            
            conexaoBanco.criarBase();
            conexaoBanco.criarTabelas();
         
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inicial().setVisible(true);
            }
        });
    }
}
