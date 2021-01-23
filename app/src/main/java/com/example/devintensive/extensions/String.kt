package com.example.devintensive.extensions

fun String.truncate(num: Int = 16) : String {
    return if (this.trimEnd().length < num) {
        this.trimEnd()
    } else {
        "${this.substring(0, num).trimEnd()}..."
    }
}

fun String.stripHtml() : String {
    return this.trimIndent().stripHtmlLetter(0, tag = false, escape = false).trimIndent()
        .trimSpaces(0, space = false)
}

fun String.trimSpaces(index: Int, space: Boolean) : String {
    if (index == this.length) return ""
    return if (this[index] == ' ' && space) {
        this.trimSpaces(index + 1, space = true)
    } else {
        this[index] + this.trimSpaces(index + 1, space = this[index] == ' ')
    }
}

fun String.stripHtmlLetter(index: Int, tag: Boolean, escape: Boolean) : String{
    if (index == this.length) return ""
    var nextTag: Boolean = tag
    var nextEscape: Boolean = escape
    var show: Boolean = !tag && !escape
    if (tag && this[index] == '>') {
        nextTag = false
    } else if (!tag && this[index] == '<') {
        nextTag = true
        show = false
    } else if (escape && this[index] == ';') {
        nextEscape = false
    } else if (!escape && this[index] == '&') {
        nextEscape = true
        show = false
    }
    return if (show) {
        this[index] + stripHtmlLetter(index + 1, nextTag, nextEscape)
    } else {
        stripHtmlLetter(index + 1, nextTag, nextEscape)
    }
}