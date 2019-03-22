package io.github.props.converter.core.handler

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.TreeNode
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.module.SimpleModule
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import io.github.props.converter.core.entity.PassedValue
import java.io.FileReader
import java.io.FileWriter
import java.io.InputStreamReader
import java.lang.reflect.Type
import kotlin.reflect.defaultType

private class MapToken: TypeToken<Map<String, Any>>()

//class JsonHandler(private val gson: Gson = getGson(),
class JsonHandler(private val type: Type = MapToken().type): BaseHandler<Map<String, Any>> {

    override fun read(input: String): Map<String, Any> {
//        FileReader(input).use { reader ->
//            return gson.fromJson(reader, type)
//        }
        throw RuntimeException()
    }

    override fun write(value: Map<String, Any>, out: String) {
//        FileWriter(out).use {writer ->
//            gson.toJson(value, writer)
//        }
    }
}

//fun getGson(): Gson {
//    return GsonBuilder()
//            .registerTypeAdapter(PassedValue::class.java, CustomConverter())
//            .create()
//}

//class CustomConverter
//    :JsonSerializer<PassedValue>, JsonDeserializer<PassedValue> {
//    override fun serialize(p0: PassedValue?, p1: Type?, p2: JsonSerializationContext?): JsonElement? {
//        return null;
//    }
//
//    override fun deserialize(elem: JsonElement?, type: Type?, context: JsonDeserializationContext?): PassedValue? {
//        return null;
//    }
//
//}

fun main(args: Array<String>) {
    JsonHandler::class.java.getResourceAsStream("/1.json").use {stream ->
        val mapper = ObjectMapper()
        val module = SimpleModule()
        module.addDeserializer(PassedValueList::class.java, Deser())
        mapper.registerModule(module)
        mapper.readValue(stream, PassedValueList::class.java)
//        val reader = InputStreamReader(stream)
//        val value = gson.fromJson(reader, PassedValue::class.java)
//        println(value)
    }
}

class PassedValueList: ArrayList<PassedValue>()


class Deser: StdDeserializer<PassedValueList>(PassedValueList::class.java) {
    override fun deserialize(parser: JsonParser?, context: DeserializationContext?): PassedValueList? {
        val tree: TreeNode? = parser?.currentToken()
        println(tree)
        return null
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}