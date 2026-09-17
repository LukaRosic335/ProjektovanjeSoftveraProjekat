/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Roba;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class RobaTableModel extends AbstractTableModel {

    private ArrayList<Roba> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"Id", "cena", "naziv","stanje u magacinu"};//nesto nalik ovom

    public RobaTableModel() throws Exception {
        lista = ClientControler.getInstance().getAllRoba();
        fireTableDataChanged();
    }

    public RobaTableModel(ArrayList<Roba> robe) {
        lista = robe;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Roba getRoba(int row) {
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
            case 0:
                return lista.get(i).getIdRoba();
            case 1:
                return lista.get(i).getCena();
            case 2:
                return lista.get(i).getNaziv();
            case 3:
                return lista.get(i).getStanjeUMagacinu();
            default:
                throw new AssertionError();
        }
    }

    
}
