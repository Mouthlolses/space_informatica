package com.example.space_informatica.repository

import com.google.firebase.auth.FirebaseAuth


//Repository gerencia a lógica de autenticação e separa a responsabilidade da Activity
class AuthRepository(private val auth: FirebaseAuth) {

    fun registerUser(email: String, password: String, callback: (Boolean, String) -> Unit) {

        if (email.isEmpty() || password.isEmpty()) {
            callback(false, "Preencha os campos para realizar o registro")
            return
        }

        auth.createUserWithEmailAndPassword(
            email, password
        ).addOnSuccessListener {
            callback(true, "Sucesso ao cadastrar usuário")
        }
            .addOnFailureListener { exception ->
                callback(false, "Erro ao cadastrar usuário: ${exception.message}")
            }
    }

    fun logarUser(email: String, password: String, callback: (Boolean, String) -> Unit) {
        if (email.isEmpty() || password.isEmpty()) {
            callback(false, "Preencha os campos para fazer login")
            return
        }

        auth.signInWithEmailAndPassword(
            email, password
        ).addOnSuccessListener {
            callback(true, "Login realizado com sucesso")
        }.addOnFailureListener { exception ->
            callback(false, "\"Erro ao fazer login: ${exception.message}")
        }
    }
}
