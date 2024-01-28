package com.spring.playerapi.dao;

import com.spring.playerapi.model.Player;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerDAO {

    public List<Player> getPlayers();

    public void addPlayers(Player player);

    public Player getPlayer(int id);

    public int removePlayer(int id);

}
