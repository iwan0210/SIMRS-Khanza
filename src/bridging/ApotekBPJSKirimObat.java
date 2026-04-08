/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgResepObat.java
 *
 * Created on 31 Mei 10, 11:27:40
 */

package bridging;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;


/**
 *
 * @author perpustakaan
 */
public final class ApotekBPJSKirimObat extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private ApiApotekBPJS api=new ApiApotekBPJS();
    private String URL="",link="",utc="";
    private HttpHeaders headers;
    private HttpEntity requestEntity;
    private ObjectMapper mapper = new ObjectMapper();
    private JsonNode root;
    private JsonNode nameNode;
    private PreparedStatement ps;
    private ResultSet rs;
    private int i=0;
    private String requestJson;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private volatile boolean ceksukses = false;

    /** Creates new form ApotekBPJSKirimResep 
     *@param parent
     *@param modal*/
    public ApotekBPJSKirimObat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(628,674);

        Object[] row={"P", "Kode Obat", "Kode Obat BPJS", "Nama Obat", "Signa 1", "Signa 2", "Jumlah", "Jumlah Hari", "Catatan", "Kode Racik", "Permintaan", "Status", "Aturan Pakai", "PRB", "Kronis", "Kemo", "Hasil"};
        tabMode = new DefaultTableModel(null, row) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return colIndex == 0 || colIndex == 4 || colIndex == 5
                        || colIndex == 6 || colIndex == 7 || colIndex == 8
                        || colIndex == 10;
            }

            Class[] types = new Class[]{
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
        tbResep.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbResep.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbResep.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 17; i++) {
            TableColumn column = tbResep.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(80);
            }else if(i==2){
                column.setPreferredWidth(100);
            }else if(i==3){
                column.setPreferredWidth(180);
            }else if(i==4){
                column.setPreferredWidth(50);
            }else if(i==5){
                column.setPreferredWidth(50);
            }else if(i==6){
                column.setPreferredWidth(50);
            }else if(i==7){
                column.setPreferredWidth(80);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(80);
            }else if(i==10){
                column.setPreferredWidth(80);
            }else if(i==11){
                column.setPreferredWidth(60);
            }else if(i==12){
                column.setPreferredWidth(200);
            }else if(i==13){
                column.setPreferredWidth(40);
            }else if(i==14){
                column.setPreferredWidth(40);
            }else if(i==15){
                column.setPreferredWidth(40);
            }else if(i==16){
                column.setPreferredWidth(200);
            }
        }
        tbResep.setDefaultRenderer(Object.class, new WarnaTable());
        
        
        
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        
        try {
            link=koneksiDB.URLAPIAPOTEKBPJS();
        } catch (Exception e) {
            System.out.println("E : "+e);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbResep = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnKeluar = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel3 = new widget.Label();
        TNoRm = new widget.TextBox();
        jLabel4 = new widget.Label();
        NoSepApt = new widget.TextBox();
        jLabel5 = new widget.Label();
        NoResep = new widget.TextBox();
        jLabel6 = new widget.Label();
        NoResepApt = new widget.TextBox();
        LabelJenisResep = new widget.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Resep Obat ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbResep.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbResep.setName("tbResep"); // NOI18N
        tbResep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbResepMouseClicked(evt);
            }
        });
        tbResep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbResepKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbResepKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbResep);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 50));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Kirim");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(440, 120));
        FormInput.setLayout(null);

        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(98, 12, 120, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(313, 12, 410, 23);

        jLabel3.setText("No.Rawat :");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 12, 95, 23);

        TNoRm.setHighlighter(null);
        TNoRm.setName("TNoRm"); // NOI18N
        TNoRm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRmKeyPressed(evt);
            }
        });
        FormInput.add(TNoRm);
        TNoRm.setBounds(220, 12, 91, 23);

        jLabel4.setText("No. SEP APT :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 50, 95, 23);

        NoSepApt.setHighlighter(null);
        NoSepApt.setName("NoSepApt"); // NOI18N
        NoSepApt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoSepAptKeyPressed(evt);
            }
        });
        FormInput.add(NoSepApt);
        NoSepApt.setBounds(100, 50, 150, 23);

        jLabel5.setText("No. Resep :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(260, 50, 60, 23);

        NoResep.setHighlighter(null);
        NoResep.setName("NoResep"); // NOI18N
        NoResep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoResepKeyPressed(evt);
            }
        });
        FormInput.add(NoResep);
        NoResep.setBounds(330, 50, 100, 23);

        jLabel6.setText("No. Resep APT :");
        jLabel6.setName("jLabel6"); // NOI18N
        FormInput.add(jLabel6);
        jLabel6.setBounds(440, 50, 80, 23);

        NoResepApt.setHighlighter(null);
        NoResepApt.setName("NoResepApt"); // NOI18N
        NoResepApt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoResepAptKeyPressed(evt);
            }
        });
        FormInput.add(NoResepApt);
        NoResepApt.setBounds(530, 50, 80, 23);

        LabelJenisResep.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelJenisResep.setText("Jenis Resep");
        LabelJenisResep.setName("LabelJenisResep"); // NOI18N
        FormInput.add(LabelJenisResep);
        LabelJenisResep.setBounds(620, 50, 150, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
            return;
        }
        
        if(NoSepApt.getText().trim().equals("")){
            Valid.textKosong(NoSepApt,"No.SEP");
            return;
        }
        
        if(NoResepApt.getText().trim().equals("")){
            Valid.textKosong(NoResepApt,"No.Resep");
            return;
        }
        
        for (i=0;i<tbResep.getRowCount();i++) {
            if (tbResep.getValueAt(i, 0).toString().equals("false")) {
                continue;
            }
           
            String col4 = tbResep.getValueAt(i, 4).toString();
            String col5 = tbResep.getValueAt(i, 5).toString();
            String col6 = tbResep.getValueAt(i, 6).toString();
            String col7 = tbResep.getValueAt(i, 7).toString();
            String col9 = tbResep.getValueAt(i, 9).toString();
            String col10 = tbResep.getValueAt(i, 10).toString();

            boolean dataObatLengkap
                    = !col4.isEmpty()
                    && !col5.isEmpty()
                    && !col6.isEmpty()
                    && !col7.isEmpty();

            if (!dataObatLengkap) {
                continue;
            }

            // non racikan
            if (col9.isEmpty()) {
                kirimNonRacik(i);
            } // racikan
            else if (!col10.isEmpty()) {
               kirimRacik(i);
            }
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void tbResepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResepMouseClicked
        
}//GEN-LAST:event_tbResepMouseClicked

    private void tbResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResepKeyPressed
        
}//GEN-LAST:event_tbResepKeyPressed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        
    }//GEN-LAST:event_TNoRwKeyPressed

    private void TNoRmKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRmKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRmKeyPressed

    private void NoResepUbahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoResepUbahKeyPressed
        Valid.pindah(evt, BtnKeluar, BtnSimpan);
    }//GEN-LAST:event_NoResepUbahKeyPressed

    private void BtnSimpan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan3ActionPerformed
       
    }//GEN-LAST:event_BtnSimpan3ActionPerformed

    private void BtnKeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluar1ActionPerformed
        
    }//GEN-LAST:event_BtnKeluar1ActionPerformed

    private void tbTambahanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTambahanKeyPressed
                  
    }//GEN-LAST:event_tbTambahanKeyPressed

    private void tbTambahan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTambahan1KeyPressed
        
    }//GEN-LAST:event_tbTambahan1KeyPressed

    private void NoResepUbah1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoResepUbah1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoResepUbah1KeyPressed

    private void BtnSimpan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan4ActionPerformed
       
    }//GEN-LAST:event_BtnSimpan4ActionPerformed

    private void BtnKeluar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluar2ActionPerformed
        
    }//GEN-LAST:event_BtnKeluar2ActionPerformed

    private void tbResepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResepKeyReleased
        
    }//GEN-LAST:event_tbResepKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void NoSepAptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoSepAptKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSepAptKeyPressed

    private void NoResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoResepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoResepKeyPressed

    private void NoResepAptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoResepAptKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoResepAptKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ApotekBPJSKirimObat dialog = new ApotekBPJSKirimObat(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.PanelBiasa FormInput;
    private widget.Label LabelJenisResep;
    private widget.TextBox NoResep;
    private widget.TextBox NoResepApt;
    private widget.TextBox NoSepApt;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private widget.TextBox TNoRm;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel3;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private javax.swing.JPanel jPanel3;
    private widget.panelisi panelGlass8;
    private widget.Table tbResep;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        
        // Obat Non-racik
        try {

            ps = koneksi.prepareStatement(
                    "select "
                    + "    databarang.kode_brng, "
                    + "    maping_obat_apotek_bpjs.kode_brng_apotek_bpjs, "
                    + "    maping_obat_apotek_bpjs.nama_brng_apotek_bpjs, "
                    + "    maping_obat_apotek_bpjs.prb, "
                    + "    maping_obat_apotek_bpjs.kronis, "
                    + "    maping_obat_apotek_bpjs.kemo, "
                    + "    detail_pemberian_obat.jml, "
                    + "    aturan_pakai.aturan, "
                    + "    case "
                    + "        when bridging_resep_apotek_bpjs_nonracikan.kode_brng is not null "
                    + "        then 'Sudah' "
                    + "        else 'Belum' "
                    + "    end as status_kirim "
                    + "from detail_pemberian_obat "
                    + "inner join databarang "
                    + "    on detail_pemberian_obat.kode_brng = databarang.kode_brng "
                    + "inner join maping_obat_apotek_bpjs "
                    + "    on maping_obat_apotek_bpjs.kode_brng = databarang.kode_brng "
                    + "inner join resep_obat "
                    + "    on resep_obat.tgl_perawatan = detail_pemberian_obat.tgl_perawatan "
                    + "    and resep_obat.jam = detail_pemberian_obat.jam "
                    + "    and resep_obat.no_rawat = detail_pemberian_obat.no_rawat "
                    + "inner join aturan_pakai "
                    + "    on aturan_pakai.tgl_perawatan = detail_pemberian_obat.tgl_perawatan "
                    + "    and aturan_pakai.jam = detail_pemberian_obat.jam "
                    + "    and aturan_pakai.no_rawat = detail_pemberian_obat.no_rawat "
                    + "    and aturan_pakai.kode_brng = detail_pemberian_obat.kode_brng "
                    + "left join bridging_resep_apotek_bpjs_nonracikan "
                    + "    on bridging_resep_apotek_bpjs_nonracikan.kode_brng = detail_pemberian_obat.kode_brng "
                    + "    and bridging_resep_apotek_bpjs_nonracikan.no_sep_apotek = ? "
                    + "where resep_obat.no_resep = ? "
                    + "and databarang.kode_brng not in ( "
                    + "    select detail_obat_racikan.kode_brng "
                    + "    from detail_obat_racikan "
                    + "    where detail_obat_racikan.tgl_perawatan = detail_pemberian_obat.tgl_perawatan "
                    + "    and detail_obat_racikan.jam = detail_pemberian_obat.jam "
                    + "    and detail_obat_racikan.no_rawat = detail_pemberian_obat.no_rawat "
                    + ") "
                    + "order by databarang.kode_brng"
            );
            
            try {
                ps.setString(1, NoSepApt.getText());
                ps.setString(2, NoResep.getText());
                rs = ps.executeQuery();
                while(rs.next()) {
                    tabMode.addRow(new Object[] {
                        false,rs.getString("kode_brng"),rs.getString("kode_brng_apotek_bpjs"),rs.getString("nama_brng_apotek_bpjs"),
                        hitungSigna1(rs.getString("jml")),hitungSigna2(rs.getString("jml")),rs.getString("jml"),30,"","","",
                        rs.getString("status_kirim"),rs.getString("aturan"),getBooleanValue(rs.getInt("prb")),getBooleanValue(rs.getInt("kronis")),
                        getBooleanValue(rs.getInt("kemo")),""
                    });
                }
            } catch(Exception ex){
                System.out.println("Notifikasi : "+ex);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
        
        // Obat Racikan
        try {
            ps = koneksi.prepareStatement(
                    "select "
                    + "    detail_obat_racikan.no_racik, "
                    + "    obat_racikan.jml_dr, "
                    + "    obat_racikan.aturan_pakai, "
                    + "    databarang.kode_brng, "
                    + "    databarang.nama_brng, "
                    + "    maping_obat_apotek_bpjs.kode_brng_apotek_bpjs, "
                    + "    maping_obat_apotek_bpjs.nama_brng_apotek_bpjs, "
                    + "    maping_obat_apotek_bpjs.prb, "
                    + "    maping_obat_apotek_bpjs.kronis, "
                    + "    maping_obat_apotek_bpjs.kemo, "
                    + "    detail_pemberian_obat.jml, "
                    + "    case "
                    + "        when bridging_resep_apotek_bpjs_racikan.kode_brng is not null "
                    + "        then 'Sudah' "
                    + "        else 'Belum' "
                    + "    end as status_kirim "
                    + "from resep_obat "
                    + "inner join detail_pemberian_obat "
                    + "    on resep_obat.tgl_perawatan = detail_pemberian_obat.tgl_perawatan "
                    + "    and resep_obat.jam = detail_pemberian_obat.jam "
                    + "    and resep_obat.no_rawat = detail_pemberian_obat.no_rawat "
                    + "inner join detail_obat_racikan "
                    + "    on detail_pemberian_obat.kode_brng = detail_obat_racikan.kode_brng "
                    + "    and detail_pemberian_obat.tgl_perawatan = detail_obat_racikan.tgl_perawatan "
                    + "    and detail_pemberian_obat.jam = detail_obat_racikan.jam "
                    + "    and detail_pemberian_obat.no_rawat = detail_obat_racikan.no_rawat "
                    + "inner join obat_racikan "
                    + "    on obat_racikan.no_rawat = detail_obat_racikan.no_rawat "
                    + "    and obat_racikan.tgl_perawatan = detail_obat_racikan.tgl_perawatan "
                    + "    and obat_racikan.jam = detail_obat_racikan.jam "
                    + "    and obat_racikan.no_racik = detail_obat_racikan.no_racik "
                    + "inner join databarang "
                    + "    on detail_pemberian_obat.kode_brng = databarang.kode_brng "
                    + "inner join maping_obat_apotek_bpjs "
                    + "    on maping_obat_apotek_bpjs.kode_brng = databarang.kode_brng "
                    + "left join bridging_resep_apotek_bpjs_racikan "
                    + "    on bridging_resep_apotek_bpjs_racikan.kode_brng = detail_pemberian_obat.kode_brng "
                    + "    and bridging_resep_apotek_bpjs_racikan.no_sep_apotek = ? "
                    + "where resep_obat.no_resep = ? "
                    + "order by detail_obat_racikan.no_racik, databarang.kode_brng"
            );

            try {
                ps.setString(1, NoSepApt.getText());
                ps.setString(2, NoResep.getText());
                rs = ps.executeQuery();
                while(rs.next()) {
                    tabMode.addRow(new Object[] {
                        false,rs.getString("kode_brng"),rs.getString("kode_brng_apotek_bpjs"),rs.getString("nama_brng_apotek_bpjs"),
                        hitungSigna1(rs.getString("jml_dr")),hitungSigna2(rs.getString("jml_dr")),rs.getString("jml"),30,"",
                        "R.0"+rs.getString("no_racik"),rs.getString("jml_dr"),rs.getString("status_kirim"),rs.getString("aturan_pakai"),
                        getBooleanValue(rs.getInt("prb")),getBooleanValue(rs.getInt("kronis")),getBooleanValue(rs.getInt("kemo")),""
                    });
                }
            } catch(Exception ex){
                System.out.println("Notifikasi : "+ex);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
    }
   
    public void setNoRm(String norwt, String norm, String nama, String nosepapt, String noresep) {
        TNoRw.setText(norwt);
        TNoRm.setText(norm);
        TPasien.setText(nama);
        NoSepApt.setText(nosepapt);
        NoResep.setText(noresep);
        Sequel.cariIsi("select no_resep_apotek from bridging_resep_apotek_bpjs where no_sep_apotek = ?", NoResepApt, nosepapt);
        LabelJenisResep.setText(Sequel.cariIsi("select kdjenis from bridging_resep_apotek_bpjs where no_sep_apotek = ?", nosepapt).substring(3));
        
        runBackground(() -> tampil());
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(akses.getresep_obat());
    }
    
    private void runBackground(Runnable task) {
        if (ceksukses) return;
        ceksukses = true;

        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        executor.submit(() -> {
            try {
                task.run();
            } finally {
                ceksukses = false;
                SwingUtilities.invokeLater(() -> {
                    this.setCursor(Cursor.getDefaultCursor());
                });
            }
        });
    }
    
    private int hitungSigna1(String jumlah) {
        try {
            int jml = Integer.parseInt(jumlah);
            return Math.max(1, jml / 30);
        } catch (NumberFormatException e) {
            return 1;
        }
    }
    
    private String hitungSigna2(String jumlah) {
        if ("15".equals(jumlah)) {
            return "0.5";
        }
        return "1";
    }
    
    private void kirimNonRacik(int index) {
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("x-cons-id", koneksiDB.CONSIDAPIAPOTEKBPJS());
            utc = String.valueOf(api.GetUTCdatetimeAsString());
            headers.add("x-timestamp", utc);
            headers.add("x-signature", api.getHmac(utc));
            headers.add("user_key", koneksiDB.USERKEYAPIAPOTEKBPJS());
            URL = link + "/obatnonracikan/v3/insert";
            requestJson = "{"
                    + "\"NOSJP\":\"" + NoSepApt.getText() + "\","
                    + "\"NORESEP\":\"" + NoResepApt.getText() + "\","
                    + "\"KDOBT\":\"" + tbResep.getValueAt(index, 2) + "\","
                    + "\"NMOBAT\":\"" + tbResep.getValueAt(index, 3) + "\","
                    + "\"SIGNA1OBT\":\"" + tbResep.getValueAt(index, 4) + "\","
                    + "\"SIGNA2OBT\":\"" + tbResep.getValueAt(index, 5) + "\","
                    + "\"JMLOBT\":\"" + tbResep.getValueAt(index, 6) + "\","
                    + "\"JHO\":\"" + tbResep.getValueAt(index, 7) + "\","
                    + "\"CatKhsObt\":\"" + tbResep.getValueAt(index, 8) + "\""
                    + "}";
            System.out.println("Request URL : " + URL);
            System.out.println("JSON : " + requestJson);
            requestEntity = new HttpEntity(requestJson, headers);
            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            nameNode = root.path("metaData");
            System.out.println("Response : " + root.toString());
            if(nameNode.path("code").asText().equals("200")){
                if (Sequel.menyimpantf2("bridging_resep_apotek_bpjs_nonracikan", "?,?,?,?,?,?,?", 7, new String[] {
                    NoSepApt.getText(),tbResep.getValueAt(index, 1).toString(),tbResep.getValueAt(index, 4).toString(),
                    tbResep.getValueAt(index, 5).toString(),tbResep.getValueAt(index, 6).toString(),
                    tbResep.getValueAt(index, 7).toString(),tbResep.getValueAt(index, 8).toString()
                })) {
                    tbResep.setValueAt("Sudah", index, 11);
                    tbResep.setValueAt(false, index, 0);
                }
            }
            
            tbResep.setValueAt(nameNode.path("message").asText(), index, 16);
        } catch (Exception ex) {
            System.out.println("Notifikasi : "+ex);
            if(ex.toString().contains("UnknownHostException")){
                JOptionPane.showMessageDialog(rootPane,"Koneksi ke server BPJS terputus...!");
            }
        }
    }
    
    private void kirimRacik(int index) {
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("x-cons-id", koneksiDB.CONSIDAPIAPOTEKBPJS());
            utc = String.valueOf(api.GetUTCdatetimeAsString());
            headers.add("x-timestamp", utc);
            headers.add("x-signature", api.getHmac(utc));
            headers.add("user_key", koneksiDB.USERKEYAPIAPOTEKBPJS());
            URL = link + "/obatracikan/v3/insert";
            requestJson = "{"
                    + "\"NOSJP\":\"" + NoSepApt.getText() + "\","
                    + "\"NORESEP\":\"" + NoResepApt.getText() + "\","
                    + "\"JNSROBT\":\"" + tbResep.getValueAt(index, 9) + "\","
                    + "\"KDOBT\":\"" + tbResep.getValueAt(index, 2) + "\","
                    + "\"NMOBAT\":\"" + tbResep.getValueAt(index, 3) + "\","
                    + "\"SIGNA1OBT\":\"" + tbResep.getValueAt(index, 4) + "\","
                    + "\"SIGNA2OBT\":\"" + tbResep.getValueAt(index, 5) + "\","
                    + "\"PERMINTAAN\":\"" + tbResep.getValueAt(index, 10) + "\","
                    + "\"JMLOBT\":\"" + tbResep.getValueAt(index, 6) + "\","
                    + "\"JHO\":\"" + tbResep.getValueAt(index, 7) + "\","
                    + "\"CatKhsObt\":\"" + tbResep.getValueAt(index, 8) + "\""
                    + "}";
            System.out.println("Request URL : " + URL);
            System.out.println("JSON : " + requestJson);
            requestEntity = new HttpEntity(requestJson, headers);
            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            nameNode = root.path("metaData");
            System.out.println("Response : " + root.toString());
            if(nameNode.path("code").asText().equals("200")){
                if (Sequel.menyimpantf2("bridging_resep_apotek_bpjs_racikan", "?,?,?,?,?,?,?,?,?", 9, new String[] {
                    NoSepApt.getText(),tbResep.getValueAt(index, 9).toString(),tbResep.getValueAt(index, 1).toString(),tbResep.getValueAt(index, 4).toString(),
                    tbResep.getValueAt(index, 5).toString(),tbResep.getValueAt(index, 6).toString(),tbResep.getValueAt(index, 10).toString(),
                    tbResep.getValueAt(index, 7).toString(),tbResep.getValueAt(index, 8).toString()
                })) {
                    tbResep.setValueAt("Sudah", index, 11);
                    tbResep.setValueAt(false, index, 0);
                }
            }
            
            tbResep.setValueAt(nameNode.path("message").asText(), index, 16);
        } catch (Exception ex) {
            System.out.println("Notifikasi : "+ex);
            if(ex.toString().contains("UnknownHostException")){
                JOptionPane.showMessageDialog(rootPane,"Koneksi ke server BPJS terputus...!");
            }
        }
    }
    
    private String getBooleanValue(int value) {
        if (value == 0) {
            return "Tidak";
        }
        
        return "Ya";
    }
}
