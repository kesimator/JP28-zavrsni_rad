package formula1.view;

import formula1.util.Alati;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Kesimator
 */
/**
 * Klasa koja predstavlja glavni izbornik aplikacije Formula 1 Manager.
 */
public class Izbornik extends javax.swing.JFrame {

    /**
     * Konstruktor klase Izbornik.
     */
    public Izbornik() {
        initComponents();

        setTitle(Alati.NAZIV_APP + " | IZBORNIK");
        lblOperater.setText(Alati.getOperater());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblOperater = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N

        lblOperater.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        lblOperater.setName(""); // NOI18N
        jToolBar1.add(lblOperater);

        jMenuBar1.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N

        jMenu1.setText("Programi");
        jMenu1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem3.setText("Vozači");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem4.setText("Timovi");
        jMenuItem4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem5.setText("Prvenstva");
        jMenuItem5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ostalo");
        jMenu2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem1.setText("O aplikaciji");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jMenuItem2.setText("Izlaz");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 254, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metoda koja se poziva prilikom odabira opcije Izlaz iz izbornika.
     *
     * @param evt Akcija događaja
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * Metoda koja se poziva prilikom odabira opcije O aplikaciji iz izbornika.
     *
     * @param evt Akcija događaja
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        String putanja = "/f1logo132x55.jpg";
        ImageIcon slika = new ImageIcon(getClass().getResource(putanja));
        JOptionPane.showMessageDialog(getRootPane(), "O aplikaciji\n"
                + "Stvorena za jednostavno praćenje vozača,\n" + "timova, vozača u timovima i prvenstvima.",
                "Aplikacija za podatke o sudionicima Formule 1", JOptionPane.INFORMATION_MESSAGE, slika);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Metoda koja se poziva prilikom odabira opcije Vozači iz izbornika.
     *
     * @param evt Akcija događaja
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ProzorVozaci().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Metoda koja se poziva prilikom odabira opcije Timovi iz izbornika.
     *
     * @param evt Akcija događaja
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new ProzorTimovi().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * Metoda koja se poziva prilikom odabira opcije Prvenstva iz izbornika.
     *
     * @param evt Akcija događaja
     */
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new ProzorPrvenstva().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblOperater;
    // End of variables declaration//GEN-END:variables
}
