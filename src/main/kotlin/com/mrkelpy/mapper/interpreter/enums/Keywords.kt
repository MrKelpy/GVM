package com.mrkelpy.mapper.interpreter.enums


/**
 * This enum is responsible for storing any keyword definitions for GVML
 * @property value The string value for the keyword
 * @property scope Where the keyword can be defined
 */
enum class Keywords(val value: String, val scope: KeywordScope) {

    OUTPUT_LOCATION_DEFINITION("out", KeywordScope.ANY),

    SECTION_DEFINITION("mappingsfor", KeywordScope.OUTER),
    SECTION_END("end", KeywordScope.OUTER),

    LOCATION_DEFINITION("setlocation", KeywordScope.SECTION),
    SCOPE_DEFINITION("setscope", KeywordScope.SECTION),
    MAPPINGS_DEFINITION("setmappings", KeywordScope.SECTION);

    companion object {

        /**
         * Checks if the specified instruction contains a keyword within the registry
         *
         * @param instruction The string containing the instruction to be checked
         * @param scope The scope of the instruction's keyword
         * @return Whether the instruction starts with a registered keyword
         */
        fun hasKeyword(instruction: String, scope: KeywordScope = KeywordScope.ANY): Boolean {
            return Keywords.entries.any { x -> instruction.startsWith(x.value)}
        }

    }

    override fun toString(): String {
        return this.value
    }
}

