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
package app.ijoic.sample.dagger

import app.ijoic.sample.App
import dagger.Component
import javax.inject.Singleton

/**
 * App component.
 *
 * @author VerstSiu 2017/10/31 16:46
 * @version 1.0
 */
//@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
  fun inject(app: App)

  fun plus(mainModule: MainModule): MainComponent
}