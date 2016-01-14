package cn.cqut.edu;

/**
 * 务必检查输入合法性
 * */
public class DNACounter {
	String DNA1 = "";
	String DNA2 = "";
	
	String resultDNA1 = "";
	String resultDNA2 = "";
	
	Item[][] resoure;
	
	public DNACounter(String DNA1,String DNA2) throws Exception{
		this.DNA1 = DNA1.toUpperCase();
		this.DNA2 = DNA2.toUpperCase();
		
		if(!isATCG(this.DNA1)||!isATCG(this.DNA2)){
			throw new Exception("DNA1 or DNA2 contain not ATCG");
		}
		
		resoure = new Item[DNA1.length()+1][DNA2.length()+1];
		initResoure();
		initResult();
	}
	
	
	
	public Item[][] getResoure() {
		return resoure;
	}



	private boolean isATCG(String s){
		for(int i = 0 ; i < s.length() ; i++){
			char c = s.charAt(i);
			if(c!='A'&&c!='T'&&c!='C'&&c!='G'){
				return false;
			}
		}
		return true;
	}
	

	public int getCouse(){
		int sum = 0;
		for(int i = 0;i<resultDNA1.length();i++){
			sum += GetCourse(getStringAt(resultDNA1,i),getStringAt(resultDNA2,i));
		}
		return sum;
	}
	
	
	private void initResult() {
		int row = resoure.length-1;
		int col = resoure[0].length-1;
		
		while(true){
			if(row == 0){
				for(int i = 0 ; i <col ; i ++){
					resultDNA1 = "_"+resultDNA1;
				}
				
				resultDNA2 = DNA2.substring(0,row)+resultDNA2;
				return;
			}
			
			if(col == 0){
				for(int i = 0 ; i < row ; i++){
					resultDNA2 = "_" + resultDNA2;
				}
				resultDNA1 = DNA1.substring(0,row)+resultDNA1;
				return;
			}
			
			Item i = resoure[row][col];
			i.isUsed = true;
			if(i.num == i.top){
				resultDNA1 = getStringAt(DNA1,row-1) + resultDNA1;
				resultDNA2 = "_"+ resultDNA2;
				
				resoure[row-1][col].isUsed = true;
				
				row -=1 ;
			}else if(i.num == i.left){
				resultDNA2 = getStringAt(DNA2,col-1) + resultDNA2;
				resultDNA1 = "_"+ resultDNA1;
				
				resoure[row][col-1].isUsed = true;
				
				col-=1;
			}else if(i.num == i.both){
				resultDNA1 = getStringAt(DNA1,row-1) + resultDNA1;
				resultDNA2 = getStringAt(DNA2,col-1) + resultDNA2;
				
				resoure[row-1][col-1].isUsed = true;
				
				row-=1;
				col-=1;
			}
		}
		
	}
	
	public String getResult(){
		return "DNA1:"+resultDNA1+"<br>"+"DNA2:"+resultDNA2+"<br>"+"Couse :" +getCouse();
	}

	private void initResoure() {
		resoure[0][0] = new Item();
		//初始化第一行row
		for(int i = 1 ; i<resoure[0].length;i++){
			resoure[0][i] = new Item();
			resoure[0][i].num = resoure[0][i-1].num + GetCourse(getStringAt(DNA2,i-1),"_");
		}
		
		//初始化第一列
		for(int i = 1; i<resoure.length;i++){
			resoure[i][0] = new Item();
			resoure[i][0].num = resoure[i-1][0].num + GetCourse(getStringAt(DNA1,i-1),"_");
		}
		
		//初始化中间的
		for(int row = 1 ; row < DNA1.length()+1 ;row ++){
			for(int col = 1 ; col < DNA2.length()+1 ; col++){
				resoure[row][col] = new Item();
				
				//左边的值等于当前坐标左边的值+当前上方坐标对应字母和_的分数
				resoure[row][col].left = resoure[row][col-1].num + GetCourse(getStringAt(DNA2,col-1),"_");
				resoure[row][col].top = resoure[row-1][col].num + GetCourse(getStringAt(DNA1,row-1),"_");
				resoure[row][col].both = resoure[row-1][col-1].num + GetCourse(getStringAt(DNA1,row-1),getStringAt(DNA2,col-1));
				resoure[row][col].num = resoure[row][col].GetMaxNum();
			} 
		}
	} 
	
	public void printf(){
		for(int row = 0;row<resoure.length;row++){
			for(int col = 0 ;col < resoure[0].length;col++){
				System.out.print(resoure[row][col].num+"  ");
			}
			System.out.println();
		}
	}

	
	private String getStringAt(String s , int i){
		return s.substring(i,i+1);
	}
	
    //两个单DNA（其中一个可为空格"_"）比较得到的的分数
    public int GetCourse(String DNA1, String DNA2)
    {
        if (DNA1.equals(DNA2))
            return 5;
        else if ((DNA1.equals("A") && DNA2.equals("C")) || (DNA1.equals("C") && DNA2.equals("A")))//A
            return -1;
        else if ((DNA1.equals("A") && DNA2.equals("G")) || (DNA1.equals("G") && DNA2.equals("A")))
            return -2;
        else if ((DNA1.equals("A") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("A")))
            return -1;
        else if ((DNA1.equals("A") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("A")))
            return -3;
        else if ((DNA1.equals("C") && DNA2.equals("G")) || (DNA1.equals("G") && DNA2.equals("C")))//C
            return -3;
        else if ((DNA1.equals("C") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("C")))
            return -2;
        else if ((DNA1.equals("C") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("C")))
            return -4;
        else if ((DNA1.equals("G") && DNA2.equals("T")) || (DNA1.equals("T") && DNA2.equals("G")))//G
            return -2;
        else if ((DNA1.equals("G") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("G")))
            return -2;
        else if ((DNA1.equals("T") && DNA2.equals("_")) || (DNA1.equals("_") && DNA2.equals("T")))//T
            return -1;
        
        return 0;
    }
	
}
