package com.example.multiplestepflow

/**
 * Visitor pattern
 * Alternatively, sealed class would give me the same effect, probably even cleaner
 */
interface FlowNagivation {
    fun goNext(outputA: OutputA)
    fun goNext(outputB: OutputB)
}