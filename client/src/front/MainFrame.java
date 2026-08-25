/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package front;

import domain.Zaposleni;
import clientsession.Session;
import controler.ClientControler;
import front.panels.NoviZaposleniPanel;
import front.panels.PanelFrame;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author jevrozim
 */
public class MainFrame extends javax.swing.JFrame {

    private PanelFrame interactionFrame;

    public MainFrame() {
        initComponents();
        ClientControler.getInstance().getFrames().add(this);
        this.setVisible(true);
        ussertxt.setHorizontalAlignment(SwingConstants.CENTER);
        System.out.println("Linija 25");
        if (Session.getInstace().getUlogovani() != null) {
            ussertxt.setText(Session.getInstace().getUlogovani().toString());
            System.out.println("Linija 28");
        }
        System.out.println("Linija 30");
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
        newZaposlenibtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagetxt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        newZaposlenibtn.setText("Dodaj novog zaposlenog");
        newZaposlenibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newZaposlenibtnActionPerformed(evt);
            }
        });

        messagetxt.setEditable(false);
        messagetxt.setColumns(20);
        messagetxt.setRows(5);
        jScrollPane1.setViewportView(messagetxt);

        jButton1.setText("Obrisi zaposlenog");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, Short.MAX_VALUE)
                        .addComponent(logoutbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newZaposlenibtn)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ussertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newZaposlenibtn)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
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
            System.out.println("1");
            Zaposleni z = Session.getInstace().getUlogovani();
            System.out.println("1.5");
            ClientControler.getInstance().logout(z);
            System.out.println("2");
            Session.getInstace().setUlogovani(null);//Ovo treba da radi klijent kontroler
            System.out.println("3");
//        LoginForm.getInstance().setVisible(true);
            System.out.println("4");
            System.out.println("5");
            LoginForm login = new LoginForm();
            login.getMessageTxt().setText("Uspesno odjavljivanje");
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_logoutbtnActionPerformed

    private void newZaposlenibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newZaposlenibtnActionPerformed
        NoviZaposleniPanel p=new NoviZaposleniPanel();
        interactionFrame=new PanelFrame(p);
        p.setFrame(interactionFrame);
        this.dispose();
    }//GEN-LAST:event_newZaposlenibtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //bukv prekopiraj gore
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextArea messagetxt;
    private javax.swing.JButton newZaposlenibtn;
    private javax.swing.JLabel ussertxt;
    // End of variables declaration//GEN-END:variables
}
