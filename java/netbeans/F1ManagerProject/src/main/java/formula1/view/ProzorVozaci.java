/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formula1.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import formula1.controller.ObradaVozaci;
import formula1.model.Vozaci;
import formula1.util.Alati;
import formula1.util.EdunovaException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kesimator
 */
public class ProzorVozaci extends javax.swing.JFrame implements EdunovaViewSucelje {

    private ObradaVozaci obrada;

    /**
     * Creates new form ProzorVozaci
     */
    public ProzorVozaci() {
        initComponents();
        setTitle(Alati.NAZIV_APP + " | VOZAČI");
        obrada = new ObradaVozaci();

        ucitaj();

        lstPodaci.setSelectedIndex(0);

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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNacionalnost = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrezime = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnPromjena = new javax.swing.JButton();
        txtDatumRodenja = new javax.swing.JTextField();

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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datum rođenja");
        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nacionalnost");
        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        txtNacionalnost.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtNacionalnost.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNacionalnost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNacionalnostFocusGained(evt);
            }
        });
        txtNacionalnost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNacionalnostKeyPressed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tim");
        jLabel3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        txtTim.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtTim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimFocusGained(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Prezime");
        jLabel4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        txtPrezime.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtPrezime.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrezime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrezimeFocusGained(evt);
            }
        });
        txtPrezime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrezimeKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ime");
        jLabel5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        txtIme.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtIme.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImeFocusGained(evt);
            }
        });
        txtIme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImeKeyPressed(evt);
            }
        });

        btnDodaj.setText("Dodaj");
        btnDodaj.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPromjena.setText("Promijeni");
        btnPromjena.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnPromjena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjenaActionPerformed(evt);
            }
        });

        txtDatumRodenja.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtDatumRodenja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDatumRodenja.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDatumRodenjaFocusGained(evt);
            }
        });
        txtDatumRodenja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDatumRodenjaKeyPressed(evt);
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
                        .addComponent(btnDodaj)
                        .addGap(49, 49, 49)
                        .addComponent(btnPromjena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtTim))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtPrezime))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtNacionalnost, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(txtDatumRodenja))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatumRodenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNacionalnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
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

        lstPodaci.requestFocusInWindow();

    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        obrada.setEntitet(new Vozaci());
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

    private boolean ispravnoIme(String ime) {
        // Provjeravamo je li ime prazno ili sadrži brojeve ili posebne znakove
        return !ime.isEmpty() && ime.matches("[a-zA-Z]+") && ime.length() <= 20;
    }

    private void txtImeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (txtIme.getText().isEmpty() || !ispravnoIme(txtIme.getText())) {
                // Ako je polje prazno, ostajemo na polju txtIme
                SwingUtilities.invokeLater(() -> txtIme.requestFocusInWindow());
            } else {
                // Ako polje nije prazno, prebacujemo se na polje txtPrezime
                SwingUtilities.invokeLater(() -> txtPrezime.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtImeKeyPressed

    private boolean ispravnoPrezime(String prezime) {
        // Provjeravamo je li prezime prazno ili sadrži brojeve ili posebne znakove
        return !prezime.isEmpty() && prezime.matches("[a-zA-Z]+") && prezime.length() <= 50;
    }

    private void txtPrezimeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrezimeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (txtPrezime.getText().isEmpty() || !ispravnoPrezime(txtPrezime.getText())) {
                // Ako je polje prazno, ostajemo na polju txtPrezime
                SwingUtilities.invokeLater(() -> txtPrezime.requestFocusInWindow());
            } else {
                // Ako polje nije prazno, prebacujemo se na polje txtDatumRodenja
                SwingUtilities.invokeLater(() -> txtDatumRodenja.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtPrezimeKeyPressed

    private boolean Nacionalnost(String nacionalnost) {
        // Provjeravamo je li nacionalnost prazno ili sadrži brojeve ili posebne znakove
        return !nacionalnost.isEmpty() && nacionalnost.matches("[a-zA-Z]+") && nacionalnost.length() <= 30;
    }
    private void txtNacionalnostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalnostKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (txtNacionalnost.getText().isEmpty() || !Nacionalnost(txtNacionalnost.getText())) {
                // Ako je polje prazno, ostajemo na polju txtNacionalnost
                SwingUtilities.invokeLater(() -> txtNacionalnost.requestFocusInWindow());
            } else {
                // Ako polje nije prazno, prebacujemo se na polje txtIme
                SwingUtilities.invokeLater(() -> txtIme.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtNacionalnostKeyPressed

    private void txtImeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImeFocusGained
        txtIme.selectAll();
    }//GEN-LAST:event_txtImeFocusGained

    private void txtPrezimeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrezimeFocusGained
        txtPrezime.selectAll();
    }//GEN-LAST:event_txtPrezimeFocusGained

    private void txtNacionalnostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNacionalnostFocusGained
        txtNacionalnost.selectAll();
    }//GEN-LAST:event_txtNacionalnostFocusGained

    private void txtTimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusGained
        txtTim.selectAll();
    }//GEN-LAST:event_txtTimFocusGained

    private void txtDatumRodenjaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDatumRodenjaFocusGained
        txtDatumRodenja.selectAll();
    }//GEN-LAST:event_txtDatumRodenjaFocusGained

    private boolean datum(String datum) {
        // Provjeravamo je li datum prazan
        if (datum.isEmpty()) {
            return false;
        }

        // Provjeravamo ispravnost formata datuma
        try {
            LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    private void txtDatumRodenjaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDatumRodenjaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDodajActionPerformed(null); // Pozivamo dodavanje
            if (!datum(txtDatumRodenja.getText())) {
                // Ako datum nije ispravan, ostajemo na polju txtDatumRodenja
                SwingUtilities.invokeLater(() -> txtDatumRodenja.requestFocusInWindow());
            } else {
                // Ako je datum ispravan, prebacujemo se na polje txtNacionalnost
                SwingUtilities.invokeLater(() -> txtNacionalnost.requestFocusInWindow());
            }
        }
    }//GEN-LAST:event_txtDatumRodenjaKeyPressed

    @Override
    public void ucitaj() {
        DefaultListModel<Vozaci> m = new DefaultListModel<>();
        m.addAll(obrada.read());
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    @Override
    public void popuniModel() {
        var e = obrada.getEntitet();
        e.setIme(txtIme.getText().trim());
        e.setPrezime(txtPrezime.getText().trim());
        e.setNacionalnost(txtNacionalnost.getText().trim());

        try {
            LocalDate datumRodenja = LocalDate.parse(txtDatumRodenja.getText(),
                    DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            e.setDatum_rodenja(datumRodenja);
            txtDatumRodenja.setText(datumRodenja.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
        } catch (Exception ex) {
            // Ako se ne može parsirati datum rođenja, postavite ga na null ili obradite pogrešku na odgovarajući način
            e.setDatum_rodenja(null);   // NE RADI PROVJERA FORMATA!
        }
    }

    @Override
    public void popuniView() {
        var e = obrada.getEntitet();

        txtIme.setText(e.getIme());
        txtPrezime.setText(e.getPrezime());
        txtNacionalnost.setText(e.getNacionalnost());

        try {
            txtDatumRodenja.setText(e.getDatum_rodenja().format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
        } catch (Exception ex) {
            txtDatumRodenja.setText("");
        }

        try {
            txtTim.setText(String.valueOf(e.getTim().getIme_tima()));
        } catch (Exception ex) {
            txtTim.setText("");
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Vozaci> lstPodaci;
    private javax.swing.JTextField txtDatumRodenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtNacionalnost;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
