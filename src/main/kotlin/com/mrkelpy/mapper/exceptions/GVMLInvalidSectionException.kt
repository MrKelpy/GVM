package com.mrkelpy.mapper.exceptions

/**
 * This exception will be thrown whenever there is an issue with a "mapping for" section statement
 */
class GVMLInvalidSectionException(private val text: String) : GVMLSyntaxError(text) {
}