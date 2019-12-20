package com.project.hw.main_list

class DummyRepoRepository {
    fun getRepoList(): List<MainItem> {
        return listOf(
            MainItem(
                image = "1",
                text1 = "A",
                text2 = "B",
                text3 = "C",
                text4="*"
            ),
            MainItem(
                image = "1",
                text1 = "A",
                text2 = "B",
                text3 = "C",
                text4="*"
            ),
            MainItem(
                image = "1",
                text1 = "A",
                text2 = "B",
                text3 = "C",
                text4="*"
            ),
            MainItem(
                image = "1",
                text1 = "A",
                text2 = "B",
                text3 = "C",
                text4="*"
            )
        )
    }
}