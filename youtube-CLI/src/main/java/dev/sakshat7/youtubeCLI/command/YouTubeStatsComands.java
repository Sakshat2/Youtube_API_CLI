package dev.sakshat7.youtubeCLI.command;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.TableBuilder;

import dev.sakshat7.youtubeCLI.model.TeamTabRow;
import dev.sakshat7.youtubeCLI.model.Video;
import dev.sakshat7.youtubeCLI.service.CommandService;
import dev.sakshat7.youtubeCLI.service.ReportService;
import dev.sakshat7.youtubeCLI.service.VideoService;

@ShellComponent
public class YouTubeStatsComands {
	
	   @ShellMethod(key = "all", value = "List all videos on the channel.")
	    public void all() {
	        List<Video> videos = VideoService.findAll();
	        TableBuilder tableBuilder = CommandService.listToArrayTableModel(videos);
	        System.out.println(tableBuilder.build().render(120));
	    }

	    @ShellMethod(key = "recent", value = "List recent videos by max count.")
	    public void recent(@ShellOption(defaultValue = "5") Integer max) {
	        List<Video> videos = VideoService.findRecent(max);
	        TableBuilder tableBuilder = CommandService.listToArrayTableModel(videos);
	        System.out.println(tableBuilder.build().render(120));
	    }

	    @ShellMethod(key = "filter-by-year", value = "Filter videos by year.")
	    public void byYear(@ShellOption(defaultValue = "2023") Integer year) {
	        List<Video> videos = VideoService.findAllByYear(year);
	        TableBuilder tableBuilder = CommandService.listToArrayTableModel(videos);
	        System.out.println(tableBuilder.build().render(120));
	    }

	    @ShellMethod(key = "report", value = "Run a report based on all the videos for the current year.")
	    public void report() {
	        List<Video> videos = VideoService.findAllByYear(LocalDateTime.now().getYear());
	        List<TeamTabRow> rows = ReportService.videosToTeamTabRows(videos);
	        rows.forEach(TeamTabRow::print);
	    }

}
//AIzaSyDe2bNj00fxlD-AEUKDAm7KGONmnwmlOA8