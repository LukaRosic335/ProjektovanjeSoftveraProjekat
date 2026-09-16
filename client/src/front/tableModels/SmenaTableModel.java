/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Smena;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class SmenaTableModel extends AbstractTableModel {

    private ArrayList<Smena> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"Id", "pocetak", "kraj"};//nesto nalik ovom

    public SmenaTableModel() throws Exception {
        lista = ClientControler.getInstance().getAllSmena();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Smena getSmena(int row) {
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
                return lista.get(i).getIdSmena();
            case 1:
                return lista.get(i).getPocetak();
            case 2:
                return lista.get(i).getKraj();
            default:
                throw new AssertionError();
        }
    }

}
