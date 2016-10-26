/* Emre BOZKURT */

import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {

	private static TreeMap<String, Integer> treeMap = new TreeMap<>();

	public static void main (String[] args) {
		try {
			analyze(args);
		} catch (Exception e) {
			System.out.println("Tekrar çalıştır");
		}
		
		System.out.print("sen => ");
		System.out.println(treeMap.get("sen").intValue());
		
		System.out.print("aşk => ");
		System.out.println(treeMap.get("aşk").intValue());
		
		System.out.print("bütün => ");
		System.out.println(treeMap.get("bütün").intValue());
		
	}

	public static void analyze (String[] files) throws Exception{
		for (int i = 0; i < files.length; i++) {
			
			Scanner scan = new Scanner(new FileReader(files[i]));
			int lineNo = 0;
			
			while(scan.hasNextLine()){
				lineNo++;
				
				String[] line = scan.nextLine().toLowerCase().replaceAll("[^a-zğüşöçı ]", "").split("\\s+");
				
				for(int j=0; j<line.length; j++){
					if(treeMap.containsKey(line[j]))
						treeMap.put(line[j], new Integer(treeMap.get(line[j]).intValue()+1));
					else
						treeMap.put(line[j], new Integer(1));
				}
			}
		}
	}
}
