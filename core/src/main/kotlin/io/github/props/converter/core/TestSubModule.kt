package io.github.props.converter.core
fun sayHi(): String {
    return "Hello"
}

class SuperHellower(val str: String? = "Dibil") {
    fun sayHello(): String {
        return str ?: sayHi()
    }
}