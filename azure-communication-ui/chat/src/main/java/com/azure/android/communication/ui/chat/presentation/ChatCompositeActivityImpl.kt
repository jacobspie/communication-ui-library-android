// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.android.communication.ui.chat.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.azure.android.communication.ui.chat.ChatAdapter
import com.azure.android.communication.ui.chat.R
import com.azure.android.communication.ui.chat.presentation.ui.container.ChatCompositeViewImpl

internal class ChatCompositeActivityImpl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 35) {
            // Turn OFF edge-to-edge behavior
            WindowCompat.setDecorFitsSystemWindows(window, true)
        }
        setContentView(ChatCompositeViewImpl(this, chatAdapter!!, true))
        actionBar?.hide()
        supportActionBar?.hide()

        if (Build.VERSION.SDK_INT >= 35) {


            ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
                val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
                val navBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom

                view.updatePadding(top = statusBarHeight, bottom = navBarHeight)

                insets
            }
        }
    }

    companion object {
        var chatAdapter: ChatAdapter? = null
    }
}
