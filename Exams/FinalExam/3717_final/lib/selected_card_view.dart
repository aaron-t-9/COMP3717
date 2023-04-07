import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SelectedCard extends StatelessWidget {

  final drawnCard;
  final Function() moreInfo;

  const SelectedCard({
    Key? key,
    required this.drawnCard,
    required this.moreInfo,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
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
                      MaterialPageRoute(builder: (context) => moreInfo(id: drawnCard.id)));
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
  }
}
