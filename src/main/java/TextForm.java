import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TextForm extends JFrame
{
    private JTextPane textPane = new JTextPane();
    
    public TextForm() {
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(textPane);
        
        JButton saveButton = new JButton("Сохранить");
        
        add(saveButton, BorderLayout.NORTH);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new WordWriter().write(textPane.getText(), "test.docx");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        
        setPreferredSize(new Dimension(640, 480));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
