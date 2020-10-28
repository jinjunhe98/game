
package game;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
	game.Logic logic =new Logic();
	static boolean pause;
	Timer timer;

	public void init() {
		timer=new Timer();
		logic.init();
		Time.pause=false;
	}

	public void timer(UI mainUI) {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(!Time.pause) {
					logic.update();
					mainUI.update(mainUI);
				}
			}
		}, 100, 600);
	}

	public void stop(UI mainUI) {
		timer.cancel();
		logic.init();
		mainUI.update(mainUI);
		timer=new Timer();
	}

	public void setmap(int col,int row,int value) {
		logic.setmap(col, row, value);
	}
	public int[][] getmapvalue(){
		return logic.getmapvalue();
	}
	public void randommap(){
		logic.randommap();
	}
}