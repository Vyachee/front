


import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:where_the_toilet/constants.dart';
import 'package:where_the_toilet/ui/widgets/default_button.dart';
import 'package:where_the_toilet/ui/widgets/default_input.dart';

class LoginPage extends StatefulWidget {

  @override
  State<StatefulWidget> createState() => _LoginPageState();

}

class _LoginPageState extends State<LoginPage> {

  var _usernameController = TextEditingController();
  var _numberController = TextEditingController();
  var _emailController = TextEditingController();
  var _passwordController = TextEditingController();
  var _passwordRepeatController = TextEditingController();

  var marginSize = 24.0;



  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xffefefef),
      body: SafeArea(
        child: Container(

          margin: EdgeInsets.only(
              left: Constants.leftMargin,
              right: Constants.rightMargin
          ),
          child: SingleChildScrollView(
            child: Column(
              children: [
                SizedBox(height: 64),
                Row(
                    children: [
                      Text(
                        'Авторизация',
                        style: TextStyle(
                            fontSize: 36,
                            fontWeight: FontWeight.w300
                        ),
                      )
                    ]
                ),
                SizedBox(height: 64),

                DefaultInput(_numberController, '+7 (999) 999 99-99'),
                SizedBox(height: marginSize),

                DefaultInput(_passwordController, 'Пароль'),
                SizedBox(height: marginSize),

                SizedBox(height: marginSize),

                DefaultButton(() => {

                }, 'Войти'),

                SizedBox(height: marginSize-4),

                Row(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  children: [
                    GestureDetector(
                      onTap: () => {
                        Navigator.pop(context)
                      },
                      child: Text(
                        'У меня ещё нет аккаунта',
                        style: TextStyle(
                            color: Color(0xff898989)
                        ),
                      ),
                    ),
                    Text(
                      'Забыли пароль?',
                      style: TextStyle(
                          color: Color(0xff898989)
                      ),
                    )
                  ],
                )
              ],
            ),
          ),
        )
      ),
    );
  }

}