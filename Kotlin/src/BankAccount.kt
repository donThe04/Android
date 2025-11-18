abstract class BankAccount(
    val accountHolder: String,
    var balance: Double
) {
    abstract fun calculateInterest(): Double
    open fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Nap tien thanh cong, so du hien tai la: $balance")
        } else {
            println("Nap tien that bai!")
        }
    }

}