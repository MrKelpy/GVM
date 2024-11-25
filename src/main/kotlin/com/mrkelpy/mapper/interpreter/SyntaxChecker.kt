package com.mrkelpy.mapper.interpreter

import com.mrkelpy.mapper.exceptions.GVMLInvalidInstructionException
import com.mrkelpy.mapper.exceptions.GVMLInvalidSectionException
import com.mrkelpy.mapper.interpreter.enums.Keywords

/**
 * This class is responsible for performing any actual syntax checks in the program
 */
class SyntaxChecker {

    companion object {

        /**
         * Goes through every statement and checks if the syntax written is according to the specifications.
         * This method doesn't go too deep, and is only a basic check for the general structure
         * @return Whether the syntax is generally correct or not
         */
        fun List<String>.checkBasicSyntax() : Boolean {
            this.checkSectionDefinitionSyntax()
            return true
        }

        /**
         *
         */
        private fun List<String>.checkOuterDefinitionSyntax() {

        }

        /**
         * Checks the syntax for the section definitions
         */
        private fun List<String>.checkSectionDefinitionSyntax() {

            // Gets all the section names present in the mapping file
            val openingInstructions = this.filter { x -> x.startsWith(Keywords.SECTION_DEFINITION.value) }
            val sectionNames = openingInstructions.map { x -> x.replace(Keywords.SECTION_DEFINITION.value, "").trim() }

            // Checks if any section name is empty
            val emptySectionName = openingInstructions.firstOrNull { x -> x.isEmpty() }
            if (emptySectionName != null) throw GVMLInvalidSectionException("Empty section name found.")

            // Checks if every opening instruction contains a closing statement
            val missingCloseStatement = sectionNames.firstOrNull { name -> !this.contains(Keywords.SECTION_END.value + name) }
            if (missingCloseStatement != null) throw GVMLInvalidSectionException("Missing closing statement for \"$missingCloseStatement\"")

            // Checks if there is a hanging end statement
            val extraEndStatement = this.firstOrNull { x -> x.startsWith(Keywords.SECTION_END.value) && !this.contains(Keywords.SECTION_DEFINITION.value + x.replace(
                Keywords.SECTION_END.value, "")) }

            if (extraEndStatement != null) throw GVMLInvalidSectionException("No opening statement found for \"${extraEndStatement.replace(
                Keywords.SECTION_END.value, "")}\" defined in END")
        }

        /**
         * Checks if all the instructions within every section are registered.
         * Throws if it's invalid.
         */
        fun HashMap<String, List<String>>.verifyInstructionValidity(){

            // If the instruction is found within the registry, continue on.
            for (entry in this) {

                var lastInstruction = "" // Saves the last instruction resetting it every time for debugging purposes

                for (instruction in entry.value) {

                    lastInstruction = instruction
                    if (Keywords.hasKeyword(instruction)) continue;

                    // If we never continue, then the instruction wasn't found.
                    throw GVMLInvalidInstructionException("Invalid keyword \"$lastInstruction\" defined within section \"${entry.key}\"")
                }
            }

        }

    }


}