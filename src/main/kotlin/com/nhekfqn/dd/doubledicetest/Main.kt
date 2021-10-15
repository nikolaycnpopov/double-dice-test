package com.nhekfqn.dd.doubledicetest

import kotlin.random.Random

fun main() {
    val iterationsNumber = 1_000_000

    // SIMPLE

    var simplePositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        if (Random.nextInt(100) >= 20) {
            simplePositiveCasesCounter++
        }
    }

    val simplePositiveCaseProbability = simplePositiveCasesCounter.toDouble() / iterationsNumber

    println("Simple '>= 20' Probability: $simplePositiveCaseProbability")

    // ONE-BY-ONE

    var oneByOnePositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        val firstTrySucceed = Random.nextInt(100) >= 20

        if (firstTrySucceed) {
            oneByOnePositiveCasesCounter++
        } else {
            val secondTrySucceed = Random.nextInt(100) >= 20

            if (secondTrySucceed) {
                oneByOnePositiveCasesCounter++
            }
        }
    }

    val oneByOnePositiveCaseProbability = oneByOnePositiveCasesCounter.toDouble() / iterationsNumber

    println("One-by-one '>= 20' probability: $oneByOnePositiveCaseProbability")

    // DOUBLE DICE

    var doubleDicePositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        val firstTrySucceed = Random.nextInt(100) >= 20
        val secondTrySucceed = Random.nextInt(100) >= 20

        if (firstTrySucceed || secondTrySucceed) {
            doubleDicePositiveCasesCounter++
        }
    }

    val doubleDicePositiveCaseProbability = doubleDicePositiveCasesCounter.toDouble() / iterationsNumber

    println("Double dice '>= 20' probability: $doubleDicePositiveCaseProbability")
}
