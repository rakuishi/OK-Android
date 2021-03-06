package com.rakuishi.ok.data

import com.rakuishi.ok.util.request
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import org.simpleframework.xml.core.Persister


class FeedRepository {

    private val okHttpClient: OkHttpClient = OkHttpClient()
    private val persister: Persister = Persister()

    fun requestFeeds(): Single<List<Feed>> {
        return okHttpClient.request("https://rakuishi.com/feed/index.xml")
            .map {
                val rss = persister.read(Rss::class.java, it.body()?.string() ?: "")
                rss.channel?.list ?: listOf()
            }
            .singleOrError()
    }
}