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
package app.ijoic.sample.room

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * User.
 *
 * @author VerstSiu 2017/11/1 9:34
 * @version 1.0
 */
@Entity
class User {
  @PrimaryKey
  lateinit var uid: String

  @ColumnInfo(name = "first_name")
  lateinit var firstName: String

  @ColumnInfo(name = "last_name")
  lateinit var lastName: String

  constructor() {
  }

  constructor(uid: String, firstName: String, lastName: String) {
    this.uid = uid
    this.firstName = firstName
    this.lastName = lastName
  }

}