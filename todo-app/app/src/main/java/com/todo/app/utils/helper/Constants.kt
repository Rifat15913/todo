package com.todo.app.utils.helper

/**
 * This is a class that contains all the needed constants
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
class Constants {
    class Invalid {
        companion object {
            const val INVALID_INTEGER: Int = -1
            const val INVALID_LONG: Long = -1
        }
    }

    class Default {
        companion object {
            const val DEFAULT_STRING: String = ""
            const val DEFAULT_INTEGER: Int = 0
            const val DEFAULT_FLOAT: Float = 0.0f
            const val DEFAULT_LONG: Long = 0
            const val DEFAULT_BOOLEAN: Boolean = false
            const val DEFAULT_LANGUAGE: String = "en"
            const val TRUE_INTEGER: Int = 1
            const val FALSE_INTEGER: Int = 0
            const val SPACE_STRING: String = " "
        }
    }

    class Common {
        companion object {
            const val BASE_URL_DEV = "makkahbag.com"
            const val BASE_URL_RELEASE = "new.makkahbag.com"
            const val BASE_URL_TEST = "ttt.makkahbag.com"
            const val DEVICE_TYPE_ANDROID = 1
            const val PROPER_BASE_URL = "http://orion.tstaffs.com/"
            const val PATH_SEGMENT_API = "api"
            const val PATH_SEGMENT_SLASH = ""
            const val PROVIDER_FACEBOOK = "facebook"
            const val PROVIDER_GOOGLE = "google"
            const val PROVIDER_LINKED_IN = "linkedin"
            const val PROVIDER_TWITTER = "twitter"
            const val SECRET_KEY_SOCIAL_LOGIN =
                "EAAHL9ZCOZBc9QBABmRgxdOzkIpeYPZAO1t1al8UG0xMVA2GNXC2KKrLxzt3nxGJElrB4ZBURk1C2y8ZC2zKYZCgZC1dTkZCagX4mzE1YksWRY7mBSJXEvvSZAcjIojZCWl16N7eolJLZAlVoIM2qqfgVUv0ZBZATCCmL3a2iVX9PuQAEVTb85hBxbPDtSJmKwo2hrEUc7sqQ3VrIy7hwHJ030MPGzbCNvZCOro1GQZD"
            const val HTTP = "http"
            const val HTTPS = "https"
            const val IMAGE_STORING_SUFFIX = ".png"
            const val NEW_LINE_CHARACTER = "\n"
            const val IMAGE_STORING_PREFIX = "share_image_"
            const val DEVICE_TYPE = "android"
            const val COMMA = ","
            const val FIRST_BRACKET = "("
            const val API_SECRET_CODE = "EH5m5%\$+3V\$7Ue4j3*Kc5UzA4Mq7TXEt8a!8^AJ#"
            const val ANDROID_HASH_KEY = "Hash Key"
            const val PLAIN_TEXT_MIME_TYPE = "text/plain"
            const val PNG_IMAGE_MIME_TYPE = "image/png"
            const val ALL_IMAGE_MIME_TYPE = "image/*"
            const val JPEG_IMAGE_MIME_TYPE = "image/jpeg"
            const val COMMON_TIME_ZONE = "UTC"
            const val APP_COMMON_DATE_FORMAT: String = "yyyy-MM-dd HH:mm"
            const val APP_PROFILE_DATE_FORMAT: String = "yyyy-MM-dd"
            const val APP_COMMON_ONLY_DATE_FORMAT: String = "yyyy-MM-dd"
            const val APP_COMMON_TIME_FORMAT: String = "hh:mm a"
            const val APP_COMMON_DAY_FORMAT: String = "E"
            const val APP_COMMON_MONTH_FORMAT: String = "MMM"
            const val ALIGNMENT_LEFT: String = "left"
            const val ALIGNMENT_RIGHT: String = "right"
            const val ALIGNMENT_INHERIT: String = "inherit"
            const val ROLE = "Bearer "
            const val TELEPHONE_URI_STARTING = "tel:"
            const val GOOGLE_DOC_TOOLBAR_REMOVING_URL = "javascript:(function() { " +
                    "document.querySelector('[role=\"toolbar\"]').remove();" +
                    "})()"
            const val PREFIX_PDF_LOADING_URL = "https://docs.google.com/gview?embedded=true&url="
            const val BASE_URL_APP_RESOURCES = "file:///android_res/"
            const val HTML_JUSTIFIED_STYLE = "<html>" +
                    "<style type='text/css'>" +
                    "@font-face {" +
                    "font-family: MyFont;" +
                    "src: url('font/regular.ttf')" +
                    "}" +
                    "body {" +
                    "margin: 0;" +
                    "line-height: 1.5;" +
                    "padding: 0;" +
                    "font-family: MyFont;" +
                    "font-size: 14px;" +
                    "text-align: justify;" +
                    "color: #434343" +
                    "}" +
                    "</style>" +
                    "<body>%s" +
                    "</body>" +
                    "</html>"
            const val HTML_SMALL_JUSTIFIED_STYLE = "<html>" +
                    "<style type='text/css'>" +
                    "@font-face {" +
                    "font-family: MyFont;" +
                    "src: url('font/raleway_regular.ttf')" +
                    "}" +
                    "body {" +
                    "margin: 0;" +
                    "line-height: 1.5;" +
                    "padding: 0;" +
                    "font-family: MyFont;" +
                    "font-size: 12px;" +
                    "text-align: justify;" +
                    "color: #FFFFFF" +
                    "}" +
                    "</style>" +
                    "<body>%s" +
                    "</body>" +
                    "</html>"
            const val HTML_MIME_TYPE = "text/html"
            const val HTML_ENCODING = "UTF-8"
            const val TWEET_URL = "https://twitter.com/intent/tweet?text="
            const val TWITTER_APPENDING_URL_PREFIX = "&url="
            const val TWITTER_APPENDING_VIA_PREFIX = "&via="
            const val TWITTER_APPENDING_HASHTAGS_PREFIX = "&hastags="
            const val TWITTER_ANDROID_APP_PACKAGE_PREFIX = "com.twitter"
            const val FACEBOOK_SHARING_URL = "https://www.facebook.com/sharer/sharer.php?u="
            const val FACEBOOK_ANDROID_APP_PACKAGE_PREFIX = "com.facebook.katana"
            const val INSTAGRAM_ANDROID_APP_PACKAGE_PREFIX = "com.instagram.android"
            const val WHATSAPP_ANDROID_APP_PACKAGE_PREFIX = "com.whatsapp"
            const val PRODUCT_TYPE_BIDS = 2
            const val PRODUCT_TYPE_SOFTWARE = 1
        }
    }

    class TableNames {
        companion object {
            const val USER = "USER"
            const val SOFTWARE = "SOFTWARE"
        }
    }

    class ColumnNames {
        companion object {
            const val ID = "ID"
            const val SOFTWARE_ID = "SOFTWARE_ID"
            const val USER_ID = "USER_ID"
            const val USER_NAME = "USER_NAME"
            const val TITLE = "TITLE"
            const val DESCRIPTION = "DESCRIPTION"
            const val SPEED_PER_SECOND = "SPEED_PER_SECOND"
            const val CORES = "CORES"
            const val CONSUMER_RANKING_POINTS = "CONSUMER_RANKING_POINTS"
            const val PRICE_PER_MONTH = "PRICE_PER_MONTH"
            const val PRICE_PER_YEAR = "PRICE_PER_YEAR"
            const val IMAGE = "IMAGE"
            const val FIRST_NAME = "FIRST_NAME"
            const val LAST_NAME = "LAST_NAME"
            const val EMAIL = "EMAIL"
            const val I_AM = "I_AM"
            const val ID_OR_PASSPORT_NUMBER = "ID_OR_PASSPORT_NUMBER"
            const val VAT_ID = "VAT_ID"
            const val PHONE_NUMBER = "PHONE_NUMBER"
            const val FISCAL_COUNTRY = "FISCAL_COUNTRY"
            const val COUNTRY = "COUNTRY"
            const val GENDER = "GENDER"
            const val MARITAL_STATUS = "MARITAL_STATUS"
            const val DATE_OF_BIRTH = "DATE_OF_BIRTH"
            const val ZIP_CODE = "ZIP_CODE"
            const val CITY = "CITY"
            const val FULL_ADDRESS = "FULL_ADDRESS"
            const val PHOTO = "PHOTO"
            const val IS_PASSPORT_VERIFIED = "IS_PASSPORT_VERIFIED"
            const val IS_NID_VERIFIED = "IS_NID_VERIFIED"
            const val IS_UTILITY_BILL_VERIFIED = "IS_UTILITY_BILL_VERIFIED"
            const val STATE = "STATE"
            const val NUMBER = "NUMBER"
            const val COMPLEMENT = "COMPLEMENT"
        }
    }

    class File {
        companion object {
            const val PREFIX_IMAGE = "IMG_"
            const val PREFIX_CROPPED_IMAGE = "IMG_CROPPED_"
            const val SUFFIX_IMAGE = ".jpg"
        }
    }

    class JsonKeys {
        companion object {
            const val DATA = "data"
            const val MESSAGE = "message"
            const val SUCCESS = "success"
            const val COUNTRIES = "countries"
            const val CODE = "code"
            const val CODE_AR = "code_ar"
            const val CODE_FR = "code_fr"
            const val CODE_UR = "code_ur"
            const val NAME = "name"
            const val NAME_AR = "name_ar"
            const val NAME_FR = "name_fr"
            const val NAME_UR = "name_ur"
            const val TELE_CODE = "tele_code"
            const val ACCESS_TOKEN = "access_token"
            const val USER_INFO = "user_info"
            const val USER_EMAIL = "user_email"
            const val CATEGORY_LIST = "category_list"
            const val ID = "id"
            const val CATEGORY_NAME_EN = "category_name_en"
            const val CATEGORY_NAME_AR = "category_name_ar"
            const val CATEGORY_NAME_FR = "category_name_fr"
            const val CATEGORY_NAME_UR = "category_name_ur"
            const val IMAGE_NAME = "imageName"
            const val CREATED_AT = "created_at"
            const val IS_OFFER = "is_offer"
            const val USER = "user"
            const val EMAIL = "email"
            const val FULL_NAME = "full_name"
            const val COUNTRY = "country"
            const val FNAME = "fname"
            const val LNAME = "lname"
            const val GENDER = "gender"
            const val MOBILENO = "mobileno"
            const val BANNER_LIST = "banner_list"
            const val BAG_LIST = "bag_list"
            const val CATEGORY_ID = "cat_id"
            const val PRODUCT_HEADING_EN = "pro_heading_en"
            const val PRODUCT_HEADING_FR = "pro_heading_fr"
            const val PRODUCT_HEADING_AR = "pro_heading_ar"
            const val PRODUCT_HEADING_UR = "pro_heading_ur"
            const val PRODUCT_DESCRIPTION_EN = "pro_description_en"
            const val PRODUCT_DESCRIPTION_FR = "pro_description_fr"
            const val PRODUCT_DESCRIPTION_AR = "pro_description_ar"
            const val PRODUCT_DESCRIPTION_UR = "pro_description_ur"
            const val PRODUCT_PRICE = "pro_price"
            const val PRODUCT_STATUS = "product_status"
            const val SHIPPING_CHARGE = "shipping_charge"
            const val DISCOUNT = "discount"
            const val MEN_OR_WOMEN = "men_or_women"
            const val PRODUCT_SIZE = "pro_size"
            const val CROSS_PROD = "cross_prod"
            const val COLOR_ID = "color_id"
            const val BASIC_BAG = "basic_bag"
            const val BASIC_BAG_PARENT_ID = "basic_bag_parent_id"
            const val DISCOUNT_PERCENTAGE = "discount_percentage"
            const val CURRENT_PRICE = "currentprice"
            const val CURRENT_PRICE_NEW = "current_price"
            const val SUB_TOTAL_PRICE = "sub_total_price"
            const val OLD_PRICE = "oldprice"
            const val BANNER = "banner"
            const val HEADING_EN = "heading_en"
            const val HEADING_FR = "heading_fr"
            const val HEADING_AR = "heading_ar"
            const val HEADING_UR = "heading_ur"
            const val BUTTON_BACKGROUND_COLOR_EN = "button_bgcolor_en"
            const val BUTTON_BACKGROUND_COLOR_FR = "button_bgcolor_fr"
            const val BUTTON_BACKGROUND_COLOR_AR = "button_bgcolor_ar"
            const val BUTTON_BACKGROUND_COLOR_UR = "button_bgcolor_ur"
            const val BUTTON_TEXT_COLOR_EN = "button_txtcolor_en"
            const val BUTTON_TEXT_COLOR_FR = "button_txtcolor_fr"
            const val BUTTON_TEXT_COLOR_AR = "button_txtcolor_ar"
            const val BUTTON_TEXT_COLOR_UR = "button_txtcolor_ur"
            const val BUTTON_ALIGN_EN = "button_align_en"
            const val BUTTON_ALIGN_FR = "button_align_fr"
            const val BUTTON_ALIGN_AR = "button_align_ar"
            const val BUTTON_ALIGN_UR = "button_align_ur"
            const val ACTIVATE = "activate"
            const val CURRENT_PAGE = "current_page"
            const val PRODUCT_LIST = "product_list"
            const val LAST_PAGE = "last_page"
            const val REVIEWS = "reviews"
            const val PRODUCT_ID = "product_id"
            const val USER_ID = "user_id"
            const val PRODUCT_DESCRIPTION = "product_description"
            const val REVIEW_NAME = "review_name"
            const val REVIEW_EMAIL = "review_email"
            const val REVIEW_IP = "review_ip"
            const val REVIEW_STAR = "review_star"
            const val IS_READ = "is_read"
            const val REVIEW_COUNT = "review_count"
            const val STAR = "star"
            const val PRODUCT = "product"
            const val CATEGORY_NAME = "cat_name"
            const val CATEGORY = "category"
            const val CART = "cart"
            const val CART_LIST = "cart_list"
            const val CART_COUNT = "cart_count"
            const val TOTAL_PRICE = "total_price"
            const val TOTAL_DISCOUNT = "total_discount"
            const val GIFT_CARD_ID = "gift_card_id"
            const val QUANTITY = "quantity"
            const val PRODUCT_TYPE = "product_type"
            const val SHOE_SIZE = "shoe_size"
            const val THOBE_SIZE = "thobe_size"
            const val ABAYA_SIZE = "abaya_size"
            const val GIFT_TYPE = "gift_type"
            const val SHOP_LIST = "shop_list"
            const val WISH_LIST = "wish_list"
            const val CURRENCY = "currency"
            const val LANGUAGE = "language"
            const val ADDRESS = "address"
            const val CITY = "city"
            const val AREA = "area"
            const val STREET = "street"
            const val BUILDING = "building"
            const val MOBILE_NUMBER = "mobile_number"
            const val LOCATION_TYPE = "location_type"
            const val SHIPPING_NOTE = "shipping_note"
            const val STATE = "state"
            const val ZIPCODE = "zipcode"
            const val COUNTRY_CODE = "country_code"
            const val COUNTRY_NAME = "country_name"
            const val FIRST_NAME = "first_name"
            const val LAST_NAME = "last_name"
            const val COUPON_DISCOUNT = "coupon_discount"
            const val GIFT_CARD_DISCOUNT = "gift_card_discount"
            const val WALLET_USAGES = "wallet_usages"
            const val LIST = "list"
            const val CARD_NAME_EN = "card_name_en"
            const val CARD_NAME_FR = "card_name_fr"
            const val CARD_NAME_AR = "card_name_ar"
            const val CARD_NAME_UR = "card_name_ur"
            const val RECIPIENT_ID = "rec_id"
            const val CARD_TYPE = "card_type"
            const val OCC_ID = "occ_id"
            const val ATTACHMENT = "attachment"
            const val CARD_PRICE = "card_price"
            const val PRICE = "price"
            const val SEARCH_KEYWORD = "search_keyword"
            const val ITEMS = "items"
            const val ORDER_LIST = "order_list"
            const val CUSTOMER_ID = "customer_id"
            const val TRANSACTION_ID = "transaction_id"
            const val PAID_AMOUNT = "paid_amount"
            const val GIFT_CARD_WALLET_DISCOUNT = "giftcard_wallet_discount"
            const val PAYMENT_METHOD = "payment_method"
            const val ORDER_CURRENCY = "order_currency"
            const val PROMO_APPLIED = "promo_applied"
            const val PROMO_DISCOUNT = "promo_discount"
            const val USE_GIFT_CODE = "use_gift_code"
            const val USE_MY_WALLET = "use_my_wallet"
            const val STATUS = "status"
            const val ADDRESS_ID = "address_id"
            const val ORDER = "order"
            const val ORDER_ID = "order_id"
            const val GIFT_PURCHASE_ID = "gift_purchase_id"
            const val CART_ATTRIBUTES = "cart_attributes"
            const val ROW_TOTAL = "row_total"
            const val PRODUCT_NAME = "product_name"
            const val HAJJ_TIME = "hajj_time"
            const val COUNTRY_ORIGINAL_CODE = "country_original_code"
        }
    }

    class PreferenceKeys {
        companion object {
            const val ACCESS_TOKEN = "access_token"
            const val USER_FULL_NAME = "user_full_name"
            const val USER_EMAIL = "user_email"
            const val USER_ID = "user_id"
            const val LOGGED_IN = "logged_in"
            const val IS_FIRST_TIME = "is_first_time"
            const val MY_CURRENCY = "my_currency"
            const val MY_CURRENCY_SYMBOL = "my_currency_symbol"
            const val MY_COUNTRY = "my_country"
            const val MY_COUNTRY_ID = "my_country_id"
        }
    }

    class IntentKeys {
        companion object {
            const val PRODUCT_DETAILS = "product_details"
            const val COMBINATION = "combination"
            const val PRODUCT_IMAGE = "product_image"
            const val PRODUCT_NAME = "product_name"
            const val EXTRA_LOCATION_UPDATED = "extra_location_updated"
            const val EXTRA_SHOULD_LOGOUT = "extra_should_logout"
            const val TOOLBAR_TITLE = "toolbar_title"
        }
    }

    class API {
        companion object {
            const val GET_COUNTRY_LIST = "country-list"
            const val REGISTER = "register"
            const val LOGIN = "login"
            const val LOG_OUT = "log-out"
            const val REQUEST_RESET_PASSWORD_CODE = "send-reset-password-code"
            const val RESET_PASSWORD = "reset-password"
            const val GET_CATEGORIES = "get-categories"
            const val GET_MY_PROFILE = "get-my-profile"
            const val UPDATE_PROFILE = "update-profile"
            const val GET_DASHBOARD_MATERIALS = "get-dashboard-materials"
            const val GET_PRODUCTS_BY_CATEGORY = "get-products-by-category/"
            const val GET_SINGLE_PRODUCT = "single-product-"
            const val SUBMIT_PRODUCT_REVIEW = "submit-product-review"
            const val ADD_TO_CART = "add-to-cart"
            const val ADD_TO_CART_FROM_WISH_LIST = "add-to-cart-from-wishlist"
            const val ADD_PRODUCT_TO_WISHLIST = "add-product-to-wishlist"
            const val GET_MY_CART = "get-my-cart"
            const val REMOVE_FROM_CART = "remove-from-cart/"
            const val REMOVE_FROM_WISHLIST = "remove_from_wishlist/"
            const val REMOVE_ADDRESS_FROM_PROFILE = "remove-address-from-profile/"
            const val APPLY_COUPON = "apply-coupon-code-on-cart"
            const val GET_SHOP_ITEMS = "get-shop-items"
            const val GET_WISHLIST = "wishlist"
            const val CHANGE_PASSWORD = "change-password"
            const val GET_MY_ADDRESSES = "get-my-addresses"
            const val ADD_ADDRESS_TO_PROFILE = "add-address-to-profile"
            const val GENERATE_OTP = "generate-otp"
            const val CHANGE_QUANTITY_OF_CART_ITEM = "change-quantity-of-cart-item"
            const val SINGLE_GIFT_CARD_TYPE = "single-gift-card-type-"
            const val ADD_CUSTOM_GIFT = "add-custom-gift"
            const val ADD_GIFT_TO_CART = "add-gift-to-cart"
            const val RECENT_SEARCH = "recent-search"
            const val CLEAR_RECENT_SEARCH = "clear-recent-search"
            const val ORDER_PLACE = "order-place"
            const val ORDER_LIST = "order-list"
            const val GET_ORDER_DETAILS = "order-details/"
            const val SOCIAL_LOGIN = "social-login"
            const val GET_LANGUAGE_LIST = "language-list"
            const val GET_CURRENCY_LIST = "currency-list"
        }

        class Path {
            companion object {
                const val CATEGORY_ID_WITH_BRACKETS = "{category_id}"
                const val CATEGORY_ID = "category_id"
                const val PRODUCT_ID_WITH_BRACKETS = "{product_id}"
                const val PRODUCT_ID = "product_id"
            }
        }

        class Header {
            companion object {
                const val RESPONSE_FORMAT = "Accept:application/json"
            }

            class Field {
                companion object {
                    const val AUTHORIZATION = "Authorization"
                    const val SECRET_KEY = "secret_key"
                    const val LANGUAGE = "language"
                    const val CURRENCY = "currency"
                }
            }
        }

        class Body {
            class Field {
                companion object {
                    const val FIRST_NAME = "first_name"
                    const val LAST_NAME = "last_name"
                    const val COUNTRY = "country"
                    const val PHONE_CODE = "phone_code"
                    const val MOBILENO = "mobileno"
                    const val GENDER = "gender"
                    const val EMAIL = "email"
                    const val PASSWORD = "password"
                    const val PASSWORD_CONFIRMATION = "password_confirmation"
                    const val DEVICE_TOKEN = "device_token"
                    const val DEVICE_TYPE = "device_type"
                    const val EMAIL_OR_MOB = "emailormob"
                    const val ACCESS_CODE = "access_code"
                    const val NEW_PASSWORD = "new_password"
                    const val PAGE = "page"
                    const val PRODUCT_ID = "product_id"
                    const val REVIEW_DESCRIPTION = "review_description"
                    const val REVIEW_RATING = "review_star"
                    const val QUANTITY = "quantity"
                    const val SHOE_SIZE = "shoe_size"
                    const val THOBE_SIZE = "thobe_size"
                    const val ABAYA_SIZE = "abaya_size"
                    const val COUPON_CODE = "coupon_code"
                    const val WISHLIST_ID = "wishlist_id"
                    const val OLD_PASSWORD = "old_password"
                    const val ADDRESS = "address"
                    const val CITY = "city"
                    const val AREA = "area"
                    const val STATE = "state"
                    const val ZIP_CODE = "zipcode"
                    const val STREET = "street"
                    const val BUILDING = "building"
                    const val LOCATION_TYPE = "location_type"
                    const val SHIPPING_NOTE = "shipping_note"
                    const val VERIFY_CODE = "verify_code"
                    const val EDIT_ID = "edit_id"
                    const val CART_ITEM_ID = "cart_item_id"
                    const val TYPE = "type"
                    const val CARD_NAME = "card_name"
                    const val ATTACHMENT = "attachment"
                    const val GIFT_CARD_ID = "gift_card_id"
                    const val GIFT_PRICE = "gift_price"
                    const val REC_NAME = "rec_name"
                    const val REC_EMAIL = "rec_email"
                    const val DEL_METH = "del_meth"
                    const val REC_COUNTRY_CODE = "rec_country_code"
                    const val REC_COUNTRY = "rec_country"
                    const val REC_MOBILE = "rec_mobile"
                    const val ATTACH_MSG = "attach_msg"
                    const val REC_DEL_DATETIME = "rec_del_datetime"
                    const val SRC = "src"
                    const val GIFT_CODE = "gift_code"
                    const val PAYMENT_METHOD = "payment_method"
                    const val PAYMENT_METHOD_NONCE = "payment_method_nonce"
                    const val ADDRESS_ID = "address_id"
                    const val ORDER_ID = "order_id"
                    const val PROVIDER = "provider"
                    const val ACCESS_TOKEN = "accessToken"
                    const val NAME = "name"
                }
            }
        }
    }

    class SelectionIds {
        companion object {
            const val APPOINTMENT_TYPE = "AppointmentType"
            const val CLINIC = "Clinic"
            const val SESSION = "Session"
        }
    }

    class LanguageCodes {
        companion object {
            const val ENGLISH = "en"
            const val PORTUGUESE = "pt"
        }
    }

    class YouTube {
        companion object {
            const val PREFIX_YOUTUBE_WATCHING_URL = "https://www.youtube.com/watch?v="
            const val DEMO_PLAYLIST_ID = "RDnngbv6829Fg"
            const val MAX_AMOUNT_OF_YOUTUBE_RESULTS = 15L
            const val YOUTUBE_PLAYLIST_PART = "snippet"
            const val YOUTUBE_PLAYLIST_FIELDS = "pageInfo,nextPageToken," +
                    "items(id,snippet(resourceId/videoId))"

            const val YOUTUBE_VIDEOLIST_PART = "snippet,contentDetails,statistics"
            const val YOUTUBE_VIDEOLIST_FIELDS =
                "items(id,snippet(title,description,thumbnails/high,channelTitle)," +
                        "contentDetails/duration,statistics)"
        }
    }
}