class Expense(val amount: Double, val category: String, val date: String) {
    fun printExpense() {
        println("Дата: $date, Категория: $category, Сумма: $amount")
    }
}

class ExpenseTracker {
    private val expenses = mutableListOf<Expense>()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun printAllExpenses() {
        for (expense in expenses) {
            expense.printExpense()
        }
    }

    fun calculateTotalByCategory(category: String): Double {
        var total = 0.0
        for (expense in expenses) {
            if (expense.category == category) {
                total += expense.amount
            }
        }
        return total
    }
}

fun main() {
    val tracker = ExpenseTracker()

    val expense1 = Expense(100.0, "Еда", "01.09.2024")
    val expense2 = Expense(50.0, "Транспорт", "02.09.2024")
    val expense3 = Expense(200.0, "Еда", "03.09.2024")

    tracker.addExpense(expense1)
    tracker.addExpense(expense2)
    tracker.addExpense(expense3)

    println("Все расходы:")
    tracker.printAllExpenses()

    println("Общая сумма расходов на Еду: ${tracker.calculateTotalByCategory("Еда")}")
    println("Общая сумма расходов на Транспорт: ${tracker.calculateTotalByCategory("Транспорт")}")

}