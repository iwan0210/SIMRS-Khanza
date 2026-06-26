/*
 * By Mas Elkhanza
 */
package rekammedis;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariDokter;

/**
 *
 * @author perpustakaan
 */
public final class RMMonitoringDiRecoveryRoom extends javax.swing.JDialog {

    private final DefaultTableModel tabMode, tabModeRiwayatMonitoring;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0, pilihan = 0;
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    private String finger = "", finger1 = "";

    /**
     * Creates new form DlgRujuk
     *
     * @param parent
     * @param modal
     */
    public RMMonitoringDiRecoveryRoom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "Jam Mulai", "Jam Selesai",
            "Kode Dokter", "Nama Dokter", "Kode dr Anestesi", "Nama dr Anestesi",
            "TD", "NADI", "RR", "Suhu", "kesadaran", "pernafasan", "komplikasi_akut",
            "penyulit", "penanganan", "transfer ke", "skor"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

        };

        tbObat.setModel(tabMode);
        tbObat.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 20; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(105);
            } else if (i == 1) {
                column.setPreferredWidth(70);
            } else if (i == 2) {
                column.setPreferredWidth(150);
            } else if (i == 3) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 4) {
                column.setPreferredWidth(105);
            } else if (i == 5) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 6) {
                column.setPreferredWidth(150);
            } else if (i == 7) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 8) {
                column.setPreferredWidth(150);
            } else if (i == 9) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 10) {
                column.setPreferredWidth(67);
            } else if (i == 11) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 12) {
                column.setPreferredWidth(150);
            } else if (i == 13) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 14) {
                column.setPreferredWidth(215);
            } else if (i == 15) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 16) {
                column.setPreferredWidth(250);
            } else if (i == 17) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 18) {
                column.setPreferredWidth(95);
            } else if (i == 19) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
        tabModeRiwayatMonitoring = new DefaultTableModel(null, new Object[]{
            "id", "No", "Jam Monitor", "TD", "Nadi", "Suhu", "RR", "Kesadaran", "Saturasi"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbRiwayatMonitoring.setModel(tabModeRiwayatMonitoring);

        tbRiwayatMonitoring.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbRiwayatMonitoring.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 9; i++) {  // mulai dari 1, skip kolom id
            TableColumn column = tbRiwayatMonitoring.getColumnModel().getColumn(i);
            if (i == 0) {
               column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 1) {
                column.setPreferredWidth(30);   // Jam Monitor
            } else if (i == 2) {
                column.setPreferredWidth(65);   // Jam Monitor
            } else if (i == 3) {
                column.setPreferredWidth(65);  // TD
            } else if (i == 4) {
                column.setPreferredWidth(65);   // Nadi
            } else if (i == 5) {
                column.setPreferredWidth(65);  // Suhu
            } else if (i == 6) {
                column.setPreferredWidth(65);  // RR
            } else if (i == 7) {
                column.setPreferredWidth(80);  // Kesadaran
            } else if (i == 8) {
                column.setPreferredWidth(65);   // Saturasi
            }
        }
        tbRiwayatMonitoring.setDefaultRenderer(Object.class, new WarnaTable());

        TNoRw.setDocument(new batasInput((byte) 17).getKata(TNoRw));

        if (koneksiDB.CARICEPAT().equals("aktif")) {
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        tampil();
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        tampil();
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        tampil();
                    }
                }
            });
        }

        dokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (dokter.getTable().getSelectedRow() != -1) {
                    if (pilihan == 1) {
                        kdanestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmanestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kdanestesi.requestFocus();
                    } else if (pilihan == 2) {
                        KdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        NmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        KdDokter.requestFocus();
                    }
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        DlgRiwayatMonitoring.setSize(800, 300);

        // SESUDAH
        if (!TNoRw.getText().trim().isEmpty()) {
            tampilPersalinan();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnLaporanMonitoring = new javax.swing.JMenuItem();
        DlgRiwayatMonitoring = new javax.swing.JDialog();
        internalFrame4 = new widget.InternalFrame();
        panelBiasa2 = new widget.PanelBiasa();
        jLabel100 = new widget.Label();
        BtnKeluarKehamilan = new widget.Button();
        BtnSimpanRiwayatKehamilan = new widget.Button();
        jLabel108 = new widget.Label();
        td1 = new widget.TextBox();
        jLabel109 = new widget.Label();
        nadi1 = new widget.TextBox();
        jLabel111 = new widget.Label();
        suhu1 = new widget.TextBox();
        jLabel113 = new widget.Label();
        rr1 = new widget.TextBox();
        jLabel114 = new widget.Label();
        saturasi = new widget.TextBox();
        jLabel115 = new widget.Label();
        kesadaran1 = new widget.TextBox();
        cmbJam2 = new widget.ComboBox();
        cmbMnt2 = new widget.ComboBox();
        cmbDtk2 = new widget.ComboBox();
        internalFrame1 = new widget.InternalFrame();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        TabRawat = new javax.swing.JTabbedPane();
        internalFrame2 = new widget.InternalFrame();
        scrollInput = new widget.ScrollPane();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        jLabel15 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        label14 = new widget.Label();
        KdDokter = new widget.TextBox();
        NmDokter = new widget.TextBox();
        BtnDokter = new widget.Button();
        label29 = new widget.Label();
        kdanestesi = new widget.TextBox();
        nmanestesi = new widget.TextBox();
        BtnAnastesi = new widget.Button();
        jLabel23 = new widget.Label();
        jLabel24 = new widget.Label();
        suhu = new widget.TextBox();
        jLabel34 = new widget.Label();
        rr = new widget.TextBox();
        jLabel12 = new widget.Label();
        nadi = new widget.TextBox();
        jLabel31 = new widget.Label();
        td = new widget.TextBox();
        label22 = new widget.Label();
        jLabel33 = new widget.Label();
        jLabel32 = new widget.Label();
        kesadaran = new widget.ComboBox();
        jLabel30 = new widget.Label();
        pernafasan = new widget.ComboBox();
        jLabel17 = new widget.Label();
        komplikasi = new widget.TextBox();
        jLabel37 = new widget.Label();
        penanganan = new widget.TextArea();
        jLabel38 = new widget.Label();
        nrs = new widget.TextBox();
        penyulit = new widget.TextArea();
        jLabel36 = new widget.Label();
        transfer = new widget.ComboBox();
        jLabel35 = new widget.Label();
        tgl_mulai = new widget.Tanggal();
        cmbJam = new widget.ComboBox();
        cmbMnt = new widget.ComboBox();
        cmbDtk = new widget.ComboBox();
        tgl_selesai = new widget.Tanggal();
        cmbJam1 = new widget.ComboBox();
        cmbMnt1 = new widget.ComboBox();
        cmbDtk1 = new widget.ComboBox();
        BtnTambahMonitoring = new widget.Button();
        BtnHapusRiwayatPersalinan = new widget.Button();
        Scroll6 = new widget.ScrollPane();
        tbRiwayatMonitoring = new widget.Table();
        PanelWall = new usu.widget.glass.PanelGlass();
        internalFrame3 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbObat = new widget.Table();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnLaporanMonitoring.setBackground(new java.awt.Color(255, 255, 254));
        MnLaporanMonitoring.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnLaporanMonitoring.setForeground(new java.awt.Color(50, 50, 50));
        MnLaporanMonitoring.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnLaporanMonitoring.setLabel("Laporan Monitoring Pemulihan Di Recovery Room");
        MnLaporanMonitoring.setName("MnLaporanMonitoring"); // NOI18N
        MnLaporanMonitoring.setPreferredSize(new java.awt.Dimension(220, 26));
        MnLaporanMonitoring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnLaporanMonitoringActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnLaporanMonitoring);

        DlgRiwayatMonitoring.setName("DlgRiwayatMonitoring"); // NOI18N

        internalFrame4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "::[ Riwayat Persalinan Ibu Bayi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 50))); // NOI18N
        internalFrame4.setMinimumSize(new java.awt.Dimension(719, 300));
        internalFrame4.setName("internalFrame4"); // NOI18N
        internalFrame4.setPreferredSize(new java.awt.Dimension(200, 200));
        internalFrame4.setLayout(new java.awt.BorderLayout(1, 1));

        panelBiasa2.setMinimumSize(new java.awt.Dimension(700, 300));
        panelBiasa2.setName("panelBiasa2"); // NOI18N
        panelBiasa2.setPreferredSize(new java.awt.Dimension(700, 300));
        panelBiasa2.setLayout(null);

        jLabel100.setText("TD :");
        jLabel100.setName("jLabel100"); // NOI18N
        panelBiasa2.add(jLabel100);
        jLabel100.setBounds(0, 10, 110, 23);

        BtnKeluarKehamilan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnKeluarKehamilan.setMnemonic('U');
        BtnKeluarKehamilan.setText("Tutup");
        BtnKeluarKehamilan.setToolTipText("Alt+U");
        BtnKeluarKehamilan.setName("BtnKeluarKehamilan"); // NOI18N
        BtnKeluarKehamilan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluarKehamilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarKehamilanActionPerformed(evt);
            }
        });
        panelBiasa2.add(BtnKeluarKehamilan);
        BtnKeluarKehamilan.setBounds(400, 190, 100, 30);

        BtnSimpanRiwayatKehamilan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpanRiwayatKehamilan.setMnemonic('S');
        BtnSimpanRiwayatKehamilan.setText("Simpan");
        BtnSimpanRiwayatKehamilan.setToolTipText("Alt+S");
        BtnSimpanRiwayatKehamilan.setName("BtnSimpanRiwayatKehamilan"); // NOI18N
        BtnSimpanRiwayatKehamilan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanRiwayatKehamilanActionPerformed(evt);
            }
        });
        panelBiasa2.add(BtnSimpanRiwayatKehamilan);
        BtnSimpanRiwayatKehamilan.setBounds(210, 190, 100, 30);

        jLabel108.setText("Waktu Monitoring :");
        jLabel108.setName("jLabel108"); // NOI18N
        panelBiasa2.add(jLabel108);
        jLabel108.setBounds(370, 20, 96, 20);

        td1.setHighlighter(null);
        td1.setName("td1"); // NOI18N
        td1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                td1KeyPressed(evt);
            }
        });
        panelBiasa2.add(td1);
        td1.setBounds(120, 10, 120, 23);

        jLabel109.setText("Nadi :");
        jLabel109.setName("jLabel109"); // NOI18N
        panelBiasa2.add(jLabel109);
        jLabel109.setBounds(0, 40, 110, 23);

        nadi1.setHighlighter(null);
        nadi1.setName("nadi1"); // NOI18N
        nadi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nadi1KeyPressed(evt);
            }
        });
        panelBiasa2.add(nadi1);
        nadi1.setBounds(120, 40, 120, 23);

        jLabel111.setText("Suhu :");
        jLabel111.setName("jLabel111"); // NOI18N
        panelBiasa2.add(jLabel111);
        jLabel111.setBounds(0, 70, 110, 23);

        suhu1.setHighlighter(null);
        suhu1.setName("suhu1"); // NOI18N
        suhu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                suhu1KeyPressed(evt);
            }
        });
        panelBiasa2.add(suhu1);
        suhu1.setBounds(120, 70, 120, 23);

        jLabel113.setText("rr :");
        jLabel113.setName("jLabel113"); // NOI18N
        panelBiasa2.add(jLabel113);
        jLabel113.setBounds(0, 100, 110, 23);

        rr1.setHighlighter(null);
        rr1.setName("rr1"); // NOI18N
        rr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rr1KeyPressed(evt);
            }
        });
        panelBiasa2.add(rr1);
        rr1.setBounds(120, 100, 120, 23);

        jLabel114.setText("Saturasi :");
        jLabel114.setName("jLabel114"); // NOI18N
        panelBiasa2.add(jLabel114);
        jLabel114.setBounds(0, 160, 110, 23);

        saturasi.setHighlighter(null);
        saturasi.setName("saturasi"); // NOI18N
        saturasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                saturasiKeyPressed(evt);
            }
        });
        panelBiasa2.add(saturasi);
        saturasi.setBounds(120, 160, 120, 23);

        jLabel115.setText("Kesadaran :");
        jLabel115.setName("jLabel115"); // NOI18N
        panelBiasa2.add(jLabel115);
        jLabel115.setBounds(0, 130, 110, 23);

        kesadaran1.setHighlighter(null);
        kesadaran1.setName("kesadaran1"); // NOI18N
        kesadaran1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kesadaran1KeyPressed(evt);
            }
        });
        panelBiasa2.add(kesadaran1);
        kesadaran1.setBounds(120, 130, 120, 23);

        cmbJam2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam2.setName("cmbJam2"); // NOI18N
        cmbJam2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam2KeyPressed(evt);
            }
        });
        panelBiasa2.add(cmbJam2);
        cmbJam2.setBounds(470, 20, 62, 23);

        cmbMnt2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt2.setName("cmbMnt2"); // NOI18N
        cmbMnt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt2KeyPressed(evt);
            }
        });
        panelBiasa2.add(cmbMnt2);
        cmbMnt2.setBounds(540, 20, 62, 23);

        cmbDtk2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk2.setName("cmbDtk2"); // NOI18N
        cmbDtk2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk2KeyPressed(evt);
            }
        });
        panelBiasa2.add(cmbDtk2);
        cmbDtk2.setBounds(610, 20, 62, 23);

        internalFrame4.add(panelBiasa2, java.awt.BorderLayout.CENTER);

        DlgRiwayatMonitoring.getContentPane().add(internalFrame4, java.awt.BorderLayout.CENTER);
        internalFrame4.getAccessibleContext().setAccessibleName("::[ Riwayat Monitoring di Recovery Room ]::");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Monitoring di Recovery Room ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setPreferredSize(new java.awt.Dimension(467, 500));
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 54));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
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

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

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

        internalFrame1.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        TabRawat.setBackground(new java.awt.Color(254, 255, 254));
        TabRawat.setForeground(new java.awt.Color(50, 50, 50));
        TabRawat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TabRawat.setMinimumSize(new java.awt.Dimension(554, 133));
        TabRawat.setName("TabRawat"); // NOI18N
        TabRawat.setPreferredSize(new java.awt.Dimension(457, 480));

        internalFrame2.setBorder(null);
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setPreferredSize(new java.awt.Dimension(102, 480));
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        scrollInput.setName("scrollInput"); // NOI18N
        scrollInput.setPreferredSize(new java.awt.Dimension(91, 300));

        FormInput.setBackground(new java.awt.Color(255, 255, 255));
        FormInput.setBorder(null);
        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(1440, 585));
        FormInput.setLayout(null);

        jLabel3.setText("No.Rawat :");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 10, 70, 23);

        jLabel15.setText("No.Rawat :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(0, 10, 70, 23);

        TNoRw.setEditable(false);
        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        FormInput.add(TNoRw);
        TNoRw.setBounds(90, 10, 130, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        FormInput.add(TNoRM);
        TNoRM.setBounds(230, 10, 80, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(310, 10, 430, 23);

        label14.setText("Dokter :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label14);
        label14.setBounds(390, 50, 50, 23);

        KdDokter.setEditable(false);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.setPreferredSize(new java.awt.Dimension(80, 23));
        FormInput.add(KdDokter);
        KdDokter.setBounds(450, 50, 70, 23);

        NmDokter.setEditable(false);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(NmDokter);
        NmDokter.setBounds(520, 50, 190, 23);

        BtnDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnDokter.setMnemonic('2');
        BtnDokter.setToolTipText("Alt+2");
        BtnDokter.setName("BtnDokter"); // NOI18N
        BtnDokter.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDokterActionPerformed(evt);
            }
        });
        FormInput.add(BtnDokter);
        BtnDokter.setBounds(710, 50, 28, 23);

        label29.setText("dr Anestesi :");
        label29.setName("label29"); // NOI18N
        label29.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label29);
        label29.setBounds(20, 50, 60, 20);

        kdanestesi.setEditable(false);
        kdanestesi.setName("kdanestesi"); // NOI18N
        kdanestesi.setPreferredSize(new java.awt.Dimension(80, 23));
        FormInput.add(kdanestesi);
        kdanestesi.setBounds(90, 50, 70, 20);

        nmanestesi.setEditable(false);
        nmanestesi.setName("nmanestesi"); // NOI18N
        nmanestesi.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmanestesi);
        nmanestesi.setBounds(160, 50, 190, 20);

        BtnAnastesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnAnastesi.setMnemonic('2');
        BtnAnastesi.setToolTipText("Alt+2");
        BtnAnastesi.setName("BtnAnastesi"); // NOI18N
        BtnAnastesi.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAnastesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnastesiActionPerformed(evt);
            }
        });
        FormInput.add(BtnAnastesi);
        BtnAnastesi.setBounds(350, 50, 28, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Keluar Kamar Puliih:");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(770, 40, 100, 23);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Masuk Kamar Pulih :");
        jLabel24.setName("jLabel24"); // NOI18N
        FormInput.add(jLabel24);
        jLabel24.setBounds(770, 10, 100, 23);

        suhu.setHighlighter(null);
        suhu.setName("suhu"); // NOI18N
        FormInput.add(suhu);
        suhu.setBounds(460, 100, 80, 23);

        jLabel34.setText("Suhu :");
        jLabel34.setName("jLabel34"); // NOI18N
        FormInput.add(jLabel34);
        jLabel34.setBounds(410, 100, 40, 23);

        rr.setHighlighter(null);
        rr.setName("rr"); // NOI18N
        FormInput.add(rr);
        rr.setBounds(320, 100, 80, 23);

        jLabel12.setText("RR :");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(280, 100, 30, 23);

        nadi.setHighlighter(null);
        nadi.setName("nadi"); // NOI18N
        FormInput.add(nadi);
        nadi.setBounds(190, 100, 80, 23);

        jLabel31.setText("Nadi :");
        jLabel31.setName("jLabel31"); // NOI18N
        FormInput.add(jLabel31);
        jLabel31.setBounds(150, 100, 30, 23);

        td.setHighlighter(null);
        td.setName("td"); // NOI18N
        FormInput.add(td);
        td.setBounds(60, 100, 80, 23);

        label22.setText("I.Tanda Vital");
        label22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label22.setName("label22"); // NOI18N
        label22.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label22);
        label22.setBounds(-10, 80, 90, 23);

        jLabel33.setText("TD :");
        jLabel33.setName("jLabel33"); // NOI18N
        FormInput.add(jLabel33);
        jLabel33.setBounds(20, 100, 30, 23);

        jLabel32.setText("Kesadaran :");
        jLabel32.setName("jLabel32"); // NOI18N
        FormInput.add(jLabel32);
        jLabel32.setBounds(0, 140, 80, 23);

        kesadaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sadar Betul", "Belum Sadar", "Tidur Dalam" }));
        kesadaran.setName("kesadaran"); // NOI18N
        FormInput.add(kesadaran);
        kesadaran.setBounds(90, 140, 100, 23);

        jLabel30.setText("Pernafasan :");
        jLabel30.setName("jLabel30"); // NOI18N
        FormInput.add(jLabel30);
        jLabel30.setBounds(0, 170, 80, 23);

        pernafasan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spontan", "DIbantu" }));
        pernafasan.setName("pernafasan"); // NOI18N
        FormInput.add(pernafasan);
        pernafasan.setBounds(90, 170, 100, 23);

        jLabel17.setText("Komplikasi Akut:");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(10, 200, 80, 23);

        komplikasi.setHighlighter(null);
        komplikasi.setName("komplikasi"); // NOI18N
        FormInput.add(komplikasi);
        komplikasi.setBounds(100, 200, 150, 23);

        jLabel37.setText("Penanganan:");
        jLabel37.setName("jLabel37"); // NOI18N
        FormInput.add(jLabel37);
        jLabel37.setBounds(20, 240, 70, 23);

        penanganan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        penanganan.setColumns(20);
        penanganan.setRows(5);
        penanganan.setName("penanganan"); // NOI18N
        FormInput.add(penanganan);
        penanganan.setBounds(100, 230, 160, 80);

        jLabel38.setText("SKor Skala NRS:");
        jLabel38.setName("jLabel38"); // NOI18N
        FormInput.add(jLabel38);
        jLabel38.setBounds(590, 150, 90, 23);

        nrs.setHighlighter(null);
        nrs.setName("nrs"); // NOI18N
        FormInput.add(nrs);
        nrs.setBounds(690, 150, 80, 23);

        penyulit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        penyulit.setColumns(20);
        penyulit.setRows(5);
        penyulit.setName("penyulit"); // NOI18N
        FormInput.add(penyulit);
        penyulit.setBounds(290, 160, 162, 72);

        jLabel36.setText("Penyulit Intra Operatif:");
        jLabel36.setName("jLabel36"); // NOI18N
        FormInput.add(jLabel36);
        jLabel36.setBounds(280, 140, 120, 23);

        transfer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rawat Inap", "HCU", "Pulang" }));
        transfer.setName("transfer"); // NOI18N
        FormInput.add(transfer);
        transfer.setBounds(130, 330, 100, 23);

        jLabel35.setText("Transfer ke Ruang :");
        jLabel35.setName("jLabel35"); // NOI18N
        FormInput.add(jLabel35);
        jLabel35.setBounds(10, 330, 110, 23);

        tgl_mulai.setDisplayFormat("dd-MM-yyyy");
        tgl_mulai.setName("tgl_mulai"); // NOI18N
        tgl_mulai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_mulaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_mulai);
        tgl_mulai.setBounds(880, 10, 90, 23);

        cmbJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam.setName("cmbJam"); // NOI18N
        cmbJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJamKeyPressed(evt);
            }
        });
        FormInput.add(cmbJam);
        cmbJam.setBounds(980, 10, 62, 23);

        cmbMnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt.setName("cmbMnt"); // NOI18N
        cmbMnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMntKeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt);
        cmbMnt.setBounds(1050, 10, 62, 23);

        cmbDtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk.setName("cmbDtk"); // NOI18N
        cmbDtk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtkKeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk);
        cmbDtk.setBounds(1120, 10, 62, 23);

        tgl_selesai.setDisplayFormat("dd-MM-yyyy");
        tgl_selesai.setName("tgl_selesai"); // NOI18N
        tgl_selesai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_selesaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_selesai);
        tgl_selesai.setBounds(880, 40, 90, 23);

        cmbJam1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam1.setName("cmbJam1"); // NOI18N
        cmbJam1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam1KeyPressed(evt);
            }
        });
        FormInput.add(cmbJam1);
        cmbJam1.setBounds(980, 40, 62, 23);

        cmbMnt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt1.setName("cmbMnt1"); // NOI18N
        cmbMnt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt1KeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt1);
        cmbMnt1.setBounds(1050, 40, 62, 23);

        cmbDtk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk1.setName("cmbDtk1"); // NOI18N
        cmbDtk1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk1KeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk1);
        cmbDtk1.setBounds(1120, 40, 62, 23);

        BtnTambahMonitoring.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); // NOI18N
        BtnTambahMonitoring.setMnemonic('3');
        BtnTambahMonitoring.setToolTipText("Alt+3");
        BtnTambahMonitoring.setName("BtnTambahMonitoring"); // NOI18N
        BtnTambahMonitoring.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnTambahMonitoring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahMonitoringActionPerformed(evt);
            }
        });
        FormInput.add(BtnTambahMonitoring);
        BtnTambahMonitoring.setBounds(300, 250, 28, 23);

        BtnHapusRiwayatPersalinan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapusRiwayatPersalinan.setMnemonic('3');
        BtnHapusRiwayatPersalinan.setToolTipText("Alt+3");
        BtnHapusRiwayatPersalinan.setName("BtnHapusRiwayatPersalinan"); // NOI18N
        BtnHapusRiwayatPersalinan.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnHapusRiwayatPersalinan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusRiwayatPersalinanActionPerformed(evt);
            }
        });
        FormInput.add(BtnHapusRiwayatPersalinan);
        BtnHapusRiwayatPersalinan.setBounds(300, 280, 28, 23);

        Scroll6.setName("Scroll6"); // NOI18N
        Scroll6.setOpaque(true);

        tbRiwayatMonitoring.setName("tbRiwayatMonitoring"); // NOI18N
        Scroll6.setViewportView(tbRiwayatMonitoring);

        FormInput.add(Scroll6);
        Scroll6.setBounds(330, 250, 660, 100);

        PanelWall.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/nrs.png"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall.setLayout(null);
        FormInput.add(PanelWall);
        PanelWall.setBounds(570, 80, 350, 60);

        scrollInput.setViewportView(FormInput);

        internalFrame2.add(scrollInput, java.awt.BorderLayout.CENTER);

        TabRawat.addTab("Input Data", internalFrame2);

        internalFrame3.setBorder(null);
        internalFrame3.setName("internalFrame3"); // NOI18N
        internalFrame3.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);
        Scroll.setPreferredSize(new java.awt.Dimension(452, 200));

        tbObat.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbObat.setComponentPopupMenu(jPopupMenu1);
        tbObat.setName("tbObat"); // NOI18N
        tbObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbObatMouseClicked(evt);
            }
        });
        tbObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbObatKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbObat);

        internalFrame3.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tgl.Asuhan :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06-05-2026" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06-05-2026" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(195, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('3');
        BtnCari.setToolTipText("Alt+3");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass9.add(BtnCari);

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(60, 23));
        panelGlass9.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(LCount);

        internalFrame3.add(panelGlass9, java.awt.BorderLayout.PAGE_END);

        TabRawat.addTab("Data Laporan", internalFrame3);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);
        TabRawat.getAccessibleContext().setAccessibleName("Input");

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (TNoRw.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
            return;
        }

        if (kdanestesi.getText().trim().equals("")) {
            Valid.textKosong(kdanestesi, "Operator 1");
            return;
        }

        setDefaultIfEmpty(kdanestesi, nmanestesi);
        setDefaultIfEmpty(KdDokter, NmDokter);

        if (Sequel.menyimpantf(
                "monitoring_pemulihan",
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?",
                "No.Rawat, Tanggal & Jam",
                16,
                new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    KdDokter.getText(),
                    kdanestesi.getText(),
                    td.getText(),
                    nadi.getText(),
                    rr.getText(),
                    suhu.getText(),
                    kesadaran.getSelectedItem().toString(),
                    pernafasan.getSelectedItem().toString(),
                    penyulit.getText(),
                    komplikasi.getText(),
                    penanganan.getText(),
                    transfer.getSelectedItem().toString(),
                    nrs.getText()
//                    InstruksiPascaOP.getText(),
                }) == true) {
            tabMode.addRow(new Object[]{
                TNoRw.getText(),
                TNoRM.getText(),
                TPasien.getText(),
                Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                KdDokter.getText(),
                NmDokter.getText(),
                kdanestesi.getText(),
                nmanestesi.getText(),
                td.getText(),
                nadi.getText(),
                rr.getText(),
                suhu.getText(),
                kesadaran.getSelectedItem().toString(),
                pernafasan.getSelectedItem().toString(),
                komplikasi.getText(),
                penyulit.getText(),
                penanganan.getText(),
                transfer.getSelectedItem().toString(),
                nrs.getText()
            });
            emptTeks();
            LCount.setText("" + tabMode.getRowCount());
        }

}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
        }
