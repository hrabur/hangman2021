package pu.fmi.web.hangman.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GameInfo {
	@Id
	@GeneratedValue
	public Long id;

	public String word;
	public String hiddenWord;
	public int tryesLeft = 5;

	public transient List<Character> letersLeft;
}
