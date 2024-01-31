package com.spring.playerapi.controller;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

    private PlayerServiceImpl playerServiceImpl;

    @Autowired
    public PlayerController(PlayerServiceImpl playerServiceImpl) {
        this.playerServiceImpl = playerServiceImpl;
    }


    @GetMapping("/players")
    public String getAllPlayers(Model model) {
        model.addAttribute("players",playerServiceImpl.allPlayers());
        return "home";
    }

    @GetMapping("/player-form")
    public String playerForm(Model model) {
        model.addAttribute("player",new Player());
        return "player-form";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player) {
        playerServiceImpl.savePlayer(player);
        return "redirect:/players";
    }

    @GetMapping("/getPlayer")
    public String getPlayer(@RequestParam("playerId") int id, Model model) {
        model.addAttribute("player",playerServiceImpl.showPlayer(id));
        return "player-form";
    }


}


/*
  @GetMapping("/agent")
    public Player getPlayerByName(@RequestParam String name){
        return   playerServiceImpl.getPlayerByName(name);
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
    }
 */