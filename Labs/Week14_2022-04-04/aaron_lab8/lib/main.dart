import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    // material apps allows us to use materials (e.g. from material.io)
    home: Home(),
  ));
}

class Home extends StatelessWidget {
  List<String> eldenRing = [
    "Radhan",
    "Morgott",
    "Malenia",
    "Lionel",
    "Varre"
  ];
  List<String> spongeBob = [
    "Spongebob",
    "Patrick",
    "Gary",
    "Squidward",
    "Sandy"
  ];
  List<String> pokeMon = [
    "Grimmsnarl",
    "Aegislash",
    "Squirtle",
    "Rhyperior",
    "Machamp"
  ];

  Home({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Pop Character List"),
        centerTitle: true,
      ),
      body: ListView(
        padding: const EdgeInsets.only(top: 10),
        children: [
          const Center(
            child: Text("Pokemon",
              style: TextStyle(
                  fontSize: 25,
                  fontWeight: FontWeight.bold
              ),
            ),
          ),
          SizedBox(
            width: 100,
            height: 175,
            child: Card(
              color: Colors.orangeAccent,
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: pokeMon.map((e) => cardTemplate(e, Colors.orange.shade100, Colors.deepOrange.shade900)).toList(),
              ),
            ),
          ),

          const Center(
            child: Text("Sponge Bob",
              style: TextStyle(
                  fontSize: 25,
                  fontWeight: FontWeight.bold
              ),
            ),
          ),
          SizedBox(
            width: 100,
            height: 175,
            child: Card(
              color: Colors.pink[400],
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: spongeBob.map((e) => cardTemplate(e, Colors.pink.shade100, Colors.pink.shade900)).toList(),
              ),
            ),
          ),

          const Center(
            child: Text("Elden Ring",
              style: TextStyle(
                  fontSize: 25,
                  fontWeight: FontWeight.bold
              ),
            ),
          ),
          SizedBox(
            width: 100,
            height: 175,
            child: Card(
              color: Colors.green[400],
              child: ListView(
                scrollDirection: Axis.horizontal,
                children: eldenRing.map((e) => cardTemplate(e, Colors.green.shade100, Colors.green.shade900)).toList(),
              ),
            ),
          ),

        ],
      ),
    );
  }
}

Widget cardTemplate(String e, Color listColor, Color textColor) {
  return UnconstrainedBox(
    alignment: Alignment.center,
    child: Padding(
      padding: const EdgeInsets.all(8.0),
      child: Card(
        elevation: 10,
        color: listColor,
        child: SizedBox(
            width: 100,
            height: 50,
            child: Center(
                child: Text(e, style:
                  TextStyle(
                    color: textColor
                  ),))
        ),
      ),
    ),
  );
}
