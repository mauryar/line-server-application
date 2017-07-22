package com.circle.utils;

import com.google.gson.Gson;

import spark.ResponseTransformer;

/**
 * @author rajan
 *
 */
public class JsonUtil {
 
  public static String toJson(Object object) {
    return new Gson().toJson(object);
  }
 
  public static ResponseTransformer json() {
    return JsonUtil::toJson;
  }
}