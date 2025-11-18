fun main(){
    val myAccount = SavingsAccount("Dong Van The", 12000000.0,0.02)
    println("Khoi tao tai khoan thanh cong")
    println("Chu la ${myAccount.accountHolder}")
    println("So du ban dau la: ${myAccount.balance}")
    println("Lai suat la: ${myAccount.calculateInterest()}")
    println("So du uoc tinh nam: ${myAccount.estimatedBalanceNextYear}")
    myAccount.withdraw(120.0)
    myAccount.deposit(300.0)
}
