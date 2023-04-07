import 'package:flutter/material.dart';

class MoreInfo extends StatelessWidget {

  final String id;

  const MoreInfo({
    Key? key,
    required this.id,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.network("https://deckofcardsapi.com/static/img/$id.png"),
            ],
          )
        ],
      ),
    );
  }
}
