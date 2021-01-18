package com.nthieu.base_mvvm.data.network;

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.content.Context;

import com.nthieu.base_mvvm.utils.DeviceUtil;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkCheckerInterceptor implements Interceptor {

    private Context context;

    public NetworkCheckerInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (DeviceUtil.Companion.hasConnection(context)) {
            return chain.proceed(chain.request());
        } else {
            throw new NoConnectivityException();
        }
    }

    public class NoConnectivityException extends IOException {
        @Override
        public String getMessage() {
            return "No Internet Access";
        }
    }
}
