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
import java.awt.event.KeyEvent;
import java.net.URI;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author perpustakaan
 */
public final class ApotekBPJSKirimResep extends javax.swing.JDialog {
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
    private JsonNode response;
    private PreparedStatement ps,ps2,psracikan;
    private ResultSet rs,rs2,rsracikan;
    private int i=0;
    private DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    private String norawat="", requestJson, user="";
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private volatile boolean ceksukses = false;

    /** Creates new form ApotekBPJSKirimResep 
     *@param parent
     *@param modal*/
    public ApotekBPJSKirimResep(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(628,674);

        Object[] row={"No.Resep","Tgl.Resep","No.Rawat","NoRM","Pasien","Dokter Peresep","Status","No.SEP", "No. Sep APT", "Kode dokter", "kode poli"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbResep.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbResep.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbResep.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 11; i++) {
            TableColumn column = tbResep.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(90);
            }else if(i==1){
                column.setPreferredWidth(200);
            }else if(i==2){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==3){
                column.setPreferredWidth(50);
            }else if(i==4){
                column.setPreferredWidth(140);
            }else if(i==5){
                column.setPreferredWidth(140);
            }else if(i==6){
                column.setPreferredWidth(50);
            }else if(i==7){
                column.setPreferredWidth(180);
            }else if(i==8){
                column.setPreferredWidth(180);
            }else if(i==9){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }
        }
        tbResep.setDefaultRenderer(Object.class, new WarnaTable());
        
        
        
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        runBackground(() -> tampil());
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        runBackground(() -> tampil());
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        runBackground(() -> tampil());
                    }
                }
            });
        }  
        ChkInput.setSelected(false);
        isForm();
        
        Valid.SetTgl2(DTPCari1,format.format(new Date())+" 00:00:00");
        Valid.SetTgl2(DTPCari2,format.format(new Date())+" 23:59:59"); 
        
        try {
            user=akses.getkode().replace(" ","").substring(0,9);
        } catch (Exception e) {
            user=akses.getkode();
        }
        
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

        Popup2 = new javax.swing.JPopupMenu();
        ppKirimResepApotekOnline = new javax.swing.JMenuItem();
        ppKirimObatApotekOnline = new javax.swing.JMenuItem();
        ppHapusResepApotekOnline = new javax.swing.JMenuItem();
        ppRiwayatObatApotekOnline = new javax.swing.JMenuItem();
        WindowKirimResep = new javax.swing.JDialog();
        internalFrame6 = new widget.InternalFrame();
        panelGlass6 = new widget.panelisi();
        BtnSimpanResep = new widget.Button();
        BtnCloseIn5 = new widget.Button();
        panelGlass7 = new widget.panelisi();
        label12 = new widget.Label();
        TglSJP = new widget.Tanggal();
        jLabel8 = new widget.Label();
        jLabel9 = new widget.Label();
        jLabel10 = new widget.Label();
        Iterasi = new widget.ComboBox();
        jLabel11 = new widget.Label();
        JenisObat = new widget.ComboBox();
        jLabel14 = new widget.Label();
        NoRM = new widget.TextBox();
        NoRawat = new widget.TextBox();
        jLabel15 = new widget.Label();
        Pasien = new widget.TextBox();
        NoResep = new widget.TextBox();
        NoSEP = new widget.TextBox();
        KdDokter = new widget.TextBox();
        NmDokter = new widget.TextBox();
        jLabel13 = new widget.Label();
        KdPoli = new widget.TextBox();
        NmPoli = new widget.TextBox();
        jLabel18 = new widget.Label();
        TglResep = new widget.TextBox();
        jLabel20 = new widget.Label();
        TglValid = new widget.TextBox();
        jLabel22 = new widget.Label();
        Status = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbResep = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnHapus1 = new widget.Button();
        BtnAll = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        jLabel3 = new widget.Label();
        TNoRm = new widget.TextBox();
        ChkInput = new widget.CekBox();

        Popup2.setName("Popup2"); // NOI18N

        ppKirimResepApotekOnline.setBackground(new java.awt.Color(255, 255, 254));
        ppKirimResepApotekOnline.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppKirimResepApotekOnline.setForeground(new java.awt.Color(50, 50, 50));
        ppKirimResepApotekOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppKirimResepApotekOnline.setText("Kirim Resep Apotek Online");
        ppKirimResepApotekOnline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppKirimResepApotekOnline.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppKirimResepApotekOnline.setName("ppKirimResepApotekOnline"); // NOI18N
        ppKirimResepApotekOnline.setPreferredSize(new java.awt.Dimension(225, 25));
        ppKirimResepApotekOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppKirimResepApotekOnlineActionPerformed(evt);
            }
        });
        Popup2.add(ppKirimResepApotekOnline);

        ppKirimObatApotekOnline.setBackground(new java.awt.Color(255, 255, 254));
        ppKirimObatApotekOnline.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppKirimObatApotekOnline.setForeground(new java.awt.Color(50, 50, 50));
        ppKirimObatApotekOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppKirimObatApotekOnline.setText("Kirim Obat Apotek Online");
        ppKirimObatApotekOnline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppKirimObatApotekOnline.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppKirimObatApotekOnline.setName("ppKirimObatApotekOnline"); // NOI18N
        ppKirimObatApotekOnline.setPreferredSize(new java.awt.Dimension(225, 25));
        ppKirimObatApotekOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppKirimObatApotekOnlineActionPerformed(evt);
            }
        });
        Popup2.add(ppKirimObatApotekOnline);

        ppHapusResepApotekOnline.setBackground(new java.awt.Color(255, 255, 254));
        ppHapusResepApotekOnline.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppHapusResepApotekOnline.setForeground(new java.awt.Color(50, 50, 50));
        ppHapusResepApotekOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppHapusResepApotekOnline.setText("Hapus SEP Apotek Online");
        ppHapusResepApotekOnline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppHapusResepApotekOnline.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppHapusResepApotekOnline.setName("ppHapusResepApotekOnline"); // NOI18N
        ppHapusResepApotekOnline.setPreferredSize(new java.awt.Dimension(225, 25));
        ppHapusResepApotekOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppHapusResepApotekOnlineActionPerformed(evt);
            }
        });
        Popup2.add(ppHapusResepApotekOnline);

        ppRiwayatObatApotekOnline.setBackground(new java.awt.Color(255, 255, 254));
        ppRiwayatObatApotekOnline.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppRiwayatObatApotekOnline.setForeground(new java.awt.Color(50, 50, 50));
        ppRiwayatObatApotekOnline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppRiwayatObatApotekOnline.setText("Riwayat Obat Apotek Online");
        ppRiwayatObatApotekOnline.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppRiwayatObatApotekOnline.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppRiwayatObatApotekOnline.setName("ppRiwayatObatApotekOnline"); // NOI18N
        ppRiwayatObatApotekOnline.setPreferredSize(new java.awt.Dimension(225, 25));
        ppRiwayatObatApotekOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppRiwayatObatApotekOnlineActionPerformed(evt);
            }
        });
        Popup2.add(ppRiwayatObatApotekOnline);

        WindowKirimResep.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        WindowKirimResep.setMinimumSize(new java.awt.Dimension(760, 300));
        WindowKirimResep.setName("WindowKirimResep"); // NOI18N
        WindowKirimResep.setUndecorated(true);
        WindowKirimResep.setResizable(false);
        WindowKirimResep.getContentPane().setLayout(new java.awt.BorderLayout(1, 1));

        internalFrame6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Laporan Operasi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame6.setName("internalFrame6"); // NOI18N
        internalFrame6.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass6.setName("panelGlass6"); // NOI18N
        panelGlass6.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpanResep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpanResep.setMnemonic('U');
        BtnSimpanResep.setText("Simpan");
        BtnSimpanResep.setToolTipText("Alt+U");
        BtnSimpanResep.setName("BtnSimpanResep"); // NOI18N
        BtnSimpanResep.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpanResep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanResepActionPerformed(evt);
            }
        });
        BtnSimpanResep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanResepKeyPressed(evt);
            }
        });
        panelGlass6.add(BtnSimpanResep);

        BtnCloseIn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnCloseIn5.setMnemonic('U');
        BtnCloseIn5.setText("Tutup");
        BtnCloseIn5.setToolTipText("Alt+U");
        BtnCloseIn5.setName("BtnCloseIn5"); // NOI18N
        BtnCloseIn5.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnCloseIn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseIn5ActionPerformed(evt);
            }
        });
        panelGlass6.add(BtnCloseIn5);

        internalFrame6.add(panelGlass6, java.awt.BorderLayout.PAGE_END);

        panelGlass7.setName("panelGlass7"); // NOI18N
        panelGlass7.setPreferredSize(new java.awt.Dimension(900, 55));
        panelGlass7.setLayout(null);

        label12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        label12.setText("Tgl. SJP :");
        label12.setName("label12"); // NOI18N
        label12.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass7.add(label12);
        label12.setBounds(450, 180, 50, 23);

        TglSJP.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        TglSJP.setName("TglSJP"); // NOI18N
        panelGlass7.add(TglSJP);
        TglSJP.setBounds(504, 180, 160, 23);

        jLabel8.setText("No. Rawat :");
        jLabel8.setName("jLabel8"); // NOI18N
        panelGlass7.add(jLabel8);
        jLabel8.setBounds(0, 20, 70, 23);

        jLabel9.setText("No. SEP :");
        jLabel9.setName("jLabel9"); // NOI18N
        panelGlass7.add(jLabel9);
        jLabel9.setBounds(290, 60, 60, 23);

        jLabel10.setText("No. Resep :");
        jLabel10.setName("jLabel10"); // NOI18N
        panelGlass7.add(jLabel10);
        jLabel10.setBounds(0, 60, 70, 23);

        Iterasi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0. Non Iterasi", "1. Iterasi" }));
        Iterasi.setName("Iterasi"); // NOI18N
        Iterasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IterasiActionPerformed(evt);
            }
        });
        Iterasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IterasiKeyPressed(evt);
            }
        });
        panelGlass7.add(Iterasi);
        Iterasi.setBounds(320, 180, 110, 23);

        jLabel11.setText("Dokter :");
        jLabel11.setName("jLabel11"); // NOI18N
        panelGlass7.add(jLabel11);
        jLabel11.setBounds(0, 100, 70, 23);

        JenisObat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1. Obat PRB", "2. Obat Kronis Blm Stabil", "3. Obat Kemoterapi" }));
        JenisObat.setSelectedIndex(1);
        JenisObat.setName("JenisObat"); // NOI18N
        JenisObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisObatActionPerformed(evt);
            }
        });
        JenisObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JenisObatKeyPressed(evt);
            }
        });
        panelGlass7.add(JenisObat);
        JenisObat.setBounds(80, 180, 170, 23);

        jLabel14.setText("Iterasi :");
        jLabel14.setName("jLabel14"); // NOI18N
        panelGlass7.add(jLabel14);
        jLabel14.setBounds(260, 180, 50, 23);

        NoRM.setEditable(false);
        NoRM.setHighlighter(null);
        NoRM.setName("NoRM"); // NOI18N
        NoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoRMKeyPressed(evt);
            }
        });
        panelGlass7.add(NoRM);
        NoRM.setBounds(250, 20, 80, 23);

        NoRawat.setEditable(false);
        NoRawat.setHighlighter(null);
        NoRawat.setName("NoRawat"); // NOI18N
        NoRawat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoRawatKeyPressed(evt);
            }
        });
        panelGlass7.add(NoRawat);
        NoRawat.setBounds(80, 20, 160, 23);

        jLabel15.setText("Jenis Obat :");
        jLabel15.setName("jLabel15"); // NOI18N
        panelGlass7.add(jLabel15);
        jLabel15.setBounds(0, 180, 70, 23);

        Pasien.setEditable(false);
        Pasien.setHighlighter(null);
        Pasien.setName("Pasien"); // NOI18N
        Pasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasienKeyPressed(evt);
            }
        });
        panelGlass7.add(Pasien);
        Pasien.setBounds(340, 20, 330, 23);

        NoResep.setEditable(false);
        NoResep.setHighlighter(null);
        NoResep.setName("NoResep"); // NOI18N
        NoResep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoResepKeyPressed(evt);
            }
        });
        panelGlass7.add(NoResep);
        NoResep.setBounds(80, 60, 190, 23);

        NoSEP.setEditable(false);
        NoSEP.setHighlighter(null);
        NoSEP.setName("NoSEP"); // NOI18N
        NoSEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoSEPKeyPressed(evt);
            }
        });
        panelGlass7.add(NoSEP);
        NoSEP.setBounds(360, 60, 310, 23);

        KdDokter.setEditable(false);
        KdDokter.setHighlighter(null);
        KdDokter.setName("KdDokter"); // NOI18N
        KdDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdDokterKeyPressed(evt);
            }
        });
        panelGlass7.add(KdDokter);
        KdDokter.setBounds(80, 100, 80, 23);

        NmDokter.setEditable(false);
        NmDokter.setHighlighter(null);
        NmDokter.setName("NmDokter"); // NOI18N
        NmDokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmDokterKeyPressed(evt);
            }
        });
        panelGlass7.add(NmDokter);
        NmDokter.setBounds(165, 100, 180, 23);

        jLabel13.setText("Poli :");
        jLabel13.setName("jLabel13"); // NOI18N
        panelGlass7.add(jLabel13);
        jLabel13.setBounds(335, 100, 40, 23);

        KdPoli.setEditable(false);
        KdPoli.setHighlighter(null);
        KdPoli.setName("KdPoli"); // NOI18N
        KdPoli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KdPoliKeyPressed(evt);
            }
        });
        panelGlass7.add(KdPoli);
        KdPoli.setBounds(385, 100, 90, 23);

        NmPoli.setEditable(false);
        NmPoli.setHighlighter(null);
        NmPoli.setName("NmPoli"); // NOI18N
        NmPoli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NmPoliKeyPressed(evt);
            }
        });
        panelGlass7.add(NmPoli);
        NmPoli.setBounds(480, 100, 190, 23);

        jLabel18.setText("Tgl. Resep :");
        jLabel18.setName("jLabel18"); // NOI18N
        panelGlass7.add(jLabel18);
        jLabel18.setBounds(0, 140, 70, 23);

        TglResep.setEditable(false);
        TglResep.setHighlighter(null);
        TglResep.setName("TglResep"); // NOI18N
        TglResep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TglResepKeyPressed(evt);
            }
        });
        panelGlass7.add(TglResep);
        TglResep.setBounds(80, 140, 170, 23);

        jLabel20.setText("Tgl. Validasi :");
        jLabel20.setName("jLabel20"); // NOI18N
        panelGlass7.add(jLabel20);
        jLabel20.setBounds(260, 140, 70, 23);

        TglValid.setEditable(false);
        TglValid.setHighlighter(null);
        TglValid.setName("TglValid"); // NOI18N
        TglValid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TglValidKeyPressed(evt);
            }
        });
        panelGlass7.add(TglValid);
        TglValid.setBounds(340, 140, 170, 23);

        jLabel22.setText("Status :");
        jLabel22.setName("jLabel22"); // NOI18N
        panelGlass7.add(jLabel22);
        jLabel22.setBounds(520, 140, 40, 23);

        Status.setEditable(false);
        Status.setHighlighter(null);
        Status.setName("Status"); // NOI18N
        Status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                StatusKeyPressed(evt);
            }
        });
        panelGlass7.add(Status);
        Status.setBounds(570, 140, 100, 23);

        internalFrame6.add(panelGlass7, java.awt.BorderLayout.LINE_START);

        WindowKirimResep.getContentPane().add(internalFrame6, java.awt.BorderLayout.CENTER);

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
        tbResep.setComponentPopupMenu(Popup2);
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

        BtnHapus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/report24.png"))); // NOI18N
        BtnHapus1.setMnemonic('H');
        BtnHapus1.setText("Daftar Resep");
        BtnHapus1.setToolTipText("Alt+H");
        BtnHapus1.setName("BtnHapus1"); // NOI18N
        BtnHapus1.setPreferredSize(new java.awt.Dimension(120, 30));
        BtnHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapus1ActionPerformed(evt);
            }
        });
        BtnHapus1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapus1KeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus1);

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

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(55, 30));
        panelGlass8.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(52, 30));
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

        jLabel19.setText("Tanggal :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(53, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "19-02-2026 18:07:48" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(152, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "19-02-2026 18:07:49" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy HH:mm:ss");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(152, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 23));
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
        BtnCari.setMnemonic('4');
        BtnCari.setToolTipText("Alt+4");
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

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(440, 60));
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
        TNoRw.setBounds(98, 12, 140, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        FormInput.add(TPasien);
        TPasien.setBounds(323, 12, 400, 23);

        jLabel3.setText("No.Rawat :");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 12, 95, 23);

        TNoRm.setEditable(false);
        TNoRm.setHighlighter(null);
        TNoRm.setName("TNoRm"); // NOI18N
        TNoRm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRmKeyPressed(evt);
            }
        });
        FormInput.add(TNoRm);
        TNoRm.setBounds(240, 12, 80, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

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

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        openWindowKirimResep();
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }else{
            Valid.pindah(evt,TCari,BtnBatal);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        ChkInput.setSelected(true);
        isForm(); 
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        ppHapusResepApotekOnlineActionPerformed(null);
}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal,BtnAll);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

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
        runBackground(() -> tampil());
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
        runBackground(() -> tampil());        
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            runBackground(() -> tampil());
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnCari, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbResepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbResepMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbResepMouseClicked

    private void tbResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResepKeyPressed
        if(tabMode.getRowCount()!=0){
            if(evt.getKeyCode()==KeyEvent.VK_SHIFT){
                TCari.setText("");
                TCari.requestFocus();
            }
        }
}//GEN-LAST:event_tbResepKeyPressed

