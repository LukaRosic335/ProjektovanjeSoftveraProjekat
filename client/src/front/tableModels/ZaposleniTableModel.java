/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package front.tableModels;

import controler.ClientControler;
import domain.Zaposleni;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jevrozim
 */
public class ZaposleniTableModel extends AbstractTableModel {

    private ArrayList<Zaposleni> lista = new ArrayList(); //KAO LISTA JE NULL NE ZNAM ZASTO
    private final String[] kolone = {"Id", "Korisnicko ime", "Ime", "Prezime"};//nesto nalik ovom

    public ZaposleniTableModel() {
        try{
        lista = ClientControler.getInstance().getAllZaposleni();
        lista.add(new Zaposleni(24, "Gojko", "gojkovic", "komenzibite", "123"));
        fireTableDataChanged();
        }catch(Exception e){
            System.out.println("GRESKA PRI UZIMANJU SVIH ZAPOSLENIH");
            //JOS NISAM SIGURAN KAKO CU OVO DA RESIM
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public Zaposleni getZaposleni(int row) {
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
                return lista.get(i).getIdZaposleni();
            case 1://get korisnickoIme
                return lista.get(i).getKorisnickoIme();
            case 2://get Ime
                return lista.get(i).getIme();
            case 3://get Prezime
                return lista.get(i).getPrezime();
            default:
                throw new AssertionError();
        }
    }
}
