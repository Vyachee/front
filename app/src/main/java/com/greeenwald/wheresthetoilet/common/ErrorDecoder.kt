package com.greeenwald.wheresthetoilet.common

class ErrorDecoder {

    fun getHumanMessage(errorCode: String): String {

        when(errorCode) {
            "PasswordTooShort" -> return "Пароль слишком короткий"
            "PasswordRequiresNonAlphanumeric" -> return "Пароль должен включать в себя спецсимвол"
            "PasswordRequiresLower" -> return "Пароль должен содержать символы в нижнем регистре"
            "PasswordRequiresUpper" -> return "Пароль должен содержать символы в верхнем регистре"
            "PasswordRequiresDigit" -> return "Пароль должен содержать цифры"
            "PasswordRequiresUniqueChars" -> return "Пароль не должен быть пустым"
            "DuplicateUserName" -> return "Такой Email уже зарегистрирован"
        }

        return "Произошла неизвестная ошибка"

    }

}