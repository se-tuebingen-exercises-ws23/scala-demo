object myAccount {
  private var currentBalance = 0
  def deposit(amount: Int) = currentBalance = currentBalance + amount
  def balance(): Int = currentBalance
}

myAccount.balance()
myAccount.deposit(10)
myAccount.balance()

object myRichAccount {
  private var currentBalance = 1000
  def deposit(amount: Int) = currentBalance = currentBalance + amount
  def balance(): Int = currentBalance
}

myRichAccount.balance()
myRichAccount.deposit(10)
myAccount.balance()


// class Account(init: Int) {
//   private var currentBalance = init
//   def deposit(amount: Int) = currentBalance = currentBalance + amount
//   def balance(): Int = currentBalance
// }

// val a = Account(10)

// a.balance()


trait Account {
  def deposit(amount: Int): Unit
  def balance(): Int
}

class SavingsAccount(init: Int) extends Account {
  private var currentBalance = init
  def deposit(amount: Int) = currentBalance = currentBalance + amount
  def balance(): Int = currentBalance
}

class CheckingAccount(init: Int) extends SavingsAccount(init) {
  def withdraw(amount: Int) = deposit(amount * -1)
}

class TaxAccount(init: Int) extends Account {
  private var transaction = List(init)
  def deposit(amount: Int) = transaction = amount +: transaction
  def balance(): Int = transaction.sum
  def history(): List[Int] = transaction
}

def useAccount(a: Account) = {
  a.deposit(10)
  a.balance()
}

useAccount(SavingsAccount(10))
useAccount(TaxAccount(10))

// Demonstration of the evaluation order (not super important to understand right now)
def special(n: Int, m: => Int) =
  m
  m
  m
  n + m

special({ println("hello"); 1 }, { println("world"); 2})
