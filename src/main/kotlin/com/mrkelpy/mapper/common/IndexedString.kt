package com.mrkelpy.mapper.common

/**
 * This class is responsible for mapping strings to lines, containing all the implementations
 * of a normal string within its content.
 * @property content The string's content
 * @property position The position of the string within the file
 */
class IndexedString(val content: String, val position: Int) : CharSequence {
    override val length: Int
        get() = this.content.length

    override fun get(index: Int): Char {
        return this.content[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return this.content.subSequence(startIndex, endIndex)
    }

    override fun toString(): String {
        return this.content
    }
}
