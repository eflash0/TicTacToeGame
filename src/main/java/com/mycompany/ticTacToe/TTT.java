/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ticTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author admin
 */
public class TTT extends JFrame implements MouseListener{
    MyPanel[] p;
    int k=0;
    ArrayList<Integer> a;
    JLabel l;
    int n=3;
    public TTT(){
        super("Tic-Tac-Toe");
        setSize(500,500);
        setLayout(new GridLayout(n,n,5,5));
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(13, 161, 146));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p=new MyPanel[n*n];
        l=new JLabel();
        l.setForeground(Color.red);
//        l.setFont(new Font("Arial",Font.BOLD,30));
//        l.setText("You won !");
        a=new ArrayList<Integer>();
        for(int i=0;i<n*n;i++){
            p[i]=new MyPanel();
            p[i].addMouseListener(this);
            p[i].setBackground(new Color(20, 189, 172));
            add(p[i]);
        }
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new TTT();
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        boolean sb;
        for(int i=0;i<n*n;i++){
            if(e.getSource()==p[i]){
                k=p[i].turn(k);
            }
        }
        sb=isSequence();
        if(sb==true){
            JOptionPane.showMessageDialog(null, "You won !");
            for (int i=0;i<n*n; i++) {
                p[i].removeMouseListener(p[i].getMouseListeners()[0]);
            }
        }
    }
    
    boolean isSequence(){
        for(int i=0;i<n;i++){
            a.add(i);
            int c=1;
            if(p[i].l.getText().equals("")) continue;
            int o=i+n*(n-1);
            c=1;
            for(int j=i+n;j<o+1;j+=n){ 
                if(p[j].l.getText().equals("")) break;
                if(!p[i].l.getText().equals(p[j].l.getText())){
                    c=1;
                    a.clear();
                    break;
                }  
                else if(p[i].l.getText().equals(p[j].l.getText())){
                    a.add(j);
                    c++;
                }    
            }
            if(c==n) return true;
            if(i==0){
                for(int j=i+n+1;j<n*n;j+=(n+1)){
                    if(p[j].l.getText().equals("")) break;
                    if(!p[i].l.getText().equals(p[j].l.getText())){
                      c=1;
                      a.clear();
                      break; 
                    }  
                    else if(p[i].l.getText().equals(p[j].l.getText())){
                        a.add(j);
                        c++;
                    } 
                } 
                if(c==n) return true;
            }
            if(i==n-1){
                for(int j=i+n-1;j<n*(n-1)+1;j+=(n-1)){
                    if(p[j].l.getText().equals("")) break;
                    if(!p[i].l.getText().equals(p[j].l.getText())){
                      c=1;
                      a.clear();
                      break; 
                    }  
                    else if(p[i].l.getText().equals(p[j].l.getText())){
                        a.add(j);
                        c++;
                    } 
                }
                if(c==n) return true;
            }
        }
        for(int i=0;i<n*(n-1)+1;i+=n){
            int c=1;
            if(p[i].l.getText().equals("")) continue;
            for(int j=i+1;j<i+n;j++){
                if(p[j].l.getText().equals("")) break;
                if(!p[i].l.getText().equals(p[j].l.getText())){
                    c=1;
                    a.clear();
                    break; 
                }     
                else if(p[i].l.getText().equals(p[j].l.getText())){
                    a.add(j);
                    c++;
                } 
            }
            if(c==n) return true;
        }
        return false;
    }
    
//    public void paint(Graphics g){
//        Graphics2D g2=(Graphics2D)g;
//        g2.setPaint(Color.white);
//        g2.fillArc(0, 0, 100, 100, 0, NORMAL);
//    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
         
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}
