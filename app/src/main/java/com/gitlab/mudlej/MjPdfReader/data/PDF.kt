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

import android.net.Uri

class PDF(
    var uri: Uri? = null,
    var name: String = "",
    var password: String? = null,
    var pageNumber: Int = 0,
    var length: Int = 0,
    var sizeInMb: Double = 0.0,
    var zoom: Float = 1F,
    var isPortrait: Boolean = true,
    var isFullScreenToggled: Boolean = false,
    var fileHash: String? = null,
    var downloadedPdf: ByteArray? = null,
    val pagesText: MutableMap<Int, String> = mutableMapOf(),
    var isExtractingTextFinished: Boolean = false
) {

    companion object {
        // constants
        const val FILE_TYPE = "application/pdf"
        const val HASH_SIZE = 1024 * 1024

        // keys
        const val nameKey = "name"
        const val passwordKey = "password"
        const val pageNumberKey = "pageNumber"
        const val lengthKey = "length"
        const val uriKey = "uri"
        const val zoomKey = "zoom"
        const val isPortraitKey = "isPortrait"
        const val isFullScreenToggledKey = "isFullScreenToggled"
        const val isExtractingTextFinishedKey = "isExtractingTextFinished"
    }

    fun getTitle(): String {
        // get .pdf start index (the dot)
        val extensionIndex: Int =
            if (name.lastIndexOf('.') == -1) name.length else name.lastIndexOf('.')

        return String.format(
            "[%s/%s] %s", pageNumber + 1, length, name.substring(0, extensionIndex))
    }
    fun togglePortrait() { isPortrait = !isPortrait }

    fun setPageCount(count: Int) {
        if (count == length || count < 1) return
        length = count
    }

    fun hasFile() = uri != null
}