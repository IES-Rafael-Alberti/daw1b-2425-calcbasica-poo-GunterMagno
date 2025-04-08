package org.example


import java.util.*


class Consola: IEntradaSalida {


    override val escaner = Scanner(System.`in`)


    override fun mostrar(msg: String,salto: Boolean){
        print(msg)
        if (salto) {println()}
    }


    override fun pedirInfo(msg: String, msgError: String): String?{
        mostrar(msg,false)
        try {
            when (val input = escaner.next().trim().lowercase()) {
                "salir" -> {
                    if (preguntar("\nSalir de la calculadora? (s/n): ")){
                        return null
                    }
                }
                else -> {return input}
            }
        }catch (e: NoSuchElementException){
            mostrar(msgError)
            return pedirInfo(msg, msgError)
        }
        return pedirInfo(msg, msgError)
    }


    override fun pedirDouble(msg: String, msgError: String): Double?{
        try {
            val input = pedirInfo(msg, msgError)?: return null
            return input.toDouble()
        } catch (e: NumberFormatException) {
            mostrar(msgError)
            return pedirDouble(msg, msgError)
        }
    }


    override fun preguntar(mensaje: String): Boolean {
        var resp: String?
        do {
            resp = try {
                pedirInfo(mensaje, "La respuesta tiene que ser si/no o en su defecto s/n")
            } catch (e: IllegalArgumentException) {
                mostrar(e.message.toString())
                ""
            }
        } while (resp.isNullOrEmpty() && resp?.lowercase() !in listOf("si", "s", "no", "n"))


        return resp == "si" || resp == "s"
    }
}
