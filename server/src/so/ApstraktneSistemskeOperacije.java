/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.OpstiDomenskiObjekat;
import transfer.util.Operation;
import dbb.DBB;
import java.sql.SQLException;

/**
 *
 * @author jevrozim
 */
public abstract class ApstraktneSistemskeOperacije {
    


    //Nisam siguran da trebaju da se bacaju obicni Exceptioni i nisam siguran da kapiram kako da ih hendlujem
    //Zasto se bacaju obicni izuzetci zvuci turbo glupo 
    
    
    
    protected abstract void execute(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void validate(OpstiDomenskiObjekat odo) throws Exception;

    public void executeTamplate(OpstiDomenskiObjekat odo) throws Exception {
        //nesto nesto validate execute i rollback
        try {
            validate(odo);
            execute(odo);
            commit();
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
