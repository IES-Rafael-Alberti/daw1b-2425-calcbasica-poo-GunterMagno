package org.example

class Calculadora(private val consola: IEntradaSalida) {


    private fun operar(primerNum: Double, operador: String, segundoNum: Double): Double{
        return when (operador){
            "+" -> primerNum + segundoNum
            "-" -> primerNum - segundoNum
            "*" -> primerNum * segundoNum
            "/" -> primerNum / segundoNum
            else -> {primerNum + segundoNum}
        }
    }


    fun iniciar(){
        consola.mostrar("\n\n----- Calculadora Simple -----")
        consola.mostrar("Escriba \"salir\" en cualquier momento para cerrar la calculadora.\n")

        while (true) {

           val primerNum = consola.pedirDouble("Introduce el primer numero: ", "Error al solicitar el primer numero, intentalo de nuevo.\n") ?: break


            var operador: String? = consola.pedirInfo("Introduce el operador (+, -, *, /): ", "Error al solicitar un operador, intentalo de nuevo.\n") ?: break

            while (operador !in listOf("+","-","*","/")) {
                consola.mostrar("Operador no valido, intentalo de nuevo.\n")
                operador = consola.pedirInfo("Introduce el operador (+, -, *, /): ", "Error al solicitar un operador, intentalo de nuevo.\n") ?: break
            }
            if (operador == null) {break}

            val segundoNum = consola.pedirDouble("Introduce el segundo numero: ", "Error al solicitar el segundo numero, intentalo de nuevo.\n")  ?: break

            consola.mostrar("Resultado = ${operar(primerNum, operador, segundoNum)}")
        }
    }
}