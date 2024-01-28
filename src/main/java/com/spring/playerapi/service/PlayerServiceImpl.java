package com.spring.playerapi.service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerDAO playerDAO;


    public PlayerServiceImpl() {
    }

    @Override
    public List<Player> getPlayers() {
        return playerDAO.getPlayers();
    }

    @Override
    public void addPlayers(Player player) {
    playerDAO.addPlayers(player);
    }

    @Override
    public Player getPlayer(int id) {
        return playerDAO.getPlayer(id);
    }

    @Override
    public int removePlayer(int id) {
        return playerDAO.removePlayer(id);
    }
}
