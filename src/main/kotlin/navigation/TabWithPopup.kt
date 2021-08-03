package navigation

// TODO: remove clazz
data class TabWithPopup(
    val title: String,
    val items: List<Screen>,
    val clazz: Class<out Screen>,
)