package M1Practice;

import java.util.*;

class Logger{
	public static List<List<String>> extractCriticalErrors(List<List<String>> logs){
		
		List<List<String>> result = new ArrayList<>();
		
		for(List<String> log: logs) {
			String status = log.get(2);
			if (status.equals("ERROR") || status.equals("CRITICAL")) {
                result.add(log);
            }
		}  
		
		result.sort((a, b) -> {
			long t1 = parseDateTime(a.get(0), a.get(1));
			long t2 = parseDateTime(b.get(0), b.get(1));
			
			return Long.compare(t1, t2);
		});
		
		return result;
		
	}
	
	private static long parseDateTime(String date, String time) {
		String[] d = date.split("-");
		String[] t = time.split(":");
		
		String ts = d[2] + d[1] + d[0] + t[0] + t[1];
		
		return Long.parseLong(ts);
	}

}

public class Question3 {

    public static void main(String[] args) {

        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed"));
        logs.add(Arrays.asList("01-01-2023", "15:00", "INFO", "ok"));
        logs.add(Arrays.asList("01-01-2023", "01:30", "CRITICAL", "disk"));
        logs.add(Arrays.asList("02-01-2023", "09:00", "ERROR", "timeout"));

        List<List<String>> result =
                Logger.extractCriticalErrors(logs);

        for (List<String> log : result) {
            System.out.println(log);
        }
    }
}

