package com.example.test

const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"
const val IMAGE_BASE_ORIGINAL_URL = "https://image.tmdb.org/t/p/original/"
const val ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYWU0Y2NjYzI2Y2RiMTY2MjBiMmI3NGNhNWMxOGQ0NSIsIm5iZiI6MTcyNDQxODM4MC42MjgyMzYsInN1YiI6IjY2Yzg3OWQyZGNhZDc5M2I0MzNjZTAyOSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Gmn6aKl7n3SDnZz71iSQrppVM2DSK8qMLrQJ5ZKaPMs"
const val RESPONSE_STRING = "{\n" +
        "    \"status\": \"OK\",\n" +
        "    \"copyright\": \"Copyright (c) 2022 The New York Times Company.  All Rights Reserved.\",\n" +
        "    \"num_results\": 59,\n" +
        "    \"results\": [\n" +
        "        {\n" +
        "            \"list_name\": \"Young Adult\",\n" +
        "            \"display_name\": \"Young Adult\",\n" +
        "            \"list_name_encoded\": \"young-adult\",\n" +
        "            \"oldest_published_date\": \"2012-12-16\",\n" +
        "            \"newest_published_date\": \"2015-08-23\",\n" +
        "            \"updated\": \"WEEKLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Young Adult E-Book\",\n" +
        "            \"display_name\": \"Young Adult E-Book\",\n" +
        "            \"list_name_encoded\": \"young-adult-e-book\",\n" +
        "            \"oldest_published_date\": \"2015-08-30\",\n" +
        "            \"newest_published_date\": \"2017-01-29\",\n" +
        "            \"updated\": \"WEEKLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Young Adult Hardcover\",\n" +
        "            \"display_name\": \"Young Adult Hardcover\",\n" +
        "            \"list_name_encoded\": \"young-adult-hardcover\",\n" +
        "            \"oldest_published_date\": \"2015-08-30\",\n" +
        "            \"newest_published_date\": \"2022-10-23\",\n" +
        "            \"updated\": \"WEEKLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Young Adult Paperback\",\n" +
        "            \"display_name\": \"Young Adult Paperback\",\n" +
        "            \"list_name_encoded\": \"young-adult-paperback\",\n" +
        "            \"oldest_published_date\": \"2015-08-30\",\n" +
        "            \"newest_published_date\": \"2017-01-29\",\n" +
        "            \"updated\": \"WEEKLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Animals\",\n" +
        "            \"display_name\": \"Animals\",\n" +
        "            \"list_name_encoded\": \"animals\",\n" +
        "            \"oldest_published_date\": \"2014-09-07\",\n" +
        "            \"newest_published_date\": \"2017-01-15\",\n" +
        "            \"updated\": \"MONTHLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Audio Fiction\",\n" +
        "            \"display_name\": \"Audio Fiction\",\n" +
        "            \"list_name_encoded\": \"audio-fiction\",\n" +
        "            \"oldest_published_date\": \"2018-03-11\",\n" +
        "            \"newest_published_date\": \"2022-10-16\",\n" +
        "            \"updated\": \"MONTHLY\"\n" +
        "        },\n" +
        "        {\n" +
        "            \"list_name\": \"Audio Nonfiction\",\n" +
        "            \"display_name\": \"Audio Nonfiction\",\n" +
        "            \"list_name_encoded\": \"audio-nonfiction\",\n" +
        "            \"oldest_published_date\": \"2018-03-11\",\n" +
        "            \"newest_published_date\": \"2022-10-16\",\n" +
        "            \"updated\": \"MONTHLY\"\n" +
        "        }\n" +
        "    ]\n" +
        "}"

enum class NAV_OPTION{
    MOVIE_LIST_SCREEN,
    DETAIL_SCREEN
}
