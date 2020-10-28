package game;

public class Logic {
	public Map map =new Map();

	public void init() {
		map.initmap();
	}

	public void update() {
		final Map map1=new Map();
		map1.initmap();
		for(int i = 0; i< Map.x; i++) {
			for(int j = 0; j< Map.y; j++) {
				if(map.getneighbor(i, j)>3|| map.getneighbor(i, j)<2) {
					map1.set(i, j, 0);
				}
				else if(map.getneighbor(i, j)==3) {
					map1.set(i, j, 1);
				}
				else if(map.getneighbor(i, j)==2) {
					map1.set(i, j, map.get(i, j));
				}
			}
		}
		//map.set_map_value(temp_map.get_map_value());
		map =map1;
	}

	public void setmap(final int col,final int row,final int value) {
		map.set(col, row, value);
	}

	public int getmap(final int col,final int row){
		return map.get(col,row);
	}

	public int[][] getmapvalue(){ return map.getmapvalue(); }


	//生成随机地图
	public void randommap(){
		for(int i = 0; i< Map.x; i++){
			for(int j = 0; j< Map.y; j++){
				map.set(i,j,(int)(Math.random()*2));
			}
		}
	}
}
