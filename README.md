# Poker Hand Scoring System

## Game Rules:
The scoring system follows these rules:

1. One Ace (A) = 1 point
2. One Pair (two cards with the same rank) = 2 points
3. Flush (all five cards share the same suit) = 3 points
4. Straight (five cards in sequence, e.g., Q-K-A-2-3 is valid) = 5 points
5. Full House (three of a kind + one pair) = 10 points
6. Four of a Kind = 20 points
7. Straight Flush (a straight with all cards in the same suit) = 100 points

Cards may only be used once per combination. If multiple scoring combinations are possible, only the maximum-scoring one is counted. However, individual leftover cards (e.g., an unused Ace) can still contribute their respective points.

## Features:
* Evaluates hand and returns the maximum score.
* Detects poker combinations including flush, straight, full house, four of a kind, and straight flush.
* Custom handling of wrap-around straights like Q-K-A-2-3.
