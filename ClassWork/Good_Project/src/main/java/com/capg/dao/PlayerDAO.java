package com.capg.dao;

import com.capg.entity.Player;

import java.util.List;

public interface PlayerDAO {
    void insertPlayer(Player player) throws Exception;
    void updatePlayer(String country , Integer id)throws Exception;
    void deletePlayer(int playerId) throws Exception;
    List<Player> getAllPlayers() throws Exception;
}
