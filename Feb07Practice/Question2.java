package Feb07Practice;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

class LogProcessor {

    public static void processLogs(Queue<String> logQueue) {

        Stack<String> errorStack = new Stack<>();

        String lastErrorMessage = "";
        int consecutiveErrorCount = 0;

        while (!logQueue.isEmpty() || !errorStack.isEmpty()) {

            String currentLog;

            if (!errorStack.isEmpty()) {
                currentLog = errorStack.pop();
            } else {
                currentLog = logQueue.poll();
            }

            String[] parts = currentLog.split(":", 2);
            String level = parts[0];
            String message = parts[1];

            if (level.equals("ERROR")) {

                if (message.equals(lastErrorMessage)) {
                    consecutiveErrorCount++;
                } else {
                    lastErrorMessage = message;
                    consecutiveErrorCount = 1;
                }

                if (consecutiveErrorCount == 3) {
                    System.out.println("🚨 ALERT: ERROR occurred 3 times consecutively -> " + message);
                    return;
                }

                // re-process immediately
                errorStack.push(currentLog);

            } else {
                // reset on non-error
                lastErrorMessage = "";
                consecutiveErrorCount = 0;
            }

            System.out.println("Processed: " + currentLog);
        }
    }
}

public class Question2 {

    public static void main(String[] args) {

        Queue<String> logs = new LinkedList<>();

        System.out.println("Processing:");

        logs.add("INFO:ServerStarted");
        logs.add("ERROR:DiskFull");
        logs.add("ERROR:DiskFull");
        logs.add("ERROR:DiskFull");
        logs.add("INFO:Cleanup");

        // ✅ correct static call
        LogProcessor.processLogs(logs);
    }
}
