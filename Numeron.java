import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Numeron extends JFrame implements ActionListener{
	JPanel key,p1,p2,result,log1,log2,rere;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ok,del;
	int[][] player1, player2;
	String[] plylog1,plylog2;
	int i1,i2,j,MODE;
	JLabel re,rer,rere1,rere2,rere3,rere4,p11,p21,p12,p22;
	public Numeron() {
		key=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		result=new JPanel();
		log1=new JPanel();
		log2=new JPanel();
		b0=new JButton("0"); b0.addActionListener(this); b0.setFont(new Font("Arial",Font.PLAIN,15)); b0.setEnabled(false);
		b1=new JButton("1"); b1.addActionListener(this); b1.setFont(new Font("Arial",Font.PLAIN,15)); b1.setEnabled(false);
		b2=new JButton("2"); b2.addActionListener(this); b2.setFont(new Font("Arial",Font.PLAIN,15)); b2.setEnabled(false);
		b3=new JButton("3"); b3.addActionListener(this); b3.setFont(new Font("Arial",Font.PLAIN,15)); b3.setEnabled(false);
		b4=new JButton("4"); b4.addActionListener(this); b4.setFont(new Font("Arial",Font.PLAIN,15)); b4.setEnabled(false);
		b5=new JButton("5"); b5.addActionListener(this); b5.setFont(new Font("Arial",Font.PLAIN,15)); b5.setEnabled(false);
		b6=new JButton("6"); b6.addActionListener(this); b6.setFont(new Font("Arial",Font.PLAIN,15)); b6.setEnabled(false);
		b7=new JButton("7"); b7.addActionListener(this); b7.setFont(new Font("Arial",Font.PLAIN,15)); b7.setEnabled(false);
		b8=new JButton("8"); b8.addActionListener(this); b8.setFont(new Font("Arial",Font.PLAIN,15)); b8.setEnabled(false);
		b9=new JButton("9"); b9.addActionListener(this); b9.setFont(new Font("Arial",Font.PLAIN,15)); b9.setEnabled(false);
		del=new JButton("Del"); del.addActionListener(this); del.setFont(new Font("Arial",Font.PLAIN,15)); del.setEnabled(false);
		ok=new JButton("OK"); ok.addActionListener(this); ok.setFont(new Font("Arial",Font.PLAIN,15)); ok.setEnabled(true);
		key.setLayout(new GridLayout(4,3));
		key.add(b7); key.add(b8); key.add(b9);
		key.add(b4); key.add(b5); key.add(b6);
		key.add(b1); key.add(b2); key.add(b3);
		key.add(ok); key.add(b0); key.add(del);
		re=new JLabel("press OK to start",JLabel.CENTER);
		re.setFont(new Font("Arial", Font.PLAIN, 20));
		rer=new JLabel("",JLabel.CENTER);
		rer.setFont(new Font("Arial", Font.PLAIN, 20));
		rere=new JPanel();
		rere.setLayout(new GridLayout(1,4));
		rere1=new JLabel("",JLabel.CENTER);
		rere2=new JLabel("",JLabel.CENTER);
		rere3=new JLabel("",JLabel.CENTER);
		rere4=new JLabel("",JLabel.CENTER);
		rere.add(rere1); rere.add(rere2); rere.add(rere3); rere.add(rere4);
		rere1.setFont(new Font("Arial", Font.PLAIN, 20));rere2.setFont(new Font("Arial", Font.PLAIN, 20));
		rere3.setFont(new Font("Arial", Font.PLAIN, 20));rere4.setFont(new Font("Arial", Font.PLAIN, 20));
		result.setLayout(new GridLayout(3,1));
		result.add(re,BorderLayout.CENTER);
		result.add(rer,BorderLayout.CENTER);
		result.add(rere,BorderLayout.CENTER);
		p1.setLayout(new GridLayout(2,1));
		p2.setLayout(new GridLayout(2,1));
		p11=new JLabel("",JLabel.CENTER); p12=new JLabel("",JLabel.CENTER); p21=new JLabel("",JLabel.CENTER); p22=new JLabel("",JLabel.CENTER); 
		p1.add(p11); p1.add(p12); p2.add(p21); p2.add(p22); 
		this.setLayout(new GridLayout(2,3));
		this.add(p1); this.add(result);	this.add(p2);  
		this.add(log1); this.add(key); this.add(log2);
		MODE=0;
		player1=new int[100][4]; plylog1=new String[100];
		player2=new int[100][4]; plylog2=new String[100];
		i1=0; i2=0; j=0;
		this.setTitle("Numeron");
		this.setSize(1000,1000);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public int EAT(int a) {
		int count=0;
		if(a==1) {
			for(int u=0;u<4;u++) {
				if(player2[0][u]==player1[i1][u]) {
					count++;
				}
			}
		}
		if(a==2) {
			for(int u=0;u<4;u++) {
				if(player1[0][u]==player2[i2][u]) {
					count++;
				}
			}
		}
		return count;
	}
	public int BITE(int a,int eat) {
		int count=0;
		if(a==1) {
			for(int u=0;u<4;u++) {
				for(int v=0;v<4;v++) {
					if(player2[0][u]==player1[i1][v]) {
						count++;
					}
				}
			}
		}else if(a==2) {
			for(int u=0;u<4;u++) {
				for(int v=0;v<4;v++) {
					if(player1[0][u]==player2[i2][v]) {
						count++;
					}
				}
			}
		}
		count-=eat;
		return count;
	}
	public void printLog(int a) {
		if(a==1) {
			JLabel l1=new JLabel();
			l1.setFont(new Font("Arial", Font.PLAIN, 20));
			log1.add(l1);
			l1.setText(plylog1[i1]);
		}
		if(a==2) {
			JLabel l2=new JLabel();
			l2.setFont(new Font("Arial", Font.PLAIN, 20));
			log2.add(l2);
			l2.setText(plylog2[i2]);
		}
	}
	public void Buttonset(int b,boolean w) {
		if(b==0) b0.setEnabled(w);
		if(b==1) b1.setEnabled(w);
		if(b==2) b2.setEnabled(w);
		if(b==3) b3.setEnabled(w);
		if(b==4) b4.setEnabled(w);
		if(b==5) b5.setEnabled(w);
		if(b==6) b6.setEnabled(w);
		if(b==7) b7.setEnabled(w);
		if(b==8) b8.setEnabled(w);
		if(b==9) b9.setEnabled(w);
	}
	public void actionPerformed(ActionEvent e) {
		String s;
		if(e.getSource()==b0||e.getSource()==b1||
				e.getSource()==b2||e.getSource()==b3||
				e.getSource()==b4||e.getSource()==b5||
				e.getSource()==b6||e.getSource()==b7||
				e.getSource()==b8||e.getSource()==b9) {
			if(e.getSource()==b0) {
				if(MODE%2==1)player1[i1][j]=0;
				else player2[i2][j]=0;
				Buttonset(0,false);
			}
			if(e.getSource()==b1) {
				if(MODE%2==1)player1[i1][j]=1;
				else player2[i2][j]=1;
				Buttonset(1,false);
			}
			if(e.getSource()==b2) {
				if(MODE%2==1)player1[i1][j]=2;
				else player2[i2][j]=2;
				Buttonset(2,false);
			}
			if(e.getSource()==b3) {
				if(MODE%2==1)player1[i1][j]=3;
				else player2[i2][j]=3;
				Buttonset(3,false);
			}
			if(e.getSource()==b4) {
				if(MODE%2==1)player1[i1][j]=4;
				else player2[i2][j]=4;
				Buttonset(4,false);
			}
			if(e.getSource()==b5) {
				if(MODE%2==1)player1[i1][j]=5;
				else player2[i2][j]=5;
				Buttonset(5,false);
			}
			if(e.getSource()==b6) {
				if(MODE%2==1)player1[i1][j]=6;
				else player2[i2][j]=6;
				Buttonset(6,false);
			}
			if(e.getSource()==b7) {
				if(MODE%2==1)player1[i1][j]=7;
				else player2[i2][j]=7;
				Buttonset(7,false);
			}
			if(e.getSource()==b8) {
				if(MODE%2==1)player1[i1][j]=8;
				else player2[i2][j]=8;
				Buttonset(8,false);
			}
			if(e.getSource()==b9) {
				if(MODE%2==1)player1[i1][j]=9;
				else player2[i2][j]=9;
				Buttonset(9,false);
			}
			if(MODE%2==1) {
				s=Integer.toString(player1[i1][j]);
			}else {
				s=Integer.toString(player2[i2][j]);
			}
			if(j==0)rere1.setText(s);
			if(j==1)rere2.setText(s);
			if(j==2)rere3.setText(s);
			if(j==3) {
				ok.setEnabled(true);
				for(int cc=0;cc<=9;cc++)Buttonset(cc,false);
				rere4.setText(s);
			}
			j++; del.setEnabled(true);
		}
		if(e.getSource()==ok) {//start
			if(MODE==0) {
				MODE=1;
				for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
				re.setText("player1");
				rer.setText("input your number");
				ok.setEnabled(false);
				log1.removeAll(); log2.removeAll(); log1.invalidate(); log2.invalidate();
			}
			if(j==4) {
				if(MODE==1) {//player1 input
					re.setText("player2");
					rer.setText("input your number");
					i1++; j=0;
					MODE=2;
					ok.setEnabled(false);
					for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
				}else if(MODE==2) {//player2 input
					re.setText("player1");
					rer.setText("guess the number of player2");
				    i2++; j=0;
				    MODE=3; 
					ok.setEnabled(false);
					for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
				}else if(MODE==3) {//player1 play
					re.setText("player2");
					rer.setText("guess the number of player1");
					int eat=EAT(1); int bite=BITE(1,eat);
					plylog1[i1]=""+player1[i1][0]+player1[i1][1]+player1[i1][2]+player1[i1][3]+"---"+eat+"EAT"+bite+"BITE";
					printLog(1);
					if(eat==4) {
						p12.setFont(new Font("Arial", Font.PLAIN, 30));
						p12.setText("<html>You got it!</html>");
						ok.setEnabled(false);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
						//MODE=0;
						//i1=0; i2=0; j=0;
						//re.setText("press OK to start");
						//rer.setText("New Game");
						i1++; j=0;
						MODE=6;
					}else {
						i1++; j=0;
						MODE=4;
						ok.setEnabled(false);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
					}
				}else if(MODE==4) {//player2 play
					String ans1,ans2;
					re.setText("player1");
					rer.setText("guess the number of player2");
					int eat=EAT(2); int bite=BITE(2,eat);
					plylog2[i2]=""+player2[i2][0]+player2[i2][1]+player2[i2][2]+player2[i2][3]+"---"+eat+"EAT"+bite+"BITE";
					printLog(2);
					if(eat==4) {
						p22.setFont(new Font("Arial", Font.PLAIN, 30));
						p22.setText("<html>You got it!</html>");
						ok.setEnabled(true);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,false);
						MODE=0;
						i1=0; i2=0; j=0;
						ans1=""+player1[0][0]+player1[0][1]+player1[0][2]+player1[0][3];
						ans2=""+player2[0][0]+player2[0][1]+player2[0][2]+player2[0][3];
						re.setText("Winner");
						rer.setText("player2");
						p11.setFont(new Font("Arial", Font.PLAIN, 30));
						p11.setText("LOSE"+ans1);
						p21.setFont(new Font("Arial", Font.PLAIN, 30));
						p21.setText("WIN!"+ans2);
					}else {
						i2++; j=0;
						MODE=3;
						ok.setEnabled(false);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
					}
				}else if(MODE==6) {//player2 last play
					String ans1,ans2;
					int eat=EAT(2); int bite=BITE(2,eat);
					plylog2[i2]=""+player2[i2][0]+player2[i2][1]+player2[i2][2]+player2[i2][3]+"---"+eat+"EAT"+bite+"BITE";
					printLog(2);
					if(eat==4) {
						p22.setFont(new Font("Arial", Font.PLAIN, 30));
						p22.setText("<html>You got it!</html>");
						ok.setEnabled(true);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,false);
						MODE=0;
						i1=0; i2=0; j=0;
						ans1=""+player1[0][0]+player1[0][1]+player1[0][2]+player1[0][3];
						ans2=""+player2[0][0]+player2[0][1]+player2[0][2]+player2[0][3];
						re.setText("Draw");
						rer.setText("--------");
						p11.setFont(new Font("Arial", Font.PLAIN, 30));
						p11.setText("DRAW"+ans1);
						p21.setFont(new Font("Arial", Font.PLAIN, 30));
						p21.setText("DRAW"+ans2);
					}else {
						ok.setEnabled(true);
						for(int cc=0;cc<=9;cc++)Buttonset(cc,false);
						MODE=0;
						i1=0; i2=0; j=0;
						ans1=""+player1[0][0]+player1[0][1]+player1[0][2]+player1[0][3];
						ans2=""+player2[0][0]+player2[0][1]+player2[0][2]+player2[0][3];
						re.setText("Winner");
						rer.setText("player1");
						p11.setFont(new Font("Arial", Font.PLAIN, 30));
						p11.setText("WIN!"+ans1);
						p21.setFont(new Font("Arial", Font.PLAIN, 30));
						p21.setText("LOSE"+ans2);
					}
				}
				del.setEnabled(false);
				rere1.setText(null);
				rere2.setText(null);
				rere3.setText(null);
				rere4.setText(null);				
			}				
		}
		if(e.getSource()==del) {
			j--;
			ok.setEnabled(false);
			if(MODE%2==1) {
				Buttonset(player1[i1][j],true);
			}else {
				Buttonset(player2[i2][j],true);
			}
			if(j==0) {
				rere1.setText(null);
				del.setEnabled(false);
			}
			if(j==1)rere2.setText(null);
			if(j==2)rere3.setText(null);
			if(j==3) {
				rere4.setText(null);
				for(int cc=0;cc<=9;cc++)Buttonset(cc,true);
				for(int cc=0;cc<3;cc++) {
					if(MODE%2==1)Buttonset(player1[i1][cc],false);
					else Buttonset(player2[i2][cc],false);
				}
			}
		}
	}
	public static void main(String argv[]) {
		new Numeron();
	}
}
