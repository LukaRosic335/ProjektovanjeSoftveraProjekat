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

    private JFrame interactionFrame;

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
    
    public JTextArea getMessage(){
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutbtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newZaposlenibtn)
                        .addGap(0, 214, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ussertxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newZaposlenibtn)
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
        // TODO add your handling code here:
        //treba mi popup koji dodaje novog zaposlenog
        NoviZaposleniPanel p=new NoviZaposleniPanel((PanelFrame)interactionFrame);
        interactionFrame = new PanelFrame(p);
        this.dispose();

    }//GEN-LAST:event_newZaposlenibtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JTextArea messagetxt;
    private javax.swing.JButton newZaposlenibtn;
    private javax.swing.JLabel ussertxt;
    // End of variables declaration//GEN-END:variables
}
