package com.spring.playerapi.dao;

import com.spring.playerapi.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "persons")
public interface PlayerDAO extends JpaRepository<Player,Integer> {


    //public List<Player> getPlayers();

    //public void addPlayers(Player player);

    //public Player getPlayer(int id);

    //public int removePlayer(int id);

}
