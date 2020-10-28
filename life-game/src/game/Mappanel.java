package game;

import javax.swing.JPanel;
import java.awt.*;

public class Mappanel extends JPanel {
	/**
	 *
	 */
	Graphics g;
	private static final long serialVersionUID = 1L;
	int width,height,x,y;
	int [][]new_map;

	Mappanel(int w,int h,int map[][]){
		setSize(width=w,height=h);
		x= Map.x;
		y= Map.y;
		new_map=map;
	}

	public void paint(Graphics g) {
		super.paint(g);

		//����
		g.setColor(Color.gray);
		width=this.getSize().width;
		height=this.getSize().height;
		int rowHt=height/y;
		int rowWid=width/x;
		for(int i=0;i<=y;i++) {
			g.drawLine(0,i*rowHt,width,i*rowHt);
			if(i==y) {
				g.drawLine(0,i*rowHt-1,width,i*rowHt-1);
			}
		}
		for(int i=0;i<=x;i++) {
			g.drawLine(i*rowWid,0,i*rowWid,height);
			if(i==x) {
				g.drawLine(i*rowWid-1,0,i*rowWid-1,height);
			}
		}

		//��map
		g.setColor(Color.black);
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(new_map[i][j]==1) {
					g.fillRect(rowWid*i, rowHt*j, rowWid, rowHt);
				}
			}
		}

	}
}
