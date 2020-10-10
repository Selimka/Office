import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class TableForm extends JFrame
{
    private final JTable table = new JTable();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    
    public TableForm() {
        table.setModel(tableModel);
        tableModel.setRowCount(8);
        tableModel.setColumnCount(4);
        
        JButton saveButton = new JButton("Сохранить");
        
        add(table, BorderLayout.CENTER);
        add(saveButton, BorderLayout.NORTH);
        
        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ExcelWriter().writeTable(getTableData(), new File("test.xlsx"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private String[][] getTableData() {
        String[][] data = new String[tableModel.getRowCount()][];
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            data[i] = new String[tableModel.getColumnCount()];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                Object value = tableModel.getValueAt(i, j);
                data[i][j] = (value != null) ? value.toString() : "";
            }
        }
        return data;
    }
}
