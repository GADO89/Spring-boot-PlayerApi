package com.spring.playerapi.controller;

import com.spring.playerapi.dao.PlayerDaoImpl;
import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class PlayerController {

    @Autowired
    private PlayerServiceImpl playerServiceImpl;



    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerServiceImpl.allPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable("id") int id) {
        Player p= playerServiceImpl.showPlayer(id);
        if (p==null){
            throw new RuntimeException("Player not found id: "+id);
        }
        return p;
    }

    @PostMapping("/savePlayers")
    public String savePlayers(@RequestBody Player player) {
        playerServiceImpl.savePlayer(player);
        return "Success added";
    }

    @PutMapping("/editPlayers")
    public String editPlayers(@RequestBody Player player) {
        playerServiceImpl.savePlayer(player);
        return "Success editing";
    }

    @DeleteMapping("/removePlayer/{id}")
    public String removePlayer(@PathVariable ("id")int id) {
        int result= playerServiceImpl.deletePlayer(id);
        System.out.println(result);
        if (result==0) {
            throw new RuntimeException("Player not found id: " + id);
        }
        return "Success Remove";
    }
}
