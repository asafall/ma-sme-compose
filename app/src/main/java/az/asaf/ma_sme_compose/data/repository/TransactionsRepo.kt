package az.asaf.ma_sme_compose.data.repository

import az.asaf.ma_sme_compose.data.dto.TransactionDto
import az.asaf.ma_sme_compose.ui.flow.enums.PaymentType

class TransactionsRepo {

    fun getTransactions(): List<TransactionDto> {
        val transactions = ArrayList<TransactionDto>()
        repeat(3) {
            transactions.add(transaction1)
            transactions.add(transaction2)
            transactions.add(transaction3)
            transactions.add(transaction4)
        }
        return transactions
    }

    /**  FAKE DATA -> HARD CODING  */

    private val transaction1 = TransactionDto(
        id = 1,
        paymentType = PaymentType.AZN_PAYMENT,
        customerName = "Any MMC",
        description = "AZ07PAHA098471AZN1111",
        date = "2022.01.06",
        amount = TransactionDto.Amount("AZN", "3512.00")
    )

    private val transaction2 = TransactionDto(
        id = 2,
        paymentType = PaymentType.INTERNAL_PAYMENT,
        customerName = "Random MMC",
        description = "AZ07PAHA34857AZN1111",
        date = "2022.01.06",
        amount = TransactionDto.Amount("AZN", "7436.00")
    )

    private val transaction3 = TransactionDto(
        id = 3,
        paymentType = PaymentType.INTERNATIONAL_PAYMENT,
        customerName = "Next MMC",
        description = "AZ07PAHA089321AZN1111",
        date = "2022.01.06",
        amount = TransactionDto.Amount("AZN", "9356.00")
    )

    private val transaction4 = TransactionDto(
        id = 4,
        paymentType = PaymentType.SALARY,
        customerName = "Nice MMC",
        description = "AZ07PAHA65902AZN1111",
        date = "2022.01.06",
        amount = TransactionDto.Amount("AZN", "23512.00")
    )
}