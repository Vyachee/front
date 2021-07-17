import 'package:flutter/material.dart';
import 'package:where_the_toilet/constants.dart';
import 'package:where_the_toilet/ui/view/register_view.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primaryColor: Constants.primaryColor,
        fontFamily: 'Roboto'
      ),
      home: RegisterPage(),
    );
  }
}
