package com.spring.playerapi.service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
//@Transactional
public class PlayerServiceImpl {

    private PlayerDAO playerDAO;

    @Autowired
    public PlayerServiceImpl(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player getPlayerByName( String playername){
      return   playerDAO.findByName(playername);
    }

    public List<Player> allPlayers() {
        return playerDAO.findAll();
    }


    public void savePlayer(Player player) {
    playerDAO.save(player);
    }


    public Player showPlayer(int id) {
        return playerDAO.findById(id).get();
    }


    public void deletePlayer(int id) {
         playerDAO.deleteById(id);
    }
}
