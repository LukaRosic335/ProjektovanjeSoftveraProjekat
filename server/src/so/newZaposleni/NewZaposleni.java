/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.newZaposleni;
import domain.OpstiDomenskiObjekat;
import domain.Zaposleni;
import so.ApstraktneSistemskeOperacije;
/**
 *
 * @author jevrozim
 */
public class NewZaposleni extends ApstraktneSistemskeOperacije{

    private Zaposleni z;
    @Override
    protected void execute(OpstiDomenskiObjekat odo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void validate(OpstiDomenskiObjekat odo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Zaposleni getZaposleni(){
        return z;
    }
    
}
