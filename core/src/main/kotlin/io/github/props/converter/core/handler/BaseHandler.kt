package io.github.props.converter.core.handler

interface BaseHandler<T> {
    fun read(input: String): T
    fun write(value: T, out: String)
}
