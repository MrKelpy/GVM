package com.mrkelpy.mapper.exceptions

/**
 * This exception will be thrown whenever there is an issue with an instruction
 */
class GVMLInvalidInstructionException(private val text: String) : GVMLSyntaxError(text) {
}