/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListeEtudiants;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AdMin
 */
public class TableCelleRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(row % 2 == 0){
            if(isSelected){
                component.setForeground(Color.black);
            }
            component.setBackground(new Color(150, 252, 151));
        }
        else{
            if(isSelected){
                component.setForeground(Color.black);
            }
            component.setBackground(new Color(50, 205, 50));
        }
        
        setHorizontalAlignment(CENTER);
        
        return component;
        
    }
    
}
