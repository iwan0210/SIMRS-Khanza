/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Owner
 */
public class WarnaTable4MultiLine extends JTextArea implements TableCellRenderer {
    
    public WarnaTable4MultiLine() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
        setFont(new java.awt.Font("Tahoma", 0, 11));
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        this.setText((String)value);
        
        if (isSelected) {
            setBackground(table.getSelectionBackground());
            setForeground(table.getSelectionForeground());
        } else {
            if (row % 2 == 1) {
                setBackground(new Color(255, 244, 244)); // sesuai kode asli
            } else {
                setBackground(Color.WHITE);              // sesuai kode asli
            }
            setForeground(new Color(50, 50, 50));       // sesuai kode asli
        }
        
        int colWidth = table.getColumnModel().getColumn(column).getWidth();
        setSize(colWidth, Short.MAX_VALUE);
        
        return this;
    }

}
