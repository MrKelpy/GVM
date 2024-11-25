package com.mrkelpy.mapper.interpreter

import com.mrkelpy.mapper.interpreter.enums.Keywords
import com.mrkelpy.mapper.utils.ReadingUtils.Companion.compact
import com.mrkelpy.mapper.utils.ReadingUtils.Companion.noComments
import java.io.File

/**
 * This class is responsible for reading and performing any preemptive syntax checks to
 * a mappings file.
 * @property filepath The file currently being analysed
 */
class SyntaxHandler(private val filepath: String) {

    /**
     * Reads the assigned file by first removing any comments and indentation, and then separating
     * the statements by a semicolon
     *
     * @return A list with all the statements in the mappings file
     */
    fun getAllStatements() : List<String> {
        return File(this.filepath).bufferedReader().noComments().compact().split(";")
    }

    /**
     * Analyses all the sections and builds a dictionary of statements for each one
     * @param statements The entirety of the statements that exist
     * @return A dictionary containing the section keys mapped to their statements
     */
    fun getSections(statements: List<String> ) : HashMap<String, List<String>> {

        val result = HashMap<String, List<String>>()

        // Gets all the section names present in the mapping file
        val sectionNames = statements.filter { x -> x.startsWith("mappingsfor") }
                                     .map { x -> x.replace("mappingsfor", "").trim() }

        // Iterate over each one, adding the sublist of their contents to their hashmap
        for (section in sectionNames) {

            val startIndex = statements.indexOf("${Keywords.SECTION_DEFINITION}$section")
            val closingIndex = statements.indexOf("${Keywords.SECTION_END}$section")
            result[section] = statements.subList(startIndex+1, closingIndex)
        }

        return result
    }

}