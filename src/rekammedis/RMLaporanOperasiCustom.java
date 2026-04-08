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
import kepegawaian.DlgCariPetugas;

/**
 *
 * @author perpustakaan
 */
public final class RMLaporanOperasiCustom extends javax.swing.JDialog {

    private final DefaultTableModel tabMode;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0, pilihan = 0;
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    private DlgCariPetugas petugas = new DlgCariPetugas(null, false);
    private String finger = "";

    /**
     * Creates new form DlgRujuk
     *
     * @param parent
     * @param modal
     */
    public RMLaporanOperasiCustom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new Object[]{
            "No.Rawat", "No.RM", "Nama Pasien", "Kode Operator 1", "Nama Operator 1",
            "Kode Operator 2", "Nama Operator 2", "Kode dr Anestesi", "Nama dr Anestesi",
            "Kode dr Anak", "Nama dr Anak", "kode Bidan 1", "Kode Bidan 1", "kode Bidan 2", "Kode Bidan 2",
            "kode dr Umum", "Kode dr Umum", "Kode Ast Operator 1", "Nama Ast Operator 1",
            "Kode Ast Operator 2", "Nama Ast Operator 2", "Kode Ast Anestesi", "Nama Ast Anestesi",
            "Kode Prw Resusitasi", "Nama Prw Resusitasi", "Kode Onloop 1", "Nama Onloop 1",
            "Kode Onloop 2", "Nama Onloop 2", "Kode Instrumen", "Nama Instrumen",
            "Mulai Operasi", "Selesai Operasi", "Jenis Anestesi", "Sifat Tindakan",
            "Kategori", "Penyulit", "Pemeriksaan PA", "Kehilangan Darah", "Nomor Implan",
            "Jaringan di-Eksisi/Insisi", "Komplikasi", "Diagnosa pre-OP", "Diagnosa post-OP",
            "Macam Operasi", "Instruksi Pasca OP", "Laporan Operasi"
        }) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

        };

        tbObat.setModel(tabMode);
        tbObat.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 47; i++) {
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
                column.setPreferredWidth(65);
            } else if (i == 5) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 6) {
                column.setPreferredWidth(150);
            } else if (i == 7) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 8) {
                column.setPreferredWidth(60);
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
            } else if (i == 20) {
                column.setPreferredWidth(150);
            } else if (i == 21) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 22) {
                column.setPreferredWidth(150);
            } else if (i == 23) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 24) {
                column.setPreferredWidth(106);
            } else if (i == 25) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 26) {
                column.setPreferredWidth(100);
            } else if (i == 27) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 28) {
                column.setPreferredWidth(100);
            } else if (i == 29) {
                column.setMinWidth(0);
                column.setMaxWidth(0);
            } else if (i == 30) {
                column.setPreferredWidth(170);
            } else if (i == 31) {
                column.setPreferredWidth(170);
            } else if (i == 32) {
                column.setPreferredWidth(170);
            } else if (i == 33) {
                column.setPreferredWidth(170);
            } else if (i == 34) {
                column.setPreferredWidth(170);
            } else if (i == 35) {
                column.setPreferredWidth(170);
            } else if (i == 36) {
                column.setPreferredWidth(170);
            } else if (i == 37) {
                column.setPreferredWidth(170);
            } else if (i == 38) {
                column.setPreferredWidth(170);
            } else if (i == 39) {
                column.setPreferredWidth(170);
            } else if (i == 40) {
                column.setPreferredWidth(170);
            } else if (i == 41) {
                column.setPreferredWidth(170);
            } else if (i == 42) {
                column.setPreferredWidth(170);
            } else if (i == 43) {
                column.setPreferredWidth(170);
            } else if (i == 44) {
                column.setPreferredWidth(170);
            } else if (i == 45) {
                column.setPreferredWidth(170);
            } else if (i == 46) {
                column.setPreferredWidth(170);
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
                        kdoperator1.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmoperator1.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kdoperator1.requestFocus();
                    } else if (pilihan == 2) {
                        kdoperator2.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmoperator2.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kdoperator2.requestFocus();
                    } else if (pilihan == 3) {
                    } else if (pilihan == 4) {
                        kdanestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmanestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kdanestesi.requestFocus();
                    } else if (pilihan == 5) {
                        kddranak.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmdranak.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kddranak.requestFocus();
                    } else if (pilihan == 6) {
                    } else if (pilihan == 7) {
                        kddrumum.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                        nmdrumum.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                        kddrumum.requestFocus();
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
                    if (pilihan == 1) {
                        kdasistoperator1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmasistoperator1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdasistoperator1.requestFocus();
                    } else if (pilihan == 2) {
                        kdasistoperator2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmasistoperator2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdasistoperator2.requestFocus();
                    } else if (pilihan == 3) {
                        kdInstrumen.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nminstrumen.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdInstrumen.requestFocus();
                    } else if (pilihan == 4) {
                        kdasistanestesi.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmasistanestesi.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdasistanestesi.requestFocus();
                    } else if (pilihan == 5) {
                        kdprwresust.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmprwresust.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdprwresust.requestFocus();
                    } else if (pilihan == 6) {
                    } else if (pilihan == 7) {
                        kdbidan1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmbidan1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdbidan1.requestFocus();
                    } else if (pilihan == 8) {
                        kdbidan2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmbidan2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdbidan2.requestFocus();
                    } else if (pilihan == 9) {
                    } else if (pilihan == 10) {
                        kdonloop1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmonloop1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdonloop1.requestFocus();
                    } else if (pilihan == 11) {
                        kdonloop2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                        nmonloop2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                        kdonloop2.requestFocus();
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
        MnLaporanOperasi = new javax.swing.JMenuItem();
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
        label14 = new widget.Label();
        kdoperator1 = new widget.TextBox();
        nmoperator1 = new widget.TextBox();
        BtnOperator1 = new widget.Button();
        label19 = new widget.Label();
        kdoperator2 = new widget.TextBox();
        nmoperator2 = new widget.TextBox();
        BtnOperator2 = new widget.Button();
        label21 = new widget.Label();
        kdanestesi = new widget.TextBox();
        nmanestesi = new widget.TextBox();
        BtnAnastesi = new widget.Button();
        label22 = new widget.Label();
        kddranak = new widget.TextBox();
        nmdranak = new widget.TextBox();
        btnAnak = new widget.Button();
        label27 = new widget.Label();
        kdbidan1 = new widget.TextBox();
        nmbidan1 = new widget.TextBox();
        btnBidan = new widget.Button();
        label29 = new widget.Label();
        kdbidan2 = new widget.TextBox();
        nmbidan2 = new widget.TextBox();
        btnBidan2 = new widget.Button();
        label23 = new widget.Label();
        kdInstrumen = new widget.TextBox();
        nminstrumen = new widget.TextBox();
        btnAsis3 = new widget.Button();
        label34 = new widget.Label();
        kddrumum = new widget.TextBox();
        nmdrumum = new widget.TextBox();
        btndrumum = new widget.Button();
        label17 = new widget.Label();
        kdasistoperator1 = new widget.TextBox();
        nmasistoperator1 = new widget.TextBox();
        btnAsis1 = new widget.Button();
        label18 = new widget.Label();
        kdasistoperator2 = new widget.TextBox();
        nmasistoperator2 = new widget.TextBox();
        btnAsis2 = new widget.Button();
        label26 = new widget.Label();
        kdasistanestesi = new widget.TextBox();
        nmasistanestesi = new widget.TextBox();
        BtnAsnes = new widget.Button();
        label24 = new widget.Label();
        kdprwresust = new widget.TextBox();
        nmprwresust = new widget.TextBox();
        btnPrwRes = new widget.Button();
        label25 = new widget.Label();
        kdonloop1 = new widget.TextBox();
        nmonloop1 = new widget.TextBox();
        btnOnloop1 = new widget.Button();
        label31 = new widget.Label();
        kdonloop2 = new widget.TextBox();
        nmonloop2 = new widget.TextBox();
        btnOnloop2 = new widget.Button();
        label11 = new widget.Label();
        tgl_mulai = new widget.Tanggal();
        label12 = new widget.Label();
        tgl_selesai = new widget.Tanggal();
        cmbJam = new widget.ComboBox();
        cmbMnt = new widget.ComboBox();
        cmbDtk = new widget.ComboBox();
        cmbJam1 = new widget.ComboBox();
        cmbMnt1 = new widget.ComboBox();
        cmbDtk1 = new widget.ComboBox();
        jLabel4 = new widget.Label();
        jenis = new widget.ComboBox();
        jLabel5 = new widget.Label();
        Sifat = new widget.ComboBox();
        jLabel16 = new widget.Label();
        Kategori = new widget.ComboBox();
        Penyulit = new widget.ComboBox();
        jLabel9 = new widget.Label();
        DikirimPA = new widget.ComboBox();
        jLabel14 = new widget.Label();
        KehilanganDarah = new widget.TextBox();
        jLabel13 = new widget.Label();
        jLabel11 = new widget.Label();
        NomorImplant = new widget.TextBox();
        jLabel12 = new widget.Label();
        Jaringan = new widget.TextBox();
        jLabel8 = new widget.Label();
        Komplikasi = new widget.TextBox();
        jLabel15 = new widget.Label();
        jLabel10 = new widget.Label();
        scrollPane4 = new widget.ScrollPane();
        PostOp = new widget.TextArea();
        scrollPane3 = new widget.ScrollPane();
        PreOp = new widget.TextArea();
        jLabel17 = new widget.Label();
        scrollPane5 = new widget.ScrollPane();
        MacamOperasi = new widget.TextArea();
        jLabel18 = new widget.Label();
        scrollPane6 = new widget.ScrollPane();
        InstruksiPascaOP = new widget.TextArea();
        btnTemplate = new widget.Button();
        jLabel20 = new widget.Label();
        scrollPane2 = new widget.ScrollPane();
        Laporan = new widget.TextArea();
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

        MnLaporanOperasi.setBackground(new java.awt.Color(255, 255, 254));
        MnLaporanOperasi.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnLaporanOperasi.setForeground(new java.awt.Color(50, 50, 50));
        MnLaporanOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnLaporanOperasi.setText("Laporan Pengkajian Pre Induksi");
        MnLaporanOperasi.setName("MnLaporanOperasi"); // NOI18N
        MnLaporanOperasi.setPreferredSize(new java.awt.Dimension(220, 26));
        MnLaporanOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnLaporanOperasiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnLaporanOperasi);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Laporan Operasi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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
        TNoRw.setBounds(90, 10, 130, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(305, 10, 430, 23);

        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRMKeyPressed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(223, 10, 80, 23);

        label14.setText("Operator 1 :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label14);
        label14.setBounds(0, 40, 81, 23);

        kdoperator1.setEditable(false);
        kdoperator1.setName("kdoperator1"); // NOI18N
        kdoperator1.setPreferredSize(new java.awt.Dimension(80, 23));
        kdoperator1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdoperator1KeyPressed(evt);
            }
        });
        FormInput.add(kdoperator1);
        kdoperator1.setBounds(90, 40, 70, 23);

        nmoperator1.setEditable(false);
        nmoperator1.setName("nmoperator1"); // NOI18N
        nmoperator1.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmoperator1);
        nmoperator1.setBounds(160, 40, 190, 23);

        BtnOperator1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnOperator1.setMnemonic('2');
        BtnOperator1.setToolTipText("Alt+2");
        BtnOperator1.setName("BtnOperator1"); // NOI18N
        BtnOperator1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnOperator1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOperator1ActionPerformed(evt);
            }
        });
        BtnOperator1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnOperator1KeyPressed(evt);
            }
        });
        FormInput.add(BtnOperator1);
        BtnOperator1.setBounds(350, 40, 28, 23);

        label19.setText("Operator 2 :");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label19);
        label19.setBounds(0, 70, 81, 23);

        kdoperator2.setEditable(false);
        kdoperator2.setName("kdoperator2"); // NOI18N
        kdoperator2.setPreferredSize(new java.awt.Dimension(80, 23));
        kdoperator2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdoperator2KeyPressed(evt);
            }
        });
        FormInput.add(kdoperator2);
        kdoperator2.setBounds(90, 70, 70, 23);

        nmoperator2.setEditable(false);
        nmoperator2.setName("nmoperator2"); // NOI18N
        nmoperator2.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmoperator2);
        nmoperator2.setBounds(160, 70, 190, 23);

        BtnOperator2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnOperator2.setMnemonic('2');
        BtnOperator2.setToolTipText("Alt+2");
        BtnOperator2.setName("BtnOperator2"); // NOI18N
        BtnOperator2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnOperator2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOperator2ActionPerformed(evt);
            }
        });
        BtnOperator2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnOperator2KeyPressed(evt);
            }
        });
        FormInput.add(BtnOperator2);
        BtnOperator2.setBounds(350, 70, 28, 23);

        label21.setText("dr Anestesi :");
        label21.setName("label21"); // NOI18N
        label21.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label21);
        label21.setBounds(0, 100, 81, 23);

        kdanestesi.setEditable(false);
        kdanestesi.setName("kdanestesi"); // NOI18N
        kdanestesi.setPreferredSize(new java.awt.Dimension(80, 23));
        kdanestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdanestesiKeyPressed(evt);
            }
        });
        FormInput.add(kdanestesi);
        kdanestesi.setBounds(90, 100, 70, 23);

        nmanestesi.setEditable(false);
        nmanestesi.setName("nmanestesi"); // NOI18N
        nmanestesi.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmanestesi);
        nmanestesi.setBounds(160, 100, 190, 23);

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
        BtnAnastesi.setBounds(350, 100, 28, 23);

        label22.setText("dr Anak :");
        label22.setName("label22"); // NOI18N
        label22.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label22);
        label22.setBounds(0, 130, 81, 23);

        kddranak.setEditable(false);
        kddranak.setName("kddranak"); // NOI18N
        kddranak.setPreferredSize(new java.awt.Dimension(80, 23));
        kddranak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kddranakKeyPressed(evt);
            }
        });
        FormInput.add(kddranak);
        kddranak.setBounds(90, 130, 70, 23);

        nmdranak.setEditable(false);
        nmdranak.setName("nmdranak"); // NOI18N
        nmdranak.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmdranak);
        nmdranak.setBounds(160, 130, 190, 23);

        btnAnak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnAnak.setMnemonic('2');
        btnAnak.setToolTipText("Alt+2");
        btnAnak.setName("btnAnak"); // NOI18N
        btnAnak.setPreferredSize(new java.awt.Dimension(28, 23));
        btnAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnakActionPerformed(evt);
            }
        });
        FormInput.add(btnAnak);
        btnAnak.setBounds(350, 130, 28, 23);

        label27.setText("Bidan 1 :");
        label27.setName("label27"); // NOI18N
        label27.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label27);
        label27.setBounds(0, 160, 81, 23);

        kdbidan1.setEditable(false);
        kdbidan1.setName("kdbidan1"); // NOI18N
        kdbidan1.setPreferredSize(new java.awt.Dimension(80, 23));
        kdbidan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdbidan1KeyPressed(evt);
            }
        });
        FormInput.add(kdbidan1);
        kdbidan1.setBounds(90, 160, 70, 23);

        nmbidan1.setEditable(false);
        nmbidan1.setName("nmbidan1"); // NOI18N
        nmbidan1.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmbidan1);
        nmbidan1.setBounds(160, 160, 190, 23);

        btnBidan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnBidan.setMnemonic('2');
        btnBidan.setToolTipText("Alt+2");
        btnBidan.setName("btnBidan"); // NOI18N
        btnBidan.setPreferredSize(new java.awt.Dimension(28, 23));
        btnBidan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBidanActionPerformed(evt);
            }
        });
        FormInput.add(btnBidan);
        btnBidan.setBounds(350, 160, 28, 23);

        label29.setText("Bidan 2 :");
        label29.setName("label29"); // NOI18N
        label29.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label29);
        label29.setBounds(0, 190, 81, 23);

        kdbidan2.setEditable(false);
        kdbidan2.setName("kdbidan2"); // NOI18N
        kdbidan2.setPreferredSize(new java.awt.Dimension(80, 23));
        kdbidan2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdbidan2KeyPressed(evt);
            }
        });
        FormInput.add(kdbidan2);
        kdbidan2.setBounds(90, 190, 70, 23);

        nmbidan2.setEditable(false);
        nmbidan2.setName("nmbidan2"); // NOI18N
        nmbidan2.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmbidan2);
        nmbidan2.setBounds(160, 190, 190, 23);

        btnBidan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnBidan2.setMnemonic('2');
        btnBidan2.setToolTipText("Alt+2");
        btnBidan2.setName("btnBidan2"); // NOI18N
        btnBidan2.setPreferredSize(new java.awt.Dimension(28, 23));
        btnBidan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBidan2ActionPerformed(evt);
            }
        });
        FormInput.add(btnBidan2);
        btnBidan2.setBounds(350, 190, 28, 23);

        label23.setText("Instrumen :");
        label23.setName("label23"); // NOI18N
        label23.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label23);
        label23.setBounds(390, 220, 81, 23);

        kdInstrumen.setEditable(false);
        kdInstrumen.setName("kdInstrumen"); // NOI18N
        kdInstrumen.setPreferredSize(new java.awt.Dimension(80, 23));
        kdInstrumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdInstrumenKeyPressed(evt);
            }
        });
        FormInput.add(kdInstrumen);
        kdInstrumen.setBounds(480, 220, 70, 23);

        nminstrumen.setEditable(false);
        nminstrumen.setName("nminstrumen"); // NOI18N
        nminstrumen.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nminstrumen);
        nminstrumen.setBounds(550, 220, 190, 23);

        btnAsis3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnAsis3.setMnemonic('2');
        btnAsis3.setToolTipText("Alt+2");
        btnAsis3.setName("btnAsis3"); // NOI18N
        btnAsis3.setPreferredSize(new java.awt.Dimension(28, 23));
        btnAsis3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsis3ActionPerformed(evt);
            }
        });
        FormInput.add(btnAsis3);
        btnAsis3.setBounds(740, 220, 28, 23);

        label34.setText("dr Umum :");
        label34.setName("label34"); // NOI18N
        label34.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label34);
        label34.setBounds(0, 220, 81, 23);

        kddrumum.setEditable(false);
        kddrumum.setName("kddrumum"); // NOI18N
        kddrumum.setPreferredSize(new java.awt.Dimension(80, 23));
        kddrumum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kddrumumKeyPressed(evt);
            }
        });
        FormInput.add(kddrumum);
        kddrumum.setBounds(90, 220, 70, 23);

        nmdrumum.setEditable(false);
        nmdrumum.setName("nmdrumum"); // NOI18N
        nmdrumum.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmdrumum);
        nmdrumum.setBounds(160, 220, 190, 23);

        btndrumum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btndrumum.setMnemonic('2');
        btndrumum.setToolTipText("Alt+2");
        btndrumum.setName("btndrumum"); // NOI18N
        btndrumum.setPreferredSize(new java.awt.Dimension(28, 23));
        btndrumum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndrumumActionPerformed(evt);
            }
        });
        FormInput.add(btndrumum);
        btndrumum.setBounds(350, 220, 28, 23);

        label17.setText("Ast. Operator 1 :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label17);
        label17.setBounds(380, 40, 90, 23);

        kdasistoperator1.setEditable(false);
        kdasistoperator1.setName("kdasistoperator1"); // NOI18N
        kdasistoperator1.setPreferredSize(new java.awt.Dimension(80, 23));
        kdasistoperator1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdasistoperator1KeyPressed(evt);
            }
        });
        FormInput.add(kdasistoperator1);
        kdasistoperator1.setBounds(480, 40, 70, 23);

        nmasistoperator1.setEditable(false);
        nmasistoperator1.setName("nmasistoperator1"); // NOI18N
        nmasistoperator1.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmasistoperator1);
        nmasistoperator1.setBounds(550, 40, 190, 23);

        btnAsis1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnAsis1.setMnemonic('2');
        btnAsis1.setToolTipText("Alt+2");
        btnAsis1.setName("btnAsis1"); // NOI18N
        btnAsis1.setPreferredSize(new java.awt.Dimension(28, 23));
        btnAsis1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsis1ActionPerformed(evt);
            }
        });
        FormInput.add(btnAsis1);
        btnAsis1.setBounds(740, 40, 28, 23);

        label18.setText("Ast. Operator 2 :");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label18);
        label18.setBounds(380, 70, 90, 23);

        kdasistoperator2.setEditable(false);
        kdasistoperator2.setName("kdasistoperator2"); // NOI18N
        kdasistoperator2.setPreferredSize(new java.awt.Dimension(80, 23));
        kdasistoperator2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdasistoperator2KeyPressed(evt);
            }
        });
        FormInput.add(kdasistoperator2);
        kdasistoperator2.setBounds(480, 70, 70, 23);

        nmasistoperator2.setEditable(false);
        nmasistoperator2.setName("nmasistoperator2"); // NOI18N
        nmasistoperator2.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmasistoperator2);
        nmasistoperator2.setBounds(550, 70, 190, 23);

        btnAsis2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnAsis2.setMnemonic('2');
        btnAsis2.setToolTipText("Alt+2");
        btnAsis2.setName("btnAsis2"); // NOI18N
        btnAsis2.setPreferredSize(new java.awt.Dimension(28, 23));
        btnAsis2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsis2ActionPerformed(evt);
            }
        });
        FormInput.add(btnAsis2);
        btnAsis2.setBounds(740, 70, 28, 23);

        label26.setText("Ast. Anestesi :");
        label26.setName("label26"); // NOI18N
        label26.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label26);
        label26.setBounds(380, 100, 90, 23);

        kdasistanestesi.setEditable(false);
        kdasistanestesi.setName("kdasistanestesi"); // NOI18N
        kdasistanestesi.setPreferredSize(new java.awt.Dimension(80, 23));
        kdasistanestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdasistanestesiKeyPressed(evt);
            }
        });
        FormInput.add(kdasistanestesi);
        kdasistanestesi.setBounds(480, 100, 70, 23);

        nmasistanestesi.setEditable(false);
        nmasistanestesi.setName("nmasistanestesi"); // NOI18N
        nmasistanestesi.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmasistanestesi);
        nmasistanestesi.setBounds(550, 100, 190, 23);

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
        BtnAsnes.setBounds(740, 100, 28, 23);

        label24.setText("Prw.Resusitasi :");
        label24.setName("label24"); // NOI18N
        label24.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label24);
        label24.setBounds(380, 130, 90, 23);

        kdprwresust.setEditable(false);
        kdprwresust.setName("kdprwresust"); // NOI18N
        kdprwresust.setPreferredSize(new java.awt.Dimension(80, 23));
        kdprwresust.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdprwresustKeyPressed(evt);
            }
        });
        FormInput.add(kdprwresust);
        kdprwresust.setBounds(480, 130, 70, 23);

        nmprwresust.setEditable(false);
        nmprwresust.setName("nmprwresust"); // NOI18N
        nmprwresust.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmprwresust);
        nmprwresust.setBounds(550, 130, 190, 23);

        btnPrwRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPrwRes.setMnemonic('2');
        btnPrwRes.setToolTipText("Alt+2");
        btnPrwRes.setName("btnPrwRes"); // NOI18N
        btnPrwRes.setPreferredSize(new java.awt.Dimension(28, 23));
        btnPrwRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrwResActionPerformed(evt);
            }
        });
        FormInput.add(btnPrwRes);
        btnPrwRes.setBounds(740, 130, 28, 23);

        label25.setText("Onloop 1 :");
        label25.setName("label25"); // NOI18N
        label25.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label25);
        label25.setBounds(380, 160, 90, 23);

        kdonloop1.setEditable(false);
        kdonloop1.setName("kdonloop1"); // NOI18N
        kdonloop1.setPreferredSize(new java.awt.Dimension(80, 23));
        kdonloop1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdonloop1KeyPressed(evt);
            }
        });
        FormInput.add(kdonloop1);
        kdonloop1.setBounds(480, 160, 70, 23);

        nmonloop1.setEditable(false);
        nmonloop1.setName("nmonloop1"); // NOI18N
        nmonloop1.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmonloop1);
        nmonloop1.setBounds(550, 160, 190, 23);

        btnOnloop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnOnloop1.setMnemonic('2');
        btnOnloop1.setToolTipText("Alt+2");
        btnOnloop1.setName("btnOnloop1"); // NOI18N
        btnOnloop1.setPreferredSize(new java.awt.Dimension(28, 23));
        btnOnloop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnloop1ActionPerformed(evt);
            }
        });
        FormInput.add(btnOnloop1);
        btnOnloop1.setBounds(740, 160, 28, 23);

        label31.setText("Onloop 2 :");
        label31.setName("label31"); // NOI18N
        label31.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label31);
        label31.setBounds(380, 190, 90, 23);

        kdonloop2.setEditable(false);
        kdonloop2.setName("kdonloop2"); // NOI18N
        kdonloop2.setPreferredSize(new java.awt.Dimension(80, 23));
        kdonloop2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kdonloop2KeyPressed(evt);
            }
        });
        FormInput.add(kdonloop2);
        kdonloop2.setBounds(480, 190, 70, 23);

        nmonloop2.setEditable(false);
        nmonloop2.setName("nmonloop2"); // NOI18N
        nmonloop2.setPreferredSize(new java.awt.Dimension(207, 23));
        FormInput.add(nmonloop2);
        nmonloop2.setBounds(550, 190, 190, 23);

        btnOnloop2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnOnloop2.setMnemonic('2');
        btnOnloop2.setToolTipText("Alt+2");
        btnOnloop2.setName("btnOnloop2"); // NOI18N
        btnOnloop2.setPreferredSize(new java.awt.Dimension(28, 23));
        btnOnloop2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOnloop2ActionPerformed(evt);
            }
        });
        FormInput.add(btnOnloop2);
        btnOnloop2.setBounds(740, 190, 28, 23);

        label11.setText("Mulai :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label11);
        label11.setBounds(20, 250, 50, 23);

        tgl_mulai.setDisplayFormat("dd-MM-yyyy");
        tgl_mulai.setName("tgl_mulai"); // NOI18N
        tgl_mulai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_mulaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_mulai);
        tgl_mulai.setBounds(80, 250, 90, 23);

        label12.setText("Selesai :");
        label12.setName("label12"); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(70, 23));
        FormInput.add(label12);
        label12.setBounds(400, 250, 50, 23);

        tgl_selesai.setDisplayFormat("dd-MM-yyyy");
        tgl_selesai.setName("tgl_selesai"); // NOI18N
        tgl_selesai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tgl_selesaiKeyPressed(evt);
            }
        });
        FormInput.add(tgl_selesai);
        tgl_selesai.setBounds(460, 250, 90, 23);

        cmbJam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam.setName("cmbJam"); // NOI18N
        cmbJam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJamKeyPressed(evt);
            }
        });
        FormInput.add(cmbJam);
        cmbJam.setBounds(180, 250, 62, 23);

        cmbMnt.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt.setName("cmbMnt"); // NOI18N
        cmbMnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMntKeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt);
        cmbMnt.setBounds(250, 250, 62, 23);

        cmbDtk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk.setName("cmbDtk"); // NOI18N
        cmbDtk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtkKeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk);
        cmbDtk.setBounds(320, 250, 62, 23);

        cmbJam1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        cmbJam1.setName("cmbJam1"); // NOI18N
        cmbJam1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbJam1KeyPressed(evt);
            }
        });
        FormInput.add(cmbJam1);
        cmbJam1.setBounds(560, 250, 62, 23);

        cmbMnt1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbMnt1.setName("cmbMnt1"); // NOI18N
        cmbMnt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbMnt1KeyPressed(evt);
            }
        });
        FormInput.add(cmbMnt1);
        cmbMnt1.setBounds(630, 250, 62, 23);

        cmbDtk1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        cmbDtk1.setName("cmbDtk1"); // NOI18N
        cmbDtk1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbDtk1KeyPressed(evt);
            }
        });
        FormInput.add(cmbDtk1);
        cmbDtk1.setBounds(700, 250, 62, 23);

        jLabel4.setText("Jenis Anasthesi :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 290, 90, 23);

        jenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GA", "RA", "LOKAL", "SEDASI" }));
        jenis.setName("jenis"); // NOI18N
        jenis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jenisKeyPressed(evt);
            }
        });
        FormInput.add(jenis);
        jenis.setBounds(100, 290, 90, 23);

        jLabel5.setText("Sifat Tindakan :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(210, 290, 81, 23);

        Sifat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elektif", "Cito" }));
        Sifat.setName("Sifat"); // NOI18N
        Sifat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SifatActionPerformed(evt);
            }
        });
        Sifat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SifatKeyPressed(evt);
            }
        });
        FormInput.add(Sifat);
        Sifat.setBounds(300, 290, 80, 23);

        jLabel16.setText("Kategori :");
        jLabel16.setName("jLabel16"); // NOI18N
        FormInput.add(jLabel16);
        jLabel16.setBounds(410, 290, 81, 23);

        Kategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Khusus", "Besar", "Sedang", "Kecil" }));
        Kategori.setName("Kategori"); // NOI18N
        Kategori.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KategoriKeyPressed(evt);
            }
        });
        FormInput.add(Kategori);
        Kategori.setBounds(500, 290, 122, 23);

        Penyulit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tanpa penyulit", "Dengan penyulit" }));
        Penyulit.setName("Penyulit"); // NOI18N
        Penyulit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PenyulitActionPerformed(evt);
            }
        });
        Penyulit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PenyulitKeyPressed(evt);
            }
        });
        FormInput.add(Penyulit);
        Penyulit.setBounds(640, 290, 122, 23);

        jLabel9.setText("Pemeriksaan PA :");
        jLabel9.setName("jLabel9"); // NOI18N
        FormInput.add(jLabel9);
        jLabel9.setBounds(0, 330, 100, 23);

        DikirimPA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak", "Ya" }));
        DikirimPA.setName("DikirimPA"); // NOI18N
        DikirimPA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DikirimPAKeyPressed(evt);
            }
        });
        FormInput.add(DikirimPA);
        DikirimPA.setBounds(110, 330, 80, 23);

        jLabel14.setText("Kehilangan Darah :");
        jLabel14.setName("jLabel14"); // NOI18N
        FormInput.add(jLabel14);
        jLabel14.setBounds(200, 330, 100, 23);

        KehilanganDarah.setHighlighter(null);
        KehilanganDarah.setName("KehilanganDarah"); // NOI18N
        KehilanganDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KehilanganDarahKeyPressed(evt);
            }
        });
        FormInput.add(KehilanganDarah);
        KehilanganDarah.setBounds(305, 330, 80, 23);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("cc");
        jLabel13.setName("jLabel13"); // NOI18N
        FormInput.add(jLabel13);
        jLabel13.setBounds(390, 330, 30, 23);

        jLabel11.setText("Nomor Implan :");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(420, 330, 80, 23);

        NomorImplant.setHighlighter(null);
        NomorImplant.setName("NomorImplant"); // NOI18N
        NomorImplant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomorImplantKeyPressed(evt);
            }
        });
        FormInput.add(NomorImplant);
        NomorImplant.setBounds(510, 330, 250, 23);

        jLabel12.setText("Jaringan di-Eksisi / -Insisi :");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(0, 370, 145, 23);

        Jaringan.setHighlighter(null);
        Jaringan.setName("Jaringan"); // NOI18N
        Jaringan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JaringanKeyPressed(evt);
            }
        });
        FormInput.add(Jaringan);
        Jaringan.setBounds(150, 370, 610, 23);

        jLabel8.setText("Komplikasi :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(60, 400, 70, 23);

        Komplikasi.setHighlighter(null);
        Komplikasi.setName("Komplikasi"); // NOI18N
        Komplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KomplikasiActionPerformed(evt);
            }
        });
        Komplikasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KomplikasiKeyPressed(evt);
            }
        });
        FormInput.add(Komplikasi);
        Komplikasi.setBounds(150, 400, 610, 23);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Diagnosis Pre-operatif :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(20, 440, 145, 23);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Diagnosis Post-operatif :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(410, 440, 145, 23);

        scrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane4.setName("scrollPane4"); // NOI18N

        PostOp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PostOp.setColumns(20);
        PostOp.setRows(5);
        PostOp.setName("PostOp"); // NOI18N
        scrollPane4.setViewportView(PostOp);

        FormInput.add(scrollPane4);
        scrollPane4.setBounds(410, 460, 350, 100);

        scrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane3.setName("scrollPane3"); // NOI18N

        PreOp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PreOp.setColumns(20);
        PreOp.setRows(5);
        PreOp.setName("PreOp"); // NOI18N
        scrollPane3.setViewportView(PreOp);

        FormInput.add(scrollPane3);
        scrollPane3.setBounds(20, 460, 380, 100);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Macam Operasi :");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(780, 10, 145, 23);

        scrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane5.setName("scrollPane5"); // NOI18N

        MacamOperasi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MacamOperasi.setColumns(20);
        MacamOperasi.setRows(5);
        MacamOperasi.setName("MacamOperasi"); // NOI18N
        scrollPane5.setViewportView(MacamOperasi);

        FormInput.add(scrollPane5);
        scrollPane5.setBounds(780, 30, 320, 80);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Instruksi Pasca Operasi");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(1110, 10, 145, 23);

        scrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane6.setName("scrollPane6"); // NOI18N

        InstruksiPascaOP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        InstruksiPascaOP.setColumns(20);
        InstruksiPascaOP.setRows(5);
        InstruksiPascaOP.setName("InstruksiPascaOP"); // NOI18N
        scrollPane6.setViewportView(InstruksiPascaOP);

        FormInput.add(scrollPane6);
        scrollPane6.setBounds(1110, 30, 320, 80);

        btnTemplate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnTemplate.setMnemonic('2');
        btnTemplate.setToolTipText("Alt+2");
        btnTemplate.setName("btnTemplate"); // NOI18N
        btnTemplate.setPreferredSize(new java.awt.Dimension(28, 23));
        btnTemplate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemplateActionPerformed(evt);
            }
        });
        FormInput.add(btnTemplate);
        btnTemplate.setBounds(880, 120, 28, 23);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Laporan Operasi :");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(780, 120, 101, 23);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane2.setName("scrollPane2"); // NOI18N

        Laporan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Laporan.setColumns(20);
        Laporan.setRows(30);
        Laporan.setName("Laporan"); // NOI18N
        scrollPane2.setViewportView(Laporan);

        FormInput.add(scrollPane2);
        scrollPane2.setBounds(780, 150, 650, 410);

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
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06-04-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06-04-2026" }));
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

        if (kdoperator1.getText().trim().equals("")) {
            Valid.textKosong(kdoperator1, "Operator 1");
            return;
        }

        setDefaultIfEmpty(kdoperator2, nmoperator2);
        setDefaultIfEmpty(kdasistoperator1, nmasistoperator1);
        setDefaultIfEmpty(kdasistoperator2, nmasistoperator2);
        setDefaultIfEmpty(kdanestesi, nmanestesi);
        setDefaultIfEmpty(kdasistanestesi, nmasistanestesi);
        setDefaultIfEmpty(kddranak, nmdranak);
        setDefaultIfEmpty(kdprwresust, nmprwresust);
        setDefaultIfEmpty(kdbidan1, nmbidan1);
        setDefaultIfEmpty(kdbidan2, nmbidan2);
        setDefaultIfEmpty(kdonloop1, nmonloop1);
        setDefaultIfEmpty(kdonloop2, nmonloop2);
        setDefaultIfEmpty(kddrumum, nmdrumum);
        setDefaultIfEmpty(kdInstrumen, nminstrumen);

        if (Sequel.menyimpantf(
                "laporan_operasi_custom",
                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?",
                "No.Rawat, Tanggal & Jam",
                31,
                new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    kdoperator1.getText(), kdoperator2.getText(),
                    kdasistoperator1.getText(), kdasistoperator2.getText(),
                    kdanestesi.getText(), kdasistanestesi.getText(),
                    kddranak.getText(), kdprwresust.getText(),
                    kdbidan1.getText(), kdbidan2.getText(),
                    kdonloop1.getText(), kdonloop2.getText(),
                    kddrumum.getText(), kdInstrumen.getText(),
                    jenis.getSelectedItem().toString(),
                    Sifat.getSelectedItem().toString(),
                    Kategori.getSelectedItem().toString(),
                    Penyulit.getSelectedItem().toString(),
                    DikirimPA.getSelectedItem().toString(),
                    KehilanganDarah.getText(),
                    NomorImplant.getText(),
                    Jaringan.getText(),
                    Komplikasi.getText(),
                    PreOp.getText(), PostOp.getText(),
                    MacamOperasi.getText(),
                    InstruksiPascaOP.getText(),
                    Laporan.getText()
                }) == true) {
            tabMode.addRow(new Object[]{
                TNoRw.getText(), TNoRM.getText(), TPasien.getText(),
                kdoperator1.getText(), nmoperator1.getText(),
                kdoperator2.getText(), nmoperator2.getText(),
                kdasistoperator1.getText(), nmasistoperator1.getText(),
                kdasistoperator2.getText(), nmasistoperator2.getText(),
                kdanestesi.getText(), nmanestesi.getText(),
                kdasistanestesi.getText(), nmasistanestesi.getText(),
                kddranak.getText(), nmdranak.getText(),
                kdprwresust.getText(), nmprwresust.getText(),
                kdbidan1.getText(), nmbidan1.getText(),
                kdbidan2.getText(), nmbidan2.getText(),
                kdonloop1.getText(), nmonloop1.getText(),
                kdonloop2.getText(), nmonloop2.getText(),
                kddrumum.getText(), nmdrumum.getText(),
                kdInstrumen.getText(), nminstrumen.getText(),
                Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                jenis.getSelectedItem().toString(),
                Sifat.getSelectedItem().toString(),
                Kategori.getSelectedItem().toString(),
                Penyulit.getSelectedItem().toString(),
                DikirimPA.getSelectedItem().toString(),
                KehilanganDarah.getText(),
                NomorImplant.getText(),
                Jaringan.getText(),
                Komplikasi.getText(),
                PreOp.getText(), PostOp.getText(),
                MacamOperasi.getText(),
                InstruksiPascaOP.getText(),
                Laporan.getText()
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
                if (kdoperator1.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 5).toString())) {
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
        
        if (nmoperator1.getText().trim().equals("")) {
            Valid.textKosong(kdoperator1, "Dokter Anastesi");
            return;
        } 
        
        if (tbObat.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Silahkan anda pilih data terlebih dahulu..!!");
            return;
        } 
        
        if (akses.getkode().equals("Admin Utama")) {
            ganti();
        } else {
            if (kdoperator1.getText().equals(tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString())) {
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

    private void MnLaporanOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnLaporanOperasiActionPerformed
        if (tbObat.getSelectedRow() > -1) {
            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());
            param.put("alamatrs", akses.getalamatrs());
            param.put("kotars", akses.getkabupatenrs());
            param.put("propinsirs", akses.getpropinsirs());
            param.put("kontakrs", akses.getkontakrs());
            param.put("emailrs", akses.getemailrs());
            param.put("logo", Sequel.cariGambar("select setting.logo from setting"));
            param.put("norawat",tbObat.getValueAt(tbObat.getSelectedRow(),0).toString());  
            param.put("tanggaloperasi",tbObat.getValueAt(tbObat.getSelectedRow(),31).toString());
            finger = Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?", tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString());
            param.put("finger", "Dikeluarkan di " + akses.getnamars() + ", Kabupaten/Kota " + akses.getkabupatenrs() + "\nDitandatangani secara elektronik oleh " + tbObat.getValueAt(tbObat.getSelectedRow(), 4).toString() + "\nID " + (finger.equals("") ? tbObat.getValueAt(tbObat.getSelectedRow(), 3).toString() : finger) + "\n" + Valid.SetTgl3(tbObat.getValueAt(tbObat.getSelectedRow(), 31).toString()));

            Valid.MyReport("rptLaporanOperasiCustom.jasper", "report", "::[ Laporan Operasi ]::",param);
        }
    }//GEN-LAST:event_MnLaporanOperasiActionPerformed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            Sequel.cariIsi("select concat(pasien.no_rkm_medis,', ',pasien.nm_pasien) from reg_periksa inner join pasien "
                    + " on pasien.no_rkm_medis=reg_periksa.no_rkm_medis where reg_periksa.no_rawat=? ", TPasien, TNoRw.getText());
        } else {
            Valid.pindah(evt, TCari, kdoperator1);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void TNoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRMKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRMKeyPressed

    private void kdoperator1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdoperator1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmoperator1.setText(dokter.tampil3(kdoperator1.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnOperator1ActionPerformed(null);
        } else {
            Valid.pindah(evt, tgl_mulai, kdoperator2);
        }
    }//GEN-LAST:event_kdoperator1KeyPressed

    private void BtnOperator1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOperator1ActionPerformed
        pilihan = 1;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnOperator1ActionPerformed

    private void BtnOperator1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnOperator1KeyPressed
        Valid.pindah(evt, tgl_mulai, BtnOperator2);
    }//GEN-LAST:event_BtnOperator1KeyPressed

    private void kdoperator2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdoperator2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmoperator2.setText(dokter.tampil3(kdoperator2.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnOperator2ActionPerformed(null);
        } else {
            Valid.pindah(evt, kdoperator1, kdanestesi);
        }
    }//GEN-LAST:event_kdoperator2KeyPressed

    private void BtnOperator2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOperator2ActionPerformed
        pilihan = 2;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnOperator2ActionPerformed

    private void BtnOperator2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnOperator2KeyPressed
        Valid.pindah(evt, BtnOperator1, kdanestesi);
    }//GEN-LAST:event_BtnOperator2KeyPressed

    private void kdanestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdanestesiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmanestesi.setText(dokter.tampil3(kdanestesi.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnAnastesiActionPerformed(null);
        } else {
            Valid.pindah(evt, kdoperator2, kddranak);
        }
    }//GEN-LAST:event_kdanestesiKeyPressed

    private void BtnAnastesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnastesiActionPerformed
        pilihan = 4;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnAnastesiActionPerformed

    private void kddranakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kddranakKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmdranak.setText(dokter.tampil3(kddranak.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnAnakActionPerformed(null);
        } else {
            Valid.pindah(evt, kdanestesi, kdbidan1);
        }
    }//GEN-LAST:event_kddranakKeyPressed

    private void btnAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnakActionPerformed
        pilihan = 5;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btnAnakActionPerformed

    private void kdbidan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdbidan1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnBidanActionPerformed(null);
        } else {
            Valid.pindah(evt, kddranak, kdbidan2);
        }
    }//GEN-LAST:event_kdbidan1KeyPressed

    private void btnBidanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBidanActionPerformed
        pilihan = 7;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnBidanActionPerformed

    private void kdbidan2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdbidan2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnBidan2ActionPerformed(null);
        } else {
            Valid.pindah(evt, kdbidan1, kddrumum);
        }
    }//GEN-LAST:event_kdbidan2KeyPressed

    private void btnBidan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBidan2ActionPerformed
        pilihan = 8;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnBidan2ActionPerformed

    private void kdInstrumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdInstrumenKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            Sequel.cariIsi("select nama from petugas where nip='" + kdInstrumen.getText() + "'", nminstrumen);
        } else {
            Valid.pindah(evt, kdonloop2, kdasistoperator1);
        }
    }//GEN-LAST:event_kdInstrumenKeyPressed

    private void btnAsis3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsis3ActionPerformed
        pilihan = 3;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnAsis3ActionPerformed

    private void kddrumumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kddrumumKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            nmdranak.setText(dokter.tampil3(kddranak.getText()));
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btndrumumActionPerformed(null);
        } else {
            Valid.pindah(evt, kdbidan2, BtnSimpan);
        }
    }//GEN-LAST:event_kddrumumKeyPressed

    private void btndrumumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndrumumActionPerformed
        pilihan = 7;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btndrumumActionPerformed

    private void kdasistoperator1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdasistoperator1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnAsis1ActionPerformed(null);
        } else {
            Valid.pindah(evt, kdInstrumen, kdasistoperator2);
        }

    }//GEN-LAST:event_kdasistoperator1KeyPressed

    private void btnAsis1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsis1ActionPerformed
        pilihan = 1;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnAsis1ActionPerformed

    private void kdasistoperator2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdasistoperator2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            btnAsis2ActionPerformed(null);
        } else {
            Valid.pindah(evt, kdasistoperator1, kdprwresust);
        }
    }//GEN-LAST:event_kdasistoperator2KeyPressed

    private void btnAsis2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsis2ActionPerformed
        pilihan = 2;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnAsis2ActionPerformed

    private void kdasistanestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdasistanestesiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            BtnAsnesActionPerformed(null);
        } else {
            Valid.pindah(evt, kdasistoperator2, kdprwresust);
        }
    }//GEN-LAST:event_kdasistanestesiKeyPressed

    private void BtnAsnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAsnesActionPerformed
        pilihan = 4;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_BtnAsnesActionPerformed

    private void kdprwresustKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdprwresustKeyPressed
        Valid.pindah(evt, kdonloop2, kdonloop1);
    }//GEN-LAST:event_kdprwresustKeyPressed

    private void btnPrwResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrwResActionPerformed
        pilihan = 5;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPrwResActionPerformed

    private void kdonloop1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdonloop1KeyPressed
        Valid.pindah(evt, kdprwresust, kdonloop2);
    }//GEN-LAST:event_kdonloop1KeyPressed

    private void btnOnloop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnloop1ActionPerformed
        pilihan = 10;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnOnloop1ActionPerformed

    private void kdonloop2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kdonloop2KeyPressed
        Valid.pindah(evt, kdonloop1, kdInstrumen);
    }//GEN-LAST:event_kdonloop2KeyPressed

    private void btnOnloop2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOnloop2ActionPerformed
        pilihan = 11;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnOnloop2ActionPerformed

    private void tgl_mulaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_mulaiKeyPressed
        Valid.pindah(evt, jenis, BtnOperator1);
    }//GEN-LAST:event_tgl_mulaiKeyPressed

    private void tgl_selesaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_selesaiKeyPressed
        Valid.pindah(evt, btnAsis3, PreOp);
    }//GEN-LAST:event_tgl_selesaiKeyPressed

    private void cmbJamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJamKeyPressed
        Valid.pindah(evt, tgl_mulai, cmbMnt);
    }//GEN-LAST:event_cmbJamKeyPressed

    private void cmbMntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMntKeyPressed
        Valid.pindah(evt, cmbJam, cmbDtk);
    }//GEN-LAST:event_cmbMntKeyPressed

    private void cmbDtkKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtkKeyPressed
        Valid.pindah(evt, cmbMnt, tgl_selesai);
    }//GEN-LAST:event_cmbDtkKeyPressed

    private void cmbJam1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbJam1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbJam1KeyPressed

    private void cmbMnt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbMnt1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMnt1KeyPressed

    private void cmbDtk1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbDtk1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDtk1KeyPressed

    private void jenisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jenisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisKeyPressed

    private void SifatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SifatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SifatActionPerformed

    private void SifatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SifatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SifatKeyPressed

    private void KategoriKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KategoriKeyPressed
        Valid.pindah(evt, Sifat, jenis);
    }//GEN-LAST:event_KategoriKeyPressed

    private void PenyulitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PenyulitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PenyulitActionPerformed

    private void PenyulitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PenyulitKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_PenyulitKeyPressed

    private void DikirimPAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DikirimPAKeyPressed
        Valid.pindah(evt, Jaringan, NomorImplant);
    }//GEN-LAST:event_DikirimPAKeyPressed

    private void KehilanganDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KehilanganDarahKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KehilanganDarahKeyPressed

    private void NomorImplantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorImplantKeyPressed
        Valid.pindah(evt, DikirimPA, Laporan);
    }//GEN-LAST:event_NomorImplantKeyPressed

    private void JaringanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JaringanKeyPressed
        Valid.pindah(evt, PostOp, DikirimPA);
    }//GEN-LAST:event_JaringanKeyPressed

    private void KomplikasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KomplikasiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KomplikasiKeyPressed

    private void KomplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KomplikasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KomplikasiActionPerformed

    private void btnTemplateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemplateActionPerformed
        MasterCariTemplateLaporanOperasi template = new MasterCariTemplateLaporanOperasi(null, false);
        template.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (template.getTable().getSelectedRow() != -1) {
                    PreOp.setText(template.getTable().getValueAt(template.getTable().getSelectedRow(), 2).toString());
                    PostOp.setText(template.getTable().getValueAt(template.getTable().getSelectedRow(), 3).toString());
                    Jaringan.setText(template.getTable().getValueAt(template.getTable().getSelectedRow(), 4).toString());
                    DikirimPA.setSelectedItem(template.getTable().getValueAt(template.getTable().getSelectedRow(), 5).toString());
                    Laporan.setText(template.getTable().getValueAt(template.getTable().getSelectedRow(), 6).toString());
                    Laporan.requestFocus();
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
        template.emptTeks();
        template.isCek();
        template.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        template.setLocationRelativeTo(internalFrame1);
        template.setVisible(true);
    }//GEN-LAST:event_btnTemplateActionPerformed

    private void TNoRwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNoRwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNoRwActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMLaporanOperasiCustom dialog = new RMLaporanOperasiCustom(new javax.swing.JFrame(), true);
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
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnOperator1;
    private widget.Button BtnOperator2;
    private widget.Button BtnSimpan;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.ComboBox DikirimPA;
    private widget.PanelBiasa FormInput;
    private widget.TextArea InstruksiPascaOP;
    private widget.TextBox Jaringan;
    private widget.ComboBox Kategori;
    private widget.TextBox KehilanganDarah;
    private widget.TextBox Komplikasi;
    private widget.Label LCount;
    private widget.TextArea Laporan;
    private widget.TextArea MacamOperasi;
    private javax.swing.JMenuItem MnLaporanOperasi;
    private widget.TextBox NomorImplant;
    private widget.ComboBox Penyulit;
    private widget.TextArea PostOp;
    private widget.TextArea PreOp;
    private widget.ScrollPane Scroll;
    private widget.ComboBox Sifat;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.Button btnAnak;
    private widget.Button btnAsis1;
    private widget.Button btnAsis2;
    private widget.Button btnAsis3;
    private widget.Button btnBidan;
    private widget.Button btnBidan2;
    private widget.Button btnOnloop1;
    private widget.Button btnOnloop2;
    private widget.Button btnPrwRes;
    private widget.Button btnTemplate;
    private widget.Button btndrumum;
    private widget.ComboBox cmbDtk;
    private widget.ComboBox cmbDtk1;
    private widget.ComboBox cmbJam;
    private widget.ComboBox cmbJam1;
    private widget.ComboBox cmbMnt;
    private widget.ComboBox cmbMnt1;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel12;
    private widget.Label jLabel13;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel3;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private widget.Label jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.ComboBox jenis;
    private widget.TextBox kdInstrumen;
    private widget.TextBox kdanestesi;
    private widget.TextBox kdasistanestesi;
    private widget.TextBox kdasistoperator1;
    private widget.TextBox kdasistoperator2;
    private widget.TextBox kdbidan1;
    private widget.TextBox kdbidan2;
    private widget.TextBox kddranak;
    private widget.TextBox kddrumum;
    private widget.TextBox kdonloop1;
    private widget.TextBox kdonloop2;
    private widget.TextBox kdoperator1;
    private widget.TextBox kdoperator2;
    private widget.TextBox kdprwresust;
    private widget.Label label11;
    private widget.Label label12;
    private widget.Label label14;
    private widget.Label label17;
    private widget.Label label18;
    private widget.Label label19;
    private widget.Label label21;
    private widget.Label label22;
    private widget.Label label23;
    private widget.Label label24;
    private widget.Label label25;
    private widget.Label label26;
    private widget.Label label27;
    private widget.Label label29;
    private widget.Label label31;
    private widget.Label label34;
    private widget.TextBox nmanestesi;
    private widget.TextBox nmasistanestesi;
    private widget.TextBox nmasistoperator1;
    private widget.TextBox nmasistoperator2;
    private widget.TextBox nmbidan1;
    private widget.TextBox nmbidan2;
    private widget.TextBox nmdranak;
    private widget.TextBox nmdrumum;
    private widget.TextBox nminstrumen;
    private widget.TextBox nmonloop1;
    private widget.TextBox nmonloop2;
    private widget.TextBox nmoperator1;
    private widget.TextBox nmoperator2;
    private widget.TextBox nmprwresust;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.ScrollPane scrollInput;
    private widget.ScrollPane scrollPane2;
    private widget.ScrollPane scrollPane3;
    private widget.ScrollPane scrollPane4;
    private widget.ScrollPane scrollPane5;
    private widget.ScrollPane scrollPane6;
    private widget.Table tbObat;
    private widget.Tanggal tgl_mulai;
    private widget.Tanggal tgl_selesai;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            // SQL Query yang sudah disesuaikan dengan nama kolom database Anda
            String sql = "select laporan_operasi_custom.*, pasien.no_rkm_medis, pasien.nm_pasien from laporan_operasi_custom "
                    + "join reg_periksa on laporan_operasi_custom.no_rawat = reg_periksa.no_rawat "
                    + "join pasien on reg_periksa.no_rkm_medis = pasien.no_rkm_medis "
                    + "join dokter on laporan_operasi_custom.operator1 = dokter.kd_dokter "
                    + "where laporan_operasi_custom.tgl_mulai between ? and ? "
                    + "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? or "
                    + "laporan_operasi_custom.diagnosa_preop like ? or laporan_operasi_custom.diagnosa_postop like ? or "
                    + "laporan_operasi_custom.macam_operasi like ? or dokter.nm_dokter like ?)";
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

                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),
                        rs.getString("operator1"),
                        dokter.tampil3(rs.getString("operator1")),
                        rs.getString("operator2"),
                        dokter.tampil3(rs.getString("operator2")),
                        rs.getString("dokter_anestesi"),
                        dokter.tampil3(rs.getString("dokter_anestesi")),
                        rs.getString("dokter_anak"),
                        dokter.tampil3(rs.getString("dokter_anak")),
                        rs.getString("bidan1"),
                        petugas.tampil3(rs.getString("bidan1")),
                        rs.getString("bidan2"),
                        petugas.tampil3(rs.getString("bidan2")),
                        rs.getString("dokter_umum"),
                        dokter.tampil3(rs.getString("dokter_umum")),
                        rs.getString("asisten_operator1"),
                        petugas.tampil3(rs.getString("asisten_operator1")),
                        rs.getString("asisten_operator2"),
                        petugas.tampil3(rs.getString("asisten_operator2")),
                        rs.getString("asisten_anestesi"),
                        petugas.tampil3(rs.getString("asisten_anestesi")),
                        rs.getString("perawat_resusitasi"),
                        petugas.tampil3(rs.getString("perawat_resusitasi")),
                        rs.getString("onloop1"),
                        petugas.tampil3(rs.getString("onloop1")),
                        rs.getString("onloop2"),
                        petugas.tampil3(rs.getString("onloop2")),
                        rs.getString("instrumen"),
                        petugas.tampil3(rs.getString("instrumen")),
                        rs.getString("tgl_mulai"),
                        rs.getString("tgl_selesai"),
                        rs.getString("jenis_anestesi"),
                        rs.getString("sifat"),
                        rs.getString("kategori"),
                        rs.getString("penyulit"),
                        rs.getString("pemeriksaan_pa"),
                        rs.getString("kehilangan_darah"),
                        rs.getString("nomor_implan"),
                        rs.getString("jaringan_dieksekusi"),
                        rs.getString("komplikasi"),
                        rs.getString("diagnosa_preop"),
                        rs.getString("diagnosa_postop"),
                        rs.getString("macam_operasi"),
                        rs.getString("instruksi_pasca_operasi"),
                        rs.getString("laporan_operasi"),
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
        kdoperator2.setText("");
        nmoperator2.setText("");
        kdasistoperator1.setText("");
        nmasistoperator1.setText("");
        kdasistoperator2.setText("");
        nmasistoperator2.setText("");
        kdanestesi.setText("");
        nmanestesi.setText("");
        kdasistanestesi.setText("");
        nmasistanestesi.setText("");
        kddranak.setText("");
        nmdranak.setText("");
        kdprwresust.setText("");
        nmprwresust.setText("");
        kdbidan1.setText("");
        nmbidan1.setText("");
        kdbidan2.setText("");
        nmbidan2.setText("");
        kdonloop1.setText("");
        nmonloop1.setText("");
        kdonloop2.setText("");
        nmonloop2.setText("");
        kddrumum.setText("");
        nmdrumum.setText("");
        kdInstrumen.setText("");
        nminstrumen.setText("");
        tgl_mulai.setDate(new Date());
        tgl_selesai.setDate(new Date());
        cmbJam.setSelectedIndex(0);
        cmbMnt.setSelectedIndex(0);
        cmbDtk.setSelectedIndex(0);
        cmbJam1.setSelectedIndex(0);
        cmbMnt1.setSelectedIndex(0);
        cmbDtk1.setSelectedIndex(0);
        jenis.setSelectedIndex(0);
        Sifat.setSelectedIndex(0);
        Kategori.setSelectedIndex(0);
        Penyulit.setSelectedIndex(0);
        DikirimPA.setSelectedIndex(0);
        KehilanganDarah.setText("");
        NomorImplant.setText("");
        Jaringan.setText("");
        Komplikasi.setText("");
        PreOp.setText("");
        PostOp.setText("");
        MacamOperasi.setText("");
        InstruksiPascaOP.setText("");
        Laporan.setText("");
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
            kdoperator1.setText(tbObat.getValueAt(row, 3).toString());
            nmoperator1.setText(tbObat.getValueAt(row, 4).toString());
            kdoperator2.setText(tbObat.getValueAt(row, 5).toString());
            nmoperator2.setText(tbObat.getValueAt(row, 6).toString());
            kdasistoperator1.setText(tbObat.getValueAt(row, 17).toString());
            nmasistoperator1.setText(tbObat.getValueAt(row, 18).toString());
            kdasistoperator2.setText(tbObat.getValueAt(row, 19).toString());
            nmasistoperator2.setText(tbObat.getValueAt(row, 20).toString());
            kdanestesi.setText(tbObat.getValueAt(row, 7).toString());
            nmanestesi.setText(tbObat.getValueAt(row, 8).toString());
            kdasistanestesi.setText(tbObat.getValueAt(row, 21).toString());
            nmasistanestesi.setText(tbObat.getValueAt(row, 22).toString());
            kddranak.setText(tbObat.getValueAt(row, 9).toString());
            nmdranak.setText(tbObat.getValueAt(row, 10).toString());
            kdprwresust.setText(tbObat.getValueAt(row, 23).toString());
            nmprwresust.setText(tbObat.getValueAt(row, 24).toString());
            kdbidan1.setText(tbObat.getValueAt(row, 11).toString());
            nmbidan1.setText(tbObat.getValueAt(row, 12).toString());
            kdbidan2.setText(tbObat.getValueAt(row, 13).toString());
            nmbidan2.setText(tbObat.getValueAt(row, 14).toString());
            kdonloop1.setText(tbObat.getValueAt(row, 25).toString());
            nmonloop1.setText(tbObat.getValueAt(row, 26).toString());
            kdonloop2.setText(tbObat.getValueAt(row, 27).toString());
            nmonloop2.setText(tbObat.getValueAt(row, 28).toString());
            kddrumum.setText(tbObat.getValueAt(row, 15).toString());
            nmdrumum.setText(tbObat.getValueAt(row, 16).toString());
            kdInstrumen.setText(tbObat.getValueAt(row, 29).toString());
            nminstrumen.setText(tbObat.getValueAt(row, 30).toString());
            String tglMulai[] = tbObat.getValueAt(row, 31).toString().split(" ");
            String jamMulai[] = tglMulai[1].split(":");
            String tglSelesai[] = tbObat.getValueAt(row, 32).toString().split(" ");
            String jamSelesai[] = tglSelesai[1].split(":");
            Valid.SetTgl(tgl_mulai, tglMulai[0]);
            Valid.SetTgl(tgl_selesai, tglSelesai[0]);
            cmbJam.setSelectedItem(jamMulai[0]);
            cmbMnt.setSelectedItem(jamMulai[1]);
            cmbDtk.setSelectedItem(jamMulai[2]);
            cmbJam1.setSelectedItem(jamSelesai[0]);
            cmbMnt1.setSelectedItem(jamSelesai[1]);
            cmbDtk1.setSelectedItem(jamSelesai[2]);
            jenis.setSelectedItem(tbObat.getValueAt(row, 33).toString());
            Sifat.setSelectedItem(tbObat.getValueAt(row, 34).toString());
            Kategori.setSelectedItem(tbObat.getValueAt(row, 35).toString());
            Penyulit.setSelectedItem(tbObat.getValueAt(row, 36).toString());
            DikirimPA.setSelectedItem(tbObat.getValueAt(row, 37).toString());
            KehilanganDarah.setText(tbObat.getValueAt(row, 38).toString());
            NomorImplant.setText(tbObat.getValueAt(row, 39).toString());
            Jaringan.setText(tbObat.getValueAt(row, 40).toString());
            Komplikasi.setText(tbObat.getValueAt(row, 41).toString());
            PreOp.setText(tbObat.getValueAt(row, 42).toString());
            PostOp.setText(tbObat.getValueAt(row, 43).toString());
            MacamOperasi.setText(tbObat.getValueAt(row, 44).toString());
            InstruksiPascaOP.setText(tbObat.getValueAt(row, 45).toString());
            Laporan.setText(tbObat.getValueAt(row, 46).toString());
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
        
        PreOp.setText(Sequel.cariIsi("select diagnosa_pre_operasi from penilaian_pre_operasi where no_rawat = ?", norwt));
    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.getpenilaian_pre_induksi());
        BtnHapus.setEnabled(akses.getpenilaian_pre_induksi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_induksi());
        BtnEdit.setEnabled(akses.getpenilaian_pre_induksi());
        if (akses.getjml2() >= 1) {
            kdoperator1.setEditable(false);
            BtnOperator1.setEnabled(false);
            kdoperator1.setText(akses.getkode());
            nmoperator1.setText(dokter.tampil3(kdoperator1.getText()));
            if (nmoperator1.getText().equals("")) {
                kdoperator1.setText("");
                JOptionPane.showMessageDialog(null, "User login bukan Dokter...!!");
            }
        }
    }

    public void setTampil() {
        TabRawat.setSelectedIndex(1);
    }

    private void hapus() {
        if (Sequel.queryu2tf("delete from laporan_operasi_custom where no_rawat=? and tgl_mulai=?", 2, new String[]{
            tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(), tbObat.getValueAt(tbObat.getSelectedRow(), 32).toString()
        }) == true) {
            tabMode.removeRow(tbObat.getSelectedRow());
            LCount.setText("" + tabMode.getRowCount());
            TabRawat.setSelectedIndex(1);
        } else {
            JOptionPane.showMessageDialog(null, "Gagal menghapus..!!");
        }
    }

    private void ganti() {

        setDefaultIfEmpty(kdoperator2, nmoperator2);
        setDefaultIfEmpty(kdasistoperator1, nmasistoperator1);
        setDefaultIfEmpty(kdasistoperator2, nmasistoperator2);
        setDefaultIfEmpty(kdanestesi, nmanestesi);
        setDefaultIfEmpty(kdasistanestesi, nmasistanestesi);
        setDefaultIfEmpty(kddranak, nmdranak);
        setDefaultIfEmpty(kdprwresust, nmprwresust);
        setDefaultIfEmpty(kdbidan1, nmbidan1);
        setDefaultIfEmpty(kdbidan2, nmbidan2);
        setDefaultIfEmpty(kdonloop1, nmonloop1);
        setDefaultIfEmpty(kdonloop2, nmonloop2);
        setDefaultIfEmpty(kddrumum, nmdrumum);
        setDefaultIfEmpty(kdInstrumen, nminstrumen);

        if (Sequel.mengedittf("laporan_operasi_custom", "no_rawat=? and tgl_mulai=?",
                "no_rawat=?,tgl_mulai=?,tgl_selesai=?,operator1=?,operator2=?,asisten_operator1=?,asisten_operator2=?,"
                + "dokter_anestesi=?,asisten_anestesi=?,dokter_anak=?,perawat_resusitasi=?,"
                + "bidan1=?,bidan2=?,onloop1=?,onloop2=?,dokter_umum=?,instrumen=?,jenis_anestesi=?,"
                + "sifat=?,kategori=?,penyulit=?,pemeriksaan_pa=?,kehilangan_darah=?,"
                + "nomor_implan=?,jaringan_dieksekusi=?,komplikasi=?,diagnosa_preop=?,diagnosa_postop=?,macam_operasi=?,instruksi_pasca_operasi=?,laporan_operasi=?",
                33, new String[]{
                    TNoRw.getText(),
                    Valid.SetTglJam(tgl_mulai.getSelectedItem() + " " + cmbJam.getSelectedItem() + ":" + cmbMnt.getSelectedItem() + ":" + cmbDtk.getSelectedItem()),
                    Valid.SetTglJam(tgl_selesai.getSelectedItem() + " " + cmbJam1.getSelectedItem() + ":" + cmbMnt1.getSelectedItem() + ":" + cmbDtk1.getSelectedItem()),
                    kdoperator1.getText(), kdoperator2.getText(),
                    kdasistoperator1.getText(), kdasistoperator2.getText(),
                    kdanestesi.getText(), kdasistanestesi.getText(),
                    kddranak.getText(), kdprwresust.getText(),
                    kdbidan1.getText(), kdbidan2.getText(),
                    kdonloop1.getText(), kdonloop2.getText(),
                    kddrumum.getText(), kdInstrumen.getText(),
                    jenis.getSelectedItem().toString(),
                    Sifat.getSelectedItem().toString(),
                    Kategori.getSelectedItem().toString(),
                    Penyulit.getSelectedItem().toString(),
                    DikirimPA.getSelectedItem().toString(),
                    KehilanganDarah.getText(),
                    NomorImplant.getText(),
                    Jaringan.getText(),
                    Komplikasi.getText(),
                    PreOp.getText(), PostOp.getText(),
                    MacamOperasi.getText(),
                    InstruksiPascaOP.getText(),
                    Laporan.getText(),
                    tbObat.getValueAt(tbObat.getSelectedRow(), 0).toString(),
                    tbObat.getValueAt(tbObat.getSelectedRow(), 31).toString()
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
