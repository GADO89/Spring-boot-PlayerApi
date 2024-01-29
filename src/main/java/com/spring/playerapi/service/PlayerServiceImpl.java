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

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerServiceImpl(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public List<Player> allPlayers() {
        return playerDAO.findAll();
    }

    @Override
    public void savePlayer(Player player) {
    playerDAO.save(player);
    }

    @Override
    public Player showPlayer(int id) {
        return playerDAO.findById(id).get();
    }

    @Override
    public void deletePlayer(int id) {
         playerDAO.deleteById(id);
    }
}
