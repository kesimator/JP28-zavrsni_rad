package formula1.view;

import formula1.controller.ObradaVozaci;
import formula1.model.Vozaci;
import formula1.util.Alati;
import formula1.util.EdunovaException;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;

/**
 *
 * @author Kesimator
 */
/**
 * Klasa koja omogućuje dodavanje i uklanjanje vozača iz tima. Koristi se u
 * kontekstu upravljanja vozačima unutar tima u formi ProzorTimovi.
 */
public class ProzorUpravljajTimovima extends javax.swing.JFrame {

    private ProzorTimovi prozorTimovi;
    private ObradaVozaci obradaVozaci;

    /**
     * Konstruktor koji inicijalizira prozor i priprema sučelje za rad.
     */
    public ProzorUpravljajTimovima() {
        initComponents();
        obradaVozaci = new ObradaVozaci();

        postaviRendererZaListu();
        postaviRendererZaListuDostupniVozaci();
        prikaziDostupneVozace();
    }

    /**
     * Konstruktor koji inicijalizira prozor s povezanim ProzorTimovi. Postavlja
     * naslov prozora na ime tima.
     *
     * @param prozorTimovi ProzorTimovi povezan s ovim prozorom
     */
    public ProzorUpravljajTimovima(ProzorTimovi prozorTimovi) {
        this(); // Pozivaj drugi konstruktor
        this.prozorTimovi = prozorTimovi;
        setTitle("TIM:        " + prozorTimovi.getObradaTimovi().getEntitet().getIme_tima());

        DefaultListModel<Vozaci> m = new DefaultListModel<>();
        m.addAll(prozorTimovi.getObradaTimovi().getEntitet().getVozaci());
        lstVozaciUTimu.setModel(m);
        lstVozaciUTimu.repaint();
    }

