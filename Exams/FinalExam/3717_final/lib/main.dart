import 'package:flutter/material.dart';
import 'dart:math';
import 'playing_card.dart';
import 'item_card_view.dart';
import 'more_screen.dart';

void main() {
  runApp(
      const MaterialApp(
        home: Home(),
      )
  );
}

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  PlayingCard drawnCard = PlayingCard(id: "JH", value: "Jack", suit: "Hearts");

  List<PlayingCard> playingCards = [
    PlayingCard(id: "3H", value: "3", suit: "Hearts"),
    PlayingCard(id: "AS", value: "Ace", suit: "Spades"),
    PlayingCard(id: "0C", value: "10", suit: "Clubs"),
    PlayingCard(id: "KD", value: "King", suit: "Diamonds"),
    PlayingCard(id: "QH", value: "Queen", suit: "Hearts"),
    PlayingCard(id: "2C", value: "2", suit: "Clubs"),
    PlayingCard(id: "0D", value: "10", suit: "Diamonds"),
    PlayingCard(id: "AH", value: "Ace", suit: "Hearts"),
    PlayingCard(id: "7C", value: "7", suit: "Clubs"),
    PlayingCard(id: "JH", value: "Jack", suit: "Hearts")
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Aaron Tansley: Fun with Cards"),
      ),
      body: ListView(
        children: [
          SizedBox(
            height: 350,
            child: ListView(
              children: playingCards.map((e) =>  ItemCard(playingCard: e)).toList(),
            ),
          ),
          Container(
            height: 275,
            color: Colors.blueAccent.shade400,
            child: Column(
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    Container(
                      padding: const EdgeInsets.only(top: 50),
                        height: 200,
                        child: Image.network("https://deckofcardsapi.com/static/img/${drawnCard.id}.png")),
                    ElevatedButton(
                        onPressed: () {
                          Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => MoreInfo(id: drawnCard.id)));
                        },
                        child: const Text("More")
                    ),
                  ],
                ),
                Padding(
                  padding: const EdgeInsets.only(top: 25),
                  child: Text(
                    "${drawnCard.value} of ${drawnCard.suit.toUpperCase()}",
                    style: const TextStyle(
                      fontSize: 18,
                      color: Colors.white,
                    )),
                ),
              ],
            ),
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Column(
                children: [
                  ElevatedButton(
                      onPressed: () {
                        setState(() {
                          drawnCard = getRandomCard();
                          playingCards.add(drawnCard);
                        });
                      },
                      child: const Text("Draw Card")),
                ],
              )
            ],
          )
        ],
      ),
    );
  }

  PlayingCard getRandomCard() {
    /*
    Uses the random function within dart:math to generate and return a random
    playing card.
     */
    var rng = Random();
    int randSuit = rng.nextInt(3);
    int randCard = rng.nextInt(12);

    String suit = "Z";
    String value = "Z";
    String idSuit = "Z";
    String idCard = "Z";

    if (randSuit == 0) {
      suit = "Hearts";
      idSuit = "H";
    }
    else if (randSuit == 1) {
      suit = "Diamonds";
      idSuit = "D";
    }
    else if (randSuit == 2) {
      suit = "Spades";
      idSuit = "S";
    }
    else if (randSuit == 3) {
      suit = "Clubs";
      idSuit = "C";
    }

    if (randCard == 0) {
      value = "Ace";
      idCard = "A";
    }
    else if (randCard == 1) {
      value = "2";
      idCard = "2";
    }
    else if (randCard == 2) {
      value = "3";
      idCard = "3";
    }
    else if (randCard == 3) {
      value = "4";
      idCard = "4";
    }
    else if (randCard == 4) {
      value = "5";
      idCard = "5";
    }
    else if (randCard == 5) {
      value = "6";
      idCard = "6";
    }
    else if (randCard == 6) {
      value = "7";
      idCard = "7";
    }
    else if (randCard == 7) {
      value = "8";
      idCard = "8";
    }
    else if (randCard == 8) {
      value = "9";
      idCard = "9";
    }
    else if (randCard == 9) {
      value = "10";
      idCard = "0";
    }
    else if (randCard == 10) {
      value = "Jack";
      idCard = "J";
    }
    else if (randCard == 11) {
      value = "Queen";
      idCard = "Q";
    }
    else if (randCard == 12) {
      value = "King";
      idCard = "K";
    }

    String id = idCard + idSuit;
    return PlayingCard(id: id, value: value, suit: suit);
  }
}
