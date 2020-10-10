import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchForm extends JFrame
{
    public LaunchForm() {
        setTitle("Интегрирование с MS Office");
        setPreferredSize(new Dimension(300, 200));
        setResizable(false);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JButton showTextForm = new JButton("Word");
        JButton showTableForm = new JButton("Excel");
        
        add(showTextForm);
        add(showTableForm);
        
        final TextForm textForm = new TextForm();
        showTextForm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if (!textForm.isVisible()) {
                    textForm.pack();
                    textForm.setLocationRelativeTo(null);
                    textForm.setVisible(true);
                }
            }
        });
        
        final TableForm tableForm = new TableForm();
        showTableForm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if (!tableForm.isVisible()) {
                    tableForm.pack();
                    tableForm.setLocationRelativeTo(null);
                    tableForm.setVisible(true);
                }
            }
        });
    }
}
