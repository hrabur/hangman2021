import { useState } from "react";
import { Button } from "react-bootstrap";
import "./App.css";

function App() {
  const [gameInfo, setGameInfo] = useState();

  const startNewGame = async () => {
    let response = await fetch("/api/games", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    let gameInfo = await response.json();
    setGameInfo(gameInfo);
  };

  return (
    <div className="App">
      {!gameInfo ? (
        <>
          <h1>Welcome to Hangman</h1>
          <Button onClick={startNewGame}> Press to start new game</Button>
        </>
      ) : (
        <>
          <h1>Guess the word. You have {gameInfo.tryesLeft} tryes left</h1>
          <h2>{gameInfo.word}</h2>
          <h3>
            {gameInfo.letersLeft.map((letter) => (
              <Button className="App-LetterButton">{letter}</Button>
            ))}
          </h3>
        </>
      )}
    </div>
  );
}

export default App;
