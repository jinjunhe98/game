package game;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class UI extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//���峣��
	final static int HEIGHT=600;
	//����
	final static int WIDTH=UI.HEIGHT+150;
	final static int GAMEPANELWIDTH=UI.HEIGHT;

	//�½�ʱ����
	static Time time=new Time();

	Graphics g;



	public void init() {
		time.init();

		//����mainUI
		UI mainUI=new UI();
		Container container=mainUI.getContentPane();
		mainUI.setTitle("������Ϸ");
		mainUI.setSize(WIDTH,HEIGHT+39);
		mainUI.setLocationRelativeTo(null);
		mainUI.setVisible(true);
		mainUI.setResizable(false);
		container.setLayout(null);

		//����JPanel
		mainUI.update(mainUI);
		
		//����pal�����button
		FlowLayout flow=new FlowLayout(FlowLayout.CENTER,20,100);
		JPanel pnl=new JPanel();
		pnl.setSize(WIDTH-GAMEPANELWIDTH,HEIGHT);
		pnl.setBackground(Color.white);
		pnl.setLocation(GAMEPANELWIDTH,0);
		pnl.setLayout(flow);

		//���button
		JButton btnbegin=new JButton("开始ʼ");
		JButton btnstop=new JButton("暂停");
		JButton btnpause=new JButton("继续");
		//JButton btn_random=new JButton("�������");

		//��Ӽ�����
		mainUI.addMouseListener(new GetMouse(mainUI));
		btnbegin.addActionListener(new Listener(mainUI,btnbegin,btnstop,btnpause));
		//btn_begin.addActionListener(new RandomListener(mainUI));
		btnstop.addActionListener(new Listener(mainUI,btnbegin,btnstop,btnpause));
		btnpause.addActionListener(new Listener(mainUI,btnbegin,btnstop,btnpause));

		pnl.add(btnbegin);
		pnl.add(btnpause);
		pnl.add(btnstop);
		//pnl.add(btn_random);
		btnstop.setEnabled(false);
		btnpause.setEnabled(false);
		mainUI.add(pnl);


	}


	public void paint(Graphics g) {
		super.paint(g);

		//画线
		g.setColor(Color.gray);
		width = this.getSize().width;
		height = this.getSize().height;
		int rowHt = height / y;
		int rowWid = width / x;
		for (int i = 0; i <= y; i++) {
			g.drawLine(0, i * rowHt, width, i * rowHt);
			if (i == y) {
				g.drawLine(0, i * rowHt - 1, width, i * rowHt - 1);
			}
		}
		for (int i = 0; i <= x; i++) {
			g.drawLine(i * rowWid, 0, i * rowWid, height);
			if (i == x) {
				g.drawLine(i * rowWid - 1, 0, i * rowWid - 1, height);
			}
		}
	}


	public void update(UI mainUI){
		/*
		final Mappanel newmappanel=new Mappanel(GAMEPANELWIDTH,HEIGHT,time.getmapvalue());
		newmappanel.setBackground(Color.white);
		newmappanel.setLocation(0,0);
		mainUI.add(newmappanel);
		newmappanel.repaint();

		 */
	}

	//�����Ӧ�¼�
	static class GetMouse extends MouseAdapter{
		UI mainUI;

		public GetMouse(UI mainUI){
			this.mainUI=mainUI;
		}

		public void mousePressed(MouseEvent e) {
			int rowHt=HEIGHT/ Map.x;
			int rowWid=GAMEPANELWIDTH/ Map.y;
			int row=(e.getY()-30)/rowHt;
			int col=(e.getX()-10)/rowWid;
			if(row< Map.x&&col< Map.y) {
				time.setmap(col,row,1);
				//����
				mainUI.update(mainUI);
			}

		}
	}

	class Listener implements ActionListener
	{
		UI mainUI;
		JButton btnbegin;
		JButton btnstop;
		JButton btnpause;
		public Listener(UI mainUI,JButton btnbegin,JButton btnstop,JButton btnpause) {
			this.mainUI=mainUI;
			this.btnstop=btnstop;
			this.btnbegin=btnbegin;
			this.btnpause=btnpause;
		}
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==btnbegin) {
				UI.time.timer(mainUI);
				btnbegin.setEnabled(false);
				btnstop.setEnabled(true);
				btnpause.setEnabled(true);
			}
			if(e.getSource()==btnstop){
				UI.time.stop(mainUI);
				btnpause.setText("��ͣ");
				btnbegin.setEnabled(true);
				btnstop.setEnabled(false);
				btnpause.setEnabled(false);
			}
			if(e.getSource()==btnpause){
				if(!Time.pause) {
					Time.pause=true;
					btnpause.setText("����");
				}
				else{
					Time.pause=false;
					btnpause.setText("��ͣ");
				}
			}
		}
	}

//	class RandomListener implements ActionListener
//	{
//		UI mainUI;
//		public RandomListener(UI mainUI) {
//			this.mainUI=mainUI;
//		}
//		public void actionPerformed(ActionEvent e){
//			if(!game.Time.pause){
//				time.randommap();
//
//				Map_panel new_map_panel=new Map_panel(game_panel_width,height,time.get_map_value());
//				new_map_panel.setBackground(Color.white);
//				new_map_panel.setLocation(0,0);
//				mainUI.add(new_map_panel);
//				new_map_panel.updateUI();
//				new_map_panel.repaint();
//			}
//		}
//	}
}