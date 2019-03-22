package io.github.props.converter.core.entity

import org.apache.commons.io.FilenameUtils

enum class FileType(private vararg val type: String) {
    JSON("json"),
    YML("yml", "yaml"),
    CSV("csv"),
    PROPERTIES("properties");

    fun getFirstType(): String = type[0]
}

enum class RestructureType {
    AS_IS,
    PLAIN,
    TREE
}

data class ConverterConfiguration(val restructureType: RestructureType = RestructureType.AS_IS,
                                  val sort: Boolean = false,
                                  val from: FileType,
                                  val to: FileType,
                                  val inputPath: String,
                                  val outputPath: String = changeExtension(inputPath, to))

fun changeExtension(input: String, type: FileType):String {
    return "${FilenameUtils.removeExtension(input)}.${type.getFirstType()}"
}