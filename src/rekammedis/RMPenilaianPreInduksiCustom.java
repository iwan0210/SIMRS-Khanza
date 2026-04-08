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
import javax.swing.JCheckBox;
import java.util.StringJoiner;
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
public final class RMPenilaianPreInduksiCustom extends javax.swing.JDialog {

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

    /**
     * Creates new form DlgRujuk
     *
     * @param parent
     * @param modal
     */
    public RMPenilaianPreInduksiCustom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "J.K.", "Tgl Lahir", "Tanggal",
            "Kode Dokter", "Nama Dokter", "TD(mmHg)", "Nadi(x/menit)", "RR(x/menit)",
            "Suhu(°C)", "Berat(Kg)", "Skala Nyeri", "Keadaan Umum", "Kesadaran",
            "Sifat Operasi", "Syaraf", "Kardiovaskuler", "Urinarius", "Respiratori",
            "Gastrointestinal", "Muskuloskeletal", "Metabolik", "Medikamentosa",
            "Lab", "Penunjang", "Lain-lain", "Pemeriksaan Fisik", "Premedikasi",
            "Rencana Anestesi", "Klasifikasi ASA", "Pasca Anestesi", "Monitoring"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

        };

        tbObat.setModel(tabMode);
        tbObat.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // PERBAIKAN: Ubah loop dari 49 menjadi 53
        for (i = 0; i < 34; i++) {  // ✅ BENAR: untuk 53 kolom (indeks 0-52)
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
                column.setPreferredWidth(60);
            } else if (i == 9) {
                column.setPreferredWidth(75);
            } else if (i == 10) {
                column.setPreferredWidth(67);
            } else if (i == 11) {
                column.setPreferredWidth(52);
            } else if (i == 12) {
                column.setPreferredWidth(150);
            } else if (i == 13) {
                column.setPreferredWidth(150);
            } else if (i == 14) {
                column.setPreferredWidth(215);
            } else if (i == 15) {
                column.setPreferredWidth(250);
            } else if (i == 16) {
                column.setPreferredWidth(250);
            } else if (i == 17) {
                column.setPreferredWidth(150);
            } else if (i == 18) {
                column.setPreferredWidth(95);
            } else if (i == 19) {
                column.setPreferredWidth(67);
            } else if (i == 20) {
                column.setPreferredWidth(150);
            } else if (i == 21) {
                column.setPreferredWidth(54);
            } else if (i == 22) {
                column.setPreferredWidth(150);
            } else if (i == 23) {
                column.setPreferredWidth(74);
            } else if (i == 24) {
                column.setPreferredWidth(106);
            } else if (i == 25) {
                column.setPreferredWidth(100);
            } else if (i == 26) {
                column.setPreferredWidth(100);
            } else if (i == 27) {
                column.setPreferredWidth(100);
            } else if (i == 28) {
                column.setPreferredWidth(100);
            } else if (i == 29) {
                column.setPreferredWidth(100);
            } else if (i == 30) {
                column.setPreferredWidth(170);
            } else if (i == 31) {
                column.setPreferredWidth(170);
            } else if (i == 32) {
                column.setPreferredWidth(170);
            } else if (i == 33) {
                column.setPreferredWidth(170);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
        TNoRw.setDocument(new batasInput((byte) 17).getKata(TNoRw));
        KdDokter.setDocument(new batasInput((int) 20).getKata(KdDokter)); // Tambahkan ini
        TD.setDocument(new batasInput((int) 8).getKata(TD));
        Nadi.setDocument(new batasInput((int) 5).getKata(Nadi));
        RR.setDocument(new batasInput((int) 5).getKata(RR));
        Suhu.setDocument(new batasInput((int) 5).getKata(Suhu));
        Lainlain.setDocument(new batasInput((int) 50).getKata(Lainlain));
        Premedikasi.setDocument(new batasInput((int) 50).getKata(Premedikasi));

        TglLahir.setDocument(new batasInput((int) 10).getKata(TglLahir));
        Jk.setDocument(new batasInput((int) 10).getKata(Jk));
        Berat.setDocument(new batasInput((int) 5).getKata(Berat));
        Nyeri.setDocument(new batasInput((int) 20).getKata(Nyeri));
        KeadaanUmum.setDocument(new batasInput((int) 60).getKata(KeadaanUmum));

// Sistem Tubuh (Sesuaikan panjang karakter berdasarkan kebutuhan database)
        Syaraf.setDocument(new batasInput((int) 100).getKata(Syaraf));
        kardiosvakuler.setDocument(new batasInput((int) 100).getKata(kardiosvakuler));
        Urinarius.setDocument(new batasInput((int) 100).getKata(Urinarius));
        Respiratori.setDocument(new batasInput((int) 100).getKata(Respiratori));
        gastrointestinal.setDocument(new batasInput((int) 100).getKata(gastrointestinal));
        Muskuloskelatal.setDocument(new batasInput((int) 100).getKata(Muskuloskelatal));
        Metabolik.setDocument(new batasInput((int) 100).getKata(Metabolik));
        Medikamentosa.setDocument(new batasInput((int) 200).getKata(Medikamentosa));
        Pemeriksaan.setDocument(new batasInput((int) 300).getKata(Pemeriksaan));

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
        jSeparator2 = new javax.swing.JSeparator();
        jLabel15 = new widget.Label();
        jLabel16 = new widget.Label();
        Syaraf = new widget.TextBox();
        jLabel22 = new widget.Label();
        TD = new widget.TextBox();
        jLabel23 = new widget.Label();
        jLabel125 = new widget.Label();
        Kesadaran = new widget.ComboBox();
        jLabel25 = new widget.Label();
        jLabel18 = new widget.Label();
        Nadi = new widget.TextBox();
        jLabel20 = new widget.Label();
        jLabel26 = new widget.Label();
        RR = new widget.TextBox();
        jLabel27 = new widget.Label();
        jLabel28 = new widget.Label();
        Suhu = new widget.TextBox();
        jLabel30 = new widget.Label();
        jLabel17 = new widget.Label();
        jLabel31 = new widget.Label();
        jLabel127 = new widget.Label();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel24 = new widget.Label();
        tindakananestesi = new widget.ComboBox();
        jLabel32 = new widget.Label();
        Premedikasi = new widget.TextBox();
        klasifikasiASA = new widget.ComboBox();
        jLabel40 = new widget.Label();
        jLabel145 = new widget.Label();
        jLabel41 = new widget.Label();
        ekg = new javax.swing.JCheckBox();
        sp = new javax.swing.JCheckBox();
        nibp = new javax.swing.JCheckBox();
        temp = new javax.swing.JCheckBox();
        cvp = new javax.swing.JCheckBox();
        etc = new javax.swing.JCheckBox();
        areteri = new javax.swing.JCheckBox();
        nadi = new javax.swing.JCheckBox();
        jLabel29 = new widget.Label();
        Berat = new widget.TextBox();
        jLabel35 = new widget.Label();
        KeadaanUmum = new widget.TextBox();
        jLabel53 = new widget.Label();
        Nyeri = new widget.TextBox();
        jLabel126 = new widget.Label();
        SifatOp = new widget.ComboBox();
        jLabel54 = new widget.Label();
        gastrointestinal = new widget.TextBox();
        jLabel55 = new widget.Label();
        Urinarius = new widget.TextBox();
        jLabel56 = new widget.Label();
        Muskuloskelatal = new widget.TextBox();
        jLabel57 = new widget.Label();
        Pemeriksaan = new widget.TextBox();
        jLabel58 = new widget.Label();
        Respiratori = new widget.TextBox();
        jLabel59 = new widget.Label();
        kardiosvakuler = new widget.TextBox();
        jLabel60 = new widget.Label();
        Lainlain = new widget.TextBox();
        jLabel61 = new widget.Label();
        Medikamentosa = new widget.TextBox();
        jLabel62 = new widget.Label();
        gds = new javax.swing.JCheckBox();
        golda = new javax.swing.JCheckBox();
        bt = new javax.swing.JCheckBox();
        creatinin = new javax.swing.JCheckBox();
        ct = new javax.swing.JCheckBox();
        leukosit = new javax.swing.JCheckBox();
        hb = new javax.swing.JCheckBox();
        hbsag = new javax.swing.JCheckBox();
        ureum = new javax.swing.JCheckBox();
        jLabel63 = new widget.Label();
        ecg = new javax.swing.JCheckBox();
        usg = new javax.swing.JCheckBox();
        rontgen = new javax.swing.JCheckBox();
        jLabel64 = new widget.Label();
        Metabolik = new widget.TextBox();
        PascaAnestesi = new widget.ComboBox();
        jLabel65 = new widget.Label();
        TglAsuhan = new widget.Tanggal();
        internalFrame3 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbObat = new widget.Table();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        jLabel6 = new widget.Label();

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnPenilaianMedis.setBackground(new java.awt.Color(255, 255, 254));
        MnPenilaianMedis.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnPenilaianMedis.setForeground(new java.awt.Color(50, 50, 50));
        MnPenilaianMedis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnPenilaianMedis.setText("Laporan Pengkajian Pre Induksi");
        MnPenilaianMedis.setName("MnPenilaianMedis"); // NOI18N
        MnPenilaianMedis.setPreferredSize(new java.awt.Dimension(220, 26));
        MnPenilaianMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnPenilaianMedisActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnPenilaianMedis);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Pengkajian Pre Induksi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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
        TabRawat.setMinimumSize(new java.awt.Dimension(554, 133));
        TabRawat.setName("TabRawat"); // NOI18N
        TabRawat.setPreferredSize(new java.awt.Dimension(457, 480));

        internalFrame2.setBorder(null);
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setPreferredSize(new java.awt.Dimension(102, 480));
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        scrollInput.setName("scrollInput"); // NOI18N
        scrollInput.setPreferredSize(new java.awt.Dimension(102, 700));

        FormInput.setBackground(new java.awt.Color(255, 255, 255));
        FormInput.setBorder(null);
        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(750, 445));
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

        jSeparator2.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator2.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator2.setName("jSeparator2"); // NOI18N
        FormInput.add(jSeparator2);
        jSeparator2.setBounds(0, 70, 750, 1);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Keadaan Umum :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(12, 110, 110, 23);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Sistem Saraf :");
        jLabel16.setName("jLabel16"); // NOI18N
        FormInput.add(jLabel16);
        jLabel16.setBounds(40, 140, 70, 23);

        Syaraf.setFocusTraversalPolicyProvider(true);
        Syaraf.setName("Syaraf"); // NOI18N
        Syaraf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyarafActionPerformed(evt);
            }
        });
        Syaraf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SyarafKeyPressed(evt);
            }
        });
        FormInput.add(Syaraf);
        Syaraf.setBounds(120, 140, 270, 23);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Tensi Darah");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(12, 80, 70, 23);

        TD.setFocusTraversalPolicyProvider(true);
        TD.setName("TD"); // NOI18N
        TD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TDKeyPressed(evt);
            }
        });
        FormInput.add(TD);
        TD.setBounds(82, 80, 76, 23);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("mmHg");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(161, 80, 50, 23);

        jLabel125.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel125.setText("Kesadaran");
        jLabel125.setName("jLabel125"); // NOI18N
        FormInput.add(jLabel125);
        jLabel125.setBounds(430, 110, 60, 23);

        Kesadaran.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compos Mentis", "Apatis", "Somnolen", "Sopor", "Soporocoma", "Coma" }));
        Kesadaran.setName("Kesadaran"); // NOI18N
        Kesadaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KesadaranKeyPressed(evt);
            }
        });
        FormInput.add(Kesadaran);
        Kesadaran.setBounds(490, 110, 120, 23);

        jLabel25.setText(":");
        jLabel25.setName("jLabel25"); // NOI18N
        FormInput.add(jLabel25);
        jLabel25.setBounds(0, 80, 78, 23);

        jLabel18.setText("Nadi :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(236, 80, 40, 23);

        Nadi.setFocusTraversalPolicyProvider(true);
        Nadi.setName("Nadi"); // NOI18N
        Nadi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NadiKeyPressed(evt);
            }
        });
        FormInput.add(Nadi);
        Nadi.setBounds(280, 80, 60, 23);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("x/menit");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(343, 80, 50, 23);

        jLabel26.setText("Premedikasi :");
        jLabel26.setName("jLabel26"); // NOI18N
        FormInput.add(jLabel26);
        jLabel26.setBounds(690, 270, 80, 23);

        RR.setFocusTraversalPolicyProvider(true);
        RR.setName("RR"); // NOI18N
        RR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RRKeyPressed(evt);
            }
        });
        FormInput.add(RR);
        RR.setBounds(457, 80, 60, 23);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("x/menit");
        jLabel27.setName("jLabel27"); // NOI18N
        FormInput.add(jLabel27);
        jLabel27.setBounds(520, 80, 50, 23);

        jLabel28.setText("Suhu :");
        jLabel28.setName("jLabel28"); // NOI18N
        FormInput.add(jLabel28);
        jLabel28.setBounds(601, 80, 40, 23);

        Suhu.setFocusTraversalPolicyProvider(true);
        Suhu.setName("Suhu"); // NOI18N
        Suhu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SuhuKeyPressed(evt);
            }
        });
        FormInput.add(Suhu);
        Suhu.setBounds(645, 80, 60, 23);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("°C");
        jLabel30.setName("jLabel30"); // NOI18N
        FormInput.add(jLabel30);
        jLabel30.setBounds(708, 80, 30, 23);

        jLabel17.setText(":");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(0, 110, 39, 23);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Rencana Tindakan Anestesi:");
        jLabel31.setName("jLabel31"); // NOI18N
        FormInput.add(jLabel31);
        jLabel31.setBounds(710, 300, 160, 23);

        jLabel127.setText(":");
        jLabel127.setName("jLabel127"); // NOI18N
        FormInput.add(jLabel127);
        jLabel127.setBounds(0, 140, 62, 23);

        jSeparator3.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator3.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator3.setName("jSeparator3"); // NOI18N
        FormInput.add(jSeparator3);
        jSeparator3.setBounds(0, 200, 750, 1);

        jSeparator4.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator4.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator4.setName("jSeparator4"); // NOI18N
        FormInput.add(jSeparator4);
        jSeparator4.setBounds(0, 200, 750, 1);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Pemeriksaan Penunjang :");
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N
        FormInput.add(jLabel24);
        jLabel24.setBounds(10, 230, 150, 23);

        tindakananestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "General Anestesi", "Anestesi Sedang / Dalam", "Regional Anestesi - SAB", "Regional Anestesi - Epidural" }));
        tindakananestesi.setName("tindakananestesi"); // NOI18N
        tindakananestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tindakananestesiKeyPressed(evt);
            }
        });
        FormInput.add(tindakananestesi);
        tindakananestesi.setBounds(860, 300, 180, 23);

        jLabel32.setText("RR :");
        jLabel32.setName("jLabel32"); // NOI18N
        FormInput.add(jLabel32);
        jLabel32.setBounds(413, 80, 40, 23);

        Premedikasi.setFocusTraversalPolicyProvider(true);
        Premedikasi.setName("Premedikasi"); // NOI18N
        Premedikasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PremedikasiKeyPressed(evt);
            }
        });
        FormInput.add(Premedikasi);
        Premedikasi.setBounds(780, 270, 332, 23);

        klasifikasiASA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ASA 1", "ASA 2", "ASA 3", "ASA 4", "ASA 5", "ASA 6", "E" }));
        klasifikasiASA.setName("klasifikasiASA"); // NOI18N
        klasifikasiASA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                klasifikasiASAKeyPressed(evt);
            }
        });
        FormInput.add(klasifikasiASA);
        klasifikasiASA.setBounds(790, 240, 100, 23);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("Klasifikasi ASA :");
        jLabel40.setName("jLabel40"); // NOI18N
        FormInput.add(jLabel40);
        jLabel40.setBounds(700, 240, 80, 23);

        jLabel145.setText(":");
        jLabel145.setName("jLabel145"); // NOI18N
        FormInput.add(jLabel145);
        jLabel145.setBounds(720, 330, 70, 20);

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Monitoring");
        jLabel41.setName("jLabel41"); // NOI18N
        FormInput.add(jLabel41);
        jLabel41.setBounds(710, 330, 80, 23);

        ekg.setBackground(new java.awt.Color(255, 255, 255));
        ekg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ekg.setText("EKG Lead");
        ekg.setName("ekg"); // NOI18N
        FormInput.add(ekg);
        ekg.setBounds(800, 330, 85, 19);

        sp.setBackground(new java.awt.Color(255, 255, 255));
        sp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sp.setText("SpO2");
        sp.setName("sp"); // NOI18N
        FormInput.add(sp);
        sp.setBounds(910, 330, 85, 19);

        nibp.setBackground(new java.awt.Color(255, 255, 255));
        nibp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nibp.setText("NIBP");
        nibp.setName("nibp"); // NOI18N
        FormInput.add(nibp);
        nibp.setBounds(1010, 330, 70, 19);

        temp.setBackground(new java.awt.Color(255, 255, 255));
        temp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        temp.setText("Temperature");
        temp.setName("temp"); // NOI18N
        FormInput.add(temp);
        temp.setBounds(1090, 330, 100, 19);

        cvp.setBackground(new java.awt.Color(255, 255, 255));
        cvp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cvp.setText("CVP");
        cvp.setName("cvp"); // NOI18N
        FormInput.add(cvp);
        cvp.setBounds(1010, 350, 80, 20);

        etc.setBackground(new java.awt.Color(255, 255, 255));
        etc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        etc.setText("ET CO2");
        etc.setName("etc"); // NOI18N
        FormInput.add(etc);
        etc.setBounds(1090, 350, 85, 19);

        areteri.setBackground(new java.awt.Color(255, 255, 255));
        areteri.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areteri.setText("Areteri Line");
        areteri.setName("areteri"); // NOI18N
        FormInput.add(areteri);
        areteri.setBounds(800, 350, 110, 19);

        nadi.setBackground(new java.awt.Color(255, 255, 255));
        nadi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nadi.setText("HR/Nadi");
        nadi.setName("nadi"); // NOI18N
        FormInput.add(nadi);
        nadi.setBounds(910, 350, 85, 19);

        jLabel29.setText("BB :");
        jLabel29.setName("jLabel29"); // NOI18N
        FormInput.add(jLabel29);
        jLabel29.setBounds(740, 80, 40, 23);

        Berat.setFocusTraversalPolicyProvider(true);
        Berat.setName("Berat"); // NOI18N
        Berat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BeratKeyPressed(evt);
            }
        });
        FormInput.add(Berat);
        Berat.setBounds(780, 80, 60, 23);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Kg");
        jLabel35.setName("jLabel35"); // NOI18N
        FormInput.add(jLabel35);
        jLabel35.setBounds(850, 80, 30, 23);

        KeadaanUmum.setFocusTraversalPolicyProvider(true);
        KeadaanUmum.setName("KeadaanUmum"); // NOI18N
        KeadaanUmum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeadaanUmumKeyPressed(evt);
            }
        });
        FormInput.add(KeadaanUmum);
        KeadaanUmum.setBounds(110, 110, 293, 23);

        jLabel53.setText("Nyeri :");
        jLabel53.setName("jLabel53"); // NOI18N
        FormInput.add(jLabel53);
        jLabel53.setBounds(890, 80, 40, 23);

        Nyeri.setFocusTraversalPolicyProvider(true);
        Nyeri.setName("Nyeri"); // NOI18N
        Nyeri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NyeriKeyPressed(evt);
            }
        });
        FormInput.add(Nyeri);
        Nyeri.setBounds(940, 80, 70, 23);

        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel126.setText("Sifat Operasi :");
        jLabel126.setName("jLabel126"); // NOI18N
        FormInput.add(jLabel126);
        jLabel126.setBounds(630, 110, 90, 23);

        SifatOp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elektif", "Cito" }));
        SifatOp.setName("SifatOp"); // NOI18N
        SifatOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SifatOpActionPerformed(evt);
            }
        });
        SifatOp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SifatOpKeyPressed(evt);
            }
        });
        FormInput.add(SifatOp);
        SifatOp.setBounds(710, 110, 120, 23);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel54.setText("Sistem Gastrointestinal :");
        jLabel54.setName("jLabel54"); // NOI18N
        FormInput.add(jLabel54);
        jLabel54.setBounds(400, 170, 140, 23);

        gastrointestinal.setFocusTraversalPolicyProvider(true);
        gastrointestinal.setName("gastrointestinal"); // NOI18N
        gastrointestinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gastrointestinalKeyPressed(evt);
            }
        });
        FormInput.add(gastrointestinal);
        gastrointestinal.setBounds(530, 170, 270, 23);

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel55.setText("Sistem Urinarius :");
        jLabel55.setName("jLabel55"); // NOI18N
        FormInput.add(jLabel55);
        jLabel55.setBounds(810, 140, 110, 23);

        Urinarius.setFocusTraversalPolicyProvider(true);
        Urinarius.setName("Urinarius"); // NOI18N
        Urinarius.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UrinariusKeyPressed(evt);
            }
        });
        FormInput.add(Urinarius);
        Urinarius.setBounds(900, 140, 270, 23);

        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("Sistem Muskuloskelatal :");
        jLabel56.setName("jLabel56"); // NOI18N
        FormInput.add(jLabel56);
        jLabel56.setBounds(810, 170, 130, 23);

        Muskuloskelatal.setFocusTraversalPolicyProvider(true);
        Muskuloskelatal.setName("Muskuloskelatal"); // NOI18N
        Muskuloskelatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MuskuloskelatalKeyPressed(evt);
            }
        });
        FormInput.add(Muskuloskelatal);
        Muskuloskelatal.setBounds(940, 170, 270, 23);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Hasil Pemeriksaan:");
        jLabel57.setName("jLabel57"); // NOI18N
        FormInput.add(jLabel57);
        jLabel57.setBounds(50, 340, 110, 23);

        Pemeriksaan.setFocusTraversalPolicyProvider(true);
        Pemeriksaan.setName("Pemeriksaan"); // NOI18N
        Pemeriksaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PemeriksaanKeyPressed(evt);
            }
        });
        FormInput.add(Pemeriksaan);
        Pemeriksaan.setBounds(150, 340, 270, 23);

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Sistem Respiratori :");
        jLabel58.setName("jLabel58"); // NOI18N
        FormInput.add(jLabel58);
        jLabel58.setBounds(10, 170, 110, 23);

        Respiratori.setFocusTraversalPolicyProvider(true);
        Respiratori.setName("Respiratori"); // NOI18N
        Respiratori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RespiratoriKeyPressed(evt);
            }
        });
        FormInput.add(Respiratori);
        Respiratori.setBounds(120, 170, 270, 20);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("Sistem Kardiovaskuler :");
        jLabel59.setName("jLabel59"); // NOI18N
        FormInput.add(jLabel59);
        jLabel59.setBounds(400, 140, 130, 23);

        kardiosvakuler.setFocusTraversalPolicyProvider(true);
        kardiosvakuler.setName("kardiosvakuler"); // NOI18N
        kardiosvakuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kardiosvakulerActionPerformed(evt);
            }
        });
        kardiosvakuler.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kardiosvakulerKeyPressed(evt);
            }
        });
        FormInput.add(kardiosvakuler);
        kardiosvakuler.setBounds(530, 140, 270, 23);

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Lain - lain :");
        jLabel60.setName("jLabel60"); // NOI18N
        FormInput.add(jLabel60);
        jLabel60.setBounds(410, 200, 110, 23);

        Lainlain.setFocusTraversalPolicyProvider(true);
        Lainlain.setName("Lainlain"); // NOI18N
        Lainlain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LainlainKeyPressed(evt);
            }
        });
        FormInput.add(Lainlain);
        Lainlain.setBounds(480, 199, 270, 24);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel61.setText("Terapi Medikamentosa :");
        jLabel61.setName("jLabel61"); // NOI18N
        FormInput.add(jLabel61);
        jLabel61.setBounds(770, 200, 150, 23);

        Medikamentosa.setFocusTraversalPolicyProvider(true);
        Medikamentosa.setName("Medikamentosa"); // NOI18N
        Medikamentosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MedikamentosaKeyPressed(evt);
            }
        });
        FormInput.add(Medikamentosa);
        Medikamentosa.setBounds(890, 200, 270, 23);

        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel62.setText("Sistem Metabolik :");
        jLabel62.setName("jLabel62"); // NOI18N
        FormInput.add(jLabel62);
        jLabel62.setBounds(20, 200, 110, 23);

        gds.setBackground(new java.awt.Color(255, 255, 255));
        gds.setText("GDS");
        gds.setName("gds"); // NOI18N
        FormInput.add(gds);
        gds.setBounds(220, 260, 85, 20);

        golda.setBackground(new java.awt.Color(255, 255, 255));
        golda.setText("Golda");
        golda.setName("golda"); // NOI18N
        FormInput.add(golda);
        golda.setBounds(130, 280, 85, 20);

        bt.setBackground(new java.awt.Color(255, 255, 255));
        bt.setText("BT");
        bt.setName("bt"); // NOI18N
        bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionPerformed(evt);
            }
        });
        FormInput.add(bt);
        bt.setBounds(310, 280, 85, 20);

        creatinin.setBackground(new java.awt.Color(255, 255, 255));
        creatinin.setText("Creatinin");
        creatinin.setName("creatinin"); // NOI18N
        FormInput.add(creatinin);
        creatinin.setBounds(400, 260, 85, 20);

        ct.setBackground(new java.awt.Color(255, 255, 255));
        ct.setText("CT");
        ct.setName("ct"); // NOI18N
        FormInput.add(ct);
        ct.setBounds(490, 260, 85, 20);

        leukosit.setBackground(new java.awt.Color(255, 255, 255));
        leukosit.setText("Leukosit");
        leukosit.setName("leukosit"); // NOI18N
        FormInput.add(leukosit);
        leukosit.setBounds(220, 280, 85, 20);

        hb.setBackground(new java.awt.Color(255, 255, 255));
        hb.setText("Hb");
        hb.setName("hb"); // NOI18N
        hb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hbActionPerformed(evt);
            }
        });
        FormInput.add(hb);
        hb.setBounds(130, 260, 85, 20);

        hbsag.setBackground(new java.awt.Color(255, 255, 255));
        hbsag.setText("HbsAg");
        hbsag.setName("hbsag"); // NOI18N
        FormInput.add(hbsag);
        hbsag.setBounds(400, 280, 85, 20);

        ureum.setBackground(new java.awt.Color(255, 255, 255));
        ureum.setText("Ureum");
        ureum.setName("ureum"); // NOI18N
        FormInput.add(ureum);
        ureum.setBounds(310, 260, 85, 20);

        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel63.setText("Laboratorium:");
        jLabel63.setName("jLabel63"); // NOI18N
        FormInput.add(jLabel63);
        jLabel63.setBounds(50, 260, 80, 23);

        ecg.setBackground(new java.awt.Color(255, 255, 255));
        ecg.setText("ECG");
        ecg.setName("ecg"); // NOI18N
        FormInput.add(ecg);
        ecg.setBounds(130, 310, 85, 20);

        usg.setBackground(new java.awt.Color(255, 255, 255));
        usg.setText("USG");
        usg.setName("usg"); // NOI18N
        FormInput.add(usg);
        usg.setBounds(220, 310, 85, 20);

        rontgen.setBackground(new java.awt.Color(255, 255, 255));
        rontgen.setText("Rontgen");
        rontgen.setName("rontgen"); // NOI18N
        rontgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rontgenActionPerformed(evt);
            }
        });
        FormInput.add(rontgen);
        rontgen.setBounds(310, 310, 85, 20);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel64.setText("Penunjang Lain:");
        jLabel64.setName("jLabel64"); // NOI18N
        FormInput.add(jLabel64);
        jLabel64.setBounds(50, 310, 80, 23);

        Metabolik.setFocusTraversalPolicyProvider(true);
        Metabolik.setName("Metabolik"); // NOI18N
        Metabolik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MetabolikKeyPressed(evt);
            }
        });
        FormInput.add(Metabolik);
        Metabolik.setBounds(120, 199, 270, 24);

        PascaAnestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rawat Jalan", "Rawat Inap", "HCU" }));
        PascaAnestesi.setName("PascaAnestesi"); // NOI18N
        PascaAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PascaAnestesiKeyPressed(evt);
            }
        });
        FormInput.add(PascaAnestesi);
        PascaAnestesi.setBounds(840, 380, 110, 23);

        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel65.setText("Perawatan Pasca Anestesi :");
        jLabel65.setName("jLabel65"); // NOI18N
        FormInput.add(jLabel65);
        jLabel65.setBounds(700, 380, 140, 23);

        TglAsuhan.setForeground(new java.awt.Color(50, 70, 50));
        TglAsuhan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15-01-2026 16:30:27" }));
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
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15-01-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "15-01-2026" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari2);

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

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass9.add(jLabel6);

        internalFrame3.add(panelGlass9, java.awt.BorderLayout.PAGE_END);

        TabRawat.addTab("Data Pengkajian", internalFrame3);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (TNoRM.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
        } else if (NmDokter.getText().trim().equals("")) {
            Valid.textKosong(BtnDokter, "Dokter Anastesi");
        } else {
            String monitoring = getMonitoringValue();
            String lab = getLabValue();
            String penunjang = getPenunjang();

            if (Sequel.menyimpantf("penilaian_pre_induksi", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "No.Rawat, Tanggal & Jam", 29, new String[]{
                TNoRw.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), KdDokter.getText(),
                TD.getText(), Nadi.getText(), RR.getText(), Suhu.getText(), Lainlain.getText(), Premedikasi.getText(),
                Berat.getText(), Nyeri.getText(), KeadaanUmum.getText(), Kesadaran.getSelectedItem().toString(), SifatOp.getSelectedItem().toString(),
                Syaraf.getText(), kardiosvakuler.getText(), Urinarius.getText(), Respiratori.getText(), gastrointestinal.getText(), Muskuloskelatal.getText(),
                Metabolik.getText(), Medikamentosa.getText(), lab, klasifikasiASA.getSelectedItem().toString(), penunjang, Pemeriksaan.getText(), tindakananestesi.getSelectedItem().toString(), monitoring,
                PascaAnestesi.getSelectedItem().toString()
            }) == true) {
                tabMode.addRow(new Object[]{
                    TNoRw.getText(),
                    Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19),
                    KdDokter.getText(),
                    TD.getText(),
                    Nadi.getText(),
                    RR.getText(),
                    Suhu.getText(),
                    Lainlain.getText(),
                    Premedikasi.getText(),
                    TglLahir.getText(),
                    Jk.getText(),
                    Berat.getText(),
                    Nyeri.getText(),
                    KeadaanUmum.getText(),
                    Kesadaran.getSelectedItem().toString(),
                    SifatOp.getSelectedItem().toString(),
                    Syaraf.getText(),
                    kardiosvakuler.getText(),
                    Urinarius.getText(),
                    Respiratori.getText(),
                    gastrointestinal.getText(),
                    Muskuloskelatal.getText(),
                    Metabolik.getText(),
                    Medikamentosa.getText(),
                    lab,
                    klasifikasiASA.getSelectedItem().toString(),
                    penunjang,
                    Pemeriksaan.getText(),
                    tindakananestesi.getSelectedItem().toString(),
                    monitoring,
                    PascaAnestesi.getSelectedItem().toString()
                });
                emptTeks();
                LCount.setText("" + tabMode.getRowCount());
            }
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
        System.out.println("Total kolom tbObat: " + tbObat.getColumnCount());
        if (TNoRM.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
        } else if (NmDokter.getText().trim().equals("")) {
            Valid.textKosong(BtnDokter, "Dokter Anastesi");
        } else {
            if (tbObat.getSelectedRow() > -1) {
                if (akses.getkode().equals("Admin Utama")) {
                    ganti();
                } else {
                    if (KdDokter.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
                        ganti();
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

    private String safeGetValueAt(int row, int col) {
        Object value = tbObat.getValueAt(row, col);
        return value != null ? value.toString() : "";
    }

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            BtnBatal.requestFocus();
        } else {
            try {
                htmlContent = new StringBuilder();
                // Header kolom
                htmlContent.append("<tr class='isi'>");
                for (int j = 0; j < tabMode.getColumnCount(); j++) {
                    htmlContent.append("<td valign='middle' bgcolor='#FFFAF8' align='center'><b>")
                            .append(tabMode.getColumnName(j))
                            .append("</b></td>");
                }
                htmlContent.append("</tr>");

                // Data isi tabel
                for (int i = 0; i < tabMode.getRowCount(); i++) {
                    htmlContent.append("<tr class='isi'>");
                    for (int j = 0; j < tabMode.getColumnCount(); j++) {
                        Object cell = tbObat.getValueAt(i, j);
                        htmlContent.append("<td valign='top'>")
                                .append(cell == null ? "" : cell.toString())
                                .append("</td>");
                    }
                    htmlContent.append("</tr>");
                }

                // Tampilkan ke jEditorPane
                LoadHTML.setText(
                        "<html>"
                        + "<table width='4600px' border='0' align='center' cellpadding='1px' cellspacing='0' class='tbl_form'>"
                        + htmlContent.toString()
                        + "</table>"
                        + "</html>"
                );

                // Tulis file CSS
                File g = new File("file2.css");
                BufferedWriter bg = new BufferedWriter(new FileWriter(g));
                bg.write(
                        ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;"
                        + "border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                        + ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"
                        + ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;"
                        + "border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"
                        + ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;"
                        + "background: #ffffff;color:#323232;}"
                        + ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"
                        + ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"
                        + ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"
                        + ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"
                        + ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
                );
                bg.close();

                File f = new File("DataPenilaianPreInduksi.html");
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                bw.write(LoadHTML.getText().replaceAll("<head>", "<head>"
                        + "<link href=\"file2.css\" rel=\"stylesheet\" type=\"text/css\" />"
                        + "<table width='4600px' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"
                        + "<tr class='isi2'>"
                        + "<td valign='top' align='center'>"
                        + "<font size='4' face='Tahoma'>" + akses.getnamars() + "</font><br>"
                        + akses.getalamatrs() + ", " + akses.getkabupatenrs() + ", " + akses.getpropinsirs() + "<br>"
                        + akses.getkontakrs() + ", E-mail : " + akses.getemailrs() + "<br><br>"
                        + "<font size='2' face='Tahoma'>DATA PENGKAJIAN PRE INDUKSI<br><br></font>"
                        + "</td>"
                        + "</tr>"
                        + "</table>")
                );
                bw.close();

                // Buka di browser
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

              Valid.MyReportqry("rptCetakPenilaianPreInduksi.jasper", "report", "::[ Laporan Penilaian Pre Induksi ]::",
                    "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,if(pasien.jk='L','Laki-Laki','Perempuan') as jk,pasien.tgl_lahir,penilaian_pre_induksi.tanggal,"
                    + "penilaian_pre_induksi.kd_dokter,penilaian_pre_induksi.tensi,penilaian_pre_induksi.nadi,penilaian_pre_induksi.rr,penilaian_pre_induksi.suhu,penilaian_pre_induksi.bb,"
                    + "penilaian_pre_induksi.lain_lain,penilaian_pre_induksi.nyeri,penilaian_pre_induksi.kesadaran,penilaian_pre_induksi.sifat_op,penilaian_pre_induksi.syaraf,"
                    + "penilaian_pre_induksi.premedikasi,penilaian_pre_induksi.kardiovaskuler,penilaian_pre_induksi.urinarius,penilaian_pre_induksi.respiratori,penilaian_pre_induksi.gastrointestinal,"
                    + "penilaian_pre_induksi.muskuloskelatal,penilaian_pre_induksi.metabolik,penilaian_pre_induksi.medikamentosa,penilaian_pre_induksi.laboratorium,penilaian_pre_induksi.penunjang_lain,"
                    + "penilaian_pre_induksi.hasil_pemeriksaan,penilaian_pre_induksi.rencana_anestesi,penilaian_pre_induksi.klasifikasiasa,"
                    + "penilaian_pre_induksi.psc_anestesi,penilaian_pre_induksi.keadaan_umum,penilaian_pre_induksi.monitoring,dokter.nm_dokter "
                    + "from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join penilaian_pre_induksi on reg_periksa.no_rawat=penilaian_pre_induksi.no_rawat "
                    + "inner join dokter on penilaian_pre_induksi.kd_dokter=dokter.kd_dokter where penilaian_pre_induksi.no_rawat='" + tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString() + "' "
                    + "and penilaian_pre_induksi.tanggal='" + tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString() + "'", param);
        }
    }//GEN-LAST:event_MnPenilaianMedisActionPerformed

    private void klasifikasiASAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_klasifikasiASAKeyPressed

    }//GEN-LAST:event_klasifikasiASAKeyPressed

    private void PremedikasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PremedikasiKeyPressed
        Valid.pindah(evt, Premedikasi, klasifikasiASA);
    }//GEN-LAST:event_PremedikasiKeyPressed

    private void tindakananestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tindakananestesiKeyPressed

    }//GEN-LAST:event_tindakananestesiKeyPressed

    private void SuhuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SuhuKeyPressed

    }//GEN-LAST:event_SuhuKeyPressed

    private void RRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RRKeyPressed
        Valid.pindah(evt, Nadi, Suhu);
    }//GEN-LAST:event_RRKeyPressed

    private void NadiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NadiKeyPressed
        Valid.pindah(evt, TD, RR);
    }//GEN-LAST:event_NadiKeyPressed

    private void KesadaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KesadaranKeyPressed

    }//GEN-LAST:event_KesadaranKeyPressed

    private void TDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDKeyPressed
        Valid.pindah(evt, BtnSimpan, Nadi);
    }//GEN-LAST:event_TDKeyPressed

    private void SyarafKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SyarafKeyPressed

    }//GEN-LAST:event_SyarafKeyPressed

    private void BtnDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokterKeyPressed
        //Valid.pindah(evt,Edukasi,Hubungan);
    }//GEN-LAST:event_BtnDokterKeyPressed

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            isRawat();
        } else {
            Valid.pindah(evt, TCari, BtnDokter);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void BeratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BeratKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeratKeyPressed

    private void KeadaanUmumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeadaanUmumKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeadaanUmumKeyPressed

    private void NyeriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NyeriKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NyeriKeyPressed

    private void SifatOpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SifatOpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SifatOpKeyPressed

    private void SifatOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SifatOpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SifatOpActionPerformed

    private void gastrointestinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gastrointestinalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_gastrointestinalKeyPressed

    private void SyarafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyarafActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SyarafActionPerformed

    private void UrinariusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UrinariusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_UrinariusKeyPressed

    private void MuskuloskelatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MuskuloskelatalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MuskuloskelatalKeyPressed

    private void PemeriksaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PemeriksaanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PemeriksaanKeyPressed

    private void RespiratoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RespiratoriKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RespiratoriKeyPressed

    private void kardiosvakulerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kardiosvakulerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kardiosvakulerKeyPressed

    private void kardiosvakulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kardiosvakulerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kardiosvakulerActionPerformed

    private void LainlainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LainlainKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_LainlainKeyPressed

    private void MedikamentosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MedikamentosaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedikamentosaKeyPressed

    private void hbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hbActionPerformed

    private void btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btActionPerformed

    private void rontgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rontgenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rontgenActionPerformed

    private void MetabolikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MetabolikKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_MetabolikKeyPressed

    private void PascaAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PascaAnestesiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PascaAnestesiKeyPressed

    private void TglAsuhanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TglAsuhanKeyPressed
        //Valid.pindah(evt,BtnDokter,Diagnosa);
    }//GEN-LAST:event_TglAsuhanKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMPenilaianPreInduksiCustom dialog = new RMPenilaianPreInduksiCustom(new javax.swing.JFrame(), true);
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
    private widget.TextBox Berat;
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
    private widget.PanelBiasa FormInput;
    private widget.TextBox Jk;
    private widget.TextBox KdDokter;
    private widget.TextBox KeadaanUmum;
    private widget.ComboBox Kesadaran;
    private widget.Label LCount;
    private widget.TextBox Lainlain;
    private widget.editorpane LoadHTML;
    private widget.TextBox Medikamentosa;
    private widget.TextBox Metabolik;
    private javax.swing.JMenuItem MnPenilaianMedis;
    private widget.TextBox Muskuloskelatal;
    private widget.TextBox Nadi;
    private widget.TextBox NmDokter;
    private widget.TextBox Nyeri;
    private widget.ComboBox PascaAnestesi;
    private widget.TextBox Pemeriksaan;
    private widget.TextBox Premedikasi;
    private widget.TextBox RR;
    private widget.TextBox Respiratori;
    private widget.ScrollPane Scroll;
    private widget.ComboBox SifatOp;
    private widget.TextBox Suhu;
    private widget.TextBox Syaraf;
    private widget.TextBox TCari;
    private widget.TextBox TD;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.Tanggal TglAsuhan;
    private widget.TextBox TglLahir;
    private widget.TextBox Urinarius;
    private javax.swing.JCheckBox areteri;
    private javax.swing.JCheckBox bt;
    private javax.swing.JCheckBox creatinin;
    private javax.swing.JCheckBox ct;
    private javax.swing.JCheckBox cvp;
    private javax.swing.JCheckBox ecg;
    private javax.swing.JCheckBox ekg;
    private javax.swing.JCheckBox etc;
    private widget.TextBox gastrointestinal;
    private javax.swing.JCheckBox gds;
    private javax.swing.JCheckBox golda;
    private javax.swing.JCheckBox hb;
    private javax.swing.JCheckBox hbsag;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel125;
    private widget.Label jLabel126;
    private widget.Label jLabel127;
    private widget.Label jLabel145;
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
    private widget.Label jLabel29;
    private widget.Label jLabel30;
    private widget.Label jLabel31;
    private widget.Label jLabel32;
    private widget.Label jLabel35;
    private widget.Label jLabel40;
    private widget.Label jLabel41;
    private widget.Label jLabel53;
    private widget.Label jLabel54;
    private widget.Label jLabel55;
    private widget.Label jLabel56;
    private widget.Label jLabel57;
    private widget.Label jLabel58;
    private widget.Label jLabel59;
    private widget.Label jLabel6;
    private widget.Label jLabel60;
    private widget.Label jLabel61;
    private widget.Label jLabel62;
    private widget.Label jLabel63;
    private widget.Label jLabel64;
    private widget.Label jLabel65;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private widget.TextBox kardiosvakuler;
    private widget.ComboBox klasifikasiASA;
    private widget.Label label11;
    private widget.Label label14;
    private javax.swing.JCheckBox leukosit;
    private javax.swing.JCheckBox nadi;
    private javax.swing.JCheckBox nibp;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private javax.swing.JCheckBox rontgen;
    private widget.ScrollPane scrollInput;
    private javax.swing.JCheckBox sp;
    private widget.Table tbObat;
    private javax.swing.JCheckBox temp;
    private widget.ComboBox tindakananestesi;
    private javax.swing.JCheckBox ureum;
    private javax.swing.JCheckBox usg;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            // SQL Query yang sudah disesuaikan dengan nama kolom database Anda
            String sql = "select reg_periksa.no_rawat, penilaian_pre_induksi.tanggal, "
                    + "penilaian_pre_induksi.kd_dokter, dokter.nm_dokter,"
                    + "penilaian_pre_induksi.tensi, penilaian_pre_induksi.nadi, penilaian_pre_induksi.rr, "
                    + "penilaian_pre_induksi.suhu, penilaian_pre_induksi.lain_lain, penilaian_pre_induksi.premedikasi, penilaian_pre_induksi.bb, "
                    + "penilaian_pre_induksi.nyeri, penilaian_pre_induksi.keadaan_umum, penilaian_pre_induksi.kesadaran, "
                    + "penilaian_pre_induksi.sifat_op, penilaian_pre_induksi.syaraf, penilaian_pre_induksi.kardiovaskuler, "
                    + "penilaian_pre_induksi.urinarius, penilaian_pre_induksi.respiratori, penilaian_pre_induksi.gastrointestinal, "
                    + "penilaian_pre_induksi.muskuloskelatal, penilaian_pre_induksi.metabolik, penilaian_pre_induksi.medikamentosa, "
                    + "penilaian_pre_induksi.laboratorium, penilaian_pre_induksi.klasifikasiasa, penilaian_pre_induksi.penunjang_lain, "
                    + "penilaian_pre_induksi.hasil_pemeriksaan, penilaian_pre_induksi.rencana_anestesi, "
                    + "penilaian_pre_induksi.monitoring, penilaian_pre_induksi.psc_anestesi, "
                    + "pasien.no_rkm_medis, pasien.nm_pasien, pasien.jk, pasien.tgl_lahir "
                    + "from reg_periksa "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join penilaian_pre_induksi on reg_periksa.no_rawat=penilaian_pre_induksi.no_rawat "
                    + "inner join dokter on penilaian_pre_induksi.kd_dokter=dokter.kd_dokter ";

            if (TCari.getText().trim().equals("")) {
                ps = koneksi.prepareStatement(sql + "where penilaian_pre_induksi.tanggal between ? and ? order by penilaian_pre_induksi.tanggal");
            } else {
                ps = koneksi.prepareStatement(sql + "where penilaian_pre_induksi.tanggal between ? and ? and "
                        + "(reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? or "
                        + "penilaian_pre_induksi.kd_dokter like ? or dokter.nm_dokter like ?) order by penilaian_pre_induksi.tanggal");
            }

            try {
                if (TCari.getText().trim().equals("")) {
                    ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                    ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");
                } else {
                    ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                    ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");
                    ps.setString(3, "%" + TCari.getText() + "%");
                    ps.setString(4, "%" + TCari.getText() + "%");
                    ps.setString(5, "%" + TCari.getText() + "%");
                    ps.setString(6, "%" + TCari.getText() + "%");
                    ps.setString(7, "%" + TCari.getText() + "%");
                }

                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"), // 1
                        rs.getString("no_rkm_medis"), // 2
                        rs.getString("nm_pasien"), // 3
                        rs.getString("jk"), // 4
                        rs.getString("tgl_lahir"), // 5
                        rs.getString("tanggal"), // 6
                        rs.getString("kd_dokter"), // 7
                        rs.getString("nm_dokter"), // 8
                        rs.getString("tensi"), // 9
                        rs.getString("nadi"), // 10
                        rs.getString("rr"), // 11
                        rs.getString("suhu"), // 12
                        rs.getString("bb"), // 13
                        rs.getString("nyeri"), // 14
                        rs.getString("keadaan_umum"), // 15
                        rs.getString("kesadaran"), // 16
                        rs.getString("sifat_op"), // 17
                        rs.getString("syaraf"), // 18
                        rs.getString("kardiovaskuler"), // 19
                        rs.getString("urinarius"), // 20
                        rs.getString("respiratori"), // 21
                        rs.getString("gastrointestinal"), // 22
                        rs.getString("muskuloskelatal"), // 23
                        rs.getString("metabolik"), // 24
                        rs.getString("medikamentosa"), // 25
                        rs.getString("laboratorium"), // 26
                        rs.getString("penunjang_lain"), // 27
                        rs.getString("lain_lain"), // 28
                        rs.getString("hasil_pemeriksaan"), // 29
                        rs.getString("premedikasi"), // 30
                        rs.getString("rencana_anestesi"), // 31 - SESUAIKAN DENGAN DB
                        rs.getString("klasifikasiasa"), // 32
                        rs.getString("psc_anestesi"), // 33 - SESUAIKAN DENGAN DB
                        rs.getString("monitoring") // 34
                    });
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

    public void emptTeks() {
        TD.setText("");
        Nadi.setText("");
        RR.setText("");
        Suhu.setText("");

        // 2. Data Pasien
        Berat.setText("");
        Nyeri.setText("");

        // 3. Sistem Tubuh & Pemeriksaan
        Syaraf.setText("");
        kardiosvakuler.setText(""); // Pastikan huruf 'k' kecil sesuai variabel simpan Anda
        Urinarius.setText("");
        Respiratori.setText("");
        gastrointestinal.setText("");
        Muskuloskelatal.setText("");
        Metabolik.setText("");
        Medikamentosa.setText("");
        Pemeriksaan.setText("");

        // 4. Lain-lain & Tatalaksana
        Lainlain.setText("");
        Premedikasi.setText(""); // Jika variabelnya JTextField
        KeadaanUmum.setText("");

        // 5. ComboBox
        Kesadaran.setSelectedIndex(0);
        SifatOp.setSelectedIndex(0);
        klasifikasiASA.setSelectedIndex(0);
        tindakananestesi.setSelectedIndex(0);
        PascaAnestesi.setSelectedIndex(0);

        // 6. Checkbox / Variable Khusus (Lab, Penunjang, Monitoring)
        ekg.setSelected(false);
        sp.setSelected(false);
        nibp.setSelected(false);
        temp.setSelected(false);
        cvp.setSelected(false);
        etc.setSelected(false);
        areteri.setSelected(false);
        nadi.setSelected(false);
        ecg.setSelected(false);
        usg.setSelected(false);
        rontgen.setSelected(false);
        hb.setSelected(false);
        gds.setSelected(false);
        ureum.setSelected(false);
        creatinin.setSelected(false);
        ct.setSelected(false);
        golda.setSelected(false);
        leukosit.setSelected(false);
        bt.setSelected(false);
        hbsag.setSelected(false);

        
        // 7. Waktu & Fokus
        TglAsuhan.setDate(new Date());
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
            Jk.setText(tbObat.getValueAt(row, 3).toString());
            TglLahir.setText(tbObat.getValueAt(row, 4).toString());
            Valid.SetTgl2(TglAsuhan, tbObat.getValueAt(row, 5).toString()); // Kolom Tanggal
            KdDokter.setText(tbObat.getValueAt(row, 6).toString());
            NmDokter.setText(tbObat.getValueAt(row, 7).toString());

            // Pemeriksaan Fisik / Tanda Vital
            TD.setText(tbObat.getValueAt(row, 8).toString());
            Nadi.setText(tbObat.getValueAt(row, 9).toString());
            RR.setText(tbObat.getValueAt(row, 10).toString());
            Suhu.setText(tbObat.getValueAt(row, 11).toString());
            Berat.setText(tbObat.getValueAt(row, 12).toString());
            Nyeri.setText(tbObat.getValueAt(row, 13).toString());

            // Kondisi Umum
            KeadaanUmum.setText(tbObat.getValueAt(row, 14).toString());
            Kesadaran.setSelectedItem(tbObat.getValueAt(row, 15).toString());
            SifatOp.setSelectedItem(tbObat.getValueAt(row, 16).toString());

            // Analisa Sistem
            Syaraf.setText(tbObat.getValueAt(row, 17).toString());
            kardiosvakuler.setText(tbObat.getValueAt(row, 18).toString());
            Urinarius.setText(tbObat.getValueAt(row, 19).toString());
            Respiratori.setText(tbObat.getValueAt(row, 20).toString());
            gastrointestinal.setText(tbObat.getValueAt(row, 21).toString());
            Muskuloskelatal.setText(tbObat.getValueAt(row, 22).toString());
            Metabolik.setText(tbObat.getValueAt(row, 23).toString());
            Medikamentosa.setText(tbObat.getValueAt(row, 24).toString());
            tampilkanLab(tbObat.getValueAt(row, 25).toString());
            tampilkanPenunjang(tbObat.getValueAt(row, 26).toString());
            Lainlain.setText(tbObat.getValueAt(row, 27).toString());
            Pemeriksaan.setText(tbObat.getValueAt(row, 28).toString());
            Premedikasi.setText(tbObat.getValueAt(row, 29).toString());
            tindakananestesi.setSelectedItem(tbObat.getValueAt(row, 30).toString());
            klasifikasiASA.setSelectedItem(tbObat.getValueAt(row, 31).toString());
            PascaAnestesi.setSelectedItem(tbObat.getValueAt(row, 32).toString());
            tampilkanMonitoring(tbObat.getValueAt(row, 33).toString());
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
                    Jk.setText(rs.getString("jk"));
                    TglLahir.setText(rs.getString("tgl_lahir"));
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
            KdDokter.setEditable(false);
            BtnDokter.setEnabled(false);
            KdDokter.setText(akses.getkode());
            NmDokter.setText(dokter.tampil3(KdDokter.getText()));
            if (NmDokter.getText().equals("")) {
                KdDokter.setText("");
                JOptionPane.showMessageDialog(null, "User login bukan Dokter...!!");
            }
        }
    }

    public void setTampil() {
        TabRawat.setSelectedIndex(1);
    }

    private void hapus() {
        if (Sequel.queryu2tf("delete from penilaian_pre_induksi where no_rawat=? and tanggal=?", 2, new String[]{
            tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(), tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString()
        }) == true) {
            tabMode.removeRow(tbObat.getSelectedRow());
            LCount.setText("" + tabMode.getRowCount());
            TabRawat.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menghapus..!!");
        }
    }

    private void tampilkanMonitoring(String MonitoringValue) {
        ekg.setSelected(false);
        sp.setSelected(false);
        nibp.setSelected(false);
        temp.setSelected(false);
        cvp.setSelected(false);
        etc.setSelected(false);
        areteri.setSelected(false);
        nadi.setSelected(false);

        if (MonitoringValue != null && !MonitoringValue.trim().isEmpty()) {
            String[] monitoringArray = MonitoringValue.split(",");

            for (String item : monitoringArray) {
                String trimmedItem = item.trim();

                switch (trimmedItem) {
                    case "EKG":
                        ekg.setSelected(true);
                        break;
                    case "SP":
                        sp.setSelected(true);
                        break;
                    case "NIBP":
                        nibp.setSelected(true);
                        break;
                    case "TEMP":
                        temp.setSelected(true);
                        break;
                    case "CVP":
                        cvp.setSelected(true);
                        break;
                    case "ETC":
                        etc.setSelected(true);
                        break;
                    case "ARETERI":
                        areteri.setSelected(true);
                        break;
                    case "NADI":
                        nadi.setSelected(true);
                }
            }
        }
    }

    private void tampilkanPenunjang(String tunjang) {
        // Kosongkan centang dulu
        ecg.setSelected(false);
        usg.setSelected(false);
        rontgen.setSelected(false);
        
        if (tunjang.trim().isEmpty()) {
            return;
        }
        
        String[] dipilih = tunjang.split(",");
        
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

    private void tampilkanLab(String lb) {
        // 1. Reset: Kosongkan semua centang terlebih dahulu agar tidak tumpuk dengan data sebelumnya
        hb.setSelected(false);
        gds.setSelected(false);
        ureum.setSelected(false);
        creatinin.setSelected(false);
        ct.setSelected(false);
        golda.setSelected(false);
        leukosit.setSelected(false);
        bt.setSelected(false);
        hbsag.setSelected(false);
        if (lb.trim().isEmpty()) {
            return;
        }
        
        String[] dipilih = lb.split(",");

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

    private String getMonitoringValue() {
        String monitoring = "";
        if (ekg.isSelected()) {
            monitoring += "EKG,";
        }
        if (sp.isSelected()) {
            monitoring += "SP,";
        }
        if (nibp.isSelected()) {
            monitoring += "NIBP,";
        }
        if (temp.isSelected()) {
            monitoring += "TEMP,";
        }
        if (cvp.isSelected()) {
            monitoring += "CVP,";
        }
        if (etc.isSelected()) {
            monitoring += "ETC,";
        }
        if (areteri.isSelected()) {
            monitoring += "ARETERI,";
        }
        if (nadi.isSelected()) {
            monitoring += "NADI,";
        }
        if (monitoring.endsWith(",")) {
            monitoring = monitoring.substring(0, monitoring.length() - 1);
        }
        return monitoring;
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
        if (!tunjang.isEmpty()) {
            tunjang = tunjang.substring(0, tunjang.length() - 1);
        }
        return tunjang;
    }

    private String getLabValue() {
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

    private void ganti() {
        String monitoring = getMonitoringValue();
        String lab = getLabValue();
        String penunjang = getPenunjang();

        if (Sequel.mengedittf("penilaian_pre_induksi", "no_rawat=? and tanggal=?",
                "no_rawat=?,tanggal=?,kd_dokter=?,tensi=?,nadi=?,rr=?,suhu=?,lain_lain=?,premedikasi=?,bb=?,nyeri=?,keadaan_umum=?,kesadaran=?,sifat_op=?,syaraf=?,kardiovaskuler=?,urinarius=?,respiratori=?,gastrointestinal=?,muskuloskelatal=?,metabolik=?,medikamentosa=?,laboratorium=?,klasifikasiasa=?,penunjang_lain=?,hasil_pemeriksaan=?,rencana_anestesi=?,monitoring=?,psc_anestesi=?",
                31, new String[]{
                    TNoRw.getText(), Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), KdDokter.getText(),
                    TD.getText(), Nadi.getText(), RR.getText(), Suhu.getText(), Lainlain.getText(), Premedikasi.getText(),
                    Berat.getText(), Nyeri.getText(), KeadaanUmum.getText(), Kesadaran.getSelectedItem().toString(), SifatOp.getSelectedItem().toString(),
                    Syaraf.getText(), kardiosvakuler.getText(), Urinarius.getText(), Respiratori.getText(), gastrointestinal.getText(), Muskuloskelatal.getText(),
                    Metabolik.getText(), Medikamentosa.getText(), lab, klasifikasiASA.getSelectedItem().toString(), penunjang, Pemeriksaan.getText(),
                    tindakananestesi.getSelectedItem().toString(), monitoring, PascaAnestesi.getSelectedItem().toString(),
                    tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(), // WHERE: no_rawat
                    tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString() // WHERE: tanggal
                }) == true) {

            // Update tabel display
            tbObat.setValueAt(TNoRw.getText(), tbObat.getSelectedRow(), 0);
            tbObat.setValueAt(TNoRM.getText(), tbObat.getSelectedRow(), 1);
            tbObat.setValueAt(TPasien.getText(), tbObat.getSelectedRow(), 2);
            tbObat.setValueAt(Jk.getText(), tbObat.getSelectedRow(), 3);
            tbObat.setValueAt(TglLahir.getText(), tbObat.getSelectedRow(), 4);
            tbObat.setValueAt(Valid.SetTgl(TglAsuhan.getSelectedItem() + "") + " " + TglAsuhan.getSelectedItem().toString().substring(11, 19), tbObat.getSelectedRow(), 5);
            tbObat.setValueAt(KdDokter.getText(), tbObat.getSelectedRow(), 6);
            tbObat.setValueAt(NmDokter.getText(), tbObat.getSelectedRow(), 7);
            tbObat.setValueAt(TD.getText(), tbObat.getSelectedRow(), 8);
            tbObat.setValueAt(Nadi.getText(), tbObat.getSelectedRow(), 9);
            tbObat.setValueAt(RR.getText(), tbObat.getSelectedRow(), 10);
            tbObat.setValueAt(Suhu.getText(), tbObat.getSelectedRow(), 11);
            tbObat.setValueAt(Berat.getText(), tbObat.getSelectedRow(), 12);
            tbObat.setValueAt(Nyeri.getText(), tbObat.getSelectedRow(), 13);
            tbObat.setValueAt(KeadaanUmum.getText(), tbObat.getSelectedRow(), 14);
            tbObat.setValueAt(Kesadaran.getSelectedItem().toString(), tbObat.getSelectedRow(), 15);
            tbObat.setValueAt(SifatOp.getSelectedItem().toString(), tbObat.getSelectedRow(), 16);
            tbObat.setValueAt(Syaraf.getText(), tbObat.getSelectedRow(), 17);
            tbObat.setValueAt(kardiosvakuler.getText(), tbObat.getSelectedRow(), 18);
            tbObat.setValueAt(Urinarius.getText(), tbObat.getSelectedRow(), 19);
            tbObat.setValueAt(Respiratori.getText(), tbObat.getSelectedRow(), 20);
            tbObat.setValueAt(gastrointestinal.getText(), tbObat.getSelectedRow(), 21);
            tbObat.setValueAt(Muskuloskelatal.getText(), tbObat.getSelectedRow(), 22);
            tbObat.setValueAt(Metabolik.getText(), tbObat.getSelectedRow(), 23);
            tbObat.setValueAt(Medikamentosa.getText(), tbObat.getSelectedRow(), 24);
            tbObat.setValueAt(lab, tbObat.getSelectedRow(), 25);
            tbObat.setValueAt(penunjang, tbObat.getSelectedRow(), 26);
            tbObat.setValueAt(Lainlain.getText(), tbObat.getSelectedRow(), 27);
            tbObat.setValueAt(Pemeriksaan.getText(), tbObat.getSelectedRow(), 28);
            tbObat.setValueAt(Premedikasi.getText(), tbObat.getSelectedRow(), 29);
            tbObat.setValueAt(tindakananestesi.getSelectedItem().toString(), tbObat.getSelectedRow(), 30);
            tbObat.setValueAt(klasifikasiASA.getSelectedItem().toString(), tbObat.getSelectedRow(), 31);
            tbObat.setValueAt(PascaAnestesi.getSelectedItem().toString(), tbObat.getSelectedRow(), 32);
            tbObat.setValueAt(monitoring, tbObat.getSelectedRow(), 33);

            emptTeks();
            TabRawat.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
        }
    }
}
