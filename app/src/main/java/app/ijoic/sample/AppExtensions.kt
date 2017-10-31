package app.ijoic.sample

import android.app.Activity

/**
 * App extensions.
 *
 * @author VerstSiu 2017/10/31 17:41
 * @version 1.0
 */
val Activity.app: App
  get() = application as App