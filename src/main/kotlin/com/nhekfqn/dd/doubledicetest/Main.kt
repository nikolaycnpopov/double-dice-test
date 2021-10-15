package com.nhekfqn.dd.doubledicetest

import kotlin.random.Random

val iterationsNumber = 10_000_000

fun main() {
    // SIMPLE

    var simplePositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        if (Random.nextInt(100) >= 20) {
            simplePositiveCasesCounter++
        }
    }

    val simplePositiveCaseProbability = simplePositiveCasesCounter.toDouble() / iterationsNumber

    println("Simple '>= 20' Probability: $simplePositiveCaseProbability  ")

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

    println("One-by-one '>= 20' probability: $oneByOnePositiveCaseProbability  ")

    // DOUBLE DICE

    var doubleDicePositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        val firstTrySucceed = Random.nextInt(50) >= 10
        val secondTrySucceed = Random.nextInt(50) >= 10

        if (firstTrySucceed || secondTrySucceed) {
            doubleDicePositiveCasesCounter++
        }
    }

    val doubleDicePositiveCaseProbability = doubleDicePositiveCasesCounter.toDouble() / iterationsNumber

    println("Double dice '>= 10' probability: $doubleDicePositiveCaseProbability  ")

    // PLUS

    var plusPositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        if (Random.nextInt(50) + Random.nextInt(50) >= 20) {
            plusPositiveCasesCounter++
        }
    }

    val plusPositiveCaseProbability = plusPositiveCasesCounter.toDouble() / iterationsNumber

    println("Plus '>= 20' probability: $plusPositiveCaseProbability  ")

    // PLUS DIVIDED

    var plusDividedPositiveCasesCounter = 0

    for (i in 1..iterationsNumber) {
        if ((Random.nextInt(100) + Random.nextInt(100)) / 2 >= 20) {
            plusDividedPositiveCasesCounter++
        }
    }

    val plusDividedPositiveCaseProbability = plusDividedPositiveCasesCounter.toDouble() / iterationsNumber

    println("Plus divided '>= 20' probability: $plusDividedPositiveCaseProbability  ")

    // EFFECTIVE ACCURACIES TABLES

    println("\nEffective accuracies table (step 0.05):\n")

    for (i in 0..100 step 5) {
        val formalAccuracy = i.toDouble() / 100
        println("${formalAccuracy.toString().padEnd(6)}: ${toEffectiveAccuracy(formalAccuracy)}  ")
    }

    println("\nEffective accuracies table (step 0.005):\n")

    for (i in 0..200) {
        val formalAccuracy = i.toDouble() / 200
        println("${formalAccuracy.toString().padEnd(6)}: ${toEffectiveAccuracy(formalAccuracy)}  ")
    }
}

fun toEffectiveAccuracy(formalAccuracy: Double): Double {
    var count = 0
    for (i in 1..iterationsNumber) {
        if ((Random.nextDouble() + Random.nextDouble()) / 2 < formalAccuracy) {
            count++
        }
    }

    return count.toDouble() / iterationsNumber
}
