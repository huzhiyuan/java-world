package com.hzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

public class RandomTest {
	public static void main(String[] args) {


		List<String> ids = new ArrayList<String>();
		ids.add("a");
		ids.add("b");
		ids.add("c");
		ids.add("d");
		ids.add("e");
		List<String> exclusions = new ArrayList<String>();
//		exclusions.add("a");
//		exclusions.add("b");

		Random r = new Random();

		for (int i = 0; i < 10000; i++) {
			getRandomFromIds(r,exclusions,ids);
		}

	}
	private static String getRandomFromIds(Random r,List<String> exclusions,List<String> ids){
		if(ids==null||ids.size()==0){
			return null;
		}
		while(true){
			String randomId = ids.get(r.nextInt(ids.size()));
			if(!exclusions.contains(randomId)){
				return randomId;
			}
			if(exclusions.size()>=ids.size()){
				return null;
			}
		}
	}
}