private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
  isForm();                
}//GEN-LAST:event_ChkInputActionPerformed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_DOWN){
            TCari.requestFocus();
        }else{
            Valid.pindah(evt,BtnKeluar,BtnSimpan);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void ppKirimResepApotekOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppKirimResepApotekOnlineActionPerformed
        openWindowKirimResep();
    }//GEN-LAST:event_ppKirimResepApotekOnlineActionPerformed

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

    private void ppKirimObatApotekOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppKirimObatApotekOnlineActionPerformed
        if(tabMode.getRowCount()==0){
             JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
             TNoRw.requestFocus();
             return;
        }
        
        if (tbResep.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,"Silahkan pilih data");
            return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Pilih baris nomor resep");
             return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Belum Terbit SEP Apotek");
             return;
        }
        
        ApotekBPJSKirimObat form = new ApotekBPJSKirimObat(null, false);
        form.setNoRm(
                tbResep.getValueAt(tbResep.getSelectedRow(), 2).toString(),
                tbResep.getValueAt(tbResep.getSelectedRow(), 3).toString(),
                tbResep.getValueAt(tbResep.getSelectedRow(), 4).toString(),
                tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString(),
                tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString()
        );
        form.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        form.setLocationRelativeTo(internalFrame1);
        form.setVisible(true);
    }//GEN-LAST:event_ppKirimObatApotekOnlineActionPerformed

    private void tbResepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbResepKeyReleased
        if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbResepKeyReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        norawat="";
    }//GEN-LAST:event_formWindowClosed

    private void BtnSimpanResepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanResepActionPerformed

        DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        LocalDateTime tglResep = LocalDateTime.parse(TglResep.getText().trim(), formatter);
        LocalDateTime tglSJP = LocalDateTime.parse(Valid.SetTglJam(TglSJP.getSelectedItem().toString()), formatter);
        
        long selisih = Math.abs(Duration.between(tglResep, tglSJP).toDays());
        
        if (selisih > 15) {
            JOptionPane.showMessageDialog(null, "Tanggal resep sudah melebihi 15 hari");
            return;
        }
        
        String prb = Sequel.cariIsi(
                "select no_srb from bridging_srb_bpjs where no_sep = ?",
                NoSEP.getText()
        );

        boolean isPRB = prb != null && !prb.isEmpty();

        if (JenisObat.getSelectedIndex() == 0) { // obat non PRB
            if (!isPRB) {
                JOptionPane.showMessageDialog(null, "Pasien bukan peserta program PRB");
                return;
            }
        } else { // obat PRB
            if (isPRB) {
                JOptionPane.showMessageDialog(null,
                        "Pasien merupakan program PRB, silahkan pilih Jenis Obat PRB");
                return;
            }
        }
        
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    headers.add("x-cons-id",koneksiDB.CONSIDAPIAPOTEKBPJS());
	    utc=String.valueOf(api.GetUTCdatetimeAsString());
	    headers.add("x-timestamp",utc);
	    headers.add("x-signature",api.getHmac(utc));
	    headers.add("user_key",koneksiDB.USERKEYAPIAPOTEKBPJS());
            String noResep = genResep(NoResep.getText());
            URL = link+"/sjpresep/v3/insert";
            requestJson = "{" +
                                "\"TGLSJP\":\""+Valid.SetTglJam(TglSJP.getSelectedItem().toString())+"\"," +
                                "\"REFASALSJP\":\""+NoSEP.getText()+"\"," +
                                "\"POLIRSP\":\""+KdPoli.getText()+"\"," +
                                "\"KDJNSOBAT\":\""+JenisObat.getSelectedItem().toString().substring(0,1)+"\"," +
                                "\"NORESEP\":\""+noResep+"\"," +
                                "\"IDUSERSJP\":\"apol-"+user+"\"," +
                                "\"TGLRSP\":\""+TglResep.getText()+"\"," +
                                "\"TGLPELRSP\":\""+TglValid.getText()+"\"," +
                                "\"KdDokter\":\""+KdDokter.getText()+"\"," +
                                "\"iterasi\":\""+Iterasi.getSelectedItem().toString().substring(0,1)+"\"" +
                          "}";
            System.out.println("Request URL : "+URL);
            System.out.println("JSON : "+requestJson);
            requestEntity = new HttpEntity(requestJson,headers);
            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            nameNode = root.path("metaData");
            System.out.println("Result : "+root.toString());
            JOptionPane.showMessageDialog(null,nameNode.path("message").asText());
            if(nameNode.path("code").asText().equals("200")){
                response = mapper.readTree(api.Decrypt(root.path("response").asText(),utc));
                if (Sequel.menyimpantf2("bridging_resep_apotek_bpjs", "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?", "SEP APT", 17, new String[] {
                    NoSEP.getText(),response.path("noApotik").asText(),response.path("tglEntry").asText(),KdPoli.getText(),NmPoli.getText(),
                    JenisObat.getSelectedItem().toString(),TglResep.getText(),TglValid.getText(),KdDokter.getText(),NmDokter.getText(),
                    Iterasi.getSelectedItem().toString(),response.path("noKartu").asText(),response.path("nama").asText(),
                    response.path("byTagRsp").asText(),response.path("byVerRsp").asText(),NoResep.getText(),noResep
                })) {
                    clearForm();
                    runBackground(() -> tampil());
                    WindowKirimResep.dispose();
                }
            }
        } catch (Exception ex) { 
            System.out.println("Notifikasi : "+ex);
            JOptionPane.showMessageDialog(null,"Notifikasi : "+ex);
            if(ex.toString().contains("UnknownHostException")){
                JOptionPane.showMessageDialog(rootPane,"Koneksi ke server BPJS terputus...!");
            }
        }
    }//GEN-LAST:event_BtnSimpanResepActionPerformed

    private void BtnSimpanResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanResepKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }
    }//GEN-LAST:event_BtnSimpanResepKeyPressed

    private void BtnCloseIn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseIn5ActionPerformed
        WindowKirimResep.dispose();
    }//GEN-LAST:event_BtnCloseIn5ActionPerformed

    private void IterasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IterasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IterasiActionPerformed

    private void IterasiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IterasiKeyPressed
        Valid.pindah(evt,JenisObat,TglSJP);
    }//GEN-LAST:event_IterasiKeyPressed

    private void JenisObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisObatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisObatActionPerformed

    private void JenisObatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JenisObatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_JenisObatKeyPressed

    private void NoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoRMKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoRMKeyPressed

    private void NoRawatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoRawatKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoRawatKeyPressed

    private void PasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasienKeyPressed
        Valid.pindah(evt,TglSJP,JenisObat);
    }//GEN-LAST:event_PasienKeyPressed

    private void NoResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoResepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoResepKeyPressed

    private void NoSEPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoSEPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSEPKeyPressed

    private void KdDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdDokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KdDokterKeyPressed

    private void NmDokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmDokterKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NmDokterKeyPressed

    private void KdPoliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KdPoliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KdPoliKeyPressed

    private void NmPoliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NmPoliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NmPoliKeyPressed

    private void TglResepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TglResepKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TglResepKeyPressed

    private void TglValidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TglValidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TglValidKeyPressed

    private void StatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StatusKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_StatusKeyPressed

    private void ppHapusResepApotekOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppHapusResepApotekOnlineActionPerformed
        if(tabMode.getRowCount()==0){
             JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
             TNoRw.requestFocus();
             return;
        }
        
        if (tbResep.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,"Silahkan pilih data");
            return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Pilih baris nomor resep");
             return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Belum Terbit SEP Apotek");
             return;
        }
        
        int reply = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan menghapus SEP Apotek..??","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                bodyWithDeleteRequest();
            } catch (Exception ex) {
                System.out.println("Notifikasi Bridging : " + ex);
            }
        }
    }//GEN-LAST:event_ppHapusResepApotekOnlineActionPerformed

    private void ppRiwayatObatApotekOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppRiwayatObatApotekOnlineActionPerformed
        if(tabMode.getRowCount()==0){
             JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
             TNoRw.requestFocus();
             return;
        }
        
        if (tbResep.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,"Silahkan pilih data");
            return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Pilih baris nomor resep");
             return;
        }
        
        String noKartu = Sequel.cariIsi("select no_peserta from pasien where no_rkm_medis = ?", tbResep.getValueAt(tbResep.getSelectedRow(), 3).toString());
        ApotekBPJSRiwayatPelayananObat form = new ApotekBPJSRiwayatPelayananObat(null, false);
        form.setNoRm(noKartu);
        form.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        form.setLocationRelativeTo(internalFrame1);
        form.setVisible(true);
    }//GEN-LAST:event_ppRiwayatObatApotekOnlineActionPerformed

    private void BtnHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapus1ActionPerformed
        ApotekBPJSDaftarResep form = new ApotekBPJSDaftarResep(null, false);
        form.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        form.setLocationRelativeTo(internalFrame1);
        form.setVisible(true);
    }//GEN-LAST:event_BtnHapus1ActionPerformed

    private void BtnHapus1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapus1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnHapus1KeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            ApotekBPJSKirimResep dialog = new ApotekBPJSKirimResep(new javax.swing.JFrame(), true);
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
    private widget.Button BtnCloseIn5;
    private widget.Button BtnHapus;
    private widget.Button BtnHapus1;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.Button BtnSimpanResep;
    private widget.CekBox ChkInput;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.PanelBiasa FormInput;
    private widget.ComboBox Iterasi;
    private widget.ComboBox JenisObat;
    private widget.TextBox KdDokter;
    private widget.TextBox KdPoli;
    private widget.Label LCount;
    private widget.TextBox NmDokter;
    private widget.TextBox NmPoli;
    private widget.TextBox NoRM;
    private widget.TextBox NoRawat;
    private widget.TextBox NoResep;
    private widget.TextBox NoSEP;
    private javax.swing.JPanel PanelInput;
    private widget.TextBox Pasien;
    private javax.swing.JPopupMenu Popup2;
    private widget.ScrollPane Scroll;
    private widget.TextBox Status;
    private widget.TextBox TCari;
    private widget.TextBox TNoRm;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.TextBox TglResep;
    private widget.Tanggal TglSJP;
    private widget.TextBox TglValid;
    private javax.swing.JDialog WindowKirimResep;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame6;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel13;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel3;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel8;
    private widget.Label jLabel9;
    private javax.swing.JPanel jPanel3;
    private widget.Label label12;
    private widget.panelisi panelGlass6;
    private widget.panelisi panelGlass7;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private javax.swing.JMenuItem ppHapusResepApotekOnline;
    private javax.swing.JMenuItem ppKirimObatApotekOnline;
    private javax.swing.JMenuItem ppKirimResepApotekOnline;
    private javax.swing.JMenuItem ppRiwayatObatApotekOnline;
    private widget.Table tbResep;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try{  
            ps=koneksi.prepareStatement(
                "select resep_obat.no_resep,resep_obat.tgl_perawatan,resep_obat.jam,resep_obat.status,bridging_sep.no_sep,poliklinik.kd_poli,"+
                "resep_obat.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,resep_obat.kd_dokter,dokter.nm_dokter,COALESCE(bridging_resep_apotek_bpjs.no_sep_apotek, '') as no_sep_apotek "+
                "from resep_obat inner join reg_periksa on resep_obat.no_rawat=reg_periksa.no_rawat "+
                "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                "inner join poliklinik on reg_periksa.kd_poli = poliklinik.kd_poli "+
                "left join bridging_resep_apotek_bpjs on bridging_resep_apotek_bpjs.no_resep = resep_obat.no_resep "+
                "inner join dokter on resep_obat.kd_dokter=dokter.kd_dokter "
                    + "inner join ( "
                    + "select b1.* from bridging_sep b1 "
                    + "where b1.jnspelayanan='1' "
                    + "or not exists ( "
                    + "select 1 from bridging_sep b2 "
                    + "where b2.no_rawat=b1.no_rawat "
                    + "and b2.jnspelayanan='1' "
                    + ") "
                    + ") bridging_sep on resep_obat.no_rawat=bridging_sep.no_rawat "
                    + "where concat(resep_obat.tgl_perawatan,' ',resep_obat.jam) between ? and ? "+
                (norawat.equals("")?"":"and resep_obat.no_rawat='"+norawat+"' ")+
                (TCari.getText().trim().equals("")?"":"and (resep_obat.no_resep like ? or resep_obat.no_rawat like ? or "+
                "pasien.no_rkm_medis like ? or pasien.nm_pasien like ? or dokter.nm_dokter like ?) ")+
                "order by resep_obat.tgl_perawatan,resep_obat.jam");
            try{
                ps.setString(1,Valid.SetTglJam(DTPCari1.getSelectedItem()+""));
                ps.setString(2,Valid.SetTglJam(DTPCari2.getSelectedItem()+""));
                if(!TCari.getText().trim().equals("")){
                    ps.setString(3,"%"+TCari.getText().trim()+"%");
                    ps.setString(4,"%"+TCari.getText().trim()+"%");
                    ps.setString(5,"%"+TCari.getText().trim()+"%");
                    ps.setString(6,"%"+TCari.getText().trim()+"%");
                    ps.setString(7,"%"+TCari.getText().trim()+"%");
                }
                    
                rs=ps.executeQuery();
                int count = 0;
                while(rs.next()){
                    int rowStart = tabMode.getRowCount();
                    count++;
                    tabMode.addRow(new Object[]{
                        rs.getString("no_resep"),rs.getString("tgl_perawatan")+" "+rs.getString("jam"),
                        rs.getString("no_rawat"),rs.getString("no_rkm_medis"),rs.getString("nm_pasien"),
                        rs.getString("nm_dokter"),rs.getString("status"),rs.getString("no_sep"),rs.getString("no_sep_apotek"),
                        rs.getString("kd_dokter"),rs.getString("kd_poli")
                    });
                    tabMode.addRow(new Object[]{"","Nama Obat","","Jumlah","Aturan Pakai","","","","","",""});                
                    ps2=koneksi.prepareStatement(
                        "select databarang.kode_brng,databarang.nama_brng,detail_pemberian_obat.jml,detail_pemberian_obat.biaya_obat,detail_pemberian_obat.embalase,detail_pemberian_obat.tuslah,detail_pemberian_obat.total "+
                        "from detail_pemberian_obat inner join databarang on detail_pemberian_obat.kode_brng=databarang.kode_brng join maping_obat_apotek_bpjs on maping_obat_apotek_bpjs.kode_brng = databarang.kode_brng where detail_pemberian_obat.tgl_perawatan=? and detail_pemberian_obat.jam=? and detail_pemberian_obat.no_rawat=? "+
                        "and databarang.kode_brng not in (select detail_obat_racikan.kode_brng from detail_obat_racikan where detail_obat_racikan.tgl_perawatan=? and detail_obat_racikan.jam=? and detail_obat_racikan.no_rawat=?) "+
                        "order by databarang.kode_brng");
                    try {
                        ps2.setString(1,rs.getString("tgl_perawatan"));
                        ps2.setString(2,rs.getString("jam"));
                        ps2.setString(3,rs.getString("no_rawat"));
                        ps2.setString(4,rs.getString("tgl_perawatan"));
                        ps2.setString(5,rs.getString("jam"));
                        ps2.setString(6,rs.getString("no_rawat"));
                        rs2=ps2.executeQuery();
                        while(rs2.next()){
                            tabMode.addRow(new Object[]{
                                "",rs2.getString("nama_brng"),"",rs2.getString("jml"),
                                Sequel.cariIsi("select aturan_pakai.aturan from aturan_pakai where aturan_pakai.tgl_perawatan='"+rs.getString("tgl_perawatan")+"' and "+
                                "aturan_pakai.jam='"+rs.getString("jam")+"' and aturan_pakai.no_rawat='"+rs.getString("no_rawat")+"' and aturan_pakai.kode_brng='"+rs2.getString("kode_brng")+"'"),
                                "","","","","",""
                            });
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi : "+e);
                    } finally{
                        if(rs2!=null){
                            rs2.close();
                        }
                        if(ps2!=null){
                            ps2.close();
                        }
                    }
                    
                    psracikan=koneksi.prepareStatement(
                            "select obat_racikan.no_racik,obat_racikan.nama_racik,obat_racikan.kd_racik,metode_racik.nm_racik as metode,obat_racikan.jml_dr,obat_racikan.aturan_pakai,obat_racikan.keterangan "+
                            "from obat_racikan inner join metode_racik on obat_racikan.kd_racik=metode_racik.kd_racik where obat_racikan.tgl_perawatan=? and obat_racikan.jam=? and obat_racikan.no_rawat=? ");
                    try {
                        psracikan.setString(1,rs.getString("tgl_perawatan"));
                        psracikan.setString(2,rs.getString("jam"));
                        psracikan.setString(3,rs.getString("no_rawat"));
                        rsracikan=psracikan.executeQuery();
                        while(rsracikan.next()){
                            tabMode.addRow(new Object[]{
                                "",rsracikan.getString("no_racik")+". "+rsracikan.getString("nama_racik"),"",
                                rsracikan.getString("jml_dr")+" "+rsracikan.getString("metode"),
                                rsracikan.getString("aturan_pakai"),"","","","","",""
                            });
                            
                            ps2=koneksi.prepareStatement(
                                "select databarang.kode_brng,databarang.nama_brng,detail_pemberian_obat.jml,detail_pemberian_obat.biaya_obat,detail_pemberian_obat.embalase,detail_pemberian_obat.tuslah,detail_pemberian_obat.total "+
                                "from detail_pemberian_obat inner join databarang on detail_pemberian_obat.kode_brng=databarang.kode_brng inner join detail_obat_racikan on detail_pemberian_obat.kode_brng=detail_obat_racikan.kode_brng and "+
                                "detail_pemberian_obat.tgl_perawatan=detail_obat_racikan.tgl_perawatan and detail_pemberian_obat.jam=detail_obat_racikan.jam and detail_pemberian_obat.no_rawat=detail_obat_racikan.no_rawat "+
                                "join maping_obat_apotek_bpjs on maping_obat_apotek_bpjs.kode_brng = databarang.kode_brng " +
                                "where detail_pemberian_obat.tgl_perawatan=? and detail_pemberian_obat.jam=? and detail_pemberian_obat.no_rawat=? and detail_obat_racikan.no_racik=? order by databarang.kode_brng");
                            try {
                                ps2.setString(1,rs.getString("tgl_perawatan"));
                                ps2.setString(2,rs.getString("jam"));
                                ps2.setString(3,rs.getString("no_rawat"));
                                ps2.setString(4,rsracikan.getString("no_racik"));
                                rs2=ps2.executeQuery();
                                while(rs2.next()){
                                    tabMode.addRow(new Object[]{
                                        "","   "+rs2.getString("nama_brng"),"",rs2.getString("jml"),
                                        "","","","","","",""
                                    });
                                }                                
                            } catch (Exception e) {
                                System.out.println("Notifikasi Detail Racikan : "+e);
                            } finally{
                                if(rs2!=null){
                                    rs2.close();
                                }
                                if(ps2!=null){
                                    ps2.close();
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Notif Racikan : "+e);
                    } finally{
                        if(rsracikan!=null){
                            rsracikan.close();
                        }
                        if(psracikan!=null){
                            psracikan.close();
                        }
                    }
                    if(tabMode.getRowCount() == rowStart + 2){
                        tabMode.removeRow(rowStart + 1); // hapus header obat
                        tabMode.removeRow(rowStart);     // hapus header resep
                        count--;
                    }
                }                
                rs.last();
                LCount.setText(""+count);
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
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }        
    }

    private void getData() {
        if(tbResep.getSelectedRow()!= -1){
            if(!tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString().equals("")){
                TNoRw.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 2).toString());
                TNoRm.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 3).toString());
                TPasien.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 4).toString());
            }
        }
    }
    
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,80));
            FormInput.setVisible(true);      
            ChkInput.setVisible(true);
        }else if(ChkInput.isSelected()==false){           
            ChkInput.setVisible(false);            
            PanelInput.setPreferredSize(new Dimension(WIDTH,20));
            FormInput.setVisible(false);      
            ChkInput.setVisible(true);
        }
    }
    
    public void isCek(){
        BtnSimpan.setEnabled(akses.getresep_obat());
        BtnHapus.setEnabled(akses.getresep_obat());
        
        runBackground(() -> tampil());
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
    
    private void clearForm() {
        NoRawat.setText("");
        NoRM.setText("");
        Pasien.setText("");
        NoResep.setText("");
        NoSEP.setText("");
        KdDokter.setText("");
        NmDokter.setText("");
        KdPoli.setText("");
        NmPoli.setText("");
        TglResep.setText("");
        TglValid.setText("");
        Status.setText("");
        JenisObat.setSelectedIndex(1);
        Iterasi.setSelectedIndex(0);
        TglSJP.setDate(new Date()); 
    }
    
    private void fillForm() {
        NoRawat.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 2).toString());
        NoRM.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 3).toString());
        Pasien.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 4).toString());
        NoResep.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString());
        NoSEP.setText(tbResep.getValueAt(tbResep.getSelectedRow(), 7).toString());
        
        try {
            ps = koneksi.prepareStatement("select kd_dokter_bpjs, nm_dokter_bpjs from maping_dokter_dpjpvclaim where kd_dokter = ?");
            ps.setString(1, tbResep.getValueAt(tbResep.getSelectedRow(), 9).toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                KdDokter.setText(rs.getString("kd_dokter_bpjs"));
                NmDokter.setText(rs.getString("nm_dokter_bpjs"));
            }
        } catch (Exception e) {
            System.out.println("fill form dokter: "+e);
        }
        
        try {
            ps = koneksi.prepareStatement("select kd_poli_bpjs, nm_poli_bpjs from maping_poli_bpjs where kd_poli_rs = ?");
            ps.setString(1, tbResep.getValueAt(tbResep.getSelectedRow(), 10).toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                KdPoli.setText(rs.getString("kd_poli_bpjs"));
                NmPoli.setText(rs.getString("nm_poli_bpjs"));
            }
        } catch (Exception e) {
            System.out.println("fill form poli: "+e);
        }
        
        try {
            ps = koneksi.prepareStatement("select tgl_perawatan, jam, tgl_peresepan, jam_peresepan, status from resep_obat where no_resep = ?");
            ps.setString(1, tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                TglResep.setText(rs.getString("tgl_peresepan")+" 00:00:00");
                TglValid.setText(rs.getString("tgl_perawatan")+" 00:00:00");
                Status.setText(rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println("fill form poli: "+e);
        }
        
        String prb = Sequel.cariIsi("select no_srb from bridging_srb_bpjs where no_sep = ?", tbResep.getValueAt(tbResep.getSelectedRow(), 7).toString());
        
        if (!prb.isEmpty()) {
            JenisObat.setSelectedIndex(0);
        }
    }
    
    private String genResep(String input) {
        String noZero = input.replace("0", "");

        // ambil 5 digit terakhir
        if (noZero.length() > 5) {
            return noZero.substring(noZero.length() - 5);
        }

        // jika kurang dari 5 digit, tambahkan 0 di depan
        return String.format("%5s", noZero).replace(' ', '0');
    }
    
    private void openWindowKirimResep() {
        if(tabMode.getRowCount()==0){
             JOptionPane.showMessageDialog(null,"Maaf, data sudah habis...!!!!");
             TNoRw.requestFocus();
             return;
        }
        
        if (tbResep.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null,"Silahkan pilih data");
            return;
        }
        
        if(tbResep.getValueAt(tbResep.getSelectedRow(), 0).toString().equals("")){
             JOptionPane.showMessageDialog(null,"Pilih baris nomor resep");
             return;
        }
        
        if(!tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString().equals("")){
             JOptionPane.showMessageDialog(null,"SEP Apotek Sudah Terbit");
             return;
        }
        
        
        clearForm();
        fillForm();
        WindowKirimResep.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        WindowKirimResep.setLocationRelativeTo(internalFrame1);
        WindowKirimResep.setVisible(true);
    }
    
    
    public static class HttpEntityEnclosingDeleteRequest extends HttpEntityEnclosingRequestBase {

        public HttpEntityEnclosingDeleteRequest(final URI uri) {
            super();
            setURI(uri);
        }

        @Override
        public String getMethod() {
            return "DELETE";
        }
    }
    
    @Test
    public void bodyWithDeleteRequest() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        SSLContext sslContext = SSLContext.getInstance("SSL");
        javax.net.ssl.TrustManager[] trustManagers = {
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }
            }
        };
        sslContext.init(null, trustManagers, new SecureRandom());
        SSLSocketFactory sslFactory = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        Scheme scheme = new Scheme("https", 443, sslFactory);

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory() {
            @Override
            protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
                if (HttpMethod.DELETE == httpMethod) {
                    return new ApotekBPJSKirimResep.HttpEntityEnclosingDeleteRequest(uri);
                }
                return super.createHttpUriRequest(httpMethod, uri);
            }
        };
        factory.getHttpClient().getConnectionManager().getSchemeRegistry().register(scheme);
        restTemplate.setRequestFactory(factory);
        
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("x-cons-id", koneksiDB.CONSIDAPIAPOTEKBPJS());
            utc = String.valueOf(api.GetUTCdatetimeAsString());
            headers.add("x-timestamp", utc);
            headers.add("x-signature", api.getHmac(utc));
            headers.add("user_key", koneksiDB.USERKEYAPIAPOTEKBPJS());
            URL = link + "/hapusresep";
            requestJson = "{"
                    + "\"nosjp\":\"" + tbResep.getValueAt(tbResep.getSelectedRow(), 8) + "\","
                    + "\"refasalsjp\":\"" + tbResep.getValueAt(tbResep.getSelectedRow(), 7) + "\","
                    + "\"noresep\":\"" + Sequel.cariIsi("select no_resep_apotek from bridging_resep_apotek_bpjs where no_sep_apotek = ?", tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString()) + "\""
                    + "}";
            System.out.println("Request URL : " + URL);
            System.out.println("JSON : " + requestJson);
            requestEntity = new HttpEntity(requestJson, headers);
            root = mapper.readTree(restTemplate.exchange(URL, HttpMethod.DELETE, requestEntity, String.class).getBody());
            nameNode = root.path("metaData");
            System.out.println("Result : " + root.toString());
            JOptionPane.showMessageDialog(null, "Respon Hapus Resep : "+nameNode.path("message").asText());
            if (nameNode.path("code").asText().equals("200")) {
                Sequel.meghapus3("bridging_resep_apotek_bpjs_nonracikan", "no_sep_apotek", tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString());
                Sequel.meghapus3("bridging_resep_apotek_bpjs_racikan", "no_sep_apotek", tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString());
                Sequel.meghapus3("bridging_resep_apotek_bpjs", "no_sep_apotek", tbResep.getValueAt(tbResep.getSelectedRow(), 8).toString());
                runBackground(() -> tampil());
            }
        } catch (Exception ex) {
            System.out.println("Notifikasi : " + ex);
            JOptionPane.showMessageDialog(null, "Notifikasi : " + ex);
            if (ex.toString().contains("UnknownHostException")) {
                JOptionPane.showMessageDialog(rootPane, "Koneksi ke server BPJS terputus...!");
            }
        }
    }
}
