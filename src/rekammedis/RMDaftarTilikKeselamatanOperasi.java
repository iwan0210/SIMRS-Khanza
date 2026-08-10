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
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPegawai;

/**
 *
 * @author dosen
 */
public final class RMDaftarTilikKeselamatanOperasi extends javax.swing.JDialog {

    private final DefaultTableModel tabModePreOp, tabModeSignIn,
            tabModeTimeOut, tabModeSignOut, tabModePostOp;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private DlgCariPasien pasien = new DlgCariPasien(null, false);
    private DlgCariDokter dokter = new DlgCariDokter(null, false);
    public DlgCariPetugas petugas = new DlgCariPetugas(null, false);
    public DlgCariPegawai pegawai = new DlgCariPegawai(null, false);
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0, pilihan = 0;

    /**
     * Creates new form DlgPerawatan
     *
     * @param parent
     * @param modal
     */
    public RMDaftarTilikKeselamatanOperasi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8, 1);
        setSize(885, 674);

        tabModePreOp = new DefaultTableModel(null, new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","Tanggal","SN/CN","Tindakan","Kode Dokter Bedah","Nama Dokter Bedah",
            "Kode Dokter Anest","Nama Dokter Anestesi","Identitas","Keadaan Umum","Penandaan Area Operasi","Surat Ijin Bedah","Surat Ijin Anestesi",
            "Surat Ijin Transfusi","Persiapan Darah","Keterangan Persiapan Darah","Perlengkapan Khusus","Radiologi","Keterangan Radiologi",
            "EKG","Keterangan EKG","USG","Keterangan USG","CT Scan","Keterangan CT Scan","MRI","Keterangan MRI","NIP Ruangan","Petugas Ruangan",
            "NIP OK","Petugas Ruang OK"
        }) {
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbPreOp.setModel(tabModePreOp);
        tbPreOp.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbPreOp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 35; i++) {
            TableColumn column = tbPreOp.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(90);
            }else if(i==7){
                column.setPreferredWidth(160);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(160);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(53);
            }else if(i==13){
                column.setPreferredWidth(85);
            }else if(i==14){
                column.setPreferredWidth(130);
            }else if(i==15){
                column.setPreferredWidth(88);
            }else if(i==16){
                column.setPreferredWidth(98);
            }else if(i==17){
                column.setPreferredWidth(102);
            }else if(i==18){
                column.setPreferredWidth(89);
            }else if(i==19){
                column.setPreferredWidth(149);
            }else if(i==20){
                column.setPreferredWidth(109);
            }else if(i==21){
                column.setPreferredWidth(90);
            }else if(i==22){
                column.setPreferredWidth(120);
            }else if(i==23){
                column.setPreferredWidth(90);
            }else if(i==24){
                column.setPreferredWidth(120);
            }else if(i==25){
                column.setPreferredWidth(90);
            }else if(i==26){
                column.setPreferredWidth(120);
            }else if(i==27){
                column.setPreferredWidth(90);
            }else if(i==28){
                column.setPreferredWidth(120);
            }else if(i==29){
                column.setPreferredWidth(90);
            }else if(i==30){
                column.setPreferredWidth(120);
            }else if(i==31){
                column.setPreferredWidth(90);
            }else if(i==32){
                column.setPreferredWidth(150);
            }else if(i==33){
                column.setPreferredWidth(90);
            }else if(i==34){
                column.setPreferredWidth(150);
            }
        }
                
        tbPreOp.setDefaultRenderer(Object.class, new WarnaTable());

        tabModeSignIn = new DefaultTableModel(null, new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","Tanggal","SN/CN","Tindakan","Kode Dokter Bedah","Nama Dokter Bedah",
            "Kode Dokter Anest","Nama Dokter Anestesi","Identitas","Alergi","Area Operasi","Resiko Aspirasi","Antisipasi Resiko Aspirasi",
            "Kehilangan Darah","Jalur IV Line","Antisipasi Resiko Kehilangan Darah","Alat & Obat","Rencana Antisipasi Ketidaklengkapan Alat & Obat",
            "NIP OK","Petugas Ruang OK"
        }) {
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };

        tbSignIn.setModel(tabModeSignIn);
        tbSignIn.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbSignIn.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 24; i++) {
            TableColumn column = tbSignIn.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(90);
            }else if(i==7){
                column.setPreferredWidth(160);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(160);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(53);
            }else if(i==13){
                column.setPreferredWidth(130);
            }else if(i==14){
                column.setPreferredWidth(88);
            }else if(i==15){
                column.setPreferredWidth(83);
            }else if(i==16){
                column.setPreferredWidth(145);
            }else if(i==17){
                column.setPreferredWidth(95);
            }else if(i==18){
                column.setPreferredWidth(110);
            }else if(i==19){
                column.setPreferredWidth(180);
            }else if(i==20){
                column.setPreferredWidth(77);
            }else if(i==21){
                column.setPreferredWidth(250);
            }else if(i==22){
                column.setPreferredWidth(90);
            }else if(i==23){
                column.setPreferredWidth(150);
            }
        }

        tabModeTimeOut = new DefaultTableModel(null, new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","Tanggal","SN/CN","Tindakan","Kode Dokter Bedah","Nama Dokter Bedah",
            "Kode Dokter Anest","Nama Dokter Anestesi","Verbal Identitas","Verbal Tindakan","Verbal Area Insisi","Penandaan Area Operasi",
            "Lama Operasi","Penayangan Radiologi","Penayangan CT Scan","Penayangan MRI","Pemberian Antibiotik","Nama Antibiotik Diberikan",
            "Jam Pemberian","Antisipasi Kehilangan Darah","Ada Hal Khusus","Hal Khusus Yang Perlu Diperhatikan","Tgl.Steril","Petunjuk Sterilisasi",
            "Verifikasi Pre Operatif","NIP OK","Petugas Ruang OK"
        }) {
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbTimeOut.setModel(tabModeTimeOut);
        tbTimeOut.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbTimeOut.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 31; i++) {
            TableColumn column = tbTimeOut.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(90);
            }else if(i==7){
                column.setPreferredWidth(160);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(160);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(88);
            }else if(i==13){
                column.setPreferredWidth(88);
            }else if(i==14){
                column.setPreferredWidth(95);
            }else if(i==15){
                column.setPreferredWidth(130);
            }else if(i==16){
                column.setPreferredWidth(76);
            }else if(i==17){
                column.setPreferredWidth(117);
            }else if(i==18){
                column.setPreferredWidth(110);
            }else if(i==19){
                column.setPreferredWidth(90);
            }else if(i==20){
                column.setPreferredWidth(111);
            }else if(i==21){
                column.setPreferredWidth(135);
            }else if(i==22){
                column.setPreferredWidth(84);
            }else if(i==23){
                column.setPreferredWidth(145);
            }else if(i==24){
                column.setPreferredWidth(83);
            }else if(i==25){
                column.setPreferredWidth(181);
            }else if(i==26){
                column.setPreferredWidth(60);
            }else if(i==27){
                column.setPreferredWidth(100);
            }else if(i==28){
                column.setPreferredWidth(117);
            }else if(i==29){
                column.setPreferredWidth(90);
            }else if(i==30){
                column.setPreferredWidth(150);
            }
        }
        tbTimeOut.setDefaultRenderer(Object.class, new WarnaTable());

        tabModeSignOut = new DefaultTableModel(null, new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","Tanggal","SN/CN","Tindakan","Kode Dokter Bedah","Nama Dokter Bedah",
            "Kode Dokter Anest","Nama Dokter Anestesi","Verbal Tindakan","Verbal Kasa","Verbal Instrumen","Verbal Alat Tajam","Kelengkapan Spesimen Label",
            "Kelengkapan Spesimen Formulir","P.K.Dokter Bedah","P.K.Dokter Anestesi","P.K.Perawat OK","Perhatian Utama Fase Pemulihan",
            "NIP OK","Petugas Ruang OK"
            }) {
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbSignOut.setModel(tabModeSignOut);
        tbSignOut.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbSignOut.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 24; i++) {
            TableColumn column = tbSignOut.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(90);
            }else if(i==7){
                column.setPreferredWidth(160);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(160);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(87);
            }else if(i==13){
                column.setPreferredWidth(67);
            }else if(i==14){
                column.setPreferredWidth(94);
            }else if(i==15){
                column.setPreferredWidth(96);
            }else if(i==16){
                column.setPreferredWidth(167);
            }else if(i==17){
                column.setPreferredWidth(167);
            }else if(i==18){
                column.setPreferredWidth(91);
            }else if(i==19){
                column.setPreferredWidth(103);
            }else if(i==20){
                column.setPreferredWidth(84);
            }else if(i==21){
                column.setPreferredWidth(200);
            }else if(i==22){
                column.setPreferredWidth(90);
            }else if(i==23){
                column.setPreferredWidth(150);
            }
        }
        tbSignOut.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabModePostOp = new DefaultTableModel(null, new Object[]{
            "No.Rawat","No.RM","Nama Pasien","Tgl.Lahir","J.K.","Tanggal","SN/CN","Tindakan","Kode Dokter Bedah","Nama Dokter Bedah",
            "Kode Dokter Anest","Nama Dokter Anestesi","Keadaan Umum","Radiologi","Keterangan Radiologi","EKG","Keterangan EKG","USG",
            "Keterangan USG","CT Scan","Keterangan CT Scan","MRI","Keterangan MRI","Jenis Cairan Infus","Kateter Urine","Tgl.Pemasangan",
            "Warna Urine","Jml.Urine","Area Luka Operasi","Drain","Jml.Drain","Letak Drain","Warna Drain","Jaringan PA","NIP OK",
            "Petugas Ruang OK","NIP Anestesi","Petugas Anestesi"
            }) {
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        
        tbPostOp.setModel(tabModePostOp);
        tbPostOp.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbPostOp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (i = 0; i < 38; i++) {
            TableColumn column = tbPostOp.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(65);
            }else if(i==4){
                column.setPreferredWidth(25);
            }else if(i==5){
                column.setPreferredWidth(115);
            }else if(i==6){
                column.setPreferredWidth(90);
            }else if(i==7){
                column.setPreferredWidth(160);
            }else if(i==8){
                column.setPreferredWidth(100);
            }else if(i==9){
                column.setPreferredWidth(160);
            }else if(i==10){
                column.setPreferredWidth(100);
            }else if(i==11){
                column.setPreferredWidth(150);
            }else if(i==12){
                column.setPreferredWidth(85);
            }else if(i==13){
                column.setPreferredWidth(58);
            }else if(i==14){
                column.setPreferredWidth(115);
            }else if(i==15){
                column.setPreferredWidth(58);
            }else if(i==16){
                column.setPreferredWidth(100);
            }else if(i==17){
                column.setPreferredWidth(58);
            }else if(i==18){
                column.setPreferredWidth(100);
            }else if(i==19){
                column.setPreferredWidth(58);
            }else if(i==20){
                column.setPreferredWidth(110);
            }else if(i==21){
                column.setPreferredWidth(58);
            }else if(i==22){
                column.setPreferredWidth(100);
            }else if(i==23){
                column.setPreferredWidth(110);
            }else if(i==24){
                column.setPreferredWidth(75);
            }else if(i==25){
                column.setPreferredWidth(115);
            }else if(i==26){
                column.setPreferredWidth(68);
            }else if(i==27){
                column.setPreferredWidth(55);
            }else if(i==28){
                column.setPreferredWidth(150);
            }else if(i==29){
                column.setPreferredWidth(58);
            }else if(i==30){
                column.setPreferredWidth(57);
            }else if(i==31){
                column.setPreferredWidth(120);
            }else if(i==32){
                column.setPreferredWidth(90);
            }else if(i==33){
                column.setPreferredWidth(70);
            }else if(i==34){
                column.setPreferredWidth(90);
            }else if(i==35){
                column.setPreferredWidth(150);
            }else if(i==36){
                column.setPreferredWidth(90);
            }else if(i==37){
                column.setPreferredWidth(150);
            }
        }
        tbPostOp.setDefaultRenderer(Object.class, new WarnaTable());

        

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
                if (akses.getform().equals("RMDaftarTilikKeselamatanOperasi")) {
                    if (dokter.getTable().getSelectedRow() != -1) {
                       if(pilihan == 1) {
                            KodeDokterBedah.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                            NamaDokterBedah.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                            btnDokterBedah.requestFocus();
                        } else if (pilihan == 2) {
                            KodeDokterAnestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                            NamaDokterAnestesi.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                            btnDokterAnestesi.requestFocus();
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
                if (akses.getform().equals("RMDaftarTilikKeselamatanOperasi")) {
                    if (petugas.getTable().getSelectedRow() != -1) {
                        switch (TabRawat.getSelectedIndex()) {
                            case 0:
                                if (pilihan == 1) {
                                    KdPetugasRuangan.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                    NmPetugasRuangan.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                    btnPetugasRuangan.requestFocus();
                                } else if (pilihan == 2) {
                                    KdPetugasOK.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                    NmPetugasOK.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                    btnPetugasOK.requestFocus();
                                }
                                break;
                            case 1:
                                KdPetugasOK1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NmPetugasOK1.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                btnPetugasOK1.requestFocus();
                                break;
                            case 2:
                                KdPetugasOK2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NmPetugasOK2.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                btnPetugasOK2.requestFocus();
                                break;
                            case 3:
                                KdPetugasOK3.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                NmPetugasOK3.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                btnPetugasOK3.requestFocus();
                                break;
                            case 4:
                                if (pilihan == 1) {
                                    KdPetugasAnest.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                    NmPetugasAnest.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                    btnPetugasRuangan.requestFocus();
                                } else if (pilihan == 2) {
                                    KdPetugasOK4.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 0).toString());
                                    NmPetugasOK4.setText(petugas.getTable().getValueAt(petugas.getTable().getSelectedRow(), 1).toString());
                                    btnPetugasOK4.requestFocus();
                                }
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
        ChkInput4.setSelected(false);
        isForm5();

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
        tbPreOp = new widget.Table();
        PanelInput = new javax.swing.JPanel();
        ChkInput = new widget.CekBox();
        Scroll7 = new widget.ScrollPane();
        panelGlass12 = new widget.panelisi();
        jLabel20 = new widget.Label();
        jLabel50 = new widget.Label();
        Identitas = new widget.ComboBox();
        jLabel52 = new widget.Label();
        KeadaanUmum = new widget.ComboBox();
        IjinAnestesi = new widget.ComboBox();
        jLabel54 = new widget.Label();
        IjinBedah = new widget.ComboBox();
        jLabel64 = new widget.Label();
        jLabel58 = new widget.Label();
        PersiapanDarah = new widget.ComboBox();
        KeteranganPersiapanDarah = new widget.TextBox();
        jLabel56 = new widget.Label();
        jLabel55 = new widget.Label();
        jLabel51 = new widget.Label();
        AreaOperasi = new widget.ComboBox();
        IjinTransfusi = new widget.ComboBox();
        PerlengkapanKhusus = new widget.ComboBox();
        KeteranganEKG = new widget.TextBox();
        KeteranganCTScan = new widget.TextBox();
        CTScan = new widget.ComboBox();
        EKG = new widget.ComboBox();
        KeteranganRadiologi = new widget.TextBox();
        Radiologi = new widget.ComboBox();
        jLabel57 = new widget.Label();
        jLabel59 = new widget.Label();
        jLabel62 = new widget.Label();
        jLabel63 = new widget.Label();
        USG = new widget.ComboBox();
        MRI = new widget.ComboBox();
        KeteranganUSG = new widget.TextBox();
        KeteranganMRI = new widget.TextBox();
        jLabel18 = new widget.Label();
        KdPetugasRuangan = new widget.TextBox();
        NmPetugasRuangan = new widget.TextBox();
        btnPetugasRuangan = new widget.Button();
        jLabel27 = new widget.Label();
        KdPetugasOK = new widget.TextBox();
        jLabel61 = new widget.Label();
        jLabel60 = new widget.Label();
        NmPetugasOK = new widget.TextBox();
        btnPetugasOK = new widget.Button();
        internalFrame6 = new widget.InternalFrame();
        Scroll4 = new widget.ScrollPane();
        tbSignIn = new widget.Table();
        PanelInput1 = new javax.swing.JPanel();
        ChkInput1 = new widget.CekBox();
        Scroll8 = new widget.ScrollPane();
        panelGlass13 = new widget.panelisi();
        jLabel28 = new widget.Label();
        jLabel53 = new widget.Label();
        Identitas1 = new widget.ComboBox();
        jLabel29 = new widget.Label();
        Alergi = new widget.TextBox();
        jLabel65 = new widget.Label();
        AreaOperasi1 = new widget.ComboBox();
        jLabel66 = new widget.Label();
        ResikoAspirasi = new widget.ComboBox();
        jLabel30 = new widget.Label();
        AntisipasiResikoAspirasi = new widget.TextBox();
        jLabel67 = new widget.Label();
        ResikoKehilanganDarah = new widget.ComboBox();
        jLabel68 = new widget.Label();
        JalurIVLine = new widget.TextBox();
        jLabel31 = new widget.Label();
        RencanaAntisipasiKehilanganDarah = new widget.TextBox();
        jLabel69 = new widget.Label();
        KesiapanAlatAnes = new widget.ComboBox();
        jLabel32 = new widget.Label();
        RencanaAntisipasiKesiapanAlat = new widget.TextBox();
        jLabel33 = new widget.Label();
        KdPetugasOK1 = new widget.TextBox();
        NmPetugasOK1 = new widget.TextBox();
        btnPetugasOK1 = new widget.Button();
        internalFrame7 = new widget.InternalFrame();
        Scroll5 = new widget.ScrollPane();
        tbTimeOut = new widget.Table();
        PanelInput2 = new javax.swing.JPanel();
        ChkInput2 = new widget.CekBox();
        Scroll9 = new widget.ScrollPane();
        panelGlass14 = new widget.panelisi();
        jLabel34 = new widget.Label();
        jLabel70 = new widget.Label();
        jLabel71 = new widget.Label();
        AreaOperasi2 = new widget.ComboBox();
        jLabel35 = new widget.Label();
        VerbalIdentitas = new widget.ComboBox();
        jLabel36 = new widget.Label();
        VerbalTindakan = new widget.ComboBox();
        jLabel37 = new widget.Label();
        VerbalArea = new widget.ComboBox();
        jLabel38 = new widget.Label();
        PerkiraanLama = new widget.TextBox();
        jLabel39 = new widget.Label();
        jLabel72 = new widget.Label();
        jLabel73 = new widget.Label();
        PenayanganRadiologi = new widget.ComboBox();
        jLabel74 = new widget.Label();
        PenayanganCTScan = new widget.ComboBox();
        jLabel75 = new widget.Label();
        PenayanganMRI = new widget.ComboBox();
        jLabel76 = new widget.Label();
        PemberianAntibiotik = new widget.ComboBox();
        NamaAntibiotikDIberikan = new widget.TextBox();
        jLabel40 = new widget.Label();
        JamPemberianAntibiotik = new widget.TextBox();
        jLabel77 = new widget.Label();
        AntisipasiKehilanganDarah = new widget.TextBox();
        jLabel41 = new widget.Label();
        AdaHalKhusus = new widget.ComboBox();
        jLabel79 = new widget.Label();
        jLabel42 = new widget.Label();
        HalKhususDiperhatikan = new widget.TextBox();
        jLabel17 = new widget.Label();
        TanggalSeteril = new widget.Tanggal();
        jLabel43 = new widget.Label();
        PetunjukSterilisasi = new widget.ComboBox();
        jLabel44 = new widget.Label();
        VerifikasiOperatif = new widget.ComboBox();
        jLabel45 = new widget.Label();
        KdPetugasOK2 = new widget.TextBox();
        NmPetugasOK2 = new widget.TextBox();
        btnPetugasOK2 = new widget.Button();
        internalFrame8 = new widget.InternalFrame();
        Scroll6 = new widget.ScrollPane();
        tbSignOut = new widget.Table();
        PanelInput3 = new javax.swing.JPanel();
        ChkInput3 = new widget.CekBox();
        Scroll10 = new widget.ScrollPane();
        panelGlass15 = new widget.panelisi();
        jLabel46 = new widget.Label();
        jLabel78 = new widget.Label();
        jLabel47 = new widget.Label();
        VerbalTindakan1 = new widget.ComboBox();
        jLabel48 = new widget.Label();
        VerbalKasa = new widget.ComboBox();
        jLabel49 = new widget.Label();
        VerbalInstrumen = new widget.ComboBox();
        jLabel80 = new widget.Label();
        VerbalAlatTajam = new widget.ComboBox();
        jLabel81 = new widget.Label();
        jLabel82 = new widget.Label();
        KelengkapanSpesimenLabel = new widget.ComboBox();
        jLabel83 = new widget.Label();
        KelengkapanSpesimenFormulir = new widget.ComboBox();
        jLabel84 = new widget.Label();
        jLabel85 = new widget.Label();
        PeninjauanKembaliDokterBedah = new widget.ComboBox();
        jLabel86 = new widget.Label();
        PeninjauanKembaliDokterAnestesi = new widget.ComboBox();
        jLabel87 = new widget.Label();
        PeninjauanKembaliPerawatKamarOK = new widget.ComboBox();
        jLabel88 = new widget.Label();
        PerhatianUtamaFasePemulihan = new widget.TextBox();
        jLabel89 = new widget.Label();
        KdPetugasOK3 = new widget.TextBox();
        NmPetugasOK3 = new widget.TextBox();
        btnPetugasOK3 = new widget.Button();
        internalFrame9 = new widget.InternalFrame();
        Scroll11 = new widget.ScrollPane();
        tbPostOp = new widget.Table();
        PanelInput4 = new javax.swing.JPanel();
        ChkInput4 = new widget.CekBox();
        Scroll12 = new widget.ScrollPane();
        panelGlass16 = new widget.panelisi();
        jLabel24 = new widget.Label();
        jLabel90 = new widget.Label();
        KeadaanUmum1 = new widget.ComboBox();
        jLabel91 = new widget.Label();
        CairanInfus = new widget.TextBox();
        jLabel92 = new widget.Label();
        JaringanPA = new widget.ComboBox();
        jLabel93 = new widget.Label();
        KateterUrine = new widget.ComboBox();
        jLabel94 = new widget.Label();
        TanggalKateter = new widget.Tanggal();
        jLabel95 = new widget.Label();
        WarnaUrine = new widget.ComboBox();
        jLabel96 = new widget.Label();
        JumlahUrine = new widget.TextBox();
        jLabel97 = new widget.Label();
        jLabel98 = new widget.Label();
        Drain = new widget.ComboBox();
        jLabel99 = new widget.Label();
        JumlahDrain = new widget.TextBox();
        jLabel100 = new widget.Label();
        LetakDrain = new widget.TextBox();
        jLabel101 = new widget.Label();
        WarnaDrain = new widget.TextBox();
        jLabel102 = new widget.Label();
        jLabel103 = new widget.Label();
        Radiologi1 = new widget.ComboBox();
        KeteranganRadiologi1 = new widget.TextBox();
        jLabel104 = new widget.Label();
        EKG1 = new widget.ComboBox();
        KeteranganEKG1 = new widget.TextBox();
        MRI1 = new widget.ComboBox();
        jLabel105 = new widget.Label();
        KeteranganMRI1 = new widget.TextBox();
        jLabel106 = new widget.Label();
        USG1 = new widget.ComboBox();
        KeteranganUSG1 = new widget.TextBox();
        jLabel107 = new widget.Label();
        CTScan1 = new widget.ComboBox();
        KeteranganCTScan1 = new widget.TextBox();
        jLabel108 = new widget.Label();
        AreaLukaOperasi = new widget.TextBox();
        jLabel109 = new widget.Label();
        KdPetugasAnest = new widget.TextBox();
        NmPetugasAnest = new widget.TextBox();
        btnPetugasRuangan1 = new widget.Button();
        jLabel110 = new widget.Label();
        KdPetugasOK4 = new widget.TextBox();
        NmPetugasOK4 = new widget.TextBox();
        btnPetugasOK4 = new widget.Button();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        TNoRw = new widget.TextBox();
        TNoRM = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel8 = new widget.Label();
        TglLahir = new widget.TextBox();
        jLabel16 = new widget.Label();
        jLabel25 = new widget.Label();
        Tanggal = new widget.Tanggal();
        Tindakan = new widget.TextBox();
        jLabel22 = new widget.Label();
        SNCN = new widget.TextBox();
        jLabel23 = new widget.Label();
        jLabel26 = new widget.Label();
        KodeDokterBedah = new widget.TextBox();
        KodeDokterAnestesi = new widget.TextBox();
        NamaDokterBedah = new widget.TextBox();
        NamaDokterAnestesi = new widget.TextBox();
        btnDokterBedah = new widget.Button();
        btnDokterAnestesi = new widget.Button();
        jLabel4 = new widget.Label();

        JK.setHighlighter(null);
        JK.setName("JK"); // NOI18N
        JK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JKKeyPressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Daftar Tilik Keselamatan Operasi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
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
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21-04-2026" }));
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
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21-04-2026" }));
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

        tbPreOp.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPreOp.setName("tbPreOp"); // NOI18N
        tbPreOp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPreOpMouseClicked(evt);
            }
        });
        tbPreOp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPreOpKeyReleased(evt);
            }
        });
        Scroll3.setViewportView(tbPreOp);

        internalFrame5.add(Scroll3, java.awt.BorderLayout.CENTER);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 300));
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
        Scroll7.setPreferredSize(new java.awt.Dimension(46, 120));

        panelGlass12.setAutoscrolls(true);
        panelGlass12.setName("panelGlass12"); // NOI18N
        panelGlass12.setOpaque(false);
        panelGlass12.setPreferredSize(new java.awt.Dimension(44, 280));
        panelGlass12.setLayout(null);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Perawat Melakukan Konfirmasi :");
        jLabel20.setName("jLabel20"); // NOI18N
        panelGlass12.add(jLabel20);
        jLabel20.setBounds(20, 0, 190, 23);

        jLabel50.setText("Identitas :");
        jLabel50.setName("jLabel50"); // NOI18N
        panelGlass12.add(jLabel50);
        jLabel50.setBounds(0, 20, 140, 23);

        Identitas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        Identitas.setName("Identitas"); // NOI18N
        Identitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IdentitasKeyPressed(evt);
            }
        });
        panelGlass12.add(Identitas);
        Identitas.setBounds(150, 20, 80, 23);

        jLabel52.setText("Keadaan Umum Pasien :");
        jLabel52.setName("jLabel52"); // NOI18N
        panelGlass12.add(jLabel52);
        jLabel52.setBounds(250, 20, 140, 23);

        KeadaanUmum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baik", "Sedang", "Lemah" }));
        KeadaanUmum.setName("KeadaanUmum"); // NOI18N
        KeadaanUmum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeadaanUmumKeyPressed(evt);
            }
        });
        panelGlass12.add(KeadaanUmum);
        KeadaanUmum.setBounds(400, 20, 90, 23);

        IjinAnestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        IjinAnestesi.setName("IjinAnestesi"); // NOI18N
        IjinAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IjinAnestesiKeyPressed(evt);
            }
        });
        panelGlass12.add(IjinAnestesi);
        IjinAnestesi.setBounds(400, 50, 100, 23);

        jLabel54.setText("Surat Ijin Anestesi :");
        jLabel54.setName("jLabel54"); // NOI18N
        panelGlass12.add(jLabel54);
        jLabel54.setBounds(280, 50, 110, 23);

        IjinBedah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        IjinBedah.setName("IjinBedah"); // NOI18N
        IjinBedah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IjinBedahKeyPressed(evt);
            }
        });
        panelGlass12.add(IjinBedah);
        IjinBedah.setBounds(150, 50, 100, 23);

        jLabel64.setText("Surat Ijin Bedah :");
        jLabel64.setName("jLabel64"); // NOI18N
        panelGlass12.add(jLabel64);
        jLabel64.setBounds(0, 50, 140, 23);

        jLabel58.setText("Persiapan Darah :");
        jLabel58.setName("jLabel58"); // NOI18N
        panelGlass12.add(jLabel58);
        jLabel58.setBounds(50, 80, 90, 23);

        PersiapanDarah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        PersiapanDarah.setName("PersiapanDarah"); // NOI18N
        PersiapanDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PersiapanDarahKeyPressed(evt);
            }
        });
        panelGlass12.add(PersiapanDarah);
        PersiapanDarah.setBounds(150, 80, 135, 23);

        KeteranganPersiapanDarah.setHighlighter(null);
        KeteranganPersiapanDarah.setName("KeteranganPersiapanDarah"); // NOI18N
        KeteranganPersiapanDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganPersiapanDarahKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganPersiapanDarah);
        KeteranganPersiapanDarah.setBounds(290, 80, 150, 23);

        jLabel56.setText("Perlengkapan Khusus, Alat/Implan :");
        jLabel56.setName("jLabel56"); // NOI18N
        panelGlass12.add(jLabel56);
        jLabel56.setBounds(460, 80, 190, 23);

        jLabel55.setText("Surat Ijin Tranfusi :");
        jLabel55.setName("jLabel55"); // NOI18N
        panelGlass12.add(jLabel55);
        jLabel55.setBounds(520, 50, 130, 23);

        jLabel51.setText("Penandaan Area Operasi :");
        jLabel51.setName("jLabel51"); // NOI18N
        panelGlass12.add(jLabel51);
        jLabel51.setBounds(510, 20, 140, 23);

        AreaOperasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        AreaOperasi.setName("AreaOperasi"); // NOI18N
        AreaOperasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaOperasiKeyPressed(evt);
            }
        });
        panelGlass12.add(AreaOperasi);
        AreaOperasi.setBounds(660, 20, 135, 23);

        IjinTransfusi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        IjinTransfusi.setName("IjinTransfusi"); // NOI18N
        IjinTransfusi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IjinTransfusiKeyPressed(evt);
            }
        });
        panelGlass12.add(IjinTransfusi);
        IjinTransfusi.setBounds(660, 50, 135, 23);

        PerlengkapanKhusus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        PerlengkapanKhusus.setName("PerlengkapanKhusus"); // NOI18N
        PerlengkapanKhusus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PerlengkapanKhususKeyPressed(evt);
            }
        });
        panelGlass12.add(PerlengkapanKhusus);
        PerlengkapanKhusus.setBounds(660, 80, 135, 23);

        KeteranganEKG.setHighlighter(null);
        KeteranganEKG.setName("KeteranganEKG"); // NOI18N
        KeteranganEKG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganEKGKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganEKG);
        KeteranganEKG.setBounds(680, 130, 120, 23);

        KeteranganCTScan.setHighlighter(null);
        KeteranganCTScan.setName("KeteranganCTScan"); // NOI18N
        KeteranganCTScan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganCTScanKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganCTScan);
        KeteranganCTScan.setBounds(680, 160, 120, 23);

        CTScan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        CTScan.setName("CTScan"); // NOI18N
        CTScan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTScanKeyPressed(evt);
            }
        });
        panelGlass12.add(CTScan);
        CTScan.setBounds(540, 160, 135, 23);

        EKG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        EKG.setName("EKG"); // NOI18N
        EKG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EKGKeyPressed(evt);
            }
        });
        panelGlass12.add(EKG);
        EKG.setBounds(540, 130, 135, 23);

        KeteranganRadiologi.setHighlighter(null);
        KeteranganRadiologi.setName("KeteranganRadiologi"); // NOI18N
        KeteranganRadiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganRadiologiKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganRadiologi);
        KeteranganRadiologi.setBounds(320, 130, 120, 23);

        Radiologi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        Radiologi.setName("Radiologi"); // NOI18N
        Radiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RadiologiKeyPressed(evt);
            }
        });
        panelGlass12.add(Radiologi);
        Radiologi.setBounds(180, 130, 135, 23);

        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setText("Hasil Pemeriksaan Penunjang :");
        jLabel57.setName("jLabel57"); // NOI18N
        panelGlass12.add(jLabel57);
        jLabel57.setBounds(60, 110, 170, 23);

        jLabel59.setText("Radiologi :");
        jLabel59.setName("jLabel59"); // NOI18N
        panelGlass12.add(jLabel59);
        jLabel59.setBounds(70, 130, 100, 23);

        jLabel62.setText("USG :");
        jLabel62.setName("jLabel62"); // NOI18N
        panelGlass12.add(jLabel62);
        jLabel62.setBounds(70, 160, 100, 23);

        jLabel63.setText("MRI :");
        jLabel63.setName("jLabel63"); // NOI18N
        panelGlass12.add(jLabel63);
        jLabel63.setBounds(70, 190, 100, 23);

        USG.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        USG.setName("USG"); // NOI18N
        USG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                USGKeyPressed(evt);
            }
        });
        panelGlass12.add(USG);
        USG.setBounds(180, 160, 135, 23);

        MRI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        MRI.setName("MRI"); // NOI18N
        MRI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MRIKeyPressed(evt);
            }
        });
        panelGlass12.add(MRI);
        MRI.setBounds(180, 190, 135, 23);

        KeteranganUSG.setHighlighter(null);
        KeteranganUSG.setName("KeteranganUSG"); // NOI18N
        KeteranganUSG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganUSGKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganUSG);
        KeteranganUSG.setBounds(320, 160, 120, 23);

        KeteranganMRI.setHighlighter(null);
        KeteranganMRI.setName("KeteranganMRI"); // NOI18N
        KeteranganMRI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganMRIKeyPressed(evt);
            }
        });
        panelGlass12.add(KeteranganMRI);
        KeteranganMRI.setBounds(320, 190, 120, 23);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Petugas Ruangan");
        jLabel18.setName("jLabel18"); // NOI18N
        panelGlass12.add(jLabel18);
        jLabel18.setBounds(20, 230, 103, 23);

        KdPetugasRuangan.setEditable(false);
        KdPetugasRuangan.setHighlighter(null);
        KdPetugasRuangan.setName("KdPetugasRuangan"); // NOI18N
        panelGlass12.add(KdPetugasRuangan);
        KdPetugasRuangan.setBounds(120, 230, 95, 23);

        NmPetugasRuangan.setEditable(false);
        NmPetugasRuangan.setName("NmPetugasRuangan"); // NOI18N
        panelGlass12.add(NmPetugasRuangan);
        NmPetugasRuangan.setBounds(220, 230, 165, 23);

        btnPetugasRuangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasRuangan.setMnemonic('2');
        btnPetugasRuangan.setToolTipText("ALt+2");
        btnPetugasRuangan.setName("btnPetugasRuangan"); // NOI18N
        btnPetugasRuangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasRuanganActionPerformed(evt);
            }
        });
        btnPetugasRuangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasRuanganKeyPressed(evt);
            }
        });
        panelGlass12.add(btnPetugasRuangan);
        btnPetugasRuangan.setBounds(390, 230, 28, 23);

        jLabel27.setText("Petugas OK :");
        jLabel27.setName("jLabel27"); // NOI18N
        panelGlass12.add(jLabel27);
        jLabel27.setBounds(430, 230, 70, 23);

        KdPetugasOK.setEditable(false);
        KdPetugasOK.setHighlighter(null);
        KdPetugasOK.setName("KdPetugasOK"); // NOI18N
        panelGlass12.add(KdPetugasOK);
        KdPetugasOK.setBounds(500, 230, 95, 23);

        jLabel61.setText("CT Scan :");
        jLabel61.setName("jLabel61"); // NOI18N
        panelGlass12.add(jLabel61);
        jLabel61.setBounds(460, 160, 70, 23);

        jLabel60.setText("EKG :");
        jLabel60.setName("jLabel60"); // NOI18N
        panelGlass12.add(jLabel60);
        jLabel60.setBounds(460, 130, 70, 23);

        NmPetugasOK.setEditable(false);
        NmPetugasOK.setName("NmPetugasOK"); // NOI18N
        panelGlass12.add(NmPetugasOK);
        NmPetugasOK.setBounds(600, 230, 165, 23);

        btnPetugasOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasOK.setMnemonic('2');
        btnPetugasOK.setToolTipText("ALt+2");
        btnPetugasOK.setName("btnPetugasOK"); // NOI18N
        btnPetugasOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasOKActionPerformed(evt);
            }
        });
        btnPetugasOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasOKKeyPressed(evt);
            }
        });
        panelGlass12.add(btnPetugasOK);
        btnPetugasOK.setBounds(770, 230, 28, 23);

        Scroll7.setViewportView(panelGlass12);

        PanelInput.add(Scroll7, java.awt.BorderLayout.CENTER);

        internalFrame5.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Check List Pre Operasi", internalFrame5);

        internalFrame6.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame6.setName("internalFrame6"); // NOI18N
        internalFrame6.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll4.setName("Scroll4"); // NOI18N
        Scroll4.setOpaque(true);

        tbSignIn.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbSignIn.setName("tbSignIn"); // NOI18N
        tbSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSignInMouseClicked(evt);
            }
        });
        tbSignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbSignInKeyReleased(evt);
            }
        });
        Scroll4.setViewportView(tbSignIn);

        internalFrame6.add(Scroll4, java.awt.BorderLayout.CENTER);

        PanelInput1.setName("PanelInput1"); // NOI18N
        PanelInput1.setOpaque(false);
        PanelInput1.setPreferredSize(new java.awt.Dimension(192, 300));
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
        Scroll8.setPreferredSize(new java.awt.Dimension(46, 120));

        panelGlass13.setName("panelGlass13"); // NOI18N
        panelGlass13.setPreferredSize(new java.awt.Dimension(44, 280));
        panelGlass13.setLayout(null);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("Perawat OK & Tim Anestesi Mengkonfirmasi :");
        jLabel28.setName("jLabel28"); // NOI18N
        panelGlass13.add(jLabel28);
        jLabel28.setBounds(20, 0, 300, 23);

        jLabel53.setText("Identitas :");
        jLabel53.setName("jLabel53"); // NOI18N
        panelGlass13.add(jLabel53);
        jLabel53.setBounds(0, 20, 110, 23);

        Identitas1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        Identitas1.setName("Identitas1"); // NOI18N
        Identitas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Identitas1KeyPressed(evt);
            }
        });
        panelGlass13.add(Identitas1);
        Identitas1.setBounds(120, 20, 80, 23);

        jLabel29.setText("Alergi :");
        jLabel29.setName("jLabel29"); // NOI18N
        panelGlass13.add(jLabel29);
        jLabel29.setBounds(200, 20, 60, 23);

        Alergi.setHighlighter(null);
        Alergi.setName("Alergi"); // NOI18N
        Alergi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AlergiKeyPressed(evt);
            }
        });
        panelGlass13.add(Alergi);
        Alergi.setBounds(270, 20, 230, 23);

        jLabel65.setText("Penandaan Area Operasi :");
        jLabel65.setName("jLabel65"); // NOI18N
        panelGlass13.add(jLabel65);
        jLabel65.setBounds(510, 20, 140, 23);

        AreaOperasi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        AreaOperasi1.setName("AreaOperasi1"); // NOI18N
        AreaOperasi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaOperasi1KeyPressed(evt);
            }
        });
        panelGlass13.add(AreaOperasi1);
        AreaOperasi1.setBounds(660, 20, 135, 23);

        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel66.setText("Resiko Aspirasi & Faktor Penyulit");
        jLabel66.setName("jLabel66"); // NOI18N
        panelGlass13.add(jLabel66);
        jLabel66.setBounds(60, 50, 170, 23);

        ResikoAspirasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        ResikoAspirasi.setName("ResikoAspirasi"); // NOI18N
        ResikoAspirasi.setPreferredSize(new java.awt.Dimension(90, 20));
        ResikoAspirasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ResikoAspirasiKeyPressed(evt);
            }
        });
        panelGlass13.add(ResikoAspirasi);
        ResikoAspirasi.setBounds(230, 50, 100, 23);

        jLabel30.setText("Bila Ada Resiko, Rencana Antisipasi :");
        jLabel30.setName("jLabel30"); // NOI18N
        panelGlass13.add(jLabel30);
        jLabel30.setBounds(330, 50, 190, 23);

        AntisipasiResikoAspirasi.setHighlighter(null);
        AntisipasiResikoAspirasi.setName("AntisipasiResikoAspirasi"); // NOI18N
        AntisipasiResikoAspirasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AntisipasiResikoAspirasiKeyPressed(evt);
            }
        });
        panelGlass13.add(AntisipasiResikoAspirasi);
        AntisipasiResikoAspirasi.setBounds(530, 50, 265, 23);

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel67.setText("Resiko Kehilangan Darah > 500 ml (7 ml/Kg Berat Badan Untuk Anak)");
        jLabel67.setName("jLabel67"); // NOI18N
        panelGlass13.add(jLabel67);
        jLabel67.setBounds(60, 80, 350, 23);

        ResikoKehilanganDarah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tidak Ada", "Ada" }));
        ResikoKehilanganDarah.setName("ResikoKehilanganDarah"); // NOI18N
        ResikoKehilanganDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ResikoKehilanganDarahKeyPressed(evt);
            }
        });
        panelGlass13.add(ResikoKehilanganDarah);
        ResikoKehilanganDarah.setBounds(410, 80, 100, 23);

        jLabel68.setText("Jika Ada, Jalur IV Line :");
        jLabel68.setName("jLabel68"); // NOI18N
        panelGlass13.add(jLabel68);
        jLabel68.setBounds(510, 80, 120, 23);

        JalurIVLine.setHighlighter(null);
        JalurIVLine.setName("JalurIVLine"); // NOI18N
        JalurIVLine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JalurIVLineKeyPressed(evt);
            }
        });
        panelGlass13.add(JalurIVLine);
        JalurIVLine.setBounds(640, 80, 155, 23);

        jLabel31.setText("Kesiapan Alat & Obat Anestesi :");
        jLabel31.setName("jLabel31"); // NOI18N
        panelGlass13.add(jLabel31);
        jLabel31.setBounds(0, 110, 330, 23);

        RencanaAntisipasiKehilanganDarah.setHighlighter(null);
        RencanaAntisipasiKehilanganDarah.setName("RencanaAntisipasiKehilanganDarah"); // NOI18N
        RencanaAntisipasiKehilanganDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RencanaAntisipasiKehilanganDarahKeyPressed(evt);
            }
        });
        panelGlass13.add(RencanaAntisipasiKehilanganDarah);
        RencanaAntisipasiKehilanganDarah.setBounds(340, 110, 455, 23);

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("Kesiapan Alat & Obat Anestesi");
        jLabel69.setName("jLabel69"); // NOI18N
        panelGlass13.add(jLabel69);
        jLabel69.setBounds(60, 140, 160, 23);

        KesiapanAlatAnes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lengkap", "Pulsa Oximetri", "Tidak Lengkap" }));
        KesiapanAlatAnes.setName("KesiapanAlatAnes"); // NOI18N
        KesiapanAlatAnes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KesiapanAlatAnesKeyPressed(evt);
            }
        });
        panelGlass13.add(KesiapanAlatAnes);
        KesiapanAlatAnes.setBounds(220, 140, 125, 23);

        jLabel32.setText("Bila Tidak Lengkap, Rencana Antisipasi :");
        jLabel32.setName("jLabel32"); // NOI18N
        panelGlass13.add(jLabel32);
        jLabel32.setBounds(340, 140, 210, 23);

        RencanaAntisipasiKesiapanAlat.setHighlighter(null);
        RencanaAntisipasiKesiapanAlat.setName("RencanaAntisipasiKesiapanAlat"); // NOI18N
        RencanaAntisipasiKesiapanAlat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RencanaAntisipasiKesiapanAlatKeyPressed(evt);
            }
        });
        panelGlass13.add(RencanaAntisipasiKesiapanAlat);
        RencanaAntisipasiKesiapanAlat.setBounds(560, 140, 235, 23);

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Perawat Kamar Operasi");
        jLabel33.setName("jLabel33"); // NOI18N
        panelGlass13.add(jLabel33);
        jLabel33.setBounds(20, 180, 130, 23);

        KdPetugasOK1.setEditable(false);
        KdPetugasOK1.setHighlighter(null);
        KdPetugasOK1.setName("KdPetugasOK1"); // NOI18N
        panelGlass13.add(KdPetugasOK1);
        KdPetugasOK1.setBounds(150, 180, 110, 23);

        NmPetugasOK1.setEditable(false);
        NmPetugasOK1.setName("NmPetugasOK1"); // NOI18N
        panelGlass13.add(NmPetugasOK1);
        NmPetugasOK1.setBounds(260, 180, 300, 23);

        btnPetugasOK1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasOK1.setMnemonic('2');
        btnPetugasOK1.setToolTipText("ALt+2");
        btnPetugasOK1.setName("btnPetugasOK1"); // NOI18N
        btnPetugasOK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasOK1ActionPerformed(evt);
            }
        });
        btnPetugasOK1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasOK1KeyPressed(evt);
            }
        });
        panelGlass13.add(btnPetugasOK1);
        btnPetugasOK1.setBounds(560, 180, 28, 23);

        Scroll8.setViewportView(panelGlass13);

        PanelInput1.add(Scroll8, java.awt.BorderLayout.CENTER);

        internalFrame6.add(PanelInput1, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Sign-In", internalFrame6);

        internalFrame7.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame7.setName("internalFrame7"); // NOI18N
        internalFrame7.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll5.setName("Scroll5"); // NOI18N
        Scroll5.setOpaque(true);

        tbTimeOut.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbTimeOut.setName("tbTimeOut"); // NOI18N
        tbTimeOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTimeOutMouseClicked(evt);
            }
        });
        tbTimeOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbTimeOutKeyReleased(evt);
            }
        });
        Scroll5.setViewportView(tbTimeOut);

        internalFrame7.add(Scroll5, java.awt.BorderLayout.CENTER);

        PanelInput2.setName("PanelInput2"); // NOI18N
        PanelInput2.setOpaque(false);
        PanelInput2.setPreferredSize(new java.awt.Dimension(192, 300));
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
        Scroll9.setPreferredSize(new java.awt.Dimension(46, 120));

        panelGlass14.setName("panelGlass14"); // NOI18N
        panelGlass14.setPreferredSize(new java.awt.Dimension(44, 280));
        panelGlass14.setLayout(null);

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel34.setText("Konfirmasi Dipimpin Oleh Salah Satu Anggota Tim, Semua Kegiatan Ditangguhkan Kecuali Jika Mengancam Jiwa :");
        jLabel34.setName("jLabel34"); // NOI18N
        panelGlass14.add(jLabel34);
        jLabel34.setBounds(20, 0, 600, 23);

        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel70.setText("Verbalisasi Tim, Konfirmasi :");
        jLabel70.setName("jLabel70"); // NOI18N
        panelGlass14.add(jLabel70);
        jLabel70.setBounds(40, 20, 200, 23);

        jLabel71.setText("Penandaan Area Operasi :");
        jLabel71.setName("jLabel71"); // NOI18N
        panelGlass14.add(jLabel71);
        jLabel71.setBounds(510, 20, 140, 23);

        AreaOperasi2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada", "Tidak Diperlukan" }));
        AreaOperasi2.setName("AreaOperasi2"); // NOI18N
        AreaOperasi2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaOperasi2KeyPressed(evt);
            }
        });
        panelGlass14.add(AreaOperasi2);
        AreaOperasi2.setBounds(650, 20, 135, 23);

        jLabel35.setText("Identitas :");
        jLabel35.setName("jLabel35"); // NOI18N
        panelGlass14.add(jLabel35);
        jLabel35.setBounds(60, 40, 60, 23);

        VerbalIdentitas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalIdentitas.setName("VerbalIdentitas"); // NOI18N
        VerbalIdentitas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalIdentitasKeyPressed(evt);
            }
        });
        panelGlass14.add(VerbalIdentitas);
        VerbalIdentitas.setBounds(120, 40, 80, 23);

        jLabel36.setText("Tindakan :");
        jLabel36.setName("jLabel36"); // NOI18N
        panelGlass14.add(jLabel36);
        jLabel36.setBounds(200, 40, 60, 23);

        VerbalTindakan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalTindakan.setName("VerbalTindakan"); // NOI18N
        VerbalTindakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalTindakanKeyPressed(evt);
            }
        });
        panelGlass14.add(VerbalTindakan);
        VerbalTindakan.setBounds(270, 40, 80, 23);

        jLabel37.setText("Area Insisi :");
        jLabel37.setName("jLabel37"); // NOI18N
        panelGlass14.add(jLabel37);
        jLabel37.setBounds(350, 40, 67, 23);

        VerbalArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalArea.setName("VerbalArea"); // NOI18N
        VerbalArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalAreaKeyPressed(evt);
            }
        });
        panelGlass14.add(VerbalArea);
        VerbalArea.setBounds(420, 40, 80, 23);

        jLabel38.setText("Perkiraan Lama Operasi :");
        jLabel38.setName("jLabel38"); // NOI18N
        panelGlass14.add(jLabel38);
        jLabel38.setBounds(510, 50, 140, 23);

        PerkiraanLama.setHighlighter(null);
        PerkiraanLama.setName("PerkiraanLama"); // NOI18N
        PerkiraanLama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PerkiraanLamaKeyPressed(evt);
            }
        });
        panelGlass14.add(PerkiraanLama);
        PerkiraanLama.setBounds(650, 50, 80, 23);

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("Jam");
        jLabel39.setName("jLabel39"); // NOI18N
        panelGlass14.add(jLabel39);
        jLabel39.setBounds(740, 50, 30, 23);

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel72.setText("Penayangan Hasil Pemeriksaan Penunjang :");
        jLabel72.setName("jLabel72"); // NOI18N
        panelGlass14.add(jLabel72);
        jLabel72.setBounds(40, 70, 240, 23);

        jLabel73.setText("Radiologi :");
        jLabel73.setName("jLabel73"); // NOI18N
        panelGlass14.add(jLabel73);
        jLabel73.setBounds(90, 90, 90, 23);

        PenayanganRadiologi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ditayangkan", "Benar", "Tidak Diperlukan" }));
        PenayanganRadiologi.setName("PenayanganRadiologi"); // NOI18N
        PenayanganRadiologi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PenayanganRadiologiKeyPressed(evt);
            }
        });
        panelGlass14.add(PenayanganRadiologi);
        PenayanganRadiologi.setBounds(190, 90, 135, 23);

        jLabel74.setText("CT Scan :");
        jLabel74.setName("jLabel74"); // NOI18N
        panelGlass14.add(jLabel74);
        jLabel74.setBounds(370, 90, 60, 23);

        PenayanganCTScan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ditayangkan", "Benar", "Tidak Diperlukan" }));
        PenayanganCTScan.setName("PenayanganCTScan"); // NOI18N
        PenayanganCTScan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PenayanganCTScanKeyPressed(evt);
            }
        });
        panelGlass14.add(PenayanganCTScan);
        PenayanganCTScan.setBounds(430, 90, 135, 23);

        jLabel75.setText("MRI :");
        jLabel75.setName("jLabel75"); // NOI18N
        panelGlass14.add(jLabel75);
        jLabel75.setBounds(590, 90, 60, 23);

        PenayanganMRI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ditayangkan", "Benar", "Tidak Diperlukan" }));
        PenayanganMRI.setName("PenayanganMRI"); // NOI18N
        PenayanganMRI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PenayanganMRIKeyPressed(evt);
            }
        });
        panelGlass14.add(PenayanganMRI);
        PenayanganMRI.setBounds(650, 90, 135, 23);

        jLabel76.setText("Pemberian Antibiotik Profilaksis :");
        jLabel76.setName("jLabel76"); // NOI18N
        panelGlass14.add(jLabel76);
        jLabel76.setBounds(0, 120, 200, 23);

        PemberianAntibiotik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        PemberianAntibiotik.setName("PemberianAntibiotik"); // NOI18N
        PemberianAntibiotik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PemberianAntibiotikKeyPressed(evt);
            }
        });
        panelGlass14.add(PemberianAntibiotik);
        PemberianAntibiotik.setBounds(210, 120, 80, 23);

        NamaAntibiotikDIberikan.setHighlighter(null);
        NamaAntibiotikDIberikan.setName("NamaAntibiotikDIberikan"); // NOI18N
        NamaAntibiotikDIberikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NamaAntibiotikDIberikanKeyPressed(evt);
            }
        });
        panelGlass14.add(NamaAntibiotikDIberikan);
        NamaAntibiotikDIberikan.setBounds(380, 120, 258, 23);

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText(", Jam Pemberian :");
        jLabel40.setName("jLabel40"); // NOI18N
        panelGlass14.add(jLabel40);
        jLabel40.setBounds(640, 120, 90, 23);

        JamPemberianAntibiotik.setHighlighter(null);
        JamPemberianAntibiotik.setName("JamPemberianAntibiotik"); // NOI18N
        JamPemberianAntibiotik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JamPemberianAntibiotikKeyPressed(evt);
            }
        });
        panelGlass14.add(JamPemberianAntibiotik);
        JamPemberianAntibiotik.setBounds(730, 120, 60, 23);

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("Antisipasi Kehilangan Darah > 500 ml (7 ml/Kg BB Untuk Anak) :");
        jLabel77.setName("jLabel77"); // NOI18N
        panelGlass14.add(jLabel77);
        jLabel77.setBounds(40, 150, 320, 23);

        AntisipasiKehilanganDarah.setHighlighter(null);
        AntisipasiKehilanganDarah.setName("AntisipasiKehilanganDarah"); // NOI18N
        AntisipasiKehilanganDarah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AntisipasiKehilanganDarahKeyPressed(evt);
            }
        });
        panelGlass14.add(AntisipasiKehilanganDarah);
        AntisipasiKehilanganDarah.setBounds(360, 150, 433, 23);

        jLabel41.setText("Hal Khusus yang Perlu Perhatian :");
        jLabel41.setName("jLabel41"); // NOI18N
        panelGlass14.add(jLabel41);
        jLabel41.setBounds(0, 180, 205, 23);

        AdaHalKhusus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        AdaHalKhusus.setName("AdaHalKhusus"); // NOI18N
        AdaHalKhusus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AdaHalKhususKeyPressed(evt);
            }
        });
        panelGlass14.add(AdaHalKhusus);
        AdaHalKhusus.setBounds(210, 180, 100, 23);

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText(", Jika Ada :");
        jLabel79.setName("jLabel79"); // NOI18N
        panelGlass14.add(jLabel79);
        jLabel79.setBounds(310, 180, 60, 23);

        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText(", Jika Diberikan :");
        jLabel42.setName("jLabel42"); // NOI18N
        panelGlass14.add(jLabel42);
        jLabel42.setBounds(290, 120, 85, 23);

        HalKhususDiperhatikan.setHighlighter(null);
        HalKhususDiperhatikan.setName("HalKhususDiperhatikan"); // NOI18N
        HalKhususDiperhatikan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HalKhususDiperhatikanKeyPressed(evt);
            }
        });
        panelGlass14.add(HalKhususDiperhatikan);
        HalKhususDiperhatikan.setBounds(370, 180, 418, 23);

        jLabel17.setText("Tanggal Steril :");
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.setVerifyInputWhenFocusTarget(false);
        panelGlass14.add(jLabel17);
        jLabel17.setBounds(0, 210, 115, 23);

        TanggalSeteril.setForeground(new java.awt.Color(50, 70, 50));
        TanggalSeteril.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21-04-2026" }));
        TanggalSeteril.setDisplayFormat("dd-MM-yyyy");
        TanggalSeteril.setName("TanggalSeteril"); // NOI18N
        TanggalSeteril.setOpaque(false);
        TanggalSeteril.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalSeterilKeyPressed(evt);
            }
        });
        panelGlass14.add(TanggalSeteril);
        TanggalSeteril.setBounds(120, 210, 90, 23);

        jLabel43.setText("Petunjuk Sterilisasi Telah Dikonfirmasi :");
        jLabel43.setName("jLabel43"); // NOI18N
        panelGlass14.add(jLabel43);
        jLabel43.setBounds(220, 210, 200, 23);

        PetunjukSterilisasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        PetunjukSterilisasi.setName("PetunjukSterilisasi"); // NOI18N
        PetunjukSterilisasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PetunjukSterilisasiKeyPressed(evt);
            }
        });
        panelGlass14.add(PetunjukSterilisasi);
        PetunjukSterilisasi.setBounds(420, 210, 80, 23);

        jLabel44.setText("Verifikasi Pre Operatif Telah Dilakukan :");
        jLabel44.setName("jLabel44"); // NOI18N
        panelGlass14.add(jLabel44);
        jLabel44.setBounds(500, 210, 210, 23);

        VerifikasiOperatif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerifikasiOperatif.setName("VerifikasiOperatif"); // NOI18N
        VerifikasiOperatif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerifikasiOperatifKeyPressed(evt);
            }
        });
        panelGlass14.add(VerifikasiOperatif);
        VerifikasiOperatif.setBounds(710, 210, 80, 23);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("Perawat Kamar Operasi");
        jLabel45.setName("jLabel45"); // NOI18N
        panelGlass14.add(jLabel45);
        jLabel45.setBounds(20, 250, 130, 23);

        KdPetugasOK2.setEditable(false);
        KdPetugasOK2.setHighlighter(null);
        KdPetugasOK2.setName("KdPetugasOK2"); // NOI18N
        panelGlass14.add(KdPetugasOK2);
        KdPetugasOK2.setBounds(150, 250, 110, 23);

        NmPetugasOK2.setEditable(false);
        NmPetugasOK2.setName("NmPetugasOK2"); // NOI18N
        panelGlass14.add(NmPetugasOK2);
        NmPetugasOK2.setBounds(267, 250, 300, 23);

        btnPetugasOK2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasOK2.setMnemonic('2');
        btnPetugasOK2.setToolTipText("ALt+2");
        btnPetugasOK2.setName("btnPetugasOK2"); // NOI18N
        btnPetugasOK2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasOK2ActionPerformed(evt);
            }
        });
        btnPetugasOK2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasOK2KeyPressed(evt);
            }
        });
        panelGlass14.add(btnPetugasOK2);
        btnPetugasOK2.setBounds(570, 250, 28, 23);

        Scroll9.setViewportView(panelGlass14);

        PanelInput2.add(Scroll9, java.awt.BorderLayout.CENTER);

        internalFrame7.add(PanelInput2, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Time-Out", internalFrame7);

        internalFrame8.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame8.setName("internalFrame8"); // NOI18N
        internalFrame8.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll6.setName("Scroll6"); // NOI18N
        Scroll6.setOpaque(true);

        tbSignOut.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbSignOut.setName("tbSignOut"); // NOI18N
        tbSignOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSignOutMouseClicked(evt);
            }
        });
        tbSignOut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbSignOutKeyReleased(evt);
            }
        });
        Scroll6.setViewportView(tbSignOut);

        internalFrame8.add(Scroll6, java.awt.BorderLayout.CENTER);

        PanelInput3.setName("PanelInput3"); // NOI18N
        PanelInput3.setOpaque(false);
        PanelInput3.setPreferredSize(new java.awt.Dimension(192, 300));
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
        Scroll10.setPreferredSize(new java.awt.Dimension(46, 120));

        panelGlass15.setName("panelGlass15"); // NOI18N
        panelGlass15.setPreferredSize(new java.awt.Dimension(44, 280));
        panelGlass15.setLayout(null);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Sebelum Menutup Luka & Meninggalkan Kamar Operasi :");
        jLabel46.setName("jLabel46"); // NOI18N
        panelGlass15.add(jLabel46);
        jLabel46.setBounds(20, 0, 580, 23);

        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("Perawat Melakukan Konfirmasi Secara Verbal :");
        jLabel78.setName("jLabel78"); // NOI18N
        panelGlass15.add(jLabel78);
        jLabel78.setBounds(40, 20, 290, 23);

        jLabel47.setText("Tindakan :");
        jLabel47.setName("jLabel47"); // NOI18N
        panelGlass15.add(jLabel47);
        jLabel47.setBounds(70, 40, 60, 23);

        VerbalTindakan1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalTindakan1.setName("VerbalTindakan1"); // NOI18N
        VerbalTindakan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalTindakan1KeyPressed(evt);
            }
        });
        panelGlass15.add(VerbalTindakan1);
        VerbalTindakan1.setBounds(140, 40, 80, 23);

        jLabel48.setText("Kelengkapan Kasa :");
        jLabel48.setName("jLabel48"); // NOI18N
        panelGlass15.add(jLabel48);
        jLabel48.setBounds(240, 40, 110, 23);

        VerbalKasa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalKasa.setName("VerbalKasa"); // NOI18N
        VerbalKasa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalKasaKeyPressed(evt);
            }
        });
        panelGlass15.add(VerbalKasa);
        VerbalKasa.setBounds(360, 40, 80, 23);

        jLabel49.setText("Instrumen :");
        jLabel49.setName("jLabel49"); // NOI18N
        panelGlass15.add(jLabel49);
        jLabel49.setBounds(460, 40, 67, 23);

        VerbalInstrumen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalInstrumen.setName("VerbalInstrumen"); // NOI18N
        VerbalInstrumen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalInstrumenKeyPressed(evt);
            }
        });
        panelGlass15.add(VerbalInstrumen);
        VerbalInstrumen.setBounds(530, 40, 80, 23);

        jLabel80.setText("Alat Tajam :");
        jLabel80.setName("jLabel80"); // NOI18N
        panelGlass15.add(jLabel80);
        jLabel80.setBounds(640, 40, 67, 23);

        VerbalAlatTajam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        VerbalAlatTajam.setName("VerbalAlatTajam"); // NOI18N
        VerbalAlatTajam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                VerbalAlatTajamKeyPressed(evt);
            }
        });
        panelGlass15.add(VerbalAlatTajam);
        VerbalAlatTajam.setBounds(710, 40, 80, 23);

        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("Kelengkapan Spesimen Jika Ada :");
        jLabel81.setName("jLabel81"); // NOI18N
        panelGlass15.add(jLabel81);
        jLabel81.setBounds(40, 70, 180, 23);

        jLabel82.setText("Label :");
        jLabel82.setName("jLabel82"); // NOI18N
        panelGlass15.add(jLabel82);
        jLabel82.setBounds(90, 90, 60, 23);

        KelengkapanSpesimenLabel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lengkap", "Tidak Lengkap", "Tidak Ada Pemeriksaan Spesimen" }));
        KelengkapanSpesimenLabel.setName("KelengkapanSpesimenLabel"); // NOI18N
        KelengkapanSpesimenLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KelengkapanSpesimenLabelKeyPressed(evt);
            }
        });
        panelGlass15.add(KelengkapanSpesimenLabel);
        KelengkapanSpesimenLabel.setBounds(160, 90, 245, 23);

        jLabel83.setText("Formulir :");
        jLabel83.setName("jLabel83"); // NOI18N
        panelGlass15.add(jLabel83);
        jLabel83.setBounds(450, 90, 90, 23);

        KelengkapanSpesimenFormulir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lengkap", "Tidak Lengkap", "Tidak Ada Pemeriksaan Spesimen" }));
        KelengkapanSpesimenFormulir.setName("KelengkapanSpesimenFormulir"); // NOI18N
        KelengkapanSpesimenFormulir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KelengkapanSpesimenFormulirKeyPressed(evt);
            }
        });
        panelGlass15.add(KelengkapanSpesimenFormulir);
        KelengkapanSpesimenFormulir.setBounds(550, 90, 245, 23);

        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("Peninjauan Kembali Kegiatan :");
        jLabel84.setName("jLabel84"); // NOI18N
        panelGlass15.add(jLabel84);
        jLabel84.setBounds(40, 120, 290, 23);

        jLabel85.setText("Dokter Bedah :");
        jLabel85.setName("jLabel85"); // NOI18N
        panelGlass15.add(jLabel85);
        jLabel85.setBounds(50, 140, 100, 23);

        PeninjauanKembaliDokterBedah.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        PeninjauanKembaliDokterBedah.setName("PeninjauanKembaliDokterBedah"); // NOI18N
        PeninjauanKembaliDokterBedah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PeninjauanKembaliDokterBedahKeyPressed(evt);
            }
        });
        panelGlass15.add(PeninjauanKembaliDokterBedah);
        PeninjauanKembaliDokterBedah.setBounds(160, 140, 80, 23);

        jLabel86.setText("Dokter Anestesi :");
        jLabel86.setName("jLabel86"); // NOI18N
        panelGlass15.add(jLabel86);
        jLabel86.setBounds(290, 140, 110, 23);

        PeninjauanKembaliDokterAnestesi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        PeninjauanKembaliDokterAnestesi.setName("PeninjauanKembaliDokterAnestesi"); // NOI18N
        PeninjauanKembaliDokterAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PeninjauanKembaliDokterAnestesiKeyPressed(evt);
            }
        });
        panelGlass15.add(PeninjauanKembaliDokterAnestesi);
        PeninjauanKembaliDokterAnestesi.setBounds(410, 140, 80, 23);

        jLabel87.setText("Perawat Kamar Operasi :");
        jLabel87.setName("jLabel87"); // NOI18N
        panelGlass15.add(jLabel87);
        jLabel87.setBounds(570, 140, 130, 23);

        PeninjauanKembaliPerawatKamarOK.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ya", "Tidak" }));
        PeninjauanKembaliPerawatKamarOK.setName("PeninjauanKembaliPerawatKamarOK"); // NOI18N
        PeninjauanKembaliPerawatKamarOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PeninjauanKembaliPerawatKamarOKKeyPressed(evt);
            }
        });
        panelGlass15.add(PeninjauanKembaliPerawatKamarOK);
        PeninjauanKembaliPerawatKamarOK.setBounds(710, 140, 80, 23);

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("Perhatian Utama Fase Pemulihan");
        jLabel88.setName("jLabel88"); // NOI18N
        panelGlass15.add(jLabel88);
        jLabel88.setBounds(40, 170, 180, 23);

        PerhatianUtamaFasePemulihan.setHighlighter(null);
        PerhatianUtamaFasePemulihan.setName("PerhatianUtamaFasePemulihan"); // NOI18N
        PerhatianUtamaFasePemulihan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PerhatianUtamaFasePemulihanKeyPressed(evt);
            }
        });
        panelGlass15.add(PerhatianUtamaFasePemulihan);
        PerhatianUtamaFasePemulihan.setBounds(210, 170, 576, 23);

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("Perawat Kamar Operasi :");
        jLabel89.setName("jLabel89"); // NOI18N
        panelGlass15.add(jLabel89);
        jLabel89.setBounds(20, 210, 130, 23);

        KdPetugasOK3.setEditable(false);
        KdPetugasOK3.setHighlighter(null);
        KdPetugasOK3.setName("KdPetugasOK3"); // NOI18N
        panelGlass15.add(KdPetugasOK3);
        KdPetugasOK3.setBounds(147, 210, 110, 23);

        NmPetugasOK3.setEditable(false);
        NmPetugasOK3.setName("NmPetugasOK3"); // NOI18N
        panelGlass15.add(NmPetugasOK3);
        NmPetugasOK3.setBounds(260, 210, 300, 23);

        btnPetugasOK3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasOK3.setMnemonic('2');
        btnPetugasOK3.setToolTipText("ALt+2");
        btnPetugasOK3.setName("btnPetugasOK3"); // NOI18N
        btnPetugasOK3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasOK3ActionPerformed(evt);
            }
        });
        btnPetugasOK3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasOK3KeyPressed(evt);
            }
        });
        panelGlass15.add(btnPetugasOK3);
        btnPetugasOK3.setBounds(560, 210, 28, 23);

        Scroll10.setViewportView(panelGlass15);

        PanelInput3.add(Scroll10, java.awt.BorderLayout.CENTER);

        internalFrame8.add(PanelInput3, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Sign-Out", internalFrame8);

        internalFrame9.setBackground(new java.awt.Color(235, 255, 235));
        internalFrame9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        internalFrame9.setName("internalFrame9"); // NOI18N
        internalFrame9.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll11.setName("Scroll11"); // NOI18N
        Scroll11.setOpaque(true);

        tbPostOp.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPostOp.setName("tbPostOp"); // NOI18N
        tbPostOp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPostOpMouseClicked(evt);
            }
        });
        tbPostOp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbPostOpKeyReleased(evt);
            }
        });
        Scroll11.setViewportView(tbPostOp);

        internalFrame9.add(Scroll11, java.awt.BorderLayout.CENTER);

        PanelInput4.setName("PanelInput4"); // NOI18N
        PanelInput4.setOpaque(false);
        PanelInput4.setPreferredSize(new java.awt.Dimension(192, 300));
        PanelInput4.setLayout(new java.awt.BorderLayout(1, 1));

        ChkInput4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput4.setMnemonic('I');
        ChkInput4.setText(".: Input Data");
        ChkInput4.setToolTipText("Alt+I");
        ChkInput4.setBorderPainted(true);
        ChkInput4.setBorderPaintedFlat(true);
        ChkInput4.setFocusable(false);
        ChkInput4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput4.setName("ChkInput4"); // NOI18N
        ChkInput4.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput4.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInput4ActionPerformed(evt);
            }
        });
        PanelInput4.add(ChkInput4, java.awt.BorderLayout.PAGE_END);

        Scroll12.setName("Scroll12"); // NOI18N
        Scroll12.setOpaque(true);
        Scroll12.setPreferredSize(new java.awt.Dimension(46, 120));

        panelGlass16.setName("panelGlass16"); // NOI18N
        panelGlass16.setPreferredSize(new java.awt.Dimension(44, 280));
        panelGlass16.setLayout(null);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Serah Terima Perawat Kamar Operasi Dengan Anestesi / Intensif / Ruangan. Perawat Melakukan Serah Terima Secara Verbal :");
        jLabel24.setName("jLabel24"); // NOI18N
        panelGlass16.add(jLabel24);
        jLabel24.setBounds(20, 0, 660, 23);

        jLabel90.setText("Keadaan Umum :");
        jLabel90.setName("jLabel90"); // NOI18N
        panelGlass16.add(jLabel90);
        jLabel90.setBounds(30, 20, 100, 23);

        KeadaanUmum1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sadar", "Tidur", "Terintubasi" }));
        KeadaanUmum1.setName("KeadaanUmum1"); // NOI18N
        KeadaanUmum1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeadaanUmum1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeadaanUmum1);
        KeadaanUmum1.setBounds(140, 20, 110, 23);

        jLabel91.setText("Jenis Cairan Infus :");
        jLabel91.setName("jLabel91"); // NOI18N
        panelGlass16.add(jLabel91);
        jLabel91.setBounds(250, 20, 110, 23);

        CairanInfus.setHighlighter(null);
        CairanInfus.setName("CairanInfus"); // NOI18N
        CairanInfus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CairanInfusKeyPressed(evt);
            }
        });
        panelGlass16.add(CairanInfus);
        CairanInfus.setBounds(370, 20, 150, 23);

        jLabel92.setText("Jaringan/Organ Tubuh PA/VC :");
        jLabel92.setName("jLabel92"); // NOI18N
        panelGlass16.add(jLabel92);
        jLabel92.setBounds(520, 20, 160, 23);

        JaringanPA.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        JaringanPA.setName("JaringanPA"); // NOI18N
        JaringanPA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JaringanPAKeyPressed(evt);
            }
        });
        panelGlass16.add(JaringanPA);
        JaringanPA.setBounds(690, 20, 100, 23);

        jLabel93.setText("Kateter Urine :");
        jLabel93.setName("jLabel93"); // NOI18N
        panelGlass16.add(jLabel93);
        jLabel93.setBounds(0, 50, 130, 23);

        KateterUrine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        KateterUrine.setName("KateterUrine"); // NOI18N
        KateterUrine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KateterUrineKeyPressed(evt);
            }
        });
        panelGlass16.add(KateterUrine);
        KateterUrine.setBounds(140, 50, 110, 23);

        jLabel94.setText("Jika Ada, Tgl.Pemasangan :");
        jLabel94.setName("jLabel94"); // NOI18N
        jLabel94.setVerifyInputWhenFocusTarget(false);
        panelGlass16.add(jLabel94);
        jLabel94.setBounds(250, 50, 150, 23);

        TanggalKateter.setForeground(new java.awt.Color(50, 70, 50));
        TanggalKateter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21-04-2026 17:47:41" }));
        TanggalKateter.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        TanggalKateter.setName("TanggalKateter"); // NOI18N
        TanggalKateter.setOpaque(false);
        TanggalKateter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKateterKeyPressed(evt);
            }
        });
        panelGlass16.add(TanggalKateter);
        TanggalKateter.setBounds(400, 50, 130, 23);

        jLabel95.setText(", Warna :");
        jLabel95.setName("jLabel95"); // NOI18N
        panelGlass16.add(jLabel95);
        jLabel95.setBounds(530, 50, 52, 23);

        WarnaUrine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Jernih", "Keruh" }));
        WarnaUrine.setName("WarnaUrine"); // NOI18N
        WarnaUrine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                WarnaUrineKeyPressed(evt);
            }
        });
        panelGlass16.add(WarnaUrine);
        WarnaUrine.setBounds(580, 50, 83, 23);

        jLabel96.setText(", Jumlah :");
        jLabel96.setName("jLabel96"); // NOI18N
        panelGlass16.add(jLabel96);
        jLabel96.setBounds(650, 50, 70, 23);

        JumlahUrine.setHighlighter(null);
        JumlahUrine.setName("JumlahUrine"); // NOI18N
        JumlahUrine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahUrineKeyPressed(evt);
            }
        });
        panelGlass16.add(JumlahUrine);
        JumlahUrine.setBounds(730, 50, 45, 23);

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel97.setText("cc");
        jLabel97.setName("jLabel97"); // NOI18N
        panelGlass16.add(jLabel97);
        jLabel97.setBounds(780, 50, 20, 23);

        jLabel98.setText("Drain :");
        jLabel98.setName("jLabel98"); // NOI18N
        panelGlass16.add(jLabel98);
        jLabel98.setBounds(0, 80, 130, 23);

        Drain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        Drain.setName("Drain"); // NOI18N
        Drain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DrainKeyPressed(evt);
            }
        });
        panelGlass16.add(Drain);
        Drain.setBounds(140, 80, 110, 23);

        jLabel99.setText("Jika Ada, Jumlah :");
        jLabel99.setName("jLabel99"); // NOI18N
        jLabel99.setVerifyInputWhenFocusTarget(false);
        panelGlass16.add(jLabel99);
        jLabel99.setBounds(250, 80, 105, 23);

        JumlahDrain.setHighlighter(null);
        JumlahDrain.setName("JumlahDrain"); // NOI18N
        JumlahDrain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahDrainKeyPressed(evt);
            }
        });
        panelGlass16.add(JumlahDrain);
        JumlahDrain.setBounds(360, 80, 40, 23);

        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel100.setText("buah, Letak :");
        jLabel100.setName("jLabel100"); // NOI18N
        panelGlass16.add(jLabel100);
        jLabel100.setBounds(410, 80, 70, 23);

        LetakDrain.setHighlighter(null);
        LetakDrain.setName("LetakDrain"); // NOI18N
        LetakDrain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LetakDrainKeyPressed(evt);
            }
        });
        panelGlass16.add(LetakDrain);
        LetakDrain.setBounds(480, 80, 112, 23);

        jLabel101.setText(", Warna/Produksi :");
        jLabel101.setName("jLabel101"); // NOI18N
        jLabel101.setVerifyInputWhenFocusTarget(false);
        panelGlass16.add(jLabel101);
        jLabel101.setBounds(590, 80, 110, 23);

        WarnaDrain.setHighlighter(null);
        WarnaDrain.setName("WarnaDrain"); // NOI18N
        WarnaDrain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                WarnaDrainKeyPressed(evt);
            }
        });
        panelGlass16.add(WarnaDrain);
        WarnaDrain.setBounds(710, 80, 112, 23);

        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel102.setText("Kelengkapan Penunjang :");
        jLabel102.setName("jLabel102"); // NOI18N
        panelGlass16.add(jLabel102);
        jLabel102.setBounds(50, 110, 210, 23);

        jLabel103.setText("Radiologi :");
        jLabel103.setName("jLabel103"); // NOI18N
        panelGlass16.add(jLabel103);
        jLabel103.setBounds(60, 130, 74, 23);

        Radiologi1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        Radiologi1.setName("Radiologi1"); // NOI18N
        Radiologi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Radiologi1KeyPressed(evt);
            }
        });
        panelGlass16.add(Radiologi1);
        Radiologi1.setBounds(140, 130, 100, 23);

        KeteranganRadiologi1.setHighlighter(null);
        KeteranganRadiologi1.setName("KeteranganRadiologi1"); // NOI18N
        KeteranganRadiologi1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganRadiologi1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeteranganRadiologi1);
        KeteranganRadiologi1.setBounds(250, 130, 75, 23);

        jLabel104.setText("EKG :");
        jLabel104.setName("jLabel104"); // NOI18N
        panelGlass16.add(jLabel104);
        jLabel104.setBounds(330, 130, 55, 23);

        EKG1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        EKG1.setName("EKG1"); // NOI18N
        EKG1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EKG1KeyPressed(evt);
            }
        });
        panelGlass16.add(EKG1);
        EKG1.setBounds(390, 130, 100, 23);

        KeteranganEKG1.setHighlighter(null);
        KeteranganEKG1.setName("KeteranganEKG1"); // NOI18N
        KeteranganEKG1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganEKG1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeteranganEKG1);
        KeteranganEKG1.setBounds(500, 130, 75, 23);

        MRI1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        MRI1.setName("MRI1"); // NOI18N
        MRI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MRI1KeyPressed(evt);
            }
        });
        panelGlass16.add(MRI1);
        MRI1.setBounds(610, 130, 100, 23);

        jLabel105.setText("MRI :");
        jLabel105.setName("jLabel105"); // NOI18N
        panelGlass16.add(jLabel105);
        jLabel105.setBounds(570, 130, 40, 23);

        KeteranganMRI1.setHighlighter(null);
        KeteranganMRI1.setName("KeteranganMRI1"); // NOI18N
        KeteranganMRI1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganMRI1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeteranganMRI1);
        KeteranganMRI1.setBounds(720, 130, 75, 23);

        jLabel106.setText("USG :");
        jLabel106.setName("jLabel106"); // NOI18N
        panelGlass16.add(jLabel106);
        jLabel106.setBounds(60, 160, 74, 23);

        USG1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        USG1.setName("USG1"); // NOI18N
        USG1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                USG1KeyPressed(evt);
            }
        });
        panelGlass16.add(USG1);
        USG1.setBounds(140, 160, 100, 23);

        KeteranganUSG1.setHighlighter(null);
        KeteranganUSG1.setName("KeteranganUSG1"); // NOI18N
        KeteranganUSG1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganUSG1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeteranganUSG1);
        KeteranganUSG1.setBounds(250, 160, 75, 23);

        jLabel107.setText("CT Scan :");
        jLabel107.setName("jLabel107"); // NOI18N
        panelGlass16.add(jLabel107);
        jLabel107.setBounds(330, 160, 55, 23);

        CTScan1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ada", "Tidak Ada" }));
        CTScan1.setName("CTScan1"); // NOI18N
        CTScan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTScan1KeyPressed(evt);
            }
        });
        panelGlass16.add(CTScan1);
        CTScan1.setBounds(390, 160, 100, 23);

        KeteranganCTScan1.setHighlighter(null);
        KeteranganCTScan1.setName("KeteranganCTScan1"); // NOI18N
        KeteranganCTScan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganCTScan1KeyPressed(evt);
            }
        });
        panelGlass16.add(KeteranganCTScan1);
        KeteranganCTScan1.setBounds(500, 160, 75, 23);

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel108.setText("Area Luka Operasi");
        jLabel108.setName("jLabel108"); // NOI18N
        panelGlass16.add(jLabel108);
        jLabel108.setBounds(50, 190, 100, 23);

        AreaLukaOperasi.setHighlighter(null);
        AreaLukaOperasi.setName("AreaLukaOperasi"); // NOI18N
        AreaLukaOperasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AreaLukaOperasiKeyPressed(evt);
            }
        });
        panelGlass16.add(AreaLukaOperasi);
        AreaLukaOperasi.setBounds(150, 190, 633, 23);

        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel109.setText("Petugas Anestesi :");
        jLabel109.setName("jLabel109"); // NOI18N
        panelGlass16.add(jLabel109);
        jLabel109.setBounds(20, 230, 103, 23);

        KdPetugasAnest.setEditable(false);
        KdPetugasAnest.setHighlighter(null);
        KdPetugasAnest.setName("KdPetugasAnest"); // NOI18N
        panelGlass16.add(KdPetugasAnest);
        KdPetugasAnest.setBounds(112, 230, 95, 23);

        NmPetugasAnest.setEditable(false);
        NmPetugasAnest.setName("NmPetugasAnest"); // NOI18N
        panelGlass16.add(NmPetugasAnest);
        NmPetugasAnest.setBounds(210, 230, 165, 23);

        btnPetugasRuangan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasRuangan1.setMnemonic('2');
        btnPetugasRuangan1.setToolTipText("ALt+2");
        btnPetugasRuangan1.setName("btnPetugasRuangan1"); // NOI18N
        btnPetugasRuangan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasRuangan1ActionPerformed(evt);
            }
        });
        btnPetugasRuangan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasRuangan1KeyPressed(evt);
            }
        });
        panelGlass16.add(btnPetugasRuangan1);
        btnPetugasRuangan1.setBounds(380, 230, 28, 23);

        jLabel110.setText("Petugas OK :");
        jLabel110.setName("jLabel110"); // NOI18N
        panelGlass16.add(jLabel110);
        jLabel110.setBounds(420, 230, 70, 23);

        KdPetugasOK4.setEditable(false);
        KdPetugasOK4.setHighlighter(null);
        KdPetugasOK4.setName("KdPetugasOK4"); // NOI18N
        KdPetugasOK4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KdPetugasOK4ActionPerformed(evt);
            }
        });
        panelGlass16.add(KdPetugasOK4);
        KdPetugasOK4.setBounds(492, 230, 95, 23);

        NmPetugasOK4.setEditable(false);
        NmPetugasOK4.setName("NmPetugasOK4"); // NOI18N
        panelGlass16.add(NmPetugasOK4);
        NmPetugasOK4.setBounds(590, 230, 165, 23);

        btnPetugasOK4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnPetugasOK4.setMnemonic('2');
        btnPetugasOK4.setToolTipText("ALt+2");
        btnPetugasOK4.setName("btnPetugasOK4"); // NOI18N
        btnPetugasOK4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasOK4ActionPerformed(evt);
            }
        });
        btnPetugasOK4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPetugasOK4KeyPressed(evt);
            }
        });
        panelGlass16.add(btnPetugasOK4);
        btnPetugasOK4.setBounds(760, 230, 28, 23);

        Scroll12.setViewportView(panelGlass16);

        PanelInput4.add(Scroll12, java.awt.BorderLayout.CENTER);

        internalFrame9.add(PanelInput4, java.awt.BorderLayout.PAGE_START);

        TabRawat.addTab("Check List Post Operasi", internalFrame9);

        internalFrame1.add(TabRawat, java.awt.BorderLayout.CENTER);

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(260, 103));
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
        TNoRw.setBounds(80, 10, 120, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setMargin(new java.awt.Insets(1, 4, 1, 4));
        TNoRM.setMinimumSize(new java.awt.Dimension(58, 24));
        TNoRM.setName("TNoRM"); // NOI18N
        FormInput.add(TNoRM);
        TNoRM.setBounds(203, 10, 80, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setMargin(new java.awt.Insets(1, 4, 1, 4));
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(286, 10, 340, 23);

        jLabel8.setText("Tgl.Lahir :");
        jLabel8.setName("jLabel8"); // NOI18N
        FormInput.add(jLabel8);
        jLabel8.setBounds(640, 10, 60, 23);

        TglLahir.setHighlighter(null);
        TglLahir.setName("TglLahir"); // NOI18N
        FormInput.add(TglLahir);
        TglLahir.setBounds(710, 10, 100, 23);

        jLabel16.setText("Tanggal :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setVerifyInputWhenFocusTarget(false);
        FormInput.add(jLabel16);
        jLabel16.setBounds(0, 40, 75, 23);

        jLabel25.setText("Tindakan :");
        jLabel25.setName("jLabel25"); // NOI18N
        FormInput.add(jLabel25);
        jLabel25.setBounds(0, 70, 75, 23);

        Tanggal.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21-04-2026 17:47:42" }));
        Tanggal.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setOpaque(false);
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        FormInput.add(Tanggal);
        Tanggal.setBounds(79, 40, 130, 23);

        Tindakan.setHighlighter(null);
        Tindakan.setName("Tindakan"); // NOI18N
        Tindakan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TindakanKeyPressed(evt);
            }
        });
        FormInput.add(Tindakan);
        Tindakan.setBounds(79, 70, 305, 23);

        jLabel22.setText("SN/CN :");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(210, 40, 50, 23);

        SNCN.setHighlighter(null);
        SNCN.setName("SNCN"); // NOI18N
        SNCN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SNCNKeyPressed(evt);
            }
        });
        FormInput.add(SNCN);
        SNCN.setBounds(264, 40, 120, 23);

        jLabel23.setText("Dokter Bedah :");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(390, 40, 91, 23);

        jLabel26.setText("Dokter Anestesi :");
        jLabel26.setName("jLabel26"); // NOI18N
        FormInput.add(jLabel26);
        jLabel26.setBounds(390, 70, 91, 23);

        KodeDokterBedah.setEditable(false);
        KodeDokterBedah.setHighlighter(null);
        KodeDokterBedah.setName("KodeDokterBedah"); // NOI18N
        FormInput.add(KodeDokterBedah);
        KodeDokterBedah.setBounds(485, 40, 97, 23);

        KodeDokterAnestesi.setEditable(false);
        KodeDokterAnestesi.setHighlighter(null);
        KodeDokterAnestesi.setName("KodeDokterAnestesi"); // NOI18N
        FormInput.add(KodeDokterAnestesi);
        KodeDokterAnestesi.setBounds(485, 70, 97, 23);

        NamaDokterBedah.setEditable(false);
        NamaDokterBedah.setName("NamaDokterBedah"); // NOI18N
        FormInput.add(NamaDokterBedah);
        NamaDokterBedah.setBounds(584, 40, 175, 23);

        NamaDokterAnestesi.setEditable(false);
        NamaDokterAnestesi.setName("NamaDokterAnestesi"); // NOI18N
        FormInput.add(NamaDokterAnestesi);
        NamaDokterAnestesi.setBounds(584, 70, 175, 23);

        btnDokterBedah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnDokterBedah.setMnemonic('2');
        btnDokterBedah.setToolTipText("ALt+2");
        btnDokterBedah.setName("btnDokterBedah"); // NOI18N
        btnDokterBedah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDokterBedahActionPerformed(evt);
            }
        });
        btnDokterBedah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDokterBedahKeyPressed(evt);
            }
        });
        FormInput.add(btnDokterBedah);
        btnDokterBedah.setBounds(761, 40, 28, 23);

        btnDokterAnestesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        btnDokterAnestesi.setMnemonic('2');
        btnDokterAnestesi.setToolTipText("ALt+2");
        btnDokterAnestesi.setName("btnDokterAnestesi"); // NOI18N
        btnDokterAnestesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDokterAnestesiActionPerformed(evt);
            }
        });
        btnDokterAnestesi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnDokterAnestesiKeyPressed(evt);
            }
        });
        FormInput.add(btnDokterAnestesi);
        btnDokterAnestesi.setBounds(761, 70, 28, 23);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("No.Rawat");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(21, 10, 75, 23);

        internalFrame1.add(FormInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);
        internalFrame1.getAccessibleContext().setAccessibleName("::[ Daftar Tilik Keselamatan Operasi ]::");

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
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"pasien");
            return;
        }
        if(KodeDokterBedah.getText().trim().equals("")||NamaDokterBedah.getText().trim().equals("")){
            Valid.textKosong(btnDokterBedah,"Dokter Bedah");
            return;
        }
        if(KodeDokterAnestesi.getText().trim().equals("")||NamaDokterAnestesi.getText().trim().equals("")){
            Valid.textKosong(KodeDokterAnestesi,"Dokter Anestesi");
            return;
        }
        if(Tindakan.getText().trim().equals("")){
            Valid.textKosong(Tindakan,"Tindakan");
            return;
        }
        if(SNCN.getText().trim().equals("")){
            Valid.textKosong(SNCN,"SN/CN");
            return;
        }
        
        simpan();
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
                hapusPreOp();
                break;
            case 1:
                hapusSignIn();
                break;
            case 2:
                hapusTimeOut();
                break;
            case 3:
                hapusSignOut();
                break;
            case 4:
                hapusPostOp();
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
                    tbPreOp.requestFocus();
                    break;
                case 1:
                    tbSignIn.requestFocus();
                    break;
                case 2:
                    tbTimeOut.requestFocus();
                    break;
                case 3:
                    tbSignOut.requestFocus();
                    break;
                case 4:
                    tbPostOp.requestFocus();
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
                BtnSimpan.setEnabled(akses.gettindakan_ralan());
                BtnHapus.setEnabled(akses.gettindakan_ralan());
                BtnEdit.setEnabled(akses.gettindakan_ralan());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanPreOp();
                break;
            case 1:
                BtnSimpan.setEnabled(akses.gettindakan_ralan());
                BtnHapus.setEnabled(akses.gettindakan_ralan());
                BtnEdit.setEnabled(akses.gettindakan_ralan());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanSignIn();
                break;
            case 2:
                BtnSimpan.setEnabled(akses.gettindakan_ralan());
                BtnHapus.setEnabled(akses.gettindakan_ralan());
                BtnEdit.setEnabled(akses.gettindakan_ralan());
                TCari.setPreferredSize(new Dimension(207, 23));
                tampilkanTimeOut();
                break;
            case 3:
                BtnSimpan.setEnabled(akses.gettindakan_ralan());
                BtnHapus.setEnabled(akses.gettindakan_ralan());
                BtnEdit.setEnabled(akses.gettindakan_ralan());
                TCari.setPreferredSize(new Dimension(240, 23));
                tampilkanSignOut();
                break;
            case 4:
                BtnSimpan.setEnabled(akses.gettindakan_ralan());
                BtnHapus.setEnabled(akses.gettindakan_ralan());
                BtnEdit.setEnabled(akses.gettindakan_ralan());
                TCari.setPreferredSize(new Dimension(240, 23));
                tampilkanPostOp();
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

    if (KodeDokterBedah.getText().trim().equals("") || NamaDokterBedah.getText().trim().equals("")) {
        Valid.textKosong(btnDokterBedah, "Dokter Bedah");
        return;
    }
    if (KodeDokterAnestesi.getText().trim().equals("") || NamaDokterAnestesi.getText().trim().equals("")) {
        Valid.textKosong(KodeDokterAnestesi, "Dokter Anestesi");
        return;
    }
    if (Tindakan.getText().trim().equals("")) {
        Valid.textKosong(Tindakan, "Tindakan");
        return;
    }
    if (SNCN.getText().trim().equals("")) {
        Valid.textKosong(SNCN, "SN/CN");
        return;
    }


    switch (TabRawat.getSelectedIndex()) {
        case 0:
            gantiPreOp();
            break;
        case 1:
            gantiSignIn();
            break;
        case 2:
            gantiTimeOut();
            break;
        case 3:
            gantiSignOut();
            break;
        case 4:
            gantiPostOp();
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

    private void tbPreOpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPreOpMouseClicked
        if (tabModePreOp.getRowCount() != 0) {
            try {
                getDataPreOp();
            } catch (java.lang.NullPointerException e) {
            }

        }
    }//GEN-LAST:event_tbPreOpMouseClicked

    private void tbSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSignInMouseClicked
        // TODO add your handling code here:
        if (tabModeSignIn.getRowCount() != 0) {
            try {
                getDataSignIn();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbSignInMouseClicked

    private void ChkInput1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput1ActionPerformed
        // TODO add your handling code here:
        isForm2();
    }//GEN-LAST:event_ChkInput1ActionPerformed

    private void tbPreOpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPreOpKeyReleased
        if (tabModePreOp.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataPreOp();
                } catch (java.lang.NullPointerException e) {
                }
            }

        }
    }//GEN-LAST:event_tbPreOpKeyReleased

    private void tbSignInKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSignInKeyReleased
        // TODO add your handling code here:
        if (tabModeSignIn.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataSignIn();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbSignInKeyReleased

    private void TNoRwMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TNoRwMouseClicked
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(internalFrame1);
                win.toFront();
            }
        }
    }//GEN-LAST:event_TNoRwMouseClicked

    private void tbTimeOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTimeOutMouseClicked
        if (tabModeTimeOut.getRowCount() != 0) {
            try {
                getDataTimeOut();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbTimeOutMouseClicked

    private void tbTimeOutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbTimeOutKeyReleased
        if (tabModeTimeOut.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataTimeOut();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbTimeOutKeyReleased

    private void ChkInput2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput2ActionPerformed
        isForm3();
    }//GEN-LAST:event_ChkInput2ActionPerformed

    private void tbSignOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSignOutMouseClicked
        if (tabModeSignOut.getRowCount() != 0) {
            try {
                getDataSignOut();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbSignOutMouseClicked

    private void tbSignOutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbSignOutKeyReleased
        if (tabModeSignOut.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataSignOut();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbSignOutKeyReleased

    private void ChkInput3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput3ActionPerformed
        isForm4();
    }//GEN-LAST:event_ChkInput3ActionPerformed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        // Valid.pindah(evt,Rencana,Informasi);
    }//GEN-LAST:event_TanggalKeyPressed

    private void TindakanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TindakanKeyPressed
        Valid.pindah(evt,SNCN,btnDokterBedah);
    }//GEN-LAST:event_TindakanKeyPressed

    private void SNCNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SNCNKeyPressed
        Valid.pindah(evt,Tanggal,Tindakan);
    }//GEN-LAST:event_SNCNKeyPressed

    private void btnDokterBedahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDokterBedahActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=1;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btnDokterBedahActionPerformed

    private void btnDokterBedahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDokterBedahKeyPressed
        Valid.pindah(evt,Tindakan,btnDokterAnestesi);
    }//GEN-LAST:event_btnDokterBedahKeyPressed

    private void btnDokterAnestesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDokterAnestesiActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=2;
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
    }//GEN-LAST:event_btnDokterAnestesiActionPerformed

    private void btnDokterAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDokterAnestesiKeyPressed
        Valid.pindah(evt,btnDokterBedah,Identitas);
    }//GEN-LAST:event_btnDokterAnestesiKeyPressed

    private void IdentitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IdentitasKeyPressed
        Valid.pindah(evt,btnDokterAnestesi,KeadaanUmum);
    }//GEN-LAST:event_IdentitasKeyPressed

    private void KeadaanUmumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeadaanUmumKeyPressed
        Valid.pindah(evt,Identitas,AreaOperasi);
    }//GEN-LAST:event_KeadaanUmumKeyPressed

    private void IjinAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IjinAnestesiKeyPressed
        Valid.pindah(evt,IjinBedah,IjinTransfusi);
    }//GEN-LAST:event_IjinAnestesiKeyPressed

    private void IjinBedahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IjinBedahKeyPressed
        Valid.pindah(evt,AreaOperasi,IjinAnestesi);
    }//GEN-LAST:event_IjinBedahKeyPressed

    private void PersiapanDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PersiapanDarahKeyPressed
        Valid.pindah(evt,IjinTransfusi,KeteranganPersiapanDarah);
    }//GEN-LAST:event_PersiapanDarahKeyPressed

    private void KeteranganPersiapanDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganPersiapanDarahKeyPressed
        Valid.pindah(evt,PersiapanDarah,PerlengkapanKhusus);
    }//GEN-LAST:event_KeteranganPersiapanDarahKeyPressed

    private void AreaOperasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaOperasiKeyPressed
        Valid.pindah(evt,KeadaanUmum,IjinBedah);
    }//GEN-LAST:event_AreaOperasiKeyPressed

    private void IjinTransfusiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IjinTransfusiKeyPressed
        Valid.pindah(evt,IjinAnestesi,PersiapanDarah);
    }//GEN-LAST:event_IjinTransfusiKeyPressed

    private void PerlengkapanKhususKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PerlengkapanKhususKeyPressed
        Valid.pindah(evt,KeteranganPersiapanDarah,Radiologi);
    }//GEN-LAST:event_PerlengkapanKhususKeyPressed

    private void KeteranganEKGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganEKGKeyPressed
        Valid.pindah(evt,EKG,USG);
    }//GEN-LAST:event_KeteranganEKGKeyPressed

    private void KeteranganCTScanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganCTScanKeyPressed
        Valid.pindah(evt,CTScan,MRI);
    }//GEN-LAST:event_KeteranganCTScanKeyPressed

    private void CTScanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTScanKeyPressed
        Valid.pindah(evt,KeteranganUSG,KeteranganCTScan);
    }//GEN-LAST:event_CTScanKeyPressed

    private void EKGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EKGKeyPressed
        Valid.pindah(evt,KeteranganRadiologi,KeteranganEKG);
    }//GEN-LAST:event_EKGKeyPressed

    private void KeteranganRadiologiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganRadiologiKeyPressed
        Valid.pindah(evt,Radiologi,EKG);
    }//GEN-LAST:event_KeteranganRadiologiKeyPressed

    private void RadiologiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RadiologiKeyPressed
        Valid.pindah(evt,PerlengkapanKhusus,KeteranganRadiologi);
    }//GEN-LAST:event_RadiologiKeyPressed

    private void USGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_USGKeyPressed
        Valid.pindah(evt,KeteranganEKG,KeteranganUSG);
    }//GEN-LAST:event_USGKeyPressed

    private void MRIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MRIKeyPressed
        Valid.pindah(evt,KeteranganCTScan,KeteranganMRI);
    }//GEN-LAST:event_MRIKeyPressed

    private void KeteranganUSGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganUSGKeyPressed
        Valid.pindah(evt,USG,CTScan);
    }//GEN-LAST:event_KeteranganUSGKeyPressed

    private void KeteranganMRIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganMRIKeyPressed
        Valid.pindah(evt,MRI,btnPetugasRuangan);
    }//GEN-LAST:event_KeteranganMRIKeyPressed

    private void btnPetugasRuanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasRuanganActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=1;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasRuanganActionPerformed

    private void btnPetugasRuanganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasRuanganKeyPressed
        Valid.pindah(evt,KeteranganMRI,btnPetugasOK);
    }//GEN-LAST:event_btnPetugasRuanganKeyPressed

    private void btnPetugasOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasOKActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=2;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasOKActionPerformed

    private void btnPetugasOKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasOKKeyPressed
        Valid.pindah(evt,btnPetugasRuangan,BtnSimpan);
    }//GEN-LAST:event_btnPetugasOKKeyPressed

    private void tbPostOpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPostOpMouseClicked
        if (tabModePostOp.getRowCount() != 0) {
            try {
                getDataPostOp();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbPostOpMouseClicked

    private void tbPostOpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPostOpKeyReleased
        if (tabModePostOp.getRowCount() != 0) {
            if ((evt.getKeyCode() == KeyEvent.VK_ENTER) || (evt.getKeyCode() == KeyEvent.VK_UP) || (evt.getKeyCode() == KeyEvent.VK_DOWN)) {
                try {
                    getDataPostOp();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbPostOpKeyReleased

    private void ChkInput4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInput4ActionPerformed
        isForm5();
    }//GEN-LAST:event_ChkInput4ActionPerformed

    private void Identitas1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Identitas1KeyPressed
        Valid.pindah(evt,btnDokterAnestesi,Alergi);
    }//GEN-LAST:event_Identitas1KeyPressed

    private void AlergiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlergiKeyPressed
        Valid.pindah(evt,Identitas,AreaOperasi);
    }//GEN-LAST:event_AlergiKeyPressed

    private void AreaOperasi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaOperasi1KeyPressed
        Valid.pindah(evt,Alergi,ResikoAspirasi);
    }//GEN-LAST:event_AreaOperasi1KeyPressed

    private void ResikoAspirasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResikoAspirasiKeyPressed
        Valid.pindah(evt,AreaOperasi,AntisipasiResikoAspirasi);
    }//GEN-LAST:event_ResikoAspirasiKeyPressed

    private void AntisipasiResikoAspirasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AntisipasiResikoAspirasiKeyPressed
        Valid.pindah(evt,ResikoAspirasi,ResikoKehilanganDarah);
    }//GEN-LAST:event_AntisipasiResikoAspirasiKeyPressed

    private void ResikoKehilanganDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResikoKehilanganDarahKeyPressed
        Valid.pindah(evt,AntisipasiResikoAspirasi,JalurIVLine);
    }//GEN-LAST:event_ResikoKehilanganDarahKeyPressed

    private void JalurIVLineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JalurIVLineKeyPressed
        Valid.pindah(evt,ResikoKehilanganDarah,RencanaAntisipasiKehilanganDarah);
    }//GEN-LAST:event_JalurIVLineKeyPressed

    private void RencanaAntisipasiKehilanganDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RencanaAntisipasiKehilanganDarahKeyPressed
        Valid.pindah(evt,JalurIVLine,KesiapanAlatAnes);
    }//GEN-LAST:event_RencanaAntisipasiKehilanganDarahKeyPressed

    private void KesiapanAlatAnesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KesiapanAlatAnesKeyPressed
        Valid.pindah(evt,RencanaAntisipasiKehilanganDarah,RencanaAntisipasiKesiapanAlat);
    }//GEN-LAST:event_KesiapanAlatAnesKeyPressed

    private void RencanaAntisipasiKesiapanAlatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RencanaAntisipasiKesiapanAlatKeyPressed
        Valid.pindah(evt,KesiapanAlatAnes,btnPetugasOK);
    }//GEN-LAST:event_RencanaAntisipasiKesiapanAlatKeyPressed

    private void btnPetugasOK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasOK1ActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasOK1ActionPerformed

    private void btnPetugasOK1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasOK1KeyPressed
        Valid.pindah(evt,RencanaAntisipasiKesiapanAlat,BtnSimpan);
    }//GEN-LAST:event_btnPetugasOK1KeyPressed

    private void AreaOperasi2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaOperasi2KeyPressed
        Valid.pindah(evt,VerbalArea,PerkiraanLama);
    }//GEN-LAST:event_AreaOperasi2KeyPressed

    private void VerbalIdentitasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalIdentitasKeyPressed
        Valid.pindah(evt,btnDokterAnestesi,VerbalTindakan);
    }//GEN-LAST:event_VerbalIdentitasKeyPressed

    private void VerbalTindakanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalTindakanKeyPressed
        Valid.pindah(evt,VerbalIdentitas,VerbalArea);
    }//GEN-LAST:event_VerbalTindakanKeyPressed

    private void VerbalAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalAreaKeyPressed
        Valid.pindah(evt,VerbalTindakan,AreaOperasi);
    }//GEN-LAST:event_VerbalAreaKeyPressed

    private void PerkiraanLamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PerkiraanLamaKeyPressed
        Valid.pindah(evt,AreaOperasi,PenayanganRadiologi);
    }//GEN-LAST:event_PerkiraanLamaKeyPressed

    private void PenayanganRadiologiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PenayanganRadiologiKeyPressed
        Valid.pindah(evt,PerkiraanLama,PenayanganCTScan);
    }//GEN-LAST:event_PenayanganRadiologiKeyPressed

    private void PenayanganCTScanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PenayanganCTScanKeyPressed
        Valid.pindah(evt,PenayanganRadiologi,PenayanganMRI);
    }//GEN-LAST:event_PenayanganCTScanKeyPressed

    private void PenayanganMRIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PenayanganMRIKeyPressed
        Valid.pindah(evt,PenayanganCTScan,PemberianAntibiotik);
    }//GEN-LAST:event_PenayanganMRIKeyPressed

    private void PemberianAntibiotikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PemberianAntibiotikKeyPressed
        Valid.pindah(evt,PenayanganMRI,NamaAntibiotikDIberikan);
    }//GEN-LAST:event_PemberianAntibiotikKeyPressed

    private void NamaAntibiotikDIberikanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaAntibiotikDIberikanKeyPressed
        Valid.pindah(evt,PemberianAntibiotik,JamPemberianAntibiotik);
    }//GEN-LAST:event_NamaAntibiotikDIberikanKeyPressed

    private void JamPemberianAntibiotikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JamPemberianAntibiotikKeyPressed
        Valid.pindah(evt,NamaAntibiotikDIberikan,AntisipasiKehilanganDarah);
    }//GEN-LAST:event_JamPemberianAntibiotikKeyPressed

    private void AntisipasiKehilanganDarahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AntisipasiKehilanganDarahKeyPressed
        Valid.pindah(evt,JamPemberianAntibiotik,AdaHalKhusus);
    }//GEN-LAST:event_AntisipasiKehilanganDarahKeyPressed

    private void AdaHalKhususKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AdaHalKhususKeyPressed
        Valid.pindah(evt,AntisipasiKehilanganDarah,HalKhususDiperhatikan);
    }//GEN-LAST:event_AdaHalKhususKeyPressed

    private void HalKhususDiperhatikanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HalKhususDiperhatikanKeyPressed
        Valid.pindah(evt,AdaHalKhusus,TanggalSeteril);
    }//GEN-LAST:event_HalKhususDiperhatikanKeyPressed

    private void TanggalSeterilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalSeterilKeyPressed
        Valid.pindah2(evt,HalKhususDiperhatikan,PetunjukSterilisasi);
    }//GEN-LAST:event_TanggalSeterilKeyPressed

    private void PetunjukSterilisasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PetunjukSterilisasiKeyPressed
        Valid.pindah(evt,TanggalSeteril,VerifikasiOperatif);
    }//GEN-LAST:event_PetunjukSterilisasiKeyPressed

    private void VerifikasiOperatifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerifikasiOperatifKeyPressed
        Valid.pindah(evt,PetunjukSterilisasi,btnPetugasOK);
    }//GEN-LAST:event_VerifikasiOperatifKeyPressed

    private void btnPetugasOK2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasOK2ActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasOK2ActionPerformed

    private void btnPetugasOK2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasOK2KeyPressed
        Valid.pindah(evt,VerifikasiOperatif,BtnSimpan);
    }//GEN-LAST:event_btnPetugasOK2KeyPressed

    private void VerbalTindakan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalTindakan1KeyPressed
        Valid.pindah(evt,btnDokterAnestesi,VerbalKasa);
    }//GEN-LAST:event_VerbalTindakan1KeyPressed

    private void VerbalKasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalKasaKeyPressed
        Valid.pindah(evt,VerbalTindakan,VerbalInstrumen);
    }//GEN-LAST:event_VerbalKasaKeyPressed

    private void VerbalInstrumenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalInstrumenKeyPressed
        Valid.pindah(evt,VerbalTindakan,VerbalAlatTajam);
    }//GEN-LAST:event_VerbalInstrumenKeyPressed

    private void VerbalAlatTajamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VerbalAlatTajamKeyPressed
        Valid.pindah(evt,VerbalInstrumen,KelengkapanSpesimenLabel);
    }//GEN-LAST:event_VerbalAlatTajamKeyPressed

    private void KelengkapanSpesimenLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KelengkapanSpesimenLabelKeyPressed
        Valid.pindah(evt,VerbalAlatTajam,KelengkapanSpesimenFormulir);
    }//GEN-LAST:event_KelengkapanSpesimenLabelKeyPressed

    private void KelengkapanSpesimenFormulirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KelengkapanSpesimenFormulirKeyPressed
        Valid.pindah(evt,KelengkapanSpesimenLabel,PeninjauanKembaliDokterBedah);
    }//GEN-LAST:event_KelengkapanSpesimenFormulirKeyPressed

    private void PeninjauanKembaliDokterBedahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeninjauanKembaliDokterBedahKeyPressed
        Valid.pindah(evt,KelengkapanSpesimenFormulir,PeninjauanKembaliDokterAnestesi);
    }//GEN-LAST:event_PeninjauanKembaliDokterBedahKeyPressed

    private void PeninjauanKembaliDokterAnestesiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeninjauanKembaliDokterAnestesiKeyPressed
        Valid.pindah(evt,PeninjauanKembaliDokterBedah,PeninjauanKembaliPerawatKamarOK);
    }//GEN-LAST:event_PeninjauanKembaliDokterAnestesiKeyPressed

    private void PeninjauanKembaliPerawatKamarOKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PeninjauanKembaliPerawatKamarOKKeyPressed
        Valid.pindah(evt,PeninjauanKembaliDokterAnestesi,PerhatianUtamaFasePemulihan);
    }//GEN-LAST:event_PeninjauanKembaliPerawatKamarOKKeyPressed

    private void PerhatianUtamaFasePemulihanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PerhatianUtamaFasePemulihanKeyPressed
        Valid.pindah(evt,PeninjauanKembaliPerawatKamarOK,btnPetugasOK);
    }//GEN-LAST:event_PerhatianUtamaFasePemulihanKeyPressed

    private void btnPetugasOK3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasOK3ActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasOK3ActionPerformed

    private void btnPetugasOK3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasOK3KeyPressed
        Valid.pindah(evt,PerhatianUtamaFasePemulihan,BtnSimpan);
    }//GEN-LAST:event_btnPetugasOK3KeyPressed

    private void KeadaanUmum1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeadaanUmum1KeyPressed
        Valid.pindah(evt,btnDokterAnestesi,CairanInfus);
    }//GEN-LAST:event_KeadaanUmum1KeyPressed

    private void CairanInfusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CairanInfusKeyPressed
        Valid.pindah(evt,KeadaanUmum,JaringanPA);
    }//GEN-LAST:event_CairanInfusKeyPressed

    private void JaringanPAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JaringanPAKeyPressed
        Valid.pindah(evt,CairanInfus,KateterUrine);
    }//GEN-LAST:event_JaringanPAKeyPressed

    private void KateterUrineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KateterUrineKeyPressed
        Valid.pindah(evt,JaringanPA,TanggalKateter);
    }//GEN-LAST:event_KateterUrineKeyPressed

    private void TanggalKateterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKateterKeyPressed
        Valid.pindah2(evt,KateterUrine,WarnaUrine);
    }//GEN-LAST:event_TanggalKateterKeyPressed

    private void WarnaUrineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WarnaUrineKeyPressed
        Valid.pindah(evt,TanggalKateter,JumlahUrine);
    }//GEN-LAST:event_WarnaUrineKeyPressed

    private void JumlahUrineKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahUrineKeyPressed
        Valid.pindah(evt,WarnaUrine,Drain);
    }//GEN-LAST:event_JumlahUrineKeyPressed

    private void DrainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DrainKeyPressed
        Valid.pindah(evt,JumlahUrine,JumlahDrain);
    }//GEN-LAST:event_DrainKeyPressed

    private void JumlahDrainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahDrainKeyPressed
        Valid.pindah(evt,Drain,LetakDrain);
    }//GEN-LAST:event_JumlahDrainKeyPressed

    private void LetakDrainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LetakDrainKeyPressed
        Valid.pindah(evt,JumlahDrain,WarnaDrain);
    }//GEN-LAST:event_LetakDrainKeyPressed

    private void WarnaDrainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_WarnaDrainKeyPressed
        Valid.pindah(evt,LetakDrain,Radiologi);
    }//GEN-LAST:event_WarnaDrainKeyPressed

    private void Radiologi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Radiologi1KeyPressed
        Valid.pindah(evt,WarnaDrain,KeteranganRadiologi);
    }//GEN-LAST:event_Radiologi1KeyPressed

    private void KeteranganRadiologi1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganRadiologi1KeyPressed
        Valid.pindah(evt,Radiologi,EKG);
    }//GEN-LAST:event_KeteranganRadiologi1KeyPressed

    private void EKG1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EKG1KeyPressed
        Valid.pindah(evt,KeteranganRadiologi,KeteranganEKG);
    }//GEN-LAST:event_EKG1KeyPressed

    private void KeteranganEKG1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganEKG1KeyPressed
        Valid.pindah(evt,EKG,USG);
    }//GEN-LAST:event_KeteranganEKG1KeyPressed

    private void MRI1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MRI1KeyPressed
        Valid.pindah(evt,KeteranganCTScan,KeteranganMRI);
    }//GEN-LAST:event_MRI1KeyPressed

    private void KeteranganMRI1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganMRI1KeyPressed
        Valid.pindah(evt,MRI,AreaLukaOperasi);
    }//GEN-LAST:event_KeteranganMRI1KeyPressed

    private void USG1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_USG1KeyPressed
        Valid.pindah(evt,KeteranganEKG,KeteranganUSG);
    }//GEN-LAST:event_USG1KeyPressed

    private void KeteranganUSG1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganUSG1KeyPressed
        Valid.pindah(evt,USG,CTScan);
    }//GEN-LAST:event_KeteranganUSG1KeyPressed

    private void CTScan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTScan1KeyPressed
        Valid.pindah(evt,KeteranganUSG,KeteranganCTScan);
    }//GEN-LAST:event_CTScan1KeyPressed

    private void KeteranganCTScan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganCTScan1KeyPressed
        Valid.pindah(evt,CTScan,MRI);
    }//GEN-LAST:event_KeteranganCTScan1KeyPressed

    private void AreaLukaOperasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AreaLukaOperasiKeyPressed
        Valid.pindah(evt,KeteranganMRI,btnPetugasRuangan);
    }//GEN-LAST:event_AreaLukaOperasiKeyPressed

    private void btnPetugasRuangan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasRuangan1ActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=1;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasRuangan1ActionPerformed

    private void btnPetugasRuangan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasRuangan1KeyPressed
        Valid.pindah(evt,KeteranganMRI,btnPetugasOK);
    }//GEN-LAST:event_btnPetugasRuangan1KeyPressed

    private void btnPetugasOK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasOK4ActionPerformed
        akses.setform("RMDaftarTilikKeselamatanOperasi");
        pilihan=2;
        petugas.emptTeks();
        petugas.isCek();
        petugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        petugas.setLocationRelativeTo(internalFrame1);
        petugas.setVisible(true);
    }//GEN-LAST:event_btnPetugasOK4ActionPerformed

    private void btnPetugasOK4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPetugasOK4KeyPressed
        Valid.pindah(evt,btnPetugasRuangan,BtnSimpan);
    }//GEN-LAST:event_btnPetugasOK4KeyPressed

    private void KdPetugasOK4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KdPetugasOK4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KdPetugasOK4ActionPerformed

    private void JKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JKKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JKKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            RMBundleTemplate dialog = new RMBundleTemplate(new javax.swing.JFrame(), true);
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
    private widget.ComboBox AdaHalKhusus;
    private widget.TextBox Alergi;
    private widget.TextBox AntisipasiKehilanganDarah;
    private widget.TextBox AntisipasiResikoAspirasi;
    private widget.TextBox AreaLukaOperasi;
    private widget.ComboBox AreaOperasi;
    private widget.ComboBox AreaOperasi1;
    private widget.ComboBox AreaOperasi2;
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.ComboBox CTScan;
    private widget.ComboBox CTScan1;
    private widget.TextBox CairanInfus;
    private widget.CekBox ChkInput;
    private widget.CekBox ChkInput1;
    private widget.CekBox ChkInput2;
    private widget.CekBox ChkInput3;
    private widget.CekBox ChkInput4;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.ComboBox Drain;
    private widget.ComboBox EKG;
    private widget.ComboBox EKG1;
    private widget.PanelBiasa FormInput;
    private widget.TextBox HalKhususDiperhatikan;
    private widget.ComboBox Identitas;
    private widget.ComboBox Identitas1;
    private widget.ComboBox IjinAnestesi;
    private widget.ComboBox IjinBedah;
    private widget.ComboBox IjinTransfusi;
    private widget.TextBox JK;
    private widget.TextBox JalurIVLine;
    private widget.TextBox JamPemberianAntibiotik;
    private widget.ComboBox JaringanPA;
    private widget.TextBox JumlahDrain;
    private widget.TextBox JumlahUrine;
    private widget.ComboBox KateterUrine;
    private widget.TextBox KdPetugasAnest;
    private widget.TextBox KdPetugasOK;
    private widget.TextBox KdPetugasOK1;
    private widget.TextBox KdPetugasOK2;
    private widget.TextBox KdPetugasOK3;
    private widget.TextBox KdPetugasOK4;
    private widget.TextBox KdPetugasRuangan;
    private widget.ComboBox KeadaanUmum;
    private widget.ComboBox KeadaanUmum1;
    private widget.ComboBox KelengkapanSpesimenFormulir;
    private widget.ComboBox KelengkapanSpesimenLabel;
    private widget.ComboBox KesiapanAlatAnes;
    private widget.TextBox KeteranganCTScan;
    private widget.TextBox KeteranganCTScan1;
    private widget.TextBox KeteranganEKG;
    private widget.TextBox KeteranganEKG1;
    private widget.TextBox KeteranganMRI;
    private widget.TextBox KeteranganMRI1;
    private widget.TextBox KeteranganPersiapanDarah;
    private widget.TextBox KeteranganRadiologi;
    private widget.TextBox KeteranganRadiologi1;
    private widget.TextBox KeteranganUSG;
    private widget.TextBox KeteranganUSG1;
    private widget.TextBox KodeDokterAnestesi;
    private widget.TextBox KodeDokterBedah;
    private widget.Label LCount;
    private widget.TextBox LetakDrain;
    private widget.ComboBox MRI;
    private widget.ComboBox MRI1;
    private widget.TextBox NamaAntibiotikDIberikan;
    private widget.TextBox NamaDokterAnestesi;
    private widget.TextBox NamaDokterBedah;
    private widget.TextBox NmPetugasAnest;
    private widget.TextBox NmPetugasOK;
    private widget.TextBox NmPetugasOK1;
    private widget.TextBox NmPetugasOK2;
    private widget.TextBox NmPetugasOK3;
    private widget.TextBox NmPetugasOK4;
    private widget.TextBox NmPetugasRuangan;
    private javax.swing.JPanel PanelInput;
    private javax.swing.JPanel PanelInput1;
    private javax.swing.JPanel PanelInput2;
    private javax.swing.JPanel PanelInput3;
    private javax.swing.JPanel PanelInput4;
    private widget.ComboBox PemberianAntibiotik;
    private widget.ComboBox PenayanganCTScan;
    private widget.ComboBox PenayanganMRI;
    private widget.ComboBox PenayanganRadiologi;
    private widget.ComboBox PeninjauanKembaliDokterAnestesi;
    private widget.ComboBox PeninjauanKembaliDokterBedah;
    private widget.ComboBox PeninjauanKembaliPerawatKamarOK;
    private widget.TextBox PerhatianUtamaFasePemulihan;
    private widget.TextBox PerkiraanLama;
    private widget.ComboBox PerlengkapanKhusus;
    private widget.ComboBox PersiapanDarah;
    private widget.ComboBox PetunjukSterilisasi;
    private widget.ComboBox Radiologi;
    private widget.ComboBox Radiologi1;
    private widget.TextBox RencanaAntisipasiKehilanganDarah;
    private widget.TextBox RencanaAntisipasiKesiapanAlat;
    private widget.ComboBox ResikoAspirasi;
    private widget.ComboBox ResikoKehilanganDarah;
    private widget.TextBox SNCN;
    private widget.ScrollPane Scroll10;
    private widget.ScrollPane Scroll11;
    private widget.ScrollPane Scroll12;
    private widget.ScrollPane Scroll3;
    private widget.ScrollPane Scroll4;
    private widget.ScrollPane Scroll5;
    private widget.ScrollPane Scroll6;
    private widget.ScrollPane Scroll7;
    private widget.ScrollPane Scroll8;
    private widget.ScrollPane Scroll9;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private javax.swing.JTabbedPane TabRawat;
    private widget.Tanggal Tanggal;
    private widget.Tanggal TanggalKateter;
    private widget.Tanggal TanggalSeteril;
    private widget.TextBox TglLahir;
    private widget.TextBox Tindakan;
    private widget.ComboBox USG;
    private widget.ComboBox USG1;
    private widget.ComboBox VerbalAlatTajam;
    private widget.ComboBox VerbalArea;
    private widget.ComboBox VerbalIdentitas;
    private widget.ComboBox VerbalInstrumen;
    private widget.ComboBox VerbalKasa;
    private widget.ComboBox VerbalTindakan;
    private widget.ComboBox VerbalTindakan1;
    private widget.ComboBox VerifikasiOperatif;
    private widget.TextBox WarnaDrain;
    private widget.ComboBox WarnaUrine;
    private widget.Button btnDokterAnestesi;
    private widget.Button btnDokterBedah;
    private widget.Button btnPetugasOK;
    private widget.Button btnPetugasOK1;
    private widget.Button btnPetugasOK2;
    private widget.Button btnPetugasOK3;
    private widget.Button btnPetugasOK4;
    private widget.Button btnPetugasRuangan;
    private widget.Button btnPetugasRuangan1;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame5;
    private widget.InternalFrame internalFrame6;
    private widget.InternalFrame internalFrame7;
    private widget.InternalFrame internalFrame8;
    private widget.InternalFrame internalFrame9;
    private widget.Label jLabel10;
    private widget.Label jLabel100;
    private widget.Label jLabel101;
    private widget.Label jLabel102;
    private widget.Label jLabel103;
    private widget.Label jLabel104;
    private widget.Label jLabel105;
    private widget.Label jLabel106;
    private widget.Label jLabel107;
    private widget.Label jLabel108;
    private widget.Label jLabel109;
    private widget.Label jLabel110;
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
    private widget.Label jLabel39;
    private widget.Label jLabel4;
    private widget.Label jLabel40;
    private widget.Label jLabel41;
    private widget.Label jLabel42;
    private widget.Label jLabel43;
    private widget.Label jLabel44;
    private widget.Label jLabel45;
    private widget.Label jLabel46;
    private widget.Label jLabel47;
    private widget.Label jLabel48;
    private widget.Label jLabel49;
    private widget.Label jLabel50;
    private widget.Label jLabel51;
    private widget.Label jLabel52;
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
    private widget.Label jLabel66;
    private widget.Label jLabel67;
    private widget.Label jLabel68;
    private widget.Label jLabel69;
    private widget.Label jLabel70;
    private widget.Label jLabel71;
    private widget.Label jLabel72;
    private widget.Label jLabel73;
    private widget.Label jLabel74;
    private widget.Label jLabel75;
    private widget.Label jLabel76;
    private widget.Label jLabel77;
    private widget.Label jLabel78;
    private widget.Label jLabel79;
    private widget.Label jLabel8;
    private widget.Label jLabel80;
    private widget.Label jLabel81;
    private widget.Label jLabel82;
    private widget.Label jLabel83;
    private widget.Label jLabel84;
    private widget.Label jLabel85;
    private widget.Label jLabel86;
    private widget.Label jLabel87;
    private widget.Label jLabel88;
    private widget.Label jLabel89;
    private widget.Label jLabel90;
    private widget.Label jLabel91;
    private widget.Label jLabel92;
    private widget.Label jLabel93;
    private widget.Label jLabel94;
    private widget.Label jLabel95;
    private widget.Label jLabel96;
    private widget.Label jLabel97;
    private widget.Label jLabel98;
    private widget.Label jLabel99;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator5;
    private widget.panelisi panelGlass12;
    private widget.panelisi panelGlass13;
    private widget.panelisi panelGlass14;
    private widget.panelisi panelGlass15;
    private widget.panelisi panelGlass16;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.Table tbPostOp;
    private widget.Table tbPreOp;
    private widget.Table tbSignIn;
    private widget.Table tbSignOut;
    private widget.Table tbTimeOut;
    // End of variables declaration//GEN-END:variables

    private void isRawat() {
        try {
            ps = koneksi.prepareStatement(
                    "select reg_periksa.no_rkm_medis,reg_periksa.tgl_registrasi,pasien.nm_pasien as pasien,pasien.tgl_lahir,pasien.jk,reg_periksa.kd_dokter,reg_periksa.tgl_registrasi,"
                    + "reg_periksa.jam_reg from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis where reg_periksa.no_rawat=?");
            try {
                ps.setString(1, TNoRw.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    TPasien.setText(rs.getString("pasien"));
                    TglLahir.setText(rs.getString("tgl_lahir"));
                    JK.setText(rs.getString("jk"));
                    DTPCari1.setDate(rs.getDate("tgl_registrasi"));
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
        DTPCari2.setDate(tgl1);
        isRawat();
        ChkInput.setSelected(true);
        isForm();
        ChkInput1.setSelected(true);
        isForm2();
        ChkInput2.setSelected(true);
        isForm3();
        ChkInput3.setSelected(true);
        isForm4();
        ChkInput4.setSelected(true);
        isForm5();
        
        TabRawatMouseClicked(null);
        isCek();
        
    }

    private void isForm() {
        if (ChkInput.isSelected() == true) {
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH, 300));
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
            PanelInput1.setPreferredSize(new Dimension(WIDTH, 300));
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
            PanelInput2.setPreferredSize(new Dimension(WIDTH, 300));
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
            PanelInput3.setPreferredSize(new Dimension(WIDTH, 300));
            panelGlass15.setVisible(true);
            ChkInput3.setVisible(true);
        } else if (ChkInput3.isSelected() == false) {
            ChkInput3.setVisible(false);
            PanelInput3.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass15.setVisible(false);
            ChkInput3.setVisible(true);
        }
    }
    
    private void isForm5() {
        if (ChkInput4.isSelected() == true) {
            ChkInput4.setVisible(false);
            PanelInput4.setPreferredSize(new Dimension(WIDTH, 300));
            panelGlass16.setVisible(true);
            ChkInput4.setVisible(true);
        } else if (ChkInput4.isSelected() == false) {
            ChkInput4.setVisible(false);
            PanelInput4.setPreferredSize(new Dimension(WIDTH, 20));
            panelGlass16.setVisible(false);
            ChkInput4.setVisible(true);
        }
    }

    public void isCek() {
        BtnSimpan.setEnabled(akses.gettindakan_ralan());
        BtnHapus.setEnabled(akses.gettindakan_ralan());
        BtnEdit.setEnabled(akses.gettindakan_ralan());
    }

    private void getDataPreOp() {
        if (tbPreOp.getSelectedRow() != -1) {
            TNoRw.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),0).toString());
            TNoRM.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),1).toString());
            TPasien.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),2).toString());
            TglLahir.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),3).toString());
            JK.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),4).toString());
            SNCN.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),6).toString());
            Tindakan.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),7).toString());
            KodeDokterBedah.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),8).toString());
            NamaDokterBedah.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),9).toString());
            KodeDokterAnestesi.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),10).toString());
            NamaDokterAnestesi.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),11).toString());
            Identitas.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),12).toString());
            KeadaanUmum.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),13).toString());
            AreaOperasi.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),14).toString());
            IjinBedah.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),15).toString());
            IjinAnestesi.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),16).toString());
            IjinTransfusi.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),17).toString());
            PersiapanDarah.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),18).toString());
            KeteranganPersiapanDarah.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),19).toString());
            PerlengkapanKhusus.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),20).toString());
            Radiologi.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),21).toString());
            KeteranganRadiologi.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),22).toString());
            EKG.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),23).toString());
            KeteranganEKG.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),24).toString());
            USG.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),25).toString());
            KeteranganUSG.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),26).toString());
            CTScan.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),27).toString());
            KeteranganCTScan.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),28).toString());
            MRI.setSelectedItem(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),29).toString());
            KeteranganMRI.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),30).toString());
            KdPetugasRuangan.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),31).toString());
            NmPetugasRuangan.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),32).toString());
            KdPetugasOK.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),33).toString());
            NmPetugasOK.setText(tbPreOp.getValueAt(tbPreOp.getSelectedRow(),34).toString());
            Valid.SetTgl2(Tanggal,tbPreOp.getValueAt(tbPreOp.getSelectedRow(),5).toString());
            
        }
    }

    private void getDataSignIn() {
        if (tbSignIn.getSelectedRow() != -1) {
            TNoRw.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),0).toString());
            TNoRM.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),1).toString());
            TPasien.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),2).toString());
            TglLahir.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),3).toString());
            SNCN.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),6).toString());
            Tindakan.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),7).toString());
            KodeDokterBedah.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),8).toString());
            NamaDokterBedah.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),9).toString());
            KodeDokterAnestesi.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),10).toString());
            NamaDokterAnestesi.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),11).toString());
            Identitas1.setSelectedItem(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),12).toString());
            Alergi.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),13).toString());
            AreaOperasi1.setSelectedItem(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),14).toString());
            ResikoAspirasi.setSelectedItem(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),15).toString());
            AntisipasiResikoAspirasi.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),16).toString());
            ResikoKehilanganDarah.setSelectedItem(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),17).toString());
            JalurIVLine.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),18).toString());
            RencanaAntisipasiKehilanganDarah.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),19).toString());
            KesiapanAlatAnes.setSelectedItem(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),20).toString());
            RencanaAntisipasiKesiapanAlat.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),21).toString());
            KdPetugasOK1.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),22).toString());
            NmPetugasOK1.setText(tbSignIn.getValueAt(tbSignIn.getSelectedRow(),23).toString());
            Valid.SetTgl2(Tanggal,tbSignIn.getValueAt(tbSignIn.getSelectedRow(),5).toString());
           
        }
    }
    
    private void getDataTimeOut() {
        if (tbTimeOut.getSelectedRow() != -1) {
            TNoRw.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),0).toString());
            TNoRM.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),1).toString());
            TPasien.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),2).toString());
            TglLahir.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),3).toString());
            SNCN.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),6).toString());
            Tindakan.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),7).toString());
            KodeDokterBedah.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),8).toString());
            NamaDokterBedah.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),9).toString());
            KodeDokterAnestesi.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),10).toString());
            NamaDokterAnestesi.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),11).toString());
            VerbalIdentitas.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),12).toString());
            VerbalTindakan.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),13).toString());
            VerbalArea.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),14).toString());
            AreaOperasi2.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),15).toString());
            PerkiraanLama.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),16).toString());
            PenayanganRadiologi.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),17).toString());
            PenayanganCTScan.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),18).toString());
            PenayanganMRI.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),19).toString());
            PemberianAntibiotik.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),20).toString());
            NamaAntibiotikDIberikan.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),21).toString());
            JamPemberianAntibiotik.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),22).toString());
            AntisipasiKehilanganDarah.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),23).toString());
            AdaHalKhusus.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),24).toString());
            HalKhususDiperhatikan.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),25).toString());
            PetunjukSterilisasi.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),27).toString());
            VerifikasiOperatif.setSelectedItem(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),28).toString());
            KdPetugasOK2.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),29).toString());
            NmPetugasOK2.setText(tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),30).toString());
            Valid.SetTgl2(Tanggal,tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),5).toString());
            Valid.SetTgl(TanggalSeteril,tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),26).toString());
           
        }
    }
    
    private void getDataSignOut() {
        if (tbSignOut.getSelectedRow() != -1) {
            TNoRw.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),0).toString());
            TNoRM.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),1).toString());
            TPasien.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),2).toString());
            TglLahir.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),3).toString());
            SNCN.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),6).toString());
            Tindakan.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),7).toString());
            KodeDokterBedah.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),8).toString());
            NamaDokterBedah.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),9).toString());
            KodeDokterAnestesi.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),10).toString());
            NamaDokterAnestesi.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),11).toString());
            VerbalTindakan1.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),12).toString());
            VerbalKasa.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),13).toString());
            VerbalInstrumen.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),14).toString());
            VerbalAlatTajam.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),15).toString());
            KelengkapanSpesimenLabel.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),16).toString());
            KelengkapanSpesimenFormulir.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),17).toString());
            PeninjauanKembaliDokterBedah.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),18).toString());
            PeninjauanKembaliDokterAnestesi.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),19).toString());
            PeninjauanKembaliPerawatKamarOK.setSelectedItem(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),20).toString());
            PerhatianUtamaFasePemulihan.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),21).toString());
            KdPetugasOK3.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),22).toString());
            NmPetugasOK3.setText(tbSignOut.getValueAt(tbSignOut.getSelectedRow(),23).toString());
            Valid.SetTgl2(Tanggal,tbSignOut.getValueAt(tbSignOut.getSelectedRow(),5).toString());
           
        }
    }
    
    private void getDataPostOp() {
        if (tbPostOp.getSelectedRow() != -1) {
            TNoRw.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),0).toString());
            TNoRM.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),1).toString());
            TPasien.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),2).toString());
            TglLahir.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),3).toString());
            JK.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),4).toString());
            SNCN.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),6).toString());
            Tindakan.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),7).toString());
            KodeDokterBedah.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),8).toString());
            NamaDokterBedah.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),9).toString());
            KodeDokterAnestesi.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),10).toString());
            NamaDokterAnestesi.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),11).toString());
            KeadaanUmum1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),12).toString());
            Radiologi1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),13).toString());
            KeteranganRadiologi1.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),14).toString());
            EKG1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),15).toString());
            KeteranganEKG1.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),16).toString());
            USG1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),17).toString());
            KeteranganUSG1.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),18).toString());
            CTScan1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),19).toString());
            KeteranganCTScan1.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),20).toString());
            MRI1.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),21).toString());
            KeteranganMRI1.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),22).toString());
            CairanInfus.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),23).toString());
            KateterUrine.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),24).toString());
            WarnaUrine.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),26).toString());
            JumlahUrine.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),27).toString());
            AreaLukaOperasi.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),28).toString());
            Drain.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),29).toString());
            JumlahDrain.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),30).toString());
            LetakDrain.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),31).toString());
            WarnaDrain.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),32).toString());
            JaringanPA.setSelectedItem(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),33).toString());
            KdPetugasOK4.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),34).toString());
            NmPetugasOK4.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),35).toString());
            KdPetugasAnest.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),36).toString());
            NmPetugasAnest.setText(tbPostOp.getValueAt(tbPostOp.getSelectedRow(),37).toString());
            Valid.SetTgl2(Tanggal,tbPostOp.getValueAt(tbPostOp.getSelectedRow(),5).toString());
            if(!tbPostOp.getValueAt(tbPostOp.getSelectedRow(),25).toString().equals("")){
                Valid.SetTgl2(TanggalKateter,tbPostOp.getValueAt(tbPostOp.getSelectedRow(),25).toString());
            }
           
        }
    }

    public void TampilkanData() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                tampilkanPreOp();
                break;
            case 1:
                tampilkanSignIn();
                break;
            case 2:
                tampilkanTimeOut();
                break;
            case 3:
                tampilkanSignOut();
                break;
            case 4:
                tampilkanPostOp();
                break;
            default:
                break;
        }
    }
    
    private void tampilkanPreOp() {
        Valid.tabelKosong(tabModePreOp);
        try {
            String sql = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.tgl_lahir,pasien.jk,checklist_pre_operasi.tanggal,"
                    + "checklist_pre_operasi.sncn,checklist_pre_operasi.tindakan,checklist_pre_operasi.kd_dokter_bedah,dokterbedah.nm_dokter as dokterbedah,"
                    + "checklist_pre_operasi.kd_dokter_anestesi,dokteranestesi.nm_dokter as dokteranestesi,checklist_pre_operasi.identitas,"
                    + "checklist_pre_operasi.surat_ijin_bedah,checklist_pre_operasi.surat_ijin_anestesi,checklist_pre_operasi.surat_ijin_transfusi,"
                    + "checklist_pre_operasi.penandaan_area_operasi,checklist_pre_operasi.keadaan_umum,checklist_pre_operasi.pemeriksaan_penunjang_rontgen,"
                    + "checklist_pre_operasi.keterangan_pemeriksaan_penunjang_rontgen,checklist_pre_operasi.pemeriksaan_penunjang_ekg,"
                    + "checklist_pre_operasi.keterangan_pemeriksaan_penunjang_ekg,checklist_pre_operasi.pemeriksaan_penunjang_usg,"
                    + "checklist_pre_operasi.keterangan_pemeriksaan_penunjang_usg,checklist_pre_operasi.pemeriksaan_penunjang_ctscan,"
                    + "checklist_pre_operasi.keterangan_pemeriksaan_penunjang_ctscan,checklist_pre_operasi.pemeriksaan_penunjang_mri,"
                    + "checklist_pre_operasi.keterangan_pemeriksaan_penunjang_mri,checklist_pre_operasi.persiapan_darah,checklist_pre_operasi.keterangan_persiapan_darah,"
                    + "checklist_pre_operasi.perlengkapan_khusus,checklist_pre_operasi.nip_petugas_ruangan,petugasruangan.nama as petugasruangan,"
                    + "checklist_pre_operasi.nip_perawat_ok,petugasok.nama as petugasok "
                    + "from checklist_pre_operasi "
                    + "inner join reg_periksa on checklist_pre_operasi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter as dokterbedah on dokterbedah.kd_dokter=checklist_pre_operasi.kd_dokter_bedah "
                    + "inner join dokter as dokteranestesi on dokteranestesi.kd_dokter=checklist_pre_operasi.kd_dokter_anestesi "
                    + "inner join petugas as petugasruangan on petugasruangan.nip=checklist_pre_operasi.nip_petugas_ruangan "
                    + "inner join petugas as petugasok on petugasok.nip=checklist_pre_operasi.nip_perawat_ok "
                    + "where checklist_pre_operasi.tanggal between ? and ? ";

            if (!TCari.getText().trim().isEmpty()) {
                sql
                        += "and (reg_periksa.no_rawat like ? OR "
                        + "pasien.no_rkm_medis like ? OR "
                        + "pasien.nm_pasien like ? OR "
                        + "dokterbedah.nm_dokter like ? OR "
                        + "dokteranestesi.nm_dokter like ? OR "
                        + "petugasruangan.nama like ?) ";
            }

            sql += "order by checklist_pre_operasi.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    ps.setString(3, "%" + TCari.getText().trim() + "%");
                    ps.setString(4, "%" + TCari.getText().trim() + "%");
                    ps.setString(5, "%" + TCari.getText().trim() + "%");
                    ps.setString(6, "%" + TCari.getText().trim() + "%");
                    ps.setString(7, "%" + TCari.getText().trim() + "%");
                    ps.setString(8, "%" + TCari.getText().trim() + "%");
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModePreOp.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),
                        rs.getString("tanggal"),rs.getString("sncn"),rs.getString("tindakan"),rs.getString("kd_dokter_bedah"),rs.getString("dokterbedah"),
                        rs.getString("kd_dokter_anestesi"),rs.getString("dokteranestesi"),rs.getString("identitas"),rs.getString("keadaan_umum"),
                        rs.getString("penandaan_area_operasi"),rs.getString("surat_ijin_bedah"),rs.getString("surat_ijin_anestesi"),rs.getString("surat_ijin_transfusi"),
                        rs.getString("persiapan_darah"),rs.getString("keterangan_persiapan_darah"),rs.getString("perlengkapan_khusus"),rs.getString("pemeriksaan_penunjang_rontgen"),
                        rs.getString("keterangan_pemeriksaan_penunjang_rontgen"),rs.getString("pemeriksaan_penunjang_ekg"),rs.getString("keterangan_pemeriksaan_penunjang_ekg"),
                        rs.getString("pemeriksaan_penunjang_usg"),rs.getString("keterangan_pemeriksaan_penunjang_usg"),rs.getString("pemeriksaan_penunjang_ctscan"),
                        rs.getString("keterangan_pemeriksaan_penunjang_ctscan"),rs.getString("pemeriksaan_penunjang_mri"),rs.getString("keterangan_pemeriksaan_penunjang_mri"),
                        rs.getString("nip_petugas_ruangan"),rs.getString("petugasruangan"),rs.getString("nip_perawat_ok"),rs.getString("petugasok")
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
        LCount.setText("" + tabModePreOp.getRowCount());
    }

    private void tampilkanSignIn() {
        Valid.tabelKosong(tabModeSignIn);
        try {
            String sql
                    = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.tgl_lahir,pasien.jk,signin_sebelum_anestesi.tanggal,"
                    + "signin_sebelum_anestesi.sncn,signin_sebelum_anestesi.tindakan,signin_sebelum_anestesi.kd_dokter_bedah,dokterbedah.nm_dokter as dokterbedah,"
                    + "signin_sebelum_anestesi.kd_dokter_anestesi,dokteranestesi.nm_dokter as dokteranestesi,signin_sebelum_anestesi.identitas,signin_sebelum_anestesi.penandaan_area_operasi,"
                    + "signin_sebelum_anestesi.alergi,signin_sebelum_anestesi.resiko_aspirasi,signin_sebelum_anestesi.resiko_aspirasi_rencana_antisipasi,"
                    + "signin_sebelum_anestesi.resiko_kehilangan_darah,signin_sebelum_anestesi.resiko_kehilangan_darah_line,signin_sebelum_anestesi.resiko_kehilangan_darah_rencana_antisipasi,"
                    + "signin_sebelum_anestesi.kesiapan_alat_obat_anestesi,signin_sebelum_anestesi.kesiapan_alat_obat_anestesi_rencana_antisipasi,signin_sebelum_anestesi.nip_perawat_ok,"
                    + "petugas.nama "
                    + "from signin_sebelum_anestesi "
                    + "inner join reg_periksa on signin_sebelum_anestesi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter as dokterbedah on dokterbedah.kd_dokter=signin_sebelum_anestesi.kd_dokter_bedah "
                    + "inner join dokter as dokteranestesi on dokteranestesi.kd_dokter=signin_sebelum_anestesi.kd_dokter_anestesi "
                    + "inner join petugas on petugas.nip=signin_sebelum_anestesi.nip_perawat_ok "
                    + "where signin_sebelum_anestesi.tanggal between ? and ? ";

            if (!TCari.getText().trim().isEmpty()) {
                sql
                        += "and (reg_periksa.no_rawat like ? OR "
                        + "pasien.no_rkm_medis like ? OR "
                        + "pasien.nm_pasien like ? OR "
                        + "dokterbedah.nm_dokter like ? OR "
                        + "dokteranestesi.nm_dokter like ? OR "
                        + "petugas.nama like ?) ";
            }

            sql += "order by signin_sebelum_anestesi.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    ps.setString(3, "%" + TCari.getText().trim() + "%");
                    ps.setString(4, "%" + TCari.getText().trim() + "%");
                    ps.setString(5, "%" + TCari.getText().trim() + "%");
                    ps.setString(6, "%" + TCari.getText().trim() + "%");
                    ps.setString(7, "%" + TCari.getText().trim() + "%");
                    ps.setString(8, "%" + TCari.getText().trim() + "%");
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeSignIn.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),
                        rs.getString("tanggal"),rs.getString("sncn"),rs.getString("tindakan"),rs.getString("kd_dokter_bedah"),rs.getString("dokterbedah"),
                        rs.getString("kd_dokter_anestesi"),rs.getString("dokteranestesi"),rs.getString("identitas"),rs.getString("alergi"),rs.getString("penandaan_area_operasi"),
                        rs.getString("resiko_aspirasi"),rs.getString("resiko_aspirasi_rencana_antisipasi"),rs.getString("resiko_kehilangan_darah"),rs.getString("resiko_kehilangan_darah_line"),
                        rs.getString("resiko_kehilangan_darah_rencana_antisipasi"),rs.getString("kesiapan_alat_obat_anestesi"),rs.getString("kesiapan_alat_obat_anestesi_rencana_antisipasi"),
                        rs.getString("nip_perawat_ok"),rs.getString("nama")
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
        LCount.setText("" + tabModeSignIn.getRowCount());
    }

    private void tampilkanTimeOut() {
        Valid.tabelKosong(tabModeTimeOut);
        try {
            String sql
                    = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.tgl_lahir,pasien.jk,timeout_sebelum_insisi.tanggal,"
                    + "timeout_sebelum_insisi.sncn,timeout_sebelum_insisi.tindakan,timeout_sebelum_insisi.kd_dokter_bedah,dokterbedah.nm_dokter as dokterbedah,"
                    + "timeout_sebelum_insisi.kd_dokter_anestesi,dokteranestesi.nm_dokter as dokteranestesi,timeout_sebelum_insisi.verbal_identitas,"
                    + "timeout_sebelum_insisi.verbal_tindakan,timeout_sebelum_insisi.verbal_area_insisi,timeout_sebelum_insisi.penandaan_area_operasi,"
                    + "timeout_sebelum_insisi.lama_operasi,timeout_sebelum_insisi.penayangan_radiologi,timeout_sebelum_insisi.penayangan_ctscan,"
                    + "timeout_sebelum_insisi.penayangan_mri,timeout_sebelum_insisi.antibiotik_profilaks,timeout_sebelum_insisi.nama_antibiotik,"
                    + "timeout_sebelum_insisi.jam_pemberian,timeout_sebelum_insisi.antisipasi_kehilangan_darah,timeout_sebelum_insisi.hal_khusus,"
                    + "timeout_sebelum_insisi.hal_khusus_diperhatikan,timeout_sebelum_insisi.tanggal_steril,timeout_sebelum_insisi.petujuk_sterilisasi,"
                    + "timeout_sebelum_insisi.verifikasi_preoperatif,timeout_sebelum_insisi.nip_perawat_ok,petugas.nama "
                    + "from timeout_sebelum_insisi "
                    + "inner join reg_periksa on timeout_sebelum_insisi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter as dokterbedah on dokterbedah.kd_dokter=timeout_sebelum_insisi.kd_dokter_bedah "
                    + "inner join dokter as dokteranestesi on dokteranestesi.kd_dokter=timeout_sebelum_insisi.kd_dokter_anestesi "
                    + "inner join petugas on petugas.nip=timeout_sebelum_insisi.nip_perawat_ok "
                    + "where timeout_sebelum_insisi.tanggal between ? and ? ";

            if (!TCari.getText().trim().isEmpty()) {
                sql
                        += "and (reg_periksa.no_rawat like ? OR "
                        + "pasien.no_rkm_medis like ? OR "
                        + "pasien.nm_pasien like ? OR "
                        + "dokterbedah.nm_dokter like ? OR "
                        + "dokteranestesi.nm_dokter like ? OR "
                        + "petugas.nama like ?) ";
            }

            sql += "order by timeout_sebelum_insisi.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    ps.setString(3, "%" + TCari.getText().trim() + "%");
                    ps.setString(4, "%" + TCari.getText().trim() + "%");
                    ps.setString(5, "%" + TCari.getText().trim() + "%");
                    ps.setString(6, "%" + TCari.getText().trim() + "%");
                    ps.setString(7, "%" + TCari.getText().trim() + "%");
                    ps.setString(8, "%" + TCari.getText().trim() + "%");
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeTimeOut.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),
                        rs.getString("tanggal"),rs.getString("sncn"),rs.getString("tindakan"),rs.getString("kd_dokter_bedah"),rs.getString("dokterbedah"),
                        rs.getString("kd_dokter_anestesi"),rs.getString("dokteranestesi"),rs.getString("verbal_identitas"),rs.getString("verbal_tindakan"),
                        rs.getString("verbal_area_insisi"),rs.getString("penandaan_area_operasi"),rs.getString("lama_operasi"),rs.getString("penayangan_radiologi"),
                        rs.getString("penayangan_ctscan"),rs.getString("penayangan_mri"),rs.getString("antibiotik_profilaks"),rs.getString("nama_antibiotik"),
                        rs.getString("jam_pemberian"),rs.getString("antisipasi_kehilangan_darah"),rs.getString("hal_khusus"),rs.getString("hal_khusus_diperhatikan"),
                        rs.getString("tanggal_steril"),rs.getString("petujuk_sterilisasi"),rs.getString("verifikasi_preoperatif"),rs.getString("nip_perawat_ok"),
                        rs.getString("nama")
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
        LCount.setText("" + tabModeTimeOut.getRowCount());
    }
    
    private void tampilkanSignOut() {
        Valid.tabelKosong(tabModeSignOut);
        try {
            String sql
                    = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.tgl_lahir,pasien.jk,signout_sebelum_menutup_luka.tanggal,"
                    + "signout_sebelum_menutup_luka.sncn,signout_sebelum_menutup_luka.tindakan,signout_sebelum_menutup_luka.kd_dokter_bedah,dokterbedah.nm_dokter as dokterbedah,"
                    + "signout_sebelum_menutup_luka.kd_dokter_anestesi,dokteranestesi.nm_dokter as dokteranestesi,signout_sebelum_menutup_luka.verbal_tindakan,"
                    + "signout_sebelum_menutup_luka.verbal_kelengkapan_kasa,signout_sebelum_menutup_luka.verbal_instrumen,signout_sebelum_menutup_luka.verbal_alat_tajam,"
                    + "signout_sebelum_menutup_luka.kelengkapan_specimen_label,signout_sebelum_menutup_luka.kelengkapan_specimen_formulir,"
                    + "signout_sebelum_menutup_luka.peninjauan_kegiatan_dokter_bedah,signout_sebelum_menutup_luka.peninjauan_kegiatan_dokter_anestesi,"
                    + "signout_sebelum_menutup_luka.peninjauan_kegiatan_perawat_kamar_ok,signout_sebelum_menutup_luka.perhatian_utama_fase_pemulihan,"
                    + "signout_sebelum_menutup_luka.nip_perawat_ok,petugas.nama "
                    + "from signout_sebelum_menutup_luka "
                    + "inner join reg_periksa on signout_sebelum_menutup_luka.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter as dokterbedah on dokterbedah.kd_dokter=signout_sebelum_menutup_luka.kd_dokter_bedah "
                    + "inner join dokter as dokteranestesi on dokteranestesi.kd_dokter=signout_sebelum_menutup_luka.kd_dokter_anestesi "
                    + "inner join petugas on petugas.nip=signout_sebelum_menutup_luka.nip_perawat_ok "
                    + "where signout_sebelum_menutup_luka.tanggal between ? and ? ";

            if (!TCari.getText().trim().isEmpty()) {
                sql
                        += "and (reg_periksa.no_rawat like ? OR "
                        + "pasien.no_rkm_medis like ? OR "
                        + "pasien.nm_pasien like ? OR "
                        + "dokterbedah.nm_dokter like ? OR "
                        + "dokteranestesi.nm_dokter like ? OR "
                        + "petugas.nama like ?) ";
            }

            sql += "order by signout_sebelum_menutup_luka.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    ps.setString(3, "%" + TCari.getText().trim() + "%");
                    ps.setString(4, "%" + TCari.getText().trim() + "%");
                    ps.setString(5, "%" + TCari.getText().trim() + "%");
                    ps.setString(6, "%" + TCari.getText().trim() + "%");
                    ps.setString(7, "%" + TCari.getText().trim() + "%");
                    ps.setString(8, "%" + TCari.getText().trim() + "%");
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModeSignOut.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),
                        rs.getString("tanggal"),rs.getString("sncn"),rs.getString("tindakan"),rs.getString("kd_dokter_bedah"),rs.getString("dokterbedah"),
                        rs.getString("kd_dokter_anestesi"),rs.getString("dokteranestesi"),rs.getString("verbal_tindakan"),rs.getString("verbal_kelengkapan_kasa"),
                        rs.getString("verbal_instrumen"),rs.getString("verbal_alat_tajam"),rs.getString("kelengkapan_specimen_label"),
                        rs.getString("kelengkapan_specimen_formulir"),rs.getString("peninjauan_kegiatan_dokter_bedah"),rs.getString("peninjauan_kegiatan_dokter_anestesi"),
                        rs.getString("peninjauan_kegiatan_perawat_kamar_ok"),rs.getString("perhatian_utama_fase_pemulihan"),rs.getString("nip_perawat_ok"),
                        rs.getString("nama")
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
        LCount.setText("" + tabModeSignOut.getRowCount());
    }
    
    private void tampilkanPostOp() {
        Valid.tabelKosong(tabModePostOp);
        try {
            String sql
                    = "select reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,pasien.tgl_lahir,pasien.jk,checklist_post_operasi.tanggal,"
                    + "checklist_post_operasi.sncn,checklist_post_operasi.tindakan,checklist_post_operasi.kd_dokter_bedah,dokterbedah.nm_dokter as dokterbedah,"
                    + "checklist_post_operasi.kd_dokter_anestesi,dokteranestesi.nm_dokter as dokteranestesi,checklist_post_operasi.keadaan_umum,"
                    + "checklist_post_operasi.pemeriksaan_penunjang_rontgen,checklist_post_operasi.keterangan_pemeriksaan_penunjang_rontgen,"
                    + "checklist_post_operasi.pemeriksaan_penunjang_ekg,checklist_post_operasi.keterangan_pemeriksaan_penunjang_ekg,checklist_post_operasi.pemeriksaan_penunjang_usg,"
                    + "checklist_post_operasi.keterangan_pemeriksaan_penunjang_usg,checklist_post_operasi.pemeriksaan_penunjang_ctscan,"
                    + "checklist_post_operasi.keterangan_pemeriksaan_penunjang_ctscan,checklist_post_operasi.pemeriksaan_penunjang_mri,"
                    + "checklist_post_operasi.keterangan_pemeriksaan_penunjang_mri,checklist_post_operasi.jenis_cairan_infus,checklist_post_operasi.kateter_urine,"
                    + "checklist_post_operasi.tanggal_pemasangan_kateter,checklist_post_operasi.warna_kateter,checklist_post_operasi.jumlah_kateter,"
                    + "checklist_post_operasi.area_luka_operasi,checklist_post_operasi.drain,checklist_post_operasi.jumlah_drain,checklist_post_operasi.letak_drain,"
                    + "checklist_post_operasi.warna_drain,checklist_post_operasi.jaringan_pa,checklist_post_operasi.nip_perawat_ok,petugasok.nama as petugasok,"
                    + "checklist_post_operasi.nip_perawat_anestesi,petugasanestesi.nama as petugasanestesi "
                    + "from checklist_post_operasi "
                    + "inner join reg_periksa on checklist_post_operasi.no_rawat=reg_periksa.no_rawat "
                    + "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "
                    + "inner join dokter as dokterbedah on dokterbedah.kd_dokter=checklist_post_operasi.kd_dokter_bedah "
                    + "inner join dokter as dokteranestesi on dokteranestesi.kd_dokter=checklist_post_operasi.kd_dokter_anestesi "
                    + "inner join petugas as petugasanestesi on petugasanestesi.nip=checklist_post_operasi.nip_perawat_anestesi "
                    + "inner join petugas as petugasok on petugasok.nip=checklist_post_operasi.nip_perawat_ok "
                    + "where checklist_post_operasi.tanggal between ? and ? ";

            if (!TCari.getText().trim().isEmpty()) {
                sql
                        += "and (reg_periksa.no_rawat like ? OR "
                        + "pasien.no_rkm_medis like ? OR "
                        + "pasien.nm_pasien like ? OR "
                        + "dokterbedah.nm_dokter like ? OR "
                        + "dokteranestesi.nm_dokter like ? OR "
                        + "petugasanestesi.nama like ?) ";
            }

            sql += "order by checklist_post_operasi.tanggal";

            ps = koneksi.prepareStatement(sql);
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + "") + " 00:00:00");
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + "") + " 23:59:59");

                if (!TCari.getText().trim().isEmpty()) {
                    ps.setString(3, "%" + TCari.getText().trim() + "%");
                    ps.setString(4, "%" + TCari.getText().trim() + "%");
                    ps.setString(5, "%" + TCari.getText().trim() + "%");
                    ps.setString(6, "%" + TCari.getText().trim() + "%");
                    ps.setString(7, "%" + TCari.getText().trim() + "%");
                    ps.setString(8, "%" + TCari.getText().trim() + "%");
                }
                
                rs=ps.executeQuery();
                while(rs.next()){
                    tabModePostOp.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),rs.getDate("tgl_lahir"),rs.getString("jk"),
                        rs.getString("tanggal"),rs.getString("sncn"),rs.getString("tindakan"),rs.getString("kd_dokter_bedah"),rs.getString("dokterbedah"),
                        rs.getString("kd_dokter_anestesi"),rs.getString("dokteranestesi"),rs.getString("keadaan_umum"),rs.getString("pemeriksaan_penunjang_rontgen"),
                        rs.getString("keterangan_pemeriksaan_penunjang_rontgen"),rs.getString("pemeriksaan_penunjang_ekg"),rs.getString("keterangan_pemeriksaan_penunjang_ekg"),
                        rs.getString("pemeriksaan_penunjang_usg"),rs.getString("keterangan_pemeriksaan_penunjang_usg"),rs.getString("pemeriksaan_penunjang_ctscan"),
                        rs.getString("keterangan_pemeriksaan_penunjang_ctscan"),rs.getString("pemeriksaan_penunjang_mri"),rs.getString("keterangan_pemeriksaan_penunjang_mri"),
                        rs.getString("jenis_cairan_infus"),rs.getString("kateter_urine"),rs.getString("tanggal_pemasangan_kateter"),rs.getString("warna_kateter"),
                        rs.getString("jumlah_kateter"),rs.getString("area_luka_operasi"),rs.getString("drain"),rs.getString("jumlah_drain"),rs.getString("letak_drain"),
                        rs.getString("warna_drain"),rs.getString("jaringan_pa"),rs.getString("nip_perawat_ok"),rs.getString("petugasok"),rs.getString("nip_perawat_anestesi"),
                        rs.getString("petugasanestesi")
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
        LCount.setText("" + tabModePostOp.getRowCount());
    }

    public void emptTeks() {
        emptTeksHeader();
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                emptTeksPreOp();
                break;
            case 1:
                emptTeksSignIn();
                break;
            case 2:
                emptTeksTimeOut();
                break;
            case 3:
                emptTeksSignOut();
                break;
            case 4:
                emptTeksPostOp();
                break;
            default:
                break;
        }
    }
    
    public void emptTeksSemua() {
        emptTeksHeader();
        emptTeksPreOp();
        emptTeksSignIn();
        emptTeksTimeOut();
        emptTeksSignOut();
        emptTeksPostOp();
    }
    
    private void emptTeksHeader() {
        Tanggal.setDate(new Date());
        SNCN.setText("");
        KodeDokterBedah.setText("");
        NamaDokterBedah.setText("");
        Tindakan.setText("");
        KodeDokterAnestesi.setText("");
        NamaDokterAnestesi.setText("");
    }
    
    private void emptTeksPreOp() {
        ChkInput.setSelected(true);
        Identitas.setSelectedIndex(0);
        KeadaanUmum.setSelectedIndex(0);
        AreaOperasi.setSelectedIndex(0);
        IjinBedah.setSelectedIndex(0);
        IjinAnestesi.setSelectedIndex(0);
        IjinTransfusi.setSelectedIndex(0);
        PersiapanDarah.setSelectedIndex(0);
        KeteranganPersiapanDarah.setText("");
        PerlengkapanKhusus.setSelectedIndex(0);
        Radiologi.setSelectedIndex(0);
        KeteranganRadiologi.setText("");
        USG.setSelectedIndex(0);
        KeteranganUSG.setText("");
        MRI.setSelectedIndex(0);
        KeteranganMRI.setText("");
        EKG.setSelectedIndex(0);
        KeteranganEKG.setText("");
        CTScan.setSelectedIndex(0);
        KeteranganCTScan.setText("");
        KdPetugasRuangan.setText("");
        NmPetugasRuangan.setText("");
        KdPetugasOK.setText("");
        NmPetugasOK.setText("");
    }
    
    private void emptTeksSignIn() {
        ChkInput1.setSelected(true);
        Identitas1.setSelectedIndex(0);
        Alergi.setText("");
        AreaOperasi1.setSelectedIndex(0);
        ResikoAspirasi.setSelectedIndex(0);
        AntisipasiResikoAspirasi.setText("");
        ResikoKehilanganDarah.setSelectedIndex(0);
        JalurIVLine.setText("");
        RencanaAntisipasiKehilanganDarah.setText("");
        KesiapanAlatAnes.setSelectedIndex(0);
        RencanaAntisipasiKesiapanAlat.setText("");
        KdPetugasOK1.setText("");
        NmPetugasOK2.setText("");
    }
    
    private void emptTeksTimeOut() {
        ChkInput2.setSelected(true);
        VerbalIdentitas.setSelectedIndex(0);
        VerbalTindakan.setSelectedIndex(0);
        VerbalArea.setSelectedIndex(0);
        AreaOperasi2.setSelectedIndex(0);
        PerkiraanLama.setText("");
        PenayanganRadiologi.setSelectedIndex(0);
        PenayanganCTScan.setSelectedIndex(0);
        PenayanganMRI.setSelectedIndex(0);
        PemberianAntibiotik.setSelectedIndex(0);
        NamaAntibiotikDIberikan.setText("");
        JamPemberianAntibiotik.setText("");
        AntisipasiKehilanganDarah.setText("");
        HalKhususDiperhatikan.setText("");
        TanggalSeteril.setDate(new Date());
        PetunjukSterilisasi.setSelectedIndex(0);
        VerifikasiOperatif.setSelectedIndex(0);
        KdPetugasOK2.setText("");
        NmPetugasOK2.setText("");
    }
    
    private void emptTeksSignOut() {
        ChkInput3.setSelected(true);
        VerbalTindakan1.setSelectedIndex(0);
        VerbalKasa.setSelectedIndex(0);
        VerbalInstrumen.setSelectedIndex(0);
        VerbalAlatTajam.setSelectedIndex(0);
        KelengkapanSpesimenLabel.setSelectedIndex(0);
        KelengkapanSpesimenFormulir.setSelectedIndex(0);
        PeninjauanKembaliDokterBedah.setSelectedIndex(0);
        PeninjauanKembaliDokterAnestesi.setSelectedIndex(0);
        PeninjauanKembaliPerawatKamarOK.setSelectedIndex(0);
        PerhatianUtamaFasePemulihan.setText("");
        KdPetugasOK3.setText("");
        NmPetugasOK3.setText("");
    }
    
    private void emptTeksPostOp() {
        ChkInput4.setSelected(true);
        KeadaanUmum1.setSelectedIndex(0);
        CairanInfus.setText("");
        JaringanPA.setSelectedIndex(0);
        KateterUrine.setSelectedIndex(0);
        TanggalKateter.setDate(new Date());
        WarnaUrine.setSelectedIndex(0);
        JumlahUrine.setText("");
        Drain.setSelectedIndex(0);
        JumlahDrain.setText("");
        LetakDrain.setText("");
        WarnaDrain.setText("");
        Radiologi1.setSelectedIndex(0);
        KeteranganRadiologi1.setText("");
        USG1.setSelectedIndex(0);
        KeteranganUSG1.setText("");
        MRI1.setSelectedIndex(0);
        KeteranganMRI1.setText("");
        EKG1.setSelectedIndex(0);
        KeteranganEKG1.setText("");
        CTScan1.setSelectedIndex(0);
        KeteranganCTScan1.setText("");
        AreaLukaOperasi.setText("");
        KdPetugasAnest.setText("");
        NmPetugasAnest.setText("");
        KdPetugasOK4.setText("");
        NmPetugasOK4.setText("");
    }

    private void simpan() {
        switch (TabRawat.getSelectedIndex()) {
            case 0:
                simpanPreOp();
                break;
            case 1:
                simpanSignIn();
                break;
            case 2:
                simpanTimeOut();
                break;
            case 3:
                simpanSignOut();
                break;
            case 4:
                simpanPostOp();
                break;
            default:
                break;
        }
    }
    
    private void simpanPreOp() {
        if(Sequel.menyimpantf("checklist_pre_operasi","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",27,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
            KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),Identitas.getSelectedItem().toString(),IjinBedah.getSelectedItem().toString(), 
            IjinAnestesi.getSelectedItem().toString(),IjinTransfusi.getSelectedItem().toString(),AreaOperasi.getSelectedItem().toString(), 
            KeadaanUmum.getSelectedItem().toString(),Radiologi.getSelectedItem().toString(),KeteranganRadiologi.getText(),EKG.getSelectedItem().toString(), 
            KeteranganEKG.getText(),USG.getSelectedItem().toString(),KeteranganUSG.getText(),CTScan.getSelectedItem().toString(),KeteranganCTScan.getText(), 
            MRI.getSelectedItem().toString(),KeteranganMRI.getText(),PersiapanDarah.getSelectedItem().toString(),KeteranganPersiapanDarah.getText(), 
            PerlengkapanKhusus.getSelectedItem().toString(),KdPetugasRuangan.getText(),KdPetugasOK.getText()
        })==true){
            TampilkanData();
            emptTeks();
        } 
    }
    
    private void simpanSignIn() {
        if (Sequel.menyimpantf("signin_sebelum_anestesi", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "Data", 17, new String[]{
            TNoRw.getText(), Valid.SetTgl(Tanggal.getSelectedItem() + "") + " " + Tanggal.getSelectedItem().toString().substring(11, 19), SNCN.getText(), Tindakan.getText(),
            KodeDokterBedah.getText(), KodeDokterAnestesi.getText(), Identitas1.getSelectedItem().toString(), AreaOperasi1.getSelectedItem().toString(), Alergi.getText(),
            ResikoAspirasi.getSelectedItem().toString(), AntisipasiResikoAspirasi.getText(), ResikoKehilanganDarah.getSelectedItem().toString(), JalurIVLine.getText(),
            RencanaAntisipasiKehilanganDarah.getText(), KesiapanAlatAnes.getSelectedItem().toString(), RencanaAntisipasiKesiapanAlat.getText(), KdPetugasOK1.getText()
        }) == true) {
            TampilkanData();
            emptTeks();
        } 
    }
    
    private void simpanTimeOut() {
        if (Sequel.menyimpantf("timeout_sebelum_insisi", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "Data", 24, new String[]{
            TNoRw.getText(), Valid.SetTgl(Tanggal.getSelectedItem() + "") + " " + Tanggal.getSelectedItem().toString().substring(11, 19), SNCN.getText(), Tindakan.getText(),
            KodeDokterBedah.getText(), KodeDokterAnestesi.getText(), VerbalIdentitas.getSelectedItem().toString(), VerbalTindakan.getSelectedItem().toString(),
            VerbalArea.getSelectedItem().toString(), AreaOperasi2.getSelectedItem().toString(), PerkiraanLama.getText(), PenayanganRadiologi.getSelectedItem().toString(),
            PenayanganCTScan.getSelectedItem().toString(), PenayanganMRI.getSelectedItem().toString(), PemberianAntibiotik.getSelectedItem().toString(),
            NamaAntibiotikDIberikan.getText(), JamPemberianAntibiotik.getText(), AntisipasiKehilanganDarah.getText(), AdaHalKhusus.getSelectedItem().toString(),
            HalKhususDiperhatikan.getText(), Valid.SetTgl(TanggalSeteril.getSelectedItem() + ""), PetunjukSterilisasi.getSelectedItem().toString(),
            VerifikasiOperatif.getSelectedItem().toString(), KdPetugasOK2.getText()
        }) == true) {
            TampilkanData();
            emptTeks();
        }
    }
    
    private void simpanSignOut() {
        if(Sequel.menyimpantf("signout_sebelum_menutup_luka", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "Data", 17, new String[]{
            TNoRw.getText(), Valid.SetTgl(Tanggal.getSelectedItem() + "") + " " + Tanggal.getSelectedItem().toString().substring(11, 19), SNCN.getText(), Tindakan.getText(),
            KodeDokterBedah.getText(), KodeDokterAnestesi.getText(), VerbalTindakan1.getSelectedItem().toString(), VerbalKasa.getSelectedItem().toString(),
            VerbalInstrumen.getSelectedItem().toString(), VerbalAlatTajam.getSelectedItem().toString(), KelengkapanSpesimenLabel.getSelectedItem().toString(),
            KelengkapanSpesimenFormulir.getSelectedItem().toString(), PeninjauanKembaliDokterBedah.getSelectedItem().toString(), PeninjauanKembaliDokterAnestesi.getSelectedItem().toString(),
            PeninjauanKembaliPerawatKamarOK.getSelectedItem().toString(), PerhatianUtamaFasePemulihan.getText(), KdPetugasOK3.getText()
        }) == true) {
            TampilkanData();
            emptTeks();
        }
    }
    
    private void simpanPostOp() {
        if(Sequel.menyimpantf("checklist_post_operasi","?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?","Data",30,new String[]{
            TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
            KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),KeadaanUmum1.getSelectedItem().toString(),Radiologi1.getSelectedItem().toString(),KeteranganRadiologi1.getText(), 
            EKG1.getSelectedItem().toString(),KeteranganEKG1.getText(),USG1.getSelectedItem().toString(),KeteranganUSG1.getText(),CTScan1.getSelectedItem().toString(),
            KeteranganCTScan1.getText(),MRI1.getSelectedItem().toString(),KeteranganMRI1.getText(),CairanInfus.getText(),KateterUrine.getSelectedItem().toString(), 
            (KateterUrine.getSelectedIndex()==0?Valid.SetTgl(TanggalKateter.getSelectedItem()+"")+" "+TanggalKateter.getSelectedItem().toString().substring(11,19):"0000-00-00 00:00:0"),
            WarnaUrine.getSelectedItem().toString(),JumlahUrine.getText(),AreaLukaOperasi.getText(),Drain.getSelectedItem().toString(),JumlahDrain.getText(),LetakDrain.getText(),
            WarnaDrain.getText(),JaringanPA.getSelectedItem().toString(),KdPetugasOK4.getText(),KdPetugasAnest.getText()
        })==true){
            TampilkanData();
            emptTeks();
        } 
    }
    
    private void hapusPreOp() {
        if (tabModePreOp.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPreOp.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from checklist_pre_operasi where no_rawat=? and tanggal=?",2,new String[]{
            tbPreOp.getValueAt(tbPreOp.getSelectedRow(),0).toString(),tbPreOp.getValueAt(tbPreOp.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        
        tabModePreOp.removeRow(tbPreOp.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModePreOp.getRowCount());
    }
    
    private void hapusSignIn() {
        if (tabModeSignIn.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSignIn.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from signin_sebelum_anestesi where no_rawat=? and tanggal=?",2,new String[]{
            tbSignIn.getValueAt(tbSignIn.getSelectedRow(),0).toString(),tbSignIn.getValueAt(tbSignIn.getSelectedRow(),5).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeSignIn.removeRow(tbSignIn.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeSignIn.getRowCount());
    }
    
    private void hapusTimeOut() {
        if (tabModeTimeOut.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbTimeOut.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from timeout_sebelum_insisi where no_rawat=? and tanggal=?",2,new String[]{
            tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),0).toString(),tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),5).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeTimeOut.removeRow(tbTimeOut.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeTimeOut.getRowCount());
    }
    
    private void hapusSignOut() {
        if (tabModeSignOut.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSignOut.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from signout_sebelum_menutup_luka where no_rawat=? and tanggal=?",2,new String[]{
            tbSignOut.getValueAt(tbSignOut.getSelectedRow(),0).toString(),tbSignOut.getValueAt(tbSignOut.getSelectedRow(),5).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModeSignOut.removeRow(tbSignOut.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModeSignOut.getRowCount());
    }
    
    private void hapusPostOp() {
        if (tabModePostOp.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPostOp.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.queryu2tf("delete from checklist_post_operasi where no_rawat=? and tanggal=?",2,new String[]{
            tbPostOp.getValueAt(tbPostOp.getSelectedRow(),0).toString(),tbPostOp.getValueAt(tbPostOp.getSelectedRow(),5).toString()
        });
        
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
            return;
        }
        
        tabModePostOp.removeRow(tbPostOp.getSelectedRow());
        emptTeks();
        LCount.setText(""+tabModePostOp.getRowCount());
    }
    
    private void gantiPreOp() {
        if (tabModePreOp.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPreOp.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("checklist_pre_operasi","no_rawat=? and tanggal=?","no_rawat=?,tanggal=?,sncn=?,tindakan=?,kd_dokter_bedah=?,kd_dokter_anestesi=?,identitas=?,"+
            "surat_ijin_bedah=?,surat_ijin_anestesi=?,surat_ijin_transfusi=?,penandaan_area_operasi=?,keadaan_umum=?,pemeriksaan_penunjang_rontgen=?,keterangan_pemeriksaan_penunjang_rontgen=?,"+
            "pemeriksaan_penunjang_ekg=?,keterangan_pemeriksaan_penunjang_ekg=?,pemeriksaan_penunjang_usg=?,keterangan_pemeriksaan_penunjang_usg=?,pemeriksaan_penunjang_ctscan=?,"+
            "keterangan_pemeriksaan_penunjang_ctscan=?,pemeriksaan_penunjang_mri=?,keterangan_pemeriksaan_penunjang_mri=?,persiapan_darah=?,keterangan_persiapan_darah=?,perlengkapan_khusus=?,"+
            "nip_petugas_ruangan=?,nip_perawat_ok=?",29,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
                KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),Identitas.getSelectedItem().toString(),IjinBedah.getSelectedItem().toString(), 
                IjinAnestesi.getSelectedItem().toString(),IjinTransfusi.getSelectedItem().toString(),AreaOperasi.getSelectedItem().toString(), 
                KeadaanUmum.getSelectedItem().toString(),Radiologi.getSelectedItem().toString(),KeteranganRadiologi.getText(),EKG.getSelectedItem().toString(), 
                KeteranganEKG.getText(),USG.getSelectedItem().toString(),KeteranganUSG.getText(),CTScan.getSelectedItem().toString(),KeteranganCTScan.getText(), 
                MRI.getSelectedItem().toString(),KeteranganMRI.getText(),PersiapanDarah.getSelectedItem().toString(),KeteranganPersiapanDarah.getText(), 
                PerlengkapanKhusus.getSelectedItem().toString(),KdPetugasRuangan.getText(),KdPetugasOK.getText(),tbPreOp.getValueAt(tbPreOp.getSelectedRow(),0).toString(),
                tbPreOp.getValueAt(tbPreOp.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        if(tabModePreOp.getRowCount()!=0){TampilkanData();}
        emptTeks();
    }
    
    private void gantiSignIn() {
        if (tabModeSignIn.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSignIn.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("signin_sebelum_anestesi","no_rawat=? and tanggal=?","no_rawat=?,tanggal=?,sncn=?,tindakan=?,kd_dokter_bedah=?,kd_dokter_anestesi=?,identitas=?,"+
            "penandaan_area_operasi=?,alergi=?,resiko_aspirasi=?,resiko_aspirasi_rencana_antisipasi=?,resiko_kehilangan_darah=?,resiko_kehilangan_darah_line=?,"+
            "resiko_kehilangan_darah_rencana_antisipasi=?,kesiapan_alat_obat_anestesi=?,kesiapan_alat_obat_anestesi_rencana_antisipasi=?,nip_perawat_ok=?",19,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
                KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),Identitas1.getSelectedItem().toString(),AreaOperasi1.getSelectedItem().toString(),Alergi.getText(), 
                ResikoAspirasi.getSelectedItem().toString(),AntisipasiResikoAspirasi.getText(),ResikoKehilanganDarah.getSelectedItem().toString(),JalurIVLine.getText(), 
                RencanaAntisipasiKehilanganDarah.getText(),KesiapanAlatAnes.getSelectedItem().toString(),RencanaAntisipasiKesiapanAlat.getText(),KdPetugasOK1.getText(),
                tbSignIn.getValueAt(tbSignIn.getSelectedRow(),0).toString(),tbSignIn.getValueAt(tbSignIn.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        if(tabModeSignIn.getRowCount()!=0){TampilkanData();}
        emptTeks();
    }
    
    private void gantiTimeOut() {
        if (tabModeTimeOut.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbTimeOut.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("timeout_sebelum_insisi","no_rawat=? and tanggal=?","no_rawat=?,tanggal=?,sncn=?,tindakan=?,kd_dokter_bedah=?,kd_dokter_anestesi=?,verbal_identitas=?,verbal_tindakan=?,"+
            "verbal_area_insisi=?,penandaan_area_operasi=?,lama_operasi=?,penayangan_radiologi=?,penayangan_ctscan=?,penayangan_mri=?,antibiotik_profilaks=?,nama_antibiotik=?,jam_pemberian=?,"+
            "antisipasi_kehilangan_darah=?,hal_khusus=?,hal_khusus_diperhatikan=?,tanggal_steril=?,petujuk_sterilisasi=?,verifikasi_preoperatif=?,nip_perawat_ok=?",26,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
                KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),VerbalIdentitas.getSelectedItem().toString(),VerbalTindakan.getSelectedItem().toString(),
                VerbalArea.getSelectedItem().toString(),AreaOperasi2.getSelectedItem().toString(),PerkiraanLama.getText(),PenayanganRadiologi.getSelectedItem().toString(),
                PenayanganCTScan.getSelectedItem().toString(),PenayanganMRI.getSelectedItem().toString(),PemberianAntibiotik.getSelectedItem().toString(),
                NamaAntibiotikDIberikan.getText(),JamPemberianAntibiotik.getText(),AntisipasiKehilanganDarah.getText(),AdaHalKhusus.getSelectedItem().toString(),
                HalKhususDiperhatikan.getText(),Valid.SetTgl(TanggalSeteril.getSelectedItem()+""),PetunjukSterilisasi.getSelectedItem().toString(),
                VerifikasiOperatif.getSelectedItem().toString(),KdPetugasOK2.getText(),tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),0).toString(),
                tbTimeOut.getValueAt(tbTimeOut.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        if(tabModeTimeOut.getRowCount()!=0){TampilkanData();}
        emptTeks();
    }
    
    private void gantiSignOut() {
        if (tabModeSignOut.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbSignOut.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("signout_sebelum_menutup_luka","no_rawat=? and tanggal=?","no_rawat=?,tanggal=?,sncn=?,tindakan=?,kd_dokter_bedah=?,kd_dokter_anestesi=?,"+
                "verbal_tindakan=?,verbal_kelengkapan_kasa=?,verbal_instrumen=?,verbal_alat_tajam=?,kelengkapan_specimen_label=?,kelengkapan_specimen_formulir=?,"+
                "peninjauan_kegiatan_dokter_bedah=?,peninjauan_kegiatan_dokter_anestesi=?,peninjauan_kegiatan_perawat_kamar_ok=?,perhatian_utama_fase_pemulihan=?,"+
                "nip_perawat_ok=?",19,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
                KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),VerbalTindakan1.getSelectedItem().toString(),VerbalKasa.getSelectedItem().toString(), 
                VerbalInstrumen.getSelectedItem().toString(),VerbalAlatTajam.getSelectedItem().toString(),KelengkapanSpesimenLabel.getSelectedItem().toString(), 
                KelengkapanSpesimenFormulir.getSelectedItem().toString(),PeninjauanKembaliDokterBedah.getSelectedItem().toString(),PeninjauanKembaliDokterAnestesi.getSelectedItem().toString(), 
                PeninjauanKembaliPerawatKamarOK.getSelectedItem().toString(),PerhatianUtamaFasePemulihan.getText(),KdPetugasOK3.getText(),
                tbSignOut.getValueAt(tbSignOut.getSelectedRow(),0).toString(),tbSignOut.getValueAt(tbSignOut.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        if(tabModeSignOut.getRowCount()!=0){TampilkanData();}
        emptTeks();
    }
    
    private void gantiPostOp() {
        if (tabModePostOp.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            TNoRw.requestFocus();
            return;
        }
        
        if (tbPostOp.getSelectedRow() < 0) {
             JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
             return;
        }
        
        boolean sukses = Sequel.mengedittf("checklist_post_operasi","no_rawat=? and tanggal=?","no_rawat=?,tanggal=?,sncn=?,tindakan=?,kd_dokter_bedah=?,kd_dokter_anestesi=?,keadaan_umum=?,"+
                "pemeriksaan_penunjang_rontgen=?,keterangan_pemeriksaan_penunjang_rontgen=?,pemeriksaan_penunjang_ekg=?,keterangan_pemeriksaan_penunjang_ekg=?,"+
                "pemeriksaan_penunjang_usg=?,keterangan_pemeriksaan_penunjang_usg=?,pemeriksaan_penunjang_ctscan=?,keterangan_pemeriksaan_penunjang_ctscan=?,pemeriksaan_penunjang_mri=?,"+
                "keterangan_pemeriksaan_penunjang_mri=?,jenis_cairan_infus=?,kateter_urine=?,tanggal_pemasangan_kateter=?,warna_kateter=?,jumlah_kateter=?,area_luka_operasi=?,"+
                "drain=?,jumlah_drain=?,letak_drain=?,warna_drain=?,jaringan_pa=?,nip_perawat_ok=?,nip_perawat_anestesi=?",32,new String[]{
                TNoRw.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+"")+" "+Tanggal.getSelectedItem().toString().substring(11,19),SNCN.getText(),Tindakan.getText(),
                KodeDokterBedah.getText(),KodeDokterAnestesi.getText(),KeadaanUmum1.getSelectedItem().toString(),Radiologi1.getSelectedItem().toString(),KeteranganRadiologi1.getText(), 
                EKG1.getSelectedItem().toString(),KeteranganEKG1.getText(),USG1.getSelectedItem().toString(),KeteranganUSG1.getText(),CTScan1.getSelectedItem().toString(),
                KeteranganCTScan1.getText(),MRI1.getSelectedItem().toString(),KeteranganMRI1.getText(),CairanInfus.getText(),KateterUrine.getSelectedItem().toString(), 
                (KateterUrine.getSelectedIndex()==0?Valid.SetTgl(TanggalKateter.getSelectedItem()+"")+" "+TanggalKateter.getSelectedItem().toString().substring(11,19):"0000-00-00 00:00:0"),
                WarnaUrine.getSelectedItem().toString(),JumlahUrine.getText(),AreaLukaOperasi.getText(),Drain.getSelectedItem().toString(),JumlahDrain.getText(),LetakDrain.getText(),
                WarnaDrain.getText(),JaringanPA.getSelectedItem().toString(),KdPetugasOK4.getText(),KdPetugasAnest.getText(),tbPostOp.getValueAt(tbPostOp.getSelectedRow(),0).toString(),
                tbPostOp.getValueAt(tbPostOp.getSelectedRow(),5).toString()
        });
            
        if (!sukses) {
            JOptionPane.showMessageDialog(null,"Gagal mengubah..!!");
            return;
        }
        
        if(tabModePostOp.getRowCount()!=0){TampilkanData();}
        emptTeks();
    }
    
}
