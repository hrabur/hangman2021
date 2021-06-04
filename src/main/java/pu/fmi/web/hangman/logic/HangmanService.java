package pu.fmi.web.hangman.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pu.fmi.web.hangman.model.GameInfo;
import pu.fmi.web.hangman.model.GameInfoRepo;

@Service
public class HangmanService {

	public static final String[] WORDS = { "word", "office", "atom", "concurrent" };

	@Autowired
	private GameInfoRepo games;

	public GameInfo startNewGame() {
		GameInfo game = new GameInfo();
		int wordIndex = RandomUtils.nextInt(0, WORDS.length - 1);
		game.setWord(WORDS[wordIndex]);
		game.setLetersLeft(removeChars(game.getWord().toCharArray()));

		games.save(game);
		return game;
	}

	private List<Character> removeChars(char[] chars) {
		List<Character> charsLeft = new ArrayList<>();
		for (char leter = 'A'; leter < 'Z'; leter++) {
			charsLeft.add(leter);
		}

		return charsLeft;
	}

	public GameInfo getGame(Long gameId) {
		return games.getById(gameId);
	}

	public GameInfo makeTry(Long gameId, char letter) {
		GameInfo game = getGame(gameId);
		return null;
	}
}
