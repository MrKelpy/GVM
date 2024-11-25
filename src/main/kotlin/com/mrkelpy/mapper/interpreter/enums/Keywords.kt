package com.mrkelpy.mapper.interpreter.enums


/**
 * This enum is responsible for storing any keyword definitions for GVML
 */
enum class Keywords(val value: String) {
    SECTION_DEFINITION("mappingsfor"),
    SECTION_END("end");

    override fun toString(): String {
        return this.value
    }

}
