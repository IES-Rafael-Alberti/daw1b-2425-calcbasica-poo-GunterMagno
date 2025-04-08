package org.example
import java.util.Scanner

interface IEntradaSalida {
    val escaner : Scanner
    fun mostrar(msg: String,salto: Boolean = true)
    fun pedirInfo(msg: String, msgError: String): String?
    fun pedirDouble(msg: String, msgError: String): Double?
    fun preguntar(mensaje: String): Boolean
}
