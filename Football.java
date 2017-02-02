import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Football extends JFrame{
	
	private final Font smallfont = new Font("Helvetica", Font.BOLD, 24);
	private Image dbImage,img;
	private Graphics dbg;
	int x,xx,xb,xgA,xgB,x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15,x16,x17,x18,x19,x20; 
	int y,yy,yb,ygA,ygB,y1,y2,y3,y4,y5,y6,y7,y8,y9,y10,y11,y12,y13,y14,y15,y16,y17,y18,y19,y20;
	int secondNearestPlayer;
	int firstPlayer;
	boolean goalHappen=false;
	
	double[] arr = new double[20];
	
	HashMap<Integer,Double> hmap = new HashMap<Integer,Double>();
	
	int T=0;
	int ball;
	
	int goalno1=0;
	int goalno2=0;
	
	boolean myball=false;
	public Football(){
		ImageIcon i = new ImageIcon("soccer.png"); 
	   	img = i.getImage();
		setTitle("SoccerAI");
		setSize(900,700);
		setResizable(false);
		setVisible(true);
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		xgB=279;
		ygB=590;
		xb=70;
		yb=120;
		x1=70;
		y1=120;
		x2=190;
		y2=130;
		x3=330;
		y3=130;
		x4=450;
		y4=130;
		x5=108;
		y5=230;
		x6=240;
		y6=230;
		x7=335;
		y7=230;
		x8=425;
		y8=230;
		x9=240;
		y9=300;
		x10=310;
		y10=300;
		
		
		xgA=279;
		ygA=40;
		x11=213;
		y11=324;
		x12=336;
		y12=324;
		x13=111;
		y13=410;
		x14=223;
		y14=412;
		x15=394;
		y15=410;
		x16=493;
		y16=412;
		x17=97;
		y17=498;
		x18=260;
		y18=500;
		x19=335;
		y19=499;
		x20=444;
		y20=506;
		
	}
	public void paint(Graphics g){
		g.setFont(smallfont);
		g.setColor(Color.black);
	   	 g.drawString("Designed by Deba Roy",593,532);
	 dbImage = createImage(getWidth(),getHeight());
   	 dbg = dbImage.getGraphics();
   	 paintComponent(dbg);
   	 g.drawImage(dbImage, 0, 0, this);
   	// g.drawRect(149, 149, 100, 100);
   	// g.drawRect(249, 149, 100, 100);
   	// g.drawRect(349, 149, 100, 100);
   	// g.drawRect(449, 149, 100, 100);
	}
	public void paintComponent(Graphics g){
		g.drawImage(img, 41, 41, this);
		
			g.setColor(Color.RED);
			g.fillRect(xb-2,yb-2,10,10);
			
		
		
		
			g.setColor(Color.white);
			g.fillOval(x1, y1, 10, 10);
			g.fillOval(x2, y2, 10, 10);
			g.fillOval(x3, y3, 10, 10);
			g.fillOval(x4, y4, 10, 10);
			g.fillOval(x5, y5, 10, 10);
			g.fillOval(x6, y6, 10, 10);
			g.fillOval(x7, y7, 10, 10);
			g.fillOval(x8, y8, 10, 10);
			g.fillOval(x9, y9, 10, 10);
			g.fillOval(x10, y10, 10, 10);
		
		//opponent team 
		
		g.setColor(Color.blue);
		g.fillOval(x11, y11, 10, 10);
		g.fillOval(x12, y12, 10, 10);
		g.fillOval(x13, y13, 10, 10);
		g.fillOval(x14, y14, 10, 10);
		g.fillOval(x15, y15, 10, 10);
		g.fillOval(x16, y16, 10, 10);
		g.fillOval(x17, y17, 10, 10);
		g.fillOval(x18, y18, 10, 10);
		g.fillOval(x19, y19, 10, 10);
		g.fillOval(x20, y20, 10, 10);
		
		g.setFont(smallfont);
		
		g.drawString("Team White :  "+goalno1, 620, 180);
		g.drawString("Team Blue :  "+goalno2, 620, 370);
		
		
		run();
		
		//repaint();
	}
	
	public void paintRecent(Graphics g){
		g.drawImage(img, 41, 41, this);
		
		g.setColor(Color.RED);
		g.fillRect(xb-2,yb-2,10,10);
		
	
	
	
		g.setColor(Color.white);
		g.fillOval(x1, y1, 10, 10);
		g.fillOval(x2, y2, 10, 10);
		g.fillOval(x3, y3, 10, 10);
		g.fillOval(x4, y4, 10, 10);
		g.fillOval(x5, y5, 10, 10);
		g.fillOval(x6, y6, 10, 10);
		g.fillOval(x7, y7, 10, 10);
		g.fillOval(x8, y8, 10, 10);
		g.fillOval(x9, y9, 10, 10);
		g.fillOval(x10, y10, 10, 10);
	
	//opponent team 
	
	g.setColor(Color.blue);
	g.fillOval(x11, y11, 10, 10);
	g.fillOval(x12, y12, 10, 10);
	g.fillOval(x13, y13, 10, 10);
	g.fillOval(x14, y14, 10, 10);
	g.fillOval(x15, y15, 10, 10);
	g.fillOval(x16, y16, 10, 10);
	g.fillOval(x17, y17, 10, 10);
	g.fillOval(x18, y18, 10, 10);
	g.fillOval(x19, y19, 10, 10);
	g.fillOval(x20, y20, 10, 10);
	
	g.setFont(smallfont);
	
	g.drawString("Team White :  "+goalno1, 620, 180);
	g.drawString("Team Blue :  "+goalno2, 620, 370);
		
		try {
			Thread.sleep(10);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//repaint();
	}
	
	public void paintGoalShot(Graphics g){
		g.drawImage(img, 41, 41, this);
		
		g.setColor(Color.RED);
		g.fillRect(xb-2,yb-2,10,10);
		
	
	
	
		g.setColor(Color.white);
		g.fillOval(x1, y1, 10, 10);
		g.fillOval(x2, y2, 10, 10);
		g.fillOval(x3, y3, 10, 10);
		g.fillOval(x4, y4, 10, 10);
		g.fillOval(x5, y5, 10, 10);
		g.fillOval(x6, y6, 10, 10);
		g.fillOval(x7, y7, 10, 10);
		g.fillOval(x8, y8, 10, 10);
		g.fillOval(x9, y9, 10, 10);
		g.fillOval(x10, y10, 10, 10);
	
	//opponent team 
	
	g.setColor(Color.blue);
	g.fillOval(x11, y11, 10, 10);
	g.fillOval(x12, y12, 10, 10);
	g.fillOval(x13, y13, 10, 10);
	g.fillOval(x14, y14, 10, 10);
	g.fillOval(x15, y15, 10, 10);
	g.fillOval(x16, y16, 10, 10);
	g.fillOval(x17, y17, 10, 10);
	g.fillOval(x18, y18, 10, 10);
	g.fillOval(x19, y19, 10, 10);
	g.fillOval(x20, y20, 10, 10);
	
	g.setFont(smallfont);
	
	g.drawString("Team White :  "+goalno1, 620, 180);
	g.drawString("Team Blue :  "+goalno2, 620, 370);
		
		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//repaint();
	}
	
	
	
	public void takeshot(){
		//T+=1;
		
		
		
		
			Random rnd = new Random();
			int rndn = rnd.nextInt(4); //power of the shot 
			
			if(rndn==0){
				//to the nearest player
				switch(secondNearestPlayer){
				case 1:
					xb=x1;
					yb=y1;
					break;
				case 2:
					xb=x2;
					yb=y2;
					break;
				case 3:
					xb=x3;
					yb=y3;
					break;
				case 4:
					xb=x4;
					yb=y4;
					break;
				case 5:
					xb=x5;
					yb=y5;
					break;
				case 6:
					xb=x6;
					yb=y6;
					break;
				case 7:
					xb=x7;
					yb=y7;
					break;
				case 8:
					xb=x8;
					yb=y8;
					break;
				case 9:
					xb=x9;
					yb=y9;
					break;
				case 10:
					xb=x10;
					yb=y10;
					break;
				case 11:
					xb=x11;
					yb=y11;
					break;
				case 12:
					xb=x12;
					yb=y12;
					break;
				case 13:
					xb=x13;
					yb=y13;
					break;
				case 14:
					xb=x14;
					yb=y14;
					break;
				case 15:
					xb=x15;
					yb=y15;
					break;
				case 16:
					xb=x16;
					yb=y16;
					break;
				case 17:
					xb=x17;
					yb=y17;
					break;
				case 18:
					xb=x18;
					yb=y18;
					break;
				case 19:
					xb=x19;
					yb=y19;
					break;
				case 20:
					xb=x20;
					yb=y20;
					break;
				}
				
			}
			if(rndn==1){
				//to the nearest player 50%
				switch(secondNearestPlayer){
				case 1:
					xb=x1+(int)arr[1]/2;
					yb=y1+(int)arr[1]/2;
					break;
				case 2:
					xb=x2+(int)arr[1]/2;
					yb=y2+(int)arr[1]/2;				
					break;
				case 3:
					xb=x3+(int)arr[1]/2;
					yb=y3+(int)arr[1]/2;
					break;
				case 4:
					xb=x4+(int)arr[1]/2;
					yb=y4+(int)arr[1]/2;
					break;
				case 5:
					xb=x5+(int)arr[1]/2;
					yb=y5+(int)arr[1]/2;
					break;
				case 6:
					xb=x6+(int)arr[1]/2;
					yb=y6+(int)arr[1]/2;				
					break;
				case 7:
					xb=x7+(int)arr[1]/2;
					yb=y7+(int)arr[1]/2;
					break;
				case 8:
					xb=x8+(int)arr[1]/2;
					yb=y8+(int)arr[1]/2;
					break;
				case 9:
					xb=x9+(int)arr[1]/2;
					yb=y9+(int)arr[1]/2;
					break;
				case 10:
					xb=x10+(int)arr[1]/2;
					yb=y10+(int)arr[1]/2;
					break;
				case 11:
					xb=x11+(int)arr[1]/2;
					yb=y11-(int)arr[1]/2;
					break;
				case 12:
					xb=x12-(int)arr[1]/2;
					yb=y12-(int)arr[1]/2;
					break;
				case 13:
					xb=x13+(int)arr[1]/2;
					yb=y13-(int)arr[1]/2;
					break;
				case 14:
					xb=x14-(int)arr[1]/2;
					yb=y14-(int)arr[1]/2;
					break;
				case 15:
					xb=x15+(int)arr[1]/2;
					yb=y15-(int)arr[1]/2;
					break;
				case 16:
					xb=x16-(int)arr[1]/2;
					yb=y16-(int)arr[1]/2;
					break;
				case 17:
					xb=x17+(int)arr[1]/2;
					yb=y17-(int)arr[1]/2;
					break;
				case 18:
					xb=x18-(int)arr[1]/2;
					yb=y18-(int)arr[1]/2;
					break;
				case 19:
					xb=x19+(int)arr[1]/2;
					yb=y19-(int)arr[1]/2;
					break;
				case 20:
					xb=x20-(int)arr[1]/2;
					yb=y20-(int)arr[1]/2;
					break;
				}
			}
			if(rndn==2){
				//to the nearest player 75%
				switch(secondNearestPlayer){
				case 1:
					xb=x1+(int)(arr[1]/1.33);
					yb=y1+(int)(arr[1]/1.33);
					break;
				case 2:
					xb=x2+(int)(arr[1]/1.33);
					yb=y2+(int)(arr[1]/1.33);				
					break;
				case 3:
					xb=x3+(int)(arr[1]/1.33);
					yb=y3+(int)(arr[1]/1.33);
					break;
				case 4:
					xb=x4+(int)(arr[1]/1.33);
					yb=y4+(int)(arr[1]/1.33);
					break;
				case 5:
					xb=x5+(int)(arr[1]/1.33);
					yb=y5+(int)(arr[1]/1.33);
					break;
				case 6:
					xb=x6+(int)(arr[1]/1.33);
					yb=y6+(int)(arr[1]/1.33);
					break;
				case 7:
					xb=x7+(int)(arr[1]/1.33);
					yb=y7+(int)(arr[1]/1.33);
					break;
				case 8:
					xb=x8+(int)(arr[1]/1.33);
					yb=y8+(int)(arr[1]/1.33);				
					break;
				case 9:
					xb=x9+(int)(arr[1]/1.33);
					yb=y9+(int)(arr[1]/1.33);
					break;
				case 10:
					xb=x10+(int)(arr[1]/1.33);
					yb=y10+(int)(arr[1]/1.33);
					break;
				case 11:
					xb=x11+(int)(arr[1]/1.33);
					yb=y11-(int)(arr[1]/1.33);
					break;
				case 12:
					xb=x12+(int)(arr[1]/1.33);
					yb=y12-(int)(arr[1]/1.33);				
					break;
				case 13:
					xb=x13+(int)(arr[1]/1.33);
					yb=y13-(int)(arr[1]/1.33);
					break;
				case 14:
					xb=x14+(int)(arr[1]/1.33);
					yb=y14-(int)(arr[1]/1.33);
					break;
				case 15:
					xb=x15+(int)(arr[1]/1.33);
					yb=y15-(int)(arr[1]/1.33);
					break;
				case 16:
					xb=x16+(int)(arr[1]/1.33);
					yb=y16-(int)(arr[1]/1.33);
					break;
				case 17:
					xb=x17+(int)(arr[1]/1.33);
					yb=y17-(int)(arr[1]/1.33);
					break;
				case 18:
					xb=x18+(int)(arr[1]/1.33);
					yb=y18-(int)(arr[1]/1.33);				
					break;
				case 19:
					xb=x19+(int)(arr[1]/1.33);
					yb=y19-(int)(arr[1]/1.33);
					break;
				case 20:
					xb=x20+(int)(arr[1]/1.33);
					yb=y20-(int)(arr[1]/1.33);
					break;
				}
			}
			if(rndn==3){
				switch(firstPlayer){
				case 1:
					xb=x1+30;
					yb=y1+30;
					break;
				case 2:
					xb=x2+30;
					yb=y2+30;				
					break;
				case 3:
					xb=x3-30;
					yb=y3+30;
					break;
				case 4:
					xb=x4-30;
					yb=y4+30;
					break;
				case 5:
					xb=x5+30;
					yb=y5+30;
					break;
				case 6:
					xb=x6+30;
					yb=y6+30;				
					break;
				case 7:
					xb=x7-30;
					yb=y7+30;
					break;
				case 8:
					xb=x8-30;
					yb=y8+30;
					break;
				case 9:
					xb=x9-30;
					yb=y9+30;
					break;
				case 10:
					xb=x10-30;
					yb=y10+30;
					break;
				case 11:
					xb=x11+30;
					yb=y11-30;
					break;
				case 12:
					xb=x12-30;
					yb=y12-30;
					break;
				case 13:
					xb=x13+30;
					yb=y13-30;
					break;
				case 14:
					xb=x14-30;
					yb=y14-30;
					break;
				case 15:
					xb=x15+30;
					yb=y15-30;
					break;
				case 16:
					xb=x16-30;
					yb=y16-30;
					break;
				case 17:
					xb=x17+30;
					yb=y17-30;
					break;
				case 18:
					xb=x18-30;
					yb=y18-30;
					break;
				case 19:
					xb=x19+30;
					yb=y19-30;
					break;
				case 20:
					xb=x20-30;
					yb=y20-30;
					break;
				}
			}
			
		
		
		
	}
	public int leastDistance(){
		
		//repaint();
		
		
		
		ArrayList<Double> al = new ArrayList<Double>();
		
		arr[0] = Math.sqrt((Math.pow(xb-x1,2)+Math.pow(yb-y1,2)));
		al.add(arr[0]);
		hmap.put(1,arr[0]);
		arr[1] = Math.sqrt((Math.pow(xb-x2,2)+Math.pow(yb-y2,2)));
		al.add(arr[1]);
		hmap.put(2,arr[1]);
		arr[2] = Math.sqrt((Math.pow(xb-x3,2)+Math.pow(yb-y3,2)));
		al.add(arr[2]);
		hmap.put(3,arr[2]);
		arr[3] = Math.sqrt((Math.pow(xb-x4,2)+Math.pow(yb-y4,2)));
		al.add(arr[3]);
		hmap.put(4,arr[3]);
		arr[4] = Math.sqrt((Math.pow(xb-x5,2)+Math.pow(yb-y5,2)));
		al.add(arr[4]);
		hmap.put(5,arr[4]);
		arr[5] = Math.sqrt((Math.pow(xb-x6,2)+Math.pow(yb-y6,2)));
		al.add(arr[5]);
		hmap.put(6,arr[5]);
		arr[6] = Math.sqrt((Math.pow(xb-x7,2)+Math.pow(yb-y7,2)));
		al.add(arr[6]);
		hmap.put(7,arr[6]);
		arr[7] = Math.sqrt((Math.pow(xb-x8,2)+Math.pow(yb-y8,2)));
		al.add(arr[7]);
		hmap.put(8,arr[7]);
		arr[8] = Math.sqrt((Math.pow(xb-x9,2)+Math.pow(yb-y9,2)));
		al.add(arr[8]);
		hmap.put(9,arr[8]);
		arr[9] = Math.sqrt((Math.pow(xb-x10,2)+Math.pow(yb-y10,2)));
		al.add(arr[9]);
		hmap.put(10,arr[9]);
		
		//opponent team:
		arr[10] = Math.sqrt((Math.pow(xb-x11,2)+Math.pow(yb-y11,2)));
		al.add(arr[10]);
		hmap.put(11,arr[10]);
		arr[11] = Math.sqrt((Math.pow(xb-x12,2)+Math.pow(yb-y12,2)));
		al.add(arr[11]);
		hmap.put(12,arr[11]);
		arr[12] = Math.sqrt((Math.pow(xb-x13,2)+Math.pow(yb-y13,2)));
		al.add(arr[12]);
		hmap.put(13,arr[12]);
		arr[13] = Math.sqrt((Math.pow(xb-x14,2)+Math.pow(yb-y14,2)));
		al.add(arr[13]);
		hmap.put(14,arr[13]);
		arr[14] = Math.sqrt((Math.pow(xb-x15,2)+Math.pow(yb-y15,2)));
		al.add(arr[14]);
		hmap.put(15,arr[14]);
		arr[15] = Math.sqrt((Math.pow(xb-x16,2)+Math.pow(yb-y16,2)));
		al.add(arr[15]);
		hmap.put(16,arr[15]);
		arr[16] = Math.sqrt((Math.pow(xb-x17,2)+Math.pow(yb-y17,2)));
		al.add(arr[16]);
		hmap.put(17,arr[16]);
		arr[17] = Math.sqrt((Math.pow(xb-x18,2)+Math.pow(yb-y18,2)));
		al.add(arr[17]);
		hmap.put(18,arr[17]);
		arr[18] = Math.sqrt((Math.pow(xb-x19,2)+Math.pow(yb-y19,2)));
		al.add(arr[18]);
		hmap.put(19,arr[18]);
		arr[19] = Math.sqrt((Math.pow(xb-x20,2)+Math.pow(yb-y20,2)));
		al.add(arr[19]);
		hmap.put(20,arr[19]);
		
		Arrays.sort(arr);
		
		int player=0;
		
		boolean ok_get_it = true;
		
		for(int i=0;i<20;i++){  //i make a mistake here i should loop through the whole array
			if(arr[0]==al.get(i)&&ok_get_it){
				player = i+1;
				firstPlayer=player;
				ok_get_it=false;
			}
			if(arr[1]==al.get(i)){
				
				secondNearestPlayer = i+1;
				
			}
			
			
		}
		
		if(arr[0]==0){
			return player;
		}else{
			return 0;
		}
		
		
		
		
		//System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
		
	}
	public void setNewPosition(int xo, int yo){
		if(xo<xb){
			x = xo+1;
		}else{
			x = xo-1;
		}
		if(yo<yb){
			y = yo+1;
		}
		else{
			y = yo-1;
		}
	}
	public void runForGoal(int xo,int yo,int team){
		if(team==1){
			if(yo<=560){
				if(xo<xgB){
					xx = xo+1;
				}else{
					//
					xx = xo-1;
				}
				if(yo<ygB){
					yy = yo+3;
				}else{
					yy = yo-2;
				}
				xb=xx;
				yb=yy;
			}else{
				takeGoalShot(1);
			}
		}
		else if(team==2){
			if(yo>=65){
			if(xo<xgA){
				xx = xo+1;
			}else{
				//
				xx = xo-1;
			}
			if(yo<ygA){
				yy = yo+1;
			}else{
				yy=yo-1;
			}
			xb=xx;
			yb=yy;
		}else{
			takeGoalShot(2);
		}
		}
		
		
		
		
	}
	
	public void takeGoalShot(int team){
		
		if(team==1){
			xb=279;
			yb=600;
			
			// paintComponent(dbg);
			paintGoalShot(dbg);
			
			
			
			goalno1++;
			
			xb=282;
			yb=307;
			
			x1=70;
			y1=120;
			x2=190;
			y2=130;
			x3=330;
			y3=130;
			x4=450;
			y4=130;
			x5=108;
			y5=230;
			x6=240;
			y6=230;
			x7=335;
			y7=230;
			x8=425;
			y8=230;
			x9=240;
			y9=300;
			x10=310;
			y10=300;
			x11=213;
			y11=324;
			x12=336;
			y12=324;
			x13=111;
			y13=410;
			x14=223;
			y14=412;
			x15=394;
			y15=410;
			x16=493;
			y16=412;
			x17=97;
			y17=498;
			x18=260;
			y18=500;
			x19=335;
			y19=499;
			x20=444;
			y20=506;
			
			goalHappen = true;
		}
		
		else if(team==2){
			xb=279;
			yb=45;
			
			// paintComponent(dbg);
			paintGoalShot(dbg);
			
			
			
			goalno2++;
			
			xb=282;
			yb=307;
			
			x1=70;
			y1=120;
			x2=190;
			y2=130;
			x3=330;
			y3=130;
			x4=450;
			y4=130;
			x5=108;
			y5=230;
			x6=240;
			y6=230;
			x7=335;
			y7=230;
			x8=425;
			y8=230;
			x9=240;
			y9=300;
			x10=310;
			y10=300;
			x11=213;
			y11=324;
			x12=336;
			y12=324;
			x13=111;
			y13=410;
			x14=223;
			y14=412;
			x15=394;
			y15=410;
			x16=493;
			y16=412;
			x17=97;
			y17=498;
			x18=260;
			y18=500;
			x19=335;
			y19=499;
			x20=444;
			y20=506;
			goalHappen = true;
		}
		
		
	}
	
	public int crowdy(int playerno,int team){
		
		Random rn = new Random();
		
		
		if(playerno<11 && team==1){
			for(int i=1;i<11;i++){
				if(arr[0]==hmap.get(i) && playerno!=i){
					int rnd = rn.nextInt(20);
					return rnd+1;
				}
			}
		}else if(playerno>10 && team==2){
			for(int i=11;i<21;i++){
				if(arr[0]==hmap.get(i) && playerno!=i){
					int rnd = rn.nextInt(20);
					return rnd+1;
				}
			}
		}
		return 0;
	}
	
	public void run(){
		try{
			
			goalHappen=false;
			
			//secondNearestPlayer = 0;
			
			Random ran = new Random();
			long start = System.currentTimeMillis();
			long end = start + 2*100;
			//boolean haveBall = false;
			
			//just for test
			//System.out.println(leastDistance());
			
			int take=0;
			
			
			while(System.currentTimeMillis()<end){
				
				//well i have make it wrong .. so lets correct 
				//player should reach the ball 
				//the ball will not come to him automatically 
				
				int haveBall = leastDistance();
				
				take=haveBall;
				

				//player1A
				if(haveBall==1){
					runForGoal(x1,y1,1);
					if(!goalHappen){
						x1 = xx;
						y1 = yy;	
					}
					
					
				}else{
					setNewPosition(x1,y1);
					x1 = x;
					y1 = y;
				
					//int fix = crowdy(haveBall,1);
					
					//x1 = x-fix;
					//y1 = y+fix;
				}
				
				Thread.sleep(1);
				
				//player2A
	            if(haveBall==2){
	            	runForGoal(x2,y2,1);
	            	if(!goalHappen){
	            		x2 = xx;
						y2 = yy;	
					}
					
					
				}else{
					setNewPosition(x2,y2);
					
					
					x2 = x;
					y2 = y;
					
					
				}
				
	            Thread.sleep(1);
				//player3A
	            if(haveBall==3){
	            	runForGoal(x3,y3,1);
                   if(!goalHappen){
                	x3 = xx;
   					y3 = yy;
					}
					
				}else{
					setNewPosition(x3,y3);
					
					
					x3 = x;
					y3 = y;
				}
				
	            Thread.sleep(1);
	            
				//player4A
	            if(haveBall==4){
	            	runForGoal(x4,y4,1);
	            	if(!goalHappen){
	            		x4 = xx;
						y4 = yy;
					}  
					
				}else{
					setNewPosition(x4,y4);
					
                   
					x4 = x;
					y4 = y;
				}
	            //player5A
	            Thread.sleep(1);
	          //player5A
				if(haveBall==5){
					runForGoal(x5,y5,1);
					if(!goalHappen){
						x5 = xx;
						y5 = yy;	
					}
					
					
				}else{
					setNewPosition(x5,y5);
					
					x5 = x;
					y5 = y;
				}
				
				Thread.sleep(1);
				
				//player6A
	            if(haveBall==6){
	            	runForGoal(x6,y6,1);
	            	if(!goalHappen){
	            		x6 = xx;
						y6 = yy;	
					}
					
					
				}else{
					setNewPosition(x6,y6);
					
					
					x6 = x;
					y6 = y;
				}
				
	            Thread.sleep(1);
				//player7A
	            if(haveBall==7){
	            	runForGoal(x7,y7,1);
                   if(!goalHappen){
                	x7 = xx;
   					y7 = yy;
					}
					
				}else{
					setNewPosition(x7,y7);
					
					x7 = x;
					y7 = y;
				}
				
	            Thread.sleep(1);
	            
				//player8A
	            if(haveBall==8){
	            	runForGoal(x8,y8,1);
	            	if(!goalHappen){
	            		x8 = xx;
						y8 = yy;
					}  
					
				}else{
					setNewPosition(x8,y8);
					
					x8 = x;
					y8 = y;
				}

	            Thread.sleep(1);
	            //player 9A
	            if(haveBall==9){
	            	runForGoal(x9,y9,1);
	            	if(!goalHappen){
	            		x9 = xx;
						y9 = yy;
					}  
					
				}else{
					setNewPosition(x9,y9);
					
					x9 = x;
					y9 = y;
				}
	            Thread.sleep(1);
	            //player 10A
	            if(haveBall==10){
	            	runForGoal(x10,y10,1);
	            	if(!goalHappen){
	            		x10 = xx;
						y10 = yy;
					}  
					
				}else{
					setNewPosition(x10,y10);
					
					x10 = x;
					y10 = y;
				}
	            
	           // xb=xx;
	    		//yb=yy;
	            
	            
	          //player 11B
	            Thread.sleep(1);
	            //*******to be reconstruct again haveBall part*****//
	            
	            if(haveBall==11){
	            	runForGoal(x11,y11,2);
	            	if(!goalHappen){
	            		x11 = xx;
						y11 = yy;
					}  
					
				}else{
					setNewPosition(x11,y11);
					x11 = x;
					y11 = y;
				}
	            
	            //player 12B
	            Thread.sleep(1);
	            
	            if(haveBall==12){
	            	runForGoal(x12,y12,2);
	            	if(!goalHappen){
	            		x12 = xx;
						y12 = yy;
					}  
					
				}else{
					setNewPosition(x12,y12);
					x12 = x;
					y12 = y;
				}
	            Thread.sleep(1);
	            
	          //player 13A
	            if(haveBall==13){
	            	runForGoal(x13,y13,2);
                   if(!goalHappen){
                	x13 = xx;
   					y13 = yy;
					}
					
				}else{
					setNewPosition(x13,y13);
					x13 = x;
					y13 = y;
				}
				
	            Thread.sleep(1);
	            
				//player 14A
	            if(haveBall==14){
	            	runForGoal(x14,y14,2);
	            	if(!goalHappen){
	            		x14 = xx;
						y14 = yy;
					}  
					
				}else{
					setNewPosition(x14,y14);
					x14 = x;
					y14 = y;
				}
	            //player 15A
	            Thread.sleep(1);
	          
				if(haveBall==15){
					runForGoal(x15,y15,2);
					if(!goalHappen){
						x15 = xx;
						y15 = yy;	
					}
					
					
				}else{
					setNewPosition(x15,y15);
					x15 = x;
					y15 = y;
				}
				
				Thread.sleep(1);
				
				//player 16A
	            if(haveBall==16){
	            	runForGoal(x16,y16,2);
	            	if(!goalHappen){
	            		x16 = xx;
						y16 = yy;	
					}
					
					
				}else{
					setNewPosition(x16,y16);
					
					x16 = x;
					y16 = y;
				}
				
	            Thread.sleep(1);
				//player 17A
	            if(haveBall==17){
	            	runForGoal(x17,y17,2);
                   if(!goalHappen){
                	x17 = xx;
   					y17 = yy;
   					if(y17<320) y17= 325; //put restriction on movement
					}
					
				}else{
					setNewPosition(x17,y17); 
					x17 = x;
					y17 = y;
					if(y17<320) y17= 325; //put restriction on movement
				}
				
	            Thread.sleep(1);
	            
				//player 18A
	            if(haveBall==18){
	            	runForGoal(x18,y18,2);
	            	if(!goalHappen){
	            		x18 = xx;
						y18 = yy;
						if(y18<320) y18= 325; //put restriction on movement
					}  
					
				}else{
					setNewPosition(x18,y18);
					x18 = x;
					y18 = y;
					if(y18<320) y18= 325; //put restriction on movement
				}
	            Thread.sleep(1);
	            //player 19A
	            if(haveBall==19){
	            	runForGoal(x19,y19,2);
	            	if(!goalHappen){
	            		x19 = xx;
						y19 = yy;
						if(y19<320) y19= 325; //put restriction on movement
					}  
					
				}else{
					setNewPosition(x19,y19);
					x19 = x;
					y19 = y;
					if(y19<320) y19= 325; //put restriction on movement
				}
	            Thread.sleep(1);
	            //player 20A
	            if(haveBall==20){
	            	runForGoal(x20,y20,2);
	            	if(!goalHappen){
	            		x20 = xx;
						y20 = yy;
						if(y20<320) y20= 325; //put restriction on movement
					}  
					
				}else{
					setNewPosition(x20,y20);
					x20 = x;
					y20 = y;
					if(y20<320) y20= 325; //put restriction on movement
				}
	            
	            
				
	            Thread.sleep(1);
				//repaint();
				paintRecent(dbg);
				
			}
			if(take>0){
				takeshot();
			}
			
			repaint();
			//paintRecent(dbg);
			secondNearestPlayer = 0;
			
			hmap.clear();
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			}
	}
	

	public static void main(String[] args) {
		new Football();
		Thread t1 = new Thread();
		t1.start();

	}

}
