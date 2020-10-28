package game;


import java.util.Arrays;

public class Map {
	public static int x=30;
	public static int y=30;
	int [][]cell=new int[x][y];
	public void initmap() {
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
			{
				cell[i][j]=0;
			}

	}

	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj==this){
			return true;
		}
		if(obj instanceof Map){
			if(Arrays.deepEquals(this.cell,((Map) obj).cell)){
				return true;
			}
		}
		return false;
	}

	public void set(int row,int col,int value) {
		cell[row][col]=value;
	}

	public int get(int row,int col){
		return cell[row][col];
	}

	//x,yȡֵ��0-19
	public int getneighbor(int x,int y) {
		int count=0;
		if(x==0&&y==0)
			count=cell[x][y+1]+cell[x+1][y]+cell[x+1][y+1];
		else if(x==0&&y==Map.y-1)
			count=cell[x][y-1]+cell[x+1][y-1]+cell[x+1][y];
		else if(x==Map.x-1&&y==0)
			count=cell[x-1][y]+cell[x-1][y+1]+cell[x][y+1];
		else if(x==Map.x-1&&y==Map.y-1)
			count=cell[x-1][y-1]+cell[x-1][y]+cell[x][y-1];
		else if(x==0)
			count=cell[x][y-1]+cell[x+1][y-1]+cell[x+1][y]+cell[x+1][y+1]+cell[x][y+1];
		else if(x==Map.x-1)
			count=cell[x][y-1]+cell[x-1][y-1]+cell[x-1][y]+cell[x-1][y+1]+cell[x][y+1];
		else if(y==0)
			count=cell[x-1][y]+cell[x-1][y+1]+cell[x][y+1]+cell[x+1][y+1]+cell[x+1][y];
		else if(y==Map.y-1)
			count=cell[x-1][y]+cell[x-1][y-1]+cell[x][y-1]+cell[x+1][y-1]+cell[x+1][y];
		else
			count=cell[x-1][y-1]+cell[x-1][y]+cell[x-1][y+1]+cell[x][y-1]+cell[x][y+1]+cell[x+1][y-1]+cell[x+1][y]+cell[x+1][y+1];
		return count;
	}

	public int[][] getmapvalue(){
		return cell;
	}
	public void setmapvalue(int [][]map) {
		for(int i=0;i<x;i++)
			for(int j=0;j<y;j++)
				cell[i][j]=map[i][j];
	}

}