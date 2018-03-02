package br.com.note.metodos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.note.entidade.Note;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;




/**
 *
 * @author jeferson
 */
public class NoteTableModel extends AbstractTableModel{
//constantes que vão representar as colunas
    private final int COL_DESC = 0; 
    //lista dos produtos que serão exibidos
    private List<Note> notes;
            
    
     public NoteTableModel() {
        notes = new ArrayList();
    }
     
      public NoteTableModel(List<Note> lista) {
        this();
        notes.addAll(lista);
    }
            
            
            
    @Override
    public int getRowCount() {
      //cada produto na lista será uma linha
    
        return notes.size();    
    }

    @Override
    public int getColumnCount() {
       
      //Quantidade de colunas
        return 1;
    }

    
      @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        if (column == COL_DESC) {
            return "Notas";
        
        
        }
      
        return "";
    }
      
      @Override
    public Class getColumnClass(int columnIndex) {
       // retorna a classe que representa a coluna
        if (columnIndex == COL_DESC) {
            return String.class;
        } else if (columnIndex == COL_DESC) {
            return String.class;
       }
        return String.class;
      }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Note f = notes.get(rowIndex);
 
        //verifica qual valor deve ser retornado
        if (columnIndex == COL_DESC) {
            return f.getDescricao();
        }
       
        return "";
        
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        fireTableDataChanged();
    }
       
    
     @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //no nosso caso todas não vão ser editáveis, entao retorna false pra todas
        return false;
    }
      
     
     public void listar(List<Note> f) {
        notes.clear();
        notes = f;
 
        fireTableDataChanged();
    }
       public void limpar() {
        notes.clear();
        fireTableDataChanged();
    }
    public Note getItem(int pos) {
        if (pos < 0 || pos >= notes.size()) {
            return null;
        }
 
        return notes.get(pos);
    }
}
