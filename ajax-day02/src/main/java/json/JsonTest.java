package json;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bean.Stock;

public class JsonTest {
	/*
	 * 使用jackson api将java对象转化成json对象
	 */
	public static void test1() throws JsonProcessingException{
		Stock s=new Stock();
		s.setCode("600877");
		s.setName("中国嘉陵");
		s.setPrice(8);
		//jackson api
		ObjectMapper om=new ObjectMapper();
		String jsonstr=om.writeValueAsString(s);
		System.out.println(jsonstr);
	}
	public static void test2() throws JsonProcessingException{
		List<Stock> stocks=new ArrayList<Stock>();
		for(int i=0;i<3;i++){
			Stock s=new Stock();
			s.setCode("600877"+i);
			s.setName("中国嘉陵"+i);
			s.setPrice(8+i);
			stocks.add(s);
		}
		//jackson api
		ObjectMapper om=new ObjectMapper();
		String jsonstr=om.writeValueAsString(stocks);
		System.out.println(jsonstr);
	}
	public static void main(String[] args) throws JsonProcessingException {
		
		test1();
		test2();
	}
}


















