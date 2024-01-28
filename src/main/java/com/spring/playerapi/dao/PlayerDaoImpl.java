package com.spring.playerapi.dao;

import com.spring.playerapi.model.Player;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

//DAO Layer
@Service
public class PlayerDaoImpl implements PlayerDAO{

    private EntityManager entityManager;

    public PlayerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Player> getPlayers() {
        Session session=entityManager.unwrap(Session.class);
        Query<Player> query=session.createQuery("from Player ", Player.class);
        return query.getResultList();
    }

    @Override
    public void addPlayers(Player player) {
        Session session=entityManager.unwrap(Session.class);
                session.saveOrUpdate(player);
    }

    @Override
    public Player getPlayer(int id) {
        Session session=entityManager.unwrap(Session.class);
        return session.get(Player.class,id);
    }

    @Override
    public int removePlayer(int id) {
        Session session=entityManager.unwrap(Session.class);
         Query q= session.createQuery("delete from Player where id=?1");
        q.setInteger(1,id);
        return q.executeUpdate();

    }
}
