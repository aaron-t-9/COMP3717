import 'package:flutter/material.dart';

class ItemCard extends StatefulWidget {

  final playingCard;

  const ItemCard({
    Key? key,
    required this.playingCard,
  }) : super(key: key);

  @override
  State<ItemCard> createState() => _ItemCardState();
}

class _ItemCardState extends State<ItemCard> {
  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.blue,
      child: TextButton(
        onPressed: () {},
        child: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text("${widget.playingCard.value} of ${widget.playingCard.suit.toUpperCase()}",
            style: const TextStyle(
              color: Colors.white,
              ),
            ),
          ],
        ),
      ),
    );
  }
}
