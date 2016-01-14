package cn.cqut.edu;

public class Item {
	public int left = -999;
	public int top = -999;
	public int both = -999;
	
	public boolean isUsed = false;
	
	public int num = 0;
	
	public Item(){
		
	};
	
    //获取3个数中的最大项
    public int GetMaxNum()
    {
        int max = left;
        max = top > max ? top : max;
        max = both > max ? both : max;
        return max;
    }
	
	
}
