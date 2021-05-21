package pu.fmi.web.hangman.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import pu.fmi.web.hangman.model.GameInfo;

@Service
public class HangmanService {

	public static final String[] WORDS = { "word", "office", "atom", "concurrent" };

	public Map<String, GameInfo> games = new ConcurrentHashMap<>();

	public GameInfo startNewGame() {
		GameInfo game = new GameInfo();
		game.setId(UUID.randomUUID().toString());
		int wordIndex = RandomUtils.nextInt(0, WORDS.length - 1);
		game.setWord(WORDS[wordIndex]);
		game.setLetersLeft(removeChars(game.getWord().toCharArray()));

		games.put(game.getId(), game);
		return game;
	}

	private List<Character> removeChars(char[] chars) {
		List<Character> charsLeft = new ArrayList<>();
		for (char leter = 'A'; leter < 'Z'; leter++) {
			charsLeft.add(leter);
		}

		return charsLeft;
	}

	public GameInfo getGame(String gameId) {
		return games.get(gameId);
	}

	public GameInfo makeTry(String gameId, char letter) {
		GameInfo game = getGame(gameId);
		return null;
	}
}
