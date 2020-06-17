package com.my.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class MuCombine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// List<String> lst = readFile("C:\\Users\\huawei\\Desktop\\kk.txt");//�൱��mu38�ļ�
		// mydown(lst);//��ts�ļ����ص�����
		//test(102) ;//ts�ļ�����
		
		//����2
		test2(1);
		//����2 end 
	}

	//
	public   static  List<String> bendits(int t) {
	     List<String>st = new ArrayList<String>();

		for(int i=0;i<t;i++) {
			st.add("C:\\Users\\huawei\\Desktop\\kk\\"+i+".ts");
		}
		return st;
	}
	
	public static void test2(int t) {
		 FileInputStream fs = null;
		 List<byte[]> btlist  = new ArrayList<byte[]>();
		 try {
			for(int i=0;i<t;i++) {
				File f = new File("C:\\Users\\huawei\\Desktop\\kk\\"+i+".ts");
				fs = new FileInputStream(f);
				ByteBuffer br = ByteBuffer.allocate((int)f.length());
				FileChannel fch  = fs.getChannel();
				 while ((fch.read(br)) > 0) {
		                // do nothing
		                // System.out.println("reading");
		           }
				byte[] ok1= br.array();
				System.out.println("a---"+ok1);
				btlist.add(ok1);
			}
			
			
			 CreatMap4( btlist);
		}catch(Exception e) {}
	}
	
	
	
	
	//��ȡ����mu38�ļ�����ȡ����ts��ַ
	public static List<String> readFile(String savePath) {
	     List<String>st = new ArrayList<String>();
	     
		  try {
			FileReader fileReader = new FileReader(savePath);

			  BufferedReader bufferedReader = new BufferedReader(fileReader);

			  String line =bufferedReader.readLine();

			  while (line!=null){
			      System.out.println(line);
			      line = bufferedReader.readLine();
			      System.out.println("ddd---"+line);
			      if(null!=line) {
			    	  if(line.endsWith(".ts")) {
			        	  st.add(line);
			          }
			      }
			      

			  }
			  bufferedReader.close();
			  fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	     return st;
	  }
	
	//����ts
	
	 public static void mydown(List<String>mystr) {
		  for(int i=0;i<mystr.size();i++) {
			    try {
					//String imageSrc = "https://2.ddyunbo.com/"+mystr.get(i);
					Connection.Response response = Jsoup.connect(mystr.get(i)).ignoreContentType(true).execute();
					saveFile(response.bodyStream(),"C:\\Users\\huawei\\Desktop\\dd\\"+i+".ts");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
	  }
	 public static void saveFile(BufferedInputStream bufferedInputStream,String savePath) throws IOException {
	      //һ������ȡ1k
	      byte[] buffer = new byte[1024];
	      //ʵ�ʶ�ȡ�ĳ���
	      int readLenghth;
	      //�����ļ������ַ�������ļ������
	      FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
	      //������һ��д���Ļ�����
	      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
	      //�ļ���д�뱾��
	      while ((readLenghth = bufferedInputStream.read(buffer,0,1024)) != -1){//�ȶ�������������buffer������
	          System.out.println(readLenghth);
	          bufferedOutputStream.write(buffer,0,readLenghth);//�ٴ�buffer��ȡ�������浽����
	      }
	      bufferedOutputStream.flush();
	      //�رջ�����
	      bufferedOutputStream.close();
	      fileOutputStream.close();
	      bufferedInputStream.close();
	  }
	  
	
	//���ļ�
	public static void test(int t) {
		 FileInputStream fs = null;
		 List<byte[]> btlist  = new ArrayList<byte[]>();
		 try {
			for(int i=0;i<t;i++) {
				File f = new File("C:\\Users\\huawei\\Desktop\\dd\\"+i+".ts");
				fs = new FileInputStream(f);
				ByteBuffer br = ByteBuffer.allocate((int)f.length());
				FileChannel fch  = fs.getChannel();
				 while ((fch.read(br)) > 0) {
		                // do nothing
		                // System.out.println("reading");
		           }
				byte[] ok1= br.array();
				System.out.println("a---"+ok1);
				btlist.add(ok1);
			}
			
			
			 CreatMap4( btlist);
		}catch(Exception e) {}
	}
	
	//�����ļ�
	public  static void CreatMap4(List<byte[]> btlist) {
		FileOutputStream fos=null;
		try {
			fos = new FileOutputStream("C:\\Users\\huawei\\Desktop\\kk\\test.mp4");
			for(int i=0;i<btlist.size();i++) {
				fos.write(btlist.get(i), 0, btlist.get(i).length);
			}
			fos.flush();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
