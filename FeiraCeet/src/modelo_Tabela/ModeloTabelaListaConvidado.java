package modelo_Tabela;

import java.util.ArrayList;
import modelos.Convidado;

public class ModeloTabelaListaConvidado extends javax.swing.table.AbstractTableModel {

    ArrayList<Convidado> listaConvidado = new ArrayList();
    Convidado convidado;

    @Override
    public int getRowCount() {
       return  listaConvidado.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        convidado = listaConvidado.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0: return convidado.getNome();
            case 1: return convidado.getCpf();
            case 2: return convidado.getEmail();
            case 3: return convidado.getCelular();
            case 4: return convidado.getTelefone();
            case 5: return convidado.getEscolaridade();
            default: return null;
        }
    }
    
      @Override
    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return "Nome";
            case 1: return "CPF";
            case 2: return "Email";
            case 3: return "Celular";
            case 4: return "Telefone";
            case 5: return "Escolaridade";
            default: return null;
        }
    }

        public void inserirListaResultado(ArrayList<Convidado> listaConvidado)
    {
        this.listaConvidado = listaConvidado;
    }
    
    public ArrayList<Convidado> retornarListaResultado()
    {
        return this.listaConvidado;
    }
}
