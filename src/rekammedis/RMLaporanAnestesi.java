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
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;

/**
 *
 * @author perpustakaan
 */
public final class RMLaporanAnestesi extends javax.swing.JDialog {

    private final DefaultTableModel tabMode;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0, pilihan = 0;
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    private DlgCariPetugas petugas = new DlgCariPetugas(null, false);
    private String finger = "", finger1 = "", finger2 = "";
    private String alatJalanNapas = "";

    /**
     * Creates new form DlgRujuk
     *
     * @param parent
     * @param modal
     */
    public RMLaporanAnestesi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "Mulai Anestesi", "Selesai Anestesi",
            "Kode dr Anestesi", "Nama dr Anestesi", "Kode Ast Anestesi", "Nama Ast Anestesi",
            "Kode Dokter", "Nama Dokter", "midazolam", "ondasetron", "dexamenthason", "oksigenasi",
            "Teknik_IV", "Teknik_umum", "Alat Jalan Napas",
            "ETT", "LMA", "teknik_regional", "posisi_puncture",
            "komplikasi", "penanganan", "propofol", "fetanyl",
            "atracurium", "sevoflourance", "isoflurance", "o2", "n2o",
            "diagnosa pre op", "prosedur", "diagnosa post op", "Level", "Obat", "Volume", "jam mulai op",
            "jam selesai op", "posisi pasien", "rl", "koloid", "darah", "nacl", "cairan",
            "darah_keluar", "urine"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

        };

        tbObat.setModel(tabMode);
        tbObat.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 44; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(105);
            } else if (i == 1) {
                column.setPreferredWidth(70);
            } else if (i == 2) {
                column.setPreferredWidth(150);
            } else if (i == 3) {
                column.setPreferredWidth(120);
            } else if (i == 4) {
                column.setPreferredWidth(120);
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
                column.setPreferredWidth(120);
            } else if (i == 10) {
                column.setPreferredWidth(100);
            } else if (i == 11) {
                column.setPreferredWidth(100);
            } else if (i == 12) {
                column.setPreferredWidth(120);
            } else if (i == 13) {
                column.setPreferredWidth(80);
            } else if (i == 14) {
                column.setPreferredWidth(80);
            } else if (i == 15) {
                column.setPreferredWidth(150);
            } else if (i == 16) {
                column.setPreferredWidth(150);
            } else if (i == 17) {
                column.setPreferredWidth(150);
            } else if (i == 18) {
                column.setPreferredWidth(150);
            } else if (i == 19) {
                column.setPreferredWidth(90);
            } else if (i == 20) {
                column.setPreferredWidth(90);
            } else if (i == 21) {
                column.setPreferredWidth(90);
            } else if (i == 22) {
                column.setPreferredWidth(90);
            } else if (i == 23) {
                column.setPreferredWidth(90);
            } else if (i == 24) {
                column.setPreferredWidth(70);
            } else if (i == 25) {
                column.setPreferredWidth(90);
            } else if (i == 26) {
                column.setPreferredWidth(70);
            } else if (i == 27) {
                column.setPreferredWidth(70);
            } else if (i == 28) {
                column.setPreferredWidth(70);
            } else if (i == 29) {
                column.setPreferredWidth(70);
            } else if (i == 30) {
                column.setPreferredWidth(70);
            } else if (i == 31) {
                column.setPreferredWidth(70);
            } else if (i == 32) {
                column.setPreferredWidth(70);
            } else if (i == 33) {
                column.setPreferredWidth(70);
            } else if (i == 34) {
                column.setPreferredWidth(70);
            } else if (i == 35) {
                column.setPreferredWidth(70);
            } else if (i == 36) {
                column.setPreferredWidth(70);
            } else if (i == 37) {
                column.setPreferredWidth(70);
            } else if (i == 38) {
                column.setPreferredWidth(70);
            } else if (i == 39) {
                column.setPreferredWidth(70);
            } else if (i == 40) {
                column.setPreferredWidth(70);
            } else if (i == 41) {
                column.setPreferredWidth(70);
            } else if (i == 42) {
                column.setPreferredWidth(70);
            } else if (i == 43) {
                column.setPreferredWidth(70);
            } else if (i == 44) {
                column.setPreferredWidth(70);
            } else if (i == 45) {
                column.setPreferredWidth(70);
            } else if (i == 45) {
                column.setPreferredWidth(70);
            }

        }

        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
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
                    } else if (pilihan == 3) {
                        KdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        NmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());

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

        petugas.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (petugas.getTable().getSelectedRow() != -1) {
                    if (pilihan == 2) {
                        kdasistanestesi.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmasistanestesi.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdasistanestesi.requestFocus();
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
        MnLaporanAnestesi = new javax.swing.JMenuItem();
        MnPemantauanStatusFisiologi = new javax.swing.JMenuItem();
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
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        TNoRM = new widget.TextBox();
        label21 = new widget.Label();
        kdanestesi = new widget.TextBox();
        nmanestesi = new widget.TextBox();
        BtnAnastesi = new widget.Button();
        label26 = new widget.Label();
        ondasetron = new widget.TextBox();
        nmasistanestesi = new widget.TextBox();
        BtnAsnes = new widget.Button();
        jLabel4 = new widget.Label();
        teknik_reg = new widget.ComboBox();
        jLabel15 = new widget.Label();
        jLabel10 = new widget.Label();
        jLabel17 = new widget.Label();
        label22 = new widget.Label();
        label23 = new widget.Label();
        label24 = new widget.Label();
        label25 = new widget.Label();
        label27 = new widget.Label();
        label28 = new widget.Label();
        label29 = new widget.Label();
        label30 = new widget.Label();
        label31 = new widget.Label();
        teknik_IV = new javax.swing.JComboBox<>();
        label32 = new widget.Label();
        teknik_umum = new javax.swing.JComboBox<>();
        label33 = new widget.Label();
        lma1 = new javax.swing.JCheckBox();
        ett1 = new javax.swing.JCheckBox();
        NasalCanul = new javax.swing.JCheckBox();
        o2mask = new javax.swing.JCheckBox();
        label34 = new widget.Label();
        label35 = new widget.Label();
        jLabel20 = new widget.Label();
        puncture = new widget.ComboBox();
        jLabel23 = new widget.Label();
        label36 = new widget.Label();
        label37 = new widget.Label();
        label38 = new widget.Label();
        label39 = new widget.Label();
        label40 = new widget.Label();
        label41 = new widget.Label();
        label42 = new widget.Label();
        label43 = new widget.Label();
        label45 = new widget.Label();
        label46 = new widget.Label();
        label47 = new widget.Label();
        label48 = new widget.Label();
        label44 = new widget.Label();
        label49 = new widget.Label();
        jLabel24 = new widget.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        penanganan = new widget.TextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        komplikasi = new widget.TextArea();
        kdasistanestesi = new widget.TextBox();
        dexa = new widget.TextBox();
        n2o = new widget.TextBox();
        midazolam = new widget.TextBox();
        oksigen = new widget.TextBox();
        propofol = new widget.TextBox();
        fenta = new widget.TextBox();
        atrac = new widget.TextBox();
        sevo = new widget.TextBox();
        iso = new widget.TextBox();
        lma = new widget.TextBox();
        o2 = new widget.TextBox();
        ett = new widget.TextBox();
        label12 = new widget.Label();
        tgl_mulai = new widget.Tanggal();
        cmbJam = new widget.ComboBox();
        cmbMnt = new widget.ComboBox();
        cmbDtk = new widget.ComboBox();
        label13 = new widget.Label();
        tgl_selesai = new widget.Tanggal();
        cmbJam1 = new widget.ComboBox();
        cmbMnt1 = new widget.ComboBox();
        cmbDtk1 = new widget.ComboBox();
        NmDokter = new widget.TextBox();
        label14 = new widget.Label();
        KdDokter = new widget.TextBox();
        BtnDokter = new widget.Button();
        label50 = new widget.Label();
        label51 = new widget.Label();
        label52 = new widget.Label();
        label15 = new widget.Label();
        tgl_mulai1 = new widget.Tanggal();
        cmbJam2 = new widget.ComboBox();
        cmbMnt2 = new widget.ComboBox();
        cmbDtk2 = new widget.ComboBox();
        label16 = new widget.Label();
        tgl_selesai1 = new widget.Tanggal();
        cmbJam3 = new widget.ComboBox();
        cmbMnt3 = new widget.ComboBox();
        cmbDtk3 = new widget.ComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        diagnosa_pre_op = new widget.TextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        diagnosa_post_op = new widget.TextArea();
        jLabel5 = new widget.Label();
        posisi_pasien = new javax.swing.JComboBox<>();
        prosedur = new widget.TextBox();
        level = new widget.TextBox();
        label53 = new widget.Label();
        label54 = new widget.Label();
        obat = new widget.TextBox();
        volume = new widget.TextBox();
        label55 = new widget.Label();
        label56 = new widget.Label();
        rl = new widget.TextBox();
        nacl = new widget.TextBox();
        label57 = new widget.Label();
        koloid = new widget.TextBox();
        label58 = new widget.Label();
        darah = new widget.TextBox();
        label59 = new widget.Label();
        jLabel18 = new widget.Label();
        label60 = new widget.Label();
        label61 = new widget.Label();
        label62 = new widget.Label();
        label63 = new widget.Label();
        jLabel22 = new widget.Label();
        Cairan = new widget.Label();
        cairan = new widget.TextBox();
        label65 = new widget.Label();
        label66 = new widget.Label();
        urine = new widget.TextBox();
        label67 = new widget.Label();
        label68 = new widget.Label();
        darah_keluar = new widget.TextBox();
        label69 = new widget.Label();
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

        MnLaporanAnestesi.setBackground(new java.awt.Color(255, 255, 254));
        MnLaporanAnestesi.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnLaporanAnestesi.setForeground(new java.awt.Color(50, 50, 50));
        MnLaporanAnestesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnLaporanAnestesi.setText("Laporan Pengkajian Pre Induksi");
        MnLaporanAnestesi.setName("MnLaporanAnestesi"); // NOI18N
        MnLaporanAnestesi.setPreferredSize(new java.awt.Dimension(220, 26));
        MnLaporanAnestesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnLaporanAnestesiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnLaporanAnestesi);

        MnPemantauanStatusFisiologi.setBackground(new java.awt.Color(255, 255, 254));
        MnPemantauanStatusFisiologi.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnPemantauanStatusFisiologi.setForeground(new java.awt.Color(50, 50, 50));
        MnPemantauanStatusFisiologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnPemantauanStatusFisiologi.setText("Pemantauan Status Fisiologi");
        MnPemantauanStatusFisiologi.setName("MnPemantauanStatusFisiologi"); // NOI18N
        MnPemantauanStatusFisiologi.setPreferredSize(new java.awt.Dimension(220, 26));
        MnPemantauanStatusFisiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnPemantauanStatusFisiologiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnPemantauanStatusFisiologi);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Laporan Anestesi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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
        jLabel3.setBounds(20, 10, 70, 23);

        TNoRw.setEditable(false);
        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNoRwActionPerformed(evt);
            }
        });
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(105, 10, 140, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(335, 10, 400, 23);

        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRMKeyPressed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(250, 10, 80, 23);

        label21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label21.setText("mg");
        label21.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label21.setName("label21"); // NOI18N
        label21.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label21);
        label21.setBounds(210, 180, 81, 23);

        kdanestesi.setEditable(false);
        kdanestesi.setName("kdanestesi"); // NOI18N
        kdanestesi.setPreferredSize(new java.awt.Dimension(80, 23));
        kdanestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdanestesiKeyPressed(evt);
            }
        });
        FormInput.add(kdanestesi);
        kdanestesi.setBounds(100, 40, 70, 23);

        nmanestesi.setEditable(false);
        nmanestesi.setName("nmanestesi"); // NOI18N
        nmanestesi.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmanestesi);
        nmanestesi.setBounds(170, 40, 190, 23);

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
        BtnAnastesi.setBounds(360, 40, 28, 23);

        label26.setText("Ast. Anestesi :");
        label26.setName("label26"); // NOI18N
        label26.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label26);
        label26.setBounds(370, 40, 90, 23);

        ondasetron.setName("ondasetron"); // NOI18N
        ondasetron.setPreferredSize(new java.awt.Dimension(80, 23));
        ondasetron.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ondasetronKeyPressed(evt);
            }
        });
        FormInput.add(ondasetron);
        ondasetron.setBounds(130, 210, 70, 23);

        nmasistanestesi.setEditable(false);
        nmasistanestesi.setName("nmasistanestesi"); // NOI18N
        nmasistanestesi.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmasistanestesi);
        nmasistanestesi.setBounds(540, 40, 190, 23);

        BtnAsnes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnAsnes.setMnemonic('2');
        BtnAsnes.setToolTipText("Alt+2");
        BtnAsnes.setName("BtnAsnes"); // NOI18N
        BtnAsnes.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAsnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAsnesActionPerformed(evt);
            }
        });
        FormInput.add(BtnAsnes);
        BtnAsnes.setBounds(730, 40, 28, 23);

        jLabel4.setText("Posisi Pasien:");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(570, 370, 90, 23);

        teknik_reg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Spinal", "Epidural", "Blok" }));
        teknik_reg.setName("teknik_reg"); // NOI18N
        teknik_reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teknik_regKeyPressed(evt);
            }
        });
        FormInput.add(teknik_reg);
        teknik_reg.setBounds(460, 340, 90, 23);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Komplikasi Akut Anestesi:");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(370, 400, 145, 23);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Penanganan :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(580, 400, 145, 23);

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("IV.Cairan Masuk");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(840, 260, 145, 20);

        label22.setText("dr Anestesi :");
        label22.setName("label22"); // NOI18N
        label22.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label22);
        label22.setBounds(10, 40, 81, 23);

        label23.setText("LMA No. :");
        label23.setName("label23"); // NOI18N
        label23.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label23);
        label23.setBounds(350, 310, 100, 23);

        label24.setText("Ondasetron:");
        label24.setName("label24"); // NOI18N
        label24.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label24);
        label24.setBounds(40, 210, 81, 23);

        label25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label25.setText("mg");
        label25.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label25.setName("label25"); // NOI18N
        label25.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label25);
        label25.setBounds(210, 210, 81, 23);

        label27.setText("Oksigenasi:");
        label27.setName("label27"); // NOI18N
        label27.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label27);
        label27.setBounds(20, 270, 100, 23);

        label28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label28.setText("mg");
        label28.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label28.setName("label28"); // NOI18N
        label28.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label28);
        label28.setBounds(210, 240, 81, 23);

        label29.setText("Dexamenthason:");
        label29.setName("label29"); // NOI18N
        label29.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label29);
        label29.setBounds(20, 240, 100, 23);

        label30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label30.setText("menit");
        label30.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label30.setName("label30"); // NOI18N
        label30.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label30);
        label30.setBounds(210, 270, 81, 23);

        label31.setText("Midazolam:");
        label31.setName("label31"); // NOI18N
        label31.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label31);
        label31.setBounds(40, 180, 81, 23);

        teknik_IV.setBackground(new java.awt.Color(255, 255, 255));
        teknik_IV.setForeground(new java.awt.Color(50, 50, 50));
        teknik_IV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "drip", "Intermitten" }));
        teknik_IV.setName("teknik_IV"); // NOI18N
        FormInput.add(teknik_IV);
        teknik_IV.setBounds(460, 190, 80, 22);

        label32.setText("Level:");
        label32.setName("label32"); // NOI18N
        label32.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label32);
        label32.setBounds(570, 340, 60, 23);

        teknik_umum.setBackground(new java.awt.Color(255, 255, 255));
        teknik_umum.setForeground(new java.awt.Color(50, 50, 50));
        teknik_umum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semi closed", "semi open" }));
        teknik_umum.setName("teknik_umum"); // NOI18N
        FormInput.add(teknik_umum);
        teknik_umum.setBounds(460, 220, 110, 22);

        label33.setText("Teknik Umum:");
        label33.setName("label33"); // NOI18N
        label33.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label33);
        label33.setBounds(370, 220, 81, 23);

        lma1.setBackground(new java.awt.Color(255, 255, 255));
        lma1.setText("LMA");
        lma1.setName("lma1"); // NOI18N
        lma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lma1ActionPerformed(evt);
            }
        });
        FormInput.add(lma1);
        lma1.setBounds(750, 250, 85, 20);

        ett1.setBackground(new java.awt.Color(255, 255, 255));
        ett1.setText("ETT");
        ett1.setName("ett1"); // NOI18N
        FormInput.add(ett1);
        ett1.setBounds(460, 250, 85, 20);

        NasalCanul.setBackground(new java.awt.Color(255, 255, 255));
        NasalCanul.setText("Nasal Canul");
        NasalCanul.setName("NasalCanul"); // NOI18N
        NasalCanul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NasalCanulActionPerformed(evt);
            }
        });
        FormInput.add(NasalCanul);
        NasalCanul.setBounds(550, 250, 100, 20);

        o2mask.setBackground(new java.awt.Color(255, 255, 255));
        o2mask.setText("O2 Mask");
        o2mask.setName("o2mask"); // NOI18N
        o2mask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o2maskActionPerformed(evt);
            }
        });
        FormInput.add(o2mask);
        o2mask.setBounds(660, 250, 85, 20);

        label34.setText("Alat Jalan Napas:");
        label34.setName("label34"); // NOI18N
        label34.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label34);
        label34.setBounds(350, 250, 100, 23);

        label35.setText("ETT No. :");
        label35.setName("label35"); // NOI18N
        label35.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label35);
        label35.setBounds(350, 280, 100, 23);

        jLabel20.setText("Posisi Puncture:");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(360, 370, 90, 23);

        puncture.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Duduk", "Miring" }));
        puncture.setName("puncture"); // NOI18N
        puncture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                punctureKeyPressed(evt);
            }
        });
        FormInput.add(puncture);
        puncture.setBounds(460, 370, 90, 23);

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("III. Obat Induksi");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(30, 300, 145, 23);

        label36.setText("Propofol:");
        label36.setName("label36"); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label36);
        label36.setBounds(40, 320, 81, 23);

        label37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label37.setText("mg");
        label37.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label37.setName("label37"); // NOI18N
        label37.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label37);
        label37.setBounds(210, 320, 81, 23);

        label38.setText("Fentanyl:");
        label38.setName("label38"); // NOI18N
        label38.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label38);
        label38.setBounds(40, 350, 81, 23);

        label39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label39.setText("mg");
        label39.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label39.setName("label39"); // NOI18N
        label39.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label39);
        label39.setBounds(210, 350, 81, 23);

        label40.setText("Atracurium:");
        label40.setName("label40"); // NOI18N
        label40.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label40);
        label40.setBounds(20, 380, 100, 23);

        label41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label41.setText("L");
        label41.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label41.setName("label41"); // NOI18N
        label41.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label41);
        label41.setBounds(210, 500, 81, 23);

        label42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label42.setText("MAC");
        label42.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label42.setName("label42"); // NOI18N
        label42.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label42);
        label42.setBounds(210, 410, 81, 23);

        label43.setText("Sevoflurance:");
        label43.setName("label43"); // NOI18N
        label43.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label43);
        label43.setBounds(20, 410, 100, 23);

        label45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label45.setText("MAC");
        label45.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label45.setName("label45"); // NOI18N
        label45.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label45);
        label45.setBounds(210, 440, 81, 23);

        label46.setText("Isoflurance:");
        label46.setName("label46"); // NOI18N
        label46.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label46);
        label46.setBounds(20, 440, 100, 23);

        label47.setText("O2:");
        label47.setName("label47"); // NOI18N
        label47.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label47);
        label47.setBounds(20, 470, 100, 23);

        label48.setText("N2O:");
        label48.setName("label48"); // NOI18N
        label48.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label48);
        label48.setBounds(20, 500, 100, 23);

        label44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label44.setText("mg");
        label44.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label44.setName("label44"); // NOI18N
        label44.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label44);
        label44.setBounds(210, 380, 81, 23);

        label49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label49.setText("L");
        label49.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        label49.setName("label49"); // NOI18N
        label49.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label49);
        label49.setBounds(210, 470, 81, 23);

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("I. Premedikasi ");
        jLabel24.setName("jLabel24"); // NOI18N
        FormInput.add(jLabel24);
        jLabel24.setBounds(30, 160, 145, 23);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setToolTipText("");
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        penanganan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        penanganan.setColumns(20);
        penanganan.setRows(5);
        penanganan.setName("penanganan"); // NOI18N
        jScrollPane1.setViewportView(penanganan);

        FormInput.add(jScrollPane1);
        jScrollPane1.setBounds(580, 420, 160, 80);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setToolTipText("");
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        komplikasi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        komplikasi.setColumns(20);
        komplikasi.setRows(5);
        komplikasi.setName("komplikasi"); // NOI18N
        jScrollPane2.setViewportView(komplikasi);

        FormInput.add(jScrollPane2);
        jScrollPane2.setBounds(370, 420, 160, 80);

        kdasistanestesi.setEditable(false);
        kdasistanestesi.setName("kdasistanestesi"); // NOI18N
        kdasistanestesi.setPreferredSize(new java.awt.Dimension(80, 23));
        kdasistanestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdasistanestesiKeyPressed(evt);
            }
        });
        FormInput.add(kdasistanestesi);
        kdasistanestesi.setBounds(470, 40, 70, 23);

        dexa.setName("dexa"); // NOI18N
        dexa.setPreferredSize(new java.awt.Dimension(80, 23));
        dexa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dexaKeyPressed(evt);
            }
        });
        FormInput.add(dexa);
        dexa.setBounds(130, 240, 70, 23);

        n2o.setName("n2o"); // NOI18N
        n2o.setPreferredSize(new java.awt.Dimension(80, 23));
        n2o.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n2oKeyPressed(evt);
            }
        });
        FormInput.add(n2o);
        n2o.setBounds(130, 500, 70, 23);

        midazolam.setName("midazolam"); // NOI18N
        midazolam.setPreferredSize(new java.awt.Dimension(80, 23));
        midazolam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midazolamActionPerformed(evt);
            }
        });
        midazolam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                midazolamKeyPressed(evt);
            }
        });
        FormInput.add(midazolam);
        midazolam.setBounds(130, 180, 70, 23);

        oksigen.setName("oksigen"); // NOI18N
        oksigen.setPreferredSize(new java.awt.Dimension(80, 23));
        oksigen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                oksigenKeyPressed(evt);
            }
        });
        FormInput.add(oksigen);
        oksigen.setBounds(130, 270, 70, 23);

        propofol.setName("propofol"); // NOI18N
        propofol.setPreferredSize(new java.awt.Dimension(80, 23));
        propofol.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                propofolKeyPressed(evt);
            }
        });
        FormInput.add(propofol);
        propofol.setBounds(130, 320, 70, 23);

        fenta.setName("fenta"); // NOI18N
        fenta.setPreferredSize(new java.awt.Dimension(80, 23));
        fenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fentaKeyPressed(evt);
            }
        });
        FormInput.add(fenta);
        fenta.setBounds(130, 350, 70, 23);

        atrac.setName("atrac"); // NOI18N
        atrac.setPreferredSize(new java.awt.Dimension(80, 23));
        atrac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                atracKeyPressed(evt);
            }
        });
        FormInput.add(atrac);
        atrac.setBounds(130, 380, 70, 23);

        sevo.setName("sevo"); // NOI18N
        sevo.setPreferredSize(new java.awt.Dimension(80, 23));
        sevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sevoKeyPressed(evt);
            }
        });
        FormInput.add(sevo);
        sevo.setBounds(130, 410, 70, 23);

        iso.setName("iso"); // NOI18N
        iso.setPreferredSize(new java.awt.Dimension(80, 23));
        iso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isoKeyPressed(evt);
            }
        });
        FormInput.add(iso);
        iso.setBounds(130, 440, 70, 23);

        lma.setName("lma"); // NOI18N
        lma.setPreferredSize(new java.awt.Dimension(80, 23));
        lma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lmaKeyPressed(evt);
            }
        });
        FormInput.add(lma);
        lma.setBounds(460, 310, 70, 23);

        o2.setName("o2"); // NOI18N
        o2.setPreferredSize(new java.awt.Dimension(80, 23));
        o2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                o2KeyPressed(evt);
            }
        });
        FormInput.add(o2);
        o2.setBounds(130, 470, 70, 23);

        ett.setName("ett"); // NOI18N
        ett.setPreferredSize(new java.awt.Dimension(80, 23));
        ett.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ettKeyPressed(evt);
            }
        });
        FormInput.add(ett);
        ett.setBounds(460, 280, 70, 23);

        label12.setText("Mulai Anes :");
        label12.setName("label12"); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label12);
        label12.setBounds(0, 100, 70, 23);

        tgl_mulai.setDisplayFormat("dd-MM-yyyy");
        tgl_mulai.setName("tgl_mulai"); // NOI18N
        tgl_mulai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_mulaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_mulai);
        tgl_mulai.setBounds(80, 100, 90, 23);

        cmbJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam.setName("cmbJam"); // NOI18N
        cmbJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJamKeyPressed(evt);
            }
        });
        FormInput.add(cmbJam);
        cmbJam.setBounds(180, 100, 62, 23);

        cmbMnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt.setName("cmbMnt"); // NOI18N
        cmbMnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMntKeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt);
        cmbMnt.setBounds(250, 100, 62, 23);

        cmbDtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk.setName("cmbDtk"); // NOI18N
        cmbDtk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtkKeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk);
        cmbDtk.setBounds(320, 100, 62, 23);

        label13.setText("Selesai Anes:");
        label13.setName("label13"); // NOI18N
        label13.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label13);
        label13.setBounds(390, 100, 70, 23);

        tgl_selesai.setDisplayFormat("dd-MM-yyyy");
        tgl_selesai.setName("tgl_selesai"); // NOI18N
        tgl_selesai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_selesaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_selesai);
        tgl_selesai.setBounds(470, 100, 90, 23);

        cmbJam1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam1.setName("cmbJam1"); // NOI18N
        cmbJam1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam1KeyPressed(evt);
            }
        });
        FormInput.add(cmbJam1);
        cmbJam1.setBounds(570, 100, 62, 23);

        cmbMnt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt1.setName("cmbMnt1"); // NOI18N
        cmbMnt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt1KeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt1);
        cmbMnt1.setBounds(640, 100, 62, 23);

        cmbDtk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk1.setName("cmbDtk1"); // NOI18N
        cmbDtk1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk1KeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk1);
        cmbDtk1.setBounds(710, 100, 62, 23);

        NmDokter.setEditable(false);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(NmDokter);
        NmDokter.setBounds(170, 70, 190, 23);

        label14.setText("Operator :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label14);
        label14.setBounds(10, 70, 80, 23);

        KdDokter.setEditable(false);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.setPreferredSize(new java.awt.Dimension(80, 23));
        FormInput.add(KdDokter);
        KdDokter.setBounds(100, 70, 70, 23);

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
        BtnDokter.setBounds(360, 70, 28, 23);

        label50.setText("Teknik IV:");
        label50.setName("label50"); // NOI18N
        label50.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label50);
        label50.setBounds(370, 190, 81, 23);

        label51.setText("Diagnosa pre op:");
        label51.setName("label51"); // NOI18N
        label51.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label51);
        label51.setBounds(800, 60, 130, 23);

        label52.setText("Diagnosa post op:");
        label52.setName("label52"); // NOI18N
        label52.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label52);
        label52.setBounds(810, 160, 130, 23);

        label15.setText("Mulai Op:");
        label15.setName("label15"); // NOI18N
        label15.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label15);
        label15.setBounds(0, 130, 70, 23);

        tgl_mulai1.setDisplayFormat("dd-MM-yyyy");
        tgl_mulai1.setName("tgl_mulai1"); // NOI18N
        tgl_mulai1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_mulai1KeyPressed(evt);
            }
        });
        FormInput.add(tgl_mulai1);
        tgl_mulai1.setBounds(80, 130, 90, 23);

        cmbJam2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam2.setName("cmbJam2"); // NOI18N
        cmbJam2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam2KeyPressed(evt);
            }
        });
        FormInput.add(cmbJam2);
        cmbJam2.setBounds(180, 130, 62, 23);

        cmbMnt2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt2.setName("cmbMnt2"); // NOI18N
        cmbMnt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt2KeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt2);
        cmbMnt2.setBounds(250, 130, 62, 23);

        cmbDtk2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk2.setName("cmbDtk2"); // NOI18N
        cmbDtk2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk2KeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk2);
        cmbDtk2.setBounds(320, 130, 62, 23);

        label16.setText("Selesai Op:");
        label16.setName("label16"); // NOI18N
        label16.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label16);
        label16.setBounds(390, 130, 70, 23);

        tgl_selesai1.setDisplayFormat("dd-MM-yyyy");
        tgl_selesai1.setName("tgl_selesai1"); // NOI18N
        tgl_selesai1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_selesai1KeyPressed(evt);
            }
        });
        FormInput.add(tgl_selesai1);
        tgl_selesai1.setBounds(470, 130, 90, 23);

        cmbJam3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam3.setName("cmbJam3"); // NOI18N
        cmbJam3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam3KeyPressed(evt);
            }
        });
        FormInput.add(cmbJam3);
        cmbJam3.setBounds(570, 130, 62, 23);

        cmbMnt3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt3.setName("cmbMnt3"); // NOI18N
        cmbMnt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt3KeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt3);
        cmbMnt3.setBounds(640, 130, 62, 23);

        cmbDtk3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk3.setName("cmbDtk3"); // NOI18N
        cmbDtk3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk3KeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk3);
        cmbDtk3.setBounds(710, 130, 62, 23);

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setName("jScrollPane5"); // NOI18N

        diagnosa_pre_op.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        diagnosa_pre_op.setColumns(20);
        diagnosa_pre_op.setRows(5);
        diagnosa_pre_op.setName("diagnosa_pre_op"); // NOI18N
        jScrollPane5.setViewportView(diagnosa_pre_op);

        FormInput.add(jScrollPane5);
        jScrollPane5.setBounds(850, 80, 160, 80);

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setName("jScrollPane6"); // NOI18N

        diagnosa_post_op.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        diagnosa_post_op.setColumns(20);
        diagnosa_post_op.setRows(5);
        diagnosa_post_op.setName("diagnosa_post_op"); // NOI18N
        jScrollPane6.setViewportView(diagnosa_post_op);

        FormInput.add(jScrollPane6);
        jScrollPane6.setBounds(850, 180, 160, 80);

        jLabel5.setText("Teknik Regional :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(360, 340, 90, 23);

        posisi_pasien.setBackground(new java.awt.Color(255, 255, 255));
        posisi_pasien.setForeground(new java.awt.Color(50, 50, 50));
        posisi_pasien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Supine", "Prone", "Litotomi", "Semi sitting", "Flowler", "Lateral dekubitus", "Right Trendelenburg", "Left Trendelenburg", "Knee Chest", "Jack-Knife", "Lain-lain" }));
        posisi_pasien.setName("posisi_pasien"); // NOI18N
        FormInput.add(posisi_pasien);
        posisi_pasien.setBounds(670, 370, 110, 22);

        prosedur.setName("prosedur"); // NOI18N
        prosedur.setPreferredSize(new java.awt.Dimension(80, 23));
        prosedur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prosedurKeyPressed(evt);
            }
        });
        FormInput.add(prosedur);
        prosedur.setBounds(660, 200, 100, 23);

        level.setName("level"); // NOI18N
        level.setPreferredSize(new java.awt.Dimension(80, 23));
        level.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                levelKeyPressed(evt);
            }
        });
        FormInput.add(level);
        level.setBounds(640, 340, 70, 23);

        label53.setText("prosedur:");
        label53.setName("label53"); // NOI18N
        label53.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label53);
        label53.setBounds(590, 200, 60, 23);

        label54.setText("Obat:");
        label54.setName("label54"); // NOI18N
        label54.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label54);
        label54.setBounds(570, 280, 60, 23);

        obat.setName("obat"); // NOI18N
        obat.setPreferredSize(new java.awt.Dimension(80, 23));
        obat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                obatKeyPressed(evt);
            }
        });
        FormInput.add(obat);
        obat.setBounds(640, 280, 70, 23);

        volume.setName("volume"); // NOI18N
        volume.setPreferredSize(new java.awt.Dimension(80, 23));
        volume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                volumeKeyPressed(evt);
            }
        });
        FormInput.add(volume);
        volume.setBounds(640, 310, 70, 23);

        label55.setText("Volume:");
        label55.setName("label55"); // NOI18N
        label55.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label55);
        label55.setBounds(570, 310, 60, 23);

        label56.setText("RL :");
        label56.setName("label56"); // NOI18N
        label56.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label56);
        label56.setBounds(860, 320, 20, 23);

        rl.setName("rl"); // NOI18N
        rl.setPreferredSize(new java.awt.Dimension(80, 23));
        rl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rlKeyPressed(evt);
            }
        });
        FormInput.add(rl);
        rl.setBounds(890, 320, 70, 23);

        nacl.setName("nacl"); // NOI18N
        nacl.setPreferredSize(new java.awt.Dimension(80, 23));
        nacl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                naclKeyPressed(evt);
            }
        });
        FormInput.add(nacl);
        nacl.setBounds(890, 380, 70, 23);

        label57.setText("Nacl :");
        label57.setName("label57"); // NOI18N
        label57.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label57);
        label57.setBounds(840, 380, 40, 23);

        koloid.setName("koloid"); // NOI18N
        koloid.setPreferredSize(new java.awt.Dimension(80, 23));
        koloid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                koloidKeyPressed(evt);
            }
        });
        FormInput.add(koloid);
        koloid.setBounds(890, 290, 70, 20);

        label58.setText("Koloid :");
        label58.setName("label58"); // NOI18N
        label58.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label58);
        label58.setBounds(840, 290, 40, 20);

        darah.setName("darah"); // NOI18N
        darah.setPreferredSize(new java.awt.Dimension(80, 23));
        darah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                darahKeyPressed(evt);
            }
        });
        FormInput.add(darah);
        darah.setBounds(890, 350, 70, 23);

        label59.setText("CC");
        label59.setName("label59"); // NOI18N
        label59.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label59);
        label59.setBounds(970, 320, 20, 23);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("II. Teknik Anestesi");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(390, 160, 145, 23);

        label60.setText("Darah :");
        label60.setName("label60"); // NOI18N
        label60.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label60);
        label60.setBounds(840, 350, 40, 23);

        label61.setText("CC");
        label61.setName("label61"); // NOI18N
        label61.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label61);
        label61.setBounds(970, 350, 20, 23);

        label62.setText("CC");
        label62.setName("label62"); // NOI18N
        label62.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label62);
        label62.setBounds(970, 380, 20, 23);

        label63.setText("CC");
        label63.setName("label63"); // NOI18N
        label63.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label63);
        label63.setBounds(970, 290, 20, 23);

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("V.Cairan Keluar");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(840, 410, 145, 20);

        Cairan.setText("Cairan :");
        Cairan.setName("Cairan"); // NOI18N
        Cairan.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(Cairan);
        Cairan.setBounds(830, 470, 50, 23);

        cairan.setName("cairan"); // NOI18N
        cairan.setPreferredSize(new java.awt.Dimension(80, 23));
        cairan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cairanKeyPressed(evt);
            }
        });
        FormInput.add(cairan);
        cairan.setBounds(890, 470, 70, 23);

        label65.setText("CC");
        label65.setName("label65"); // NOI18N
        label65.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label65);
        label65.setBounds(970, 470, 20, 23);

        label66.setText("Urine :");
        label66.setName("label66"); // NOI18N
        label66.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label66);
        label66.setBounds(840, 500, 40, 23);

        urine.setName("urine"); // NOI18N
        urine.setPreferredSize(new java.awt.Dimension(80, 23));
        urine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                urineKeyPressed(evt);
            }
        });
        FormInput.add(urine);
        urine.setBounds(890, 500, 70, 23);

        label67.setText("CC");
        label67.setName("label67"); // NOI18N
        label67.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label67);
        label67.setBounds(970, 500, 20, 23);

        label68.setText("CC");
        label68.setName("label68"); // NOI18N
        label68.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label68);
        label68.setBounds(970, 440, 20, 23);

        darah_keluar.setName("darah_keluar"); // NOI18N
        darah_keluar.setPreferredSize(new java.awt.Dimension(80, 23));
        darah_keluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                darah_keluarKeyPressed(evt);
            }
        });
        FormInput.add(darah_keluar);
        darah_keluar.setBounds(890, 440, 70, 23);

        label69.setText("Darah :");
        label69.setName("label69"); // NOI18N
        label69.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label69);
        label69.setBounds(840, 440, 40, 23);

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
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "23-04-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "23-04-2026" }));
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

    private void setJalanNapas() {
        alatJalanNapas = (ett1.isSelected() ? "ETT|" : "")
                + (NasalCanul.isSelected() ? "Nasal Canul|" : "")
                + (o2mask.isSelected() ? "O2 Mask|" : "")
                + (lma1.isSelected() ? "LMA" : "");
    }


    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        setJalanNapas();

        if (TNoRw.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "Nama Pasien");
            return;
        }

        if (kdanestesi.getText().trim().equals("")) {
            Valid.textKosong(kdanestesi, "kdanestesi");
            return;
        }
        if (Sequel.menyimpantf(
                "laporan_anestesi_custom",
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?",
                "No.Rawat, Tanggal & Jam",
                42,
                new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    KdDokter.getText(),
                    midazolam.getText(),
                    ondasetron.getText(),
                    dexa.getText(),
                    oksigen.getText(),
                    kdanestesi.getText(),
                    kdasistanestesi.getText(),
                    teknik_IV.getSelectedItem().toString(),
                    teknik_umum.getSelectedItem().toString(),
                    alatJalanNapas,
                    ett.getText(),
                    lma.getText(),
                    teknik_reg.getSelectedItem().toString(),
                    puncture.getSelectedItem().toString(),
                    komplikasi.getText(),
                    penanganan.getText(),
                    propofol.getText(),
                    fenta.getText(),
                    atrac.getText(),
                    sevo.getText(),
                    iso.getText(),
                    o2.getText(),
                    n2o.getText(),
                    diagnosa_pre_op.getText(),
                    prosedur.getText(),
                    diagnosa_post_op.getText(),
                    level.getText(),
                    obat.getText(),
                    volume.getText(),
                    Valid.SetTglJam(tgl_mulai1.getSelectedItem() + " " + cmbJam2.getSelectedItem() + ":" + cmbMnt2.getSelectedItem() + ":" + cmbDtk2.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai1.getSelectedItem() + " " + cmbJam3.getSelectedItem() + ":" + cmbMnt3.getSelectedItem() + ":" + cmbDtk3.getSelectedItem()),
                    posisi_pasien.getSelectedItem().toString(),
                    rl.getText(),
                    koloid.getText(),
                    darah.getText(),
                    nacl.getText(),
                    cairan.getText(),
                    darah_keluar.getText(),
                    urine.getText(),}) == true) {
            tabMode.addRow(new Object[]{
                TNoRw.getText(),
                TNoRM.getText(),
                TPasien.getText(),
                Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                kdanestesi.getText(),
                nmanestesi.getText(),
                kdasistanestesi.getText(),
                nmasistanestesi.getText(),
                KdDokter.getText(),
                NmDokter.getText(),
                midazolam.getText(),
                ondasetron.getText(),
                dexa.getText(),
                oksigen.getText(),
                teknik_IV.getSelectedItem().toString(),
                teknik_umum.getSelectedItem().toString(),
                alatJalanNapas,
                ett.getText(),
                lma.getText(),
                teknik_reg.getSelectedItem().toString(),
                puncture.getSelectedItem().toString(),
                komplikasi.getText(),
                penanganan.getText(),
                propofol.getText(),
                fenta.getText(),
                atrac.getText(),
                sevo.getText(),
                iso.getText(),
                o2.getText(),
                n2o.getText(),
                diagnosa_pre_op.getText(),
                prosedur.getText(),
                diagnosa_post_op.getText(),
                level.getText(),
                obat.getText(),
                volume.getText(),
                Valid.SetTglJam(tgl_mulai1.getSelectedItem() + " " + cmbJam2.getSelectedItem() + ":" + cmbMnt2.getSelectedItem() + ":" + cmbDtk2.getSelectedItem()),
                Valid.SetTglJam(tgl_selesai1.getSelectedItem() + " " + cmbJam3.getSelectedItem() + ":" + cmbMnt3.getSelectedItem() + ":" + cmbDtk3.getSelectedItem()),
                posisi_pasien.getSelectedItem().toString(),
                rl.getText(),
                koloid.getText(),
                darah.getText(),
                nacl.getText(),
                cairan.getText(),
                darah_keluar.getText(),
                urine.getText(),});
            emptTeks();
            LCount.setText("" + tabMode.getRowCount());
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
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
                if (kdanestesi.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
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
            if (kdanestesi.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
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

    private String safeGetValueAt(int row, int col) {
        Object value = tbObat.getValueAt(row, col);
        return value != null ? value.toString() : "";
    }

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

    private void MnLaporanAnestesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnLaporanAnestesiActionPerformed
        if (tbObat.getSelectedRow() > -1) {
            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());
            param.put("alamatrs", akses.getalamatrs());
            param.put("kotars", akses.getkabupatenrs());
            param.put("propinsirs", akses.getpropinsirs());
            param.put("kontakrs", akses.getkontakrs());
            param.put("emailrs", akses.getemailrs());
            param.put("base_url","https://" + koneksiDB.HOSTHYBRIDWEB() + ":" + koneksiDB.PORTWEB() + "/" + koneksiDB.HYBRIDWEB() + "/radiologi/");
            param.put("logo", Sequel.cariGambar("select setting.logo from setting"));
            finger = Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?", tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString());
            param.put("finger", "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs() + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 6).toString() + "\nID " + (finger.equals("") ? tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString() : finger) + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString()));
            finger1 = Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?", tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString());
            param.put("finger1", "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs() + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 8).toString() + "\nID " + (finger1.equals("") ? tbObat.getValueAt(tbObat.getSelectedRow(), 7).toString() : finger) + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString()));
            finger2 = Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?", tbObat.getValueAt(tbObat.getSelectedRow(), 9).toString());
            param.put("finger2", "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs() + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 10).toString() + "\nID " + (finger2.equals("") ? tbObat.getValueAt(tbObat.getSelectedRow(), 9).toString() : finger) + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString()));

            Valid.MyReportqry(
                    "rptLaporanAnestesiCustom.jasper", "report", "::[ Laporan Anestesi ]::",
                    "SELECT laporan_anestesi_custom.*, "
                    + "pasien.no_rkm_medis, pasien.nm_pasien,pasien.tgl_lahir,"
                    + "laporan_anestesi_custom_gambar.photo,"
                    + "d1.nm_dokter AS nm_dokter_operator, "
                    + "d2.nm_dokter AS nm_dokter_anestesi, "
                    + "pegawai.nama AS nm_asisten_anestesi "
                    + "FROM laporan_anestesi_custom "
                    + "JOIN reg_periksa ON laporan_anestesi_custom.no_rawat = reg_periksa.no_rawat "
                    + "JOIN pasien ON reg_periksa.no_rkm_medis = pasien.no_rkm_medis "
                    + "JOIN dokter d1 ON laporan_anestesi_custom.dokter = d1.kd_dokter "
                    + "JOIN dokter d2 ON laporan_anestesi_custom.dokter_anestesi = d2.kd_dokter "
                    + "JOIN pegawai ON laporan_anestesi_custom.prwt_anestesi = pegawai.nik "
                    + "left join laporan_anestesi_custom_gambar on laporan_anestesi_custom.no_rawat = laporan_anestesi_custom_gambar.no_rawat and laporan_anestesi_custom.tanggal_mulai = laporan_anestesi_custom_gambar.tanggal "
                    + "WHERE laporan_anestesi_custom.no_rawat ='" + tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString() + "' "
                    + "AND laporan_anestesi_custom.tanggal_mulai='" + tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString() + "'",
                    param);
        }
    }//GEN-LAST:event_MnLaporanAnestesiActionPerformed

    private void punctureKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_punctureKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_punctureKeyPressed

    private void o2maskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o2maskActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_o2maskActionPerformed

    private void NasalCanulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NasalCanulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NasalCanulActionPerformed

    private void lma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lma1ActionPerformed

    private void teknik_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teknik_regKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_teknik_regKeyPressed

    private void BtnAsnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAsnesActionPerformed
        pilihan = 2;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_BtnAsnesActionPerformed

    private void ondasetronKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ondasetronKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnAsnesActionPerformed(null);
        } else {
//            Valid.pindah(evt, kdasistoperator2, kdprwresust);
        }
    }//GEN-LAST:event_ondasetronKeyPressed

    private void BtnAnastesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnastesiActionPerformed
        pilihan = 1;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnAnastesiActionPerformed

    private void TNoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRMKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRMKeyPressed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,', ',pasien.nm_pasien) from reg_periksa inner join pasien "
                    + " on pasien.no_rkm_medis=reg_periksa.no_rkm_medis where reg_periksa.no_rawat=? ", TPasien, TNoRw.getText());
        } else {
            Valid.pindah(evt, TCari, kdanestesi);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void TNoRwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNoRwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRwActionPerformed

    private void kdasistanestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdasistanestesiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kdasistanestesiKeyPressed

    private void dexaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dexaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dexaKeyPressed

    private void n2oKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n2oKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_n2oKeyPressed

    private void midazolamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_midazolamKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_midazolamKeyPressed

    private void oksigenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oksigenKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_oksigenKeyPressed

    private void propofolKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_propofolKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_propofolKeyPressed

    private void fentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fentaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fentaKeyPressed

    private void atracKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_atracKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_atracKeyPressed

    private void sevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sevoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_sevoKeyPressed

    private void isoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_isoKeyPressed

    private void lmaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lmaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lmaKeyPressed

    private void o2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_o2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_o2KeyPressed

    private void ettKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ettKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ettKeyPressed

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

    private void midazolamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midazolamActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_midazolamActionPerformed

    private void kdanestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdanestesiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmanestesi.setText(dokter.tampil3(kdanestesi.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnAnastesiActionPerformed(null);
        } else {
            //            Valid.pindah(evt, kdoperator2, kddranak);
        }
    }//GEN-LAST:event_kdanestesiKeyPressed

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        pilihan = 3;
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void BtnDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokterKeyPressed
        //Valid.pindah(evt,Edukasi,Hubungan);
    }//GEN-LAST:event_BtnDokterKeyPressed

    private void tgl_mulai1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_mulai1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_mulai1KeyPressed

    private void cmbJam2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJam2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJam2KeyPressed

    private void cmbMnt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMnt2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMnt2KeyPressed

    private void cmbDtk2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtk2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDtk2KeyPressed

    private void tgl_selesai1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_selesai1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgl_selesai1KeyPressed

    private void cmbJam3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJam3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJam3KeyPressed

    private void cmbMnt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMnt3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMnt3KeyPressed

    private void cmbDtk3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtk3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDtk3KeyPressed

    private void prosedurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prosedurKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_prosedurKeyPressed

    private void levelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_levelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelKeyPressed

    private void obatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_obatKeyPressed

    private void volumeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_volumeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_volumeKeyPressed

    private void rlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rlKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_rlKeyPressed

    private void naclKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_naclKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_naclKeyPressed

    private void koloidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_koloidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_koloidKeyPressed

    private void darahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_darahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_darahKeyPressed

    private void cairanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cairanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cairanKeyPressed

    private void urineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urineKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_urineKeyPressed

    private void darah_keluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_darah_keluarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_darah_keluarKeyPressed

    private void MnPemantauanStatusFisiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnPemantauanStatusFisiologiActionPerformed
        if (tbObat.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
            return;
        }
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        Valid.panggilUrl("pemantauanstatusfisiologilaporananestesi/login.php?act=login&usere="+koneksiDB.USERHYBRIDWEB()+"&passwordte="+koneksiDB.PASHYBRIDWEB()+"&no_rawat="+tbObat.getValueAt(tbObat.getSelectedRow(),0).toString()+"&tanggal="+tbObat.getValueAt(tbObat.getSelectedRow(),3).toString());
        this.setCursor(Cursor.getDefaultCursor()); 
    }//GEN-LAST:event_MnPemantauanStatusFisiologiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMLaporanAnestesi dialog = new RMLaporanAnestesi(new javax.swing.JFrame(), true);
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
    private widget.Button BtnAsnes;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnDokter;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.Label Cairan;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.PanelBiasa FormInput;
    private widget.TextBox KdDokter;
    private widget.Label LCount;
    private javax.swing.JMenuItem MnLaporanAnestesi;
    private javax.swing.JMenuItem MnPemantauanStatusFisiologi;
    private javax.swing.JCheckBox NasalCanul;
    private widget.TextBox NmDokter;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.TextBox atrac;
    private widget.TextBox cairan;
    private widget.ComboBox cmbDtk;
    private widget.ComboBox cmbDtk1;
    private widget.ComboBox cmbDtk2;
    private widget.ComboBox cmbDtk3;
    private widget.ComboBox cmbJam;
    private widget.ComboBox cmbJam1;
    private widget.ComboBox cmbJam2;
    private widget.ComboBox cmbJam3;
    private widget.ComboBox cmbMnt;
    private widget.ComboBox cmbMnt1;
    private widget.ComboBox cmbMnt2;
    private widget.ComboBox cmbMnt3;
    private widget.TextBox darah;
    private widget.TextBox darah_keluar;
    private widget.TextBox dexa;
    private widget.TextArea diagnosa_post_op;
    private widget.TextArea diagnosa_pre_op;
    private widget.TextBox ett;
    private javax.swing.JCheckBox ett1;
    private widget.TextBox fenta;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.TextBox iso;
    private widget.Label jLabel10;
    private widget.Label jLabel15;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel23;
    private widget.Label jLabel24;
    private widget.Label jLabel3;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private widget.TextBox kdanestesi;
    private widget.TextBox kdasistanestesi;
    private widget.TextBox koloid;
    private widget.TextArea komplikasi;
    private widget.Label label12;
    private widget.Label label13;
    private widget.Label label14;
    private widget.Label label15;
    private widget.Label label16;
    private widget.Label label21;
    private widget.Label label22;
    private widget.Label label23;
    private widget.Label label24;
    private widget.Label label25;
    private widget.Label label26;
    private widget.Label label27;
    private widget.Label label28;
    private widget.Label label29;
    private widget.Label label30;
    private widget.Label label31;
    private widget.Label label32;
    private widget.Label label33;
    private widget.Label label34;
    private widget.Label label35;
    private widget.Label label36;
    private widget.Label label37;
    private widget.Label label38;
    private widget.Label label39;
    private widget.Label label40;
    private widget.Label label41;
    private widget.Label label42;
    private widget.Label label43;
    private widget.Label label44;
    private widget.Label label45;
    private widget.Label label46;
    private widget.Label label47;
    private widget.Label label48;
    private widget.Label label49;
    private widget.Label label50;
    private widget.Label label51;
    private widget.Label label52;
    private widget.Label label53;
    private widget.Label label54;
    private widget.Label label55;
    private widget.Label label56;
    private widget.Label label57;
    private widget.Label label58;
    private widget.Label label59;
    private widget.Label label60;
    private widget.Label label61;
    private widget.Label label62;
    private widget.Label label63;
    private widget.Label label65;
    private widget.Label label66;
    private widget.Label label67;
    private widget.Label label68;
    private widget.Label label69;
    private widget.TextBox level;
    private widget.TextBox lma;
    private javax.swing.JCheckBox lma1;
    private widget.TextBox midazolam;
    private widget.TextBox n2o;
    private widget.TextBox nacl;
    private widget.TextBox nmanestesi;
    private widget.TextBox nmasistanestesi;
    private widget.TextBox o2;
    private javax.swing.JCheckBox o2mask;
    private widget.TextBox obat;
    private widget.TextBox oksigen;
    private widget.TextBox ondasetron;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.TextArea penanganan;
    private javax.swing.JComboBox<String> posisi_pasien;
    private widget.TextBox propofol;
    private widget.TextBox prosedur;
    private widget.ComboBox puncture;
    private widget.TextBox rl;
    private widget.ScrollPane scrollInput;
    private widget.TextBox sevo;
    private widget.Table tbObat;
    private javax.swing.JComboBox<String> teknik_IV;
    private widget.ComboBox teknik_reg;
    private javax.swing.JComboBox<String> teknik_umum;
    private widget.Tanggal tgl_mulai;
    private widget.Tanggal tgl_mulai1;
    private widget.Tanggal tgl_selesai;
    private widget.Tanggal tgl_selesai1;
    private widget.TextBox urine;
    private widget.TextBox volume;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            String sql
                    = "SELECT laporan_anestesi_custom.*, "
                    + "pasien.no_rkm_medis, pasien.nm_pasien, "
                    + "d1.nm_dokter AS nm_dokter_operator, "
                    + "d2.nm_dokter AS nm_dokter_anestesi, "
                    + "pegawai.nama AS nm_asisten_anestesi "
                    + "FROM laporan_anestesi_custom "
                    + "JOIN reg_periksa ON laporan_anestesi_custom.no_rawat = reg_periksa.no_rawat "
                    + "JOIN pasien ON reg_periksa.no_rkm_medis = pasien.no_rkm_medis "
                    + "JOIN dokter d1 ON laporan_anestesi_custom.dokter = d1.kd_dokter "
                    + "JOIN dokter d2 ON laporan_anestesi_custom.dokter_anestesi = d2.kd_dokter "
                    + "JOIN pegawai ON laporan_anestesi_custom.prwt_anestesi = pegawai.nik "
                    + "WHERE laporan_anestesi_custom.tanggal_mulai BETWEEN ? AND ? "
                    + "AND (reg_periksa.no_rawat LIKE ? "
                    + "OR pasien.no_rkm_medis LIKE ? "
                    + "OR pasien.nm_pasien LIKE ? "
                    + "OR laporan_anestesi_custom.teknik_IV LIKE ? "
                    + "OR laporan_anestesi_custom.teknik_umum LIKE ? "
                    + "OR laporan_anestesi_custom.teknik_regional LIKE ? "
                    + "OR d1.nm_dokter LIKE ? "
                    + "OR d2.nm_dokter LIKE ?)";
            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");
                ps.setString(3, "%" + TCari.getText() + "%");
                ps.setString(4, "%" + TCari.getText() + "%");
                ps.setString(5, "%" + TCari.getText() + "%");
                ps.setString(6, "%" + TCari.getText() + "%");
                ps.setString(7, "%" + TCari.getText() + "%");
                ps.setString(8, "%" + TCari.getText() + "%");
                ps.setString(9, "%" + TCari.getText() + "%");
                ps.setString(10, "%" + TCari.getText() + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),
                        rs.getString("no_rkm_medis"),
                        rs.getString("nm_pasien"),
                        rs.getString("tanggal_mulai"),
                        rs.getString("tanggal_selesai"),
                        rs.getString("dokter_anestesi"),
                        rs.getString("nm_dokter_anestesi"),
                        rs.getString("prwt_anestesi"),
                        rs.getString("nm_asisten_anestesi"),
                        rs.getString("dokter"),
                        rs.getString("nm_dokter_operator"),
                        rs.getString("midazolam"),
                        rs.getString("ondasetron"),
                        rs.getString("dexa"),
                        rs.getString("oksigen"),
                        rs.getString("teknik_IV"),
                        rs.getString("teknik_umum"),
                        rs.getString("alat_jalan_napas"),
                        rs.getString("ett"),
                        rs.getString("lma"),
                        rs.getString("teknik_regional"),
                        rs.getString("posisi_puncture"),
                        rs.getString("komplikasi"),
                        rs.getString("penanganan"),
                        rs.getString("propofol"),
                        rs.getString("fetanyl"),
                        rs.getString("atracurium"),
                        rs.getString("sevoflourance"),
                        rs.getString("isoflurance"),
                        rs.getString("o2"),
                        rs.getString("n2o"),
                        rs.getString("diagnosa_pre_op"),
                        rs.getString("prosedur"),
                        rs.getString("diagnosa_post_op"),
                        rs.getString("Level"),
                        rs.getString("Obat"),
                        rs.getString("Volume"),
                        rs.getString("jam_mulai_op"),
                        rs.getString("jam_selesai_op"),
                        rs.getString("posisi_pasien"),
                        rs.getString("rl"),
                        rs.getString("koloid"),
                        rs.getString("darah"),
                        rs.getString("nacl"),
                        rs.getString("cairan"),
                        rs.getString("darah_keluar"),
                        rs.getString("urine"),});
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
        kdasistanestesi.setText("1034");
        nmasistanestesi.setText("Latif Sobirin, S.ST");
        KdDokter.setText("-");
        NmDokter.setText("-");
        tgl_mulai.setSelectedIndex(0);
        cmbJam.setSelectedIndex(0);
        cmbMnt.setSelectedIndex(0);
        cmbDtk.setSelectedIndex(0);
        tgl_selesai.setSelectedIndex(0);
        cmbJam1.setSelectedIndex(0);
        cmbMnt1.setSelectedIndex(0);
        cmbDtk1.setSelectedIndex(0);
        midazolam.setText("");
        ondasetron.setText("");
        dexa.setText("");
        oksigen.setText("");
        teknik_IV.setSelectedIndex(0);
        teknik_umum.setSelectedIndex(0);
        ett.setText("");
        lma.setText("");
        ett1.setSelected(false);
        NasalCanul.setSelected(false);
        o2mask.setSelected(false);
        lma1.setSelected(false);
        teknik_reg.setSelectedIndex(0);
        komplikasi.setText("");
        propofol.setText("");
        fenta.setText("");
        atrac.setText("");
        sevo.setText("");
        iso.setText("");
        o2.setText("");
        n2o.setText("");
        TabRawat.setSelectedIndex(0);
        TNoRw.requestFocus();
        diagnosa_pre_op.setText("");
        prosedur.setText("");
        diagnosa_post_op.setText("");
        level.setText("");
        obat.setText("");
        volume.setText("");
        tgl_mulai1.setSelectedIndex(0);
        cmbJam2.setSelectedIndex(0);
        cmbMnt2.setSelectedIndex(0);
        cmbDtk2.setSelectedIndex(0);
        tgl_selesai1.setSelectedIndex(0);
        cmbJam3.setSelectedIndex(0);
        cmbMnt3.setSelectedIndex(0);
        cmbDtk3.setSelectedIndex(0);
        posisi_pasien.setSelectedIndex(0);
        rl.setText("");
        koloid.setText("");
        darah.setText("");
        nacl.setText("");
        cairan.setText("");
        darah_keluar.setText("");
        urine.setText("");
    }

    private void getData() {
        int row = tbObat.getSelectedRow();
        if (row != -1) {
            TNoRw.setText(tbObat.getValueAt(row, 0).toString());
            TNoRM.setText(tbObat.getValueAt(row, 1).toString());
            TPasien.setText(tbObat.getValueAt(row, 2).toString());

            kdanestesi.setText(tbObat.getValueAt(row, 5).toString());
            nmanestesi.setText(tbObat.getValueAt(row, 6).toString());

            kdasistanestesi.setText(tbObat.getValueAt(row, 7).toString());
            nmasistanestesi.setText(tbObat.getValueAt(row, 8).toString());

            KdDokter.setText(tbObat.getValueAt(row, 9).toString());
            NmDokter.setText(tbObat.getValueAt(row, 10).toString());

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

            midazolam.setText(tbObat.getValueAt(row, 11).toString());
            ondasetron.setText(tbObat.getValueAt(row, 12).toString());
            dexa.setText(tbObat.getValueAt(row, 13).toString());
            oksigen.setText(tbObat.getValueAt(row, 14).toString());

            teknik_IV.setSelectedItem(tbObat.getValueAt(row, 15).toString());
            teknik_umum.setSelectedItem(tbObat.getValueAt(row, 16).toString());
            String jalan = tbObat.getValueAt(row, 17).toString();
            ett1.setSelected(jalan.contains("ETT"));
            NasalCanul.setSelected(jalan.contains("Nasal Canul"));
            o2mask.setSelected(jalan.contains("O2 Mask"));
            lma1.setSelected(jalan.contains("LMA"));
            ett.setText(tbObat.getValueAt(row, 18).toString());
            lma.setText(tbObat.getValueAt(row, 19).toString());
            teknik_reg.setSelectedItem(tbObat.getValueAt(row, 20).toString());
            puncture.setSelectedItem(tbObat.getValueAt(row, 21).toString());
            komplikasi.setText(tbObat.getValueAt(row, 22).toString());
            penanganan.setText(tbObat.getValueAt(row, 23).toString());
            propofol.setText(tbObat.getValueAt(row, 24).toString());
            fenta.setText(tbObat.getValueAt(row, 25).toString());
            atrac.setText(tbObat.getValueAt(row, 26).toString());
            sevo.setText(tbObat.getValueAt(row, 27).toString());
            iso.setText(tbObat.getValueAt(row, 28).toString());
            o2.setText(tbObat.getValueAt(row, 29).toString());
            n2o.setText(tbObat.getValueAt(row, 30).toString());
            diagnosa_pre_op.setText(tbObat.getValueAt(row, 31).toString());
            prosedur.setText(tbObat.getValueAt(row, 32).toString());
            diagnosa_post_op.setText(tbObat.getValueAt(row, 33).toString());
            level.setText(tbObat.getValueAt(row, 34).toString());
            obat.setText(tbObat.getValueAt(row, 35).toString());
            volume.setText(tbObat.getValueAt(row, 36).toString());

            String tglMulai1[] = tbObat.getValueAt(row, 37).toString().split(" ");
            String jamMulai1[] = tglMulai1[1].split(":");
            Valid.SetTgl(tgl_mulai1, tglMulai1[0]);
            cmbJam2.setSelectedItem(jamMulai1[0]);
            cmbMnt2.setSelectedItem(jamMulai1[1]);
            cmbDtk2.setSelectedItem(jamMulai1[2]);

            String tglSelesai1[] = tbObat.getValueAt(row, 38).toString().split(" ");
            String jamSelesai1[] = tglSelesai1[1].split(":");
            Valid.SetTgl(tgl_selesai1, tglSelesai1[0]);
            cmbJam3.setSelectedItem(jamSelesai1[0]);
            cmbMnt3.setSelectedItem(jamSelesai1[1]);
            cmbDtk3.setSelectedItem(jamSelesai1[2]);

            posisi_pasien.setSelectedItem(tbObat.getValueAt(row, 39).toString());
            rl.setText(tbObat.getValueAt(row, 40).toString());
            koloid.setText(tbObat.getValueAt(row, 41).toString());
            darah.setText(tbObat.getValueAt(row, 42).toString());
            nacl.setText(tbObat.getValueAt(row, 43).toString());
            cairan.setText(tbObat.getValueAt(row, 44).toString());
            darah_keluar.setText(tbObat.getValueAt(row, 45).toString());
            urine.setText(tbObat.getValueAt(row, 46).toString());
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
        getDataFromLaporanOperasi(norwt);
    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.getcatatan_anestesi_sedasi());
        BtnHapus.setEnabled(akses.getcatatan_anestesi_sedasi());
        BtnEdit.setEnabled(akses.getcatatan_anestesi_sedasi());
        BtnEdit.setEnabled(akses.getcatatan_anestesi_sedasi());
        if (akses.getjml2() >= 1) {
            kdanestesi.setEditable(false);
            BtnAnastesi.setEnabled(false);
            kdanestesi.setText(akses.getkode());
            nmanestesi.setText(dokter.tampil3(kdanestesi.getText()));
            if (nmanestesi.getText().equals("")) {
                kdanestesi.setText("");
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
                    "delete from laporan_anestesi_custom where no_rawat=? and tanggal_mulai=?",
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

        setJalanNapas();
        if (Sequel.mengedittf("laporan_anestesi_custom", "no_rawat=?",
                "no_rawat=?,tanggal_mulai=?,tanggal_selesai=?,dokter=?,midazolam=?,ondasetron=?,dexa=?,oksigen=?,dokter_anestesi=?,prwt_anestesi=?,"
                + "teknik_IV=?,teknik_umum=?,alat_jalan_napas=?,ett=?,"
                + "lma=?,teknik_regional=?,posisi_puncture=?,komplikasi=?,penanganan=?,propofol=?,fetanyl=?,"
                + "atracurium=?,sevoflourance=?,isoflurance=?,o2=?,n2o=?,diagnosa_pre_op=?,prosedur=?,"
                + "diagnosa_post_op=?,Level=?,Obat=?,Volume=?,jam_mulai_op=?,jam_selesai_op=?,posisi_pasien=?,"
                + "rl=?,koloid=?,darah=?,nacl=?,cairan=?,darah_keluar=?,urine=?",
                43, new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    KdDokter.getText(), midazolam.getText(), ondasetron.getText(),
                     dexa.getText(),
                     oksigen.getText(),
                     kdanestesi.getText(),
                     kdasistanestesi.getText(),
                     teknik_IV.getSelectedItem().toString(),
                     teknik_umum.getSelectedItem().toString(), alatJalanNapas,
                     ett.getText(),
                     lma.getText(),
                     teknik_reg.getSelectedItem().toString(),
                     puncture.getSelectedItem().toString(),
                     komplikasi.getText(),
                     penanganan.getText(),
                     propofol.getText(),
                     fenta.getText(),
                     atrac.getText(),
                     sevo.getText(),
                     iso.getText(),
                     o2.getText(),
                     n2o.getText(),
                     diagnosa_pre_op.getText(),
                     prosedur.getText(),
                     diagnosa_post_op.getText(),
                     level.getText(),
                     obat.getText(),
                     volume.getText(),
                     Valid.SetTglJam(tgl_mulai1.getSelectedItem() + " " + cmbJam2.getSelectedItem() + ":" + cmbMnt2.getSelectedItem() + ":" + cmbDtk2.getSelectedItem()),
                     Valid.SetTglJam(tgl_selesai1.getSelectedItem() + " " + cmbJam3.getSelectedItem() + ":" + cmbMnt3.getSelectedItem() + ":" + cmbDtk3.getSelectedItem()),
                     posisi_pasien.getSelectedItem().toString(),
                     rl.getText(),
                     koloid.getText(),
                     darah.getText(),
                     nacl.getText(),
                     cairan.getText(),
                     darah_keluar.getText(),
                     urine.getText(),
                     TNoRw.getText()
                }
        ) == true) {
            emptTeks();
            tampil();
            TabRawat.setSelectedIndex(1);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah.");
        }
    }
    
    private void getDataFromLaporanOperasi(String norwt) {
        try {
            ps = koneksi.prepareStatement("select operator1, asisten_anestesi, diagnosa_preop, diagnosa_preop, tgl_mulai, tgl_selesai from laporan_operasi_custom where no_rawat = ? order by tgl_mulai desc limit 1");
            try {
                ps.setString(1, norwt);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    KdDokter.setText(rs.getString("operator1"));
                    //kdasistanestesi.setText(rs.getString("asisten_anestesi"));
                    diagnosa_pre_op.setText(rs.getString("diagnosa_preop"));
                    diagnosa_post_op.setText(rs.getString("diagnosa_preop"));
                    NmDokter.setText(dokter.tampil3(rs.getString("operator1")));
                    //nmasistanestesi.setText(petugas.tampil3(rs.getString("asisten_anestesi")));
                    String tglMulai1[] = rs.getString("tgl_mulai").split(" ");
                    String jamMulai1[] = tglMulai1[1].split(":");
                    Valid.SetTgl(tgl_mulai1, tglMulai1[0]);
                    cmbJam2.setSelectedItem(jamMulai1[0]);
                    cmbMnt2.setSelectedItem(jamMulai1[1]);
                    cmbDtk2.setSelectedItem(jamMulai1[2]);

                    String tglSelesai1[] = rs.getString("tgl_selesai").split(" ");
                    String jamSelesai1[] = tglSelesai1[1].split(":");
                    Valid.SetTgl(tgl_selesai1, tglSelesai1[0]);
                    cmbJam3.setSelectedItem(jamSelesai1[0]);
                    cmbMnt3.setSelectedItem(jamSelesai1[1]);
                    cmbDtk3.setSelectedItem(jamSelesai1[2]);
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
