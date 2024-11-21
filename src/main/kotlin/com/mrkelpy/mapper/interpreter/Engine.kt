package com.mrkelpy.mapper.interpreter

import java.io.File

/**
 * This class is responsible for interpreting
 */
class Engine {

    // Defines the frequently needed and most important values for the interpreter
    companion object {
        internal const val extension = ".gvm"
    }

    /**
     * Runs the interpreter on a given file, from a given working directory
     * @param filename The name of the file being interpreted
     * @param cwd The current working dictionary
     */
    fun match(filename: String, cwd: String) : List<Array<Int>>{

        val mappingsSource = this.getMappingsFile(cwd)

        return listOf()
    }

    /**
     * Looks in the current working directory for a file to be interpreted
     * @cwd The full path to the current working directory
     * @return The full path to the mappings file, or null if not found
     */
    private fun getMappingsFile(cwd: String) : String? {

        for (file in File(cwd).listFiles()!!) {
            if (file.extension == extension) return file.absolutePath
        }

        return null
    }
}