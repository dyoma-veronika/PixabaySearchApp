# PixabaySearchApp

This is an Image Search App that allows users to search for images by entering one or more words in a text field. The app utilizes the Pixabay API to retrieve images associated with the user-provided search text. The app displays a list of search results, and each entry in the list shows a thumbnail of the image, the Pixabay username, and a list of tags associated with the image. A click on the list item opens a dialog asking the user if he wants to see more details. In case of a positive answer, a new detail screen should be
opened.


Features

-Search for images by entering one or more words

-Display search results with thumbnails, usernames, and tags

-Cache search results for offline handling

-Clicking on a list item opens a dialog to view more details

-Detail screen shows a bigger version of the image, username, tags, nuber of likes, downloads, and comments

-Tests


Stack:

MVVM Architecture

Jetpack Compose 

Coroutines

Hilt

Coil

Retrofit

Room

JUnit

Truth

Search Screen             | Confirm Action | Details Screen 
:-------------------------:|:-------------------------:|:-------------------------:
![](https://github.com/dyoma-veronika/PixabaySearchApp/blob/master/SearchScreen.png) | ![](https://github.com/dyoma-veronika/PixabaySearchApp/blob/master/Confirm.png) | ![](https://github.com/dyoma-veronika/PixabaySearchApp/blob/master/DetailsScreen.png)

