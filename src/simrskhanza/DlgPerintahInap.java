/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */

package simrskhanza;

import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;
import laporan.DlgCariPenyakit;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import permintaan.DlgPermintaanKonsultasiMedik;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRParameter;


/**
 *
 * @author perpustakaan
 */
public final class DlgPerintahInap extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement pstampil;
    private ResultSet rs;
    private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
    private int i=0;
    private String finger="",finger2="";
    private DlgCariPenyakit penyakit=new DlgCariPenyakit(null,false);
    private DlgCariDokter dokter=new DlgCariDokter(null,false);
    public  DlgCariPetugas perawat=new DlgCariPetugas(null,false); 
    /** Creates new form DlgRujuk
     * @param parent
     * @param modal */
    public DlgPerintahInap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(628,674);

        Object[] row={"P","No.Surat","No.Rawat","No.R.M.",
                  "Nama Pasien","Alamat","Umur","Tgl.Surat","Dokter Perujuk","Kode dokter","Dokter Inap",
                  "kode perawat","Perawat","Diagnosa","Tindakan"};
        tabMode=new DefaultTableModel(null,row){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                 java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                 java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                 java.lang.String.class, java.lang.String.class, java.lang.String.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbObat.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbObat.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 15; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setPreferredWidth(75);
            }else if(i==2){
                column.setPreferredWidth(100);
            }else if(i==3){
                column.setPreferredWidth(40);
            }else if(i==4){
                column.setPreferredWidth(150);
            }else if(i==5){
                column.setPreferredWidth(180);
            }else if(i==6){
                column.setPreferredWidth(40);
            }else if(i==7){
                column.setPreferredWidth(75);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==12){
                column.setPreferredWidth(100);
            }else if(i==13){
                column.setPreferredWidth(180);
            }else if(i==14){
                column.setPreferredWidth(180);
            }else{
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
        

        Diagnosa.setDocument(new batasInput((byte)100).getKata(Diagnosa));
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        NoSurat.setDocument(new batasInput((byte)20).getKata(NoSurat));
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));          
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }  
        
        penyakit.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if( penyakit.getTable().getSelectedRow()!= -1){
                    Diagnosa.setText(penyakit.getTable().getValueAt(penyakit.getTable().getSelectedRow(),1).toString());
                }  
                Diagnosa.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        dokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(dokter.getTable().getSelectedRow()!= -1){   
                    KdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(),0).toString());
                    NmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(),1).toString());
                    KdDokter.requestFocus();
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        perawat.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(perawat.getTable().getSelectedRow()!= -1){   
                    KdPerawat.setText(perawat.getTable().getValueAt(perawat.getTable().getSelectedRow(),0).toString());
                    NmPerawat.setText(perawat.getTable().getValueAt(perawat.getTable().getSelectedRow(),1).toString());
                    KdPerawat.requestFocus();
                }
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        ChkInput.setSelected(false);
        isForm();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DTPReg = new widget.Tanggal();
        kd2 = new javax.swing.JTextField();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnCetakSPRIPS = new javax.swing.JMenuItem();
        MnCetakSPRIGD = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbObat = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKonsul = new widget.Button();
        BtnKeluar = new widget.Button();
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
        PanelInput = new javax.swing.JPanel();
        ChkInput = new widget.CekBox();
        FormInput = new widget.PanelBiasa();
        KdPerawat = new widget.TextBox();
        jLabel4 = new widget.Label();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel12 = new widget.Label();
        TNoRM = new widget.TextBox();
        btnCariPerawat = new widget.Button();
        jLabel5 = new widget.Label();
        NoSurat = new widget.TextBox();
        jLabel14 = new widget.Label();
        Dokter = new widget.TextBox();
        btnCariPenyakit = new widget.Button();
        Diagnosa = new widget.TextBox();
        jLabel9 = new widget.Label();
        jLabel10 = new widget.Label();
        DTPTgl = new widget.Tanggal();
        NmPerawat = new widget.TextBox();
        jLabel13 = new widget.Label();
        KdDokter = new widget.TextBox();
        NmDokter = new widget.TextBox();
        btnCariDokter = new widget.Button();
        jLabel15 = new widget.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tindakan = new javax.swing.JTextArea();

        DTPReg.setEditable(false);
        DTPReg.setForeground(new java.awt.Color(50, 70, 50));
        DTPReg.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2025" }));
        DTPReg.setDisplayFormat("dd-MM-yyyy");
        DTPReg.setName("DTPReg"); // NOI18N
        DTPReg.setOpaque(false);

        kd2.setText("kd2");
        kd2.setName("kd2"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnCetakSPRIPS.setBackground(new java.awt.Color(255, 255, 254));
        MnCetakSPRIPS.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnCetakSPRIPS.setForeground(java.awt.Color.darkGray);
        MnCetakSPRIPS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnCetakSPRIPS.setActionCommand("Cetak SPRI Poli Spesialis");
        MnCetakSPRIPS.setLabel("Cetak SPRI Poli Spesialis");
        MnCetakSPRIPS.setName("MnCetakSPRIPS"); // NOI18N
        MnCetakSPRIPS.setPreferredSize(new java.awt.Dimension(250, 28));
        MnCetakSPRIPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnCetakSPRIPSActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnCetakSPRIPS);

        MnCetakSPRIGD.setBackground(new java.awt.Color(255, 255, 254));
        MnCetakSPRIGD.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnCetakSPRIGD.setForeground(java.awt.Color.darkGray);
        MnCetakSPRIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnCetakSPRIGD.setActionCommand("Cetak SPRI Gawat Darurat");
        MnCetakSPRIGD.setLabel("Cetak SPRI Gawat Darurat");
        MnCetakSPRIGD.setName("MnCetakSPRIGD"); // NOI18N
        MnCetakSPRIGD.setPreferredSize(new java.awt.Dimension(250, 28));
        MnCetakSPRIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnCetakSPRIGDActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnCetakSPRIGD);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Data Rujukan Masuk ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbObat.setAutoCreateRowSorter(true);
        tbObat.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbObat.setComponentPopupMenu(jPopupMenu1);
        tbObat.setName("tbObat"); // NOI18N
        tbObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbObatMouseClicked(evt);
            }
        });
        tbObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbObatKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbObat);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
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
        BtnPrint.setEnabled(false);
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

        BtnKonsul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Create-Ticket24.png"))); // NOI18N
        BtnKonsul.setMnemonic('M');
        BtnKonsul.setText("Konsul");
        BtnKonsul.setToolTipText("Alt+M");
        BtnKonsul.setName("BtnKonsul"); // NOI18N
        BtnKonsul.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKonsul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKonsulActionPerformed(evt);
            }
        });
        BtnKonsul.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKonsulKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKonsul);

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

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tgl.Surat :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(67, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2025" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2025" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(200, 23));
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
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass9.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(LCount);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 186));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(100, 210));
        FormInput.setLayout(null);

        KdPerawat.setEditable(false);
        KdPerawat.setHighlighter(null);
        KdPerawat.setName("KdPerawat"); // NOI18N
        KdPerawat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdPerawatKeyPressed(evt);
            }
        });
        FormInput.add(KdPerawat);
        KdPerawat.setBounds(83, 70, 64, 23);

        jLabel4.setText("No.Rawat :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 10, 80, 23);

        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(83, 10, 152, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(359, 10, 368, 23);

        jLabel12.setText("Perawat :");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(0, 70, 80, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRMKeyPressed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(237, 10, 120, 23);

        btnCariPerawat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnCariPerawat.setMnemonic('2');
        btnCariPerawat.setToolTipText("Alt+2");
        btnCariPerawat.setName("btnCariPerawat"); // NOI18N
        btnCariPerawat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPerawatActionPerformed(evt);
            }
        });
        btnCariPerawat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCariPerawatKeyPressed(evt);
            }
        });
        FormInput.add(btnCariPerawat);
        btnCariPerawat.setBounds(350, 70, 28, 23);

        jLabel5.setText("No.Surat :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(0, 40, 80, 23);

        NoSurat.setHighlighter(null);
        NoSurat.setName("NoSurat"); // NOI18N
        NoSurat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoSuratKeyPressed(evt);
            }
        });
        FormInput.add(NoSurat);
        NoSurat.setBounds(83, 40, 152, 23);

        jLabel14.setText("Tindakan sudah diberikan :");
        jLabel14.setName("jLabel14"); // NOI18N
        FormInput.add(jLabel14);
        jLabel14.setBounds(340, 130, 140, 23);

        Dokter.setHighlighter(null);
        Dokter.setName("Dokter"); // NOI18N
        Dokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DokterKeyPressed(evt);
            }
        });
        FormInput.add(Dokter);
        Dokter.setBounds(540, 70, 190, 23);

        btnCariPenyakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnCariPenyakit.setMnemonic('2');
        btnCariPenyakit.setToolTipText("Alt+2");
        btnCariPenyakit.setName("btnCariPenyakit"); // NOI18N
        btnCariPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPenyakitActionPerformed(evt);
            }
        });
        FormInput.add(btnCariPenyakit);
        btnCariPenyakit.setBounds(700, 40, 28, 23);

        Diagnosa.setHighlighter(null);
        Diagnosa.setName("Diagnosa"); // NOI18N
        Diagnosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DiagnosaKeyPressed(evt);
            }
        });
        FormInput.add(Diagnosa);
        Diagnosa.setBounds(360, 40, 340, 23);

        jLabel9.setText("Diagnosa :");
        jLabel9.setName("jLabel9"); // NOI18N
        FormInput.add(jLabel9);
        jLabel9.setBounds(270, 40, 80, 23);

        jLabel10.setText("Tanggal :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(10, 130, 70, 23);

        DTPTgl.setForeground(new java.awt.Color(50, 70, 50));
        DTPTgl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "09-05-2025" }));
        DTPTgl.setDisplayFormat("dd-MM-yyyy");
        DTPTgl.setName("DTPTgl"); // NOI18N
        DTPTgl.setOpaque(false);
        DTPTgl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DTPTglItemStateChanged(evt);
            }
        });
        DTPTgl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DTPTglKeyPressed(evt);
            }
        });
        FormInput.add(DTPTgl);
        DTPTgl.setBounds(90, 130, 90, 23);

        NmPerawat.setEditable(false);
        NmPerawat.setHighlighter(null);
        NmPerawat.setName("NmPerawat"); // NOI18N
        NmPerawat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmPerawatKeyPressed(evt);
            }
        });
        FormInput.add(NmPerawat);
        NmPerawat.setBounds(150, 70, 190, 23);

        jLabel13.setText("Dokter Inap :");
        jLabel13.setName("jLabel13"); // NOI18N
        FormInput.add(jLabel13);
        jLabel13.setBounds(0, 100, 80, 23);

        KdDokter.setEditable(false);
        KdDokter.setHighlighter(null);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDokterKeyPressed(evt);
            }
        });
        FormInput.add(KdDokter);
        KdDokter.setBounds(83, 100, 64, 23);

        NmDokter.setEditable(false);
        NmDokter.setHighlighter(null);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmDokterKeyPressed(evt);
            }
        });
        FormInput.add(NmDokter);
        NmDokter.setBounds(150, 100, 190, 23);

        btnCariDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnCariDokter.setMnemonic('2');
        btnCariDokter.setToolTipText("Alt+2");
        btnCariDokter.setName("btnCariDokter"); // NOI18N
        btnCariDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariDokterActionPerformed(evt);
            }
        });
        btnCariDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCariDokterKeyPressed(evt);
            }
        });
        FormInput.add(btnCariDokter);
        btnCariDokter.setBounds(350, 100, 28, 23);

        jLabel15.setText("Dokter Perujuk :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(430, 70, 100, 23);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        Tindakan.setColumns(20);
        Tindakan.setRows(5);
        Tindakan.setName("Tindakan"); // NOI18N
        jScrollPane1.setViewportView(Tindakan);

        FormInput.add(jScrollPane1);
        jScrollPane1.setBounds(490, 100, 280, 120);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(NoSurat.getText().trim().equals("")){
            Valid.textKosong(NoSurat,"No Surat");
        }else if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
        }else if(KdDokter.getText().trim().equals("")){
            Valid.textKosong(Dokter,"Dokter");
        }else if(KdPerawat.getText().trim().equals("")){
            Valid.textKosong(Dokter,"Perawat");
        }else if(Diagnosa.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Diagnosa Masuk");
        }else if(Tindakan.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Tindakan");
        }else{
            if(Sequel.menyimpantf("perintah_inap","'"+TNoRw.getText()+"','"+NoSurat.getText()+"','"+Diagnosa.getText()+"',"+
                             "'"+KdPerawat.getText()+"','"+KdDokter.getText()+"','"+Valid.SetTgl(DTPTgl.getSelectedItem()+"")+"','"+Tindakan.getText()+"'","No.Surat")==true){
                tampil();
                emptTeks();
            }
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
            Valid.pindah(evt,DTPTgl,BtnBatal);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        for(int i=0;i<tbObat.getRowCount();i++){ 
            if(tbObat.getValueAt(i,0).toString().equals("true")){
                if(Sequel.meghapustf("perintah_inap","no_rawat",tbObat.getValueAt(i,2).toString())==true){
                    tabMode.removeRow(i);
                    i--;
                }
            }
        }
        emptTeks();
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if(NoSurat.getText().trim().equals("")){
            Valid.textKosong(NoSurat,"No Surat");
        }else if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
        }else if(KdDokter.getText().trim().equals("")){
            Valid.textKosong(Dokter,"Dokter");
        }else if(KdPerawat.getText().trim().equals("")){
            Valid.textKosong(Dokter,"Dokter");
        }else if(Diagnosa.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Diagnosa Masuk");
        }else if(Tindakan.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Tindakan");
        }else{    
            Sequel.mengedit("perintah_inap","no_rawat='"+tbObat.getValueAt(tbObat.getSelectedRow(),2).toString()+"'",
                    "no_surat='"+NoSurat.getText()+"',diagnosa='"+Diagnosa.getText()+"',kd_perawat='"+KdPerawat.getText()+"',"+
                    "kd_dokter='"+KdDokter.getText()+"',tanggal='"+Valid.SetTgl(DTPTgl.getSelectedItem()+"")+"',tindakan='"+Tindakan.getText()+"'");
            if(tabMode.getRowCount()!=0){tampil();}
            emptTeks();
        }
}//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnPrint);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnEdit,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BtnCariActionPerformed(evt);
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.queryu("delete from temporary where temp37='"+akses.getalamatip()+"'");
            for(int i=0;i<tabMode.getRowCount();i++){  
                Sequel.menyimpan("temporary","'"+i+"','"+
                                tabMode.getValueAt(i,1).toString()+"','"+
                                tabMode.getValueAt(i,2).toString()+"','"+
                                tabMode.getValueAt(i,3).toString()+"','"+
                                tabMode.getValueAt(i,6).toString()+"','"+
                                tabMode.getValueAt(i,7).toString()+"','"+
                                tabMode.getValueAt(i,8).toString()+"','"+
                                tabMode.getValueAt(i,9).toString()+"','"+
                                tabMode.getValueAt(i,10).toString()+"','"+
                                tabMode.getValueAt(i,11).toString()+"','"+
                                tabMode.getValueAt(i,12).toString()+"','"+
                                tabMode.getValueAt(i,13).toString()+"','"+
                                tabMode.getValueAt(i,14).toString()+"','','','','','','','','','','','','','','','','','','','','','','','','','"+akses.getalamatip()+"'","Perintah Inap"); 
            }
            Map<String, Object> param = new HashMap<>(); 
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());   
                param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
            Valid.MyReportqry("rptRujukMasuk.jasper","report","::[ Data Rujukan Yang Masuk ]::",
               "select * from temporary where temporary.temp37='"+akses.getalamatip()+"' order by temporary.no",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnCari, TPasien);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbObatMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbObatMouseClicked

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
        isForm();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void tbObatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbObatKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbObatKeyReleased

    private void DiagnosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiagnosaKeyPressed
        //Valid.pindah(evt,TKd,TSpek);
    }//GEN-LAST:event_DiagnosaKeyPressed

    private void btnCariPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPenyakitActionPerformed
        penyakit.isCek();
        penyakit.emptTeks();
        penyakit.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        penyakit.setLocationRelativeTo(internalFrame1);
        penyakit.setVisible(true);
    }//GEN-LAST:event_btnCariPenyakitActionPerformed

    private void DokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DokterKeyPressed
        Valid.pindah(evt,KdPerawat,DTPTgl);
    }//GEN-LAST:event_DokterKeyPressed

    private void NoSuratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoSuratKeyPressed
        Valid.pindah(evt,TNoRw,Diagnosa);
    }//GEN-LAST:event_NoSuratKeyPressed

    private void btnCariPerawatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCariPerawatKeyPressed

    }//GEN-LAST:event_btnCariPerawatKeyPressed

    private void btnCariPerawatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPerawatActionPerformed
        perawat.isCek();
        perawat.emptTeks();
        perawat.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        perawat.setLocationRelativeTo(internalFrame1);
        perawat.setVisible(true);
    }//GEN-LAST:event_btnCariPerawatActionPerformed

    private void TNoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRMKeyPressed
        // Valid.pindah(evt, TNm, BtnSimpan);
    }//GEN-LAST:event_TNoRMKeyPressed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            isRawat();
        }else{
            Valid.pindah(evt,TCari,NoSurat);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void KdPerawatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdPerawatKeyPressed
        Valid.pindah(evt,Diagnosa,KdDokter);
    }//GEN-LAST:event_KdPerawatKeyPressed

    private void DTPTglKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DTPTglKeyPressed
        Valid.pindah(evt,TCari,Diagnosa);
    }//GEN-LAST:event_DTPTglKeyPressed

    private void NmPerawatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmPerawatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NmPerawatKeyPressed

    private void KdDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdDokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KdDokterKeyPressed

    private void NmDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmDokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NmDokterKeyPressed

    private void btnCariDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariDokterActionPerformed
        dokter.isCek();
        dokter.emptTeks();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btnCariDokterActionPerformed

    private void btnCariDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCariDokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCariDokterKeyPressed

    private void DTPTglItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DTPTglItemStateChanged
        if (kd2.getText().equals("")) {
            String tanggal = new SimpleDateFormat("ddMMyyyy").format(DTPTgl.getDate());
            Valid.autoNomer6("select LPAD(COUNT(DISTINCT no_surat), 4, 0) from perintah_inap where no_surat like '%"+tanggal+"' ", tanggal, 4, NoSurat);
        }
    }//GEN-LAST:event_DTPTglItemStateChanged

    private void MnCetakSPRIPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnCetakSPRIPSActionPerformed
        if(TPasien.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Silahkan anda pilih dulu pasien...!!!");
        }else{
            if(tbObat.getSelectedRow()!= -1){
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                Map<String, Object> param = new HashMap<>();
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());  
                param.put(JRParameter.REPORT_LOCALE,new Locale("id"));  
                String dokterPerujuk = Sequel.cariIsi("select reg_periksa.kd_dokter from reg_periksa WHERE reg_periksa.no_rawat = ?",TNoRw.getText());
                finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",dokterPerujuk);
                finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",KdPerawat.getText());
                param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+Dokter.getText()+"\nID "+(finger.equals("")?dokterPerujuk:finger)+"\n"+DTPTgl.getSelectedItem()); 
                param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+NmPerawat.getText()+"\nID "+(finger2.equals("")?KdPerawat.getText():finger2)+"\n"+DTPTgl.getSelectedItem()); 
                param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
                Valid.MyReportqry("rptSPRIPoli.jasper","report","::[ Surat Perintah Rawat Inap Poli SPesialis ]::",
                        " select perintah_inap.no_surat, reg_periksa.no_rawat, reg_periksa.no_rkm_medis, pasien.nm_pasien, pasien.jk, pasien.tgl_lahir, "
                                + "concat(pasien.alamat, ', ', kelurahan.nm_kel, ', ', kecamatan.nm_kec, ', ', kabupaten.nm_kab) as alamat, concat(reg_periksa.umurdaftar,' ',reg_periksa.sttsumur) as umur, "
                                + "perintah_inap.tanggal, dokter_reg.nm_dokter as dokter_registrasi, "
                                + "dokter_inap.nm_dokter as dokter_perintah_inap,  petugas.nama as nm_perawat, perintah_inap.diagnosa, perintah_inap.tindakan "
                                + "from perintah_inap "
                                + "join reg_periksa on perintah_inap.no_rawat = reg_periksa.no_rawat "
                                + "join pasien on reg_periksa.no_rkm_medis = pasien.no_rkm_medis join kelurahan on pasien.kd_kel = kelurahan.kd_kel "
                                + "join kecamatan on pasien.kd_kec = kecamatan.kd_kec join kabupaten on pasien.kd_kab = kabupaten.kd_kab "
                                + "join dokter as dokter_reg on reg_periksa.kd_dokter = dokter_reg.kd_dokter "
                                + "join dokter as dokter_inap on perintah_inap.kd_dokter = dokter_inap.kd_dokter "
                                + "join petugas on perintah_inap.kd_perawat = petugas.nip "+
                        "where perintah_inap.no_surat='"+NoSurat.getText()+"' ",param);
                this.setCursor(Cursor.getDefaultCursor());
            }else{
                JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data...!!!!");
            }
        }
    }//GEN-LAST:event_MnCetakSPRIPSActionPerformed

    private void MnCetakSPRIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnCetakSPRIGDActionPerformed
        if(TPasien.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Silahkan anda pilih dulu pasien...!!!");
        }else{
            if(tbObat.getSelectedRow()!= -1){
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                Map<String, Object> param = new HashMap<>();
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());  
                param.put(JRParameter.REPORT_LOCALE,new Locale("id"));  
                String dokterPerujuk = Sequel.cariIsi("select reg_periksa.kd_dokter from reg_periksa WHERE reg_periksa.no_rawat = ?",TNoRw.getText());
                finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",dokterPerujuk);
                finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",KdPerawat.getText());
                param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+Dokter.getText()+"\nID "+(finger.equals("")?dokterPerujuk:finger)+"\n"+DTPTgl.getSelectedItem()); 
                param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+NmPerawat.getText()+"\nID "+(finger2.equals("")?KdPerawat.getText():finger2)+"\n"+DTPTgl.getSelectedItem()); 
                param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
                Valid.MyReportqry("rptSPRIGawat.jasper","report","::[ Surat Perintah Rawat Inap Gawat Darurat ]::",
                        " select perintah_inap.no_surat, reg_periksa.no_rawat, reg_periksa.no_rkm_medis, pasien.nm_pasien, pasien.jk, pasien.tgl_lahir, "
                                + "concat(pasien.alamat, ', ', kelurahan.nm_kel, ', ', kecamatan.nm_kec, ', ', kabupaten.nm_kab) as alamat, concat(reg_periksa.umurdaftar,' ',reg_periksa.sttsumur) as umur, "
                                + "perintah_inap.tanggal, dokter_reg.nm_dokter as dokter_registrasi, "
                                + "dokter_inap.nm_dokter as dokter_perintah_inap,  petugas.nama as nm_perawat, perintah_inap.diagnosa, perintah_inap.tindakan "
                                + "from perintah_inap "
                                + "join reg_periksa on perintah_inap.no_rawat = reg_periksa.no_rawat "
                                + "join pasien on reg_periksa.no_rkm_medis = pasien.no_rkm_medis join kelurahan on pasien.kd_kel = kelurahan.kd_kel "
                                + "join kecamatan on pasien.kd_kec = kecamatan.kd_kec join kabupaten on pasien.kd_kab = kabupaten.kd_kab "
                                + "join dokter as dokter_reg on reg_periksa.kd_dokter = dokter_reg.kd_dokter "
                                + "join dokter as dokter_inap on perintah_inap.kd_dokter = dokter_inap.kd_dokter "
                                + "join petugas on perintah_inap.kd_perawat = petugas.nip "+
                        "where perintah_inap.no_surat='"+NoSurat.getText()+"' ",param);
                this.setCursor(Cursor.getDefaultCursor());
            }else{
                JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data...!!!!");
            }
        }
    }//GEN-LAST:event_MnCetakSPRIGDActionPerformed

    private void BtnKonsulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKonsulActionPerformed
        if (TNoRw.getText().trim().isEmpty()) {
            return;
        }
        
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            DlgPermintaanKonsultasiMedik form=new DlgPermintaanKonsultasiMedik(null,false);
            form.isCek();
            form.setSize(internalFrame1.getWidth(),internalFrame1.getHeight());
            form.setLocationRelativeTo(internalFrame1);
            form.setVisible(true);
            form.emptTeks();
            form.setNoRm(TNoRw.getText(),TNoRM.getText(),TPasien.getText());
            form.tampil();
            this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnKonsulActionPerformed

    private void BtnKonsulKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKonsulKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnKonsulKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgPerintahInap dialog = new DlgPerintahInap(new javax.swing.JFrame(), true);
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
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnKonsul;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.Tanggal DTPReg;
    private widget.Tanggal DTPTgl;
    private widget.TextBox Diagnosa;
    private widget.TextBox Dokter;
    private widget.PanelBiasa FormInput;
    private widget.TextBox KdDokter;
    private widget.TextBox KdPerawat;
    private widget.Label LCount;
    private javax.swing.JMenuItem MnCetakSPRIGD;
    private javax.swing.JMenuItem MnCetakSPRIPS;
    private widget.TextBox NmDokter;
    private widget.TextBox NmPerawat;
    private widget.TextBox NoSurat;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTextArea Tindakan;
    private widget.Button btnCariDokter;
    private widget.Button btnCariPenyakit;
    private widget.Button btnCariPerawat;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel12;
    private widget.Label jLabel13;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel19;
    private widget.Label jLabel21;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kd2;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Table tbObat;
    // End of variables declaration//GEN-END:variables

    public void tampil() {        
        Valid.tabelKosong(tabMode);
        try{
            pstampil=koneksi.prepareStatement(
                    "select perintah_inap.no_surat, reg_periksa.no_rawat, reg_periksa.no_rkm_medis, pasien.nm_pasien,"
                            + " concat(pasien.alamat, ', ', kelurahan.nm_kel, ', ', kecamatan.nm_kec, ', ', kabupaten.nm_kab) as alamat,"
                            + " concat(reg_periksa.umurdaftar,' ',reg_periksa.sttsumur) as umur, perintah_inap.tanggal,"
                            + " dokter_reg.nm_dokter as dokter_registrasi, perintah_inap.kd_dokter,"
                            + " dokter_inap.nm_dokter as dokter_perintah_inap, perintah_inap.kd_perawat,"
                            + " petugas.nama as nm_perawat, perintah_inap.diagnosa, perintah_inap.tindakan"
                            + " from perintah_inap"
                            + " join reg_periksa on perintah_inap.no_rawat = reg_periksa.no_rawat"
                            + " join pasien on reg_periksa.no_rkm_medis = pasien.no_rkm_medis"
                            + " join kelurahan on pasien.kd_kel = kelurahan.kd_kel"
                            + " join kecamatan on pasien.kd_kec = kecamatan.kd_kec"
                            + " join kabupaten on pasien.kd_kab = kabupaten.kd_kab"
                            + " join dokter as dokter_reg on reg_periksa.kd_dokter = dokter_reg.kd_dokter"
                            + " join dokter as dokter_inap on perintah_inap.kd_dokter = dokter_inap.kd_dokter"
                            + " join petugas on perintah_inap.kd_perawat = petugas.nip"
                            + " where perintah_inap.tanggal between ? and ?"
                            + " and (perintah_inap.no_surat like ? or perintah_inap.no_rawat like ?"
                            + " or reg_periksa.no_rkm_medis like ? or dokter_reg.nm_dokter like ? or dokter_inap.nm_dokter like ?"
                            + " or petugas.nama like ? or perintah_inap.diagnosa like ?)"
                            + " order by perintah_inap.tanggal asc");
            try {
                pstampil.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                pstampil.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                pstampil.setString(3,"%"+TCari.getText().trim()+"%");
                pstampil.setString(4,"%"+TCari.getText().trim()+"%");
                pstampil.setString(5,"%"+TCari.getText().trim()+"%");
                pstampil.setString(6,"%"+TCari.getText().trim()+"%");
                pstampil.setString(7,"%"+TCari.getText().trim()+"%");
                pstampil.setString(8,"%"+TCari.getText().trim()+"%");
                pstampil.setString(9,"%"+TCari.getText().trim()+"%");
                rs=pstampil.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        false,rs.getString("no_surat"),rs.getString("no_rawat"),rs.getString("no_rkm_medis"),
                        rs.getString("nm_pasien"),rs.getString("alamat"),rs.getString("umur"),
                        rs.getString("tanggal"),rs.getString("dokter_registrasi"),rs.getString("kd_dokter"),rs.getString("dokter_perintah_inap"),
                        rs.getString("kd_perawat"),rs.getString("nm_perawat"),rs.getString("diagnosa"),rs.getString("tindakan")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(pstampil!=null){
                    pstampil.close();
                }
            }
                
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }

    public void emptTeks() {
        String tanggal = new SimpleDateFormat("ddMMyyyy").format(DTPTgl.getDate());
        kd2.setText("");
        Diagnosa.setText("");
        KdPerawat.setText("");
        NmPerawat.setText("");
        KdDokter.setText("");
        NmDokter.setText("");
        Dokter.setText("");
        Tindakan.setText("");
        DTPTgl.setDate(new Date());
        NoSurat.requestFocus();
        Valid.autoNomer6("select LPAD(COUNT(DISTINCT no_surat), 4, 0) from perintah_inap where no_surat like '%"+tanggal+"' ", tanggal, 4, NoSurat);
    }


    private void getData() {
        if(tbObat.getSelectedRow()!= -1){
            kd2.setText(tbObat.getValueAt(tbObat.getSelectedRow(),1).toString());
            TNoRw.setText(tbObat.getValueAt(tbObat.getSelectedRow(),2).toString());
            TNoRM.setText(tbObat.getValueAt(tbObat.getSelectedRow(),3).toString());
            TPasien.setText(tbObat.getValueAt(tbObat.getSelectedRow(),4).toString());
            NoSurat.setText(tbObat.getValueAt(tbObat.getSelectedRow(),1).toString());
            Diagnosa.setText(tbObat.getValueAt(tbObat.getSelectedRow(),13).toString());
            KdPerawat.setText(tbObat.getValueAt(tbObat.getSelectedRow(),11).toString());
            NmPerawat.setText(tbObat.getValueAt(tbObat.getSelectedRow(),12).toString());
            KdDokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(),9).toString());
            NmDokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(),10).toString());
            Dokter.setText(tbObat.getValueAt(tbObat.getSelectedRow(),8).toString());
            Tindakan.setText(tbObat.getValueAt(tbObat.getSelectedRow(),14).toString());
            Valid.SetTgl(DTPTgl,tbObat.getValueAt(tbObat.getSelectedRow(),7).toString()); 
        }
    }

    private void isRawat() {
        try {
            pstampil=koneksi.prepareStatement(
                "select reg_periksa.no_rkm_medis,pasien.nm_pasien from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis where reg_periksa.no_rawat=?");
            try {
                pstampil.setString(1,TNoRw.getText());
                rs=pstampil.executeQuery();
                if(rs.next()){
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    TPasien.setText(rs.getString("nm_pasien"));
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(pstampil!=null){
                    pstampil.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notif : "+e);
        }
    }
    
    public void setNoRm(String norwt, Date tgl1, Date tgl2) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        DTPCari1.setDate(tgl1);
        DTPCari2.setDate(tgl2);
        isRawat();   
        Dokter.setText(Sequel.cariIsi("select dokter.nm_dokter from dokter join reg_periksa on dokter.kd_dokter = reg_periksa.kd_dokter where reg_periksa.no_rawat=?",norwt));
        Diagnosa.setText(Sequel.cariIsi("select diagnosis from penilaian_medis_igd where no_rawat = ?",norwt));
        Tindakan.setText(Sequel.cariIsi("select tata from penilaian_medis_igd where no_rawat = ?",norwt));
        ChkInput.setSelected(true);
        isForm();
    }
    
    public void setNoRm2(String norwt) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        Valid.SetTgl(DTPCari1, Sequel.cariIsi("select tgl_registrasi from reg_periksa where no_rawat = ?", norwt));
        DTPCari2.setDate(new Date());
        isRawat();   
        Dokter.setText(Sequel.cariIsi("select dokter.nm_dokter from dokter join reg_periksa on dokter.kd_dokter = reg_periksa.kd_dokter where reg_periksa.no_rawat=?",norwt));
        Diagnosa.setText(Sequel.cariIsi("select diagnosis from penilaian_medis_igd where no_rawat = ?",norwt));
        Tindakan.setText(Sequel.cariIsi("select tata from penilaian_medis_igd where no_rawat = ?",norwt));
        ChkInput.setSelected(true);
        isForm();
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(akses.getrujukan_masuk());
        BtnHapus.setEnabled(akses.getrujukan_masuk());
        BtnPrint.setEnabled(akses.getrujukan_masuk());
        BtnEdit.setEnabled(akses.getrujukan_masuk());
        BtnKonsul.setEnabled(akses.getkonsultasi_medik());
    }
    
    
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,260));
            FormInput.setVisible(true);      
            ChkInput.setVisible(true);
        }else if(ChkInput.isSelected()==false){           
            ChkInput.setVisible(false);            
            PanelInput.setPreferredSize(new Dimension(WIDTH,20));
            FormInput.setVisible(false);      
            ChkInput.setVisible(true);
        }
    }

}
