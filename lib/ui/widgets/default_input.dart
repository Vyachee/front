import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

Widget DefaultInput(TextEditingController controller, String hintText) {
  return TextField(
    controller: controller,
    style: TextStyle(
      fontWeight: FontWeight.w300,
    ),
    decoration: InputDecoration(
      hintText: hintText,
      border: OutlineInputBorder(
          borderSide: BorderSide.none, borderRadius: BorderRadius.circular(50)),
      contentPadding: EdgeInsets.only(left: 16, top: 4, right: 16, bottom: 4),
      filled: true,
      fillColor: Colors.white,
    ),
  );
}