//        else {
//            Valid.pindah(evt, TeknikRegionalHasil, BtnBatal);
//        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            emptTeks();
        } else {
            Valid.pindah(evt, BtnSimpan, BtnHapus);
        }
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if (tbObat.getSelectedRow() > -1) {
            if (akses.getkode().equals("Admin Utama")) {
                hapus();
            } else {
                if (KdDokter.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
                    hapus();
                } else {
                    JOptionPane.showMessageDialog(null, "Hanya bisa dihapus oleh dokter yang bersangkutan..!!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
        }

}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnHapusActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if (TNoRM.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
            return;
        }

        if (kdanestesi.getText().trim().equals("")) {
            Valid.textKosong(kdanestesi, "Dokter Anastesi");
            return;
        }

        if (tbObat.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
            return;
        }

        if (akses.getkode().equals("Admin Utama")) {
            ganti();
        } else {
            if (kdanestesi.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString())) {
                ganti();
            } else {
                JOptionPane.showMessageDialog(null, "Hanya bisa diganti oleh dokter yang bersangkutan..!!");
            }
        }
}//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnEditActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnHapus, BtnAll);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnKeluarActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnEdit, TCari);
        }
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnCariActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            BtnCari.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnCariActionPerformed(null);
        } else {
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            TCari.setText("");
            tampil();
        } else {
            Valid.pindah(evt, BtnCari, TPasien);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbObatMouseClicked
        if (tabMode.getRowCount() != 0) {
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
            if ((evt.getClickCount() == 2)) {
                TabRawat.setSelectedIndex(0);
            }
        }
}//GEN-LAST:event_tbObatMouseClicked

    private void tbObatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbObatKeyPressed
        if (tabMode.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            } else if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
                try {
                    getData();
                    TabRawat.setSelectedIndex(0);
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbObatKeyPressed

    private void MnLaporanMonitoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnLaporanMonitoringActionPerformed
        if (tbObat.getSelectedRow() > -1) {
            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());
            param.put("alamatrs", akses.getalamatrs());
            param.put("kotars", akses.getkabupatenrs());
            param.put("propinsirs", akses.getpropinsirs());
            param.put("kontakrs", akses.getkontakrs());
            param.put("emailrs", akses.getemailrs());
            param.put("logo", Sequel.cariGambar("select setting.logo from setting"));
            param.put("norawat", tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString());
            param.put("tanggal", tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString());
            param.put("tanggalmulai", tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString());

            finger = Sequel.cariIsi(
                    "select sha1(sidikjari.sidikjari) from sidikjari "
                    + "inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",
                    tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString()
            );
            param.put("finger",
                    "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs()
                    + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 6).toString()
                    + "\nID " + (finger.equals("")
                    ? tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString()
                    : finger)
                    + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString())
            );
            finger1 = Sequel.cariIsi(
                    "select sha1(sidikjari.sidikjari) from sidikjari "
                    + "inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",
                    tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString()
            );
            param.put("finger1",
                    "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs()
                    + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 8).toString()
                    + "\nID " + (finger1.equals("") // ✅ pakai finger1
                    ? tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString()
                    : finger1)
                    + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString())
            );
            Valid.MyReportqry("rptMonitoringRecoveryRoom.jasper", "report", "::[ Laporan Monitoring Di Recovery Room ]::",
                    "SELECT monitoring_pemulihan.*, pasien.no_rkm_medis,pasien.jk,pasien.tgl_lahir,"
                    + "d1.nm_dokter AS nm_dokter_operator,"
                    + "d2.nm_dokter AS nm_dokter_anestesi,"
                    + "pasien.nm_pasien "
                    + "FROM monitoring_pemulihan "
                    + "JOIN reg_periksa ON monitoring_pemulihan.no_rawat = reg_periksa.no_rawat "
                    + "JOIN pasien ON reg_periksa.no_rkm_medis = pasien.no_rkm_medis "
                    + "JOIN dokter d1 ON monitoring_pemulihan.dokter = d1.kd_dokter "
                    + "JOIN dokter d2 ON monitoring_pemulihan.dokter_anestesi = d2.kd_dokter "
                    + "WHERE monitoring_pemulihan.no_rawat='" + tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString() + "' ",
                    param);
        }
    }//GEN-LAST:event_MnLaporanMonitoringActionPerformed

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        pilihan = 2;
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void BtnAnastesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnastesiActionPerformed
        pilihan = 1;
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnAnastesiActionPerformed

    private void tgl_mulaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_mulaiKeyPressed
        //        Valid.pindah(evt, jenis, BtnOperator1);
    }//GEN-LAST:event_tgl_mulaiKeyPressed

    private void cmbJamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJamKeyPressed
        Valid.pindah(evt, tgl_mulai, cmbMnt);
    }//GEN-LAST:event_cmbJamKeyPressed

    private void cmbMntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMntKeyPressed
        Valid.pindah(evt, cmbJam, cmbDtk);
    }//GEN-LAST:event_cmbMntKeyPressed

    private void cmbDtkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtkKeyPressed
        Valid.pindah(evt, cmbMnt, tgl_selesai);
    }//GEN-LAST:event_cmbDtkKeyPressed

    private void tgl_selesaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_selesaiKeyPressed
        //        Valid.pindah(evt, btnAsis3, PreOp);
    }//GEN-LAST:event_tgl_selesaiKeyPressed

    private void cmbJam1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJam1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJam1KeyPressed

    private void cmbMnt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMnt1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMnt1KeyPressed

    private void cmbDtk1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtk1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDtk1KeyPressed

    private void BtnKeluarKehamilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarKehamilanActionPerformed
        DlgRiwayatMonitoring.dispose();
    }//GEN-LAST:event_BtnKeluarKehamilanActionPerformed

    private void BtnSimpanRiwayatKehamilanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanRiwayatKehamilanActionPerformed
        String jam = cmbJam2.getSelectedItem().toString() + ":"
                + cmbMnt2.getSelectedItem().toString() + ":"
                + cmbDtk2.getSelectedItem().toString();
        if (td1.getText().trim().equals("")) {
            Valid.textKosong(td1, "Tekanan Darah");
        } else if (nadi1.getText().trim().equals("")) {
            Valid.textKosong(nadi1, "Nadi");
        } else if (suhu1.getText().trim().equals("")) {
            Valid.textKosong(suhu1, "Suhu");
        } else if (rr1.getText().trim().equals("")) {
            Valid.textKosong(rr1, "RR");
        } else if (saturasi.getText().trim().equals("")) {
            Valid.textKosong(saturasi, "Keadaan");
        } else {
            if (Sequel.menyimpantf("riwayat_monitoring (no_rawat, jam_monitoring, td, nadi, suhu, rr, kesadaran, saturasi)",
                    "?,?,?,?,?,?,?,?",
                    "Riwayat Persalinan", 8,
                    new String[]{
                        TNoRw.getText(),
                        jam,
                        td1.getText(),
                        nadi1.getText(),
                        suhu1.getText(),
                        rr1.getText(),
                        kesadaran1.getText(),
                        saturasi.getText()
                    }) == true) {
                emptyMonitoring();
                tampilPersalinan();
            }
        }
    }//GEN-LAST:event_BtnSimpanRiwayatKehamilanActionPerformed

    private void td1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_td1KeyPressed
        Valid.pindah(evt, BtnKeluarKehamilan, nadi1);
    }//GEN-LAST:event_td1KeyPressed

    private void nadi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nadi1KeyPressed
        Valid.pindah(evt, td1, suhu1);
    }//GEN-LAST:event_nadi1KeyPressed

    private void suhu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_suhu1KeyPressed
        Valid.pindah(evt, nadi1, rr1);
    }//GEN-LAST:event_suhu1KeyPressed

    private void rr1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rr1KeyPressed
        Valid.pindah(evt, suhu1, saturasi);
    }//GEN-LAST:event_rr1KeyPressed

    private void saturasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saturasiKeyPressed

    }//GEN-LAST:event_saturasiKeyPressed

    private void kesadaran1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kesadaran1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kesadaran1KeyPressed

    private void cmbJam2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJam2KeyPressed
        Valid.pindah(evt, tgl_mulai, cmbMnt);
    }//GEN-LAST:event_cmbJam2KeyPressed

    private void cmbMnt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMnt2KeyPressed
        Valid.pindah(evt, cmbJam, cmbDtk);
    }//GEN-LAST:event_cmbMnt2KeyPressed

    private void cmbDtk2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtk2KeyPressed
        Valid.pindah(evt, cmbMnt, tgl_selesai);
    }//GEN-LAST:event_cmbDtk2KeyPressed

    private void BtnTambahMonitoringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahMonitoringActionPerformed
        if (TNoRM.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Pilih terlebih pasiennya...");

        } else {
            emptyMonitoring();
            DlgRiwayatMonitoring.setLocationRelativeTo(internalFrame1);
            DlgRiwayatMonitoring.setVisible(true);
        }
    }//GEN-LAST:event_BtnTambahMonitoringActionPerformed

    private void BtnHapusRiwayatPersalinanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusRiwayatPersalinanActionPerformed
        if (tbRiwayatMonitoring.getSelectedRow() > -1) {
            Sequel.meghapus("riwayat_monitoring", "id", "jam_monitoring", tbRiwayatMonitoring.getValueAt(tbRiwayatMonitoring.getSelectedRow(), 0).toString(), tbRiwayatMonitoring.getValueAt(tbRiwayatMonitoring.getSelectedRow(), 2).toString());
            tampilPersalinan();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
        }
    }//GEN-LAST:event_BtnHapusRiwayatPersalinanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMMonitoringDiRecoveryRoom dialog = new RMMonitoringDiRecoveryRoom(new javax.swing.JFrame(), true);
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
    private widget.Button BtnAll;
    private widget.Button BtnAnastesi;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnDokter;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnHapusRiwayatPersalinan;
    private widget.Button BtnKeluar;
    private widget.Button BtnKeluarKehamilan;
    private widget.Button BtnSimpan;
    private widget.Button BtnSimpanRiwayatKehamilan;
    private widget.Button BtnTambahMonitoring;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private javax.swing.JDialog DlgRiwayatMonitoring;
    private widget.PanelBiasa FormInput;
    private widget.TextBox KdDokter;
    private widget.Label LCount;
    private javax.swing.JMenuItem MnLaporanMonitoring;
    private widget.TextBox NmDokter;
    private usu.widget.glass.PanelGlass PanelWall;
    private widget.ScrollPane Scroll;
    private widget.ScrollPane Scroll6;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.ComboBox cmbDtk;
    private widget.ComboBox cmbDtk1;
    private widget.ComboBox cmbDtk2;
    private widget.ComboBox cmbJam;
    private widget.ComboBox cmbJam1;
    private widget.ComboBox cmbJam2;
    private widget.ComboBox cmbMnt;
    private widget.ComboBox cmbMnt1;
    private widget.ComboBox cmbMnt2;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.InternalFrame internalFrame4;
    private widget.Label jLabel100;
    private widget.Label jLabel108;
    private widget.Label jLabel109;
    private widget.Label jLabel111;
    private widget.Label jLabel113;
    private widget.Label jLabel114;
    private widget.Label jLabel115;
    private widget.Label jLabel12;
    private widget.Label jLabel15;
    private widget.Label jLabel17;
    private widget.Label jLabel19;
    private widget.Label jLabel21;
    private widget.Label jLabel23;
    private widget.Label jLabel24;
    private widget.Label jLabel3;
    private widget.Label jLabel30;
    private widget.Label jLabel31;
    private widget.Label jLabel32;
    private widget.Label jLabel33;
    private widget.Label jLabel34;
    private widget.Label jLabel35;
    private widget.Label jLabel36;
    private widget.Label jLabel37;
    private widget.Label jLabel38;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.TextBox kdanestesi;
    private widget.ComboBox kesadaran;
    private widget.TextBox kesadaran1;
    private widget.TextBox komplikasi;
    private widget.Label label14;
    private widget.Label label22;
    private widget.Label label29;
    private widget.TextBox nadi;
    private widget.TextBox nadi1;
    private widget.TextBox nmanestesi;
    private widget.TextBox nrs;
    private widget.PanelBiasa panelBiasa2;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.TextArea penanganan;
    private widget.TextArea penyulit;
    private widget.ComboBox pernafasan;
    private widget.TextBox rr;
    private widget.TextBox rr1;
    private widget.TextBox saturasi;
    private widget.ScrollPane scrollInput;
    private widget.TextBox suhu;
    private widget.TextBox suhu1;
    private widget.Table tbObat;
    private widget.Table tbRiwayatMonitoring;
    private widget.TextBox td;
    private widget.TextBox td1;
    private widget.Tanggal tgl_mulai;
    private widget.Tanggal tgl_selesai;
    private widget.ComboBox transfer;
    // End of variables declaration//GEN-END:variables

    private void tampilPersalinan() {
        Valid.tabelKosong(tabModeRiwayatMonitoring);
        try {
            ps = koneksi.prepareStatement("select * from riwayat_monitoring where riwayat_monitoring.no_rawat=?");
            try {
                ps.setString(1, TNoRw.getText());
                rs = ps.executeQuery();
                i = 1;
                while (rs.next()) {
                    tabModeRiwayatMonitoring.addRow(new Object[]{
                        rs.getString("id"), i + "", rs.getString("jam_monitoring"), rs.getString("td"), rs.getString("nadi"), rs.getString("suhu"),
                        rs.getString("rr"), rs.getString("kesadaran"), rs.getString("saturasi")
                    });
                    i++;
                }
            } catch (Exception e) {
                System.out.println("Notif : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notif : " + e);
        }
    }

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            String sql = "SELECT monitoring_pemulihan.*, pasien.no_rkm_medis, "
                    + "d1.nm_dokter AS nm_dokter_operator, "
                    + "d2.nm_dokter AS nm_dokter_anestesi, "
                    + "pasien.nm_pasien "
                    + "FROM monitoring_pemulihan "
                    + "JOIN reg_periksa ON monitoring_pemulihan.no_rawat = reg_periksa.no_rawat "
                    + "JOIN pasien ON reg_periksa.no_rkm_medis = pasien.no_rkm_medis "
                    + "JOIN dokter d1 ON monitoring_pemulihan.dokter = d1.kd_dokter "
                    + "JOIN dokter d2 ON monitoring_pemulihan.dokter_anestesi = d2.kd_dokter "
                    + "WHERE monitoring_pemulihan.jam_masuk BETWEEN ? AND ? "
                    + "AND (reg_periksa.no_rawat LIKE ? "
                    + "OR pasien.no_rkm_medis LIKE ? "
                    + "OR pasien.nm_pasien LIKE ?)";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00"); // tanggal awal
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59"); // tanggal akhir
                ps.setString(3, "%" + TCari.getText() + "%"); // no_rawat
                ps.setString(4, "%" + TCari.getText() + "%"); // no_rkm_medis
                ps.setString(5, "%" + TCari.getText() + "%"); // nm_pasien

                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),
                        rs.getString("no_rkm_medis"),
                        rs.getString("nm_pasien"),
                        rs.getString("jam_masuk"),
                        rs.getString("jam_keluar"),
                        rs.getString("dokter"),
                        rs.getString("nm_dokter_operator"),
                        rs.getString("dokter_anestesi"),
                        rs.getString("nm_dokter_anestesi"),
                        rs.getString("td"),
                        rs.getString("nadi"),
                        rs.getString("rr"),
                        rs.getString("suhu"),
                        rs.getString("kesadaran"),
                        rs.getString("pernafasan"),
                        rs.getString("komplikasi_akut"),
                        rs.getString("penyulit"),
                        rs.getString("penanganan"),
                        rs.getString("transfer_ke"),
                        rs.getString("skor_nrs"),});
                }
            } catch (Exception e) {
                System.out.println("Notif RS: " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
        LCount.setText("" + tabMode.getRowCount());
    }

    public void emptyMonitoring() {
        td1.setText("");
        nadi1.setText("");
        suhu1.setText("");
        rr1.setText("");
        kesadaran1.setText("");
        saturasi.setText("");
    }

    public void emptTeks() {
        tgl_mulai.setSelectedIndex(0);
        cmbJam.setSelectedIndex(0);
        cmbMnt.setSelectedIndex(0);
        cmbDtk.setSelectedIndex(0);
        tgl_selesai.setSelectedIndex(0);
        cmbJam1.setSelectedIndex(0);
        cmbMnt1.setSelectedIndex(0);
        cmbDtk1.setSelectedIndex(0);
        KdDokter.setText("");
        NmDokter.setText("");
        td.setText("");
        nadi.setText("");
        rr.setText("");
        suhu.setText("");
        kesadaran.setSelectedIndex(0);
        kesadaran.setSelectedIndex(0);
        penyulit.setText("");
        penyulit.setText("");
        penyulit.setText("");
        penyulit.setText("");
        kesadaran.setSelectedIndex(0);
        TabRawat.setSelectedIndex(0);
        TNoRw.requestFocus();
    }

    private void getData() {
        int row = tbObat.getSelectedRow();
        if (row != -1) {
            // Data Pasien & Administrasi
            TNoRw.setText(tbObat.getValueAt(row, 0).toString());
            TNoRM.setText(tbObat.getValueAt(row, 1).toString());
            TPasien.setText(tbObat.getValueAt(row, 2).toString());
            KdDokter.setText(tbObat.getValueAt(row, 5).toString());
            NmDokter.setText(tbObat.getValueAt(row, 6).toString());
            kdanestesi.setText(tbObat.getValueAt(row, 7).toString());
            nmanestesi.setText(tbObat.getValueAt(row, 8).toString());
            td.setText(tbObat.getValueAt(row, 9).toString());
            nadi.setText(tbObat.getValueAt(row, 10).toString());
            rr.setText(tbObat.getValueAt(row, 11).toString());
            suhu.setText(tbObat.getValueAt(row, 12).toString());
            kesadaran.setSelectedItem(tbObat.getValueAt(row, 13).toString());
            pernafasan.setSelectedItem(tbObat.getValueAt(row, 14).toString());
            komplikasi.setText(tbObat.getValueAt(row, 15).toString());
            penyulit.setText(tbObat.getValueAt(row, 16).toString());
            penanganan.setText(tbObat.getValueAt(row, 17).toString());
            transfer.setSelectedItem(tbObat.getValueAt(row, 18).toString());
            nrs.setText(tbObat.getValueAt(row, 19).toString());

            String tglMulai[] = tbObat.getValueAt(row, 3).toString().split(" ");
            String jamMulai[] = tglMulai[1].split(":");
            Valid.SetTgl(tgl_mulai, tglMulai[0]);
            cmbJam.setSelectedItem(jamMulai[0]);
            cmbMnt.setSelectedItem(jamMulai[1]);
            cmbDtk.setSelectedItem(jamMulai[2]);

            String tglSelesai[] = tbObat.getValueAt(row, 4).toString().split(" ");
            String jamSelesai[] = tglSelesai[1].split(":");
            Valid.SetTgl(tgl_selesai, tglSelesai[0]);
            cmbJam1.setSelectedItem(jamSelesai[0]);
            cmbMnt1.setSelectedItem(jamSelesai[1]);
            cmbDtk1.setSelectedItem(jamSelesai[2]);
            
            tampilPersalinan();
        }
    }

    private void isRawat() {
        try {
            ps = koneksi.prepareStatement(
                    "select reg_periksa.no_rkm_medis,pasien.nm_pasien, if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,reg_periksa.tgl_registrasi "
                    + "from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "where reg_periksa.no_rawat=?");
            try {
                ps.setString(1, TNoRw.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    DTPCari1.setDate(rs.getDate("tgl_registrasi"));
                    TPasien.setText(rs.getString("nm_pasien"));
                }
            } catch (Exception e) {
                System.out.println("Notif : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notif : " + e);
        }
    }

    public void setNoRm(String norwt, Date tgl2) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        DTPCari2.setDate(tgl2);
        isRawat();

    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.getpenilaian_pre_induksi());
        BtnHapus.setEnabled(akses.getpenilaian_pre_induksi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_induksi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_induksi());
        if (akses.getjml2() >= 1) {
            kdanestesi.setEditable(false);
            BtnAnastesi.setEnabled(false);
            kdanestesi.setText(akses.getkode());
            nmanestesi.setText(dokter.tampil3(kdanestesi.getText()));
            if (nmanestesi.getText().equals("")) {
                nmanestesi.setText("");
                JOptionPane.showMessageDialog(null, "User login bukan Dokter...!!");
            }
        }
    }

    public void setTampil() {
        TabRawat.setSelectedIndex(1);
    }

    private void hapus() {
        int row = tbObat.getSelectedRow();
        if (row != -1) {
            if (Sequel.queryu2tf(
                    "delete from monitoring_pemulihan where no_rawat=? and jam_masuk=?",
                    2,
                    new String[]{
                        tbObat.getValueAt(row, 0).toString(), // no_rawat
                        tbObat.getValueAt(row, 3).toString() // tanggal_mulai
                    }
            ) == true) {
                tabMode.removeRow(row);
                LCount.setText("" + tabMode.getRowCount());
                TabRawat.setSelectedIndex(1);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Gagal menghapus..!!"
                );
            }
        }
    }

    private void ganti() {
        setDefaultIfEmpty(kdanestesi, nmanestesi);

        if (Sequel.mengedittf("monitoring_pemulihan", "no_rawat=? and jam_masuk=?",
                "no_rawat=?,jam_masuk=?,jam_keluar=?,dokter=?,dokter_anestesi=?,"
                + "td=?,rr=?,nadi=?,suhu=?,"
                + "kesadaran=?,pernafasan=?,penyulit=?,komplikasi_akut=?,penanganan=?,"
                + "transfer_ke=?,skor_nrs=?",
                18, new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    KdDokter.getText(),
                    kdanestesi.getText(),
                    td.getText(),
                    rr.getText(),
                    nadi.getText(),
                    suhu.getText(),
                    kesadaran.getSelectedItem().toString(),
                    pernafasan.getSelectedItem().toString(),
                    penyulit.getText(),
                    komplikasi.getText(),
                    penanganan.getText(),
                    transfer.getSelectedItem().toString(),
                    nrs.getText(),
                    tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(), // no_rawat lama
                    tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString()
                }) == true) {

            emptTeks();
            tampil();
            TabRawat.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
        }
    }

    private void setDefaultIfEmpty(JTextField kode, JTextField nama) {
        if (kode.getText().trim().isEmpty()) {
            kode.setText("-");
            nama.setText("-");
        }
    }
}
