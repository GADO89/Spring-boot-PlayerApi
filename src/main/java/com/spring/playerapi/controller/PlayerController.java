package com.spring.playerapi.controller;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/agents")
public class PlayerController {

    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerServiceImpl = playerServiceImpl;
    }

    @GetMapping("/agent")
    public Player getPlayerByName(@RequestParam String name){
        return   playerServiceImpl.getPlayerByName(name);
    }


/*
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
    public void removePlayer(@PathVariable ("id")int id) {
         playerServiceImpl.deletePlayer(id);
    }*/
}
