interface Transactable {
    fun withdraw(amount: Double)
    fun printStatement(){
        println("Printing transaction summary.")
    }
}