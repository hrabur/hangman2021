package pu.fmi.web.hangman.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameInfoRepo extends JpaRepository<GameInfo, Long> {
}
