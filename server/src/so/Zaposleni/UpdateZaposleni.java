/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.Zaposleni;

import dbb.DBB;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import java.util.ArrayList;
import so.ApstraktneSistemskeOperacije;

/**
 *
 * @author jevrozim
 */
public class UpdateZaposleni extends ApstraktneSistemskeOperacije{ 

    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        DBB.getInstance().update(odo);
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Zaposleni)){
            throw new Exception("Podatak koji je poslat nije zaposleni");
        }
        Zaposleni zaposleni=(Zaposleni) odo;
        if(zaposleni.getIme().equals("") || zaposleni.getPrezime().equals("")||zaposleni.getKorisnickoIme().equals("")||zaposleni.getSifra().equals("")){
            throw new Exception("Nepravilno postavljeni kredencijali");
        }
        //nadji ga u bazi
        Zaposleni id=new Zaposleni();
        id.setIdZaposleni(zaposleni.getIdZaposleni());
        ArrayList<OpstiDomenskiObjekat> him=DBB.getInstance().select(id);//trazi ga samo po id
        if(him.isEmpty()){
            throw new Exception("Ne postoji taj zaposleni");
        }
    }
    
}
