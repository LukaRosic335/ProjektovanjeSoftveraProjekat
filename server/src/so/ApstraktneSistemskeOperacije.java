/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.OpstiDomenskiObjekat;
import dbb.DBB;
import java.sql.SQLException;

/**
 *
 * @author jevrozim
 */
public abstract class ApstraktneSistemskeOperacije <T>{
    


    //Nisam siguran da trebaju da se bacaju obicni Exceptioni i nisam siguran da kapiram kako da ih hendlujem
    //Zasto se bacaju obicni izuzetci zvuci turbo glupo 
    
    
    
    protected abstract T execute(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void validate(OpstiDomenskiObjekat odo) throws Exception;

    public T executeTamplate(OpstiDomenskiObjekat odo) throws Exception {
        try {
            validate(odo);
            T rosaVoda=execute(odo);
            commit();
            return rosaVoda;
        } catch (Exception e) {
            rollback();
            throw e;
        }

    }

    private void commit() throws SQLException {
        DBB.getInstance().getConnection().commit();
    }

    private void rollback() throws SQLException {
        DBB.getInstance().getConnection().rollback();
    }
}
