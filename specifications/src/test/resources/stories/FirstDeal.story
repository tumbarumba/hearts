Narrative:
As a Hearts player
I want to see the cards in my hard are grouped by suit and sorted by rank
So that I can easily choose my next card

Scenario: Cards are grouped by suit and ordered by rank
Given that the player has a hand containing
Q♥, 5♣, 10♣, 4♦, 9♥, Q♣, 10♦, 10♠, J♥, Q♠, K♥, 9♦, 3♥
When the cards are displayed
Then the cards are shown in the order
5♣, 10♣, Q♣, 4♦, 9♦, 10♦, 10♠, Q♠, 3♥, 9♥, J♥, Q♥, K♥