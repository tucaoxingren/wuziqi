package wuziqi;
import java.io.*;

public class wuziqi {
	char[][] qp =new char[17][17];//���̱���
	static char[] bu =new char[5];//���꼰��Һ������
	//��������
	void csh_qp(){
		int i,j;
		qp[0][0]=' ';
		for(i=1;i<17;i++){
			qp[0][i]=(char) ('a'+i-1);//���������
		}
		for(i=1;i<17;i++){
			qp[i][0]=(char) ('a'+i-1);//���������
		}
		for(i=1;i<17;i++){
			for(j=1;j<17;j++){
				qp[i][j]='+';//������̣�����+����	
			}	
		}
	}
	//�������
	void sc_qp(){
		int i,j;
		System.out.println("����������");	
		for(i=0;i<17;i++){
			for(j=0;j<17;j++){
				System.out.print(qp[i][j] + " ");	
			}
			System.out.println();	
		}
	}
	//�������˳��
	void select_player_qp(){
		if(bu[0]=='1'){
			System.out.println("��ڷ�����");
			bu[0]='2';
		}
		else
		{
			System.out.println("��׷�����");
			bu[0]='1';
		}
	}
	//�Ӽ��̶�ȡ����
	void zb_qp() throws IOException{
		int i=0;
		System.out.println("�������������꣨�ڷ���#���׷���&����");
		for (i=1;i<5;i++){
			bu[i] = (char) System.in.read();
		}
		System.out.println("������Ϸ�߼�����Ϊ��");
		if(bu[0]=='1'){
			System.out.print("�׷���&,");
		}
		else{
			System.out.print("�ڷ���#,");
		}
		for (i=1;i<3;i++){
			System.out.print(bu[i]);
		}
		System.out.println();
	}
	//������Ч,����
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
	//�жϵ�ǰ�����Ƿ���Ч
	boolean pdlz_qp(){
		int hang,lie;
		hang=(int) bu[1];
		hang=hang-96;
		lie=(int) bu[2];
		lie=lie-96;
		if(hang>17 || lie >17){
			System.out.println("����Խ�磬����������");
			return true;
		}
		else if(qp[hang][lie]=='+')			
			return false;
		else{
			System.out.println("��λ���������ӣ�����������");
			return true;
		}
	}
	//�ж���Ӯ
	boolean pd_qp(){
		int win = 0;
		int i,hang,lie;
		char qz='+';
		char winplayer='��';
		hang=(int) bu[1];
		hang=hang-96;
		lie=(int) bu[2];
		lie=lie-96;
		if (bu[0]=='1'){
			qz='&';
			winplayer='��';
		}
		else{
			qz='#';
			winplayer='��';
		}
		{
			//������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
			//������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
			//������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}	
			//������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
			//��������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
			//��������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}	
			//��������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
			//��������5������
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
				System.out.println(winplayer+"����һ�ʤ ");
				return true;
			}
		}
		return false;
	}
	//������
	public static void main(String[] args) throws IOException {
		wuziqi s = new wuziqi();
		s.csh_qp();//��������
		s.sc_qp();//�������
		bu[0]='1';
		while(true){			
			s.select_player_qp();//�������˳��
			s.zb_qp();//�Ӽ��̶�ȡ����
			//�жϵ�ǰ�����Ƿ���Ч,pdlz_qp()����true��������Ч
			if (s.pdlz_qp()){
				if(bu[0]=='1')
					bu[0]='2';//���ѡ����ָ���ǰδ���ӳɹ������
				else
					bu[0]='1';
				continue;//��ǰ������Ч�������������䣬������һ��ѭ��
			}
			s.luoz_qp();//������Ч,����
			s.sc_qp();//������Ӻ������
			//�ж���Ӯ��pd_qp()���� true����������Ҵ�����ӣ���Ϸ����
			if (s.pd_qp()){
				System.out.println("��Ϸ�����������˳�");
				break;//��������
			}
			System.out.println("---------------------------------");
		}		
	}
}