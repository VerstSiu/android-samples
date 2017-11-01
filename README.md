
# Android Sample Projects

Sample projects write with [kotlin](https://github.com/JetBrains/kotlin) and [lambda](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html).

Project list:

* [kotlin-room](https://github.com/VerstSiu/android-samples/tree/app-room)

## Reference

* [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room.html)
* [Room 🔗 RxJava](https://medium.com/google-developers/room-rxjava-acb0cd4f3757)

## Query Types

Maybe:

1. Query returns no rows -> complete.

2. Query exist a row -> trigger `onSuccess` and complete.

3. Query result update after query complete -> nothing happens.

Single:

1. Query returns not rows -> trigger `onError(EmptyResultSetException::class)`.

2. Query exist a row -> trigger `onSuccess`.

3. Query result update after `Single.onComplete` was called -> nothing happens.

Flowable:

1. Query returns no rows -> emit, neither `onNext`, nor `onError`.

2. Query exist a row -> trigger `onNext`.

3. Query result update after query complete -> emit automatically, allow you to update the UI based on the latest data.

## License

```

   Copyright 2017 VerstSiu

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

```