package wuziqi;
import java.io.*;

public class wuziqi {
	char[][] qp =new char[17][17];//棋盘变量
	static char[] bu =new char[5];//坐标及玩家号码变量
	//创建棋盘
	void csh_qp(){
		int i,j;
		qp[0][0]=' ';
		for(i=1;i<17;i++){
			qp[0][i]=(char) ('a'+i-1);//输出列坐标
		}
		for(i=1;i<17;i++){
			qp[i][0]=(char) ('a'+i-1);//输出行坐标
		}
		for(i=1;i<17;i++){
			for(j=1;j<17;j++){
				qp[i][j]='+';//输出棋盘，即‘+’号	
			}	
		}
	}
	//输出棋盘
	void sc_qp(){
		int i,j;
		System.out.println("五子棋棋盘");	
		for(i=0;i<17;i++){
			for(j=0;j<17;j++){
				System.out.print(qp[i][j] + " ");	
			}
			System.out.println();	
		}
	}
	//决定玩家顺序
	void select_player_qp(){
		if(bu[0]=='1'){
			System.out.println("请黑方落子");
			bu[0]='2';
		}
		else
		{
			System.out.println("请白方落子");
			bu[0]='1';
		}
	}
	//从键盘读取坐标
	void zb_qp() throws IOException{
		int i=0;
		System.out.println("请输入棋子坐标（黑方：#，白方：&）：");
		for (i=1;i<5;i++){
			bu[i] = (char) System.in.read();
		}
		System.out.println("输入游戏者及坐标为：");
		if(bu[0]=='1'){
			System.out.print("白方：&,");
		}
		else{
			System.out.print("黑方：#,");
		}
		for (i=1;i<3;i++){
			System.out.print(bu[i]);
		}
		System.out.println();
	}
	//坐标有效,落子
	void luoz_qp(){
		int hang,lie,player;
		hang=(int) bu[1];lie=(int) bu[2];
		player=(int) bu[0];
		if (player==49){
			qp[hang-96][lie-96]='&';
		}
		else if(player==50){
			qp[hang-96][lie-96]='#';
		}
	}
	//判断当前落子是否有效
	boolean pdlz_qp(){
		int hang,lie;
		hang=(int) bu[1];
		hang=hang-96;
		lie=(int) bu[2];
		lie=lie-96;
		if(hang>17 || lie >17){
			System.out.println("坐标越界，请重新落子");
			return true;
		}
		else if(qp[hang][lie]=='+')			
			return false;
		else{
			System.out.println("此位置已有棋子，请重新落子");
			return true;
		}
	}
	//判断输赢
	boolean pd_qp(){
		int win = 0;
		int i,hang,lie;
		char qz='+';
		char winplayer='黑';
		hang=(int) bu[1];
		hang=hang-96;
		lie=(int) bu[2];
		lie=lie-96;
		if (bu[0]=='1'){
			qz='&';
			winplayer='白';
		}
		else{
			qz='#';
			winplayer='黑';
		}
		{
			//向上数5个棋子
			for(i=0;i<5;i++){
				if(hang==0)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				hang=hang-1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
			//向下数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=win-1;
			
			for(i=0;i<5;i++){
				if(hang==0)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				hang=hang+1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
			//向左数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=0;
			
			for(i=0;i<5;i++){
				if(lie==0)//
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie-1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}	
			//向右数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=win-1;
			
			for(i=0;i<5;i++){
				if(lie==18)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie+1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
			//向左上数5个棋子
			win=0;
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			
			for(i=0;i<5;i++){
				if(lie==0 || hang==0)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie-1;
				hang=hang-1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
			//向右下数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=win-1;
			
			for(i=0;i<5;i++){
				if(lie==18 || hang==18)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie+1;
				hang=hang+1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}	
			//向右上数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=0;
			
			for(i=0;i<5;i++){
				if(lie==18 || hang==0)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie+1;
				hang=hang-1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
			//向左下数5个棋子
			hang=(int) bu[1];
			hang=hang-96;
			lie=(int) bu[2];
			lie=lie-96;
			win=win-1;
			
			for(i=0;i<5;i++){
				if(lie==0 || hang==18)
					break;
				else{
					if (qp[hang][lie]==qz)
						win=win+1;
				}
				lie=lie-1;
				hang=hang+1;
			}
			if (win>=5){
				System.out.println(winplayer+"方玩家获胜 ");
				return true;
			}
		}
		return false;
	}
	//主方法
	public static void main(String[] args) throws IOException {
		wuziqi s = new wuziqi();
		s.csh_qp();//创建棋盘
		s.sc_qp();//输出棋盘
		bu[0]='1';
		while(true){			
			s.select_player_qp();//决定玩家顺序
			s.zb_qp();//从键盘读取坐标
			//判断当前落子是否有效,pdlz_qp()返回true则落子无效
			if (s.pdlz_qp()){
				if(bu[0]=='1')
					bu[0]='2';//玩家选择项，恢复当前未落子成功的玩家
				else
					bu[0]='1';
				continue;//当前落子无效，跳过后面的语句，跳到下一次循环
			}
			s.luoz_qp();//坐标有效,落子
			s.sc_qp();//输出落子后的棋盘
			//判断输赢，pd_qp()返回 true，则已有玩家达成五子，游戏结束
			if (s.pd_qp()){
				System.out.println("游戏结束，即将退出");
				break;//结束程序
			}
			System.out.println("---------------------------------");
		}		
	}
}