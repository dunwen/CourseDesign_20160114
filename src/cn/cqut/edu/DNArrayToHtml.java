package cn.cqut.edu;

public class DNArrayToHtml {
	private static final int ITEM_HEIGHT = 20;
	private static String color = "#bcbcbc";
	
	public static String toHtml(Item[][] items,String DNA1,String DNA2){
		StringBuilder sb = new StringBuilder();
		int tableHeight = items.length*ITEM_HEIGHT;
		
		sb.append("<table id = 'table' class = 'table table-border' style='height: "+tableHeight+"px;width: "+tableHeight+"px'>");
		int itemRowLength = items.length + 1;
		int itemColLength = items[0].length + 1;
		
		for(int row = 0 ; row < itemRowLength; row ++){
			sb.append("<tr>");
			for(int col  = 0 ; col < itemColLength ; col++){
				if(row == 0){
					if(col == 0||col==1){
						sb.append("<td style='height:"+ITEM_HEIGHT+"px;width:"+ITEM_HEIGHT+"px' >"
								+"<td>");
						
						continue;
					}
					sb.append("<td style='height:"+ITEM_HEIGHT+"px;width:"+ITEM_HEIGHT+"px' >"
							+DNA2.substring(col-2,col-1)
							+"<td>");
					continue;
				}
				
				if(col == 0){
					if(row==0||row==1){
						sb.append("<td style='height:"+ITEM_HEIGHT+"px;width:"+ITEM_HEIGHT+"px' >"
								+"<td>");
						continue;
					}
					
					sb.append("<td style='height:"+ITEM_HEIGHT+"px;width:"+ITEM_HEIGHT+"px' >"
							+DNA1.substring(row-2,row-1)
							+"<td>");
					continue;
				}
				
				Item i = items[row-1][col-1];
				
				sb.append("<td style='background:"+(i.isUsed?color:"#ffffff")+";height:"+ITEM_HEIGHT+"px;width:"+ITEM_HEIGHT+"px' >"
						+i.left+"&nbsp"+i.top+"&nbsp"+i.both+"</br>"+"&nbsp&nbsp"+i.num
						+"<td>");
			}
			
			sb.append("</tr>");
		}
		
		
		sb.append("</table>");
		
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		
	}
	

}
