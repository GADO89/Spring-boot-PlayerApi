package com.spring.playerapi.service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PlayerService {

    public List<Player> getPlayers();

    public void addPlayers(Player player);

    public Player getPlayer(int id);

    public int removePlayer(int id);

}
