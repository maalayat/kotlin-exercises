package infix

/**
 * Indica el valor de la carta (dos, tres, rey, as, etc.).
 */
enum class Rank {
    TWO, THREE, FOUR, FIVE,
    SIX, SEVEN, EIGHT, NINE,
    TEN, JACK, QUEEN, KING, ACE;

    /*fun of(suit: Suit) : Card {
        return Card(this, suit)
    }*/

    //https://en.wikipedia.org/wiki/Infix_notation
    infix fun of(suit: Suit) = Card(this, suit)
}