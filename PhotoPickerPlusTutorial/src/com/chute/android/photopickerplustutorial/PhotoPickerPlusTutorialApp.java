/**
 * The MIT License (MIT)

Copyright (c) 2013 Chute

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.chute.android.photopickerplustutorial;

import com.araneaapps.android.libs.logger.ALog;
import com.araneaapps.android.libs.logger.ALog.DebugLevel;
import com.chute.android.photopickerplus.PhotoPickerPlusApp;
import com.chute.android.photopickerplus.config.PhotoPicker;
import com.chute.android.photopickerplus.config.PhotoPickerConfiguration;
import com.chute.android.photopickerplus.models.enums.LocalMediaType;
import com.chute.android.photopickerplustutorial.config.ConfigEndpointURLs;
import com.chute.sdk.v2.api.Chute;
import com.chute.sdk.v2.api.authentication.AuthConstants;
import com.chute.sdk.v2.model.enums.AccountType;

public class PhotoPickerPlusTutorialApp extends PhotoPickerPlusApp {

  @Override
  public void onCreate() {
    super.onCreate();
    ALog.setDebugTag("PhotoPicker");
    ALog.setDebugLevel(DebugLevel.ALL);

    /**
     * Fill in using "app_id" and "app_secret" values from your Chute
     * application.
     * 
     * See <a href="https://apps.getchute.com">https://apps.getchute.com</a>
     */
    Chute.init(this, new AuthConstants("50d9c930018d1672df00002e", "ee9b33013c0592aa41d30d1f347ff62514b737e61e6ce9c64fb13a44d31917d9"));


    PhotoPickerConfiguration config = new PhotoPickerConfiguration.Builder(
        getApplicationContext())
        .isMultiPicker(true)
        .accountList(AccountType.FLICKR, AccountType.TWITTER, AccountType.FACEBOOK,
            AccountType.FOURSQUARE)
        .localMediaList(LocalMediaType.ALL_MEDIA, LocalMediaType.CAMERA_MEDIA)
        .configUrl(ConfigEndpointURLs.SERVICES_CONFIG_URL)
        .supportImages(true)
        .supportVideos(true)
        .build();
    PhotoPicker.getInstance().init(config);

  }

}
