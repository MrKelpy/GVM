package com.mrkelpy.mapper.utils

import java.io.BufferedReader

/**
 * This class is responsible for implementing useful classes for reading files.
 */
class ReadingUtils {

    companion object {

        /**
         * Remove all the break lines and double spaces in a given string, compacted to a flat and spaceless one-liner
         *
         * @return A string containing the entire file compacted down to one line
         */
        fun String.compact() : String {

            var flattened = this.replace("\n", "")
            flattened = flattened.replace(" ", "")
            flattened = flattened.replace("\t", "")

            return flattened.trim()
        }

        /**
         * Removes all the comments in the given file
         *
         * @return A string containing the text with no comments
         */
        fun BufferedReader.noComments() : String {

            var result = ""

            for (line in this.readLines())
                result += line.split("//")[0] + "\n"

            return result.trim()
        }



    }

}