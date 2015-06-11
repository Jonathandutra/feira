package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    
// instanciando e criando um arquivo , cria um arquivo com o nome jogador.txt no diretorio raiz
 File jogador = new File("d:\banco.txt");
// metodo usado para gravar Texto no arquivo 
    public void gravarArquivo(String tex) {

        try {
            // verifica a se o arquivo existe caso nao exista criar um aquivo 
            if (!jogador.exists()) {
                jogador.createNewFile();
            }
// recebe todo conteudo do arquivo que sera posteriormente gravado
            
            String conteudo = lerArquivo();
// rebebe o conteudo do arquivo e acresenta o conteudo passado no contruturo do metodo 
            String texto = conteudo + tex;
// Instancia classe rescponsavel por gravar no arquivo e diz em qual arquivo sera gravado
            PrintWriter guardar = new PrintWriter(jogador);
// grava o conteudo do texto no arquivo
            guardar.println(texto);
// fecha o arquivo 
            guardar.close();
// exibe uma confirmacao que o arquivo foi criado 
            JOptionPane.showMessageDialog(null, "Cadasro Realizado com Sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// Metodo usado para ler o conteudo de um arquivo 
    public String lerArquivo() {
// Inicia uma variavel que irar retornar o conteudo do arquivo 
        String texto = "";

        try {
//Instancia um objeto para ler o conteudo de um arquivo , esatbelece \\ como lititado no lugar do \n            
            Scanner leitor = new Scanner(new FileReader(jogador)).useDelimiter("\\|");
// Enquanto houver conteudo no leitor faca            
            while (leitor.hasNext()) {
                texto += leitor.next();
            }
      
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            return texto;
        }
    }

    public ArrayList<String> lerArquivoArray() {

        ArrayList< String> to = new ArrayList();
         String texto="";
        try {
            Scanner leitor = new Scanner(new FileReader(jogador)).useDelimiter("\\|");
                while (leitor.hasNext()) {
                texto = leitor.next();
                to.add(texto);
            }
          
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            return to;
        }
    }

    public void gravarArquivo(ArrayList<String> text) {

        try {
            if (!jogador.exists()) {
                jogador.createNewFile();
            }

            ArrayList<String> conteudo = new ArrayList();
            conteudo = lerArquivoArray();
            PrintWriter guardar = new PrintWriter(jogador);

            for (String tex : text) {
                String texto = tex;
                guardar.println(texto);
            }
            guardar.close();

            JOptionPane.showMessageDialog(null, "Cadasro Realizado com Sucesso");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moverAquivo()
    {
     File arqIn = new File("banco.txt");  
     File arqOut = new File("d:\banco.txt");  
     arqIn.renameTo(arqOut);
    }
    
    public boolean TestarArquivo(String nome)
    {
        File arq = new File (nome);
        if(arq.exists())
        {
          return true;  
        }else
        {
             return false; 
        }
      
    }


        public void gravarArquivoServidor(String tex) {
            File servidor = new File("CaminhoServidor.txt");
        try {
            
            if (servidor.exists()) {
                servidor.createNewFile();
            }
            
            String conteudo = lerArquivo();
            PrintWriter guardar = new PrintWriter(servidor);

            guardar.println(tex);
            guardar.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
