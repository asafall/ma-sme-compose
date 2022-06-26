package az.asaf.ma_sme_compose.ui.flow.tabs.main

import androidx.lifecycle.ViewModel
import az.asaf.ma_sme_compose.data.repository.CumulativeAccountsRepo
import az.asaf.ma_sme_compose.data.repository.TemplatesRepo
import az.asaf.ma_sme_compose.data.repository.TransactionsRepo
import az.asaf.ma_sme_compose.data.repository.UserInfoRepo

class MainViewModel(
    private val userInfoRepo: UserInfoRepo = UserInfoRepo(), // without di
    private val cumulativeAccountsRepo: CumulativeAccountsRepo = CumulativeAccountsRepo(),
    private val templatesRepo: TemplatesRepo = TemplatesRepo(),
    private val transactionsRepo: TransactionsRepo = TransactionsRepo()
): ViewModel() {

    private val _userInfo = userInfoRepo.getUserInfo()
    val userInfo get() = _userInfo

    private val _cumulativeAccounts = cumulativeAccountsRepo.getCumulativeAccounts()
    val cumulativeAccounts get() = _cumulativeAccounts

    private val _unsignedPaymentsCount = "5"
    val unsignedPaymentsCount get() = _unsignedPaymentsCount

    private val _templates = templatesRepo.getTemplates()
    val templates get() = _templates

    private val _transactions = transactionsRepo.getTransactions()
    val transactions get() = _transactions

}