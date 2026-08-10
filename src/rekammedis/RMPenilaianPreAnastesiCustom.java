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
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import kepegawaian.DlgCariDokter;

/**
 *
 * @author perpustakaan
 */
public final class RMPenilaianPreAnastesiCustom extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0;
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    private StringBuilder htmlContent;
    private String finger = "";
    private String TANGGALMUNDUR = "yes";

    /**
     * Creates new form DlgRujuk
     *
     * @param parent
     * @param modal */
    public RMPenilaianPreAnastesiCustom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "Tgl.Lahir", "J.K.", "Kode Dokter", "Nama Dokter", "Tanggal", "Tgl.Operasi", "Diagnosa", "Rencana Tindakan",
            "TB", "BB", "TD", "Nadi", "Suhu", "Pernapasan", "Kesadaran", "Jenis Operasi", "Riwayat Penyakit", "Pengobatan Saat Ini", "Riwayat Operasi",
            "Riwayat Anestesi", "Riwayat Alergi", "Riwayat Kebiasaan", "Riwayat Penyakit Keluarga", "Laboratorium", "Penunjang Lain",
            "Rencana Anestesi", "Angka ASA", "Pemberian Informasi", "Persetujuan Tindakan", "Pemberian Medikasi", "Persiapan Transfusi Darah",
            "HCU Pasca Operasi", "Pemeriksaan Tambahan", "Anamnesa"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        tbObat.setModel(tabMode);
        tbObat.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 37; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(105);
            } else if (i == 1) {
                column.setPreferredWidth(70);
            } else if (i == 2) {
                column.setPreferredWidth(150);
            } else if (i == 3) {
                column.setPreferredWidth(65);
            } else if (i == 4) {
                column.setPreferredWidth(65);
            } else if (i == 5) {
                column.setPreferredWidth(80);
            } else if (i == 6) {
                column.setPreferredWidth(150);
            } else if (i == 7) {
                column.setPreferredWidth(115);
            } else if (i == 8) {
                column.setPreferredWidth(115);
            } else if (i == 9) {
                column.setPreferredWidth(170);
            } else if (i == 10) {
                column.setPreferredWidth(170);
            } else if (i == 11) {
                column.setPreferredWidth(35);
            } else if (i == 12) {
                column.setPreferredWidth(35);
            } else if (i == 13) {
                column.setPreferredWidth(50);
            } else if (i == 14) {
                column.setPreferredWidth(35);
            } else if (i == 15) {
                column.setPreferredWidth(35);
            } else if (i == 16) {
                column.setPreferredWidth(55);
            } else if (i == 17) {
                column.setPreferredWidth(35);
            } else if (i == 18) {
                column.setPreferredWidth(170);
            } else if (i == 19) {
                column.setPreferredWidth(170);
            } else if (i == 20) {
                column.setPreferredWidth(170);
            } else if (i == 21) {
                column.setPreferredWidth(170);
            } else if (i == 22) {
                column.setPreferredWidth(170);
            } else if (i == 23) {
                column.setPreferredWidth(170);
            } else if (i == 24) {
                column.setPreferredWidth(170);
            } else if (i == 25) {
                column.setPreferredWidth(170);
            } else if (i == 26) {
                column.setPreferredWidth(170);
            } else if (i == 27) {
                column.setPreferredWidth(170);
            } else if (i == 28) {
                column.setPreferredWidth(170);
            } else if (i == 29) {
                column.setPreferredWidth(170);
            } else if (i == 30) {
                column.setPreferredWidth(100);
            } else if (i == 31) {
                column.setPreferredWidth(55);
            } else if (i == 32) {
                column.setPreferredWidth(97);
            } else if (i == 33) {
                column.setPreferredWidth(49);
            } else if (i == 34) {
                column.setPreferredWidth(94);
            } else if (i == 35) {
                column.setPreferredWidth(130);
            } else if (i == 36) {
                column.setPreferredWidth(170);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());

        TNoRw.setDocument(new batasInput((byte) 17).getKata(TNoRw));
        Diagnosa.setDocument(new batasInput((byte) 100).getKata(Diagnosa));
        RencanaTindakan.setDocument(new batasInput((byte) 100).getKata(RencanaTindakan));
        TB.setDocument(new batasInput((byte) 5).getKata(TB));
        BB.setDocument(new batasInput((byte) 5).getKata(BB));
        TD.setDocument(new batasInput((byte) 8).getKata(TD));
        Nadi.setDocument(new batasInput((byte) 5).getKata(Nadi));
        Suhu.setDocument(new batasInput((byte) 5).getKata(Suhu));
        Pernapasan.setDocument(new batasInput((byte) 5).getKata(Pernapasan));
        TCari.setDocument(new batasInput((int) 100).getKata(TCari));

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
                    KdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                    NmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                    KdDokter.requestFocus();
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

        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                + ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"
                + ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                + ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                + ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"
                + ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"
                + ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"
                + ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"
                + ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
        );
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);

        try {
            TANGGALMUNDUR = koneksiDB.TANGGALMUNDUR();
        } catch (Exception e) {
            TANGGALMUNDUR = "yes";
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

        LoadHTML = new widget.editorpane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnPenilaianMedis = new javax.swing.JMenuItem();
        TanggalRegistrasi = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        TabRawat = new javax.swing.JTabbedPane();
        internalFrame2 = new widget.InternalFrame();
        scrollInput = new widget.ScrollPane();
        FormInput = new widget.PanelBiasa();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        TNoRM = new widget.TextBox();
        label14 = new widget.Label();
        KdDokter = new widget.TextBox();
        NmDokter = new widget.TextBox();
        BtnDokter = new widget.Button();
        jLabel8 = new widget.Label();
        TglLahir = new widget.TextBox();
        Jk = new widget.TextBox();
        jLabel10 = new widget.Label();
        jLabel11 = new widget.Label();
        jSeparator1 = new javax.swing.JSeparator();
        label11 = new widget.Label();
        TglAsuhan = new widget.Tanggal();
        label12 = new widget.Label();
        TglOperasi = new widget.Tanggal();
        jLabel12 = new widget.Label();
        Diagnosa = new widget.TextBox();
        jLabel13 = new widget.Label();
        RencanaTindakan = new widget.TextBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel109 = new widget.Label();
        jLabel15 = new widget.Label();
        TB = new widget.TextBox();
        jLabel24 = new widget.Label();
        jLabel16 = new widget.Label();
        BB = new widget.TextBox();
        jLabel17 = new widget.Label();
        jLabel22 = new widget.Label();
        TD = new widget.TextBox();
        jLabel23 = new widget.Label();
        jLabel18 = new widget.Label();
        Nadi = new widget.TextBox();
        jLabel20 = new widget.Label();
        jLabel25 = new widget.Label();
        Suhu = new widget.TextBox();
        jLabel26 = new widget.Label();
        jLabel27 = new widget.Label();
        Pernapasan = new widget.TextBox();
        jLabel28 = new widget.Label();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel110 = new widget.Label();
        jLabel40 = new widget.Label();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel111 = new widget.Label();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel128 = new widget.Label();
        RencanaAnestesi = new widget.ComboBox();
        AngkaASA = new widget.ComboBox();
        jLabel129 = new widget.Label();
        jLabel47 = new widget.Label();
        medikasi = new javax.swing.JCheckBox();
        informasi = new javax.swing.JCheckBox();
        tindakan = new javax.swing.JCheckBox();
        jLabel50 = new widget.Label();
        hcu = new javax.swing.JCheckBox();
        transfusi = new javax.swing.JCheckBox();
        jLabel51 = new widget.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tambahan = new javax.swing.JTextArea();
        jLabel130 = new widget.Label();
        JenisOperasi = new widget.ComboBox();
        RiwayatDM = new javax.swing.JCheckBox();
        RiwayatHepatitis = new javax.swing.JCheckBox();
        RiwayatPernapasan = new javax.swing.JCheckBox();
        RiwayatTidak = new javax.swing.JCheckBox();
        RiwayatLain = new javax.swing.JCheckBox();
        RiwayatJantung = new javax.swing.JCheckBox();
        jLabel131 = new widget.Label();
        Kesadaran = new widget.ComboBox();
        jLabel132 = new widget.Label();
        RiwayatOperasi = new widget.ComboBox();
        jLabel133 = new widget.Label();
        PengobatanSaatIni = new widget.ComboBox();
        jLabel134 = new widget.Label();
        RiwayatAnestesi = new widget.ComboBox();
        jLabel135 = new widget.Label();
        RiwayatAlergi = new widget.ComboBox();
        jLabel136 = new widget.Label();
        jLabel137 = new widget.Label();
        RiwayatKebiasaan = new widget.ComboBox();
        RiwayatKeluargaJantung = new javax.swing.JCheckBox();
        RiwayatKeluargaDM = new javax.swing.JCheckBox();
        RiwayatKeluargaHepatitis = new javax.swing.JCheckBox();
        RiwayatKeluargaPernapasan = new javax.swing.JCheckBox();
        RiwayatKeluargaTidak = new javax.swing.JCheckBox();
        RiwayatKeluargaLain = new javax.swing.JCheckBox();
        jLabel63 = new widget.Label();
        hb = new javax.swing.JCheckBox();
        golda = new javax.swing.JCheckBox();
        leukosit = new javax.swing.JCheckBox();
        gds = new javax.swing.JCheckBox();
        ureum = new javax.swing.JCheckBox();
        bt = new javax.swing.JCheckBox();
        hbsag = new javax.swing.JCheckBox();
        creatinin = new javax.swing.JCheckBox();
        ct = new javax.swing.JCheckBox();
        jLabel64 = new widget.Label();
        ecg = new javax.swing.JCheckBox();
        usg = new javax.swing.JCheckBox();
        rontgen = new javax.swing.JCheckBox();
        jLabel112 = new widget.Label();
        jLabel48 = new widget.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        Anamnesa = new javax.swing.JTextArea();
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

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnPenilaianMedis.setBackground(new java.awt.Color(255, 255, 254));
        MnPenilaianMedis.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnPenilaianMedis.setForeground(new java.awt.Color(50, 50, 50));
        MnPenilaianMedis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnPenilaianMedis.setText("Laporan Pengkajian Pre Anestesi");
        MnPenilaianMedis.setName("MnPenilaianMedis"); // NOI18N
        MnPenilaianMedis.setPreferredSize(new java.awt.Dimension(220, 26));
        MnPenilaianMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnPenilaianMedisActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnPenilaianMedis);

        TanggalRegistrasi.setHighlighter(null);
        TanggalRegistrasi.setName("TanggalRegistrasi"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Pengkajian Pre Anestesi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

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
        TabRawat.setName("TabRawat"); // NOI18N
        TabRawat.setPreferredSize(new java.awt.Dimension(457, 480));

        internalFrame2.setBorder(null);
        internalFrame2.setMinimumSize(new java.awt.Dimension(100, 100));
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setPreferredSize(new java.awt.Dimension(102, 480));
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        scrollInput.setMinimumSize(new java.awt.Dimension(100, 100));
        scrollInput.setName("scrollInput"); // NOI18N
        scrollInput.setPreferredSize(new java.awt.Dimension(102, 557));

        FormInput.setBackground(new java.awt.Color(255, 255, 255));
        FormInput.setBorder(null);
        FormInput.setMinimumSize(new java.awt.Dimension(300, 300));
        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(750, 1100));
        FormInput.setLayout(null);

        TNoRw.setEditable(false);
        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(74, 10, 131, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(309, 10, 260, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        FormInput.add(TNoRM);
        TNoRM.setBounds(207, 10, 100, 23);

        label14.setText("Dokter :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label14);
        label14.setBounds(166, 40, 50, 23);

        KdDokter.setEditable(false);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.setPreferredSize(new java.awt.Dimension(80, 23));
        FormInput.add(KdDokter);
        KdDokter.setBounds(220, 40, 90, 23);

        NmDokter.setEditable(false);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(NmDokter);
        NmDokter.setBounds(312, 40, 180, 23);

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
        BtnDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnDokterKeyPressed(evt);
            }
        });
        FormInput.add(BtnDokter);
        BtnDokter.setBounds(494, 40, 28, 23);

        jLabel8.setText("Tgl.Lahir :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(580, 10, 60, 23);

        TglLahir.setEditable(false);
        TglLahir.setHighlighter(null);
        TglLahir.setName("TglLahir"); // NOI18N
        FormInput.add(TglLahir);
        TglLahir.setBounds(644, 10, 80, 23);

        Jk.setEditable(false);
        Jk.setHighlighter(null);
        Jk.setName("Jk"); // NOI18N
        FormInput.add(Jk);
        Jk.setBounds(74, 40, 80, 23);

        jLabel10.setText("No.Rawat :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(0, 10, 70, 23);

        jLabel11.setText("J.K. :");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(0, 40, 70, 23);

        jSeparator1.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator1.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator1.setName("jSeparator1"); // NOI18N
        FormInput.add(jSeparator1);
        jSeparator1.setBounds(0, 70, 750, 1);

        label11.setText("Tanggal :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label11);
        label11.setBounds(538, 40, 52, 23);

        TglAsuhan.setForeground(new java.awt.Color(50, 70, 50));
        TglAsuhan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "29-05-2026 17:04:15" }));
        TglAsuhan.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        TglAsuhan.setName("TglAsuhan"); // NOI18N
        TglAsuhan.setOpaque(false);
        TglAsuhan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TglAsuhanKeyPressed(evt);
            }
        });
        FormInput.add(TglAsuhan);
        TglAsuhan.setBounds(594, 40, 160, 23);

        label12.setText("Tgl.Operasi :");
        label12.setName("label12"); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label12);
        label12.setBounds(520, 80, 70, 23);

        TglOperasi.setForeground(new java.awt.Color(50, 70, 50));
        TglOperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "29-05-2026 17:04:16" }));
        TglOperasi.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        TglOperasi.setName("TglOperasi"); // NOI18N
        TglOperasi.setOpaque(false);
        TglOperasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TglOperasiKeyPressed(evt);
            }
        });
        FormInput.add(TglOperasi);
        TglOperasi.setBounds(594, 80, 160, 23);

        jLabel12.setText("Diagnosa :");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(0, 80, 62, 23);

        Diagnosa.setHighlighter(null);
        Diagnosa.setName("Diagnosa"); // NOI18N
        Diagnosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DiagnosaKeyPressed(evt);
            }
        });
        FormInput.add(Diagnosa);
        Diagnosa.setBounds(66, 80, 139, 23);

        jLabel13.setText("Rencana Tindakan :");
        jLabel13.setName("jLabel13"); // NOI18N
        FormInput.add(jLabel13);
        jLabel13.setBounds(208, 80, 100, 23);

        RencanaTindakan.setHighlighter(null);
        RencanaTindakan.setName("RencanaTindakan"); // NOI18N
        RencanaTindakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RencanaTindakanKeyPressed(evt);
            }
        });
        FormInput.add(RencanaTindakan);
        RencanaTindakan.setBounds(312, 80, 210, 23);

        jSeparator2.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator2.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator2.setName("jSeparator2"); // NOI18N
        FormInput.add(jSeparator2);
        jSeparator2.setBounds(0, 70, 750, 1);

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel109.setText("I. Asesmen Fisik :");
        jLabel109.setName("jLabel109"); // NOI18N
        FormInput.add(jLabel109);
        jLabel109.setBounds(10, 110, 130, 23);

        jLabel15.setText("TB :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(-80, 140, 130, 23);

        TB.setFocusTraversalPolicyProvider(true);
        TB.setName("TB"); // NOI18N
        TB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TBKeyPressed(evt);
            }
        });
        FormInput.add(TB);
        TB.setBounds(60, 140, 55, 23);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText(" Cm");
        jLabel24.setName("jLabel24"); // NOI18N
        FormInput.add(jLabel24);
        jLabel24.setBounds(120, 140, 30, 23);

        jLabel16.setText("BB :");
        jLabel16.setName("jLabel16"); // NOI18N
        FormInput.add(jLabel16);
        jLabel16.setBounds(170, 140, 40, 23);

        BB.setFocusTraversalPolicyProvider(true);
        BB.setName("BB"); // NOI18N
        BB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BBKeyPressed(evt);
            }
        });
        FormInput.add(BB);
        BB.setBounds(220, 140, 55, 23);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Kg");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(280, 140, 30, 23);

        jLabel22.setText("TD :");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(330, 140, 40, 23);

        TD.setFocusTraversalPolicyProvider(true);
        TD.setName("TD"); // NOI18N
        TD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TDKeyPressed(evt);
            }
        });
        FormInput.add(TD);
        TD.setBounds(380, 140, 76, 23);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("mmHg");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(460, 140, 50, 23);

        jLabel18.setText("Nadi :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(-80, 170, 130, 23);

        Nadi.setFocusTraversalPolicyProvider(true);
        Nadi.setName("Nadi"); // NOI18N
        Nadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NadiKeyPressed(evt);
            }
        });
        FormInput.add(Nadi);
        Nadi.setBounds(60, 170, 55, 23);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("x/menit");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(120, 170, 50, 23);

        jLabel25.setText("Suhu :");
        jLabel25.setName("jLabel25"); // NOI18N
        FormInput.add(jLabel25);
        jLabel25.setBounds(170, 170, 40, 23);

        Suhu.setFocusTraversalPolicyProvider(true);
        Suhu.setName("Suhu"); // NOI18N
        Suhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SuhuKeyPressed(evt);
            }
        });
        FormInput.add(Suhu);
        Suhu.setBounds(220, 170, 55, 23);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("°C");
        jLabel26.setName("jLabel26"); // NOI18N
        FormInput.add(jLabel26);
        jLabel26.setBounds(280, 170, 30, 23);

        jLabel27.setText("RR :");
        jLabel27.setName("jLabel27"); // NOI18N
        FormInput.add(jLabel27);
        jLabel27.setBounds(280, 170, 90, 23);

        Pernapasan.setFocusTraversalPolicyProvider(true);
        Pernapasan.setName("Pernapasan"); // NOI18N
        Pernapasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PernapasanKeyPressed(evt);
            }
        });
        FormInput.add(Pernapasan);
        Pernapasan.setBounds(385, 170, 70, 23);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("x/menit");
        jLabel28.setName("jLabel28"); // NOI18N
        FormInput.add(jLabel28);
        jLabel28.setBounds(460, 170, 50, 23);

        jSeparator3.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator3.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator3.setName("jSeparator3"); // NOI18N
        FormInput.add(jSeparator3);
        jSeparator3.setBounds(0, 110, 750, 1);

        jSeparator4.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator4.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator4.setName("jSeparator4"); // NOI18N
        FormInput.add(jSeparator4);
        jSeparator4.setBounds(0, 110, 750, 1);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel110.setText("II. Riwayat Pasien :");
        jLabel110.setName("jLabel110"); // NOI18N
        FormInput.add(jLabel110);
        jLabel110.setBounds(10, 230, 130, 23);

        jLabel40.setText("Riwayat  Penyakit:");
        jLabel40.setName("jLabel40"); // NOI18N
        FormInput.add(jLabel40);
        jLabel40.setBounds(-20, 200, 130, 23);

        jSeparator7.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator7.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator7.setName("jSeparator7"); // NOI18N
        FormInput.add(jSeparator7);
        jSeparator7.setBounds(0, 228, 750, 1);

        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel111.setText("IV. Anamnesa:");
        jLabel111.setName("jLabel111"); // NOI18N
        FormInput.add(jLabel111);
        jLabel111.setBounds(10, 400, 130, 23);

        jSeparator9.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator9.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator9.setName("jSeparator9"); // NOI18N
        FormInput.add(jSeparator9);
        jSeparator9.setBounds(0, 391, 750, 1);

        jLabel128.setText("Rencana Anestesi :");
        jLabel128.setName("jLabel128"); // NOI18N
        FormInput.add(jLabel128);
        jLabel128.setBounds(10, 600, 130, 23);

        RencanaAnestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General Anestesi", "Anestesi Sedang / Dalam", "Regional Anestesi - SAB", "Regional Anestesi - Epidural" }));
        RencanaAnestesi.setName("RencanaAnestesi"); // NOI18N
        RencanaAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RencanaAnestesiKeyPressed(evt);
            }
        });
        FormInput.add(RencanaAnestesi);
        RencanaAnestesi.setBounds(150, 600, 140, 23);

        AngkaASA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "E" }));
        AngkaASA.setName("AngkaASA"); // NOI18N
        AngkaASA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AngkaASAKeyPressed(evt);
            }
        });
        FormInput.add(AngkaASA);
        AngkaASA.setBounds(440, 600, 60, 23);

        jLabel129.setText("Angka ASA :");
        jLabel129.setName("jLabel129"); // NOI18N
        FormInput.add(jLabel129);
        jLabel129.setBounds(310, 600, 120, 23);

        jLabel47.setText("<html> Pemeriksaan tambahan  :<br> yang diperlukan   </html>");
        jLabel47.setName("jLabel47"); // NOI18N
        FormInput.add(jLabel47);
        jLabel47.setBounds(20, 770, 130, 30);

        medikasi.setBackground(new java.awt.Color(255, 255, 255));
        medikasi.setText("Pemberian Medikasi ");
        medikasi.setName("medikasi"); // NOI18N
        medikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medikasiActionPerformed(evt);
            }
        });
        FormInput.add(medikasi);
        medikasi.setBounds(150, 700, 150, 20);

        informasi.setBackground(new java.awt.Color(255, 255, 255));
        informasi.setText("Dokumen pemberian informasi tindakan anestesi");
        informasi.setName("informasi"); // NOI18N
        FormInput.add(informasi);
        informasi.setBounds(150, 660, 320, 20);

        tindakan.setBackground(new java.awt.Color(255, 255, 255));
        tindakan.setText("Persetujuan Tindakan Medis Anestesi");
        tindakan.setName("tindakan"); // NOI18N
        FormInput.add(tindakan);
        tindakan.setBounds(150, 680, 290, 20);

        jLabel50.setText("Instruksi :");
        jLabel50.setName("jLabel50"); // NOI18N
        FormInput.add(jLabel50);
        jLabel50.setBounds(10, 660, 130, 23);

        hcu.setBackground(new java.awt.Color(255, 255, 255));
        hcu.setText("Perawatan HCU Pasca Operasi");
        hcu.setName("hcu"); // NOI18N
        FormInput.add(hcu);
        hcu.setBounds(360, 730, 200, 20);

        transfusi.setBackground(new java.awt.Color(255, 255, 255));
        transfusi.setText("Persiapan Transfusi darah");
        transfusi.setName("transfusi"); // NOI18N
        FormInput.add(transfusi);
        transfusi.setBounds(150, 730, 200, 20);

        jLabel51.setText("Persiapan Lain-lain :");
        jLabel51.setName("jLabel51"); // NOI18N
        FormInput.add(jLabel51);
        jLabel51.setBounds(10, 730, 130, 23);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tambahan.setColumns(20);
        tambahan.setRows(5);
        tambahan.setName("tambahan"); // NOI18N
        jScrollPane1.setViewportView(tambahan);

        FormInput.add(jScrollPane1);
        jScrollPane1.setBounds(160, 770, 400, 170);

        jLabel130.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel130.setText("Jenis Operasi :");
        jLabel130.setName("jLabel130"); // NOI18N
        FormInput.add(jLabel130);
        jLabel130.setBounds(520, 170, 90, 23);

        JenisOperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elektif", "Cito" }));
        JenisOperasi.setName("JenisOperasi"); // NOI18N
        JenisOperasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JenisOperasiKeyPressed(evt);
            }
        });
        FormInput.add(JenisOperasi);
        JenisOperasi.setBounds(610, 170, 120, 23);

        RiwayatDM.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatDM.setText("DM");
        RiwayatDM.setName("RiwayatDM"); // NOI18N
        FormInput.add(RiwayatDM);
        RiwayatDM.setBounds(200, 200, 85, 20);

        RiwayatHepatitis.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatHepatitis.setText("Hepatitis");
        RiwayatHepatitis.setName("RiwayatHepatitis"); // NOI18N
        FormInput.add(RiwayatHepatitis);
        RiwayatHepatitis.setBounds(300, 200, 85, 20);

        RiwayatPernapasan.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatPernapasan.setText("Pernapasan");
        RiwayatPernapasan.setName("RiwayatPernapasan"); // NOI18N
        RiwayatPernapasan.setPreferredSize(new java.awt.Dimension(80, 20));
        FormInput.add(RiwayatPernapasan);
        RiwayatPernapasan.setBounds(390, 200, 110, 20);

        RiwayatTidak.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatTidak.setText("Tidak Ada");
        RiwayatTidak.setName("RiwayatTidak"); // NOI18N
        FormInput.add(RiwayatTidak);
        RiwayatTidak.setBounds(510, 200, 85, 20);

        RiwayatLain.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatLain.setText("Lainnya");
        RiwayatLain.setName("RiwayatLain"); // NOI18N
        FormInput.add(RiwayatLain);
        RiwayatLain.setBounds(600, 200, 85, 20);

        RiwayatJantung.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatJantung.setText("Jantung");
        RiwayatJantung.setName("RiwayatJantung"); // NOI18N
        FormInput.add(RiwayatJantung);
        RiwayatJantung.setBounds(110, 200, 85, 20);

        jLabel131.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel131.setText("Kesadaran    :");
        jLabel131.setName("jLabel131"); // NOI18N
        FormInput.add(jLabel131);
        jLabel131.setBounds(520, 140, 70, 23);

        Kesadaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compos Mentis", "Apatis", "Somnolen", "Sopor", "Soporocoma", "Coma" }));
        Kesadaran.setName("Kesadaran"); // NOI18N
        Kesadaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KesadaranKeyPressed(evt);
            }
        });
        FormInput.add(Kesadaran);
        Kesadaran.setBounds(610, 140, 120, 23);

        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel132.setText("Riwayat Operasi Sebelumnya  :");
        jLabel132.setName("jLabel132"); // NOI18N
        FormInput.add(jLabel132);
        jLabel132.setBounds(20, 290, 160, 23);

        RiwayatOperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        RiwayatOperasi.setSelectedIndex(1);
        RiwayatOperasi.setName("RiwayatOperasi"); // NOI18N
        RiwayatOperasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RiwayatOperasiKeyPressed(evt);
            }
        });
        FormInput.add(RiwayatOperasi);
        RiwayatOperasi.setBounds(190, 290, 120, 23);

        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel133.setText("Pengobatan Saat ini                :");
        jLabel133.setName("jLabel133"); // NOI18N
        FormInput.add(jLabel133);
        jLabel133.setBounds(20, 260, 170, 23);

        PengobatanSaatIni.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        PengobatanSaatIni.setSelectedIndex(1);
        PengobatanSaatIni.setName("PengobatanSaatIni"); // NOI18N
        PengobatanSaatIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PengobatanSaatIniKeyPressed(evt);
            }
        });
        FormInput.add(PengobatanSaatIni);
        PengobatanSaatIni.setBounds(190, 260, 120, 23);

        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel134.setText("Riwayat Anestesi Sebelumnya  :");
        jLabel134.setName("jLabel134"); // NOI18N
        FormInput.add(jLabel134);
        jLabel134.setBounds(20, 320, 160, 23);

        RiwayatAnestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General", "Regional", "Sedasi", "Lokal", "Tidak Ada" }));
        RiwayatAnestesi.setSelectedIndex(4);
        RiwayatAnestesi.setName("RiwayatAnestesi"); // NOI18N
        RiwayatAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RiwayatAnestesiKeyPressed(evt);
            }
        });
        FormInput.add(RiwayatAnestesi);
        RiwayatAnestesi.setBounds(190, 320, 120, 23);

        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel135.setText("Riwayat Alergi                     :");
        jLabel135.setName("jLabel135"); // NOI18N
        FormInput.add(jLabel135);
        jLabel135.setBounds(340, 260, 160, 23);

        RiwayatAlergi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        RiwayatAlergi.setSelectedIndex(1);
        RiwayatAlergi.setName("RiwayatAlergi"); // NOI18N
        RiwayatAlergi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RiwayatAlergiKeyPressed(evt);
            }
        });
        FormInput.add(RiwayatAlergi);
        RiwayatAlergi.setBounds(510, 260, 120, 23);

        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel136.setText("Riwayat Penyakit Keluarga         :");
        jLabel136.setName("jLabel136"); // NOI18N
        FormInput.add(jLabel136);
        jLabel136.setBounds(20, 340, 200, 23);

        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel137.setText("Riwayat Kebiasaan               :");
        jLabel137.setName("jLabel137"); // NOI18N
        FormInput.add(jLabel137);
        jLabel137.setBounds(340, 290, 160, 23);

        RiwayatKebiasaan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perokok", "Minuman Alkohol", "Sulit Tidur", "Lainnya", "Tidak Ada" }));
        RiwayatKebiasaan.setSelectedIndex(4);
        RiwayatKebiasaan.setName("RiwayatKebiasaan"); // NOI18N
        RiwayatKebiasaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RiwayatKebiasaanKeyPressed(evt);
            }
        });
        FormInput.add(RiwayatKebiasaan);
        RiwayatKebiasaan.setBounds(510, 290, 120, 23);

        RiwayatKeluargaJantung.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaJantung.setText("Jantung");
        RiwayatKeluargaJantung.setName("RiwayatKeluargaJantung"); // NOI18N
        FormInput.add(RiwayatKeluargaJantung);
        RiwayatKeluargaJantung.setBounds(70, 360, 85, 20);

        RiwayatKeluargaDM.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaDM.setText("DM");
        RiwayatKeluargaDM.setName("RiwayatKeluargaDM"); // NOI18N
        FormInput.add(RiwayatKeluargaDM);
        RiwayatKeluargaDM.setBounds(160, 360, 85, 20);

        RiwayatKeluargaHepatitis.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaHepatitis.setText("Hepatitis");
        RiwayatKeluargaHepatitis.setName("RiwayatKeluargaHepatitis"); // NOI18N
        FormInput.add(RiwayatKeluargaHepatitis);
        RiwayatKeluargaHepatitis.setBounds(260, 360, 85, 20);

        RiwayatKeluargaPernapasan.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaPernapasan.setText("Pernapasan");
        RiwayatKeluargaPernapasan.setName("RiwayatKeluargaPernapasan"); // NOI18N
        FormInput.add(RiwayatKeluargaPernapasan);
        RiwayatKeluargaPernapasan.setBounds(360, 360, 85, 20);

        RiwayatKeluargaTidak.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaTidak.setText("Tidak Ada");
        RiwayatKeluargaTidak.setName("RiwayatKeluargaTidak"); // NOI18N
        FormInput.add(RiwayatKeluargaTidak);
        RiwayatKeluargaTidak.setBounds(450, 360, 85, 20);

        RiwayatKeluargaLain.setBackground(new java.awt.Color(255, 255, 255));
        RiwayatKeluargaLain.setText("Lainnya");
        RiwayatKeluargaLain.setName("RiwayatKeluargaLain"); // NOI18N
        FormInput.add(RiwayatKeluargaLain);
        RiwayatKeluargaLain.setBounds(540, 360, 85, 20);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Laboratorium:");
        jLabel63.setName("jLabel63"); // NOI18N
        FormInput.add(jLabel63);
        jLabel63.setBounds(670, 270, 80, 23);

        hb.setBackground(new java.awt.Color(255, 255, 255));
        hb.setText("Hb");
        hb.setName("hb"); // NOI18N
        hb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hbActionPerformed(evt);
            }
        });
        FormInput.add(hb);
        hb.setBounds(750, 270, 85, 20);

        golda.setBackground(new java.awt.Color(255, 255, 255));
        golda.setText("Golda");
        golda.setName("golda"); // NOI18N
        FormInput.add(golda);
        golda.setBounds(750, 290, 85, 20);

        leukosit.setBackground(new java.awt.Color(255, 255, 255));
        leukosit.setText("Leukosit");
        leukosit.setName("leukosit"); // NOI18N
        FormInput.add(leukosit);
        leukosit.setBounds(840, 290, 85, 20);

        gds.setBackground(new java.awt.Color(255, 255, 255));
        gds.setText("GDS");
        gds.setName("gds"); // NOI18N
        FormInput.add(gds);
        gds.setBounds(840, 270, 85, 20);

        ureum.setBackground(new java.awt.Color(255, 255, 255));
        ureum.setText("Ureum");
        ureum.setName("ureum"); // NOI18N
        FormInput.add(ureum);
        ureum.setBounds(930, 270, 85, 20);

        bt.setBackground(new java.awt.Color(255, 255, 255));
        bt.setText("BT");
        bt.setName("bt"); // NOI18N
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        FormInput.add(bt);
        bt.setBounds(930, 290, 85, 20);

        hbsag.setBackground(new java.awt.Color(255, 255, 255));
        hbsag.setText("HbsAg");
        hbsag.setName("hbsag"); // NOI18N
        FormInput.add(hbsag);
        hbsag.setBounds(1020, 290, 85, 20);

        creatinin.setBackground(new java.awt.Color(255, 255, 255));
        creatinin.setText("Creatinin");
        creatinin.setName("creatinin"); // NOI18N
        FormInput.add(creatinin);
        creatinin.setBounds(1020, 270, 85, 20);

        ct.setBackground(new java.awt.Color(255, 255, 255));
        ct.setText("CT");
        ct.setName("ct"); // NOI18N
        FormInput.add(ct);
        ct.setBounds(1110, 270, 85, 20);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Penunjang Lain:");
        jLabel64.setName("jLabel64"); // NOI18N
        FormInput.add(jLabel64);
        jLabel64.setBounds(670, 320, 80, 23);

        ecg.setBackground(new java.awt.Color(255, 255, 255));
        ecg.setText("ECG");
        ecg.setName("ecg"); // NOI18N
        FormInput.add(ecg);
        ecg.setBounds(750, 320, 85, 20);

        usg.setBackground(new java.awt.Color(255, 255, 255));
        usg.setText("USG");
        usg.setName("usg"); // NOI18N
        FormInput.add(usg);
        usg.setBounds(840, 320, 85, 20);

        rontgen.setBackground(new java.awt.Color(255, 255, 255));
        rontgen.setText("Rontgen");
        rontgen.setName("rontgen"); // NOI18N
        rontgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rontgenActionPerformed(evt);
            }
        });
        FormInput.add(rontgen);
        rontgen.setBounds(930, 320, 85, 20);

        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel112.setText("III. Pemeriksaan Penjunjang:");
        jLabel112.setName("jLabel112"); // NOI18N
        FormInput.add(jLabel112);
        jLabel112.setBounds(640, 240, 170, 23);

        jLabel48.setText("Anamnesa :");
        jLabel48.setName("jLabel48"); // NOI18N
        FormInput.add(jLabel48);
        jLabel48.setBounds(20, 420, 130, 30);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        Anamnesa.setColumns(20);
        Anamnesa.setRows(5);
        Anamnesa.setName("Anamnesa"); // NOI18N
        jScrollPane2.setViewportView(Anamnesa);

        FormInput.add(jScrollPane2);
        jScrollPane2.setBounds(160, 420, 400, 160);

        scrollInput.setViewportView(FormInput);

        internalFrame2.add(scrollInput, java.awt.BorderLayout.CENTER);

        TabRawat.addTab("Input Pengkajian", internalFrame2);

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
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "29-05-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "29-05-2026" }));
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

        TabRawat.addTab("Data Pengkajian", internalFrame3);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            isRawat();
        } else {
            Valid.pindah(evt, TCari, BtnDokter);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (TNoRM.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
        } else if (NmDokter.getText().trim().equals("")) {
            Valid.textKosong(BtnDokter, "Dokter");
        } else if (Diagnosa.getText().trim().equals("")) {
            Valid.textKosong(Diagnosa, "Diagnosa");
        } else if (RencanaTindakan.getText().trim().equals("")) {
            Valid.textKosong(RencanaTindakan, "Rencana Tindakan");
        } else if (RencanaTindakan.getText().trim().equals("")) {
            Valid.textKosong(RencanaTindakan, "Rencana Tindakan");
        } else {
            if (akses.getkode().equals("Admin Utama")) {
                simpan();
            } else {
                if (TanggalRegistrasi.getText().equals("")) {
                    TanggalRegistrasi.setText(Sequel.cariIsi("select concat(reg_periksa.tgl_registrasi,' ',reg_periksa.jam_reg) from reg_periksa where reg_periksa.no_rawat=?", TNoRw.getText()));
                }
                if (Sequel.cekTanggalRegistrasi(TanggalRegistrasi.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19)) == true) {
                    if (Sequel.cekTanggalRegistrasi(TanggalRegistrasi.getText(), Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19)) == true) {
                        simpan();
                    }
                }
            }
        }

    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
        } else {
            Valid.pindah(evt, tambahan, BtnBatal);
        }
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
                    if (Sequel.cekTanggal48jam(tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString(), Sequel.ambiltanggalsekarang()) == true) {
                        if (Sequel.cekTanggal48jam(tbObat.getValueAt(tbObat.getSelectedRow(), 8).toString(), Sequel.ambiltanggalsekarang()) == true) {
                            hapus();
                        }
                    }
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
        } else if (NmDokter.getText().trim().equals("")) {
            Valid.textKosong(BtnDokter, "Dokter");
        } else if (Diagnosa.getText().trim().equals("")) {
            Valid.textKosong(Diagnosa, "Diagnosa");
        } else if (RencanaTindakan.getText().trim().equals("")) {
            Valid.textKosong(RencanaTindakan, "Rencana Tindakan");
        } else if (RencanaTindakan.getText().trim().equals("")) {
            Valid.textKosong(RencanaTindakan, "Rencana Tindakan");
        } else {
            if (tbObat.getSelectedRow() > -1) {
                if (akses.getkode().equals("Admin Utama")) {
                    ganti();
                } else {
                    if (KdDokter.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
                        if (Sequel.cekTanggal48jam(tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString(), Sequel.ambiltanggalsekarang()) == true) {
                            if (Sequel.cekTanggal48jam(tbObat.getValueAt(tbObat.getSelectedRow(), 8).toString(), Sequel.ambiltanggalsekarang()) == true) {
                                if (TanggalRegistrasi.getText().equals("")) {
                                    TanggalRegistrasi.setText(Sequel.cariIsi("select concat(reg_periksa.tgl_registrasi,' ',reg_periksa.jam_reg) from reg_periksa where reg_periksa.no_rawat=?", TNoRw.getText()));
                                }
                                if (Sequel.cekTanggalRegistrasi(TanggalRegistrasi.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19)) == true) {
                                    if (Sequel.cekTanggalRegistrasi(TanggalRegistrasi.getText(), Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19)) == true) {
                                        ganti();
                                    }
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Hanya bisa diganti oleh dokter yang bersangkutan..!!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
            }
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnEditActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnHapus, BtnPrint);
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

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            BtnBatal.requestFocus();
        } else if (tabMode.getRowCount() != 0) {
            try {
                htmlContent = new StringBuilder();
                htmlContent.append(
                        "<tr class='isi'>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>No.Rawat</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>No.RM</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Nama Pasien</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Tgl.Lahir</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>J.K.</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Kode Dokter</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Nama Dokter</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Tanggal</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Tgl.Operasi</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Diagnosa</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Rencana Tindakan</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>TB</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>BB</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>TD</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>IO2</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Nadi</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Pernapasan</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Suhu</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Cardiovasculer</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Paru</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Abdomen</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Extrimitas</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Endokrin</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Ginjal</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Obat-obatan</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Laborat</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Asesmen Fisik Penunjang</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Penyakit Alergi Obat</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Penyakit Alergi Lainnya</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Penyakit Terapi</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Kebiasaan Merokok</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Jml.Rokok</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Kebiasaan Alkohol</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Jml.Alko</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Penggunaan Obat</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Obat Dikonsumsi</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Medis Cardiovasculer</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Medis Respiratory</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Medis Endocrine</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Riwayat Medis Lainnya</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Angka ASA</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Mulai Puasa</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Rencana Anestesi</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Rencana Perawatan</b></td>"
                        + "<td valign='middle' bgcolor='#FFFAF8' align='center'><b>Catatan Khusus</b></td>"
                        + "</tr>"
                );

                for (i = 0; i < tabMode.getRowCount(); i++) {
                    htmlContent.append(
                            "<tr class='isi'>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 0).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 1).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 2).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 3).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 4).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 5).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 6).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 7).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 8).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 9).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 10).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 11).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 12).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 13).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 14).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 15).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 16).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 17).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 18).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 19).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 20).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 21).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 22).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 23).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 24).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 25).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 26).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 27).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 28).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 29).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 30).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 31).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 32).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 33).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 34).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 35).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 36).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 37).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 38).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 39).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 40).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 41).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 42).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 43).toString() + "</td>"
                            + "<td valign='top'>" + tbObat.getValueAt(i, 44).toString() + "</td>"
                            + "</tr>");
                }

                LoadHTML.setText(
                        "<html>"
                        + "<table width='4500px' border='0' align='center' cellpadding='1px' cellspacing='0' class='tbl_form'>"
                        + htmlContent.toString()
                        + "</table>"
                        + "</html>"
                );

                File g = new File("file2.css");
                BufferedWriter bg = new BufferedWriter(new FileWriter(g));
                bg.write(
                        ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                        + ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"
                        + ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                        + ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                        + ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"
                        + ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"
                        + ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"
                        + ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"
                        + ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
                );
                bg.close();

                File f = new File("DataPenilaianPreAnestesi.html");
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                bw.write(LoadHTML.getText().replaceAll("<head>", "<head>"
                        + "<link href=\"file2.css\" rel=\"stylesheet\" type=\"text/css\" />"
                        + "<table width='4500px' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"
                        + "<tr class='isi2'>"
                        + "<td valign='top' align='center'>"
                        + "<font size='4' face='Tahoma'>" + akses.getnamars() + "</font><br>"
                        + akses.getalamatrs() + ", " + akses.getkabupatenrs() + ", " + akses.getpropinsirs() + "<br>"
                        + akses.getkontakrs() + ", E-mail : " + akses.getemailrs() + "<br><br>"
                        + "<font size='2' face='Tahoma'>DATA PENGKAJIAN PRE ANESTESI<br><br></font>"
                        + "</td>"
                        + "</tr>"
                        + "</table>")
                );
                bw.close();
                Desktop.getDesktop().browse(f.toURI());

            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            }
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnPrintActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

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
            if ((evt.getClickCount() == 2) && (tbObat.getSelectedColumn() == 0)) {
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

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void BtnDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokterKeyPressed
        //Valid.pindah(evt,Edukasi,Hubungan);
    }//GEN-LAST:event_BtnDokterKeyPressed

    private void TglAsuhanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TglAsuhanKeyPressed
        Valid.pindah(evt, BtnDokter, Diagnosa);
    }//GEN-LAST:event_TglAsuhanKeyPressed

    private void MnPenilaianMedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnPenilaianMedisActionPerformed
        if (tbObat.getSelectedRow() > -1) {
            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());
            param.put("alamatrs", akses.getalamatrs());
            param.put("kotars", akses.getkabupatenrs());
            param.put("propinsirs", akses.getpropinsirs());
            param.put("kontakrs", akses.getkontakrs());
            param.put("emailrs", akses.getemailrs());
            param.put("logo", Sequel.cariGambar("select setting.logo from setting"));
            finger = Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?", tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString());
            param.put("finger", "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs() + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 6).toString() + "\nID " + (finger.equals("") ? tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString() : finger) + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString()));

            Valid.MyReportqry(
                    "rptCetakPenilaianPreAnestesi.jasper", "report", "::[ Laporan Pengkajian Pre Anestesi ]::",
                    "SELECT reg_periksa.no_rawat, pasien.no_rkm_medis, pasien.nm_pasien, "
                    + "pasien.tgl_lahir, IF(pasien.jk='L','Laki-Laki','Perempuan') AS jk, "
                    + "penilaian_pre_anestesi.kd_dokter, dokter.nm_dokter, "
                    + "penilaian_pre_anestesi.tanggal, "
                    + "DATE_FORMAT(penilaian_pre_anestesi.tanggal_operasi,'%d-%m-%Y %H:%i:%s') AS tanggal_operasi, "
                    + "penilaian_pre_anestesi.diagnosa, penilaian_pre_anestesi.rencana_tindakan, "
                    + "penilaian_pre_anestesi.tb, penilaian_pre_anestesi.bb, penilaian_pre_anestesi.td, "
                    + "penilaian_pre_anestesi.nadi, penilaian_pre_anestesi.suhu, penilaian_pre_anestesi.pernapasan, "
                    + "penilaian_pre_anestesi.kesadaran, penilaian_pre_anestesi.jenis_operasi, "
                    + "penilaian_pre_anestesi.riwayat_penyakit, penilaian_pre_anestesi.pengobatan_saat_ini, "
                    + "penilaian_pre_anestesi.riwayat_operasi, penilaian_pre_anestesi.riwayat_anestesi, "
                    + "penilaian_pre_anestesi.riwayat_alergi, penilaian_pre_anestesi.riwayat_kebiasaan, "
                    + "penilaian_pre_anestesi.riwayat_penyakit_keluarga, penilaian_pre_anestesi.laboratorium, "
                    + "penilaian_pre_anestesi.penunjang_lain, " // Sesuaikan dengan field penunjang_lain
                    + "penilaian_pre_anestesi.rencana_anestesi, "
                    + "penilaian_pre_anestesi.asa AS angka_asa, " // Sesuaikan jika di Jasper memakai angka_asa
                    + "penilaian_pre_anestesi.pemberian_informasi, penilaian_pre_anestesi.informed_consent, "
                    + "penilaian_pre_anestesi.pemberian_medikasi, penilaian_pre_anestesi.persiapan_transfusi, "
                    + "penilaian_pre_anestesi.hcu_pasca_op, "
                    + "penilaian_pre_anestesi.pemeriksaan_tambahan AS tambahan, " // Alias untuk kolom tambahan
                    + "penilaian_pre_anestesi.anamnesa " // Alias untuk kolom tambahan
                    + "FROM reg_periksa "
                    + "INNER JOIN pasien ON reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "INNER JOIN penilaian_pre_anestesi ON reg_periksa.no_rawat=penilaian_pre_anestesi.no_rawat "
                    + "INNER JOIN dokter ON penilaian_pre_anestesi.kd_dokter=dokter.kd_dokter "
                    + "WHERE penilaian_pre_anestesi.no_rawat='" + tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString() + "' "
                    + "AND penilaian_pre_anestesi.tanggal='" + tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString() + "'",
                    param
            );

        }
    }//GEN-LAST:event_MnPenilaianMedisActionPerformed

    private void TglOperasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TglOperasiKeyPressed
        Valid.pindah(evt, RencanaTindakan, TB);
    }//GEN-LAST:event_TglOperasiKeyPressed

    private void DiagnosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiagnosaKeyPressed
        Valid.pindah(evt, TglAsuhan, RencanaTindakan);
    }//GEN-LAST:event_DiagnosaKeyPressed

    private void RencanaTindakanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RencanaTindakanKeyPressed
        Valid.pindah(evt, Diagnosa, TB);
    }//GEN-LAST:event_RencanaTindakanKeyPressed

    private void TBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TBKeyPressed
        Valid.pindah(evt, RencanaTindakan, BB);
    }//GEN-LAST:event_TBKeyPressed

    private void BBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BBKeyPressed
        Valid.pindah(evt, TB, TD);
    }//GEN-LAST:event_BBKeyPressed

    private void TDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDKeyPressed
        Valid.pindah(evt, BB, Nadi);
    }//GEN-LAST:event_TDKeyPressed

    private void NadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NadiKeyPressed
        Valid.pindah(evt, TD, Suhu);
    }//GEN-LAST:event_NadiKeyPressed

    private void SuhuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuhuKeyPressed
        Valid.pindah(evt, Nadi, Pernapasan);
    }//GEN-LAST:event_SuhuKeyPressed

    private void PernapasanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PernapasanKeyPressed
        Valid.pindah(evt, Suhu, Kesadaran);
    }//GEN-LAST:event_PernapasanKeyPressed

    private void RencanaAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RencanaAnestesiKeyPressed
        Valid.pindah(evt, RiwayatKebiasaan, AngkaASA);
    }//GEN-LAST:event_RencanaAnestesiKeyPressed

    private void AngkaASAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AngkaASAKeyPressed
        Valid.pindah(evt, RencanaAnestesi, RencanaAnestesi);
    }//GEN-LAST:event_AngkaASAKeyPressed

    private void medikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medikasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_medikasiActionPerformed

    private void JenisOperasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JenisOperasiKeyPressed

    }//GEN-LAST:event_JenisOperasiKeyPressed

    private void KesadaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KesadaranKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KesadaranKeyPressed

    private void RiwayatOperasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RiwayatOperasiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiwayatOperasiKeyPressed

    private void PengobatanSaatIniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PengobatanSaatIniKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PengobatanSaatIniKeyPressed

    private void RiwayatAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RiwayatAnestesiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiwayatAnestesiKeyPressed

    private void RiwayatAlergiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RiwayatAlergiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiwayatAlergiKeyPressed

    private void RiwayatKebiasaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RiwayatKebiasaanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RiwayatKebiasaanKeyPressed

    private void hbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hbActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btActionPerformed

    private void rontgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rontgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rontgenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMPenilaianPreAnastesi dialog = new RMPenilaianPreAnastesi(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextArea Anamnesa;
    private widget.ComboBox AngkaASA;
    private widget.TextBox BB;
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnDokter;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.TextBox Diagnosa;
    private widget.PanelBiasa FormInput;
    private widget.ComboBox JenisOperasi;
    private widget.TextBox Jk;
    private widget.TextBox KdDokter;
    private widget.ComboBox Kesadaran;
    private widget.Label LCount;
    private widget.editorpane LoadHTML;
    private javax.swing.JMenuItem MnPenilaianMedis;
    private widget.TextBox Nadi;
    private widget.TextBox NmDokter;
    private widget.ComboBox PengobatanSaatIni;
    private widget.TextBox Pernapasan;
    private widget.ComboBox RencanaAnestesi;
    private widget.TextBox RencanaTindakan;
    private widget.ComboBox RiwayatAlergi;
    private widget.ComboBox RiwayatAnestesi;
    private javax.swing.JCheckBox RiwayatDM;
    private javax.swing.JCheckBox RiwayatHepatitis;
    private javax.swing.JCheckBox RiwayatJantung;
    private widget.ComboBox RiwayatKebiasaan;
    private javax.swing.JCheckBox RiwayatKeluargaDM;
    private javax.swing.JCheckBox RiwayatKeluargaHepatitis;
    private javax.swing.JCheckBox RiwayatKeluargaJantung;
    private javax.swing.JCheckBox RiwayatKeluargaLain;
    private javax.swing.JCheckBox RiwayatKeluargaPernapasan;
    private javax.swing.JCheckBox RiwayatKeluargaTidak;
    private javax.swing.JCheckBox RiwayatLain;
    private widget.ComboBox RiwayatOperasi;
    private javax.swing.JCheckBox RiwayatPernapasan;
    private javax.swing.JCheckBox RiwayatTidak;
    private widget.ScrollPane Scroll;
    private widget.TextBox Suhu;
    private widget.TextBox TB;
    private widget.TextBox TCari;
    private widget.TextBox TD;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.TextBox TanggalRegistrasi;
    private widget.Tanggal TglAsuhan;
    private widget.TextBox TglLahir;
    private widget.Tanggal TglOperasi;
    private javax.swing.JCheckBox bt;
    private javax.swing.JCheckBox creatinin;
    private javax.swing.JCheckBox ct;
    private javax.swing.JCheckBox ecg;
    private javax.swing.JCheckBox gds;
    private javax.swing.JCheckBox golda;
    private javax.swing.JCheckBox hb;
    private javax.swing.JCheckBox hbsag;
    private javax.swing.JCheckBox hcu;
    private javax.swing.JCheckBox informasi;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.Label jLabel10;
    private widget.Label jLabel109;
    private widget.Label jLabel11;
    private widget.Label jLabel110;
    private widget.Label jLabel111;
    private widget.Label jLabel112;
    private widget.Label jLabel12;
    private widget.Label jLabel128;
    private widget.Label jLabel129;
    private widget.Label jLabel13;
    private widget.Label jLabel130;
    private widget.Label jLabel131;
    private widget.Label jLabel132;
    private widget.Label jLabel133;
    private widget.Label jLabel134;
    private widget.Label jLabel135;
    private widget.Label jLabel136;
    private widget.Label jLabel137;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel23;
    private widget.Label jLabel24;
    private widget.Label jLabel25;
    private widget.Label jLabel26;
    private widget.Label jLabel27;
    private widget.Label jLabel28;
    private widget.Label jLabel40;
    private widget.Label jLabel47;
    private widget.Label jLabel48;
    private widget.Label jLabel50;
    private widget.Label jLabel51;
    private widget.Label jLabel6;
    private widget.Label jLabel63;
    private widget.Label jLabel64;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private widget.Label label11;
    private widget.Label label12;
    private widget.Label label14;
    private javax.swing.JCheckBox leukosit;
    private javax.swing.JCheckBox medikasi;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private javax.swing.JCheckBox rontgen;
    private widget.ScrollPane scrollInput;
    private javax.swing.JTextArea tambahan;
    private widget.Table tbObat;
    private javax.swing.JCheckBox tindakan;
    private javax.swing.JCheckBox transfusi;
    private javax.swing.JCheckBox ureum;
    private javax.swing.JCheckBox usg;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);

        String sql
                = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,"
                + "if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,"
                + "p.tanggal,p.kd_dokter,p.tanggal_operasi,p.diagnosa,p.rencana_tindakan,"
                + "p.tb,p.bb,p.td,p.nadi,p.suhu,p.pernapasan,p.kesadaran,p.jenis_operasi,"
                + "p.riwayat_penyakit,p.pengobatan_saat_ini,p.riwayat_operasi,p.riwayat_anestesi,"
                + "p.riwayat_alergi,p.riwayat_kebiasaan,p.riwayat_penyakit_keluarga,"
                + "p.laboratorium,p.penunjang_lain,p.rencana_anestesi,p.asa,"
                + "p.pemberian_informasi,p.informed_consent,p.pemberian_medikasi,"
                + "p.persiapan_transfusi,p.hcu_pasca_op,p.pemeriksaan_tambahan,p.anamnesa,d.nm_dokter "
                + "from reg_periksa "
                + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                + "inner join penilaian_pre_anestesi p on reg_periksa.no_rawat=p.no_rawat "
                + "inner join dokter d on p.kd_dokter=d.kd_dokter "
                + "where p.tanggal between ? and ? ";

        if (!TCari.getText().trim().isEmpty()) {
            sql += "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? "
                    + "or pasien.nm_pasien like ? or p.kd_dokter like ? or d.nm_dokter like ?) ";
        }

        sql += "order by p.tanggal";

        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {

            ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
            ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

            if (!TCari.getText().trim().isEmpty()) {
                for (int i = 3; i <= 7; i++) {
                    ps.setString(i, "%" + TCari.getText().trim() + "%");
                }
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),
                        rs.getString("no_rkm_medis"),
                        rs.getString("nm_pasien"),
                        rs.getDate("tgl_lahir"),
                        rs.getString("jk"),
                        rs.getString("kd_dokter"),
                        rs.getString("nm_dokter"),
                        rs.getString("tanggal"),
                        rs.getString("tanggal_operasi"),
                        rs.getString("diagnosa"),
                        rs.getString("rencana_tindakan"),
                        rs.getString("tb"),
                        rs.getString("bb"),
                        rs.getString("td"),
                        rs.getString("nadi"),
                        rs.getString("suhu"),
                        rs.getString("pernapasan"),
                        rs.getString("kesadaran"),
                        rs.getString("jenis_operasi"),
                        rs.getString("riwayat_penyakit"),
                        rs.getString("pengobatan_saat_ini"),
                        rs.getString("riwayat_operasi"),
                        rs.getString("riwayat_anestesi"),
                        rs.getString("riwayat_alergi"),
                        rs.getString("riwayat_kebiasaan"),
                        rs.getString("riwayat_penyakit_keluarga"),
                        rs.getString("laboratorium"),
                        rs.getString("penunjang_lain"),
                        rs.getString("rencana_anestesi"),
                        rs.getString("asa"),
                        rs.getString("pemberian_informasi"),
                        rs.getString("informed_consent"),
                        rs.getString("pemberian_medikasi"),
                        rs.getString("persiapan_transfusi"),
                        rs.getString("hcu_pasca_op"),
                        rs.getString("pemeriksaan_tambahan"),
                        rs.getString("anamnesa")
                    });
                }
            }

        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }

        LCount.setText("" + tabMode.getRowCount());
    }

    public void emptTeks() {
        Diagnosa.setText("");
        RencanaTindakan.setText("");
        TglAsuhan.setDate(new Date());
        TglOperasi.setDate(new Date());
        TB.setText("");
        BB.setText("");
        TD.setText("");
        Nadi.setText("");
        Suhu.setText("");
        Pernapasan.setText("");
        Kesadaran.setSelectedIndex(0);
        JenisOperasi.setSelectedIndex(0);
        RiwayatJantung.setSelected(false);
        RiwayatDM.setSelected(false);
        RiwayatHepatitis.setSelected(false);
        RiwayatPernapasan.setSelected(false);
        RiwayatTidak.setSelected(false);
        RiwayatLain.setSelected(false);
        PengobatanSaatIni.setSelectedIndex(1);
        RiwayatOperasi.setSelectedIndex(1);
        RiwayatAnestesi.setSelectedIndex(4);
        RiwayatAlergi.setSelectedIndex(1);
        RiwayatKebiasaan.setSelectedIndex(4);
        RiwayatKeluargaJantung.setSelected(false);
        RiwayatKeluargaDM.setSelected(false);
        RiwayatKeluargaHepatitis.setSelected(false);
        RiwayatKeluargaPernapasan.setSelected(false);
        RiwayatKeluargaTidak.setSelected(false);
        RiwayatKeluargaLain.setSelected(false);
        hb.setSelected(false);
        gds.setSelected(false);
        ureum.setSelected(false);
        creatinin.setSelected(false);
        ct.setSelected(false);
        golda.setSelected(false);
        leukosit.setSelected(false);
        bt.setSelected(false);
        hbsag.setSelected(false);
        ecg.setSelected(false);
        usg.setSelected(false);
        rontgen.setSelected(false);
        AngkaASA.setSelectedIndex(0);
        TabRawat.setSelectedIndex(0);
        informasi.setSelected(false);
        tindakan.setSelected(false);
        medikasi.setSelected(false);
        transfusi.setSelected(false);
        hcu.setSelected(false);
        tambahan.setText("");
        Anamnesa.setText("");
        Diagnosa.requestFocus();
    }

    private void getData() {
        if (tbObat.getSelectedRow() != -1) {
            TNoRw.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString());
            TNoRM.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 1).toString());
            TPasien.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 2).toString());
            TglLahir.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString());
            Jk.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString());
            KdDokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString());
            NmDokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 6).toString());
            Valid.SetTgl2(TglAsuhan, tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString());
            Valid.SetTgl2(TglOperasi, tbObat.getValueAt(tbObat.getSelectedRow(), 8).toString());
            Diagnosa.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 9).toString());
            RencanaTindakan.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 10).toString());
            TB.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 11).toString());
            BB.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 12).toString());
            TD.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 13).toString());
            Nadi.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 14).toString());
            Suhu.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 15).toString());
            Pernapasan.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 16).toString());
            Kesadaran.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 17).toString());
            JenisOperasi.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 18).toString());
            tampilRiwayatPenyakit(tbObat.getValueAt(tbObat.getSelectedRow(), 19).toString());
            PengobatanSaatIni.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 20).toString());
            RiwayatOperasi.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 21).toString());
            RiwayatAnestesi.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 22).toString());
            RiwayatAlergi.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 23).toString());
            RiwayatKebiasaan.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 24).toString());
            tampilRiwayatPenyakitKeluarga(tbObat.getValueAt(tbObat.getSelectedRow(), 25).toString());
            tampilLaboratorium(tbObat.getValueAt(tbObat.getSelectedRow(), 26).toString());
            tampilPenunjang(tbObat.getValueAt(tbObat.getSelectedRow(), 27).toString());
            RencanaAnestesi.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 28).toString());
            AngkaASA.setSelectedItem(tbObat.getValueAt(tbObat.getSelectedRow(), 29).toString());
            informasi.setSelected(tbObat.getValueAt(tbObat.getSelectedRow(), 30).toString().equals("Ya"));
            tindakan.setSelected(tbObat.getValueAt(tbObat.getSelectedRow(), 31).toString().equals("Ya"));
            medikasi.setSelected(tbObat.getValueAt(tbObat.getSelectedRow(), 32).toString().equals("Ya"));
            transfusi.setSelected(tbObat.getValueAt(tbObat.getSelectedRow(), 33).toString().equals("Ya"));
            hcu.setSelected(tbObat.getValueAt(tbObat.getSelectedRow(), 34).toString().equals("Ya"));
            tambahan.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 35).toString());
            Anamnesa.setText(tbObat.getValueAt(tbObat.getSelectedRow(), 36).toString());
        }
    }

    private void isRawat() {
        try {
            ps = koneksi.prepareStatement(
                    "select reg_periksa.no_rkm_medis,pasien.nm_pasien, if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,reg_periksa.tgl_registrasi, "
                    + "reg_periksa.tgl_registrasi,reg_periksa.jam_reg from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "where reg_periksa.no_rawat=?");
            try {
                ps.setString(1, TNoRw.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    DTPCari1.setDate(rs.getDate("tgl_registrasi"));
                    TPasien.setText(rs.getString("nm_pasien"));
                    Jk.setText(rs.getString("jk"));
                    TglLahir.setText(rs.getString("tgl_lahir"));
                    TanggalRegistrasi.setText(rs.getString("tgl_registrasi") + " " + rs.getString("jam_reg"));
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
        
        getDataFromInduksi(norwt);
    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.getpenilaian_pre_anestesi());
        BtnHapus.setEnabled(akses.getpenilaian_pre_anestesi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_anestesi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_anestesi());
        if (akses.getjml2() >= 1) {
            KdDokter.setEditable(false);
            BtnDokter.setEnabled(false);
            KdDokter.setText(akses.getkode());
            NmDokter.setText(dokter.tampil3(KdDokter.getText()));
            if (NmDokter.getText().equals("")) {
                KdDokter.setText("");
                JOptionPane.showMessageDialog(null, "User login bukan Dokter...!!");
            }
        }

        if (TANGGALMUNDUR.equals("no")) {
            if (!akses.getkode().equals("Admin Utama")) {
                TglAsuhan.setEditable(false);
                TglAsuhan.setEnabled(false);
            }
        }
    }

    public void setTampil() {
        TabRawat.setSelectedIndex(1);
    }

    private void hapus() {
        if (Sequel.queryu2tf("delete from penilaian_pre_anestesi where no_rawat=? and tanggal=?", 2, new String[]{
            tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(), tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString()
        }) == true) {
            tabMode.removeRow(tbObat.getSelectedRow());
            LCount.setText("" + tabMode.getRowCount());
            TabRawat.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menghapus..!!");
        }
    }

    private void ganti() {
        String riwayatPenyakit = this.getRiwayatPenyakit();
        String riwayatPenyakitKeluarga = this.getRiwayatPenyakitKeluarga();
        String laboratorium = this.getLaboratorium();
        String penunjang = this.getPenunjang();
        String pemberianInformasi = informasi.isSelected() ? "Ya" : "Tidak";
        String informedConsent = tindakan.isSelected() ? "Ya" : "Tidak";
        String pemberianMedikasi = medikasi.isSelected() ? "Ya" : "Tidak";
        String persiapanTransfusi = transfusi.isSelected() ? "Ya" : "Tidak";
        String HCUPascaOP = hcu.isSelected() ? "Ya" : "Tidak";
        if (Sequel.mengedittf("penilaian_pre_anestesi", "no_rawat=? and tanggal=?", "no_rawat=?,tanggal=?,kd_dokter=?,tanggal_operasi=?,diagnosa=?,rencana_tindakan=?,tb=?,bb=?,td=?,nadi=?,"
                + "suhu=?,pernapasan=?,kesadaran=?,jenis_operasi=?,riwayat_penyakit=?,pengobatan_saat_ini=?,riwayat_operasi=?,riwayat_anestesi=?,riwayat_alergi=?,riwayat_kebiasaan=?,"
                + "riwayat_penyakit_keluarga=?,laboratorium=?,penunjang_lain=?,rencana_anestesi=?,asa=?,pemberian_informasi=?,informed_consent=?,pemberian_medikasi=?,persiapan_transfusi=?,"
                + "hcu_pasca_op=?,pemeriksaan_tambahan=?,anamnesa=?", 34, new String[]{
                    TNoRw.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), KdDokter.getText(),
                    Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19), Diagnosa.getText(), RencanaTindakan.getText(),
                    TB.getText(), BB.getText(), TD.getText(), Nadi.getText(), Suhu.getText(), Pernapasan.getText(), Kesadaran.getSelectedItem().toString(), JenisOperasi.getSelectedItem().toString(),
                    riwayatPenyakit, PengobatanSaatIni.getSelectedItem().toString(), RiwayatOperasi.getSelectedItem().toString(), RiwayatAnestesi.getSelectedItem().toString(),
                    RiwayatAlergi.getSelectedItem().toString(), RiwayatKebiasaan.getSelectedItem().toString(), riwayatPenyakitKeluarga, laboratorium, penunjang,
                    RencanaAnestesi.getSelectedItem().toString(), AngkaASA.getSelectedItem().toString(), pemberianInformasi, informedConsent, pemberianMedikasi,
                    persiapanTransfusi, HCUPascaOP, tambahan.getText(), Anamnesa.getText(), tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(),
                    tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString()
                }) == true) {
            tbObat.setValueAt(TNoRw.getText(), tbObat.getSelectedRow(), 0);
            tbObat.setValueAt(TNoRM.getText(), tbObat.getSelectedRow(), 1);
            tbObat.setValueAt(TPasien.getText(), tbObat.getSelectedRow(), 2);
            tbObat.setValueAt(TglLahir.getText(), tbObat.getSelectedRow(), 3);
            tbObat.setValueAt(Jk.getText(), tbObat.getSelectedRow(), 4);
            tbObat.setValueAt(KdDokter.getText(), tbObat.getSelectedRow(), 5);
            tbObat.setValueAt(NmDokter.getText(), tbObat.getSelectedRow(), 6);
            tbObat.setValueAt(Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), tbObat.getSelectedRow(), 7);
            tbObat.setValueAt(Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19), tbObat.getSelectedRow(), 8);
            tbObat.setValueAt(Diagnosa.getText(), tbObat.getSelectedRow(), 9);
            tbObat.setValueAt(RencanaTindakan.getText(), tbObat.getSelectedRow(), 10);
            tbObat.setValueAt(TB.getText(), tbObat.getSelectedRow(), 11);
            tbObat.setValueAt(BB.getText(), tbObat.getSelectedRow(), 12);
            tbObat.setValueAt(TD.getText(), tbObat.getSelectedRow(), 13);
            tbObat.setValueAt(Nadi.getText(), tbObat.getSelectedRow(), 14);
            tbObat.setValueAt(Suhu.getText(), tbObat.getSelectedRow(), 15);
            tbObat.setValueAt(Pernapasan.getText(), tbObat.getSelectedRow(), 16);
            tbObat.setValueAt(Kesadaran.getSelectedItem().toString(), tbObat.getSelectedRow(), 17);
            tbObat.setValueAt(JenisOperasi.getSelectedItem().toString(), tbObat.getSelectedRow(), 18);
            tbObat.setValueAt(riwayatPenyakit, tbObat.getSelectedRow(), 19);
            tbObat.setValueAt(PengobatanSaatIni.getSelectedItem().toString(), tbObat.getSelectedRow(), 20);
            tbObat.setValueAt(RiwayatOperasi.getSelectedItem().toString(), tbObat.getSelectedRow(), 21);
            tbObat.setValueAt(RiwayatAnestesi.getSelectedItem().toString(), tbObat.getSelectedRow(), 22);
            tbObat.setValueAt(RiwayatAlergi.getSelectedItem().toString(), tbObat.getSelectedRow(), 23);
            tbObat.setValueAt(RiwayatKebiasaan.getSelectedItem().toString(), tbObat.getSelectedRow(), 24);
            tbObat.setValueAt(riwayatPenyakitKeluarga, tbObat.getSelectedRow(), 25);
            tbObat.setValueAt(laboratorium, tbObat.getSelectedRow(), 26);
            tbObat.setValueAt(penunjang, tbObat.getSelectedRow(), 27);
            tbObat.setValueAt(RencanaAnestesi.getSelectedItem().toString(), tbObat.getSelectedRow(), 28);
            tbObat.setValueAt(AngkaASA.getSelectedItem().toString(), tbObat.getSelectedRow(), 29);
            tbObat.setValueAt(pemberianInformasi, tbObat.getSelectedRow(), 30);
            tbObat.setValueAt(informedConsent, tbObat.getSelectedRow(), 31);
            tbObat.setValueAt(pemberianMedikasi, tbObat.getSelectedRow(), 32);
            tbObat.setValueAt(persiapanTransfusi, tbObat.getSelectedRow(), 33);
            tbObat.setValueAt(HCUPascaOP, tbObat.getSelectedRow(), 34);
            tbObat.setValueAt(tambahan.getText(), tbObat.getSelectedRow(), 35);
            tbObat.setValueAt(Anamnesa.getText(), tbObat.getSelectedRow(), 36);
            emptTeks();
            TabRawat.setSelectedIndex(1);
        }
    }

    private void simpan() {
        String riwayatPenyakit = this.getRiwayatPenyakit();
        String riwayatPenyakitKeluarga = this.getRiwayatPenyakitKeluarga();
        String laboratorium = this.getLaboratorium();
        String penunjang = this.getPenunjang();
        String pemberianInformasi = informasi.isSelected() ? "Ya" : "Tidak";
        String informedConsent = tindakan.isSelected() ? "Ya" : "Tidak";
        String pemberianMedikasi = medikasi.isSelected() ? "Ya" : "Tidak";
        String persiapanTransfusi = transfusi.isSelected() ? "Ya" : "Tidak";
        String HCUPascaOP = hcu.isSelected() ? "Ya" : "Tidak";
        if (Sequel.menyimpantf("penilaian_pre_anestesi", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "No.Rawat, Tanggal & Jam", 32, new String[]{
            TNoRw.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), KdDokter.getText(),
            Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19), Diagnosa.getText(), RencanaTindakan.getText(),
            TB.getText(), BB.getText(), TD.getText(), Nadi.getText(), Suhu.getText(), Pernapasan.getText(), Kesadaran.getSelectedItem().toString(), JenisOperasi.getSelectedItem().toString(),
            riwayatPenyakit, PengobatanSaatIni.getSelectedItem().toString(), RiwayatOperasi.getSelectedItem().toString(), RiwayatAnestesi.getSelectedItem().toString(),
            RiwayatAlergi.getSelectedItem().toString(), RiwayatKebiasaan.getSelectedItem().toString(), riwayatPenyakitKeluarga, laboratorium, penunjang,
            RencanaAnestesi.getSelectedItem().toString(), AngkaASA.getSelectedItem().toString(), pemberianInformasi, informedConsent, pemberianMedikasi,
            persiapanTransfusi, HCUPascaOP, tambahan.getText(), Anamnesa.getText()
        }) == true) {
            tabMode.addRow(new Object[]{
                TNoRw.getText(), TNoRM.getText(), TPasien.getText(), TglLahir.getText(), Jk.getText(), KdDokter.getText(), NmDokter.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19),
                Valid.SetTgl(TglOperasi.getSelectedItem() + "") + " " + TglOperasi.getSelectedItem().toString().substring(11, 19), Diagnosa.getText(), RencanaTindakan.getText(), TB.getText(), BB.getText(), TD.getText(), Nadi.getText(),
                Suhu.getText(), Pernapasan.getText(), Kesadaran.getSelectedItem().toString(), JenisOperasi.getSelectedItem().toString(),
                riwayatPenyakit, PengobatanSaatIni.getSelectedItem().toString(), RiwayatOperasi.getSelectedItem().toString(), RiwayatAnestesi.getSelectedItem().toString(),
                RiwayatAlergi.getSelectedItem().toString(), RiwayatKebiasaan.getSelectedItem().toString(), riwayatPenyakitKeluarga, laboratorium, penunjang,
                RencanaAnestesi.getSelectedItem().toString(), AngkaASA.getSelectedItem().toString(), pemberianInformasi, informedConsent, pemberianMedikasi,
                persiapanTransfusi, HCUPascaOP, tambahan.getText(), Anamnesa.getText()
            });
            emptTeks();
            LCount.setText("" + tabMode.getRowCount());
        }
    }

    private String getRiwayatPenyakit() {
        String riwayat = "";

        if (RiwayatJantung.isSelected()) {
            riwayat += "Jantung,";
        }

        if (RiwayatDM.isSelected()) {
            riwayat += "DM,";
        }

        if (RiwayatHepatitis.isSelected()) {
            riwayat += "Hepatitis,";
        }

        if (RiwayatPernapasan.isSelected()) {
            riwayat += "Pernapasan,";
        }

        if (RiwayatTidak.isSelected()) {
            riwayat += "Tidak Ada,";
        }

        if (RiwayatLain.isSelected()) {
            riwayat += "Lainnya,";
        }

        if (riwayat.endsWith(",")) {
            riwayat = riwayat.substring(0, riwayat.length() - 1);
        }

        return riwayat;
    }

    private String getPenunjang() {
        String tunjang = "";
        if (ecg.isSelected()) {
            tunjang += "ECG,";
        }
        if (usg.isSelected()) {
            tunjang += "USG,";
        }
        if (rontgen.isSelected()) {
            tunjang += "RONTGEN,";
        }
        if (tunjang.endsWith(",")) {
            tunjang = tunjang.substring(0, tunjang.length() - 1);
        }
        return tunjang;
    }

    private String getLaboratorium() {
        JCheckBox[] boxes = {hb, gds, ureum, creatinin, ct, golda, leukosit, bt, hbsag};
        String[] labels = {"HB", "GDS", "UREUM", "CREATININ", "CT", "GOLDA", "LEUKOSIT", "BT", "HBSAG"};
        StringJoiner sj = new StringJoiner(",");

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].isSelected()) {
                sj.add(labels[i]);
            }
        }
        return sj.toString(); // Return di luar loop agar semua dicek
    }

    private String getRiwayatPenyakitKeluarga() {
        String riwayat = "";

        if (RiwayatKeluargaJantung.isSelected()) {
            riwayat += "Jantung,";
        }

        if (RiwayatKeluargaDM.isSelected()) {
            riwayat += "DM,";
        }

        if (RiwayatKeluargaHepatitis.isSelected()) {
            riwayat += "Hepatitis,";
        }

        if (RiwayatKeluargaPernapasan.isSelected()) {
            riwayat += "Pernapasan,";
        }

        if (RiwayatKeluargaTidak.isSelected()) {
            riwayat += "Tidak Ada,";
        }

        if (RiwayatKeluargaLain.isSelected()) {
            riwayat += "Lainnya,";
        }

        if (riwayat.endsWith(",")) {
            riwayat = riwayat.substring(0, riwayat.length() - 1);
        }

        return riwayat;
    }

    private void tampilRiwayatPenyakit(String data) {
        RiwayatJantung.setSelected(false);
        RiwayatDM.setSelected(false);
        RiwayatHepatitis.setSelected(false);
        RiwayatPernapasan.setSelected(false);
        RiwayatTidak.setSelected(false);
        RiwayatLain.setSelected(false);

        if (data.trim().isEmpty()) {
            return;
        }

        String[] dipilih = data.split(",");

        for (String s : dipilih) {
            if (s.trim().equals("Jantung")) {
                RiwayatJantung.setSelected(true);
            }
            if (s.trim().equals("DM")) {
                RiwayatDM.setSelected(true);
            }
            if (s.trim().equals("Hepatitis")) {
                RiwayatHepatitis.setSelected(true);
            }
            if (s.trim().equals("Pernapasan")) {
                RiwayatPernapasan.setSelected(true);
            }
            if (s.trim().equals("Tidak Ada")) {
                RiwayatTidak.setSelected(true);
            }
            if (s.trim().equals("Lainnya")) {
                RiwayatLain.setSelected(true);
            }
        }
    }

    private void tampilRiwayatPenyakitKeluarga(String data) {
        RiwayatKeluargaJantung.setSelected(false);
        RiwayatKeluargaDM.setSelected(false);
        RiwayatKeluargaHepatitis.setSelected(false);
        RiwayatKeluargaPernapasan.setSelected(false);
        RiwayatKeluargaTidak.setSelected(false);
        RiwayatKeluargaLain.setSelected(false);

        if (data.trim().isEmpty()) {
            return;
        }

        String[] dipilih = data.split(",");

        for (String s : dipilih) {
            if (s.trim().equals("Jantung")) {
                RiwayatKeluargaJantung.setSelected(true);
            }
            if (s.trim().equals("DM")) {
                RiwayatKeluargaDM.setSelected(true);
            }
            if (s.trim().equals("Hepatitis")) {
                RiwayatKeluargaHepatitis.setSelected(true);
            }
            if (s.trim().equals("Pernapasan")) {
                RiwayatKeluargaPernapasan.setSelected(true);
            }
            if (s.trim().equals("Tidak Ada")) {
                RiwayatKeluargaTidak.setSelected(true);
            }
            if (s.trim().equals("Lainnya")) {
                RiwayatKeluargaLain.setSelected(true);
            }
        }
    }

    private void tampilLaboratorium(String data) {
        hb.setSelected(false);
        gds.setSelected(false);
        ureum.setSelected(false);
        creatinin.setSelected(false);
        ct.setSelected(false);
        golda.setSelected(false);
        leukosit.setSelected(false);
        bt.setSelected(false);
        hbsag.setSelected(false);
        if (data.trim().isEmpty()) {
            return;
        }

        String[] dipilih = data.split(",");

        for (String s : dipilih) {
            if (s.trim().equals("HB")) {
                hb.setSelected(true);
            }
            if (s.trim().equals("GDS")) {
                gds.setSelected(true);
            }
            if (s.trim().equals("UREUM")) {
                ureum.setSelected(true);
            }
            if (s.trim().equals("CREATININ")) {
                creatinin.setSelected(true);
            }
            if (s.trim().equals("CT")) {
                ct.setSelected(true);
            }
            if (s.trim().equals("GOLDA")) {
                golda.setSelected(true);
            }
            if (s.trim().equals("LEUKOSIT")) {
                leukosit.setSelected(true);
            }
            if (s.trim().equals("BT")) {
                bt.setSelected(true);
            }
            if (s.trim().equals("HBSAG")) {
                hbsag.setSelected(true);
            }
        }
    }

    private void tampilPenunjang(String data) {
        ecg.setSelected(false);
        usg.setSelected(false);
        rontgen.setSelected(false);

        if (data.trim().isEmpty()) {
            return;
        }

        String[] dipilih = data.split(",");
        for (String s : dipilih) {
            if (s.trim().equals("ECG")) {
                ecg.setSelected(true);
            }
            if (s.trim().equals("USG")) {
                usg.setSelected(true);
            }
            if (s.trim().equals("RONTGEN")) {
                rontgen.setSelected(true);
            }
        }
    }
    
    private void getDataFromInduksi(String norwt) {
        try {
            ps = koneksi.prepareStatement(
                    "select bb, tensi, nadi, suhu, rr, laboratorium, penunjang_lain, rencana_anestesi, klasifikasiasa "
                    + "from penilaian_pre_induksi where no_rawat = ?"
            );
            
            try {
                ps.setString(1, norwt);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    TD.setText(rs.getString("tensi"));
                    Nadi.setText(rs.getString("nadi"));
                    Pernapasan.setText(rs.getString("rr"));
                    Suhu.setText(rs.getString("suhu"));
                    BB.setText(rs.getString("bb"));
                    if (rs.getString("klasifikasiasa").equals("E")) {
                        AngkaASA.setSelectedItem(rs.getString("klasifikasiasa"));
                    } else {
                        AngkaASA.setSelectedItem(rs.getString("klasifikasiasa").replace("ASA ", ""));
                    }
                    
                    RencanaAnestesi.setSelectedItem(rs.getString("rencana_anestesi"));
                    tampilLaboratorium(rs.getString("laboratorium"));
                    tampilPenunjang(rs.getString("penunjang_lain"));
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
}
