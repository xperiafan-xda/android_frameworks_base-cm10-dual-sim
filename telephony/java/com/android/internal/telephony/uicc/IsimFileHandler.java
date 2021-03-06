/*
 * Copyright (C) 2006, 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.telephony.uicc;

import android.util.Log;

import com.android.internal.telephony.CommandsInterface;

/**
 * {@hide}
 * This class should be used to access files in ISIM ADF
 */
public final class IsimFileHandler extends IccFileHandler implements IccConstants {
    static final String LOG_TAG = "RIL_IsimFH";

    IsimFileHandler(UiccCardApplication app, String aid, CommandsInterface ci) {
        super(app, aid, ci);
    }

    protected void finalize() {
        logd("IsimFileHandler finalized");
    }

    protected String getEFPath(int efid) {
        switch(efid) {
        case EF_IMPI:
        case EF_IMPU:
        case EF_DOMAIN:
            return MF_SIM + DF_ADF;
        }
        String path = getCommonIccEFPath(efid);
        return path;
    }

    protected void logd(String msg) {
        Log.d(LOG_TAG, msg);
    }

    protected void loge(String msg) {
        Log.e(LOG_TAG, msg);
    }
}
