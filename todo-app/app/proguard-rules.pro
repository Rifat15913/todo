-keepattributes Signature
-keepattributes *Annotation*

-dontwarn sun.misc.**

-keep class * implements com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

-keep class com.todo.app.main.data.remote.model.** { <fields>; }
-keep class com.todo.app.main.data.local.model.** { <fields>; }


-keep class com.paytabs.paytabs_sdk.** { *; }