# GMap2iCal - Google Maps to iCal
### My first Compose for Desktop App

A small utility written in Kotlin to convert Google Maps activity timeline to iCal (.ics) files for calendar import.

This is not an Android App. It can be built and executed using IntelliJ IDEA on the desktop environment.

This is an experiment, to see if in the future I can lead a project overlooking cross-platform product development, with the Kotlin/Android team being the core. 

<div style="text-align:center"><img src="screenshot-220721.png" /></div>

## TLDR - Status

Transforming the command line program to a desktop app. Simply this project is not yet functioning properly.

This is my first non-Android Kotlin project. I am still finding out the right architecture and pattern for it.
It is within expectation that everything inside this project can be messy.

I treat this as my playground that allows me to make all kinds of experiments and mistakes. While I thank you for your visit, I would appreciate if you could take things easy when you see me doing something crazy here. Thank you. 

## Background

I travelled quite a lot before the pandemic. Very often my daily itinerary changes at the last minute. This made me a
headache recalling where I have been to previously.

I use Google Maps for navigation heavily, and I have it tracked my movement for quite many years.

I had an idea to extract my activity timeline from the Google Maps, but unfortunately there is no public API available.
It might be possible to achieve that using some web scrapping techniques, but this approach is not likely to be an
elegant one.

That is why I am trying another way round: By setting Google Maps to regularly export my activity timeline as JSON
files, I can then process them using this Kotlin utility, and generate iCal (.ICS) files which I can then import to my
calendars.

By doing so, I can keep a full record of the places I have actually been, and also the rough mileages I have spent on
the road.

## Skills covered:

Trying to reuse all my Android development knowledge as possible, otherwise native replacements have been applied.

### High level architecture

* Kotlin
* Kotlin Flow and Coroutines
* Compose UI
* MVVM architecture
* [Travis-CI](https://travis-ci.org/) - CI - to be replaced by Bitrise

### Major libraries used

* [JUnit 5](https://github.com/junit-team/junit5) - Tests
* [KOTest](https://kotest.io/) - Test framework
* [Retrofit2](https://square.github.io/retrofit/) - to be replaced by Ktor soon

## How to prepare the data set for processing

<div style="text-align:center"><img src="preview.png" /></div>.

1. Go to [Google Takeout](https://takeout.google.com/)
2. Make sure you have included **"Location History"** in your export request.
3. Create an export and wait for completion. _This process can take a long time (possibly hours or days) to complete.
   You'll receive an email when your export is done._
4. Unzip the data file.
5. The JSON files under `/Location History/Semantic Location History` are the files we need.
6. Move the JSON files to a directory, for example `./src/main/resources` of this project.
7. Update, or create yor own configuration file `uk.ryanwong.gmap2ics.configs.DefaultConfig` to specify the input and
   output paths.
8. If you have created a duplicated configuration file, update the file path in `Main.kt`
9. Run the project on IntelliJ IDEA

## Todo list

- No.1 issue: properly design the UI for dynamic window size (without ConstraintLayout?)
- Exception handling
- Migrate Retrofit to Ktor
- The presentation for driving starting and ending locations is to be improved. This is because the location data (
  coordinates and place Ids) returned by Google Maps are not always accurate (even not exists).
- Database to permanently cache Google Maps Location API results