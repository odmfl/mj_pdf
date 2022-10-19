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

package com.gitlab.mudlej.MjPdfReader.ui

import android.Manifest
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro
import com.github.paolorotolo.appintro.model.SliderPage
import com.github.paolorotolo.appintro.AppIntroFragment
import com.gitlab.mudlej.MjPdfReader.R

class MainIntroActivity : AppIntro() {
    var themeColor = "#263238"
    var bg = Color.parseColor(themeColor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        val first = SliderPage()
        first.title = getString(R.string.title_intro)
        first.description = getString(R.string.description__intro)
        first.imageDrawable = R.drawable.final_logo
        first.bgColor = bg
        addSlide(AppIntroFragment.newInstance(first))

        val second = SliderPage()
        second.title = getString(R.string.title_open)
        second.description = getString(R.string.description_open)
        second.imageDrawable = R.drawable.opensource_logo
        second.bgColor = bg
        addSlide(AppIntroFragment.newInstance(second))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val third = SliderPage()
            third.title = getString(R.string.title_permission)
            third.description = getString(R.string.description__permission)
            third.imageDrawable = R.drawable.patterns_permissions
            third.bgColor = bg
            addSlide(AppIntroFragment.newInstance(third))
            askForPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 3)
        }

        showSkipButton(false)
        showStatusBar(false)
        setNavBarColor(themeColor)
    }

    override fun onDonePressed(currentFragment: Fragment) {
        super.onDonePressed(currentFragment)
        finish()
    }
}