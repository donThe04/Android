class SavingsAccount(
    accountHolder: String,
    initialBalance: Double,
    val interestRate: Double // Đổi tên và giữ lại trong constructor
) : BankAccount(accountHolder, initialBalance), Transactable {
    override fun calculateInterest(): Double {
        return balance * interestRate
    }
    // 4. Custom Getter (Thuộc tính Tính toán)
    val estimatedBalanceNextYear: Double
        get() {
            return balance + calculateInterest()
        }
    // Triển khai Interface: withdraw(amount)
    override fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount //  Cập nhật số dư
            println("Rút tiền thành công. Số dư mới: $balance")
        } else if (amount <= 0) {
            println("Rút tiền thất bại: Số tiền rút phải lớn hơn 0.")
        } else {
            println("Rút tiền thất bại: Số dư $balance không đủ để rút $amount.")
        }
    }
    // Ghi đè Hàm open (Deposit)
    override fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount // Cập nhật số dư
            println("Nạp tiền thành công! Số dư hiện tại: $balance")
        } else {
            println("Nạp tiền thất bại: Số tiền nạp phải lớn hơn 0.")
        }
    }
}
