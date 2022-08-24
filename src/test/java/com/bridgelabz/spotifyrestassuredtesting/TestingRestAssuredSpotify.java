package com.bridgelabz.spotifyrestassuredtesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestingRestAssuredSpotify {

    public String token = "Bearer BQCzXyTWGJios3HSablsDYNqdDqQDG0EGpSf1Y7NNtKGL9ogil3R8E92YqXpOmYiGkSnrC7t-D8Me73p2Hu" +
            "n1Gyk0E6yCpbDbD2Mrhs5cBaDo7-RR5kWESDGCMA1Lfdb2JTXg3vsCRQ45mZwufxOBak-S7QCkSDafvHz3lSC636Mmkesq35DAXs6-" +
            "hcPplN5c4Qp4j0qB5OTUH-W2OKY36fl";
    public String userId = "31bgjhjvtmijmyfklydkhvyqg4ry";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.spotify.com/v1/me";
    }

    //    ======================================USER-PROFILE==========================================
    @Test
    public void GetCurrentUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me");
        response.prettyPrint();
        System.out.println("Current user's profile:" + userId);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetUsersProfile() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/31bgjhjvtmijmyfklydkhvyqg4ry");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================PLAYLISTS==========================================
    @Test
    public void createPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body("{\n" +
                        "  \"name\": \"My fav songs\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31ezwhxqwlt5v57h3s4fxpo2kyym/playlists");
        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
    }


    @Test
    public void addItemsToPlaylist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/607NXPIBtEtEACDadJxqSC/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getusersPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/users/smedjan/playlists?limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getPlaylistItems() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }


    //    =====================================TRACKS==========================================
    @Test
    public void GetTrack() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getTracksAudioFeachers() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getTracksAudioAnalysis() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================ARTISTS==========================================
    @Test
    public void getseveralArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists?ids=57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtist() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/57dN52uHvrHOxijzpIgu3E");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtistsTopTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getArtistsRelatedArtists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================ALBUMS==========================================
    @Test
    public void getSeveralAlbums() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAlbum() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAlbumTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getRecommendations() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getNewReleases() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getFeaturedPlaylists() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getAvailableGenreSeeds() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================BROWSER==========================================
    @Test
    public void getSeveralBrowseCategories() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================SHOW==========================================
    @Test
    public void getShow() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getShowEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralShows() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================MARKETS==========================================
    @Test
    public void getAvailableMarkets() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/markets");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================EPISODES==========================================
    @Test
    public void getEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void getSeveralEpisodes() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH&market=ES");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    //    ======================================PLAYER==========================================
    @Test
    public void getRecentlyPlayedTracks() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/me/player/recently-played?limit=10&after=1484811043508");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void searchForItem() {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get("https://api.spotify.com/v1/search?q=Carly%20Rae%20Jepsen&type=artist&market=ES&limit=10&offset=5");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}