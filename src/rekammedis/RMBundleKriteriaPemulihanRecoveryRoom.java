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
package rekammedis;

import simrskhanza.DlgCariPasien;
import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPegawai;

/**
 *
 * @author dosen
 */
public final class RMBundleKriteriaPemulihanRecoveryRoom extends javax.swing.JDialog {

    private final DefaultTableModel tabModeBromage, tabModeSteward,
            tabModeAldrette, tabModePadss;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private DlgCariPasien pasien = new DlgCariPasien(null, false);
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    public DlgCariPetugas petugas = new DlgCariPetugas(null, false);
    public DlgCariPegawai pegawai = new DlgCariPegawai(null, false);
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0;
    private String finger = "", finger2 = "";

    /**
     * Creates new form DlgPerawatan
     *
     * @param parent
     * @param modal
     */
    public RMBundleKriteriaPemulihanRecoveryRoom(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8, 1);
        setSize(885, 674);

        tabModeBromage = new DefaultTableModel(null,new Object[]{
                "No.Rawat","No.R.M.","Nama Pasien","Tgl.Lahir","JK","Tanggal","Skala","Nilai","Keluar","Instruksi","Kode Dokter","Nama Dokter","NIP","Petugas"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbBromage.setModel(tabModeBromage);
        tbBromage.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbBromage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 14; i++) {
            TableColumn column = tbBromage.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(65);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(200);
            }else if(i==7){
                column.setPreferredWidth(40);
            }else if(i==8){
                column.setPreferredWidth(200);
            }else if(i==9){
                column.setPreferredWidth(200);
            }else if(i==10){
                column.setPreferredWidth(90);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(90);
            }else if(i==13){
                column.setPreferredWidth(150);
            }
        }
                
        tbBromage.setDefaultRenderer(Object.class, new WarnaTable());

        tabModeSteward=new DefaultTableModel(null,new Object[]{
            "No.Rawat","No.R.M.","Nama Pasien","Tgl.Lahir","JK","Tanggal","1. Kesadaran","N.K. 1","2. Respirasi","N.K. 2",
            "3. Aktivitas Motorik","N.K. 3","Total","Keluar","Instruksi","Kode Dokter","Nama Dokter","NIP","Petugas"
        }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };

