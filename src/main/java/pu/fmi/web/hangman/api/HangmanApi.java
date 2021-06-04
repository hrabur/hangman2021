package pu.fmi.web.hangman.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pu.fmi.web.hangman.logic.HangmanService;
import pu.fmi.web.hangman.model.GameInfo;

@RestController
@RequestMapping("/api")
public class HangmanApi {

	@Autowired
	private HangmanService hangmanService;

	@PostMapping("/games")
	public GameInfo createGame() {
		return hangmanService.startNewGame();
	}

	@GetMapping("/games/{gameId}")
	public GameInfo getGameInfo(@PathVariable Long gameId) {
		return hangmanService.getGame(gameId);
	}

	@PostMapping("/games/{gameId}/tryes")
	public ResponseEntity<GameInfo> makeTry(@PathVariable Long gameId, @RequestParam Character letter) {
		GameInfo game = hangmanService.getGame(gameId);
		if (game == null) {
			ResponseEntity.notFound().build();
		}

		game = hangmanService.makeTry(gameId, letter);
		return ResponseEntity.ok(game);
	}
}
