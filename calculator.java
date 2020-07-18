package calculator;

import java.awt.event.*; 
import javax.swing.*; 
import java.awt.*; 

class calculator extends JFrame implements ActionListener 
{ 
    // create frame and textarea
    static JFrame f;  
    static JTextArea tfield; 
    
   // variables
    String s0, s1, s2; 
    double a;
    JPanel textPanel, buttonpanel;
    
    // default constrcutor 
    calculator() 
    { 
        s0 = s1 = s2 = ""; 
    } 
   
    
    // main function 
    public static void main(String args[]) 
    { 
        f = new JFrame("Scientific_Calculator");   
        f.setVisible(true);
        try 
        { 
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // set look and feel
        } 
        catch (Exception e)
        { 
            System.err.println(e.getMessage()); 
        } 
  
        // create a object of class 
        calculator c = new calculator(); 
  
        //  textarea
        
        tfield = new JTextArea(4, 34); 
        //tfield.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        //textpanel
        
       JPanel textpanel = new JPanel();
        textpanel.add(tfield);
      
        //keylisteners
        
        //tfield.addKeyListener(c);
        textpanel.add(tfield);
  
        // create number buttons and some operators 
        JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, clr, pow2, pow3, exp,
		fac, plus, min, div, log, inv , mul, eq, addSub, dot, 
		sqrt, sin, cos, tan;
  
        // create number buttons 
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
   
  
        // create operator buttons 
		plus = new JButton("+");
		min = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		addSub = new JButton("+/-");
		dot = new JButton(".");
		eq = new JButton("=");
		inv= new JButton("inv x");
		sqrt = new JButton("Sqrt");
		log = new JButton("log");
		sin = new JButton("SIN");
		cos = new JButton("COS");
		tan = new JButton("TAN");
		pow2 = new JButton("x^2");
		pow3 = new JButton("x^3");
		exp = new JButton("Exp");
		fac = new JButton("n!");
		clr = new JButton("AC"); 
  
        // create a panel 
        JPanel buttonpanel = new JPanel(); 
       buttonpanel.setLayout(new GridLayout(7,4,4,4));
  
        // add action listeners 
        
        b9.addActionListener(c); 
        b8.addActionListener(c); 
        b7.addActionListener(c); 
        b6.addActionListener(c); 
        b5.addActionListener(c); 
        b4.addActionListener(c); 
        b3.addActionListener(c); 
        b2.addActionListener(c); 
        b1.addActionListener(c); 
        b0.addActionListener(c); 
        plus.addActionListener(c);
		min.addActionListener(c);
		mul.addActionListener(c);
		div.addActionListener(c);
		addSub.addActionListener(c);
		dot.addActionListener(c);
		eq.addActionListener(c);
		inv.addActionListener(c);
		sqrt.addActionListener(c);
		log.addActionListener(c);
		sin.addActionListener(c);
		cos.addActionListener(c);
		tan.addActionListener(c);
		pow2.addActionListener(c);
		pow3.addActionListener(c);
		exp.addActionListener(c);
		fac.addActionListener(c);
		clr.addActionListener(c);
		
		//
		tfield.disable();
		
		f.add("Center", buttonpanel);
		f.add("North", textpanel);
  
        //add element to the panel
        
        buttonpanel.add(b1); 
        buttonpanel.add(b2); 
        buttonpanel.add(b3); 
        buttonpanel.add(b4); 
        buttonpanel.add(b5); 
        buttonpanel.add(b6); 
        buttonpanel.add(b7); 
        buttonpanel.add(b8); 
        buttonpanel.add(b9);  
        buttonpanel.add(b0); 
        buttonpanel.add(plus); 
        buttonpanel.add(min); 
        buttonpanel.add(mul);
        buttonpanel.add(div); 
        buttonpanel.add(addSub); 
        buttonpanel.add(dot); 
        buttonpanel.add(eq); 
        buttonpanel.add(inv); 
        buttonpanel.add(sqrt); 
        buttonpanel.add(log); 
        buttonpanel.add(sin);  
        buttonpanel.add(cos);
        buttonpanel.add(tan); 
        buttonpanel.add(pow2); 
        buttonpanel.add(pow3); 
        buttonpanel.add(exp); 
        buttonpanel.add(fac); 
        buttonpanel.add(clr);
  
        // set Background of panel 
        buttonpanel.setBackground(Color.blue); 
        //grid layout for buttons
        buttonpanel.setLayout(new GridLayout(7, 4, 2, 2));
     
      //frame size
        f.setSize(300, 300); 
        f.show(); 
    } 
    public void actionPerformed(ActionEvent e) 
    { 
        String s = e.getActionCommand(); 
  
        // if the value is a number 
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.')
        { 
            // if operand is present then add to second no 
            if (!s1.equals("")) 
                s2 = s2 + s; 
            else
                s0 = s0 + s; 
  
            // set the value of text 
            tfield.setText(s0 + s1 + s2); 
        } 
        else if (s.equals("AC")) 
        { 
            // clear the one letter 
            s0 = s1 = s2 = ""; 
  
            // set the value of text 
            tfield.setText(s0 + s1 + s2); 
        } 
        else if (s.equals("log"))
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			} 
			else 
			{
				a = Math.log(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("inv x"))             
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			}
			else 
			{
				a = 1/Double.parseDouble(tfield.getText());
				s0 = Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("Exp"))
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			} 
			else
			{
				a = Math.exp(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
				
			}
		}
        else if (s.equals("x^2")) 
        {
			if (tfield.getText().equals(""))
			{
				tfield.setText("");
			}
			else
			{
				a = Math.pow(Double.parseDouble(tfield.getText()), 2);
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}	
        else if (s.equals("x^3")) 
        {
			if (tfield.getText().equals(""))
			{
				tfield.setText("");
			}
			else 
			{
				a = Math.pow(Double.parseDouble(tfield.getText()), 3);
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("+/-"))   //not working
        {       
			if (s1 == "")
			{
				a=Double.parseDouble(tfield.getText())*(-1);
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}

			else 
			{
				tfield.setText(tfield.getText());
			}
		}	
        else if (s.equals("Sqrt")) 
        {
			if (tfield.getText().equals(""))
            {
				tfield.setText("");
			} 
			else 
			{
				a = Math.sqrt(Double.parseDouble(tfield.getText()));
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("SIN"))
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			} 
			else 
			{
				a = Math.sin(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("COS"))
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			} 
			else 
			{
				a = Math.cos(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}
        else if (s.equals("TAN")) 
        {
			if (tfield.getText().equals("")) 
			{
				tfield.setText("");
			} 
			else
			{
				a = Math.tan(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
		}	
	else if (s.equals("n!")) 
	{
			if (tfield.getText().equals(""))
			{
				tfield.setText("");
			} 
			else
			{
				a = fact(Double.parseDouble(tfield.getText()));
				s0=Double.toString(a);
				tfield.setText("");
				tfield.setText(tfield.getText() + a);
			}
	}
		

        else if (s.charAt(0) == '=')
        { 
  
            double ans; 
  
            // store the value in 1st 
            if (s1.equals("+")) 
                ans = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
            else if (s1.equals("-")) 
                ans = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
            else if (s1.equals("/")) 
                ans = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
            else
                ans = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
  
            // set the value of text 
            tfield.setText(s0 + s1 + s2 + "=" + ans); 
  
            // convert it to string 
            s0 = Double.toString(ans); 
  
            s1 = s2 = ""; 
        } 
        else 
        { 
            // if there was no operand 
            if (s1.equals("") || s2.equals("")) 
                s1 = s; 
            // else evaluate 
            else 
            { 
                double ans; 
  
                // store the value in 1st 
                if (s1.equals("+")) 
                    ans = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
                else if (s1.equals("-")) 
                    ans = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
                else if (s1.equals("/")) 
                    ans = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
                else
                    ans = (Double.parseDouble(s0) * Double.parseDouble(s2)); 
 
                s0 = Double.toString(ans); 
                s1 = s; 
                s2 = "";  // make the operand blank 
            } 
  
            // set the value of text 
            tfield.setText(s0 + s1 + s2); 
        } 
    }
    
    	double fact(double x)
    	{
    		int e = 0;
    		if (s0 =="") 
    		{
    			e = 20;
    			return 0;
    		}
    		double i, ans = 1;
    		for (i = 2; i <= x; i += 1.0)
    			ans *= i;
    		return ans;
    	}

}
	