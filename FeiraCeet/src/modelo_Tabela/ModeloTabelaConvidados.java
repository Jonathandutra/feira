
package modelo_Tabela;

import java.util.ArrayList;
import modelos.Convidado;


public class ModeloTabelaConvidados extends  javax.swing.table.AbstractTableModel
{
    ArrayList<Convidado> listaConvidado = new ArrayList(); 

    @Override
    public int getRowCount() {
       return this.listaConvidado.size();
    }

    @Override
    public int getColumnCount() {
       return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
