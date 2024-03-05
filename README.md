# Youtube_API_CLI
A CLI application  where it fetch data from my youtube channel using spring shell


## Running the CLI

When those values are set you can run the CLI by running the following command or by running the `main` method in your
IDE.

```bash
./mvnw spring-boot:run
```

Once the application is running you can run the help command to see all the commands available.

```bash
help
```

```bash
AVAILABLE COMMANDS

Built-In Commands
       help: Display help about available commands
       stacktrace: Display the full stacktrace of the last error.
       clear: Clear the shell screen.
       quit, exit: Exit the shell.
       history: Display or save the history of previously run commands
       version: Show version info
       script: Read and execute commands from a file.

You Tube Stats Commands
       all: List all videos on the channel.
       report: Run a report based on all the videos for the current year.
       filter-by-year: Filter videos by year.
       recent: List recent videos by max count.

```
