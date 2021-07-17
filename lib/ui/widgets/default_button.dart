import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:where_the_toilet/constants.dart';

Widget DefaultButton(VoidCallback callback, String text) {
  return Container(
    decoration: BoxDecoration(
      borderRadius: BorderRadius.all(Radius.circular(50))
    ),
    child: ConstrainedBox(
        constraints: BoxConstraints.tightFor(width: 300, height: 45),
        child: ElevatedButton(
            onPressed: callback,
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all(Constants.primaryColor),
              elevation: MaterialStateProperty.all(0),
                shape: MaterialStateProperty.all<RoundedRectangleBorder>(
                    RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(50),
                    )
                )
            ),
            child: Text(
              text,
              style: TextStyle(
                  fontSize: 16,
                fontWeight: FontWeight.w300
              ),
            )

        ))
  );
}
