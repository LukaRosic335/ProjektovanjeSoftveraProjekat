/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Racun;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Racun;
import domain.StavkaRacuna;
import java.util.ArrayList;
import java.util.Comparator;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class PromeniRacun extends ApstraktneSistemskeOperacije<Racun> {

    @Override
    protected Racun execute(OpstiDomenskiObjekat odo) throws Exception {
        Racun racun = (Racun) odo;
        ArrayList<OpstiDomenskiObjekat> od = DBB.getInstance().select(new StavkaRacuna(racun));
        ArrayList<StavkaRacuna> novi = racun.getStavkeRacuna();
        ArrayList<StavkaRacuna> stari = new ArrayList<>();

        for (OpstiDomenskiObjekat o : od) {
            stari.add((StavkaRacuna) o);
        }

        stari.sort(Comparator.comparingInt(StavkaRacuna::getRb));
        novi.sort(Comparator.comparingInt(StavkaRacuna::getRb));
        System.out.println(stari.size()+"VEOMA STARI");
        System.out.println(novi.size()+"VEOMA NOVI");

        if(novi.size()==stari.size()){
            for(StavkaRacuna s:novi){
                DBB.getInstance().update(s);
            }
        }
        if(novi.size()<stari.size()){
            for(StavkaRacuna s:stari){
                if(!novi.contains(s)){
                    DBB.getInstance().delete(s);
                }
                for(int i=0;i<novi.size()+0;i++){
                    novi.get(i).setRb(i);
                    DBB.getInstance().update(novi.get(i));
                }
            }
        }
        if(novi.size()>stari.size()){
            System.out.println("JAKO BITNOSAOFDSAJDSDAIDSPOKADASJDPSJDAD");
            DBB.getInstance().insert(novi.get(stari.size()));
        }
        
        

        //ima u starim nema u novim=>delete
        //nema u starim ima u novim=>insert
        //ima u starim ima u novim=>update
//        double suma=0;
//        for(StavkaRacuna s: novi){
//            suma+=s.getCena()*s.getKolicina();
//        }
//        racun.setPocetniIznos(suma);
//        racun.setKrajnjiIznos(suma*racun.getPopust());



        DBB.getInstance().update(odo);
        return (Racun) odo;
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Nije prosledjen racun");
        }
    }

}
