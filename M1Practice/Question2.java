package M1Practice;

import java.util.*;

class TransactionMonitor{
	public static List<String> getTopSpenders(List<List<String>> logs){
		
		Map<String, Integer> map = new HashMap<>();
		
		for(List<String>log: logs) {
			map.put(log.get(0), map.getOrDefault(log.get(0), 0)+ Integer.parseInt(log.get(1)) );		
		}
		
		List<String> result = new ArrayList<>();
		
		Integer maxAmount = 0;
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			if(value > maxAmount) {
				result.clear();
				result.add(key);
				maxAmount = value;
			}else if(value == maxAmount) {
				result.add(key);
			}
		}
		
		Collections.sort(result);
		
		return result;
		
		
	}

}

public class Question2 {
	public static void main(String[] args) {

        String[][] input = {
            {"alice","200","10:00"},
            {"bob","300","10:10"},
            {"alice","200","10:30"},
            {"charlie","400","11:00"}
        };

        List<List<String>> logs = new ArrayList<>();

        for (String[] row : input) {
            logs.add(Arrays.asList(row));
        }

        List<String> result = TransactionMonitor.getTopSpenders(logs);

        System.out.println(result);
    }
}
