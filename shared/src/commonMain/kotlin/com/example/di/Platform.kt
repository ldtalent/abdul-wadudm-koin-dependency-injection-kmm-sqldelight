package com.example.di

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform