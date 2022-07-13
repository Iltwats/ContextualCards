# ContextualCards
A standalone Plug-and-Play container that can be used to display Contextual Cards that are rendered using JSON from an [API](https://run.mocky.io/v3/fefcfbeb-5c12-4722-94ad-b8f92caad1ad)

## Screenshots
<p>
    <img src="https://github.com/Iltwats/ContextualCards/raw/master/assests/1.jpg" width="200" />
    <img src="https://github.com/Iltwats/ContextualCards/raw/master/assests/2.jpg" width="200"/>
    <img src="https://github.com/Iltwats/ContextualCards/raw/master/assests/3.jpg" width="200"/>
    <img src="https://github.com/Iltwats/ContextualCards/raw/master/assests/4.jpg" width="200"/>
</p>

### App
It deals with fetching and deserializing the JSON from the API and passing it down to the UI layer and It uses **Model View ViewModel (MVVM)** architecture.
Also it uses 3rd party libraries such as Retrofit for Making Calls to backend server, RxJava to observe the required components/variables and Glide for 
downloading images.<br> <br>

### Download
Apk to [download](https://github.com/Iltwats/ContextualCards/raw/master/app/build/outputs/apk/debug/app-debug.apk) </br></br>

### Deliverables or Todo
- [x]  Init the app
- [x]  Build models
- [x]  Design different Cards
   - [x]  HC6
   - [x]  HC5
   - [x]  HC1
   - [x]  HC3
   - [x]  HC9
- [x]  Build Recycler Views for Card Groups
- [x]  Configured Deeplinks for each UI
- [x]  Add Styling
- [x]  Connect to API
- [x]  Add Swipe to Refresh
- [x]  Add HC3 long click effect
   - [x]  Dismiss on click dismiss
   - [x]  Save on click remind later
- [x]  Add error handling

### Future Scope
- An standlone library can be created for usage in other apps.
