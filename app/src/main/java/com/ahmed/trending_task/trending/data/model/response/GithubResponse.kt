package com.ahmed.trending_task.trending.data.model.response

data class GithubResponse(
    var author: String,
    var avatar: String,
    var builtBy: List<BuiltBy>,
    var currentPeriodStars: Int,
    var description: String,
    var forks: Int,
    var language: String,
    var languageColor: String,
    var name: String,
    var stars: Int,
    var url: String
)

data class BuiltBy(
    var avatar: String,
    var href: String,
    var username: String
)