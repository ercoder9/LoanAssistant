package loanassistant;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.text.*;


public class LoanAssistant extends JFrame {
	
	
	
	JLabel LoanBalance = new JLabel ("Loan Balance");
	JLabel InterestRate = new JLabel ("Interest Rate");
	JLabel NumberOfPayment = new JLabel ("Numbers of Payments");
	JLabel MonthlyPayment = new JLabel ("Monthly Payments");
	JLabel analysisLabel = new JLabel("Loan Analysis");
	JTextArea analysisTextArea = new JTextArea();
	JButton exitButton = new JButton("Exit");
	JTextField Lb = new JTextField();
	JTextField Ir = new JTextField();
	JTextField Nop = new JTextField();
	JTextField Mp = new JTextField();
	JButton computeButton = new JButton("Compute Monthly Payment");
	JButton newLoanButton = new JButton("New Loan Analysis");
	JButton xp = new JButton();
	JButton xmp = new JButton();
	
	Color lightYellow = new Color(255, 255, 128);
	boolean computePayment;
	
	public static void main(String args[])
	{
		new LoanAssistant().setVisible(true);
	}
	public LoanAssistant()
	{
		setTitle("Loan Assistant");
		setResizable(false);
		setSize(800,300);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		Font myFont = new Font("Arial",Font.PLAIN, 16);
		Font myFont1 = new Font("Courier",Font.PLAIN,14);
		
		
		
		LoanBalance.setFont(myFont);
		InterestRate.setFont(myFont);
		NumberOfPayment.setFont(myFont);
		MonthlyPayment.setFont(myFont);
		analysisLabel.setFont(myFont);
		analysisTextArea.setFont(myFont1);
		
		
		xp.setBounds(340,90,45,30);
		xmp.setBounds(340,130,45,30);
		xp.setFocusable(false);
		xmp.setFocusable(false);
		xp.setText("X");
		xmp.setText("X");
		analysisLabel.setBounds(390, 10, 200, 30);
		analysisTextArea.setBounds(390,50, 280,160);
		computeButton.setBounds(50,180, 220, 30);
		newLoanButton.setBounds(75,220, 150, 30);
		exitButton.setBounds(500,220,60,30);
		analysisTextArea.setFocusable(false);
		exitButton.setFocusable(false);
		
		LoanBalance.setBounds(10, 10, 100, 30);
		InterestRate.setBounds(10, 50, 100, 30);
		NumberOfPayment.setBounds(10, 90, 200, 30);
		MonthlyPayment.setBounds(10, 130, 200, 30);
		Lb.setBounds(180, 10 , 150, 30);
		Ir.setBounds(180, 50 , 150, 30);
		Nop.setBounds(180, 90 , 150, 30);
		Mp.setBounds(180, 130, 150, 30);
		
		
		add(computeButton);
		add(newLoanButton);
		add(LoanBalance);
		add(InterestRate);
		add(NumberOfPayment);
		add(MonthlyPayment);
		add(Lb);
		add(Ir);
		add(Nop);
		add(Mp);
		add(xp);
		add(xmp);
		add(analysisLabel);
		add(analysisTextArea);
		add(exitButton);
		
		computeButton.addActionListener( new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				computeButtonActionPerformed(e);
			}
		});
		
		newLoanButton.addActionListener( new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				newLoanButtonActionPerformed(e);
			}
				});
		exitButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				exitButtonActionPerformed(e);
			}
				});
		xmp.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				paymentButtonActionPerformed(e);
			}
				});
		xp.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				
				monthsButtonActionPerformed(e);
			}
				});
		
		Lb.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
			
			balanceTextFieldActionPerformed(e);
		}
			});
		Ir.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			
			interestTextFieldActionPerformed(e);
		}
			});
		Nop.addActionListener(new ActionListener()
		{
		public void actionPerformed(ActionEvent e)
		{
			
			monthsTextFieldActionPerformed(e);
		}
			});
		Mp.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
			
			paymentTextFieldActionPerformed(e);
		}
			});
		
		
		
		
		
	}
	protected void paymentTextFieldActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Mp.transferFocus();
		
	}
	protected void monthsTextFieldActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Nop.transferFocus();
	}
	protected void interestTextFieldActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Ir.transferFocus();
		
	}
	protected void balanceTextFieldActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Lb.transferFocus();
	}
	private void monthsButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		computePayment = false;
		xp.setVisible(false);
		xmp.setVisible(true);
		Mp.setEditable(true);
		Mp.setBackground(Color.WHITE);
		Mp.setFocusable(true);
		Nop.setText("");
		Nop.setEditable(false);
		Nop.setBackground(lightYellow);
		Nop.setFocusable(false);
		computeButton.setText("Compute Number of Payments");
		Lb.requestFocus();
		
	}
	protected void paymentButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		computePayment = true;
		xp.setVisible(true);
		xmp.setVisible(false);
		Nop.setEditable(true);
		Nop.setBackground(Color.WHITE);
		Nop.setFocusable(true);
		Mp.setText("");
		Mp.setEditable(false);
		Mp.setBackground(lightYellow);
		Mp.setFocusable(false);
		computeButton.setText("Compute Monthly Payment");
		Lb.requestFocus();
		
	}
	protected void exitButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}
	protected void computeButtonActionPerformed(ActionEvent e) {
		
		double balance, interest,payment;
		double loanBalance, finalPayment;
		int months;
		double monthlyInterest , multiplier;
		if (validateDecimalNumber(Lb))
		{
			balance = Double.valueOf(Lb.getText()).doubleValue();
		}
		else
		{
			JOptionPane.showConfirmDialog(null,"Invalid or empty Loan Balance entry.\nPlease correct.","Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (validateDecimalNumber(Ir))
		{
			interest = Double.valueOf(Ir.getText()).doubleValue();
		}
		else
		{
			JOptionPane.showConfirmDialog(null,"Invalid or empty Interest Rate entry.\nPlease correct.","Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		monthlyInterest = interest/1200;
		
		if(computePayment)
		{
			if(validateDecimalNumber(Nop))
			{
				months = Integer.valueOf(Nop.getText()).intValue();
			}
			else
			{
				JOptionPane.showConfirmDialog(null,"Invalid or empty Number of Payments entry.\nPlease correct.","Number of Payment Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(interest == 0)
			{
				payment = balance/months;
			}
			else
			{
				multiplier = Math.pow(1+monthlyInterest, months);
				payment = balance* monthlyInterest*multiplier/(multiplier-1);
			}
			Mp.setText(new DecimalFormat("0.00").format(payment));
		}
		else
		{
			if(validateDecimalNumber(Mp))
			{
				payment = Double.valueOf(Mp.getText()).doubleValue();
				if(payment <= (balance*monthlyInterest+1.0))
				{
					if(JOptionPane.showConfirmDialog(null,"Minimum payment must be $" + new DecimalFormat("0.00").format((int)(balance*monthlyInterest+1.0))+"\n"+"Do you want to use the minimum payment?","Input Error", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
					{
						Mp.setText(new DecimalFormat("0.00").format((int)(balance*monthlyInterest+1.0)));
						payment = Double.valueOf(Mp.getText()).doubleValue();
						
					}
					else
					{
						Mp.requestFocus();
						return;
					}
					 
				}
			}
			else
			{
				JOptionPane.showConfirmDialog(null,"Invalid or empty Monthly Payment entry.\nPlease correct.","Payment Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(interest == 0)
			{
				months= (int)(balance/payment);
			}
			else
			{
				months = (int)((Math.log(payment)-Math.log(payment - balance * monthlyInterest))/ Math.log(1+monthlyInterest));
			}
			Nop.setText(String.valueOf(months));
		}
		
		payment = Double.valueOf(Mp.getText()).doubleValue();
		analysisTextArea.setText("Loan Balance: $"+ new DecimalFormat("0.00").format(balance));
		analysisTextArea.append("\n" + "Interest Rate: " +new DecimalFormat("0.00").format(interest)+"%");
		
		loanBalance =balance;
		for (int paymentNumber=1;paymentNumber<= months-1;paymentNumber++)
		{
			loanBalance+= loanBalance*monthlyInterest-payment;
			
		}
		
		finalPayment =loanBalance;
		if(finalPayment>payment)
		{
			loanBalance+=loanBalance*monthlyInterest-payment;
			finalPayment = loanBalance;
			months++;
			Nop.setText(String.valueOf(months));
		}
		analysisTextArea.append("\n\n"+String.valueOf(months-1)+" Payments of $"+new DecimalFormat("0.00").format(payment));
		analysisTextArea.append("\n" + "Final Payament of: $"+ new DecimalFormat("0.00").format(finalPayment));
		analysisTextArea.append("\n" + "Total Payament of: $"+ new DecimalFormat("0.00").format((months-1)*payment+finalPayment));
		analysisTextArea.append("\n" + "Interest Paid $"+ new DecimalFormat("0.00").format((months-1)*payment+finalPayment-balance));
		computeButton.setEnabled(false);
		newLoanButton.setEnabled(true);
		newLoanButton.requestFocus();
		
	}
	protected void newLoanButtonActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(computePayment)
		{
			Mp.setText("");
		}
		else
		{
			Nop.setText("");
		}
		analysisTextArea.setText("");
		computeButton.setEnabled(true);
		newLoanButton.setEnabled(false);
		Lb.requestFocus();
	}
	
	public boolean validateDecimalNumber(JTextField tf)
	{
		String s = tf.getText().trim();
		boolean hasDecimal= false;
		boolean valid = true;
		if(s.length() == 0)
		{
			valid = false;
		}
		else
		{
			for(int i =0 ;i<s.length(); i++)
			{
				char c = s.charAt(i);
				if(c >= '0'&& c<='9')
				{
					continue;
				}
				else if(c =='.' && !hasDecimal)
				{
					hasDecimal = true;
				}
				else
				{
					valid =false;
				}
			}
		}
		tf.setText(s);
		if(!valid)
		{
			tf.requestFocus();
		}
		return(valid);
	}
					
		
		
}

