(ns com.walmartlabs.lacinia.protocols
  ""
  {:added "0.38.0"})

(defprotocol Field)

(defprotocol QualifiedName
  (qualified-name [named]
    "Returns a keyword whose namespace is the containing element; e.g., :User/id for the id field of the User type."))

(defprotocol Arguments

  "Implemented by [[Directive]]."

  (arguments [element]
    "Returns a map of keyword name to value.  May return nil if no arguments.

     The value may reflect query variables or argument defaults."))

(defprotocol Directive

  "Implements [[Arguments]]."

  (directive-type [d]
    "Returns the type of directive as a keyword."))

(defprotocol Directives
  "An element that may contain directives."

  (directives [element]
    "Returns a map of directives for this element; keys are keywords, values are a seq of Directive.

    May return nil."))

(defprotocol SelectionSet

  "An selection that may contain sub-selections.  FieldSelection specializes this."

  (field-selection? [selection])

  (selections [selection]
    "Returns a seq of sub-selections of this field selection."))

(defprotocol FieldSelection

  "A SelectionSet that extracts a value from a field and records it into the
   result as a name or alias; for non-scalar types, may have sub-selections."

  (field-name [fs]
    "Returns the name of the field (as an unqualified keyword).")

  (alias-name [fs]
    "Returns the alias for the field selection, or name of the field."))


