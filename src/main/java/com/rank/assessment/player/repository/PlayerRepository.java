package com.rank.assessment.player.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rank.assessment.player.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	@Query("SELECT p FROM Player p WHERE p.username = ?1")
	Optional<Player> findPlayerByUsername(String username);
}
