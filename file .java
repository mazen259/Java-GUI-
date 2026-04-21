import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz2 implements ActionListener, ItemListener ,MouseListener, KeyListener {

    JFrame frame;
    JTextField questionLabel;
    JButton copyButton;
    JLabel copiedLabel, red, green, r, g;
    JButton save;
    JRadioButton enable, disable;
    JCheckBox bold, italic, plain, underlined;
    JPanel panel;
        int x=320, y=30;

    public quiz2() {

        frame = new JFrame("Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);

        // Text Field
        questionLabel = new JTextField("");
        questionLabel.setBounds(50, 30, 120, 30);
        questionLabel.setBorder(BorderFactory.createLineBorder(Color.black));
   

        // Button Copy
        copyButton = new JButton("Copy");
        copyButton.setBounds(200, 30, 80, 30);
        copyButton.addActionListener(this);

        
      

        // Label
           copiedLabel = new JLabel("");
        copiedLabel.setBounds(x, y, 200, 100);
        copiedLabel.setOpaque(true);
        copiedLabel.setBackground(Color.WHITE);
        copiedLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
       

        // Radio Buttons
        enable = new JRadioButton("Enable");
        enable.setBounds(50, 80, 80, 30);
        enable.setBackground(Color.WHITE);
        enable.addActionListener(this);

        disable = new JRadioButton("Disable");
        disable.setBounds(150, 80, 80, 30);
        disable.setBackground(Color.WHITE);
        disable.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(enable);
        group.add(disable);

        frame.add(enable);
        frame.add(disable);

        // Checkboxes
        bold = new JCheckBox("Bold");
        bold.setBounds(50, 300, 100, 50);
        bold.setBackground(Color.WHITE);
        bold.addItemListener(this);
        frame.add(bold);

        italic = new JCheckBox("Italic");
        italic.setBounds(160, 300, 100, 50);
        italic.setBackground(Color.WHITE);
        italic.addItemListener(this);
        frame.add(italic);

        plain = new JCheckBox("Plain");
        plain.setBounds(270, 300, 100, 50);
        plain.setBackground(Color.WHITE);
        plain.addItemListener(this);
        frame.add(plain);

        underlined = new JCheckBox("Underlined");
        underlined.setBounds(380, 300, 100, 50);
        underlined.setBackground(Color.WHITE);
        underlined.addItemListener(this);
        frame.add(underlined);

        // Color Buttons
        red = new JLabel(new ImageIcon("C:\\htmlfolder\\java\\1f534.png"));
        red.setBounds(50, 200, 50, 50);
        red.addMouseListener(this);

        r = new JLabel("Red");
        r.setBounds(60, 240, 50, 30);
        r.setForeground(Color.RED);
        
          green = new JLabel(new ImageIcon("C:\\htmlfolder\\java\\🟢.png"));
        green.setBounds(160, 200, 50, 50);
        green.addMouseListener(this);


        g = new JLabel("Green");
        g.setBounds(167, 240, 50, 30);
        g.setForeground(Color.GREEN);



        // Save
        save = new JButton("Save");
        save.setBounds(310, 400, 70, 35);
        save.addActionListener(this);
   
        
        // panel
        panel = new JPanel(null);
        panel.setBounds(0, 0, 700, 575);
        panel.setBackground(Color.WHITE);

        panel.add(questionLabel);
        panel.add(copiedLabel);
        panel.add(copyButton);
        panel.add(enable);
        panel.add(disable);
        panel.add(bold);
        panel.add(italic);
        panel.add(plain);
        panel.add(underlined);
        panel.add(red);
        panel.add(green);
        panel.add(r);
        panel.add(g);
        panel.add(save);
// بعد إضافة الـ panel
frame.add(panel);

// KeyListener
panel.setFocusable(true);
panel.addKeyListener(this);

// أول ما يفتح
frame.setVisible(true);
panel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new quiz2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == copyButton) {
            copiedLabel.setText(questionLabel.getText());
        }
        if (e.getSource() == enable) {
            questionLabel.setEnabled(true);
        }

        if (e.getSource() == disable) {
            questionLabel.setEnabled(false);
        }

        if (e.getSource() == save) {
            copiedLabel.setText(questionLabel.getText());
            JOptionPane.showMessageDialog(frame, "Saved successfully");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        int t = Font.PLAIN;
        String s = questionLabel.getText();

        if (plain.isSelected()) {
            t = Font.PLAIN;
            bold.setSelected(false);
            italic.setSelected(false);
        } else {
            if (bold.isSelected()) {
                t += Font.BOLD;
            }
            if (italic.isSelected()) {
                t += Font.ITALIC;
            }
        }

        copiedLabel.setFont(new Font("Arial", t, 16));

        if (underlined.isSelected()) {
            copiedLabel.setText("<html><u>" + s + "</u></html>");
        } else {
            copiedLabel.setText(s);
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == red) {
            copiedLabel.setForeground(Color.RED);
        }
        if (e.getSource() == green) {
            copiedLabel.setForeground(Color.GREEN);
        }
    }
    public void mousePressed(MouseEvent e) {}   
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {} 
  @Override
    public void keyPressed(KeyEvent e) {
      // up
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          y-=5;
            copiedLabel.setLocation(x, y);
        }
        //down
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          y+=5;
            copiedLabel.setLocation(x,y );
        }
        //left
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
          x-=5;
            copiedLabel .setLocation(x,y);
        }
        // right 
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
          x+=5;
            copiedLabel.setLocation(x,y);
        }
        panel.requestFocus();
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
