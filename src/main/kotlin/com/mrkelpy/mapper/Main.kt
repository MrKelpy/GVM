package com.mrkelpy.mapper

import com.mrkelpy.mapper.interpreter.Engine
import com.mrkelpy.mapper.interpreter.SyntaxHandler

fun main() {
    Engine().run("", ".")
    SyntaxHandler("C:\\dev\\Kotlin\\GeneralValueMapper\\mappings.gvm").run()
}