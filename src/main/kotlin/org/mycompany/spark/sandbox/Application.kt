package org.mycompany.spark.sandbox

import org.jetbrains.kotlinx.spark.api.withCached
import org.jetbrains.kotlinx.spark.api.withSpark

fun main() {
    withSpark {
        dsOf(0, 1, 2, 4, 5, 6).withCached {
            println("File contains ${count()} lines")
        }
    }
}