import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.green,
      ),
      home: const MyHomePage(title: 'Sorteio'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key, required this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final TextEditingController _numero1 = TextEditingController();
  final TextEditingController _numero2 = TextEditingController();

  int _numeroSorteado = 0;

  void _sortear() {
    int minVal;
    int maxVal;
    final _random = Random();
    int numero1 = _numero1.text.isEmpty ? 0 : int.parse(_numero1.text);
    int numero2 = _numero2.text.isEmpty ? 0 : int.parse(_numero2.text);
    if (numero2 > numero1) {
      minVal = numero1;
      maxVal = numero2;
    } else {
      minVal = numero2;
      maxVal = numero1;
    }
    setState(() {
      _numeroSorteado = _random.nextInt(maxVal - minVal + 1) + minVal;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                Container(
                  margin: const EdgeInsets.all(30),
                  child: TextField(
                    controller: _numero1,
                    decoration: const InputDecoration(
                      labelText: 'Número',
                      hintText: 'Digite o número 1',
                    ),
                    keyboardType: TextInputType.number,
                  ),
                ),
                Container(
                  margin: const EdgeInsets.all(30),
                  child: TextField(
                    controller: _numero2,
                    decoration: const InputDecoration(
                      labelText: 'Número',
                      hintText: 'Digite o número 2',
                    ),
                    keyboardType: TextInputType.number,
                  ),
                ),
              ],
            ),
            Container(
              margin: const EdgeInsets.all(25),
              child: MaterialButton(
                child: const Text(
                  'Sortear',
                  style: TextStyle(fontSize: 20.0),
                ),
                color: Colors.blueAccent,
                textColor: Colors.white,
                onPressed: _sortear,
              ),
            ),
            const Text(
              'numero Sorteado:',
            ),
            Container(
              margin: const EdgeInsets.all(25),
              child: Text(
                '$_numeroSorteado',
                style: TextStyle(fontSize: 50.0),
              ),
            ),
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
