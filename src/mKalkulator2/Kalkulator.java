package mKalkulator2;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator implements ActionListener {

    public static void main(String[] args) {new Kalkulator();}
	String sEkran = "0";
    String[] sKey = {"1","2","3","C",
            "4","5","6","+",
            "7","8","9","-",
            "0","*","/","=",};
    Color[] cKey = {Color.BLACK, Color.BLACK, Color.BLACK, Color.RED,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLUE,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.GREEN};

        JFrame okno = new JFrame("Kalkulator");
        JTextField text = new JTextField(sEkran);
        JButton[] bKey = new JButton[16];
        Font font = new Font("System", Font.BOLD,15);


    Kalkulator() {
        for (byte i=0; i<16; i++){
            bKey[i] = new JButton(sKey[i]);
            okno.add(bKey[i]);bKey[i].addActionListener(this);

        }
        byte index = 0;
        for (byte y=0; y<4; y++)
            for (byte x=0; x<4; x++){
            bKey[index].setBounds(10+(x*50), 55+(y*50), 45, 45);
            bKey[index].setFont(font);
            bKey[index].setForeground(cKey[index]);
            index++;
        }



        text.setBounds(10, 10, 195, 35); text.setFont(new Font("System",Font.BOLD,20));
        text.setEditable(false); text.setHorizontalAlignment(JTextField.RIGHT);


        okno.add(text);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setSize(220, 285);
        okno.setLocationRelativeTo(null);
        okno.setResizable(false);
        okno.setLayout(null);
        okno.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object cel = e.getSource();

        for (byte i = 0; i<16; i++) if (cel==bKey[i]) oblicz(i);

    }
}
