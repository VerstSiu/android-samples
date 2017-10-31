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
package app.ijoic.sample.retrofit

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Test retrofit.
 *
 * @author VerstSiu 2017/10/30 22:16
 * @version 1.0
 */
class TestRetrofit(val searchCallback: SearchCallback?) {

  private val apiService by lazy {
    WikiApiService.create()
  }

  private var disposable: Disposable? = null

  /**
   * Begin wiki search.
   */
  fun beginSearch(srSearch: String) {
    disposable = apiService
        .hitCountCheck("query", "json", "search", srSearch)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { result -> showResult(result.query.searchinfo.totalhits) },
            { error -> showError(error.message) }
        )
  }

  /**
   * Pause search.
   */
  fun pause() {
    disposable?.dispose()
  }

  private fun showResult(totalHits: Int) {
    searchCallback?.onDisplayHitResult(totalHits)
  }

  private fun showError(message: String?) {
    searchCallback?.onDisplaySearchError(message)
  }
}