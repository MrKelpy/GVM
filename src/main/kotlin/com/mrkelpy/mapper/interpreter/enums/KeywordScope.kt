package com.mrkelpy.mapper.interpreter.enums

/**
 * This class is responsible for holding the locations where certain keywords can go.
 */
enum class KeywordScope {
    SECTION,  // Defined within a section
    OUTER,    // Defined outside any sections, within the "top-level" of the file
    ANY,      // Defined everywhere
}