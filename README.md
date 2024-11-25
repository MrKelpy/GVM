# GVM: Automatic Mapping Manager

This repository introduces the GVM (General Value Mapper), a powerful tool designed to simplify managing mapped values across your project files. With GVM, you can effortlessly automate replacements and transformations, saving you time and effort.

## Installation & Usage
Using GVM is very simple. Download the GVM Installer through the [releases page](https://github.com/MrKelpy/GVM/releases) and run it. Afterwards.:
1. Create your .gvm file (see [GVML](#GVML-General-Value-Mapping-Language))
2. Use `gvm run` to generate your mapped files

## GVML: General Value Mapping Language

**GVML** is a simple, yet powerful language designed to streamline value mapping processes within your projects. It allows you to define mappings for specific files and directories, making it easy to automate replacements and transformations.

### How to Use GVML

1. **Define Sections:** Each section targets a specific set of files.
2. **Set Location and Scope:** Specify the relative path and file patterns for the section.
3. **Define Mappings:** Use key-value pairs to specify old and new values.

### Basic Syntax
####  File Structure and Naming Conventions

* **File Extension:** A GVML file must have the extension `.gvm`.
* **Single File Per Project:** Only one `.gvm` file is allowed per project.

###  Syntax

A GVML file consists of sections. Each section defines mappings for a specific set of files. Here's the syntax breakdown:

```
// Comments (optional)

out ./gvm-out/;

mappings for SECTION_NAME;  // Define the section being mapped

  // Section Properties 
  set location (PATH);  // Define the relative location of files (based on CWD)
  set scope (FILENAME_PATTERNS);  // Define file patterns to be affected

  // Mapping Definitions 
  set mappings (
    "old_value1" -> "new_value1",
    "old_value2" -> "new_value2",
    ...
  );

end SECTION_NAME;  // Close off the section
```

* `SECTION_NAME`: This is a user-defined name for the section. It helps identify the specific set of files being mapped.
* `PATH`: This specifies the relative location of the files affected by the section. The path is relative to the current working directory (CWD). Use forward slashes (/) as path separators.
* `FILENAME_PATTERNS`: This defines a pattern (using wildcards like `*.kt`) to match the file extensions of files impacted by the mappings in the section. You can specify multiple patterns separated by commas (,).

**Mapping Definitions:**

Within the `set mappings` block, define key-value pairs to specify the old values to be replaced with new values in the target files.

* `old_value`: The original value to be searched for in the files.
* `new_value`: The new value that will replace the `old_value` in the files.

**Example:**

```
mappings for UI_Strings;  // Define the section for UI strings

  set location (./src/resources/);  // Set the location to resources directory 
  set scope (*.xml);  // Apply mappings to all XML files

  set mappings (
    "Welcome_Text" -> "Hello World!",  // Replace "Welcome_Text" with "Hello World"
    "Next_Button"  -> "Next"      // Replace "Next_Button" with "Next"
  );

end UI_Strings;
```

This example defines a section for UI strings. It targets all XML files within the `./src/resources/` directory and replaces specific strings with their proper values.

**Other Statement Definitions**

* `out`: This defines the output directory for the mapped project files. Defaults to `"./gvm-out/"`

**Additional Notes:**

* Comments can be added using `//` for better readability.
* Whitespace is generally ignored, but it's recommended to maintain consistent indentation for clarity.

By following this syntax guide, you can effectively use GVML to automate value mapping tasks within your project files.
