/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Owner
 */
public class WarnaTableSoapInap extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (row % 2 == 1) {
            component.setBackground(new Color(255, 244, 244));
        } else {
            component.setBackground(new Color(255, 255, 255));
        }

        component.setForeground(Color.BLACK);

        boolean tbak = Boolean.TRUE.equals(table.getValueAt(row, 29));
        boolean kritis = Boolean.TRUE.equals(table.getValueAt(row, 30));
        boolean verified = "SUDAH".equalsIgnoreCase(
                String.valueOf(table.getValueAt(row, 25)));

        // ==========================
        // Hitung Expired (>24 Jam)
        // ==========================
        boolean expired = false;

        if (tbak && !verified) {
            try {
                java.time.LocalDateTime waktuTBak = java.time.LocalDateTime.parse(
                        table.getValueAt(row, 4).toString() + " "
                        + table.getValueAt(row, 5).toString(),
                        java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                expired = java.time.Duration.between(
                        waktuTBak,
                        java.time.LocalDateTime.now()).toHours() >= 24;

            } catch (Exception e) {
                expired = false;
            }
        }

        // ==========================
        // PRIORITAS WARNA
        // ==========================
        // 1. TBaK Expired
        if (expired) {
            component.setBackground(new Color(183, 28, 28)); // Dark Red
            component.setForeground(Color.WHITE);
        } // 2. Kritis + TBaK Pending
        else if (kritis && tbak && !verified) {
            component.setBackground(new Color(255, 152, 0)); // Orange
            component.setForeground(Color.BLACK);
        } // 3. Kritis + TBaK Verified
        else if (kritis && tbak && verified) {
            component.setBackground(new Color(156, 39, 176)); // Purple
            component.setForeground(Color.WHITE);
        } // 4. Hanya Nilai Kritis Verified
        else if (kritis && !tbak && verified) {
            component.setBackground(new Color(63, 81, 181)); // Indigo
            component.setForeground(Color.WHITE);
        } // 5. Hanya Nilai Kritis
        else if (kritis) {
            component.setBackground(new Color(244, 67, 54)); // Red
            component.setForeground(Color.WHITE);
        } // 6. Hanya TBaK Pending
        else if (tbak && !verified) {
            component.setBackground(new Color(255, 235, 59)); // Yellow
            component.setForeground(Color.BLACK);
        } // 7. Hanya TBaK Verified
        else if (tbak && verified) {
            component.setBackground(new Color(76, 175, 80)); // Green
            component.setForeground(Color.WHITE);
        } // 8. Non Kritis + Non TBaK + Verified
        else if (!kritis && !tbak && verified) {
            component.setBackground(new Color(33, 150, 243)); // Blue
            component.setForeground(Color.WHITE);
        } // 9. Normal
        else {
            if (row % 2 == 1) {
                component.setBackground(new Color(255, 244, 244));
            } else {
                component.setBackground(Color.WHITE);
            }
            component.setForeground(Color.BLACK);
        }

        return component;
    }

}
