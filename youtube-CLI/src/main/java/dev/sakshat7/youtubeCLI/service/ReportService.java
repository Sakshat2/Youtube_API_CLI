package dev.sakshat7.youtubeCLI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.sakshat7.youtubeCLI.model.TeamTabRow;
import dev.sakshat7.youtubeCLI.model.Video;

@Service
public class ReportService {

    public static List<TeamTabRow> videosToTeamTabRows(List<Video> videos) {
        return videos.stream()
                .map(video -> new TeamTabRow(video.snippet().title(),
                        "YouTube",
                        video.snippet().publishedAt().toLocalDate(),
                        video.snippet().publishedAt().toLocalDate(),
                        "Virtual",
                        "Y",
                        0,
                        video.statistics().viewCount(),
                        "https://www.youtube.com/watch?v=" + video.id(),
                        "",
                        ""))
                .toList();
    }
}