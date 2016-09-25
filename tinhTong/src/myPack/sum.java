package myPack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class sum {
	private JFrame Frame;
	private JLabel vara;
	private JLabel varb;
	private JTextField txta;
	private JTextField txtb;
	private JLabel kqua;
	private JButton btnGiai;
	private JButton btnReset;
	
	public sum(){
		prepareGUI();
	}

	public static void main(String[] args){
	     sum sum= new sum();
	   }
	private void prepareGUI(){
		Frame = new JFrame("Tinh Tong");
		Frame.setLayout(new GridLayout(4,1));
		Frame.setSize(500, 500);
		Frame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
		
		vara = new JLabel ("Nhap a");
		vara.setFont(new Font("Courier New",Font.PLAIN,14));
		vara.setForeground(Color.BLUE);
		txta = new JTextField();
		JPanel pan1 = new JPanel(new GridLayout(1,2));
		pan1.add(vara);
		pan1.add(txta);
		
		varb = new JLabel ("Nhap b");
		varb.setFont(new Font("Courier New",Font.PLAIN,14));
		varb.setForeground(Color.BLUE);
		
		txtb = new JTextField();
		JPanel pan2 = new JPanel(new GridLayout(1,2));
		pan2.add(varb);
		pan2.add(txtb);
		
		btnGiai = new JButton("Giai");
		btnGiai.setFont(new Font("Courier New",Font.PLAIN,14));
		btnGiai.addActionListener(new CustomActionListener());
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Courier New",Font.PLAIN,14));
		btnReset.addActionListener(new CustomActionListener());
		
		JPanel pan3 = new JPanel(new GridLayout(1,2));
		pan3.add(btnGiai);
		pan3.add(btnReset);
		
		txta.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		       txtb.requestFocus();
		    }
		});
		
		txtb.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		       btnGiai.requestFocus();
		    }
		});
		btnGiai.addKeyListener(new CustomKeyListener());
		kqua=new JLabel ("Ket qua",JLabel.CENTER);
		
		
		Frame.add(pan1);
		Frame.add(pan2);
		Frame.add(pan3);
		Frame.add(kqua);
		Frame.setVisible(true);
	}
	class CustomActionListener implements ActionListener{
	      public void actionPerformed(ActionEvent e) {
	    	  if(e.getSource().equals(btnGiai)){
	    		  try{
	    			  double a = Double.parseDouble(txta.getText());
	    			  double b = Double.parseDouble(txtb.getText());
	    			  double c=a+b;
	    			  kqua.setText(Double.toString(c));
	    			  }
	    		  catch(NumberFormatException ex){
	    			  kqua.setText("Loi!!!" + ex.getMessage());
	    		  }
	    		  }
	    	  if(e.getSource().equals(btnReset)){
	    		  txta.setText("");
	    		  txtb.setText("");
	    		  txta.requestFocus();
	    	  }
	      }
	   }
	class CustomKeyListener implements KeyListener{
	     

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				if(e.getSource().equals(btnGiai)){
			    	  if(e.getSource().equals(btnGiai)){
			    		 Giai(txta.getText(),txtb.getText());
			    		  }
			    	
			      }
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	private void Giai(String a1, String b1 ){
	
		try{
			  double a = Double.parseDouble(a1);
			  double b = Double.parseDouble(b1);
			  double c=a+b;
			  kqua.setText(Double.toString(c));
			  }
		  catch(NumberFormatException ex){
			  kqua.setText("Loi!!!" + ex.getMessage());
		  }

	}
}
