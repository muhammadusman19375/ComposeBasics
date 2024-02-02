package com.example.composepractice.paginationInCompose

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}