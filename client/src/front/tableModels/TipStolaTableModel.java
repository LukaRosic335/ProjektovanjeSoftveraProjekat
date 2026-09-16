/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.TipStola;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class TipStolaTableModel extends AbstractTableModel{  //NAVODNO JE LISTA NULL
    private ArrayList<TipStola> lista = new ArrayList(); 
    private final String[] kolone = {"Id", "brMesta"};

    public TipStolaTableModel() throws Exception{
        lista = ClientControler.getInstance().getAllTipStola();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public TipStola getTipStola(int row) {
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();

    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0://get id
                return lista.get(i).getIdTipStola();
            case 1://get korisnickoIme
                return lista.get(i).getBrMesta();
            default:
                throw new AssertionError();
        }
    }
    
}
