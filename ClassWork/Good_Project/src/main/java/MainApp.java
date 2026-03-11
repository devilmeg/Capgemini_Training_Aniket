import com.capg.dao.PlayerDAO;
import com.capg.dao.PlayerDAOImpl;
import com.capg.entity.Player;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PlayerDAO dao = new PlayerDAOImpl();
//        dao.insertPlayer(new Player(1 , "Vishal" , "India"));

        // Update Player
//        System.out.println("Enter the player id whose country you want to update");
//        int id = sc.nextInt();
//        sc.nextLine();
//        System.out.println("Enter the updated country");
//        String country = sc.nextLine();
//        dao.updatePlayer(country , id);

        // delete player
//        System.out.println("Enter the id of player you want to delete");
//        int delete_id = sc.nextInt();
//        dao.deletePlayer(delete_id);

        // getAll Player
        System.out.println(dao.getAllPlayers());
    }
}
