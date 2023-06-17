package com.red_velvet.flix.domain.usecase

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class FormatMediaDateAndCountryCodeUsecase @Inject constructor() {
    operator fun invoke(rawDate: String, languageCode: String): String {
        return "${formatMovieDate(parseInputDate(rawDate))} (${languageCode.split("-")[1].uppercase()})"
    }

    fun getFormattedSeriesDate(rawDate: String): String {
        return "${formatSeriesDate(parseInputDate(rawDate)!!)}"
    }


    private fun parseInputDate(rawDate: String): Date? {
        return SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(rawDate)
    }

    private fun formatMovieDate(date: Date?): String? {
        return date?.let { SimpleDateFormat("dd/MM/yyyy", Locale.US).format(it) }
    }


    private fun formatSeriesDate(date: Date): String? {
        return date.let { SimpleDateFormat("MMMM d, yyyy", Locale.US).format(it) }
    }
}