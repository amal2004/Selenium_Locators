package amal2004.selenium.locators;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Streams {

	public static void main(String[] args) {
		
	}
	
	//@Test
	public void regular(){
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Abhijeeth");
		nameList.add("Don");
		nameList.add("Alekhya");
		nameList.add("Adam");
		nameList.add("Ram");
		int count = 0;
		
		for (int i = 0; i < nameList.size(); i++) {
			
			String actualName = nameList.get(i);
			if(actualName.startsWith("A")) {
				count++;
			}
			
		}		
		System.out.println(count);
	
	}
	
	@Test
	public void streamFilter() {
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("Abhijeeth");
		nameList.add("Don");
		nameList.add("Alekhya");
		nameList.add("Adam");
		nameList.add("Ram");
		
		
		Long c = nameList.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		

		//long d = Stream.of("aaaa", "sssss", "ggggg", "eeeee", "asdsf").filter(s -> s.startsWith("a")).count();	
		
		// Above is similar version for this
		long d = Stream.of("Abhijeeth", "Don", "Alekhya", "Adam", "Ram").filter(s -> 
		{
			s.startsWith("A");

			return true;

		}).count();
		 
		System.out.println(d);
		
		
		// filter by name length
		nameList.stream().filter(s -> s.length()>=3).forEach(s -> System.out.println(s));
		
		// filter by name length and result size
		nameList.stream().filter(s-> s.length() > 3).limit(3).forEach(s-> System.out.println(s));
		
		

	}
	
	
	@Test
	public void StreamMap() {
		
		// Print names with last letter a in caps
		
		Stream.of("Abhijeeth", "Don", "Alekhya", "Adam", "Ram").filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
		
		//Print names with last letter a in caps and sorted
		
		List<String> names1 = Arrays.asList("Abhijeeth", "Don", "Alekhya", "Adam", "Cam","Bam", "Sam");
		names1.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).sorted().forEach(s-> System.out.println(s));
		
		// Create Stream and sort
		List<String> names2= Arrays.asList("Abhijeeth", "Don", "Alekhya", "Adam", "Cam","Bam", "Sam");
		names1.stream().filter(s->s.endsWith("m")).map(s->s.toUpperCase()).sorted().forEach(s-> System.out.println(s));
		
		
		 Stream.of("Abhijeeth", "Don", "Alekhya", "Adam", "Cam","Bam", "Sam").filter(s->s.endsWith("m"))
		.map(s->s.toUpperCase()).sorted().forEach(s-> System.out.println(s));
		
		
		// Stream Concatanation
		 Stream<String> newStream = Stream.concat(names1.stream(), names2.stream());
		 
		// newStream.sorted().forEach(s->System.out.println());
		 
		boolean flag = newStream.anyMatch(s-> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag); 
		 
		 
	}
	
	// Collect result of the stream to a list and then get 1st value
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Abhijeeth", "Don", "Alekhya", "Adam", "Cam","Bam", "Sam").filter(s->s.endsWith("m")).map(s->s.toUpperCase())
		 .collect(Collectors.toList());
		
		System.out.println(ls.get(0));
	
		
      // Getting different value in array using distinct keyword		
	  List<Integer> values=	Arrays.asList(12,11,14,15,17,12,10,12,11);
	  values.stream().distinct().forEach(s ->System.out.println(s));
	  
	  // Sort and pick the 2nd number
	  List<Integer> sortedValues = values.stream().sorted().collect(Collectors.toList());
      System.out.println(sortedValues.get(2));		
		
		
	}
	

}
