/*
 *
 *  Copyright(c) 2017 VerstSiu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package app.ijoic.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import app.ijoic.sample.retrofit.SearchCallback
import app.ijoic.sample.retrofit.TestRetrofit

import kotlinx.android.synthetic.main.activity_main.search_text
import kotlinx.android.synthetic.main.activity_main.search_button

/**
 * Main activity.
 *
 * @author VerstSiu 2017/10/31 16:14
 * @version 1.0
 */
class MainActivity : AppCompatActivity(), SearchCallback {

  private val testInstance = TestRetrofit(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    search_button.setOnClickListener({ testInstance.beginSearch(search_text.text.toString()) })
  }

  override fun onPause() {
    super.onPause()
    testInstance.pause()
  }

  override fun onDisplayHitResult(totalHits: Int) {
    showToast("totalHits: $totalHits")
  }

  override fun onDisplaySearchError(message: String?) {
    showToast(message)
  }

  private fun showToast(message: String?) {
    Toast.makeText(this, message ?: "", Toast.LENGTH_SHORT).show()
  }
}
