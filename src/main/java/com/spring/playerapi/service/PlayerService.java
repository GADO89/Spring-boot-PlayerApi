package com.spring.playerapi.service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PlayerService {

    public List<Player> allPlayers();

    public void savePlayer(Player player);

    public Player showPlayer(int id);

    public int deletePlayer(int id);

}
