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
		
		// List<String> lst = readFile("C:\\Users\\huawei\\Desktop\\kk.txt");//相当于mu38文件
		// mydown(lst);//将ts文件下载到本地
		//test(102) ;//ts文件个数
		
		//类型2
		test2(1);
		//类型2 end 
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
	
	
	
	
	//读取本地mu38文件，获取其中ts地址
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
	
	//下载ts
	
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
	      //一次最多读取1k
	      byte[] buffer = new byte[1024];
	      //实际读取的长度
	      int readLenghth;
	      //根据文件保存地址，创建文件输出流
	      FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath));
	      //创建的一个写出的缓冲流
	      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
	      //文件逐步写入本地
	      while ((readLenghth = bufferedInputStream.read(buffer,0,1024)) != -1){//先读出来，保存在buffer数组中
	          System.out.println(readLenghth);
	          bufferedOutputStream.write(buffer,0,readLenghth);//再从buffer中取出来保存到本地
	      }
	      bufferedOutputStream.flush();
	      //关闭缓冲流
	      bufferedOutputStream.close();
	      fileOutputStream.close();
	      bufferedInputStream.close();
	  }
	  
	
	//将文件
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
	
	//创建文件
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
