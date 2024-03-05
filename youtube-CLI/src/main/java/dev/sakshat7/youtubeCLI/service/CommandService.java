package dev.sakshat7.youtubeCLI.service;

import java.util.List;

import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.stereotype.Service;

import dev.sakshat7.youtubeCLI.model.Video;

@Service
public class CommandService {

    public static TableBuilder listToArrayTableModel(List<Video> videos) {
        ArrayTableModel model = new ArrayTableModel(videos.stream()
                .map(v -> new String[]{v.id(), v.snippet().title(), v.snippet().publishedAt().toString(), v.statistics().viewCount().toString()})
                .toArray(String[][]::new));
        TableBuilder tableBuilder = new TableBuilder(model);
        tableBuilder.addInnerBorder(BorderStyle.fancy_light_double_dash);
        return tableBuilder;
    }




}