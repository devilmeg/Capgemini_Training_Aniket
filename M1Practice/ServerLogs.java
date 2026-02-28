package M1Practice;
import java.util.*;

class UserActivity{
	public static List<String> getTopActiveUsers(List<List<String>> logs){
		
		Map<String, Integer> mpp = new HashMap<>();
		List<String> result = new ArrayList<>();
		
		for(List<String> log: logs) {
			if(log.get(1).equals("LOGIN")) {
				mpp.put(log.get(0), mpp.getOrDefault(log.get(0), 0)+1 );
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(Map.Entry<String, Integer> entry: mpp.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			
			if(value > max) {
				result.clear();
				result.add(key);
		        max = value;
			}else if(value == max){
				result.add(key);
			}
		}
		
		Collections.sort(result);
		
		return result;
		
		
		
	}

}

public class ServerLogs {

	public static void main(String[] args) {
		String[][] input = {
	            {"alice","LOGIN","10"},
	            {"bob","LOGIN","20"},
	            {"alice","LOGIN","30"},
	            {"bob","LOGOUT","40"},
	            {"charlie","LOGIN","50"},
	            {"bob","LOGIN","60"},
	            {"charlie", "LOGIN", "20"}
	        };

	        List<List<String>> logs = new ArrayList<>();

	        for (String[] row : input) {
	            logs.add(Arrays.asList(row));
	        }

	        List<String> result = UserActivity.getTopActiveUsers(logs);

	        System.out.println(result);
	    }
		
	}

