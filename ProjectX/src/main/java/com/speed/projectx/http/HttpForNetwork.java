package com.speed.projectx.http;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by xujl on 2017/11/28.
 */

public interface HttpForNetwork {
    /**
     * Get请求
     *
     * @param options
     * @return
     */
    @Headers({ "Accept: application/vnd.github.v3.full+json", "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36" })
    @GET("{apiName}")
    Call<JsonObject> requestGet (@Path(value = "apiName", encoded = true) String apiName, @QueryMap Map<String, Object> options);
}
