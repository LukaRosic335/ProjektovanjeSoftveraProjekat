/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDateTime;

/**
 *
 * @author jevrozim
 */
public class Smena {
    private long idSmena;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;

    public long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(long idSmena) {
        this.idSmena = idSmena;
    }

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalDateTime kraj) {
        this.kraj = kraj;
    }
    
}
