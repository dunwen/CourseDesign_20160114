package cn.cqut.edu;

public class Chessboard {
	int size = -1;
	int[][] board;
	int k = -1;
	int SpecialChessX;
	int SpecialChessY;
	
	/**
	 * @param k 
	 * @param specialChessX �������Ӻ�����
	 * @param spencilChessY ��������������
	 * @throws Exception 
	 * */
	public Chessboard(int k, int specialChessX, int specialChessY) throws Exception {
		this.k = k;
		SpecialChessX = specialChessX;
		SpecialChessY = specialChessY;
		
		if(k <=0){
				throw new Exception("k must be >= 0\n");
		}
		size = (int) Math.pow(2,k);
		if(specialChessX>=size||specialChessY>=size){
				throw new Exception("the row or col must be < size current size is >>"+size);
		}
		board = new int[size][size];
	
		putchess(0,0,specialChessX,specialChessY,size);
		
		
	}
	
	
	public int[][] getBoard() {
		return board;
	}




	public void setBoard(int[][] board) {
		this.board = board;
	}




	/**
	 * ��������������̵�����
	 *    	 Y
	 *     
	 *  X   1 | 2
	 *      ���� ����
	 *      3 | 4
	 * 
	 * */
	private int getSpecialQuadrant(int specialChessXInCurrent,int specialChessYInCurrent,int divideX,int divideY){
		if(specialChessXInCurrent<divideX&&specialChessYInCurrent<divideY){
			return 1;
		}
		if(specialChessXInCurrent<divideX&&specialChessYInCurrent>=divideY){
			return 2;
		}
		if(specialChessXInCurrent>=divideX&&specialChessYInCurrent<divideY){
			return 3;
		}
		if(specialChessXInCurrent>=divideX&&specialChessYInCurrent>=divideY)
			return 4;
		return 0;
	}
	
	private int chressI = 0;
	private int time = 0;
	private void putchess(int leftCornerX, int leftCornerY, int specialChessXInCurrent, int specialChessYInCurrent,
			int sizeInCurrent) {
		
		//���̴�С == 1 �����ݹ�
		if(sizeInCurrent == 1){
			return;
		}
		
		int chress = ++chressI;
		int halfOfSize = sizeInCurrent / 2;
		
		if(specialChessXInCurrent < leftCornerX + halfOfSize&& specialChessYInCurrent < leftCornerY + halfOfSize){
			//����ڵ�һ���ޣ����������
			putchess(leftCornerX, leftCornerY, specialChessXInCurrent, specialChessYInCurrent, halfOfSize);
		}else{
			board[leftCornerX + halfOfSize -1][leftCornerY + halfOfSize - 1] = chress ;
//			printf();
			//���򣬰ѵڵ�ǰ���̵�һ���޵����½���Ϊ�������ӣ���������
			/*
				0 0 0 0 
				0 1 0 0 
				0 0 0 0 
				0 0 0 0 

			 * */
			putchess(leftCornerX, leftCornerY,leftCornerX+halfOfSize-1,leftCornerY+halfOfSize-1,halfOfSize);
		}
		
		if(specialChessXInCurrent < leftCornerX + halfOfSize&& specialChessYInCurrent >= leftCornerY + halfOfSize){
			//����ڵڶ����ޣ����������
			putchess(leftCornerX, leftCornerY + halfOfSize, specialChessXInCurrent, specialChessYInCurrent, halfOfSize);
		}else{
			
			/*
			0 0 0 0 
			0 0 1 0 
			0 0 0 0 
			0 0 0 0 
			 * */
			//������ڵڶ����ޣ���ɵڶ����޵����½���Ϊ�������ӣ���������
			board[leftCornerX + halfOfSize -1][leftCornerY + halfOfSize] = chress;
//			printf();
			
			putchess(leftCornerX, leftCornerY + halfOfSize , leftCornerX + halfOfSize -1,leftCornerY + halfOfSize, halfOfSize);
		}
		
		if(specialChessXInCurrent >= leftCornerX + halfOfSize&& specialChessYInCurrent < leftCornerY + halfOfSize){
			putchess(leftCornerX + halfOfSize, leftCornerY, specialChessXInCurrent, specialChessYInCurrent, halfOfSize);
		}else{
			/*
			0 0 0 0 
			0 0 0 0 
			0 1 0 0 
			0 0 0 0 
			 * */
			//������ڵ������ޣ���ɵ������޵����Ͻ���Ϊ�������ӣ���������
			board[leftCornerX + halfOfSize][leftCornerY + halfOfSize -1] = chress;
//			printf();
			putchess(leftCornerX +halfOfSize,leftCornerY,leftCornerX + halfOfSize ,leftCornerY + halfOfSize - 1, halfOfSize);
		}
		
		if(specialChessXInCurrent >= leftCornerX + halfOfSize && specialChessYInCurrent>= leftCornerY + halfOfSize){
			putchess(leftCornerX + halfOfSize, leftCornerY + halfOfSize, specialChessXInCurrent, specialChessYInCurrent, halfOfSize);
		}else{
			/*
			0 0 0 0 
			0 0 0 0 
			0 0 1 0 
			0 0 0 0 
			 * */
			//������ڵ������ޣ���ɵ������޵����Ͻ���Ϊ�������ӣ���������		
			board[leftCornerX + halfOfSize][leftCornerY + halfOfSize] = chress;
//			printf();
			putchess(leftCornerX + halfOfSize, leftCornerY + halfOfSize, leftCornerX + halfOfSize, leftCornerY + halfOfSize, halfOfSize);
		}
	}


	public void printf(){
		System.out.println(++time+"\n");
		int num = 0;
		for(int row = 0 ; row < board.length;row++){
			for(int col = 0 ; col < board[row].length;col++){
				if(board[row][col]==0) num++;
				System.out.print(board[row][col]/10==0?" "+board[row][col]:board[row][col]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(num);
	}
	
	
	
	

}
