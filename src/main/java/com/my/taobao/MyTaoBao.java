package com.my.taobao;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyTaoBao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show("https://s.taobao.com/search?q=%E5%8D%8E%E4%B8%BA%E6%89%8B%E6%9C%BA&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
	}
	
	
	public static void show(String url) {
		//https://s.taobao.com/search?q=华为手机&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306
		try {
			Map<String,String> mp = new HashMap<String,String>();
			mp.put("scheme", "https");
			mp.put("authority", "s.taobao.com");

			mp.put("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");

			mp.put("accept-encoding", "gzip, deflate, br");
			mp.put("cookie", "miid=282768242068298588; tk_trace=oTRxOWSBNwn9dPyorMJE%2FoPdY8zfvmw%2Fq5hp2aBvkBNyOVmvi3e4MKTTFLyDb7EybJvTa5VUvXepWRI2W9MSXvVtMxFVhN5McdwIZX4V9pxFQLPe1PNjjqz7Pol81XQMcrX0n5fK09kM0L00DnPp8DNtRHzs8vj7uqdPuVif6gbr7MMuo0t3n2Hh25GpnddiZLkQTVjMM0cmkHI2wjCsyXvy2LaNOlUDx1kxUk24bmePCd%2FHm74m6M7e0gnXzDxDYnhMhEedeNS7%2Fv5%2FiyTWX2A0BYiO; lLtC1_=1; t=cc0a672b9b585389814a07f0a8c952e5; cookie2=1168e439d79425d7f5a35d6ffb3be407; v=0; _tb_token_=f6dba3773e3eb; thw=cn; cna=oCT3Fs1H/WoCAXDgBF3VYnHI; _samesite_flag_=true; sgcookie=EKg0WV9sOgN%2BcStTsJ6Kp; unb=1972676263; uc3=nk2=CygPIKbEex6Sv8k%3D&vt3=F8dBxd9mYVcOtB9a5KY%3D&id2=UojTVuCPbm5beQ%3D%3D&lg2=W5iHLLyFOGW7aA%3D%3D; csg=84a18ac2; lgc=hello%5Cu674E%5Cu58EB%5Cu6839; cookie17=UojTVuCPbm5beQ%3D%3D; dnk=hello%5Cu674E%5Cu58EB%5Cu6839; skt=9e14c140eda1c97f; existShop=MTU4NDQxMjU4Mg%3D%3D; uc4=nk4=0%40CW%2Fq6oIVAh2Tso%2FVHQ7rgARHD7Jigg%3D%3D&id4=0%40UOBXV7J%2F8%2Fh6SUGcsMeJiglHVTo3; tracknick=hello%5Cu674E%5Cu58EB%5Cu6839; _cc_=WqG3DMC9EA%3D%3D; tg=0; _l_g_=Ug%3D%3D; sg=%E6%A0%B937; _nk_=hello%5Cu674E%5Cu58EB%5Cu6839; cookie1=AVTlYk%2FtAdd%2F4N%2BULZz6bG47g8gN%2FKf%2FzbogDco9ItA%3D; enc=AOaQx70yKaQVWwZCIkSDdn0tS7au9LCY2%2Fc82IBeKuIwDaxKZPvsE3BnnKk95GekdqBdwXD5%2F6EAsyU6VEBHyw%3D%3D; tfstk=cCPfB2aY-nxbor0X3R_r_wfrflcOZI8I5ti0l8iUr0yX50UfiDAExlzYIhCDA41..; uc1=cookie16=V32FPkk%2FxXMk5UvIbNtImtMfJQ%3D%3D&cookie21=VFC%2FuZ9aiKCaj7AzMHh1&cookie15=Vq8l%2BKCLz3%2F65A%3D%3D&existShop=false&pas=0&cookie14=UoTUPvQW%2B7sg4A%3D%3D&tag=8&lng=zh_CN; mt=ci=14_1; hng=CN%7Czh-CN%7CCNY%7C156; JSESSIONID=3B2BFC5A63DAE7B185AE8C6A39DD5E9D; isg=BMPDNgoumVq4FlUu0zKmxAcZUodtOFd6yhhQdPWgHyKZtOPWfQjnyqEmLkT6D69y; l=dB_jt20IQyrOMSetBOCanurza77OSIRYYuPzaNbMi_5Lg6T_SwbOorF_qF96VjWftiTB4082ve99-etkq3DmndK-g3fPaxDc.");

			mp.put("user-agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
			Connection cn= Jsoup.connect(url); 
			cn.headers(mp);
			Document  dc=	cn.get();
			System.out.println(dc.title());
			System.out.println(dc.select("img").size());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
