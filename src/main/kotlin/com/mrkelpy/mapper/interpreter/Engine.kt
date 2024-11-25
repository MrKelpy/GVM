package com.mrkelpy.mapper.interpreter

import com.mrkelpy.mapper.exceptions.GVMException
import com.mrkelpy.mapper.interpreter.SyntaxChecker.Companion.checkBasicSyntax
import com.mrkelpy.mapper.interpreter.SyntaxChecker.Companion.verifyInstructionValidity
import java.io.File

/**
 * This class is responsible for interpreting
 */
class Engine {

    // Defines the frequently needed and most important values for the interpreter
    companion object {
        internal const val EXTENSION = "gvm"
    }

    /**
     * Runs the interpreter on a given file, from a given working directory
     * @param filename The name of the file being interpreted
     * @param cwd The current working dictionary
     */
    fun run(filename: String, cwd: String) : List<Array<Int>>{

        val handler = SyntaxHandler(getMappingsFile(cwd))

        // Get every statement and run a syntax check
        val statements = handler.getAllStatements()
        statements.checkBasicSyntax()

        // Get the sections and check if all the instructions defined within are registered
        val sections = handler.getSections(statements)
        sections.verifyInstructionValidity()

        return listOf()
    }

    /**
     * Looks in the current working directory for a file to be interpreted
     * @cwd The full path to the current working directory
     * @return The full path to the mappings file, or null if not found
     */
    private fun getMappingsFile(cwd: String) : String {

        val files = File(cwd).listFiles()!!
        val filecount = files.count { x -> x.extension == EXTENSION }

        if (filecount != 1) throw GVMException("There must only be ONE .gvm mappings file within the project in order to use GVM. Found $filecount in ${File(cwd).absolutePath}")

        for (file in files) {
            if (file.extension == EXTENSION) return file.absolutePath
        }

        throw GVMException("Could not find a \".$EXTENSION\" file within \"$cwd\"")
    }
}