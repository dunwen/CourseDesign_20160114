package cn.cqut.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ArrayToHtml {
	private static int widthAndHeight = 20;
	
	
	private Map<Integer,String> colorMap = new HashMap<Integer,String>();
	
	public String getRandColorCode(){
		String r,g,b;
		Random random = new Random();
		
		r= Integer.toHexString(random.nextInt(256)).toUpperCase();
		g= Integer.toHexString(random.nextInt(256)).toUpperCase();
		b= Integer.toHexString(random.nextInt(256)).toUpperCase();
		
		r = r.length()==1? "0"+ r : r;
		g = g.length()==1? "0"+ g : g;
		b = b.length()==1? "0"+ b : b;
		
		return "#"+r+g+b;
		
	}
	
	public String parse(int[][] arr){
		colorMap.put(0,"#000");
		StringBuilder sb = new StringBuilder();
		sb.append("<table id = 'table' class = 'table' style='height: " +
					arr.length*widthAndHeight+" px ;width: "+arr.length*widthAndHeight+"px'>");
		
		for(int row = 0;row<arr.length;row++){
			
			sb.append("<tr>\n");
			
			for(int col = 0 ;col<arr[row].length;col++){
				int num = arr[row][col];
				String color = colorMap.get(num);
				if(color == null){
					color = getRandColorCode();
					colorMap.put(num,color);
				}
				sb.append("<td style='background:"+color
							+";height:"+widthAndHeight+"px;"+
						"width:"+widthAndHeight+"px' >"
						);
				sb.append(num+"<td>\n");
			}
			
			sb.append("</tr>\n");
		}
		
		sb.append("\n</table>");
		
		return sb.toString();
	}

	public static void main(String[] args) {
		ArrayToHtml a = new ArrayToHtml();
//		Chessboard cb = new Chessboard(2,0,0);
		System.out.println(a.getRandColorCode());
	}
}