        tbSteward.setModel(tabModeSteward);
        tbSteward.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbSteward.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 19; i++) {
            TableColumn column = tbSteward.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(65);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(140);
            }else if(i==7){
                column.setPreferredWidth(40);
            }else if(i==8){
                column.setPreferredWidth(140);
            }else if(i==9){
                column.setPreferredWidth(40);
            }else if(i==10){
                column.setPreferredWidth(140);
            }else if(i==11){
                column.setPreferredWidth(40);
            }else if(i==12){
                column.setPreferredWidth(40);
            }else if(i==13){
                column.setPreferredWidth(200);
            }else if(i==14){
                column.setPreferredWidth(200);
            }else if(i==15){
                column.setPreferredWidth(85);
            }else if(i==16){
                column.setPreferredWidth(150);
            }else if(i==17){
                column.setPreferredWidth(85);
            }else if(i==18){
                column.setPreferredWidth(150);
            }
        }

        tabModeAldrette=new DefaultTableModel(null,new Object[]{
            "No.Rawat","No.R.M.","Nama Pasien","Tgl.Lahir","JK","Tanggal","1. Aktivitas","N.K. 1","2. Respirasi","N.K. 2",
            "3. Tekanan Darah","N.K. 3","4. Kesadaran","N.K. 4","5. Warna Kulit","N.K. 5","Total","Keluar","Instruksi",
            "Kode Dokter","Nama Dokter","NIP","Petugas"
        }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbAldrette.setModel(tabModeAldrette);
        tbAldrette.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbAldrette.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 23; i++) {
            TableColumn column = tbAldrette.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(65);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(150);
            }else if(i==7){
                column.setPreferredWidth(40);
            }else if(i==8){
                column.setPreferredWidth(150);
            }else if(i==9){
                column.setPreferredWidth(40);
            }else if(i==10){
                column.setPreferredWidth(150);
            }else if(i==11){
                column.setPreferredWidth(50);
            }else if(i==12){
                column.setPreferredWidth(150);
            }else if(i==13){
                column.setPreferredWidth(40);
            }else if(i==14){
                column.setPreferredWidth(150);
            }else if(i==15){
                column.setPreferredWidth(40);
            }else if(i==16){
                column.setPreferredWidth(40);
            }else if(i==17){
                column.setPreferredWidth(200);
            }else if(i==18){
                column.setPreferredWidth(200);
            }else if(i==19){
                column.setPreferredWidth(85);
            }else if(i==20){
                column.setPreferredWidth(150);
            }else if(i==21){
                column.setPreferredWidth(85);
            }else if(i==22){
                column.setPreferredWidth(150);
            }
        }
        tbAldrette.setDefaultRenderer(Object.class, new WarnaTable());

        tabModePadss=new DefaultTableModel(null,new Object[]{
            "No.Rawat","No.R.M.","Nama Pasien","Tgl.Lahir","JK","Tanggal","1. Tanda-tanda Vital","N.K. 1","2. Tingkat Aktvitas","N.K. 2",
            "3. Nyeri, Mual, dan Muntah","N.K. 3","4. Pendarahan Bedah","N.K. 4","5. Intake dan Output","N.K. 5","Total","Keluar","Instruksi",
            "Kode Dokter","Nama Dokter","NIP","Petugas"
        }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbPadss.setModel(tabModePadss);
        tbPadss.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbPadss.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 23; i++) {
            TableColumn column = tbPadss.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(65);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(150);
            }else if(i==7){
                column.setPreferredWidth(40);
            }else if(i==8){
                column.setPreferredWidth(150);
            }else if(i==9){
                column.setPreferredWidth(40);
            }else if(i==10){
                column.setPreferredWidth(150);
            }else if(i==11){
                column.setPreferredWidth(50);
            }else if(i==12){
                column.setPreferredWidth(150);
            }else if(i==13){
                column.setPreferredWidth(40);
            }else if(i==14){
                column.setPreferredWidth(150);
            }else if(i==15){
                column.setPreferredWidth(40);
            }else if(i==16){
                column.setPreferredWidth(40);
            }else if(i==17){
                column.setPreferredWidth(200);
            }else if(i==18){
                column.setPreferredWidth(200);
            }else if(i==19){
                column.setPreferredWidth(85);
            }else if(i==20){
                column.setPreferredWidth(150);
            }else if(i==21){
                column.setPreferredWidth(85);
            }else if(i==22){
                column.setPreferredWidth(150);
            }
        }
        tbPadss.setDefaultRenderer(Object.class, new WarnaTable());

        

        TNoRw.setDocument(new batasInput((byte) 17).getKata(TNoRw));
        TCari.setDocument(new batasInput((int) 100).getKata(TCari));
        

        if (koneksiDB.CARICEPAT().equals("aktif")) {
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        TampilkanData();
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        TampilkanData();
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (TCari.getText().length() > 2) {
                        TampilkanData();
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
                if (akses.getform().equals("RMBundleKriteriaPemulihanRecoveryRoom")) {
                    if (dokter.getTable().getSelectedRow() != -1) {
                        switch(TabRawat.getSelectedIndex()) {
                            case 0:
                                KdDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                                NmDokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                                KdDokter.requestFocus();
                                break;
                            case 1:
                                KdDokter1.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                                NmDokter1.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                                KdDokter1.requestFocus();
                                break;
                            case 2:
                                KdDokter2.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                                NmDokter2.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                                KdDokter2.requestFocus();
                                break;
                            case 3:
                                KdDokter3.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                                NmDokter3.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                                KdDokter3.requestFocus();
                                break;
                            default:
                                break;
                        }
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
                if (akses.getform().equals("RMBundleKriteriaPemulihanRecoveryRoom")) {
                    if (petugas.getTable().getSelectedRow() != -1) {
                        switch(TabRawat.getSelectedIndex()) {
                            case 0:
                                NIP.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NamaPetugas.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),1).toString());
                                NIP.requestFocus();
                                break;
                            case 1:
                                NIP1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NamaPetugas1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),1).toString());
                                NIP1.requestFocus();
                                break;
                            case 2:
                                NIP2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NamaPetugas2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),1).toString());
                                NIP2.requestFocus();
                                break;
                            case 3:
                                NIP3.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NamaPetugas3.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(),1).toString());
                                NIP3.requestFocus();
                                break;
                            default:
                                break;
                        }
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

        pegawai.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (pegawai.getTable().getSelectedRow() != -1) {
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

        ChkInput.setSelected(false);
        isForm();
        ChkInput1.setSelected(false);
        isForm2();
        ChkInput2.setSelected(false);
        isForm3();
        ChkInput3.setSelected(false);
        isForm4();
        
        jam();

    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JK = new widget.TextBox();
        PopupMenuBromage = new javax.swing.JPopupMenu();
        MnMonitoringBromageScore = new javax.swing.JMenuItem();
        MnMonitoringBromageScore2 = new javax.swing.JMenuItem();
        PopupMenuSteward = new javax.swing.JPopupMenu();
        MnMonitoringStewardScore = new javax.swing.JMenuItem();
        MnMonitoringStewardScore2 = new javax.swing.JMenuItem();
        PopupMenuAldrette = new javax.swing.JPopupMenu();
        MnMonitoringSkorAldrette = new javax.swing.JMenuItem();
        MnMonitoringSkorAldrette2 = new javax.swing.JMenuItem();
        PopupMenuPadss = new javax.swing.JPopupMenu();
        MnMonitoringSkorPadss = new javax.swing.JMenuItem();
        MnMonitoringSkorPadss2 = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnAll = new widget.Button();
        jLabel10 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        TabRawat = new javax.swing.JTabbedPane();
        internalFrame5 = new widget.InternalFrame();
        Scroll3 = new widget.ScrollPane();
        tbBromage = new widget.Table();
        PanelInput = new javax.swing.JPanel();
        ChkInput = new widget.CekBox();
        Scroll7 = new widget.ScrollPane();
        panelGlass12 = new widget.panelisi();
        PanelWall = new usu.widget.glass.PanelGlass();
        NamaPetugas = new widget.TextBox();
        jLabel218 = new widget.Label();
        jLabel30 = new widget.Label();
        BtnDokter = new widget.Button();
        ChkKejadian = new widget.CekBox();
        scrollPane1 = new widget.ScrollPane();
        Keluar = new widget.TextArea();
        jLabel18 = new widget.Label();
        TingkatKriteria = new widget.Label();
        jLabel219 = new widget.Label();
        scrollPane2 = new widget.ScrollPane();
        Instruksi = new widget.TextArea();
        jLabel31 = new widget.Label();
        NIP = new widget.TextBox();
        Detik = new widget.ComboBox();
        btnPetugas = new widget.Button();
        label14 = new widget.Label();
        NilaiBromage = new widget.TextBox();
        Menit = new widget.ComboBox();
        Jam = new widget.ComboBox();
        SkalaBromage = new widget.ComboBox();
        jLabel220 = new widget.Label();
        NmDokter = new widget.TextBox();
        jLabel16 = new widget.Label();
        Tanggal = new widget.Tanggal();
        jLabel57 = new widget.Label();
        jSeparator2 = new javax.swing.JSeparator();
        KdDokter = new widget.TextBox();
        internalFrame6 = new widget.InternalFrame();
        Scroll4 = new widget.ScrollPane();
        tbSteward = new widget.Table();
        PanelInput1 = new javax.swing.JPanel();
        ChkInput1 = new widget.CekBox();
        Scroll8 = new widget.ScrollPane();
        panelGlass13 = new widget.panelisi();
        jLabel217 = new widget.Label();
        NIP1 = new widget.TextBox();
        Menit1 = new widget.ComboBox();
        jLabel223 = new widget.Label();
        NilaiSteward3 = new widget.TextBox();
        label15 = new widget.Label();
        NilaiSteward2 = new widget.TextBox();
        SkalaSteward2 = new widget.ComboBox();
        NilaiSteward1 = new widget.TextBox();
        KdDokter1 = new widget.TextBox();
        scrollPane3 = new widget.ScrollPane();
        Keluar1 = new widget.TextArea();
        btnPetugas1 = new widget.Button();
        jLabel222 = new widget.Label();
        jLabel32 = new widget.Label();
        jLabel33 = new widget.Label();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        scrollPane4 = new widget.ScrollPane();
        Instruksi1 = new widget.TextArea();
        NamaPetugas1 = new widget.TextBox();
        BtnDokter1 = new widget.Button();
        Tanggal1 = new widget.Tanggal();
        jLabel17 = new widget.Label();
        jSeparator6 = new javax.swing.JSeparator();
        NilaiTotalSteward = new widget.TextBox();
        jLabel20 = new widget.Label();
        jLabel221 = new widget.Label();
        jLabel58 = new widget.Label();
        jLabel224 = new widget.Label();
        TingkatSkor = new widget.Label();
        ChkKejadian1 = new widget.CekBox();
        Detik1 = new widget.ComboBox();
        NmDokter1 = new widget.TextBox();
        SkalaSteward3 = new widget.ComboBox();
        jLabel235 = new widget.Label();
        jLabel225 = new widget.Label();
        jLabel226 = new widget.Label();
        SkalaSteward1 = new widget.ComboBox();
        jLabel227 = new widget.Label();
        jLabel228 = new widget.Label();
        Jam1 = new widget.ComboBox();
        internalFrame7 = new widget.InternalFrame();
        Scroll5 = new widget.ScrollPane();
        tbAldrette = new widget.Table();
        PanelInput2 = new javax.swing.JPanel();
        ChkInput2 = new widget.CekBox();
        Scroll9 = new widget.ScrollPane();
        panelGlass14 = new widget.panelisi();
        jLabel22 = new widget.Label();
        TingkatSkor1 = new widget.Label();
        jLabel229 = new widget.Label();
        btnPetugas2 = new widget.Button();
        NilaiAldrette5 = new widget.TextBox();
        scrollPane5 = new widget.ScrollPane();
        Instruksi2 = new widget.TextArea();
        jLabel230 = new widget.Label();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel231 = new widget.Label();
        jLabel232 = new widget.Label();
        NilaiAldrette1 = new widget.TextBox();
        jLabel233 = new widget.Label();
        Tanggal2 = new widget.Tanggal();
        jLabel234 = new widget.Label();
        jLabel23 = new widget.Label();
        jLabel236 = new widget.Label();
        jLabel237 = new widget.Label();
        jLabel238 = new widget.Label();
        jLabel34 = new widget.Label();
        NilaiAldrette3 = new widget.TextBox();
        Detik2 = new widget.ComboBox();
        NamaPetugas2 = new widget.TextBox();
        NilaiAldrette4 = new widget.TextBox();
        jLabel59 = new widget.Label();
        NilaiAldrette2 = new widget.TextBox();
        NilaiTotalAldrette = new widget.TextBox();
        jSeparator8 = new javax.swing.JSeparator();
        SkalaAldrette2 = new widget.ComboBox();
        BtnDokter2 = new widget.Button();
        NIP2 = new widget.TextBox();
        jLabel239 = new widget.Label();
        jLabel240 = new widget.Label();
        jLabel241 = new widget.Label();
        jLabel242 = new widget.Label();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel35 = new widget.Label();
        NmDokter2 = new widget.TextBox();
        scrollPane6 = new widget.ScrollPane();
        Keluar2 = new widget.TextArea();
        jLabel243 = new widget.Label();
        Jam2 = new widget.ComboBox();
        KdDokter2 = new widget.TextBox();
        SkalaAldrette3 = new widget.ComboBox();
        Menit2 = new widget.ComboBox();
        label16 = new widget.Label();
        SkalaAldrette4 = new widget.ComboBox();
        jLabel244 = new widget.Label();
        SkalaAldrette5 = new widget.ComboBox();
        SkalaAldrette1 = new widget.ComboBox();
        ChkKejadian2 = new widget.CekBox();
        jLabel245 = new widget.Label();
        internalFrame8 = new widget.InternalFrame();
        Scroll6 = new widget.ScrollPane();
        tbPadss = new widget.Table();
        PanelInput3 = new javax.swing.JPanel();
        ChkInput3 = new widget.CekBox();
        Scroll10 = new widget.ScrollPane();
        panelGlass15 = new widget.panelisi();
        NilaiPadss4 = new widget.TextBox();
        NilaiPadss3 = new widget.TextBox();
        SkalaPadss1 = new widget.ComboBox();
        jLabel36 = new widget.Label();
        label17 = new widget.Label();
        jLabel25 = new widget.Label();
        TingkatSkor2 = new widget.Label();
        jLabel246 = new widget.Label();
        jLabel247 = new widget.Label();
        jLabel248 = new widget.Label();
        jLabel249 = new widget.Label();
        SkalaPadss3 = new widget.ComboBox();
        NmDokter3 = new widget.TextBox();
        jLabel250 = new widget.Label();
        jLabel251 = new widget.Label();
        NamaPetugas3 = new widget.TextBox();
        jLabel252 = new widget.Label();
        jLabel26 = new widget.Label();
        NIP3 = new widget.TextBox();
        jLabel253 = new widget.Label();
        jLabel254 = new widget.Label();
        jLabel255 = new widget.Label();
        jLabel256 = new widget.Label();
        jSeparator10 = new javax.swing.JSeparator();
        BtnDokter3 = new widget.Button();
        NilaiPadss1 = new widget.TextBox();
        Menit3 = new widget.ComboBox();
        KdDokter3 = new widget.TextBox();
        jLabel60 = new widget.Label();
        jLabel257 = new widget.Label();
        NilaiPadss5 = new widget.TextBox();
        jLabel258 = new widget.Label();
        Tanggal3 = new widget.Tanggal();
        scrollPane7 = new widget.ScrollPane();
        Keluar3 = new widget.TextArea();
        ChkKejadian3 = new widget.CekBox();
        jLabel259 = new widget.Label();
        jLabel260 = new widget.Label();
        scrollPane8 = new widget.ScrollPane();
        Instruksi3 = new widget.TextArea();
        NilaiPadss2 = new widget.TextBox();
        jLabel37 = new widget.Label();
        Detik3 = new widget.ComboBox();
        SkalaPadss5 = new widget.ComboBox();
        SkalaPadss4 = new widget.ComboBox();
        jLabel261 = new widget.Label();
        btnPetugas3 = new widget.Button();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        Jam3 = new widget.ComboBox();
        NilaiTotalPadss = new widget.TextBox();
        SkalaPadss2 = new widget.ComboBox();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel8 = new widget.Label();
        TglLahir = new widget.TextBox();

        JK.setHighlighter(null);
        JK.setName("JK"); // NOI18N

        PopupMenuBromage.setName("PopupMenuBromage"); // NOI18N

        MnMonitoringBromageScore.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringBromageScore.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringBromageScore.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringBromageScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringBromageScore.setText("Monitoring Skor Bromage Pasca Anestesi");
        MnMonitoringBromageScore.setName("MnMonitoringBromageScore"); // NOI18N
        MnMonitoringBromageScore.setPreferredSize(new java.awt.Dimension(290, 26));
        MnMonitoringBromageScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringBromageScoreActionPerformed(evt);
            }
        });
        PopupMenuBromage.add(MnMonitoringBromageScore);

        MnMonitoringBromageScore2.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringBromageScore2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringBromageScore2.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringBromageScore2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringBromageScore2.setText("Rekap Monitoring Skor Bromage Pasca Anestesi");
        MnMonitoringBromageScore2.setName("MnMonitoringBromageScore2"); // NOI18N
        MnMonitoringBromageScore2.setPreferredSize(new java.awt.Dimension(230, 26));
        MnMonitoringBromageScore2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringBromageScore2ActionPerformed(evt);
            }
        });
        PopupMenuBromage.add(MnMonitoringBromageScore2);

        PopupMenuSteward.setName("PopupMenuSteward"); // NOI18N

        MnMonitoringStewardScore.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringStewardScore.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringStewardScore.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringStewardScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringStewardScore.setText("Monitoring Skor Steward Pasca Anestesi");
        MnMonitoringStewardScore.setName("MnMonitoringStewardScore"); // NOI18N
        MnMonitoringStewardScore.setPreferredSize(new java.awt.Dimension(290, 26));
        MnMonitoringStewardScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringStewardScoreActionPerformed(evt);
            }
        });
        PopupMenuSteward.add(MnMonitoringStewardScore);

        MnMonitoringStewardScore2.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringStewardScore2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringStewardScore2.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringStewardScore2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringStewardScore2.setText("Rekap Monitoring Skor Steward Pasca Anestesi");
        MnMonitoringStewardScore2.setName("MnMonitoringStewardScore2"); // NOI18N
        MnMonitoringStewardScore2.setPreferredSize(new java.awt.Dimension(230, 26));
        MnMonitoringStewardScore2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringStewardScore2ActionPerformed(evt);
            }
        });
        PopupMenuSteward.add(MnMonitoringStewardScore2);

        PopupMenuAldrette.setName("PopupMenuAldrette"); // NOI18N

        MnMonitoringSkorAldrette.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringSkorAldrette.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringSkorAldrette.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringSkorAldrette.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringSkorAldrette.setText("Monitoring Skor Aldrette Pasca Anestesi");
        MnMonitoringSkorAldrette.setName("MnMonitoringSkorAldrette"); // NOI18N
        MnMonitoringSkorAldrette.setPreferredSize(new java.awt.Dimension(290, 26));
        MnMonitoringSkorAldrette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringSkorAldretteActionPerformed(evt);
            }
        });
        PopupMenuAldrette.add(MnMonitoringSkorAldrette);

        MnMonitoringSkorAldrette2.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringSkorAldrette2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringSkorAldrette2.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringSkorAldrette2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringSkorAldrette2.setText("Rekap Monitoring Skor Aldrette Pasca Anestesi");
        MnMonitoringSkorAldrette2.setName("MnMonitoringSkorAldrette2"); // NOI18N
        MnMonitoringSkorAldrette2.setPreferredSize(new java.awt.Dimension(230, 26));
        MnMonitoringSkorAldrette2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringSkorAldrette2ActionPerformed(evt);
            }
        });
        PopupMenuAldrette.add(MnMonitoringSkorAldrette2);

        PopupMenuPadss.setName("PopupMenuPadss"); // NOI18N

        MnMonitoringSkorPadss.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringSkorPadss.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringSkorPadss.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringSkorPadss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringSkorPadss.setText("Monitoring Skor Aldrette Pasca Anestesi");
        MnMonitoringSkorPadss.setName("MnMonitoringSkorPadss"); // NOI18N
        MnMonitoringSkorPadss.setPreferredSize(new java.awt.Dimension(290, 26));
        MnMonitoringSkorPadss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringSkorPadssActionPerformed(evt);
            }
        });
        PopupMenuPadss.add(MnMonitoringSkorPadss);

        MnMonitoringSkorPadss2.setBackground(new java.awt.Color(255, 255, 254));
        MnMonitoringSkorPadss2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnMonitoringSkorPadss2.setForeground(new java.awt.Color(50, 50, 50));
        MnMonitoringSkorPadss2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnMonitoringSkorPadss2.setText("Rekap Monitoring Skor Aldrette Pasca Anestesi");
        MnMonitoringSkorPadss2.setName("MnMonitoringSkorPadss2"); // NOI18N
        MnMonitoringSkorPadss2.setPreferredSize(new java.awt.Dimension(230, 26));
        MnMonitoringSkorPadss2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnMonitoringSkorPadss2ActionPerformed(evt);
            }
        });
        PopupMenuPadss.add(MnMonitoringSkorPadss2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Kriteria Pemulihan Recovery Room ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

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

        jLabel10.setText("Record :");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(95, 30));
        panelGlass8.add(jLabel10);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(87, 30));
        panelGlass8.add(LCount);

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

        jLabel19.setText("Tgl.Rawat :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(64, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari2);

        jSeparator5.setBackground(new java.awt.Color(220, 225, 215));
        jSeparator5.setForeground(new java.awt.Color(220, 225, 215));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setName("jSeparator5"); // NOI18N
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 23));
        panelGlass9.add(jSeparator5);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(240, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('6');
        BtnCari.setToolTipText("Alt+6");
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

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        TabRawat.setBackground(new java.awt.Color(255, 255, 253));
        TabRawat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(241, 246, 236)));
        TabRawat.setForeground(new java.awt.Color(50, 50, 50));
        TabRawat.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        TabRawat.setName("TabRawat"); // NOI18N
        TabRawat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabRawatMouseClicked(evt);
            }
        });

        internalFrame5.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame5.setName("internalFrame5"); // NOI18N
        internalFrame5.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll3.setName("Scroll3"); // NOI18N
        Scroll3.setOpaque(true);

        tbBromage.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbBromage.setComponentPopupMenu(PopupMenuBromage);
        tbBromage.setMinimumSize(new java.awt.Dimension(16, 16));
        tbBromage.setName("tbBromage"); // NOI18N
        tbBromage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBromageMouseClicked(evt);
            }
        });
        tbBromage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbBromageKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbBromageKeyReleased(evt);
            }
        });
        Scroll3.setViewportView(tbBromage);

        internalFrame5.add(Scroll3, java.awt.BorderLayout.CENTER);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 420));
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

        Scroll7.setName("Scroll7"); // NOI18N
        Scroll7.setOpaque(true);
        Scroll7.setPreferredSize(new java.awt.Dimension(46, 222));

        panelGlass12.setAutoscrolls(true);
        panelGlass12.setName("panelGlass12"); // NOI18N
        panelGlass12.setOpaque(false);
        panelGlass12.setPreferredSize(new java.awt.Dimension(192, 420));
        panelGlass12.setLayout(null);

        PanelWall.setBackground(new java.awt.Color(255, 255, 255));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/bromage_score.png"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setLayout(null);
        panelGlass12.add(PanelWall);
        PanelWall.setBounds(30, 90, 430, 233);

        NamaPetugas.setEditable(false);
        NamaPetugas.setName("NamaPetugas"); // NOI18N
        panelGlass12.add(NamaPetugas);
        NamaPetugas.setBounds(180, 10, 175, 23);

        jLabel218.setText("Nilai :");
        jLabel218.setName("jLabel218"); // NOI18N
        panelGlass12.add(jLabel218);
        jLabel218.setBounds(330, 330, 70, 23);

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel30.setText("Keluar :");
        jLabel30.setName("jLabel30"); // NOI18N
        panelGlass12.add(jLabel30);
        jLabel30.setBounds(500, 70, 80, 23);

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
        panelGlass12.add(BtnDokter);
        BtnDokter.setBounds(780, 10, 28, 23);

        ChkKejadian.setBorder(null);
        ChkKejadian.setSelected(true);
        ChkKejadian.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkKejadian.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkKejadian.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkKejadian.setName("ChkKejadian"); // NOI18N
        ChkKejadian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkKejadianActionPerformed(evt);
            }
        });
        panelGlass12.add(ChkKejadian);
        ChkKejadian.setBounds(390, 40, 23, 23);

        scrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane1.setName("scrollPane1"); // NOI18N

        Keluar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Keluar.setColumns(20);
        Keluar.setRows(20);
        Keluar.setName("Keluar"); // NOI18N
        Keluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeluarKeyPressed(evt);
            }
        });
        scrollPane1.setViewportView(Keluar);

        panelGlass12.add(scrollPane1);
        scrollPane1.setBounds(500, 90, 289, 133);

        jLabel18.setText("Petugas :");
        jLabel18.setName("jLabel18"); // NOI18N
        panelGlass12.add(jLabel18);
        jLabel18.setBounds(0, 10, 70, 23);

        TingkatKriteria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TingkatKriteria.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        TingkatKriteria.setToolTipText("");
        TingkatKriteria.setName("TingkatKriteria"); // NOI18N
        panelGlass12.add(TingkatKriteria);
        TingkatKriteria.setBounds(30, 360, 440, 30);

        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel219.setText("Skala");
        jLabel219.setName("jLabel219"); // NOI18N
        panelGlass12.add(jLabel219);
        jLabel219.setBounds(30, 330, 50, 23);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane2.setName("scrollPane2"); // NOI18N

        Instruksi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Instruksi.setColumns(20);
        Instruksi.setRows(20);
        Instruksi.setName("Instruksi"); // NOI18N
        Instruksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InstruksiKeyPressed(evt);
            }
        });
        scrollPane2.setViewportView(Instruksi);

        panelGlass12.add(scrollPane2);
        scrollPane2.setBounds(500, 250, 289, 133);

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel31.setText("Instruksi / Tindakan di ruang pemulihan (RR) :");
        jLabel31.setName("jLabel31"); // NOI18N
        panelGlass12.add(jLabel31);
        jLabel31.setBounds(500, 230, 280, 23);

        NIP.setEditable(false);
        NIP.setHighlighter(null);
        NIP.setName("NIP"); // NOI18N
        panelGlass12.add(NIP);
        NIP.setBounds(80, 10, 94, 23);

        Detik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Detik.setName("Detik"); // NOI18N
        Detik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DetikKeyPressed(evt);
            }
        });
        panelGlass12.add(Detik);
        Detik.setBounds(320, 40, 62, 23);

        btnPetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugas.setMnemonic('2');
        btnPetugas.setToolTipText("ALt+2");
        btnPetugas.setName("btnPetugas"); // NOI18N
        btnPetugas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasActionPerformed(evt);
            }
        });
        btnPetugas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasKeyPressed(evt);
            }
        });
        panelGlass12.add(btnPetugas);
        btnPetugas.setBounds(360, 10, 28, 23);

        label14.setText("Dokter Anestesi :");
        label14.setName("label14"); // NOI18N
        label14.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass12.add(label14);
        label14.setBounds(390, 10, 99, 23);

        NilaiBromage.setEditable(false);
        NilaiBromage.setFocusTraversalPolicyProvider(true);
        NilaiBromage.setName("NilaiBromage"); // NOI18N
        panelGlass12.add(NilaiBromage);
        NilaiBromage.setBounds(400, 330, 60, 23);

        Menit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Menit.setName("Menit"); // NOI18N
        Menit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MenitKeyPressed(evt);
            }
        });
        panelGlass12.add(Menit);
        Menit.setBounds(250, 40, 62, 23);

        Jam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        Jam.setName("Jam"); // NOI18N
        Jam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JamKeyPressed(evt);
            }
        });
        panelGlass12.add(Jam);
        Jam.setBounds(180, 40, 62, 23);

        SkalaBromage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Gerakan Penuh Dari Tungkai", "Tidak Mampu Extensi Tungkai", "Tidak Mampu Flexi Lutut", "Tidak Mampu Flexi Pergelangan Kaki" }));
        SkalaBromage.setName("SkalaBromage"); // NOI18N
        SkalaBromage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaBromageItemStateChanged(evt);
            }
        });
        SkalaBromage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SkalaBromageActionPerformed(evt);
            }
        });
        SkalaBromage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaBromageKeyPressed(evt);
            }
        });
        panelGlass12.add(SkalaBromage);
        SkalaBromage.setBounds(70, 330, 260, 23);

        jLabel220.setText(":");
        jLabel220.setName("jLabel220"); // NOI18N
        panelGlass12.add(jLabel220);
        jLabel220.setBounds(0, 330, 67, 23);

        NmDokter.setEditable(false);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.setPreferredSize(new java.awt.Dimension(207, 23));
        panelGlass12.add(NmDokter);
        NmDokter.setBounds(600, 10, 175, 23);

        jLabel16.setText("Tanggal :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setVerifyInputWhenFocusTarget(false);
        panelGlass12.add(jLabel16);
        jLabel16.setBounds(0, 40, 70, 23);

        Tanggal.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setOpaque(false);
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        panelGlass12.add(Tanggal);
        Tanggal.setBounds(80, 40, 90, 23);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Kriteria :");
        jLabel57.setName("jLabel57"); // NOI18N
        panelGlass12.add(jLabel57);
        jLabel57.setBounds(10, 70, 80, 23);

        jSeparator2.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator2.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator2.setName("jSeparator2"); // NOI18N
        panelGlass12.add(jSeparator2);
        jSeparator2.setBounds(0, 70, 810, 1);

        KdDokter.setEditable(false);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass12.add(KdDokter);
        KdDokter.setBounds(493, 10, 100, 23);

        Scroll7.setViewportView(panelGlass12);

        PanelInput.add(Scroll7, java.awt.BorderLayout.CENTER);

        internalFrame5.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Bromage Score", internalFrame5);

        internalFrame6.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame6.setName("internalFrame6"); // NOI18N
        internalFrame6.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll4.setName("Scroll4"); // NOI18N
        Scroll4.setOpaque(true);

        tbSteward.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbSteward.setComponentPopupMenu(PopupMenuSteward);
        tbSteward.setName("tbSteward"); // NOI18N
        tbSteward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStewardMouseClicked(evt);
            }
        });
        tbSteward.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbStewardKeyReleased(evt);
            }
        });
        Scroll4.setViewportView(tbSteward);

        internalFrame6.add(Scroll4, java.awt.BorderLayout.CENTER);

        PanelInput1.setName("PanelInput1"); // NOI18N
        PanelInput1.setOpaque(false);
        PanelInput1.setPreferredSize(new java.awt.Dimension(192, 420));
        PanelInput1.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput1.setMnemonic('I');
        ChkInput1.setText(".: Input Data");
        ChkInput1.setToolTipText("Alt+I");
        ChkInput1.setBorderPainted(true);
        ChkInput1.setBorderPaintedFlat(true);
        ChkInput1.setFocusable(false);
        ChkInput1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput1.setName("ChkInput1"); // NOI18N
        ChkInput1.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInput1ActionPerformed(evt);
            }
        });
        PanelInput1.add(ChkInput1, java.awt.BorderLayout.PAGE_END);

        Scroll8.setName("Scroll8"); // NOI18N
        Scroll8.setOpaque(true);
        Scroll8.setPreferredSize(new java.awt.Dimension(46, 222));

        panelGlass13.setName("panelGlass13"); // NOI18N
        panelGlass13.setPreferredSize(new java.awt.Dimension(44, 400));
        panelGlass13.setLayout(null);

        jLabel217.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel217.setText("1. Kesadaran");
        jLabel217.setName("jLabel217"); // NOI18N
        panelGlass13.add(jLabel217);
        jLabel217.setBounds(40, 90, 260, 23);

        NIP1.setEditable(false);
        NIP1.setHighlighter(null);
        NIP1.setName("NIP1"); // NOI18N
        panelGlass13.add(NIP1);
        NIP1.setBounds(80, 10, 94, 23);

        Menit1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Menit1.setName("Menit1"); // NOI18N
        Menit1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Menit1KeyPressed(evt);
            }
        });
        panelGlass13.add(Menit1);
        Menit1.setBounds(250, 40, 62, 23);

        jLabel223.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel223.setText("3. Aktivitas Motorik");
        jLabel223.setName("jLabel223"); // NOI18N
        panelGlass13.add(jLabel223);
        jLabel223.setBounds(40, 150, 260, 23);

        NilaiSteward3.setEditable(false);
        NilaiSteward3.setFocusTraversalPolicyProvider(true);
        NilaiSteward3.setName("NilaiSteward3"); // NOI18N
        panelGlass13.add(NilaiSteward3);
        NilaiSteward3.setBounds(730, 150, 60, 23);

        label15.setText("Dokter Anestesi :");
        label15.setName("label15"); // NOI18N
        label15.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass13.add(label15);
        label15.setBounds(390, 10, 99, 23);

        NilaiSteward2.setEditable(false);
        NilaiSteward2.setFocusTraversalPolicyProvider(true);
        NilaiSteward2.setName("NilaiSteward2"); // NOI18N
        panelGlass13.add(NilaiSteward2);
        NilaiSteward2.setBounds(730, 120, 60, 23);

        SkalaSteward2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Perlu Bantuan Bernafas", "Berusaha Bernafas", "Batuk / Menangis" }));
        SkalaSteward2.setName("SkalaSteward2"); // NOI18N
        SkalaSteward2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaSteward2ItemStateChanged(evt);
            }
        });
        SkalaSteward2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaSteward2KeyPressed(evt);
            }
        });
        panelGlass13.add(SkalaSteward2);
        SkalaSteward2.setBounds(310, 120, 310, 23);

        NilaiSteward1.setEditable(false);
        NilaiSteward1.setFocusTraversalPolicyProvider(true);
        NilaiSteward1.setName("NilaiSteward1"); // NOI18N
        panelGlass13.add(NilaiSteward1);
        NilaiSteward1.setBounds(730, 90, 60, 23);

        KdDokter1.setEditable(false);
        KdDokter1.setName("KdDokter1"); // NOI18N
        KdDokter1.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass13.add(KdDokter1);
        KdDokter1.setBounds(490, 10, 100, 23);

        scrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane3.setName("scrollPane3"); // NOI18N

        Keluar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Keluar1.setColumns(20);
        Keluar1.setRows(5);
        Keluar1.setName("Keluar1"); // NOI18N
        Keluar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Keluar1KeyPressed(evt);
            }
        });
        scrollPane3.setViewportView(Keluar1);

        panelGlass13.add(scrollPane3);
        scrollPane3.setBounds(40, 230, 755, 43);

        btnPetugas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugas1.setMnemonic('2');
        btnPetugas1.setToolTipText("ALt+2");
        btnPetugas1.setName("btnPetugas1"); // NOI18N
        btnPetugas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugas1ActionPerformed(evt);
            }
        });
        btnPetugas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugas1KeyPressed(evt);
            }
        });
        panelGlass13.add(btnPetugas1);
        btnPetugas1.setBounds(360, 10, 28, 23);

        jLabel222.setText("Nilai :");
        jLabel222.setName("jLabel222"); // NOI18N
        panelGlass13.add(jLabel222);
        jLabel222.setBounds(660, 120, 70, 23);

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel32.setText("Instruksi / Tindakan di ruang pemulihan (RR) :");
        jLabel32.setName("jLabel32"); // NOI18N
        panelGlass13.add(jLabel32);
        jLabel32.setBounds(20, 280, 280, 23);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Keluar :");
        jLabel33.setName("jLabel33"); // NOI18N
        panelGlass13.add(jLabel33);
        jLabel33.setBounds(20, 210, 80, 23);

        jSeparator3.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator3.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator3.setName("jSeparator3"); // NOI18N
        panelGlass13.add(jSeparator3);
        jSeparator3.setBounds(0, 210, 810, 1);

        jSeparator4.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator4.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator4.setName("jSeparator4"); // NOI18N
        panelGlass13.add(jSeparator4);
        jSeparator4.setBounds(0, 70, 810, 1);

        scrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane4.setName("scrollPane4"); // NOI18N

        Instruksi1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Instruksi1.setColumns(20);
        Instruksi1.setRows(5);
        Instruksi1.setName("Instruksi1"); // NOI18N
        Instruksi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Instruksi1KeyPressed(evt);
            }
        });
        scrollPane4.setViewportView(Instruksi1);

        panelGlass13.add(scrollPane4);
        scrollPane4.setBounds(40, 300, 755, 53);

        NamaPetugas1.setEditable(false);
        NamaPetugas1.setName("NamaPetugas1"); // NOI18N
        panelGlass13.add(NamaPetugas1);
        NamaPetugas1.setBounds(180, 10, 175, 23);

        BtnDokter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnDokter1.setMnemonic('2');
        BtnDokter1.setToolTipText("Alt+2");
        BtnDokter1.setName("BtnDokter1"); // NOI18N
        BtnDokter1.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnDokter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDokter1ActionPerformed(evt);
            }
        });
        BtnDokter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnDokter1KeyPressed(evt);
            }
        });
        panelGlass13.add(BtnDokter1);
        BtnDokter1.setBounds(780, 10, 28, 23);

        Tanggal1.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
        Tanggal1.setDisplayFormat("dd-MM-yyyy");
        Tanggal1.setName("Tanggal1"); // NOI18N
        Tanggal1.setOpaque(false);
        Tanggal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tanggal1KeyPressed(evt);
            }
        });
        panelGlass13.add(Tanggal1);
        Tanggal1.setBounds(80, 40, 90, 23);

        jLabel17.setText("Tanggal :");
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.setVerifyInputWhenFocusTarget(false);
        panelGlass13.add(jLabel17);
        jLabel17.setBounds(0, 40, 70, 23);

        jSeparator6.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator6.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator6.setName("jSeparator6"); // NOI18N
        panelGlass13.add(jSeparator6);
        jSeparator6.setBounds(0, 280, 810, 1);

        NilaiTotalSteward.setEditable(false);
        NilaiTotalSteward.setFocusTraversalPolicyProvider(true);
        NilaiTotalSteward.setName("NilaiTotalSteward"); // NOI18N
        panelGlass13.add(NilaiTotalSteward);
        NilaiTotalSteward.setBounds(730, 180, 60, 23);

        jLabel20.setText("Petugas :");
        jLabel20.setName("jLabel20"); // NOI18N
        panelGlass13.add(jLabel20);
        jLabel20.setBounds(0, 10, 70, 23);

        jLabel221.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel221.setText("2. Respirasi");
        jLabel221.setName("jLabel221"); // NOI18N
        panelGlass13.add(jLabel221);
        jLabel221.setBounds(40, 120, 260, 23);

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel58.setText("Kriteria :");
        jLabel58.setName("jLabel58"); // NOI18N
        panelGlass13.add(jLabel58);
        jLabel58.setBounds(20, 70, 80, 23);

        jLabel224.setText("Nilai :");
        jLabel224.setName("jLabel224"); // NOI18N
        panelGlass13.add(jLabel224);
        jLabel224.setBounds(660, 90, 70, 23);

        TingkatSkor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TingkatSkor.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        TingkatSkor.setToolTipText("");
        TingkatSkor.setName("TingkatSkor"); // NOI18N
        panelGlass13.add(TingkatSkor);
        TingkatSkor.setBounds(40, 180, 640, 23);

        ChkKejadian1.setBorder(null);
        ChkKejadian1.setSelected(true);
        ChkKejadian1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkKejadian1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkKejadian1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkKejadian1.setName("ChkKejadian1"); // NOI18N
        panelGlass13.add(ChkKejadian1);
        ChkKejadian1.setBounds(390, 40, 23, 23);

        Detik1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Detik1.setName("Detik1"); // NOI18N
        Detik1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Detik1KeyPressed(evt);
            }
        });
        panelGlass13.add(Detik1);
        Detik1.setBounds(320, 40, 62, 23);

        NmDokter1.setEditable(false);
        NmDokter1.setName("NmDokter1"); // NOI18N
        NmDokter1.setPreferredSize(new java.awt.Dimension(207, 23));
        panelGlass13.add(NmDokter1);
        NmDokter1.setBounds(600, 10, 175, 23);

        SkalaSteward3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak Bergerak", "Gerakan Tanpa Tujuan", "Gerakan Beraturan" }));
        SkalaSteward3.setName("SkalaSteward3"); // NOI18N
        SkalaSteward3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaSteward3ItemStateChanged(evt);
            }
        });
        SkalaSteward3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaSteward3KeyPressed(evt);
            }
        });
        panelGlass13.add(SkalaSteward3);
        SkalaSteward3.setBounds(310, 150, 310, 23);

        jLabel235.setText("Total :");
        jLabel235.setName("jLabel235"); // NOI18N
        panelGlass13.add(jLabel235);
        jLabel235.setBounds(660, 180, 70, 23);

        jLabel225.setText("Skala :");
        jLabel225.setName("jLabel225"); // NOI18N
        panelGlass13.add(jLabel225);
        jLabel225.setBounds(220, 150, 80, 23);

        jLabel226.setText("Skala :");
        jLabel226.setName("jLabel226"); // NOI18N
        panelGlass13.add(jLabel226);
        jLabel226.setBounds(220, 90, 80, 23);

        SkalaSteward1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Belum Respon", "Bangun Jika Dipanggil", "Sadar Penuh" }));
        SkalaSteward1.setName("SkalaSteward1"); // NOI18N
        SkalaSteward1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaSteward1ItemStateChanged(evt);
            }
        });
        SkalaSteward1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaSteward1KeyPressed(evt);
            }
        });
        panelGlass13.add(SkalaSteward1);
        SkalaSteward1.setBounds(310, 90, 310, 23);

        jLabel227.setText("Skala :");
        jLabel227.setName("jLabel227"); // NOI18N
        panelGlass13.add(jLabel227);
        jLabel227.setBounds(220, 120, 80, 23);

        jLabel228.setText("Nilai :");
        jLabel228.setName("jLabel228"); // NOI18N
        panelGlass13.add(jLabel228);
        jLabel228.setBounds(660, 150, 70, 23);

        Jam1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        Jam1.setName("Jam1"); // NOI18N
        Jam1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jam1KeyPressed(evt);
            }
        });
        panelGlass13.add(Jam1);
        Jam1.setBounds(180, 40, 62, 23);

        Scroll8.setViewportView(panelGlass13);

        PanelInput1.add(Scroll8, java.awt.BorderLayout.CENTER);

        internalFrame6.add(PanelInput1, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Steward Score", internalFrame6);

        internalFrame7.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame7.setName("internalFrame7"); // NOI18N
        internalFrame7.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll5.setName("Scroll5"); // NOI18N
        Scroll5.setOpaque(true);

        tbAldrette.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbAldrette.setComponentPopupMenu(PopupMenuAldrette);
        tbAldrette.setName("tbAldrette"); // NOI18N
        tbAldrette.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAldretteMouseClicked(evt);
            }
        });
        tbAldrette.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbAldretteKeyReleased(evt);
            }
        });
        Scroll5.setViewportView(tbAldrette);

        internalFrame7.add(Scroll5, java.awt.BorderLayout.CENTER);

        PanelInput2.setName("PanelInput2"); // NOI18N
        PanelInput2.setOpaque(false);
        PanelInput2.setPreferredSize(new java.awt.Dimension(192, 420));
        PanelInput2.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput2.setMnemonic('I');
        ChkInput2.setText(".: Input Data");
        ChkInput2.setToolTipText("Alt+I");
        ChkInput2.setBorderPainted(true);
        ChkInput2.setBorderPaintedFlat(true);
        ChkInput2.setFocusable(false);
        ChkInput2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput2.setName("ChkInput2"); // NOI18N
        ChkInput2.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInput2ActionPerformed(evt);
            }
        });
        PanelInput2.add(ChkInput2, java.awt.BorderLayout.PAGE_END);

        Scroll9.setName("Scroll9"); // NOI18N
        Scroll9.setOpaque(true);
        Scroll9.setPreferredSize(new java.awt.Dimension(46, 222));

        panelGlass14.setName("panelGlass14"); // NOI18N
        panelGlass14.setPreferredSize(new java.awt.Dimension(44, 420));
        panelGlass14.setLayout(null);

        jLabel22.setText("Tanggal :");
        jLabel22.setName("jLabel22"); // NOI18N
        jLabel22.setVerifyInputWhenFocusTarget(false);
        panelGlass14.add(jLabel22);
        jLabel22.setBounds(0, 40, 70, 23);

        TingkatSkor1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TingkatSkor1.setText("Pasien Bisa Dipindahkan Ke Ruang Perawatan Bila Skor Minimal 8");
        TingkatSkor1.setToolTipText("");
        TingkatSkor1.setName("TingkatSkor1"); // NOI18N
        panelGlass14.add(TingkatSkor1);
        TingkatSkor1.setBounds(40, 240, 640, 23);

        jLabel229.setText("Nilai :");
        jLabel229.setName("jLabel229"); // NOI18N
        panelGlass14.add(jLabel229);
        jLabel229.setBounds(680, 180, 50, 23);

        btnPetugas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugas2.setMnemonic('2');
        btnPetugas2.setToolTipText("ALt+2");
        btnPetugas2.setName("btnPetugas2"); // NOI18N
        btnPetugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugas2ActionPerformed(evt);
            }
        });
        btnPetugas2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugas2KeyPressed(evt);
            }
        });
        panelGlass14.add(btnPetugas2);
        btnPetugas2.setBounds(360, 10, 28, 23);

        NilaiAldrette5.setEditable(false);
        NilaiAldrette5.setFocusTraversalPolicyProvider(true);
        NilaiAldrette5.setName("NilaiAldrette5"); // NOI18N
        panelGlass14.add(NilaiAldrette5);
        NilaiAldrette5.setBounds(730, 210, 60, 23);

        scrollPane5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane5.setName("scrollPane5"); // NOI18N

        Instruksi2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Instruksi2.setColumns(20);
        Instruksi2.setRows(5);
        Instruksi2.setName("Instruksi2"); // NOI18N
        Instruksi2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Instruksi2KeyPressed(evt);
            }
        });
        scrollPane5.setViewportView(Instruksi2);

        panelGlass14.add(scrollPane5);
        scrollPane5.setBounds(40, 360, 755, 53);

        jLabel230.setText("Nilai :");
        jLabel230.setName("jLabel230"); // NOI18N
        panelGlass14.add(jLabel230);
        jLabel230.setBounds(680, 150, 50, 23);

        jSeparator7.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator7.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator7.setName("jSeparator7"); // NOI18N
        panelGlass14.add(jSeparator7);
        jSeparator7.setBounds(0, 340, 810, 1);

        jLabel231.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel231.setText("2. Respirasi");
        jLabel231.setName("jLabel231"); // NOI18N
        panelGlass14.add(jLabel231);
        jLabel231.setBounds(40, 120, 260, 23);

        jLabel232.setText("Skala :");
        jLabel232.setName("jLabel232"); // NOI18N
        panelGlass14.add(jLabel232);
        jLabel232.setBounds(250, 210, 80, 23);

        NilaiAldrette1.setEditable(false);
        NilaiAldrette1.setFocusTraversalPolicyProvider(true);
        NilaiAldrette1.setName("NilaiAldrette1"); // NOI18N
        panelGlass14.add(NilaiAldrette1);
        NilaiAldrette1.setBounds(730, 90, 60, 23);

        jLabel233.setText("Skala :");
        jLabel233.setName("jLabel233"); // NOI18N
        panelGlass14.add(jLabel233);
        jLabel233.setBounds(250, 180, 80, 23);

        Tanggal2.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
        Tanggal2.setDisplayFormat("dd-MM-yyyy");
        Tanggal2.setName("Tanggal2"); // NOI18N
        Tanggal2.setOpaque(false);
        Tanggal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tanggal2KeyPressed(evt);
            }
        });
        panelGlass14.add(Tanggal2);
        Tanggal2.setBounds(80, 40, 90, 23);

        jLabel234.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel234.setText("4. Kesadaran");
        jLabel234.setName("jLabel234"); // NOI18N
        panelGlass14.add(jLabel234);
        jLabel234.setBounds(40, 180, 260, 23);

        jLabel23.setText("Petugas :");
        jLabel23.setName("jLabel23"); // NOI18N
        panelGlass14.add(jLabel23);
        jLabel23.setBounds(0, 10, 70, 23);

        jLabel236.setText("Total :");
        jLabel236.setName("jLabel236"); // NOI18N
        panelGlass14.add(jLabel236);
        jLabel236.setBounds(680, 240, 50, 23);

        jLabel237.setText("Nilai :");
        jLabel237.setName("jLabel237"); // NOI18N
        panelGlass14.add(jLabel237);
        jLabel237.setBounds(680, 210, 50, 23);

        jLabel238.setText("Skala :");
        jLabel238.setName("jLabel238"); // NOI18N
        panelGlass14.add(jLabel238);
        jLabel238.setBounds(250, 120, 80, 23);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Keluar :");
        jLabel34.setName("jLabel34"); // NOI18N
        panelGlass14.add(jLabel34);
        jLabel34.setBounds(20, 270, 80, 23);

        NilaiAldrette3.setEditable(false);
        NilaiAldrette3.setFocusTraversalPolicyProvider(true);
        NilaiAldrette3.setName("NilaiAldrette3"); // NOI18N
        panelGlass14.add(NilaiAldrette3);
        NilaiAldrette3.setBounds(730, 150, 60, 23);

        Detik2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Detik2.setName("Detik2"); // NOI18N
        Detik2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Detik2KeyPressed(evt);
            }
        });
        panelGlass14.add(Detik2);
        Detik2.setBounds(320, 40, 62, 23);

        NamaPetugas2.setEditable(false);
        NamaPetugas2.setName("NamaPetugas2"); // NOI18N
        panelGlass14.add(NamaPetugas2);
        NamaPetugas2.setBounds(180, 10, 175, 23);

        NilaiAldrette4.setEditable(false);
        NilaiAldrette4.setFocusTraversalPolicyProvider(true);
        NilaiAldrette4.setName("NilaiAldrette4"); // NOI18N
        panelGlass14.add(NilaiAldrette4);
        NilaiAldrette4.setBounds(730, 180, 60, 23);

        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel59.setText("Kriteria :");
        jLabel59.setName("jLabel59"); // NOI18N
        panelGlass14.add(jLabel59);
        jLabel59.setBounds(20, 70, 80, 23);

        NilaiAldrette2.setEditable(false);
        NilaiAldrette2.setFocusTraversalPolicyProvider(true);
        NilaiAldrette2.setName("NilaiAldrette2"); // NOI18N
        panelGlass14.add(NilaiAldrette2);
        NilaiAldrette2.setBounds(730, 120, 60, 23);

        NilaiTotalAldrette.setEditable(false);
        NilaiTotalAldrette.setFocusTraversalPolicyProvider(true);
        NilaiTotalAldrette.setName("NilaiTotalAldrette"); // NOI18N
        panelGlass14.add(NilaiTotalAldrette);
        NilaiTotalAldrette.setBounds(730, 240, 60, 23);

        jSeparator8.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator8.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator8.setName("jSeparator8"); // NOI18N
        panelGlass14.add(jSeparator8);
        jSeparator8.setBounds(0, 270, 810, 1);

        SkalaAldrette2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Apnea Atau Napas Tidak Adekuat", "Sesak Atau Pernapasan Sedikit Terbatas", "Sanggup Bernafas Dalam Serta Disuruh Batuk" }));
        SkalaAldrette2.setName("SkalaAldrette2"); // NOI18N
        SkalaAldrette2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaAldrette2ItemStateChanged(evt);
            }
        });
        SkalaAldrette2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaAldrette2KeyPressed(evt);
            }
        });
        panelGlass14.add(SkalaAldrette2);
        SkalaAldrette2.setBounds(340, 120, 330, 23);

        BtnDokter2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnDokter2.setMnemonic('2');
        BtnDokter2.setToolTipText("Alt+2");
        BtnDokter2.setName("BtnDokter2"); // NOI18N
        BtnDokter2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnDokter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDokter2ActionPerformed(evt);
            }
        });
        BtnDokter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnDokter2KeyPressed(evt);
            }
        });
        panelGlass14.add(BtnDokter2);
        BtnDokter2.setBounds(770, 10, 28, 23);

        NIP2.setEditable(false);
        NIP2.setHighlighter(null);
        NIP2.setName("NIP2"); // NOI18N
        panelGlass14.add(NIP2);
        NIP2.setBounds(80, 10, 94, 23);

        jLabel239.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel239.setText("1. Aktivitas");
        jLabel239.setName("jLabel239"); // NOI18N
        panelGlass14.add(jLabel239);
        jLabel239.setBounds(40, 90, 260, 23);

        jLabel240.setText("Nilai :");
        jLabel240.setName("jLabel240"); // NOI18N
        panelGlass14.add(jLabel240);
        jLabel240.setBounds(680, 90, 50, 23);

        jLabel241.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel241.setText("5. Warna Kulit");
        jLabel241.setName("jLabel241"); // NOI18N
        panelGlass14.add(jLabel241);
        jLabel241.setBounds(40, 210, 260, 23);

        jLabel242.setText("Skala :");
        jLabel242.setName("jLabel242"); // NOI18N
        panelGlass14.add(jLabel242);
        jLabel242.setBounds(250, 150, 80, 23);

        jSeparator9.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator9.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator9.setName("jSeparator9"); // NOI18N
        panelGlass14.add(jSeparator9);
        jSeparator9.setBounds(0, 70, 810, 1);

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("Instruksi / Tindakan Di Ruang Pemulihan (RR) :");
        jLabel35.setName("jLabel35"); // NOI18N
        panelGlass14.add(jLabel35);
        jLabel35.setBounds(20, 340, 280, 23);

        NmDokter2.setEditable(false);
        NmDokter2.setName("NmDokter2"); // NOI18N
        NmDokter2.setPreferredSize(new java.awt.Dimension(207, 23));
        panelGlass14.add(NmDokter2);
        NmDokter2.setBounds(590, 10, 175, 23);

        scrollPane6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane6.setName("scrollPane6"); // NOI18N

        Keluar2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Keluar2.setColumns(20);
        Keluar2.setRows(5);
        Keluar2.setName("Keluar2"); // NOI18N
        Keluar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Keluar2KeyPressed(evt);
            }
        });
        scrollPane6.setViewportView(Keluar2);

        panelGlass14.add(scrollPane6);
        scrollPane6.setBounds(40, 290, 755, 43);

        jLabel243.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel243.setText("3. Tekanan Darah");
        jLabel243.setName("jLabel243"); // NOI18N
        panelGlass14.add(jLabel243);
        jLabel243.setBounds(40, 150, 260, 23);

        Jam2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        Jam2.setName("Jam2"); // NOI18N
        Jam2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jam2KeyPressed(evt);
            }
        });
        panelGlass14.add(Jam2);
        Jam2.setBounds(180, 40, 62, 23);

        KdDokter2.setEditable(false);
        KdDokter2.setName("KdDokter2"); // NOI18N
        KdDokter2.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass14.add(KdDokter2);
        KdDokter2.setBounds(480, 10, 100, 23);

        SkalaAldrette3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "± 50% Tekanan Darah Pra Anestesi", "± 20% - 50% Tekanan Darah Pra Anestesi", "± 20% Tekanan Darah Pra Anestesi" }));
        SkalaAldrette3.setName("SkalaAldrette3"); // NOI18N
        SkalaAldrette3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaAldrette3ItemStateChanged(evt);
            }
        });
        SkalaAldrette3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaAldrette3KeyPressed(evt);
            }
        });
        panelGlass14.add(SkalaAldrette3);
        SkalaAldrette3.setBounds(340, 150, 330, 23);

        Menit2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Menit2.setName("Menit2"); // NOI18N
        Menit2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Menit2KeyPressed(evt);
            }
        });
        panelGlass14.add(Menit2);
        Menit2.setBounds(250, 40, 62, 23);

        label16.setText("Dokter Anestesi :");
        label16.setName("label16"); // NOI18N
        label16.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass14.add(label16);
        label16.setBounds(380, 10, 99, 23);

        SkalaAldrette4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak Ada Respon", "Respon Terhadap Panggilan", "Sadar Penuh" }));
        SkalaAldrette4.setName("SkalaAldrette4"); // NOI18N
        SkalaAldrette4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaAldrette4ItemStateChanged(evt);
            }
        });
        SkalaAldrette4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaAldrette4KeyPressed(evt);
            }
        });
        panelGlass14.add(SkalaAldrette4);
        SkalaAldrette4.setBounds(340, 180, 330, 23);

        jLabel244.setText("Nilai :");
        jLabel244.setName("jLabel244"); // NOI18N
        panelGlass14.add(jLabel244);
        jLabel244.setBounds(680, 120, 50, 23);

        SkalaAldrette5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cianosis", "Pucat", "Kemerahan / Normal" }));
        SkalaAldrette5.setName("SkalaAldrette5"); // NOI18N
        SkalaAldrette5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaAldrette5ItemStateChanged(evt);
            }
        });
        SkalaAldrette5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaAldrette5KeyPressed(evt);
            }
        });
        panelGlass14.add(SkalaAldrette5);
        SkalaAldrette5.setBounds(340, 210, 330, 23);

        SkalaAldrette1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak Sanggup Menggerakan Satupun Anggota Gerak", "Sanggup Gerak 2 Anggota Tubuh", "Sanggup Gerak 4 Anggota Tubuh" }));
        SkalaAldrette1.setName("SkalaAldrette1"); // NOI18N
        SkalaAldrette1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaAldrette1ItemStateChanged(evt);
            }
        });
        SkalaAldrette1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaAldrette1KeyPressed(evt);
            }
        });
        panelGlass14.add(SkalaAldrette1);
        SkalaAldrette1.setBounds(340, 90, 330, 23);

        ChkKejadian2.setBorder(null);
        ChkKejadian2.setSelected(true);
        ChkKejadian2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkKejadian2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkKejadian2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkKejadian2.setName("ChkKejadian2"); // NOI18N
        panelGlass14.add(ChkKejadian2);
        ChkKejadian2.setBounds(390, 40, 23, 23);

        jLabel245.setText("Skala :");
        jLabel245.setName("jLabel245"); // NOI18N
        panelGlass14.add(jLabel245);
        jLabel245.setBounds(250, 90, 80, 23);

        Scroll9.setViewportView(panelGlass14);

        PanelInput2.add(Scroll9, java.awt.BorderLayout.CENTER);

        internalFrame7.add(PanelInput2, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Aldrette Score", internalFrame7);

        internalFrame8.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame8.setName("internalFrame8"); // NOI18N
        internalFrame8.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll6.setName("Scroll6"); // NOI18N
        Scroll6.setOpaque(true);

        tbPadss.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPadss.setComponentPopupMenu(PopupMenuPadss);
        tbPadss.setName("tbPadss"); // NOI18N
        tbPadss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPadssMouseClicked(evt);
            }
        });
        tbPadss.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPadssKeyReleased(evt);
            }
        });
        Scroll6.setViewportView(tbPadss);

        internalFrame8.add(Scroll6, java.awt.BorderLayout.CENTER);

        PanelInput3.setName("PanelInput3"); // NOI18N
        PanelInput3.setOpaque(false);
        PanelInput3.setPreferredSize(new java.awt.Dimension(192, 420));
        PanelInput3.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput3.setMnemonic('I');
        ChkInput3.setText(".: Input Data");
        ChkInput3.setToolTipText("Alt+I");
        ChkInput3.setBorderPainted(true);
        ChkInput3.setBorderPaintedFlat(true);
        ChkInput3.setFocusable(false);
        ChkInput3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput3.setName("ChkInput3"); // NOI18N
        ChkInput3.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInput3ActionPerformed(evt);
            }
        });
        PanelInput3.add(ChkInput3, java.awt.BorderLayout.PAGE_END);

        Scroll10.setName("Scroll10"); // NOI18N
        Scroll10.setOpaque(true);
        Scroll10.setPreferredSize(new java.awt.Dimension(46, 222));

        panelGlass15.setName("panelGlass15"); // NOI18N
        panelGlass15.setPreferredSize(new java.awt.Dimension(44, 420));
        panelGlass15.setLayout(null);

        NilaiPadss4.setEditable(false);
        NilaiPadss4.setFocusTraversalPolicyProvider(true);
        NilaiPadss4.setName("NilaiPadss4"); // NOI18N
        panelGlass15.add(NilaiPadss4);
        NilaiPadss4.setBounds(730, 180, 60, 23);

        NilaiPadss3.setEditable(false);
        NilaiPadss3.setFocusTraversalPolicyProvider(true);
        NilaiPadss3.setName("NilaiPadss3"); // NOI18N
        panelGlass15.add(NilaiPadss3);
        NilaiPadss3.setBounds(730, 150, 60, 23);

        SkalaPadss1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TD & N dalam >40% nilai pre-operasi", "TD & N dalam 20-40& nilai pre-operasi", "TD & N dalam 20% nilai pre-operasi" }));
        SkalaPadss1.setName("SkalaPadss1"); // NOI18N
        SkalaPadss1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaPadss1ItemStateChanged(evt);
            }
        });
        SkalaPadss1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaPadss1KeyPressed(evt);
            }
        });
        panelGlass15.add(SkalaPadss1);
        SkalaPadss1.setBounds(340, 90, 330, 23);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Instruksi / Tindakan Di Ruang Pemulihan (RR) :");
        jLabel36.setName("jLabel36"); // NOI18N
        panelGlass15.add(jLabel36);
        jLabel36.setBounds(20, 340, 280, 23);

        label17.setText("Dokter Anestesi :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass15.add(label17);
        label17.setBounds(390, 10, 99, 23);

        jLabel25.setText("Tanggal :");
        jLabel25.setName("jLabel25"); // NOI18N
        jLabel25.setVerifyInputWhenFocusTarget(false);
        panelGlass15.add(jLabel25);
        jLabel25.setBounds(0, 40, 70, 23);

        TingkatSkor2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TingkatSkor2.setText("Pasien Bisa Dipindahkan Ke Ruang Perawatan Bila Skor Minimal 8");
        TingkatSkor2.setToolTipText("");
        TingkatSkor2.setName("TingkatSkor2"); // NOI18N
        panelGlass15.add(TingkatSkor2);
        TingkatSkor2.setBounds(40, 240, 640, 23);

        jLabel246.setText("Nilai :");
        jLabel246.setName("jLabel246"); // NOI18N
        panelGlass15.add(jLabel246);
        jLabel246.setBounds(670, 180, 50, 23);

        jLabel247.setText("Total :");
        jLabel247.setName("jLabel247"); // NOI18N
        panelGlass15.add(jLabel247);
        jLabel247.setBounds(670, 240, 50, 23);

        jLabel248.setText("Skala :");
        jLabel248.setName("jLabel248"); // NOI18N
        panelGlass15.add(jLabel248);
        jLabel248.setBounds(250, 120, 80, 23);

        jLabel249.setText("Skala :");
        jLabel249.setName("jLabel249"); // NOI18N
        panelGlass15.add(jLabel249);
        jLabel249.setBounds(250, 210, 80, 23);

        SkalaPadss3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Berat", "Sedang", "Minimal" }));
        SkalaPadss3.setName("SkalaPadss3"); // NOI18N
        SkalaPadss3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaPadss3ItemStateChanged(evt);
            }
        });
        SkalaPadss3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaPadss3KeyPressed(evt);
            }
        });
        panelGlass15.add(SkalaPadss3);
        SkalaPadss3.setBounds(340, 150, 330, 23);

        NmDokter3.setEditable(false);
        NmDokter3.setName("NmDokter3"); // NOI18N
        NmDokter3.setPreferredSize(new java.awt.Dimension(207, 23));
        panelGlass15.add(NmDokter3);
        NmDokter3.setBounds(600, 10, 175, 23);

        jLabel250.setText("Skala :");
        jLabel250.setName("jLabel250"); // NOI18N
        panelGlass15.add(jLabel250);
        jLabel250.setBounds(250, 150, 80, 23);

        jLabel251.setText("Nilai :");
        jLabel251.setName("jLabel251"); // NOI18N
        panelGlass15.add(jLabel251);
        jLabel251.setBounds(670, 210, 50, 23);

        NamaPetugas3.setEditable(false);
        NamaPetugas3.setName("NamaPetugas3"); // NOI18N
        panelGlass15.add(NamaPetugas3);
        NamaPetugas3.setBounds(180, 10, 175, 23);

        jLabel252.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel252.setText("5. Intake dan Output");
        jLabel252.setName("jLabel252"); // NOI18N
        panelGlass15.add(jLabel252);
        jLabel252.setBounds(40, 210, 260, 23);

        jLabel26.setText("Petugas :");
        jLabel26.setName("jLabel26"); // NOI18N
        panelGlass15.add(jLabel26);
        jLabel26.setBounds(0, 10, 70, 23);

        NIP3.setEditable(false);
        NIP3.setHighlighter(null);
        NIP3.setName("NIP3"); // NOI18N
        panelGlass15.add(NIP3);
        NIP3.setBounds(80, 10, 94, 23);

        jLabel253.setText("Nilai :");
        jLabel253.setName("jLabel253"); // NOI18N
        panelGlass15.add(jLabel253);
        jLabel253.setBounds(670, 150, 50, 23);

        jLabel254.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel254.setText("4. Pendarahan Bedah");
        jLabel254.setName("jLabel254"); // NOI18N
        panelGlass15.add(jLabel254);
        jLabel254.setBounds(40, 180, 260, 23);

        jLabel255.setText("Skala :");
        jLabel255.setName("jLabel255"); // NOI18N
        panelGlass15.add(jLabel255);
        jLabel255.setBounds(250, 180, 80, 23);

        jLabel256.setText("Nilai :");
        jLabel256.setName("jLabel256"); // NOI18N
        panelGlass15.add(jLabel256);
        jLabel256.setBounds(670, 120, 50, 23);

        jSeparator10.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator10.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator10.setName("jSeparator10"); // NOI18N
        panelGlass15.add(jSeparator10);
        jSeparator10.setBounds(0, 70, 810, 1);

        BtnDokter3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnDokter3.setMnemonic('2');
        BtnDokter3.setToolTipText("Alt+2");
        BtnDokter3.setName("BtnDokter3"); // NOI18N
        BtnDokter3.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnDokter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDokter3ActionPerformed(evt);
            }
        });
        BtnDokter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnDokter3KeyPressed(evt);
            }
        });
        panelGlass15.add(BtnDokter3);
        BtnDokter3.setBounds(780, 10, 28, 23);

        NilaiPadss1.setEditable(false);
        NilaiPadss1.setFocusTraversalPolicyProvider(true);
        NilaiPadss1.setName("NilaiPadss1"); // NOI18N
        panelGlass15.add(NilaiPadss1);
        NilaiPadss1.setBounds(730, 90, 60, 23);

        Menit3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Menit3.setName("Menit3"); // NOI18N
        Menit3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Menit3KeyPressed(evt);
            }
        });
        panelGlass15.add(Menit3);
        Menit3.setBounds(250, 40, 62, 23);

        KdDokter3.setEditable(false);
        KdDokter3.setName("KdDokter3"); // NOI18N
        KdDokter3.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass15.add(KdDokter3);
        KdDokter3.setBounds(490, 10, 100, 23);

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel60.setText("Kriteria :");
        jLabel60.setName("jLabel60"); // NOI18N
        panelGlass15.add(jLabel60);
        jLabel60.setBounds(20, 70, 80, 23);

        jLabel257.setText("Skala :");
        jLabel257.setName("jLabel257"); // NOI18N
        panelGlass15.add(jLabel257);
        jLabel257.setBounds(250, 90, 80, 23);

        NilaiPadss5.setEditable(false);
        NilaiPadss5.setFocusTraversalPolicyProvider(true);
        NilaiPadss5.setName("NilaiPadss5"); // NOI18N
        panelGlass15.add(NilaiPadss5);
        NilaiPadss5.setBounds(730, 210, 60, 23);

        jLabel258.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel258.setText("3. Nyeri, Mual, dan Muntah");
        jLabel258.setName("jLabel258"); // NOI18N
        panelGlass15.add(jLabel258);
        jLabel258.setBounds(40, 150, 260, 23);

        Tanggal3.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "14-04-2026" }));
        Tanggal3.setDisplayFormat("dd-MM-yyyy");
        Tanggal3.setName("Tanggal3"); // NOI18N
        Tanggal3.setOpaque(false);
        Tanggal3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tanggal3KeyPressed(evt);
            }
        });
        panelGlass15.add(Tanggal3);
        Tanggal3.setBounds(80, 40, 90, 23);

        scrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane7.setName("scrollPane7"); // NOI18N

        Keluar3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Keluar3.setColumns(20);
        Keluar3.setRows(5);
        Keluar3.setName("Keluar3"); // NOI18N
        Keluar3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Keluar3KeyPressed(evt);
            }
        });
        scrollPane7.setViewportView(Keluar3);

        panelGlass15.add(scrollPane7);
        scrollPane7.setBounds(40, 290, 755, 43);

        ChkKejadian3.setBorder(null);
        ChkKejadian3.setSelected(true);
        ChkKejadian3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkKejadian3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkKejadian3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ChkKejadian3.setName("ChkKejadian3"); // NOI18N
        panelGlass15.add(ChkKejadian3);
        ChkKejadian3.setBounds(390, 40, 23, 23);

        jLabel259.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel259.setText("1. Tanda-tanda vital");
        jLabel259.setName("jLabel259"); // NOI18N
        panelGlass15.add(jLabel259);
        jLabel259.setBounds(40, 90, 260, 23);

        jLabel260.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel260.setText("2. Tingkat aktivitas");
        jLabel260.setName("jLabel260"); // NOI18N
        panelGlass15.add(jLabel260);
        jLabel260.setBounds(40, 120, 260, 23);

        scrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane8.setName("scrollPane8"); // NOI18N

        Instruksi3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Instruksi3.setColumns(20);
        Instruksi3.setRows(5);
        Instruksi3.setName("Instruksi3"); // NOI18N
        Instruksi3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Instruksi3KeyPressed(evt);
            }
        });
        scrollPane8.setViewportView(Instruksi3);

        panelGlass15.add(scrollPane8);
        scrollPane8.setBounds(40, 360, 755, 53);

        NilaiPadss2.setEditable(false);
        NilaiPadss2.setFocusTraversalPolicyProvider(true);
        NilaiPadss2.setName("NilaiPadss2"); // NOI18N
        panelGlass15.add(NilaiPadss2);
        NilaiPadss2.setBounds(730, 120, 60, 23);

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("Keluar :");
        jLabel37.setName("jLabel37"); // NOI18N
        panelGlass15.add(jLabel37);
        jLabel37.setBounds(20, 270, 80, 23);

        Detik3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        Detik3.setName("Detik3"); // NOI18N
        Detik3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Detik3KeyPressed(evt);
            }
        });
        panelGlass15.add(Detik3);
        Detik3.setBounds(320, 40, 62, 23);

        SkalaPadss5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak keduanya", "Minum atau BAK", "Minum dan BAK" }));
        SkalaPadss5.setName("SkalaPadss5"); // NOI18N
        SkalaPadss5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaPadss5ItemStateChanged(evt);
            }
        });
        SkalaPadss5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaPadss5KeyPressed(evt);
            }
        });
        panelGlass15.add(SkalaPadss5);
        SkalaPadss5.setBounds(340, 210, 330, 23);

        SkalaPadss4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Berat : diperlukan >3x ganti balut", "Sedang : diperlukan ganti balut 2x", "Minimal : tidak perlu ganti balut" }));
        SkalaPadss4.setName("SkalaPadss4"); // NOI18N
        SkalaPadss4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaPadss4ItemStateChanged(evt);
            }
        });
        SkalaPadss4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaPadss4KeyPressed(evt);
            }
        });
        panelGlass15.add(SkalaPadss4);
        SkalaPadss4.setBounds(340, 180, 330, 23);

        jLabel261.setText("Nilai :");
        jLabel261.setName("jLabel261"); // NOI18N
        panelGlass15.add(jLabel261);
        jLabel261.setBounds(670, 90, 50, 23);

        btnPetugas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugas3.setMnemonic('2');
        btnPetugas3.setToolTipText("ALt+2");
        btnPetugas3.setName("btnPetugas3"); // NOI18N
        btnPetugas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugas3ActionPerformed(evt);
            }
        });
        btnPetugas3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugas3KeyPressed(evt);
            }
        });
        panelGlass15.add(btnPetugas3);
        btnPetugas3.setBounds(360, 10, 28, 23);

        jSeparator11.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator11.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator11.setName("jSeparator11"); // NOI18N
        panelGlass15.add(jSeparator11);
        jSeparator11.setBounds(0, 340, 810, 1);

        jSeparator12.setBackground(new java.awt.Color(239, 244, 234));
        jSeparator12.setForeground(new java.awt.Color(239, 244, 234));
        jSeparator12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)));
        jSeparator12.setName("jSeparator12"); // NOI18N
        panelGlass15.add(jSeparator12);
        jSeparator12.setBounds(0, 270, 810, 1);

        Jam3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        Jam3.setName("Jam3"); // NOI18N
        Jam3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Jam3KeyPressed(evt);
            }
        });
        panelGlass15.add(Jam3);
        Jam3.setBounds(180, 40, 62, 23);

        NilaiTotalPadss.setEditable(false);
        NilaiTotalPadss.setFocusTraversalPolicyProvider(true);
        NilaiTotalPadss.setName("NilaiTotalPadss"); // NOI18N
        panelGlass15.add(NilaiTotalPadss);
        NilaiTotalPadss.setBounds(730, 240, 60, 23);

        SkalaPadss2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak mampu berjalan", "Perlu bantuan", "Berjalan stabil, tidak lemas" }));
        SkalaPadss2.setName("SkalaPadss2"); // NOI18N
        SkalaPadss2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SkalaPadss2ItemStateChanged(evt);
            }
        });
        SkalaPadss2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SkalaPadss2KeyPressed(evt);
            }
        });
        panelGlass15.add(SkalaPadss2);
        SkalaPadss2.setBounds(340, 120, 330, 23);

        Scroll10.setViewportView(panelGlass15);

        PanelInput3.add(Scroll10, java.awt.BorderLayout.CENTER);

        internalFrame8.add(PanelInput3, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Post Anesthesia Discharge Scoring System", internalFrame8);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(260, 43));
        FormInput.setLayout(null);

        jLabel3.setText("No.Rawat : ");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(10, 600, 70, 23);

        TNoRw.setHighlighter(null);
        TNoRw.setMargin(new java.awt.Insets(1, 4, 1, 4));
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TNoRwMouseClicked(evt);
            }
        });
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(10, 10, 120, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setMargin(new java.awt.Insets(1, 4, 1, 4));
        TNoRM.setMinimumSize(new java.awt.Dimension(58, 24));
        TNoRM.setName("TNoRM"); // NOI18N
        FormInput.add(TNoRM);
        TNoRM.setBounds(133, 10, 80, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setMargin(new java.awt.Insets(1, 4, 1, 4));
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(216, 10, 340, 23);

        jLabel8.setText("Tgl.Lahir :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(580, 10, 60, 23);

        TglLahir.setHighlighter(null);
        TglLahir.setName("TglLahir"); // NOI18N
        TglLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TglLahirActionPerformed(evt);
            }
        });
        FormInput.add(TglLahir);
        TglLahir.setBounds(650, 10, 100, 24);

        internalFrame1.add(FormInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            isRawat();
        } else {
//            if (TabRawat.getSelectedIndex() == 0) {
//                Valid.pindah(evt, DTPTgl, KdDok);
//            } else if (TabRawat.getSelectedIndex() == 1) {
//                Valid.pindah(evt, DTPTgl, kdptg);
//            } else if (TabRawat.getSelectedIndex() == 2) {
//                Valid.pindah(evt, DTPTgl, KdDok2);
//            } else if (TabRawat.getSelectedIndex() == 3) {
//                Valid.pindah(evt, DTPTgl, KdPeg);
//            } else if (TabRawat.getSelectedIndex() == 4) {
//                Valid.pindah(evt, DTPTgl, TTinggi_uteri);
//            }
        }
}//GEN-LAST:event_TNoRwKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (TNoRw.getText().trim().equals("") || TPasien.getText().trim().equals("")) {
            Valid.textKosong(TNoRw, "No.Rawat");
        } else {
            simpan();
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
        } else {
//            if (TabRawat.getSelectedIndex() == 0) {
//                Valid.pindah(evt, BtnSeekDokter, BtnBatal);
//            } else if (TabRawat.getSelectedIndex() == 1) {
//                Valid.pindah(evt, BtnSeekPetugas, BtnBatal);
//            } else if (TabRawat.getSelectedIndex() == 2) {
//                Valid.pindah(evt, BtnSeekPetugas2, BtnBatal);
//            } else if (TabRawat.getSelectedIndex() == 3) {
//                Valid.pindah(evt, TEvaluasi, BtnBatal);
//            } else if (TabRawat.getSelectedIndex() == 4) {
//                Valid.pindah(evt, cmbFeto, BtnBatal);
//            }
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnBatalActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnSimpan, BtnHapus);
        }
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                hapusSkorBromage();
                break;
            case 1:
                hapusSkorSteward();
                break;
            case 2:
                hapusSkorAldrette();
                break;
            case 3:
                hapusSkorPadss();
                break;
            default:
                break;
        }
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnHapusActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        petugas.dispose();
        dokter.dispose();
        pasien.dispose();
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnKeluarActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnAll, TCari);
        }
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        TampilkanData();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnAllActionPerformed(null);
        } else {
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TampilkanData();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            BtnCari.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnKeluar.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            switch (TabRawat.getSelectedIndex()) {
                case 0:
                    tbBromage.requestFocus();
                    break;
                case 1:
                    tbSteward.requestFocus();
                    break;
                case 2:
                    tbAldrette.requestFocus();
                    break;
                case 3:
                    tbPadss.requestFocus();
                    break;
                default:
                    break;
            }
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        TampilkanData();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnCariActionPerformed(null);
        } else {
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void TabRawatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabRawatMouseClicked
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                BtnSimpan.setEnabled(akses.getskor_bromage_pasca_anestesi());
                BtnHapus.setEnabled(akses.getskor_bromage_pasca_anestesi());
                BtnEdit.setEnabled(akses.getskor_bromage_pasca_anestesi());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanSkorBromage();
                break;
            case 1:
                BtnSimpan.setEnabled(akses.getskor_steward_pasca_anestesi());
                BtnHapus.setEnabled(akses.getskor_steward_pasca_anestesi());
                BtnEdit.setEnabled(akses.getskor_steward_pasca_anestesi());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanSkorSteward();
                break;
            case 2:
                BtnSimpan.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                BtnHapus.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                BtnEdit.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanSkorAldrette();
                break;
            case 3:
                BtnSimpan.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                BtnHapus.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                BtnEdit.setEnabled(akses.getskor_aldrette_pasca_anestesi());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanSkorPadss();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_TabRawatMouseClicked

private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
    isForm();
}//GEN-LAST:event_ChkInputActionPerformed

