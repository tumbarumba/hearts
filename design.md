# Hearts Design

The game of hearts is controlled by the UI. This will allow multiplayer implementation later.

## Start a New Game

```
browser
    -> New Game
        -> NewGameHandler
            -> new Game()
            -> Add 4 new players
            -> game.startGame()
                -> deal cards
                -> create new trick and add to players
            -> redirect browser to display the game
```


## Sequence to Display the Game
 
```
browser
    -> GET /game/:gameId
        -> GamePage
            -> Game
            -> Renders HTML from mustache
```

## Sequence to Play a Card

```
browser
    -> POST /game/:gameId
        -> PlayCardHandler
            -> player.playCard
                -> trick.playCardForPlayer
                    -> notify observers? (e.g. game can then update next 
                    player, or decide winner, or create new trick)
```