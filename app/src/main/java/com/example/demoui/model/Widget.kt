package com.example.demoui

data class Widget(
    var widgetBgColor: String?,
    var widgetTitleConfig:WidgetTitleConfig?,
    var widgetSubTitleConfig: WidgetSubTitleConfig?,
    var timerConfig: TimerConfig?,
    var collectionTitleConfig: CollectionTitleConfig?,
    var collectionSubTitleConfig: CollectionSubTitleConfig?,
    var topSepratorEnable: Boolean?,
    var bottomSepratorEnable: Boolean?,
    var ascpectRatio: Double?,
    var image_fit:String?,
    var viewMore: ViewMore?,
    var linesToShow: Int?,
    var pagename: String?,
    var tupleBorder: Boolean?,
    var collections: List<Item>,
    var slot:Int?,
    var design: String?
)
data class WidgetTitleConfig(
    var text:String?,
    var textColor:String?,
    var visibility: Boolean?
)
data class WidgetSubTitleConfig (
    var text: String?,
    var textColor: String?,
    var visibility: Boolean
        )
data class TimerConfig(
    var startTimeEpoc:Long?,
    var endTimeEpoc: Long?,
    var textColor: String?,
    var visibility: Boolean?
)
data class CollectionTitleConfig(
    var textColor: String?,
    var visibility: Boolean?
)

data class CollectionSubTitleConfig(
    var textColor: String?,
    var visibility: Boolean?
)
data class ViewMore(
    var visibility: Boolean?,
    var viewMoreText: String?,
    var viewLessText: String?,
    var textColor: String?
)
data class Item(
    var tileId: Long?,
    var position: Int?,
    var tileTitle: String?,
    var tileSubTitle: String?,
    var imgUrl: String?,
    var landingUrl: String?,
    var keyfeature: String?
)