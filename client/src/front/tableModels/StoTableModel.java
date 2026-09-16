/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Sto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class StoTableModel extends AbstractTableModel {

    private ArrayList<Sto> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"Id", "br Musterija, br Mesta"};//nesto nalik ovom

    public StoTableModel() throws Exception{
        lista = ClientControler.getInstance().getAllSto();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Sto getSto(int row) {
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
                return lista.get(i).getIdSto();
            case 1://get korisnickoIme
                return lista.get(i).getBrMusterija();
            case 2:
                return lista.get(i).getTipStola().getBrMesta();
            default:
                throw new AssertionError();
        }
    }
    
}
