package pu.fmi.web.hangman.model;

import java.util.List;

import lombok.Data;

@Data
public class GameInfo {
	public String id;

	public String word;
	public String hiddenWord;
	public List<Character> letersLeft;
	public int tryesLeft = 5;
}
