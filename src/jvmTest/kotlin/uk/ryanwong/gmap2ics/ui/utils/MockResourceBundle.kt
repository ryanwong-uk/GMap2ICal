/*
 * Copyright (c) 2022. Ryan Wong (hello@ryanwong.co.uk)
 */

package uk.ryanwong.gmap2ics.ui.utils

class MockResourceBundle : ResourceBundleWrapper {
    override fun getString(key: String): String {
        return "mock-string-for-$key"
    }
}