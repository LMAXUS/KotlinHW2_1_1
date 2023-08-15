fun getCommission(cardType: String = "VK Pay", amount: Double, prevAmount: Double = 0.0): Double{

    val UNDEFINED_CARD_TYPE = -1.0
    val OVERFLOW_DAY_LIMIT = -2.0
    val OVERFLOW_MONTH_LIMIT = -3.0

    return if (amount > 150_000.00) OVERFLOW_DAY_LIMIT
        else if (prevAmount+amount  > 600_000.00) OVERFLOW_MONTH_LIMIT
        else{
            when(cardType){
                "MasterCard", "Maestro" ->
                    if(prevAmount+amount <= 75000.00) 0.0
                    else if(prevAmount >= 75000.00) amount/100.00*0.6+20.00
                    else (prevAmount+amount-75000.00)/100.00*0.6+20.00
                "Visa", "Мир" -> if(amount/100.00*0.75 < 35.00) 35.00 else amount/100.00*0.75
                "VK Pay" ->
                    if(amount > 15_000.00) OVERFLOW_DAY_LIMIT
                    else if (prevAmount+amount  > 40_000.00) OVERFLOW_MONTH_LIMIT
                    else 0.0
                else -> UNDEFINED_CARD_TYPE
            }
       }
}

fun main(){
    println( getCommission("Maestro", 1_000.00, 500_000.0) )
    println( getCommission("Maestro", 70_001.00, 530_000.0) )
    println( getCommission("Maestro", 5_001.00, 70_000.0) )
    println( getCommission("Мир", 10_000.00) )
    println( getCommission("VK Pay", 14_000.00, 30_000.00) )
}