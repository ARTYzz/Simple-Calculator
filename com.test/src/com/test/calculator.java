package com.test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

  public class calculator implements ActionListener {

	static JFrame f ;
	static JTextField tf;
	String s0,s1,s2;
	
	calculator(){
		s0=s1=s2="";
	}
	
	/* create function */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		f = new JFrame("Simple Calculator");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
		 System.err.println(e.getMessage());
		}	
		
			calculator c = new calculator();
			tf = new JTextField(20);
			
			
			/* create number */
			JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bq,bp,bmb,bd,bm,bc,bd1;
			
		/* add Button */
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		bp = new JButton("+");
		bq = new JButton("=");
		bm = new JButton("-");
		bmb = new JButton("*");
		bd = new JButton("/");
		bc = new JButton("C");
		bd1 = new JButton(".");
		
		JPanel p = new JPanel();
		
		/* add Action Listeners */
		b0.addActionListener(c);
		b1.addActionListener(c);
		b2.addActionListener(c);
		b3.addActionListener(c);
		b4.addActionListener(c);
		b5.addActionListener(c);
		b6.addActionListener(c);
		b7.addActionListener(c);
		b8.addActionListener(c);
		b9.addActionListener(c);
		bp.addActionListener(c);
		bq.addActionListener(c);
		bm.addActionListener(c);
		bmb.addActionListener(c);
		bd.addActionListener(c);
		bc.addActionListener(c);
		bd1.addActionListener(c);
		
		/* add Button to panel */
		p.add(tf);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bp);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bmb);
		p.add(bd1);
		p.add(b0);
		p.add(bc);
		p.add(bd);
		p.add(bq);
		
	   tf.setEditable(false);
		f.add(p);
		f.setSize(200, 300);
		f.show();
		
		p.setBackground(Color.GRAY);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String s = e.getActionCommand();
		
		// if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
 
            // set the value of text
            tf.setText(s0 + s1 + s2);
						
		} 
		else if(s.charAt(0) == 'C') {
			s0 = s1 = s2 = "";
		
		tf.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {
			 
            double te;
 
            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
            // set the value of text
            tf.setText(s0 + s1 + s2 + "=" + te);
 
            // convert it to string
            s0 = Double.toString(te);
 
            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            // else evaluate
            else {
                double te;
 
                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
                // convert it to string
                s0 = Double.toString(te);
 
                // place the operator
                s1 = s;
 
                // make the operand blank
                s2 = "";
            }
 
            // set the value of text
            tf.setText(s0 + s1 + s2);
        }
    }

		
		
	}
	
	
	
	

