package com.mrkelpy.mapper.exceptions

/**
 * Any child exception will be thrown whenever the GVM errors. This is separate from GVML errors.
 */
class GVMException(private val text: String) : Throwable(text)