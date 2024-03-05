package dev.sakshat7.youtubeCLI.model;

import java.util.List;

public record VideoListResponse(String kind, String etag, List<Video> items) {
}
