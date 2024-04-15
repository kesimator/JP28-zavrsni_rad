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
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

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

        postaviRendererZaListu();
    }

    public ObradaTimovi getObradaTimovi() {
        return obrada;
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
        lblVozaciUTimu = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstVozaci = new javax.swing.JList<>();
        lblBrojTimova = new javax.swing.JLabel();
        btnUpravljajTimovima = new javax.swing.JButton();
        btnUkloniIzPrvenstva = new javax.swing.JButton();
        btnUkloniVozace = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(890, 400));

        jScrollPane1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N

        lstPodaci.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstPodaciKeyPressed(evt);
            }
        });
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

        lblVozaciUTimu.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblVozaciUTimu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVozaciUTimu.setText("Vozači u timu");

        btnDodaj.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjena.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnPromjena.setText("Promijeni");
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jScrollPane2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        lstVozaci.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lstVozaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstVozaci);

        lblBrojTimova.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblBrojTimova.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrojTimova.setText("Broj timova");

        btnUpravljajTimovima.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUpravljajTimovima.setText("Upravljaj timovima");
        btnUpravljajTimovima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpravljajTimovimaActionPerformed(evt);
            }
        });

        btnUkloniIzPrvenstva.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUkloniIzPrvenstva.setText("Ukloni tim iz prvenstva");
        btnUkloniIzPrvenstva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniIzPrvenstvaActionPerformed(evt);
            }
        });

        btnUkloniVozace.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUkloniVozace.setText("Ukloni vozače iz tima");
        btnUkloniVozace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniVozaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(lblBrojTimova, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtGodinaOsnutka)
                                .addComponent(txtDrzavaSjedista)
                                .addComponent(txtImeTima, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnDodaj)
                            .addGap(45, 45, 45)
                            .addComponent(btnPromjena)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnObrisi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUkloniIzPrvenstva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnUpravljajTimovima, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUkloniVozace, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVozaciUTimu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVozaciUTimu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBrojTimova, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtImeTima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGodinaOsnutka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDrzavaSjedista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjena)
                            .addComponent(btnObrisi))
                        .addGap(18, 18, 18)
                        .addComponent(btnUpravljajTimovima)
                        .addGap(18, 18, 18)
                        .addComponent(btnUkloniIzPrvenstva)
                        .addGap(18, 18, 18)
                        .addComponent(btnUkloniVozace)
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
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

        lstPodaci.requestFocusInWindow();
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

    private boolean ispravnoIme(String ime) {
        // Provjeravamo je li ime prazno ili duže od 30 znakova
        ime = ime.trim();
        return !ime.isEmpty() && ime.length() <= 30;
    }

    private void txtImeTimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeTimaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (txtImeTima.getText().isEmpty() || !ispravnoIme(txtImeTima.getText())) {
                // Ako je polje prazno, ostajemo na polju txtImeTima
                SwingUtilities.invokeLater(() -> txtImeTima.requestFocusInWindow());
            } else {
                // Ako polje nije prazno, prebacujemo se na polje txtPrezime
                SwingUtilities.invokeLater(() -> txtGodinaOsnutka.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtImeTimaKeyPressed

    private boolean ispravanGodinaOsnutka(int godinaOsnutka) {
        // Provjeravamo je li godina između 1904 i 2020
        return godinaOsnutka >= 1904 && godinaOsnutka <= 2020;
    }

    private void txtGodinaOsnutkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGodinaOsnutkaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            try {
                int godina = Integer.parseInt(txtGodinaOsnutka.getText());
                if (!ispravanGodinaOsnutka(godina)) {
                    // Ako godina nije ispravna, ostajemo na polju txtGodinaOsnutka
                    SwingUtilities.invokeLater(() -> txtGodinaOsnutka.requestFocusInWindow());
                } else {
                    // Ako je godina ispravna, prebacujemo se na sljedeće polje
                    SwingUtilities.invokeLater(() -> txtDrzavaSjedista.requestFocusInWindow());
                }
            } catch (NumberFormatException e) {
                // Ako se ne može parsirati kao broj, ostajemo na polju txtGodinaOsnutka
                SwingUtilities.invokeLater(() -> txtGodinaOsnutka.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtGodinaOsnutkaKeyPressed

    private boolean ispravnaDrzava(String drzava) {
        // Provjeravamo je li drzava prazno ili sadrži brojeve ili posebne znakove
        drzava = drzava.trim();
        return !drzava.isEmpty() && drzava.matches("[a-zA-ZčćžšđČĆŽŠĐ '-]+") && drzava.length() <= 20;
    }

    private void txtDrzavaSjedistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDrzavaSjedistaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (txtDrzavaSjedista.getText().isEmpty() || !ispravnaDrzava(txtDrzavaSjedista.getText())) {
                // Ako je polje prazno, ostajemo na polju txtDrzavaSjedista
                SwingUtilities.invokeLater(() -> txtDrzavaSjedista.requestFocusInWindow());
            } else {
                // Ako polje nije prazno, prebacujemo se na polje lstPodaci
                SwingUtilities.invokeLater(() -> lstPodaci.requestFocusInWindow());
            }
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

    private void btnUpravljajTimovimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpravljajTimovimaActionPerformed
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }
        new ProzorUpravljajTimovima(this).setVisible(true);
    }//GEN-LAST:event_btnUpravljajTimovimaActionPerformed

    private void lstPodaciKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstPodaciKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnUpravljajTimovima.doClick();
        }
    }//GEN-LAST:event_lstPodaciKeyPressed

    private void btnUkloniIzPrvenstvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniIzPrvenstvaActionPerformed
        if (lstPodaci.getSelectedValue() != null) {
            Timovi odabraniTim = lstPodaci.getSelectedValue();

            // Provjeri sudjeluje li tim u nekom prvenstvu
            if (odabraniTim.getPrvenstva().isEmpty()) {
                // Ako tim ne sudjeluje u ijednom prvenstvu, obavijesti korisnika
                ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
                JOptionPane.showMessageDialog(this, "Tim nema osvojenih prvenstava!",
                        "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
                // Automatski vraća fokus na odabrani tim u lstPodaci
                lstPodaci.setSelectedValue(odabraniTim, true);
                lstPodaci.requestFocusInWindow();
            } else {
                // Tim sudjeluje u prvenstvu, pa ga možemo ukloniti
                // Prikaži dijalog za potvrdu korisnika
                ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
                int odgovor = JOptionPane.showConfirmDialog(this, "Sigurno obrisati tim iz prvenstva?",
                        "UPOZORENJE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        slika);

                // Provjeri odgovor korisnika
                if (odgovor == JOptionPane.YES_OPTION) {
                    try {
                        obrada.ukloniIzPrvenstva(odabraniTim);
                        obrada.update();

                        // Osvježi prikaz tablice ili druge komponente sučelja kako bi se odražene promjene vidjele
                        ucitaj();
                        lstPodaci.requestFocusInWindow();

                        // Obavijesti korisnika o uspješnom uklanjanju tima iz prvenstva
                        JOptionPane.showMessageDialog(this, "Tim je uspješno uklonjen iz prvenstva!",
                                "POTVRDA", JOptionPane.INFORMATION_MESSAGE, slika);
                    } catch (Exception ex) {
                        // Uhvati iznimku ako se dogodi greška prilikom uklanjanja tima iz prvenstva
                        // i prikaži odgovarajuću poruku korisniku
                        JOptionPane.showMessageDialog(this,
                                "Dogodila se greška prilikom uklanjanja tima iz prvenstva: "
                                + ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE, slika);
                    }
                }
            }
        } else {
            // Ako nije odabran ijedan tim, prikaži poruku korisniku
            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
            JOptionPane.showMessageDialog(this, "Nije odabran tim za uklanjanje iz prvenstva!",
                    "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
        }
    }//GEN-LAST:event_btnUkloniIzPrvenstvaActionPerformed

    private void btnUkloniVozaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniVozaceActionPerformed
        // Provjeri je li odabran tim
        if (lstPodaci.getSelectedValue() != null) {
            // Dohvati odabrani tim
            Timovi odabraniTim = lstPodaci.getSelectedValue();

            // Pripremi ikonu za dijalog
            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));

            // Pitaj korisnika za potvrdu brisanja tima
            int odgovor = JOptionPane.showConfirmDialog(this, "Sigurno ukloniti sve vozače iz tima?",
                    "UPOZORENJE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    slika);

            // Provjeri odgovor korisnika
            if (odgovor == JOptionPane.YES_OPTION) {
                try {
                    // Ukloni sve vozače iz tima
                    obrada.ukloniSveVozaceIzTima(odabraniTim);
                    obrada.update();

                    // Osvježi prikaz liste vozača u timu
                    popuniView();

                    // Osvježi prikaz tablice ili druge komponente sučelja kako bi se odražene promjene
                    ucitaj();
                    lstPodaci.requestFocusInWindow();

                    // Obavijesti korisnika o uspješnom uklanjanju svih vozača iz tima
                    JOptionPane.showMessageDialog(this, "Svi vozači su uspješno uklonjeni iz tima!",
                            "POTVRDA", JOptionPane.INFORMATION_MESSAGE, slika);
                } catch (EdunovaException ex) {
                    // Uhvati iznimku ako se dogodi greška prilikom uklanjanja vozača iz tima
                    // i prikaži odgovarajuću poruku korisniku
                    JOptionPane.showMessageDialog(this, "Dogodila se greška prilikom uklanjanja vozača iz tima: "
                            + ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE, slika);
                }
            }
        } else {
            // Pripremi ikonu za dijalog
            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
            // Ako nije odabran ijedan tim, prikaži poruku korisniku
            JOptionPane.showMessageDialog(this, "Nije odabran tim za uklanjanje vozača!",
                    "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
        }
    }//GEN-LAST:event_btnUkloniVozaceActionPerformed

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
        e.setIme_tima(txtImeTima.getText().trim());
        e.setDrzava_sjedista(txtDrzavaSjedista.getText().trim());

        try {
            e.setGodina_osnutka(Integer.valueOf(txtGodinaOsnutka.getText()));
        } catch (Exception ex) {
            e.setGodina_osnutka(null);
        }
    }

    private void postaviRendererZaListu() {
        lstVozaci.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Vozaci) {
                    Vozaci vozac = (Vozaci) value;
                    value = vozac.getIme() + " " + vozac.getPrezime();
                }

                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                return label;
            }
        });
    }

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();
        txtImeTima.setText(e.getIme_tima());
        txtDrzavaSjedista.setText(e.getDrzava_sjedista());
        txtGodinaOsnutka.setText(String.valueOf(e.getGodina_osnutka()));

        DefaultListModel<Vozaci> v = new DefaultListModel<>();
        for (Vozaci vozac : e.getVozaci()) {
            v.addElement(vozac);
        }
        lstVozaci.setModel(v);

        lblVozaciUTimu.setText("Vozači u timu (" + e.getVozaci().size() + ")");

        lblBrojTimova.setText("Broj timova: " + obrada.read().size());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnUkloniIzPrvenstva;
    private javax.swing.JButton btnUkloniVozace;
    private javax.swing.JButton btnUpravljajTimovima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBrojTimova;
    private javax.swing.JLabel lblVozaciUTimu;
    private javax.swing.JList<Timovi> lstPodaci;
    private javax.swing.JList<Vozaci> lstVozaci;
    private javax.swing.JTextField txtDrzavaSjedista;
    private javax.swing.JTextField txtGodinaOsnutka;
    private javax.swing.JTextField txtImeTima;
    // End of variables declaration//GEN-END:variables

}
