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

/**
 * Query result data model.
 *
 * @author VerstSiu 2017/10/30 18:54
 * @version 1.0
 */
object Model {
  data class Result(val query: Query)
  data class Query(val searchinfo: SearchInfo)
  data class SearchInfo(val totalhits: Int)
}