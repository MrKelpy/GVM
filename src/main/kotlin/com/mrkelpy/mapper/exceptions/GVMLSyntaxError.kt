package com.mrkelpy.mapper.exceptions;

/**
 * Parent exception for GVML Syntax Errors. Thrown whenever any mapping definitions are wrongly written.
 */
open class GVMLSyntaxError(private val text: String) : Throwable(text)
