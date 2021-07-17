


import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:where_the_toilet/constants.dart';
import 'package:where_the_toilet/ui/view/login_view.dart';
import 'package:where_the_toilet/ui/widgets/default_button.dart';
import 'package:where_the_toilet/ui/widgets/default_input.dart';

class RegisterPage extends StatefulWidget {

  @override
  State<StatefulWidget> createState() => _RegisterPageState();

}

class _RegisterPageState extends State<RegisterPage> {

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
                        "Регистрация",
                        style: TextStyle(
                            fontSize: 36,
                            fontWeight: FontWeight.w300
                        ),
                      )
                    ]
                ),
                SizedBox(height: 64),
                DefaultInput(_usernameController, 'Имя пользователя'),
                SizedBox(height: marginSize),

                DefaultInput(_numberController, '+7 (999) 999 99-99'),
                SizedBox(height: marginSize),

                DefaultInput(_emailController, 'example@mail.com'),
                SizedBox(height: marginSize),

                DefaultInput(_passwordController, 'Пароль'),
                SizedBox(height: marginSize),

                DefaultInput(_passwordRepeatController, 'Повтор пароля'),
                SizedBox(height: marginSize),

                DefaultButton(() => {

                }, 'Зарегистрироваться'),

                SizedBox(height: marginSize-4),

                GestureDetector(
                  onTap: () => {
                    Navigator.push(
                      context,
                    MaterialPageRoute(builder: (context) => LoginPage()))
                  },
                  child: Text(
                    'У меня уже есть аккаунт',
                    style: TextStyle(
                        color: Color(0xff898989)
                    ),
                  ),
                )
              ],
            ),
          ),
        )
      ),
    );
  }

}