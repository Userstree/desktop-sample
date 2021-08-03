package navigation

import com.arkivanov.decompose.statekeeper.Parcelable

sealed class Screen(val title: String) : Parcelable {
    object Home : Screen("Home")
    object Logs : Screen("Logs")
    sealed class Staff(title: String) : Screen(title) {
        object Masters : Staff("Masters")
        object Admins : Staff("Admins")
        object OtherStaff : Staff("OtherStaff")
        object WorkingHours : Staff("WorkingHours")
        object Salaries : Staff("Salaries")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Staff",
                items = listOf(Masters, Admins, OtherStaff, WorkingHours, Salaries),
                clazz = Staff::class.java
            )
        }

    }

    sealed class Client(title: String) : Screen(title) {
        object Clients : Client("Clients")
        object Reservations : Client("Reservations")
        object Groups : Client("Groups")
        object Loyalties : Client("Loyalties")
        object Feedback : Client("Feedback")
        object Notifications : Client("Notifications")
        object SmsMailing : Client("SmsMailing")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Client",
                items = listOf(Clients, Reservations, Groups, Loyalties, Feedback, Notifications, SmsMailing),
                clazz = Staff::class.java,
            )
        }

    }

    sealed class Service(title: String) : Screen(title) {
        object Services : Service("Services")
        object TechnologyMaps : Service("TechnologyMaps")
        object SalesDeals : Service("SalesDeals")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Service",
                items = listOf(Services, TechnologyMaps, SalesDeals),
                clazz = Staff::class.java,
            )
        }
    }

    sealed class Statistics(title: String) : Screen(title) {

        object ReservationStatistics : Statistics("ReservationStatistics")
        object Sources : Statistics("Sources")
        object ServiceStatistics : Statistics("ServiceStatistics")
        object MapStatistics : Statistics("MapStatistics")
        object ClientStatistics : Statistics("ClientStatistics")
        object Returnability : Statistics("Returnability")
        object Marketplace : Statistics("Marketplace")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Statistics",
                items = listOf(
                    ReservationStatistics,
                    Sources,
                    ServiceStatistics,
                    MapStatistics,
                    ClientStatistics,
                    Returnability,
                    Marketplace
                ),
                clazz = Staff::class.java,
            )
        }
    }

    sealed class Storage(title: String) : Screen(title) {
        object Nomenclature : Storage("Nomenclature")
        object Sales : Storage("Sales")
        object TurnOver : Storage("TurnOver")
        object Revision : Storage("Revision")
        object StorageReport : Storage("StorageReport")
        object Settings : Storage("Settings")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Storage",
                items = listOf(Nomenclature, Sales, TurnOver, Revision, StorageReport, Settings),
                clazz = Staff::class.java,
            )
        }
    }

    sealed class Finance(title: String) : Screen(title) {
        object Accounts : Finance("Accounts")
        object MoneyFlow : Finance("MoneyFlow")
        object Income : Finance("Income")
        object Expense : Finance("Expense")
        object Reports : Finance("Reports")
        companion object {
            fun getTab() = TabWithPopup(
                title = "Finance",
                items = listOf(Accounts, MoneyFlow, Income, Expense, Reports),
                clazz = Staff::class.java,
            )
        }
    }

    object Settings : Screen("Settings")
    sealed class Help(title: String) : Screen(title) {
        object Feedback : Help("Feedback")
        object Support : Help("Support")
        object Documentation : Help("Documentation")
        object VideoInstructions : Help("VideoInstructions")

        companion object {
            fun getTab() = TabWithPopup(
                title = "Staff",
                items = listOf(Feedback, Support, Documentation, VideoInstructions),
                clazz = Staff::class.java,
            )
        }

    }

    object Profile : Screen("Profile")
}