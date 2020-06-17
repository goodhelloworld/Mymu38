package com.my.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

public class Myutil {
	public static void main(String[] args) {
		//down2();
	//	down1();
		
		//http://www.xiaoyeyi.com.cn/Static/Home/RadioJS/?Play=http://mp3.qiaomeigift.com/【新】乖妈妈的小骚逼第二部/乖妈妈的小骚逼第二部46.mp3
		List<String>mystr = new ArrayList<String>();
			mystr.add("\r\n" + 
					"https://cdn-2-dx.cdnpan.com/hls/2018/09/20/ELxuciDw/out000.ts");
			mystr.add("https://cdn-2-dx.cdnpan.com/hls/2018/09/20/ELxuciDw/out002.ts");
			
			 mydown(mystr);
			//mystr.add("http://www.xiaoyeyi.com.cn/Static/Home/RadioJS/?Play=http://mp3.qiaomeigift.com/%E3%80%90%E6%96%B0%E3%80%91%E4%B9%96%E5%A6%88%E5%A6%88%E7%9A%84%E5%B0%8F%E9%AA%9A%E9%80%BC%E7%AC%AC%E4%BA%8C%E9%83%A8/%E4%B9%96%E5%A6%88%E5%A6%88%E7%9A%84%E5%B0%8F%E9%AA%9A%E9%80%BC%E7%AC%AC%E4%BA%8C%E9%83%A81.mp3");
			//downFile(mystr,"mp3");
			
	}
	
	
	public static void down2() {
		  try {
			 
			 
			List<String>mm= new ArrayList<String>();
			 System.out.println("oo---"+mm.size());
			 for(int i=41;i<100;i++) {
				 String str="https://2.ddyunbo.com/20200211/TsbHEeR0/600kb/hls/"+i+".ts";
				 System.out.println(str);
				 mm.add(str);
			 }
			 
			 
			 mydown(mm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	
	
	
	
	
  public static void down1() {
	  try {
		//Document doc = Jsoup.connect("https://dadi-bo.com/ppvod/04B27776DBFAC9D1016A66DB86F34862.m3u8").get();
		 
		// String imageSrc = "https://cdn-shenma-iqiyi.com/20190905/sMPZAed0/index.m3u8";
	      //  Connection.Response response = Jsoup.connect(imageSrc).ignoreContentType(true).execute();
		// System.out.println(response.body().toString());
			/*
			 * BufferedInputStream br= response.bodyStream(); int t=0; byte[] bt = new
			 * byte[1024]; while((t=br.read(bt))!=-1) { String chunk = new String(bt, 0,
			 * bt.length); System.out.println("----"+chunk); }
			 */
		/// saveFile(response.bodyStream(),"C:\\Users\\huawei\\Desktop\\aa.m3u8");
		 
		 
		 
		List<String>mm= readFile("C:\\Users\\huawei\\Desktop\\index (1).m3u8");
		 System.out.println("oo---"+mm.size());
		 mydown(mm);
	} catch (IOException e) {
		e.printStackTrace();
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
  
  
  
  public static List<String> readFile(String savePath) throws IOException {
     List<String>st = new ArrayList<String>();
     
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
      
     return st;
  }
  
  // wode  
   // https://2.ddyunbo.com/20200211/TsbHEeR0/600kb/hls//20200211/TsbHEeR0/600kb/hls/khu71325000.ts
    	
    	//https://2.ddyunbo.com/20200211/TsbHEeR0/600kb/hls/khu71325120.ts
    	

  		//https://2.ddyunbo.com/20200211/TsbHEeR0/600kb/hls/khu71325059.ts
	 
  			///https://2.ddyunbo.com/20200211/TsbHEeR0/600kb/hls//20200211/TsbHEeR0/600kb/hls/khu71325002.ts
		  //
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
  
  //
  public static void downFile(List<String>str,String FileType) {
	  for(int i=0;i<str.size();i++) {
		    try {
				Connection.Response response = Jsoup.connect(str.get(i)).ignoreContentType(true).execute();
				saveFile(response.bodyStream(),"C:\\Users\\huawei\\Desktop\\dd\\乖妈妈的小骚逼第二部"+i+".mp3");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
  }
  
  public static void OkDown(String url,String savePath) {
	  BufferedInputStream  bufferedInputStream=null ;
	  try {
			Connection.Response response = Jsoup.connect(url).data("Cookie","Hm_lvt_a06d25719c10d236960bace1a38a9ae8=1584617415; Hm_lpvt_a06d25719c10d236960bace1a38a9ae8=1584617415").execute();
			 //一次最多读取1k
			bufferedInputStream=response.bodyStream();
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
}
