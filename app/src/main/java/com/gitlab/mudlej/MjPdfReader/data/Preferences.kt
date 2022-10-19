/*
 *   MJ PDF Reader
 *   Copyright (C) 2022 Mudlej
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *  --------------------------
 *  This code was previously licensed under
 *
 *  MIT License
 *
 *  Copyright (c) 2018 Gokul Swaminathan
 *  Copyright (c) 2022 Mudlej
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.gitlab.mudlej.MjPdfReader.data

import android.content.SharedPreferences

class Preferences(private val prefMan: SharedPreferences) {

    companion object {
        // Preferences keys
        const val firstInstallKey = "firstInstall"
        const val showFeaturesDialogKey = "showFeaturesDialog"
        const val highQualityKey = "highQuality"
        const val antiAliasingKey = "antiAliasing"
        const val horizontalScrollKey = "horizontalScroll"
        const val pageSnapKey = "pageSnap"
        const val pageFlingKey = "pageFling"
        const val pdfDarkThemeKey = "pdfDarkTheme"
        const val appFollowSystemTheme = "appFollowSystemTheme"
        const val screenOnKey = "screenOn"
        const val hideDelayKey = "hideDelay"
        const val partSizeKey = "partSize"
        const val thumbnailRatioKey = "thumbnailRatio"
        const val maxZoomKey = "maxZoom"
        const val pdfTextKey = "pdfText"
        const val pdfLengthKey = "pdfLength"
        const val uriKey = "uri"
        const val finishedExtractionDialogKey = "finishedExtraction"
        const val copyTextDialogKey = "copyTextDialog"
        const val turnPageByVolumeButtonsKey = "turnPageByVolumeButtons"

        // Default values
        const val firstInstallDefault = true
        const val showFeaturesDialogDefault = true
        const val highQualityDefault = false
        const val antiAliasingDefault = true
        const val horizontalScrollDefault = false
        const val pageSnapDefault = false
        const val pageFlingDefault = false
        const val pdfDarkThemeDefault = false
        const val appFollowSystemThemeDefault = false
        const val annotationRenderingDefault = true
        const val screenOnDefault = false
        const val hideDelayDefault = 4000
        const val spacingDefault = 10          // in dp
        const val minZoomDefault = 0.5f
        const val midZoomDefault = 2.0f
        const val maxZoomDefault = 5.0f
        const val partSizeDefault = 256f
        const val thumbnailRatioDefault = 0.3f
        const val pdfLengthDefault = 0
        const val finishedExtractionDialogDefault = false
        const val copyTextDialogDefault = true
        const val turnPageByVolumeButtonsDefault = false

        // Colors
        const val pdfDarkBackgroundColor = -0x313132          // -0x313132 = 0xffcecece
        const val pdfLightBackgroundColor = -0xcdcdce         // 0xff323232 = -0xcdcdce

        // Constants
        const val minMaxZoom = 1f
        const val maxMaxZoom = 10f
        const val minPartSize = 5f
        const val maxPartSize = 1000f
    }

    // get values saved in Shared Preferences or return the default values
    fun getFirstInstall() = prefMan.getBoolean(firstInstallKey, firstInstallDefault)
    fun getShowFeaturesDialog() = prefMan.getBoolean(showFeaturesDialogKey, showFeaturesDialogDefault)
    fun getHighQuality() = prefMan.getBoolean(highQualityKey, highQualityDefault)
    fun getAntiAliasing() = prefMan.getBoolean(antiAliasingKey, antiAliasingDefault)
    fun getHorizontalScroll() = prefMan.getBoolean(horizontalScrollKey, horizontalScrollDefault)
    fun getPageSnap() = prefMan.getBoolean(pageSnapKey, pageSnapDefault)
    fun getPageFling() = prefMan.getBoolean(pageFlingKey, pageFlingDefault)
    fun getPdfDarkTheme() = prefMan.getBoolean(pdfDarkThemeKey, pdfDarkThemeDefault)
    fun getAppFollowSystemTheme() = prefMan.getBoolean(appFollowSystemTheme, appFollowSystemThemeDefault)
    fun getScreenOn() = prefMan.getBoolean(screenOnKey, screenOnDefault)
    fun getHideDelay() = prefMan.getInt(hideDelayKey, hideDelayDefault)
    fun getPartSize() = prefMan.getFloat(partSizeKey, partSizeDefault)
    fun getThumbnailRation() = prefMan.getFloat(thumbnailRatioKey, thumbnailRatioDefault)
    fun getMaxZoom() = prefMan.getFloat(maxZoomKey, maxZoomDefault)
    fun getFinishedExtractionDialog() = prefMan.getBoolean(finishedExtractionDialogKey, finishedExtractionDialogDefault)
    fun getCopyTextDialog() = prefMan.getBoolean(copyTextDialogKey, copyTextDialogDefault)
    fun getTurnPageByVolumeButtons() = prefMan.getBoolean(turnPageByVolumeButtonsKey, turnPageByVolumeButtonsDefault)

    // put values in Shared Preferences
    fun setFirstInstall(value: Boolean) = prefMan.edit().putBoolean(firstInstallKey, value).apply()
    fun setShowFeaturesDialog(value: Boolean) = prefMan.edit().putBoolean(showFeaturesDialogKey, value).apply()
    fun setHighQuality(value: Boolean) = prefMan.edit().putBoolean(highQualityKey, value).apply()
    fun setAntiAliasing(value: Boolean) = prefMan.edit().putBoolean(antiAliasingKey, value).apply()
    fun setHorizontalScroll(value: Boolean) = prefMan.edit().putBoolean(horizontalScrollKey, value).apply()
    fun setPageSnap(value: Boolean) = prefMan.edit().putBoolean(pageSnapKey, value).apply()
    fun setPageFling(value: Boolean) = prefMan.edit().putBoolean(pageFlingKey, value).apply()
    fun setPdfDarkTheme(value: Boolean) = prefMan.edit().putBoolean(pdfDarkThemeKey, value).apply()
    fun setAppFollowSystemTheme(value: Boolean) = prefMan.edit().putBoolean(appFollowSystemTheme, value).apply()
    fun setScreenOn(value: Boolean) = prefMan.edit().putBoolean(screenOnKey, value).apply()
    fun setHideDelay(value: Int) = prefMan.edit().putInt(hideDelayKey, value).apply()
    fun setPartSize(value: Float) = prefMan.edit().putFloat(partSizeKey, value).apply()
    fun setThumbnailRatio(value: Float) = prefMan.edit().putFloat(thumbnailRatioKey, value).apply()
    fun setMaxZoom(value: Float) = prefMan.edit().putFloat(maxZoomKey, value).apply()
    fun setFinishedExtractionDialog(value: Boolean) = prefMan.edit().putBoolean(finishedExtractionDialogKey, value).apply()
    fun setCopyTextDialog(value: Boolean) = prefMan.edit().putBoolean(copyTextDialogKey, value).apply()
    fun setTurnPageByVolumeButtons(value: Boolean) = prefMan.edit().putBoolean(turnPageByVolumeButtonsKey, value).apply()
}