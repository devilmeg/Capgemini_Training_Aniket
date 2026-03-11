package com.capg.dao;

import com.capg.entity.Player;
import com.capg.repository.Player_repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAOImpl implements PlayerDAO{
    @Override
    public void insertPlayer(Player player) throws Exception {
        String sql = "Insert into player values(? , ? , ?)";
        Connection conn = Player_repo.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, player.getPlayer_id());
        pstmt.setString(2 , player.getPlayer_name());
        pstmt.setString(3 , player.getPlayer_Country());

        pstmt.execute();
        System.out.println("Player Inserted");
    }

    @Override
    public void updatePlayer(String country , Integer id) throws Exception{
        String sql = "Update player set player_country = ? where player.player_id = ?";
        Connection conn = Player_repo.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1 , country);
        pstmt.setInt(2 , id);
        pstmt.execute();
        System.out.println("Updated players Country");
    }

    @Override
    public void deletePlayer(int playerId) throws Exception{
            String sql = "delete from player where player_id = ?";
            Connection conn = Player_repo.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, playerId);
            pstmt.execute();
        System.out.println("Player deleted");
    }

    @Override
    public List<Player> getAllPlayers() throws Exception {
        String sql = "Select * from player";
        Connection conn = Player_repo.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Player> list = new ArrayList<>();

        while (rs.next()) {
            list.add(new Player(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            ));
        }

        return list;
    }

}
