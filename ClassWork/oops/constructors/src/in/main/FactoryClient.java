package in.main;

//product
interface Notification{
	void notifyUser() ;
}

//concrete prod 1 
class  EmailNotification implements Notification {
	public void notifyUser() {
		System.out.println("Sending email....");
	}	
}

//concrete product 2 
class PushNotification implements Notification{
	public void notifyUser() {
		System.out.println("pushing notifications ...");
	}	
}

//Factory class
class NotificationFactory{
	public static Notification createNotification( String type){
		
		if ( type.trim().equalsIgnoreCase("EMAIL")) {
			return new EmailNotification();
		}else if (type.trim().equalsIgnoreCase("PUSH")) {
			return new  PushNotification();
		}else {
			return null;
		}		
	}
}

//client 
public class FactoryClient {
	public static void main(String[] args) {
		Notification n1 = NotificationFactory.createNotification("EMAIL");
		 n1.notifyUser();
		 
		 Notification n2 = NotificationFactory.createNotification("PUSH");
		 n2.notifyUser();
	}

}