private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
    if (TNoRw.getText().trim().equals("") || TPasien.getText().trim().equals("")) {
        Valid.textKosong(TNoRw, "No.Rawat");
        return;
    }
    
    switch (TabRawat.getSelectedIndex()) {
        case 0:
            gantiSkorBromage();
            break;
        case 1:
             gantiSkorSteward();
            break;
        case 2:
             gantiSkorAldrette();
            break;
        case 3:
             gantiSkorPadss();
            break;
        default:
            break;
    }
}//GEN-LAST:event_BtnEditActionPerformed

private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
        BtnEditActionPerformed(null);
    } else {
        Valid.pindah(evt, BtnHapus, BtnAll);
    }
}//GEN-LAST:event_BtnEditKeyPressed

    private void tbBromageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBromageMouseClicked
        if (tabModeBromage.getRowCount() != 0) {
            try {
                getDataBromage();
            } catch (java.lang.NullPointerException e) {
            }

        }
    }//GEN-LAST:event_tbBromageMouseClicked

    private void tbStewardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStewardMouseClicked
        // TODO add your handling code here:
        if (tabModeSteward.getRowCount() != 0) {
            try {
                getDataSteward();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbStewardMouseClicked

    private void ChkInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput1ActionPerformed
        // TODO add your handling code here:
        isForm2();
    }//GEN-LAST:event_ChkInput1ActionPerformed

    private void tbBromageKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBromageKeyReleased
        if (tabModeBromage.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataBromage();
                } catch (java.lang.NullPointerException e) {
                }
            }

        }
    }//GEN-LAST:event_tbBromageKeyReleased

    private void tbStewardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbStewardKeyReleased
        // TODO add your handling code here:
        if (tabModeSteward.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataSteward();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbStewardKeyReleased

    private void TNoRwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TNoRwMouseClicked
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(internalFrame1);
                win.toFront();
            }
        }
    }//GEN-LAST:event_TNoRwMouseClicked

    private void tbAldretteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAldretteMouseClicked
        if (tabModeAldrette.getRowCount() != 0) {
            try {
                getDataAldrette();
            } catch (java.lang.NullPointerException e) {
            }

        }
    }//GEN-LAST:event_tbAldretteMouseClicked

    private void tbAldretteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAldretteKeyReleased
        if (tabModeAldrette.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataAldrette();
                } catch (java.lang.NullPointerException e) {
                }
            }

        }
    }//GEN-LAST:event_tbAldretteKeyReleased

    private void ChkInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput2ActionPerformed
        isForm3();
    }//GEN-LAST:event_ChkInput2ActionPerformed

    private void tbPadssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPadssMouseClicked
        if (tabModePadss.getRowCount() != 0) {
            try {
                getDataPadss();
            } catch (java.lang.NullPointerException e) {
            }

        }
    }//GEN-LAST:event_tbPadssMouseClicked

    private void tbPadssKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPadssKeyReleased
        if (tabModePadss.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataPadss();
                } catch (java.lang.NullPointerException e) {
                }
            }

        }
    }//GEN-LAST:event_tbPadssKeyReleased

    private void ChkInput3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput3ActionPerformed
        isForm4();
    }//GEN-LAST:event_ChkInput3ActionPerformed

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void BtnDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokterKeyPressed
        Valid.pindah(evt,btnPetugas,BtnSimpan);
    }//GEN-LAST:event_BtnDokterKeyPressed

    private void KeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeluarKeyPressed
        Valid.pindah2(evt,Keluar,Instruksi);
    }//GEN-LAST:event_KeluarKeyPressed

    private void InstruksiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InstruksiKeyPressed
        Valid.pindah2(evt,Keluar,BtnSimpan);
    }//GEN-LAST:event_InstruksiKeyPressed

    private void DetikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DetikKeyPressed
        Valid.pindah(evt,Menit,btnPetugas);
    }//GEN-LAST:event_DetikKeyPressed

    private void btnPetugasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasActionPerformed

    private void btnPetugasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasKeyPressed
        Valid.pindah(evt,Detik,SkalaBromage);
    }//GEN-LAST:event_btnPetugasKeyPressed

    private void MenitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MenitKeyPressed
        Valid.pindah(evt,Jam,Detik);
    }//GEN-LAST:event_MenitKeyPressed

    private void JamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JamKeyPressed
        Valid.pindah(evt,Tanggal,Menit);
    }//GEN-LAST:event_JamKeyPressed

    private void SkalaBromageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaBromageItemStateChanged
        if(SkalaBromage.getSelectedIndex()==0){
            NilaiBromage.setText("0");
        }else if(SkalaBromage.getSelectedIndex()==1){
            NilaiBromage.setText("1");
        }else if(SkalaBromage.getSelectedIndex()==2){
            NilaiBromage.setText("2");
        }else{
            NilaiBromage.setText("3");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaBromageItemStateChanged

    private void SkalaBromageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SkalaBromageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SkalaBromageActionPerformed

    private void SkalaBromageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaBromageKeyPressed
        Valid.pindah(evt,btnPetugas,NilaiBromage);
    }//GEN-LAST:event_SkalaBromageKeyPressed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        Valid.pindah(evt,TCari,Jam);
    }//GEN-LAST:event_TanggalKeyPressed

    private void Menit1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Menit1KeyPressed
        Valid.pindah(evt,Jam,Detik);
    }//GEN-LAST:event_Menit1KeyPressed

    private void SkalaSteward2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaSteward2ItemStateChanged
        if(SkalaSteward2.getSelectedIndex()==0){
            NilaiSteward2.setText("0");
        }else if(SkalaSteward2.getSelectedIndex()==1){
            NilaiSteward2.setText("1");
        }else{
            NilaiSteward2.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaSteward2ItemStateChanged

    private void SkalaSteward2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaSteward2KeyPressed
        Valid.pindah(evt,SkalaSteward1,SkalaSteward3);
    }//GEN-LAST:event_SkalaSteward2KeyPressed

    private void Keluar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Keluar1KeyPressed
        Valid.pindah2(evt,Keluar,Instruksi);
    }//GEN-LAST:event_Keluar1KeyPressed

    private void btnPetugas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugas1ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugas1ActionPerformed

    private void btnPetugas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugas1KeyPressed
        Valid.pindah(evt,Detik,SkalaSteward1);
    }//GEN-LAST:event_btnPetugas1KeyPressed

    private void Instruksi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Instruksi1KeyPressed
        Valid.pindah2(evt,Keluar,BtnSimpan);
    }//GEN-LAST:event_Instruksi1KeyPressed

    private void BtnDokter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokter1ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokter1ActionPerformed

    private void BtnDokter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokter1KeyPressed
        Valid.pindah(evt,btnPetugas,BtnSimpan);
    }//GEN-LAST:event_BtnDokter1KeyPressed

    private void Tanggal1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tanggal1KeyPressed
        Valid.pindah(evt,TCari,Jam);
    }//GEN-LAST:event_Tanggal1KeyPressed

    private void Detik1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Detik1KeyPressed
        Valid.pindah(evt,Menit,btnPetugas);
    }//GEN-LAST:event_Detik1KeyPressed

    private void SkalaSteward3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaSteward3ItemStateChanged
        if(SkalaSteward3.getSelectedIndex()==0){
            NilaiSteward3.setText("0");
        }else if(SkalaSteward3.getSelectedIndex()==1){
            NilaiSteward3.setText("1");
        }else{
            NilaiSteward3.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaSteward3ItemStateChanged

    private void SkalaSteward3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaSteward3KeyPressed
        Valid.pindah(evt,SkalaSteward2,NilaiTotalSteward);
    }//GEN-LAST:event_SkalaSteward3KeyPressed

    private void SkalaSteward1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaSteward1ItemStateChanged
        if(SkalaSteward1.getSelectedIndex()==0){
            NilaiSteward1.setText("0");
        }else if(SkalaSteward1.getSelectedIndex()==1){
            NilaiSteward1.setText("1");
        }else{
            NilaiSteward1.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaSteward1ItemStateChanged

    private void SkalaSteward1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaSteward1KeyPressed
        Valid.pindah(evt,btnPetugas,SkalaSteward2);
    }//GEN-LAST:event_SkalaSteward1KeyPressed

    private void Jam1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jam1KeyPressed
        Valid.pindah(evt,Tanggal,Menit);
    }//GEN-LAST:event_Jam1KeyPressed

    private void btnPetugas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugas2ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugas2ActionPerformed

    private void btnPetugas2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugas2KeyPressed
        Valid.pindah(evt,Detik,SkalaSteward1);
    }//GEN-LAST:event_btnPetugas2KeyPressed

    private void Instruksi2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Instruksi2KeyPressed
        Valid.pindah2(evt,Keluar,BtnSimpan);
    }//GEN-LAST:event_Instruksi2KeyPressed

    private void Tanggal2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tanggal2KeyPressed
        Valid.pindah(evt,TCari,Jam);
    }//GEN-LAST:event_Tanggal2KeyPressed

    private void Detik2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Detik2KeyPressed
        Valid.pindah(evt,Menit,btnPetugas);
    }//GEN-LAST:event_Detik2KeyPressed

    private void SkalaAldrette2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaAldrette2ItemStateChanged
        if(SkalaAldrette2.getSelectedIndex()==0){
            NilaiAldrette2.setText("0");
        }else if(SkalaAldrette2.getSelectedIndex()==1){
            NilaiAldrette2.setText("1");
        }else{
            NilaiAldrette2.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaAldrette2ItemStateChanged

    private void SkalaAldrette2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaAldrette2KeyPressed
        Valid.pindah(evt,SkalaSteward1,SkalaSteward3);
    }//GEN-LAST:event_SkalaAldrette2KeyPressed

    private void BtnDokter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokter2ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokter2ActionPerformed

    private void BtnDokter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokter2KeyPressed
        Valid.pindah(evt,btnPetugas,BtnSimpan);
    }//GEN-LAST:event_BtnDokter2KeyPressed

    private void Keluar2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Keluar2KeyPressed
        Valid.pindah2(evt,Keluar,Instruksi);
    }//GEN-LAST:event_Keluar2KeyPressed

    private void Jam2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jam2KeyPressed
        Valid.pindah(evt,Tanggal,Menit);
    }//GEN-LAST:event_Jam2KeyPressed

    private void SkalaAldrette3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaAldrette3ItemStateChanged
        if(SkalaAldrette3.getSelectedIndex()==0){
            NilaiAldrette3.setText("0");
        }else if(SkalaAldrette3.getSelectedIndex()==1){
            NilaiAldrette3.setText("1");
        }else{
            NilaiAldrette3.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaAldrette3ItemStateChanged

    private void SkalaAldrette3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaAldrette3KeyPressed
        Valid.pindah(evt,SkalaSteward2,SkalaAldrette2);
    }//GEN-LAST:event_SkalaAldrette3KeyPressed

    private void Menit2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Menit2KeyPressed
        Valid.pindah(evt,Jam,Detik);
    }//GEN-LAST:event_Menit2KeyPressed

    private void SkalaAldrette4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaAldrette4ItemStateChanged
        if(SkalaAldrette4.getSelectedIndex()==0){
            NilaiAldrette4.setText("0");
        }else if(SkalaAldrette4.getSelectedIndex()==1){
            NilaiAldrette4.setText("1");
        }else{
            NilaiAldrette4.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaAldrette4ItemStateChanged

    private void SkalaAldrette4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaAldrette4KeyPressed
        Valid.pindah(evt,SkalaSteward3,SkalaAldrette3);
    }//GEN-LAST:event_SkalaAldrette4KeyPressed

    private void SkalaAldrette5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaAldrette5ItemStateChanged
        if(SkalaAldrette5.getSelectedIndex()==0){
            NilaiAldrette5.setText("0");
        }else if(SkalaAldrette5.getSelectedIndex()==1){
            NilaiAldrette5.setText("1");
        }else{
            NilaiAldrette5.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaAldrette5ItemStateChanged

    private void SkalaAldrette5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaAldrette5KeyPressed
        Valid.pindah(evt,SkalaAldrette2,NilaiTotalSteward);
    }//GEN-LAST:event_SkalaAldrette5KeyPressed

    private void SkalaAldrette1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaAldrette1ItemStateChanged
        if(SkalaAldrette1.getSelectedIndex()==0){
            NilaiAldrette1.setText("0");
        }else if(SkalaAldrette1.getSelectedIndex()==1){
            NilaiAldrette1.setText("1");
        }else{
            NilaiAldrette1.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaAldrette1ItemStateChanged

    private void SkalaAldrette1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaAldrette1KeyPressed
        Valid.pindah(evt,btnPetugas,SkalaSteward2);
    }//GEN-LAST:event_SkalaAldrette1KeyPressed

    private void SkalaPadss1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaPadss1ItemStateChanged
        if(SkalaPadss1.getSelectedIndex()==0){
            NilaiPadss1.setText("0");
        }else if(SkalaPadss1.getSelectedIndex()==1){
            NilaiPadss1.setText("1");
        }else{
            NilaiPadss1.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaPadss1ItemStateChanged

    private void SkalaPadss1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaPadss1KeyPressed
        Valid.pindah(evt,btnPetugas,SkalaSteward2);
    }//GEN-LAST:event_SkalaPadss1KeyPressed

    private void SkalaPadss3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaPadss3ItemStateChanged
        if(SkalaPadss3.getSelectedIndex()==0){
            NilaiPadss3.setText("0");
        }else if(SkalaPadss3.getSelectedIndex()==1){
            NilaiPadss3.setText("1");
        }else{
            NilaiPadss3.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaPadss3ItemStateChanged

    private void SkalaPadss3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaPadss3KeyPressed
        Valid.pindah(evt,SkalaSteward2,SkalaAldrette2);
    }//GEN-LAST:event_SkalaPadss3KeyPressed

    private void BtnDokter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokter3ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnDokter3ActionPerformed

    private void BtnDokter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDokter3KeyPressed
        Valid.pindah(evt,btnPetugas,BtnSimpan);
    }//GEN-LAST:event_BtnDokter3KeyPressed

    private void Menit3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Menit3KeyPressed
        Valid.pindah(evt,Jam,Detik);
    }//GEN-LAST:event_Menit3KeyPressed

    private void Tanggal3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tanggal3KeyPressed
        Valid.pindah(evt,TCari,Jam);
    }//GEN-LAST:event_Tanggal3KeyPressed

    private void Keluar3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Keluar3KeyPressed
        Valid.pindah2(evt,Keluar,Instruksi);
    }//GEN-LAST:event_Keluar3KeyPressed

    private void Instruksi3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Instruksi3KeyPressed
        Valid.pindah2(evt,Keluar,BtnSimpan);
    }//GEN-LAST:event_Instruksi3KeyPressed

    private void Detik3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Detik3KeyPressed
        Valid.pindah(evt,Menit,btnPetugas);
    }//GEN-LAST:event_Detik3KeyPressed

    private void SkalaPadss5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaPadss5ItemStateChanged
        if(SkalaPadss5.getSelectedIndex()==0){
            NilaiPadss5.setText("0");
        }else if(SkalaPadss5.getSelectedIndex()==1){
            NilaiPadss5.setText("1");
        }else{
            NilaiPadss5.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaPadss5ItemStateChanged

    private void SkalaPadss5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaPadss5KeyPressed
        Valid.pindah(evt,SkalaAldrette2,NilaiTotalSteward);
    }//GEN-LAST:event_SkalaPadss5KeyPressed

    private void SkalaPadss4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaPadss4ItemStateChanged
        if(SkalaPadss4.getSelectedIndex()==0){
            NilaiPadss4.setText("0");
        }else if(SkalaPadss4.getSelectedIndex()==1){
            NilaiPadss4.setText("1");
        }else{
            NilaiPadss4.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaPadss4ItemStateChanged

    private void SkalaPadss4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaPadss4KeyPressed
        Valid.pindah(evt,SkalaSteward3,SkalaAldrette3);
    }//GEN-LAST:event_SkalaPadss4KeyPressed

    private void btnPetugas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugas3ActionPerformed
        akses.setform("RMBundleKriteriaPemulihanRecoveryRoom");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugas3ActionPerformed

    private void btnPetugas3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugas3KeyPressed
        Valid.pindah(evt,Detik,SkalaSteward1);
    }//GEN-LAST:event_btnPetugas3KeyPressed

    private void Jam3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Jam3KeyPressed
        Valid.pindah(evt,Tanggal,Menit);
    }//GEN-LAST:event_Jam3KeyPressed

    private void SkalaPadss2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SkalaPadss2ItemStateChanged
        if(SkalaPadss2.getSelectedIndex()==0){
            NilaiPadss2.setText("0");
        }else if(SkalaPadss2.getSelectedIndex()==1){
            NilaiPadss2.setText("1");
        }else{
            NilaiPadss2.setText("2");
        }
        isTotalResiko();
    }//GEN-LAST:event_SkalaPadss2ItemStateChanged

    private void SkalaPadss2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SkalaPadss2KeyPressed
        Valid.pindah(evt,SkalaSteward1,SkalaSteward3);
    }//GEN-LAST:event_SkalaPadss2KeyPressed

    private void ChkKejadianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkKejadianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChkKejadianActionPerformed

    private void TglLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TglLahirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TglLahirActionPerformed

    private void tbBromageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbBromageKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBromageKeyPressed

    private void MnMonitoringBromageScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringBromageScoreActionPerformed
        if(tbBromage.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbBromage.getValueAt(tbBromage.getSelectedRow(),10).toString());
            param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbBromage.getValueAt(tbBromage.getSelectedRow(),11).toString()+"\nID "+(finger.equals("")?tbBromage.getValueAt(tbBromage.getSelectedRow(),10).toString():finger)+"\n"+Tanggal.getSelectedItem());
            finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbBromage.getValueAt(tbBromage.getSelectedRow(),12).toString());
            param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbBromage.getValueAt(tbBromage.getSelectedRow(),13).toString()+"\nID "+(finger.equals("")?tbBromage.getValueAt(tbBromage.getSelectedRow(),12).toString():finger2)+"\n"+Tanggal.getSelectedItem());
            try {
                param.put("gambar",getClass().getResource("/picture/bromage_score.png").openStream());
            } catch (Exception e) {
            }
            Valid.MyReportqry("rptMonitoringBromageScore.jasper","report","::[ Monitoring Bromage Score Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_bromage_pasca_anestesi.tanggal,"+
                "skor_bromage_pasca_anestesi.penilaian_skala1,skor_bromage_pasca_anestesi.penilaian_nilai1,skor_bromage_pasca_anestesi.keluar,"+
                "skor_bromage_pasca_anestesi.instruksi,skor_bromage_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_bromage_pasca_anestesi.nip,petugas.nama "+
                "from skor_bromage_pasca_anestesi inner join reg_periksa on skor_bromage_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_bromage_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_bromage_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbBromage.getValueAt(tbBromage.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringBromageScoreActionPerformed

    private void MnMonitoringBromageScore2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringBromageScore2ActionPerformed
        if(tbBromage.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            Valid.MyReportqry("rptFormulirMonitoringBromageScore.jasper","report","::[ Formulir Monitoring Bromage Score Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_bromage_pasca_anestesi.tanggal,"+
                "skor_bromage_pasca_anestesi.penilaian_skala1,skor_bromage_pasca_anestesi.penilaian_nilai1,skor_bromage_pasca_anestesi.keluar,"+
                "skor_bromage_pasca_anestesi.instruksi,skor_bromage_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_bromage_pasca_anestesi.nip,petugas.nama "+
                "from skor_bromage_pasca_anestesi inner join reg_periksa on skor_bromage_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_bromage_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_bromage_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbBromage.getValueAt(tbBromage.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringBromageScore2ActionPerformed

    private void MnMonitoringStewardScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringStewardScoreActionPerformed
        if(tbSteward.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbSteward.getValueAt(tbSteward.getSelectedRow(),15).toString());
            param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbSteward.getValueAt(tbSteward.getSelectedRow(),16).toString()+"\nID "+(finger.equals("")?tbSteward.getValueAt(tbSteward.getSelectedRow(),15).toString():finger)+"\n"+Tanggal1.getSelectedItem());
            finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbSteward.getValueAt(tbSteward.getSelectedRow(),17).toString());
            param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbSteward.getValueAt(tbSteward.getSelectedRow(),18).toString()+"\nID "+(finger.equals("")?tbSteward.getValueAt(tbSteward.getSelectedRow(),17).toString():finger2)+"\n"+Tanggal1.getSelectedItem());
            Valid.MyReportqry("rptMonitoringStewardScore.jasper","report","::[ Monitoring Steward Score Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_steward_pasca_anestesi.tanggal,"+
                "skor_steward_pasca_anestesi.penilaian_skala1,skor_steward_pasca_anestesi.penilaian_nilai1,"+
                "skor_steward_pasca_anestesi.penilaian_skala2,skor_steward_pasca_anestesi.penilaian_nilai2,"+
                "skor_steward_pasca_anestesi.penilaian_skala3,skor_steward_pasca_anestesi.penilaian_nilai3,"+
                "skor_steward_pasca_anestesi.penilaian_totalnilai,skor_steward_pasca_anestesi.keluar,"+
                "skor_steward_pasca_anestesi.instruksi,skor_steward_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_steward_pasca_anestesi.nip,petugas.nama "+
                "from skor_steward_pasca_anestesi inner join reg_periksa on skor_steward_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_steward_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_steward_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbSteward.getValueAt(tbSteward.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringStewardScoreActionPerformed

    private void MnMonitoringStewardScore2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringStewardScore2ActionPerformed
        if(tbSteward.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            Valid.MyReportqry("rptFormulirMonitoringStewardScore.jasper","report","::[ Formulir Monitoring Steward Score Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_steward_pasca_anestesi.tanggal,"+
                "skor_steward_pasca_anestesi.penilaian_skala1,skor_steward_pasca_anestesi.penilaian_nilai1,"+
                "skor_steward_pasca_anestesi.penilaian_skala2,skor_steward_pasca_anestesi.penilaian_nilai2,"+
                "skor_steward_pasca_anestesi.penilaian_skala3,skor_steward_pasca_anestesi.penilaian_nilai3,"+
                "skor_steward_pasca_anestesi.penilaian_totalnilai,skor_steward_pasca_anestesi.keluar,"+
                "skor_steward_pasca_anestesi.instruksi,skor_steward_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_steward_pasca_anestesi.nip,petugas.nama "+
                "from skor_steward_pasca_anestesi inner join reg_periksa on skor_steward_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_steward_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_steward_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbSteward.getValueAt(tbSteward.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringStewardScore2ActionPerformed

    private void MnMonitoringSkorAldretteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringSkorAldretteActionPerformed
        if(tbAldrette.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbAldrette.getValueAt(tbAldrette.getSelectedRow(),19).toString());
            param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbAldrette.getValueAt(tbAldrette.getSelectedRow(),20).toString()+"\nID "+(finger.equals("")?tbAldrette.getValueAt(tbAldrette.getSelectedRow(),19).toString():finger)+"\n"+Tanggal2.getSelectedItem());
            finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbAldrette.getValueAt(tbAldrette.getSelectedRow(),21).toString());
            param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbAldrette.getValueAt(tbAldrette.getSelectedRow(),22).toString()+"\nID "+(finger.equals("")?tbAldrette.getValueAt(tbAldrette.getSelectedRow(),21).toString():finger2)+"\n"+Tanggal2.getSelectedItem());
            Valid.MyReportqry("rptMonitoringSkorAldrette.jasper","report","::[ Monitoring Skor Aldrette Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_aldrette_pasca_anestesi.tanggal,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala1,skor_aldrette_pasca_anestesi.penilaian_nilai1,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala2,skor_aldrette_pasca_anestesi.penilaian_nilai2,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala3,skor_aldrette_pasca_anestesi.penilaian_nilai3,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala4,skor_aldrette_pasca_anestesi.penilaian_nilai4,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala5,skor_aldrette_pasca_anestesi.penilaian_nilai5,"+
                "skor_aldrette_pasca_anestesi.penilaian_totalnilai,skor_aldrette_pasca_anestesi.keluar,"+
                "skor_aldrette_pasca_anestesi.instruksi,skor_aldrette_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_aldrette_pasca_anestesi.nip,petugas.nama "+
                "from skor_aldrette_pasca_anestesi inner join reg_periksa on skor_aldrette_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_aldrette_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_aldrette_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbAldrette.getValueAt(tbAldrette.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringSkorAldretteActionPerformed

    private void MnMonitoringSkorAldrette2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringSkorAldrette2ActionPerformed
        if(tbAldrette.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            Valid.MyReportqry("rptFormulirMonitoringSkorAldrette.jasper","report","::[ Monitoring Skor Aldrette Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_aldrette_pasca_anestesi.tanggal,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala1,skor_aldrette_pasca_anestesi.penilaian_nilai1,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala2,skor_aldrette_pasca_anestesi.penilaian_nilai2,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala3,skor_aldrette_pasca_anestesi.penilaian_nilai3,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala4,skor_aldrette_pasca_anestesi.penilaian_nilai4,"+
                "skor_aldrette_pasca_anestesi.penilaian_skala5,skor_aldrette_pasca_anestesi.penilaian_nilai5,"+
                "skor_aldrette_pasca_anestesi.penilaian_totalnilai,skor_aldrette_pasca_anestesi.keluar,"+
                "skor_aldrette_pasca_anestesi.instruksi,skor_aldrette_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_aldrette_pasca_anestesi.nip,petugas.nama "+
                "from skor_aldrette_pasca_anestesi inner join reg_periksa on skor_aldrette_pasca_anestesi.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on skor_aldrette_pasca_anestesi.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on skor_aldrette_pasca_anestesi.nip=petugas.nip where reg_periksa.no_rawat='"+tbAldrette.getValueAt(tbAldrette.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringSkorAldrette2ActionPerformed

    private void MnMonitoringSkorPadssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringSkorPadssActionPerformed
        if(tbPadss.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            finger=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbPadss.getValueAt(tbPadss.getSelectedRow(),19).toString());
            param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbPadss.getValueAt(tbPadss.getSelectedRow(),20).toString()+"\nID "+(finger.equals("")?tbPadss.getValueAt(tbPadss.getSelectedRow(),19).toString():finger)+"\n"+Tanggal3.getSelectedItem());
            finger2=Sequel.cariIsi("select sha1(sidikjari.sidikjari) from sidikjari inner join pegawai on pegawai.id=sidikjari.id where pegawai.nik=?",tbPadss.getValueAt(tbPadss.getSelectedRow(),21).toString());
            param.put("finger2","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+tbPadss.getValueAt(tbPadss.getSelectedRow(),22).toString()+"\nID "+(finger.equals("")?tbPadss.getValueAt(tbPadss.getSelectedRow(),21).toString():finger2)+"\n"+Tanggal3.getSelectedItem());
            Valid.MyReportqry("rptMonitoringDischargeScoringSystemPascaAnestesi.jasper","report","::[ Monitoring Skor Aldrette Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,post_anesthesia_discharge_scoring_system.tanggal,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala1,post_anesthesia_discharge_scoring_system.penilaian_nilai1,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala2,post_anesthesia_discharge_scoring_system.penilaian_nilai2,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala3,post_anesthesia_discharge_scoring_system.penilaian_nilai3,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala4,post_anesthesia_discharge_scoring_system.penilaian_nilai4,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala5,post_anesthesia_discharge_scoring_system.penilaian_nilai5,"+
                "post_anesthesia_discharge_scoring_system.penilaian_totalnilai,post_anesthesia_discharge_scoring_system.keluar,"+
                "post_anesthesia_discharge_scoring_system.instruksi,post_anesthesia_discharge_scoring_system.kd_dokter,dokter.nm_dokter,post_anesthesia_discharge_scoring_system.nip,petugas.nama "+
                "from post_anesthesia_discharge_scoring_system inner join reg_periksa on post_anesthesia_discharge_scoring_system.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on post_anesthesia_discharge_scoring_system.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on post_anesthesia_discharge_scoring_system.nip=petugas.nip where reg_periksa.no_rawat='"+tbPadss.getValueAt(tbPadss.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringSkorPadssActionPerformed

    private void MnMonitoringSkorPadss2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnMonitoringSkorPadss2ActionPerformed
        if(tbPadss.getSelectedRow()>-1){
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());
            param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
            Valid.MyReportqry("rptFormulirMonitoringDischargeScoringSystemPascaAnestesi.jasper","report","::[ Monitoring Skor Aldrette Pasca Anestesi ]::",
                "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,post_anesthesia_discharge_scoring_system.tanggal,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala1,post_anesthesia_discharge_scoring_system.penilaian_nilai1,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala2,post_anesthesia_discharge_scoring_system.penilaian_nilai2,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala3,post_anesthesia_discharge_scoring_system.penilaian_nilai3,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala4,post_anesthesia_discharge_scoring_system.penilaian_nilai4,"+
                "post_anesthesia_discharge_scoring_system.penilaian_skala5,post_anesthesia_discharge_scoring_system.penilaian_nilai5,"+
                "post_anesthesia_discharge_scoring_system.penilaian_totalnilai,post_anesthesia_discharge_scoring_system.keluar,"+
                "post_anesthesia_discharge_scoring_system.instruksi,post_anesthesia_discharge_scoring_system.kd_dokter,dokter.nm_dokter,post_anesthesia_discharge_scoring_system.nip,petugas.nama "+
                "from post_anesthesia_discharge_scoring_system inner join reg_periksa on post_anesthesia_discharge_scoring_system.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join dokter on post_anesthesia_discharge_scoring_system.kd_dokter=dokter.kd_dokter "+
                "inner join petugas on post_anesthesia_discharge_scoring_system.nip=petugas.nip where reg_periksa.no_rawat='"+tbPadss.getValueAt(tbPadss.getSelectedRow(),0).toString()+"'",param);
        }
    }//GEN-LAST:event_MnMonitoringSkorPadss2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMBundleKriteriaPemulihanRecoveryRoom dialog = new RMBundleKriteriaPemulihanRecoveryRoom(new javax.swing.JFrame(), true);
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
    private widget.Button BtnDokter;
    private widget.Button BtnDokter1;
    private widget.Button BtnDokter2;
    private widget.Button BtnDokter3;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.CekBox ChkInput1;
    private widget.CekBox ChkInput2;
    private widget.CekBox ChkInput3;
    private widget.CekBox ChkKejadian;
    private widget.CekBox ChkKejadian1;
    private widget.CekBox ChkKejadian2;
    private widget.CekBox ChkKejadian3;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.ComboBox Detik;
    private widget.ComboBox Detik1;
    private widget.ComboBox Detik2;
    private widget.ComboBox Detik3;
    private widget.PanelBiasa FormInput;
    private widget.TextArea Instruksi;
    private widget.TextArea Instruksi1;
    private widget.TextArea Instruksi2;
    private widget.TextArea Instruksi3;
    private widget.TextBox JK;
    private widget.ComboBox Jam;
    private widget.ComboBox Jam1;
    private widget.ComboBox Jam2;
    private widget.ComboBox Jam3;
    private widget.TextBox KdDokter;
    private widget.TextBox KdDokter1;
    private widget.TextBox KdDokter2;
    private widget.TextBox KdDokter3;
    private widget.TextArea Keluar;
    private widget.TextArea Keluar1;
    private widget.TextArea Keluar2;
    private widget.TextArea Keluar3;
    private widget.Label LCount;
    private widget.ComboBox Menit;
    private widget.ComboBox Menit1;
    private widget.ComboBox Menit2;
    private widget.ComboBox Menit3;
    private javax.swing.JMenuItem MnMonitoringBromageScore;
    private javax.swing.JMenuItem MnMonitoringBromageScore2;
    private javax.swing.JMenuItem MnMonitoringSkorAldrette;
    private javax.swing.JMenuItem MnMonitoringSkorAldrette2;
    private javax.swing.JMenuItem MnMonitoringSkorPadss;
    private javax.swing.JMenuItem MnMonitoringSkorPadss2;
    private javax.swing.JMenuItem MnMonitoringStewardScore;
    private javax.swing.JMenuItem MnMonitoringStewardScore2;
    private widget.TextBox NIP;
    private widget.TextBox NIP1;
    private widget.TextBox NIP2;
    private widget.TextBox NIP3;
    private widget.TextBox NamaPetugas;
    private widget.TextBox NamaPetugas1;
    private widget.TextBox NamaPetugas2;
    private widget.TextBox NamaPetugas3;
    private widget.TextBox NilaiAldrette1;
    private widget.TextBox NilaiAldrette2;
    private widget.TextBox NilaiAldrette3;
    private widget.TextBox NilaiAldrette4;
    private widget.TextBox NilaiAldrette5;
    private widget.TextBox NilaiBromage;
    private widget.TextBox NilaiPadss1;
    private widget.TextBox NilaiPadss2;
    private widget.TextBox NilaiPadss3;
    private widget.TextBox NilaiPadss4;
    private widget.TextBox NilaiPadss5;
    private widget.TextBox NilaiSteward1;
    private widget.TextBox NilaiSteward2;
    private widget.TextBox NilaiSteward3;
    private widget.TextBox NilaiTotalAldrette;
    private widget.TextBox NilaiTotalPadss;
    private widget.TextBox NilaiTotalSteward;
    private widget.TextBox NmDokter;
    private widget.TextBox NmDokter1;
    private widget.TextBox NmDokter2;
    private widget.TextBox NmDokter3;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelInput1;
    private javax.swing.JPanel PanelInput2;
    private javax.swing.JPanel PanelInput3;
    private usu.widget.glass.PanelGlass PanelWall;
    private javax.swing.JPopupMenu PopupMenuAldrette;
    private javax.swing.JPopupMenu PopupMenuBromage;
    private javax.swing.JPopupMenu PopupMenuPadss;
    private javax.swing.JPopupMenu PopupMenuSteward;
    private widget.ScrollPane Scroll10;
    private widget.ScrollPane Scroll3;
    private widget.ScrollPane Scroll4;
    private widget.ScrollPane Scroll5;
    private widget.ScrollPane Scroll6;
    private widget.ScrollPane Scroll7;
    private widget.ScrollPane Scroll8;
    private widget.ScrollPane Scroll9;
    private widget.ComboBox SkalaAldrette1;
    private widget.ComboBox SkalaAldrette2;
    private widget.ComboBox SkalaAldrette3;
    private widget.ComboBox SkalaAldrette4;
    private widget.ComboBox SkalaAldrette5;
    private widget.ComboBox SkalaBromage;
    private widget.ComboBox SkalaPadss1;
    private widget.ComboBox SkalaPadss2;
    private widget.ComboBox SkalaPadss3;
    private widget.ComboBox SkalaPadss4;
    private widget.ComboBox SkalaPadss5;
    private widget.ComboBox SkalaSteward1;
    private widget.ComboBox SkalaSteward2;
    private widget.ComboBox SkalaSteward3;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.Tanggal Tanggal;
    private widget.Tanggal Tanggal1;
    private widget.Tanggal Tanggal2;
    private widget.Tanggal Tanggal3;
    private widget.TextBox TglLahir;
    private widget.Label TingkatKriteria;
    private widget.Label TingkatSkor;
    private widget.Label TingkatSkor1;
    private widget.Label TingkatSkor2;
    private widget.Button btnPetugas;
    private widget.Button btnPetugas1;
    private widget.Button btnPetugas2;
    private widget.Button btnPetugas3;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame5;
    private widget.InternalFrame internalFrame6;
    private widget.InternalFrame internalFrame7;
    private widget.InternalFrame internalFrame8;
    private widget.Label jLabel10;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel217;
    private widget.Label jLabel218;
    private widget.Label jLabel219;
    private widget.Label jLabel22;
    private widget.Label jLabel220;
    private widget.Label jLabel221;
    private widget.Label jLabel222;
    private widget.Label jLabel223;
    private widget.Label jLabel224;
    private widget.Label jLabel225;
    private widget.Label jLabel226;
    private widget.Label jLabel227;
    private widget.Label jLabel228;
    private widget.Label jLabel229;
    private widget.Label jLabel23;
    private widget.Label jLabel230;
    private widget.Label jLabel231;
    private widget.Label jLabel232;
    private widget.Label jLabel233;
    private widget.Label jLabel234;
    private widget.Label jLabel235;
    private widget.Label jLabel236;
    private widget.Label jLabel237;
    private widget.Label jLabel238;
    private widget.Label jLabel239;
    private widget.Label jLabel240;
    private widget.Label jLabel241;
    private widget.Label jLabel242;
    private widget.Label jLabel243;
    private widget.Label jLabel244;
    private widget.Label jLabel245;
    private widget.Label jLabel246;
    private widget.Label jLabel247;
    private widget.Label jLabel248;
    private widget.Label jLabel249;
    private widget.Label jLabel25;
    private widget.Label jLabel250;
    private widget.Label jLabel251;
    private widget.Label jLabel252;
    private widget.Label jLabel253;
    private widget.Label jLabel254;
    private widget.Label jLabel255;
    private widget.Label jLabel256;
    private widget.Label jLabel257;
    private widget.Label jLabel258;
    private widget.Label jLabel259;
    private widget.Label jLabel26;
    private widget.Label jLabel260;
    private widget.Label jLabel261;
    private widget.Label jLabel3;
    private widget.Label jLabel30;
    private widget.Label jLabel31;
    private widget.Label jLabel32;
    private widget.Label jLabel33;
    private widget.Label jLabel34;
    private widget.Label jLabel35;
    private widget.Label jLabel36;
    private widget.Label jLabel37;
    private widget.Label jLabel57;
    private widget.Label jLabel58;
    private widget.Label jLabel59;
    private widget.Label jLabel6;
    private widget.Label jLabel60;
    private widget.Label jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private widget.Label label14;
    private widget.Label label15;
    private widget.Label label16;
    private widget.Label label17;
    private widget.panelisi panelGlass12;
    private widget.panelisi panelGlass13;
    private widget.panelisi panelGlass14;
    private widget.panelisi panelGlass15;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.ScrollPane scrollPane1;
    private widget.ScrollPane scrollPane2;
    private widget.ScrollPane scrollPane3;
    private widget.ScrollPane scrollPane4;
    private widget.ScrollPane scrollPane5;
    private widget.ScrollPane scrollPane6;
    private widget.ScrollPane scrollPane7;
    private widget.ScrollPane scrollPane8;
    private widget.Table tbAldrette;
    private widget.Table tbBromage;
    private widget.Table tbPadss;
    private widget.Table tbSteward;
    // End of variables declaration//GEN-END:variables

    private void isRawat() {
        try {
            ps = koneksi.prepareStatement(
                    "select reg_periksa.no_rkm_medis,pasien.tgl_lahir,pasien.jk,concat(pasien.nm_pasien,' (',pasien.umur,')') as pasien,reg_periksa.kd_dokter,reg_periksa.tgl_registrasi,"
                    + "reg_periksa.jam_reg from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis where reg_periksa.no_rawat=?");
            try {
                ps.setString(1, TNoRw.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    TPasien.setText(rs.getString("pasien"));
                    TglLahir.setText(rs.getString("tgl_lahir"));
                    JK.setText(rs.getString("jk"));
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

    public void setNoRm(String norwt, Date tgl1) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        DTPCari1.setDate(tgl1);
        isRawat();
        ChkInput.setSelected(true);
        isForm();
        ChkInput1.setSelected(true);
        isForm2();
        ChkInput2.setSelected(true);
        isForm3();
        ChkInput3.setSelected(true);
        isForm4();
        
        TabRawatMouseClicked(null);
        isCek();
        
    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.getskor_bromage_pasca_anestesi());
        BtnHapus.setEnabled(akses.getskor_bromage_pasca_anestesi());
        BtnEdit.setEnabled(akses.getskor_bromage_pasca_anestesi());
        if (akses.getjml2() >= 1) {
            String namaPetugas = petugas.tampil3(akses.getkode());
            if (!namaPetugas.isEmpty()) {
                NIP.setText(akses.getkode());
                NamaPetugas.setText(namaPetugas);
                NIP1.setText(akses.getkode());
                NamaPetugas1.setText(namaPetugas);
                NIP2.setText(akses.getkode());
                NamaPetugas2.setText(namaPetugas);
                NIP3.setText(akses.getkode());
                NamaPetugas3.setText(namaPetugas);
            }
        }
    }

    private void getDataBromage() {
        if (tbBromage.getSelectedRow() != -1) {
            TNoRw.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),0).toString()); 
            TNoRM.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),1).toString());
            TPasien.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),2).toString());
            TglLahir.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),3).toString());
            JK.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),4).toString());
            SkalaBromage.setSelectedItem(tbBromage.getValueAt(tbBromage.getSelectedRow(),6).toString());
            NilaiBromage.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),7).toString());
            Keluar.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),8).toString());
            Instruksi.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),9).toString());
            KdDokter.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),10).toString());
            NmDokter.setText(tbBromage.getValueAt(tbBromage.getSelectedRow(),11).toString());
            Jam.setSelectedItem(tbBromage.getValueAt(tbBromage.getSelectedRow(),5).toString().substring(6,7));
            Menit.setSelectedItem(tbBromage.getValueAt(tbBromage.getSelectedRow(),5).toString().substring(8,10));
            Detik.setSelectedItem(tbBromage.getValueAt(tbBromage.getSelectedRow(),5).toString().substring(11,13));
            Valid.SetTgl(Tanggal,tbBromage.getValueAt(tbBromage.getSelectedRow(),5).toString());
            
        }
    }

    private void getDataSteward() {
        if (tbSteward.getSelectedRow() != -1) {
            TNoRw.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),0).toString()); 
            TNoRM.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),1).toString());
            TPasien.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),2).toString());
            TglLahir.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),3).toString());
            JK.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),4).toString());
            SkalaSteward1.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),6).toString());
            NilaiSteward1.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),7).toString());
            SkalaSteward2.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),8).toString());
            NilaiSteward2.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),9).toString());
            SkalaSteward3.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),10).toString());
            NilaiSteward3.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),11).toString());
            NilaiTotalSteward.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),12).toString());
            Keluar1.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),13).toString());
            Instruksi1.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),14).toString());
            KdDokter1.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),15).toString());
            NmDokter1.setText(tbSteward.getValueAt(tbSteward.getSelectedRow(),16).toString());
            Jam1.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),5).toString().substring(9,11));
            Menit1.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),5).toString().substring(12,14));
            Detik1.setSelectedItem(tbSteward.getValueAt(tbSteward.getSelectedRow(),5).toString().substring(15,17));
            Valid.SetTgl(Tanggal1,tbSteward.getValueAt(tbSteward.getSelectedRow(),5).toString());
           
        }
    }
    
    private void getDataAldrette() {
        if (tbAldrette.getSelectedRow() != -1) {
            TNoRw.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),0).toString()); 
            TNoRM.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),1).toString());
            TPasien.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),2).toString());
            TglLahir.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),3).toString());
            JK.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),4).toString());
            SkalaAldrette1.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),6).toString());
            NilaiAldrette1.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),7).toString());
            SkalaAldrette2.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),8).toString());
            NilaiAldrette2.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),9).toString());
            SkalaAldrette3.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),10).toString());
            NilaiAldrette3.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),11).toString());
            SkalaAldrette4.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),12).toString());
            NilaiAldrette4.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),13).toString());
            SkalaAldrette5.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),14).toString());
            NilaiAldrette5.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),15).toString());
            NilaiTotalAldrette.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),16).toString());
            Keluar2.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),17).toString());
            Instruksi2.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),18).toString());
            KdDokter2.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),19).toString());
            NmDokter2.setText(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),20).toString());
            Jam2.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString().substring(11,13));
            Menit2.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString().substring(14,16));
            Detik2.setSelectedItem(tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString().substring(17,19));
            Valid.SetTgl(Tanggal2,tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString());
           
        }
    }
    
    private void getDataPadss() {
        if (tbPadss.getSelectedRow() != -1) {
            TNoRw.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),0).toString()); 
            TNoRM.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),1).toString());
            TPasien.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),2).toString());
            TglLahir.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),3).toString());
            JK.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),4).toString());
            SkalaPadss1.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),6).toString());
            NilaiPadss1.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),7).toString());
            SkalaPadss2.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),8).toString());
            NilaiPadss2.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),9).toString());
            SkalaPadss3.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),10).toString());
            NilaiPadss3.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),11).toString());
            SkalaPadss4.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),12).toString());
            NilaiPadss4.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),13).toString());
            SkalaPadss5.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),14).toString());
            NilaiPadss5.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),15).toString());
            NilaiTotalPadss.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),16).toString());
            Keluar3.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),17).toString());
            Instruksi3.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),18).toString());
            KdDokter3.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),19).toString());
            NmDokter3.setText(tbPadss.getValueAt(tbPadss.getSelectedRow(),20).toString());
            Jam3.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString().substring(11,13));
            Menit3.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString().substring(14,16));
            Detik3.setSelectedItem(tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString().substring(17,19));
            Valid.SetTgl(Tanggal3,tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString());
           
        }
    }
    
    private void isForm() {
        if (ChkInput.isSelected() == true) {
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH, 420));
            panelGlass12.setVisible(true);
            ChkInput.setVisible(true);
        } else if (ChkInput.isSelected() == false) {
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass12.setVisible(false);
            ChkInput.setVisible(true);
        }
    }

    private void isForm2() {
        if (ChkInput1.isSelected() == true) {
            ChkInput1.setVisible(false);
            PanelInput1.setPreferredSize(new Dimension(WIDTH, 420));
            panelGlass13.setVisible(true);
            ChkInput1.setVisible(true);
        } else if (ChkInput1.isSelected() == false) {
            ChkInput1.setVisible(false);
            PanelInput1.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass13.setVisible(false);
            ChkInput1.setVisible(true);
        }
    }
    
    private void isForm3() {
        if (ChkInput2.isSelected() == true) {
            ChkInput2.setVisible(false);
            PanelInput2.setPreferredSize(new Dimension(WIDTH, 420));
            panelGlass14.setVisible(true);
            ChkInput2.setVisible(true);
        } else if (ChkInput2.isSelected() == false) {
            ChkInput2.setVisible(false);
            PanelInput2.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass14.setVisible(false);
            ChkInput2.setVisible(true);
        }
    }

    private void isForm4() {
        if (ChkInput3.isSelected() == true) {
            ChkInput3.setVisible(false);
            PanelInput3.setPreferredSize(new Dimension(WIDTH, 420));
            panelGlass15.setVisible(true);
            ChkInput3.setVisible(true);
        } else if (ChkInput3.isSelected() == false) {
            ChkInput3.setVisible(false);
            PanelInput3.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass15.setVisible(false);
            ChkInput3.setVisible(true);
        }
    }

    public void TampilkanData() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                tampilkanSkorBromage();
                break;
            case 1:
                tampilkanSkorSteward();
                break;
            case 2:
                tampilkanSkorAldrette();
                break;
            case 3:
                tampilkanSkorPadss();
                break;
            default:
                break;
        }
    }
    
    private void tampilkanSkorBromage() {
        Valid.tabelKosong(tabModeBromage);
        try {
            String sql = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_bromage_pasca_anestesi.tanggal,"
                    + "skor_bromage_pasca_anestesi.penilaian_skala1,skor_bromage_pasca_anestesi.penilaian_nilai1,skor_bromage_pasca_anestesi.keluar,"
                    + "skor_bromage_pasca_anestesi.instruksi,skor_bromage_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_bromage_pasca_anestesi.nip,petugas.nama "
                    + "from skor_bromage_pasca_anestesi "
                    + "inner join reg_periksa on skor_bromage_pasca_anestesi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter on skor_bromage_pasca_anestesi.kd_dokter=dokter.kd_dokter "
                    + "inner join petugas on skor_bromage_pasca_anestesi.nip=petugas.nip "
                    + "where skor_bromage_pasca_anestesi.tanggal between ? and ? ";
            if (!TCari.getText().trim().isEmpty()) {
                sql += "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? "
                        + "or skor_bromage_pasca_anestesi.kd_dokter like ? or dokter.nm_dokter like ? "
                        + "or skor_bromage_pasca_anestesi.nip like ? or petugas.nama like ?) ";
            }

            sql += "order by skor_bromage_pasca_anestesi.tanggal";

            ps = koneksi.prepareStatement(sql);
            
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    for (int i = 3; i <= 9; i++) {
                        ps.setString(i, "%" + TCari.getText().trim() + "%");
                    }
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeBromage.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),rs.getString("tanggal"),
                        rs.getString("penilaian_skala1"),rs.getString("penilaian_nilai1"),rs.getString("keluar"),rs.getString("instruksi"),rs.getString("kd_dokter"),
                        rs.getString("nm_dokter"),rs.getString("nip"),rs.getString("nama")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText("" + tabModeBromage.getRowCount());
    }

    private void tampilkanSkorSteward() {
        Valid.tabelKosong(tabModeSteward);
        try {
            String sql = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_steward_pasca_anestesi.tanggal,"
                    + "skor_steward_pasca_anestesi.penilaian_skala1,skor_steward_pasca_anestesi.penilaian_nilai1,"
                    + "skor_steward_pasca_anestesi.penilaian_skala2,skor_steward_pasca_anestesi.penilaian_nilai2,"
                    + "skor_steward_pasca_anestesi.penilaian_skala3,skor_steward_pasca_anestesi.penilaian_nilai3,"
                    + "skor_steward_pasca_anestesi.penilaian_totalnilai,skor_steward_pasca_anestesi.keluar,"
                    + "skor_steward_pasca_anestesi.instruksi,skor_steward_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_steward_pasca_anestesi.nip,petugas.nama "
                    + "from skor_steward_pasca_anestesi "
                    + "inner join reg_periksa on skor_steward_pasca_anestesi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter on skor_steward_pasca_anestesi.kd_dokter=dokter.kd_dokter "
                    + "inner join petugas on skor_steward_pasca_anestesi.nip=petugas.nip "
                    + "where skor_steward_pasca_anestesi.tanggal between ? and ? ";
            if(!TCari.getText().trim().isEmpty()) {
                sql += "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? "
                        + "or skor_steward_pasca_anestesi.kd_dokter like ? or dokter.nm_dokter like ? "
                        + "or skor_steward_pasca_anestesi.nip like ? or petugas.nama like ?) ";
            }

            sql += "order by skor_steward_pasca_anestesi.tanggal";

            ps = koneksi.prepareStatement(sql);
            
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    for (int i = 3; i <= 9; i++) {
                        ps.setString(i, "%" + TCari.getText().trim() + "%");
                    }
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeSteward.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),rs.getString("tanggal"),
                        rs.getString("penilaian_skala1"),rs.getString("penilaian_nilai1"),rs.getString("penilaian_skala2"),rs.getString("penilaian_nilai2"),rs.getString("penilaian_skala3"),rs.getString("penilaian_nilai3"),
                        rs.getString("penilaian_totalnilai"),rs.getString("keluar"),rs.getString("instruksi"),rs.getString("kd_dokter"),rs.getString("nm_dokter"),rs.getString("nip"),rs.getString("nama")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText("" + tabModeSteward.getRowCount());
    }

    private void tampilkanSkorAldrette() {
        Valid.tabelKosong(tabModeAldrette);
        try {
            String sql = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,skor_aldrette_pasca_anestesi.tanggal,"
                    + "skor_aldrette_pasca_anestesi.penilaian_skala1,skor_aldrette_pasca_anestesi.penilaian_nilai1,"
                    + "skor_aldrette_pasca_anestesi.penilaian_skala2,skor_aldrette_pasca_anestesi.penilaian_nilai2,"
                    + "skor_aldrette_pasca_anestesi.penilaian_skala3,skor_aldrette_pasca_anestesi.penilaian_nilai3,"
                    + "skor_aldrette_pasca_anestesi.penilaian_skala4,skor_aldrette_pasca_anestesi.penilaian_nilai4,"
                    + "skor_aldrette_pasca_anestesi.penilaian_skala5,skor_aldrette_pasca_anestesi.penilaian_nilai5,"
                    + "skor_aldrette_pasca_anestesi.penilaian_totalnilai,skor_aldrette_pasca_anestesi.keluar,"
                    + "skor_aldrette_pasca_anestesi.instruksi,skor_aldrette_pasca_anestesi.kd_dokter,dokter.nm_dokter,skor_aldrette_pasca_anestesi.nip,petugas.nama "
                    + "from skor_aldrette_pasca_anestesi "
                    + "inner join reg_periksa on skor_aldrette_pasca_anestesi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter on skor_aldrette_pasca_anestesi.kd_dokter=dokter.kd_dokter "
                    + "inner join petugas on skor_aldrette_pasca_anestesi.nip=petugas.nip "
                    + "where skor_aldrette_pasca_anestesi.tanggal between ? and ? ";
            if(!TCari.getText().trim().isEmpty()) {
                sql += "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? "
                        + "or skor_aldrette_pasca_anestesi.kd_dokter like ? or dokter.nm_dokter like ? "
                        + "or skor_aldrette_pasca_anestesi.nip like ? or petugas.nama like ?) ";
            }

            sql += "order by skor_aldrette_pasca_anestesi.tanggal";

            ps = koneksi.prepareStatement(sql);
            
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    for (int i = 3; i <= 9; i++) {
                        ps.setString(i, "%" + TCari.getText().trim() + "%");
                    }
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeAldrette.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),rs.getString("tanggal"),
                        rs.getString("penilaian_skala1"),rs.getString("penilaian_nilai1"),rs.getString("penilaian_skala2"),rs.getString("penilaian_nilai2"),rs.getString("penilaian_skala3"),
                        rs.getString("penilaian_nilai3"),rs.getString("penilaian_skala4"),rs.getString("penilaian_nilai4"),rs.getString("penilaian_skala5"),rs.getString("penilaian_nilai5"),
                        rs.getString("penilaian_totalnilai"),rs.getString("keluar"),rs.getString("instruksi"),rs.getString("kd_dokter"),rs.getString("nm_dokter"),rs.getString("nip"),rs.getString("nama")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch (Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText("" + tabModeAldrette.getRowCount());
    }
    
    private void tampilkanSkorPadss() {
        Valid.tabelKosong(tabModePadss);
        try {
            String sql = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.tgl_lahir,post_anesthesia_discharge_scoring_system.tanggal,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_skala1,post_anesthesia_discharge_scoring_system.penilaian_nilai1,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_skala2,post_anesthesia_discharge_scoring_system.penilaian_nilai2,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_skala3,post_anesthesia_discharge_scoring_system.penilaian_nilai3,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_skala4,post_anesthesia_discharge_scoring_system.penilaian_nilai4,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_skala5,post_anesthesia_discharge_scoring_system.penilaian_nilai5,"
                    + "post_anesthesia_discharge_scoring_system.penilaian_totalnilai,post_anesthesia_discharge_scoring_system.keluar,"
                    + "post_anesthesia_discharge_scoring_system.instruksi,post_anesthesia_discharge_scoring_system.kd_dokter,dokter.nm_dokter,post_anesthesia_discharge_scoring_system.nip,petugas.nama "
                    + "from post_anesthesia_discharge_scoring_system "
                    + "inner join reg_periksa on post_anesthesia_discharge_scoring_system.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter on post_anesthesia_discharge_scoring_system.kd_dokter=dokter.kd_dokter "
                    + "inner join petugas on post_anesthesia_discharge_scoring_system.nip=petugas.nip "
                    + "where post_anesthesia_discharge_scoring_system.tanggal between ? and ? ";
            
            if(!TCari.getText().trim().isEmpty()) {
                sql += "and (reg_periksa.no_rawat like ? or pasien.no_rkm_medis like ? or pasien.nm_pasien like ? "
                        + "or post_anesthesia_discharge_scoring_system.kd_dokter like ? or dokter.nm_dokter like ? "
                        + "or post_anesthesia_discharge_scoring_system.nip like ? or petugas.nama like ?) ";
            }

            sql += "order by post_anesthesia_discharge_scoring_system.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    for (int i = 3; i <= 9; i++) {
                        ps.setString(i, "%" + TCari.getText().trim() + "%");
                    }
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModePadss.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),rs.getString("tanggal"),
                        rs.getString("penilaian_skala1"),rs.getString("penilaian_nilai1"),rs.getString("penilaian_skala2"),rs.getString("penilaian_nilai2"),rs.getString("penilaian_skala3"),
                        rs.getString("penilaian_nilai3"),rs.getString("penilaian_skala4"),rs.getString("penilaian_nilai4"),rs.getString("penilaian_skala5"),rs.getString("penilaian_nilai5"),
                        rs.getString("penilaian_totalnilai"),rs.getString("keluar"),rs.getString("instruksi"),rs.getString("kd_dokter"),rs.getString("nm_dokter"),rs.getString("nip"),rs.getString("nama")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText("" + tabModePadss.getRowCount());
    }

    public void emptTeks() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                emptTeksBromage();
                break;
            case 1:
                emptTeksSteward();
                break;
            case 2:
                emptTeksAldrette();
                break;
            case 3:
                emptTeksPadss();
                break;
            default:
                break;
        }
    }
    
    public void emptTeksSemua() {
        emptTeksPadss();
        emptTeksAldrette();
        emptTeksSteward();
        emptTeksBromage();
    }

    private void simpan() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                simpanBromage();
                break;
            case 1:
                simpanSteward();
                break;
            case 2:
                simpanAldrette();
                break;
            case 3:
                simpanPadss();
                break;
            default:
                break;
        }
    }
    
    private void isTotalResiko(){
        //Bromage
        try {
            if(Integer.parseInt(NilaiBromage.getText())<=2){
                TingkatKriteria.setText("Pasien Bisa Dipindahkan Dari Ruang Pemulihan Bila Nilai <= 2");
            }else{
                TingkatKriteria.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
            }
        } catch (Exception e) {
            TingkatKriteria.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        }
        
        //Steward
        try {
            NilaiTotalSteward.setText((Integer.parseInt(NilaiSteward1.getText())+Integer.parseInt(NilaiSteward2.getText())+Integer.parseInt(NilaiSteward3.getText()))+"");
            if(Integer.parseInt(NilaiTotalSteward.getText())>=5){
                TingkatSkor.setText("Pasien Bisa Dipindahkan Ke Ruangan Perawatan Bila Skor >= 5");
            }else if(Integer.parseInt(NilaiTotalSteward.getText())<5){
                TingkatSkor.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
            }
        } catch (Exception e) {
            NilaiTotalSteward.setText("0");
            TingkatSkor.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        }
        
        //Aldrette
        try {
            NilaiTotalAldrette.setText((Integer.parseInt(NilaiAldrette1.getText())+Integer.parseInt(NilaiAldrette2.getText())+Integer.parseInt(NilaiAldrette3.getText())+Integer.parseInt(NilaiAldrette4.getText())+Integer.parseInt(NilaiAldrette5.getText()))+"");
            if(Integer.parseInt(NilaiTotalAldrette.getText())>=8){
                TingkatSkor1.setText("Pasien Bisa Dipindahkan Ke Ruangan Perawatan Bila Skor Minimal 8");
            }else if(Integer.parseInt(NilaiTotalAldrette.getText())<8){
                TingkatSkor1.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
            }
        } catch (Exception e) {
            NilaiTotalAldrette.setText("0");
            TingkatSkor1.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        }
        
        //PADSS
        try {
            NilaiTotalPadss.setText((Integer.parseInt(NilaiPadss1.getText())+Integer.parseInt(NilaiPadss2.getText())+Integer.parseInt(NilaiPadss3.getText())+Integer.parseInt(NilaiPadss4.getText())+Integer.parseInt(NilaiPadss5.getText()))+"");
            if(Integer.parseInt(NilaiTotalPadss.getText())>=9){
                TingkatSkor2.setText("Pasien Bisa Dipindahkan Ke Ruangan Perawatan Bila Skor Minimal 9");
            }else if(Integer.parseInt(NilaiTotalPadss.getText())<9){
                TingkatSkor2.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
            }
        } catch (Exception e) {
            NilaiTotalPadss.setText("0");
            TingkatSkor2.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        }
    }
    
    private void simpanBromage() {
        if(NIP.getText().trim().equals("")||NamaPetugas.getText().trim().equals("")){
            Valid.textKosong(NIP,"Petugas");
            return;
        }
        
        if(KdDokter.getText().trim().equals("")||NmDokter.getText().trim().equals("")){
            Valid.textKosong(BtnDokter,"Dokter");
            return;
        }
        
        if(Sequel.menyimpantf("skor_bromage_pasca_anestesi","?,?,?,?,?,?,?,?","Data",8,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Jam.getSelectedItem()+":"+Menit.getSelectedItem()+":"+Detik.getSelectedItem(),
            SkalaBromage.getSelectedItem().toString(),NilaiBromage.getText(),Keluar.getText(),Instruksi.getText(),KdDokter.getText(),NIP.getText()
        })==true) {
            tabModeBromage.addRow(new Object[]{
                TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TglLahir.getText(),JK.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Jam.getSelectedItem()+":"+Menit.getSelectedItem()+":"+Detik.getSelectedItem(),
                SkalaBromage.getSelectedItem().toString(),NilaiBromage.getText(),Keluar.getText(),Instruksi.getText(),KdDokter.getText(),NmDokter.getText(),NIP.getText(),NamaPetugas.getText()
            });
            emptTeks();
            LCount.setText(""+tabModeBromage.getRowCount());
        }
    }
    
    private void simpanSteward() {
        if(NIP1.getText().trim().equals("")||NamaPetugas1.getText().trim().equals("")){
            Valid.textKosong(NIP1,"Petugas");
            return;
        }
        
        if(KdDokter1.getText().trim().equals("")||NmDokter1.getText().trim().equals("")){
            Valid.textKosong(BtnDokter1,"Dokter");
            return;
        }
        
        if(Sequel.menyimpantf("skor_steward_pasca_anestesi","?,?,?,?,?,?,?,?,?,?,?,?,?","Data",13,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal1.getSelectedItem()+"")+" "+Jam1.getSelectedItem()+":"+Menit1.getSelectedItem()+":"+Detik1.getSelectedItem(),
            SkalaSteward1.getSelectedItem().toString(),NilaiSteward1.getText(),SkalaSteward2.getSelectedItem().toString(),NilaiSteward2.getText(),SkalaSteward3.getSelectedItem().toString(),NilaiSteward3.getText(),
            NilaiTotalSteward.getText(),Keluar1.getText(),Instruksi1.getText(),KdDokter1.getText(),NIP1.getText()
        })==true){
            tabModeSteward.addRow(new Object[]{
                TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TglLahir.getText(),JK.getText(),Valid.SetTgl(Tanggal1.getSelectedItem()+"")+" "+Jam1.getSelectedItem()+":"+Menit1.getSelectedItem()+":"+Detik1.getSelectedItem(),
                SkalaSteward1.getSelectedItem().toString(),NilaiSteward1.getText(),SkalaSteward2.getSelectedItem().toString(),NilaiSteward2.getText(),SkalaSteward3.getSelectedItem().toString(),NilaiSteward3.getText(),
                NilaiTotalSteward.getText(),Keluar1.getText(),Instruksi1.getText(),KdDokter1.getText(),NmDokter1.getText(),NIP1.getText(),NamaPetugas1.getText()
            });
            emptTeks();
            LCount.setText(""+tabModeSteward.getRowCount());
        }
    }
    
    private void simpanAldrette() {
        if(NIP2.getText().trim().equals("")||NamaPetugas2.getText().trim().equals("")){
            Valid.textKosong(NIP2,"Petugas");
            return;
        }
        
        if(KdDokter2.getText().trim().equals("")||NmDokter2.getText().trim().equals("")){
            Valid.textKosong(BtnDokter2,"Dokter");
            return;
        }
        
        if(Sequel.menyimpantf("skor_aldrette_pasca_anestesi","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",17,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal2.getSelectedItem()+"")+" "+Jam2.getSelectedItem()+":"+Menit2.getSelectedItem()+":"+Detik2.getSelectedItem(),
            SkalaAldrette1.getSelectedItem().toString(),NilaiAldrette1.getText(),SkalaAldrette2.getSelectedItem().toString(),NilaiAldrette2.getText(),SkalaAldrette3.getSelectedItem().toString(),NilaiAldrette3.getText(),
            SkalaAldrette4.getSelectedItem().toString(),NilaiAldrette4.getText(),SkalaAldrette5.getSelectedItem().toString(),NilaiAldrette5.getText(), 
            NilaiTotalAldrette.getText(),Keluar2.getText(),Instruksi2.getText(),KdDokter2.getText(),NIP2.getText()
        })==true){
            tabModeAldrette.addRow(new Object[]{
                TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TglLahir.getText(),JK.getText(),Valid.SetTgl(Tanggal2.getSelectedItem()+"")+" "+Jam2.getSelectedItem()+":"+Menit2.getSelectedItem()+":"+Detik2.getSelectedItem(),
                SkalaAldrette1.getSelectedItem().toString(),NilaiAldrette1.getText(),SkalaAldrette2.getSelectedItem().toString(),NilaiAldrette2.getText(),SkalaAldrette3.getSelectedItem().toString(),NilaiAldrette3.getText(),
            SkalaAldrette4.getSelectedItem().toString(),NilaiAldrette4.getText(),SkalaAldrette5.getSelectedItem().toString(),NilaiAldrette5.getText(), 
                NilaiTotalAldrette.getText(),Keluar2.getText(),Instruksi2.getText(),KdDokter2.getText(),NmDokter2.getText(),NIP2.getText(),NamaPetugas2.getText()
            });
            emptTeks();
            LCount.setText(""+tabModeAldrette.getRowCount());
        } 
    }
    
    private void simpanPadss() {
        if(NIP3.getText().trim().equals("")||NamaPetugas3.getText().trim().equals("")){
            Valid.textKosong(NIP3,"Petugas");
            return;
        }
        
        if(KdDokter3.getText().trim().equals("")||NmDokter3.getText().trim().equals("")){
            Valid.textKosong(BtnDokter3,"Dokter");
            return;
        }
        
        if(Sequel.menyimpantf("post_anesthesia_discharge_scoring_system","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",17,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal3.getSelectedItem()+"")+" "+Jam3.getSelectedItem()+":"+Menit3.getSelectedItem()+":"+Detik3.getSelectedItem(),
            SkalaPadss1.getSelectedItem().toString(),NilaiPadss1.getText(),SkalaPadss2.getSelectedItem().toString(),NilaiPadss2.getText(),SkalaPadss3.getSelectedItem().toString(),NilaiPadss3.getText(),
            SkalaPadss4.getSelectedItem().toString(),NilaiPadss4.getText(),SkalaPadss5.getSelectedItem().toString(),NilaiPadss5.getText(), 
            NilaiTotalPadss.getText(),Keluar3.getText(),Instruksi3.getText(),KdDokter3.getText(),NIP3.getText()
        })==true){
            tabModePadss.addRow(new Object[]{
                TNoRw.getText(),TNoRM.getText(),TPasien.getText(),TglLahir.getText(),JK.getText(),Valid.SetTgl(Tanggal3.getSelectedItem()+"")+" "+Jam3.getSelectedItem()+":"+Menit3.getSelectedItem()+":"+Detik3.getSelectedItem(),
                SkalaPadss1.getSelectedItem().toString(),NilaiPadss1.getText(),SkalaPadss2.getSelectedItem().toString(),NilaiPadss2.getText(),SkalaPadss3.getSelectedItem().toString(),NilaiPadss3.getText(),
                SkalaPadss4.getSelectedItem().toString(),NilaiPadss4.getText(),SkalaPadss5.getSelectedItem().toString(),NilaiPadss5.getText(), 
                 NilaiTotalPadss.getText(),Keluar3.getText(),Instruksi3.getText(),KdDokter3.getText(),NmDokter3.getText(),NIP3.getText(),NamaPetugas3.getText()
            });
            emptTeks();
            LCount.setText(""+tabModePadss.getRowCount());
        } 
    }
    
    private void hapusSkorBromage() {
        if (tabModeBromage.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbBromage.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from skor_bromage_pasca_anestesi where tanggal=? and no_rawat=?",2,new String[]{
            tbBromage.getValueAt(tbBromage.getSelectedRow(),5).toString(),tbBromage.getValueAt(tbBromage.getSelectedRow(),0).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeBromage.removeRow(tbBromage.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeBromage.getRowCount());
    }
    
    private void hapusSkorSteward() {
        if (tabModeSteward.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSteward.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from skor_steward_pasca_anestesi where tanggal=? and no_rawat=?",2,new String[]{
            tbSteward.getValueAt(tbSteward.getSelectedRow(),5).toString(),tbSteward.getValueAt(tbSteward.getSelectedRow(),0).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeSteward.removeRow(tbSteward.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeSteward.getRowCount());
    }
    
    private void hapusSkorAldrette() {
        if (tabModeAldrette.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbAldrette.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from skor_aldrette_pasca_anestesi where tanggal=? and no_rawat=?",2,new String[]{
            tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString(),tbAldrette.getValueAt(tbAldrette.getSelectedRow(),0).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeAldrette.removeRow(tbAldrette.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeAldrette.getRowCount());
    }
    
    private void hapusSkorPadss() {
        if (tabModePadss.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPadss.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from post_anesthesia_discharge_scoring_system where tanggal=? and no_rawat=?",2,new String[]{
            tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString(),tbPadss.getValueAt(tbPadss.getSelectedRow(),0).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModePadss.removeRow(tbPadss.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModePadss.getRowCount());
    }
    
    private void gantiSkorBromage() {
        if (tabModeBromage.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbBromage.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("skor_bromage_pasca_anestesi", "tanggal=? and no_rawat=?", "no_rawat=?,tanggal=?,penilaian_skala1=?,penilaian_nilai1=?,"
                + "keluar=?,instruksi=?,kd_dokter=?,nip=?", 10, new String[]{
                    TNoRw.getText(), Valid.SetTgl(Tanggal.getSelectedItem() + "") + " " + Jam.getSelectedItem() + ":" + Menit.getSelectedItem() + ":" + Detik.getSelectedItem(),
                    SkalaBromage.getSelectedItem().toString(), NilaiBromage.getText(), Keluar.getText(), Instruksi.getText(), KdDokter.getText(), NIP.getText(),
                    tbBromage.getValueAt(tbBromage.getSelectedRow(), 5).toString(), tbBromage.getValueAt(tbBromage.getSelectedRow(), 0).toString()
                });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        tbBromage.setValueAt(TNoRw.getText(), tbBromage.getSelectedRow(), 0);
        tbBromage.setValueAt(TNoRM.getText(), tbBromage.getSelectedRow(), 1);
        tbBromage.setValueAt(TPasien.getText(), tbBromage.getSelectedRow(), 2);
        tbBromage.setValueAt(TglLahir.getText(), tbBromage.getSelectedRow(), 3);
        tbBromage.setValueAt(JK.getText(), tbBromage.getSelectedRow(), 4);
        tbBromage.setValueAt(Valid.SetTgl(Tanggal.getSelectedItem() + "") + " " + Jam.getSelectedItem() + ":" + Menit.getSelectedItem() + ":" + Detik.getSelectedItem(), tbBromage.getSelectedRow(), 5);
        tbBromage.setValueAt(SkalaBromage.getSelectedItem().toString(), tbBromage.getSelectedRow(), 6);
        tbBromage.setValueAt(NilaiBromage.getText(), tbBromage.getSelectedRow(), 7);
        tbBromage.setValueAt(Keluar.getText(), tbBromage.getSelectedRow(), 8);
        tbBromage.setValueAt(Instruksi.getText(), tbBromage.getSelectedRow(), 9);
        tbBromage.setValueAt(KdDokter.getText(), tbBromage.getSelectedRow(), 10);
        tbBromage.setValueAt(NmDokter.getText(), tbBromage.getSelectedRow(), 11);
        tbBromage.setValueAt(NIP.getText(), tbBromage.getSelectedRow(), 12);
        tbBromage.setValueAt(NamaPetugas.getText(), tbBromage.getSelectedRow(), 13);
        emptTeks();
    }
    
    private void gantiSkorSteward() {
        if (tabModeSteward.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSteward.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("skor_steward_pasca_anestesi", "tanggal=? and no_rawat=?", "no_rawat=?,tanggal=?,penilaian_skala1=?,penilaian_nilai1=?,"
                + "penilaian_skala2=?,penilaian_nilai2=?,penilaian_skala3=?,penilaian_nilai3=?,penilaian_totalnilai=?,keluar=?,instruksi=?,kd_dokter=?,nip=?", 15, new String[]{
                    TNoRw.getText(), Valid.SetTgl(Tanggal1.getSelectedItem() + "") + " " + Jam1.getSelectedItem() + ":" + Menit1.getSelectedItem() + ":" + Detik1.getSelectedItem(), SkalaSteward1.getSelectedItem().toString(),
                    NilaiSteward1.getText(), SkalaSteward2.getSelectedItem().toString(), NilaiSteward2.getText(), SkalaSteward3.getSelectedItem().toString(), NilaiSteward3.getText(), NilaiTotalSteward.getText(),
                    Keluar1.getText(), Instruksi1.getText(), KdDokter1.getText(), NIP1.getText(), tbSteward.getValueAt(tbSteward.getSelectedRow(), 5).toString(), tbSteward.getValueAt(tbSteward.getSelectedRow(), 0).toString()
                });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal Mengubah..!!");
            return;
        }
        
        tbSteward.setValueAt(TNoRw.getText(), tbSteward.getSelectedRow(), 0);
        tbSteward.setValueAt(TNoRM.getText(), tbSteward.getSelectedRow(), 1);
        tbSteward.setValueAt(TPasien.getText(), tbSteward.getSelectedRow(), 2);
        tbSteward.setValueAt(TglLahir.getText(), tbSteward.getSelectedRow(), 3);
        tbSteward.setValueAt(JK.getText(), tbSteward.getSelectedRow(), 4);
        tbSteward.setValueAt(Valid.SetTgl(Tanggal1.getSelectedItem() + "") + " " + Jam1.getSelectedItem() + ":" + Menit1.getSelectedItem() + ":" + Detik1.getSelectedItem(), tbSteward.getSelectedRow(), 5);
        tbSteward.setValueAt(SkalaSteward1.getSelectedItem().toString(), tbSteward.getSelectedRow(), 6);
        tbSteward.setValueAt(NilaiSteward1.getText(), tbSteward.getSelectedRow(), 7);
        tbSteward.setValueAt(SkalaSteward2.getSelectedItem().toString(), tbSteward.getSelectedRow(), 8);
        tbSteward.setValueAt(NilaiSteward2.getText(), tbSteward.getSelectedRow(), 9);
        tbSteward.setValueAt(SkalaSteward3.getSelectedItem().toString(), tbSteward.getSelectedRow(), 10);
        tbSteward.setValueAt(NilaiSteward3.getText(), tbSteward.getSelectedRow(), 11);
        tbSteward.setValueAt(NilaiTotalSteward.getText(), tbSteward.getSelectedRow(), 12);
        tbSteward.setValueAt(Keluar1.getText(), tbSteward.getSelectedRow(), 13);
        tbSteward.setValueAt(Instruksi1.getText(), tbSteward.getSelectedRow(), 14);
        tbSteward.setValueAt(KdDokter1.getText(), tbSteward.getSelectedRow(), 15);
        tbSteward.setValueAt(NmDokter1.getText(), tbSteward.getSelectedRow(), 16);
        tbSteward.setValueAt(NIP1.getText(), tbSteward.getSelectedRow(), 17);
        tbSteward.setValueAt(NamaPetugas1.getText(), tbSteward.getSelectedRow(), 18);
        emptTeks();
    }
    
    private void gantiSkorAldrette() {
        if (tabModeAldrette.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbAldrette.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("skor_aldrette_pasca_anestesi","tanggal=? and no_rawat=?","no_rawat=?,tanggal=?,penilaian_skala1=?,penilaian_nilai1=?,"+
                "penilaian_skala2=?,penilaian_nilai2=?,penilaian_skala3=?,penilaian_nilai3=?,penilaian_skala4=?,"+
                "penilaian_nilai4=?,penilaian_skala5=?,penilaian_nilai5=?,"+
                "penilaian_totalnilai=?,keluar=?,instruksi=?,kd_dokter=?,nip=?",19,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal2.getSelectedItem()+"")+" "+Jam2.getSelectedItem()+":"+Menit2.getSelectedItem()+":"+Detik2.getSelectedItem(),
                SkalaAldrette1.getSelectedItem().toString(),NilaiAldrette1.getText(),SkalaAldrette2.getSelectedItem().toString(),NilaiAldrette2.getText(),SkalaAldrette3.getSelectedItem().toString(),NilaiAldrette3.getText(),
                SkalaAldrette4.getSelectedItem().toString(),NilaiAldrette4.getText(),SkalaAldrette5.getSelectedItem().toString(),NilaiAldrette5.getText(), 
                NilaiTotalAldrette.getText(),Keluar2.getText(),Instruksi2.getText(),KdDokter2.getText(),NIP2.getText(),tbAldrette.getValueAt(tbAldrette.getSelectedRow(),5).toString(),
                tbAldrette.getValueAt(tbAldrette.getSelectedRow(),0).toString()
            });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        tbAldrette.setValueAt(TNoRw.getText(), tbAldrette.getSelectedRow(), 0);
        tbAldrette.setValueAt(TNoRM.getText(), tbAldrette.getSelectedRow(), 1);
        tbAldrette.setValueAt(TPasien.getText(), tbAldrette.getSelectedRow(), 2);
        tbAldrette.setValueAt(TglLahir.getText(), tbAldrette.getSelectedRow(), 3);
        tbAldrette.setValueAt(JK.getText(), tbAldrette.getSelectedRow(), 4);
        tbAldrette.setValueAt(Valid.SetTgl(Tanggal2.getSelectedItem() + "") + " " + Jam2.getSelectedItem() + ":" + Menit2.getSelectedItem() + ":" + Detik2.getSelectedItem(), tbAldrette.getSelectedRow(), 5);
        tbAldrette.setValueAt(SkalaAldrette1.getSelectedItem().toString(), tbAldrette.getSelectedRow(), 6);
        tbAldrette.setValueAt(NilaiAldrette1.getText(), tbAldrette.getSelectedRow(), 7);
        tbAldrette.setValueAt(SkalaAldrette2.getSelectedItem().toString(), tbAldrette.getSelectedRow(), 8);
        tbAldrette.setValueAt(NilaiAldrette2.getText(), tbAldrette.getSelectedRow(), 9);
        tbAldrette.setValueAt(SkalaAldrette3.getSelectedItem().toString(), tbAldrette.getSelectedRow(), 10);
        tbAldrette.setValueAt(NilaiAldrette3.getText(), tbAldrette.getSelectedRow(), 11);
        tbAldrette.setValueAt(SkalaAldrette4.getSelectedItem().toString(), tbAldrette.getSelectedRow(), 12);
        tbAldrette.setValueAt(NilaiAldrette4.getText(), tbAldrette.getSelectedRow(), 13);
        tbAldrette.setValueAt(SkalaAldrette5.getSelectedItem().toString(), tbAldrette.getSelectedRow(), 14);
        tbAldrette.setValueAt(NilaiAldrette5.getText(), tbAldrette.getSelectedRow(), 15);
        tbAldrette.setValueAt(NilaiTotalAldrette.getText(), tbAldrette.getSelectedRow(), 16);
        tbAldrette.setValueAt(Keluar2.getText(), tbAldrette.getSelectedRow(), 17);
        tbAldrette.setValueAt(Instruksi2.getText(), tbAldrette.getSelectedRow(), 18);
        tbAldrette.setValueAt(KdDokter2.getText(), tbAldrette.getSelectedRow(), 19);
        tbAldrette.setValueAt(NmDokter2.getText(), tbAldrette.getSelectedRow(), 20);
        tbAldrette.setValueAt(NIP2.getText(), tbAldrette.getSelectedRow(), 21);
        tbAldrette.setValueAt(NamaPetugas2.getText(), tbAldrette.getSelectedRow(), 22);
        emptTeks();
    }
    
    private void gantiSkorPadss() {
        if (tabModePadss.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPadss.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("post_anesthesia_discharge_scoring_system","tanggal=? and no_rawat=?","no_rawat=?,tanggal=?,penilaian_skala1=?,penilaian_nilai1=?,"+
                "penilaian_skala2=?,penilaian_nilai2=?,penilaian_skala3=?,penilaian_nilai3=?,penilaian_skala4=?,"+
                "penilaian_nilai4=?,penilaian_skala5=?,penilaian_nilai5=?,"+
                "penilaian_totalnilai=?,keluar=?,instruksi=?,kd_dokter=?,nip=?",19,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal3.getSelectedItem()+"")+" "+Jam3.getSelectedItem()+":"+Menit3.getSelectedItem()+":"+Detik3.getSelectedItem(),
                SkalaPadss1.getSelectedItem().toString(),NilaiPadss1.getText(),SkalaPadss2.getSelectedItem().toString(),NilaiPadss2.getText(),SkalaPadss3.getSelectedItem().toString(),NilaiPadss3.getText(),
                SkalaPadss4.getSelectedItem().toString(),NilaiPadss4.getText(),SkalaPadss5.getSelectedItem().toString(),NilaiPadss5.getText(), 
                NilaiTotalPadss.getText(),Keluar3.getText(),Instruksi3.getText(),KdDokter3.getText(),NIP3.getText(),tbPadss.getValueAt(tbPadss.getSelectedRow(),5).toString(),
                tbPadss.getValueAt(tbPadss.getSelectedRow(),0).toString()
            });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        tbPadss.setValueAt(TNoRw.getText(), tbPadss.getSelectedRow(), 0);
        tbPadss.setValueAt(TNoRM.getText(), tbPadss.getSelectedRow(), 1);
        tbPadss.setValueAt(TPasien.getText(), tbPadss.getSelectedRow(), 2);
        tbPadss.setValueAt(TglLahir.getText(), tbPadss.getSelectedRow(), 3);
        tbPadss.setValueAt(JK.getText(), tbPadss.getSelectedRow(), 4);
        tbPadss.setValueAt(Valid.SetTgl(Tanggal3.getSelectedItem() + "") + " " + Jam3.getSelectedItem() + ":" + Menit3.getSelectedItem() + ":" + Detik3.getSelectedItem(), tbPadss.getSelectedRow(), 5);
        tbPadss.setValueAt(SkalaPadss1.getSelectedItem().toString(), tbPadss.getSelectedRow(), 6);
        tbPadss.setValueAt(NilaiPadss1.getText(), tbPadss.getSelectedRow(), 7);
        tbPadss.setValueAt(SkalaPadss2.getSelectedItem().toString(), tbPadss.getSelectedRow(), 8);
        tbPadss.setValueAt(NilaiPadss2.getText(), tbPadss.getSelectedRow(), 9);
        tbPadss.setValueAt(SkalaPadss3.getSelectedItem().toString(), tbPadss.getSelectedRow(), 10);
        tbPadss.setValueAt(NilaiPadss3.getText(), tbPadss.getSelectedRow(), 11);
        tbPadss.setValueAt(SkalaPadss4.getSelectedItem().toString(), tbPadss.getSelectedRow(), 12);
        tbPadss.setValueAt(NilaiPadss4.getText(), tbPadss.getSelectedRow(), 13);
        tbPadss.setValueAt(SkalaPadss5.getSelectedItem().toString(), tbPadss.getSelectedRow(), 14);
        tbPadss.setValueAt(NilaiPadss5.getText(), tbPadss.getSelectedRow(), 15);
        tbPadss.setValueAt(NilaiTotalPadss.getText(), tbPadss.getSelectedRow(), 16);
        tbPadss.setValueAt(Keluar3.getText(), tbPadss.getSelectedRow(), 17);
        tbPadss.setValueAt(Instruksi3.getText(), tbPadss.getSelectedRow(), 18);
        tbPadss.setValueAt(KdDokter3.getText(), tbPadss.getSelectedRow(), 19);
        tbPadss.setValueAt(NmDokter3.getText(), tbPadss.getSelectedRow(), 20);
        tbPadss.setValueAt(NIP3.getText(), tbPadss.getSelectedRow(), 21);
        tbPadss.setValueAt(NamaPetugas3.getText(), tbPadss.getSelectedRow(), 22);
        emptTeks();
    }
    
    private void emptTeksBromage() {
        Tanggal.setDate(new Date());
        ChkKejadian.setSelected(true);
        KdDokter.setText("");
        NmDokter.setText("");
        SkalaBromage.setSelectedIndex(3);
        NilaiBromage.setText("3");
        TingkatKriteria.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        Keluar.setText("");
        Instruksi.setText("");
        SkalaBromage.requestFocus();
    }
    
    private void emptTeksSteward() {
        Tanggal1.setDate(new Date());
        ChkKejadian1.setSelected(true);
        KdDokter1.setText("");
        NmDokter1.setText("");
        SkalaSteward1.setSelectedIndex(0);
        NilaiSteward1.setText("0");
        SkalaSteward2.setSelectedIndex(0);
        NilaiSteward2.setText("0");
        SkalaSteward3.setSelectedIndex(0);
        NilaiSteward3.setText("0");
        NilaiTotalSteward.setText("0");
        Keluar1.setText("");
        Instruksi1.setText("");
        TingkatSkor.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        NilaiSteward1.requestFocus();
    }
    
    private void emptTeksAldrette() {
        Tanggal2.setDate(new Date());
        ChkKejadian2.setSelected(true);
        KdDokter2.setText("");
        NmDokter2.setText("");
        SkalaAldrette1.setSelectedIndex(0);
        NilaiAldrette1.setText("0");
        SkalaAldrette2.setSelectedIndex(0);
        NilaiAldrette2.setText("0");
        SkalaAldrette3.setSelectedIndex(0);
        NilaiAldrette3.setText("0");
        SkalaAldrette4.setSelectedIndex(0);
        NilaiAldrette4.setText("0");
        SkalaAldrette5.setSelectedIndex(0);
        NilaiAldrette5.setText("0");
        NilaiTotalAldrette.setText("0");
        Keluar2.setText("");
        Instruksi2.setText("");
        TingkatSkor1.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        SkalaAldrette1.requestFocus();
    }
    
    private void emptTeksPadss() {
        Tanggal3.setDate(new Date());
        ChkKejadian3.setSelected(true);
        KdDokter3.setText("");
        NmDokter3.setText("");
        SkalaPadss1.setSelectedIndex(0);
        NilaiPadss1.setText("0");
        SkalaPadss2.setSelectedIndex(0);
        NilaiPadss2.setText("0");
        SkalaPadss3.setSelectedIndex(0);
        NilaiPadss3.setText("0");
        SkalaPadss4.setSelectedIndex(0);
        NilaiPadss4.setText("0");
        SkalaPadss5.setSelectedIndex(0);
        NilaiPadss5.setText("0");
        NilaiTotalPadss.setText("0");
        Keluar3.setText("");
        Instruksi3.setText("");
        TingkatSkor2.setText("Pasien Tidak Dapat Dipindahkan Ke Ruangan Perawatan, Karena Kondisi Yang Lemah");
        SkalaPadss1.requestFocus();
    }
    
    private void jam() {

        JCheckBox[] chkList = {ChkKejadian, ChkKejadian1, ChkKejadian2, ChkKejadian3};
        JComboBox[] jamList = {Jam, Jam1, Jam2, Jam3};
        JComboBox[] menitList = {Menit, Menit1, Menit2, Menit3};
        JComboBox[] detikList = {Detik, Detik1, Detik2, Detik3};

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Date now = Calendar.getInstance().getTime();

                for (int i = 0; i < chkList.length; i++) {

                    int nilai_jam;
                    int nilai_menit;
                    int nilai_detik;

                    if (chkList[i].isSelected()) {
                        nilai_jam = now.getHours();
                        nilai_menit = now.getMinutes();
                        nilai_detik = now.getSeconds();
                    } else {
                        nilai_jam = jamList[i].getSelectedIndex();
                        nilai_menit = menitList[i].getSelectedIndex();
                        nilai_detik = detikList[i].getSelectedIndex();
                    }

                    String jam = String.format("%02d", nilai_jam);
                    String menit = String.format("%02d", nilai_menit);
                    String detik = String.format("%02d", nilai_detik);

                    jamList[i].setSelectedItem(jam);
                    menitList[i].setSelectedItem(menit);
                    detikList[i].setSelectedItem(detik);
                }
            }
        };

        new Timer(1000, taskPerformer).start();
    }
    
}
