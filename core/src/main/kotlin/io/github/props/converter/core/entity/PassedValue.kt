package io.github.props.converter.core.entity

data class PassedValue(val name: String, val value: Any? = null, val subValues: List<PassedValue>? = null)