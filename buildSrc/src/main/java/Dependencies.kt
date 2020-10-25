

object Version {

    const val kt_stdlib = "1.3.72"
    const val ktx_core = "1.3.1"
    const val appcompat = "1.1.0"
    const val material = "1.2.0"
    const val recyclerView = "1.2.0-alpha05"

    const val junit = "4.12"
    const val junit_ext = "1.1.1"
    const val espresso = "3.2.0"

    const val lifecycle = "2.3.0-alpha07"
    const val constrantLayout = "1.1.3"
    const val room = "2.3.0-alpha02"
    const val paging = "3.0.0-alpha05"
    const val navigation = "2.3.0"
    const val work = "2.5.0-alpha01"

    const val gson = "2.8.6"
    const val retrofit = "2.9.0"
    const val glide = "4.11.0"

    const val coil = "0.12.0"

    const val exo_player = "2.12.0"
    const val ijk_player = "0.7.7.1"


}

object AndroidDeps {
    const val kt_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kt_stdlib}"
    const val ktx_core = "androidx.core:core-ktx:${Version.ktx_core}"
    const val junit = "junit:junit:${Version.junit}"
    const val junit_ext = "androidx.test.ext:junit:${Version.junit_ext}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"

    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
    const val constrantLayout = "androidx.constraintlayout:constraintlayout:${Version.constrantLayout}"
    const val material = "com.google.android.material:material:${Version.material}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
}

object ThirdDeps {

    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"

    const val room_ktx = "androidx.room:room-ktx:${Version.room}"
    const val room_compiler = "androidx.room:room-compiler:${Version.room}"
    const val paging = "androidx.paging:paging-runtime:${Version.paging}"
    const val nav_fragment = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val nav_ui = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val work = "androidx.work:work-runtime-ktx:${Version.work}"

    const val gson = "com.google.code.gson:gson:${Version.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glide}"
    const val glide_compiler = "'com.github.bumptech.glide:compiler:${Version.glide}"

    const val coil = "io.coil-kt:coil:${Version.coil}"

    const val exo_player = "com.google.android.exoplayer:exoplayer:${Version.exo_player}"
    const val ijk_player_java = "tv.danmaku.ijk.media:ijkplayer-java:${Version.ijk_player}"
    const val ijk_player_arm = "tv.danmaku.ijk.media:ijkplayer-armv7a:${Version.ijk_player}"
}