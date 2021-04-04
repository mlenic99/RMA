import kotlin.random.Random

fun main(args: Array<String>) {
    var rolls : Int = 0
    val hand = Hand()
    println(hand.rollDiceInHand())
}

class Die(var number : Int, var locked : Boolean){
    constructor() : this(1, true)

    fun roll(){
        this.number = Random.nextInt(1, 7)
    }

    override fun toString(): String {
        return "$number "
    }
}

class Hand(var handRoll : MutableList<Die> = mutableListOf(Die(), Die(), Die(), Die(), Die(), Die()),
           var numOfRolls : Int = 0){

    fun rollDiceInHand(){

        if(numOfRolls == 3) {
            for (die in handRoll)
                die.locked
            numOfRolls = 0
        }

        for(die in handRoll){
            if(!die.locked){
                die.roll()
                println("You rolled: ")
                println(die.number)
            }
            else{
                println("You're holding: ")
            }
        }
        numOfRolls++
    }

    fun checkScore(){

        var result = mutableListOf<Int>()
        var score : Int = 0
        for(die in handRoll){
            if(die.locked){
                result.add(die.number)
            }
        }

        if(result.count() == 6 && result.distinct().count() == 1){
            score += 50
            println("Jamb. Your score is $score")
        }
        if(result.count() == 5 && result.distinct().count() == 1){
            score += 40
            println("Poker. Your score is $score")
        }
        else{
            println("You've got something but it's not poker or jamb")
        }
    }
}