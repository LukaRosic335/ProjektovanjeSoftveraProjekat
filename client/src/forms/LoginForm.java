/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controler.ClientControler;
import domain.Zaposleni;
import clientsession.Session;

/**
 *
 * @author jevrozim
 */
public class LoginForm extends javax.swing.JFrame {
    
    public LoginForm(String poruka) {
        initComponents();
        this.setVisible(true);
        messagetxt.setText(poruka);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernametxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordtxt = new javax.swing.JTextField();
        loginbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagetxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Korisnicko Ime:");

        jLabel2.setText("Lozinka:");

        loginbtn.setText("uloguj se");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });

        messagetxt.setEditable(false);
        messagetxt.setColumns(20);
        messagetxt.setRows(5);
        messagetxt.setText("Unesite korisnicko ime i lozinku.");
        jScrollPane1.setViewportView(messagetxt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(usernametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginbtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(59, 59, 59)
                        .addComponent(passwordtxt)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(loginbtn)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
        if(usernametxt.getText().isEmpty()||passwordtxt.getText().isEmpty()){
            System.out.println("Polja za ussername i password ne smeju ostati nepopunjena!");
        }else{
            Zaposleni zaposleni=new Zaposleni();
            zaposleni.setKorisnickoIme(usernametxt.getText());
            zaposleni.setSifra(passwordtxt.getText());
            zaposleni=ClientControler.getInstance().login(zaposleni);
            if(zaposleni!=null){
                Session.getInstace().setUlogovani(zaposleni);
                System.out.println(Session.getInstace().getUlogovani());
                System.out.println("IMAMO ZAPOSLENOG " + zaposleni.getIme()+" "+zaposleni.getPrezime()+" "+zaposleni.getKorisnickoIme());
                this.setVisible(false);
//                MainFrame.getInstance().setVisible(true);
                  MainFrame mainFrame=new MainFrame();
                  this.dispose();
            }else{
                System.out.println("Klijent kao odgovor nije dobio zaposlenog natrag");
                messagetxt.setText("Neuspesno prijavljivanje");
            }

        }
        
        
    }//GEN-LAST:event_loginbtnActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JTextArea messagetxt;
    private javax.swing.JTextField passwordtxt;
    private javax.swing.JTextField usernametxt;
    // End of variables declaration//GEN-END:variables
}
