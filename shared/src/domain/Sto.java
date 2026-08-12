/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author jevrozim
 */
public class Sto {
    private long idSto;
    private int brMusterija;
    private TipStola tipStola;

    public long getIdSto() {
        return idSto;
    }

    public void setIdSto(long idSto) {
        this.idSto = idSto;
    }

    public int getBrMusterija() {
        return brMusterija;
    }

    public void setBrMusterija(int brMusterija) {
        this.brMusterija = brMusterija;
    }

    public TipStola getTipStola() {
        return tipStola;
    }

    public void setTipStola(TipStola tipStola) {
        this.tipStola = tipStola;
    }
    
}
