/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ticTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class MyPanel extends JPanel{
    JLabel l;
    public MyPanel(){
        l = new JLabel("");
        setLayout(new GridBagLayout());
        l.setFont(new Font("Arial",Font.PLAIN,100));
        add(l);
    }
    public int turn(int n){
        if(!l.getText().equals("")) return -1;
        if(n==0){
            l.setText("X");
            l.setForeground(new Color(84, 84, 84));
            return 1;  
        }      
        else{
            l.setText("O"); 
            l.setForeground(new Color(242, 235, 211));
            return 0;
        }
    }
}
