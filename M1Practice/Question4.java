package M1Practice;

import java.util.*;

class UserSession{
	public static List<String> getCurrentlyLoggedInUsers(List<List<String>> logs){
		List<String> result = new ArrayList<>();
		
		Set<String> set = new HashSet<>();
		
		for(List<String> log: logs) {
			String user = log.get(0);
			String status = log.get(1);
			
			if(status.equals("LOGIN")) {
				set.add(user);
			}else {
				set.remove(user);
			}
		}
		
		result.addAll(set);
		
		Collections.sort(result);
		
		return result;
	}

}

public class Question4 {

    public static void main(String[] args) {

        // ---------- Test Case 1: Basic example ----------
        List<List<String>> logs1 = new ArrayList<>();
        logs1.add(Arrays.asList("alice", "LOGIN", "10"));
        logs1.add(Arrays.asList("bob", "LOGIN", "20"));
        logs1.add(Arrays.asList("alice", "LOGOUT", "30"));
        logs1.add(Arrays.asList("charlie", "LOGIN", "40"));

        System.out.println("Test 1 (basic):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs1));
        // Expected: [bob, charlie]


        // ---------- Test Case 2: User logs in but never logs out ----------
        List<List<String>> logs2 = new ArrayList<>();
        logs2.add(Arrays.asList("alice", "LOGIN", "10"));
        logs2.add(Arrays.asList("alice", "LOGIN", "20")); // duplicate login

        System.out.println("\nTest 2 (duplicate login, no logout):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs2));
        // Expected: [alice]


        // ---------- Test Case 3: Logout without login ----------
        List<List<String>> logs3 = new ArrayList<>();
        logs3.add(Arrays.asList("bob", "LOGOUT", "15")); // invalid logout
        logs3.add(Arrays.asList("alice", "LOGIN", "20"));

        System.out.println("\nTest 3 (logout without login):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs3));
        // Expected: [alice]


        // ---------- Test Case 4: Multiple users interleaved ----------
        List<List<String>> logs4 = new ArrayList<>();
        logs4.add(Arrays.asList("alice", "LOGIN", "10"));
        logs4.add(Arrays.asList("bob", "LOGIN", "15"));
        logs4.add(Arrays.asList("alice", "LOGOUT", "20"));
        logs4.add(Arrays.asList("alice", "LOGIN", "25"));
        logs4.add(Arrays.asList("charlie", "LOGIN", "30"));
        logs4.add(Arrays.asList("bob", "LOGOUT", "35"));

        System.out.println("\nTest 4 (interleaved sessions):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs4));
        // Expected: [alice, charlie]


        // ---------- Test Case 5: All users logged out ----------
        List<List<String>> logs5 = new ArrayList<>();
        logs5.add(Arrays.asList("alice", "LOGIN", "10"));
        logs5.add(Arrays.asList("alice", "LOGOUT", "20"));
        logs5.add(Arrays.asList("bob", "LOGIN", "30"));
        logs5.add(Arrays.asList("bob", "LOGOUT", "40"));

        System.out.println("\nTest 5 (all logged out):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs5));
        // Expected: []


        // ---------- Test Case 6: Empty logs ----------
        List<List<String>> logs6 = new ArrayList<>();

        System.out.println("\nTest 6 (empty logs):");
        System.out.println(UserSession.getCurrentlyLoggedInUsers(logs6));
        // Expected: []
    }
}

