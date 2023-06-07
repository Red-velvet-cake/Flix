package com.red_velvet.flix.ui.utils

import java.util.Locale

fun convertLanguageToCountryCode(languageCode: String): String {
    return when (languageCode) {
        "en" -> "US"  // English -> United States
        "fr" -> "FR"  // French -> France
        "fi" -> "FI"  // Finnish -> Finland
        "es" -> "ES"  // Spanish -> Spain
        "it" -> "IT"  // Italian -> Italy
        "ja" -> "JP"  // Japanese -> Japan
        "ko" -> "KR"  // Korean -> South Korea
        "pt" -> "PT"  // Portuguese -> Portugal
        "ru" -> "RU"  // Russian -> Russia
        "zh" -> "CN"  // Chinese -> China
        "de" -> "DE"  // German -> Germany
        "hi" -> "IN"  // Hindi -> India
        "ar" -> "SA"  // Arabic -> Saudi Arabia
        "tr" -> "TR"  // Turkish -> Turkey
        "nl" -> "NL"  // Dutch -> Netherlands
        "sv" -> "SE"  // Swedish -> Sweden
        "da" -> "DK"  // Danish -> Denmark
        "hu" -> "HU"  // Hungarian -> Hungary
        "no" -> "NO"  // Norwegian -> Norway
        "pl" -> "PL"  // Polish -> Poland
        // add more mappings as needed
        else -> languageCode.uppercase();
    }
}