    /**
     * Metoda koja postavlja prilagođeni renderer za listu vozača u timu.
     * Renderer centrirano prikazuje ime i prezime vozača.
     */
    private void postaviRendererZaListu() {
        lstVozaciUTimu.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                Vozaci vozac = (Vozaci) value;
                label.setText(vozac.getIme() + " " + vozac.getPrezime());
                return label;
            }
        });
    }

    /**
     * Metoda koja postavlja prilagođeni renderer za listu dostupnih vozača.
     * Renderer centrirano prikazuje ime i prezime vozača.
     */
    private void postaviRendererZaListuDostupniVozaci() {
        lstVozaciUBazi.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                Vozaci vozac = (Vozaci) value;
                label.setText(vozac.getIme() + " " + vozac.getPrezime());
                return label;
            }
        });
    }

    /**
     * Metoda koja sortira listu vozača abecedno prema imenima i prezimenima.
     *
     * @param vozaci Lista vozača koju treba sortirati
     * @return Sortirana lista vozača
     */
    private List<Vozaci> sortirajAbecedno(List<Vozaci> vozaci) {
        vozaci.sort(Comparator.comparing(Vozaci::getIme).thenComparing(Vozaci::getPrezime));
        return vozaci;
    }

    /**
     * Metoda koja prikazuje sve dostupne vozače u listi. Vozači se dohvaćaju
     * preko obrade vozača, sortiraju abecedno i prikazuju u listi.
     */
    private void prikaziDostupneVozace() {
        DefaultListModel<Vozaci> m = new DefaultListModel<>();
        List<Vozaci> sviDostupniVozaci = obradaVozaci.dohvatiVozaceBezTima(null);
        sviDostupniVozaci = sortirajAbecedno(sviDostupniVozaci);
        for (Vozaci v : sviDostupniVozaci) {
            m.addElement(v);
        }
        lblUkupnoDostupnihVozaca.setText("Pronađeno rezultata: " + m.getSize());
        lstVozaciUBazi.setModel(m);
        lstVozaciUBazi.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVozaciUTimu = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstVozaciUTimu = new javax.swing.JList<>();
        lblDostupniVozaci = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstVozaciUBazi = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        btnUkloni = new javax.swing.JButton();
        lblUkupnoDostupnihVozaca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblVozaciUTimu.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblVozaciUTimu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVozaciUTimu.setText("Vozači u timu");

        jScrollPane2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        lstVozaciUTimu.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lstVozaciUTimu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane2.setViewportView(lstVozaciUTimu);

        lblDostupniVozaci.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblDostupniVozaci.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDostupniVozaci.setText("Dostupni vozači");

        jScrollPane3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N

        lstVozaciUBazi.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        lstVozaciUBazi.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstVozaciUBazi);

        txtUvjet.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUvjetKeyReleased(evt);
            }
        });

        btnTrazi.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnTrazi.setText("Traži");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnDodaj.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnDodaj.setText("<< Dodaj vozača u tim");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnUkloni.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        btnUkloni.setText("Ukloni vozača iz tima >>");
        btnUkloni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniActionPerformed(evt);
            }
        });

        lblUkupnoDostupnihVozaca.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lblUkupnoDostupnihVozaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUkupnoDostupnihVozaca.setText("Pronađeno rezultata:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVozaciUTimu, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUkloni))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUkupnoDostupnihVozaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblDostupniVozaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDostupniVozaci)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrazi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUkupnoDostupnihVozaca))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVozaciUTimu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(btnDodaj)
                                .addGap(63, 63, 63)
                                .addComponent(btnUkloni)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metoda koja se poziva prilikom pritiska gumba za pretragu vozača.
     * Pretražuje dostupne vozače prema unesenom uvjetu i ažurira prikaz u
     * listi.
     */
    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        DefaultListModel<Vozaci> m = new DefaultListModel<>();

        // Dohvati tekst unesen u txtUvjet
        String uvjet = txtUvjet.getText().trim();

        // Dohvati sve vozače koji nisu dodijeljeni nijednom timu
        List<Vozaci> sviDostupniVozaci = obradaVozaci.dohvatiVozaceBezTima(uvjet);

        // Prikaži vozače u listi
        for (Vozaci v : sviDostupniVozaci) {
            // Provjeri da li ime vozača sadrži uneseni uvjet
            if (v.getIme().toUpperCase().contains(uvjet.toUpperCase())) {
                m.addElement(v);
            }
        }

        lstVozaciUBazi.setModel(m);
    }//GEN-LAST:event_btnTraziActionPerformed

    /**
     * Metoda koja se poziva prilikom pritiska tipke na tipkovnici. Ako je
     * pritisnuta tipka ENTER, pokreće se pretraga vozača.
     */
    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnTraziActionPerformed(null);
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    /**
     * Metoda koja filtrira vozače prema unesenom uvjetu u realnom vremenu.
     * Ažurira prikaz dostupnih vozača prema unesenom uvjetu.
     */
    private void filtrirajVozace(String uvjet) {
        DefaultListModel<Vozaci> m = new DefaultListModel<>();
        List<Vozaci> sviDostupniVozaci = obradaVozaci.dohvatiVozaceBezTima(uvjet);

        // Prikaži samo vozače koji počinju s unesenim uvjetom u imenu
        for (Vozaci v : sviDostupniVozaci) {
            if (v.getIme().toUpperCase().startsWith(uvjet.toUpperCase())) {
                m.addElement(v);
            }
        }

        // Sortiraj vozače abecedno
        List<Vozaci> sortiraniVozaci = new ArrayList<>(m.getSize());
        for (int i = 0; i < m.getSize(); i++) {
            sortiraniVozaci.add(m.getElementAt(i));
        }
        sortiraniVozaci.sort(Comparator.comparing(Vozaci::getIme).thenComparing(Vozaci::getPrezime));

        lblUkupnoDostupnihVozaca.setText("Pronađeno rezultata: " + sortiraniVozaci.size());

        // Očisti model liste prije dodavanja sortiranih vozača
        m.clear();
        // Dodaj sortirane vozače u model liste
        for (Vozaci v : sortiraniVozaci) {
            m.addElement(v);
        }

        lstVozaciUBazi.setModel(m);
        lstVozaciUBazi.repaint();
    }

    /**
     * Metoda koja se poziva prilikom puštanja tipke na tipkovnici. Ažurira
     * prikaz dostupnih vozača prema unesenom uvjetu.
     */
    private void txtUvjetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyReleased
        // Pokreni pretragu teksta prilikom puštanja tipke
        filtrirajVozace(txtUvjet.getText().trim());
    }//GEN-LAST:event_txtUvjetKeyReleased

    /**
     * Metoda koja se poziva prilikom pritiska gumba za dodavanje vozača u tim.
     * Dodaje odabranog vozača iz liste dostupnih vozača u tim.
     */
    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        if (lstVozaciUBazi.getSelectedValue() == null) {
            return;
        }

        var v = lstVozaciUBazi.getSelectedValue();

        DefaultListModel<Vozaci> m = (DefaultListModel<Vozaci>) lstVozaciUTimu.getModel();
        DefaultListModel<Vozaci> b = (DefaultListModel<Vozaci>) lstVozaciUBazi.getModel();

        try {
            // Dodaj vozača u tim
            prozorTimovi.getObradaTimovi().dodajUTim(v);

            // Ukloni vozača iz liste dostupnih vozača i dodaj ga u listu vozača u timu
            m.addElement(v);
            b.removeElement(v);
        } catch (EdunovaException ex) {
            ex.printStackTrace();
            return;
        }
        prozorTimovi.popuniView();
        prikaziDostupneVozace();
    }//GEN-LAST:event_btnDodajActionPerformed

    /**
     * Metoda koja se poziva prilikom pritiska gumba za uklanjanje vozača iz
     * tima. Uklanja odabranog vozača iz tima i vraća ga u listu dostupnih
     * vozača.
     */
    private void btnUkloniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniActionPerformed
        if (lstVozaciUTimu.getSelectedValue() == null) {
            return;
        }

        var v = lstVozaciUTimu.getSelectedValue();

        DefaultListModel<Vozaci> m = (DefaultListModel<Vozaci>) lstVozaciUTimu.getModel();
        m.removeElement(v);

        DefaultListModel<Vozaci> b = (DefaultListModel<Vozaci>) lstVozaciUBazi.getModel();
        b.addElement(v);

        try {
            prozorTimovi.getObradaTimovi().ukloniIzTima(v);
        } catch (EdunovaException ex) {
            ex.printStackTrace();
            // Ovdje možeš dodati odgovarajuću obradu iznimke ako je potrebno
            return;
        }
        prozorTimovi.popuniView();
        prikaziDostupneVozace();
    }//GEN-LAST:event_btnUkloniActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnUkloni;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDostupniVozaci;
    private javax.swing.JLabel lblUkupnoDostupnihVozaca;
    private javax.swing.JLabel lblVozaciUTimu;
    private javax.swing.JList<Vozaci> lstVozaciUBazi;
    private javax.swing.JList<Vozaci> lstVozaciUTimu;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
