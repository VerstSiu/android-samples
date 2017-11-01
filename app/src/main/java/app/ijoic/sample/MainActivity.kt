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

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import app.ijoic.sample.room.User
import app.ijoic.sample.room.UserDatabase

import kotlinx.android.synthetic.main.activity_main.message_text

/**
 * Main activity.
 *
 * @author VerstSiu 2017/10/31 16:14
 * @version 1.0
 */
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    testDatabase()
  }

  private fun testDatabase() {
    val user = User("123", "Tom", "Lee")
    val database = Room.inMemoryDatabaseBuilder(applicationContext, UserDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    // Given that we have a user in the data source
    database.userDao().insertUser(user);

    // When subscribing to the emissions of user
    database.userDao()
        .getUserById(user.uid)
        .subscribe({ message_text.text = it.firstName })

    database.close()
  }
}
