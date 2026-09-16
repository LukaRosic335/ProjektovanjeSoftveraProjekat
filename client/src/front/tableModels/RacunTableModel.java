/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Racun;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class RacunTableModel extends AbstractTableModel {

    private ArrayList<Racun> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"Id", "pocetni iznos", "sat","popust","krajnji iznos"};//nesto nalik ovom

    public RacunTableModel() throws Exception {
        
        lista = ClientControler.getInstance().getAllRacun();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Racun getRacun(int row) {
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
                return lista.get(i).getIdRacun();
            case 1:
                return lista.get(i).getPocetniIznos();
            case 2:
                return lista.get(i).getPopust();
            case 3:
                return lista.get(i).getKrajnjiIznos();
            default:
                throw new AssertionError();
        }
    }

    
    
}
