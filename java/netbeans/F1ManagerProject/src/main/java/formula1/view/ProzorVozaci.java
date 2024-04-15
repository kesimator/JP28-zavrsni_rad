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
        btnUkloniIzTima = new javax.swing.JButton();
        lblBrojVozaca = new javax.swing.JLabel();
        btnUkloniIzPrvenstva = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datum rođenja");

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nacionalnost");

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

        jLabel3.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tim");

        txtTim.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtTim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimFocusGained(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Prezime");

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

        jLabel5.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ime");

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

        btnDodaj.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnPromjena.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        btnPromjena.setText("Promijeni");
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

        btnUkloniIzTima.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUkloniIzTima.setText("Ukloni iz tima");
        btnUkloniIzTima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniIzTimaActionPerformed(evt);
            }
        });

        lblBrojVozaca.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblBrojVozaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBrojVozaca.setText("Broj vozača:");

        btnUkloniIzPrvenstva.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUkloniIzPrvenstva.setText("Ukloni iz prvenstva");
        btnUkloniIzPrvenstva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniIzPrvenstvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBrojVozaca, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnPromjena)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtIme, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtPrezime))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtNacionalnost, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(txtDatumRodenja))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUkloniIzTima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTim)
                            .addComponent(btnUkloniIzPrvenstva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBrojVozaca, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addGap(18, 18, 18)
                        .addComponent(btnUkloniIzTima)
                        .addGap(18, 18, 18)
                        .addComponent(btnUkloniIzPrvenstva)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnObrisi)
                            .addComponent(btnPromjena))
                        .addContainerGap())
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                slika) != JOptionPane.YES_OPTION) {
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
                // Ako polje nije prazno, prebacujemo se na polje lstPodaci
                SwingUtilities.invokeLater(() -> lstPodaci.requestFocusInWindow());
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
            LocalDate rodendan = LocalDate.parse(datum, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
            LocalDate danas = LocalDate.now();

            // Računanje razlike u godinama između datuma rođenja i danas
            int godine = Period.between(rodendan, danas).getYears();

            // Provjera uvjeta za dob vozača
            if (godine < 18 || godine > 60) {
                return false;
            }

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

    private void btnUkloniIzTimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniIzTimaActionPerformed
        if (lstPodaci.getSelectedValue() != null) {
            Vozaci odabraniVozac = lstPodaci.getSelectedValue();

            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));

            // Provjeri je li vozač sudionik nekog prvenstva
            if (!odabraniVozac.getPrvenstva().isEmpty()) {
                // Ako je vozač sudionik nekog prvenstva, obavijesti korisnika
                JOptionPane.showMessageDialog(this,
                        "Vozač se ne može ukloniti iz tima jer ima osvojena prvenstva!",
                        "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
                return; // Prekini izvršavanje metode jer ne želimo nastaviti s uklanjanjem vozača iz tima
            }

            // Provjeri je li vozač uopće član nekog tima
            if (odabraniVozac.getTim() == null) {
                // Ako vozač nije član tima, obavijesti korisnika
                JOptionPane.showMessageDialog(this,
                        "Vozač nije u timu!",
                        "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
                return; // Prekini izvršavanje metode jer ne želimo nastaviti s uklanjanjem vozača iz tima
            }

            try {
                // Provjeri može li vozač biti uklonjen iz tima
                if (obrada.provjeriVozaca(odabraniVozac)) {
                    // Prikaži dijalog za potvrdu korisnika
                    int odgovor = JOptionPane.showConfirmDialog(this, "Sigurno ukloniti vozača iz tima?",
                            "UPOZORENJE", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, slika);

                    // Provjeri odgovor korisnika
                    if (odgovor == JOptionPane.YES_OPTION) {
                        // Ukloni vozača iz tima
                        obrada.ukloniIzTima(odabraniVozac);
                        obrada.update();

                        // Osvježi prikaz tablice ili druge komponente sučelja kako bi se odražene promjene
                        ucitaj();
                        lstPodaci.requestFocusInWindow();

                        // Obavijesti korisnika o uspješnom uklanjanju vozača iz tima
                        JOptionPane.showMessageDialog(this, "Vozač je uspješno uklonjen iz tima!",
                                "POTVRDA", JOptionPane.INFORMATION_MESSAGE, slika);
                    }
                }
            } catch (EdunovaException ex) {
                // Uhvati iznimku ako se dogodi greška prilikom uklanjanja vozača iz tima
                // i prikaži odgovarajuću poruku korisniku
                JOptionPane.showMessageDialog(this, "Dogodila se greška prilikom uklanjanja vozača iz tima: "
                        + ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE, slika);
            }
        } else {
            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
            // Ako nije odabran nijedan vozač, prikaži poruku korisniku
            JOptionPane.showMessageDialog(this, "Nije odabran vozač za uklanjanje iz tima!",
                    "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
        }
    }//GEN-LAST:event_btnUkloniIzTimaActionPerformed

    private void btnUkloniIzPrvenstvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniIzPrvenstvaActionPerformed
        if (lstPodaci.getSelectedValue() != null) {
            Vozaci odabraniVozac = lstPodaci.getSelectedValue();

            // Provjeri sudjeluje li vozač u nekom prvenstvu
            if (odabraniVozac.getPrvenstva().isEmpty()) {
                // Ako vozač ne sudjeluje u ijednom prvenstvu, obavijesti korisnika
                ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
                JOptionPane.showMessageDialog(this, "Vozač nema osvojenih prvenstava!",
                        "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
                // Automatski vraća fokus na odabranog vozača u lstPodaci
                lstPodaci.setSelectedValue(odabraniVozac, true);
                lstPodaci.requestFocusInWindow();
            } else {
                // Vozač sudjeluje u prvenstvu, pa ga možemo ukloniti
                // Prikaži dijalog za potvrdu korisnika
                ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
                int odgovor = JOptionPane.showConfirmDialog(this, "Sigurno obrisati vozača iz prvenstva?",
                        "UPOZORENJE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        slika);

                // Provjeri odgovor korisnika
                if (odgovor == JOptionPane.YES_OPTION) {
                    try {
                        obrada.ukloniIzPrvenstva(odabraniVozac);
                        obrada.update();

                        // Osvježi prikaz tablice ili druge komponente sučelja kako bi se odražene promjene vidjele
                        ucitaj();
                        lstPodaci.requestFocusInWindow();

                        // Obavijesti korisnika o uspješnom uklanjanju vozača iz prvenstva
                        JOptionPane.showMessageDialog(this, "Vozač je uspješno uklonjen iz prvenstva!",
                                "POTVRDA", JOptionPane.INFORMATION_MESSAGE, slika);
                    } catch (Exception ex) {
                        // Uhvati iznimku ako se dogodi greška prilikom uklanjanja vozača iz prvenstva
                        // i prikaži odgovarajuću poruku korisniku
                        JOptionPane.showMessageDialog(this,
                                "Dogodila se greška prilikom uklanjanja vozača iz prvenstva: "
                                + ex.getMessage(), "GREŠKA", JOptionPane.ERROR_MESSAGE, slika);
                    }
                }
            }
        } else {
            // Ako nije odabran ijedan vozač, prikaži poruku korisniku
            ImageIcon slika = new ImageIcon(getClass().getResource("/f1logo70x29.jpg"));
            JOptionPane.showMessageDialog(this, "Nije odabran vozač za uklanjanje iz prvenstva!",
                    "UPOZORENJE", JOptionPane.WARNING_MESSAGE, slika);
        }
    }//GEN-LAST:event_btnUkloniIzPrvenstvaActionPerformed

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
            e.setDatum_rodenja(null);
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

        lblBrojVozaca.setText("Broj vozača: " + obrada.read().size());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjena;
    private javax.swing.JButton btnUkloniIzPrvenstva;
    private javax.swing.JButton btnUkloniIzTima;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojVozaca;
    private javax.swing.JList<Vozaci> lstPodaci;
    private javax.swing.JTextField txtDatumRodenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtNacionalnost;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
