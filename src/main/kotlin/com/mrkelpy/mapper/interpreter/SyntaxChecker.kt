package com.mrkelpy.mapper.interpreter

import java.io.BufferedReader
import java.io.File

/**
 * This class is responsible for reading and performing any preemptive syntax checks to
 * a mappings file.
 * @property filepath The file currently being analysed
 */
class SyntaxHandler(private val filepath: String) {

    /**
     * Runs the syntax checker on the file assigned to the class.
     * The full syntax guide is present in the README.md file.
     */
    fun run() {

    }

    /**
     * Reads the assigned file by first removing any comments and indentation, and then separating
     * the statements by ";"
     *
     * @return A list with all the statements in the mappings file
     */
    fun getAllStatements() : List<String> {

        val reader = File(this.filepath).bufferedReader()
        reader



    }




}