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
package freehand;

import fungsi.koneksiDB;
import fungsi.sekuel;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author perpustakaan
 */
public class DlgMarkingImageMedisIGD extends javax.swing.JDialog {

    private final sekuel Sequel = new sekuel();
    private int index = 0;
    private Point[] arr = new Point[100000];

    /**
     * Creates new form DlgPemberianObat
     *
     * @param parent
     * @param modal
     */
    public DlgMarkingImageMedisIGD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setResizable(false);
        this.setLocation(0, 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        internalFrame1 = new widget.InternalFrame();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        TNoRawat = new widget.TextBox();
        panelGlass9 = new widget.panelisi();
        panelGlass10 = new widget.panelisi();
        rbFullBadan = new javax.swing.JRadioButton();
        rbTubuhPria = new javax.swing.JRadioButton();
        rbTubuhWanita = new javax.swing.JRadioButton();
        rbKepala = new javax.swing.JRadioButton();
        rbTangan = new javax.swing.JRadioButton();
        rbParuParu = new javax.swing.JRadioButton();
        rbMamame = new javax.swing.JRadioButton();
        rbGenitalWanita = new javax.swing.JRadioButton();
        rbGenitalPria = new javax.swing.JRadioButton();
        rbKaki = new javax.swing.JRadioButton();
        PanelMenggambar = new usu.widget.glass.PanelGlass();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnHapus = new widget.Button();
        BtnHapusGambar = new widget.Button();
        btnPerbaruiGambar = new widget.Button();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Site Marking Medis IGD ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(70, 70, 70))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(865, 60));
        FormInput.setLayout(null);

        jLabel3.setText("No. Rawat");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 10, 65, 23);

        TNoRawat.setEditable(false);
        TNoRawat.setHighlighter(null);
        TNoRawat.setName("TNoRawat"); // NOI18N
        FormInput.add(TNoRawat);
        TNoRawat.setBounds(70, 10, 470, 23);

        internalFrame1.add(FormInput, java.awt.BorderLayout.PAGE_START);
        FormInput.getAccessibleContext().setAccessibleName("");
        FormInput.getAccessibleContext().setAccessibleDescription("");

        panelGlass9.setBorder(null);
        panelGlass9.setAlignmentX(0.0F);
        panelGlass9.setAlignmentY(0.0F);
        panelGlass9.setMinimumSize(new java.awt.Dimension(0, 0));
        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(800, 500));
        panelGlass9.setLayout(new java.awt.BorderLayout());

        panelGlass10.setName("panelGlass10"); // NOI18N
        panelGlass10.setPreferredSize(new java.awt.Dimension(100, 30));
        panelGlass10.setLayout(new javax.swing.BoxLayout(panelGlass10, javax.swing.BoxLayout.X_AXIS));

        rbFullBadan.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbFullBadan);
        rbFullBadan.setSelected(true);
        rbFullBadan.setText("Semua");
        rbFullBadan.setName("rbFullBadan"); // NOI18N
        rbFullBadan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFullBadanActionPerformed(evt);
            }
        });
        panelGlass10.add(rbFullBadan);

        rbTubuhPria.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbTubuhPria);
        rbTubuhPria.setText("Tubuh Pria");
        rbTubuhPria.setName("rbTubuhPria"); // NOI18N
        rbTubuhPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTubuhPriaActionPerformed(evt);
            }
        });
        panelGlass10.add(rbTubuhPria);

        rbTubuhWanita.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbTubuhWanita);
        rbTubuhWanita.setText("Tubuh Wanita");
        rbTubuhWanita.setName("rbTubuhWanita"); // NOI18N
        rbTubuhWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTubuhWanitaActionPerformed(evt);
            }
        });
        panelGlass10.add(rbTubuhWanita);

        rbKepala.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbKepala);
        rbKepala.setText("Kepala");
        rbKepala.setName("rbKepala"); // NOI18N
        rbKepala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKepalaActionPerformed(evt);
            }
        });
        panelGlass10.add(rbKepala);

        rbTangan.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbTangan);
        rbTangan.setText("Tangan");
        rbTangan.setName("rbTangan"); // NOI18N
        rbTangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTanganActionPerformed(evt);
            }
        });
        panelGlass10.add(rbTangan);

        rbParuParu.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbParuParu);
        rbParuParu.setText("Paru - Paru");
        rbParuParu.setName("rbParuParu"); // NOI18N
        rbParuParu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParuParuActionPerformed(evt);
            }
        });
        panelGlass10.add(rbParuParu);

        rbMamame.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbMamame);
        rbMamame.setText("Mammae");
        rbMamame.setName("rbMamame"); // NOI18N
        rbMamame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMamameActionPerformed(evt);
            }
        });
        panelGlass10.add(rbMamame);

        rbGenitalWanita.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbGenitalWanita);
        rbGenitalWanita.setText("Genital Wanita");
        rbGenitalWanita.setName("rbGenitalWanita"); // NOI18N
        rbGenitalWanita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGenitalWanitaActionPerformed(evt);
            }
        });
        panelGlass10.add(rbGenitalWanita);

        rbGenitalPria.setBackground(new java.awt.Color(204, 204, 255));
        buttonGroup1.add(rbGenitalPria);
        rbGenitalPria.setText("Genital Pria");
        rbGenitalPria.setName("rbGenitalPria"); // NOI18N
        rbGenitalPria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbGenitalPriaActionPerformed(evt);
            }
        });
        panelGlass10.add(rbGenitalPria);

        rbKaki.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbKaki);
        rbKaki.setText("Kaki");
        rbKaki.setName("rbKaki"); // NOI18N
        rbKaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbKakiActionPerformed(evt);
            }
        });
        panelGlass10.add(rbKaki);

        panelGlass9.add(panelGlass10, java.awt.BorderLayout.PAGE_END);

        PanelMenggambar.setBackground(new java.awt.Color(29, 29, 29));
        PanelMenggambar.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelMenggambar.setPreferredSize(new java.awt.Dimension(878, 556));
        PanelMenggambar.setRound(false);
        PanelMenggambar.setWarna(new java.awt.Color(110, 110, 110));
        PanelMenggambar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanelMenggambarMouseDragged(evt);
            }
        });
        PanelMenggambar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PanelMenggambarMouseReleased(evt);
            }
        });
        PanelMenggambar.setLayout(null);
        panelGlass9.add(PanelMenggambar, java.awt.BorderLayout.CENTER);

        internalFrame1.add(panelGlass9, java.awt.BorderLayout.CENTER);

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(100, 56));
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

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus Marking");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(150, 30));
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

        BtnHapusGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapusGambar.setMnemonic('H');
        BtnHapusGambar.setText("Hapus Gambar");
        BtnHapusGambar.setToolTipText("Alt+H");
        BtnHapusGambar.setName("BtnHapusGambar"); // NOI18N
        BtnHapusGambar.setPreferredSize(new java.awt.Dimension(150, 30));
        BtnHapusGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusGambarActionPerformed(evt);
            }
        });
        BtnHapusGambar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusGambarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapusGambar);

        btnPerbaruiGambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/42a.png"))); // NOI18N
        btnPerbaruiGambar.setMnemonic('H');
        btnPerbaruiGambar.setText("Gambar Baru");
        btnPerbaruiGambar.setToolTipText("Alt+H");
        btnPerbaruiGambar.setName("btnPerbaruiGambar"); // NOI18N
        btnPerbaruiGambar.setPreferredSize(new java.awt.Dimension(150, 30));
        btnPerbaruiGambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerbaruiGambarActionPerformed(evt);
            }
        });
        btnPerbaruiGambar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnPerbaruiGambarKeyPressed(evt);
            }
        });
        panelGlass8.add(btnPerbaruiGambar);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnKeluar.setMnemonic('T');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+T");
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

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        try {
            if (!PanelMenggambar.isShowing()) {
                return;
            }
            Robot r = new Robot();
            
            Rectangle capture = new Rectangle(
                PanelMenggambar.getLocationOnScreen(),
                PanelMenggambar.getSize()
            );
            
            BufferedImage image = r.createScreenCapture(capture);

            File dir = new File("tmpImageFreehand");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            String fileName = "medisIGD_" + TNoRawat.getText().replaceAll("/", "")+".png";
            File output = new File(dir, fileName);
            
            ImageIO.write(image, "png", output);

            uploadImage(fileName, "medisigd/imagemarking");
            
            int savedImage = Sequel.cariInteger("select count(no_rawat) from medis_igd_marking where no_rawat=?",
                    TNoRawat.getText());
            
            if (savedImage > 0) {
                Sequel.mengedittf(
                    "medis_igd_marking",
                    "no_rawat=?","url_image=?",
                    2,
                    new String[]{
                        "medisigd/imagemarking/" + fileName,
                        TNoRawat.getText()
                    }
                );
            } else {
                Sequel.menyimpantf(
                    "medis_igd_marking",
                    "?,?",
                    "No.Rawat",
                    2,
                    new String[]{
                        TNoRawat.getText(),
                        "medisigd/imagemarking/" + fileName
                    }
                );
            }

            dispose();
        } catch (AWTException | IOException ex) {
            Logger.getLogger(DlgMarkingImageMedisIGD.class.getName())
                  .log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed

}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            dispose();
        }
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void PanelMenggambarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMenggambarMouseDragged
        arr[index] = new Point(evt.getX(), evt.getY());
        index++;
        Graphics2D g = (Graphics2D) PanelMenggambar.getGraphics();
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(4));
        for (int i = 0; i < index - 1; i++) {
            g.drawLine(arr[i].x, arr[i].y, arr[i + 1].x, arr[i + 1].y);
        }
    }//GEN-LAST:event_PanelMenggambarMouseDragged

    private void PanelMenggambarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelMenggambarMouseReleased
        arr = new Point[100000];
        index = 0;
    }//GEN-LAST:event_PanelMenggambarMouseReleased

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        repaint();
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed

    }//GEN-LAST:event_BtnHapusKeyPressed

    private void btnPerbaruiGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerbaruiGambarActionPerformed
        pilihanGambar();
    }//GEN-LAST:event_btnPerbaruiGambarActionPerformed

    private void btnPerbaruiGambarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnPerbaruiGambarKeyPressed
        pilihanGambar();
    }//GEN-LAST:event_btnPerbaruiGambarKeyPressed

    private void BtnHapusGambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusGambarActionPerformed
        try {
            String FileName = Sequel.cariIsi("select url_image from medis_igd_marking where no_rawat=?",TNoRawat.getText());
            
            String url = "https://"
                + koneksiDB.HOSTHYBRIDWEB() + ":"
                + koneksiDB.PORTWEB() + "/"
                + koneksiDB.HYBRIDWEB()
                + "/imagefreehand/hapus.php";
            
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost(url);

            // Parameter POST
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("file", FileName));
            postRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

            HttpResponse response = httpClient.execute(postRequest);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpURLConnection.HTTP_OK) {
                String responHasilnya = EntityUtils.toString(response.getEntity());
                System.out.println("Respons dari server: " + responHasilnya);

                if ("File berhasil dihapus".equals(responHasilnya)) {
                    Sequel.meghapus(
                        "medis_igd_marking",
                        "no_rawat",
                        TNoRawat.getText()
                    );
                }
            } else {
                System.out.println("Gagal menghubungi server, kode respons: " + statusCode);
            }
        } catch (Exception e) {
            System.out.println("Hapus error" + e);
        }
        pilihanGambar();
    }//GEN-LAST:event_BtnHapusGambarActionPerformed

    private void BtnHapusGambarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusGambarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnHapusGambarKeyPressed

    private void rbFullBadanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFullBadanActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/semua43.png")));
    }//GEN-LAST:event_rbFullBadanActionPerformed

    private void rbParuParuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParuParuActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/paruparu.png")));
    }//GEN-LAST:event_rbParuParuActionPerformed

    private void rbGenitalPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGenitalPriaActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/genitalPria.png")));
    }//GEN-LAST:event_rbGenitalPriaActionPerformed

    private void rbMamameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMamameActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/payudara.png")));
    }//GEN-LAST:event_rbMamameActionPerformed

    private void rbGenitalWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbGenitalWanitaActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/genitalWanita.png")));
    }//GEN-LAST:event_rbGenitalWanitaActionPerformed

    private void rbKepalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKepalaActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/kepala.png")));
    }//GEN-LAST:event_rbKepalaActionPerformed

    private void rbKakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbKakiActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/telapakKaki.png")));
    }//GEN-LAST:event_rbKakiActionPerformed

    private void rbTanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTanganActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tangan.png")));
    }//GEN-LAST:event_rbTanganActionPerformed

    private void rbTubuhPriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTubuhPriaActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tubuhPria.png")));
    }//GEN-LAST:event_rbTubuhPriaActionPerformed

    private void rbTubuhWanitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTubuhWanitaActionPerformed
        PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tubuhWanita.png")));
    }//GEN-LAST:event_rbTubuhWanitaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgMarkingImageMedisIGD dialog = new DlgMarkingImageMedisIGD(new javax.swing.JFrame(), true);
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
    private widget.Button BtnHapus;
    private widget.Button BtnHapusGambar;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    private widget.PanelBiasa FormInput;
    private usu.widget.glass.PanelGlass PanelMenggambar;
    private widget.TextBox TNoRawat;
    private widget.Button btnPerbaruiGambar;
    private javax.swing.ButtonGroup buttonGroup1;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel3;
    private widget.panelisi panelGlass10;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private javax.swing.JRadioButton rbFullBadan;
    private javax.swing.JRadioButton rbGenitalPria;
    private javax.swing.JRadioButton rbGenitalWanita;
    private javax.swing.JRadioButton rbKaki;
    private javax.swing.JRadioButton rbKepala;
    private javax.swing.JRadioButton rbMamame;
    private javax.swing.JRadioButton rbParuParu;
    private javax.swing.JRadioButton rbTangan;
    private javax.swing.JRadioButton rbTubuhPria;
    private javax.swing.JRadioButton rbTubuhWanita;
    // End of variables declaration//GEN-END:variables


    public void setNoRw(String norw) {
        TNoRawat.setText(norw);
        rbFullBadan.setSelected(true);
        
        String imageUrl = Sequel.cariIsi("select url_image from medis_igd_marking where no_rawat = ?", norw);
        
        if (imageUrl.isEmpty()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/semua43.png")));
            return;
        }
        
        imageAssesment("https://" + koneksiDB.HOSTHYBRIDWEB() + ":" + koneksiDB.PORTWEB() + "/" + koneksiDB.HYBRIDWEB() + "/imagefreehand/" + imageUrl + "");
        
    }

    public void isCek() {
        BtnSimpan.setEnabled(true);
    }

    void uploadImage(String FileName, String docpath) {
        try {
            File file = new File("tmpImageFreehand/" + FileName);

            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return;
            }
            
            ContentType contentType = ContentType.create("image/png");
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost postRequest = new HttpPost("https://" + koneksiDB.HOSTHYBRIDWEB() + ":" + koneksiDB.PORTWEB() + "/" + koneksiDB.HYBRIDWEB() + "/imagefreehand/upload.php?doc=" + docpath);
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                    .addBinaryBody("file", file, contentType, FileName)
                    .build();
            postRequest.setEntity(reqEntity);
            HttpResponse response = httpClient.execute(postRequest);
            int status = response.getStatusLine().getStatusCode();

            String result = EntityUtils.toString(response.getEntity());

            System.out.println("Upload status: " + status);
            System.out.println("Response: " + result);
            deleteFile();
        } catch (IOException e) {
            System.out.println("Upload error" + e);
        }
    }

    void deleteFile() {
        File file = new File("tmpImageFreehand");
        String[] myFiles;
        if (file.isDirectory()) {
            myFiles = file.list();
            for (String myFile1 : myFiles) {
                File myFile = new File(file, myFile1);
                myFile.delete();
            }
        }
    }

    void imageAssesment(String url) {
        try {
            BufferedImage img = ImageIO.read(new URL(url.trim()));
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(img));
        } catch (IOException ex) {

        }
    }

    void pilihanGambar() {
        if (rbParuParu.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/paruparu.png")));
        } else if (rbFullBadan.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/semua43.png")));
        } else if (rbGenitalPria.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/genitalPria.png")));
        } else if (rbGenitalWanita.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/genitalWanita.png")));
        } else if (rbKaki.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/telapakKaki.png")));
        } else if (rbKepala.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/kepala.png")));
        } else if (rbKepala.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/kelamin.png")));
        } else if (rbTangan.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tangan.png")));
        } else if (rbTubuhPria.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tubuhPria.png")));
        } else if (rbTubuhWanita.isSelected()) {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/tubuhWanita.png")));
        } else {
            PanelMenggambar.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/payudara.png")));
        }
    }
}
