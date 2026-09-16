/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class StavkaRacunaTableModel extends AbstractTableModel {

    private ArrayList<StavkaRacuna> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"rb", "id Racuna", "roba","kolicina","cena"};//nesto nalik ovom
    private Racun racun;
    public StavkaRacunaTableModel(Racun r) throws Exception {
        racun=r;
        lista =ClientControler.getInstance().getRacun(racun).getStavkeRacuna();
        lista.sort(Comparator.comparingInt(StavkaRacuna::getRb));
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public StavkaRacuna getStavkaRacuna(int row) {
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
    public Object getValueAt(int i, int i1) {//"rb", "id Racuna", "roba","kolicina","cena"
        switch (i1) {
            case 0:
                return lista.get(i).getRb();
            case 1:
                return lista.get(i).getRacun().getIdRacun();
            case 2:
                return lista.get(i).getRoba().getNaziv();
            case 3:
                return lista.get(i).getKolicina();
            case 4:
                return lista.get(i).getCena();
            default:
                throw new AssertionError();
        }
    }
    
}
