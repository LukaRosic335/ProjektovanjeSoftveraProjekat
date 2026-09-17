/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package front;

import domain.Zaposleni;
import clientsession.Session;
import controler.ClientControler;
import front.panels.zaposleniPaneli.ZaposleniPanel;
import front.panels.PanelFrame;
import front.panels.racunPaleni.RacunPanel;
import front.panels.robaPaneli.RobaPanel;
import front.panels.smenaPaneli.SmenaPanel;
import front.panels.stoPaneli.StoPanel;
import front.panels.tipStolaPaneli.TipStolaPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author jevrozim
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        this.setVisible(true);
        ussertxt.setHorizontalAlignment(SwingConstants.CENTER);
        if (Session.getInstace().getUlogovani() != null) {
            ussertxt.setText(Session.getInstace().getUlogovani().toString());
        }
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//najverovatnije nije potrebno
    }

    public JTextArea getMessage() {
        return messagetxt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ussertxt = new javax.swing.JLabel();
        logoutbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagetxt = new javax.swing.JTextArea();
        zaposlenibtn = new javax.swing.JButton();
        tipstolabtn = new javax.swing.JButton();
        robabtn = new javax.swing.JButton();
        racunbtn = new javax.swing.JButton();
        stobtn = new javax.swing.JButton();
        smenabtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        messagetxt.setEditable(false);
        messagetxt.setColumns(20);
        messagetxt.setRows(5);
        jScrollPane1.setViewportView(messagetxt);

        zaposlenibtn.setText("Zaposleni");
        zaposlenibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zaposlenibtnActionPerformed(evt);
            }
        });

        tipstolabtn.setText("Tip Stola");
        tipstolabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipstolabtnActionPerformed(evt);
            }
        });

        robabtn.setText("Roba");
        robabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robabtnActionPerformed(evt);
            }
        });

        racunbtn.setText("Racun");
        racunbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                racunbtnActionPerformed(evt);
            }
        });

        stobtn.setText("Sto");
        stobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stobtnActionPerformed(evt);
            }
        });

        smenabtn.setText("Smena");
        smenabtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smenabtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ussertxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                        .addComponent(logoutbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zaposlenibtn)
                        .addGap(18, 18, 18)
                        .addComponent(tipstolabtn)
                        .addGap(18, 18, 18)
                        .addComponent(stobtn)
                        .addGap(18, 18, 18)
                        .addComponent(robabtn)
                        .addGap(18, 18, 18)
                        .addComponent(racunbtn)
                        .addGap(18, 18, 18)
                        .addComponent(smenabtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ussertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zaposlenibtn)
                    .addComponent(tipstolabtn)
                    .addComponent(robabtn)
                    .addComponent(racunbtn)
                    .addComponent(stobtn)
                    .addComponent(smenabtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoutbtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        // TODO add your handling code here:
        try {
            Zaposleni z = Session.getInstace().getUlogovani();
            ClientControler.getInstance().logout(z);
            LoginForm login = new LoginForm();
            login.getMessageTxt().setText("Uspesno odjavljivanje");
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_logoutbtnActionPerformed

    private void zaposlenibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zaposlenibtnActionPerformed
        // TODO add your handling code here:
        ZaposleniPanel p = new ZaposleniPanel();
        PanelFrame f = new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_zaposlenibtnActionPerformed

    private void tipstolabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipstolabtnActionPerformed
        // TODO add your handling code here:
        TipStolaPanel p = new TipStolaPanel();
        PanelFrame f = new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_tipstolabtnActionPerformed

    private void robabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robabtnActionPerformed
        // TODO add your handling code here:
        RobaPanel p = new RobaPanel();
        PanelFrame f = new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_robabtnActionPerformed

    private void stobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stobtnActionPerformed
        // TODO add your handling code here:
        StoPanel p = new StoPanel();
        PanelFrame f = new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_stobtnActionPerformed

    private void racunbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_racunbtnActionPerformed
        // TODO add your handling code here:
        RacunPanel p = new RacunPanel();
        PanelFrame f = new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_racunbtnActionPerformed

    private void smenabtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smenabtnActionPerformed
        // TODO add your handling code here:
        SmenaPanel p=new SmenaPanel();
        PanelFrame f=new PanelFrame(p);
        p.setFrame(f);
        this.dispose();
    }//GEN-LAST:event_smenabtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextArea messagetxt;
    private javax.swing.JButton racunbtn;
    private javax.swing.JButton robabtn;
    private javax.swing.JButton smenabtn;
    private javax.swing.JButton stobtn;
    private javax.swing.JButton tipstolabtn;
    private javax.swing.JLabel ussertxt;
    private javax.swing.JButton zaposlenibtn;
    // End of variables declaration//GEN-END:variables
}
