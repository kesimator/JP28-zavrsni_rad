/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formula1.view;

import formula1.controller.ObradaTimovi;
import formula1.model.Timovi;
import formula1.model.Vozaci;
import formula1.util.Alati;
import formula1.util.EdunovaException;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Kesimator
 */
public class ProzorTimovi extends javax.swing.JFrame implements EdunovaViewSucelje {

    private ObradaTimovi obrada;

    /**
     * Creates new form ProzorTimovi
     */
    public ProzorTimovi() {
        initComponents();
        obrada = new ObradaTimovi();
        setTitle(Alati.NAZIV_APP + " | TIMOVI");
        ucitaj();

        lstPodaci.setSelectedIndex(0);
        lstPodaci.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txtImeTima = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGodinaOsnutka = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDrzavaSjedista = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtVozaciUTimu = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N

        lstPodaci.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ime tima");

        txtImeTima.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtImeTima.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImeTima.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImeTimaFocusGained(evt);
            }
        });
        txtImeTima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImeTimaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Godina osnutka");

        txtGodinaOsnutka.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtGodinaOsnutka.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGodinaOsnutka.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGodinaOsnutkaFocusGained(evt);
            }
        });
        txtGodinaOsnutka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGodinaOsnutkaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Država sjedišta");

        txtDrzavaSjedista.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtDrzavaSjedista.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDrzavaSjedista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDrzavaSjedistaFocusGained(evt);
            }
        });
        txtDrzavaSjedista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDrzavaSjedistaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Vozači u timu");

        txtVozaciUTimu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtVozaciUTimu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnDodaj.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjena.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnPromjena.setText("Promijeni");
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGodinaOsnutka, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txtImeTima, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtVozaciUTimu)
                            .addComponent(txtDrzavaSjedista)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(49, 49, 49)
                        .addComponent(btnPromjena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnObrisi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtImeTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGodinaOsnutka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDrzavaSjedista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtVozaciUTimu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnPromjena))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }

        if (lstPodaci.getSelectedValue() == null) { // treba li !
            return;
        }

        obrada.setEntitet(lstPodaci.getSelectedValue());

        popuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        obrada.setEntitet(new Timovi());
        popuniModel();

        ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));

        try {
            obrada.create();
            ucitaj();
            lstPodaci.setSelectedIndex(0);
            lstPodaci.requestFocusInWindow();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka(),
                    "UPOZORENJE", JOptionPane.ERROR_MESSAGE, slika);
        }
        lstPodaci.setSelectedIndex(0);
        lstPodaci.requestFocusInWindow();
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjenaActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        var e = lstPodaci.getSelectedValue();

        obrada.setEntitet(e);
        popuniModel();

        ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));

        try {
            obrada.update();
            ucitaj();
            lstPodaci.setSelectedIndex(0);
            lstPodaci.requestFocusInWindow();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka(),
                    "UPOZORENJE", JOptionPane.ERROR_MESSAGE, slika);
            obrada.refresh();
        }
        lstPodaci.setSelectedIndex(0);
        lstPodaci.requestFocusInWindow();
    }//GEN-LAST:event_btnPromjenaActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        var e = lstPodaci.getSelectedValue();

        ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));

        if (JOptionPane.showConfirmDialog(getRootPane(), e, "Sigurno obrisati?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, slika) != JOptionPane.YES_OPTION) {
            return;
        }

        obrada.setEntitet(e);

        try {
            obrada.delete();
            ucitaj();
            lstPodaci.setSelectedIndex(0);
            lstPodaci.requestFocusInWindow();
        } catch (EdunovaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka(),
                    "UPOZORENJE", JOptionPane.ERROR_MESSAGE, slika);
        }
        lstPodaci.setSelectedIndex(0);
        lstPodaci.requestFocusInWindow();
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtImeTimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeTimaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null);
            txtGodinaOsnutka.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtImeTimaKeyPressed

    private void txtGodinaOsnutkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGodinaOsnutkaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null);
            txtDrzavaSjedista.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtGodinaOsnutkaKeyPressed

    private void txtDrzavaSjedistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDrzavaSjedistaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null);
            txtImeTima.requestFocusInWindow();
        }
    }//GEN-LAST:event_txtDrzavaSjedistaKeyPressed

    private void txtImeTimaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImeTimaFocusGained
        txtImeTima.selectAll();
    }//GEN-LAST:event_txtImeTimaFocusGained

    private void txtGodinaOsnutkaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGodinaOsnutkaFocusGained
        txtGodinaOsnutka.selectAll();
    }//GEN-LAST:event_txtGodinaOsnutkaFocusGained

    private void txtDrzavaSjedistaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDrzavaSjedistaFocusGained
        txtDrzavaSjedista.selectAll();
    }//GEN-LAST:event_txtDrzavaSjedistaFocusGained

    @Override
    public void ucitaj() {
        DefaultListModel<Timovi> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();
        e.setIme_tima(txtImeTima.getText());
        e.setDrzava_sjedista(txtDrzavaSjedista.getText());

        try {
            e.setGodina_osnutka(Integer.valueOf(txtGodinaOsnutka.getText()));
        } catch (Exception ex) {
            e.setGodina_osnutka(null);
        }
    }

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();
        txtImeTima.setText(e.getIme_tima());
        txtDrzavaSjedista.setText(e.getDrzava_sjedista());
        txtGodinaOsnutka.setText(String.valueOf(e.getGodina_osnutka()));
//        txtVozaciUTimu.setText(String.valueOf(e.getVozaci()));

        try {
            txtVozaciUTimu.setText(String.valueOf(e.getVozaci()));
        } catch (Exception ex) {
            txtVozaciUTimu.setText("");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Timovi> lstPodaci;
    private javax.swing.JTextField txtDrzavaSjedista;
    private javax.swing.JTextField txtGodinaOsnutka;
    private javax.swing.JTextField txtImeTima;
    private javax.swing.JTextField txtVozaciUTimu;
    // End of variables declaration//GEN-END:variables

}
